package sernanp.app.dao.query.domain; 

public class RpSeleccionPostulantesEvaluacionEscritaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String var_descrip_subetapa; 
private String nombre_completo; 
private Integer srl_id_convocatoria; 
private Integer srl_id_conv_area_org; 
private String numerodoc; 

public RpSeleccionPostulantesEvaluacionEscritaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getVar_descrip_subetapa() { 
  return var_descrip_subetapa; 
} 
public void setVar_descrip_subetapa(String var_descrip_subetapa) { 
  this.var_descrip_subetapa = var_descrip_subetapa; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
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
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getOrderColumn() {
return orderColumn;
}
public void setOrderColumn(String orderColumn) {
this.orderColumn = orderColumn;
}
public String getOrderDirecction() {
return orderDirecction;
}
public void setOrderDirecction(String orderDirecction) {
this.orderDirecction = orderDirecction;
}

} 
