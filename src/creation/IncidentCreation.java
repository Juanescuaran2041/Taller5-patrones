package creation;

import models.AlertData;
import models.Incident;

public abstract class IncidentCreation {
    public Incident registerIncident(AlertData alertData){
        return createIncident(alertData);
    }

    protected abstract Incident createIncident(AlertData alertData);
}
