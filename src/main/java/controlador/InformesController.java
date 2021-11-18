package controlador;

import domains.Empresa;
import domains.OfertaLaboral;
import enums.CategoriasPublicacionEnum;

import java.util.*;
import java.util.stream.Collectors;

import static enums.CategoriasPublicacionEnum.*;

public class InformesController {
    //• La oferta laboral que más postulantes recibió en un mes y/o año determinado.
    ArrayList<Empresa> empresas = EmpresaController.getInstanceEmpresas();

    public void getMCategoriasMasVisitadas(int m) {

        ArrayList<OfertaLaboral> ofertaLaborals = this.getOfertaLaborales();
        Map<CategoriasPublicacionEnum, Integer> categoriasVisitas = Map.of(Administración, 0, Tecnología, 0, Ventas, 0);
        ofertaLaborals.forEach(o -> {
            Integer visitas = categoriasVisitas.get(o.getCategoria());
            categoriasVisitas.put(o.getCategoria(), o.getNumeroDeVisitas()+visitas);
        });

        categoriasVisitas.entrySet()
                         .stream()
                         .sorted(Map.Entry.<CategoriasPublicacionEnum, Integer>comparingByValue().reversed())
                         .limit(m)
                         .forEach(System.out::println);
    }

    public ArrayList<OfertaLaboral> getOfertaLaborales(){
        ArrayList<OfertaLaboral> ofertasLaborales = new ArrayList<>();
        for (Empresa em: empresas){
            for(OfertaLaboral of: em.getOfertasLaborales()){
                ofertasLaborales.add(of);
            }
        }
        return ofertasLaborales;
    }
    
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

}
