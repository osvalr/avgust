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
* DATE CREATE : 08/06/2015 18:38:03
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.seleccion.service.ReportePostulantesInscritosService;
import sernanp.app.dao.query.domain.RpPostulantesInscritosQuery;
import sernanp.app.dao.query.domain.RpPostulantesInscritosQueryCriteria;
import sernanp.app.dao.query.mapper.RpPostulantesInscritosQueryMapper;

public class ReportePostulantesInscritosAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReportePostulantesInscritosService reportePostulantesInscritosService;
	
	private RpPostulantesInscritosQuery rpPostulantesInscritosQuery;
	
	String resultado;
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Map reportParameters;
	
	
	public String reportePostulantesInscritos(){
		String nombre_completo 			= this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String numerodoc 						= this.getParameter("numerodoc").equals("") ? null : this.getParameter("numerodoc");
		String srl_id_convocatoria 			= this.getParameter("srl_id_convocatoria").equals("") ? null : this.getParameter("srl_id_convocatoria");		
		String srl_id_conv_area_org			= this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");	
//		String tipo_reporte 						= this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/		
		String srl_id_sede_req_sel	= this.getParameter("srl_id_sede_req_sel").equals("") ? null : this.getParameter("srl_id_sede_req_sel");
		
		Integer sede_administrativa = null;
		
		if(srl_id_sede_req_sel == null){
			sede_administrativa = null;
		}else{
			sede_administrativa = Integer.parseInt(srl_id_sede_req_sel);
		}
	
		
		/*END*/

		Integer convocatoria = null;
		
		if(srl_id_convocatoria==null){
			
			convocatoria = null;
		}else{
			convocatoria =Integer.parseInt(srl_id_convocatoria);
			convocatoria.intValue();
			
		}
		
		Integer cod_postulacion = null;
		
		if(srl_id_conv_area_org == null){
			cod_postulacion = null;
		}else{
			cod_postulacion = Integer.parseInt(srl_id_conv_area_org);
			cod_postulacion.intValue();
		}

		RpPostulantesInscritosQueryCriteria criteria = new RpPostulantesInscritosQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setNumerodoc(numerodoc);
		criteria.setSrl_id_convocatoria(convocatoria);
		criteria.setSrl_id_conv_area_org(cod_postulacion);
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
		criteria.setSrl_id_sede_req_sel(sede_administrativa);
//		criteria.setSrl_id_sede_uni_ope_anp(sede_unidad_operativa_anp);
		/*END*/
		List<RpPostulantesInscritosQuery> list = reportePostulantesInscritosService.getListByQuery(RpPostulantesInscritosQueryMapper.class, criteria);
		
		listResult = list;
		if (listResult.size() > 0){
			String ruta = PropUtil.getInstance().getPropVal("personal.properties", "ruta.logo");
			
			reportParameters = new HashMap();

			reportParameters.put("logo", ruta);		
	
		}
				
//		return resultado = tipo_reporte;
		
		return SUCCESS;
	}
	
	
		
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			System.out.println("ReportePostulantesInscritosView - view");
			RpPostulantesInscritosQueryCriteria rpPostulantesInscritosQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpPostulantesInscritosQueryCriteria.class);
			List<RpPostulantesInscritosQuery> listRpPostulantesInscritosQuery = reportePostulantesInscritosService.getListByQuery(RpPostulantesInscritosQueryMapper.class, rpPostulantesInscritosQueryCriteria, start, limit);
			int total = reportePostulantesInscritosService.getCountRowsByQuery(RpPostulantesInscritosQueryMapper.class, rpPostulantesInscritosQueryCriteria);
			
			this.success(listRpPostulantesInscritosQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reportePostulantesInscritosService.create(rpPostulantesInscritosQuery);
			this.success(rpPostulantesInscritosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reportePostulantesInscritosService.save(rpPostulantesInscritosQuery);
			this.success(rpPostulantesInscritosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reportePostulantesInscritosService.remove(rpPostulantesInscritosQuery);
			this.extjsReturn.setSuccess(true);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public ReportePostulantesInscritosService getReportePostulantesInscritosService() {
		return reportePostulantesInscritosService;
	}

	public void setReportePostulantesInscritosService(ReportePostulantesInscritosService reportePostulantesInscritosService) {
		this.reportePostulantesInscritosService = reportePostulantesInscritosService;
	}

	public RpPostulantesInscritosQuery getRpPostulantesInscritosQuery() {
		return rpPostulantesInscritosQuery;
	}

	public void setRpPostulantesInscritosQuery(RpPostulantesInscritosQuery rpPostulantesInscritosQuery) {
		this.rpPostulantesInscritosQuery = rpPostulantesInscritosQuery;
	}

	public List getListResult() {
		return listResult;
	}

	public void setListResult(List listResult) {
		this.listResult = listResult;
	}


	public Map getReportParameters() {
		return reportParameters;
	}


	public void setReportParameters(Map reportParameters) {
		this.reportParameters = reportParameters;
	}




/*
<!-- Start Actions ReportePostulantesInscritos -->
<action name="ReportePostulantesInscritosView" class="sernanp.rrhh.web.action.seleccion.ReportePostulantesInscritosAction" method="view">
		<result type="json" />
</action>

<action name="ReportePostulantesInscritosCreate" class="sernanp.rrhh.web.action.seleccion.ReportePostulantesInscritosAction" method="create">
		<result type="json" />
</action>

<action name="ReportePostulantesInscritosSave" class="sernanp.rrhh.web.action.seleccion.ReportePostulantesInscritosAction" method="save">
		<result type="json" />
</action>

<action name="ReportePostulantesInscritosRemove" class="sernanp.rrhh.web.action.seleccion.ReportePostulantesInscritosAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReportePostulantesInscritos -->
*/

}
