package domains.state;

import domains.OfertaLaboral;
import enums.StateEnum;

public abstract class Estado {

    public abstract void cambiar(OfertaLaboral ofertaLaboral);

    public abstract StateEnum getEstado();

}
