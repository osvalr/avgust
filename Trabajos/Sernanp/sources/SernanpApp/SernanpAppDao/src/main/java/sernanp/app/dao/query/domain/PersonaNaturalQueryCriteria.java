package sernanp.app.dao.query.domain; 

public class PersonaNaturalQueryCriteria { 

private Integer idpersona; 
private Integer idpersonanatural; 
private String nombres_completos;


public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
}
public String getNombres_completos() {
	return nombres_completos;
}
public void setNombres_completos(String nombres_completos) {
	this.nombres_completos = nombres_completos;
} 

} 
