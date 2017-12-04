package sernanp.app.dao.query.domain; 

public class ObtenerDatosReqPlazaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_requerimiento_personal; 
private Integer int_id_estado; 

// ADD 01-02-2016 DAVID
private Integer srl_id_convocatoria;


public ObtenerDatosReqPlazaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
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
public Integer getSrl_id_convocatoria() {
	return srl_id_convocatoria;
}
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
	this.srl_id_convocatoria = srl_id_convocatoria;
}

} 
