package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import domains.OfertaLaboral;
import domains.Postulacion;
import dtos.PostulacionDTO;
import interfaces.EmpresaService;
import interfaces.PostulacionService;

import java.util.ArrayList;

public class PostulacionController {

    private PostulacionService postulacionService;
    private EmpresaService empresaService;
    private ObjectMapper objectMapper;

    public PostulacionController(PostulacionService postulacionService, EmpresaService empresaService, ObjectMapper objectMapper) {
        this.postulacionService = postulacionService;
        this.empresaService = empresaService;
        this.objectMapper = objectMapper;
    }

    public String postularse(PostulacionDTO postulacionDTO) throws Exception {
        Postulacion postulacion = this.objectMapper.convertValue(postulacionDTO, Postulacion.class);
        return postulacionService.postularse(postulacion,  postulacionDTO.getId(), postulacionDTO.getRazonSocial());
    }

    public OfertaLaboral findPublicacionById(Long id, String razonSocial) throws Exception {
        ArrayList<OfertaLaboral> ofertas = this.empresaService.getOfertasLaborales(EmpresaController.getInstanceEmpresas(), razonSocial);
        return postulacionService.findById(id, ofertas);
    }
}
