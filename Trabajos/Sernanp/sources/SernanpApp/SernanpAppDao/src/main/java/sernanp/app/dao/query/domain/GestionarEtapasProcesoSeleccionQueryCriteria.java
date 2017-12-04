package sernanp.app.dao.query.domain; 

public class GestionarEtapasProcesoSeleccionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_etapa_proceso_seleccion; 
private String var_nombre_etapa; 
private Integer int_id_estado; 

public GestionarEtapasProcesoSeleccionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getVar_nombre_etapa() { 
  return var_nombre_etapa; 
} 
public void setVar_nombre_etapa(String var_nombre_etapa) { 
  this.var_nombre_etapa = var_nombre_etapa; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
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
