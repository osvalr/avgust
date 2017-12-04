package com.acme.commons.ajax.controller;

import com.acme.commons.business.service.IGestionarVendedorService;
import com.acme.commons.helper.ControllerHelper;
import com.acme.mybatis.query.mapper.VendedorQueryMapper;
import com.acme.mybatis.query.model.VendedorQuery;
import com.acme.mybatis.query.model.VendedorQueryCriteria;
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
@RequestMapping("/GestionarVendedor")
public class GestionarVendedorController extends ControllerHelper {

    private static Logger log = Logger.getLogger(GestionarVendedorController.class);

    @Autowired
    private IGestionarVendedorService iGestionarVendedorService;

    @RequestMapping(value="/list")
    public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
        try{
            VendedorQueryCriteria vendedorQueryCriteria = this.loadCriteria(request, VendedorQueryCriteria.class);
            List<VendedorQuery> vendedorQueryList = iGestionarVendedorService.list(VendedorQueryMapper.class, vendedorQueryCriteria, true);
            int total = iGestionarVendedorService.selectCountByQuery(VendedorQueryMapper.class, vendedorQueryCriteria);
            return JsonReturnUtil.success(vendedorQueryList, total);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/create")
    public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<VendedorQuery> modelWrapper) {
        try{

            VendedorQuery vendedorQuery = modelWrapper.getData();
            Integer lastId = iGestionarVendedorService.create(vendedorQuery);

            return JsonReturnUtil.success(lastId);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/update")
    public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<VendedorQuery> modelWrapper) {
        try{

            VendedorQuery vendedorQuery = modelWrapper.getData();
            iGestionarVendedorService.save(vendedorQuery);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }


    @RequestMapping(value="/destroy")
    public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<VendedorQuery> modelWrapper) {
        try{

            VendedorQuery vendedorQuery = modelWrapper.getData();
            iGestionarVendedorService.remove(vendedorQuery);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

}
