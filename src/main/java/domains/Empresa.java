package domains;

import domains.notification.Notificacion;
import domains.notification.Notificador;
import interfaces.NotifyStrategy;
import interfaces.Observer;

public class Empresa implements Observer {

    private String razonSocial;
    private String direccion;
    private Integer telefono;
    private Integer cantidadPublicaciones;
    private String rubro;
    private String emial;
    private Notificador notificador;

    @Override
    public void notificarPublicacion(Postulacion postulacion, NotifyStrategy notifyStrategy) {
        this.notificador.withStrategy(notifyStrategy)
                   .send(new Notificacion());
    }
}
