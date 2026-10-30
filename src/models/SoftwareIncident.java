package models;

public class SoftwareIncident extends Incident{
    public SoftwareIncident (String id, AlertData alertData){
        super(id, alertData, IncidentType.SOFTWARE);
    }
}
