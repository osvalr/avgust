package sernanp.app.dao.query.domain; 

public class GestionarAnioPlanillaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String var_cod_ejecutor; 
private String dte_fecha_fin; 
private Integer int_anio; 
private String dte_fecha_inicio; 
private Integer srl_id_anio_planilla; 

public GestionarAnioPlanillaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getVar_cod_ejecutor() { 
  return var_cod_ejecutor; 
} 
public void setVar_cod_ejecutor(String var_cod_ejecutor) { 
  this.var_cod_ejecutor = var_cod_ejecutor; 
} 
public String getDte_fecha_fin() { 
  return dte_fecha_fin; 
} 
public void setDte_fecha_fin(String dte_fecha_fin) { 
  this.dte_fecha_fin = dte_fecha_fin; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public String getDte_fecha_inicio() { 
  return dte_fecha_inicio; 
} 
public void setDte_fecha_inicio(String dte_fecha_inicio) { 
  this.dte_fecha_inicio = dte_fecha_inicio; 
} 
public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
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
