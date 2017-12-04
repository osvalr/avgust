package sernanp.app.dao.query.domain; 

public class GestionarTrabajadoresQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String nombre_completo; 
private String numerodoc; 
private String ruc; 
private Integer idtipodocumento; 

public GestionarTrabajadoresQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getRuc() { 
  return ruc; 
} 
public void setRuc(String ruc) { 
  this.ruc = ruc; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
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
