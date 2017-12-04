package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class ProductoQueryCriteria extends DataCriteria {

  private Integer id_categoria;
  private Integer id_producto;
  private String cod_producto;
  private String nombre;
  private Integer id_moneda;
  private Integer id_estado;


  public Integer getId_categoria() {
    return id_categoria;
  }
  public void setId_categoria(Integer id_categoria) {
    this.id_categoria = id_categoria;
  }
  public Integer getId_producto() {
    return id_producto;
  }
  public void setId_producto(Integer id_producto) {
    this.id_producto = id_producto;
  }
  public String getCod_producto() {
    return cod_producto;
  }
  public void setCod_producto(String cod_producto) {
    this.cod_producto = cod_producto;
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


  public Integer getId_estado() {
    return id_estado;
  }

  public void setId_estado(Integer id_estado) {
    this.id_estado = id_estado;
  }
}
