package sernanp.app.dao.query.domain; 

public class GestionarPlazaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idarea; 
private Integer idunidad; 
private Integer idpersonal; 
private Integer srl_id_convocatoria; 
private Integer srl_id_conv_area_org; 
private Integer int_id_estado; 
private Integer num_anio; 
//private String num_req; 

public GestionarPlazaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}

public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
} 
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getNum_anio() { 
  return num_anio; 
} 
public void setNum_anio(Integer num_anio) { 
  this.num_anio = num_anio; 
} 
//public String getNum_req() { 
//  return num_req; 
//} 
//public void setNum_req(String num_req) { 
//  this.num_req = num_req; 
//} 
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
