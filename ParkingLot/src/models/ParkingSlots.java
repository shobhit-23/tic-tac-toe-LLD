package Client.models;

import Client.enums.ParkingSlotStatus;
import Client.enums.VehicleType;

public class ParkingSlots extends BaseModel{
    private VehicleType allowedVehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private ParkingFloor parkingFloor;
    private int slotNumber;

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }
    public void setAllowedVehicleType(VehicleType allowedVehicleType) {
        this.allowedVehicleType = allowedVehicleType;
    }
    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }
    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }
    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
    public int getSlotNumber() {
        return slotNumber;
    }
    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    
}
