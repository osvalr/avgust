package pe.com.kapcom.tambos.lima.common.service.implement;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.kapcom.tambos.lima.common.model.bean.ProductQuery;
import pe.com.kapcom.tambos.lima.common.model.bean.ProductQueryCriteria;
import pe.com.kapcom.tambos.lima.common.model.mapper.ProductQueryMapper;
import pe.com.kapcom.tambos.lima.common.service.api.ProductService;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductQueryMapper productQueryMapper;

    @Override
    public List<ProductQuery> find(ProductQueryCriteria criteria) {

        List<ProductQuery> productQueryList = null;

        if(criteria.isNoPaging()){
            productQueryList = productQueryMapper.getListQueryByCriteria(criteria);
        }else{

            Integer limit = null;
            Integer start = null;

            if(criteria.getLimit() != null){
                limit = criteria.getLimit();
            }

            if(criteria.getStart()!=null){
                start = criteria.getStart();
            }

            RowBounds rowBounds = new RowBounds(start,limit);

            productQueryList = productQueryMapper.getListQueryPaginationByCriteria(criteria,rowBounds);
        }



        return productQueryList;
    }

    @Override
    public Integer count(ProductQueryCriteria criteria) {

        Integer count = productQueryMapper.getCountRowsByCriteria(criteria);

        return count;
    }
}
