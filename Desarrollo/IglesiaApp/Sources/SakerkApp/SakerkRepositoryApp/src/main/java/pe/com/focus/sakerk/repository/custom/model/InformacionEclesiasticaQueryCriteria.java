package pe.com.focus.sakerk.repository.custom.model; 

public class InformacionEclesiasticaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_info_eclesiastica; 
private Integer id_persona_natural; 

public InformacionEclesiasticaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_info_eclesiastica() { 
  return id_info_eclesiastica; 
} 
public void setId_info_eclesiastica(Integer id_info_eclesiastica) { 
  this.id_info_eclesiastica = id_info_eclesiastica; 
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
