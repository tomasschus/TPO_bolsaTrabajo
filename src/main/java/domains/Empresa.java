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
    private String nroCelular;
    private Notificador notificador;

    @Override
    public void notificarPublicacion(Postulacion postulacion, NotifyStrategy notifyStrategy) {
        this.notificador.withStrategy(notifyStrategy)
                        .send(buildNotification(postulacion));
    }

    private Notificacion buildNotification(Postulacion postulacion) {
        Notificacion notificacion = new Notificacion();
        Postulante postulante = postulacion.getPostulante();
        notificacion.setMessage("Se postulo " + postulante.getNombre() + " " + postulante.getApellido());
        notificacion.setEmialFrom("notificaciones@bolsatrabajo.com");
        notificacion.setEmailTo(this.emial);
        notificacion.setNroCelularFrom("1511111111");
        notificacion.setNroCelularTo(this.nroCelular);
        return notificacion;
    }
}


