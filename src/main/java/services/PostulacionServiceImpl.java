package services;

import domains.OfertaLaboral;
import domains.Postulacion;
import domains.Postulante;
import domains.Requisitos;
import enums.StateEnum;
import interfaces.PostulacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostulacionServiceImpl implements PostulacionService {

    private static final String MSG_POSTULACION_SUCCESFULL = "Postulacion exitosa";

    private List<OfertaLaboral> ofertasLaborales;

    public PostulacionServiceImpl() {
        this.ofertasLaborales = new ArrayList<>();
    }

    @Override
    public String postularse(Postulacion postulacion, Long id) throws Exception {

        OfertaLaboral ofertaLaboral = findById(id);

        if(StateEnum.ABIERTA.equals(ofertaLaboral.getEstado().getEstado())) {
            //Valido que cumpla requisitos
            validateRequisitos(ofertaLaboral.getRequisitos(),postulacion.getPostulante());
            //Aca notifica a la empresa con el notificador
            ofertaLaboral.agregarPostulacion(postulacion);

        } else {
            throw new Exception("Publicacion cerrada");
        }
        return MSG_POSTULACION_SUCCESFULL;
    }

    private OfertaLaboral findById(Long id) throws Exception {
        return this.ofertasLaborales
                .stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("id-oferta not exist"));
    }

    private void validateRequisitos(Requisitos requisitos, Postulante postulante) throws Exception {
        if(requisitos.getEdadMaxima() < postulante.getEdad() || requisitos.getEdadMinima() > postulante.getEdad()) {
            throw new Exception("Edad requerida no cumplida");
        }
        if(requisitos.isGraduado() && !postulante.isGraduado()) {
            throw new Exception("Requiere estar gradudado");
        }
        if(!requisitos.getIdiomas().isEmpty()) {
            requisitos.getIdiomas()
                    .stream()
                    .filter(r -> !postulante.getIdiomas().contains(r))
                    .collect(Collectors.toList())
                    .stream().findAny()
                    .orElseThrow(() -> new Exception("No cumple con los idiomas requeridos"));
        }
    }
}
