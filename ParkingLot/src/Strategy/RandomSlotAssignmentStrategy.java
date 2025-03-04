package Client.Strategy;

import Client.Repository.ParkingLotRepository;
import Client.enums.ParkingSlotStatus;
import Client.enums.VehicleType;
import Client.models.Gate;
import Client.models.ParkingFloor;
import Client.models.ParkingLot;
import Client.models.ParkingSlots;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{
   
    private ParkingLotRepository parkingLotRepository;

    public RandomSlotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }

    @Override
    public ParkingSlots getSlot(VehicleType vehicleType,Gate gate){
        ParkingLot parkinglots=parkingLotRepository.getParkingSlotByGateId(gate.getId());
        for(ParkingFloor parkingFloor:parkinglots.getParkingFloors()){
            for(ParkingSlots parkingSlots:parkingFloor.getParkingSlots()){
                if(parkingSlots.getAllowedVehicleType().equals(vehicleType) && parkingSlots.getParkingSlotStatus().equals(ParkingSlotStatus.UNOCCUPIED)){
                    return parkingSlots;
                }
            }
        }
        return null;
    }
}
