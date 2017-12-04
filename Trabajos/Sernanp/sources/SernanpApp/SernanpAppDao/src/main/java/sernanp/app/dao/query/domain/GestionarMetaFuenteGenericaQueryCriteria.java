package sernanp.app.dao.query.domain; 

public class GestionarMetaFuenteGenericaQueryCriteria { 

private String orderColumn;
private String orderDirecction;

private Integer srl_id_meta_fuente_generica; 
private Integer srl_id_anio_planilla; 
private Integer srl_id_meta_presupuestaria; 
private Integer srl_id_fuente_financiamiento; 
private Integer srl_id_generica_gasto; 
private Integer srl_id_clasificador; 
private Integer idarea; 
private Integer idunidad; 
private Integer int_id_estado; 

public GestionarMetaFuenteGenericaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
} 
public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getSrl_id_meta_fuente_generica() { 
  return srl_id_meta_fuente_generica; 
} 
public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) { 
  this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica; 
} 
public Integer getSrl_id_fuente_financiamiento() { 
  return srl_id_fuente_financiamiento; 
} 
public void setSrl_id_fuente_financiamiento(Integer srl_id_fuente_financiamiento) { 
  this.srl_id_fuente_financiamiento = srl_id_fuente_financiamiento; 
} 
public Integer getSrl_id_generica_gasto() { 
  return srl_id_generica_gasto; 
} 
public void setSrl_id_generica_gasto(Integer srl_id_generica_gasto) { 
  this.srl_id_generica_gasto = srl_id_generica_gasto; 
} 
public Integer getSrl_id_clasificador() { 
  return srl_id_clasificador; 
} 
public void setSrl_id_clasificador(Integer srl_id_clasificador) { 
  this.srl_id_clasificador = srl_id_clasificador; 
} 
public Integer getSrl_id_meta_presupuestaria() { 
  return srl_id_meta_presupuestaria; 
} 
public void setSrl_id_meta_presupuestaria(Integer srl_id_meta_presupuestaria) { 
  this.srl_id_meta_presupuestaria = srl_id_meta_presupuestaria; 
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
