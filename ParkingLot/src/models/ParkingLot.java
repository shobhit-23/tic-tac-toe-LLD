package Client.models;

import java.util.List;

import Client.Strategy.SlotAssignmentStrategy;
import Client.enums.ParkingLotStatus;
import Client.enums.VehicleType;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VehicleType> supportedVehicleTypes;
    private String address;
    private ParkingLotStatus status;
    private SlotAssignmentStrategy slotAssignmentStrategy;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }
    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
    public List<Gate> getGates() {
        return gates;
    }
    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }
    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public ParkingLotStatus getStatus() {
        return status;
    }
    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }
    public SlotAssignmentStrategy getSlotAssignmentStrategy() {
        return slotAssignmentStrategy;
    }
    public void setSlotAssignmentStrategy(SlotAssignmentStrategy slotAssignmentStrategy) {
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }
    
}
