package sernanp.app.dao.query.domain; 

public class PostulanteNumeroTelefonoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_numero_telefono; 
private Integer int_id_postulante; 

public PostulanteNumeroTelefonoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_numero_telefono() { 
  return srl_id_numero_telefono; 
} 
public void setSrl_id_numero_telefono(Integer srl_id_numero_telefono) { 
  this.srl_id_numero_telefono = srl_id_numero_telefono; 
} 
public Integer getInt_id_postulante() { 
  return int_id_postulante; 
} 
public void setInt_id_postulante(Integer int_id_postulante) { 
  this.int_id_postulante = int_id_postulante; 
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
