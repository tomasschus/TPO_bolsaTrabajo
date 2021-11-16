package controlador;

import domains.Postulacion;
import dtos.PostulacionDTO;
import interfaces.PostulacionService;

public class PostulacionController {

    private PostulacionService postulacionService;

    public String postularse(PostulacionDTO postulacionDTO) throws Exception {
        Postulacion postulacion = new Postulacion();
        return postulacionService.postularse(postulacion,  postulacionDTO.getId());
    }
}
