package domains.state;

import domains.OfertaLaboral;
import interfaces.Image;

public class Cerrada extends Estado{


    @Override
    public void cambiar(OfertaLaboral ofertaLaboral) {
        ofertaLaboral.cambiarEstado(new Abierta());
    }

    public void reabrir(OfertaLaboral ofertaLaboral) {
        ofertaLaboral.cambiarEstado(new Abierta());
    }

}
