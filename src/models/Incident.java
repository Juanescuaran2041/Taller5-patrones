package models;

public abstract class Incident {

    private String id;
    private AlertData alert;
    private IncidentType incidentType;

    public Incident(String id, AlertData alert, IncidentType incidentType){
        this.id = id;
        this.alert = alert;
        this.incidentType = incidentType;
    }

    public IncidentType getType() {
        return incidentType;
    }

    public AlertData getAlert() {
        return alert;
    }

    public String getId() {
        return id;
    }

}