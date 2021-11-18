package domains;

import java.util.List;

public class Requisitos {

    private int edadMinima;
    private int edadMaxima;
    private boolean graduado;
    private List<String> idiomas;

    public int getPuntos(){
        int puntos = 0;
        if (edadMinima!=0){
            puntos = puntos + 1;
        }
        if (edadMaxima!=0){
            puntos = puntos + 1;
        }
        if (graduado){
            puntos = puntos + 1;
        }
        return puntos + idiomas.size();
    }

    public Requisitos(int edadMinima, int edadMaxima, boolean graduado, List<String> idiomas) {
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.graduado = graduado;
        this.idiomas = idiomas;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }
}
