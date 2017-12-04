package sernanp.app.dao.query.domain; 

public class SuspensionPorPersonalQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_suspension_cuarta_categoria; 
private Integer idpersonal; 
private String var_num_operacion; 
private java.util.Date dte_fecha_presentacion; 
private Integer anho_presenteacion; 
private Integer int_id_estado; 
private java.util.Date tsp_fecha_registro; 

public Integer getSrl_id_suspension_cuarta_categoria() { 
  return srl_id_suspension_cuarta_categoria; 
} 
public void setSrl_id_suspension_cuarta_categoria(Integer srl_id_suspension_cuarta_categoria) { 
  this.srl_id_suspension_cuarta_categoria = srl_id_suspension_cuarta_categoria; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getVar_num_operacion() { 
  return var_num_operacion; 
} 
public void setVar_num_operacion(String var_num_operacion) { 
  this.var_num_operacion = var_num_operacion; 
} 
public java.util.Date getDte_fecha_presentacion() { 
  return dte_fecha_presentacion; 
} 
public void setDte_fecha_presentacion(java.util.Date dte_fecha_presentacion) { 
  this.dte_fecha_presentacion = dte_fecha_presentacion; 
} 
public Integer getAnho_presenteacion() { 
  return anho_presenteacion; 
} 
public void setAnho_presenteacion(Integer anho_presenteacion) { 
  this.anho_presenteacion = anho_presenteacion; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public java.util.Date getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(java.util.Date tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
