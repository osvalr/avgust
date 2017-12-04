package sernanp.app.dao.query.domain; 

public class ArchivoRequerimientoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_archivo; 
private Integer srl_id_requerimiento_personal; 

public ArchivoRequerimientoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_archivo() { 
  return srl_id_archivo; 
} 
public void setSrl_id_archivo(Integer srl_id_archivo) { 
  this.srl_id_archivo = srl_id_archivo; 
} 
public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
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
