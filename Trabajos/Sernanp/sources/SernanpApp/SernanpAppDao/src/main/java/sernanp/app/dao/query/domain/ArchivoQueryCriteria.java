package sernanp.app.dao.query.domain; 

public class ArchivoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_archivo; 
private Integer srl_id_comision_archivo; 

public ArchivoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_archivo() { 
  return srl_id_archivo; 
} 
public void setSrl_id_archivo(Integer srl_id_archivo) { 
  this.srl_id_archivo = srl_id_archivo; 
} 
public Integer getSrl_id_comision_archivo() { 
  return srl_id_comision_archivo; 
} 
public void setSrl_id_comision_archivo(Integer srl_id_comision_archivo) { 
  this.srl_id_comision_archivo = srl_id_comision_archivo; 
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
