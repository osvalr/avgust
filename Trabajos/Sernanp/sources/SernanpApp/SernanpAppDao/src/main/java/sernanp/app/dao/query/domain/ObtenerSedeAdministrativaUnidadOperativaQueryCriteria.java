package sernanp.app.dao.query.domain; 

public class ObtenerSedeAdministrativaUnidadOperativaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idunidad; 

public ObtenerSedeAdministrativaUnidadOperativaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
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
