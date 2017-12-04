package sernanp.app.dao.query.domain; 

public class RequerimientoDisponibleQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_requerimiento_personal; 
private String var_numero_requerimiento; 
private String var_numero_requerimiento_corto; 

public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
} 
public String getVar_numero_requerimiento() { 
  return var_numero_requerimiento; 
} 
public void setVar_numero_requerimiento(String var_numero_requerimiento) { 
  this.var_numero_requerimiento = var_numero_requerimiento; 
} 
public String getVar_numero_requerimiento_corto() { 
  return var_numero_requerimiento_corto; 
} 
public void setVar_numero_requerimiento_corto(String var_numero_requerimiento_corto) { 
  this.var_numero_requerimiento_corto = var_numero_requerimiento_corto; 
} 

} 
