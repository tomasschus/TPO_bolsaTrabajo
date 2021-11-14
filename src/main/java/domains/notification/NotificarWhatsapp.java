package domains.notification;

import interfaces.NotifyStrategy;

public class NotificarWhatsapp implements NotifyStrategy {

    private static final String NOTIFICACION_WP = "ESTA ES UNA NOTIFICACION POR EMAIL DE";

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println(NOTIFICACION_WP + " " + notificacion.getMessage().toUpperCase());
    }
}
