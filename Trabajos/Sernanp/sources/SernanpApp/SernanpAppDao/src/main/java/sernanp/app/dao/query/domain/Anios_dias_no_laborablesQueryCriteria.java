package sernanp.app.dao.query.domain; 

public class Anios_dias_no_laborablesQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_no_laborable; 

public Anios_dias_no_laborablesQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_no_laborable() { 
  return srl_id_no_laborable; 
} 
public void setSrl_id_no_laborable(Integer srl_id_no_laborable) { 
  this.srl_id_no_laborable = srl_id_no_laborable; 
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
