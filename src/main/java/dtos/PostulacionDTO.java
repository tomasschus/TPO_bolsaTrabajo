package dtos;

import java.time.ZonedDateTime;
import java.util.List;

public class PostulacionDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private List<String> idiomas;
    private String categoria;
    private boolean graduado;
    private int edad;
    private ZonedDateTime fechaPostulacion;
    private Integer remuneracionPretendida;
    private String razonSocial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ZonedDateTime getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(ZonedDateTime fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public Integer getRemuneracionPretendida() {
        return remuneracionPretendida;
    }

    public void setRemuneracionPretendida(Integer remuneracionPretendida) {
        this.remuneracionPretendida = remuneracionPretendida;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
