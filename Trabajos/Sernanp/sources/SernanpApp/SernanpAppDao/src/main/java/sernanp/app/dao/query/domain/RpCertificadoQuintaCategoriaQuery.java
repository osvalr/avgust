package sernanp.app.dao.query.domain; 

public class RpCertificadoQuintaCategoriaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer int_anio; 
private Integer idpersonal; 

private String nombre_completo; 
private String numerodoc; 
private String direccion; 
private String cargo; 
private Double total_ingresos; 
private Double aporte_obligatorio; 
private Double quinta_cat; 
private Double retencion; 

/*ADD 29-12-2015 DAVID*/
private Integer srl_id_regimen_pensionario;

public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
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
public String getDireccion() { 
  return direccion; 
} 
public void setDireccion(String direccion) { 
  this.direccion = direccion; 
} 
public String getCargo() { 
  return cargo; 
} 
public void setCargo(String cargo) { 
  this.cargo = cargo; 
} 
public Double getTotal_ingresos() { 
  return total_ingresos; 
} 
public void setTotal_ingresos(Double total_ingresos) { 
  this.total_ingresos = total_ingresos; 
} 
public Double getAporte_obligatorio() { 
  return aporte_obligatorio; 
} 
public void setAporte_obligatorio(Double aporte_obligatorio) { 
  this.aporte_obligatorio = aporte_obligatorio; 
} 
public Double getQuinta_cat() { 
  return quinta_cat; 
} 
public void setQuinta_cat(Double quinta_cat) { 
  this.quinta_cat = quinta_cat; 
} 
public Double getRetencion() { 
  return retencion; 
} 
public void setRetencion(Double retencion) { 
  this.retencion = retencion; 
}
public Integer getSrl_id_regimen_pensionario() {
	return srl_id_regimen_pensionario;
}
public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) {
	this.srl_id_regimen_pensionario = srl_id_regimen_pensionario;
} 

} 
