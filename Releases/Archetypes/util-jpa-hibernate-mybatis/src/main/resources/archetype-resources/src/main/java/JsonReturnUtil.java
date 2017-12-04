#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JsonReturnUtil {

    public static <T> Map<String,Object> success(List<T> list, int size){

        Map<String,Object> modelMap = new HashMap<String,Object>(3);
        modelMap.put("total", size);
        modelMap.put("data", list);
        modelMap.put("success", true);

        return modelMap;
    }

    public static <T> Map<String,Object> success(Integer lastId){

        Map<String,Object> modelMap = new HashMap<String,Object>(2);
        modelMap.put("lastId", lastId);
        modelMap.put("success", true);

        return modelMap;
    }

    public static <T> Map<String,Object> success(){

        Map<String,Object> modelMap = new HashMap<String,Object>(1);
        modelMap.put("success", true);

        return modelMap;
    }

    public static Map<String,Object> exception(String msg){

        Map<String,Object> modelMap = new HashMap<String,Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);

        return modelMap;
    }

}
