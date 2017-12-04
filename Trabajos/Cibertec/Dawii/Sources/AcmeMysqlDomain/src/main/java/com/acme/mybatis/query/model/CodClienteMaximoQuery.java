package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class CodClienteMaximoQuery extends DataTranferObject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String cod_cliente_max;

    public String getCod_cliente_max() {
        return cod_cliente_max;
    }
    public void setCod_cliente_max(String cod_cliente_max) {
        this.cod_cliente_max = cod_cliente_max;
    }

} 
