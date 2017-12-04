package sernanp.app.dao.query.domain; 

public class GestionarAfpPlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_afp; 
private String var_cod_afp; 
private String var_nombre_afp; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_afp() { 
  return srl_id_afp; 
} 
public void setSrl_id_afp(Integer srl_id_afp) { 
  this.srl_id_afp = srl_id_afp; 
} 
public String getVar_cod_afp() { 
  return var_cod_afp; 
} 
public void setVar_cod_afp(String var_cod_afp) { 
  this.var_cod_afp = var_cod_afp; 
} 
public String getVar_nombre_afp() { 
  return var_nombre_afp; 
} 
public void setVar_nombre_afp(String var_nombre_afp) { 
  this.var_nombre_afp = var_nombre_afp; 
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
