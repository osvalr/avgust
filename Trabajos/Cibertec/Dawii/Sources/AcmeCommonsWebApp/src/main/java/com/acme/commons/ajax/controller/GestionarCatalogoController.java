package com.acme.commons.ajax.controller;

import com.acme.commons.business.service.IGestionarCatalogoService;
import com.acme.commons.helper.ControllerHelper;
import com.acme.mybatis.query.mapper.CatalogoItemQueryMapper;
import com.acme.mybatis.query.mapper.CatalogoQueryMapper;
import com.acme.mybatis.query.model.*;
import com.acme.util.JsonReturnUtil;
import com.acme.util.ModelWrapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/GestionarCatalogo")
public class GestionarCatalogoController extends ControllerHelper {

    private static Logger log = Logger.getLogger(GestionarCatalogoController.class);

    @Autowired
    private IGestionarCatalogoService iGestionarCatalogoService;

    @RequestMapping(value="/list")
    public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
        try{
            CatalogoQueryCriteria catalogoQueryCriteria = this.loadCriteria(request, CatalogoQueryCriteria.class);
            List<CatalogoQuery> catalogoQueryList = iGestionarCatalogoService.list(CatalogoQueryMapper.class, catalogoQueryCriteria, true);
            int total = iGestionarCatalogoService.selectCountByQuery(CatalogoQueryMapper.class, catalogoQueryCriteria);
            return JsonReturnUtil.success(catalogoQueryList, total);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/create")
    public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<CatalogoQuery> modelWrapper, HttpSession session) {
        try{

            List<CatalogoItemQuery> catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

            CatalogoQuery catalogoQuery = modelWrapper.getData();

            catalogoQuery.setCatalogoItemQueryList(catalogoItemQueryList);

            Integer lastId = iGestionarCatalogoService.create(catalogoQuery);

            session.setAttribute("catalogoItemQueryList",null);

            return JsonReturnUtil.success(lastId);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/update")
    public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<CatalogoQuery> modelWrapper, HttpSession session) {
        try{

            List<CatalogoItemQuery> catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

            CatalogoQuery catalogoQuery = modelWrapper.getData();
            
            catalogoQuery.setCatalogoItemQueryList(catalogoItemQueryList);

            iGestionarCatalogoService.save(catalogoQuery);

            session.setAttribute("catalogoItemQueryList",null);

            return JsonReturnUtil.success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/destroy")
    public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<CatalogoQuery> modelWrapper, HttpSession session) {
        try{

            List<CatalogoItemQuery> catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

            CatalogoQuery catalogoQuery = modelWrapper.getData();

            catalogoQuery.setCatalogoItemQueryList(catalogoItemQueryList);

            iGestionarCatalogoService.remove(catalogoQuery);

            session.setAttribute("catalogoItemQueryList",null);

            return JsonReturnUtil.success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/createCatalogoItem")
    public @ResponseBody Map<String,? extends Object> createCatalogoItem(@RequestBody ModelWrapper<CatalogoItemQuery> modelWrapper, HttpSession session) {
        try{

            List<CatalogoItemQuery> catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

            CatalogoItemQuery catalogoItemQuery = modelWrapper.getData();

            int randomInt = this.getNegativeIdRandom();
            catalogoItemQuery.setId_catalogo_item(randomInt);
            catalogoItemQuery.setNewEntry(true);

            if(catalogoItemQueryList == null){
                catalogoItemQueryList = new ArrayList<>();
            }

            catalogoItemQueryList.add(catalogoItemQuery);
            session.setAttribute("catalogoItemQueryList",catalogoItemQueryList);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/updateCatalogoItem")
    public @ResponseBody Map<String,? extends Object> updateCatalogoItem(@RequestBody ModelWrapper<CatalogoItemQuery> modelWrapper, HttpSession session) {

        try{

            List<CatalogoItemQuery> catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

            CatalogoItemQuery catalogoItemQuery = modelWrapper.getData();

            int index = -1;

            for (int i = 0; i < catalogoItemQueryList.size(); i++) {
                if(catalogoItemQueryList.get(i).getId_catalogo_item().equals(catalogoItemQuery.getId_catalogo_item())){
                    index = i;
                    break;
                }
            }

            if(index > -1){
                catalogoItemQuery.setUpdatedRecord(true);
                catalogoItemQueryList.set(index, catalogoItemQuery);
            }

            session.setAttribute("catalogoItemQueryList",catalogoItemQueryList);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }

    }

    @RequestMapping(value="/destroyCatalogoItem")
    public @ResponseBody Map<String,? extends Object> destroyCatalogoItem(@RequestBody ModelWrapper<CatalogoItemQuery> modelWrapper, HttpSession session) {

        try{

            List<CatalogoItemQuery> catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

            CatalogoItemQuery catalogoItemQuery = modelWrapper.getData();

            int index = -1;
            for (int i = 0; i < catalogoItemQueryList.size(); i++) {
                if(catalogoItemQueryList.get(i).getId_catalogo_item().equals(catalogoItemQuery.getId_catalogo_item())){
                    index = i;
                    break;
                }
            }

            if(index > -1){

                if(catalogoItemQuery.getId_catalogo_item().intValue() > 0){
                    catalogoItemQuery.setRemovedRecord(true);
                    catalogoItemQueryList.set(index, catalogoItemQuery);
                }else{
                    catalogoItemQueryList.remove(index);
                }

            }

            session.setAttribute("catalogoItemQueryList",catalogoItemQueryList);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }

    }

    @RequestMapping(value="/listCatalogoItem")
    public @ResponseBody Map<String,? extends Object> listCatalogoItem(Integer id_catalogo, int start, int limit, HttpSession session) {

        try{

            List<CatalogoItemQuery> catalogoItemQueryList;
            List<CatalogoItemQuery> subCatalogoItemQueryList;
            List<CatalogoItemQuery> auxList = new ArrayList<>();

            if(id_catalogo == null){

                catalogoItemQueryList = (List<CatalogoItemQuery>) session.getAttribute("catalogoItemQueryList");

                if(catalogoItemQueryList == null){
                    catalogoItemQueryList = new ArrayList<>();
                    session.setAttribute("catalogoItemQueryList",catalogoItemQueryList);
                }

            }else{

                CatalogoItemQueryCriteria catalogoItemQueryCriteria = new CatalogoItemQueryCriteria();
                catalogoItemQueryCriteria.setId_catalogo(id_catalogo);
                catalogoItemQueryList = this.iGestionarCatalogoService.selectByQuery(CatalogoItemQueryMapper.class, catalogoItemQueryCriteria);
                session.setAttribute("catalogoItemQueryList",catalogoItemQueryList);

            }

            for(CatalogoItemQuery catalogoItemQuery : catalogoItemQueryList){

                if(catalogoItemQuery.isRemovedRecord()){
                    auxList.add(catalogoItemQuery);
                }

            }

            int size = auxList.size();

            subCatalogoItemQueryList = this.getSubList(auxList, start, limit);

            return JsonReturnUtil.success(subCatalogoItemQueryList,size);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }

    }
}
