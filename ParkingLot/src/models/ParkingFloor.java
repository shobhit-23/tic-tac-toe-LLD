package Client.models;

import java.util.List;

import Client.enums.ParkingFloorStatus;

public class ParkingFloor extends BaseModel {
    private List<ParkingSlots> parkingSlots;
    private String floorNumber;
    private ParkingFloorStatus floorStatus;
    
    public List<ParkingSlots> getParkingSlots() {
        return parkingSlots;
    }
    public void setParkingSlots(List<ParkingSlots> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    public String getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }
    public ParkingFloorStatus getFloorStatus() {
        return floorStatus;
    }
    public void setFloorStatus(ParkingFloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }
    
    
}
