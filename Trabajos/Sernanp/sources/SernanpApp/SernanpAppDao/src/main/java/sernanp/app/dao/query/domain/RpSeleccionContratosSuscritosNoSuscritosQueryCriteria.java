package sernanp.app.dao.query.domain; 

public class RpSeleccionContratosSuscritosNoSuscritosQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String nombre_completo; 
private String numerodoc;
private Integer srl_id_convocatoria; 
private Integer idunidad; 
private Integer idarea; 
private Integer srl_id_conv_area_org; 
private Integer int_id_estado; 
private Integer var_cod_estado;
//private Integer int_estado_postulante_prop;

/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
private Integer srl_id_sede_req_sel;
//private Integer srl_id_sede_uni_ope_anp;
/*END*/


public RpSeleccionContratosSuscritosNoSuscritosQueryCriteria() {
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
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
} 
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
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
public Integer getVar_cod_estado() {
	return var_cod_estado;
}
public void setVar_cod_estado(Integer var_cod_estado) {
	this.var_cod_estado = var_cod_estado;
}
public String getNumerodoc() {
	return numerodoc;
}
public void setNumerodoc(String numerodoc) {
	this.numerodoc = numerodoc;
}

//public Integer getInt_estado_postulante_prop() {
//	return int_estado_postulante_prop;
//}
//public void setInt_estado_postulante_prop(Integer int_estado_postulante_prop) {
//	this.int_estado_postulante_prop = int_estado_postulante_prop;
//}
public Integer getSrl_id_sede_req_sel() {
	return srl_id_sede_req_sel;
}
public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) {
	this.srl_id_sede_req_sel = srl_id_sede_req_sel;
}

} 
