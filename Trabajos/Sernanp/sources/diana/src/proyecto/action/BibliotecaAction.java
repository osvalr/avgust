package proyecto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StreamResult;

import proyecto.constants.ValueConstants;
import proyecto.param.AreanaturalSel;
import proyecto.param.RecursoInformacionParam;
import proyecto.reportes.RecursoInformacionReporte;
import proyecto.service.ArchivoService;
import proyecto.service.AreaNaturalService;
import proyecto.service.AreaOrganicaService;
import proyecto.service.AutorService;
import proyecto.service.CategoriaAnpService;
import proyecto.service.EditorialService;
import proyecto.service.IdiomaService;
import proyecto.service.PaisService;
import proyecto.service.PersonaJuridicaService;
import proyecto.service.PersonaNaturalService;
import proyecto.service.PersonalService;
import proyecto.service.RecursoInformacionService;
import proyecto.service.TemaService;
import proyecto.service.TematicaRecursoInformacionService;
import proyecto.service.TipoService;
import proyecto.util.Pagination;
import proyecto.vo.Archivo;
import proyecto.vo.Areanatural;
import proyecto.vo.Areaorganica;
import proyecto.vo.Autor;
import proyecto.vo.Categoriaanp;
import proyecto.vo.Editorial;
import proyecto.vo.Idioma;
import proyecto.vo.Objeto;
import proyecto.vo.Pais;
import proyecto.vo.Personajuridica;
import proyecto.vo.Personal;
import proyecto.vo.Personanatural;
import proyecto.vo.RecursoInformacion;
import proyecto.vo.RecursoInformacionAreanatural;
import proyecto.vo.RecursoInformacionEditorial;
import proyecto.vo.Tema;
import proyecto.vo.TematicaRecursoInformacion;
import proyecto.vo.Tipo;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;

public class BibliotecaAction extends ActionSupport {
	
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RecursoInformacion recursoinformacion;
	private List<RecursoInformacion> listaRecursoInformacion;
	private List<Tipo> listaTipoRecursoInformacion;
	private List<Tipo> listaMedioRecursoInformacion;
	private List<TematicaRecursoInformacion> listaTematicaRecursoInformacion;
	private List<RecursoInformacionEditorial> listaRecursoInformacionEditorial;
	private List<Categoriaanp> listaCategoriaAnp;
	private List<Areanatural> listaAreaNatural;
	private List<Idioma> listaIdioma; 
	private List<TematicaRecursoInformacion> listaTematica;
	private List<Pais> listaPais;
	private List<Tipo> listaTipoDocumentoIdentidad;
	private List<Tipo> listaGenero;
	private List<Tipo> listaAnioPublicacion;
	private List<AreanaturalSel> listaAreaNaturalSel;
	private List<Areanatural> listaSedeBiblioteca;
	private List<Areaorganica> listaAreaOrganica;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private int idrecursoinformacion;
	private int idcodigo;
	private int idpagina;
	private int idpestania;
	private int idopcion;
	private String rutaImagen;
	private InputStream imagenPortada;
	private String cadena;
	private Map<String,Object> datos;
	private InputStream archivoBiblioteca;
	private String nombrearchivo;
	private Pagination paginacion;
	private int idrecursoinformacionparam;
	private List<Integer> listaCodigos;
	private InputStream resultadoListaRecursoInformacion;
	private InputStream resultadoRecursoInformacion;
	private String nombreArchivo;
	private int temporal;
	
	public BibliotecaAction(){
		recursoinformacion=new RecursoInformacion();
		listaTipoRecursoInformacion=new ArrayList<Tipo>();
		listaMedioRecursoInformacion=new ArrayList<Tipo>();
		listaTematicaRecursoInformacion=new ArrayList<TematicaRecursoInformacion>();
		listaIdioma=new ArrayList<Idioma>();
		datos=new HashMap<String, Object>();
		listaRecursoInformacionEditorial=new ArrayList<RecursoInformacionEditorial>();
		listaAreaNaturalSel=new ArrayList<AreanaturalSel>();
		listaCategoriaAnp=new ArrayList<Categoriaanp>();
		listaAreaNatural=new ArrayList<Areanatural>();
		listaSedeBiblioteca=new ArrayList<Areanatural>();
		listaAreaOrganica=new ArrayList<Areaorganica>();
		listaPais=new ArrayList<Pais>();
		listaTipoDocumentoIdentidad=new ArrayList<Tipo>();
		listaGenero=new ArrayList<Tipo>();
		listaRecursoInformacion=new ArrayList<RecursoInformacion>();
		listaTematica=new ArrayList<TematicaRecursoInformacion>();
		paginacion=new Pagination();
		listaCodigos=new ArrayList<Integer>();
		listaAnioPublicacion=new ArrayList<Tipo>();
	}
	

	
	
	
	 
	
	
	public String consultarRecursosInformacion(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		 RecursoInformacionParam recursoInformacionParam=new RecursoInformacionParam();
		String resultado="";
		
		int control=0;
		if(request.getParameter("control")==null){
			control=1;
		}
		else{
			control=Integer.parseInt(request.getParameter("control").toString());
		}
		int numeropagina=0;
		if(request.getParameter("control")==null){
			numeropagina=0;
		}
		else{
			numeropagina=Integer.parseInt(request.getParameter("numeropagina").toString());
		}
		if(control==ValueConstants.LINK_INICIO){
			//listaCategoriaAnp=categoriaAnpService.listarCategoriasAnpsActivas();
			listaCategoriaAnp=recursoInformacionService.listarCategoriasAnpConRecursosInformacion();
			//listaAreaNatural=areaNaturalService.listarAreasNaturales();
			listaAreaNatural=recursoInformacionService.listarAreasNaturalesConRecursosInformacion();
			listaIdioma=idiomaService.listarIdiomas();
			listaTematica=tematicaRecursoInformacionService.listarTematicas();
			listaTipoRecursoInformacion=tipoService.listarTipoRecursoInformacion();
			listaMedioRecursoInformacion=tipoService.listarMedioRecursoInformacion();
		}
		if(control==ValueConstants.CONTROL_NUMPAGINA){
			String titulo = String.valueOf(request.getParameter("titulo"));
			int idtipo =  Integer.parseInt(request.getParameter("idtipo").toString());
			int idmedio =  Integer.parseInt(request.getParameter("idmedio").toString());
			int idcategoriaanp =  Integer.parseInt(request.getParameter("idcategoriaanp").toString());
			int idanp =  Integer.parseInt(request.getParameter("idareanatural").toString());
			int ididioma =  Integer.parseInt(request.getParameter("ididioma").toString());
			int idtematica =  Integer.parseInt(request.getParameter("idtematica").toString());
			String nomautor = String.valueOf(request.getParameter("nomautor"));
			String codsgd = String.valueOf(request.getParameter("codsgd"));
			if(!titulo.equals("")){
				recursoInformacionParam.getRecursoinformacion().setTitulo(titulo);
			}
			if(!nomautor.equals("")){
				recursoInformacionParam.getAutor().setNombre(nomautor);
			}
			if(!codsgd.equals("")){
				recursoInformacionParam.getRecursoinformacion().setCodigosgd(codsgd);
			}
			recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().setIdtipo(idtipo);
			recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().setIdtipo(idmedio);
			recursoInformacionParam.getRecursoinformacion().getIdioma().setIdidioma(ididioma);
			recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().setIdtematicarecursoinformacion(idtematica);
			recursoInformacionParam.getAreanatural().setIdareanatural(idanp);
			recursoInformacionParam.getAreanatural().getCategoriaanp().setIdcategoriaanp(idcategoriaanp);
			
		}
		ResourceBundle labels = ResourceBundle
		.getBundle("proyecto.resources.proyectoparametros");
	    String tamPagina=labels.getString("tamanio_pagina");
	    int tamanio=Integer.parseInt(tamPagina);
	    
	    
        if(control==ValueConstants.LINK_INICIO ){
        	//recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
        	recursoInformacionParam.getRecursoinformacion().setFlagtemporal(ValueConstants.VALOR_CERO);
        	paginacion=recursoInformacionService.calcularPaginacion(recursoInformacionParam,tamanio,numeropagina);
		    System.out.println("pag inicial"+paginacion.getTotal());
        	if(paginacion.getTotal()==0){
		    	recursoInformacionParam.getRecursoinformacion().setFlagtemporal(ValueConstants.FLAG_ACTIVO);
		    	paginacion=recursoInformacionService.calcularPaginacion(recursoInformacionParam,tamanio,numeropagina);
		    }
        	else{
        		temporal=1;
        	}
        }
	    
	    
        paginacion=recursoInformacionService.calcularPaginacion(recursoInformacionParam,tamanio,numeropagina);
	    
	    if(control==ValueConstants.LINK_INICIO ){
	    	
	    	if(temporal==1){
	    		listaRecursoInformacion=recursoInformacionService.consultarRecursoInformacionPaginadoTemporales( recursoInformacionParam, 0,tamanio);
		    }else{
		    	listaRecursoInformacion=recursoInformacionService.consultarRecursoInformacionPaginado(recursoInformacionParam, 0, tamanio);
		    }
	    	
		    resultado="inicio";
			
		}
		else 
			if(control==ValueConstants.CONTROL_NUMPAGINA){
				int indice=0;
	    	    indice=((numeropagina-1)*tamanio);
	    	    listaRecursoInformacion=recursoInformacionService.consultarRecursoInformacionPaginado( recursoInformacionParam,indice,tamanio);
	    	    resultado="lista";
			}
	   
	    
	    for(int i=0;i<listaRecursoInformacion.size();i++){
			listaRecursoInformacion.set(i,recursoInformacionService.consultarDetalleRecursoInformacionxId(listaRecursoInformacion.get(i).getIdrecursoinformacion()));
		}
	    
	    
	    session.put("idpestaniaVS", 0);
		session.put("idrecursoVS", 0);
		return resultado;
	}


	
	public String consultarDetalleRecursoInformacion(){
		
		recursoinformacion=recursoInformacionService.consultarDetalleRecursoInformacionxId(idrecursoinformacionparam);
		
		return "success";
	}
	
	//mar ve qui
	
    public String irRegistroRecursoInformacion(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    	String rutaBibliotecaImagen = labels.getString("ruta_repositorio_imagen_biblioteca_portada");
        List<Areanatural> listaAreaNatural=areaNaturalService.listarAreasNaturales();
        listaCategoriaAnp=categoriaAnpService.listarCategoriasAnpsActivas();
    	listaTipoRecursoInformacion=tipoService.listarTipoRecursoInformacion();
		listaMedioRecursoInformacion=tipoService.listarMedioRecursoInformacion();
		listaAnioPublicacion=tipoService.listarAniosPublicacion();
		listaTematicaRecursoInformacion=tematicaRecursoInformacionService.listarTematicas();
		listaIdioma=idiomaService.listarIdiomas();
		listaSedeBiblioteca=areaNaturalService.listarSedes();
		listaAreaOrganica=areaOrganicaService.listarAreasOrganicas();
		listaPais=paisService.listar();
		listaGenero=tipoService.listarGenero();
		listaTipoDocumentoIdentidad=tipoService.listarTipoDocumentoIdentidad();
		
		
		if(idrecursoinformacionparam==0){
			//nuevo
			//fill areas naturales del modal
			for(Areanatural a:listaAreaNatural){
				AreanaturalSel asel=new AreanaturalSel();
				asel.setAreanatural(a);
				asel.setIdareanaturalsel(0);
				listaAreaNaturalSel.add(asel);
			}
		}
		else{
			//actualizar
			if(request.getParameter("pagina")!=null){
				if(Integer.parseInt(request.getParameter("pagina").toString())==1){
		        	idpagina=1;
				}
			}
			
			System.out.println("idparam"+idrecursoinformacionparam);
			recursoinformacion=recursoInformacionService.consultarDetalleRecursoInformacionxId(idrecursoinformacionparam);
			//fill areas naturales del modal
			 //relacionar clave valor de areas del recurso  
			/*
			for(RecursoInformacionArchivo ra:recursoinformacion.getListaRecursoInformacionArchivo()){
				System.out.println("idra"+ra.getIdrecursoinformacionarchivo());
			}
			*/
			Map< Integer, String> mapArea=new HashMap<Integer, String>(); 
			 for( RecursoInformacionAreanatural rian:  recursoinformacion.getListaRecursoInformacionAreanatural()){
				 mapArea.put(rian.getAreanatural().getIdareanatural(), rian.getAreanatural().getDesareanatural());
			 }
			//
			 for(Areanatural a:listaAreaNatural){
					AreanaturalSel asel=new AreanaturalSel();
					asel.setAreanatural(a);
					 if( mapArea.containsKey(a.getIdareanatural()) ){
							asel.setFlagseleccion(1);
					   }
					listaAreaNaturalSel.add(asel);
				}
			 
			
			 
			
			
		}
		session.put("mapArchivoVS", new HashMap<Integer, Object>());
		 //imagen
		 if(recursoinformacion.getListaRecursoInformacionArchivo().size()!=0){
			 rutaImagen=rutaBibliotecaImagen+recursoinformacion.getListaRecursoInformacionArchivo().get(1).getArchivo().getNombreGenerado();
			 System.out.println(rutaImagen);
			 session.put("rutaImagenVS", rutaImagen);
		 
		 }
		 else{
			 session.put("rutaImagenVS", "");
		 }
		
		System.out.println("personal:"+recursoinformacion.getAprobacionrecursoinformacion().getPersonal().getIdpersonal());
		
		int fuente=0;
        if(request.getParameter("fuente")==null){
        	return "success";
		}
		else{
			return "registro";
		}
		
		
	
    
    }
	
	
	public String guardarRegistroRecursoInformacion(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Map<Integer,Object> mapArchivo=(Map<Integer, Object>) session.get("mapArchivoVS");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		System.out.println("personal guard:"+recursoinformacion.getAprobacionrecursoinformacion().getPersonal().getIdpersonal());
		int idrecurso=0;
		recursoinformacion.getListaRecursoInformacionEditorial().removeAll(Collections.singleton(null)); 
		recursoinformacion.getListaRecursoInformacionAutor().removeAll(Collections.singleton(null)); 
		recursoinformacion.getListaRecursoInformacionTema().removeAll(Collections.singleton(null)); 
		 String resultado="";
		//recursoinformacion.getListaRecursoInformacionArchivo().removeAll(Collections.singleton(null));
		for(int i=0;i<recursoinformacion.getListaRecursoInformacionArchivo().size();i++){		    
	     if(mapArchivo.get( recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().getIdcodigo())!=null){
			    	Archivo a=new Archivo();
			    	a=  (Archivo) mapArchivo.get(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().getIdcodigo());
										//recursoinformacion.getListaRecursoInformacionArchivo().get(i).getTipoarchivo().setIdtipo(a.getIdcodigo());
			    	recursoinformacion.getListaRecursoInformacionArchivo().get(i).setArchivo(a);
			    	recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().setFechaUpload(new Date()) ;
		}else
			    	if(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().getIdarchivo()==0){
			    		recursoinformacion.getListaRecursoInformacionArchivo().get(i).setArchivo(null);
			    	}      
		}
		
		
	   
		int siguiente=0;
        if(request.getParameter("siguiente")==null){
        	resultado="registro";
		}
		else{
			 siguiente= Integer.parseInt(request.getParameter("siguiente").toString());
			 recursoinformacion.setFlagtemporal(ValueConstants.FLAG_ACTIVO);
			 //recursoinformacion.setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
			 if(siguiente==2){
				resultado="crea";
			  }else
				if(siguiente==3){
					//recursoinformacion.getSedebiblioteca().setIdareanatural(0);
					resultado="actualiza";
				}
			
		}
        
	    idrecurso=recursoInformacionService.guardarRecursoinformacion(recursoinformacion);
		idcodigo=idrecurso;
	   return resultado;
	}


	
	
	
	
	public String cargarArchivoBiblioteca(){
		  
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		Map<Integer,Object> mapArchivo=(Map<Integer, Object>) session.get("mapArchivoVS");
		 Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
		ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
		String rutaBibliotecaDocumento = labels.getString("ruta_repositorio_documento_biblioteca"); 
		String rutaBibliotecaImagen = labels.getString("ruta_repositorio_imagen_biblioteca_portada");
		 
		System.out.println(idcodigo);
		 if(file!=null){
			 Archivo a=new Archivo();
			 a.setNombreInicial(fileFileName);
			 Date instante=new Date();
 			 long inst =instante.getTime();
 			 int pos=fileFileName.lastIndexOf('.');
 			 String ext=fileFileName.substring(pos);
 			 fileFileName=inst+ext;
 			 String nameInst=String.valueOf(inst);
 			 File archivoGuardado=null;
 			 if(idcodigo==ValueConstants.TIPO_FILE_DOCUMENTO){
 				archivoGuardado = new File(rutaBibliotecaDocumento, fileFileName);
 				String rutaDocumento=rutaBibliotecaDocumento+fileFileName; 
 				Map<String, Object> mapDocumento=new HashMap<String, Object>();
				mapDocumento.put("archivo",a);
				mapDocumento.put("rutadocumento", rutaDocumento);
 				session.put("mapdocumentoVS", mapDocumento);
 			 }
 			 else
 				if(idcodigo==ValueConstants.TIPO_FILE_IMAGEN){
 					archivoGuardado = new File(rutaBibliotecaImagen, fileFileName);
 					rutaImagen=rutaBibliotecaImagen+fileFileName; 
 					 session.put("rutaImagenVS", rutaImagen);
 				}
 			 
 			 file.renameTo(archivoGuardado);
 			 a.setNombreGenerado(fileFileName);
 			 //a.getUsuario().setIdUsuario(user.getIdUsuario());
 			a.getUsuario().setIdUsuario(1);
 			 a.setIdcodigo(idcodigo);
 			 mapArchivo.put(idcodigo, a);
 			 
         }  
		 
         //System.out.println("rutaimagen"+rutaImagen);
         session.put("mapArchivoVS", mapArchivo);
        
		return "success";
	}
	
	
	
	
	 public InputStream getArchivoBiblioteca() { 
		 Map<String, Object> session = ActionContext.getContext().getSession(); 
		 Map<String, Object> mapDocumento=(Map<String, Object>) session.get("mapdocumentoVS"); 
		 ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
		  String rutaBibliotecaDocumento = labels.getString("ruta_repositorio_documento_biblioteca"); 
	       
		  // Archivo a= archivoService.consultarArchivoxId(idcodigo);
	        //String rutaArchivo=mapDocumento.get("rutadocumento").toString();
	        
	        Archivo a= archivoService.consultarArchivoxId(idcodigo);
	        
	        String rutaArchivo=rutaBibliotecaDocumento+a.getNombreGenerado();
	        //System.out.println("rut arc"+rutaArchivo);
	        nombrearchivo=a.getNombreInicial();
	       try {
	      	
				archivoBiblioteca= new FileInputStream(new File(rutaArchivo));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return archivoBiblioteca;
			
			
			
		}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public InputStream getImagenPortada() throws Exception { 
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		
		String contentType = "image/gif"; 
		String rutaimagen=session.get("rutaImagenVS").toString();
		//System.out.println("cons img"+rutaimagen);
		 
		File file = new File(rutaimagen);
         Result result = ActionContext.getContext(). getActionInvocation().getResult();
         if (result != null && result instanceof StreamResult) {
				StreamResult streamResult = (StreamResult) result;
				streamResult.setContentType(contentType); } 
			try { 
				return new FileInputStream(file); }
			catch (IOException ex) { } 
         return null;
		
	}
	
	
	
	
	public String obtenerFiltrosRecursoInformacion(){
		
		List<Areanatural> lista= recursoInformacionService.consultarAreasNaturalesConRecursosInformacionxCategoriaAnp(idcodigo);
		//listaAreaNatural=areaNaturalService.consultarAreasNaturalesConProyectos(a);
    	List<Objeto> lista1=new ArrayList<Objeto>();
		for(Areanatural anat:lista){
			Objeto o=new Objeto();
			o.setIdcodigo(anat.getIdareanatural());
			o.setNombre(anat.getDesareanatural());
			lista1.add(o);
		}
		datos.put("cboAnp",lista1);
		return "success";
	}
	
	
	public String eliminarRegistroRecursoInformacion(){
	    recursoInformacionService.eliminarRecursosInformacion(listaCodigos);
		return "success";
	}
	
	
	public String buscarEditoriales(){
		Editorial editorial=new Editorial();
		editorial.setNombrepersonajuridica(cadena);
		List<Editorial> listaEdit=editorialService.consultarEditoriales(editorial);
		datos.put("editoriales",listaEdit);
		return "success";
	}
	
	public String buscarAutores(){
		Autor autor=new Autor();
		autor.setApepat(cadena);
		autor.setApemat(cadena);
		autor.setNombre(cadena);
		List<Autor> listaAutor=autorService.consultarAutores(autor);
		datos.put("autores",listaAutor);
		return "success";
	}
	
	
	public String buscarTemas(){
		Tema tema=new Tema();
		tema.setNombretema(cadena);
		List<Tema> listaTema=temaService.consultarTemas(tema);
		datos.put("temas",listaTema);
		return "success";
	}


	
	public String buscarPersonalAprobacion(){
		Personal p=new Personal();
		p.setApepat(cadena);
		p.setApemat(cadena);
		p.setNombre(cadena);
		List<Personal> listaPersonal=personalService.listarPersonalxNombreCompleto(p);
		datos.put("personal",listaPersonal);
		return "success";
	}
	
	
	public String guardarRegistroEditorial(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String nombre = String.valueOf(request.getParameter("nombre"));
		String dir = String.valueOf(request.getParameter("direccion"));
		String stelf=request.getParameter("telefono").toString();
		int idpais =  Integer.parseInt(request.getParameter("pais").toString()); 
		int telf=0;
			
		    stelf= stelf.trim();
		    if(!stelf.equals("")){
		    	telf=Integer.parseInt(stelf);
		    }
			  
			
			Personajuridica pj=new Personajuridica();
			if(!nombre.equals("")){
				pj.setNombrepersonajuridica(nombre);	
			}
			if(!dir.equals("")){
				pj.setDireccion(dir);	
			}
			pj.setTelefono(telf);
			int codigo=0;
			pj.getPais().setIdpais(idpais);
			int codigoPersonaJuridica= personaJuridicaService.guardarInstitucion(pj);
			Editorial editorial=new Editorial();
			editorial.setIdpersonajuridica(codigoPersonaJuridica);
			codigo=editorialService.guardarEditorial(editorial);
			datos.put("codigo", codigo);
			datos.put("nombre", nombre);
		return "success";
	}
	
	
	public String guardarRegistroAutor(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String nombre = String.valueOf(request.getParameter("nombre"));
		String apepat = String.valueOf(request.getParameter("appaterno"));
		String apemat = String.valueOf(request.getParameter("apmaterno"));
		String dir = String.valueOf(request.getParameter("direccion"));
		String stelf=request.getParameter("telefono").toString();
		String email = String.valueOf(request.getParameter("email")); 
		int idpais =  Integer.parseInt(request.getParameter("pais").toString());
		int idtipodocumento =  Integer.parseInt(request.getParameter("tipodocumento").toString());
		String genero = String.valueOf(request.getParameter("genero"));
		int telf=0;
			
		    stelf= stelf.trim();
		    if(!stelf.equals("")){
		    	telf=Integer.parseInt(stelf);
		    }
		    
			Personanatural pnat=new Personanatural();
			if(!nombre.equals("")){
				pnat.setNombre(nombre);
					
			}
			if(!apepat.equals("")){
				pnat.setApepat(apepat);
					
			}
			if(!apemat.equals("")){
				pnat.setApemat(apemat);
					
			}
			if(!dir.equals("")){
				pnat.setDireccion(dir);	
			}
			if(!email.equals("")){
				pnat.setEmail(email);	
			}
			if(!genero.equals("")){
				pnat.setSexo(genero);	
			}
			pnat.setTelefono(telf);
			int codigo=0;
			pnat.getPais().setIdpais(idpais);
			pnat.setIdtipodocumento(idtipodocumento);
			int codigoPersonaNatural= personaNaturalService.guardarPersonaNatural(pnat);
			Autor autor=new Autor();
			autor.setIdpersonanatural(codigoPersonaNatural);
			codigo=autorService.guardarAutor(autor);
			String nomcom=apepat+" "+apemat+","+nombre;
			datos.put("codigo", codigo);
			datos.put("nombre", nomcom);
		return "success";
	}
	
	
	public String guardarRegistroTema(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String nombre = String.valueOf(request.getParameter("nombre"));
		Tema tema=new Tema();
		tema.setNombretema(nombre);
		int codigo=0;
		codigo=temaService.guardarTema(tema);
		datos.put("codigo", codigo);
		datos.put("nombre", nombre);
		return "success";
	}
	
	
	
	public InputStream getResultadoRecursoInformacion(){
		
		System.out.println(idcodigo);
		RecursoInformacion recurso=recursoInformacionService.consultarDetalleRecursoInformacionxId(idcodigo);
		ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
        String rutaArchivo = labels.getString("ruta_repositorio_temp");
        String rutaImagen = labels.getString("ruta_repositorio_imagen");
        String nombreImagen = labels.getString("nombre_logo_sernanp");
        
        Map<String, Object> mapParam=new HashMap<String, Object>();
        mapParam.put("rutaArchivo", rutaArchivo);
        mapParam.put("rutaImagen", rutaImagen);
        mapParam.put("nombreImagen", nombreImagen);
        //mapParam.put("titulo", "jjj");
        nombreArchivo="FichaRecurso.pdf";
        RecursoInformacionReporte recursoInformacionReporte=new RecursoInformacionReporte();
        String ruta=recursoInformacionReporte.generarPdfRegistroRecursoInformacion(recurso, mapParam); 
		 try {
			 
			 resultadoRecursoInformacion=new FileInputStream(new File(ruta));
			File filedel=new File(ruta);
			filedel.delete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultadoRecursoInformacion;
	}
	
	public InputStream getResultadoListaRecursoInformacion(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		// Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
		Usuario user=new Usuario();
		ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
        String rutaArchivo = labels.getString("ruta_repositorio_temp");
        String rutaImagen = labels.getString("ruta_repositorio_imagen");
        String nombreImagen = labels.getString("nombre_logo_sernanp");
        RecursoInformacionParam recursoInformacionParam=new RecursoInformacionParam();
        String titulo = String.valueOf(request.getParameter("titulo"));
		int idtipo =  Integer.parseInt(request.getParameter("idtipo").toString());
		int idmedio =  Integer.parseInt(request.getParameter("idmedio").toString());
		int idcategoriaanp =  Integer.parseInt(request.getParameter("idcategoriaanp").toString());
		int idanp =  Integer.parseInt(request.getParameter("idareanatural").toString());
		int ididioma =  Integer.parseInt(request.getParameter("ididioma").toString());
		int idtematica =  Integer.parseInt(request.getParameter("idtematica").toString());
		String nomautor = String.valueOf(request.getParameter("nomautor"));
		String codsgd = String.valueOf(request.getParameter("codsgd"));
		if(!titulo.equals("")){
			recursoInformacionParam.getRecursoinformacion().setTitulo(titulo);
		}
		if(!nomautor.equals("")){
			recursoInformacionParam.getAutor().setNombre(nomautor);
		}
		if(!codsgd.equals("")){
			recursoInformacionParam.getRecursoinformacion().setCodigosgd(codsgd);
		}
		recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().setIdtipo(idtipo);
		recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().setIdtipo(idmedio);
		recursoInformacionParam.getRecursoinformacion().getIdioma().setIdidioma(ididioma);
		recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().setIdtematicarecursoinformacion(idtematica);
		recursoInformacionParam.getAreanatural().setIdareanatural(idanp);
		recursoInformacionParam.getAreanatural().getCategoriaanp().setIdcategoriaanp(idcategoriaanp);
		System.out.println("antes busqueda");
		List<RecursoInformacion>lista=recursoInformacionService.consultarRecursosInformacion(recursoInformacionParam);
        SimpleDateFormat formateador2=new SimpleDateFormat("dd/MM/yyyy");
         RecursoInformacionReporte recursoInformacionReporte=new RecursoInformacionReporte();
        Map<String, Object> mapParam=new HashMap<String, Object>();
        mapParam.put("rutaArchivo", rutaArchivo);
        mapParam.put("rutaImagen", rutaImagen);
        mapParam.put("nombreImagen", nombreImagen);
        mapParam.put("titulo", titulo);
        //mapParam.put("formateador", formateador);
        //mapParam.put("formateador2", formateador2);
        //mapParam.put("user", user);
        if(idopcion==ValueConstants.TIPO_EXP_EXCEL){
    	 
        	 nombreArchivo="Biblioteca.xls";
        	 String ruta= recursoInformacionReporte.exportarExcelRecursoInformacion(lista, mapParam);
        	 try {
        		 resultadoListaRecursoInformacion=new FileInputStream(new File(ruta));
				File filedel=new File(ruta);
				filedel.delete();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    	 
          }
 
     else
    	  if(idopcion==ValueConstants.TIPO_EXP_PDF){
    		  nombreArchivo="Biblioteca.pdf";
    		 String ruta=recursoInformacionReporte.exportarPdfRecursoInformacion(lista, mapParam);
    		 try {
    			 resultadoListaRecursoInformacion=new FileInputStream(new File(ruta));
				File filedel=new File(ruta);
				filedel.delete();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  }
             
    		 return resultadoListaRecursoInformacion;
		
	}
	
	
	
	
	
	

	public List<RecursoInformacionEditorial> getListaRecursoInformacionEditorial() {
		return listaRecursoInformacionEditorial;
	}




	public void setListaRecursoInformacionEditorial(
			List<RecursoInformacionEditorial> listaRecursoInformacionEditorial) {
		this.listaRecursoInformacionEditorial = listaRecursoInformacionEditorial;
	}




	public RecursoInformacion getRecursoinformacion() {
		return recursoinformacion;
	}




	public void setRecursoinformacion(RecursoInformacion recursoinformacion) {
		this.recursoinformacion = recursoinformacion;
	}




	public List<Tipo> getListaTipoRecursoInformacion() {
		return listaTipoRecursoInformacion;
	}




	public void setListaTipoRecursoInformacion(
			List<Tipo> listaTipoRecursoInformacion) {
		this.listaTipoRecursoInformacion = listaTipoRecursoInformacion;
	}




	public List<Tipo> getListaMedioRecursoInformacion() {
		return listaMedioRecursoInformacion;
	}




	public void setListaMedioRecursoInformacion(
			List<Tipo> listaMedioRecursoInformacion) {
		this.listaMedioRecursoInformacion = listaMedioRecursoInformacion;
	}




	
	
	public List<TematicaRecursoInformacion> getListaTematicaRecursoInformacion() {
		return listaTematicaRecursoInformacion;
	}








	public void setListaTematicaRecursoInformacion(
			List<TematicaRecursoInformacion> listaTematicaRecursoInformacion) {
		this.listaTematicaRecursoInformacion = listaTematicaRecursoInformacion;
	}








	public void setIdrecursoinformacion(int idrecursoinformacion) {
		this.idrecursoinformacion = idrecursoinformacion;
	}
	

	
	
	
	
	
	public int getIdpestania() {
		return idpestania;
	}




	public void setIdpestania(int idpestania) {
		this.idpestania = idpestania;
	}



	public int getIdrecursoinformacion() {
		return idrecursoinformacion;
	}




	public List<Idioma> getListaIdioma() {
		return listaIdioma;
	}




	public void setListaIdioma(List<Idioma> listaIdioma) {
		this.listaIdioma = listaIdioma;
	}


	


	public int getTemporal() {
		return temporal;
	}








	public void setTemporal(int temporal) {
		this.temporal = temporal;
	}








	public int getIdpagina() {
		return idpagina;
	}




	public void setIdpagina(int idpagina) {
		this.idpagina = idpagina;
	}



	


	public int getIdcodigo() {
		return idcodigo;
	}




	public void setIdcodigo(int idcodigo) {
		this.idcodigo = idcodigo;
	}



	
	




	public File getFile() {
		return file;
	}




	public void setFile(File file) {
		this.file = file;
	}




	public String getFileContentType() {
		return fileContentType;
	}




	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}





	public String getFileFileName() {
		return fileFileName;
	}




	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}




	





	public List<Tipo> getListaTipoDocumentoIdentidad() {
		return listaTipoDocumentoIdentidad;
	}




	public void setListaTipoDocumentoIdentidad(
			List<Tipo> listaTipoDocumentoIdentidad) {
		this.listaTipoDocumentoIdentidad = listaTipoDocumentoIdentidad;
	}




	public List<Tipo> getListaGenero() {
		return listaGenero;
	}




	public void setListaGenero(List<Tipo> listaGenero) {
		this.listaGenero = listaGenero;
	}




	public String getCadena() {
		return cadena;
	}




	public void setCadena(String cadena) {
		this.cadena = cadena;
	}


	





	public int getIdopcion() {
		return idopcion;
	}




	public void setIdopcion(int idopcion) {
		this.idopcion = idopcion;
	}


	




	public List<Categoriaanp> getListaCategoriaAnp() {
		return listaCategoriaAnp;
	}




	public void setListaCategoriaAnp(List<Categoriaanp> listaCategoriaAnp) {
		this.listaCategoriaAnp = listaCategoriaAnp;
	}






	public List<AreanaturalSel> getListaAreaNaturalSel() {
		return listaAreaNaturalSel;
	}




	public void setListaAreaNaturalSel(List<AreanaturalSel> listaAreaNaturalSel) {
		this.listaAreaNaturalSel = listaAreaNaturalSel;
	}


	
	


	public List<RecursoInformacion> getListaRecursoInformacion() {
		return listaRecursoInformacion;
	}








	public void setListaRecursoInformacion(
			List<RecursoInformacion> listaRecursoInformacion) {
		this.listaRecursoInformacion = listaRecursoInformacion;
	}








	public List<Pais> getListaPais() {
		return listaPais;
	}




	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}




	public List<Areanatural> getListaSedeBiblioteca() {
		return listaSedeBiblioteca;
	}




	public void setListaSedeBiblioteca(List<Areanatural> listaSedeBiblioteca) {
		this.listaSedeBiblioteca = listaSedeBiblioteca;
	}




	public List<Areaorganica> getListaAreaOrganica() {
		return listaAreaOrganica;
	}




	public void setListaAreaOrganica(List<Areaorganica> listaAreaOrganica) {
		this.listaAreaOrganica = listaAreaOrganica;
	}








	




	public Pagination getPaginacion() {
		return paginacion;
	}








	public void setPaginacion(Pagination paginacion) {
		this.paginacion = paginacion;
	}








	public String getNombrearchivo() {
		return nombrearchivo;
	}








	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}




	



























	public List<Areanatural> getListaAreaNatural() {
		return listaAreaNatural;
	}








	public void setListaAreaNatural(List<Areanatural> listaAreaNatural) {
		this.listaAreaNatural = listaAreaNatural;
	}




	



	public List<TematicaRecursoInformacion> getListaTematica() {
		return listaTematica;
	}








	public void setListaTematica(List<TematicaRecursoInformacion> listaTematica) {
		this.listaTematica = listaTematica;
	}







	public int getIdrecursoinformacionparam() {
		return idrecursoinformacionparam;
	}








	public void setIdrecursoinformacionparam(int idrecursoinformacionparam) {
		this.idrecursoinformacionparam = idrecursoinformacionparam;
	}





	public List<Integer> getListaCodigos() {
		return listaCodigos;
	}








	public void setListaCodigos(List<Integer> listaCodigos) {
		this.listaCodigos = listaCodigos;
	}







































































	public String getNombreArchivo() {
		return nombreArchivo;
	}








	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}




	





































































	public List<Tipo> getListaAnioPublicacion() {
		return listaAnioPublicacion;
	}








	public void setListaAnioPublicacion(List<Tipo> listaAnioPublicacion) {
		this.listaAnioPublicacion = listaAnioPublicacion;
	}










































































	private TipoService tipoService;
	private RecursoInformacionService recursoInformacionService;
	private IdiomaService idiomaService;
	private EditorialService editorialService;
	private AutorService autorService;
	private TemaService temaService;
	private AreaNaturalService areaNaturalService; 
	private CategoriaAnpService categoriaAnpService;
	private AreaOrganicaService areaOrganicaService;
	private PersonalService personalService;
	private PersonaJuridicaService personaJuridicaService;
	private PaisService paisService;
	private PersonaNaturalService personaNaturalService;
	private TematicaRecursoInformacionService tematicaRecursoInformacionService;
	private ArchivoService archivoService;




	


	
	


	public void setTematicaRecursoInformacionService(
			TematicaRecursoInformacionService tematicaRecursoInformacionService) {
		this.tematicaRecursoInformacionService = tematicaRecursoInformacionService;
	}








	public void setPersonaNaturalService(PersonaNaturalService personaNaturalService) {
		this.personaNaturalService = personaNaturalService;
	}




	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}




	public void setPersonaJuridicaService(
			PersonaJuridicaService personaJuridicaService) {
		this.personaJuridicaService = personaJuridicaService;
	}




	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}




	public void setAreaOrganicaService(AreaOrganicaService areaOrganicaService) {
		this.areaOrganicaService = areaOrganicaService;
	}




	public void setCategoriaAnpService(CategoriaAnpService categoriaAnpService) {
		this.categoriaAnpService = categoriaAnpService;
	}




	public void setAreaNaturalService(AreaNaturalService areaNaturalService) {
		this.areaNaturalService = areaNaturalService;
	}




	public void setTemaService(TemaService temaService) {
		this.temaService = temaService;
	}




	public void setAutorService(AutorService autorService) {
		this.autorService = autorService;
	}




	public void setIdiomaService(IdiomaService idiomaService) {
		this.idiomaService = idiomaService;
	}




	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}




	public void setRecursoInformacionService(
			RecursoInformacionService recursoInformacionService) {
		this.recursoInformacionService = recursoInformacionService;
	}


	

	
	


	

	public void setArchivoService(ArchivoService archivoService) {
		this.archivoService = archivoService;
	}








	public void setEditorialService(EditorialService editorialService) {
		this.editorialService = editorialService;
	}




	public String getRutaImagen() {
		return rutaImagen;
	}




	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}




	public Map<String, Object> getDatos() {
		return datos;
	}




	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}
	
	
	
	
	
	
}
