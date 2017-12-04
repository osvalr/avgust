package sernanp.app.dao.query.domain; 

public class GestionarAfpPlanillaComisionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_afp; 

public GestionarAfpPlanillaComisionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_afp() { 
  return srl_id_afp; 
} 
public void setSrl_id_afp(Integer srl_id_afp) { 
  this.srl_id_afp = srl_id_afp; 
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
