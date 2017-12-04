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
* DATE CREATE : 20/04/2015 00:26:11
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

import sernanp.app.business.core.seleccion.service.GestionarPlazaService;
import sernanp.app.dao.query.domain.ArchivoPlazaQuery;
import sernanp.app.dao.query.domain.GestionarPlazaQuery;
import sernanp.app.dao.query.domain.GestionarPlazaQueryCriteria;
import sernanp.app.dao.query.domain.PostulantePlazaQuery;
import sernanp.app.dao.query.domain.SubEtapaPlazaQuery;
import sernanp.app.dao.query.mapper.ArchivoPlazaQueryMapper;
import sernanp.app.dao.query.mapper.GestionarPlazaQueryMapper;
import sernanp.app.dao.query.mapper.PostulantePlazaQueryMapper;
import sernanp.app.dao.query.mapper.SubEtapaPlazaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.rrhh.web.bean.FileCommonBean;

public class GestionarPlazaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;
	
	private InputStream fileInputStream;
    private String fileName;
    private String contentType;

	@Autowired
	private GestionarPlazaService gestionarPlazaService;
	private GestionarPlazaQuery gestionarPlazaQuery;
	private SubEtapaPlazaQuery subEtapaPlazaQuery;
	private PostulantePlazaQuery postulantePlazaQuery;
	private ArchivoPlazaQuery archivoPlazaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarPlazaQueryCriteria gestionarPlazaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarPlazaQueryCriteria.class);
			List<GestionarPlazaQuery> listGestionarPlazaQuery = gestionarPlazaService.getListByQuery(GestionarPlazaQueryMapper.class, gestionarPlazaQueryCriteria, start, limit);
			int total = gestionarPlazaService.getCountRowsByQuery(GestionarPlazaQueryMapper.class, gestionarPlazaQueryCriteria);
			
			this.success(listGestionarPlazaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create() throws FileNotFoundException, IOException{
		
		try{
			List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery = (List<SubEtapaPlazaQuery>) this.getSessionContext().getAttribute("SubEtapaPlazaQueryList");
			List<PostulantePlazaQuery> listPostulantePlazaQuery = (List<PostulantePlazaQuery>) this.getSessionContext().getAttribute("PostulantePlazaQueryList");
			List<ArchivoPlazaQuery> listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
			String path_files_plazas = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.plazas");
			gestionarPlazaQuery.setPath_files_plazas(path_files_plazas);
			gestionarPlazaService.create(gestionarPlazaQuery,listSubEtapaPlazaQuery, listPostulantePlazaQuery, listArchivoPlazaQuery);
			this.getSessionContext().setAttribute("SubEtapaPlazaQueryList",null);
			this.getSessionContext().setAttribute("PostulantePlazaQueryList",null);
			this.getSessionContext().setAttribute("ArchivoPlazaQueryList",null);
			this.success(gestionarPlazaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save() throws FileNotFoundException, IOException{
		
		try{
			List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery = (List<SubEtapaPlazaQuery>) this.getSessionContext().getAttribute("SubEtapaPlazaQueryList");
			List<PostulantePlazaQuery> listPostulantePlazaQuery = (List<PostulantePlazaQuery>) this.getSessionContext().getAttribute("PostulantePlazaQueryList");
			List<ArchivoPlazaQuery> listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
			String path_files_plazas = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.plazas");
			gestionarPlazaQuery.setPath_files_plazas(path_files_plazas);
			gestionarPlazaService.save(gestionarPlazaQuery,listSubEtapaPlazaQuery, listPostulantePlazaQuery, listArchivoPlazaQuery);
			this.getSessionContext().setAttribute("SubEtapaPlazaQueryList",null);
			this.getSessionContext().setAttribute("PostulantePlazaQueryList",null);
			this.getSessionContext().setAttribute("ArchivoPlazaQueryList",null);
			this.success(gestionarPlazaQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove() throws FileNotFoundException, IOException{
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_conv_area_org", gestionarPlazaQuery.getSrl_id_conv_area_org());
			List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery = this.gestionarPlazaService.getListByQuery(SubEtapaPlazaQueryMapper.class, paramMap);
			paramMap.put("srl_id_conv_area_org", gestionarPlazaQuery.getSrl_id_conv_area_org());
			List<PostulantePlazaQuery> listPostulantePlazaQuery = this.gestionarPlazaService.getListByQuery(PostulantePlazaQueryMapper.class, paramMap);
			paramMap.put("srl_id_conv_area_org", gestionarPlazaQuery.getSrl_id_conv_area_org());
			List<ArchivoPlazaQuery> listArchivoPlazaQuery = this.gestionarPlazaService.getListByQuery(ArchivoPlazaQueryMapper.class, paramMap);
			gestionarPlazaService.remove(gestionarPlazaQuery,listSubEtapaPlazaQuery, listPostulantePlazaQuery, listArchivoPlazaQuery);
			this.getSessionContext().removeAttribute("SubEtapaPlazaQueryList");
			this.getSessionContext().removeAttribute("PostulantePlazaQueryList");
			this.getSessionContext().removeAttribute("ArchivoPlazaQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaPlazaQueryList(){
		
		List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery;
		List<SubEtapaPlazaQuery> subListSubEtapaPlazaQuery;
		Integer srl_id_conv_area_org = this.getIntegerParameter("srl_id_conv_area_org");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_conv_area_org == null){
			listSubEtapaPlazaQuery = (List<SubEtapaPlazaQuery>) this.getSessionContext().getAttribute("SubEtapaPlazaQueryList");
		}else if(srl_id_conv_area_org.equals("-1")){
			listSubEtapaPlazaQuery = new ArrayList<SubEtapaPlazaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_conv_area_org", srl_id_conv_area_org);
			listSubEtapaPlazaQuery = this.gestionarPlazaService.getListByQuery(SubEtapaPlazaQueryMapper.class, paramMap);
		}

		if(listSubEtapaPlazaQuery == null){
			listSubEtapaPlazaQuery = new ArrayList<SubEtapaPlazaQuery>();
		}
		this.getSessionContext(true).setAttribute("SubEtapaPlazaQueryList",listSubEtapaPlazaQuery);
		int size = listSubEtapaPlazaQuery.size();
		subListSubEtapaPlazaQuery = this.getSubList(listSubEtapaPlazaQuery, start, limit);
		
		this.success(subListSubEtapaPlazaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaPlazaQueryAdd(){
		
		List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery = (List<SubEtapaPlazaQuery>) this.getSessionContext().getAttribute("SubEtapaPlazaQueryList");
		int randomInt = this.getNegativeIdRandom();
		subEtapaPlazaQuery.setSrl_id_conv_area_org_etapa(randomInt);
		listSubEtapaPlazaQuery.add(subEtapaPlazaQuery);	
		this.getSessionContext().setAttribute("SubEtapaPlazaQueryList",listSubEtapaPlazaQuery);
		this.success(subEtapaPlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaPlazaQueryUpdate(){
		
		List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery = (List<SubEtapaPlazaQuery>) this.getSessionContext().getAttribute("SubEtapaPlazaQueryList");
		int index = -1;
		
		for (int i = 0; i < listSubEtapaPlazaQuery.size(); i++) {
			if(listSubEtapaPlazaQuery.get(i).getSrl_id_conv_area_org_etapa().equals(subEtapaPlazaQuery.getSrl_id_conv_area_org_etapa())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listSubEtapaPlazaQuery.set(index, subEtapaPlazaQuery);
		}
		
		this.getSessionContext().setAttribute("SubEtapaPlazaQueryList",listSubEtapaPlazaQuery);
		this.success(subEtapaPlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaPlazaQueryDelete(){
		
		List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery = (List<SubEtapaPlazaQuery>) this.getSessionContext().getAttribute("SubEtapaPlazaQueryList");
		int index = -1;
		for (int i = 0; i < listSubEtapaPlazaQuery.size(); i++) {
			if(listSubEtapaPlazaQuery.get(i).getSrl_id_conv_area_org_etapa().equals(subEtapaPlazaQuery.getSrl_id_conv_area_org_etapa())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listSubEtapaPlazaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("SubEtapaPlazaQueryList",listSubEtapaPlazaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String PostulantePlazaQueryList(){
		
		List<PostulantePlazaQuery> listPostulantePlazaQuery;
		List<PostulantePlazaQuery> subListPostulantePlazaQuery;
		Integer srl_id_conv_area_org = this.getIntegerParameter("srl_id_conv_area_org");
		System.out.println("srl_id_conv_area_org --> " + srl_id_conv_area_org);
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_conv_area_org == null){
			listPostulantePlazaQuery = (List<PostulantePlazaQuery>) this.getSessionContext().getAttribute("PostulantePlazaQueryList");
			if(!listPostulantePlazaQuery.isEmpty()){
				Map<String, Object> paramMap = this.getParamMap();
				paramMap.put("srl_id_conv_area_org", listPostulantePlazaQuery.get(0).getSrl_id_conv_area_org());
				listPostulantePlazaQuery = this.gestionarPlazaService.getListByQuery(PostulantePlazaQueryMapper.class, paramMap);
			}
			
		}else if(srl_id_conv_area_org.equals("-1")){
			listPostulantePlazaQuery = new ArrayList<PostulantePlazaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_conv_area_org", srl_id_conv_area_org);
			listPostulantePlazaQuery = this.gestionarPlazaService.getListByQuery(PostulantePlazaQueryMapper.class, paramMap);
		}

		if(listPostulantePlazaQuery == null){
			listPostulantePlazaQuery = new ArrayList<PostulantePlazaQuery>();
		}
		

		
		this.getSessionContext(true).setAttribute("PostulantePlazaQueryList",listPostulantePlazaQuery);
		int size = listPostulantePlazaQuery.size();
		subListPostulantePlazaQuery = this.getSubList(listPostulantePlazaQuery, start, limit);
		
		this.success(subListPostulantePlazaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulantePlazaQueryAdd(){
		
		List<PostulantePlazaQuery> listPostulantePlazaQuery = (List<PostulantePlazaQuery>) this.getSessionContext().getAttribute("PostulantePlazaQueryList");
		int randomInt = this.getNegativeIdRandom();
		postulantePlazaQuery.setSrl_id_postulante_conv_area_org(randomInt);
		listPostulantePlazaQuery.add(postulantePlazaQuery);	
		this.getSessionContext().setAttribute("PostulantePlazaQueryList",listPostulantePlazaQuery);
		this.success(postulantePlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulantePlazaQueryUpdate(){
		
		List<PostulantePlazaQuery> listPostulantePlazaQuery = (List<PostulantePlazaQuery>) this.getSessionContext().getAttribute("PostulantePlazaQueryList");
		int index = -1;
		
		for (int i = 0; i < listPostulantePlazaQuery.size(); i++) {
			if(listPostulantePlazaQuery.get(i).getSrl_id_postulante_conv_area_org().equals(postulantePlazaQuery.getSrl_id_postulante_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPostulantePlazaQuery.set(index, postulantePlazaQuery);
		}
		
		this.getSessionContext().setAttribute("PostulantePlazaQueryList",listPostulantePlazaQuery);
		this.success(postulantePlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulantePlazaQueryDelete(){
		
		List<PostulantePlazaQuery> listPostulantePlazaQuery = (List<PostulantePlazaQuery>) this.getSessionContext().getAttribute("PostulantePlazaQueryList");
		int index = -1;
		for (int i = 0; i < listPostulantePlazaQuery.size(); i++) {
			if(listPostulantePlazaQuery.get(i).getSrl_id_postulante_conv_area_org().equals(postulantePlazaQuery.getSrl_id_postulante_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPostulantePlazaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("PostulantePlazaQueryList",listPostulantePlazaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String ArchivoPlazaQueryList(){
		
		List<ArchivoPlazaQuery> listArchivoPlazaQuery;
		List<ArchivoPlazaQuery> subListArchivoPlazaQuery;
		Integer srl_id_conv_area_org = this.getIntegerParameter("srl_id_conv_area_org");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_conv_area_org == null){
			listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
		}else if(srl_id_conv_area_org.equals("-1")){
			listArchivoPlazaQuery = new ArrayList<ArchivoPlazaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_conv_area_org", srl_id_conv_area_org);
			listArchivoPlazaQuery = this.gestionarPlazaService.getListByQuery(ArchivoPlazaQueryMapper.class, paramMap);
		}

		if(listArchivoPlazaQuery == null){
			listArchivoPlazaQuery = new ArrayList<ArchivoPlazaQuery>();
		}
		this.getSessionContext(true).setAttribute("ArchivoPlazaQueryList",listArchivoPlazaQuery);
		int size = listArchivoPlazaQuery.size();
		subListArchivoPlazaQuery = this.getSubList(listArchivoPlazaQuery, start, limit);
		
		this.success(subListArchivoPlazaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoPlazaQueryAdd(){
		
		List<ArchivoPlazaQuery> listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
		FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(archivoPlazaQuery.getFile_name_session());
		
		int randomInt = this.getNegativeIdRandom();
		archivoPlazaQuery.setSrl_id_archivo(randomInt);
		archivoPlazaQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
		archivoPlazaQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
		archivoPlazaQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
		listArchivoPlazaQuery.add(archivoPlazaQuery);	
		this.getSessionContext().setAttribute("ArchivoPlazaQueryList",listArchivoPlazaQuery);
		this.success(archivoPlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoPlazaQueryUpdate(){
		
		List<ArchivoPlazaQuery> listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
		int index = -1;
		
		for (int i = 0; i < listArchivoPlazaQuery.size(); i++) {
			if(listArchivoPlazaQuery.get(i).getSrl_id_archivo().equals(archivoPlazaQuery.getSrl_id_archivo())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(archivoPlazaQuery.getFile_name_session());
			if(fileCommonBean != null){
				archivoPlazaQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
				archivoPlazaQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
				archivoPlazaQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
			}
			listArchivoPlazaQuery.set(index, archivoPlazaQuery);
		}
		
		this.getSessionContext().setAttribute("ArchivoPlazaQueryList",listArchivoPlazaQuery);
		this.success(archivoPlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoPlazaQueryDelete(){
		
		List<ArchivoPlazaQuery> listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
		int index = -1;
		for (int i = 0; i < listArchivoPlazaQuery.size(); i++) {
			if(listArchivoPlazaQuery.get(i).getSrl_id_archivo().equals(archivoPlazaQuery.getSrl_id_archivo())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listArchivoPlazaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ArchivoPlazaQueryList",listArchivoPlazaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String downaloadFile() throws FileNotFoundException{
		
		Integer srl_id_archivo = this.getIntegerParameter("srl_id_archivo");
		
		List<ArchivoPlazaQuery> listArchivoPlazaQuery = (List<ArchivoPlazaQuery>) this.getSessionContext().getAttribute("ArchivoPlazaQueryList");
		int index = -1;
		
		for (int i = 0; i < listArchivoPlazaQuery.size(); i++) {
			if(listArchivoPlazaQuery.get(i).getSrl_id_archivo().equals(srl_id_archivo)){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			archivoPlazaQuery = listArchivoPlazaQuery.get(index);
			contentType = archivoPlazaQuery.getVar_tipo_archivo();
			File fileToDownload = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);

		}
				
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarPlazaService getGestionarPlazaService() {
		return gestionarPlazaService;
	}

	public void setGestionarPlazaService(GestionarPlazaService gestionarPlazaService) {
		this.gestionarPlazaService = gestionarPlazaService;
	}
	
	public GestionarPlazaQuery getGestionarPlazaQuery() {
		return gestionarPlazaQuery;
	}

	public void setGestionarPlazaQuery(GestionarPlazaQuery gestionarPlazaQuery) {
		this.gestionarPlazaQuery = gestionarPlazaQuery;
	}
	public SubEtapaPlazaQuery getSubEtapaPlazaQuery() {
		return subEtapaPlazaQuery;
	}

	public void setSubEtapaPlazaQuery(SubEtapaPlazaQuery subEtapaPlazaQuery) {
		this.subEtapaPlazaQuery = subEtapaPlazaQuery;
	}
	public PostulantePlazaQuery getPostulantePlazaQuery() {
		return postulantePlazaQuery;
	}

	public void setPostulantePlazaQuery(PostulantePlazaQuery postulantePlazaQuery) {
		this.postulantePlazaQuery = postulantePlazaQuery;
	}
	public ArchivoPlazaQuery getArchivoPlazaQuery() {
		return archivoPlazaQuery;
	}

	public void setArchivoPlazaQuery(ArchivoPlazaQuery archivoPlazaQuery) {
		this.archivoPlazaQuery = archivoPlazaQuery;
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

/*
<!-- Start Actions GestionarPlaza -->
<action name="GestionarPlazaView" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarPlazaCreate" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarPlazaSave" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarPlazaRemove" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model SubEtapaPlazaQuery Actions -->
<action name="SubEtapaPlazaQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="SubEtapaPlazaQueryList">
		<result type="json" />
</action>

<action name="SubEtapaPlazaQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="SubEtapaPlazaQueryAdd">
		<result type="json" />
</action>

<action name="SubEtapaPlazaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="SubEtapaPlazaQueryUpdate">
		<result type="json" />
</action>

<action name="SubEtapaPlazaQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="SubEtapaPlazaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model SubEtapaPlazaQuery Actions -->
<!-- Start Sub Model PostulantePlazaQuery Actions -->
<action name="PostulantePlazaQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="PostulantePlazaQueryList">
		<result type="json" />
</action>

<action name="PostulantePlazaQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="PostulantePlazaQueryAdd">
		<result type="json" />
</action>

<action name="PostulantePlazaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="PostulantePlazaQueryUpdate">
		<result type="json" />
</action>

<action name="PostulantePlazaQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="PostulantePlazaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model PostulantePlazaQuery Actions -->
<!-- Start Sub Model ArchivoPlazaQuery Actions -->
<action name="ArchivoPlazaQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="ArchivoPlazaQueryList">
		<result type="json" />
</action>

<action name="ArchivoPlazaQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="ArchivoPlazaQueryAdd">
		<result type="json" />
</action>

<action name="ArchivoPlazaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="ArchivoPlazaQueryUpdate">
		<result type="json" />
</action>

<action name="ArchivoPlazaQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarPlazaAction" method="ArchivoPlazaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ArchivoPlazaQuery Actions -->

<!-- End Actions GestionarPlaza -->
*/
}
