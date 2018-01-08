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
* @since   17/03/2016 17:34:43
*/

package pe.com.acme.inavi.ws.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

import pe.com.acme.dto.InfoGuiaDeudaDto;
import pe.com.acme.inavi.business.service.GestionarSaldoService;
import pe.com.acme.inavi.business.util.InaviConstantes;
import pe.com.acme.query.mybatis.mapper.CuentaXCobrarQueryMapper;
import pe.com.acme.query.mybatis.mapper.GuiaQueryMapper;
import pe.com.acme.query.mybatis.mapper.GuiaSaldoQueryMapper;
import pe.com.acme.query.mybatis.mapper.SaldoPorGuiaQueryMapper;
import pe.com.acme.query.mybatis.model.CuentaXCobrarQuery;
import pe.com.acme.query.mybatis.model.CuentaXCobrarQueryCriteria;
import pe.com.acme.query.mybatis.model.GuiaQuery;
import pe.com.acme.query.mybatis.model.GuiaQueryCriteria;
import pe.com.acme.query.mybatis.model.GuiaSaldoQuery;
import pe.com.acme.query.mybatis.model.SaldoPorGuiaQuery;
import pe.com.acme.query.mybatis.model.SaldoPorGuiaQueryCriteria;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.ModelWrapper;
import pe.com.acme.util.web.ControllerHelper;

@Controller
@RequestMapping("/GestionarSaldo")
public class GestionarSaldoController extends ControllerHelper{

    private static Logger log = Logger.getLogger(GestionarSaldoController.class);

	@Autowired
	private GestionarSaldoService gestionarSaldoService;

	@RequestMapping(value="/list")
	public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
		try{
			SaldoPorGuiaQueryCriteria saldoPorGuiaQueryCriteria = this.loadCriteria(request, SaldoPorGuiaQueryCriteria.class);
            List<SaldoPorGuiaQuery> listSaldoPorGuiaQuery = gestionarSaldoService.list(saldoPorGuiaQueryCriteria);
			int count = gestionarSaldoService.countRecords(saldoPorGuiaQueryCriteria);
			return JsonReturnUtil.success(listSaldoPorGuiaQuery,count);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/create")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<SaldoPorGuiaQuery> modelWrapper, HttpSession session) {
		try{
		
            List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
            modelWrapper.getData().setListGuiaSaldoQuery(listGuiaSaldoQuery);
            gestionarSaldoService.create(modelWrapper.getData());
            session.setAttribute("listGuiaSaldoQuery",null);
            return JsonReturnUtil.success(modelWrapper.getData().getId_guia());

		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<SaldoPorGuiaQuery> modelWrapper, HttpSession session) throws Exception {
		try{
			List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
            modelWrapper.getData().setListGuiaSaldoQuery(listGuiaSaldoQuery);
                        
			gestionarSaldoService.update(modelWrapper.getData());
			session.setAttribute("listGuiaSaldoQuery",null);
			return JsonReturnUtil.success();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/destroy")
	public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<SaldoPorGuiaQuery> modelWrapper, HttpSession session) {
		try{
			Map<String, Object> paramMap = null;
			paramMap = this.getParamMap();
			paramMap.put("id_guia", modelWrapper.getData().getId_guia());
			List<GuiaSaldoQuery> listGuiaSaldoQuery = this.gestionarSaldoService.selectByQuery(GuiaSaldoQueryMapper.class, paramMap);
			modelWrapper.getData().setListGuiaSaldoQuery(listGuiaSaldoQuery);
			gestionarSaldoService.destroy(modelWrapper.getData());
			session.setAttribute("listGuiaSaldoQuery",null);
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
				listGuiaSaldoQuery = this.gestionarSaldoService.selectByQuery(GuiaSaldoQueryMapper.class, paramMap);
				this.setRandomId(listGuiaSaldoQuery);
				
				SaldoPorGuiaQuery saldoPorGuiaQuery = gestionarSaldoService.selectOneByQuery(SaldoPorGuiaQueryMapper.class, paramMap);
				double total_importe = saldoPorGuiaQuery.getTotal_importe();
				session.setAttribute("total_importe",total_importe);
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/createGuiaSaldoQuery")
	public @ResponseBody Map<String,? extends Object> createGuiaSaldoQuery(@RequestBody ModelWrapper<GuiaSaldoQuery> modelWrapper, HttpSession session) {
		try{
		
			List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
			int randomInt = this.getNegativeIdRandom();
			modelWrapper.getData().setRownum(randomInt);
			modelWrapper.getData().setId_guia_saldo(randomInt);
			modelWrapper.getData().setNewEntry(true);
			if(listGuiaSaldoQuery == null){
				listGuiaSaldoQuery = new ArrayList<GuiaSaldoQuery>();
			}
			
			double total_importe = (Double) session.getAttribute("total_importe");
			
			double total_amortizado = this.getTotalAmortizado(listGuiaSaldoQuery, 0);
			
			if((total_importe - total_amortizado) == 0){
				throw new Exception("La guia ya fue saldada.");
			}
			
			double monto = modelWrapper.getData().getMonto_amortizado();
			
			if((total_importe - (total_amortizado + monto)) < 0){
				throw new Exception("La suma del total amortizado más el monto enviado supera el importe total de la guia.");
			}
			
			listGuiaSaldoQuery.add(modelWrapper.getData());
	
			return JsonReturnUtil.success();

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updateGuiaSaldoQuery")
	public @ResponseBody Map<String,? extends Object> updateGuiaSaldoQuery(@RequestBody ModelWrapper<GuiaSaldoQuery> modelWrapper, HttpSession session) {
		try{
		
			List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
			GuiaSaldoQuery guiaSaldoQuery = (GuiaSaldoQuery) this.find(listGuiaSaldoQuery, modelWrapper.getData());
			
			if(guiaSaldoQuery.getRownum().intValue() > 0){
				modelWrapper.getData().setUpdatedRecord(true);
				modelWrapper.getData().setNewEntry(false);
				modelWrapper.getData().setRemovedRecord(false);
			}else{
				modelWrapper.getData().setNewEntry(true);
				modelWrapper.getData().setUpdatedRecord(false);
				modelWrapper.getData().setRemovedRecord(false);
			}
			
			if(guiaSaldoQuery != null){
				
				double total_importe = (Double) session.getAttribute("total_importe");
				
				double total_amortizado = this.getTotalAmortizado(listGuiaSaldoQuery, modelWrapper.getData().getRownum());
				
				if((total_importe - total_amortizado) == 0){
					throw new Exception("La guia ya fue saldada.");
				}
				
				double monto = modelWrapper.getData().getMonto_amortizado();
				
				if((total_importe - (total_amortizado + monto)) < 0){
					throw new Exception("La suma del total amortizado más el monto enviado supera el importe total de la guia.");
				}
				
	        	listGuiaSaldoQuery.set(listGuiaSaldoQuery.indexOf(guiaSaldoQuery), modelWrapper.getData());
			}
			return JsonReturnUtil.success();

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/destroyGuiaSaldoQuery")
	public @ResponseBody Map<String,? extends Object> destroyGuiaSaldoQuery(@RequestBody ModelWrapper<GuiaSaldoQuery> modelWrapper, HttpSession session) {
		try{
		
			List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
			GuiaSaldoQuery guiaSaldoQuery = (GuiaSaldoQuery) this.find(listGuiaSaldoQuery, modelWrapper.getData());
			modelWrapper.getData().setRemovedRecord(true);
			if(guiaSaldoQuery != null){
			
				if(guiaSaldoQuery.getRownum().intValue() > 0){
					listGuiaSaldoQuery.set(listGuiaSaldoQuery.indexOf(guiaSaldoQuery), modelWrapper.getData());
				}else{
					listGuiaSaldoQuery.remove(listGuiaSaldoQuery.indexOf(guiaSaldoQuery));
				}
				
			}		
	        return JsonReturnUtil.success();
	        
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getDeudaPendiente")
	public @ResponseBody Map<String,? extends Object> getDeudaPendiente(HttpSession session){
		
		double total_amortizado = 0;
		double total_pendiente = 0;
		
		double total_importe = (Double) session.getAttribute("total_importe");
		List<GuiaSaldoQuery> listGuiaSaldoQuery = (List<GuiaSaldoQuery>) session.getAttribute("listGuiaSaldoQuery");
		
		for(GuiaSaldoQuery guiaSaldoQuery : listGuiaSaldoQuery){
			if(guiaSaldoQuery.isRemovedRecord() == false){
				total_amortizado = total_amortizado + guiaSaldoQuery.getMonto_amortizado().doubleValue();
			}
		}
		
		total_pendiente = total_importe - total_amortizado;
		
		BigDecimal value = new BigDecimal(total_pendiente);
		value = value.setScale(2, RoundingMode.HALF_UP);
		total_pendiente = value.doubleValue();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total_pendiente", total_pendiente);
		
		return map;
	}
	
	@RequestMapping(value="/listGuiaDeuda")
	public @ResponseBody Map<String,? extends Object> listGuiaDeuda(Integer id_cliente) {
		try{
			
			GuiaQueryCriteria guiaQueryCriteria = new GuiaQueryCriteria();
			guiaQueryCriteria.setId_cliente(id_cliente);
			guiaQueryCriteria.setId_estado(InaviConstantes.ESTADO_GUIA_VENTA_POR_SALDAR);
			
            List<GuiaQuery> listGuiaQuery = gestionarSaldoService.selectByQuery(GuiaQueryMapper.class,guiaQueryCriteria);
			int count = gestionarSaldoService.selectCountByQuery(GuiaQueryMapper.class,guiaQueryCriteria);
			
			CuentaXCobrarQueryCriteria cuentaXCobrarQueryCriteria = new CuentaXCobrarQueryCriteria();
			cuentaXCobrarQueryCriteria.setId_cliente(id_cliente);
			cuentaXCobrarQueryCriteria.setId_estado(InaviConstantes.ESTADO_GUIA_VENTA_POR_SALDAR);
			
			List<CuentaXCobrarQuery> cuentaXCobrarQueries = gestionarSaldoService.selectByQuery(CuentaXCobrarQueryMapper.class,cuentaXCobrarQueryCriteria);
			int count2 = gestionarSaldoService.selectCountByQuery(CuentaXCobrarQueryMapper.class,cuentaXCobrarQueryCriteria);
			
			List<InfoGuiaDeudaDto> list = new ArrayList<>();
			
			for (CuentaXCobrarQuery cuentaXCobrarQuery : cuentaXCobrarQueries) {
				
				InfoGuiaDeudaDto infoGuiaDeudaDto = new InfoGuiaDeudaDto();
				infoGuiaDeudaDto.setDescrip(cuentaXCobrarQuery.getDescrip_glosa());
				infoGuiaDeudaDto.setImporte(cuentaXCobrarQuery.getMonto_deuda());
				infoGuiaDeudaDto.setAmortizado(cuentaXCobrarQuery.getTotal_amortizado());
				infoGuiaDeudaDto.setDeuda(cuentaXCobrarQuery.getTotal_deuda());
				
				list.add(infoGuiaDeudaDto);
				
			}
			
			for (GuiaQuery guiaQuery : listGuiaQuery) {
				
				InfoGuiaDeudaDto infoGuiaDeudaDto = new InfoGuiaDeudaDto();
				infoGuiaDeudaDto.setDescrip(guiaQuery.getFecha_jornada());
				infoGuiaDeudaDto.setImporte(guiaQuery.getTotal_importe());
				infoGuiaDeudaDto.setAmortizado(guiaQuery.getTotal_amortizado());
				infoGuiaDeudaDto.setDeuda(guiaQuery.getTotal_deuda());
				
				list.add(infoGuiaDeudaDto);
				
			}
			
			return JsonReturnUtil.success(list,(count+count2));
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/grabarImporteAmortizado")
	public @ResponseBody Map<String,? extends Object> grabarImporteAmortizado(String fecha_pago, Integer id_cliente, Double montoAmortizado) {
		try{
			
			gestionarSaldoService.grabarSaldoAmortizado(fecha_pago, id_cliente, montoAmortizado);
			
			return JsonReturnUtil.success();
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
}