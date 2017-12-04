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
* DATE CREATE : 14/06/2015 01:52:58
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReporteNominaDescuentoService;
import sernanp.app.business.core.planilla.service.RpNominaDescuentoMaestroService;
import sernanp.app.dao.query.domain.RpNominaDescuentoConceptoQueryCriteria;
import sernanp.app.dao.query.domain.RpNominaDescuentosMaestroQuery;
import sernanp.app.dao.query.domain.RpNominaDescuentosMaestroQueryCriteria;
import sernanp.app.dao.query.domain.RpNominaDescuentosQuery;
import sernanp.app.dao.query.domain.RpNominaDescuentosQueryCriteria;
import sernanp.app.dao.query.mapper.RpNominaDescuentoConceptoQueryMapper;
import sernanp.app.dao.query.mapper.RpNominaDescuentosMaestroQueryMapper;
import sernanp.app.dao.query.mapper.RpNominaDescuentosQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteNominaDescuentoAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteNominaDescuentoService reporteNominaDescuentoService;
	
	private RpNominaDescuentosMaestroQuery rpNominaDescuentosMaestroQuery;
	
	@Autowired
	private RpNominaDescuentoMaestroService rpNominaDescuentoMaestroService;
	
		
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	String resultado;
	
	public String listarNominaDescuento(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String srl_id_regimen_pensionario = this.getParameter("srl_id_regimen_pensionario").equals("") ? null : this.getParameter("srl_id_regimen_pensionario");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("")? null: this.getParameter("c_fte_fto");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		Integer int_regimen_pensionario = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		if(srl_id_regimen_pensionario == null){
			int_regimen_pensionario = null;
		}else{
			int_regimen_pensionario = Integer.parseInt(srl_id_regimen_pensionario);
			int_regimen_pensionario.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpNominaDescuentosMaestroQueryCriteria criterioNomina = new RpNominaDescuentosMaestroQueryCriteria();
		criterioNomina.setNombre_completo(nombre_completo);
		criterioNomina.setInt_id_periodo_mes(id_periodo);
		criterioNomina.setSrl_id_regimen_contractual(int_regimen);
		criterioNomina.setInt_anio(anio);
		criterioNomina.setSrl_id_regimen_pensionario(int_regimen_pensionario);
		criterioNomina.setC_fte_fto(c_fte_fto);

		
		listResult = rpNominaDescuentoMaestroService.getListByQuery(RpNominaDescuentosMaestroQueryMapper.class, criterioNomina);
		
        return resultado = tipo_reporte;
		
	
    }
	
	public String listarNominaDescuentoConcepto(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String srl_id_concepto_planilla = this.getParameter("srl_id_concepto_planilla").equals("") ? null : this.getParameter("srl_id_concepto_planilla");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
//		String c_fte_fto = this.getParameter("c_fte_fto").equals("")? null: this.getParameter("c_fte_fto");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		Integer int_concepto = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		if(srl_id_concepto_planilla == null){
			int_concepto = null;
		}else{
			int_concepto = Integer.parseInt(srl_id_concepto_planilla);
			int_concepto.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpNominaDescuentoConceptoQueryCriteria criteriaNominaConcepto = new RpNominaDescuentoConceptoQueryCriteria();
		criteriaNominaConcepto.setInt_id_periodo_mes(id_periodo);
		criteriaNominaConcepto.setSrl_id_regimen_contractual(int_regimen);
		criteriaNominaConcepto.setInt_anio(anio);
		criteriaNominaConcepto.setSrl_id_concepto_planilla(int_concepto);
//		criteriaNominaConcepto.setC_fte_fto(c_fte_fto);

		
		listResult = rpNominaDescuentoMaestroService.getListByQuery(RpNominaDescuentoConceptoQueryMapper.class, criteriaNominaConcepto);
		
        return resultado = tipo_reporte;
		
	}
	
	
	
	public String listarNominaDetalleDescuento(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String srl_id_regimen_pensionario = this.getParameter("srl_id_regimen_pensionario").equals("") ? null : this.getParameter("srl_id_regimen_pensionario");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		Integer int_regimen_pensionario = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		if(srl_id_regimen_pensionario == null){
			int_regimen_pensionario = null;
		}else{
			int_regimen_pensionario = Integer.parseInt(srl_id_regimen_pensionario);
			int_regimen_pensionario.intValue();
		}
		
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpNominaDescuentosQueryCriteria criteria = new RpNominaDescuentosQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);
		criteria.setSrl_id_regimen_pensionario(int_regimen_pensionario);

		
		setListResult(reporteNominaDescuentoService.getListByQuery(RpNominaDescuentosQueryMapper.class, criteria));
		
        return resultado = tipo_reporte;
		
	
    }
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpNominaDescuentosQueryCriteria rpNominaDescuentosMaestroQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpNominaDescuentosQueryCriteria.class);
			List<RpNominaDescuentosQuery> listRpNominaDescuentosMaestroQuery = reporteNominaDescuentoService.getListByQuery(RpNominaDescuentosQueryMapper.class, rpNominaDescuentosMaestroQueryCriteria, start, limit);
			int total = reporteNominaDescuentoService.getCountRowsByQuery(RpNominaDescuentosQueryMapper.class, rpNominaDescuentosMaestroQueryCriteria);
			
			this.success(listRpNominaDescuentosMaestroQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteNominaDescuentoService.create(rpNominaDescuentosMaestroQuery);
			this.success(rpNominaDescuentosMaestroQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteNominaDescuentoService.save(rpNominaDescuentosMaestroQuery);
			this.success(rpNominaDescuentosMaestroQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteNominaDescuentoService.remove(rpNominaDescuentosMaestroQuery);
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
	
	public ReporteNominaDescuentoService getReporteNominaDescuentoService() {
		return reporteNominaDescuentoService;
	}

	public void setReporteNominaDescuentoService(ReporteNominaDescuentoService reporteNominaDescuentoService) {
		this.reporteNominaDescuentoService = reporteNominaDescuentoService;
	}

	public RpNominaDescuentosMaestroQuery getRpNominaDescuentosMaestroQuery() {
		return rpNominaDescuentosMaestroQuery;
	}

	public void setRpNominaDescuentosMaestroQuery(RpNominaDescuentosMaestroQuery rpNominaDescuentosMaestroQuery) {
		this.rpNominaDescuentosMaestroQuery = rpNominaDescuentosMaestroQuery;
	}

	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReporteNominaDescuento -->
<action name="ReporteNominaDescuentoView" class="sernanp.rrhh.web.action.planilla.ReporteNominaDescuentoAction" method="view">
		<result type="json" />
</action>

<action name="ReporteNominaDescuentoCreate" class="sernanp.rrhh.web.action.planilla.ReporteNominaDescuentoAction" method="create">
		<result type="json" />
</action>

<action name="ReporteNominaDescuentoSave" class="sernanp.rrhh.web.action.planilla.ReporteNominaDescuentoAction" method="save">
		<result type="json" />
</action>

<action name="ReporteNominaDescuentoRemove" class="sernanp.rrhh.web.action.planilla.ReporteNominaDescuentoAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteNominaDescuento -->
*/

}
