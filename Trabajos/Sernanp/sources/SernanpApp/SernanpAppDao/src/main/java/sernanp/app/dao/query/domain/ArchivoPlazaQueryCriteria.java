package sernanp.app.dao.query.domain; 

public class ArchivoPlazaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_conv_area_org; 
private Integer srl_id_archivo; 

public ArchivoPlazaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getSrl_id_archivo() { 
  return srl_id_archivo; 
} 
public void setSrl_id_archivo(Integer srl_id_archivo) { 
  this.srl_id_archivo = srl_id_archivo; 
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
