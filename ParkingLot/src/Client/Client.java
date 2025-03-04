package Client;

import Client.Repository.GateRepository;
import Client.Repository.ParkingLotRepository;
import Client.Repository.TicketRepository;
import Client.Repository.VehicleRepository;
import Client.Serivce.TicketService;
import Client.controllers.TicketController;

public class Client {
    public static void main(String[] args) {
       
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        TicketRepository ticketRepository=new TicketRepository();
        GateRepository gateRepository=new GateRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();

        TicketService ticketService=new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        TicketController ticketController=new TicketController(ticketService);
        

    }
}
//Client -> Contoller-> Serivce -> Repository -> Uses Models to interact with DB