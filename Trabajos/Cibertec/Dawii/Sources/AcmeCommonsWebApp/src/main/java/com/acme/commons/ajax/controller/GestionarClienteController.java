package com.acme.commons.ajax.controller;

import com.acme.commons.business.service.IGestionarClienteService;
import com.acme.commons.helper.ControllerHelper;
import com.acme.mybatis.query.mapper.ClienteQueryMapper;
import com.acme.mybatis.query.model.ClienteQuery;
import com.acme.mybatis.query.model.ClienteQueryCriteria;
import com.acme.util.JsonReturnUtil;
import com.acme.util.ModelWrapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 10/22/15.
 */

@Controller
@RequestMapping("/GestionarCliente")
public class GestionarClienteController extends ControllerHelper {

    private static Logger log = Logger.getLogger(GestionarClienteController.class);

    @Autowired
    private IGestionarClienteService iGestionarClienteService;

    @RequestMapping(value="/list")
    public @ResponseBody Map<String,? extends Object> list(HttpServletRequest request) {
        try{
            ClienteQueryCriteria clienteQueryCriteria = this.loadCriteria(request, ClienteQueryCriteria.class);
            List<ClienteQuery> clienteQueryList = iGestionarClienteService.list(ClienteQueryMapper.class, clienteQueryCriteria, true);
            int total = iGestionarClienteService.selectCountByQuery(ClienteQueryMapper.class, clienteQueryCriteria);
            return JsonReturnUtil.success(clienteQueryList, total);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/create")
    public @ResponseBody Map<String,? extends Object> create(@RequestBody ModelWrapper<ClienteQuery> modelWrapper) {
        try{

            ClienteQuery clienteQuery = modelWrapper.getData();

            Integer lastId = iGestionarClienteService.create(clienteQuery);

            return JsonReturnUtil.success(lastId);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

    @RequestMapping(value="/update")
    public @ResponseBody Map<String,? extends Object> update(@RequestBody ModelWrapper<ClienteQuery> modelWrapper) {
        try{

            ClienteQuery clienteQuery = modelWrapper.getData();

            iGestionarClienteService.save(clienteQuery);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }


    @RequestMapping(value="/destroy")
    public @ResponseBody Map<String,? extends Object> destroy(@RequestBody ModelWrapper<ClienteQuery> modelWrapper) {
        try{

            ClienteQuery clienteQuery = modelWrapper.getData();

            iGestionarClienteService.remove(clienteQuery);

            return JsonReturnUtil.success();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
    }

}
