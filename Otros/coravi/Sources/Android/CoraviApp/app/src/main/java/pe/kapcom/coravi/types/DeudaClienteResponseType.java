package pe.kapcom.coravi.types;

import java.util.List;

/**
 * Created by JRaffo on 14/03/17.
 */

public class DeudaClienteResponseType {

    private List<DeudaClienteType> data;

    public List<DeudaClienteType> getData() {
        return data;
    }

    public void setData(List<DeudaClienteType> data) {
        this.data = data;
    }
}
