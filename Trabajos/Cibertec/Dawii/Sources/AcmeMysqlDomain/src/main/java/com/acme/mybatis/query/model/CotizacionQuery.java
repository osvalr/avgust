package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

import java.util.ArrayList;
import java.util.List;

public class CotizacionQuery extends DataTranferObject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id_cotizacion;
    private String cod_cotizacion;
    private Integer id_cliente;
    private String nombres_cliente;
    private Integer id_vendedor;
    private String nombres_vendedor;
    private Double importe_total;
    private String nom_user;
    private String nom_user_mod;
    private String descrip_estado;

    //private List<CotizacionProductoQuery> cotizacionProductoQueryList = new ArrayList<CotizacionProductoQuery>();

    public Integer getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(Integer id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public String getCod_cotizacion() {
        return cod_cotizacion;
    }

    public void setCod_cotizacion(String cod_cotizacion) {
        this.cod_cotizacion = cod_cotizacion;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres_cliente() {
        return nombres_cliente;
    }

    public void setNombres_cliente(String nombres_cliente) {
        this.nombres_cliente = nombres_cliente;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNombres_vendedor() {
        return nombres_vendedor;
    }

    public void setNombres_vendedor(String nombres_vendedor) {
        this.nombres_vendedor = nombres_vendedor;
    }

    public Double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Double importe_total) {
        this.importe_total = importe_total;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getNom_user_mod() {
        return nom_user_mod;
    }

    public void setNom_user_mod(String nom_user_mod) {
        this.nom_user_mod = nom_user_mod;
    }

    public String getDescrip_estado() {
        return descrip_estado;
    }

    public void setDescrip_estado(String descrip_estado) {
        this.descrip_estado = descrip_estado;
    }

}
