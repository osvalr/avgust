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
* DATE CREATE : 15/04/2015 00:11:39
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

import sernanp.app.business.core.seleccion.service.GestionarPostulanteService;
import sernanp.app.dao.query.domain.ArchivoPostulanteQuery;
import sernanp.app.dao.query.domain.GestionarPersonaNaturalQuery;
import sernanp.app.dao.query.domain.GestionarPersonaNaturalQueryCriteria;
import sernanp.app.dao.query.domain.PostulacionPersonaQuery;
import sernanp.app.dao.query.domain.PostulanteNumeroTelefonoQuery;
import sernanp.app.dao.query.mapper.ArchivoPostulanteQueryMapper;
import sernanp.app.dao.query.mapper.GestionarPersonaNaturalQueryMapper;
import sernanp.app.dao.query.mapper.PostulacionPersonaQueryMapper;
import sernanp.app.dao.query.mapper.PostulanteNumeroTelefonoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.rrhh.web.bean.FileCommonBean;

public class GestionarPostulanteAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;
	
	private InputStream fileInputStream;
    private String fileName;
    private String contentType;

	@Autowired
	private GestionarPostulanteService gestionarPostulanteService;
	private GestionarPersonaNaturalQuery gestionarPersonaNaturalQuery;
	private PostulanteNumeroTelefonoQuery postulanteNumeroTelefonoQuery;
	private ArchivoPostulanteQuery archivoPostulanteQuery;
	private PostulacionPersonaQuery postulacionPersonaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarPersonaNaturalQueryCriteria gestionarPersonaNaturalQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarPersonaNaturalQueryCriteria.class);
			
			List<GestionarPersonaNaturalQuery> listGestionarPersonaNaturalQuery = gestionarPostulanteService.getListByQuery(GestionarPersonaNaturalQueryMapper.class, gestionarPersonaNaturalQueryCriteria, start, limit);
			int total = gestionarPostulanteService.getCountRowsByQuery(GestionarPersonaNaturalQueryMapper.class, gestionarPersonaNaturalQueryCriteria);
			
			this.success(listGestionarPersonaNaturalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create() throws FileNotFoundException, IOException{
		
		try{
			List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery = (List<PostulanteNumeroTelefonoQuery>) this.getSessionContext().getAttribute("PostulanteNumeroTelefonoQueryList");
			List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
			List<PostulacionPersonaQuery> listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
			String path_files_postulantes = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.postulantes");
			gestionarPersonaNaturalQuery.setPath_files_postulantes(path_files_postulantes);
			Integer lastId = gestionarPostulanteService.create(gestionarPersonaNaturalQuery,listPostulanteNumeroTelefonoQuery, listArchivoPostulanteQuery, listPostulacionPersonaQuery);
			
			gestionarPersonaNaturalQuery.setIdpersonanatural(lastId);
			
			this.getSessionContext().setAttribute("PostulanteNumeroTelefonoQueryList",null);
			this.getSessionContext().setAttribute("ArchivoPostulanteQueryList",null);
			this.getSessionContext().setAttribute("PostulacionPersonaQueryList",null);
			this.success(gestionarPersonaNaturalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save() throws FileNotFoundException, IOException{
		
		try{
			List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery = (List<PostulanteNumeroTelefonoQuery>) this.getSessionContext().getAttribute("PostulanteNumeroTelefonoQueryList");
			List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
			List<PostulacionPersonaQuery> listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
			String path_files_postulantes = PropUtil.getInstance().getPropVal("documents.properties", "ruta.files.postulantes");
			gestionarPersonaNaturalQuery.setPath_files_postulantes(path_files_postulantes);
			gestionarPostulanteService.save(gestionarPersonaNaturalQuery,listPostulanteNumeroTelefonoQuery, listArchivoPostulanteQuery, listPostulacionPersonaQuery);
			this.getSessionContext().setAttribute("PostulanteNumeroTelefonoQueryList",null);
			this.getSessionContext().setAttribute("ArchivoPostulanteQueryList",null);
			this.getSessionContext().setAttribute("PostulacionPersonaQueryList",null);
			this.success(gestionarPersonaNaturalQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove() throws FileNotFoundException, IOException{
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("int_id_postulante", gestionarPersonaNaturalQuery.getInt_id_postulante());
			List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery = this.gestionarPostulanteService.getListByQuery(PostulanteNumeroTelefonoQueryMapper.class, paramMap);
			paramMap.put("int_id_postulante", gestionarPersonaNaturalQuery.getInt_id_postulante());
			List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = this.gestionarPostulanteService.getListByQuery(ArchivoPostulanteQueryMapper.class, paramMap);
			paramMap.put("int_id_postulante", gestionarPersonaNaturalQuery.getInt_id_postulante());
			List<PostulacionPersonaQuery> listPostulacionPersonaQuery = this.gestionarPostulanteService.getListByQuery(PostulacionPersonaQueryMapper.class, paramMap);
			gestionarPostulanteService.remove(gestionarPersonaNaturalQuery,listPostulanteNumeroTelefonoQuery, listArchivoPostulanteQuery, listPostulacionPersonaQuery);
			this.getSessionContext().removeAttribute("PostulanteNumeroTelefonoQueryList");
			this.getSessionContext().removeAttribute("ArchivoPostulanteQueryList");
			this.getSessionContext().removeAttribute("PostulacionPersonaQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulanteNumeroTelefonoQueryList(){
		
		List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery;
		List<PostulanteNumeroTelefonoQuery> subListPostulanteNumeroTelefonoQuery;
		Integer int_id_postulante = this.getIntegerParameter("int_id_postulante");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(int_id_postulante == null){
			listPostulanteNumeroTelefonoQuery = (List<PostulanteNumeroTelefonoQuery>) this.getSessionContext().getAttribute("PostulanteNumeroTelefonoQueryList");
		}else if(int_id_postulante.equals("-1")){
			listPostulanteNumeroTelefonoQuery = new ArrayList<PostulanteNumeroTelefonoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("int_id_postulante", int_id_postulante);
			listPostulanteNumeroTelefonoQuery = this.gestionarPostulanteService.getListByQuery(PostulanteNumeroTelefonoQueryMapper.class, paramMap);
		}

		if(listPostulanteNumeroTelefonoQuery == null){
			listPostulanteNumeroTelefonoQuery = new ArrayList<PostulanteNumeroTelefonoQuery>();
		}
		this.getSessionContext(true).setAttribute("PostulanteNumeroTelefonoQueryList",listPostulanteNumeroTelefonoQuery);
		int size = listPostulanteNumeroTelefonoQuery.size();
		subListPostulanteNumeroTelefonoQuery = this.getSubList(listPostulanteNumeroTelefonoQuery, start, limit);
		
		this.success(subListPostulanteNumeroTelefonoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulanteNumeroTelefonoQueryAdd(){
		
		List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery = (List<PostulanteNumeroTelefonoQuery>) this.getSessionContext().getAttribute("PostulanteNumeroTelefonoQueryList");
		int randomInt = this.getNegativeIdRandom();
		postulanteNumeroTelefonoQuery.setSrl_id_numero_telefono(randomInt);
		listPostulanteNumeroTelefonoQuery.add(postulanteNumeroTelefonoQuery);	
		this.getSessionContext().setAttribute("PostulanteNumeroTelefonoQueryList",listPostulanteNumeroTelefonoQuery);
		this.success(postulanteNumeroTelefonoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulanteNumeroTelefonoQueryUpdate(){
		
		List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery = (List<PostulanteNumeroTelefonoQuery>) this.getSessionContext().getAttribute("PostulanteNumeroTelefonoQueryList");
		int index = -1;
		
		for (int i = 0; i < listPostulanteNumeroTelefonoQuery.size(); i++) {
			if(listPostulanteNumeroTelefonoQuery.get(i).getSrl_id_numero_telefono().equals(postulanteNumeroTelefonoQuery.getSrl_id_numero_telefono())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPostulanteNumeroTelefonoQuery.set(index, postulanteNumeroTelefonoQuery);
		}
		
		this.getSessionContext().setAttribute("PostulanteNumeroTelefonoQueryList",listPostulanteNumeroTelefonoQuery);
		this.success(postulanteNumeroTelefonoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulanteNumeroTelefonoQueryDelete(){
		
		List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery = (List<PostulanteNumeroTelefonoQuery>) this.getSessionContext().getAttribute("PostulanteNumeroTelefonoQueryList");
		int index = -1;
		for (int i = 0; i < listPostulanteNumeroTelefonoQuery.size(); i++) {
			if(listPostulanteNumeroTelefonoQuery.get(i).getSrl_id_numero_telefono().equals(postulanteNumeroTelefonoQuery.getSrl_id_numero_telefono())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPostulanteNumeroTelefonoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("PostulanteNumeroTelefonoQueryList",listPostulanteNumeroTelefonoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String ArchivoPostulanteQueryList(){
		
		List<ArchivoPostulanteQuery> listArchivoPostulanteQuery;
		List<ArchivoPostulanteQuery> subListArchivoPostulanteQuery;
		Integer int_id_postulante = this.getIntegerParameter("int_id_postulante");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(int_id_postulante == null){
			listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
		}else if(int_id_postulante.equals("-1")){
			listArchivoPostulanteQuery = new ArrayList<ArchivoPostulanteQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("int_id_postulante", int_id_postulante);
			listArchivoPostulanteQuery = this.gestionarPostulanteService.getListByQuery(ArchivoPostulanteQueryMapper.class, paramMap);
		}

		if(listArchivoPostulanteQuery == null){
			listArchivoPostulanteQuery = new ArrayList<ArchivoPostulanteQuery>();
		}
		this.getSessionContext(true).setAttribute("ArchivoPostulanteQueryList",listArchivoPostulanteQuery);
		int size = listArchivoPostulanteQuery.size();
		subListArchivoPostulanteQuery = this.getSubList(listArchivoPostulanteQuery, start, limit);
		
		this.success(subListArchivoPostulanteQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoPostulanteQueryAdd(){
		
		List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
		FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(archivoPostulanteQuery.getFile_name_session());
		
		int randomInt = this.getNegativeIdRandom();
		archivoPostulanteQuery.setSrl_id_archivo(randomInt);
		archivoPostulanteQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
		archivoPostulanteQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
		archivoPostulanteQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
		listArchivoPostulanteQuery.add(archivoPostulanteQuery);	
		this.getSessionContext().setAttribute("ArchivoPostulanteQueryList",listArchivoPostulanteQuery);
		this.getSessionContext().setAttribute(archivoPostulanteQuery.getFile_name_session(),null);
		this.success(archivoPostulanteQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoPostulanteQueryUpdate(){
		
		List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
		int index = -1;
		
		for (int i = 0; i < listArchivoPostulanteQuery.size(); i++) {
			if(listArchivoPostulanteQuery.get(i).getSrl_id_archivo().equals(archivoPostulanteQuery.getSrl_id_archivo())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(archivoPostulanteQuery.getFile_name_session());
			if(fileCommonBean != null){
				archivoPostulanteQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
				archivoPostulanteQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
				archivoPostulanteQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
			}
			listArchivoPostulanteQuery.set(index, archivoPostulanteQuery);
		}
		
		this.getSessionContext().setAttribute("ArchivoPostulanteQueryList",listArchivoPostulanteQuery);
		this.getSessionContext().setAttribute(archivoPostulanteQuery.getFile_name_session(),null);
		this.success(archivoPostulanteQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ArchivoPostulanteQueryDelete(){
		
		List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
		int index = -1;
		for (int i = 0; i < listArchivoPostulanteQuery.size(); i++) {
			if(listArchivoPostulanteQuery.get(i).getSrl_id_archivo().equals(archivoPostulanteQuery.getSrl_id_archivo())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listArchivoPostulanteQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ArchivoPostulanteQueryList",listArchivoPostulanteQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String PostulacionPersonaQueryList(){
		
		List<PostulacionPersonaQuery> listPostulacionPersonaQuery;
		List<PostulacionPersonaQuery> subListPostulacionPersonaQuery;
		Integer int_id_postulante = this.getIntegerParameter("int_id_postulante");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(int_id_postulante == null){
			listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
		}else if(int_id_postulante.equals("-1")){
			listPostulacionPersonaQuery = new ArrayList<PostulacionPersonaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("int_id_postulante", int_id_postulante);
			listPostulacionPersonaQuery = this.gestionarPostulanteService.getListByQuery(PostulacionPersonaQueryMapper.class, paramMap);
		}

		if(listPostulacionPersonaQuery == null){
			listPostulacionPersonaQuery = new ArrayList<PostulacionPersonaQuery>();
		}
		this.getSessionContext(true).setAttribute("PostulacionPersonaQueryList",listPostulacionPersonaQuery);
		int size = listPostulacionPersonaQuery.size();
		subListPostulacionPersonaQuery = this.getSubList(listPostulacionPersonaQuery, start, limit);
		
		this.success(subListPostulacionPersonaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulacionPersonaQueryAdd(){
		
		List<PostulacionPersonaQuery> listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
		FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(postulacionPersonaQuery.getFile_name_session());

		
		int randomInt = this.getNegativeIdRandom();
		postulacionPersonaQuery.setSrl_id_postulante_conv_area_org(randomInt);
		postulacionPersonaQuery.setSrl_id_archivo(randomInt);
		postulacionPersonaQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
		postulacionPersonaQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
		postulacionPersonaQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
		
		boolean error = false;
		
//		for (PostulacionPersonaQuery obj : listPostulacionPersonaQuery) {
//			
//			if(postulacionPersonaQuery.getSrl_id_postulante_conv_area_org().equals(obj.getSrl_id_postulante_conv_area_org())){
//				this.exception("Error, Ya registraste la plaza seleccionada.");
//				error = true;
//			}else if(postulacionPersonaQuery.getSrl_id_convocatoria().equals(obj.getSrl_id_convocatoria())){
//				this.exception("Error, No se permite postular a otra plaza de una misma convocatoria.");
//				error = true;
//			}
//			
//		}
		
		if(!error){
			listPostulacionPersonaQuery.add(postulacionPersonaQuery);	
			this.getSessionContext().setAttribute("PostulacionPersonaQueryList",listPostulacionPersonaQuery);
			this.success(postulacionPersonaQuery, "Operation Success.");
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulacionPersonaQueryUpdate(){
		
		List<PostulacionPersonaQuery> listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
		int index = -1;
		
		for (int i = 0; i < listPostulacionPersonaQuery.size(); i++) {
			if(listPostulacionPersonaQuery.get(i).getSrl_id_postulante_conv_area_org().equals(postulacionPersonaQuery.getSrl_id_postulante_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			FileCommonBean fileCommonBean = (FileCommonBean) this.getSessionContext().getAttribute(postulacionPersonaQuery.getFile_name_session());
			if(fileCommonBean != null){
				postulacionPersonaQuery.setVar_archivo_ruta_almacen(fileCommonBean.getPathFile());
				postulacionPersonaQuery.setVar_nombre_archivo(fileCommonBean.getFileName());
				postulacionPersonaQuery.setVar_tipo_archivo(fileCommonBean.getFileContentType());
			}
			
			listPostulacionPersonaQuery.set(index, postulacionPersonaQuery);
		}
		
		this.getSessionContext().setAttribute("PostulacionPersonaQueryList",listPostulacionPersonaQuery);
		this.success(postulacionPersonaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PostulacionPersonaQueryDelete(){
		
		List<PostulacionPersonaQuery> listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
		int index = -1;
		for (int i = 0; i < listPostulacionPersonaQuery.size(); i++) {
			if(listPostulacionPersonaQuery.get(i).getSrl_id_postulante_conv_area_org().equals(postulacionPersonaQuery.getSrl_id_postulante_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPostulacionPersonaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("PostulacionPersonaQueryList",listPostulacionPersonaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String downaloadFile() throws FileNotFoundException{
		
		Integer srl_id_archivo = this.getIntegerParameter("srl_id_archivo");
		
		List<ArchivoPostulanteQuery> listArchivoPostulanteQuery = (List<ArchivoPostulanteQuery>) this.getSessionContext().getAttribute("ArchivoPostulanteQueryList");
		int index = -1;
		
		for (int i = 0; i < listArchivoPostulanteQuery.size(); i++) {
			if(listArchivoPostulanteQuery.get(i).getSrl_id_archivo().equals(srl_id_archivo)){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			archivoPostulanteQuery = listArchivoPostulanteQuery.get(index);
			contentType = archivoPostulanteQuery.getVar_tipo_archivo();
			File fileToDownload = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);

		}
				
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String downaloadFilePostulacion() throws FileNotFoundException{
		
		Integer srl_id_archivo = this.getIntegerParameter("srl_id_archivo");
		
		List<PostulacionPersonaQuery> listPostulacionPersonaQuery = (List<PostulacionPersonaQuery>) this.getSessionContext().getAttribute("PostulacionPersonaQueryList");
		int index = -1;
		
		for (int i = 0; i < listPostulacionPersonaQuery.size(); i++) {
			if(listPostulacionPersonaQuery.get(i).getSrl_id_archivo().equals(srl_id_archivo)){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			
			postulacionPersonaQuery = listPostulacionPersonaQuery.get(index);
			contentType = postulacionPersonaQuery.getVar_tipo_archivo();
			File fileToDownload = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);

		}
				
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarPostulanteService getGestionarPostulanteService() {
		return gestionarPostulanteService;
	}

	public void setGestionarPostulanteService(GestionarPostulanteService gestionarPostulanteService) {
		this.gestionarPostulanteService = gestionarPostulanteService;
	}
	
	public GestionarPersonaNaturalQuery getGestionarPersonaNaturalQuery() {
		return gestionarPersonaNaturalQuery;
	}

	public void setGestionarPersonaNaturalQuery(GestionarPersonaNaturalQuery gestionarPersonaNaturalQuery) {
		this.gestionarPersonaNaturalQuery = gestionarPersonaNaturalQuery;
	}
	public PostulanteNumeroTelefonoQuery getPostulanteNumeroTelefonoQuery() {
		return postulanteNumeroTelefonoQuery;
	}

	public void setPostulanteNumeroTelefonoQuery(PostulanteNumeroTelefonoQuery postulanteNumeroTelefonoQuery) {
		this.postulanteNumeroTelefonoQuery = postulanteNumeroTelefonoQuery;
	}
	public ArchivoPostulanteQuery getArchivoPostulanteQuery() {
		return archivoPostulanteQuery;
	}

	public void setArchivoPostulanteQuery(ArchivoPostulanteQuery archivoPostulanteQuery) {
		this.archivoPostulanteQuery = archivoPostulanteQuery;
	}
	public PostulacionPersonaQuery getPostulacionPersonaQuery() {
		return postulacionPersonaQuery;
	}

	public void setPostulacionPersonaQuery(PostulacionPersonaQuery postulacionPersonaQuery) {
		this.postulacionPersonaQuery = postulacionPersonaQuery;
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
<!-- Start Actions GestionarPostulante -->
<action name="GestionarPostulanteView" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="view">
		<result type="json" />
</action>

<action name="GestionarPostulanteCreate" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="create">
		<result type="json" />
</action>

<action name="GestionarPostulanteSave" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="save">
		<result type="json" />
</action>

<action name="GestionarPostulanteRemove" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model PostulanteNumeroTelefonoQuery Actions -->
<action name="PostulanteNumeroTelefonoQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulanteNumeroTelefonoQueryList">
		<result type="json" />
</action>

<action name="PostulanteNumeroTelefonoQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulanteNumeroTelefonoQueryAdd">
		<result type="json" />
</action>

<action name="PostulanteNumeroTelefonoQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulanteNumeroTelefonoQueryUpdate">
		<result type="json" />
</action>

<action name="PostulanteNumeroTelefonoQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulanteNumeroTelefonoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model PostulanteNumeroTelefonoQuery Actions -->
<!-- Start Sub Model ArchivoPostulanteQuery Actions -->
<action name="ArchivoPostulanteQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="ArchivoPostulanteQueryList">
		<result type="json" />
</action>

<action name="ArchivoPostulanteQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="ArchivoPostulanteQueryAdd">
		<result type="json" />
</action>

<action name="ArchivoPostulanteQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="ArchivoPostulanteQueryUpdate">
		<result type="json" />
</action>

<action name="ArchivoPostulanteQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="ArchivoPostulanteQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ArchivoPostulanteQuery Actions -->
<!-- Start Sub Model PostulacionPersonaQuery Actions -->
<action name="PostulacionPersonaQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulacionPersonaQueryList">
		<result type="json" />
</action>

<action name="PostulacionPersonaQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulacionPersonaQueryAdd">
		<result type="json" />
</action>

<action name="PostulacionPersonaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulacionPersonaQueryUpdate">
		<result type="json" />
</action>

<action name="PostulacionPersonaQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarPostulanteAction" method="PostulacionPersonaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model PostulacionPersonaQuery Actions -->

<!-- End Actions GestionarPostulante -->
*/
}
