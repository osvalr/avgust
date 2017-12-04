package sernanp.rrhh.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.service.PersonalMarcacionService;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.Tipo;
import sernanp.rrhh.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UploadMarcacionesRelojAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private File archivoAdjunto;
    private String archivoAdjuntoFileName;
    private String tmpFileName;
    private String archivoAdjuntoContentType;
    private String filePathToSaveInDB;    
    private String archivoAdjuntoSize;
	
//    private Personanatural personanatural;
    private List<PersonalVO> personalVO;        
    private PersonalMarcacionService personalMarcacionService;
    
    private List<PersonalAsistenciaVO> datosp;
    private List<PersonalMarcacionVO> datosm;
    private List <PersonalMarcacionVO> personalMarcacionVO;
        
    private Usuario user;

	public UploadMarcacionesRelojAction (){
  	
    	datosp 						= new ArrayList<PersonalAsistenciaVO>();
    	datosm						= new ArrayList<PersonalMarcacionVO>(); 
//    	personanatural				= new Personanatural();
    	personalMarcacionVO			= new ArrayList<PersonalMarcacionVO>();
    	personalVO					= new ArrayList<PersonalVO>();
//    	personalMarcacionService 	= new PersonalMarcacionService();	
    }
    
	
	public String execute(){
		
		return SUCCESS;		
	}
	
	public String uploadTxt() {
		String filePath              				= null;
		String[] ext 	             				= null;
	    File uploadDir 	             				= null;   
        try {				
	    	filePath   = "/tmp/";
			ext 	   = Funciones.explodeString(archivoAdjuntoFileName, ".");
			this.tmpFileName 	= String.valueOf((new java.util.Date()).getTime())+"."+ext[(ext.length - 1)];				
	        uploadDir  = new File(filePath);                        
	        FileUtils.copyFile(archivoAdjunto, new File(uploadDir, this.tmpFileName));		
	        filePath   += this.tmpFileName;
	        datosm 	   = cargarDatosMarcaciones(filePath);						
//			if (datosm.size() != 0){

				personalMarcacionService.guardarListaMarcaciones(datosm, 0);	

//			}
			
				if(datosm.get(0).getDte_fec_marc1() != null) datosm.clear();
			
		} catch (Exception e) {
			e.printStackTrace();
	    	addActionError("Problema inesperado, por favor vuelva a intentarlo.");    	
	    	return ERROR;
		}
	    addActionMessage("Se registraron, "+ datosm.size()+" Marcaciones");
	    return SUCCESS;
	}
    
    
	
	

	public List<PersonalMarcacionVO> cargarDatosMarcaciones(String strArchivoIn) {
		List<PersonalMarcacionVO> listaMarcaciones	= null;	
		BufferedReader entrada      	 			= null;
		List<String> alText         	 			= null;
		File ffile                  	 			= null;
		String aux,strfechamarc,strhoramarc			= null;
		PersonalMarcacionVO m						= null;
        String [] strData				 			= null;
        String strNumerodoc							= null;
        Date  dte_marc								= null;
        Time  hor_marc								= null;
        int cont									= 0;
		 try {
			 Map<String,Object> session =  ActionContext.getContext().getSession();
			 user						= (Usuario) session.get("USUARIO_ACTUAL");
			 
			 alText = new ArrayList<String>();
			 ffile  = new File(strArchivoIn);
			 if(ffile.isFile()){
				 if(ffile.exists()){
					listaMarcaciones 	= new ArrayList<PersonalMarcacionVO>();
					entrada 			= new BufferedReader( new FileReader( strArchivoIn ) );
			        aux     			= entrada.readLine().trim();
			        
			        
			        while(aux 	!= null){		        	
			            alText.add(aux.substring(0, aux.length() - 1).trim());
			            aux 	= entrada.readLine();
			        }
			        entrada.close();
			        
			        if(alText.size()>0){
			        	for(String x : alText){
			        		
			        		m		= new PersonalMarcacionVO();
				        	strData = x.split(",");
				        	
				        	if (strData[0].matches("\\d+")){
				        		strNumerodoc = strData[0];
				        		strfechamarc = strData[1] + "-" + strData[2] + "-" + strData[3];				        		
				        		strhoramarc  = strData[4] + ":" + strData[5] + ":" + strData[6];
				        		dte_marc  	 = Funciones.convertString2Sqldate(strfechamarc);
				        		hor_marc  	 = Funciones.ConvertString2Time(strhoramarc);
				        		personalVO	 = personalMarcacionService.Idpersonalxnumerodoc(strNumerodoc);
				        		
				        		if (personalVO.size()	 >= 1){
//				        		if (personalVO.get(0).getIdpersonal() > 0){
				        			personalMarcacionVO  = personalMarcacionService.MarcacionxIdpersonalfechamarchoramarc(personalVO.get(0).getIdpersonal(), strfechamarc, strhoramarc);
				        			if (personalMarcacionVO.size() == 0){
				        				Tipo td = new Tipo(33);//idtabla = 33 => TEMPUS
				        				td.setIdtipo(ValueConstants.TipoMarcacionTempus);
				        				m.setTipomarcacion(td);
						        		m.setDte_fec_marc(dte_marc);
						        		m.setHor_hor_marc(hor_marc);
						        		m.setIdpersonal(personalVO.get(0).getIdpersonal());
						        		m.setTsp_fec_crea(Funciones.fechaHoyTimeStamp());
						        		m.setInt_id_usu_crea(user.getIdUsuario());
						        		m.setTsp_fec_mod(null);
						        		m.setInt_id_usu_mod(0);
						        		m.setInt_flag(0);
						        		
								        listaMarcaciones.add(m);
								        
				        			}
				        		}					    	
				        	}				        	
				        }
			        	// ADD 13-07-2015 D.V.R: SETEA FECHA DEL ARCHIVO, PARA GENERAR ASISTENCIA PARA EL PERSONAL QUE NO TIENE.
			        	if(listaMarcaciones.size() == 0){
			        		m	= new PersonalMarcacionVO();
			        		m.setDte_fec_marc1(dte_marc);			        		
					        listaMarcaciones.add(m);					        
	        			}
			        	//END
	        				
			        }
				 }
			 }
			 
			        
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		 return listaMarcaciones;        
	}
	
	
	
	public File getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(File archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public String getArchivoAdjuntoFileName() {
		return archivoAdjuntoFileName;
	}

	public void setArchivoAdjuntoFileName(String archivoAdjuntoFileName) {
		this.archivoAdjuntoFileName = archivoAdjuntoFileName;
	}

	public String getTmpFileName() {
		return tmpFileName;
	}

	public void setTmpFileName(String tmpFileName) {
		this.tmpFileName = tmpFileName;
	}

	public String getArchivoAdjuntoContentType() {
		return archivoAdjuntoContentType;
	}

	public void setArchivoAdjuntoContentType(String archivoAdjuntoContentType) {
		this.archivoAdjuntoContentType = archivoAdjuntoContentType;
	}

	public String getFilePathToSaveInDB() {
		return filePathToSaveInDB;
	}

	public void setFilePathToSaveInDB(String filePathToSaveInDB) {
		this.filePathToSaveInDB = filePathToSaveInDB;
	}

	public String getArchivoAdjuntoSize() {
		return archivoAdjuntoSize;
	}

	public void setArchivoAdjuntoSize(String archivoAdjuntoSize) {
		this.archivoAdjuntoSize = archivoAdjuntoSize;
	}

//	public Personanatural getPersonanatural() {
//		return personanatural;
//	}
//
//	public void setPersonanatural(Personanatural personanatural) {
//		this.personanatural = personanatural;
//	}


	public List<PersonalMarcacionVO> getPersonalMarcacionVO() {
		return personalMarcacionVO;
	}


	public void setPersonalMarcacionVO(List<PersonalMarcacionVO> personalMarcacionVO) {
		this.personalMarcacionVO = personalMarcacionVO;
	}


	public PersonalMarcacionService getPersonalMarcacionService() {
		return personalMarcacionService;
	}


	public void setPersonalMarcacionService(
			PersonalMarcacionService personalMarcacionService) {
		this.personalMarcacionService = personalMarcacionService;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
    
    
    
	
}
