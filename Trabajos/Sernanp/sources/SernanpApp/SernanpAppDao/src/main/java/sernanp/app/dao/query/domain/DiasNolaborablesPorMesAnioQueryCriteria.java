package sernanp.app.dao.query.domain; 

public class DiasNolaborablesPorMesAnioQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_anio; 
private Integer int_mes; 

public DiasNolaborablesPorMesAnioQueryCriteria() {
this.orderColumn = "2";
this.orderDirecction = "DESC";
}
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getInt_mes() { 
  return int_mes; 
} 
public void setInt_mes(Integer int_mes) { 
  this.int_mes = int_mes; 
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
