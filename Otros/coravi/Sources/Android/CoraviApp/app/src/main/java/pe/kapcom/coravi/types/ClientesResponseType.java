package pe.kapcom.coravi.types;

import java.util.List;

/**
 * Created by JRaffo on 13/03/17.
 */

public class ClientesResponseType {

    List<ClienteType> list;

    public List<ClienteType> getList() {
        return list;
    }

    public void setList(List<ClienteType> list) {
        this.list = list;
    }
}
