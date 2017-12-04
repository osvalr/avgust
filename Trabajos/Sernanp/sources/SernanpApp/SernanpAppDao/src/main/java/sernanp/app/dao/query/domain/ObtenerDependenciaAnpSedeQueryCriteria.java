package sernanp.app.dao.query.domain; 

public class ObtenerDependenciaAnpSedeQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_unidad_operativa; 

public ObtenerDependenciaAnpSedeQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_unidad_operativa() { 
  return srl_id_unidad_operativa; 
} 
public void setSrl_id_unidad_operativa(Integer srl_id_unidad_operativa) { 
  this.srl_id_unidad_operativa = srl_id_unidad_operativa; 
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
