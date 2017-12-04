package sernanp.app.dao.query.domain; 

public class UsuarioResponsableGestionQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idrol; 
private Integer idpersonal; 
private Integer idpersonanatural; 
private String nombre_completo; 

public Integer getIdrol() { 
  return idrol; 
} 
public void setIdrol(Integer idrol) { 
  this.idrol = idrol; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 

} 
