package sernanp.app.dao.query.domain; 

public class GestionarAnioPeriodoPlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_anio_periodo_planilla; 
private Integer srl_id_anio_planilla; 
private Integer int_id_periodo_mes; 
private String var_des_periodo_mes; 
private String dte_fecha_inicio_periodo; 
private String dte_fecha_fin_periodo; 
private Integer int_id_estado; 
private String var_des_tipo_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_anio_periodo_planilla() { 
  return srl_id_anio_periodo_planilla; 
} 
public void setSrl_id_anio_periodo_planilla(Integer srl_id_anio_periodo_planilla) { 
  this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla; 
} 
public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
} 
public Integer getInt_id_periodo_mes() { 
  return int_id_periodo_mes; 
} 
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) { 
  this.int_id_periodo_mes = int_id_periodo_mes; 
} 
public String getVar_des_periodo_mes() { 
  return var_des_periodo_mes; 
} 
public void setVar_des_periodo_mes(String var_des_periodo_mes) { 
  this.var_des_periodo_mes = var_des_periodo_mes; 
} 
public String getDte_fecha_inicio_periodo() { 
  return dte_fecha_inicio_periodo; 
} 
public void setDte_fecha_inicio_periodo(String dte_fecha_inicio_periodo) { 
  this.dte_fecha_inicio_periodo = dte_fecha_inicio_periodo; 
} 
public String getDte_fecha_fin_periodo() { 
  return dte_fecha_fin_periodo; 
} 
public void setDte_fecha_fin_periodo(String dte_fecha_fin_periodo) { 
  this.dte_fecha_fin_periodo = dte_fecha_fin_periodo; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_des_tipo_estado() { 
  return var_des_tipo_estado; 
} 
public void setVar_des_tipo_estado(String var_des_tipo_estado) { 
  this.var_des_tipo_estado = var_des_tipo_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
