package sernanp.app.dao.query.domain; 

public class ConvocatoriaAreaOrgFactorCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_conv_area_org; 
private Integer srl_conv_area_org_factor_eval; 

public ConvocatoriaAreaOrgFactorCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getSrl_conv_area_org_factor_eval() { 
  return srl_conv_area_org_factor_eval; 
} 
public void setSrl_conv_area_org_factor_eval(Integer srl_conv_area_org_factor_eval) { 
  this.srl_conv_area_org_factor_eval = srl_conv_area_org_factor_eval; 
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
