package controlador;

import domains.Empresa;
import domains.OfertaLaboral;
import domains.Postulacion;
import domains.notification.Notificador;
import interfaces.EmpresaService;
import services.EmpresaServiceImpl;
import enums.CategoriasPublicacionEnum;

import java.util.ArrayList;
import java.util.List;

public class EmpresaController {

    private EmpresaService empresaService;
    private static ArrayList<Empresa> empresas;

    public EmpresaController(){
        empresaService = new EmpresaServiceImpl();
    }


    public void crearEmpresa(String razonSocial, String direccion, Integer telefono, Integer cantidadPublicaciones, String rubro, String email, String nroCelular, Notificador notificador) {
        getInstanceEmpresas().add(empresaService.crearEmpresa( razonSocial,  direccion,  telefono,  cantidadPublicaciones,  rubro,  email,  nroCelular,  notificador));
    }

    public boolean eliminarEmpresa( String razonSocial) {
        return empresaService.eliminarEmpresa(getInstanceEmpresas(),razonSocial);
    }

    public void crearOfertaLaboral(String razonSocial, OfertaLaboral ofertaLaboral) {
        //ver si se encarga esta funcion de crear la oferta
        //empresaService.crearOfertaLaboral(empresa,ofertaLaboral);
    }

    public boolean modificarOfertaLaboral( String razonSocial, Long id, String tituloBusqueda, String descripcionPuesto, String modalidadContrato, String tipoTrabajo, String lugarTrabajo, String requisitos, Integer sueldoOfrecido, CategoriasPublicacionEnum categoria) {
        return empresaService.modificarOfertaLaboral( getInstanceEmpresas(),  razonSocial,  id,  tituloBusqueda,
                 descripcionPuesto,  modalidadContrato,  tipoTrabajo,  lugarTrabajo,
                requisitos,  sueldoOfrecido, categoria);
    }

    public void cerrarOfertaLaboral(String razonSocial, Long idOfertaLaboral) {

    }

    public ArrayList<OfertaLaboral> getOfertasLaborales(Empresa empresa) {
        return null;
    }

    public List<Postulacion> getPostulantesByPublicacion(String razonSocial, Long id) throws Exception {
       return empresaService.getPostulantes(getInstanceEmpresas(), razonSocial, id);
    }

    public static ArrayList getInstanceEmpresas() {
        if(empresas == null) {
            return new ArrayList<>();
        }
        return empresas;
    }
}
