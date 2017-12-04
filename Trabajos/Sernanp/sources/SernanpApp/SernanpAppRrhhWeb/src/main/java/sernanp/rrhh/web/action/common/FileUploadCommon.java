package sernanp.rrhh.web.action.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.common.service.FileCommonsService;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.rrhh.web.bean.FileCommonBean;

public class FileUploadCommon extends ActionHelperExtjs {

	private static final long serialVersionUID = -8645033536553055762L;

	@Autowired
	private FileCommonsService fileCommonsService;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String file_name_session;
	private boolean success = false;
	
	public String saveUpload() throws BusinessException, FileNotFoundException, IOException{
		
		String pathTemp = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.temp");
		
		File destino = new File(pathTemp + File.separator + uploadFileName);
		File origen = new File(upload.getAbsolutePath());
		fileCommonsService.copy(origen,destino);
		
		FileCommonBean fileCommonBean = new FileCommonBean();
		fileCommonBean.setPathFile(destino.getAbsolutePath());
		fileCommonBean.setFileContentType(uploadContentType);
		fileCommonBean.setFileName(uploadFileName);
		
		this.getSessionContext().setAttribute(file_name_session, fileCommonBean);
		
		success = true;
		
		return SUCCESS;
	}
	
	public String getFile_name_session() {
		return file_name_session;
	}

	public void setFile_name_session(String file_name_session) {
		this.file_name_session = file_name_session;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return this.extjsReturn;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
