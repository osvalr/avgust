package sernanp.app.dao.query.domain; 

public class GestionarConceptoQueryCriteria { 

private String orderColumn;
private String orderDirecction;

private Integer srl_id_concepto_planilla; 
private String var_cod_concepto; 
private String var_cod_pdt_concepto; 
private String var_cod_mef_concepto; 
private String var_cod_siaf_concepto; 
private String var_descrip_corto_concepto; 
private Integer int_id_tipo_concepto; 
private Integer int_id_sub_tipo_concepto; 
private Integer int_id_estado; 

public GestionarConceptoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getVar_cod_concepto() { 
  return var_cod_concepto; 
} 
public void setVar_cod_concepto(String var_cod_concepto) { 
  this.var_cod_concepto = var_cod_concepto; 
} 
public String getVar_cod_pdt_concepto() { 
  return var_cod_pdt_concepto; 
} 
public void setVar_cod_pdt_concepto(String var_cod_pdt_concepto) { 
  this.var_cod_pdt_concepto = var_cod_pdt_concepto; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getInt_id_tipo_concepto() { 
  return int_id_tipo_concepto; 
} 
public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) { 
  this.int_id_tipo_concepto = int_id_tipo_concepto; 
} 
public String getVar_descrip_corto_concepto() { 
  return var_descrip_corto_concepto; 
} 
public void setVar_descrip_corto_concepto(String var_descrip_corto_concepto) { 
  this.var_descrip_corto_concepto = var_descrip_corto_concepto; 
} 
public String getVar_cod_mef_concepto() { 
  return var_cod_mef_concepto; 
} 
public void setVar_cod_mef_concepto(String var_cod_mef_concepto) { 
  this.var_cod_mef_concepto = var_cod_mef_concepto; 
} 
public String getVar_cod_siaf_concepto() { 
  return var_cod_siaf_concepto; 
} 
public void setVar_cod_siaf_concepto(String var_cod_siaf_concepto) { 
  this.var_cod_siaf_concepto = var_cod_siaf_concepto; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
} 
public Integer getInt_id_sub_tipo_concepto() { 
  return int_id_sub_tipo_concepto; 
} 
public void setInt_id_sub_tipo_concepto(Integer int_id_sub_tipo_concepto) { 
  this.int_id_sub_tipo_concepto = int_id_sub_tipo_concepto; 
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
