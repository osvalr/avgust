package sernanp.app.dao.query.domain; 

public class PostulacionPersonaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_postulante_conv_area_org; 
private Integer int_id_postulante; 

public PostulacionPersonaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_postulante_conv_area_org() { 
  return srl_id_postulante_conv_area_org; 
} 
public void setSrl_id_postulante_conv_area_org(Integer srl_id_postulante_conv_area_org) { 
  this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org; 
} 
public Integer getInt_id_postulante() { 
  return int_id_postulante; 
} 
public void setInt_id_postulante(Integer int_id_postulante) { 
  this.int_id_postulante = int_id_postulante; 
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
