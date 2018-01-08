package pe.kapcom.coravi.types;

import java.util.List;

/**
 * Created by JRaffo on 15/03/17.
 */

public class ResumenPagosResponseType {
    
    private Integer total;
    private List<ResumenPagosType> data;
    private String success;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ResumenPagosType> getData() {
        return data;
    }

    public void setData(List<ResumenPagosType> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
