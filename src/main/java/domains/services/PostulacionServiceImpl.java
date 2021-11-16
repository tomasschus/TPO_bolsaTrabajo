package domains.services;

import domains.OfertaLaboral;
import domains.Postulacion;
import domains.Postulante;
import domains.Requisitos;
import enums.StateEnum;
import interfaces.PostulacionService;

import java.util.List;

public class PostulacionServiceImpl implements PostulacionService {

    private List<OfertaLaboral> ofertasLaborales;

    @Override
    public void postularse(Postulacion postulacion, Long id) throws Exception {

        OfertaLaboral ofertaLaboral = findById(id);

        if(StateEnum.ABIERTA.equals(ofertaLaboral.getEstado().getEstado())) {

            //Aca notifica a la empresa con el notificador
            ofertaLaboral.agregarPostulacion(postulacion);

        } else {
            throw new Exception("Publicacion cerrada");
        }



    }

    private OfertaLaboral findById(Long id) throws Exception {
        return this.ofertasLaborales
                .stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("id-oferta not exist"));
    }

    private void validateRequisitos(Requisitos requisitos, Postulante postulante) {

    }
}
