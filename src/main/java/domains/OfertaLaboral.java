package domains;

import domains.state.Estado;
import enums.CategoriasPublicacionEnum;
import interfaces.NotifyStrategy;

import java.time.ZonedDateTime;
import java.util.List;

public class OfertaLaboral {

    private Long id;
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
    private Integer numeroDeVisitas = 0;

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }


    public void agregarPostulacion(Postulacion postulacion) {
        this.postulantes.add(postulacion);
        notificar(postulacion);
    }

    public void visitada() {
        this.numeroDeVisitas = this.numeroDeVisitas + 1;
    }

    public void notificar(Postulacion postulacion) {
        this.empresa.notificarPublicacion(postulacion, notifyStrategy);
    }

    public OfertaLaboral(Long id, String tituloBusqueda, String descripcionPuesto, String modalidadContrato, String tipoTrabajo, String lugarTrabajo, Requisitos requisitos, Integer sueldoOfrecido, CategoriasPublicacionEnum categoria, ZonedDateTime fechaPublicacion, Estado estado, List<Postulacion> postulantes, Empresa empresa, NotifyStrategy notifyStrategy, ZonedDateTime vigenteHasta) {
        this.id = id;
        this.tituloBusqueda = tituloBusqueda;
        this.descripcionPuesto = descripcionPuesto;
        this.modalidadContrato = modalidadContrato;
        this.tipoTrabajo = tipoTrabajo;
        this.lugarTrabajo = lugarTrabajo;
        this.requisitos = requisitos;
        this.sueldoOfrecido = sueldoOfrecido;
        this.categoria = categoria;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
        this.postulantes = postulantes;
        this.empresa = empresa;
        this.notifyStrategy = notifyStrategy;
        this.vigenteHasta = vigenteHasta;
    }

    public Long getId() {
        return id;
    }

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

    public void setId(Long id) {
        this.id = id;
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

    public Integer getNumeroDeVisitas() {
        return numeroDeVisitas;
    }

    public void setNumeroDeVisitas(Integer numeroDeVisitas) {
        this.numeroDeVisitas = numeroDeVisitas;
    }
}
