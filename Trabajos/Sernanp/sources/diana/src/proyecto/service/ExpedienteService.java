package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.dao.ExpedienteDAO;
import proyecto.dao.ExpedienteInfraccionDAO;
import proyecto.dao.ExpedienteSancionDAO;
import proyecto.dao.InfraccionDAO;
import proyecto.dao.InfractorDAO;
import proyecto.dao.ResolucionDAO;
import proyecto.dao.SancionDAO;
import proyecto.util.Pagination;
import proyecto.vo.Archivo;
import proyecto.vo.DetalleExpedienteSancion;
import proyecto.vo.Expediente;
import proyecto.vo.ExpedienteInfraccion;
import proyecto.vo.ExpedienteSancion;
import proyecto.vo.Infraccion;

@Service
public class ExpedienteService {

	@Autowired
	private InfractorDAO infractorDAO;
	
	@Autowired
	private ResolucionDAO resolucionDAO;
	
	@Autowired
	private ExpedienteSancionDAO expedienteSancionDAO;

	@Autowired
	private ExpedienteInfraccionDAO expedienteInfraccionDAO;
	
//	@Autowired
//	private MultaDAO multaDAO;
	
	@Autowired
	private InfraccionService  infraccionService;	

//	@Autowired
//	private SancionService sancionService;
	
	@Autowired
	private ExpedienteDAO expedienteDAO;
	
	@Autowired
	private InfraccionDAO infraccionDAO;
	
	@Autowired
	private SancionDAO sancionDAO;	

	// JCEV 29-10-2012
	public int insertarUpdateExpTrx(Expediente exp, int idPersNatu){
		return expedienteDAO.insertarUpdateExpedienteTrx(exp,idPersNatu);
	}
	
	// JCEV 26-10-2012
	public int insertarExpTrx(Expediente exp){
		return expedienteDAO.insertarExpedienteTrx(exp);
	}
	
	public void insertar(Expediente exp){
		
		int idInfractor   = 0; // Insertamos infractor:
		int idResolucion  = 0; // Insertamos resolucion
		int idAreaNatural = 0; // Obtenemos el areanatural
		int idExpediente  = 0; // Insertamo el expediente
		
		// JCEV 16-09-2012
		// int idMulta       = 0; // Insertamos multa
		try {			
			// 1. Agrega Infractor y nos devuelve el Nro. del Infractor
			idInfractor   = infractorDAO.insertar(exp);
			// System.out.println("***  IdInfractor : " + idInfractor);
			
			// 2. Agrega los Datos de la resolucion y nos devuelve el Nro. de Resolución
			idResolucion  = resolucionDAO.insertar(exp);
			
			// Se Elimino las multas, por la parte de Observaciones  de la Tabla
			// detalleExpedienteSancion, coordinado con Yonny y JCEV  (14-09-2012)
//			idMulta       = multaDAO.insertar(exp);						
			idAreaNatural = exp.getIdareanatural();
			
			// 3. Agrega el Expiente y nos devuelve el Nro. de Expediente
//			idExpediente  = expedienteDAO.insertar_wi(idInfractor, idResolucion, idMulta,idareanatural);
			idExpediente  = expedienteDAO.insertar_ExpedienteInfractor(idInfractor, idResolucion, idAreaNatural);
			
			// JCEV 16-09-2012 (Cuando se agrego correctamente el Expediente)
			if(idExpediente>=0){

				// 4. Grabamos las Infracciones x Expediente
				for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
					if(ei!=null){
						// JCEV 16-09.2012 Version Antigua
//						expedienteInfraccionDAO.insertar(idExpediente, ei.getInfraccion().getIdinfraccion(), 
//		                         ei.getReincidencia());

						// JCEV 17-09.2012 Version Nueva
						expedienteInfraccionDAO.insertaExpedienteInfraccion(idExpediente, 
								                                            ei.getInfraccion().getIdinfraccion(), 
								                                            ei.getReincidencia());						
					}
				}
				
		        // Grabamos listamos las Sanciones x Expediente y su Detalle
				for(ExpedienteSancion es : exp.getListaExpedienteSancion()){					
					int idexpsancion = expedienteSancionDAO.insertarExpedienteSancion(idExpediente, 
															       es.getSancion().getIdsancion(),
															       es.getEstado());				
					// Creando el DetalleExpedienteSancion
					//for(DetalleExpedienteSancion des : es.getListaDetalleExpedienteSancion()){
					DetalleExpedienteSancion des = es.getDetalleExpedienteSancion();
//						System.out.println("Exp. Detalle : " + idExpediente + " - " + 
//					                                           es.getSancion().getIdsancion() + " - " + 
//					                                           es.getEstado() + " - " +  
//					                                           des.getDatoVariado() + " - " + 
//					                                           des.getObservacion());
						expedienteSancionDAO.insertarDetalleExpedienteSancion(idExpediente, es.getSancion().getIdsancion(),
						          es.getEstado(), des.getDatoVariado(), 
						          des.getObservacion(), idexpsancion);
					
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	// JCEV 26-10-2012
	@Transactional
	public void insertarTrx(Expediente exp){
		
		int idInfractor   = 0; // Insertamos infractor:
		int idResolucion  = 0; // Insertamos resolucion
		int idAreaNatural = 0; // Obtenemos el areanatural
		int idExpediente  = 0; // Insertamo el expediente
		
		// JCEV 16-09-2012
		// int idMulta       = 0; // Insertamos multa
		try {		
			expedienteDAO.insertarExpedienteTrx(exp);
			
			// 1. Agrega Infractor y nos devuelve el Nro. del Infractor
			idInfractor   = infractorDAO.insertar(exp);
			// System.out.println("***  IdInfractor : " + idInfractor);
			
			// 2. Agrega los Datos de la resolucion y nos devuelve el Nro. de Resolución
			idResolucion  = resolucionDAO.insertar(exp);
			
			// Se Elimino las multas, por la parte de Observaciones  de la Tabla
			// detalleExpedienteSancion, coordinado con Yonny y JCEV  (14-09-2012)
//			idMulta       = multaDAO.insertar(exp);						
			idAreaNatural = exp.getIdareanatural();
			
			// 3. Agrega el Expiente y nos devuelve el Nro. de Expediente
//			idExpediente  = expedienteDAO.insertar_wi(idInfractor, idResolucion, idMulta,idareanatural);
			idExpediente  = expedienteDAO.insertar_ExpedienteInfractor(idInfractor, idResolucion, idAreaNatural);
			
			// JCEV 16-09-2012 (Cuando se agrego correctamente el Expediente)
			if(idExpediente>=0){

				// 4. Grabamos las Infracciones x Expediente
				for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
					if(ei!=null){
						// JCEV 16-09.2012 Version Antigua
//						expedienteInfraccionDAO.insertar(idExpediente, ei.getInfraccion().getIdinfraccion(), 
//		                         ei.getReincidencia());

						// JCEV 17-09.2012 Version Nueva
						expedienteInfraccionDAO.insertaExpedienteInfraccion(idExpediente, 
								                                            ei.getInfraccion().getIdinfraccion(), 
								                                            ei.getReincidencia());						
					}
				}
				
		        // Grabamos listamos las Sanciones x Expediente y su Detalle
				for(ExpedienteSancion es : exp.getListaExpedienteSancion()){					
					int idexpsancion = expedienteSancionDAO.insertarExpedienteSancion(idExpediente, 
															       es.getSancion().getIdsancion(),
															       es.getEstado());				
					// Creando el DetalleExpedienteSancion
					//for(DetalleExpedienteSancion des : es.getListaDetalleExpedienteSancion()){
					DetalleExpedienteSancion des = es.getDetalleExpedienteSancion();
//						System.out.println("Exp. Detalle : " + idExpediente + " - " + 
//					                                           es.getSancion().getIdsancion() + " - " + 
//					                                           es.getEstado() + " - " +  
//					                                           des.getDatoVariado() + " - " + 
//					                                           des.getObservacion());
						expedienteSancionDAO.insertarDetalleExpedienteSancion(idExpediente, es.getSancion().getIdsancion(),
						          es.getEstado(), des.getDatoVariado(), 
						          des.getObservacion(), idexpsancion);
					
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	// Listar Pendientes
	// JCEV 19-09-2012 Actualizado con idInfractor
	public List<Expediente> listarPaginado(Expediente expediente, int offset, int tamaniopagina){
		return expedienteDAO.listarPaginadoSubConsulta(expediente, offset, tamaniopagina);
	}
	
	public List<Expediente> listarPaginadoxNDoc(Expediente expediente, String ndoc){
		return expedienteDAO.listarPaginadoSubConsultaxNDoc(expediente, ndoc);
	}
	
	public List<Expediente> listarXNumDoc(Expediente expediente){
		return expedienteDAO.listarXNumDoc(expediente);
	}	
	
	// Cuando ya existe la Persona - 18-09-2012
	public void insertUpdate(Expediente exp, int idInfractor){
		
		int idResolucion  = 0;
		int idAreaNatural = 0;
		int idExpediente  = 0;
		
		try {
			// Insertamos resolucion
			idResolucion = resolucionDAO.insertar(exp);
			
			// Obtenemos el idAreaNatural
			idAreaNatural = exp.getIdareanatural();
			
			// JCEV 17-09-2012 Grabamos el Expediente
			idExpediente = expedienteDAO.insertar_ExpedienteInfractor(idInfractor, idResolucion, idAreaNatural);

			// Grabamos las infracciones
			for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
				if(ei!=null){
				   expedienteInfraccionDAO.insertaExpedienteInfraccion(idExpediente, 
						                                               ei.getInfraccion().getIdinfraccion(), 
							                                           ei.getReincidencia());						
				}
			}
			
	        // Grabamos listamos las Sanciones x Expediente y su Detalle
			for(ExpedienteSancion es : exp.getListaExpedienteSancion()){					
				int idexpsancion = expedienteSancionDAO.insertarExpedienteSancion(idExpediente, 
														       es.getSancion().getIdsancion(),
														       es.getEstado());
				
				// Creando el DetalleExpedienteSancion
				//for(DetalleExpedienteSancion des : es.getListaDetalleExpedienteSancion()){
				DetalleExpedienteSancion des = es.getDetalleExpedienteSancion();
//					System.out.println("Exp. Detalle : " + idExpediente + " - " + 
//				                                           es.getSancion().getIdsancion() + " - " + 
//				                                           es.getEstado() + " - " +  
//				                                           des.getDatoVariado() + " - " + 
//				                                           des.getObservacion());
					
					expedienteSancionDAO.insertarDetalleExpedienteSancion(idExpediente, es.getSancion().getIdsancion(),
					          es.getEstado(), des.getDatoVariado(), 
					          des.getObservacion(), idexpsancion);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//OTRA OPCION
	public void oinsertar(Expediente exp, int idPersNatu){
		
		int idResolucion  = 0;
		int idAreaNatural = 0;
		int idExpediente  = 0;
		//insertamos infractor:
		//int idInfractor = idInfracc;
		//System.out.println("ID INFRACTOR : "+idInfractor);
		
		
		//insertamos resolucion
		try {
			idResolucion = resolucionDAO.insertar(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("ID RESOLUCION : "+idResolucion);
		//insertamos multa
		
		// JCEV 17-09-2012 por verificar
//		int idMulta= multaDAO.insertar(exp);
		
		//System.out.println("ID MULTA : "+ idMulta);
		
		//obtenemos el areanatural
		idAreaNatural = exp.getIdareanatural();
		
		//insertamo el expediente
		// JCEV 17-09-2012 por verificar
//		int idExpediente= expedienteDAO.insertar(idPersNatu, idResolucion, idMulta,idareanatural);

//		listamos las infracciones
		//System.out.println("CODIGOS DE INFRACCIONES");
		for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
			if(ei!=null){
			//System.out.println("codigo:"+ei.getInfraccion().getIdinfraccion());
				expedienteInfraccionDAO.insertar(exp.getIdexpediente(),ei.getInfraccion().getIdinfraccion(),ei.getReincidencia());
				// JCEV 17-09-2012 por verificar
//				expedienteInfraccionDAO.insertar(exp. idExpediente,ei.getInfraccion().getIdinfraccion(),ei.getReincidencia());
			}
			/*
			else{
				System.out.println(" : (");
			}*/
		}
		
//		listamos las infracciones
		//System.out.println("CODIGOS DE SANCIONES");
		for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
			if(es!=null){
			//System.out.println("codigo :"+es.getSancion().getIdsancion()+" / "+"observacion :"+es.getObservacion());
			
				// JCEV 17-09-2012 por verificar
				// expedienteSancionDAO.insertar(idExpediente, es.getSancion().getIdsancion(),es.getObservacion());
			
			}
			/*
			else{
				System.out.println(" : (");
			}*/
		}		
	}	
	
	//ACTUALIZAR
	public void actualizar(Expediente exp){
		
		int idexpediente= exp.getIdexpediente();

		//infractorDAO.actualizar(exp);
		
		//actualizamos la resolucion
		resolucionDAO.actualizar(exp);
		
		//actualizamos la multa
		/*
		System.out.println("verificando la actualizacion de datos de multa");
		System.out.println("idmulta :"+exp.getMulta().getIdmulta());
		System.out.println("montomulta : "+ exp.getMulta().getMontomulta());
		System.out.println("estado multa : "+exp.getMulta().getEstadomulta());
		*/				
		expedienteInfraccionDAO.eliminar(exp);		
		for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
			if(ei!=null){
				expedienteInfraccionDAO.insertar(idexpediente,ei.getInfraccion().getIdinfraccion(),ei.getReincidencia());
			}
		}
		//eliminamos los expedientesancion
		expedienteSancionDAO.eliminar(exp);
		//multaDAO.eliminar(exp);
		
//		agregamos nuevamente el expedienteinfraccion listaExpedienteSancion
		//System.out.println("entrando a lfor de sanciones");
		
		for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
			if(es!=null){			
				if(es.getSancion().getIdsancion() == 1){				
				// JCEV 17-09-2012 por verificar
//				es.getExpediente().getMulta().setIdmulta(exp.getMulta().getIdmulta());			
//				multaDAO.actualizar(es);
				}						
				// JCEV 17-09-2012 por verificar
				// expedienteSancionDAO.insertar(idexpediente, es.getSancion().getIdsancion(),es.getSancion().getObservacion());
			}
		}						
	}
		
	public Expediente obtenerXID(Expediente expediente){
		List<Expediente>lista = new ArrayList<Expediente>();
		lista = expedienteDAO.ObtenerXID(expediente);
		
		if(lista.size()==1){
			expediente= lista.get(0);
								
		//listamos las infracciones;
		List<Infraccion> listaInfracciones = new ArrayList<Infraccion>();
		listaInfracciones= infraccionDAO.listarXExpediente(expediente.getIdexpediente());
		
		//listamos las sanciones;
		//List<Sancion> listaSanciones  = new ArrayList<Sancion>();		
		//listaSanciones= sancionDAO.listarXExpediente(expediente.getIdexpediente());
		
		List<ExpedienteSancion> listaExpSanciones  = new ArrayList<ExpedienteSancion>();
		listaExpSanciones= sancionDAO.listarExpedienteSancion(expediente.getIdexpediente());
		
		//agregamos expediente infraccion
		for(int i=0;i<listaInfracciones.size();i++){
			
			int idinfraccion=listaInfracciones.get(i).getIdinfraccion();
			String descripcionInfraccion =listaInfracciones.get(i).getDescripcioninfraccion();
			String codigoInfraccion= listaInfracciones.get(i).getCodigoinfraccion();
			int reincidenciaInfraccion = listaInfracciones.get(i).getReincidencia();			
			
			ExpedienteInfraccion ei = new ExpedienteInfraccion();
			ei.getInfraccion().setIdinfraccion(idinfraccion);
			ei.getInfraccion().setDescripcioninfraccion(descripcionInfraccion);
			ei.getInfraccion().setCodigoinfraccion(codigoInfraccion);
			ei.getInfraccion().setReincidencia(reincidenciaInfraccion);															
			expediente.getListaExpedienteInfraccion().add(ei);
			
		}
		
		//agregamos expediente sancion
		/*
		for(int i=0;i<listaSanciones.size();i++){
			
			int idsancion=listaSanciones.get(i).getIdsancion();
			String descripcionSancion =listaSanciones.get(i).getDescripcionsancion();
			String observacionSancion = listaSanciones.get(i).getObservacion();
						
			ExpedienteSancion es = new ExpedienteSancion();
			es.getSancion().setIdsancion(idsancion);
			es.getSancion().setDescripcionsancion(descripcionSancion);
			es.getSancion().setObservacion(observacionSancion);
			
			if(es.getExpediente().getIdexpediente() == expediente.getIdexpediente())
				es.getExpediente().getMulta().setMontomulta(expediente.getMulta().getMontomulta());
			
			expediente.getListaExpedienteSancion().add(es);
		}*/
		
		for(int i=0;i<listaExpSanciones.size();i++){
			
			int idsancion=listaExpSanciones.get(i).getSancion().getIdsancion();
			String descripcionSancion =listaExpSanciones.get(i).getSancion().getDescripcionsancion();
			
			// JCEV 17-09-2012 por verificar
			// String observacionSancion = listaExpSanciones.get(i).getObservacion();
						
			ExpedienteSancion es = new ExpedienteSancion();
			es.getSancion().setIdsancion(idsancion);
			es.getSancion().setDescripcionsancion(descripcionSancion);
			
			// JCEV 17-09-2012 por verificar
			// es.getSancion().setObservacion(observacionSancion);						
			int idExp = listaExpSanciones.get(i).getExpediente().getIdexpediente();			
			if(idExp == expediente.getIdexpediente()){
				// JCEV 17-09-2012 por verificar
				// es.getExpediente().getMulta().setMontomulta(expediente.getMulta().getMontomulta());
				// es.getExpediente().getMulta().setEstadomulta(expediente.getMulta().getEstadomulta());
			}			
			expediente.getListaExpedienteSancion().add(es);
		}				
		return expediente;		
		}else{
			System.out.println("se obtuvo mas de un expediente");
			return null;
		}
	}	
	
//	ESTE METODO SERA PARA GESTIONAR LA PAGINACION
	public Pagination calcularPaginacion(Expediente expediente,int tamanio,int numeropagina){	
//		recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
		int total             = expedienteDAO.contarPaginadoXNumDoc(expediente);
		Pagination paginacion = new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
		
	public Pagination calcularPaginacionTotal(Expediente expediente,int tamanio,int numeropagina){
		//System.out.println("entro a calcular Paginacion Total");
//		recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
		int total             = expedienteDAO.contarPaginado(expediente);
		Pagination paginacion = new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
	
	public Pagination calcularPaginacionTotalxNDoc(Expediente expediente, String ndoc){

		int total             = expedienteDAO.contarPaginadoxNDoc(expediente, ndoc);		
		Pagination paginacion = new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(0);
		paginacion.paginar1();
		return paginacion;
	}
				
	//	SEGUNDO METODO PARA PAGINACION
	public List<Expediente> consultarExpedientePaginado(Expediente expediente,int offset, int tamaniopagina){
		return expedienteDAO.listarPaginadoSubConsultaXNumDoc(expediente, offset, tamaniopagina);
	}

	//public int updateMorosidadExpediente(int nIdExpediente){
	public int updateMorosidadExpediente(Expediente exp, Archivo af){
		int nIdFlagMorosidad = 0;
		try {
			//nIdFlagMorosidad = expedienteDAO.updateMorosidadXExpediente(nIdExpediente);
			nIdFlagMorosidad = expedienteDAO.updateMorosidadXExpediente(exp, af);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nIdFlagMorosidad;
	}
	
	// JCEV 21-10-2012, actualizado 24-10-2012 (ayuda de Yonny Coyla)
	public int updateStatusFile(Expediente exp, int nUser){
		int nUpdate = 0;
		try {
			//System.out.println("02. updateStatusFile");
			nUpdate = expedienteDAO.updateStatusFile(exp, nUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nUpdate;
	}


	
}