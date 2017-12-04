package pe.com.acme.util;

import java.util.List;
import java.util.Map;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IRepositoryItemHelper<Item,Criteria> {
    void createNewItem(Map<String,Object> mapItem, Integer id) throws Exception;
    void updateModifiedItem(Map<String,Object> mapItem) throws Exception;
    void removeItem(Map<String,Object> mapItem, boolean onlyFlag) throws Exception;
    void createNewItem(List<Map<String,Object>> mapItems, Integer id) throws Exception;
    void updateModifiedItem(List<Map<String,Object>> mapItems) throws Exception;
    void removeItem(List<Map<String,Object>> mapItems, boolean onlyFlag) throws Exception;
    List<Map<String,Object>> list(Map<String,Object> mapCriteria) throws Exception;
    int countItems(Map<String,Object> mapCriteria) throws Exception;
}
