package sernanp.app.dao.query.domain; 

public class ObtenerDetalleDesvinculacionQuery { 

private Integer srl_id_estado_personal; 
private Integer idpersonal; 
private String var_motivo; 
private Integer int_id_estado; 
private Integer int_id_tipificacion; 
private String dte_fecha_estado; 
private String dte_fec_cese; 

public Integer getSrl_id_estado_personal() { 
  return srl_id_estado_personal; 
} 
public void setSrl_id_estado_personal(Integer srl_id_estado_personal) { 
  this.srl_id_estado_personal = srl_id_estado_personal; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getVar_motivo() { 
  return var_motivo; 
} 
public void setVar_motivo(String var_motivo) { 
  this.var_motivo = var_motivo; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getInt_id_tipificacion() { 
  return int_id_tipificacion; 
} 
public void setInt_id_tipificacion(Integer int_id_tipificacion) { 
  this.int_id_tipificacion = int_id_tipificacion; 
} 
public String getDte_fecha_estado() { 
  return dte_fecha_estado; 
} 
public void setDte_fecha_estado(String dte_fecha_estado) { 
  this.dte_fecha_estado = dte_fecha_estado; 
} 
public String getDte_fec_cese() { 
  return dte_fec_cese; 
} 
public void setDte_fec_cese(String dte_fec_cese) { 
  this.dte_fec_cese = dte_fec_cese; 
} 

} 
