//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import facade.IncidentManagementFacade;
import integration.LegacyAdapter;
import integration.LegacyMonitor;
import order.OrderAttention;

public class Main {

    public static void main(String[] args) {
        LegacyAdapter alertSource = new LegacyAdapter(new LegacyMonitor());
        IncidentManagementFacade facade = new IncidentManagementFacade();
        IncidentManagementFacade.Result result = facade.processAlert(
                alertSource,
                "Ana Perez",
                "Diurno"
        );

        OrderAttention order = result.getOrder();
        System.out.println("Incidente: " + order.getIncident().getId());
        System.out.println("Tipo: " + order.getIncident().getType());
        System.out.println("Orden: " + order.getOrderId());
        System.out.println("Ubicación: " + order.getLocation());
        System.out.println("Técnico: " + order.getTecnician());
        System.out.println("Notificación:\n" + result.getNotification());
    }
}