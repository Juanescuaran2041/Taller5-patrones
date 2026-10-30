package order;

import models.Incident;

import java.time.LocalDateTime;
import java.util.List;

public class OrderAttention {

    private final String orderId;
    private final LocalDateTime date;
    private final Incident incident;
    private final String tecnician;
    private final String location;
    private final String workDescription;
    private final Integer durationMinutes;
    private final List<String> spareParts;
    private final String observations;
    private final String shift;

    // Constructor privado que usa el Builder
    private OrderAttention(Builder builder) {
        this.orderId = builder.orderId;
        this.date = builder.date;
        this.incident = builder.incident;
        this.tecnician = builder.tecnician;
        this.location = builder.location;
        this.workDescription = builder.workDescription;
        this.durationMinutes = builder.durationMinutes;
        this.spareParts = builder.spareParts;
        this.observations = builder.observations;
        this.shift = builder.shift;
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getDate() { return date; }
    public Incident getIncident() { return incident; }
    public String getTecnician() { return tecnician; }
    public String getLocation() { return location; }
    public String getWorkDescription() { return workDescription; }
    public Integer getDurationMinutes() { return durationMinutes; }
    public List<String> getSpareParts() { return spareParts; }
    public String getObservations() { return observations; }
    public String getShift() { return shift; }

    // Builder Pattern
    public static class Builder {
        private String orderId;
        private LocalDateTime date;
        private Incident incident;
        private String tecnician;
        private String location;
        private String workDescription;
        private Integer durationMinutes;
        private List<String> spareParts;
        private String observations;
        private String shift;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder incident(Incident incident) {
            this.incident = incident;
            return this;
        }

        public Builder tecnician(String tecnician) {
            this.tecnician = tecnician;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder workDescription(String workDescription) {
            this.workDescription = workDescription;
            return this;
        }

        public Builder durationMinutes(Integer durationMinutes) {
            this.durationMinutes = durationMinutes;
            return this;
        }

        public Builder spareParts(List<String> spareParts) {
            this.spareParts = spareParts;
            return this;
        }

        public Builder observations(String observations) {
            this.observations = observations;
            return this;
        }

        public Builder shift(String shift) {
            this.shift = shift;
            return this;
        }

        public OrderAttention build() {
            if (orderId == null || orderId.isEmpty()) {
                throw new IllegalArgumentException("Order ID is required");
            }
            if (date == null) {
                throw new IllegalArgumentException("Date is required");
            }
            if (incident == null) {
                throw new IllegalArgumentException("Incident is required");
            }
            if (tecnician == null || tecnician.isEmpty()) {
                throw new IllegalArgumentException("Tecnician is required");
            }
            if (location == null || location.isEmpty()) {
                throw new IllegalArgumentException("Location is required");
            }

            if (durationMinutes != null && durationMinutes <= 0) {
                throw new IllegalArgumentException("Duration minutes must be greater than 0");
            }

            return new OrderAttention(this);
        }
    }
}