package services;

import controlador.EmpresaController;
import domains.*;
import enums.StateEnum;
import interfaces.EmpresaService;
import interfaces.PostulacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostulacionServiceImpl implements PostulacionService {

    private EmpresaService empresaService;

    private static final String MSG_POSTULACION_SUCCESFULL = "Postulacion exitosa";

    public PostulacionServiceImpl() {
        this.empresaService = new EmpresaServiceImpl();
    }


    @Override
    public String postularse(Postulacion postulacion, Long id, String razonSocial) throws Exception {

        ArrayList<Empresa> empresas = getEmpresas();

        ArrayList<OfertaLaboral> ofertaLaborales = empresaService.getOfertasLaborales(empresas, razonSocial);

        OfertaLaboral ofertaLaboral = findById(id, ofertaLaborales);

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

    public OfertaLaboral findById(Long id, ArrayList<OfertaLaboral> ofertas) throws Exception {
        return   ofertas
                .stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("id-oferta " + id + " not exist"));
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

    private ArrayList getEmpresas() {
        return EmpresaController.getInstanceEmpresas();
    }
}
