package models;

public class AlertData {

    private String id;
    private String location;
    private String description;
    private int severity;
    private int affectedUsers;

    public AlertData(String id, String location,
                     String description, int severity,
                     int affectedUsers) {

        this.id = id;
        this.location = location;
        this.description = description;
        this.severity = severity;
        this.affectedUsers = affectedUsers;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getSeverity() {
        return severity;
    }

    public int getAffectedUsers() {
        return affectedUsers;
    }
}