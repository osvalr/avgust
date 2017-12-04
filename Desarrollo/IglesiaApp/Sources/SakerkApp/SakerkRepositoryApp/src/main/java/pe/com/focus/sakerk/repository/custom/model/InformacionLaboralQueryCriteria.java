package pe.com.focus.sakerk.repository.custom.model; 

public class InformacionLaboralQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_informacion_laboral; 
private Integer id_persona_natural; 

public InformacionLaboralQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_informacion_laboral() { 
  return id_informacion_laboral; 
} 
public void setId_informacion_laboral(Integer id_informacion_laboral) { 
  this.id_informacion_laboral = id_informacion_laboral; 
} 
public Integer getId_persona_natural() { 
  return id_persona_natural; 
} 
public void setId_persona_natural(Integer id_persona_natural) { 
  this.id_persona_natural = id_persona_natural; 
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
