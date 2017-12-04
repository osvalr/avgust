package pe.com.acme.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 23/11/16.
 */

@Component
public abstract class RepositoryModelHelper<Model,Criteria> extends MybatisRepositoryHelper implements IRepositoryModelHelper<Model,Criteria> {

    @Autowired
    private DtoUtil dtoUtil;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Class classDomain;
    private Class classDomainMapper;
    private Class classModelMapper;
    private String nameKey;

    public RepositoryModelHelper(Class classModelMapper, Class classDomain, Class classDomainMapper, String nameKey) {
        this.classDomain = classDomain;
        this.nameKey = nameKey;
        this.classDomainMapper = classDomainMapper;
        this.classModelMapper = classModelMapper;
    }

    @Override
    public void create(Map<String,Object> mapModel) throws Exception {
        Object domain = dtoUtil.copyBean(mapModel, classDomain);
        this.insertSelective(classDomainMapper, domain);
        Object valueKey = PropertyUtils.getProperty(domain,nameKey);
        mapModel.put(nameKey,valueKey);
    }

    @Override
    public void update(Map<String,Object> mapModel) throws Exception {
        Object domain = dtoUtil.copyBean(mapModel, classDomain);
        this.updateByPrimaryKeySelective(classDomainMapper, domain);
    }

    @Override
    public void destroy(Map<String,Object> mapModel) throws Exception {
        Object domain = dtoUtil.copyBean(mapModel, classDomain);
        this.deleteByPrimaryKey(classDomainMapper, domain);
    }

    @Override
    public List<Map<String,Object>> list(Map<String,Object> mapCriteria) throws Exception {

        List<Map<String,Object>> mapList = new ArrayList<>();

        Integer start = (Integer) mapCriteria.get("start");
        Integer limit = (Integer) mapCriteria.get("limit");

        String order_column = (String) mapCriteria.get("order_column");
        String order_direction = (String) mapCriteria.get("order_direction");

        if(start == null){
            throw new AcmeException("start should not be null, in the mapCriteria");
        }

        if(limit == null){
            throw new AcmeException("limit should not be null, in the mapCriteria");
        }

        if(order_column == null){
            throw new AcmeException("order_column should not be null, in the mapCriteria");
        }

        if(order_direction == null){
            throw new AcmeException("order_direction should not be null, in the mapCriteria");
        }

        List<Model> list = this.selectByQuery(classModelMapper, mapCriteria, start, limit);

        for (Model model: list) {
            Map<String,Object> mapModel = objectMapper.convertValue(model,Map.class);
            mapList.add(mapModel);
        }

        return mapList;
    }

    @Override
    public int countRecords(Map<String,Object> mapCriteria) throws Exception {
        int count = this.selectCountByQuery(classModelMapper, mapCriteria);
        return count;
    }

}
