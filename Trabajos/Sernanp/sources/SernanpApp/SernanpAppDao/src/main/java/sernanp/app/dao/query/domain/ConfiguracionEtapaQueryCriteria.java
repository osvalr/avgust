package sernanp.app.dao.query.domain; 

public class ConfiguracionEtapaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_configuracion_etapa; 
private Integer srl_id_configuracion_evaluacion_personal; 

public ConfiguracionEtapaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_configuracion_etapa() { 
  return srl_id_configuracion_etapa; 
} 
public void setSrl_id_configuracion_etapa(Integer srl_id_configuracion_etapa) { 
  this.srl_id_configuracion_etapa = srl_id_configuracion_etapa; 
} 
public Integer getSrl_id_configuracion_evaluacion_personal() { 
  return srl_id_configuracion_evaluacion_personal; 
} 
public void setSrl_id_configuracion_evaluacion_personal(Integer srl_id_configuracion_evaluacion_personal) { 
  this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal; 
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
