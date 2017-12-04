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
* DATE CREATE : 31/05/2015 16:59:27
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.GenerarJORService;
import sernanp.app.business.core.planilla.service.GenerarREMService;
import sernanp.app.business.core.planilla.service.ReporteResumenGeneralPlanillaService;
import sernanp.app.business.dto.RptJORBean;
import sernanp.app.business.dto.RptREMBean;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoProyeccionQuery;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoProyeccionQueryCriteria;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoQuery;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoQueryCriteria;
import sernanp.app.dao.query.domain.ReporteProyeccionPlanillasFFQuery;
import sernanp.app.dao.query.domain.ReporteProyeccionPlanillasFFQueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenGeneralPlanillaQuery;
import sernanp.app.dao.query.domain.ReporteResumenGeneralPlanillaQueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenGlobal728QueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenGlobal728Query_LiquidacionCriteria;
import sernanp.app.dao.query.domain.ReporteResumenGlobalCASQueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenGlobalCASQuery_LiquidacionCriteria;
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_728QueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria;
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_CASQueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria;
import sernanp.app.dao.query.domain.ResumenNominaPagosQuery;
import sernanp.app.dao.query.domain.ResumenNominaPagosQueryCriteria;
import sernanp.app.dao.query.domain.ResumenPlanillaFuenteMetaQueryCriteria;
import sernanp.app.dao.query.mapper.ConceptoPlanillaPorPeriodoProyeccionQueryMapper;
import sernanp.app.dao.query.mapper.ConceptoPlanillaPorPeriodoQueryMapper;
import sernanp.app.dao.query.mapper.ReporteProyeccionPlanillasFFQueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenGeneralPlanillaQueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenGlobal728QueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenGlobal728Query_LiquidacionMapper;
import sernanp.app.dao.query.mapper.ReporteResumenGlobalCASQueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenGlobalCASQuery_LiquidacionMapper;
import sernanp.app.dao.query.mapper.ReporteResumenNominaPagoFFMP_728QueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenNominaPagoFFMP_728Query_LiquidacionMapper;
import sernanp.app.dao.query.mapper.ReporteResumenNominaPagoFFMP_CASQueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionMapper;
import sernanp.app.dao.query.mapper.ResumenNominaPagosQueryMapper;
import sernanp.app.dao.query.mapper.ResumenPlanillaFuenteMetaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteResumenGeneralPlanillaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteResumenGeneralPlanillaService reporteResumenGeneralPlanillaService;
	
	@Autowired
	private GenerarJORService generarJORService;
	
	@Autowired
	private GenerarREMService generarREMService;
	
	private ReporteResumenGeneralPlanillaQuery reporteResumenGeneralPlanillaQuery;
	
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	@SuppressWarnings("rawtypes")
	private List listResultGlobalCAS;
	
	@SuppressWarnings("rawtypes")
	private List listResultGlobal728;
	
		
	@SuppressWarnings("rawtypes")
	private Map parametros;
	
	String resultado;
	
	private InputStream fileInputStream;
    private String fileName;
    private String contentType;
    
   	
	public String listarResumenGeneralPlanilla(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		
				
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		ReporteResumenGeneralPlanillaQueryCriteria criteria = new ReporteResumenGeneralPlanillaQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setC_fte_fto(c_fte_fto);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);

		
		listResult = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenGeneralPlanillaQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
		
	}
	
	public String listarResumenNominaPago() {
		
		List<Map<Object, Object>> listDetalle			= null;
		List<Map<Object, Object>> listDetalleTotales	= null;
		Map<Object, Object> mapDetalle					= null;
				
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
//		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
				
		SimpleDateFormat simpleMes	= new SimpleDateFormat("MMMM", new Locale("es_ES"));
		Calendar cal				= new GregorianCalendar();
		cal.set(2000, (id_periodo - 1), 1);
		
		String strMes	= simpleMes.format(cal.getTime());
		
		switch(id_periodo) {
			case 1:
				strMes = "ENERO";
				break;
			case 2:
				strMes = "FEBRERO";
				break;
			case 3:
				strMes = "MARZO";
				break;
			case 4:
				strMes = "ABRIL";
				break;
			case 5:
				strMes = "MAYO";
				break;
			case 6:
				strMes = "JUNIO";
				break;
			case 7:
				strMes = "JULIO";
				break;
			case 8:
				strMes = "AGOSTO";
				break;
			case 9:
				strMes = "SETIEMBRE";
				break;
			case 10:
				strMes = "OCTUBRE";
				break;
			case 11:
				strMes = "NOVIEMBRE";
				break;
			case 12:
				strMes = "DICIEMBRE";
				break;
		}
		
		parametros	= new HashMap();
		parametros.put("strAnio", "" + int_anio);
		parametros.put("strMes", strMes);
		
		//TODO Cambiar por un property

//		parametros.put("SUBREPORT_DIR", "C:\\GITHUB\\sernanp\\Consultoria_planillas_seleccion_personal\\Desarrollo\\SernanpApp\\SernanpAppRrhhWeb\\src\\main\\webapp\\jasper\\planillas\\");
//		parametros.put("SUBREPORT_DIR", "/opt/apache-tomcat-7.0.50/webapps/personal/jasper/planillas/");
//		parametros.put("SUBREPORT_DIR", "/home/david/Desarrollo SW/GitHub/sernanp/Consultoria_planillas_seleccion_personal/Desarrollo/SernanpApp/SernanpAppRrhhWeb/src/main/webapp/jasper/planillas/");	
		

		String ruta = PropUtil.getInstance().getPropVal("documents.properties", "ruta.subreporte.resumen.general.planilla");	
		parametros.put("SUBREPORT_DIR", ruta);

		
		ConceptoPlanillaPorPeriodoQueryCriteria criteriaConcPlanilla = new ConceptoPlanillaPorPeriodoQueryCriteria();
		criteriaConcPlanilla.setInt_id_periodo_mes(id_periodo);
		criteriaConcPlanilla.setInt_anio(anio);
		criteriaConcPlanilla.setSrl_id_regimen_contractual(int_regimen);
		
		
		List<ConceptoPlanillaPorPeriodoQuery> listResultConcPlan	= reporteResumenGeneralPlanillaService.getListByQuery(ConceptoPlanillaPorPeriodoQueryMapper.class, criteriaConcPlanilla);
		Map<Integer, Integer> mapConcPlanPorPer			= new HashMap<Integer, Integer>();
		int intOrden	= 0;
		listDetalle			= new ArrayList<Map<Object, Object>>();
		listDetalleTotales	= new ArrayList<Map<Object, Object>>();

		for(ConceptoPlanillaPorPeriodoQuery conceptoBean:listResultConcPlan) {
			//INICIA CABECERAS
			mapConcPlanPorPer.put(conceptoBean.getSrl_id_concepto_planilla(), intOrden);
			intOrden++;
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", conceptoBean.getVar_descrip_concepto());
			listDetalle.add(mapDetalle);
			
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", 0d);
			mapDetalle.put("dblValor", 0d);
			listDetalleTotales.add(mapDetalle);
			
		}
		{
			//INICIA COLUMNAS FINALES
		
			mapConcPlanPorPer.put(-100, intOrden);
			intOrden++;
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", "TOTAL DSCTS");
			listDetalle.add(mapDetalle);
			
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", 0d);
			mapDetalle.put("dblValor", 0d);
			listDetalleTotales.add(mapDetalle);
			
			mapConcPlanPorPer.put(-200, intOrden);
			intOrden++;
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", "NETO");
			listDetalle.add(mapDetalle);
			
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", 0d);
			mapDetalle.put("dblValor", 0d);
			listDetalleTotales.add(mapDetalle);
		}
		
		JRMapCollectionDataSource listMapDetalleCab_DS = new JRMapCollectionDataSource((Collection)listDetalle);
		parametros.put("listMapDetalleCab_DS", listMapDetalleCab_DS);

		JRMapCollectionDataSource listMapDetalleTotales_DS = new JRMapCollectionDataSource((Collection)listDetalleTotales);
		parametros.put("listMapDetalleTotales_DS", listMapDetalleTotales_DS);
		
		ResumenNominaPagosQueryCriteria criteria = new ResumenNominaPagosQueryCriteria();
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setInt_anio(anio);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setC_fte_fto(c_fte_fto);
//		criteria.setC_meta(c_meta);
		
		criteriaConcPlanilla.setOrderColumn("nombre_completo, srl_id_concepto_planilla");
		
		List<ResumenNominaPagosQuery> listResultTemp = reporteResumenGeneralPlanillaService.getListByQuery(ResumenNominaPagosQueryMapper.class, criteria);
		
		ArrayList<ResumenNominaPagosQuery> listArr			= new ArrayList<ResumenNominaPagosQuery>();
		Map<String, ResumenNominaPagosQuery> mapEmpleado	= new HashMap<String, ResumenNominaPagosQuery>();
		ResumenNominaPagosQuery mapEmpTemp					= null;
		Map<String, Object> totales					   	 	= new HashMap<String, Object>();
		double dblSubTotal									= 0d;
		
		try {
			for(ResumenNominaPagosQuery bean:listResultTemp) {
				
				if(!mapEmpleado.containsKey(bean.getNumerodoc())) {
					
					listDetalle			= new ArrayList<Map<Object, Object>>();
										
					for(ConceptoPlanillaPorPeriodoQuery conceptoBean:listResultConcPlan) {
						//INICIA VALORES
						mapDetalle		= new HashMap<Object, Object>();
						mapDetalle.put("strValor", 0d);
						listDetalle.add(mapDetalle);
					}
					
					{
						//INICIA VALORES COLS FIN
						
						mapDetalle		= new HashMap<Object, Object>();//"TOTAL DSCTS"
						mapDetalle.put("strValor", bean.getDec_total_descuentos());
						listDetalle.add(mapDetalle);
						
						mapDetalle		= new HashMap<Object, Object>();//"NETO"
						mapDetalle.put("strValor", bean.getNeto_pagar());
						listDetalle.add(mapDetalle);
					}

					{
						intOrden			= mapConcPlanPorPer.get(-100);
						mapDetalle			= (Map<Object, Object>)listDetalleTotales.get(intOrden);
						dblSubTotal			= (Double)mapDetalle.get("dblValor");
						mapDetalle.put("dblValor", (dblSubTotal + bean.getDec_total_descuentos()));
					}
					{
						intOrden			= mapConcPlanPorPer.get(-200);
						mapDetalle			= (Map<Object, Object>)listDetalleTotales.get(intOrden);
						dblSubTotal			= (Double)mapDetalle.get("dblValor");
						mapDetalle.put("dblValor", (dblSubTotal + bean.getNeto_pagar()));
					}
					
					bean.setListDetalle(listDetalle);
					listArr.add(bean);
					mapEmpleado.put(bean.getNumerodoc(), bean);
					
				}
				
				
				mapEmpTemp			= (ResumenNominaPagosQuery)mapEmpleado.get(bean.getNumerodoc());
				listDetalle			= mapEmpTemp.getListDetalle();
				
				{
					
					intOrden			= mapConcPlanPorPer.get(bean.getSrl_id_concepto_planilla());
					mapDetalle			= (Map<Object, Object>)listDetalle.get(intOrden);
					mapDetalle.put("strValor", bean.getDec_monto_calculado_tot());
				}
				

				{					
				
					intOrden			= mapConcPlanPorPer.get(bean.getSrl_id_concepto_planilla());
					mapDetalle			= (Map<Object, Object>)listDetalleTotales.get(intOrden);
					dblSubTotal			= (Double)mapDetalle.get("dblValor");
					mapDetalle.put("dblValor", (dblSubTotal + bean.getDec_monto_calculado()));					
				
				}
					
									
			}
			
			
			for(Map<Object, Object> mapDetalleTot:listDetalleTotales) {
				
				dblSubTotal			= (Double)mapDetalleTot.get("dblValor");
				mapDetalleTot.put("strValor", dblSubTotal);
				
			}
			
			
			dblSubTotal			= 0d;
			
			for(ResumenNominaPagosQuery mapRep:listArr) {
				
				listDetalle		= mapRep.getListDetalle();
				
				try {
					
					dblSubTotal		+= mapRep.getDec_total_ingresos();
					
				} catch(Exception ex) {}
				
				JRMapCollectionDataSource listMapDetalle_DS = new JRMapCollectionDataSource((Collection)listDetalle);
				mapRep.setListMapDetalle_DS(listMapDetalle_DS);
				mapRep.setListDetalle(null);
				
			}
			parametros.put("dec_total", dblSubTotal);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		listResult	= listArr;
		
        return resultado = tipo_reporte;
	}
	
	public String listarResumenNominaPagoFFMP728(){
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		String ruta = PropUtil.getInstance().getPropVal("documents.properties", "ruta.subreporte.resumen.general.planilla");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		if(c_meta == null){
			c_meta = "000-600";
		}
		
		String resultado_concatenacion = null;
		try{
		resultado_concatenacion = concatenarMeta(c_meta);
		
		}catch (BusinessException e) {
		    e.printStackTrace(); return null;
		}catch (Exception e) {
		    e.printStackTrace(); return null;
		}  
		
		parametros	= new HashMap();
		parametros.put("SUBREPORT_DIR", ruta);
		
		ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria Liquidacion728_criteria = new ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria();
		Liquidacion728_criteria.setC_fte_fto(c_fte_fto);
		Liquidacion728_criteria.setC_meta(resultado_concatenacion);
		Liquidacion728_criteria.setInt_anio(anio);
		Liquidacion728_criteria.setInt_id_periodo_mes(id_periodo);
		Liquidacion728_criteria.setSrl_id_regimen_contractual(int_regimen);
		
		List listResult728Liquidacion = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenNominaPagoFFMP_728Query_LiquidacionMapper.class, Liquidacion728_criteria);
		
		ReporteResumenNominaPagoFFMP_728QueryCriteria criteria728 = new ReporteResumenNominaPagoFFMP_728QueryCriteria();
		criteria728.setC_fte_fto(c_fte_fto);
		criteria728.setC_meta(resultado_concatenacion);
		criteria728.setInt_anio(anio);
		criteria728.setInt_id_periodo_mes(id_periodo);
		criteria728.setSrl_id_regimen_contractual(int_regimen);
		
		listResult = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenNominaPagoFFMP_728QueryMapper.class, criteria728);
		
		JRBeanCollectionDataSource listLiquidacion_DS = new JRBeanCollectionDataSource((Collection)listResult728Liquidacion);
		parametros.put("listLiquidacion_DS", listLiquidacion_DS);
		
		JRBeanCollectionDataSource listApertura_DS = new JRBeanCollectionDataSource((Collection)listResult);
		parametros.put("listApertura_DS", listApertura_DS);
		
		return resultado = tipo_reporte;
	}
	
	public String listarResumenNominaPagoFFMPCAS(){
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		String ruta 		= PropUtil.getInstance().getPropVal("documents.properties", "ruta.subreporte.resumen.general.planilla");
		String ruta_logo 	= PropUtil.getInstance().getPropVal("personal.properties", "ruta.logo");
						
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		if(c_meta == null){
			c_meta = "000-600";
		}
		
		String resultado_concatenacion = null;
		try{
		resultado_concatenacion = concatenarMeta(c_meta);
		
		}catch (BusinessException e) {
		    e.printStackTrace(); return null;
		}catch (Exception e) {
		    e.printStackTrace(); return null;
		}  
		
		parametros	= new HashMap();
		parametros.put("SUBREPORT_DIR", ruta);
		parametros.put("SUBREPORT_DIR_LOGO",ruta_logo);
		
		System.out.println("SUBREPORT_DIR_LOGO --> " + ruta_logo);
		
		ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria CASLiquidacion_criteria = new ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria();
		CASLiquidacion_criteria.setC_fte_fto(c_fte_fto);
		CASLiquidacion_criteria.setC_meta(resultado_concatenacion);
		CASLiquidacion_criteria.setInt_anio(anio);
		CASLiquidacion_criteria.setInt_id_periodo_mes(id_periodo);
		CASLiquidacion_criteria.setSrl_id_regimen_contractual(int_regimen);
		
		List listResultCASLiquidacion = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionMapper.class, CASLiquidacion_criteria);
		
		
		
		ReporteResumenNominaPagoFFMP_CASQueryCriteria CAScriteria = new ReporteResumenNominaPagoFFMP_CASQueryCriteria();
		CAScriteria.setC_fte_fto(c_fte_fto);
		CAScriteria.setC_meta(resultado_concatenacion);
		CAScriteria.setInt_anio(anio);
		CAScriteria.setInt_id_periodo_mes(id_periodo);
		CAScriteria.setSrl_id_regimen_contractual(int_regimen);
		
		listResult = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenNominaPagoFFMP_CASQueryMapper.class, CAScriteria);
		
		JRBeanCollectionDataSource listLiquidacion_DS = new JRBeanCollectionDataSource((Collection)listResultCASLiquidacion);
		parametros.put("listLiquidacion_DS", listLiquidacion_DS);
		
		JRBeanCollectionDataSource listApertura_DS = new JRBeanCollectionDataSource((Collection)listResult);
		parametros.put("listApertura_DS", listApertura_DS);
		
		
		return resultado = tipo_reporte;
	}
	
	public String listarResumenGlobalCAS(){
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		String ruta = PropUtil.getInstance().getPropVal("documents.properties", "ruta.subreporte.resumen.general.planilla");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		if(c_meta == null){
			c_meta = "000-600";
		}
		
		String resultado_concatenacion = null;
		try{
		resultado_concatenacion = concatenarMeta(c_meta);
		
		}catch (BusinessException e) {
		    e.printStackTrace(); return null;
		}catch (Exception e) {
		    e.printStackTrace(); return null;
		}  
		
		parametros	= new HashMap();
		parametros.put("SUBREPORT_DIR", ruta);
		
		ReporteResumenGlobalCASQuery_LiquidacionCriteria GlobalCASLiquidacion_criteria = new ReporteResumenGlobalCASQuery_LiquidacionCriteria();
		GlobalCASLiquidacion_criteria.setC_fte_fto(c_fte_fto);
		GlobalCASLiquidacion_criteria.setC_meta(resultado_concatenacion);
		GlobalCASLiquidacion_criteria.setInt_anio(anio);
		GlobalCASLiquidacion_criteria.setInt_id_periodo_mes(id_periodo);
		GlobalCASLiquidacion_criteria.setSrl_id_regimen_contractual(int_regimen);
		
		List listResultGlobalCASLiquidacion = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenGlobalCASQuery_LiquidacionMapper.class, GlobalCASLiquidacion_criteria);
		
		
		
		ReporteResumenGlobalCASQueryCriteria GlobalCAScriteria = new ReporteResumenGlobalCASQueryCriteria();
		GlobalCAScriteria.setC_fte_fto(c_fte_fto);
		GlobalCAScriteria.setC_meta(resultado_concatenacion);
		GlobalCAScriteria.setInt_anio(anio);
		GlobalCAScriteria.setInt_id_periodo_mes(id_periodo);
		GlobalCAScriteria.setSrl_id_regimen_contractual(int_regimen);
		
		listResultGlobalCAS = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenGlobalCASQueryMapper.class, GlobalCAScriteria);
		
		JRBeanCollectionDataSource listLiquidacion_DS = new JRBeanCollectionDataSource((Collection)listResultGlobalCASLiquidacion);
		parametros.put("listLiquidacion_DS", listLiquidacion_DS);
		
		JRBeanCollectionDataSource listApertura_DS = new JRBeanCollectionDataSource((Collection)listResultGlobalCAS);
		parametros.put("listApertura_DS", listApertura_DS);
		
		if(c_meta == "000-600"){
			
			parametros.put("strMeta", "Todos");
		}
		else{
			parametros.put("strMeta", "" + c_meta);
		}

		return resultado = tipo_reporte;
	}
	
	public String listarResumenGlobal728(){
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		String ruta = PropUtil.getInstance().getPropVal("documents.properties", "ruta.subreporte.resumen.general.planilla");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		if(c_meta == null){
			c_meta = "000-600";
		}
		
		String resultado_concatenacion = null;
		try{
		resultado_concatenacion = concatenarMeta(c_meta);
		
		}catch (BusinessException e) {
		    e.printStackTrace(); return null;
		}catch (Exception e) {
		    e.printStackTrace(); return null;
		}  
		
		parametros	= new HashMap();
		parametros.put("SUBREPORT_DIR", ruta);
		
		
		ReporteResumenGlobal728Query_LiquidacionCriteria Global728Liquidacion_criteria = new ReporteResumenGlobal728Query_LiquidacionCriteria();
		Global728Liquidacion_criteria.setC_fte_fto(c_fte_fto);
		Global728Liquidacion_criteria.setC_meta(resultado_concatenacion);
		Global728Liquidacion_criteria.setInt_anio(anio);
		Global728Liquidacion_criteria.setInt_id_periodo_mes(id_periodo);
		Global728Liquidacion_criteria.setSrl_id_regimen_contractual(int_regimen);
		
		List listResultGlobal728Liquidacion = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenGlobal728Query_LiquidacionMapper.class, Global728Liquidacion_criteria);
		
		
		
		ReporteResumenGlobal728QueryCriteria Global728criteria = new ReporteResumenGlobal728QueryCriteria();
		Global728criteria.setC_fte_fto(c_fte_fto);
		Global728criteria.setC_meta(resultado_concatenacion);
		Global728criteria.setInt_anio(anio);
		Global728criteria.setInt_id_periodo_mes(id_periodo);
		Global728criteria.setSrl_id_regimen_contractual(int_regimen);
		
		listResultGlobal728 = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenGlobal728QueryMapper.class, Global728criteria);
		
		JRBeanCollectionDataSource listLiquidacion_DS = new JRBeanCollectionDataSource((Collection)listResultGlobal728Liquidacion);
		parametros.put("listLiquidacion_DS", listLiquidacion_DS);
		
		JRBeanCollectionDataSource listApertura_DS = new JRBeanCollectionDataSource((Collection)listResultGlobal728);
		parametros.put("listApertura_DS", listApertura_DS);
		
		if(c_meta == "000-600"){
			
			parametros.put("strMeta", "Todos");
		}
		else{
			parametros.put("strMeta", "" + c_meta);
		}

		return resultado = tipo_reporte;
	}
	
	public String generarJOR(){
		
		try{
			
			String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
			String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
			String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
			
			Integer int_regimen = null;
			
			if(srl_id_regimen_contractual == null){
				int_regimen = null;
			}else{
				int_regimen = Integer.parseInt(srl_id_regimen_contractual);
				int_regimen.intValue();
			}
			
			int id_periodo = Integer.parseInt(int_id_periodo_mes);
			int anio = Integer.parseInt(int_anio);
			
			RptJORBean rpJORBean = generarJORService.generarJOR(anio, id_periodo,int_regimen);
						
    	    File temp = File.createTempFile("tempfile", ".tmp"); 
 
    	    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    	    bw.write(rpJORBean.getContenido());
    	    bw.close();
    	    
            setFileName(rpJORBean.getNombreArchivo());
            setFileInputStream(new FileInputStream(temp));
			
			
		}catch(BusinessException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String generarREM(){
		
		try{
			
			String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
			String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
			String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
			
			Integer int_regimen = null;
			
			if(srl_id_regimen_contractual == null){
				int_regimen = null;
			}else{
				int_regimen = Integer.parseInt(srl_id_regimen_contractual);
				int_regimen.intValue();
			}
			
			int id_periodo = Integer.parseInt(int_id_periodo_mes);
			int anio = Integer.parseInt(int_anio);
			
			RptREMBean rpREMBean = generarREMService.generarREM(anio, id_periodo,int_regimen);
			
    	    File temp = File.createTempFile("tempfile", ".tmp"); 
 
    	    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    	    bw.write(rpREMBean.getContenido());
    	    bw.close();
    	    
            setFileName(rpREMBean.getNombreArchivo());
            setFileInputStream(new FileInputStream(temp));
			
			
		}catch(BusinessException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String listarProyeccionPlanillaFFMP(){
		
		List<Map<Object, Object>> listDetalle			= null;
		List<Map<Object, Object>> listDetalleTotales	= null;
		List<Map<Object, Object>> listDetalleTotalesFF	= null;
		Map<Object, Object> mapDetalle					= null;
		List<Map<Object, Object>> listTotales           = null;
		
		
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		if(c_meta == null){
			c_meta = "000-600";
		}
		
		//LLAMANDO A LA FUNCION CONCATENAR META
		String resultado_concatenacion = null;
		try{
		resultado_concatenacion = concatenarMeta(c_meta);
//		System.out.println("resultado_concatenacion --> " + resultado_concatenacion);
		}catch (BusinessException e) {
		    e.printStackTrace(); return null;
		}catch (Exception e) {
		    e.printStackTrace(); return null;
		}  
		
				
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		String strMes	= Funciones.nombreMes(id_periodo).toUpperCase();
		
		parametros	= new HashMap();
		parametros.put("strAnio", "" + int_anio);
		parametros.put("strMes", strMes);
		
		//TODO Cambiar por un property
		String ruta = PropUtil.getInstance().getPropVal("documents.properties", "ruta.subreporte.resumen.general.planilla");
		
		parametros.put("SUBREPORT_DIR", ruta);
		
		ConceptoPlanillaPorPeriodoProyeccionQueryCriteria criteriaConcPlanilla = new ConceptoPlanillaPorPeriodoProyeccionQueryCriteria();
		criteriaConcPlanilla.setInt_id_periodo_mes(id_periodo);
		criteriaConcPlanilla.setInt_anio(anio);
		criteriaConcPlanilla.setSrl_id_regimen_contractual(int_regimen);
		
		List<ConceptoPlanillaPorPeriodoProyeccionQuery> listResultConcPlan	= reporteResumenGeneralPlanillaService.getListByQuery(ConceptoPlanillaPorPeriodoProyeccionQueryMapper.class, criteriaConcPlanilla);
		Map<Integer, Integer> mapConcPlanPorPer			= new HashMap<Integer, Integer>();
		int intOrden	= 0;
		listDetalle			= new ArrayList<Map<Object, Object>>();
		listDetalleTotales	= new ArrayList<Map<Object, Object>>();
		
		for(ConceptoPlanillaPorPeriodoProyeccionQuery conceptoBean:listResultConcPlan) {
			//INICIA CABECERAS
			mapConcPlanPorPer.put(conceptoBean.getSrl_id_concepto_planilla(), intOrden);
			intOrden++;
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", conceptoBean.getVar_descrip_concepto());
			listDetalle.add(mapDetalle);
			
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", 0d);
			mapDetalle.put("dblValor", 0d);
			listDetalleTotales.add(mapDetalle);
		}
		{
			//INICIA COLUMNAS FINALES
		
			mapConcPlanPorPer.put(-100, intOrden);
			intOrden++;
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", "NETO");
			listDetalle.add(mapDetalle);
			
			mapDetalle		= new HashMap<Object, Object>();
			mapDetalle.put("strValor", 0d);
			mapDetalle.put("dblValor", 0d);
			listDetalleTotales.add(mapDetalle);
		}
		// CREA UNA LISTA A PARTIR DEL MAP listDetalle, DICHO MAP DEBE SER PARSEADO CON Collection
		JRMapCollectionDataSource listMapDetalleCab_DS = new JRMapCollectionDataSource((Collection)listDetalle);
		parametros.put("listMapDetalleCab_DS", listMapDetalleCab_DS);
		
		ReporteProyeccionPlanillasFFQueryCriteria criteria = new ReporteProyeccionPlanillasFFQueryCriteria();
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setInt_anio(anio);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setC_fte_fto(c_fte_fto);
		criteria.setC_meta(resultado_concatenacion);
		
		criteriaConcPlanilla.setOrderColumn("nombre_completo, srl_id_concepto_planilla");
		
		List<ReporteProyeccionPlanillasFFQuery> listResultTemp = reporteResumenGeneralPlanillaService.getListByQuery(ReporteProyeccionPlanillasFFQueryMapper.class, criteria);
		
		List<ReporteProyeccionPlanillasFFQuery> listArr					= null;
		Map<String, ReporteProyeccionPlanillasFFQuery> mapEmpleado		= null;
		Map<String, List<ReporteProyeccionPlanillasFFQuery>> mapMeta	= new HashMap<String, List<ReporteProyeccionPlanillasFFQuery>>();
		Map<String, Object> map											= new HashMap<String, Object>();
		List<Map<String,Object>> listMapMeta							= new ArrayList<Map<String,Object>>();
		ReporteProyeccionPlanillasFFQuery beanEmpTemp					= null;
		
		Map<String, Object> mapFteFto1									= new HashMap<String, Object>();
		List<Map<String,Object>> listaFuentes	 						= new ArrayList<Map<String,Object>>();
		
		double dblSubTotal												= 0d;
		double dblSubTotal2												= 0d;
		
		try {
			List<ReporteProyeccionPlanillasFFQuery> listDetalleEmpl		= null;
			
			if (c_fte_fto == null){
//				System.out.println("FUENTE --> " + c_fte_fto);
				for(ReporteProyeccionPlanillasFFQuery bean:listResultTemp) {
					
					//ADD 13-08-2015 DAVID
					if(!mapMeta.containsKey(bean.getC_fte_fto().toString() + bean.getC_meta().toString())) {
						
//					if(!mapMeta.containsKey(bean.getC_meta())) {
//						System.out.println("AGREGANDO  --->>>>>  FUENTE --> " + bean.getVar_descripcion_fuente_financiamiento() + " : META --> " + bean.getC_meta());
						listDetalleEmpl			= new ArrayList<ReporteProyeccionPlanillasFFQuery>();
						mapMeta.put(bean.getC_meta(), listDetalleEmpl);

						//ADD 13-08-2015 DAVID
						mapMeta.put((bean.getC_fte_fto().toString() + bean.getC_meta().toString()), listDetalleEmpl);
						map						= new HashMap<String, Object>();
						map.put("c_fte_fto_c_meta",(bean.getC_fte_fto().toString() + bean.getC_meta().toString()));
						map.put("c_meta", bean.getC_meta());
						map.put("c_fte_fto", bean.getC_fte_fto());
						map.put("var_descripcion_fuente_financiamiento", bean.getVar_descripcion_fuente_financiamiento());
						map.put("srl_id_regimen_contractual", bean.getSrl_id_regimen_contractual());
						
						map.put("listDetalleEmpl", listDetalleEmpl);
						map.put("mapEmpleadoMeta", new HashMap<String, ReporteProyeccionPlanillasFFQuery>());
						map.put("listArr", new ArrayList<ReporteProyeccionPlanillasFFQuery>());
						map.put("listDetalleTotales", new ArrayList<Map<String, Object>>());
						listMapMeta.add(map);
					} else {
						
						listDetalleEmpl			= (List)mapMeta.get(bean.getC_meta());	
					}
					
					listDetalleEmpl.add(bean);
				}
			}else{
//				System.out.println("FUENTE --> " + c_fte_fto);
				for(ReporteProyeccionPlanillasFFQuery bean:listResultTemp) {
					if(!mapMeta.containsKey(bean.getC_meta())) {
//						System.out.println("FUENTE --> " + bean.getVar_descripcion_fuente_financiamiento() + " : META --> " + bean.getC_meta());
						listDetalleEmpl			= new ArrayList<ReporteProyeccionPlanillasFFQuery>();
						mapMeta.put(bean.getC_meta(), listDetalleEmpl);
						map						= new HashMap<String, Object>();
						map.put("c_meta", bean.getC_meta());
						map.put("c_fte_fto", bean.getC_fte_fto());
						map.put("var_descripcion_fuente_financiamiento", bean.getVar_descripcion_fuente_financiamiento());
						map.put("srl_id_regimen_contractual", bean.getSrl_id_regimen_contractual());
						
						map.put("listDetalleEmpl", listDetalleEmpl);
						map.put("mapEmpleadoMeta", new HashMap<String, ReporteProyeccionPlanillasFFQuery>());
						map.put("listArr", new ArrayList<ReporteProyeccionPlanillasFFQuery>());
						map.put("listDetalleTotales", new ArrayList<Map<String, Object>>());
						listMapMeta.add(map);
					} else {
						listDetalleEmpl			= (List)mapMeta.get(bean.getC_meta());
					}
					
					listDetalleEmpl.add(bean);
				}
			}

			

			
			
			for(Map<String,Object> currMapMeta:listMapMeta) {
				listDetalleEmpl		= (List)currMapMeta.get("listDetalleEmpl");
				mapEmpleado			= (Map<String, ReporteProyeccionPlanillasFFQuery>)currMapMeta.get("mapEmpleadoMeta");
				listArr				= (List<ReporteProyeccionPlanillasFFQuery>)currMapMeta.get("listArr");
				listDetalleTotales	= (List<Map<Object, Object>>)currMapMeta.get("listDetalleTotales");
				dblSubTotal			= 0d;
				for(ConceptoPlanillaPorPeriodoProyeccionQuery conceptoBean:listResultConcPlan) {
					{
						mapDetalle		= new HashMap<Object, Object>();
						mapDetalle.put("strValor", 0d);
						listDetalleTotales.add(mapDetalle);
					}
				}
				{//Totales NETO
					mapDetalle		= new HashMap<Object, Object>();
					mapDetalle.put("strValor", 0d);
					listDetalleTotales.add(mapDetalle);
					
				}
				for(ReporteProyeccionPlanillasFFQuery bean:listDetalleEmpl) {
					if(!mapEmpleado.containsKey(bean.getNumerodoc())) {
						listDetalle			= new ArrayList<Map<Object, Object>>();
						for(ConceptoPlanillaPorPeriodoProyeccionQuery conceptoBean:listResultConcPlan) {
							//INICIA VALORES
							{//Valores del detalle
								mapDetalle		= new HashMap<Object, Object>();
								mapDetalle.put("strValor", 0d);
								listDetalle.add(mapDetalle);
							}
						}
						{
							//INICIA VALORES COLS FIN
							mapDetalle		= new HashMap<Object, Object>();//"NETO"
							mapDetalle.put("strValor", bean.getNeto_pagar());
							listDetalle.add(mapDetalle);
						}
						{//Totales Neto
							intOrden			= mapConcPlanPorPer.get(-100);
							mapDetalle			= (Map<Object, Object>)listDetalleTotales.get(intOrden);
							dblSubTotal			= (Double)mapDetalle.get("strValor");
							mapDetalle.put("strValor", (dblSubTotal + bean.getNeto_pagar()));
						}
						
						bean.setListDetalle(listDetalle);
						listArr.add(bean);
						mapEmpleado.put(bean.getNumerodoc(), bean);
						
					}
					beanEmpTemp			= (ReporteProyeccionPlanillasFFQuery)mapEmpleado.get(bean.getNumerodoc());
					listDetalle			= beanEmpTemp.getListDetalle();
					{
						intOrden			= mapConcPlanPorPer.get(bean.getSrl_id_concepto_planilla());
						mapDetalle			= (Map<Object, Object>)listDetalle.get(intOrden);
						mapDetalle.put("strValor", bean.getDec_monto_calculado());
					    //dblSubTotal		+= bean.getDec_monto_calculado();
					}
					{//Totales
						intOrden			= mapConcPlanPorPer.get(bean.getSrl_id_concepto_planilla());
						mapDetalle			= (Map<Object, Object>)listDetalleTotales.get(intOrden);
						dblSubTotal			= (Double)mapDetalle.get("strValor");
						mapDetalle.put("strValor", (dblSubTotal + bean.getDec_monto_calculado()));
					}
				}
			}
			
			
			Map<Object,Object> mapDetalleTotales	= null;
			Map<Object,Object> mapDetalleTotalesFF	= null;
			String strFteFto	= "";
			Map<String, List<Map<Object, Object>>> mapFteFto	= new HashMap<String, List<Map<Object, Object>>>();
			for(Map<String,Object> currMapMeta:listMapMeta) {
				listDetalleTotales		= (List<Map<Object, Object>>)currMapMeta.get("listDetalleTotales");
				strFteFto	= (String)currMapMeta.get("c_fte_fto");
				if(!mapFteFto.containsKey(strFteFto)) {
					listDetalleTotalesFF		= new ArrayList<Map<Object, Object>>();
					mapFteFto.put(strFteFto, listDetalleTotalesFF);
					for(int a = 0;a < listDetalleTotales.size();a++) {
						mapDetalleTotalesFF		= new HashMap<Object, Object>();
						mapDetalleTotalesFF.put("strValor", 0d);
						listDetalleTotalesFF.add(mapDetalleTotalesFF);
					}
				}
				for(int i = 0;i < listDetalleTotales.size();i++) {
					mapDetalleTotales	= listDetalleTotales.get(i);
					mapDetalleTotalesFF	= listDetalleTotalesFF.get(i);
					dblSubTotal			= 0d;
					dblSubTotal			= (Double)mapDetalleTotales.get("strValor");
					dblSubTotal			+= (Double)mapDetalleTotalesFF.get("strValor");
					mapDetalleTotalesFF.put("strValor", dblSubTotal);
				}
			}
			
			
			JRMapCollectionDataSource listMapDetalle_DS	= null;
			for(Map<String,Object> currMapMeta:listMapMeta) {
				listDetalleEmpl		= (List)currMapMeta.get("listDetalleEmpl");
				mapEmpleado			= (Map<String, ReporteProyeccionPlanillasFFQuery>)currMapMeta.get("mapEmpleadoMeta");
				listArr				= (List<ReporteProyeccionPlanillasFFQuery>)currMapMeta.get("listArr");
				listDetalleTotales	= (List<Map<Object, Object>>)currMapMeta.get("listDetalleTotales");
				
				strFteFto				= (String)currMapMeta.get("c_fte_fto");
				listDetalleTotalesFF	= mapFteFto.get(strFteFto);
				
				JRBeanCollectionDataSource listBeanDetalle_DS = new JRBeanCollectionDataSource(listArr);
				currMapMeta.put("listMapDetalle_DS", listBeanDetalle_DS);
				
				listMapDetalle_DS		= new JRMapCollectionDataSource((Collection)listDetalleTotales);
				currMapMeta.put("listMapDetalleTotales_DS", listMapDetalle_DS);
				
				listMapDetalle_DS		= new JRMapCollectionDataSource((Collection)listDetalleTotalesFF);
				currMapMeta.put("listMapDetalleTotalesFF_DS", listMapDetalle_DS);
				for(ReporteProyeccionPlanillasFFQuery bean:listDetalleEmpl) {
					listDetalle			= bean.getListDetalle();
					listMapDetalle_DS	= new JRMapCollectionDataSource((Collection)listDetalle);
					bean.setListMapDetalle_DS(listMapDetalle_DS);
					
					
				}
				
				
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		listResult	= listMapMeta;
        return resultado = tipo_reporte;
	}
	
	public String ResumenPlanillaFuenteMeta(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("") ? null : this.getParameter("c_meta");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		
				
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		
		ResumenPlanillaFuenteMetaQueryCriteria criteria = new ResumenPlanillaFuenteMetaQueryCriteria();
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setC_fte_fto(c_fte_fto);
		criteria.setC_meta(c_meta);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);

		
		listResult = reporteResumenGeneralPlanillaService.getListByQuery(ResumenPlanillaFuenteMetaQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
	}
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			ReporteResumenGeneralPlanillaQueryCriteria reporteResumenGeneralPlanillaQueryCriteria = this.loadCriteria(this.getHttpRequest(), ReporteResumenGeneralPlanillaQueryCriteria.class);
			List<ReporteResumenGeneralPlanillaQuery> listReporteResumenGeneralPlanillaQuery = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenGeneralPlanillaQueryMapper.class, reporteResumenGeneralPlanillaQueryCriteria, start, limit);
			int total = reporteResumenGeneralPlanillaService.getCountRowsByQuery(ReporteResumenGeneralPlanillaQueryMapper.class, reporteResumenGeneralPlanillaQueryCriteria);
			
			this.success(listReporteResumenGeneralPlanillaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteResumenGeneralPlanillaService.create(reporteResumenGeneralPlanillaQuery);
			this.success(reporteResumenGeneralPlanillaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteResumenGeneralPlanillaService.save(reporteResumenGeneralPlanillaQuery);
			this.success(reporteResumenGeneralPlanillaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteResumenGeneralPlanillaService.remove(reporteResumenGeneralPlanillaQuery);
			this.extjsReturn.setSuccess(true);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	public String concatenarMeta(String meta){
		
		try{
			
		   String[] arrayMeta = meta.split(",");
	       String Cadena = "";
	       String Concatenado = "";
	          
	      
	    	   
	          for (int i = 0; i < arrayMeta.length; i++) {
	                  
	                  Cadena = arrayMeta[i];
	                  
	                  String[] arrayCadena = Cadena.split("-");
	                  
	                  int numElementos = arrayCadena.length;
	                  
	                 	                	  
	                 
	                  if (numElementos == 1){
	                	  
	                	  
	                		  
	                	 
		                   String  primer_numero = arrayCadena[0];
		                   String  segundo_numero = null;
		                   
		                  if (segundo_numero == null) {
		                       segundo_numero =  arrayCadena[0];
		                   }                   
		                       segundo_numero= arrayCadena[0];
		                   
		                   int int_primer_numero = Integer.parseInt(primer_numero);
		                   int int_segundo_numero = Integer.parseInt(segundo_numero);
		                   
		                   
		                   if(int_primer_numero > int_segundo_numero){
		                           
		                           break;
		                           
		                   }else{
		                                    
		                       for (Integer j = int_primer_numero; j <= int_segundo_numero ; j++) {
		                                                  
		                                           
		                           String str = Integer.toString(j);
		                                          
		                              if(str.length() < 2){
		                                   Concatenado += "'00" + j + "',";
		                              }
		                              else if(str.length() < 3){
		                                   Concatenado += "'0" + j + "',";
		                              }
		                              else{
		                                   Concatenado += "'" + j + "',";
		                              }
		                             
		                        }
                            }
	                	  
	                	 
	                	  
	                  }else {
	                	  
		               
		            	   
		               
	                	   String  primer_numero = arrayCadena[0];
		                   String  segundo_numero = arrayCadena[1];  
	                	  
		                   if (segundo_numero == null) {
		                       segundo_numero =  arrayCadena[0];
		                   }                   
		                       segundo_numero= arrayCadena[1];
		                   
		                   int int_primer_numero = Integer.parseInt(primer_numero);
		                   int int_segundo_numero = Integer.parseInt(segundo_numero);
		                   
		                   
		                   if(int_primer_numero > int_segundo_numero){
		                           break;
		                   }else{
		                                    
		                         for (Integer j = int_primer_numero; j <= int_segundo_numero ; j++) {
		                              
		                        	 String str = Integer.toString(j);
		                             
		                             if(str.length() < 2){
		                                  Concatenado += "'00" + j + "',";
		                             }
		                             else if(str.length() < 3){
		                                  Concatenado += "'0" + j + "',";
		                             }
		                             else{
		                                  Concatenado += "'" + j + "',";
		                             }
		                             
		                             
		                  }
		             }
		                   
		                   
		                   
	       }// end else
	                 
	  }
	      
	  Integer cantidad_caracteres = Concatenado.length();
	  String concatenacion_meta = Concatenado.substring(0, cantidad_caracteres - 1);
//	  System.out.println("concatenacion_meta: " + concatenacion_meta); 
	  
	  return concatenacion_meta;
	  
	
			
	  }catch (ArrayIndexOutOfBoundsException e) {
           	e.printStackTrace();
           	String concatenacion_meta = null;
			
			return concatenacion_meta;
		           		
	  }catch (StringIndexOutOfBoundsException e) {
		  	e.printStackTrace();
		  	String concatenacion_meta = null;
			
			return concatenacion_meta;
	  }catch (BusinessException e) {
		    e.printStackTrace();
		    String concatenacion_meta = null;
			
			return concatenacion_meta;
		    
	  }
		
		
		
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public ReporteResumenGeneralPlanillaService getReporteResumenGeneralPlanillaService() {
		return reporteResumenGeneralPlanillaService;
	}

	public void setReporteResumenGeneralPlanillaService(ReporteResumenGeneralPlanillaService reporteResumenGeneralPlanillaService) {
		this.reporteResumenGeneralPlanillaService = reporteResumenGeneralPlanillaService;
	}

	public ReporteResumenGeneralPlanillaQuery getReporteResumenGeneralPlanillaQuery() {
		return reporteResumenGeneralPlanillaQuery;
	}

	public void setReporteResumenGeneralPlanillaQuery(ReporteResumenGeneralPlanillaQuery reporteResumenGeneralPlanillaQuery) {
		this.reporteResumenGeneralPlanillaQuery = reporteResumenGeneralPlanillaQuery;
	}
	
	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	

	public Map getParametros() {
		return parametros;
	}
	

	public void setParametros(Map parametros) {
		this.parametros = parametros;
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

	@SuppressWarnings("rawtypes")
	public List getListResultGlobalCAS() {
		return listResultGlobalCAS;
	}

	@SuppressWarnings("rawtypes")
	public void setListResultGlobalCAS(List listResultGlobalCAS) {
		this.listResultGlobalCAS = listResultGlobalCAS;
	}

	@SuppressWarnings("rawtypes")
	public List getListResultGlobal728() {
		return listResultGlobal728;
	}

	@SuppressWarnings("rawtypes")
	public void setListResultGlobal728(List listResultGlobal728) {
		this.listResultGlobal728 = listResultGlobal728;
	}


}
