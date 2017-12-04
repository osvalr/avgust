package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class CodProductoMaximoQuery extends DataTranferObject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String cod_producto_max;

    public String getCod_producto_max() {
        return cod_producto_max;
    }

    public void setCod_producto_max(String cod_producto_max) {
        this.cod_producto_max = cod_producto_max;
    }

} 
