package controlador;

import domains.Postulacion;
import dtos.PostulacionDTO;
import interfaces.PostulacionService;

public class PostulacionController {

    private PostulacionService postulacionService;

    public void postularse(PostulacionDTO postulacionDTO) {
        Postulacion postulacion = new Postulacion();

        postulacionService.postularse(postulacion, 1L);
    }
}
