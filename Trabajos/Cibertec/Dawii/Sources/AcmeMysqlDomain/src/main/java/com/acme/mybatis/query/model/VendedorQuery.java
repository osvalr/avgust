package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class VendedorQuery extends DataTranferObject implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id_persona;
  private String cod_persona;
  private String nombres_completos;
  private String nombres;
  private String ape_pater;
  private String ape_mater;
  private Integer id_tipo_docu_iden;
  private String descrip_tipo_docu_iden;
  private String num_docu_iden;
  private String correo;
  private String direccion;
  private String telefono;
  private String sucursal;

  private String usuario;
  private String clave;

  private String nom_user;
  private String nom_user_mod;
  private String descrip_estado;

  public Integer getId_persona() {
    return id_persona;
  }

  public void setId_persona(Integer id_persona) {
    this.id_persona = id_persona;
  }

  public String getCod_persona() {
    return cod_persona;
  }

  public void setCod_persona(String cod_persona) {
    this.cod_persona = cod_persona;
  }

  public String getNombres_completos() {
    return nombres_completos;
  }

  public void setNombres_completos(String nombres_completos) {
    this.nombres_completos = nombres_completos;
  }

  public String getApe_pater() {
    return ape_pater;
  }

  public void setApe_pater(String ape_pater) {
    this.ape_pater = ape_pater;
  }

  public String getApe_mater() {
    return ape_mater;
  }

  public void setApe_mater(String ape_mater) {
    this.ape_mater = ape_mater;
  }

  public Integer getId_tipo_docu_iden() {
    return id_tipo_docu_iden;
  }

  public void setId_tipo_docu_iden(Integer id_tipo_docu_iden) {
    this.id_tipo_docu_iden = id_tipo_docu_iden;
  }

  public String getDescrip_tipo_docu_iden() {
    return descrip_tipo_docu_iden;
  }

  public void setDescrip_tipo_docu_iden(String descrip_tipo_docu_iden) {
    this.descrip_tipo_docu_iden = descrip_tipo_docu_iden;
  }

  public String getNum_docu_iden() {
    return num_docu_iden;
  }

  public void setNum_docu_iden(String num_docu_iden) {
    this.num_docu_iden = num_docu_iden;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getSucursal() {
    return sucursal;
  }

  public void setSucursal(String sucursal) {
    this.sucursal = sucursal;
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


  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }


  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }
}
