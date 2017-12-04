package sernanp.app.dao.query.domain; 

public class RpNominaDescuentosMaestroQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_anio; 
private Integer int_id_periodo_mes; 
private Integer srl_id_regimen_pensionario; 
private Integer srl_id_regimen_contractual; 
private String c_fte_fto; 
private String nombre_completo; 
private String int_id_estado; 
private String c_meta; 

public RpNominaDescuentosMaestroQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
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
public Integer getSrl_id_regimen_pensionario() { 
  return srl_id_regimen_pensionario; 
} 
public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) { 
  this.srl_id_regimen_pensionario = srl_id_regimen_pensionario; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public String getC_fte_fto() { 
  return c_fte_fto; 
} 
public void setC_fte_fto(String c_fte_fto) { 
  this.c_fte_fto = c_fte_fto; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public String getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(String int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getC_meta() { 
  return c_meta; 
} 
public void setC_meta(String c_meta) { 
  this.c_meta = c_meta; 
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
