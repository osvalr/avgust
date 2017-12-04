package com.acme.commons.ajax.controller;

import com.acme.commons.business.service.IGestionarProductoService;
import com.acme.commons.helper.ControllerHelper;
import com.acme.mybatis.query.mapper.ProductoQueryMapper;
import com.acme.mybatis.query.model.*;
import com.acme.util.JsonReturnUtil;
import com.acme.util.ModelWrapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 10/22/15.
 */

@Controller
@RequestMapping("/GestionarProducto")
public class GestionarProductoController extends ControllerHelper {

    private static Logger log = Logger.getLogger(GestionarProductoController.class);

    @Autowired
    private IGestionarProductoService iGestionarProductoService;

    @RequestMapping(value="/list")
    public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
        try{
            ProductoQueryCriteria productoQueryCriteria = this.loadCriteria(request, ProductoQueryCriteria.class);
            List<ProductoQuery> productoQueryList = iGestionarProductoService.list(ProductoQueryMapper.class, productoQueryCriteria, true);
            int total = iGestionarProductoService.selectCountByQuery(ProductoQueryMapper.class, productoQueryCriteria);
            return JsonReturnUtil.success(productoQueryList, total);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/create")
    public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<ProductoQuery> modelWrapper) {
        try{

            ProductoQuery productoQuery = modelWrapper.getData();
            productoQuery.setId_user(1);
            productoQuery.setId_user_mod(1);
            productoQuery.setId_estado(1);

            Integer lastId = iGestionarProductoService.create(productoQuery);

            return JsonReturnUtil.success(lastId);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/update")
    public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<ProductoQuery> modelWrapper) {
        try{

            ProductoQuery productoQuery = modelWrapper.getData();
            iGestionarProductoService.save(productoQuery);

            return JsonReturnUtil.success();
            
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }


    @RequestMapping(value="/destroy")
    public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<ProductoQuery> modelWrapper) {
        try{

            ProductoQuery productoQuery = modelWrapper.getData();
            iGestionarProductoService.remove(productoQuery);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }
    
    
}
