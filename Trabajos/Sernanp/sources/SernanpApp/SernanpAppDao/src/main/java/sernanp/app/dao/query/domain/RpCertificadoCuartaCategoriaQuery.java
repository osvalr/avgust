package sernanp.app.dao.query.domain; 

public class RpCertificadoCuartaCategoriaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer int_anio; 
private Integer idpersonal; 
private String nombre_completo; 
private String ruc; 
private String direccion; 
private String var_nom_cargo; 
private Integer meses; 
private Double total_ingresos; 
private Double cuarta_cat; 

private Double neto;
private String ubicacion; 
private Integer idareanatural; 
private Integer srl_id_cargo; 

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
public String getRuc() { 
  return ruc; 
} 
public void setRuc(String ruc) { 
  this.ruc = ruc; 
} 
public String getDireccion() { 
  return direccion; 
} 
public void setDireccion(String direccion) { 
  this.direccion = direccion; 
} 
public String getVar_nom_cargo() { 
  return var_nom_cargo; 
} 
public void setVar_nom_cargo(String var_nom_cargo) { 
  this.var_nom_cargo = var_nom_cargo; 
} 
public Integer getMeses() { 
  return meses; 
} 
public void setMeses(Integer meses) { 
  this.meses = meses; 
} 
public Double getTotal_ingresos() { 
  return total_ingresos; 
} 
public void setTotal_ingresos(Double total_ingresos) { 
  this.total_ingresos = total_ingresos; 
} 
public Double getCuarta_cat() { 
  return cuarta_cat; 
} 
public void setCuarta_cat(Double cuarta_cat) { 
  this.cuarta_cat = cuarta_cat; 
} 

public String getUbicacion() { 
  return ubicacion; 
} 
public void setUbicacion(String ubicacion) { 
  this.ubicacion = ubicacion; 
} 
public Integer getIdareanatural() { 
  return idareanatural; 
} 
public void setIdareanatural(Integer idareanatural) { 
  this.idareanatural = idareanatural; 
} 
public Integer getSrl_id_cargo() { 
  return srl_id_cargo; 
} 
public void setSrl_id_cargo(Integer srl_id_cargo) { 
  this.srl_id_cargo = srl_id_cargo; 
}
public Double getNeto() {
	return neto;
}
public void setNeto(Double neto) {
	this.neto = neto;
} 

} 
