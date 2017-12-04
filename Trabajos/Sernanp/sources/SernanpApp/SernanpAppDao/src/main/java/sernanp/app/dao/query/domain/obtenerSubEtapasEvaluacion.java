package sernanp.app.dao.query.domain; 

public class obtenerSubEtapasEvaluacion implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_subetapa_proceso_seleccion; 
private Integer srl_id_etapa_proceso_seleccion; 
private Integer idarea; 
private Integer idunidad; 
private String var_descrip_subetapa; 
private Integer int_id_estado; 

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
public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
} 
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public String getVar_descrip_subetapa() { 
  return var_descrip_subetapa; 
} 
public void setVar_descrip_subetapa(String var_descrip_subetapa) { 
  this.var_descrip_subetapa = var_descrip_subetapa; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 

} 
