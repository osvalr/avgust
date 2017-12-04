package sernanp.app.dao.query.domain; 

public class ObtenerSedeAdministrativaUnidadOperativaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idunidad; 
private String sede_administrativa_req_sel; 
private Integer int_sede_principal; 

public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public String getSede_administrativa_req_sel() { 
  return sede_administrativa_req_sel; 
} 
public void setSede_administrativa_req_sel(String sede_administrativa_req_sel) { 
  this.sede_administrativa_req_sel = sede_administrativa_req_sel; 
} 
public Integer getInt_sede_principal() { 
  return int_sede_principal; 
} 
public void setInt_sede_principal(Integer int_sede_principal) { 
  this.int_sede_principal = int_sede_principal; 
} 

} 
