package pe.com.kapcom.tambos.lima.common.rest.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.kapcom.tambos.lima.common.model.bean.ProductQueryCriteria;
import pe.com.kapcom.tambos.lima.common.service.api.ProductService;
import pe.com.kapcom.util.JsonReturnUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1.0")
public class ProductRestController{

    private static Logger log = Logger.getLogger(ProductRestController.class);

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> list(ProductQueryCriteria criteria) throws Exception {

        try {

            List<?> list = productService.find(criteria);
            Integer total = productService.count(criteria);

            Map<String, Object> modelMap = new HashMap<String, Object>(7);

            modelMap.put("total", total);
            modelMap.put("nextPage", criteria.getStart()+1);
            modelMap.put("pageSize", criteria.getLimit());
            modelMap.put("records", list);
            modelMap.put("status", true);

            return new ResponseEntity<>(modelMap, HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(JsonReturnUtil.exception(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
