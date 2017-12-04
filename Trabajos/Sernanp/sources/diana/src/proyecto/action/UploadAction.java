package proyecto.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import proyecto.excel.ProcesarDatosHoja;
import proyecto.service.PersonalRegistroService;
import proyecto.service.TipoService;
import proyecto.util.Funciones;
import proyecto.vo.Areanatural;
import proyecto.vo.Operadorturismo;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Tipo;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File file_1;
    private String file_1FileName;
    private String tmpFileName;
    private String file_1ContentType;
    private String filePathToSaveInDB;
    
    private String file_1Size;
       
    private Areanatural areanatural;
	private Operadorturismo operadorturismo;
    
    private List<PersonalRegistro> datosp;
    private HashMap<String, Object> datos;
    private LinkedHashMap<String, String> tipos;
    
    private TipoService tipoService;
    private PersonalRegistroService personalregistroService;
		
	private List<Tipo> tipodocumento;
	private List<Tipo> tipogenero;
	private List<Tipo> tipolocal;
	
	    
	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}

	public void setPersonalregistroService(
			PersonalRegistroService personalregistroService) {
		this.personalregistroService = personalregistroService;
	}



	public UploadAction(){
		areanatural = new Areanatural();
		operadorturismo = new Operadorturismo();
		datosp = new ArrayList<PersonalRegistro>();
		datos = new HashMap<String, Object>();
	}
    
    
    
public String uploadFileToMyFolder() {	
		
    try {		
				
		//String filePath = "/home/yonny/tmp/";
    	//String filePath = "/tmp/";
    	String filePath = getText("ruta.tmp");
		
		String[] ext = Funciones.explodeString(file_1FileName, ".");
		
		this.tmpFileName = String.valueOf((new Date()).getTime())+"."+ext[(ext.length - 1)];
		
        File uploadDir = new File(filePath);
        FileUtils.copyFile(file_1, new File(uploadDir, this.tmpFileName));
		
        filePath += this.tmpFileName;		
				
        ProcesarDatosHoja hoja = new ProcesarDatosHoja();
        
        datosp = hoja.cargarDatos(filePath, 0);
        
        List<String> listDoc = new ArrayList<String>();
        
        for(PersonalRegistro p : personalregistroService.listarPersonalxDoc()){
        	listDoc.add(""+p.getTipodocumento().getIdtipo()+p.getNumerodocumento());
        }
        
        for(PersonalRegistro pp : datosp){
        	String idnmdoc = ""+pp.getTipodocumento().getIdtipo()+pp.getNumerodocumento(); 
        	if(listDoc.contains(idnmdoc))pp.setIdestado(0);
        }
        
        tipodocumento = tipoService.listarTipoDocumentoIdentidad();
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
        
        
        tipos = new LinkedHashMap<String, String>();
        
        for(Tipo t1 : tipodocumento){
        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());
        	
        }
        
        for(Tipo t2 : tipogenero){
        	
        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
        }
        
        for(Tipo t3 : tipolocal){
        	
        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
        }

        datos.put("datosp", datosp);
        //datos.put("tipod", tipodocumento);
        //datos.put("tipog", tipogenero);
        datos.put("name", this.file_1FileName);
        datos.put("tmpname", this.tmpFileName);
        datos.put("tipos", tipos);
                      
              
    } catch (Exception e) {
        System.out.println("Exception : " + e);
    	e.printStackTrace();
    }
    
    return SUCCESS;
}


public File getFile_1() {
	return file_1;
}

public void setFile_1(File file_1) {
	this.file_1 = file_1;
}

public String getFile_1Size() {
	return file_1Size;
}



public void setFile_1Size(String file_1Size) {
	this.file_1Size = file_1Size;
}



public String getFile_1FileName() {
	return file_1FileName;
}

public void setFile_1FileName(String file_1FileName) {
	this.file_1FileName = file_1FileName;
}


public String getFile_1ContentType() {
	return file_1ContentType;
}

public void setFile_1ContentType(String file_1ContentType) {
	this.file_1ContentType = file_1ContentType;
}

public String getFilePathToSaveInDB() {
	return filePathToSaveInDB;
}

public void setFilePathToSaveInDB(String filePathToSaveInDB) {
	this.filePathToSaveInDB = filePathToSaveInDB;
}


public List<PersonalRegistro> getDatosp() {
	return datosp;
}

public void setDatosp(List<PersonalRegistro> datosp) {
	this.datosp = datosp;
}

public HashMap<String, Object> getDatos() {
	return datos;
}

public void setDatos(HashMap<String, Object> datos) {
	this.datos = datos;
}

public List<Tipo> getTipodocumento() {
	return tipodocumento;
}

public void setTipodocumento(List<Tipo> tipodocumento) {
	this.tipodocumento = tipodocumento;
}

public List<Tipo> getTipogenero() {
	return tipogenero;
}

public void setTipogenero(List<Tipo> tipogenero) {
	this.tipogenero = tipogenero;
}



public List<Tipo> getTipolocal() {
	return tipolocal;
}



public void setTipolocal(List<Tipo> tipolocal) {
	this.tipolocal = tipolocal;
}



public LinkedHashMap<String, String> getTipos() {
	return tipos;
}



public void setTipos(LinkedHashMap<String, String> tipos) {
	this.tipos = tipos;
}

public Areanatural getAreanatural() {
	return areanatural;
}

public void setAreanatural(Areanatural areanatural) {
	this.areanatural = areanatural;
}

public Operadorturismo getOperadorturismo() {
	return operadorturismo;
}

public void setOperadorturismo(Operadorturismo operadorturismo) {
	this.operadorturismo = operadorturismo;
}

public String getTmpFileName() {
	return tmpFileName;
}

public void setTmpFileName(String tmpFileName) {
	this.tmpFileName = tmpFileName;
}

}