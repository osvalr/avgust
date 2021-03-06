/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by GeneratorCrud v.1.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   11/03/2016 01:37:11
*/

package pe.com.acme.inavi.ws.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.dto.CambiarPrecioDto;
import pe.com.acme.inavi.business.service.GestionarGuiaService;
import pe.com.acme.inavi.business.util.InaviBusinessUtil;
import pe.com.acme.inavi.business.util.InaviConstantes;
import pe.com.acme.inavi.ws.bean.GuiaTotales;
import pe.com.acme.query.mybatis.mapper.GuiaPesoQueryMapper;
import pe.com.acme.query.mybatis.mapper.GuiaQueryMapper;
import pe.com.acme.query.mybatis.mapper.GuiaSaldoQueryMapper;
import pe.com.acme.query.mybatis.model.GuiaPesoQuery;
import pe.com.acme.query.mybatis.model.GuiaQuery;
import pe.com.acme.query.mybatis.model.GuiaQueryCriteria;
import pe.com.acme.query.mybatis.model.GuiaSaldoQuery;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.ModelWrapper;
import pe.com.acme.util.web.ControllerHelper;

@Controller
@RequestMapping("/GestionarGuia")
public class GestionarGuiaController extends ControllerHelper{

    private static Logger log = Logger.getLogger(GestionarGuiaController.class);

	@Autowired
	private GestionarGuiaService gestionarGuiaService;
	
	@RequestMapping(value="/list")
	public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
		try{
			GuiaQueryCriteria guiaQueryCriteria = this.loadCriteria(request, GuiaQueryCriteria.class);
            List<GuiaQuery> listGuiaQuery = gestionarGuiaService.list(guiaQueryCriteria);
			int count = gestionarGuiaService.countRecords(guiaQueryCriteria);
			return JsonReturnUtil.success(listGuiaQuery,count);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/create")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<GuiaQuery> modelWrapper, HttpSession session) {
		try{
		
            List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
            modelWrapper.getData().setListGuiaPesoQuery(listGuiaPesoQuery);
            gestionarGuiaService.create(modelWrapper.getData());
            session.setAttribute("listGuiaPesoQuery",null);
            return JsonReturnUtil.success(modelWrapper.getData().getId_guia());

		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<GuiaQuery> modelWrapper, HttpSession session) throws Exception {
		try{
			List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
            modelWrapper.getData().setListGuiaPesoQuery(listGuiaPesoQuery);
			gestionarGuiaService.update(modelWrapper.getData());
			session.setAttribute("listGuiaPesoQuery",null);
			return JsonReturnUtil.success();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/destroy")
	public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<GuiaQuery> modelWrapper, HttpSession session) {
		try{
			Map<String, Object> paramMap = null;
			paramMap = this.getParamMap();
			paramMap.put("id_guia", modelWrapper.getData().getId_guia());
			List<GuiaPesoQuery> listGuiaPesoQuery = this.gestionarGuiaService.selectByQuery(GuiaPesoQueryMapper.class, paramMap);
			modelWrapper.getData().setListGuiaPesoQuery(listGuiaPesoQuery);
			gestionarGuiaService.destroy(modelWrapper.getData());
			session.setAttribute("listGuiaPesoQuery",null);
			return JsonReturnUtil.success();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/listGuiaPesoQuery")
	public @ResponseBody Map<String,? extends Object> listGuiaPesoQuery(Integer id_guia, int start, int limit, HttpSession session) throws Exception {
		try{
		
			List<GuiaPesoQuery> listGuiaPesoQuery;
			List<GuiaPesoQuery> subListGuiaPesoQuery;
	
			if(id_guia == null){
				listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
			}else if(id_guia.equals(-1)){
				listGuiaPesoQuery = new ArrayList<GuiaPesoQuery>();
			}else{
				Map<String, Object> paramMap = this.getParamMap();
				paramMap.put("id_guia", id_guia);
				listGuiaPesoQuery = this.gestionarGuiaService.selectByQuery(GuiaPesoQueryMapper.class, paramMap);
				this.setRandomId(listGuiaPesoQuery);
			}
	
			if(listGuiaPesoQuery == null){
				listGuiaPesoQuery = new ArrayList<GuiaPesoQuery>();
			}
			session.setAttribute("listGuiaPesoQuery",listGuiaPesoQuery);
			int size = listGuiaPesoQuery.size();
			subListGuiaPesoQuery = (List<GuiaPesoQuery>) this.getSubList(listGuiaPesoQuery, start, limit);
			return JsonReturnUtil.success(subListGuiaPesoQuery,size);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/createGuiaPesoQuery")
	public @ResponseBody Map<String,? extends Object> createGuiaPesoQuery(@RequestBody ModelWrapper<GuiaPesoQuery> modelWrapper, HttpSession session) {
		try{
		
			
			if(modelWrapper.getData().getId_tipo_peso().intValue() != InaviConstantes.TIPO_PESO_BRUTO){
				modelWrapper.getData().setFlag_devolucion(null);
			}
			
			List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
			int randomInt = this.getNegativeIdRandom();
			modelWrapper.getData().setRownum(randomInt);
			modelWrapper.getData().setId_guia_peso(randomInt);
			modelWrapper.getData().setNewEntry(true);
			if(listGuiaPesoQuery == null){
				listGuiaPesoQuery = new ArrayList<GuiaPesoQuery>();
			}
			listGuiaPesoQuery.add(modelWrapper.getData());
	
			return JsonReturnUtil.success();

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updateGuiaPesoQuery")
	public @ResponseBody Map<String,? extends Object> updateGuiaPesoQuery(@RequestBody ModelWrapper<GuiaPesoQuery> modelWrapper, HttpSession session) {
		try{
			
			if(modelWrapper.getData().getId_tipo_peso().intValue() != InaviConstantes.TIPO_PESO_BRUTO){
				modelWrapper.getData().setFlag_devolucion(null);
			}
		
			List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
			GuiaPesoQuery guiaPesoQuery = (GuiaPesoQuery) this.find(listGuiaPesoQuery, modelWrapper.getData());
			
			if(guiaPesoQuery.getRownum().intValue() > 0){
				modelWrapper.getData().setUpdatedRecord(true);
				modelWrapper.getData().setNewEntry(false);
				modelWrapper.getData().setRemovedRecord(false);
			}else{
				modelWrapper.getData().setNewEntry(true);
				modelWrapper.getData().setUpdatedRecord(false);
				modelWrapper.getData().setRemovedRecord(false);
			}
			
			if(guiaPesoQuery != null){
	        	listGuiaPesoQuery.set(listGuiaPesoQuery.indexOf(guiaPesoQuery), modelWrapper.getData());
			}
			return JsonReturnUtil.success();

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/destroyGuiaPesoQuery")
	public @ResponseBody Map<String,? extends Object> destroyGuiaPesoQuery(@RequestBody ModelWrapper<GuiaPesoQuery> modelWrapper, HttpSession session) {
		try{
		
			List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
			GuiaPesoQuery guiaPesoQuery = (GuiaPesoQuery) this.find(listGuiaPesoQuery, modelWrapper.getData());
			modelWrapper.getData().setRemovedRecord(true);
			if(guiaPesoQuery != null){
			
				if(guiaPesoQuery.getRownum().intValue() > 0){
					listGuiaPesoQuery.set(listGuiaPesoQuery.indexOf(guiaPesoQuery), modelWrapper.getData());
				}else{
					listGuiaPesoQuery.remove(listGuiaPesoQuery.indexOf(guiaPesoQuery));
				}
				
			}		
	        return JsonReturnUtil.success();
	        
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/listGuiaSaldoQuery")
	public @ResponseBody Map<String,? extends Object> listGuiaSaldoQuery(Integer id_guia, int start, int limit, HttpSession session) throws Exception {
		try{
		
			List<GuiaSaldoQuery> listGuiaSaldoQuery;
			List<GuiaSaldoQuery> subListGuiaSaldoQuery;
	
			if(id_guia == null){
				listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
			}else if(id_guia.equals(-1)){
				listGuiaSaldoQuery = new ArrayList<GuiaSaldoQuery>();
			}else{
				
				Map<String, Object> paramMap = this.getParamMap();
				paramMap.put("id_guia", id_guia);
				listGuiaSaldoQuery = this.gestionarGuiaService.selectByQuery(GuiaSaldoQueryMapper.class, paramMap);
				this.setRandomId(listGuiaSaldoQuery);
							
			}
	
			if(listGuiaSaldoQuery == null){
				listGuiaSaldoQuery = new ArrayList<GuiaSaldoQuery>();
			}
			session.setAttribute("listGuiaSaldoQuery",listGuiaSaldoQuery);
			int size = listGuiaSaldoQuery.size();
			subListGuiaSaldoQuery = (List<GuiaSaldoQuery>) this.getSubList(listGuiaSaldoQuery, start, limit);
			return JsonReturnUtil.success(subListGuiaSaldoQuery,size);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
	
	public double getTotalAmortizado(List<GuiaSaldoQuery> list, int num){
		double total = 0;
		
		for(GuiaSaldoQuery guiaSaldoQuery : list){
			if(guiaSaldoQuery.getRownum().intValue() != num && guiaSaldoQuery.isRemovedRecord() == false){
				total = total + guiaSaldoQuery.getMonto_amortizado().doubleValue();
			}
		}
		
		return total;
	}
	
	public double getTotalImporte(List<GuiaPesoQuery> listGuiaPesoQuery) {

		double total_peso_bruto = 0;
		double total_peso_tara = 0;
		double total_peso_devolucion = 0;
		double total_peso_neto = 0;

		total_peso_bruto = this.getTotalPorTipoPeso(InaviConstantes.TIPO_PESO_BRUTO, listGuiaPesoQuery);
		total_peso_tara = this.getTotalPorTipoPeso(InaviConstantes.TIPO_PESO_TARA, listGuiaPesoQuery);
		total_peso_devolucion = this.getTotalPorTipoPeso(InaviConstantes.TIPO_PESO_DEVOLUCION, listGuiaPesoQuery);

		total_peso_neto = total_peso_bruto - (total_peso_tara + total_peso_devolucion);

		return total_peso_neto;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getDeudaPendiente")
	public @ResponseBody Map<String,? extends Object> getDeudaPendiente(HttpSession session){
		
		double total_amortizado = 0;
		double total_pendiente = 0;
		
		List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
		double total_importe = this.getTotalImporte(listGuiaPesoQuery);
		
		List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
		
		for(GuiaSaldoQuery guiaSaldoQuery : listGuiaSaldoQuery){
			if(guiaSaldoQuery.isRemovedRecord() == false){
				total_amortizado = total_amortizado + guiaSaldoQuery.getMonto_amortizado().doubleValue();
			}
		}
		
		total_pendiente = total_importe - total_amortizado;
		
		Map<String, Object> map = new HashMap<>();
		map.put("total_pendiente", total_pendiente);
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/guiaTotales")
	public @ResponseBody Map<String,? extends Object> guiaTotales(HttpSession session) throws Exception {
		try{
		
			List<GuiaPesoQuery> listGuiaPesoQuery = (List<GuiaPesoQuery>) session.getAttribute("listGuiaPesoQuery");
			
			double total_peso_bruto = 0;
			double total_peso_tara = 0;
			double total_peso_devolucion = 0;
			double total_peso_tara_devo = 0;
			double total_peso_neto = 0;
			int total_jabas_bruto = 0;
			int total_jabas_tara = 0;
			int diff_jabas = 0;
			String taraCompleta = null;
			
			if(listGuiaPesoQuery != null){
				
				total_peso_bruto = this.getTotalPorTipoPeso(InaviConstantes.TIPO_PESO_BRUTO, listGuiaPesoQuery);
				total_peso_tara = this.getTotalPorTipoPeso(InaviConstantes.TIPO_PESO_TARA, listGuiaPesoQuery);
				total_peso_devolucion = this.getTotalPorTipoPeso(InaviConstantes.TIPO_PESO_DEVOLUCION, listGuiaPesoQuery);
				
				total_peso_tara_devo = total_peso_tara + total_peso_devolucion;
				
				total_peso_neto = total_peso_bruto - (total_peso_tara + total_peso_devolucion);
				
				//
				total_jabas_bruto = this.getTotalJabasPorTipoPeso(InaviConstantes.TIPO_PESO_BRUTO, listGuiaPesoQuery);
				total_jabas_tara = this.getTotalJabasPorTipoPeso(InaviConstantes.TIPO_PESO_TARA, listGuiaPesoQuery);
				
				diff_jabas = total_jabas_bruto - total_jabas_tara;
				
				if(diff_jabas == 0){
					taraCompleta = "Si";
				}else{
					taraCompleta = "No";
				}
				
				total_peso_neto = InaviBusinessUtil.round(total_peso_neto, 2);
				
			}

			GuiaTotales guia = new GuiaTotales();
			
			guia.setTotal_peso_bruto(total_peso_bruto);
			guia.setTotal_peso_tara(total_peso_tara);
			guia.setTotal_peso_devolucion(total_peso_devolucion);
			guia.setTotal_peso_tara_devo(total_peso_tara_devo);
			guia.setTotal_peso_neto(total_peso_neto);
			guia.setTaraCompleta(taraCompleta);
			
			return JsonReturnUtil.returnRecord(guia);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
	
    public double getTotalPorTipoPeso(int tipoPeso, List<GuiaPesoQuery> list){
    	
    	double total = 0;
    	
		for (GuiaPesoQuery guiaPesoQuery : list) {
			if(guiaPesoQuery.getId_tipo_peso().intValue() == tipoPeso && !guiaPesoQuery.isRemovedRecord()){
				total = total + guiaPesoQuery.getPeso_obtenido().doubleValue();
			}
		}
		
		total = InaviBusinessUtil.round(total, 2);
		
		return total;
    }
    
    public int getTotalJabasPorTipoPeso(int tipoPeso, List<GuiaPesoQuery> list){
    	
    	int total = 0;
    	
		for (GuiaPesoQuery guiaPesoQuery : list) {
			if(guiaPesoQuery.getId_tipo_peso().intValue() == tipoPeso && !guiaPesoQuery.isRemovedRecord()){
				if(guiaPesoQuery.getNum_jabas() == null){
					total = total + 0;
				}else{
					total = total + guiaPesoQuery.getNum_jabas().intValue();
				}
				
			}
		}
				
		return total;
    }
    
	@RequestMapping(value="/cambiarPrecioList")
	public @ResponseBody Map<String,? extends Object> cambiarPrecioList(String fecha_jornada, Double valor, int start, int limit) throws Exception {
		try{
			
				String[] fecha = fecha_jornada.split("/");
				
				GuiaQueryCriteria guiaQueryCriteria = new GuiaQueryCriteria();
				guiaQueryCriteria.setNum_anio(Integer.parseInt(fecha[2]));
				guiaQueryCriteria.setNum_mes(Integer.parseInt(fecha[1]));
				guiaQueryCriteria.setNum_dia(Integer.parseInt(fecha[0]));
				
	            List<GuiaQuery> listGuiaQuery = this.gestionarGuiaService.selectByQuery(GuiaQueryMapper.class, guiaQueryCriteria,start,limit);
	            int count = this.gestionarGuiaService.selectCountByQuery(GuiaQueryMapper.class, guiaQueryCriteria);
				
				List<CambiarPrecioDto> cambiarPrecioDtos = new ArrayList<>();
				
				for (GuiaQuery guiaQuery : listGuiaQuery) {
					
					CambiarPrecioDto cambiarPrecioDto = new CambiarPrecioDto();
					cambiarPrecioDto.setId_guia(guiaQuery.getId_guia());
					cambiarPrecioDto.setNombreCliente(guiaQuery.getNombre_cliente());
					cambiarPrecioDto.setPrecioActual(guiaQuery.getPrecio_aplicado());
					cambiarPrecioDto.setNuevoPrecio(InaviBusinessUtil.round(guiaQuery.getPrecio_aplicado().doubleValue() + valor.doubleValue(), 2));
					cambiarPrecioDto.setPesoNeto(guiaQuery.getTotal_peso_neto());
					cambiarPrecioDto.setNuevoImporte(InaviBusinessUtil.round(guiaQuery.getTotal_peso_neto().doubleValue() * cambiarPrecioDto.getNuevoPrecio().doubleValue(), 2));
					cambiarPrecioDto.setImporteActual(guiaQuery.getTotal_importe());
					
					cambiarPrecioDtos.add(cambiarPrecioDto);
					
				}
				
				return JsonReturnUtil.success(cambiarPrecioDtos,count);
				
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
		
		@RequestMapping(value="/grabarCambioPrecio")
		public @ResponseBody Map<String,? extends Object> grabarCambioPrecio(String fecha_jornada, Double valor, HttpSession session) throws Exception {
			try{
				
				this.gestionarGuiaService.grabarCambioPrecio(fecha_jornada, valor);
				session.removeAttribute("cambiarPrecioDtos");
				
				return JsonReturnUtil.success();
					
			} catch (Exception e) {
				log.error(e.getMessage(),e);
				return JsonReturnUtil.exception(e.getMessage());
			}
		
	}
}