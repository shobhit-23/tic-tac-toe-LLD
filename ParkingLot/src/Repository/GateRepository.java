package Client.Repository;

import java.util.Optional;

import Client.models.Gate;

public class GateRepository {
    public Optional<Gate> getGateById(Long gateId){
        // select * from gate where id=gateId;
        return Optional.empty();
    }
}
