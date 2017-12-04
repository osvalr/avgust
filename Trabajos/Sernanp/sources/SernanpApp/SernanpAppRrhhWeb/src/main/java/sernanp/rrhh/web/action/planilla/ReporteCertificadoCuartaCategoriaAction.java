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
* DATE CREATE : 02/06/2015 16:08:44
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.planilla.service.ReporteCertificadoCuartaCategoriaService;
import sernanp.app.dao.query.domain.RpCertificadoCuartaCategoriaQuery;
import sernanp.app.dao.query.domain.RpCertificadoCuartaCategoriaQueryCriteria;
import sernanp.app.dao.query.mapper.RpCertificadoCuartaCategoriaQueryMapper;

public class ReporteCertificadoCuartaCategoriaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteCertificadoCuartaCategoriaService reporteCertificadoCuartaCategoriaService;
	
	private RpCertificadoCuartaCategoriaQuery rpCertificadoCuartaCategoriaQuery;
	
	
String resultado;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	public String reporteCertificadoCuartaCategoria(){
		
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String srl_id_cargo = this.getParameter("srl_id_cargo").equals("") ? null : this.getParameter("srl_id_cargo");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("")? null : this.getParameter("int_id_periodo_mes");

		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		
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
			
		/* ADD 04-01-2015 DAVID*/
		// CUANDO SE GENERE UN CERTIFICADO INDIVIDUAL
		if(nombre_completo != null){
			mes = null;
		}
		
		RpCertificadoCuartaCategoriaQueryCriteria criteria = new RpCertificadoCuartaCategoriaQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_anio(anio);
		criteria.setSrl_id_cargo(cargo);
		criteria.setInt_id_periodo_mes(mes);

				
		listResult =reporteCertificadoCuartaCategoriaService.getListByQuery(RpCertificadoCuartaCategoriaQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	
    }

	public String reporteCertificadoCuartaCategoriaIndividual(){
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String idpersonal = this.getParameter("idpersonal").equals("") ? null : this.getParameter("idpersonal");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");

		Integer anio = null;
		Integer personal = null;
		
		
		if (int_anio == null) {
			anio = null;
		}else{
			anio = Integer.parseInt(int_anio);
			anio.intValue();
		}
		
		if (idpersonal == null) {
			personal = null;
		}else{
			personal = Integer.parseInt(idpersonal);
			personal.intValue();
		}
			
		
		RpCertificadoCuartaCategoriaQueryCriteria criteria = new RpCertificadoCuartaCategoriaQueryCriteria();

		criteria.setInt_anio(anio);
		criteria.setIdpersonal(personal);
				
		listResult =reporteCertificadoCuartaCategoriaService.getListByQuery(RpCertificadoCuartaCategoriaQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	
    }

	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpCertificadoCuartaCategoriaQueryCriteria rpCertificadoCuartaCategoriaQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpCertificadoCuartaCategoriaQueryCriteria.class);
			List<RpCertificadoCuartaCategoriaQuery> listRpCertificadoCuartaCategoriaQuery = reporteCertificadoCuartaCategoriaService.getListByQuery(RpCertificadoCuartaCategoriaQueryMapper.class, rpCertificadoCuartaCategoriaQueryCriteria, start, limit);
			int total = reporteCertificadoCuartaCategoriaService.getCountRowsByQuery(RpCertificadoCuartaCategoriaQueryMapper.class, rpCertificadoCuartaCategoriaQueryCriteria);
			
			this.success(listRpCertificadoCuartaCategoriaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteCertificadoCuartaCategoriaService.create(rpCertificadoCuartaCategoriaQuery);
			this.success(rpCertificadoCuartaCategoriaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteCertificadoCuartaCategoriaService.save(rpCertificadoCuartaCategoriaQuery);
			this.success(rpCertificadoCuartaCategoriaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteCertificadoCuartaCategoriaService.remove(rpCertificadoCuartaCategoriaQuery);
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
	
	public ReporteCertificadoCuartaCategoriaService getReporteCertificadoCuartaCategoriaService() {
		return reporteCertificadoCuartaCategoriaService;
	}

	public void setReporteCertificadoCuartaCategoriaService(ReporteCertificadoCuartaCategoriaService reporteCertificadoCuartaCategoriaService) {
		this.reporteCertificadoCuartaCategoriaService = reporteCertificadoCuartaCategoriaService;
	}

	public RpCertificadoCuartaCategoriaQuery getRpCertificadoCuartaCategoriaQuery() {
		return rpCertificadoCuartaCategoriaQuery;
	}

	public void setRpCertificadoCuartaCategoriaQuery(RpCertificadoCuartaCategoriaQuery rpCertificadoCuartaCategoriaQuery) {
		this.rpCertificadoCuartaCategoriaQuery = rpCertificadoCuartaCategoriaQuery;
	}


	public List getListResult() {
		return listResult;
	}


	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReporteCertificadoCuartaCategoria -->
<action name="ReporteCertificadoCuartaCategoriaView" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoCuartaCategoriaAction" method="view">
		<result type="json" />
</action>

<action name="ReporteCertificadoCuartaCategoriaCreate" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoCuartaCategoriaAction" method="create">
		<result type="json" />
</action>

<action name="ReporteCertificadoCuartaCategoriaSave" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoCuartaCategoriaAction" method="save">
		<result type="json" />
</action>

<action name="ReporteCertificadoCuartaCategoriaRemove" class="sernanp.rrhh.web.action.planilla.ReporteCertificadoCuartaCategoriaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteCertificadoCuartaCategoria -->
*/

}
