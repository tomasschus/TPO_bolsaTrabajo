package interfaces;

import domains.OfertaLaboral;
import domains.Postulacion;

import java.util.ArrayList;

public interface PostulacionService {

    String postularse(Postulacion postulacion, Long id, String razonSocial) throws Exception;
    OfertaLaboral findById(Long id, ArrayList<OfertaLaboral> ofertas) throws Exception;
}
