package models;

public class ServiceIncident extends Incident {
    public ServiceIncident (String id, AlertData alertData){
        super(id, alertData, IncidentType.SERVICE);
    }
}
