package pe.com.acme.util;

import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IRepositoryModelHelper<Model,Criteria> {
    void create(Map<String,Object> mapModel) throws Exception;
    void update(Map<String,Object> mapModel) throws Exception;
    void destroy(Map<String,Object> mapModel) throws Exception;
    List<Map<String,Object>> list(Map<String,Object> mapCriteria) throws Exception;
    int countRecords(Map<String,Object> mapCriteria) throws Exception;
}
