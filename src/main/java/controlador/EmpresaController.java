package controlador;

import domains.Empresa;
import domains.OfertaLaboral;
import domains.notification.Notificador;
import domains.services.EmpresaService;
import enums.CategoriasPublicacionEnum;

import java.util.ArrayList;

public class EmpresaController {
    private EmpresaService empresaService;
    private ArrayList<Empresa> empresas;

    public EmpresaController(){
        empresas = new ArrayList<>();
        empresaService = new EmpresaService();
    }


    public void crearEmpresa(String razonSocial, String direccion, Integer telefono, Integer cantidadPublicaciones, String rubro, String email, String nroCelular, Notificador notificador) {
        this.empresas.add(empresaService.crearEmpresa( razonSocial,  direccion,  telefono,  cantidadPublicaciones,  rubro,  email,  nroCelular,  notificador));
    }

    public boolean eliminarEmpresa( String razonSocial) {
        return empresaService.eliminarEmpresa(empresas,razonSocial);
    }

    public void crearOfertaLaboral(String razonSocial, OfertaLaboral ofertaLaboral) {
        //ver si se encarga esta funcion de crear la oferta
        //empresaService.crearOfertaLaboral(empresa,ofertaLaboral);
    }

    public boolean modificarOfertaLaboral( String razonSocial, Long id, String tituloBusqueda, String descripcionPuesto, String modalidadContrato, String tipoTrabajo, String lugarTrabajo, String requisitos, Integer sueldoOfrecido, CategoriasPublicacionEnum categoria) {
        return empresaService.modificarOfertaLaboral( empresas,  razonSocial,  id,  tituloBusqueda,
                 descripcionPuesto,  modalidadContrato,  tipoTrabajo,  lugarTrabajo,
                requisitos,  sueldoOfrecido, categoria);
    }

    public void cerrarOfertaLaboral(String razonSocial, Long idOfertaLaboral) {

    }

    public ArrayList<OfertaLaboral> getOfertasLaborales(Empresa empresa) {
        return null;
    }
}