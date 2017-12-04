package com.acme.commons.ajax.controller;

import com.acme.commons.business.service.IGestionarCotizacionService;
import com.acme.commons.helper.ControllerHelper;
import com.acme.mybatis.query.mapper.CotizacionProductoQueryMapper;
import com.acme.mybatis.query.mapper.CotizacionQueryMapper;
import com.acme.mybatis.query.model.*;
import com.acme.util.JsonReturnUtil;
import com.acme.util.ModelWrapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 17/10/15.
 */

@Controller
@RequestMapping("/GestionarCotizacion")
public class GestionarCotizacionController extends ControllerHelper {

    private static Logger log = Logger.getLogger(GestionarCatalogoController.class);

    @Autowired
    private IGestionarCotizacionService iGestionarCotizacionService;

    @RequestMapping(value="/list")
    public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
        try{
            CotizacionQueryCriteria cotizacionQueryCriteria = this.loadCriteria(request, CotizacionQueryCriteria.class);
            List<CotizacionQuery> cotizacionQueryList = iGestionarCotizacionService.list(CotizacionQueryMapper.class, cotizacionQueryCriteria, true);
            int total = iGestionarCotizacionService.selectCountByQuery(CotizacionQueryMapper.class, cotizacionQueryCriteria);
            return JsonReturnUtil.success(cotizacionQueryList, total);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/create")
    public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<CotizacionQuery> modelWrapper, HttpSession session) {
        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

            CotizacionQuery cotizacionQuery = modelWrapper.getData();

            //cotizacionQuery.setCotizacionProductoQueryList(cotizacionProductoQueryList);

            Integer lastId = iGestionarCotizacionService.create(cotizacionQuery);

            session.setAttribute("cotizacionProductoQueryList",null);

            return JsonReturnUtil.success(lastId);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/update")
    public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<CotizacionQuery> modelWrapper, HttpSession session) {
        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

            CotizacionQuery cotizacionQuery = modelWrapper.getData();

            //cotizacionQuery.setCotizacionProductoQueryList(cotizacionProductoQueryList);

            iGestionarCotizacionService.save(cotizacionQuery);

            session.setAttribute("cotizacionProductoQueryList",null);

            return JsonReturnUtil.success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/destroy")
    public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<CotizacionQuery> modelWrapper, HttpSession session) {
        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

            CotizacionQuery cotizacionQuery = modelWrapper.getData();

            //cotizacionQuery.setCotizacionProductoQueryList(cotizacionProductoQueryList);

            iGestionarCotizacionService.remove(cotizacionQuery);

            session.setAttribute("cotizacionProductoQueryList",null);

            return JsonReturnUtil.success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/createCotizacionProducto")
    public @ResponseBody Map<String,? extends Object> createCotizacionProducto(@RequestBody ModelWrapper<CotizacionProductoQuery> modelWrapper, HttpSession session) {
        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

            CotizacionProductoQuery cotizacionProductoQuery = modelWrapper.getData();

            int randomInt = this.getNegativeIdRandom();
            cotizacionProductoQuery.setId_cotizacion_producto(randomInt);
            cotizacionProductoQuery.setNewEntry(true);

            if(cotizacionProductoQueryList == null){
                cotizacionProductoQueryList = new ArrayList<>();
            }

            cotizacionProductoQueryList.add(cotizacionProductoQuery);
            session.setAttribute("cotizacionProductoQueryList",cotizacionProductoQueryList);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/updateCotizacionProducto")
    public @ResponseBody Map<String,? extends Object> updateCotizacionProducto(@RequestBody ModelWrapper<CotizacionProductoQuery> modelWrapper, HttpSession session) {

        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

            CotizacionProductoQuery cotizacionProductoQuery = modelWrapper.getData();

            int index = -1;

            for (int i = 0; i < cotizacionProductoQueryList.size(); i++) {
                if(cotizacionProductoQueryList.get(i).getId_cotizacion_producto().equals(cotizacionProductoQuery.getId_cotizacion_producto())){
                    index = i;
                    break;
                }
            }

            if(index > -1){
                cotizacionProductoQuery.setUpdatedRecord(true);
                cotizacionProductoQueryList.set(index, cotizacionProductoQuery);
            }

            session.setAttribute("cotizacionProductoQueryList",cotizacionProductoQueryList);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }

    }

    @RequestMapping(value="/destroyCotizacionProducto")
    public @ResponseBody Map<String,? extends Object> destroyCotizacionProducto(@RequestBody ModelWrapper<CotizacionProductoQuery> modelWrapper, HttpSession session) {

        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

            CotizacionProductoQuery cotizacionProductoQuery = modelWrapper.getData();

            int index = -1;
            for (int i = 0; i < cotizacionProductoQueryList.size(); i++) {
                if(cotizacionProductoQueryList.get(i).getId_cotizacion_producto().equals(cotizacionProductoQuery.getId_cotizacion_producto())){
                    index = i;
                    break;
                }
            }

            if(index > -1){

                if(cotizacionProductoQuery.getId_cotizacion_producto().intValue() > 0){
                    cotizacionProductoQuery.setRemovedRecord(true);
                    cotizacionProductoQueryList.set(index, cotizacionProductoQuery);
                }else{
                    cotizacionProductoQueryList.remove(index);
                }

            }

            session.setAttribute("cotizacionProductoQueryList",cotizacionProductoQueryList);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }

    }

    @RequestMapping(value="/listCotizacionProducto")
    public @ResponseBody Map<String,? extends Object> listCotizacionProducto(Integer id_cotizacion, int start, int limit, HttpSession session) {

        try{

            List<CotizacionProductoQuery> cotizacionProductoQueryList;
            List<CotizacionProductoQuery> subCotizacionProductoQueryList;
            List<CotizacionProductoQuery> auxList = new ArrayList<>();

            if(id_cotizacion == null){

                cotizacionProductoQueryList = (List<CotizacionProductoQuery>) session.getAttribute("cotizacionProductoQueryList");

                if(cotizacionProductoQueryList == null){
                    cotizacionProductoQueryList = new ArrayList<>();
                    session.setAttribute("cotizacionProductoQueryList",cotizacionProductoQueryList);
                }

            }else{

                CotizacionProductoQueryCriteria cotizacionProductoQueryCriteria = new CotizacionProductoQueryCriteria();
                cotizacionProductoQueryCriteria.setId_cotizacion(id_cotizacion);
                cotizacionProductoQueryList = this.iGestionarCotizacionService.selectByQuery(CotizacionProductoQueryMapper.class, cotizacionProductoQueryCriteria);
                session.setAttribute("cotizacionProductoQueryList",cotizacionProductoQueryList);

            }

            for(CotizacionProductoQuery cotizacionProductoQuery : cotizacionProductoQueryList){

                if(cotizacionProductoQuery.isRemovedRecord()){
                    auxList.add(cotizacionProductoQuery);
                }

            }

            int size = auxList.size();

            subCotizacionProductoQueryList = this.getSubList(auxList, start, limit);

            return JsonReturnUtil.success(subCotizacionProductoQueryList,size);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }

    }


}
