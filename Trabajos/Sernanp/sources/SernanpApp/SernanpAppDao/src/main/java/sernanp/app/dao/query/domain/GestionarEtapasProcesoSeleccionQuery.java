package sernanp.app.dao.query.domain; 

public class GestionarEtapasProcesoSeleccionQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_etapa_proceso_seleccion; 
private String var_nombre_etapa; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

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
