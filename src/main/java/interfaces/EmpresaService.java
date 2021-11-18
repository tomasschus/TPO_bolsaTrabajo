package interfaces;

import domains.Empresa;
import domains.OfertaLaboral;
<<<<<<< HEAD
import domains.Postulacion;
=======
import domains.Requisitos;
>>>>>>> 45d28cda167d7933b8ae40923061257593380b36
import domains.notification.Notificador;
import enums.CategoriasPublicacionEnum;

import java.util.ArrayList;
import java.util.List;

public interface EmpresaService {
    Empresa crearEmpresa(String razonSocial, String direccion, Integer telefono, Integer cantidadPublicaciones, String rubro, String email, String nroCelular, Notificador notificador);
    boolean eliminarEmpresa(ArrayList<Empresa> empresas,String razonSocial);
    void crearOfertaLaboral(ArrayList<Empresa> empresas, String razonSocial, OfertaLaboral ofertaLaboral);
    boolean modificarOfertaLaboral(ArrayList<Empresa> empresas, String razonSocial, Long id, String tituloBusqueda, String descripcionPuesto, String modalidadContrato, String tipoTrabajo, String lugarTrabajo, Requisitos requisitos, Integer sueldoOfrecido, CategoriasPublicacionEnum categoria);
    void cerrarOfertaLaboral(ArrayList<Empresa> empresas, String razonSocial, Long idOfertaLaboral);
    Empresa getEmpresaByRazonSocial(ArrayList<Empresa> empresas, String razonSocial);
    ArrayList<OfertaLaboral> getOfertasLaborales(ArrayList<Empresa> empresas, String razonSocial);
    List<Postulacion> getPostulantes(ArrayList<Empresa> empresas, String razonSocial, Long id) throws Exception;
}
