package sernanp.app.dao.query.domain; 

public class EstadoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_estado_tabla; 
private Integer srl_id_detalle_estado_tabla; 
private Integer var_cod_estado; 
private String var_nombre_estado; 
private java.util.Date tsp_fecha_registro; 

public Integer getSrl_id_estado_tabla() { 
  return srl_id_estado_tabla; 
} 
public void setSrl_id_estado_tabla(Integer srl_id_estado_tabla) { 
  this.srl_id_estado_tabla = srl_id_estado_tabla; 
} 
public Integer getSrl_id_detalle_estado_tabla() { 
  return srl_id_detalle_estado_tabla; 
} 
public void setSrl_id_detalle_estado_tabla(Integer srl_id_detalle_estado_tabla) { 
  this.srl_id_detalle_estado_tabla = srl_id_detalle_estado_tabla; 
} 
public Integer getVar_cod_estado() { 
  return var_cod_estado; 
} 
public void setVar_cod_estado(Integer var_cod_estado) { 
  this.var_cod_estado = var_cod_estado; 
} 
public String getVar_nombre_estado() { 
  return var_nombre_estado; 
} 
public void setVar_nombre_estado(String var_nombre_estado) { 
  this.var_nombre_estado = var_nombre_estado; 
} 
public java.util.Date getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(java.util.Date tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
