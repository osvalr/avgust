package sernanp.app.dao.query.domain; 

public class GestionarAfpPlanillaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_id_estado; 
private String var_cod_afp; 
private String var_nombre_afp; 
private Integer srl_id_afp; 

public GestionarAfpPlanillaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_cod_afp() { 
  return var_cod_afp; 
} 
public void setVar_cod_afp(String var_cod_afp) { 
  this.var_cod_afp = var_cod_afp; 
} 
public String getVar_nombre_afp() { 
  return var_nombre_afp; 
} 
public void setVar_nombre_afp(String var_nombre_afp) { 
  this.var_nombre_afp = var_nombre_afp; 
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
