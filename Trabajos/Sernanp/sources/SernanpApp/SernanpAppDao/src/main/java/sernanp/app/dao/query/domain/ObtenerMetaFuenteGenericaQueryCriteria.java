package sernanp.app.dao.query.domain; 

public class ObtenerMetaFuenteGenericaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_meta_fuente_generica; 

public ObtenerMetaFuenteGenericaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_meta_fuente_generica() { 
  return srl_id_meta_fuente_generica; 
} 
public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) { 
  this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica; 
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
