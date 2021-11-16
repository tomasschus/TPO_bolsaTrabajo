package interfaces;

import domains.Postulacion;

public interface PostulacionService {

    void postularse(Postulacion postulacion, Long id) throws Exception;
}
