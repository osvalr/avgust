package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class CodCotizacionMaximoQuery extends DataTranferObject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String cod_cotizacion_max;

    public String getCod_cotizacion_max() {
        return cod_cotizacion_max;
    }

    public void setCod_cotizacion_max(String cod_cotizacion_max) {
        this.cod_cotizacion_max = cod_cotizacion_max;
    }

} 
