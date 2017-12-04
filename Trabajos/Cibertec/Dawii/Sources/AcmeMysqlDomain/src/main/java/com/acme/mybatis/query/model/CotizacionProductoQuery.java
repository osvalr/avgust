package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class CotizacionProductoQuery extends DataTranferObject implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id_cotizacion_producto;
  private Integer id_cotizacion;
  private Integer id_producto;
  private String nombre;
  private Integer id_moneda;
  private String descrip_moneda;
  private Integer cantidad;
  private Double sub_total;
  private String nom_user;
  private String nom_user_mod;
  private String descrip_estado;

  public Integer getId_cotizacion_producto() {
    return id_cotizacion_producto;
  }

  public void setId_cotizacion_producto(Integer id_cotizacion_producto) {
    this.id_cotizacion_producto = id_cotizacion_producto;
  }

  public Integer getId_cotizacion() {
    return id_cotizacion;
  }

  public void setId_cotizacion(Integer id_cotizacion) {
    this.id_cotizacion = id_cotizacion;
  }

  public Integer getId_producto() {
    return id_producto;
  }

  public void setId_producto(Integer id_producto) {
    this.id_producto = id_producto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getId_moneda() {
    return id_moneda;
  }

  public void setId_moneda(Integer id_moneda) {
    this.id_moneda = id_moneda;
  }

  public String getDescrip_moneda() {
    return descrip_moneda;
  }

  public void setDescrip_moneda(String descrip_moneda) {
    this.descrip_moneda = descrip_moneda;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Double getSub_total() {
    return sub_total;
  }

  public void setSub_total(Double sub_total) {
    this.sub_total = sub_total;
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
