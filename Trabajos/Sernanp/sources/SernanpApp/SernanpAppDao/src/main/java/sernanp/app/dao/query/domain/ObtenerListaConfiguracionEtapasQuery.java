package sernanp.app.dao.query.domain; 

public class ObtenerListaConfiguracionEtapasQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_subetapa_proceso_seleccion; 
private Integer srl_id_etapa_proceso_seleccion; 
private String var_nombre_etapa; 
private String var_descrip_subetapa; 
private String var_detalle_subetapa; 
private Integer int_id_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_subetapa_proceso_seleccion() { 
  return srl_id_subetapa_proceso_seleccion; 
} 
public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) { 
  this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion; 
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
public String getVar_descrip_subetapa() { 
  return var_descrip_subetapa; 
} 
public void setVar_descrip_subetapa(String var_descrip_subetapa) { 
  this.var_descrip_subetapa = var_descrip_subetapa; 
} 
public String getVar_detalle_subetapa() { 
  return var_detalle_subetapa; 
} 
public void setVar_detalle_subetapa(String var_detalle_subetapa) { 
  this.var_detalle_subetapa = var_detalle_subetapa; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
