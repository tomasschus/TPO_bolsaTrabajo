package dtos;

import domains.OfertaLaboral;
import domains.notification.Notificador;

import java.util.ArrayList;

public class EmpresaDTO {
    private String razonSocial;
    private String direccion;
    private Integer telefono;
    private Integer cantidadPublicaciones;
    private String rubro;
    private String email;
    private String nroCelular;
    private Notificador notificador;
    private ArrayList<OfertaLaboral> ofertasLaborales;

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
