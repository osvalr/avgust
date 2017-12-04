package proyecto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.plot.PiePlot;

import proyecto.constants.ValueConstants;
import proyecto.param.AreanaturalParam;
import proyecto.param.ProyectoParam;
import proyecto.reportes.ProyectoReporte;
import proyecto.service.ArchivoService;
import proyecto.service.AreaNaturalService;
import proyecto.service.CategoriaAnpService;
import proyecto.service.EjecutorService;
import proyecto.service.EstadoService;
import proyecto.service.FuenteFinanciamientoService;
import proyecto.service.MonedaService;
import proyecto.service.PaisService;
import proyecto.service.PersonaJuridicaService;
import proyecto.service.ProyectoService;
import proyecto.service.TipoCambioService;
import proyecto.service.TipoService;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Archivo;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.Ejecutor;
import proyecto.vo.Estado;
import proyecto.vo.Fuentefinanciamiento;
import proyecto.vo.Moneda;
import proyecto.vo.Objeto;
import proyecto.vo.Pais;
import proyecto.vo.Personajuridica;
import proyecto.vo.Proyecto;
import proyecto.vo.ProyectoArchivo;
import proyecto.vo.ProyectoEjecutor;
import proyecto.vo.ProyectoFteFto;
import proyecto.vo.Tipo;
import proyecto.vo.Tipocambio;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProyectoAction  extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Proyecto> listaProyecto;
	private List<Tipo> listaCategoriaProyecto;
	private List<Tipo> listaTipoProyecto;
	private List<Integer> listaPagina;
	private List<Areanatural> listaAreaNatural;
	private List<Estado> listaEstadoProyecto;
	private List<Ejecutor> listaEjecutor;
	private List<Ejecutor> listaEjecutorFinanciero;
	private List<Ejecutor> listaEjecutorTecnico;
	private List<Fuentefinanciamiento> listaFtefto;
	private List<Categoriaanp> listaCategoriaAnp;
	private List<Integer> listaCodigos;
	private List<Integer> listaCodigosArea;
	private List<Integer> listaCodigosEjecutor;
	private List<Integer> listaCodigosEjecFinanciero;
	private List<Integer> listaCodigosEjecTecnico;
	private List<Integer> listaCodigosFte;
	private List<Objeto> listaMontosFteFto;
	private List<ProyectoEjecutor> listaProyectoEjecutor;
	private List<ProyectoFteFto> listaProyectoFteFto;
	private List<ProyectoArchivo> listaProyectoArchivo;
	//private Map mapArea;
	private List<Objeto> listaObjetoArea;
	private List<Objeto> listaObjetoEjecutor;
	private List<Objeto> listaObjetoFteFto;
	private List<Estado> listaEstadoVigencia;
	private List<Moneda> listaMoneda;
	private List<Tipo> listaOpciones;
	private List<Proyecto> listaProyectoPrincipal;
	private Proyecto proyecto;
	private ProyectoParam proyectoParam;
	private int mensaje;
	private int indice;
	private int totalRegistros;
	private int numeroPagina;
	private int idProyectoParam;
	private int idCategoriaAnpParam;
	private int pagina;
	private int control;
	private int paginaInicial;
	private int idCodigoParam;
	private Map<String,Object> datos;
	private String cadenaParam;
	private Personajuridica personajuridica;
	private int crear;
	private int numPagina;
	private Map<String,Integer> paginacion;
	private Estado estado;
	private List<Pais> listaPais;
	private List<Archivo> listaArchivo;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private File[] listaFlujoArchivo;
    private String[] listaFlujoArchivoFileName;
	private String[] listaFlujoArchivoContentType;
	private Archivo documento;
	private Archivo archivo;
	private int idarchivo;
	private InputStream resultadoListaProyecto;
	private int idtipoexp;
	private String nombreArchivo;
	private String datosJson;
	private String datosJson2;
	private String datosJson3;
	private String datosJson4;
	private int idopcion;
	private int idcodigo;
	private String codigo;
	private InputStream archivoProyecto;
	private String nombreGenerado;
	private Map<String, Integer> parametro;
	private List<AreanaturalParam> listaConsolidadoAreaNatural;
	private String nombreproyecto;
	private PiePlot plot;
	private String codareanatural;
	private Areanatural areanatural;
	private List<Tipocambio> listaTipoCambio;
	private List<Tipo> listaAnio;
	private List<Tipo> listaMes;
	private Usuario usuario;
	private List<ProyectoEjecutor> listaProyectoEjecutorFinanciero;
	private List<ProyectoEjecutor> listaProyectoEjecutorTecnico;
	
	public ProyectoAction(){
		listaProyecto=new ArrayList<Proyecto>();
		
		listaTipoProyecto=new ArrayList<Tipo>();
		listaPagina=new ArrayList<Integer>();
		listaAreaNatural=new ArrayList<Areanatural>();
		listaEjecutor=new ArrayList<Ejecutor>();
		listaFtefto=new ArrayList<Fuentefinanciamiento>();
		listaCategoriaAnp=new ArrayList<Categoriaanp>();
		listaCodigos=new ArrayList<Integer>();
		listaCodigosArea=new ArrayList<Integer>();
		//mapArea=new HashMap<Areanatural, Integer>();
		listaObjetoArea=new ArrayList<Objeto>();
		listaObjetoEjecutor=new ArrayList<Objeto>();
		listaObjetoFteFto=new ArrayList<Objeto>();
		listaCodigosEjecutor=new ArrayList<Integer>();
		listaEstadoVigencia=new ArrayList<Estado>();
		listaMoneda=new ArrayList<Moneda>();
		proyectoParam=new ProyectoParam();
		proyecto=new Proyecto();
		listaMontosFteFto=new ArrayList<Objeto>();
		listaCodigosFte=new ArrayList<Integer>();
		listaEjecutorFinanciero=new ArrayList<Ejecutor>();
		listaEjecutorTecnico=new ArrayList<Ejecutor>();
		listaCategoriaProyecto=new ArrayList<Tipo>();
		listaOpciones=new ArrayList<Tipo>();
		datos=new HashMap<String, Object>();
		listaCodigosEjecFinanciero=new ArrayList<Integer>();
		listaCodigosEjecTecnico=new ArrayList<Integer>();
		listaProyectoFteFto=new ArrayList<ProyectoFteFto>();
		personajuridica=new Personajuridica();
		paginacion=new HashMap<String, Integer>();
		estado=new Estado();
		listaPais=new ArrayList<Pais>();
		listaProyectoPrincipal=new ArrayList<Proyecto>();
		listaProyectoArchivo=new ArrayList<ProyectoArchivo>();
		listaArchivo=new ArrayList<Archivo>();
		//listaFlujoArchivo=new File[500];
		//listaFlujoArchivoFileName=new String[500];
		//listaFlujoArchivoContentType=new String[500];
		documento=new Archivo();
		archivo=new Archivo();
		parametro=new HashMap<String, Integer>();
		listaConsolidadoAreaNatural=new ArrayList<AreanaturalParam>();
		listaTipoCambio=new ArrayList<Tipocambio>();
	   listaEstadoProyecto=new ArrayList<Estado>();
	   areanatural=new Areanatural();
	   listaAnio=new ArrayList<Tipo>();
	   listaMes=new ArrayList<Tipo>();
	   listaEstadoProyecto=new ArrayList<Estado>();
	   usuario=new Usuario();
	   listaProyectoEjecutor=new ArrayList<ProyectoEjecutor>();
	   listaProyectoEjecutorFinanciero=new ArrayList<ProyectoEjecutor>();
	   listaProyectoEjecutorTecnico=new ArrayList<ProyectoEjecutor>();
	}
	
	
	
     public String consultarProyectos(){
    	 Map<String, Object> session = ActionContext.getContext().getSession();
    	 
    	
    	
    	 String resultado="";
    	 
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			try {
				request.setCharacterEncoding("ISO-8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProyectoParam busProyectoParam=new ProyectoParam();
			
			int control=0;
			if(request.getParameter("control")==null){
				control=1;
			}
			else{
				control=Integer.parseInt(request.getParameter("control").toString());
			}
			
			
			
			Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
			int idareanatural=user.getAreaorganica().getSede().getAreanatural().getIdareanatural();
			
			if(control==ValueConstants.LINK_INICIO){
				listaEjecutorFinanciero=ejecutorService.listarInstitucionesEjecutoras();
				listaEjecutorTecnico=ejecutorService.listarInstitucionesEjecutoras();
				listaFtefto=fuenteFinanciamientoService.listarInstitucionesFuentes();
				listaTipoProyecto=tipoService.listarTipoProyectos();
				listaCategoriaProyecto=tipoService.listarCategoriaProyectos();
				listaCategoriaAnp=categoriaAnpService.listarCategoriasAnpsActivasConProyectos();
				listaAreaNatural=areaNaturalService.consultarAreasNaturalesConProyectos(new Areanatural());
				listaProyectoPrincipal=proyectoService.listarProyectosPrincipales();
				//listaCategoriaAnp=categoriaAnpService.listarCategoriasAnpsActivas();
				listaEstadoVigencia=estadoService.listarEstadoVigencia();
				listaEstadoProyecto=estadoService.listarEstadoProyecto();
				estado=new Estado();
				estado.setIdestado(1);
			}
			
			if(control==ValueConstants.CONTROL_NUMPAGINA){
					String nombre = String.valueOf(request.getParameter("proyectoParam.nombre"));
					int idTipoProy =  Integer.parseInt(request.getParameter("proyectoParam.tipoProyecto.idTipo").toString());
					int idcatproy =  Integer.parseInt(request.getParameter("proyectoParam.categoriaproyecto.idtipo").toString());
					int idProyPrinc =  Integer.parseInt(request.getParameter("proyectoParam.proyectoPrincipal.idproyecto").toString());
					String areaEspecifica = String.valueOf(request.getParameter("proyectoParam.areaEspecifica"));
					String objetivo = String.valueOf(request.getParameter("proyectoParam.objetivo"));
					int idArea =  Integer.parseInt(request.getParameter("proyectoParam.areanatural.idareanatural").toString());
					//int idEjec =  Integer.parseInt(request.getParameter("proyectoParam.ejecutor.idejecutor").toString());
					int idEjecFin =  Integer.parseInt(request.getParameter("proyectoParam.ejecutorFinanciero.idejecutor").toString());
					int idEjecTec =  Integer.parseInt(request.getParameter("proyectoParam.ejecutorTecnico.idejecutor").toString());
					int idFteFto =  Integer.parseInt(request.getParameter("proyectoParam.ftefto.idftefto").toString());
					int idCategoriaAnp =  Integer.parseInt(request.getParameter("proyectoParam.areanatural.categoriaanp.idcategoriaanp").toString());
					int idvigencia =  Integer.parseInt(request.getParameter("proyectoParam.flagVigencia").toString());
					int idestado= Integer.parseInt(request.getParameter("proyectoParam.estadoProyecto.idEstado").toString());
					
					
					if(!nombre.equals("")){
						busProyectoParam.getProyecto().setNombreproyecto(nombre);	
					}
					if(!objetivo.equals("")){
						busProyectoParam.getProyecto().setObjetivoproyecto(objetivo);	
					}
					if(!areaEspecifica.equals("")){
						busProyectoParam.getProyecto().setAreaespecificaproyecto(areaEspecifica);	
					}
					busProyectoParam.getProyecto().getCategoriaproyecto().setIdtipo(idcatproy);
					busProyectoParam.getProyecto().getTipoproyecto().setIdtipo(idTipoProy);
					busProyectoParam.getProyecto().getEstadoproyecto().setIdestado(idestado);
					busProyectoParam.getProyecto().setFlagVigencia(idvigencia);
					busProyectoParam.getAreanatural().setIdareanatural(idArea);
					busProyectoParam.getAreanatural().getCategoriaanp().setIdcategoriaanp(idCategoriaAnp);
					//busProyectoParam.getEjecutor().setIdejecutor(idEjec);
					busProyectoParam.getEjecutorFinanciero().setIdejecutor(idEjecFin);
					busProyectoParam.getEjecutorTecnico().setIdejecutor(idEjecTec);
					busProyectoParam.getFtefto().setIdftefto(idFteFto);
					Proyecto pp=new Proyecto();
					pp.setIdproyecto(idProyPrinc);
					busProyectoParam.getProyecto().setProyectoPrincipal(pp);
				
			}
			
			ResourceBundle labels = ResourceBundle
			.getBundle("proyecto.resources.proyectoparametros");
		    String tamPagina=labels.getString("tamanio_pagina");
		    
		    if(control==ValueConstants.LINK_INICIO ){
				busProyectoParam.getProyecto().setFlagVigencia(ValueConstants.FLAG_SI);
				
			}
		    /******* Pagination **********/
			   
		    	int tamanioPagina=Integer.parseInt(tamPagina);
				int total=proyectoService.calcularCantidadProyectos(busProyectoParam);
				double numPaginas=(double)total / (double)tamanioPagina;
			    double cantPaginas=Math.ceil(numPaginas);
			    totalRegistros=(int)cantPaginas;
	 			//numPagina=numeroPagina;
			    //totalRegistros=4;
	 			//numeroPagina=4;
			    setPaginaInicial(
			    		(numeroPagina <=2)? 
			    		1 :	
			    		( ( numeroPagina+2 ) >= totalRegistros )? 
			    			( totalRegistros-4 ) : 
			    				numeroPagina-2
			    				);
			    paginacion.put("pagina", numeroPagina);
			    paginacion.put("total", totalRegistros);
			    paginacion.put("inicio", paginaInicial);
			    paginacion.put("final", (totalRegistros>=5)? paginaInicial+4: totalRegistros);
			    paginacion.put("paginaSiguiente", numeroPagina+1);
			    paginacion.put("paginaAnterior", numeroPagina-1);
			    paginacion.put("totalProyectos", total);
	 			
		    /********* END Pagination **********/
		    /*
		    for(int i=1;i<=cantPaginas;i++){
 				Integer numero=new Integer(i);
 				listaPagina.add(numero);
 			}
 			*/
 			
		    
		    
 			
			if(control==ValueConstants.LINK_INICIO ){
				
				listaProyecto=proyectoService.consultarProyectosPaginado(busProyectoParam, 0, tamanioPagina);
				
			}
			else 
				if(control==ValueConstants.CONTROL_NUMPAGINA){
					int indice=0;
		    	    indice=( (numeroPagina-1)*tamanioPagina);
		    		listaProyecto=proyectoService.consultarProyectosPaginado(busProyectoParam,indice,tamanioPagina );
		    		
				}
			
			
			if(control==ValueConstants.LINK_INICIO){
				resultado="inicio";
				//session.put("controlVS", ValueConstants.LINK_INICIO);
			}
			else
				if(control==ValueConstants.CONTROL_NUMPAGINA){
					resultado="lista";
					//session.put("controlVS", ValueConstants.CONTROL_NUMPAGINA);
				}

			
			for(int i=0;i<listaProyecto.size();i++){
				listaProyecto.set(i, proyectoService.consultarDetalleProyecto(new Proyecto(listaProyecto.get(i).getIdproyecto())));
				
				if(user.getRol().getIdrol()==ValueConstants.ID_ADMIN_TOTAL){
					listaProyecto.get(i).setFlagAccion(ValueConstants.FLAG_ACTIVO);
				}
				else{
				for(Areanatural a: listaProyecto.get(i).getAreanaturals()){
		    		if(a.getIdareanatural()==idareanatural){
		    			listaProyecto.get(i).setFlagAccion(1);
		    		}
		    	}
				}
			}
		    
			
			
		return resultado;
		
		
	}
	
   
     
     public String consultarDetalleProyecto() {
    			proyecto=proyectoService.consultarDetalleProyecto(new Proyecto(idProyectoParam));
    			
    	return "success";
 	} 
	
     
    public String listarAreasNaturales(){
    	Areanatural a=new Areanatural();
    	
    	a.getCategoriaanp().setIdcategoriaanp(idCategoriaAnpParam);
    	listaAreaNatural=areaNaturalService.consultarAreasNaturalesConProyectos(a);
    	//listaAreaNatural=areaNaturalService.consultarAreasNaturales(a);
    	return "success";
    } 
     
    
    public String listarAreasNaturalesxCategoria(){
    	
    	Areanatural an=new Areanatural();
        an.getCategoriaanp().setIdcategoriaanp(idCodigoParam);
    	listaAreaNatural=areaNaturalService.consultarAreasNaturales(an);
    	
    	for(Areanatural a:listaAreaNatural){
			  Objeto o=new Objeto();
				o.setIdcodigo(a.getIdareanatural());
				o.setNombre(a.getDesareanatural());
			    listaObjetoArea.add(o);
		 }
    	return "success";
    }
    
    
  
    
    public String listarFiltrosProyectos(){
    	Areanatural a=new Areanatural();
    	
    	listaCategoriaAnp=categoriaAnpService.listarCategoriasAnpsActivasConProyectos();
    	if(control==ValueConstants.CBO_CATEGORIA){
    		a.getCategoriaanp().setIdcategoriaanp(idCodigoParam);
        	
        	listaAreaNatural=areaNaturalService.consultarAreasNaturalesConProyectos(a);
        	List<Objeto> lista1=new ArrayList<Objeto>();
    		for(Areanatural anat:listaAreaNatural){
    			Objeto o=new Objeto();
    			o.setIdcodigo(anat.getIdareanatural());
    			o.setNombre(anat.getDesareanatural());
    			lista1.add(o);
    		}
    		datos.put("cboAnp",lista1);
    	}else
    		if(control==ValueConstants.CBO_ANP){
    			if(idCodigoParam!=0){
    				a.setIdareanatural(idCodigoParam);
    			}
    			else{
    				a.getCategoriaanp().setIdcategoriaanp(idCategoriaAnpParam);
    			}
    			
            	
    		}
    	
    	listaEjecutorFinanciero=ejecutorService.consultarInstitucionesEjecutorasFinancierasxAreasNaturales(a);
    	listaEjecutorTecnico=ejecutorService.consultarInstitucionesEjecutorasTecnicasxAreasNaturales(a);
		listaFtefto=fuenteFinanciamientoService.consultarInstitucionesFuentesxAreasNaturales(a);
		
		List<Objeto> lista2=new ArrayList<Objeto>();
		for(Ejecutor e:listaEjecutorFinanciero){
			Objeto o=new Objeto();
			o.setIdcodigo(e.getIdejecutor());
			o.setNombre(e.getPersonajuridica().getNombrepersonajuridica());
			lista2.add(o);
		}
		List<Objeto> lista3=new ArrayList<Objeto>();
		for(Ejecutor e:listaEjecutorTecnico){
			Objeto o=new Objeto();
			o.setIdcodigo(e.getIdejecutor());
			o.setNombre(e.getPersonajuridica().getNombrepersonajuridica());
			lista3.add(o);
		}
		List<Objeto> lista4=new ArrayList<Objeto>();
		for(Fuentefinanciamiento f:listaFtefto){
			Objeto o=new Objeto();
			o.setIdcodigo(f.getIdftefto());
			o.setNombre(f.getPersonajuridica().getNombrepersonajuridica());
			lista4.add(o);
		}
		
		
		datos.put("cboEjecFin", lista2);
		datos.put("cboEjecTec", lista3);
		datos.put("cboFteFto", lista4);
    	return "success";
    } 
     
	
	public String irRegistroProyecto(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		 Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
		//int idareanatural=user.getAreaorganica().getAreanatural().getIdareanatural();
		areanatural.setIdareanatural(user.getAreaorganica().getSede().getAreanatural().getIdareanatural());
		//listas 
		listaAreaNatural=areaNaturalService.listarAreasNaturales();
		listaEjecutor=ejecutorService.listarInstitucionesEjecutoras();
		listaFtefto=fuenteFinanciamientoService.listarInstitucionesFuentes();
		listaCategoriaProyecto=tipoService.listarCategoriaProyectos();
		listaTipoProyecto=tipoService.listarTipoProyectos();
		listaMoneda=monedaService.listarTipoMonedas();
		listaOpciones=tipoService.listarOpciones();
		listaCategoriaAnp=categoriaAnpService.listarCategoriasAnpsActivas();
		listaPais=paisService.listar();
		listaProyectoPrincipal=proyectoService.listarProyectosPrincipales();
		listaEstadoProyecto=estadoService.listarEstadoProyecto();
		listaAnio=tipoService.listarAnios();
		listaMes=tipoService.listarMeses();
		Tipo tp=new Tipo();
		int idtipoult=listaTipoProyecto.get(listaTipoProyecto.size()-1).getIdtipo();
		tp.setIdtipo(idtipoult+1);
		tp.setNombretipo("Otro");
		listaTipoProyecto.add(tp);
		
		int maxDoc=0;
		 int maxArch=0;
		if(idProyectoParam!=0){
			
		 proyecto=proyectoService.consultarDetalleProyecto(new Proyecto(idProyectoParam));
		
		 SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		 String fecha="";
		 
		 if(proyecto.getFechainicioproyecto()!=null){
        	 fecha=formateador.format(proyecto.getFechainicioproyecto());
        	 proyecto.setFechainicio(fecha);
         }   
		 if(proyecto.getFechafinproyecto()!=null){
        	 fecha=formateador.format(proyecto.getFechafinproyecto());
        	 proyecto.setFechafin(fecha);
         }
		 
		
		 
		 
		 
		 
		 //areas naturales
		 Map< Integer, String> mapArea=new HashMap<Integer, String>(); 
		 for( Areanatural a:  proyecto.getAreanaturals()){
			 mapArea.put(a.getIdareanatural(), a.getDesareanatural());
		 }
		 for(Areanatural a:listaAreaNatural){
	   		Objeto o=new Objeto();
	   		
			o.setIdcodigo(a.getIdareanatural());
			
			o.setNombre(a.getCategoriaanp().getSiglascategoriaanp()+". "+a.getDesareanatural());
			o.setIdtipo(a.getCategoriaanp().getIdcategoriaanp());
			
		  if( mapArea.containsKey(a.getIdareanatural()) ){
				o.setValor(1);
		   }
	      listaObjetoArea.add(o);
		}
		 listaProyectoFteFto=proyecto.getListaFuenteProyecto();
		 
		 for(ProyectoFteFto pf:listaProyectoFteFto){
			 System.out.println("valor tc"+pf.getTipocambio().getValor());
			 System.out.println("id tc"+pf.getTipocambio().getIdtipocambio());
		 }
	
		 
		 
		}
		else{
			
			proyecto.setNombreproyecto("");
			proyecto.setObjetivoproyecto("");
			proyecto.setFechainicio("");
			proyecto.setFechafin("");
			proyecto.getTipoproyecto().setIdtipo(0);
			proyecto.setObservacionproyecto("");
			proyecto.setCompromisoproyecto("");
			proyecto.setAreaespecificaproyecto("");
			
			//areas
			for(Areanatural a:listaAreaNatural){
				  Objeto o=new Objeto();
					o.setIdcodigo(a.getIdareanatural());
					o.setNombre(a.getCategoriaanp().getSiglascategoriaanp()+". "+a.getDesareanatural());
					o.setIdtipo(a.getCategoriaanp().getIdcategoriaanp());
				    listaObjetoArea.add(o);
			 }
			
		
		}
		
		
		
		
		//session.put("listaArchivoVS", new ArrayList<Archivo>());
		parametro.put("maxDoc", maxDoc);
		 parametro.put("maxArch", maxArch);
		session.put("mapArchivoVS", new HashMap<Integer, Object>());
		return "success";
	}

	
	  public InputStream getArchivoProyecto() { 
		  ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
	         String rutaRepositorio = labels.getString("ruta_repositorio");
	        Archivo a= archivoService.consultarArchivoxId(idcodigo);
	        String rutaArchivo=rutaRepositorio+a.getNombreGenerado();
	        nombreArchivo=a.getNombreInicial();
	       try {
	      	
				archivoProyecto= new FileInputStream(new File(rutaArchivo));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return archivoProyecto;
		}
	
	
	public String cargarArchivo(){
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		Map<Integer,Object> mapArchivo=(Map<Integer, Object>) session.get("mapArchivoVS");
		ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
         String rutaRepositorio = labels.getString("ruta_repositorio");
		 if(file!=null){
			 //Archivo a=new Archivo();
			 archivo.setNombreInicial(fileFileName);
			 //a.setNombreInicial(fileFileName);
             Date instante=new Date();
 			 long inst =instante.getTime();
 			 int pos=fileFileName.lastIndexOf('.');
 			 String ext=fileFileName.substring(pos);
 			 fileFileName=inst+ext;
 			 String nameInst=String.valueOf(inst);
 			 File archivoGuardado = new File(rutaRepositorio, fileFileName);
 			 file.renameTo(archivoGuardado);
 			 archivo.setNombreGenerado(fileFileName);
 			 archivo.getUsuario().setIdUsuario(1);
 			 //archivo.setIdarchivo(idcodigo);
 			 archivo.setIdcodigo(idcodigo);
 			 mapArchivo.put(idcodigo, archivo);
 			
         }
         
         session.put("mapArchivoVS", mapArchivo);
        
		return "success";
	}
	
	
	
	
	public String eliminarRegistroProyectos(){
		proyectoService.eliminarProyectos(listaCodigos);
		return "success";
	}
	
	public String guardarRegistroProyecto(){
		 Map<String, Object> session = ActionContext.getContext().getSession();
		 Map<Integer,Object> mapArchivo=(Map<Integer, Object>) session.get("mapArchivoVS");
		 Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
		 //int idareanatural=user.getAreaorganica().getAreanatural().getIdareanatural();
		 // ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
         //String rutaRepositorio = labels.getString("ruta_repositorio_temp");
        
		
			
			
			
			
			
			
			
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(!proyecto.getFechainicio().equals("")){
					proyecto.setFechainicioproyecto(formateador.parse(proyecto.getFechainicio()));	
				}
				if(!proyecto.getFechafin().equals("")){
					proyecto.setFechafinproyecto(formateador.parse(proyecto.getFechafin()));	
				}
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			proyecto.getMoneda().setIdmoneda(ValueConstants.MONEDA_SOL);
			
			//areas
			List<Areanatural> listaArea=new ArrayList<Areanatural>();
			for(Integer i:listaCodigosArea){
				Areanatural a=new Areanatural();
				a.setIdareanatural(i);
				listaArea.add(a);
			}
			
			//ejecutoras
			List<ProyectoEjecutor> listaProyectoEjecutor=new ArrayList<ProyectoEjecutor>();
			//ejecutoras financieras
			
			
			for(ProyectoEjecutor pe:listaProyectoEjecutorFinanciero){
				if(pe!=null){
					pe.getTipoejecutor().setIdtipo(ValueConstants.EJECUTOR_FINANCIERO);
					listaProyectoEjecutor.add(pe);
					
				}
				
				
			}
			
			//ejecutoras tecnicas
			for(ProyectoEjecutor pe:listaProyectoEjecutorTecnico){
				if(pe!=null){
					pe.getTipoejecutor().setIdtipo(ValueConstants.EJECUTOR_TECNICO);
					listaProyectoEjecutor.add(pe);
					
				}
				
			}
			
			//fuentes
			List<ProyectoFteFto> listaFte=new ArrayList<ProyectoFteFto>();
			for(ProyectoFteFto pf:listaProyectoFteFto){
				if(pf!=null){
					listaFte.add(pf);
					
				}		
			}
			
			//archivos
			List<ProyectoArchivo> listaArch=new ArrayList<ProyectoArchivo>();
			for(ProyectoArchivo pa:listaProyectoArchivo){
				if(pa!=null){
					
					ProyectoArchivo par=new ProyectoArchivo();
					par.setArchivo(pa.getArchivo());
					par.getArchivo().getUsuario().setIdUsuario(user.getIdUsuario());
					par.getArchivo().setFechaUpload(new Date());
					
					List<Archivo> lista=new ArrayList<Archivo>();
					for(Archivo a:listaArchivo){
						if(a!=null){
							
							//selecciono los archivos del documento
							if(a.getIdcodigopadre()==pa.getArchivo().getIdcodigo()){
								Archivo aux=new Archivo();
								aux.setIdarchivo(a.getIdarchivo());
								aux.getUsuario().setIdUsuario(user.getIdUsuario());
								aux.setFechaUpload(new Date());
								//setear nombre, si se subio archivo
								if(mapArchivo.get(a.getIdcodigo())!=null){
									Archivo arch=  (Archivo) mapArchivo.get(a.getIdcodigo());
									aux.setIdarchivoPadre(a.getIdarchivoPadre());
									aux.setNombreGenerado(arch.getNombreGenerado());
									aux.setNombreInicial(arch.getNombreInicial());
									
									
								}
								lista.add(aux);
								
							}
							
						}
						
					}
					//par.getArchivo().setIdarchivo(0);
					par.getArchivo().setListaArchivo(lista);
					listaArch.add(par);
					
				}		
			}
			
			
			proyecto.setAreanaturals(listaArea);
			proyecto.setListaProyectoEjecutor(listaProyectoEjecutor);
			proyecto.setListaFuenteProyecto(listaFte);
			proyecto.setListaProyectoArchivo(listaArch);
			proyectoService.guardarProyecto(proyecto);
			
			if(crear==1 && proyecto.getIdproyecto()==0){
				
				//mensaje=ValueConstants.MENSAJE_EXITO;
				return "crea";
			}
			else{
				
				return "actualiza";
			}
			
			
			
			
			
			
			
			
			
			
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
	}
	
	
	public InputStream getResultadoListaProyecto(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		 Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
		 ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
         String rutaArchivo = labels.getString("ruta_repositorio_temp");
         String rutaImagen = labels.getString("ruta_repositorio_imagen");
         String nombreImagen = labels.getString("nombre_logo_sernanp");
         ProyectoParam busProyectoParam=new ProyectoParam();
         String nombre = String.valueOf(request.getParameter("proyectoParam.nombre"));
			int idTipoProy =  Integer.parseInt(request.getParameter("proyectoParam.tipoProyecto.idTipo").toString());
			int idcatproy =  Integer.parseInt(request.getParameter("proyectoParam.categoriaproyecto.idtipo").toString());
			int idProyPrinc =  Integer.parseInt(request.getParameter("proyectoParam.proyectoPrincipal.idproyecto").toString());
			String areaEspecifica = String.valueOf(request.getParameter("proyectoParam.areaEspecifica"));
			String objetivo = String.valueOf(request.getParameter("proyectoParam.objetivo"));
			int idArea =  Integer.parseInt(request.getParameter("proyectoParam.areanatural.idareanatural").toString());
			//int idEjec =  Integer.parseInt(request.getParameter("proyectoParam.ejecutor.idejecutor").toString());
			int idEjecFin =  Integer.parseInt(request.getParameter("proyectoParam.ejecutorFinanciero.idejecutor").toString());
			int idEjecTec =  Integer.parseInt(request.getParameter("proyectoParam.ejecutorTecnico.idejecutor").toString());
			int idFteFto =  Integer.parseInt(request.getParameter("proyectoParam.ftefto.idftefto").toString());
			int idCategoriaAnp =  Integer.parseInt(request.getParameter("proyectoParam.areanatural.categoriaanp.idcategoriaanp").toString());
			int idvigencia =  Integer.parseInt(request.getParameter("proyectoParam.flagVigencia").toString());
			
			
			if(!nombre.equals("")){
				busProyectoParam.getProyecto().setNombreproyecto(nombre);	
			}
			if(!objetivo.equals("")){
				busProyectoParam.getProyecto().setObjetivoproyecto(objetivo);	
			}
			if(!areaEspecifica.equals("")){
				busProyectoParam.getProyecto().setAreaespecificaproyecto(areaEspecifica);	
			}
			busProyectoParam.getProyecto().getCategoriaproyecto().setIdtipo(idcatproy);
			busProyectoParam.getProyecto().getTipoproyecto().setIdtipo(idTipoProy);
			busProyectoParam.getProyecto().setFlagVigencia(idvigencia);
			busProyectoParam.getAreanatural().setIdareanatural(idArea);
			busProyectoParam.getAreanatural().getCategoriaanp().setIdcategoriaanp(idCategoriaAnp);
			//busProyectoParam.getEjecutor().setIdejecutor(idEjec);
			busProyectoParam.getEjecutorFinanciero().setIdejecutor(idEjecFin);
			busProyectoParam.getEjecutorTecnico().setIdejecutor(idEjecTec);
			busProyectoParam.getFtefto().setIdftefto(idFteFto);
			Proyecto pp=new Proyecto();
			pp.setIdproyecto(idProyPrinc);
			busProyectoParam.getProyecto().setProyectoPrincipal(pp);
            SimpleDateFormat formateador=new SimpleDateFormat("yyyy");
            List<Proyecto>lista=proyectoService.consultarProyectos(busProyectoParam);
            SimpleDateFormat formateador2=new SimpleDateFormat("dd/MM/yyyy");
            String titulo=ValueConstants.TITULO_SERNANP;
            //String nombreImagen=ValueConstants.NOMBRE_LOGO_SERNANP;
            
            ProyectoReporte proyectoReporte=new ProyectoReporte();
            
           
            Map<String, Object> mapParam=new HashMap<String, Object>();
            mapParam.put("rutaArchivo", rutaArchivo);
            mapParam.put("rutaImagen", rutaImagen);
            mapParam.put("nombreImagen", nombreImagen);
            mapParam.put("titulo", titulo);
            mapParam.put("formateador", formateador);
            mapParam.put("formateador2", formateador2);
            mapParam.put("user", user);
            if(idtipoexp==ValueConstants.TIPO_EXP_EXCEL){
        	 
            	 nombreArchivo="Proyectos.xls";
            	 String ruta= proyectoReporte.exportarExcelProyecto(lista, mapParam);
            	 try {
					resultadoListaProyecto= new FileInputStream(new File(ruta));
					File filedel=new File(ruta);
					filedel.delete();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   		
        	 
        }
     
         else
        	  if(idtipoexp==ValueConstants.TIPO_EXP_PDF){
        		  nombreArchivo="Proyectos.pdf";
        		 String ruta=proyectoReporte.exportarPdfProyecto(lista, mapParam);
        		 try {
					resultadoListaProyecto= new FileInputStream(new File(ruta));
					File filedel=new File(ruta);
					filedel.delete();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	  }
                 
        		 return resultadoListaProyecto;
	}
	
	
	
	
	public String generarReporteCantidadProyectoVsAreaNatural(){
		List<AreanaturalParam> listaArea=new ArrayList<AreanaturalParam>();
		List<AreanaturalParam> listaAreaResT=new ArrayList<AreanaturalParam>();
		List<AreanaturalParam> listaAreaResV=new ArrayList<AreanaturalParam>();
		List<AreanaturalParam> listaAreaResC=new ArrayList<AreanaturalParam>();
		listaArea=areaNaturalService.consultarCantidadProyectosxAreasNaturales();
		
		listaAreaResT=areaNaturalService.consultarMayorCantidadProyectosxAreasNaturales(10,ValueConstants.TOTAL);
		listaAreaResV=areaNaturalService.consultarMayorCantidadProyectosxAreasNaturales(10,ValueConstants.VIGENTES);
		listaAreaResC=areaNaturalService.consultarMayorCantidadProyectosxAreasNaturales(10,ValueConstants.CONCLUIDOS);
		datosJson = JSONArray.fromObject(
				listaArea)
				.toString();
		datosJson2 = JSONArray.fromObject(
				listaAreaResT)
				.toString();   
		datosJson3 = JSONArray.fromObject(
				listaAreaResV)
				.toString();
		
		datosJson4 = JSONArray.fromObject(
				listaAreaResC)
				.toString();
		//calcular total
		int total=0;
		int vigentes=0;
		int vencidos=0;
		for(AreanaturalParam ap: listaArea ){
			total+=ap.getCantidadProyectos();
			vigentes+=ap.getCantidadProyectosVigente();
			vencidos+=ap.getCantidadProyectosVencidos();
		}
		AreanaturalParam atotal=new AreanaturalParam();
		atotal.getAreanatural().setDesareanatural("TOTAL");
		atotal.setCantidadProyectos(total);
		atotal.setCantidadProyectosVigente(vigentes);
		atotal.setCantidadProyectosVencidos(vencidos);
		listaArea.add(atotal);
		listaConsolidadoAreaNatural=listaArea;
		return "success";
	}
	
	
	
    public String generarReporteMontoProyectoVsAreaNatural(){
    	
    	List<AreanaturalParam> listaArea=new ArrayList<AreanaturalParam>();
		List<AreanaturalParam> listaAreaResT=new ArrayList<AreanaturalParam>();
		List<AreanaturalParam> listaAreaResV=new ArrayList<AreanaturalParam>();
		List<AreanaturalParam> listaAreaResC=new ArrayList<AreanaturalParam>();
		listaArea=areaNaturalService.consultarMontoProyectosxAreasNaturales();
		listaAreaResT=areaNaturalService.consultarMayorMontoProyectosxAreasNaturales(10,ValueConstants.TOTAL);
		listaAreaResV=areaNaturalService.consultarMayorMontoProyectosxAreasNaturales(10,ValueConstants.VIGENTES);
		listaAreaResC=areaNaturalService.consultarMayorMontoProyectosxAreasNaturales(10,ValueConstants.CONCLUIDOS);
		datosJson = JSONArray.fromObject(
				listaArea)
				.toString();
		datosJson2 = JSONArray.fromObject(
				listaAreaResT)
				.toString();   
		datosJson3 = JSONArray.fromObject(
				listaAreaResV)
				.toString();
		
		datosJson4 = JSONArray.fromObject(
				listaAreaResC)
				.toString();
		//calcular total
		double total=0;
		double vigentes=0;
		double vencidos=0;
		for(AreanaturalParam ap: listaArea ){
			total+=ap.getMontoTotalProyectos();
			vigentes+=ap.getMontoTotalVigente();
			vencidos+=ap.getMontoTotalVencido();
		}
		AreanaturalParam atotal=new AreanaturalParam();
		atotal.getAreanatural().setDesareanatural("TOTAL");
		atotal.setMontoTotalProyectos(total);
		atotal.setMontoTotalVigente(vigentes);
		atotal.setMontoTotalVencido(vencidos);
		listaArea.add(atotal);
		listaConsolidadoAreaNatural=listaArea;   
		return "success";
	}
	
    
    public String consultarReporteProyectoxAreaNatural(){
		
		
    	areanatural=areaNaturalService.consultarAreaNaturalxCodigo(codareanatural);
		if(areanatural!=null){
			listaProyecto= proyectoService.consultarProyectosxIdAreaNatural(areanatural.getIdareanatural());
			if(listaProyecto.size()==0){
				areanatural.setIdareanatural(0);
			}
			else{
				
				
				AreanaturalParam apc=areaNaturalService.consultarCantidadProyectosxIdAreaNatural(areanatural.getIdareanatural());
				AreanaturalParam apm=areaNaturalService.consultarMontoProyectosxIdAreaNatural(areanatural.getIdareanatural());
				listaProyectoFteFto=fuenteFinanciamientoService.consultarInstitucionesFuentesxIdAreaNatural(areanatural.getIdareanatural());
				
				apm.setMontoTotalProyectos( ProyectoUtil.redondear(apm.getMontoTotalProyectos(), 2));
				apm.setMontoTotalVigente(ProyectoUtil.redondear(apm.getMontoTotalVigente(), 2));
				apm.setMontoTotalVencido(ProyectoUtil.redondear(apm.getMontoTotalVencido(), 2));
				double tot= ProyectoUtil.redondear(apm.getMontoTotalProyectos(), 2);
				double vig= ProyectoUtil.redondear(apm.getMontoTotalVigente(), 2);
				double ven= ProyectoUtil.redondear(apm.getMontoTotalVencido(), 2);
				
				 SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
				
			
				for(Proyecto p: listaProyecto){
					if(p.getFechainicioproyecto()!=null){
					
						p.setFechainicio(formateador.format(p.getFechainicioproyecto()));
					   
					}
					else{
						p.setFechainicio("");
					}
					if(p.getFechafinproyecto()!=null){
						p.setFechafin(formateador.format(p.getFechafinproyecto()));
					}
					else{
						p.setFechafin("");
					}	
					
					p.setFechafinproyecto(null);
					p.setFechainicioproyecto(null);
				}
				
				datosJson = JSONArray.fromObject(
						listaProyecto)
						.toString();	
				apc.setMontoTotalVigente(apm.getMontoTotalVigente());
				apc.setMontoTotalVencido(apm.getMontoTotalVencido());
				datosJson2 = JSONArray.fromObject(
						apc)
						.toString();	
				
				for(ProyectoFteFto pf:listaProyectoFteFto){
					pf.setMonto(ProyectoUtil.redondear(pf.getMonto(), 2));
				}
				
				
				
				
				datosJson3 = JSONArray.fromObject(
						listaProyectoFteFto)
						.toString();	
				List<ProyectoFteFto> listaProyFte=new ArrayList<ProyectoFteFto>();
			    int numfuentes=listaProyectoFteFto.size();
			    //listaProyFte= fuenteFinanciamientoService.consultarMayorMontoInstitucionesFuentesxIdAreaNatural(4, areanatural.getIdareanatural());
			    listaProyFte= fuenteFinanciamientoService.consultarMayorMontoInstitucionesFuentesxIdAreaNatural(4, areanatural.getIdareanatural());
			    
			     
			     for(ProyectoFteFto pf:listaProyFte){
						pf.setMonto(ProyectoUtil.redondear(pf.getMonto(), 2));
				     
			     }
				
			     listaProyFte=fuenteFinanciamientoService.consultarMayorMontoVariosInstitucionesFuentesxIdAreaNatural(listaProyFte);
			     
			     //salidas
			     listaProyectoFteFto=fuenteFinanciamientoService.calcularTotalFuentes(listaProyFte);
			     datosJson4 = JSONArray.fromObject(
							listaProyFte)
							.toString();		

				
			}
			
		
		
		}
		
	
		return "success";
	}
    
   
	public String buscarProyectos(){
		Proyecto p=new Proyecto();
		p.setNombreproyecto(cadenaParam);
		List<Proyecto> listaProy=proyectoService.consultarProyectos(p);
	  	datos.put("proyectos",listaProy );
		return "success";
	}
	
	public String buscarTipoCambio(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		int anio =  Integer.parseInt(request.getParameter("idanio").toString());
		int mes =  Integer.parseInt(request.getParameter("idmes").toString());
		int idmoneda =  Integer.parseInt(request.getParameter("idmoneda").toString());
		Tipocambio tc=new Tipocambio();
		tc.setAnio(anio);
		tc.setMes(mes);
		tc.getMonedaOrigen().setIdmoneda(idmoneda);
		tc.getMonedaDestino().setIdmoneda(ValueConstants.MONEDA_SOL);
		tc=tipoCambioService.consultarTipoCambioMensual(tc);
		datos.put("tipocambio",tc.getValor());
		datos.put("idtipocambio",tc.getIdtipocambio());
		return "success";
	}
	
	
	
	
	public String buscarEjecutores(){
		Ejecutor ejecutor=new Ejecutor();
		
		if(idopcion==1){
			ejecutor.getPersonajuridica().setNombrepersonajuridica(cadenaParam);
		}
		else
			 if(idopcion==2){
				 ejecutor.getPersonajuridica().setSiglas(cadenaParam); 
			 }
		List<Ejecutor> listaEjec=ejecutorService.consultarInstitucionesEjecutoras(ejecutor);
		datos.put("ejecutoras",listaEjec);
		return "success";
	}
	
	
	public String buscarFuenteFinanciamiento(){
		Fuentefinanciamiento fte=new Fuentefinanciamiento();
		if(idopcion==1){
			fte.getPersonajuridica().setNombrepersonajuridica(cadenaParam);
		}
		else
			 if(idopcion==2){
				 fte.getPersonajuridica().setSiglas(cadenaParam); 
			 }
		
		List<Fuentefinanciamiento> listaFte=fuenteFinanciamientoService.consultarInstitucionesFuentes(fte);
		//List<Ejecutor> listaEjec=ejecutorService.consultarInstitucionesEjecutoras(ejecutor);
		
		datos.put("fuentes",listaFte);
		return "success";
	}
	
	
	public String guardarRegistroInstitucion(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String nombre = String.valueOf(request.getParameter("nombre"));
		String siglas = String.valueOf(request.getParameter("siglas"));
		String dir = String.valueOf(request.getParameter("direccion"));
	    int telf=0;
		String stelf=request.getParameter("telefono").toString();
	    stelf= stelf.trim();
	    if(!stelf.equals("")){
	    	telf=Integer.parseInt(stelf);
	    }
		  
		int idpais =  Integer.parseInt(request.getParameter("pais").toString());
		String email = String.valueOf(request.getParameter("email"));
		int opcion =  Integer.parseInt(request.getParameter("codTipoInstitucion").toString());
		
		Personajuridica pj=new Personajuridica();
		if(!nombre.equals("")){
			pj.setNombrepersonajuridica(nombre);	
		}
		if(!siglas.equals("")){
			pj.setSiglas(siglas);	
		}
		if(!dir.equals("")){
			pj.getPersona().setDireccion(dir);	
		}
		if(!email.equals("")){
			pj.getPersona().setEmail(email);	
		}
		pj.getPersona().setTelefono(telf);
		int codigo=0;
		pj.getPersona().getPais().setIdpais(idpais);
		int codigoPersonaJuridica= personaJuridicaService.guardarInstitucion(pj);
		
		
		if(opcion==ValueConstants.EJECUTOR_FINANCIERO || opcion==ValueConstants.EJECUTOR_TECNICO){
			Ejecutor ejecutor=new Ejecutor();
			ejecutor.getPersonajuridica().setIdpersonajuridica(codigoPersonaJuridica);
			codigo= ejecutorService.guardarEjecutor(ejecutor);
		}
		else 
			if(opcion==ValueConstants.FUENTE_FINANCIAMIENTO)
				{
				Fuentefinanciamiento fuente=new Fuentefinanciamiento();
				fuente.getPersonajuridica().setIdpersonajuridica(codigoPersonaJuridica);
				codigo=fuenteFinanciamientoService.guardarFuenteFinanciamiento(fuente);
				}
		
		datos.put("codigo", codigo);
		datos.put("nombre", nombre);
		
		return "success";
	}
	
	
	
	public List<Areanatural> getListaAreaNatural() {
		return listaAreaNatural;
	}


	public void setListaAreaNatural(List<Areanatural> listaAreaNatural) {
		this.listaAreaNatural = listaAreaNatural;
	}


	public List<Integer> getListaPagina() {
		return listaPagina;
	}


	public void setListaPagina(List<Integer> listaPagina) {
		this.listaPagina = listaPagina;
	}


	public int getTotalRegistros() {
		return totalRegistros;
	}


	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}


	


	public List<Proyecto> getListaProyecto() {
		return listaProyecto;
	}


	public void setListaProyecto(List<Proyecto> listaProyecto) {
		this.listaProyecto = listaProyecto;
	}

	
	
	
	


	private ProyectoService proyectoService;
	private AreaNaturalService areaNaturalService;
	private EjecutorService ejecutorService;
	private FuenteFinanciamientoService fuenteFinanciamientoService;
	private CategoriaAnpService categoriaAnpService;
	private TipoService tipoService;
	private EstadoService estadoService;
	private MonedaService monedaService;
	private PersonaJuridicaService personaJuridicaService;
	private PaisService paisService;
	private ArchivoService archivoService;
	private TipoCambioService tipoCambioService;

	
	

	
	
	public void setTipoCambioService(TipoCambioService tipoCambioService) {
		this.tipoCambioService = tipoCambioService;
	}



	public void setArchivoService(ArchivoService archivoService) {
		this.archivoService = archivoService;
	}



	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}



	public void setPersonaJuridicaService(
			PersonaJuridicaService personaJuridicaService) {
		this.personaJuridicaService = personaJuridicaService;
	}



	public void setMonedaService(MonedaService monedaService) {
		this.monedaService = monedaService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}


	public void setCategoriaAnpService(CategoriaAnpService categoriaAnpService) {
		this.categoriaAnpService = categoriaAnpService;
	}


	public void setEjecutorService(EjecutorService ejecutorService) {
		this.ejecutorService = ejecutorService;
	}


	public void setFuenteFinanciamientoService(
			FuenteFinanciamientoService fuenteFinanciamientoService) {
		this.fuenteFinanciamientoService = fuenteFinanciamientoService;
	}


	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	


	

	public void setAreaNaturalService(AreaNaturalService areaNaturalService) {
		this.areaNaturalService = areaNaturalService;
	}


	public int getIndice() {
		return indice;
	}


	public void setIndice(int indice) {
		this.indice = indice;
	}


	


	public int getNumeroPagina() {
		return numeroPagina;
	}


	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public int getIdProyectoParam() {
		return idProyectoParam;
	}


	public void setIdProyectoParam(int idProyectoParam) {
		this.idProyectoParam = idProyectoParam;
	}


	

	public List<Tipo> getListaTipoProyecto() {
		return listaTipoProyecto;
	}


	public void setListaTipoProyecto(List<Tipo> listaTipoProyecto) {
		this.listaTipoProyecto = listaTipoProyecto;
	}


	public List<Ejecutor> getListaEjecutor() {
		return listaEjecutor;
	}


	public void setListaEjecutor(List<Ejecutor> listaEjecutor) {
		this.listaEjecutor = listaEjecutor;
	}


	public List<Fuentefinanciamiento> getListaFtefto() {
		return listaFtefto;
	}


	public void setListaFtefto(List<Fuentefinanciamiento> listaFtefto) {
		this.listaFtefto = listaFtefto;
	}


	public List<Categoriaanp> getListaCategoriaAnp() {
		return listaCategoriaAnp;
	}


	public void setListaCategoriaAnp(List<Categoriaanp> listaCategoriaAnp) {
		this.listaCategoriaAnp = listaCategoriaAnp;
	}


	public int getIdCategoriaAnpParam() {
		return idCategoriaAnpParam;
	}


	public void setIdCategoriaAnpParam(int idCategoriaAnpParam) {
		this.idCategoriaAnpParam = idCategoriaAnpParam;
	}


	public List<Integer> getListaCodigos() {
		return listaCodigos;
	}


	public void setListaCodigos(List<Integer> listaCodigos) {
		this.listaCodigos = listaCodigos;
	}


	public List<Integer> getListaCodigosArea() {
		return listaCodigosArea;
	}


	public void setListaCodigosArea(List<Integer> listaCodigosArea) {
		this.listaCodigosArea = listaCodigosArea;
	}


	public int getMensaje() {
		return mensaje;
	}


	public void setMensaje(int mensaje) {
		this.mensaje = mensaje;
	}




	public List<Objeto> getListaObjetoArea() {
		return listaObjetoArea;
	}


	public void setListaObjetoArea(List<Objeto> listaObjetoArea) {
		this.listaObjetoArea = listaObjetoArea;
	}


	public int getPagina() {
		return pagina;
	}


	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public int getControl() {
		return control;
	}

	public void setControl(int control) {
		this.control = control;
	}

	public List<Objeto> getListaObjetoEjecutor() {
		return listaObjetoEjecutor;
	}

	public void setListaObjetoEjecutor(List<Objeto> listaObjetoEjecutor) {
		this.listaObjetoEjecutor = listaObjetoEjecutor;
	}

	public List<Objeto> getListaObjetoFteFto() {
		return listaObjetoFteFto;
	}

	public void setListaObjetoFteFto(List<Objeto> listaObjetoFteFto) {
		this.listaObjetoFteFto = listaObjetoFteFto;
	}

	public List<Integer> getListaCodigosEjecutor() {
		return listaCodigosEjecutor;
	}

	public void setListaCodigosEjecutor(List<Integer> listaCodigosEjecutor) {
		this.listaCodigosEjecutor = listaCodigosEjecutor;
	}

	public List<Estado> getListaEstadoVigencia() {
		return listaEstadoVigencia;
	}

	public void setListaEstadoVigencia(List<Estado> listaEstadoVigencia) {
		this.listaEstadoVigencia = listaEstadoVigencia;
	}

	public List<Moneda> getListaMoneda() {
		return listaMoneda;
	}

	public void setListaMoneda(List<Moneda> listaMoneda) {
		this.listaMoneda = listaMoneda;
	}

	public ProyectoParam getProyectoParam() {
		return proyectoParam;
	}

	public void setProyectoParam(ProyectoParam proyectoParam) {
		this.proyectoParam = proyectoParam;
	}

	public int getIdCodigoParam() {
		return idCodigoParam;
	}

	public void setIdCodigoParam(int idCodigoParam) {
		this.idCodigoParam = idCodigoParam;
	}

	public List<Objeto> getListaMontosFteFto() {
		return listaMontosFteFto;
	}

	public void setListaMontosFteFto(List<Objeto> listaMontosFteFto) {
		this.listaMontosFteFto = listaMontosFteFto;
	}

	public List<Integer> getListaCodigosFte() {
		return listaCodigosFte;
	}

	public void setListaCodigosFte(List<Integer> listaCodigosFte) {
		this.listaCodigosFte = listaCodigosFte;
	}

	public List<Ejecutor> getListaEjecutorFinanciero() {
		return listaEjecutorFinanciero;
	}

	public void setListaEjecutorFinanciero(List<Ejecutor> listaEjecutorFinanciero) {
		this.listaEjecutorFinanciero = listaEjecutorFinanciero;
	}

	public List<Ejecutor> getListaEjecutorTecnico() {
		return listaEjecutorTecnico;
	}

	public void setListaEjecutorTecnico(List<Ejecutor> listaEjecutorTecnico) {
		this.listaEjecutorTecnico = listaEjecutorTecnico;
	}

	public List<Tipo> getListaCategoriaProyecto() {
		return listaCategoriaProyecto;
	}

	public void setListaCategoriaProyecto(List<Tipo> listaCategoriaProyecto) {
		this.listaCategoriaProyecto = listaCategoriaProyecto;
	}

	public List<Tipo> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(List<Tipo> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	public Map<String, Object> getDatos() {
		return datos;
	}

	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}

	public String getCadenaParam() {
		return cadenaParam;
	}

	public void setCadenaParam(String cadenaParam) {
		this.cadenaParam = cadenaParam;
	}

	public List<Integer> getListaCodigosEjecFinanciero() {
		return listaCodigosEjecFinanciero;
	}

	public void setListaCodigosEjecFinanciero(
			List<Integer> listaCodigosEjecFinanciero) {
		this.listaCodigosEjecFinanciero = listaCodigosEjecFinanciero;
	}

	public List<Integer> getListaCodigosEjecTecnico() {
		return listaCodigosEjecTecnico;
	}

	public void setListaCodigosEjecTecnico(List<Integer> listaCodigosEjecTecnico) {
		this.listaCodigosEjecTecnico = listaCodigosEjecTecnico;
	}

	public List<ProyectoFteFto> getListaProyectoFteFto() {
		return listaProyectoFteFto;
	}

	public void setListaProyectoFteFto(List<ProyectoFteFto> listaProyectoFteFto) {
		this.listaProyectoFteFto = listaProyectoFteFto;
	}

	public Personajuridica getPersonajuridica() {
		return personajuridica;
	}

	public void setPersonajuridica(Personajuridica personajuridica) {
		this.personajuridica = personajuridica;
	}



	public int getCrear() {
		return crear;
	}



	public void setCrear(int crear) {
		this.crear = crear;
	}



	public int getNumPagina() {
		return numPagina;
	}



	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}



	public void setPaginaInicial(int paginaInicial) {
		this.paginaInicial = paginaInicial;
	}



	public int getPaginaInicial() {
		return paginaInicial;
	}



	public Map<String, Integer> getPaginacion() {
		return paginacion;
	}



	public void setPaginacion(Map<String, Integer> paginacion) {
		this.paginacion = paginacion;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public List<Pais> getListaPais() {
		return listaPais;
	}



	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}



	public List<Proyecto> getListaProyectoPrincipal() {
		return listaProyectoPrincipal;
	}



	public void setListaProyectoPrincipal(List<Proyecto> listaProyectoPrincipal) {
		this.listaProyectoPrincipal = listaProyectoPrincipal;
	}



	public List<ProyectoArchivo> getListaProyectoArchivo() {
		return listaProyectoArchivo;
	}



	public void setListaProyectoArchivo(List<ProyectoArchivo> listaProyectoArchivo) {
		this.listaProyectoArchivo = listaProyectoArchivo;
	}



	public List<Archivo> getListaArchivo() {
		return listaArchivo;
	}



	public void setListaArchivo(List<Archivo> listaArchivo) {
		this.listaArchivo = listaArchivo;
	}



	public File[] getListaFlujoArchivo() {
		return listaFlujoArchivo;
	}



	public void setListaFlujoArchivo(File[] listaFlujoArchivo) {
		this.listaFlujoArchivo = listaFlujoArchivo;
	}



	public String[] getListaFlujoArchivoFileName() {
		return listaFlujoArchivoFileName;
	}



	public void setListaFlujoArchivoFileName(String[] listaFlujoArchivoFileName) {
		this.listaFlujoArchivoFileName = listaFlujoArchivoFileName;
	}



	public String[] getListaFlujoArchivoContentType() {
		return listaFlujoArchivoContentType;
	}



	public void setListaFlujoArchivoContentType(
			String[] listaFlujoArchivoContentType) {
		this.listaFlujoArchivoContentType = listaFlujoArchivoContentType;
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



	public Archivo getDocumento() {
		return documento;
	}



	public void setDocumento(Archivo documento) {
		this.documento = documento;
	}



	public Archivo getArchivo() {
		return archivo;
	}



	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}



	public int getIdarchivo() {
		return idarchivo;
	}



	public void setIdarchivo(int idarchivo) {
		this.idarchivo = idarchivo;
	}



	public int getIdtipoexp() {
		return idtipoexp;
	}



	public void setIdtipoexp(int idtipoexp) {
		this.idtipoexp = idtipoexp;
	}



	public String getNombreArchivo() {
		return nombreArchivo;
	}



	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}



	public String getDatosJson() {
		return datosJson;
	}



	public void setDatosJson(String datosJson) {
		this.datosJson = datosJson;
	}



	public int getIdopcion() {
		return idopcion;
	}



	public void setIdopcion(int idopcion) {
		this.idopcion = idopcion;
	}



	public int getIdcodigo() {
		return idcodigo;
	}



	public void setIdcodigo(int idcodigo) {
		this.idcodigo = idcodigo;
	}



	public String getNombreGenerado() {
		return nombreGenerado;
	}



	public void setNombreGenerado(String nombreGenerado) {
		this.nombreGenerado = nombreGenerado;
	}



	public Map<String, Integer> getParametro() {
		return parametro;
	}



	public void setParametro(Map<String, Integer> parametro) {
		this.parametro = parametro;
	}



	public List<AreanaturalParam> getListaConsolidadoAreaNatural() {
		return listaConsolidadoAreaNatural;
	}



	public void setListaConsolidadoAreaNatural(
			List<AreanaturalParam> listaConsolidadoAreaNatural) {
		this.listaConsolidadoAreaNatural = listaConsolidadoAreaNatural;
	}



	public String getDatosJson2() {
		return datosJson2;
	}



	public void setDatosJson2(String datosJson2) {
		this.datosJson2 = datosJson2;
	}

	


	public String getDatosJson3() {
		return datosJson3;
	}



	public void setDatosJson3(String datosJson3) {
		this.datosJson3 = datosJson3;
	}



	public String getDatosJson4() {
		return datosJson4;
	}



	public void setDatosJson4(String datosJson4) {
		this.datosJson4 = datosJson4;
	}



	


	public PiePlot getPlot() {
		return plot;
	}






	public List<Tipocambio> getListaTipoCambio() {
		return listaTipoCambio;
	}



	public void setListaTipoCambio(List<Tipocambio> listaTipoCambio) {
		this.listaTipoCambio = listaTipoCambio;
	}



	public List<Estado> getListaEstadoProyecto() {
		return listaEstadoProyecto;
	}



	public void setListaEstadoProyecto(List<Estado> listaEstadoProyecto) {
		this.listaEstadoProyecto = listaEstadoProyecto;
	}







	public String getCodigo() {
		return codigo;
	}







	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}













	public String getCodareanatural() {
		return codareanatural;
	}













	public void setCodareanatural(String codareanatural) {
		this.codareanatural = codareanatural;
	}













	public Areanatural getAreanatural() {
		return areanatural;
	}













	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}













	public String getNombreproyecto() {
		return nombreproyecto;
	}













	public void setNombreproyecto(String nombreproyecto) {
		this.nombreproyecto = nombreproyecto;
	}













	public List<Tipo> getListaAnio() {
		return listaAnio;
	}













	public void setListaAnio(List<Tipo> listaAnio) {
		this.listaAnio = listaAnio;
	}













	public List<Tipo> getListaMes() {
		return listaMes;
	}













	public void setListaMes(List<Tipo> listaMes) {
		this.listaMes = listaMes;
	}













	public Usuario getUsuario() {
		return usuario;
	}













	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}













	public List<ProyectoEjecutor> getListaProyectoEjecutor() {
		return listaProyectoEjecutor;
	}













	public void setListaProyectoEjecutor(
			List<ProyectoEjecutor> listaProyectoEjecutor) {
		this.listaProyectoEjecutor = listaProyectoEjecutor;
	}













	public List<ProyectoEjecutor> getListaProyectoEjecutorFinanciero() {
		return listaProyectoEjecutorFinanciero;
	}













	public void setListaProyectoEjecutorFinanciero(
			List<ProyectoEjecutor> listaProyectoEjecutorFinanciero) {
		this.listaProyectoEjecutorFinanciero = listaProyectoEjecutorFinanciero;
	}













	public List<ProyectoEjecutor> getListaProyectoEjecutorTecnico() {
		return listaProyectoEjecutorTecnico;
	}






	







	public void setListaProyectoEjecutorTecnico(
			List<ProyectoEjecutor> listaProyectoEjecutorTecnico) {
		this.listaProyectoEjecutorTecnico = listaProyectoEjecutorTecnico;
	}


	
	











	
	




	



	



	



	
	
	
	


	
	

}
