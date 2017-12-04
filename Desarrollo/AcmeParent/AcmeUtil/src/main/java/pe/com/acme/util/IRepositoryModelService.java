package pe.com.acme.util;

import java.util.List;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IRepositoryModelService<Model, Criteria> {

//    void create(Map<String, Object> mapModel) throws Exception;
//    void update(Map<String, Object> mapModel) throws Exception;
//    void destroy(Map<String, Object> mapModel) throws Exception;
//    List<Map<String, Object>> list(Map<String, Object> mapCriteria) throws Exception;
//    int countRecords(Map<String, Object> mapCriteria) throws Exception;


    void create(Model model) throws Exception;
    void update(Model model) throws Exception;
    void destroy(Model model) throws Exception;
    List<Model> query(Criteria criteria) throws Exception;
    List<Model> query(Criteria criteria, Integer start, Integer limit) throws Exception;
    Model recordQuery(Criteria criteria) throws Exception;
    Integer countRecords(Criteria criteria) throws Exception;

    void setRepository();

}
