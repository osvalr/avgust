package sernanp.rrhh.web.action.planilla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.GenerarPlameService;
import sernanp.app.business.dto.RptPlameBean;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class GenerarPlameAction extends ActionHelperExtjs {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GenerarPlameService generarPlameService;
	
	private InputStream fileInputStream;
    private String fileName;
    private String contentType;
    

	public String generarPlame(){
		
		try{
			
			Integer srl_id_anio_periodo_planilla = this.getIntegerParameter("srl_id_anio_periodo_planilla");
			Integer srl_id_regimen_contractual = this.getIntegerParameter("srl_id_regimen_contractual");
			Integer srl_id_fuente_financiamiento = this.getIntegerParameter("srl_id_fuente_financiamiento");
			
			RptPlameBean rpPlameBean = generarPlameService.generarPlame(srl_id_anio_periodo_planilla, srl_id_regimen_contractual, srl_id_fuente_financiamiento);
			
    	    File temp = File.createTempFile("tempfile", ".tmp"); 
 
    	    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    	    bw.write(rpPlameBean.getContenido());
    	    bw.close();
    	    
            fileName = rpPlameBean.getNombreArchivo();
            fileInputStream = new FileInputStream(temp);
			
			
		}catch(BusinessException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return this.extjsReturn;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
