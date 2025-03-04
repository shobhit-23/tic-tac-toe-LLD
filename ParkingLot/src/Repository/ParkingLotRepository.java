package Client.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Client.models.Gate;
import Client.models.ParkingLot;

public class ParkingLotRepository {

    private Map<Long,ParkingLot> parkingLots=new TreeMap<>();

    public ParkingLot getParkingSlotByGateId(Long gateId){
        
        for(ParkingLot parkingLot:parkingLots.values())
        {
            List<Gate> gates=parkingLot.getGates();
            for(Gate gate :gates)
            {
                if(gate.getId()==gateId){
                    return parkingLot;
                }
            }
        }
        return null;

    }
}
