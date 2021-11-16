package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import domains.Postulacion;
import dtos.PostulacionDTO;
import interfaces.PostulacionService;

public class PostulacionController {

    private PostulacionService postulacionService;
    private ObjectMapper objectMapper;

    public PostulacionController(PostulacionService postulacionService, ObjectMapper objectMapper) {
        this.postulacionService = postulacionService;
        this.objectMapper = objectMapper;
    }

    public String postularse(PostulacionDTO postulacionDTO) throws Exception {
        Postulacion postulacion = this.objectMapper.convertValue(postulacionDTO, Postulacion.class);
        return postulacionService.postularse(postulacion,  postulacionDTO.getId());
    }
}
