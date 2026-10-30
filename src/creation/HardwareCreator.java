package creation;

import models.AlertData;
import models.HardwareIncident;
import models.Incident;

import java.util.UUID;

public class HardwareCreator extends IncidentCreation {

    @Override
    public Incident createIncident(AlertData alert){
        return new HardwareIncident(
                "ICN" + " - " + generateID() ,
                alert
        );
    }

    public String generateID(){
        return UUID.randomUUID().toString();
    }
}
