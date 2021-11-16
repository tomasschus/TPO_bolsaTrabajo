package domains;

import java.time.ZonedDateTime;

public class Postulacion {

    private Postulante postulante;
    private ZonedDateTime fechaPostulacion;
    private Integer remuneracionPretendida;

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
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
}
