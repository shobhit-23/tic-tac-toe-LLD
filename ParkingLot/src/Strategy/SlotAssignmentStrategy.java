package Client.Strategy;

import Client.enums.VehicleType;
import Client.models.Gate;
import Client.models.ParkingSlots;

public interface SlotAssignmentStrategy {

    ParkingSlots getSlot(VehicleType vehicleType,Gate gate); 
}
