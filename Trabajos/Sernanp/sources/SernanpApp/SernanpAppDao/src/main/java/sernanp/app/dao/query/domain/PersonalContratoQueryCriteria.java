package sernanp.app.dao.query.domain; 

public class PersonalContratoQueryCriteria { 

private String nombres; 
private Integer tipoDoc; 
private String numeroDoc; 
private String numeroRuc; 

public String getNombres() { 
  return nombres; 
} 
public void setNombres(String nombres) { 
  this.nombres = nombres; 
} 
public Integer getTipoDoc() { 
  return tipoDoc; 
} 
public void setTipoDoc(Integer tipoDoc) { 
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

} 
