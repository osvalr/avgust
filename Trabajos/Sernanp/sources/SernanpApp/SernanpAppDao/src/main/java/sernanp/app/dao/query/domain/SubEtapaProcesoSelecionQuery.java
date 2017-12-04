package sernanp.app.dao.query.domain; 

public class SubEtapaProcesoSelecionQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_subetapa_proceso_seleccion; 
private Integer srl_id_etapa_proceso_seleccion; 
private Integer idarea; 
private String desarea; 
private Integer idunidad; 
private String nomunidad; 
private String var_descrip_subetapa; 
private String var_detalle_subetapa; 
private Integer int_id_estado; 
private String descrip_estado; 
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
public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
} 
public String getDesarea() { 
  return desarea; 
} 
public void setDesarea(String desarea) { 
  this.desarea = desarea; 
} 
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public String getNomunidad() { 
  return nomunidad; 
} 
public void setNomunidad(String nomunidad) { 
  this.nomunidad = nomunidad; 
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
