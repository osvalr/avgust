package sernanp.app.dao.query.domain; 

public class ConfiguracionEtapaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_configuracion_etapa; 
private Integer srl_id_configuracion_evaluacion_personal; 
private Integer srl_id_etapa_proceso_seleccion; 
private String var_nombre_etapa; 
private Integer srl_id_subetapa_proceso_seleccion; 
private String var_descrip_subetapa; 
private Integer int_orden; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_configuracion_etapa() { 
  return srl_id_configuracion_etapa; 
} 
public void setSrl_id_configuracion_etapa(Integer srl_id_configuracion_etapa) { 
  this.srl_id_configuracion_etapa = srl_id_configuracion_etapa; 
} 
public Integer getSrl_id_configuracion_evaluacion_personal() { 
  return srl_id_configuracion_evaluacion_personal; 
} 
public void setSrl_id_configuracion_evaluacion_personal(Integer srl_id_configuracion_evaluacion_personal) { 
  this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal; 
} 
public Integer getSrl_id_etapa_proceso_seleccion() { 
  return srl_id_etapa_proceso_seleccion; 
} 
public void setSrl_id_etapa_proceso_seleccion(Integer srl_id_etapa_proceso_seleccion) { 
  this.srl_id_etapa_proceso_seleccion = srl_id_etapa_proceso_seleccion; 
} 
public String getVar_nombre_etapa() { 
  return var_nombre_etapa; 
} 
public void setVar_nombre_etapa(String var_nombre_etapa) { 
  this.var_nombre_etapa = var_nombre_etapa; 
} 
public Integer getSrl_id_subetapa_proceso_seleccion() { 
  return srl_id_subetapa_proceso_seleccion; 
} 
public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) { 
  this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion; 
} 
public String getVar_descrip_subetapa() { 
  return var_descrip_subetapa; 
} 
public void setVar_descrip_subetapa(String var_descrip_subetapa) { 
  this.var_descrip_subetapa = var_descrip_subetapa; 
} 
public Integer getInt_orden() { 
  return int_orden; 
} 
public void setInt_orden(Integer int_orden) { 
  this.int_orden = int_orden; 
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
