package sernanp.app.dao.query.domain; 

public class RpSeleccionPostulantesFichaPostulacionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String nombre_completo; 
private Integer srl_id_convocatoria; 
private String numerodoc; 
private Integer srl_id_conv_area_org; 
private Integer int_id_tipo_factor;
/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
private Integer srl_id_sede_req_sel;
//private Integer srl_id_sede_uni_ope_anp;
/*END*/

public RpSeleccionPostulantesFichaPostulacionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
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
public Integer getSrl_id_conv_area_org() {
	return srl_id_conv_area_org;
}
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
	this.srl_id_conv_area_org = srl_id_conv_area_org;
}
public Integer getInt_id_tipo_factor() {
	return int_id_tipo_factor;
}
public void setInt_id_tipo_factor(Integer int_id_tipo_factor) {
	this.int_id_tipo_factor = int_id_tipo_factor;
}
public Integer getSrl_id_sede_req_sel() {
	return srl_id_sede_req_sel;
}
public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) {
	this.srl_id_sede_req_sel = srl_id_sede_req_sel;
}


}


