package notification;

public class AuditDecorator extends NotificationDecorator {
    public AuditDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String send() {

        return notification.send()
                + "\nAuditoría: notificación registrada.";
    }
}
