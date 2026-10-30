package notification;

import models.Incident;

public class BasicNotification implements Notification {

    private Incident incident;

    public BasicNotification(Incident incident) {
        this.incident = incident;
    }

    @Override
    public String send() {
        return "New incident: " + incident.getAlert().getDescription();
    }
}
