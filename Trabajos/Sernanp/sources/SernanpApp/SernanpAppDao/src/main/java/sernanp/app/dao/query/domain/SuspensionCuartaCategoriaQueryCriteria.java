package sernanp.app.dao.query.domain; 

public class SuspensionCuartaCategoriaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_suspension_cuarta_categoria; 
private Integer idpersonal; 

public SuspensionCuartaCategoriaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_suspension_cuarta_categoria() { 
  return srl_id_suspension_cuarta_categoria; 
} 
public void setSrl_id_suspension_cuarta_categoria(Integer srl_id_suspension_cuarta_categoria) { 
  this.srl_id_suspension_cuarta_categoria = srl_id_suspension_cuarta_categoria; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
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
