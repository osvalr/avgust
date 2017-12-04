package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class ProductoQuery extends DataTranferObject implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id_producto;
  private String cod_producto;
  private Integer id_categoria;
  private String descrip_categoria;
  private String nombre;
  private String descripcion;
  private String observacion;
  private Integer id_moneda;
  private String descrip_moneda;
  private Double precio;
  private String ruta_foto;
  private String nom_user;
  private String nom_user_mod;
  private String descrip_estado;

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

  public Integer getId_categoria() {
    return id_categoria;
  }

  public void setId_categoria(Integer id_categoria) {
    this.id_categoria = id_categoria;
  }

  public String getDescrip_categoria() {
    return descrip_categoria;
  }

  public void setDescrip_categoria(String descrip_categoria) {
    this.descrip_categoria = descrip_categoria;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
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

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public String getRuta_foto() {
    return ruta_foto;
  }

  public void setRuta_foto(String ruta_foto) {
    this.ruta_foto = ruta_foto;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ProductoQuery that = (ProductoQuery) o;

    if (id_producto != null ? !id_producto.equals(that.id_producto) : that.id_producto != null) return false;
    if (cod_producto != null ? !cod_producto.equals(that.cod_producto) : that.cod_producto != null) return false;
    if (id_categoria != null ? !id_categoria.equals(that.id_categoria) : that.id_categoria != null) return false;
    if (descrip_categoria != null ? !descrip_categoria.equals(that.descrip_categoria) : that.descrip_categoria != null) return false;
    if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
    if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
    if (observacion != null ? !observacion.equals(that.observacion) : that.observacion != null) return false;
    if (id_moneda != null ? !id_moneda.equals(that.id_moneda) : that.id_moneda != null) return false;
    if (descrip_moneda != null ? !descrip_moneda.equals(that.descrip_moneda) : that.descrip_moneda != null) return false;
    if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
    if (ruta_foto != null ? !ruta_foto.equals(that.ruta_foto) : that.ruta_foto != null) return false;
    if (nom_user != null ? !nom_user.equals(that.nom_user) : that.nom_user != null) return false;
    if (nom_user_mod != null ? !nom_user_mod.equals(that.nom_user_mod) : that.nom_user_mod != null) return false;
    return !(descrip_estado != null ? !descrip_estado.equals(that.descrip_estado) : that.descrip_estado != null);

  }

  @Override
  public int hashCode() {
    int result = id_producto != null ? id_producto.hashCode() : 0;
    result = 31 * result + (cod_producto != null ? cod_producto.hashCode() : 0);
    result = 31 * result + (id_categoria != null ? id_categoria.hashCode() : 0);
    result = 31 * result + (descrip_categoria != null ? descrip_categoria.hashCode() : 0);
    result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
    result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
    result = 31 * result + (observacion != null ? observacion.hashCode() : 0);
    result = 31 * result + (id_moneda != null ? id_moneda.hashCode() : 0);
    result = 31 * result + (descrip_moneda != null ? descrip_moneda.hashCode() : 0);
    result = 31 * result + (precio != null ? precio.hashCode() : 0);
    result = 31 * result + (ruta_foto != null ? ruta_foto.hashCode() : 0);
    result = 31 * result + (nom_user != null ? nom_user.hashCode() : 0);
    result = 31 * result + (nom_user_mod != null ? nom_user_mod.hashCode() : 0);
    result = 31 * result + (descrip_estado != null ? descrip_estado.hashCode() : 0);
    return result;
  }
}
