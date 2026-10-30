package notification;

import models.Incident;

public class PriorityDecorator extends NotificationDecorator {

    private Incident incident;

    public PriorityDecorator(Notification notification, Incident incident) {
        super(notification);
        this.incident = incident;
    }

    @Override
    public String send() {
        int severity = incident.getAlert().getSeverity();
        int users = incident.getAlert().getAffectedUsers();

        int priority = (severity * 2) + Math.min(users, 10);

        return notification.send() + "Priority: " + priority;
    }
}
