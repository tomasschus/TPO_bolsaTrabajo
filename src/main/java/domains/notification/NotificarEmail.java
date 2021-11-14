package domains.notification;

import interfaces.NotifyStrategy;

public class NotificarEmail implements NotifyStrategy {

    private static final String NOTIFICACION_EMAIL = "ESTA ES UNA NOTIFICACION POR EMAIL DE";

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println(NOTIFICACION_EMAIL + " " + notificacion.getMessage().toUpperCase());
    }
}
