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
* DATE CREATE : 02/06/2015 23:42:36
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.ReporteCertificadoQuintaCategoriaService;
import sernanp.app.dao.query.domain.RpCertificadoQuintaCategoriaQuery;
import sernanp.app.dao.query.domain.RpCertificadoQuintaCategoriaQueryCriteria;
import sernanp.app.dao.query.mapper.RpCertificadoQuintaCategoriaQueryMapper;

public class ReporteCertificadoQuintaCategoriaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteCertificadoQuintaCategoriaService reporteCertificadoQuintaCategoriaService;
	
	private RpCertificadoQuintaCategoriaQuery rpCertificadoQuintaCategoriaQuery;
	

	
String resultado;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	public String reporteCertificadoQuintaCategoria(){
		
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String srl_id_cargo = this.getParameter("srl_id_cargo").equals("") ? null : this.getParameter("srl_id_cargo");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("")? null : this.getParameter("int_id_periodo_mes");
		
		Integer cargo = null;
		Integer anio = null;
		Integer mes = null;
		
		
		if (srl_id_cargo == null) {
			cargo = null;
		}else{
			cargo = Integer.parseInt(srl_id_cargo);
			cargo.intValue();
		}
		
		if (int_anio == null) {
			anio = null;
		}else{
			anio = Integer.parseInt(int_anio);
			anio.intValue();
		}
			
		if (int_id_periodo_mes == null){
			mes = null;
		}else{
			mes = Integer.parseInt(int_id_periodo_mes);
			mes.intValue();
		}
				
		
			
		RpCertificadoQuintaCategoriaQueryCriteria criteria = new RpCertificadoQuintaCategoriaQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_anio(anio);
		criteria.setSrl_id_cargo(cargo);
		criteria.setInt_id_periodo_mes(mes);
	
		listResult=reporteCertificadoQuintaCategoriaService.getListByQuery(RpCertificadoQuintaCategoriaQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	
    }
	
	
	public String reporteCertificadoQuintaCategoriaIndividual(){
		
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String idpersonal = this.getParameter("idpersonal").equals("") ? null : this.getParameter("idpersonal");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		
		Integer personal = null;
		Integer anio = null;
		
		
		
		if (idpersonal == null) {
			personal = null;
		}else{
			personal = Integer.parseInt(idpersonal);
			personal.intValue();
		}
		
		if (int_anio == null) {
			anio = null;
		}else{
			anio = Integer.parseInt(int_anio);
			anio.intValue();
		}
				
					
		RpCertificadoQuintaCategoriaQueryCriteria criteria = new RpCertificadoQuintaCategoriaQueryCriteria();

		criteria.setInt_anio(anio);
		criteria.setIdpersonal(personal);
		
		listResult=reporteCertificadoQuintaCategoriaService.getListByQuery(RpCertificadoQuintaCategoriaQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	
    }

	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			
			RpCertificadoQuintaCategoriaQueryCriteria rpCertificadoQuintaCategoriaQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpCertificadoQuintaCategoriaQueryCriteria.class);
			List<RpCertificadoQuintaCategoriaQuery> listRpCertificadoQuintaCategoriaQuery = reporteCertificadoQuintaCategoriaService.getListByQuery(RpCertificadoQuintaCategoriaQueryMapper.class, rpCertificadoQuintaCategoriaQueryCriteria, start, limit);
			int total = reporteCertificadoQuintaCategoriaService.getCountRowsByQuery(RpCertificadoQuintaCategoriaQueryMapper.class, rpCertificadoQuintaCategoriaQueryCriteria);
					
						
			
			this.success(listRpCertificadoQuintaCategoriaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteCertificadoQuintaCategoriaService.create(rpCertificadoQuintaCategoriaQuery);
			this.success(rpCertificadoQuintaCategoriaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteCertificadoQuintaCategoriaService.save(rpCertificadoQuintaCategoriaQuery);
			this.success(rpCertificadoQuintaCategoriaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteCertificadoQuintaCategoriaService.remove(rpCertificadoQuintaCategoriaQuery);
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
	
	public ReporteCertificadoQuintaCategoriaService getReporteCertificadoQuintaCategoriaService() {
		return reporteCertificadoQuintaCategoriaService;
	}

	public void setReporteCertificadoQuintaCategoriaService(ReporteCertificadoQuintaCategoriaService reporteCertificadoQuintaCategoriaService) {
		this.reporteCertificadoQuintaCategoriaService = reporteCertificadoQuintaCategoriaService;
	}

	public RpCertificadoQuintaCategoriaQuery getRpCertificadoQuintaCategoriaQuery() {
		return rpCertificadoQuintaCategoriaQuery;
	}

	public void setRpCertificadoQuintaCategoriaQuery(RpCertificadoQuintaCategoriaQuery rpCertificadoQuintaCategoriaQuery) {
		this.rpCertificadoQuintaCategoriaQuery = rpCertificadoQuintaCategoriaQuery;
	}


	public List getListResult() {
		return listResult;
	}


	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReporteCertificadoQuintaCategoria -->
<action name="ReporteCertificadoQuintaCategoriaView" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoQuintaCategoriaAction" method="view">
		<result type="json" />
</action>

<action name="ReporteCertificadoQuintaCategoriaCreate" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoQuintaCategoriaAction" method="create">
		<result type="json" />
</action>

<action name="ReporteCertificadoQuintaCategoriaSave" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoQuintaCategoriaAction" method="save">
		<result type="json" />
</action>

<action name="ReporteCertificadoQuintaCategoriaRemove" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoQuintaCategoriaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteCertificadoQuintaCategoria -->
*/

}
