package sernanp.app.dao.query.domain; 

public class GestionarNominaTotalesQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer cantidad_nominas; 
private Double total_ingresos; 
private Double total_descuentos; 
private Double total_aportes; 
private Double total_neto; 

public Integer getCantidad_nominas() { 
  return cantidad_nominas; 
} 
public void setCantidad_nominas(Integer cantidad_nominas) { 
  this.cantidad_nominas = cantidad_nominas; 
} 
public Double getTotal_ingresos() { 
  return total_ingresos; 
} 
public void setTotal_ingresos(Double total_ingresos) { 
  this.total_ingresos = total_ingresos; 
} 
public Double getTotal_descuentos() { 
  return total_descuentos; 
} 
public void setTotal_descuentos(Double total_descuentos) { 
  this.total_descuentos = total_descuentos; 
} 
public Double getTotal_aportes() { 
  return total_aportes; 
} 
public void setTotal_aportes(Double total_aportes) { 
  this.total_aportes = total_aportes; 
} 
public Double getTotal_neto() { 
  return total_neto; 
} 
public void setTotal_neto(Double total_neto) { 
  this.total_neto = total_neto; 
} 

} 
