package sernanp.app.dao.query.domain; 

public class ObtenerSedeAdministrativaAreaOrganicaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idarea; 

public ObtenerSedeAdministrativaAreaOrganicaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
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
