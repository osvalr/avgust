package sernanp.app.dao.query.domain; 

public class PersonalContratoNominaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersona; 
private Integer idpersonanatural; 
private Integer idpersonal; 
private Integer srl_id_contrato; 
private Integer srl_id_regimen_contractual; 
private java.util.Date dte_fec_inicio; 
private java.util.Date dte_fec_cese; 
private Integer int_id_estado; 
private Double num_sueldo; 

public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getSrl_id_contrato() { 
  return srl_id_contrato; 
} 
public void setSrl_id_contrato(Integer srl_id_contrato) { 
  this.srl_id_contrato = srl_id_contrato; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public java.util.Date getDte_fec_inicio() { 
  return dte_fec_inicio; 
} 
public void setDte_fec_inicio(java.util.Date dte_fec_inicio) { 
  this.dte_fec_inicio = dte_fec_inicio; 
} 
public java.util.Date getDte_fec_cese() { 
  return dte_fec_cese; 
} 
public void setDte_fec_cese(java.util.Date dte_fec_cese) { 
  this.dte_fec_cese = dte_fec_cese; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Double getNum_sueldo() { 
  return num_sueldo; 
} 
public void setNum_sueldo(Double num_sueldo) { 
  this.num_sueldo = num_sueldo; 
} 

} 
