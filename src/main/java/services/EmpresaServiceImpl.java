package services;

import domains.Empresa;
import domains.OfertaLaboral;
import domains.Postulacion;
import domains.Postulante;
import domains.notification.Notificador;
import domains.state.Cerrada;
import enums.CategoriasPublicacionEnum;
import interfaces.PostulacionService;

import java.util.ArrayList;
import java.util.List;

public class EmpresaServiceImpl implements interfaces.EmpresaService {

    private PostulacionService postulacionService;

    public EmpresaServiceImpl(PostulacionService postulacionService) {
        this.postulacionService = postulacionService;
    }

    @Override
    public Empresa crearEmpresa(String razonSocial, String direccion, Integer telefono, Integer cantidadPublicaciones, String rubro, String email, String nroCelular, Notificador notificador) {
        return new Empresa( razonSocial,  direccion,  telefono,  cantidadPublicaciones,  rubro,  email,  nroCelular,  notificador);
    }

    @Override
    public boolean eliminarEmpresa(ArrayList<Empresa> empresas, String razonSocial) {
        for (Empresa e: empresas) {
            if(e.getRazonSocial()==razonSocial){
                empresas.remove(e);
                return true;
            }
        }
        return false;
    }

    @Override
    public void crearOfertaLaboral(ArrayList<Empresa> empresas, String razonSocial, OfertaLaboral ofertaLaboral) {
        Empresa empresa = getEmpresaByRazonSocial(empresas,razonSocial);
        ofertaLaboral.setEmpresa(empresa);
        empresa.agregarOfertaLaboral(ofertaLaboral);
    }

    @Override
    public Empresa getEmpresaByRazonSocial(ArrayList<Empresa> empresas, String razonSocial) {
        for (Empresa e: empresas) {
            if(e.getRazonSocial()==razonSocial){
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean modificarOfertaLaboral(ArrayList<Empresa> empresas, String razonSocial, Long idOfertaLaboral, String tituloBusqueda, String descripcionPuesto,
                                       String modalidadContrato, String tipoTrabajo,
                                       String lugarTrabajo, String requisitos,
                                       Integer sueldoOfrecido, CategoriasPublicacionEnum categoria ) {

        Empresa empresa = getEmpresaByRazonSocial(empresas,razonSocial);
        for(OfertaLaboral ofertaLaboral: empresa.getOfertasLaborales()){
            if(ofertaLaboral.getId()==idOfertaLaboral) {
                ofertaLaboral.setTituloBusqueda(tituloBusqueda);
                ofertaLaboral.setDescripcionPuesto(descripcionPuesto);
                ofertaLaboral.setModalidadContrato(modalidadContrato);
                ofertaLaboral.setTipoTrabajo(tipoTrabajo);
                ofertaLaboral.setLugarTrabajo(lugarTrabajo);
                //TODO arreglar (Se cambio requisitos de string a object)
                //ofertaLaboral.setRequisitos(requisitos);
                ofertaLaboral.setSueldoOfrecido(sueldoOfrecido);
                ofertaLaboral.setCategoria(categoria);
                return true;
            }
        }
        return false;
    }

    @Override
    public void cerrarOfertaLaboral(ArrayList<Empresa> empresas, String razonSocial, Long idOfertaLaboral) {
        Empresa empresa = getEmpresaByRazonSocial(empresas,razonSocial);
        for(OfertaLaboral ofertaLaboral: empresa.getOfertasLaborales()) {
            if (ofertaLaboral.getId() == idOfertaLaboral) {
                ofertaLaboral.cambiarEstado(new Cerrada());
            }
        }
    }

    @Override
    public ArrayList<OfertaLaboral> getOfertasLaborales(ArrayList<Empresa> empresas, String razonSocial) {
        return getEmpresaByRazonSocial(empresas,razonSocial).getOfertasLaborales();
    }

    @Override
    public List<Postulacion> getPostulantes(ArrayList<Empresa> empresas, String razonSocial, Long id) throws Exception {

        ArrayList<OfertaLaboral> ofertaLaborales = this.getOfertasLaborales(empresas, razonSocial);
        OfertaLaboral ofertaLaboral = postulacionService.findById(id, ofertaLaborales);
        return ofertaLaboral.getPostulantes();
    }


}
