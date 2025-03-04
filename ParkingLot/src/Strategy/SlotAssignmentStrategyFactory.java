package Client.Strategy;

import Client.Repository.ParkingLotRepository;
import Client.enums.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategyByType(SlotAssignmentStrategy slotAssignmentStrategyType){
        if(slotAssignmentStrategyType.equals(SlotAssignmentStrategyType.RANDOM))
        {
            return new RandomSlotAssignmentStrategy(new ParkingLotRepository());
        }
        return null;
    }
}
