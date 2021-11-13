package interfaces;

import domains.notification.Notificacion;

public interface NotifyStrategy {

    void enviar(Notificacion notificacion);
}
