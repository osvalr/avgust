package sernanp.app.dao.query.domain; 

public class ConvocatoriaPlazaReqQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_convocatoria; 
private Integer srl_id_conv_area_org; 
private Integer srl_id_requerimiento_personal; 
private String var_numero_requerimiento; 
private String var_denominacion_requerimiento; 

public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
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
public String getVar_denominacion_requerimiento() { 
  return var_denominacion_requerimiento; 
} 
public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) { 
  this.var_denominacion_requerimiento = var_denominacion_requerimiento; 
} 

} 
