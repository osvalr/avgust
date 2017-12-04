package sernanp.app.dao.query.domain; 

public class ConvocatoriaPlazaReqQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_convocatoria; 
private Integer srl_id_conv_area_org; 
private Integer srl_id_requerimiento_personal; 

public ConvocatoriaPlazaReqQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
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
