package sernanp.app.dao.query.domain; 

public class SuspensionPorPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idpersonal; 
private Integer anho_presenteacion; 

public SuspensionPorPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getAnho_presenteacion() { 
  return anho_presenteacion; 
} 
public void setAnho_presenteacion(Integer anho_presenteacion) { 
  this.anho_presenteacion = anho_presenteacion; 
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
