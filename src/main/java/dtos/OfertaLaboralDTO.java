package dtos;

import domains.Empresa;
import domains.Postulacion;
import domains.Requisitos;
import domains.state.Estado;
import enums.CategoriasPublicacionEnum;
import interfaces.NotifyStrategy;

import java.time.ZonedDateTime;
import java.util.List;

public class OfertaLaboralDTO {
    private String tituloBusqueda;
    private String descripcionPuesto;
    private String modalidadContrato;
    private String tipoTrabajo;
    private String lugarTrabajo;
    private Requisitos requisitos;
    private Integer sueldoOfrecido;
    private CategoriasPublicacionEnum categoria;
    private ZonedDateTime fechaPublicacion;
    private Estado estado;
    private List<Postulacion> postulantes;
    private Empresa empresa;
    private NotifyStrategy notifyStrategy;
    private ZonedDateTime vigenteHasta;

    public String getTituloBusqueda() {
        return tituloBusqueda;
    }

    public void setTituloBusqueda(String tituloBusqueda) {
        this.tituloBusqueda = tituloBusqueda;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    public String getModalidadContrato() {
        return modalidadContrato;
    }

    public void setModalidadContrato(String modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }

    public Integer getSueldoOfrecido() {
        return sueldoOfrecido;
    }

    public void setSueldoOfrecido(Integer sueldoOfrecido) {
        this.sueldoOfrecido = sueldoOfrecido;
    }

    public CategoriasPublicacionEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasPublicacionEnum categoria) {
        this.categoria = categoria;
    }

    public ZonedDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(ZonedDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Postulacion> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(List<Postulacion> postulantes) {
        this.postulantes = postulantes;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public NotifyStrategy getNotifyStrategy() {
        return notifyStrategy;
    }

    public void setNotifyStrategy(NotifyStrategy notifyStrategy) {
        this.notifyStrategy = notifyStrategy;
    }

    public ZonedDateTime getVigenteHasta() {
        return vigenteHasta;
    }

    public void setVigenteHasta(ZonedDateTime vigenteHasta) {
        this.vigenteHasta = vigenteHasta;
    }
}
