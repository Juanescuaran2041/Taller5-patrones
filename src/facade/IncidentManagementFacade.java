package facade;

import creation.HardwareCreator;
import creation.IncidentCreation;
import creation.ServiceCreation;
import creation.SoftwareCreation;
import integration.AlertSource;
import models.AlertData;
import models.Incident;
import notification.AuditDecorator;
import notification.BasicNotification;
import notification.Notification;
import notification.PriorityDecorator;
import order.OrderAttention;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

public class IncidentManagementFacade {

    public Result processAlert(AlertSource alertSource, String technician, String shift) {
        AlertData alert = alertSource.getAlert();
        Incident incident = createIncident(alert);

        Notification notification = new BasicNotification(incident);
        notification = new PriorityDecorator(notification, incident);
        notification = new AuditDecorator(notification);

        OrderAttention order = new OrderAttention.Builder()
                .orderId("ORD-" + UUID.randomUUID())
                .date(LocalDateTime.now())
                .incident(incident)
                .tecnician(technician)
                .location(alert.getLocation())
                .workDescription(alert.getDescription())
                .durationMinutes(30)
                .spareParts(Collections.emptyList())
                .observations("Orden generada a partir de una alerta")
                .shift(shift)
                .build();

        return new Result(order, notification.send());
    }

    private Incident createIncident(AlertData alert) {
        String category = alert.getId().trim().toUpperCase();
        IncidentCreation creator;

        switch (category) {
            case "CPU":
            case "HARDWARE":
                creator = new HardwareCreator();
                break;
            case "SOFTWARE":
                creator = new SoftwareCreation();
                break;
            case "SERVICE":
                creator = new ServiceCreation();
                break;
            default:
                throw new IllegalArgumentException("Categoría de alerta no soportada: " + alert.getId());
        }

        return creator.registerIncident(alert);
    }

    public static class Result {
        private final OrderAttention order;
        private final String notification;

        private Result(OrderAttention order, String notification) {
            this.order = order;
            this.notification = notification;
        }

        public OrderAttention getOrder() {
            return order;
        }

        public String getNotification() {
            return notification;
        }
    }
}