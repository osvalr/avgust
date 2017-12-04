package sernanp.rrhh.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.excel.ProcesarDatosHoja;
import sernanp.rrhh.service.PersonalContratoService;
import sernanp.rrhh.service.PersonalMarcacionService;
import sernanp.rrhh.service.PersonalService;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.Areanatural;
import sernanp.rrhh.vo.PersonalContratoVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.Tipo;
import sernanp.rrhh.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadPersonalExcelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private File archivoAdjunto;
    private String archivoAdjuntoFileName;
    private String tmpFileName;
    private String archivoAdjuntoContentType;
    private String filePathToSaveInDB;    
    private String archivoAdjuntoSize;
       
    private Areanatural areanatural;
    private PersonalService personalService;
    private PersonalContratoService personalcontratoService;
    
        
    private List<PersonalVO> dataobtenidaexcel;    
    private HashMap<String, Object> datos;
    
    private List<PersonalMarcacionVO> ListamarcacionesObtenidasANPs;
    private List<PersonalMarcacionVO> ListamarcacionesANPs;
//    private List<PersonalMarcacionVO> ListapersonalMarcacionVO;  
    private PersonalMarcacionService personalMarcacionService;
    private Usuario user;


	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}

	public void setPersonalcontratoService(
			PersonalContratoService personalcontratoService) {
		this.personalcontratoService = personalcontratoService;
	}

		
	public UploadPersonalExcelAction(){
		areanatural 						= new Areanatural();
		dataobtenidaexcel					= new ArrayList<PersonalVO>();
		datos 								= new HashMap<String, Object>();		
		ListamarcacionesObtenidasANPs		= new ArrayList<PersonalMarcacionVO>();
		ListamarcacionesANPs				= new ArrayList<PersonalMarcacionVO>();
//		ListapersonalMarcacionVO			= new ArrayList<PersonalMarcacionVO>();

	}    
    

	public String execute(){
		return SUCCESS;
		
	}

	public String uploadExcel_23_10_2014() {
		
		List<PersonalVO> listapersonal 						= null;	
		List<PersonalVO> listapersonalguardar 				= null;
		List<PersonalVO> listapersonalupdatestado			= null;
		PersonalVO	personal_estado							= null;
		List<PersonalContratoVO> listacontratoInsert		= null;
		List<PersonalContratoVO> listacontratoUpdate		= null;
		List<PersonalContratoVO> listacontratoxidpersonal	= null;
		PersonalContratoVO contrato							= null;		
		Map<Integer,String> personalenBD					= null;
		String filePath     								= null;
		String[] ext 										= null;
		File uploadDir 										= null;
		String nrodocx 										= null;	
		int	idPersonalContrato								= 0;
//		int	n												= 0;
//		int	sn												= 0;

	    try {				
	    	filePath    			= "/tmp/";
			ext 					= Funciones.explodeString(archivoAdjuntoFileName, ".");
			this.tmpFileName 		= String.valueOf((new Date()).getTime())+"."+ext[(ext.length - 1)];				
	        uploadDir 				= new File(filePath);                        
	        FileUtils.copyFile(archivoAdjunto, new File(uploadDir, this.tmpFileName));		
	        filePath            	+= this.tmpFileName;       
	        ProcesarDatosHoja hoja 	= new ProcesarDatosHoja();       
	        dataobtenidaexcel		= hoja.cargarDatosExcel(filePath, 0);  
	        
	        if (dataobtenidaexcel.get(dataobtenidaexcel.size() - 1).getPersonanatural().getNumerodocumento().isEmpty()){
	        	dataobtenidaexcel.remove(dataobtenidaexcel.size() - 1);	        
	        }

	        if (dataobtenidaexcel.size() 	> 0){			
				listapersonal   	  				= personalService.lista_personal();
				personalenBD						= new HashMap<Integer, String>();
				listacontratoxidpersonal			= new ArrayList<PersonalContratoVO>();
				listapersonalguardar 				= new ArrayList<PersonalVO>();
				listacontratoUpdate					= new ArrayList<PersonalContratoVO>();
				listacontratoInsert					= new ArrayList<PersonalContratoVO>();
				listapersonalupdatestado			= new ArrayList<PersonalVO>();
				
				for(PersonalVO pp : listapersonal){
					
					if (pp.getPersonanatural().getNumerodocumento() != null && pp.getIdpersonal() != 0){
//						n++;
						personalenBD.put(pp.getIdpersonal(), pp.getPersonanatural().getNumerodocumento());
					}else{
//						sn++;
					}
				}
//				System.out.println("Cantidad de Personal en BD con N° doc : " + n + " <-----> Cantidad de Personal en BD sin N° doc : " + sn + " Total ==>" + (n + sn));
//				n = 0;	sn = 0;

	        	for(PersonalVO x : dataobtenidaexcel){
	        		nrodocx  = x.getPersonanatural().getNumerodocumento();
//	        		if(x.getInt_flag() == 0){	 // Solo cuando pertenezca a la Sede Central
		        		if(personalenBD.containsValue(nrodocx) ){
		        		    for(Object idPersonal : personalenBD.keySet()){		        		    	
		        		        if(personalenBD.get(idPersonal).equals(nrodocx)) {
				        			idPersonalContrato			= (Integer) idPersonal;
		    	        		    //Agrega idpersonal donde actualizara los estados ...(27-09-2013)
		    	        			personal_estado = new PersonalVO();
		    	        			personal_estado.setIdpersonal((Integer) idPersonal);
		    	        			personal_estado.setEstado(x.getEstado());
		    	        			personal_estado.setTurno(x.getTurno());
		    	        			personal_estado.setInt_flag(x.getInt_flag());
		    	        			
		    	        			
		    	        			listapersonalupdatestado.add(personal_estado);	
		    	        			
		        		        	
		        		        	x.getListapersonalcontrato().get(0).setIdpersonal(idPersonalContrato);
		        		        	contrato	= x.getListapersonalcontrato().get(0);	
		        		        	
		        		        	listacontratoxidpersonal	= personalcontratoService.listacontratoxidpersonal(idPersonalContrato);
		        		        	
		        		        	if (listacontratoxidpersonal.get(0).getDte_fec_suscrip() != null){
			        		        	if(listacontratoxidpersonal.get(0).getDte_fec_suscrip().compareTo(x.getListapersonalcontrato().get(0).getDte_fec_inicio()) < 0 ){
			        		        		listacontratoUpdate.add(contrato);
			        		        	}
		        		        	}else{
		        		        		listacontratoInsert.add(contrato);
		        		        	}		
		        		        	break;
		        		        }
		        		    }
		        		}else{
		        			listapersonalguardar.add(x);
		        		}	        			
//	        		}
	
	        	}
	        }			
	        
	        if ((listapersonalguardar.size() + listapersonalupdatestado.size() + listacontratoUpdate.size() + listacontratoInsert.size()) > 0 ){

		        
	        	if(listapersonalupdatestado.size() > 0){
		        	personalService.updatePersonalEstado(listapersonalupdatestado);	
		        	addActionMessage("Se actualizó información de  '"+ listapersonalupdatestado.size() +"' Persona(s).");
		        }
		        
	        	if(listacontratoUpdate.size() > 0){
		        	personalService.updatePersonalContrato(listacontratoUpdate);
		        	addActionMessage("Se actualizó información de  '"+ listacontratoUpdate.size() +"' Contrato(s).");
		        }
	        	
		        if(listacontratoInsert.size() > 0){
		           	personalService.updatePersonalContrato(listacontratoInsert);
		           	addActionMessage("Se registro información de  '"+ listacontratoInsert.size() +"' Contrato(s).");
		        }        
		        
		        if (listapersonalguardar.size() > 0 ){
		        	personalService.guardarPersonal(listapersonalguardar);
		        	addActionMessage("Se registro información de  '"+ listapersonalguardar.size() +"' Persona(s).");
	       	   }

	        }else{
	        	addActionMessage("No existe información para Registrar / Actualizar!");
	        }	
	        
	        
	    	   
	    } catch (Exception e) {
	    	e.printStackTrace();    	
	    	addActionError("Problema inesperado, por favor vuelva a intentarlo.");    	
	    	return ERROR;
	    }    
	    return SUCCESS;
	}

	public String uploadExcel() {
		
		List<PersonalVO> listapersonal 						= null;	
		List<PersonalVO> listapersonalguardar 				= null;
		List<PersonalVO> listapersonalupdatestado			= null;
		PersonalVO	personal_estado							= null;	
		Map<Integer,String> personalenBD					= null;
		String filePath     								= null;
		String[] ext 										= null;
		File uploadDir 										= null;
		String nrodocx 										= null;	


	    try {				
	    	filePath    			= "/tmp/";
			ext 					= Funciones.explodeString(archivoAdjuntoFileName, ".");
			this.tmpFileName 		= String.valueOf((new Date()).getTime())+"."+ext[(ext.length - 1)];				
	        uploadDir 				= new File(filePath);                        
	        FileUtils.copyFile(archivoAdjunto, new File(uploadDir, this.tmpFileName));		
	        filePath            	+= this.tmpFileName;       
	        ProcesarDatosHoja hoja 	= new ProcesarDatosHoja();       
	        dataobtenidaexcel		= hoja.cargarDatosExcel(filePath, 0);  
	        
	        if (dataobtenidaexcel.get(dataobtenidaexcel.size() - 1).getPersonanatural().getNumerodocumento().isEmpty()){
	        	dataobtenidaexcel.remove(dataobtenidaexcel.size() - 1);	        
	        }

	        if (dataobtenidaexcel.size() 	> 0){			
				listapersonal   	  				= personalService.lista_personal();
				personalenBD						= new HashMap<Integer, String>();
				listapersonalguardar 				= new ArrayList<PersonalVO>();
				listapersonalupdatestado			= new ArrayList<PersonalVO>();
				
				for(PersonalVO pp : listapersonal){
					
					if (pp.getPersonanatural().getNumerodocumento() != null && pp.getIdpersonal() != 0){
//						n++;
						personalenBD.put(pp.getIdpersonal(), pp.getPersonanatural().getNumerodocumento());
					}else{
//						sn++;
					}
				}
//				System.out.println("Cantidad de Personal en BD con N° doc : " + n + " <-----> Cantidad de Personal en BD sin N° doc : " + sn + " Total ==>" + (n + sn));
//				n = 0;	sn = 0;

	        	for(PersonalVO x : dataobtenidaexcel){
	        		nrodocx  = x.getPersonanatural().getNumerodocumento();
	        		if(personalenBD.containsValue(nrodocx) ){
	        		    for(Object idPersonal : personalenBD.keySet()){		        		    	
	        		        if(personalenBD.get(idPersonal).equals(nrodocx)) {

	    	        			personal_estado = new PersonalVO();
	    	        			personal_estado.setIdpersonal((Integer) idPersonal);
	    	        			personal_estado.setEstado(x.getEstado());
	    	        			personal_estado.setTurno(x.getTurno());
	    	        			personal_estado.setInt_flag(x.getInt_flag());
	    	        			
	    	        			
	    	        			listapersonalupdatestado.add(personal_estado);	
	
	        		        	break;
	        		        }
	        		    }
	        		}else{
	        			listapersonalguardar.add(x);
	        		}	
	        	}
	        }			
	        

	        if ((listapersonalguardar.size() + listapersonalupdatestado.size() ) > 0 ){
		        
	        	if(listapersonalupdatestado.size() > 0){
		        	personalService.updatePersonalEstado(listapersonalupdatestado);	
		        	addActionMessage("Se actualizó información de  '"+ listapersonalupdatestado.size() +"' Personal.");
		        }

		        if (listapersonalguardar.size() > 0 ){
		        	personalService.guardarPersonal(listapersonalguardar);
		        	addActionMessage("Se registro información de  '"+ listapersonalguardar.size() +"' Personal nuevo .");
	       	   }

	        }else{
	        	addActionMessage("No existe información para Registrar / Actualizar!");
	        }	
	        
	        
	    	   
	    } catch (Exception e) {
	    	e.printStackTrace();    	
	    	addActionError("Problema inesperado, por favor vuelva a intentarlo.");    	
	    	return ERROR;
	    }    
	    return SUCCESS;
	}

	
	public String uploadExcelMarcacionesANPs() {		

		String filePath     								= null;
		String[] ext 										= null;
		File uploadDir 										= null;
		PersonalMarcacionVO pmarcacion						= null;
		List<PersonalMarcacionVO> ListapersonalMarcacionVO  = null; 							
	    List<PersonalVO> personalVO 						= null; 
	    Integer i 											= 0, j = 0;
	    Map<Integer, java.sql.Date> ListafechasMarcaciones 	= null;
	    Map<Integer,Integer> ListafechasCantMarc		= null;
		
	    try {		
			 Map<String,Object> session =  ActionContext.getContext().getSession();
			 user						= (Usuario) session.get("USUARIO_ACTUAL");
	    	filePath    					= "/tmp/";
			ext 							= Funciones.explodeString(archivoAdjuntoFileName, ".");
			this.tmpFileName 				= String.valueOf((new Date()).getTime())+"."+ext[(ext.length - 1)];				
	        uploadDir 						= new File(filePath);                        
	        FileUtils.copyFile(archivoAdjunto, new File(uploadDir, this.tmpFileName));		
	        filePath          			  	+= this.tmpFileName;       

	        ProcesarDatosHoja procesaexcel 	= new ProcesarDatosHoja();       
	        
//	        System.out.println("Inicio Lectura : " + new Date());
	        
	        ListamarcacionesObtenidasANPs	= procesaexcel.cargarMarcacionesANPsExcel(filePath);
	        
//	        System.out.println("Fín Lectura : " + new Date());
	        
//	        System.out.println("Size Lista - marcacionesANPs --> " + ListamarcacionesObtenidasANPs.size());

	        if (ListamarcacionesObtenidasANPs.size() 	> 0){
	        	
	        	if(ListamarcacionesObtenidasANPs.get(0).getVar_descripcion() != null){
	        		
	        		addActionError(ListamarcacionesObtenidasANPs.get(0).getVar_descripcion());	        		
	        		addActionError("Revise las instrucciones del llenado del formato.");
	        		
	    	    	return ERROR;
	        	}
	        	
	        	ListafechasMarcaciones = new HashMap<Integer, java.sql.Date>();
	        	for(PersonalMarcacionVO x : ListamarcacionesObtenidasANPs){
		        	personalVO	 = new ArrayList<PersonalVO>();		
		    		personalVO	 = personalMarcacionService.Idpersonalxnumerodoc(x.getPersonal().getPersonanatural().getNumerodocumento());
		    		
		    		if(personalVO.size() == 0){
		    			addActionError("HOJA : " + x.getVal_temp());
		        		addActionError("DNI : " +x.getPersonal().getPersonanatural().getNumerodocumento() + " no éxiste en la Base de Datos.");
		        		addActionError("Nombre completo : " +x.getPersonal().getPersonanatural().getNombre());
		    	    	return ERROR;
		    		}
		    		
		    		if(personalVO.get(0) != null){		    			
		    			pmarcacion	= x;
		    			pmarcacion.setIdpersonal(personalVO.get(0).getIdpersonal());
		    			ListamarcacionesANPs.add(pmarcacion);		    			
		    		}
		    		
//		    		for(PersonalMarcacionVO x2 : ListamarcacionesObtenidasANPs){
//		    			if(x.getDte_fec_marc().equals(x2.getDte_fec_marc())){
//		    				if(!ListafechasMarcaciones.containsValue(x.getDte_fec_marc())){		    					
//		    					ListafechasMarcaciones.put(i, x.getDte_fec_marc());
//		    					i++;
//		    				}
//		    			}
//		    		}
		    		
	        	}
	        	i=0;
	        }
	        
//	        System.out.println("Fín Validacion N° Doc. : " + new Date());
	        
    		for(PersonalMarcacionVO x2 : ListamarcacionesObtenidasANPs){
				if(!ListafechasMarcaciones.containsValue(x2.getDte_fec_marc())){
					ListafechasMarcaciones.put(i, x2.getDte_fec_marc());
					i++;
				}
    		}
    		

    		i=0;
	        
	        ListamarcacionesObtenidasANPs.clear();	        
	        
	        if ( ListamarcacionesANPs.size() 	> 0 ){
	        	
	        	
	        	for(PersonalMarcacionVO x : ListamarcacionesANPs){
	        		i++;
//	        		System.out.println("****************************** " + j + " ********************************");
//	        		System.out.println(i + ".- " + 	x.getPersonal().getPersonanatural().getNombre() + ", " +
//	        										x.getPersonal().getPersonanatural().getNumerodocumento() + ", " +
//	        										x.getIdpersonal() + ", " +
//	        										(x.getDte_fec_marc() != null ? x.getDte_fec_marc().toString() : "--/--/----") + ", " +
//	        										(x.getHor_hor_marc() != null ? x.getHor_hor_marc().toString() : "--:--:--") + ", " +
//	        										(x.getHor_hor_marc1() != null ? x.getHor_hor_marc1().toString() : "--:--:--")  + ", " +
//	        										(x.getHor_hor_salida_ref() != null ? x.getHor_hor_salida_ref().toString() : "--:--:--") + ", " +
//	        										(x.getHor_hor_retorno_ref() != null ? x.getHor_hor_retorno_ref().toString() : "--:--:--")+ "\r\n");
	        		
					if(x.getHor_hor_marc() != null ){
						
						ListapersonalMarcacionVO = new ArrayList<PersonalMarcacionVO>();
						
						ListapersonalMarcacionVO  = personalMarcacionService.MarcacionxIdpersonalfechamarchoramarc(x.getIdpersonal(), x.getDte_fec_marc().toString(), x.getHor_hor_marc().toString());
						
						if(ListapersonalMarcacionVO.size() == 0){
							pmarcacion	 = addMarcacionesANPs(x);
							pmarcacion.setHor_hor_marc(x.getHor_hor_marc());
							ListamarcacionesObtenidasANPs.add(pmarcacion);
							j++;							
						}
					}
					
					if(x.getHor_hor_marc1() != null ){
						
						ListapersonalMarcacionVO = new ArrayList<PersonalMarcacionVO>();
						
						ListapersonalMarcacionVO  = personalMarcacionService.MarcacionxIdpersonalfechamarchoramarc(x.getIdpersonal(), x.getDte_fec_marc().toString(), x.getHor_hor_marc1().toString());
						
						if(ListapersonalMarcacionVO.size() == 0){
							pmarcacion	 = addMarcacionesANPs(x);
							pmarcacion.setHor_hor_marc(x.getHor_hor_marc1());
							ListamarcacionesObtenidasANPs.add(pmarcacion);
							j++;							
						}
					}
					
					if(x.getHor_hor_salida_ref() != null ){
						
						ListapersonalMarcacionVO = new ArrayList<PersonalMarcacionVO>();
						
						ListapersonalMarcacionVO  = personalMarcacionService.MarcacionxIdpersonalfechamarchoramarc(x.getIdpersonal(), x.getDte_fec_marc().toString(), x.getHor_hor_salida_ref().toString());
						
						if(ListapersonalMarcacionVO.size() == 0){
							pmarcacion	 = addMarcacionesANPs(x);
							pmarcacion.setHor_hor_marc(x.getHor_hor_salida_ref());
							pmarcacion.setInt_marc_refrigerio(1); //MARCACION DE REFRIGERIO
							ListamarcacionesObtenidasANPs.add(pmarcacion);
							j++;							
						}
					}
					
					if(x.getHor_hor_retorno_ref() != null ){
						
						ListapersonalMarcacionVO = new ArrayList<PersonalMarcacionVO>();
						
						ListapersonalMarcacionVO  = personalMarcacionService.MarcacionxIdpersonalfechamarchoramarc(x.getIdpersonal(), x.getDte_fec_marc().toString(), x.getHor_hor_retorno_ref().toString());
						
						if(ListapersonalMarcacionVO.size() == 0){
							pmarcacion	 = addMarcacionesANPs(x);
							pmarcacion.setHor_hor_marc(x.getHor_hor_retorno_ref());
							pmarcacion.setInt_marc_refrigerio(1); //MARCACION DE REFRIGERIO
							ListamarcacionesObtenidasANPs.add(pmarcacion);
							j++;							
						}
					}	        		
	        	}	        	
	        }	
	        
//	        System.out.println("Fín Validacion Marcación por Persona : " + new Date());
	        
//	        System.out.println("Cantidad de Marcaciones que se grabaran (j) --> " + j);
	        
//	        System.out.println("ListamarcacionesANPs.size() --> " + ListamarcacionesObtenidasANPs.size());
	        
	        //LOS ARCHIVOS EXCEL DE LAS MARCACIONES DE LAS ANPs SOLO SE LEERAN UNA VEZ
	        
	        if (ListamarcacionesObtenidasANPs.size() > 0 ){	        
	        	
	        	personalMarcacionService.guardarListaMarcaciones(ListamarcacionesObtenidasANPs, 1);
	        	
//	        	System.out.println("Fín Guardar Marcaciones : " + new Date());
	        	
	        	addActionMessage("Se registraron "+ ListamarcacionesObtenidasANPs.size()+" Marcaciones.");
	        	
	        	//SETEANDO LA CANTIDAD DE MARCACIONES POR FECHA
	        	ListafechasCantMarc	= new HashMap<Integer,Integer>();
	        	for(int j1 = 0; j1 < ListafechasMarcaciones.size(); j1++){
	        		j= 0;
	        		for(PersonalMarcacionVO pm : ListamarcacionesObtenidasANPs){
	        			if(ListafechasMarcaciones.get(j1).equals(pm.getDte_fec_marc())){
	        				j++;
	        			}
	        		}
	        		ListafechasCantMarc.put(j1, j);
	        		addActionMessage("Día " + (j1 + 1) + ": "+Funciones.fechaFormat("dd/MM/yyyy", ListafechasMarcaciones.get(j1)) + ", "+ ListafechasCantMarc.get(j1) + " Marcaciones.");
	        	}
				
	        }else{
	        	addActionMessage("No existe marcaciones nuevas.");
	        }
	    	   
	    } catch (Exception e) {
	    	e.printStackTrace();    	
	    	addActionError("Problema inesperado, por favor vuelva a intentarlo.");    	
	    	return ERROR;
	    }
	    
//	    addActionMessage("Se registraron, "+ ListamarcacionesObtenidasANPs.size()+" Marcaciones");
	    return SUCCESS;
	}
	
	public PersonalMarcacionVO addMarcacionesANPs(PersonalMarcacionVO pm){
		PersonalMarcacionVO pmr 	= new PersonalMarcacionVO();
		Tipo td		= new Tipo(33);
		td.setIdtipo(ValueConstants.TipoMarcacionManual);
		pmr.setTipomarcacion(td);
		pmr.setDte_fec_marc(pm.getDte_fec_marc());
		pmr.setIdpersonal(pm.getIdpersonal());
		pmr.setTsp_fec_crea(Funciones.fechaHoyTimeStamp());
		pmr.setInt_id_usu_crea(user.getIdUsuario());
		pmr.setInt_flag(0);
		return pmr;
	}
	

	public File getArchivoAdjunto() {
		return archivoAdjunto;
	}
	
	public void setArchivoAdjunto(File archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	
	public String getarchivoAdjuntoSize() {
		return archivoAdjuntoSize;
	}
	
	public void setarchivoAdjuntoSize(String archivoAdjuntoSize) {
		this.archivoAdjuntoSize = archivoAdjuntoSize;
	}
	
	public String getArchivoAdjuntoFileName() {
		return archivoAdjuntoFileName;
	}
	
	public void setArchivoAdjuntoFileName(String archivoAdjuntoFileName) {
		this.archivoAdjuntoFileName = archivoAdjuntoFileName;
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
	
	
	public HashMap<String, Object> getDatos() {
		return datos;
	}
	
	public void setDatos(HashMap<String, Object> datos) {
		this.datos = datos;
	}
	
	
	public Areanatural getAreanatural() {
		return areanatural;
	}
	
	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}
	
	public String getTmpFileName() {
		return tmpFileName;
	}
	
	public void setTmpFileName(String tmpFileName) {
		this.tmpFileName = tmpFileName;
	}
	
	public List<PersonalVO> getDataobtenidaexcel() {
		return dataobtenidaexcel;
	}
	
	public void setDataobtenidaexcel(List<PersonalVO> dataobtenidaexcel) {
		this.dataobtenidaexcel = dataobtenidaexcel;
	}



	public List<PersonalMarcacionVO> getListamarcacionesObtenidasANPs() {
		return ListamarcacionesObtenidasANPs;
	}

	public void setListamarcacionesObtenidasANPs(
			List<PersonalMarcacionVO> listamarcacionesObtenidasANPs) {
		ListamarcacionesObtenidasANPs = listamarcacionesObtenidasANPs;
	}

	public List<PersonalMarcacionVO> getListamarcacionesANPs() {
		return ListamarcacionesANPs;
	}

	public void setListamarcacionesANPs(
			List<PersonalMarcacionVO> listamarcacionesANPs) {
		ListamarcacionesANPs = listamarcacionesANPs;
	}

//	public List<PersonalMarcacionVO> getListapersonalMarcacionVO() {
//		return ListapersonalMarcacionVO;
//	}
//
//	public void setListapersonalMarcacionVO(
//			List<PersonalMarcacionVO> listapersonalMarcacionVO) {
//		ListapersonalMarcacionVO = listapersonalMarcacionVO;
//	}

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
