package sernanp.app.dao.query.domain; 

public class ConvocatoriaEtapaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_convocatoria; 
private Integer srl_id_conv_fecha_etapa_config; 

public ConvocatoriaEtapaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public Integer getSrl_id_conv_fecha_etapa_config() { 
  return srl_id_conv_fecha_etapa_config; 
} 
public void setSrl_id_conv_fecha_etapa_config(Integer srl_id_conv_fecha_etapa_config) { 
  this.srl_id_conv_fecha_etapa_config = srl_id_conv_fecha_etapa_config; 
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
