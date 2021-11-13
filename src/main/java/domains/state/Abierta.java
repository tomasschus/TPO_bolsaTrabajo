package domains.state;

import domains.OfertaLaboral;

public class Abierta extends Estado {


    @Override
    public void cambiar(OfertaLaboral ofertaLaboral) {
        ofertaLaboral.cambiarEstado(new Cerrada());
    }
    public void cerrar(OfertaLaboral ofertaLaboral) {
        ofertaLaboral.cambiarEstado(new Cerrada());
    }
}
