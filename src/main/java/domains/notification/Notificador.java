package domains.notification;

import interfaces.NotifyStrategy;

public class Notificador {

    private NotifyStrategy notifyStrategy;

    public Notificador withStrategy(NotifyStrategy notifyStrategy) {
        this.notifyStrategy = notifyStrategy;
        return this;
    }

    public void send(Notificacion notificacion) {
        this.notifyStrategy.enviar(notificacion);
    }
}
