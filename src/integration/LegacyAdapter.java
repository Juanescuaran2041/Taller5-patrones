package integration;

import models.AlertData;

public class LegacyAdapter implements AlertSource {

    private LegacyMonitor monitor;

    public LegacyAdapter(LegacyMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public AlertData getAlert() {

        String legacyAlert = monitor.readAlert();

        String[] fields = legacyAlert.split("\\|");

        if (fields.length != 5) {
            throw new IllegalArgumentException(
                    "Formato de alerta inválido"
            );
        }

        String category = fields[0];
        String location = fields[1];
        String description = fields[2];
        int severity = Integer.parseInt(fields[3]);
        int affectedUsers = Integer.parseInt(fields[4]);

        return new AlertData(
                category,
            location,
                description,
                severity,
                affectedUsers
        );
    }
}