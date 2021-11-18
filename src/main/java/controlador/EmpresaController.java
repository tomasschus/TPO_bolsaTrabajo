package controlador;

import domains.Empresa;
import domains.OfertaLaboral;
import domains.Postulacion;
import dtos.EmpresaDTO;
import dtos.OfertaLaboralDTO;
import interfaces.EmpresaService;
import services.EmpresaServiceImpl;
import services.PostulacionServiceImpl;


import java.util.ArrayList;
import java.util.List;

public class EmpresaController {

    private EmpresaService empresaService;
    private static ArrayList<Empresa> empresas;

    public EmpresaController(){
        empresaService = new EmpresaServiceImpl();
    }

    public void crearEmpresa(EmpresaDTO empresa) {
        this.getInstanceEmpresas().add(empresaService.crearEmpresa(
                empresa.getRazonSocial(),  empresa.getDireccion(),
                empresa.getTelefono(),  empresa.getCantidadPublicaciones(),
                empresa.getRubro(),  empresa.getEmail(),
                empresa.getNroCelular(),  empresa.getNotificador()));
    }

    public boolean eliminarEmpresa( String razonSocial) {
        return empresaService.eliminarEmpresa(getInstanceEmpresas(),razonSocial);
    }

    public void crearOfertaLaboral(String razonSocial, OfertaLaboralDTO ofertaLaboralDTO) {
        Long id = null;
        OfertaLaboral ofertaLaboral = new OfertaLaboral(id,ofertaLaboralDTO.getTituloBusqueda(),ofertaLaboralDTO.getDescripcionPuesto(),ofertaLaboralDTO.getModalidadContrato(),ofertaLaboralDTO.getTipoTrabajo(),ofertaLaboralDTO.getLugarTrabajo(),ofertaLaboralDTO.getRequisitos(),ofertaLaboralDTO.getSueldoOfrecido(),ofertaLaboralDTO.getCategoria(),ofertaLaboralDTO.getFechaPublicacion(),ofertaLaboralDTO.getEstado(),ofertaLaboralDTO.getPostulantes(),ofertaLaboralDTO.getEmpresa(),ofertaLaboralDTO.getNotifyStrategy(),ofertaLaboralDTO.getVigenteHasta());
        empresaService.crearOfertaLaboral(getInstanceEmpresas(),razonSocial,ofertaLaboral);
    }


    public boolean modificarOfertaLaboral(String razonSocial, Long id, OfertaLaboralDTO ofertaLaboralDTO) {
        return empresaService.modificarOfertaLaboral( getInstanceEmpresas(),  razonSocial,  id,  ofertaLaboralDTO.getTituloBusqueda(),
                ofertaLaboralDTO.getDescripcionPuesto(),  ofertaLaboralDTO.getModalidadContrato(),  ofertaLaboralDTO.getTipoTrabajo(),
                ofertaLaboralDTO.getLugarTrabajo(), ofertaLaboralDTO.getRequisitos(),
                ofertaLaboralDTO.getSueldoOfrecido(), ofertaLaboralDTO.getCategoria());
    }

    public void cerrarOfertaLaboral(String razonSocial, Long idOfertaLaboral) {
        empresaService.cerrarOfertaLaboral(getInstanceEmpresas(),razonSocial,idOfertaLaboral);
    }

    public ArrayList<OfertaLaboral> getOfertasLaboralesPorRazonSocial(String razonSocial) {
        return empresaService.getOfertasLaborales(getInstanceEmpresas(),razonSocial);
    }



    public List<Postulacion> getPostulantesByPublicacion(String razonSocial, Long id) throws Exception {
       return empresaService.getPostulantes(getInstanceEmpresas(), razonSocial, id);
    }

    public static ArrayList<Empresa> getInstanceEmpresas() {
        if(empresas == null) {
            return new ArrayList<>();
        }
        return empresas;
    }
}
