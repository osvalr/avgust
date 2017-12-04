package sernanp.app.dao.query.domain; 

public class RptPlameMaestroCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_anio_periodo_planilla; 
private Integer srl_id_regimen_contractual; 
private String c_fte_fto; 

public RptPlameMaestroCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_anio_periodo_planilla() { 
  return srl_id_anio_periodo_planilla; 
} 
public void setSrl_id_anio_periodo_planilla(Integer srl_id_anio_periodo_planilla) { 
  this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla; 
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
