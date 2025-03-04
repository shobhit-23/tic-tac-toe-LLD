package Client.Serivce;

import java.util.Date;
import java.util.Optional;

import Client.Exception.GateNotFoundException;
import Client.Repository.GateRepository;
import Client.Repository.ParkingLotRepository;
import Client.Repository.TicketRepository;
import Client.Repository.VehicleRepository;
import Client.Strategy.SlotAssignmentStrategy;
import Client.Strategy.SlotAssignmentStrategyFactory;
import Client.enums.ParkingSlotStatus;
import Client.enums.VehicleType;
import Client.models.Gate;
import Client.models.ParkingSlots;
import Client.models.Ticket;
import Client.models.Vehicle;

public class TicketService {
    
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    
    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,ParkingLotRepository parkingLotRepository,TicketRepository ticketRepository){
        this.gateRepository=gateRepository;// Dependency Injection
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;
        this.ticketRepository=ticketRepository;
    }
    public Ticket IssueTicket(Long gateId, VehicleType vehicleType, String vehicleNumber, String ownerName) throws GateNotFoundException
    {
        //create the ticket Object
        // assign the slot to the vehicle
        // return the ticket
        Ticket ticket=new Ticket();
        ticket.setEntryTime(new Date());
        
        // Gate
        // Use optional to avoid NPE (null pointer exception)
        Optional<Gate> gatOptional=gateRepository.getGateById(gateId);
        
        // if(gate !=null)  //if optional was not there
        // {
        //     ticket.setGateGeneratedAt(gate);
        //     ticket.setGeneratedBy(gate.getGateOperator());
        // }

        
        if(gatOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate=gatOptional.get();
        ticket.setGateGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getGateOperator());

        //Vehicle
        //1.It is a new Vehicla -> store and return
        //2. If it exits then return
        Optional<Vehicle> optionalVehicle =vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(!optionalVehicle.isPresent())
        {
            Vehicle vehicle=new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            savedVehicle=vehicleRepository.insertVehicle(vehicle);
        }
        else{
            savedVehicle=optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        //find and assign the slot
        SlotAssignmentStrategy slotAssignmentStrategyType=parkingLotRepository.getParkingSlotByGateId(gateId).getSlotAssignmentStrategy();
        ParkingSlots parkingSlots=SlotAssignmentStrategyFactory.getSlotAssignmentStrategyByType(slotAssignmentStrategyType).getSlot(vehicleType, gate);
        parkingSlots.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        ticket.setParkingSlots(parkingSlots);

        //persist the ticket in DB as well
        Ticket savedTicket=ticketRepository.saveTicket(ticket);
        savedTicket.setTicketNumber("TIcket - "+savedTicket.getId());
        return savedTicket;
    }
}
