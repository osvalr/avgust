package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class CatalogoItemQuery extends DataTranferObject implements java.io.Serializable {

private static final long serialVersionUID = 1L;
private Integer id_catalogo_item; 
private Integer id_catalogo; 
private String valor_a; 
private String valor_b; 
private String valor_c; 
private String valor_d; 
private String valor_e;

  private String nom_user;
  private String nom_user_mod;
  private String descrip_estado;

public Integer getId_catalogo_item() { 
  return id_catalogo_item; 
} 
public void setId_catalogo_item(Integer id_catalogo_item) { 
  this.id_catalogo_item = id_catalogo_item; 
} 
public Integer getId_catalogo() { 
  return id_catalogo; 
} 
public void setId_catalogo(Integer id_catalogo) { 
  this.id_catalogo = id_catalogo; 
} 
public String getValor_a() { 
  return valor_a; 
} 
public void setValor_a(String valor_a) { 
  this.valor_a = valor_a; 
} 
public String getValor_b() { 
  return valor_b; 
} 
public void setValor_b(String valor_b) { 
  this.valor_b = valor_b; 
} 
public String getValor_c() { 
  return valor_c; 
} 
public void setValor_c(String valor_c) { 
  this.valor_c = valor_c; 
} 
public String getValor_d() { 
  return valor_d; 
} 
public void setValor_d(String valor_d) { 
  this.valor_d = valor_d; 
} 
public String getValor_e() { 
  return valor_e; 
} 
public void setValor_e(String valor_e) { 
  this.valor_e = valor_e; 
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
