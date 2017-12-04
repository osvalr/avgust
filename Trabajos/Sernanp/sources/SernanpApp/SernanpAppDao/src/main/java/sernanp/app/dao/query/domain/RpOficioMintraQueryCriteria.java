package sernanp.app.dao.query.domain; 

public class RpOficioMintraQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_id_estado; 
private Integer idarea_solicitante; 
private String var_denominacion_requerimiento; 
private Integer srl_id_convocatoria;

public RpOficioMintraQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getIdarea_solicitante() { 
  return idarea_solicitante; 
} 
public void setIdarea_solicitante(Integer idarea_solicitante) { 
  this.idarea_solicitante = idarea_solicitante; 
} 
public String getVar_denominacion_requerimiento() { 
  return var_denominacion_requerimiento; 
} 
public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) { 
  this.var_denominacion_requerimiento = var_denominacion_requerimiento; 
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
public Integer getSrl_id_convocatoria() {
	return srl_id_convocatoria;
}
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
	this.srl_id_convocatoria = srl_id_convocatoria;
}

} 
