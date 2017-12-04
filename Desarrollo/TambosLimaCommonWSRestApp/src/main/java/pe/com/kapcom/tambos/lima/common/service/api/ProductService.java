package pe.com.kapcom.tambos.lima.common.service.api;

import pe.com.kapcom.tambos.lima.common.model.bean.ProductQuery;
import pe.com.kapcom.tambos.lima.common.model.bean.ProductQueryCriteria;

import java.util.List;

public interface ProductService {
    List<ProductQuery> find(ProductQueryCriteria criteria);
    Integer count(ProductQueryCriteria criteria);
}
