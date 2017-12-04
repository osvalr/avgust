package sernanp.app.dao.query.domain; 

public class GestionarAnioPlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_anio_planilla; 
private String var_cod_ejecutor; 
private Integer int_anio; 
private String var_nombre_anio; 
private String dte_fecha_inicio; 
private String dte_fecha_fin; 
private Integer int_id_estado_vigencia; 
private String descrip_estado_vigencia; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
} 
public String getVar_cod_ejecutor() { 
  return var_cod_ejecutor; 
} 
public void setVar_cod_ejecutor(String var_cod_ejecutor) { 
  this.var_cod_ejecutor = var_cod_ejecutor; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public String getVar_nombre_anio() { 
  return var_nombre_anio; 
} 
public void setVar_nombre_anio(String var_nombre_anio) { 
  this.var_nombre_anio = var_nombre_anio; 
} 
public String getDte_fecha_inicio() { 
  return dte_fecha_inicio; 
} 
public void setDte_fecha_inicio(String dte_fecha_inicio) { 
  this.dte_fecha_inicio = dte_fecha_inicio; 
} 
public String getDte_fecha_fin() { 
  return dte_fecha_fin; 
} 
public void setDte_fecha_fin(String dte_fecha_fin) { 
  this.dte_fecha_fin = dte_fecha_fin; 
} 
public Integer getInt_id_estado_vigencia() { 
  return int_id_estado_vigencia; 
} 
public void setInt_id_estado_vigencia(Integer int_id_estado_vigencia) { 
  this.int_id_estado_vigencia = int_id_estado_vigencia; 
} 
public String getDescrip_estado_vigencia() { 
  return descrip_estado_vigencia; 
} 
public void setDescrip_estado_vigencia(String descrip_estado_vigencia) { 
  this.descrip_estado_vigencia = descrip_estado_vigencia; 
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
