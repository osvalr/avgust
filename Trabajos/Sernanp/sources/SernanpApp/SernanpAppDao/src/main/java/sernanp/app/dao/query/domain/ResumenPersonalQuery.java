package sernanp.app.dao.query.domain; 

public class ResumenPersonalQuery { 

private Integer idpersona; 
private Integer idpersonanatural; 
private String nombre_completo; 
private String tipoDoc; 
private String numeroDoc; 
private String numeroRuc; 
private String genero; 
private String nacionalidad; 
private String direccion; 
private String fechanacimiento; 
private String estadocivil; 

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
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public String getTipoDoc() { 
  return tipoDoc; 
} 
public void setTipoDoc(String tipoDoc) { 
  this.tipoDoc = tipoDoc; 
} 

public String getNumeroDoc() {
	return numeroDoc;
}
public void setNumeroDoc(String numeroDoc) {
	this.numeroDoc = numeroDoc;
}
public String getNumeroRuc() {
	return numeroRuc;
}
public void setNumeroRuc(String numeroRuc) {
	this.numeroRuc = numeroRuc;
}
public String getGenero() { 
  return genero; 
} 
public void setGenero(String genero) { 
  this.genero = genero; 
} 
public String getNacionalidad() { 
  return nacionalidad; 
} 
public void setNacionalidad(String nacionalidad) { 
  this.nacionalidad = nacionalidad; 
} 
public String getDireccion() { 
  return direccion; 
} 
public void setDireccion(String direccion) { 
  this.direccion = direccion; 
} 
public String getFechanacimiento() { 
  return fechanacimiento; 
} 
public void setFechanacimiento(String fechanacimiento) { 
  this.fechanacimiento = fechanacimiento; 
} 
public String getEstadocivil() { 
  return estadocivil; 
} 
public void setEstadocivil(String estadocivil) { 
  this.estadocivil = estadocivil; 
} 

} 
