package sernanp.app.dao.query.domain; 

public class RpDetalleBoletaPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_nomina_anio_periodo_personal; 
private Integer int_id_tipo_concepto; 
private Integer idpersonal; 
private Integer int_anio; 
private Integer int_id_periodo_mes; 

public RpDetalleBoletaPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public Integer getInt_id_tipo_concepto() { 
  return int_id_tipo_concepto; 
} 
public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) { 
  this.int_id_tipo_concepto = int_id_tipo_concepto; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getInt_id_periodo_mes() { 
  return int_id_periodo_mes; 
} 
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) { 
  this.int_id_periodo_mes = int_id_periodo_mes; 
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
