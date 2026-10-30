package creation;

import models.AlertData;
import models.Incident;
import models.ServiceIncident;
import models.SoftwareIncident;

import java.util.UUID;

public class ServiceCreation extends IncidentCreation {
    @Override
    public Incident createIncident(AlertData alert){
        return new ServiceIncident(
                "SOFT" + " - " + generateID() ,
                alert
        );
    }

    public String generateID(){
        return UUID.randomUUID().toString();
    }
}
