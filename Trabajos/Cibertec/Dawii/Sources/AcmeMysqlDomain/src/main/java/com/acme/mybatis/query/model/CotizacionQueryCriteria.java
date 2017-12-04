package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class CotizacionQueryCriteria extends DataCriteria {

    private String cod_cotizacion;
    private Integer id_estado;
    private String nombres_cliente;
    private String nombres_vendedor;
    private Integer id_cotizacion;

    public String getCod_cotizacion() {
        return cod_cotizacion;
    }

    public void setCod_cotizacion(String cod_cotizacion) {
        this.cod_cotizacion = cod_cotizacion;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombres_cliente() {
        return nombres_cliente;
    }

    public void setNombres_cliente(String nombres_cliente) {
        this.nombres_cliente = nombres_cliente;
    }

    public String getNombres_vendedor() {
        return nombres_vendedor;
    }

    public void setNombres_vendedor(String nombres_vendedor) {
        this.nombres_vendedor = nombres_vendedor;
    }

    public Integer getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(Integer id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }


} 
