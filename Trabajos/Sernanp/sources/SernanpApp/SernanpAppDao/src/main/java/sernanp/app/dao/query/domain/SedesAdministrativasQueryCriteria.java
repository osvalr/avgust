package sernanp.app.dao.query.domain; 

public class SedesAdministrativasQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_sede_req_sel; 

public SedesAdministrativasQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_sede_req_sel() { 
  return srl_id_sede_req_sel; 
} 
public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) { 
  this.srl_id_sede_req_sel = srl_id_sede_req_sel; 
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
