package controlador;

import domains.Empresa;
import domains.OfertaLaboral;
import java.util.ArrayList;

public class InformesController {
    ArrayList<Empresa> empresas = EmpresaController.getInstanceEmpresas();

    public ArrayList<OfertaLaboral> getOfertaLaborales(){
        ArrayList<OfertaLaboral> ofertasLaborales = new ArrayList<>();
        for (Empresa em: empresas){
            for(OfertaLaboral of: em.getOfertasLaborales()){
                ofertasLaborales.add(of);
            }
        }
        return ofertasLaborales;
    }

    //• La oferta laboral que más postulantes recibió en un mes y/o año determinado.
    public OfertaLaboral getOfertaLaboralConMasPostulantes(int mes, int año){
        OfertaLaboral masPostulantes = null;
        for (Empresa em: empresas) {
            for (OfertaLaboral of : em.getOfertasLaborales()) {
                if(of.getFechaPublicacion().getYear()==año && of.getFechaPublicacion().getMonthValue()==mes){
                    if(masPostulantes==null){
                        masPostulantes=of;
                    }
                    else{
                        if(of.getPostulantes().size()>masPostulantes.getPostulantes().size()){
                            masPostulantes=of;
                        }
                    }
                }
            }
        }
        return masPostulantes;
    }
    public OfertaLaboral getOfertaLaboralConMasPostulantes(int año){
        OfertaLaboral masPostulantes = null;
        for (Empresa em: empresas) {
            for (OfertaLaboral of : em.getOfertasLaborales()) {
                if(of.getFechaPublicacion().getYear()==año){
                    if(masPostulantes==null){
                        masPostulantes=of;
                    }
                    else{
                        if(of.getPostulantes().size()>masPostulantes.getPostulantes().size()){
                            masPostulantes=of;
                        }
                    }
                }
            }
        }
        return masPostulantes;
    }

    //Cuál es la oferta “más exigente”, considerando que es “la más exigente” aquella oferta que tiene
    //mayor cantidad de requisitos.
    // hice una funcion en requisios que contabiliza los puntos en funcion de los atributos activos.
    public OfertaLaboral getOfertaMasExigente(){
        OfertaLaboral masExigente = null;
        for(OfertaLaboral of: getOfertaLaborales()){
            if(masExigente==null){
                masExigente = of;
            }
            else{
                if(of.getRequisitos().getPuntos()>masExigente.getRequisitos().getPuntos()){
                    masExigente = of;
                }
            }
        }
        return masExigente;
    }
}
