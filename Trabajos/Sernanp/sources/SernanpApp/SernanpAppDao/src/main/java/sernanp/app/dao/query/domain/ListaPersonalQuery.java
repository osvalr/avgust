package sernanp.app.dao.query.domain; 

public class ListaPersonalQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersonal; 
private String nombres_completos; 
private Integer idtipodocumento; 
private String descrip_tipodocumento; 
private String numerodoc; 

public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getNombres_completos() { 
  return nombres_completos; 
} 
public void setNombres_completos(String nombres_completos) { 
  this.nombres_completos = nombres_completos; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public String getDescrip_tipodocumento() { 
  return descrip_tipodocumento; 
} 
public void setDescrip_tipodocumento(String descrip_tipodocumento) { 
  this.descrip_tipodocumento = descrip_tipodocumento; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 

} 
