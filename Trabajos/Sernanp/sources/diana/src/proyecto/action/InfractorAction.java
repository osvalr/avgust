package proyecto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import proyecto.service.ArchivoService;
import proyecto.service.AreaNaturalService;
import proyecto.service.CategoriaAnpService;
import proyecto.service.DetalleExpedienteSancionService;
import proyecto.service.DirectorioArchivoService;
import proyecto.service.ExpedienteSancionService;
import proyecto.service.ExpedienteService;
import proyecto.service.InfraccionService;
import proyecto.service.InfractorService;
import proyecto.service.SancionService;
import proyecto.service.TipoService;
import proyecto.util.Pagination;
import proyecto.vo.Archivo;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.Directorioarchivo;
import proyecto.vo.Expediente;
import proyecto.vo.ExpedienteInfraccion;
import proyecto.vo.ExpedienteSancion;
import proyecto.vo.Infraccion;
import proyecto.vo.Infractor;
import proyecto.vo.Sancion;
import proyecto.vo.Tipo;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InfractorAction extends ActionSupport{
		
		private static final long serialVersionUID = 1L;

		@Autowired
		private InfractorService infractorService;	
		
		@Autowired
		private InfraccionService infraccionService;	
		
		@Autowired
		private SancionService sancionService;	
		
		@Autowired  
		private DirectorioArchivoService directorioArchivoService;
		
		@Autowired
		private ArchivoService archivoService;
		
		@Autowired
		private ExpedienteService expedienteService;
		
		@Autowired
		private TipoService tipoService;

		// JCEV 18-09-2012
		@Autowired
		private ExpedienteSancionService expedientesancionService;
		
		@Autowired
		private DetalleExpedienteSancionService detalleExpedienteSancionService;
		
		
		//09-05-2013
		@Autowired
		private AreaNaturalService areanaturalService;
		
		@Autowired
		private CategoriaAnpService categoriaanpService;
		
		
		private Categoriaanp categoriaanp;
		private Areanatural areanatural;
		
		private Expediente expediente;
		
		// Para recibir la cadena de la Lista de Infracciones
		private String cadIds;	
		private int arrayCadIds[];
		
		private File file;
		private String fileFileName;
		private String fileContentType;
		
		//APRA LA PAGINACION
		private Pagination paginacion ;
		private int numeropagina;
		
		/**************************************************************/
		//para recibir el dni
		private Map<String,Object> datos;
		private Map<String,Object> datosInfracciones;
//		private Map<String,Object> datosListaInfractores;
		
		private String dniRecibido;
		private Infractor infractorPantalla;
		
		// JCEV 17-10-2012
		private Infractor personalPantalla;
		
		/**/
		private List<Infraccion> listaInfraccionesAntiguasPantalla;
		private String idInfractorAyuda;
		private String idPersonaNatural;
		
		/**************************************************************/
		/**PARA EL LISTADO**/
		private List<Tipo> listaEstadoMulta;
		private List<Expediente> listaExpedientes;
//		private List<ExpedienteInfraccion> listaExpedientesInfracciones ;
		private List<ExpedienteSancion>    listaExpedienteSancion;
		
		private List<Infraccion> listaInfracciones;
		private List<Sancion> listaSanciones;
		private List<Directorioarchivo> listaDirectorios;				
		
		/***************************************************************/
		
		//09-05-2013
		private List<Categoriaanp> listacategoriaanp;
		
		private List<Areanatural> listaareanatural;
		
		
		
		// PAR LA BUSQUEDA
		private String numeroDocRecibido;
		
		/***************************************************************/
		// PARA LA EDICION
		private String paramIdExpediente;

		
		// PARA DESCARGAR ARCHIVOS
		private InputStream fileInputStream;
		 
		public InputStream getFileInputStream() {
			return fileInputStream;
		}
		
		public String descargaArchivoExpediente() throws Exception {		
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);			
			int idarchivo              = Integer.valueOf(request.getParameter("idarchivo"));			
			Archivo af                 = archivoService.consultarArchivoxId(idarchivo);
			fileFileName               = af.getNombregenerado();
			fileContentType            = af.getMimearchivo();
			String uri                 = af.getDirectorioarchivo().getDirdirectorio()+af.getNombregenerado();
		    fileInputStream            = new FileInputStream(new File(uri));
		    return SUCCESS;
		}
		
		public InfractorAction(){
			categoriaanp                      = new Categoriaanp();
			areanatural 					  = new Areanatural();
			listaInfracciones                 = new ArrayList<Infraccion>();
			listaSanciones                    = new ArrayList<Sancion>();
			expediente                        = new Expediente();
			arrayCadIds                       = new int[20];
			infractorPantalla                 = new Infractor();
			datos                             = new HashMap<String, Object>();			
			datosInfracciones                 = new HashMap<String, Object>();
			listaInfraccionesAntiguasPantalla = new ArrayList<Infraccion>();
			listaSanciones                    = new ArrayList<Sancion>();
			listaExpedientes                  = new ArrayList<Expediente>();
			listaEstadoMulta                  = new ArrayList<Tipo>();			
			paginacion                        = new Pagination();
//			datosListaInfractores = new HashMap<String, Object>();
//			listaExpedientesInfracciones = new ArrayList<ExpedienteInfraccion>();
//			listaExpedientesSanciones = new ArrayList<ExpedienteSancion>();
		}

		public String listarInfracciones(){
			//cadIds=cadIds.substring(2);
			listaInfracciones      = infractorService.listarInfracciones();			
		    StringTokenizer tokens = new StringTokenizer(cadIds,"-");  
		    int i                  = 0;		    	
		    while(tokens.hasMoreTokens()){  
		    	int auc = Integer.parseInt(tokens.nextToken());
		    	i       = auc - 1;		    	
		    	if(i<listaInfracciones.size()){
		    		listaInfracciones.get(i).setCheckeado(auc);
		    	}
		    }		    
		    
			return SUCCESS;
		}
		
		//NAVEGACION
		
		//nuevo infractor
		public String nuevoInfractor(){
			//listaInfracciones = infractorService.listarInfracciones();
			Map<String, Object> session = ActionContext.getContext().getSession();
			areanatural = (Areanatural) session.get("area");
			
			listaSanciones = infractorService.listarSanciones();			
			return SUCCESS;
		}
		
		public String moduloListado(){
			listarInfractores();
			return SUCCESS;
		}		
		
		// JCEV 18-09-2012 Nueva Version del Listado de Infractores
		// JCEV 04-10-2012 Actualizado para colocar la reicidencia y Morosidad
		public String listarInfractores(){
		
			Map<String, Object> session               = null;
			Usuario u                                 = null;
			ResourceBundle labels                     = null;
			List<Infraccion> listaInfracciones        = null;
			List<ExpedienteSancion> listaExpSanciones = null;
			List<Infraccion> alInf                    = null;
			ExpedienteInfraccion ei                   = null;
			ExpedienteSancion es                      = null;
		    String tamPagina                          = null;
			String descripcionSancion                 = null;
			String datavariadoSancion                 = null;
			String observacionSancion                 = null;
			String descripcionInfraccion              = null;
			String codigoInfraccion                   = null;
			String strMoroso                          = null;
			String strFin                             = null;
		    int tamanio                               = 0;
			int indice                                = 0;
			int idsancion                             = 0;
			int idinfraccion                          = 0;
			int idInfractor                           = 0;
			int nIdExpediente                         = 0;
			int reincidenciaInfraccion                = 0;					
			try {
				strFin    = SUCCESS;
				session   = ActionContext.getContext().getSession();
				u         = (Usuario) session.get("USUARIO_ACTUAL");
				labels    = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
			    tamPagina = labels.getString("tamanio_pagina");
			    tamanio   = Integer.parseInt(tamPagina);
			    if(numeropagina == 0){
			    	numeropagina = 1;
			    }
			    // para determinar el Tipo de Persona (Natural o Juridica)
			    //idInfractor      = expediente.getInfractor().getIdinfractor();
			    
				expediente.setIdareanatural(u.getAreaorganica().getSede().getAreanatural().getIdareanatural());
				indice           = ((numeropagina-1) * tamanio);
				paginacion       = expedienteService.calcularPaginacionTotal(expediente, tamanio, numeropagina);
				
				// En este punto, hay que ver si es Persona Natural o Juridico 
				listaExpedientes = expedienteService.listarPaginado(expediente, indice, tamanio);
				
				// Actualiza la Morosidad de cada Registro de la Matriz
				for(int i= 0; i< listaExpedientes.size(); i++){
					Expediente e  = listaExpedientes.get(i);
					nIdExpediente = e.getIdexpediente();
					strMoroso     = expedientesancionService.determinaMorocidadResolucionExpediente(nIdExpediente);
					e.setMorosidad(strMoroso);
				}
												
				for(Expediente exp : listaExpedientes){

					// JCEV 04-10-2012
					idInfractor      = exp.getInfractor().getIdinfractor();
					
					// Listar Infracciones
					listaInfracciones = new ArrayList<Infraccion>();
					listaInfracciones = infraccionService.listarXExpediente(exp.getIdexpediente());					
					for(int i=0;i<listaInfracciones.size();i++){
						idinfraccion            = listaInfracciones.get(i).getIdinfraccion();
						descripcionInfraccion   = listaInfracciones.get(i).getDescripcioninfraccion();
						codigoInfraccion        = listaInfracciones.get(i).getCodigoinfraccion();
						
						// JCEV 04-10-2012 Version Antiguo
						// reincidenciaInfraccion  = listaInfracciones.get(0).getReincidencia();					
						
						// JCEV 04-10-2012 Version Nueva
						// Realiza una Consulta para saber la Reinidencia
						
						// Por defecto vale 1 la Reincidencia
						reincidenciaInfraccion  = 1;
						alInf                   = infraccionService.contarReinidenciaXInfraccion(idInfractor, idinfraccion);
						if(alInf.size()>0){
							for(Infraccion x : alInf){
								if(idinfraccion == x.getIdinfraccion()){
									reincidenciaInfraccion = x.getReincidencia();
									break;
								}
							}
						}
						ei = new ExpedienteInfraccion();
						ei.getInfraccion().setIdinfraccion(idinfraccion);
						ei.getInfraccion().setDescripcioninfraccion(descripcionInfraccion);
						ei.getInfraccion().setCodigoinfraccion(codigoInfraccion);
						ei.getInfraccion().setReincidencia(reincidenciaInfraccion);		
						exp.getListaExpedienteInfraccion().add(ei);
					}				

					// Numero de Expediente
					nIdExpediente     = exp.getIdexpediente();
					
					// JCEV 04-10-2012, Determinar si es Moroso o No!!
//					strMoroso        = expedientesancionService.determinaMorocidadResolucionExpediente(nIdExpediente);
//					expediente.setMorosidad(strMoroso);
							
					// Listar ExpedienteSancion
					listaExpSanciones = new ArrayList<ExpedienteSancion>();
					listaExpSanciones = expedientesancionService.listarExpedienteSancion(nIdExpediente);
					
															
					for(int i=0;i<listaExpSanciones.size();i++){
						idsancion          = listaExpSanciones.get(i).getSancion().getIdsancion();						
						descripcionSancion = listaExpSanciones.get(i).getSancion().getDescripcionsancion();
						
						datavariadoSancion = listaExpSanciones.get(i).getDetalleExpedienteSancion().getDatoVariado();
						observacionSancion = listaExpSanciones.get(i).getDetalleExpedienteSancion().getObservacion();
								
						
						es                 = new ExpedienteSancion();
						es.getSancion().setIdsancion(idsancion);
						es.getSancion().setDescripcionsancion(descripcionSancion);
						// es.getSancion().setMorosidad(strMoroso);
						
						es.getDetalleExpedienteSancion().setDatoVariado(datavariadoSancion);
						es.getDetalleExpedienteSancion().setObservacion(observacionSancion);						
						
						exp.getListaExpedienteSancion().add(es);
					}
					
				}
			} catch (Exception e) {
				strFin = ERROR;
				e.printStackTrace();
			}			
			return strFin;
		}
		
		
		// JCEV 11-10-2012 Nueva Version
		public String listarInfractoresXDocumento(){
			
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);	
			
			Map<String, Object> session               = null;
			Usuario u                                 = null;
			ResourceBundle labels                     = null;
			List<Infraccion> listaInfracciones        = null;
			List<ExpedienteSancion> listaExpSanciones = null;
			List<Infraccion> alInf                    = null;
			ExpedienteInfraccion ei                   = null;
			ExpedienteSancion es                      = null;
		    String tamPagina                          = null;
			String descripcionSancion                 = null;
			String datavariadoSancion                 = null;
			String observacionSancion                 = null;
			String descripcionInfraccion              = null;
			String codigoInfraccion                   = null;
			String strMoroso                          = null;
			String strFin                             = null;
		    int tamanio                               = 0;
			int indice                                = 0;
			int idsancion                             = 0;
			int idinfraccion                          = 0;
			int idInfractor                           = 0;
			int nIdExpediente                         = 0;
			int reincidenciaInfraccion                = 0;
			String NDoc	= null;
			try {
				strFin    = SUCCESS;
				session   = ActionContext.getContext().getSession();
				u         = (Usuario) session.get("USUARIO_ACTUAL");
				//labels    = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
			    //tamPagina = labels.getString("tamanio_pagina");
			    //tamanio   = Integer.parseInt(tamPagina);
			    //if(numeropagina == 0){
			    	//numeropagina = 1;
			    //}
			    // para determinar el Tipo de Persona (Natural o Juridica)
			    //idInfractor      = expediente.getInfractor().getIdinfractor();
			    
				expediente.setIdareanatural(u.getAreaorganica().getSede().getAreanatural().getIdareanatural());
				//indice           = ((numeropagina-1) * tamanio);
								
				NDoc = request.getParameter("dniRecibido");
				
				ServletActionContext.getRequest().setAttribute("NDOC", NDoc);
				
				paginacion       = expedienteService.calcularPaginacionTotalxNDoc(expediente, NDoc);
				
				// En este punto, hay que ver si es Persona Natural o Juridico				
				listaExpedientes = expedienteService.listarPaginadoxNDoc(expediente, NDoc);
				
				// Actualiza la Morosidad de cada Registro de la Matriz
				for(int i= 0; i< listaExpedientes.size(); i++){
					Expediente e  = listaExpedientes.get(i);
					nIdExpediente = e.getIdexpediente();
					strMoroso     = expedientesancionService.determinaMorocidadResolucionExpediente(nIdExpediente);
					e.setMorosidad(strMoroso);
				}
												
				for(Expediente exp : listaExpedientes){

					// JCEV 04-10-2012
					idInfractor      = exp.getInfractor().getIdinfractor();
					
					// Listar Infracciones
					listaInfracciones = new ArrayList<Infraccion>();
					listaInfracciones = infraccionService.listarXExpediente(exp.getIdexpediente());					
					for(int i=0;i<listaInfracciones.size();i++){
						idinfraccion            = listaInfracciones.get(i).getIdinfraccion();
						descripcionInfraccion   = listaInfracciones.get(i).getDescripcioninfraccion();
						codigoInfraccion        = listaInfracciones.get(i).getCodigoinfraccion();
						
						// JCEV 04-10-2012 Version Antiguo
						// reincidenciaInfraccion  = listaInfracciones.get(0).getReincidencia();					
						
						// JCEV 04-10-2012 Version Nueva
						// Realiza una Consulta para saber la Reinidencia
						
						// Por defecto vale 1 la Reincidencia
						reincidenciaInfraccion  = 1;
						alInf                   = infraccionService.contarReinidenciaXInfraccion(idInfractor, idinfraccion);
						if(alInf.size()>0){
							for(Infraccion x : alInf){
								if(idinfraccion == x.getIdinfraccion()){
									reincidenciaInfraccion = x.getReincidencia();
									break;
								}
							}
						}
						ei = new ExpedienteInfraccion();
						ei.getInfraccion().setIdinfraccion(idinfraccion);
						ei.getInfraccion().setDescripcioninfraccion(descripcionInfraccion);
						ei.getInfraccion().setCodigoinfraccion(codigoInfraccion);
						ei.getInfraccion().setReincidencia(reincidenciaInfraccion);		
						exp.getListaExpedienteInfraccion().add(ei);
					}				

					// Numero de Expediente
					nIdExpediente     = exp.getIdexpediente();
					
					// JCEV 04-10-2012, Determinar si es Moroso o No!!
//					strMoroso        = expedientesancionService.determinaMorocidadResolucionExpediente(nIdExpediente);
//					expediente.setMorosidad(strMoroso);
							
					// Listar ExpedienteSancion
					listaExpSanciones = new ArrayList<ExpedienteSancion>();
					listaExpSanciones = expedientesancionService.listarExpedienteSancion(nIdExpediente);
					
															
					for(int i=0;i<listaExpSanciones.size();i++){
						idsancion          = listaExpSanciones.get(i).getSancion().getIdsancion();						
						descripcionSancion = listaExpSanciones.get(i).getSancion().getDescripcionsancion();
						
						datavariadoSancion = listaExpSanciones.get(i).getDetalleExpedienteSancion().getDatoVariado();
						observacionSancion = listaExpSanciones.get(i).getDetalleExpedienteSancion().getObservacion();
								
						
						es                 = new ExpedienteSancion();
						es.getSancion().setIdsancion(idsancion);
						es.getSancion().setDescripcionsancion(descripcionSancion);
						// es.getSancion().setMorosidad(strMoroso);
						
						es.getDetalleExpedienteSancion().setDatoVariado(datavariadoSancion);
						es.getDetalleExpedienteSancion().setObservacion(observacionSancion);						
						
						exp.getListaExpedienteSancion().add(es);
					}
					
				}
			} catch (Exception e) {
				strFin = ERROR;
				e.printStackTrace();
			}			
			return strFin;
		}

		
		//Agregado 08-05-2013 16:01 (Y.C.)
		public String listarInfractoresxAnp(){
			
			Map<String, Object> session               = null;
			//Usuario u                                 = null;
			ResourceBundle labels                     = null;
			List<Infraccion> listaInfracciones        = null;
			List<ExpedienteSancion> listaExpSanciones = null;
			List<Infraccion> alInf                    = null;
			ExpedienteInfraccion ei                   = null;
			ExpedienteSancion es                      = null;
		    String tamPagina                          = null;
			String descripcionSancion                 = null;
			String datavariadoSancion                 = null;
			String observacionSancion                 = null;
			String descripcionInfraccion              = null;
			String codigoInfraccion                   = null;
			String strMoroso                          = null;
			String strFin                             = null;
		    int tamanio                               = 0;
			int indice                                = 0;
			int idsancion                             = 0;
			int idinfraccion                          = 0;
			int idInfractor                           = 0;
			int nIdExpediente                         = 0;
			int reincidenciaInfraccion                = 0;					
			try {				
				
				listacategoriaanp = categoriaanpService.listarCategoriasAnps();								
				listaareanatural = areanaturalService.listarAreasNaturalesxCtg(categoriaanp);				
								
				strFin    = SUCCESS;
				session   = ActionContext.getContext().getSession();
				//u         = (Usuario) session.get("USUARIO_ACTUAL");
				labels    = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
			    tamPagina = labels.getString("tamanio_pagina");
			    tamanio   = Integer.parseInt(tamPagina);
			    if(numeropagina == 0){
			    	numeropagina = 1;
			    }
			    // para determinar el Tipo de Persona (Natural o Juridica)
			    //idInfractor      = expediente.getInfractor().getIdinfractor();
			    
			    areanatural.setCategoriaanp(categoriaanp);			    
			    expediente.setAreanatural(areanatural);
			    
				expediente.setIdareanatural(areanatural.getIdareanatural());
				
				indice           = ((numeropagina-1) * tamanio);
				paginacion       = expedienteService.calcularPaginacionTotal(expediente, tamanio, numeropagina);
				
				// En este punto, hay que ver si es Persona Natural o Juridico 
				listaExpedientes = expedienteService.listarPaginado(expediente, indice, tamanio);
				
				// Actualiza la Morosidad de cada Registro de la Matriz
				for(int i= 0; i< listaExpedientes.size(); i++){
					Expediente e  = listaExpedientes.get(i);
					nIdExpediente = e.getIdexpediente();
					strMoroso     = expedientesancionService.determinaMorocidadResolucionExpediente(nIdExpediente);
					e.setMorosidad(strMoroso);
				}
												
				for(Expediente exp : listaExpedientes){

					// JCEV 04-10-2012
					idInfractor      = exp.getInfractor().getIdinfractor();
					
					// Listar Infracciones
					listaInfracciones = new ArrayList<Infraccion>();
					listaInfracciones = infraccionService.listarXExpediente(exp.getIdexpediente());					
					for(int i=0;i<listaInfracciones.size();i++){
						idinfraccion            = listaInfracciones.get(i).getIdinfraccion();
						descripcionInfraccion   = listaInfracciones.get(i).getDescripcioninfraccion();
						codigoInfraccion        = listaInfracciones.get(i).getCodigoinfraccion();
						
						// JCEV 04-10-2012 Version Antiguo
						// reincidenciaInfraccion  = listaInfracciones.get(0).getReincidencia();					
						
						// JCEV 04-10-2012 Version Nueva
						// Realiza una Consulta para saber la Reinidencia
						
						// Por defecto vale 1 la Reincidencia
						reincidenciaInfraccion  = 1;
						alInf                   = infraccionService.contarReinidenciaXInfraccion(idInfractor, idinfraccion);
						if(alInf.size()>0){
							for(Infraccion x : alInf){
								if(idinfraccion == x.getIdinfraccion()){
									reincidenciaInfraccion = x.getReincidencia();
									break;
								}
							}
						}
						ei = new ExpedienteInfraccion();
						ei.getInfraccion().setIdinfraccion(idinfraccion);
						ei.getInfraccion().setDescripcioninfraccion(descripcionInfraccion);
						ei.getInfraccion().setCodigoinfraccion(codigoInfraccion);
						ei.getInfraccion().setReincidencia(reincidenciaInfraccion);		
						exp.getListaExpedienteInfraccion().add(ei);
					}				

					// Numero de Expediente
					nIdExpediente     = exp.getIdexpediente();
					
					// JCEV 04-10-2012, Determinar si es Moroso o No!!
//					strMoroso        = expedientesancionService.determinaMorocidadResolucionExpediente(nIdExpediente);
//					expediente.setMorosidad(strMoroso);
							
					// Listar ExpedienteSancion
					listaExpSanciones = new ArrayList<ExpedienteSancion>();
					listaExpSanciones = expedientesancionService.listarExpedienteSancion(nIdExpediente);
					
															
					for(int i=0;i<listaExpSanciones.size();i++){
						idsancion          = listaExpSanciones.get(i).getSancion().getIdsancion();						
						descripcionSancion = listaExpSanciones.get(i).getSancion().getDescripcionsancion();
						
						datavariadoSancion = listaExpSanciones.get(i).getDetalleExpedienteSancion().getDatoVariado();
						observacionSancion = listaExpSanciones.get(i).getDetalleExpedienteSancion().getObservacion();
								
						
						es                 = new ExpedienteSancion();
						es.getSancion().setIdsancion(idsancion);
						es.getSancion().setDescripcionsancion(descripcionSancion);
						// es.getSancion().setMorosidad(strMoroso);
						
						es.getDetalleExpedienteSancion().setDatoVariado(datavariadoSancion);
						es.getDetalleExpedienteSancion().setObservacion(observacionSancion);						
						
						exp.getListaExpedienteSancion().add(es);
					}
					
				}			
				
			} catch (Exception e) {
				strFin = ERROR;
				e.printStackTrace();
			}			
			return strFin;
		}
		
		
		//ACTUALIZA INFRACTOR
		
		public String actualizarInfractor(){		
		/*****************************************************************/
		/**OJO CON ESTO--ESTE METODO LIMPIA LOS REGISTROS VACIOS---IMLPEMENTAR EN PROYECTO**/
			//listaExpedienteSancion.removeAll(Collections.singleton(null));
		/*****************************************************************/
					
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
			
			int idmod = Integer.parseInt(session.get("idmoduloactual").toString());
			
			Directorioarchivo directorio = new Directorioarchivo();
			directorio = directorioArchivoService.obtener(idmod);
			
			String rutaRepositorio="";
			rutaRepositorio= directorio.getDirdirectorio();
			
			int idarchivo = Integer.valueOf(request.getParameter("idarchivo"));
			
			String nameInst="";		
			Archivo af = null;
			
			if(file!=null){

				
				af = new Archivo();
				
			 //expediente.getResolucion().getArchivo().setNombreinicial(fileFileName);
				af.setNombreinicial(fileFileName);
			 
			 Date instante=new Date();
			 long inst =instante.getTime();
			 int pos=fileFileName.lastIndexOf('.');
			  
			 String ext=fileFileName.substring(pos);
			 fileFileName=inst+ext;
			 
			 //expediente.getResolucion().getArchivo().setNombregenerado(fileFileName);
			 af.setNombregenerado(fileFileName);
			 
			 nameInst=String.valueOf(inst);
			 File archivoGuardado = new File(rutaRepositorio, fileFileName);
			 file.renameTo(archivoGuardado);
			 //String extension[] = fileContentType.split("/");
			 
			 //expediente.getResolucion().getArchivo().setMimearchivo(extension[1]);
			 //af.setMimearchivo(extension[1]);
			 af.setMimearchivo(fileContentType);
			 
			 //expediente.getResolucion().getArchivo().getDirectorioarchivo().setIddirectorioarchivo(directorio.getIddirectorioarchivo());
			 af.getDirectorioarchivo().setIddirectorioarchivo(directorio.getIddirectorioarchivo());
			
			 if(idarchivo != 0){
					archivoService.actualizaEstadoArchivo(idarchivo);
				}
			}
			expediente.getResolucion().setArchivo(af);
			expedienteService.actualizar(expediente);		
			//}//fin else	
			return SUCCESS;
		
		}
		
		// JCEV - 21/08/2012 Registro de infractor, actualizado 13/09/2012
		public String registrarInfractor(){
			Map<String, Object> session  = null;
			Usuario u                    = null;
			File archivoGuardado         = null;
			Directorioarchivo directorio = null;
			String rutaRepositorio       = null;
//			String nameInst              = null;
			String ext                   = null;
			String strRet                = null;
			Archivo af 	  			     = null;
		    Date instante 			     = null;
			long inst                    = 0L;
			int idmod                    = 0;
			int idInFractor              = 0;
		    int pos                      = 0;
			try {
				strRet = SUCCESS;
//				strRet          = ERROR;
				session    		= ActionContext.getContext().getSession();
				u          		= (Usuario) session.get("USUARIO_ACTUAL");
				idmod      		= Integer.parseInt(session.get("idmoduloactual").toString());
				directorio 		= new Directorioarchivo();
				directorio 		= directorioArchivoService.obtener(idmod);
				rutaRepositorio = directorio.getDirdirectorio();
				if(file != null){				
					af              = new Archivo();
					af.setNombreinicial(fileFileName);
				    instante        = new Date();
				    inst            = instante.getTime();
				    pos             = fileFileName.lastIndexOf('.');
				    ext             = fileFileName.substring(pos);
				    fileFileName    = inst + ext;				 
//					System.out.println("rutaRepositorio : " + rutaRepositorio);
//					System.out.println("archivo         : " + fileFileName);
				    af.setNombregenerado(fileFileName);				 
//				    nameInst        = String.valueOf(inst);
				    
				    archivoGuardado = new File(rutaRepositorio, fileFileName);
				    //file.renameTo(archivoGuardado);
				    
				    try {
						FileUtils.copyFile(file, archivoGuardado);
					} catch (Exception ex) {ex.printStackTrace();
					
					}
				    af.setMimearchivo(fileContentType);
				    af.getDirectorioarchivo().setIddirectorioarchivo(directorio.getIddirectorioarchivo());				 
				}				
//				System.out.println("Datos de registrarInfractor (InfractorAction.java) : " + u.getAreaorganica().getSede().getAreanatural().getIdareanatural());
				expediente.getResolucion().setArchivo(af);				
				expediente.setIdareanatural(u.getAreaorganica().getSede().getAreanatural().getIdareanatural());
								
				// Validamos que el infractor no sea nuevo, si es antiguo mandamos como parametro el id
				if(idInfractorAyuda.equals("00")){
//					System.out.println("Nuevo " + idInfractorAyuda);					
//					System.out.println("expediente.getResolucion()    : " + expediente.getResolucion());
//					System.out.println("expediente.getIdareanatural() : " + expediente.getIdareanatural());
					
					// JCEV 14-09-2012 Agrega la Información del Expediente
					expedienteService.insertar(expediente);
				}else{
					//idInFractor = Integer.parseInt(idPersonaNatural);
					idInFractor = Integer.parseInt(idInfractorAyuda);
					
					// JCEV 18-09-2012
					expedienteService.insertUpdate(expediente, idInFractor);
					
					// JCEV 18-09-2012 Se actualizo con insertUpdate
					//	expedienteService.insertar(expediente, idI);
					
				}
			} catch (Exception e) {
				strRet = ERROR;
				e.printStackTrace();
			}
			
			datos.put("Transaccion", strRet);
			
			//return strRet;
			return SUCCESS;
		}
		
		
		// JCEV - 25/08/2012 Registro de infractor Transaccional
		public String registrarInfractorTrx(){			
			Map<String, Object> session  = null;
			Usuario u                    = null;
			//File archivoGuardado         = null;
			Directorioarchivo directorio = null;
			String rutaRepositorio       = null;
			String ext                   = null;
			Archivo af 	  			     = null;
		    Date instante 			     = null;
			long inst                    = 0L;
			int nInsert                  = 0;
			int idI                      = 0;
			int idmod                    = 0;
		    int pos                      = 0;
			try {
				session    		= ActionContext.getContext().getSession();
				u          		= (Usuario) session.get("USUARIO_ACTUAL");
				idmod      		= Integer.parseInt(session.get("idmoduloactual").toString());
				directorio 		= new Directorioarchivo();
				directorio 		= directorioArchivoService.obtener(idmod);
				rutaRepositorio = directorio.getDirdirectorio();
				
				if(file != null){
					 af            = new Archivo();				 
	 				 af.setNombreinicial(fileFileName);  //expediente.getResolucion().getArchivo().setNombreinicial(fileFileName);				 
					 instante      = new Date();
					 inst          = instante.getTime();
					 pos           = fileFileName.lastIndexOf('.');			  
					 ext           = fileFileName.substring(pos);
					 fileFileName  = inst + ext;				 
					 af.setNombregenerado(fileFileName);
					 
					 //archivoGuardado = new File(rutaRepositorio, fileFileName);
					 //file.renameTo(archivoGuardado);
					 
					 //File uploadDir = new File(rutaRepositorio);
				     //FileUtils.copyFile(file, new File(uploadDir,fileFileName));					 
				     
			            try {
			            	File destFile = new File(rutaRepositorio + File.separator + fileFileName);			            	
			                FileUtils.copyFile(file, destFile);
			            } catch (IOException ex) {
			                //System.out.println("Could not copy file " + fileFileName);
			                //ex.printStackTrace();
			                return ERROR;
			            }
				     
				     
					 af.setMimearchivo(fileContentType);
					 af.getDirectorioarchivo().setIddirectorioarchivo(directorio.getIddirectorioarchivo());			 
				}
												
				expediente.getResolucion().setArchivo(af);
				
				// Usuario u=(Usuario) session.get("USUARIO_ACTUAL");
				expediente.setIdareanatural(u.getAreaorganica().getSede().getAreanatural().getIdareanatural());
								
				// Validamos que el infractor no sea nuevo, si es antiguo mandamos como parametro el id
				
				nInsert = expedienteService.insertarExpTrx(expediente);
				/*
				if(idInfractorAyuda.equals("00")){
					nInsert = expedienteService.insertarExpTrx(expediente);
				}else{
					idI     = Integer.parseInt(idInfractorAyuda);
					nInsert = expedienteService.insertarUpdateExpTrx(expediente, idI);
				}*/		
			} catch (Exception e) {				
				//System.out.println("nInsert :"+ ((nInsert > 0) ? SUCCESS : ERROR));
				//e.printStackTrace();
				return ERROR;
			} 
			
			//System.out.println("Resultado : " + ((nInsert > 0) ? SUCCESS : ERROR));
			//return ( (nInsert > 0) ? SUCCESS : ERROR );
			return SUCCESS;
		}
		
		//registro de infractor
		public String registrarInfractorOriginal(){
			Map<String, Object> session  = ActionContext.getContext().getSession();
			Usuario u                    = (Usuario) session.get("USUARIO_ACTUAL");			
			int idmod                    = Integer.parseInt(session.get("idmoduloactual").toString());			
			Directorioarchivo directorio = new Directorioarchivo();
			directorio                   = directorioArchivoService.obtener(idmod);			
			String rutaRepositorio       = "";
			rutaRepositorio              = directorio.getDirdirectorio();
			Archivo af                   = null;			
			String ext                   = null;
		    File archivoGuardado         = null;
			Date instante                = null;
			long inst                    = 0L;
			int idI                      = 0;
			int pos                      = 0;			  
			if(file != null){
				 af            = new Archivo();				 
 				 af.setNombreinicial(fileFileName);  //expediente.getResolucion().getArchivo().setNombreinicial(fileFileName);				 
				 instante      = new Date();
				 inst          = instante.getTime();
				 pos           = fileFileName.lastIndexOf('.');			  
				 ext           = fileFileName.substring(pos);
				 fileFileName  = inst + ext;				 
				 af.setNombregenerado(fileFileName);
				 archivoGuardado = new File(rutaRepositorio, fileFileName);
				 file.renameTo(archivoGuardado);
				 af.setMimearchivo(fileContentType);
				 af.getDirectorioarchivo().setIddirectorioarchivo(directorio.getIddirectorioarchivo());			 
			}			
			expediente.getResolucion().setArchivo(af);
			
			// Usuario u=(Usuario) session.get("USUARIO_ACTUAL");
			expediente.setIdareanatural(u.getAreaorganica().getSede().getAreanatural().getIdareanatural());
							
			// Validamos que el infractor no sea nuevo, si es antiguo mandamos como parametro el id
			if(idInfractorAyuda.equals("00")){
				expedienteService.insertar(expediente);
			}else{
				idI = Integer.parseInt(idPersonaNatural);
				expedienteService.insertUpdate(expediente,idI);
			}		
			return SUCCESS;
		}
		
		// VALIDACIONES JSON
		public String verificaInfractorEnSistema(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
			String nroDoc     = request.getParameter("nroDoc").trim();
			int tipDoc        = Integer.valueOf(request.getParameter("tipDoc"));
			
			infractorPantalla = infractorService.verificaEnSistema(nroDoc,tipDoc);          
			datos.put("MyInfractor",infractorPantalla);
			infractorPantalla = null;
			return SUCCESS;
		}
		
		// JCEV 17-10-2012
		public String verificaPersonaEnSistema(){
			HttpServletRequest request = null;
			String nroDoc              = null;
			int tipDoc                 = 0;
			try {
				request          = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
				nroDoc           = request.getParameter("nroDoc").trim();
				tipDoc           = Integer.valueOf(request.getParameter("tipDoc"));
				// personalPantalla = infractorService.verifySystem(nroDoc,tipDoc);          
				datos.put("MyInfractor",personalPantalla);
				personalPantalla = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		
		//obtiene antiguasInfracciones
		public String verificaReincidenciaInfracciones(){
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			int codigoInfractorR       = Integer.parseInt(request.getParameter("idInfractor").toString().trim());
			//System.out.println("Id : " + codigoInfractorR);
			if(infractorPantalla !=null){
				listaInfraccionesAntiguasPantalla = infractorService.obtieneInfraccionesAntiguas(codigoInfractorR);
				datosInfracciones.put("InfraccionesAntiguas",listaInfraccionesAntiguasPantalla);
				for(int i = 0; i<listaInfraccionesAntiguasPantalla.size();i++){
					listaInfraccionesAntiguasPantalla.get(i).getIdinfraccion();
				}
			}			
			return SUCCESS;
		}
		
		//METODOS PARA LA EDICION
		public String mostrarEditarExpediente(){
			listaSanciones   = infractorService.listarSanciones();			
			Expediente ex    = new Expediente();
			int xx           = Integer.parseInt(paramIdExpediente.toString());
			ex.setIdexpediente(xx);
			expediente       = expedienteService.obtenerXID(ex);			
			listaEstadoMulta = tipoService.listarEstadoMulta();							
			return SUCCESS;
		}
		
		// Actualiza el Pago del Expediente para las Sanciones con multa
		public String updatePagos(){
			HttpServletRequest request = null;
			int nIdExp                 = 0;
			int nSuccess               = 0;
			
			Map<String, Object> session  = null;
			Usuario u                    = null;
			//File archivoGuardado         = null;
			Directorioarchivo directorio = null;
			String rutaRepositorio       = null;
			String ext                   = null;
			Archivo af 	  			     = null;
		    Date instante 			     = null;
			long inst                    = 0L;
			int idmod                    = 0;
		    int pos						 = 0; 
			
			try {
				request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
				
				session    		= ActionContext.getContext().getSession();
				u          		= (Usuario) session.get("USUARIO_ACTUAL");
				idmod      		= Integer.parseInt(session.get("idmoduloactual").toString());

				directorio 		= new Directorioarchivo();
				directorio 		= directorioArchivoService.obtener(idmod);
				rutaRepositorio = directorio.getDirdirectorio();
				
				//if(file != null){
					 af            = new Archivo();				 
	 				 af.setNombreinicial(fileFileName);  //expediente.getResolucion().getArchivo().setNombreinicial(fileFileName);				 
					 instante      = new Date();
					 inst          = instante.getTime();
					 pos           = fileFileName.lastIndexOf('.');			  
					 ext           = fileFileName.substring(pos);
					 fileFileName  = inst + ext;				 
					 af.setNombregenerado(fileFileName);
					 
					 af.setMimearchivo(fileContentType);
					 af.getDirectorioarchivo().setIddirectorioarchivo(directorio.getIddirectorioarchivo());
					 
		            try {
		            	File destFile = new File(rutaRepositorio + File.separator + fileFileName);			            	
		                FileUtils.copyFile(file, destFile);
		            } catch (IOException ex) {
		                //System.out.println("Could not copy file " + fileFileName);
		                //ex.printStackTrace();
		                return ERROR;
		            }
							 
				//}				
				nIdExp  = Integer.valueOf(request.getParameter("nIdExpediente"));
				
				expediente.setIdexpediente(nIdExp);
				
				if(nIdExp > 0){
					//nSuccess = expedienteService.updateMorosidadExpediente(nIdExp);
					nSuccess = expedienteService.updateMorosidadExpediente(expediente, af);
				}			
			} catch (Exception e) {
				//e.printStackTrace();
				return ERROR;
			}
			
			return nSuccess == 1 ? SUCCESS : ERROR;
		}
		
		// Actualiza el Estadi del Expediente (Activo, Inactivo o Eliminado)
		// JCEV 21-10-2012, actualizado 24-10-2012 (ayuda de Yonny Coyla)
		public String updateStatusFile(){
			Map<String, Object> session = null;
			Usuario u                   = null;
			int nSuccess                = 0;
			try {
				session  = ActionContext.getContext().getSession();
				u        = (Usuario) session.get("USUARIO_ACTUAL");
				nSuccess = expedienteService.updateStatusFile(expediente, u.getIdUsuario());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return nSuccess == 1 ? SUCCESS : ERROR;
		}

		public String fffupdateStatusFile(){
//			HttpServletRequest request  = null;
			Map<String, Object> session = null;
			Usuario u                   = null;
//			String strObser             = null;
//			int nIdExp                  = 0;
//			int nOpcion                 = 0;
			int nSuccess                = 0;
			try {
//				request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
				session   = ActionContext.getContext().getSession();
				u         = (Usuario) session.get("USUARIO_ACTUAL");
				System.out.println("01. updateStatusFile");
//				nIdExp  = Integer.valueOf(request.getParameter("nIdExpediente"));
//				if(nIdExp > 0){
//					nOpcion  = Integer.valueOf(request.getParameter("strEstado"));
//					strObser = request.getParameter("strObs");
					nSuccess = expedienteService.updateStatusFile(expediente, u.getIdUsuario());
//				}			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return nSuccess == 1 ? SUCCESS : ERROR;
		}
		
		// JCEV 12-10-2012 Actualiza el Flag de Morosidad en la Tabla de Expediente
		public String updateFlagMorosidadExpediente(){
			HttpServletRequest request = null;
			int nIdExp                 = 0;
			int nSuccess               = 0;
			try {
				request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
				nIdExp  = Integer.valueOf(request.getParameter("nIdExpediente"));
				if(nIdExp > 0){
					//nSuccess = expedienteService.updateMorosidadExpediente(nIdExp);
				}			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return nSuccess == 1 ? SUCCESS : ERROR;
		}
		
		// Getters and Setters
		public String getCadIds() {
			return cadIds;
		}
		
		public String getParamIdExpediente() {
			return paramIdExpediente;
		}

		public void setParamIdExpediente(String paramIdExpediente) {
			this.paramIdExpediente = paramIdExpediente;
		}

		public ExpedienteService getExpedienteService() {
			return expedienteService;
		}

		public void setExpedienteService(ExpedienteService expedienteService) {
			this.expedienteService = expedienteService;
		}
		
		//09-05-2013
		public void setAreanaturalService(AreaNaturalService areanaturalService) {
			this.areanaturalService = areanaturalService;
		}		
				
		public void setCategoriaanpService(CategoriaAnpService categoriaanpService) {
			this.categoriaanpService = categoriaanpService;
		}

		public void setCadIds(String cadIds) {
			this.cadIds = cadIds;
		}	

		public Expediente getExpediente() {
			return expediente;
		}

		public void setExpediente(Expediente expediente) {
			this.expediente = expediente;
		}

		public List<Infraccion> getListaInfracciones() {
			return listaInfracciones;
		}

		public void setListaInfracciones(List<Infraccion> listaInfracciones) {
			this.listaInfracciones = listaInfracciones;
		}

		public List<Sancion> getListaSanciones() {
			return listaSanciones;
		}

		public void setListaSanciones(List<Sancion> listaSanciones) {
			this.listaSanciones = listaSanciones;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public String getFileFileName() {
			return fileFileName;
		}

		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}

		public String getFileContentType() {
			return fileContentType;
		}

		public void setFileContentType(String fileContentType) {
			this.fileContentType = fileContentType;
		}
		
		public int[] getArrayCadIds() {
			return arrayCadIds;
		}
		
		public void setArrayCadIds(int[] arrayCadIds) {
			this.arrayCadIds = arrayCadIds;
		}
		
		public String getDniRecibido() {
			return dniRecibido;
		}
		
		public void setDniRecibido(String dniRecibido) {
			this.dniRecibido = dniRecibido;
		}
		
		public Infractor getInfractorPantalla() {
			return infractorPantalla;
		}
		
		public void setInfractorPantalla(Infractor infractorPantalla) {
			this.infractorPantalla = infractorPantalla;
		}
		
		public Map<String, Object> getDatos() {
			return datos;
		}
		
		public void setDatos(Map<String, Object> datos) {
			this.datos = datos;
		}
		
		public List<Infraccion> getListaInfraccionesAntiguasPantalla() {
			return listaInfraccionesAntiguasPantalla;
		}
		
		public void setListaInfraccionesAntiguasPantalla(
				List<Infraccion> listaInfraccionesAntiguasPantalla) {
			this.listaInfraccionesAntiguasPantalla = listaInfraccionesAntiguasPantalla;
		}
		
		public Map<String, Object> getDatosInfracciones() {
			return datosInfracciones;
		}
		
		public void setDatosInfracciones(Map<String, Object> datosInfracciones) {
			this.datosInfracciones = datosInfracciones;
		}
		
		public String getIdInfractorAyuda() {
			return idInfractorAyuda;
		}
		
		public void setIdInfractorAyuda(String idInfractorAyuda) {
			this.idInfractorAyuda = idInfractorAyuda;
		}
		
		public String getIdPersonaNatural() {
			return idPersonaNatural;
		}

		public void setIdPersonaNatural(String idPersonaNatural) {
			this.idPersonaNatural = idPersonaNatural;
		}

		public List<Expediente> getListaExpedientes() {
			return listaExpedientes;
		}
		
		public void setListaExpedientes(List<Expediente> listaExpedientes) {
			this.listaExpedientes = listaExpedientes;
		}
//		public Map<String, Object> getDatosListaInfractores() {
//			return datosListaInfractores;
//		}
//		public void setDatosListaInfractores(Map<String, Object> datosListaInfractores) {
//			this.datosListaInfractores = datosListaInfractores;
//		}
//		

		public List<Categoriaanp> getListacategoriaanp() {
			return listacategoriaanp;
		}

		public void setListacategoriaanp(List<Categoriaanp> listacategoriaanp) {
			this.listacategoriaanp = listacategoriaanp;
		}

		
		public List<Areanatural> getListaareanatural() {
			return listaareanatural;
		}
		
		public void setListaareanatural(List<Areanatural> listaareanatural) {
			this.listaareanatural = listaareanatural;
		}
		
		public String getNumeroDocRecibido() {
			return numeroDocRecibido;
		}		

		public void setNumeroDocRecibido(String numeroDocRecibido) {
			this.numeroDocRecibido = numeroDocRecibido;
		}

		public List<ExpedienteSancion> getListaExpedienteSancion() {
			return listaExpedienteSancion;
		}

		public void setListaExpedienteSancion(
				List<ExpedienteSancion> listaExpedienteSancion) {
			this.listaExpedienteSancion = listaExpedienteSancion;
		}

		public List<Tipo> getListaEstado() {
			return listaEstadoMulta;
		}

		public void setListaEstado(List<Tipo> listaEstadoMulta) {
			this.listaEstadoMulta = listaEstadoMulta;
		}

		public List<Tipo> getListaEstadoMulta() {
			return listaEstadoMulta;
		}

		public void setListaEstadoMulta(List<Tipo> listaEstadoMulta) {
			this.listaEstadoMulta = listaEstadoMulta;
		}
		
		public List<Directorioarchivo> getListaDirectorios() {
			return listaDirectorios;
		}

		public void setListaDirectorios(List<Directorioarchivo> listaDirectorios) {
			this.listaDirectorios = listaDirectorios;
		}

		public Pagination getPaginacion() {
			return paginacion;
		}

		public void setPaginacion(Pagination paginacion) {
			this.paginacion = paginacion;
		}

		public int getNumeropagina() {
			return numeropagina;
		}

		public void setNumeropagina(int numeropagina) {
			this.numeropagina = numeropagina;
		}

		public Categoriaanp getCategoriaanp() {
			return categoriaanp;
		}

		public void setCategoriaanp(Categoriaanp categoriaanp) {
			this.categoriaanp = categoriaanp;
		}

		public Areanatural getAreanatural() {
			return areanatural;
		}

		public void setAreanatural(Areanatural areanatural) {
			this.areanatural = areanatural;
		}
		
		

}
