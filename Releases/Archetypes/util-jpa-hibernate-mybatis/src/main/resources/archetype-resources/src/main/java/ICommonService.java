#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 9/10/15.
 */
public interface ICommonService {

    Integer create(Map<String, Object> dataMap) throws Exception;
    Integer create(DataTranferObject dataTranferObject) throws Exception;
    void save(Map<String, Object> dataMap) throws Exception;
    void save(DataTranferObject dataTranferObject) throws Exception;
    void remove(Map<String, Object> dataMap) throws Exception;
    void remove(DataTranferObject dataTranferObject) throws Exception;
    <T>  List<T> list(Class mapperClass, Map<String, Object> dataMap, boolean pagination) throws Exception;
    <T>  List<T> list(Class mapperClass, DataCriteria dataCriteria, boolean pagination) throws Exception;

}
