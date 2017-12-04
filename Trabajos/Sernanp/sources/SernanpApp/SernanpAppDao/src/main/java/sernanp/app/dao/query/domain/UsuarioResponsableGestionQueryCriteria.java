package sernanp.app.dao.query.domain; 

public class UsuarioResponsableGestionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idrol; 

public UsuarioResponsableGestionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdrol() { 
  return idrol; 
} 
public void setIdrol(Integer idrol) { 
  this.idrol = idrol; 
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
