package sernanp.app.dao.query.domain; 

public class SubEtapaPorPlazaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_conv_area_org; 
private Integer srl_id_etapa_proceso_seleccion; 

public SubEtapaPorPlazaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getSrl_id_etapa_proceso_seleccion() { 
  return srl_id_etapa_proceso_seleccion; 
} 
public void setSrl_id_etapa_proceso_seleccion(Integer srl_id_etapa_proceso_seleccion) { 
  this.srl_id_etapa_proceso_seleccion = srl_id_etapa_proceso_seleccion; 
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
