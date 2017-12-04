package sernanp.app.dao.query.domain; 

public class ObtenerUltimaActivacionPlazaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String var_num_convocatoria; 

public ObtenerUltimaActivacionPlazaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getVar_num_convocatoria() { 
  return var_num_convocatoria; 
} 
public void setVar_num_convocatoria(String var_num_convocatoria) { 
  this.var_num_convocatoria = var_num_convocatoria; 
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
