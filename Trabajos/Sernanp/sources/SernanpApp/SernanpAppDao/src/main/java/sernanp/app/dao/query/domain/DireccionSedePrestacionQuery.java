package sernanp.app.dao.query.domain; 

public class DireccionSedePrestacionQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idsede; 
private String direccion_sede_prestacion; 

public Integer getIdsede() { 
  return idsede; 
} 
public void setIdsede(Integer idsede) { 
  this.idsede = idsede; 
} 
public String getDireccion_sede_prestacion() { 
  return direccion_sede_prestacion; 
} 
public void setDireccion_sede_prestacion(String direccion_sede_prestacion) { 
  this.direccion_sede_prestacion = direccion_sede_prestacion; 
} 

} 
