package creation;

import models.AlertData;
import models.HardwareIncident;
import models.Incident;
import models.SoftwareIncident;

import java.util.UUID;

public class SoftwareCreation extends IncidentCreation {

    @Override
    public Incident createIncident(AlertData alert){
        return new SoftwareIncident(
                "SOFT" + " - " + generateID() ,
                alert
        );
    }

    public String generateID(){
        return UUID.randomUUID().toString();
    }
}
