package interfaces;

import domains.Postulacion;

public interface Observer {

    void notificarPublicacion(Postulacion postulacion, NotifyStrategy notifyStrategy);
}
