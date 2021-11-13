package domains;

import domains.notification.Notificador;
import domains.state.Estado;
import enums.CategoriasPublicacionEnum;
import interfaces.NotifyStrategy;

import java.time.ZonedDateTime;
import java.util.List;

public class OfertaLaboral {

    private String tituloBusqueda;
    private String descripcionPuesto;
    private String modalidadContrato;
    private String tipoTrabajo;
    private String lugarTrabajo;
    private String requisitos;
    private Integer sueldoOfrecido;
    private CategoriasPublicacionEnum categoria;
    private ZonedDateTime fechaPublicacion;
    private Estado estado;
    private List<Postulacion> postulantes;
    private Empresa empresa;
    private NotifyStrategy notifyStrategy;

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public void validarRequisitos(Postulacion postulacion) {
        //TODO
    }

    public void agregarPostulacion(Postulacion postulacion) {
        this.postulantes.add(postulacion);
        notificar(postulacion);
    }

    public void notificar(Postulacion postulacion) {
        this.empresa.notificarPublicacion(postulacion, notifyStrategy);
    }

}
