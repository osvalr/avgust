package proyecto.action;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import proyecto.service.DirectorioArchivoService;
import proyecto.service.InfraccionService;
import proyecto.service.InfractorService;
import proyecto.vo.Expediente;
import proyecto.vo.Infraccion;
import proyecto.vo.Sancion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InfraccionAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	@Autowired  
	private InfraccionService infraccionService;
	@Autowired
	private InfractorService infractorService;	
	@Autowired  
	private DirectorioArchivoService directorioArchivoService;
	
	
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String variable;
	
	
	private Map<String,Object> datos;
	
	private int codigoGenerado;
	private Infraccion infraccion;
	private int idInsertado;
	
	private Expediente expediente;
	
	private List<Infraccion> listaInfracciones = new ArrayList<Infraccion>();
	private List<Sancion> listaSanciones = new ArrayList<Sancion>();
//	private String dniRecibido;
	
//	int dniR =0;
	
	public InfraccionAction() {
		infraccion= new Infraccion();
		datos=new HashMap<String, Object>();
		listaInfracciones = new ArrayList<Infraccion>();
		expediente= new Expediente();
		datos=new HashMap<String, Object>();
		// TODO Auto-generated constructor stub
	}
	
	
	//NAVEGACION
	
	//nuevo infractor
	public String nuevoInfractor(){
		
		listaInfracciones = infractorService.listarInfracciones();
		listaSanciones = infractorService.listarSanciones();
		return SUCCESS;
	}
	
	
	//registro de infractor
	public String registrarInfractor(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
		Expediente e=new Expediente();
		e.getInfractor().getIdinfractor();
		
		return SUCCESS;
	}
	
	
	public String iniciarInfracciones(){  	 
   	   	
   	 return SUCCESS;
    }
	
	
	public String listadoInfracciones(){  	 
   	   	
	   	 return SUCCESS;
	}
	
		
	public String nuevaInfraccion(){  	 
		codigoGenerado = infraccionService.codigoGenerado();
   	   	System.out.println("el codigo generado es "+codigoGenerado);
   	   	return SUCCESS;
	   	
	}
	
//	public String ingresarInfraccion() {
//		int resultado=-1;
//		
//		//conseguimos la ruta para el archivo
//		DirectorioArchivo directorio = new DirectorioArchivo();
//		directorio = directorioArchivoService.obtener(2);
//		
//		String rutaRepositorio="";
//		rutaRepositorio= directorio.getDirdirectorio();
//		String nameInst="";
//		if(file!=null){
//		
//		 infraccion.getArchivo().setNombrenicialarchivo(fileFileName);
//		 Date instante=new Date();
//		 long inst =instante.getTime();
//		 int pos=fileFileName.lastIndexOf('.');
//		  
//		 String ext=fileFileName.substring(pos);
//		 fileFileName=inst+ext;
//		 
//		 infraccion.getArchivo().setNombregeneradoarchivo(fileFileName);
//		 
//		 nameInst=String.valueOf(inst);
//		 File archivoGuardado = new File(rutaRepositorio, fileFileName);
//		 file.renameTo(archivoGuardado);
//		 String extension[] = fileContentType.split("/");
//		 infraccion.getArchivo().setMime(extension[1]);
//		}
//		
//		else System.out.println("hubo un error con el archivo");
//		
//		System.out.println("ESTE ES EL TIPO DE ESTADO:"+infraccion.getInfractor().getPersonanatural().getEstadocivil().getIdtipo());
//		
//		resultado=infraccionService.insertar(infraccion);
//		idInsertado=resultado;
//		return SUCCESS;
//	}
//	
//	public String verificaReincidencia(){
//		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//		int dniR =  Integer.parseInt(request.getParameter("dni").toString().trim());
//		System.out.println("este es el dni :"+dniR);
//		infraccion.setInfractor(infraccionService.verificaReincidencia(dniR));
//	    datos.put("MyInfractor", infraccion.getInfractor());
//		return SUCCESS;
//	}
	
	
	
	
	
//	public String cargarArchivo(){
////		Map<String, Object> session = ActionContext.getContext().getSession(); 
////		Map<Integer,Object> mapArchivo=(Map<Integer, Object>) session.get("mapArchivoVS");
//		ResourceBundle labels = ResourceBundle.getBundle("proyecto.resources.proyectoparametros");
//         String rutaRepositorio = labels.getString("ruta_repositorio");
//		 if(file!=null){
//			 //Archivo a=new Archivo();
//			 archivo.setNombrenicialarchivo(fileFileName);
//			 //a.setNombreInicial(fileFileName);
//             Date instante=new Date();
// 			 long inst =instante.getTime();
// 			 int pos=fileFileName.lastIndexOf('.');
// 			 String ext=fileFileName.substring(pos);
// 			 fileFileName=inst+ext;
// 			 String nameInst=String.valueOf(inst);
//
// 			 System.out.println("nombre en el instante es :"+nameInst);
// 			 File archivoGuardado = new File(rutaRepositorio, fileFileName);
// 			 file.renameTo(archivoGuardado);
// 			 archivo.setNombregeneradoarchivo(fileFileName);
// 			 archivo.getUsuario().setIdUsuario(1);
// 			 
// 			 
// 			 //archivo.setIdarchivo(idcodigo);
//// 			 archivo.setIdarchivo(idcodigo);
//// 			 mapArchivo.put(idcodigo, archivo);
// 			
//         }
////         
////         session.put("mapArchivoVS", mapArchivo);
//        
//		return "success";
//	}
	
	//LISTADO
	public String consultarInfracciones(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);		
		
		return SUCCESS;
	}
		
	
	//GETTERS AND SETTERS	
	
	public int getCodigoGenerado() {
		return codigoGenerado;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public List<Sancion> getListaSanciones() {
		return listaSanciones;
	}

	public void setListaSanciones(List<Sancion> listaSanciones) {
		this.listaSanciones = listaSanciones;
	}

	public List<Infraccion> getListaInfracciones() {
		return listaInfracciones;
	}

	public void setListaInfracciones(List<Infraccion> listaInfracciones) {
		this.listaInfracciones = listaInfracciones;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}	

	public int getIdInsertado() {
		return idInsertado;
	}

	public void setIdInsertado(int idInsertado) {
		this.idInsertado = idInsertado;
	}

	public Map<String, Object> getDatos() {
		return datos;
	}

	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}

	public void setCodigoGenerado(int codigoGenerado) {
		this.codigoGenerado = codigoGenerado;
	}

	public Infraccion getInfraccion() {
		return infraccion;
	}

	public void setInfraccion(Infraccion infraccion) {
		this.infraccion = infraccion;
	}	
	
}