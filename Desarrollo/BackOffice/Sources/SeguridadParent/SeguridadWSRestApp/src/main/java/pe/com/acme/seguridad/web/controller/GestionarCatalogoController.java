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
* @since   25/02/2016 20:09:25
*/

package pe.com.acme.seguridad.web.controller;

import java.util.ArrayList;
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

import pe.com.acme.util.web.ControllerHelper;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.ModelWrapper;

import pe.com.acme.seguridad.business.service.GestionarCatalogoService;
import pe.com.acme.query.mybatis.model.CatalogoQuery;
import pe.com.acme.query.mybatis.model.CatalogoQueryCriteria;

import pe.com.acme.query.mybatis.model.CatalogoItemQuery;
import pe.com.acme.query.mybatis.mapper.CatalogoItemQueryMapper;

@Controller
@RequestMapping("/GestionarCatalogo")
public class GestionarCatalogoController extends ControllerHelper{

    private static Logger log = Logger.getLogger(GestionarCatalogoController.class);

	@Autowired
	private GestionarCatalogoService gestionarCatalogoService;

	@RequestMapping(value="/list")
	public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
		try{
			CatalogoQueryCriteria catalogoQueryCriteria = this.loadCriteria(request, CatalogoQueryCriteria.class);
            List<CatalogoQuery> listCatalogoQuery = gestionarCatalogoService.list(catalogoQueryCriteria);
			int count = gestionarCatalogoService.countRecords(catalogoQueryCriteria);
			return JsonReturnUtil.success(listCatalogoQuery,count);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/create")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<CatalogoQuery> modelWrapper, HttpSession session) {
		try{
		
            List<CatalogoItemQuery> listCatalogoItemQuery = (List<CatalogoItemQuery>) session.getAttribute("listCatalogoItemQuery");
            modelWrapper.getData().setListCatalogoItemQuery(listCatalogoItemQuery);
            gestionarCatalogoService.create(modelWrapper.getData());
            session.setAttribute("listCatalogoItemQuery",null);
            return JsonReturnUtil.success(modelWrapper.getData().getId_catalogo());

		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<CatalogoQuery> modelWrapper, HttpSession session) throws Exception {
		try{
			List<CatalogoItemQuery> listCatalogoItemQuery = (List<CatalogoItemQuery>) session.getAttribute("listCatalogoItemQuery");
            modelWrapper.getData().setListCatalogoItemQuery(listCatalogoItemQuery);
                        
			gestionarCatalogoService.update(modelWrapper.getData());
			session.setAttribute("listCatalogoItemQuery",null);
			return JsonReturnUtil.success();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/destroy")
	public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<CatalogoQuery> modelWrapper, HttpSession session) {
		try{
			Map<String, Object> paramMap = null;
			paramMap = this.getParamMap();
			paramMap.put("id_catalogo", modelWrapper.getData().getId_catalogo());
			List<CatalogoItemQuery> listCatalogoItemQuery = this.gestionarCatalogoService.selectByQuery(CatalogoItemQueryMapper.class, paramMap);
			modelWrapper.getData().setListCatalogoItemQuery(listCatalogoItemQuery);
			gestionarCatalogoService.destroy(modelWrapper.getData());
			session.setAttribute("listCatalogoItemQuery",null);
			return JsonReturnUtil.success();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/listCatalogoItemQuery")
	public @ResponseBody Map<String,? extends Object> listCatalogoItemQuery(Integer id_catalogo, int start, int limit, HttpSession session) throws Exception {
		try{
		
			List<CatalogoItemQuery> listCatalogoItemQuery;
			List<CatalogoItemQuery> subListCatalogoItemQuery;
	
			if(id_catalogo == null){
				listCatalogoItemQuery = (List<CatalogoItemQuery>) session.getAttribute("listCatalogoItemQuery");
			}else if(id_catalogo.equals(-1)){
				listCatalogoItemQuery = new ArrayList<CatalogoItemQuery>();
			}else{
				Map<String, Object> paramMap = this.getParamMap();
				paramMap.put("id_catalogo", id_catalogo);
				listCatalogoItemQuery = this.gestionarCatalogoService.selectByQuery(CatalogoItemQueryMapper.class, paramMap);
				this.setRandomId(listCatalogoItemQuery);
			}
	
			if(listCatalogoItemQuery == null){
				listCatalogoItemQuery = new ArrayList<CatalogoItemQuery>();
			}
			session.setAttribute("listCatalogoItemQuery",listCatalogoItemQuery);
			int size = listCatalogoItemQuery.size();
			subListCatalogoItemQuery = (List<CatalogoItemQuery>) this.getSubList(listCatalogoItemQuery, start, limit);
			return JsonReturnUtil.success(subListCatalogoItemQuery,size);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/createCatalogoItemQuery")
	public @ResponseBody Map<String,? extends Object> createCatalogoItemQuery(@RequestBody ModelWrapper<CatalogoItemQuery> modelWrapper, HttpSession session) {
		try{
		
			List<CatalogoItemQuery> listCatalogoItemQuery = (List<CatalogoItemQuery>) session.getAttribute("listCatalogoItemQuery");
			int randomInt = this.getNegativeIdRandom();
			modelWrapper.getData().setRownum(randomInt);
			modelWrapper.getData().setNewEntry(true);
			if(listCatalogoItemQuery == null){
				listCatalogoItemQuery = new ArrayList<CatalogoItemQuery>();
			}
			listCatalogoItemQuery.add(modelWrapper.getData());	
			//session.setAttribute("listCatalogoItemQuery",listCatalogoItemQuery);
	
			return JsonReturnUtil.success();

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updateCatalogoItemQuery")
	public @ResponseBody Map<String,? extends Object> updateCatalogoItemQuery(@RequestBody ModelWrapper<CatalogoItemQuery> modelWrapper, HttpSession session) {
		try{
		
			List<CatalogoItemQuery> listCatalogoItemQuery = (List<CatalogoItemQuery>) session.getAttribute("listCatalogoItemQuery");
			CatalogoItemQuery catalogoItemQuery = (CatalogoItemQuery) this.find(listCatalogoItemQuery, modelWrapper.getData());
			modelWrapper.getData().setUpdatedRecord(true);
			if(catalogoItemQuery != null){
	        	listCatalogoItemQuery.set(listCatalogoItemQuery.indexOf(catalogoItemQuery), modelWrapper.getData());
			}
			//session.setAttribute("listCatalogoItemQuery",listCatalogoItemQuery);
			return JsonReturnUtil.success();

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/destroyCatalogoItemQuery")
	public @ResponseBody Map<String,? extends Object> destroyCatalogoItemQuery(@RequestBody ModelWrapper<CatalogoItemQuery> modelWrapper, HttpSession session) {
		try{
		
			List<CatalogoItemQuery> listCatalogoItemQuery = (List<CatalogoItemQuery>) session.getAttribute("listCatalogoItemQuery");
			CatalogoItemQuery catalogoItemQuery = (CatalogoItemQuery) this.find(listCatalogoItemQuery, modelWrapper.getData());
			modelWrapper.getData().setRemovedRecord(true);
			if(catalogoItemQuery != null){
	        	listCatalogoItemQuery.set(listCatalogoItemQuery.indexOf(catalogoItemQuery), modelWrapper.getData());
			}		
			//session.setAttribute("listCatalogoItemQuery",listCatalogoItemQuery);
	        return JsonReturnUtil.success();
	        
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
}