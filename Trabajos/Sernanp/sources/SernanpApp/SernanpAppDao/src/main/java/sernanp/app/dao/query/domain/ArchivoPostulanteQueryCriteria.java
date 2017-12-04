package sernanp.app.dao.query.domain; 

public class ArchivoPostulanteQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_archivo; 
private Integer int_id_postulante; 

public ArchivoPostulanteQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_archivo() { 
  return srl_id_archivo; 
} 
public void setSrl_id_archivo(Integer srl_id_archivo) { 
  this.srl_id_archivo = srl_id_archivo; 
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
