package com.acme.commons.util;

import com.acme.commons.business.service.ICommonService;
import com.acme.commons.helper.ControllerHelper;
import com.acme.mybatis.query.mapper.ItemsByNameCatalogoQueryMapper;
import com.acme.mybatis.query.model.ItemsByNameCatalogoQuery;
import com.acme.mybatis.query.model.ItemsByNameCatalogoQueryCriteria;
import com.acme.util.JsonReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 10/26/15.
 */
@RestController
@RequestMapping("/")
public class CommonDataController extends ControllerHelper {

    @Autowired
    private ICommonService iCommonService;

    @RequestMapping(value="ItemsByNameCatalogo", method = RequestMethod.GET)
    public Map<String,? extends Object> listaTablaGeneralDetalle(String nameCataoglo) throws Exception {

        ItemsByNameCatalogoQueryCriteria itemsByNameCatalogoQueryCriteria = new ItemsByNameCatalogoQueryCriteria();
        itemsByNameCatalogoQueryCriteria.setNombre_catalogo(nameCataoglo);
        List<ItemsByNameCatalogoQuery> list = iCommonService.selectByQuery(ItemsByNameCatalogoQueryMapper.class,itemsByNameCatalogoQueryCriteria);
        return JsonReturnUtil.returnList(list);

    }

}
