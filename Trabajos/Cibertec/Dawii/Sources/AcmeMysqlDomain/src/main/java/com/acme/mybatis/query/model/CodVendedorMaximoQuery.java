package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class CodVendedorMaximoQuery extends DataTranferObject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String cod_vendedor_max;

    public String getCod_vendedor_max() {
        return cod_vendedor_max;
    }

    public void setCod_vendedor_max(String cod_vendedor_max) {
        this.cod_vendedor_max = cod_vendedor_max;
    }

} 
