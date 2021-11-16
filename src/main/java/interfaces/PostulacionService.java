package interfaces;

import domains.Postulacion;

public interface PostulacionService {

    String postularse(Postulacion postulacion, Long id) throws Exception;
}
