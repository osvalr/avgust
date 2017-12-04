package sernanp.app.dao.query.domain; 

public class RpResumenAfpQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String nombres_completos; 
private Integer int_anio; 
private Integer srl_id_regimen_contractual; 
private Integer int_id_periodo_mes; 
private Integer srl_id_afp; 

public RpResumenAfpQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getNombres_completos() { 
  return nombres_completos; 
} 
public void setNombres_completos(String nombres_completos) { 
  this.nombres_completos = nombres_completos; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getInt_id_periodo_mes() { 
  return int_id_periodo_mes; 
} 
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) { 
  this.int_id_periodo_mes = int_id_periodo_mes; 
} 
public Integer getSrl_id_afp() { 
  return srl_id_afp; 
} 
public void setSrl_id_afp(Integer srl_id_afp) { 
  this.srl_id_afp = srl_id_afp; 
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
