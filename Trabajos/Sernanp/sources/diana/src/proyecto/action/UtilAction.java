package proyecto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import proyecto.service.DocumentoService;
import proyecto.service.UbigeoService;
import proyecto.vo.Archivo;
import proyecto.vo.Directorioarchivo;
import proyecto.vo.Ubigeo;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UtilAction extends ActionSupport {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numperiodo;
	private int idparam;
	private int idparam2;
	private String cadenaparam;
	private String cadenaparam2;
	private Map<String, Object> datos;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private InputStream archivo;
	private String nombre;
	
	@Autowired  
	private UbigeoService ubigeoService;
	@Autowired  
	private DocumentoService documentoService;
	
	
	public UtilAction(){
		datos=new HashMap<String, Object>();
	}
	
	
	public  String listarUbigeo(){
		
		
		if(idparam==1){
			List<Ubigeo> lista=ubigeoService.listarUbigeosProvinciaxCodigoDepartamento(cadenaparam);
			datos.put("listaubigeo", ubigeoService.listarUbigeosProvinciaxCodigoDepartamento(cadenaparam));
		}else if(idparam==2){
			List<Ubigeo> lista=ubigeoService.listarUbigeosDistritoxCodigoProvincia(cadenaparam2, cadenaparam);
			datos.put("listaubigeo", ubigeoService.listarUbigeosDistritoxCodigoProvincia(cadenaparam2, cadenaparam));
		}

		
		return "success";
	}
	
	public String listarMenu(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(request.getParameter("idmodulo")!=null){
		    int idmodulo=Integer.parseInt(request.getParameter("idmodulo").toString());
		    session.put("idmodulo", idmodulo);
		}
		Calendar c = Calendar.getInstance();
		//int anioActual =  c.get(Calendar.YEAR);
		numperiodo=c.get(Calendar.YEAR);
		//idtipo=anioactual;
		return "success";
	}
	
	
	
	public String cargarArchivo(){
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		Map<Integer,Object> mapArchivo=(Map<Integer, Object>) session.get("mapArchivoVS");
		int idmodulo=(Integer) session.get("idmodulo");
	    Directorioarchivo da= documentoService.obtenerDirectorioxIdmodulo(idmodulo);
        String rutaRepositorio=da.getDirdirectorio();
        System.out.println("rut"+rutaRepositorio);
        int idgrupoarchivo=da.getIddirectorioarchivo();
         Usuario user=(Usuario) session.get("USUARIO_ACTUAL");
         if(file!=null){
			 Archivo a=new Archivo();
			 a.setNombreinicial(fileFileName);
			 Date instante=new Date();
 			 long inst =instante.getTime();
 			 int pos=fileFileName.lastIndexOf('.');
 			 String ext=fileFileName.substring(pos);
 			 fileFileName=inst+ext;
 			 String nameInst=String.valueOf(inst);
 			 File archivoGuardado = new File(rutaRepositorio, fileFileName);
 			 file.renameTo(archivoGuardado);
 			 a.setNombregenerado(fileFileName);
 			 a.getUsuario().setIdUsuario(user.getIdUsuario());
 			 a.setIdcodigo(idparam);
 			 a.getDirectorioarchivo().setIddirectorioarchivo(idgrupoarchivo);
 			 mapArchivo.put(idparam, a);
 			
         }    
         session.put("mapArchivoVS", mapArchivo);
        
		return "success";
	}
	
	 public InputStream getArchivo() { 
		    Map<String, Object> session = ActionContext.getContext().getSession(); 
		    int idmodulo=(Integer) session.get("idmodulo");
		    Directorioarchivo da= documentoService.obtenerDirectorioxIdmodulo(idmodulo);
	        String rutaRepositorio=da.getDirdirectorio();
		    Archivo a= documentoService.consultarArchivoxId(idparam);
	        String rutaArchivo=rutaRepositorio+a.getNombregenerado();
	        nombre=a.getNombreinicial();
	       try {
	      	archivo= new FileInputStream(new File(rutaArchivo));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return archivo;
		}
	
	 
	
	 

	public int getIdparam() {
		return idparam;
	}


	public void setIdparam(int idparam) {
		this.idparam = idparam;
	}


	public int getNumperiodo() {
		return numperiodo;
	}


	public void setNumperiodo(int numperiodo) {
		this.numperiodo = numperiodo;
	}


	


	public int getIdparam2() {
		return idparam2;
	}


	public void setIdparam2(int idparam2) {
		this.idparam2 = idparam2;
	}




	public Map<String, Object> getDatos() {
		return datos;
	}




	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}




	public String getCadenaparam() {
		return cadenaparam;
	}




	public void setCadenaparam(String cadenaparam) {
		this.cadenaparam = cadenaparam;
	}


	public String getCadenaparam2() {
		return cadenaparam2;
	}


	public void setCadenaparam2(String cadenaparam2) {
		this.cadenaparam2 = cadenaparam2;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	
	 
	
	 
	
	
	
	
	
}
