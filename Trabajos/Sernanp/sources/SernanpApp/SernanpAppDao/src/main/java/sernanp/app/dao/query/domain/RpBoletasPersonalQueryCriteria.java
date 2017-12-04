package sernanp.app.dao.query.domain; 

public class RpBoletasPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String nombre_completo; 
private Integer int_anio; 
private Integer int_id_periodo_mes; 
private Integer srl_id_regimen_contractual; 
private Integer int_id_estado; 
private Integer srl_id_fuente_financiamiento; 

public RpBoletasPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getInt_id_periodo_mes() { 
  return int_id_periodo_mes; 
} 
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) { 
  this.int_id_periodo_mes = int_id_periodo_mes; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getSrl_id_fuente_financiamiento() { 
  return srl_id_fuente_financiamiento; 
} 
public void setSrl_id_fuente_financiamiento(Integer srl_id_fuente_financiamiento) { 
  this.srl_id_fuente_financiamiento = srl_id_fuente_financiamiento; 
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
