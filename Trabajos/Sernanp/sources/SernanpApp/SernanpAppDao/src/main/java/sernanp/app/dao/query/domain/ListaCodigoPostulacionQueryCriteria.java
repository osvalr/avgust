package sernanp.app.dao.query.domain; 

public class ListaCodigoPostulacionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_convocatoria; 
private Integer int_num_activacion; 

public ListaCodigoPostulacionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public Integer getInt_num_activacion() { 
  return int_num_activacion; 
} 
public void setInt_num_activacion(Integer int_num_activacion) { 
  this.int_num_activacion = int_num_activacion; 
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
