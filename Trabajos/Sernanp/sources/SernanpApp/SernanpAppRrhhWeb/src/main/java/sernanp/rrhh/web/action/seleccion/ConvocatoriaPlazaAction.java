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
* DATE CREATE : 23/04/2015 16:49:26
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sernanp.app.business.core.seleccion.service.ConvocatoriaPlazaService;
import sernanp.app.dao.query.domain.ConvocatoriaEtapaQuery;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaFactorQuery;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaQuery;
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQuery;
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraObtenerFactorQuery;
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraObtenerFactorQueryCriteria;
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraQuery;
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraQueryCriteria;
import sernanp.app.dao.query.domain.ReporteSelectEtapasSeleccionQuery;
import sernanp.app.dao.query.domain.ReporteSelectEtapasSeleccionQueryCriteria;
import sernanp.app.dao.query.domain.ReporteVacantesPublicasQueryCriteria;
import sernanp.app.dao.query.mapper.ConvocatoriaEtapaQueryMapper;
import sernanp.app.dao.query.mapper.ConvocatoriaPlazaFactorQueryMapper;
import sernanp.app.dao.query.mapper.ConvocatoriaPlazaQueryMapper;
import sernanp.app.dao.query.mapper.GestionarConvocatoriaPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ReporteConvocatoriaMintraObtenerFactorQueryMapper;
import sernanp.app.dao.query.mapper.ReporteConvocatoriaMintraQueryMapper;
import sernanp.app.dao.query.mapper.ReporteSelectEtapasSeleccionQueryMapper;
import sernanp.app.dao.query.mapper.ReporteVacantesPublicasQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.NumeroLiteralUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.action.GeneradorReportesJasper;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ConvocatoriaPlazaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ConvocatoriaPlazaService convocatoriaPlazaService;
	private GestionarConvocatoriaPersonalQuery gestionarConvocatoriaPersonalQuery;
	private ConvocatoriaPlazaQuery convocatoriaPlazaQuery;
	private ConvocatoriaEtapaQuery convocatoriaEtapaQuery;
	private ConvocatoriaPlazaFactorQuery convocatoriaPlazaFactorQuery;
	
	private GeneradorReportesJasper generadorReportesJasper;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	@SuppressWarnings("rawtypes")
	private Map parametros;

	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarConvocatoriaPersonalQueryCriteria gestionarConvocatoriaPersonalQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarConvocatoriaPersonalQueryCriteria.class);
			List<GestionarConvocatoriaPersonalQuery> listGestionarConvocatoriaPersonalQuery = convocatoriaPlazaService.getListByQuery(GestionarConvocatoriaPersonalQueryMapper.class, gestionarConvocatoriaPersonalQueryCriteria, start, limit);
			
			int total = convocatoriaPlazaService.getCountRowsByQuery(GestionarConvocatoriaPersonalQueryMapper.class, gestionarConvocatoriaPersonalQueryCriteria);
			
			this.success(listGestionarConvocatoriaPersonalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		System.out.println("Agregando Convocatoria ...");
		try{
			List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery = (List<ConvocatoriaPlazaQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaQueryList");
			List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery = (List<ConvocatoriaEtapaQuery>) this.getSessionContext().getAttribute("ConvocatoriaEtapaQueryList");
			List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery = (List<ConvocatoriaPlazaFactorQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaFactorQueryList");
			convocatoriaPlazaService.create(gestionarConvocatoriaPersonalQuery,listConvocatoriaPlazaQuery, listConvocatoriaEtapaQuery, listConvocatoriaPlazaFactorQuery);
			this.getSessionContext().setAttribute("ConvocatoriaPlazaQueryList",null);
			this.getSessionContext().setAttribute("ConvocatoriaEtapaQueryList",null);
			this.getSessionContext().setAttribute("ConvocatoriaPlazaFactorQueryList",null);
			this.success(gestionarConvocatoriaPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			System.out.println("Save Convocatoria");
			List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery = (List<ConvocatoriaPlazaQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaQueryList");
			List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery = (List<ConvocatoriaEtapaQuery>) this.getSessionContext().getAttribute("ConvocatoriaEtapaQueryList");
			List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery = (List<ConvocatoriaPlazaFactorQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaFactorQueryList");
			convocatoriaPlazaService.save(gestionarConvocatoriaPersonalQuery,listConvocatoriaPlazaQuery, listConvocatoriaEtapaQuery, listConvocatoriaPlazaFactorQuery);
			this.getSessionContext().setAttribute("ConvocatoriaPlazaQueryList",null);
			this.getSessionContext().setAttribute("ConvocatoriaEtapaQueryList",null);
			this.getSessionContext().setAttribute("ConvocatoriaPlazaFactorQueryList",null);
			this.success(gestionarConvocatoriaPersonalQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_convocatoria", gestionarConvocatoriaPersonalQuery.getSrl_id_convocatoria());
			List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery = this.convocatoriaPlazaService.getListByQuery(ConvocatoriaPlazaQueryMapper.class, paramMap);
			paramMap.put("srl_id_convocatoria", gestionarConvocatoriaPersonalQuery.getSrl_id_convocatoria());
			List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery = this.convocatoriaPlazaService.getListByQuery(ConvocatoriaEtapaQueryMapper.class, paramMap);
			paramMap.put("srl_id_configuracion_factor_evaluacion", convocatoriaPlazaFactorQuery.getSrl_id_configuracion_factor_evaluacion());
			List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery = this.convocatoriaPlazaService.getListByQuery(ConvocatoriaPlazaFactorQueryMapper.class, paramMap);
			convocatoriaPlazaService.remove(gestionarConvocatoriaPersonalQuery,listConvocatoriaPlazaQuery, listConvocatoriaEtapaQuery, listConvocatoriaPlazaFactorQuery);
			this.getSessionContext().removeAttribute("ConvocatoriaPlazaQueryList");
			this.getSessionContext().removeAttribute("ConvocatoriaEtapaQueryList");
			this.getSessionContext().removeAttribute("ConvocatoriaPlazaFactorQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String relanzar(){
		
		try{
			
			int srl_id_convocatoria = this.getIntegerParameter("srl_id_convocatoria");
			convocatoriaPlazaService.relanzar(srl_id_convocatoria);
			this.extjsReturn.setSuccess(true);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaQueryList(){
		System.out.println("ConvocatoriaPlazaQueryList ...");
		List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery;
		List<ConvocatoriaPlazaQuery> subListConvocatoriaPlazaQuery;
		Integer srl_id_convocatoria = this.getIntegerParameter("srl_id_convocatoria");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_convocatoria == null){
			listConvocatoriaPlazaQuery = (List<ConvocatoriaPlazaQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaQueryList");
		}else if(srl_id_convocatoria.equals("-1")){
			listConvocatoriaPlazaQuery = new ArrayList<ConvocatoriaPlazaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_convocatoria", srl_id_convocatoria);
			listConvocatoriaPlazaQuery = this.convocatoriaPlazaService.getListByQuery(ConvocatoriaPlazaQueryMapper.class, paramMap);
		}

		if(listConvocatoriaPlazaQuery == null){
			listConvocatoriaPlazaQuery = new ArrayList<ConvocatoriaPlazaQuery>();
		}
		this.getSessionContext(true).setAttribute("ConvocatoriaPlazaQueryList",listConvocatoriaPlazaQuery);
		int size = listConvocatoriaPlazaQuery.size();
		subListConvocatoriaPlazaQuery = this.getSubList(listConvocatoriaPlazaQuery, start, limit);
		
		this.success(subListConvocatoriaPlazaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaQueryAdd(){
		
		List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery = (List<ConvocatoriaPlazaQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaQueryList");
		int randomInt = this.getNegativeIdRandom();
		convocatoriaPlazaQuery.setSrl_id_conv_area_org(randomInt);
		boolean error = false;
		
		for (ConvocatoriaPlazaQuery convocatoriaPlazaQuery2 : listConvocatoriaPlazaQuery) {
			
			if(convocatoriaPlazaQuery.getSrl_id_requerimiento_personal().equals(convocatoriaPlazaQuery2.getSrl_id_requerimiento_personal())){
				this.exception("Error, El requerimiento ya se encuentra registrado en otra Plaza.");
				error = true;
			}
		}
		
				
		if(!error){
			listConvocatoriaPlazaQuery.add(convocatoriaPlazaQuery);	
			this.getSessionContext().setAttribute("ConvocatoriaPlazaQueryList",listConvocatoriaPlazaQuery);
			this.success(convocatoriaPlazaQuery, "Operation Success.");
		}
				
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaQueryUpdate(){
		
		List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery = (List<ConvocatoriaPlazaQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaQueryList");
		int index = -1;
		
		for (int i = 0; i < listConvocatoriaPlazaQuery.size(); i++) {
			if(listConvocatoriaPlazaQuery.get(i).getSrl_id_conv_area_org().equals(convocatoriaPlazaQuery.getSrl_id_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConvocatoriaPlazaQuery.set(index, convocatoriaPlazaQuery);
		}
		
		this.getSessionContext().setAttribute("ConvocatoriaPlazaQueryList",listConvocatoriaPlazaQuery);
		this.success(convocatoriaPlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaQueryDelete(){
		
		List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery = (List<ConvocatoriaPlazaQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaQueryList");
		int index = -1;
		for (int i = 0; i < listConvocatoriaPlazaQuery.size(); i++) {
			if(listConvocatoriaPlazaQuery.get(i).getSrl_id_conv_area_org().equals(convocatoriaPlazaQuery.getSrl_id_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConvocatoriaPlazaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConvocatoriaPlazaQueryList",listConvocatoriaPlazaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String ConvocatoriaEtapaQueryList(){
		
		List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery;
		List<ConvocatoriaEtapaQuery> subListConvocatoriaEtapaQuery;
		Integer srl_id_convocatoria = this.getIntegerParameter("srl_id_convocatoria");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_convocatoria == null){
			listConvocatoriaEtapaQuery = (List<ConvocatoriaEtapaQuery>) this.getSessionContext().getAttribute("ConvocatoriaEtapaQueryList");
		}else if(srl_id_convocatoria.equals("-1")){
			listConvocatoriaEtapaQuery = new ArrayList<ConvocatoriaEtapaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_convocatoria", srl_id_convocatoria);
			listConvocatoriaEtapaQuery = this.convocatoriaPlazaService.getListByQuery(ConvocatoriaEtapaQueryMapper.class, paramMap);
		
			if(listConvocatoriaEtapaQuery.isEmpty()){
				listConvocatoriaEtapaQuery =  convocatoriaPlazaService.obtenerListaConfiguracionEtapas();
				
				for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
					
					Integer randomInt = this.getNegativeIdRandom();
					convocatoriaEtapaQuery.setSrl_id_conv_fecha_etapa_config(randomInt);
					
				}
                
			}
		
		}

		if(listConvocatoriaEtapaQuery == null){
			listConvocatoriaEtapaQuery = new ArrayList<ConvocatoriaEtapaQuery>();
		}
		this.getSessionContext(true).setAttribute("ConvocatoriaEtapaQueryList",listConvocatoriaEtapaQuery);
		int size = listConvocatoriaEtapaQuery.size();
		subListConvocatoriaEtapaQuery = this.getSubList(listConvocatoriaEtapaQuery, start, limit);
		
		this.success(subListConvocatoriaEtapaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaEtapaQueryAdd(){
		
		List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery = (List<ConvocatoriaEtapaQuery>) this.getSessionContext().getAttribute("ConvocatoriaEtapaQueryList");
		int randomInt = this.getNegativeIdRandom();
		convocatoriaEtapaQuery.setSrl_id_conv_fecha_etapa_config(randomInt);
		listConvocatoriaEtapaQuery.add(convocatoriaEtapaQuery);	
		this.getSessionContext().setAttribute("ConvocatoriaEtapaQueryList",listConvocatoriaEtapaQuery);
		this.success(convocatoriaEtapaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaEtapaQueryUpdate(){
		
		List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery = (List<ConvocatoriaEtapaQuery>) this.getSessionContext().getAttribute("ConvocatoriaEtapaQueryList");
		int index = -1;
		
		for (int i = 0; i < listConvocatoriaEtapaQuery.size(); i++) {
			if(listConvocatoriaEtapaQuery.get(i).getSrl_id_conv_fecha_etapa_config().equals(convocatoriaEtapaQuery.getSrl_id_conv_fecha_etapa_config())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConvocatoriaEtapaQuery.set(index, convocatoriaEtapaQuery);
		}
		
		this.getSessionContext().setAttribute("ConvocatoriaEtapaQueryList",listConvocatoriaEtapaQuery);
		this.success(convocatoriaEtapaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaEtapaQueryDelete(){
		
		List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery = (List<ConvocatoriaEtapaQuery>) this.getSessionContext().getAttribute("ConvocatoriaEtapaQueryList");
		int index = -1;
		for (int i = 0; i < listConvocatoriaEtapaQuery.size(); i++) {
			if(listConvocatoriaEtapaQuery.get(i).getSrl_id_conv_fecha_etapa_config().equals(convocatoriaEtapaQuery.getSrl_id_conv_fecha_etapa_config())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConvocatoriaEtapaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConvocatoriaEtapaQueryList",listConvocatoriaEtapaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaFactorQueryList(){
		
		List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery;
		List<ConvocatoriaPlazaFactorQuery> subListConvocatoriaPlazaFactorQuery;
		Integer srl_id_configuracion_factor_evaluacion = this.getIntegerParameter("srl_id_configuracion_factor_evaluacion");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_configuracion_factor_evaluacion == null){
			listConvocatoriaPlazaFactorQuery = (List<ConvocatoriaPlazaFactorQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaFactorQueryList");
		}else if(srl_id_configuracion_factor_evaluacion.equals("-1")){
			listConvocatoriaPlazaFactorQuery = new ArrayList<ConvocatoriaPlazaFactorQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_configuracion_factor_evaluacion", srl_id_configuracion_factor_evaluacion);
			listConvocatoriaPlazaFactorQuery = this.convocatoriaPlazaService.getListByQuery(ConvocatoriaPlazaFactorQueryMapper.class, paramMap);
			
			
		}

		if(listConvocatoriaPlazaFactorQuery == null){
			listConvocatoriaPlazaFactorQuery = new ArrayList<ConvocatoriaPlazaFactorQuery>();
		}
		this.getSessionContext(true).setAttribute("ConvocatoriaPlazaFactorQueryList",listConvocatoriaPlazaFactorQuery);
		int size = listConvocatoriaPlazaFactorQuery.size();
		subListConvocatoriaPlazaFactorQuery = this.getSubList(listConvocatoriaPlazaFactorQuery, start, limit);
		
		this.success(subListConvocatoriaPlazaFactorQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaFactorQueryAdd(){
		
		List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery = (List<ConvocatoriaPlazaFactorQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaFactorQueryList");
		int randomInt = this.getNegativeIdRandom();
		convocatoriaPlazaFactorQuery.setSrl_id_factor_evaluacion(randomInt);
		listConvocatoriaPlazaFactorQuery.add(convocatoriaPlazaFactorQuery);	
		this.getSessionContext().setAttribute("ConvocatoriaPlazaFactorQueryList",listConvocatoriaPlazaFactorQuery);
		this.success(convocatoriaPlazaFactorQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaFactorQueryUpdate(){
		
		List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery = (List<ConvocatoriaPlazaFactorQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaFactorQueryList");
		int index = -1;
		
		for (int i = 0; i < listConvocatoriaPlazaFactorQuery.size(); i++) {
			if(listConvocatoriaPlazaFactorQuery.get(i).getSrl_id_factor_evaluacion().equals(convocatoriaPlazaFactorQuery.getSrl_id_factor_evaluacion())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConvocatoriaPlazaFactorQuery.set(index, convocatoriaPlazaFactorQuery);
		}
		
		this.getSessionContext().setAttribute("ConvocatoriaPlazaFactorQueryList",listConvocatoriaPlazaFactorQuery);
		this.success(convocatoriaPlazaFactorQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConvocatoriaPlazaFactorQueryDelete(){
		
		List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery = (List<ConvocatoriaPlazaFactorQuery>) this.getSessionContext().getAttribute("ConvocatoriaPlazaFactorQueryList");
		int index = -1;
		for (int i = 0; i < listConvocatoriaPlazaFactorQuery.size(); i++) {
			if(listConvocatoriaPlazaFactorQuery.get(i).getSrl_id_factor_evaluacion().equals(convocatoriaPlazaFactorQuery.getSrl_id_factor_evaluacion())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConvocatoriaPlazaFactorQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConvocatoriaPlazaFactorQueryList",listConvocatoriaPlazaFactorQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	public String reporteConvocatoriaMintra(){
		
		List<ReporteConvocatoriaMintraQuery> listReporteConvocatoriaMintraQuery;		
				
		List<ReporteConvocatoriaMintraObtenerFactorQuery> listReporteConvocatoriaMintraObtenerFactorQuery = new ArrayList<ReporteConvocatoriaMintraObtenerFactorQuery>();;
		
		parametros	= new HashMap();
		
		int srl_id_convocatoria = this.getIntegerParameter("srl_id_convocatoria").equals("") ? null : this.getIntegerParameter("srl_id_convocatoria");
		String srl_id_conv_area_org = this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");
		
//		String formato = this.getParameter("idformato").equals("") ? null : this.getParameter("idformato");
		
		Integer int_conv_area_org = null;
		
		String ruta = PropUtil.getInstance().getPropVal("documents.properties", "ruta.reporte.convocatoria.mintra");
		
		if(srl_id_conv_area_org == null){
			int_conv_area_org = null;
		}else{
			int_conv_area_org = Integer.parseInt(srl_id_conv_area_org);
			int_conv_area_org.intValue();
		}		
		
		ReporteConvocatoriaMintraQueryCriteria criteriaMintra = new ReporteConvocatoriaMintraQueryCriteria();
		criteriaMintra.setSrl_id_convocatoria(srl_id_convocatoria);
		criteriaMintra.setSrl_id_conv_area_org(int_conv_area_org);
		
		listReporteConvocatoriaMintraQuery = this.convocatoriaPlazaService.getListByQuery(ReporteConvocatoriaMintraQueryMapper.class, criteriaMintra);	
		
//		Integer numCodPost = 0;
		
		for(ReporteConvocatoriaMintraQuery y : listReporteConvocatoriaMintraQuery){				
			
			ReporteConvocatoriaMintraObtenerFactorQueryCriteria criteriaFactor = new ReporteConvocatoriaMintraObtenerFactorQueryCriteria();

			criteriaFactor.setSrl_id_configuracion_factor_evaluacion(y.getSrl_id_configuracion_factor_evaluacion());
			criteriaFactor.setSrl_id_conv_area_org(y.getSrl_id_conv_area_org());
			criteriaFactor.setSrl_id_convocatoria(y.getSrl_id_convocatoria());
			
			List<ReporteConvocatoriaMintraObtenerFactorQuery> l = new ArrayList<ReporteConvocatoriaMintraObtenerFactorQuery>();  
			
			l = this.convocatoriaPlazaService.getListByQuery(ReporteConvocatoriaMintraObtenerFactorQueryMapper.class, criteriaFactor);
			
			listReporteConvocatoriaMintraObtenerFactorQuery.addAll(l);	
			
			y.setListEvaluacion(l);
			
			
			ReporteSelectEtapasSeleccionQueryCriteria criteria = new ReporteSelectEtapasSeleccionQueryCriteria();
			
			criteria.setSrl_id_conv_area_org(y.getSrl_id_conv_area_org());
			criteria.setSrl_id_convocatoria(y.getSrl_id_convocatoria());
			
			List<ReporteSelectEtapasSeleccionQuery> e = new ArrayList<ReporteSelectEtapasSeleccionQuery>();
			
			e = this.convocatoriaPlazaService.getListByQuery(ReporteSelectEtapasSeleccionQueryMapper.class, criteria);
			
			y.setListEtapas(e);
			
			
			y.setVar_denominacion_requerimiento(NumeroLiteralUtil.getInstance().ConvertirToLetras(y.getInt_cantidad_requerida() + "",false) + " " + y.getVar_denominacion_requerimiento());
			
//			numCodPost++;
//			
//			if(numCodPost < 10){
//				y.setVar_codigo_postulacion("0"+numCodPost+".- Código : "+y.getVar_codigo_postulacion());
//			}else{
//				y.setVar_codigo_postulacion(numCodPost+".- Código : "+y.getVar_codigo_postulacion());
//			}
			
		}
		

		
		
		
			
	/*	
		for(ReporteConvocatoriaMintraQuery y : listReporteConvocatoriaMintraQuery){
			
			System.out.println("Requerimiento : " + y.getSrl_id_requerimiento_personal());
			
			List<ReporteConvocatoriaMintraObtenerFactorQuery> j = y.getListEvaluacion();			
			for(ReporteConvocatoriaMintraObtenerFactorQuery j1 : j){
				System.out.println(j1.getSrl_id_requerimiento_personal() + " ---- " + j1.getDescrip_tipo_factor());
			}
			
			System.out.println("------------------ Etapas Seleccion ------------------");
			
			for(ReporteSelectEtapasSeleccionQuery e : y.getListEtapas()){
				System.out.println(e.getSrl_id_requerimiento_personal() + " ---- " + e.getVar_descrip_subetapa());
			}
			
			System.out.println("Denominación Requerimiento ---> " + y.getVar_denominacion_requerimiento());
			
			
		}
	 */		
		
		listResult = listReporteConvocatoriaMintraQuery;
		
		parametros.put("SUBREPORT_DIR", ruta);		
		

		return SUCCESS;
	}
	
	public String reporteVacantesPublicas(){
		
		ReporteVacantesPublicasQueryCriteria criteriaVacantes = new ReporteVacantesPublicasQueryCriteria();
		criteriaVacantes.setInt_id_estado(1);
		
		listResult = this.convocatoriaPlazaService.getListByQuery(ReporteVacantesPublicasQueryMapper.class, criteriaVacantes);
		
		return SUCCESS;
	}
	
	public String reporteVacantesPlazas(){
		
		

		int srl_id_convocatoria = this.getIntegerParameter("srl_id_convocatoria").equals("") ? null : this.getIntegerParameter("srl_id_convocatoria");
		String srl_id_conv_area_org = this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");
		
		Integer int_conv_area_org = null;		
		
		
		if(srl_id_conv_area_org == null){
			int_conv_area_org = null;
		}else{
			int_conv_area_org = Integer.parseInt(srl_id_conv_area_org);
			int_conv_area_org.intValue();
		}
		
		ReporteVacantesPublicasQueryCriteria criteriaVacantes = new ReporteVacantesPublicasQueryCriteria();
		criteriaVacantes.setInt_id_estado(1);
		criteriaVacantes.setSrl_id_convocatoria(srl_id_convocatoria);
		
		listResult = this.convocatoriaPlazaService.getListByQuery(ReporteVacantesPublicasQueryMapper.class, criteriaVacantes);
		
		return SUCCESS;
	}
	
	
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public ConvocatoriaPlazaService getConvocatoriaPlazaService() {
		return convocatoriaPlazaService;
	}

	public void setConvocatoriaPlazaService(ConvocatoriaPlazaService convocatoriaPlazaService) {
		this.convocatoriaPlazaService = convocatoriaPlazaService;
	}
	
	public GestionarConvocatoriaPersonalQuery getGestionarConvocatoriaPersonalQuery() {
		return gestionarConvocatoriaPersonalQuery;
	}

	public void setGestionarConvocatoriaPersonalQuery(GestionarConvocatoriaPersonalQuery gestionarConvocatoriaPersonalQuery) {
		this.gestionarConvocatoriaPersonalQuery = gestionarConvocatoriaPersonalQuery;
	}
	public ConvocatoriaPlazaQuery getConvocatoriaPlazaQuery() {
		return convocatoriaPlazaQuery;
	}

	public void setConvocatoriaPlazaQuery(ConvocatoriaPlazaQuery convocatoriaPlazaQuery) {
		this.convocatoriaPlazaQuery = convocatoriaPlazaQuery;
	}
	public ConvocatoriaEtapaQuery getConvocatoriaEtapaQuery() {
		return convocatoriaEtapaQuery;
	}

	public void setConvocatoriaEtapaQuery(ConvocatoriaEtapaQuery convocatoriaEtapaQuery) {
		this.convocatoriaEtapaQuery = convocatoriaEtapaQuery;
	}
	public ConvocatoriaPlazaFactorQuery getConvocatoriaPlazaFactorQuery() {
		return convocatoriaPlazaFactorQuery;
	}

	public void setConvocatoriaPlazaFactorQuery(ConvocatoriaPlazaFactorQuery convocatoriaPlazaFactorQuery) {
		this.convocatoriaPlazaFactorQuery = convocatoriaPlazaFactorQuery;
	}

	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}
	public Map getParametros() {
		return parametros;
	}
	

	public void setParametros(Map parametros) {
		this.parametros = parametros;
	}

	public GeneradorReportesJasper getGeneradorReportesJasper() {
		return generadorReportesJasper;
	}

	public void setGeneradorReportesJasper(GeneradorReportesJasper generadorReportesJasper) {
		this.generadorReportesJasper = generadorReportesJasper;
	}

/*
<!-- Start Actions ConvocatoriaPlaza -->
<action name="ConvocatoriaPlazaView" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="view">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaCreate" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="create">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaSave" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="save">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaRemove" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model ConvocatoriaPlazaQuery Actions -->
<action name="ConvocatoriaPlazaQueryList" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaQueryList">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaQueryAdd" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaQueryAdd">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaQueryUpdate">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaQueryDelete" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConvocatoriaPlazaQuery Actions -->
<!-- Start Sub Model ConvocatoriaEtapaQuery Actions -->
<action name="ConvocatoriaEtapaQueryList" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaEtapaQueryList">
		<result type="json" />
</action>

<action name="ConvocatoriaEtapaQueryAdd" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaEtapaQueryAdd">
		<result type="json" />
</action>

<action name="ConvocatoriaEtapaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaEtapaQueryUpdate">
		<result type="json" />
</action>

<action name="ConvocatoriaEtapaQueryDelete" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaEtapaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConvocatoriaEtapaQuery Actions -->
<!-- Start Sub Model ConvocatoriaPlazaFactorQuery Actions -->
<action name="ConvocatoriaPlazaFactorQueryList" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaFactorQueryList">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaFactorQueryAdd" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaFactorQueryAdd">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaFactorQueryUpdate" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaFactorQueryUpdate">
		<result type="json" />
</action>

<action name="ConvocatoriaPlazaFactorQueryDelete" class="sernanp.rrhh.web.action.seleccion.ConvocatoriaPlazaAction" method="ConvocatoriaPlazaFactorQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConvocatoriaPlazaFactorQuery Actions -->

<!-- End Actions ConvocatoriaPlaza -->
*/
}
