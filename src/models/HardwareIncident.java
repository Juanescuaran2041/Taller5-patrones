package models;

public class HardwareIncident extends Incident {
    public HardwareIncident (String id, AlertData alertData){
        super(id, alertData, IncidentType.HARDWARE);
    }
}
