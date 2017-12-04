package sernanp.app.dao.query.domain; 

public class PersonalConceptoFrecuenciaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_frecuencia; 
private Integer srl_id_personal_concepto; 
private Integer int_id_mes; 
private String descrip_mes; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_frecuencia() { 
  return srl_id_frecuencia; 
} 
public void setSrl_id_frecuencia(Integer srl_id_frecuencia) { 
  this.srl_id_frecuencia = srl_id_frecuencia; 
} 
public Integer getSrl_id_personal_concepto() { 
  return srl_id_personal_concepto; 
} 
public void setSrl_id_personal_concepto(Integer srl_id_personal_concepto) { 
  this.srl_id_personal_concepto = srl_id_personal_concepto; 
} 
public Integer getInt_id_mes() { 
  return int_id_mes; 
} 
public void setInt_id_mes(Integer int_id_mes) { 
  this.int_id_mes = int_id_mes; 
} 
public String getDescrip_mes() { 
  return descrip_mes; 
} 
public void setDescrip_mes(String descrip_mes) { 
  this.descrip_mes = descrip_mes; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getDescrip_estado() { 
  return descrip_estado; 
} 
public void setDescrip_estado(String descrip_estado) { 
  this.descrip_estado = descrip_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
