/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 19/04/2015 01:20:12
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import sernanp.app.business.core.common.service.CommonServiceMybatis;
import sernanp.app.business.core.seleccion.service.GestionarReqPersonalService;
import sernanp.app.dao.query.domain.ArchivoRequerimientoQuery;
import sernanp.app.dao.query.domain.GestionarReqPersonalQuery;
import sernanp.app.dao.query.domain.GestionarReqPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQuery;
import sernanp.app.dao.query.mapper.ArchivoRequerimientoQueryMapper;
import sernanp.app.dao.query.mapper.GestionarReqPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerSedeAdministrativaAreaOrganicaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.vo.Usuario;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.rrhh.web.bean.FileCommonBean;

public class GestionarReqPersonalAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;
	
	private InputStream fileInputStream;
	private String fileName;
	private String contentType;
	private List listResult;
	
	private Usuario user;
	
	
	@Autowired
	CommonServiceMybatis commonServiceMybatis;

	@Autowired
	private GestionarReqPersonalService gestionarReqPersonalService;
	private GestionarReqPersonalQuery gestionarReqPersonalQuery;
	private ArchivoRequerimientoQuery archivoRequerimientoQuery;
	
	private ObtenerSedeAdministrativaAreaOrganicaQuery obtenerSedeAreaOrganica;
	
	
	public String viewPorArea(){
		
		Map<String, Object> session 	= ActionContext.getContext().getSession();
		
		
		user					= (Usuario)session.get("USUARIO_ACTUAL");
		
		System.out.println(user.getApemat());
		
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarReqPersonalQueryCriteria gestionarReqPersonalQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarReqPersonalQueryCriteria.class);
			
			gestionarReqPersonalQueryCriteria.setIdarea_solicitante(user.getIdarea());
			
			List<GestionarReqPersonalQuery> listGestionarReqPersonalQuery = gestionarReqPersonalService.getListByQuery(GestionarReqPersonalQueryMapper.class, gestionarReqPersonalQueryCriteria, start, limit);
			int total = gestionarReqPersonalService.getCountRowsByQuery(GestionarReqPersonalQueryMapper.class, gestionarReqPersonalQueryCriteria);
			
			this.success(listGestionarReqPersonalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	public String view(){
		
		System.out.println("view - Consultando filtros");
		
		
		Map<String, Object> session 	= ActionContext.getContext().getSession();
		
		
		user					= (Usuario)session.get("USUARIO_ACTUAL");
		
		System.out.println(user.getApemat());
		System.out.println(user.getIdarea());
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarReqPersonalQueryCriteria gestionarReqPersonalQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarReqPersonalQueryCriteria.class);
			
			List<GestionarReqPersonalQuery> listGestionarReqPersonalQuery = gestionarReqPersonalService.getListByQuery(GestionarReqPersonalQueryMapper.class, gestionarReqPersonalQueryCriteria, start, limit);
			int total = gestionarReqPersonalService.getCountRowsByQuery(GestionarReqPersonalQueryMapper.class, gestionarReqPersonalQueryCriteria);
			
			this.success(listGestionarReqPersonalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	public String create() throws FileNotFoundException, IOException{
		
		try{
			List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
			String path_files_requerimiento = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.requerimiento");
			gestionarReqPersonalQuery.setPath_files_requerimiento(path_files_requerimiento);			
			gestionarReqPersonalService.create(gestionarReqPersonalQuery,listArchivoRequerimientoQuery);
			this.getSessionContext().setAttribute("ArchivoRequerimientoQueryList",null);
			this.success(gestionarReqPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save()  throws FileNotFoundException, IOException{
		
		try{
			List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
			String path_files_requerimiento = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.requerimiento");
			gestionarReqPersonalQuery.setPath_files_requerimiento(path_files_requerimiento);
			gestionarReqPersonalService.save(gestionarReqPersonalQuery,listArchivoRequerimientoQuery);
			this.getSessionContext().setAttribute("ArchivoRequerimientoQueryList",null);
			this.success(gestionarReqPersonalQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove() throws FileNotFoundException, IOException{
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_requerimiento_personal", gestionarReqPersonalQuery.getSrl_id_requerimiento_personal());
			List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = this.gestionarReqPersonalService.getListByQuery(ArchivoRequerimientoQueryMapper.class, paramMap);
			gestionarReqPersonalService.remove(gestionarReqPersonalQuery,listArchivoRequerimientoQuery);
			this.getSessionContext().removeAttribute("ArchivoRequerimientoQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoRequerimientoQueryList(){
		
		List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery;
		List<ArchivoRequerimientoQuery> subListArchivoRequerimientoQuery;
		Integer srl_id_requerimiento_personal = this.getIntegerParameter("srl_id_requerimiento_personal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_requerimiento_personal == null){
			listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
		}else if(srl_id_requerimiento_personal.equals("-1")){
			listArchivoRequerimientoQuery = new ArrayList<ArchivoRequerimientoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_requerimiento_personal", srl_id_requerimiento_personal);
			listArchivoRequerimientoQuery = this.gestionarReqPersonalService.getListByQuery(ArchivoRequerimientoQueryMapper.class, paramMap);
		}

		if(listArchivoRequerimientoQuery == null){
			listArchivoRequerimientoQuery = new ArrayList<ArchivoRequerimientoQuery>();
		}
		this.getSessionContext(true).setAttribute("ArchivoRequerimientoQueryList",listArchivoRequerimientoQuery);
		int size = listArchivoRequerimientoQuery.size();
		subListArchivoRequerimientoQuery = this.getSubList(listArchivoRequerimientoQuery, start, limit);
		
		this.success(subListArchivoRequerimientoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoRequerimientoQueryAdd(){
		
		List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
		FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(archivoRequerimientoQuery.getFile_name_session());
		
		int randomInt = this.getNegativeIdRandom();
		archivoRequerimientoQuery.setSrl_id_archivo(randomInt);
		archivoRequerimientoQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
		archivoRequerimientoQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
		archivoRequerimientoQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
		listArchivoRequerimientoQuery.add(archivoRequerimientoQuery);	
		this.getSessionContext().setAttribute("ArchivoRequerimientoQueryList",listArchivoRequerimientoQuery);
		this.success(archivoRequerimientoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoRequerimientoQueryUpdate(){
		
		List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
		int index = -1;
		
		for (int i = 0; i < listArchivoRequerimientoQuery.size(); i++) {
			if(listArchivoRequerimientoQuery.get(i).getSrl_id_archivo().equals(archivoRequerimientoQuery.getSrl_id_archivo())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(archivoRequerimientoQuery.getFile_name_session());
			if(fileCommonBean != null) {
				archivoRequerimientoQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
				archivoRequerimientoQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
				archivoRequerimientoQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
			}
			
			listArchivoRequerimientoQuery.set(index, archivoRequerimientoQuery);
		}
		
		this.getSessionContext().setAttribute("ArchivoRequerimientoQueryList",listArchivoRequerimientoQuery);
		this.getSessionContext().setAttribute(archivoRequerimientoQuery.getFile_name_session(), null);
		this.success(archivoRequerimientoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoRequerimientoQueryDelete(){
		
		List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
		int index = -1;
		for (int i = 0; i < listArchivoRequerimientoQuery.size(); i++) {
			if(listArchivoRequerimientoQuery.get(i).getSrl_id_archivo().equals(archivoRequerimientoQuery.getSrl_id_archivo())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listArchivoRequerimientoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ArchivoRequerimientoQueryList",listArchivoRequerimientoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String downloadFile() throws FileNotFoundException{
		
		Integer srl_id_archivo = this.getIntegerParameter("srl_id_archivo");
		List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery = (List<ArchivoRequerimientoQuery>) this.getSessionContext().getAttribute("ArchivoRequerimientoQueryList");
		int index = -1;
		
		for(int i = 0; i < listArchivoRequerimientoQuery.size(); i++){
			if(listArchivoRequerimientoQuery.get(i).getSrl_id_archivo().equals(srl_id_archivo)){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			archivoRequerimientoQuery = listArchivoRequerimientoQuery.get(index);
			contentType = archivoRequerimientoQuery.getVar_tipo_archivo();
			File fileToDownload = new File(archivoRequerimientoQuery.getVar_archivo_ruta_almacen());
			     fileName = fileToDownload.getName();
			     fileInputStream = new FileInputStream(fileToDownload);
		}
		
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarReqPersonalService getGestionarReqPersonalService() {
		return gestionarReqPersonalService;
	}

	public void setGestionarReqPersonalService(GestionarReqPersonalService gestionarReqPersonalService) {
		this.gestionarReqPersonalService = gestionarReqPersonalService;
	}
	
	public GestionarReqPersonalQuery getGestionarReqPersonalQuery() {
		return gestionarReqPersonalQuery;
	}

	public void setGestionarReqPersonalQuery(GestionarReqPersonalQuery gestionarReqPersonalQuery) {
		this.gestionarReqPersonalQuery = gestionarReqPersonalQuery;
	}
	public ArchivoRequerimientoQuery getArchivoRequerimientoQuery() {
		return archivoRequerimientoQuery;
	}

	public void setArchivoRequerimientoQuery(ArchivoRequerimientoQuery archivoRequerimientoQuery) {
		this.archivoRequerimientoQuery = archivoRequerimientoQuery;
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

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public ObtenerSedeAdministrativaAreaOrganicaQuery getObtenerSedeAreaOrganica() {
		return obtenerSedeAreaOrganica;
	}

	public void setObtenerSedeAreaOrganica(ObtenerSedeAdministrativaAreaOrganicaQuery obtenerSedeAreaOrganica) {
		this.obtenerSedeAreaOrganica = obtenerSedeAreaOrganica;
	}

	public List getListResult() {
		return listResult;
	}

	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	
	
/*
<!-- Start Actions GestionarReqPersonal -->
<action name="GestionarReqPersonalView" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="view">
		<result type="json" />
</action>

<action name="GestionarReqPersonalCreate" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="create">
		<result type="json" />
</action>

<action name="GestionarReqPersonalSave" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="save">
		<result type="json" />
</action>

<action name="GestionarReqPersonalRemove" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model ArchivoRequerimientoQuery Actions -->
<action name="ArchivoRequerimientoQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="ArchivoRequerimientoQueryList">
		<result type="json" />
</action>

<action name="ArchivoRequerimientoQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="ArchivoRequerimientoQueryAdd">
		<result type="json" />
</action>

<action name="ArchivoRequerimientoQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="ArchivoRequerimientoQueryUpdate">
		<result type="json" />
</action>

<action name="ArchivoRequerimientoQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarReqPersonalAction" method="ArchivoRequerimientoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ArchivoRequerimientoQuery Actions -->

<!-- End Actions GestionarReqPersonal -->
*/
}
