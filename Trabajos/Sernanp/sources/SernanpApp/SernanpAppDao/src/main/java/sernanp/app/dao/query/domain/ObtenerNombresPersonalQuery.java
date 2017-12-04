package sernanp.app.dao.query.domain; 

public class ObtenerNombresPersonalQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersonal; 
private String nombre_completo;
private String nombre;
private String apepat;
private String apemat;

public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public String getNombre() { 
  return nombre; 
} 
public void setNombre(String nombre) { 
  this.nombre = nombre; 
} 
public String getApepat() { 
  return apepat; 
} 
public void setApepat(String apepat) { 
  this.apepat = apepat; 
} 
public String getApemat() { 
  return apemat; 
} 
public void setApemat(String apemat) { 
  this.apemat = apemat; 
} 


} 
