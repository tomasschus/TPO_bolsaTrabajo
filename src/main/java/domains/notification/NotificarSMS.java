package domains.notification;

import interfaces.NotifyStrategy;

public class NotificarSMS implements NotifyStrategy {

    private static final String NOTIFICACION_SMS = "ESTA ES UNA NOTIFICACION POR SMS DE";

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println(NOTIFICACION_SMS + " " + notificacion.getMessage().toUpperCase());
    }
}
