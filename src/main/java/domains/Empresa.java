package domains;

import domains.notification.Notificacion;
import domains.notification.Notificador;
import interfaces.NotifyStrategy;
import interfaces.Observer;

import java.util.ArrayList;

public class Empresa implements Observer {

    private String razonSocial;
    private String direccion;
    private Integer telefono;
    private Integer cantidadPublicaciones;
    private String rubro;
    private String email;
    private String nroCelular;
    private Notificador notificador;
    private ArrayList<OfertaLaboral> ofertasLaborales;

    public Empresa(String razonSocial, String direccion, Integer telefono, Integer cantidadPublicaciones, String rubro, String email, String nroCelular, Notificador notificador) {
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cantidadPublicaciones = cantidadPublicaciones;
        this.rubro = rubro;
        this.email = email;
        this.nroCelular = nroCelular;
        this.notificador = notificador;
        ofertasLaborales = new ArrayList<>();
    }

    public void agregarOfertaLaboral(OfertaLaboral ofertaLaboral){
        this.ofertasLaborales.add(ofertaLaboral);
    }

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
        notificacion.setEmailTo(this.email);
        notificacion.setNroCelularFrom("1511111111");
        notificacion.setNroCelularTo(this.nroCelular);
        return notificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getCantidadPublicaciones() {
        return cantidadPublicaciones;
    }

    public void setCantidadPublicaciones(Integer cantidadPublicaciones) {
        this.cantidadPublicaciones = cantidadPublicaciones;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public Notificador getNotificador() {
        return notificador;
    }

    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    public ArrayList<OfertaLaboral> getOfertasLaborales() {
        return ofertasLaborales;
    }

    public void setOfertasLaborales(ArrayList<OfertaLaboral> ofertasLaborales) {
        this.ofertasLaborales = ofertasLaborales;
    }
}


