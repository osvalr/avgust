package sernanp.app.dao.query.domain; 

public class SuspensionCuartaCategoriaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_suspension_cuarta_categoria; 
private Integer idpersonal; 
private String var_num_operacion; 
private String dte_fecha_presentacion; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

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
public String getDte_fecha_presentacion() { 
  return dte_fecha_presentacion; 
} 
public void setDte_fecha_presentacion(String dte_fecha_presentacion) { 
  this.dte_fecha_presentacion = dte_fecha_presentacion; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getDescrip_estado() { 
  return descrip_estado; 
} 
public void setDescrip_estado(String descrip_estado) { 
  this.descrip_estado = descrip_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
