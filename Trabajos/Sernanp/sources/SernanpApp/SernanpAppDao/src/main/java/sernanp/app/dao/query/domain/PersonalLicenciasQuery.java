package sernanp.app.dao.query.domain; 

public class PersonalLicenciasQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_pers_lic; 
private java.util.Date dte_fec_inicio_lic; 
private java.util.Date dte_fec_fin_lic; 
private Integer int_dias_lic; 
private Integer int_est_lic; 
private Integer idpersonal; 
private Integer srl_id_per_activ; 

public Integer getSrl_id_pers_lic() { 
  return srl_id_pers_lic; 
} 
public void setSrl_id_pers_lic(Integer srl_id_pers_lic) { 
  this.srl_id_pers_lic = srl_id_pers_lic; 
} 
public java.util.Date getDte_fec_inicio_lic() { 
  return dte_fec_inicio_lic; 
} 
public void setDte_fec_inicio_lic(java.util.Date dte_fec_inicio_lic) { 
  this.dte_fec_inicio_lic = dte_fec_inicio_lic; 
} 
public java.util.Date getDte_fec_fin_lic() { 
  return dte_fec_fin_lic; 
} 
public void setDte_fec_fin_lic(java.util.Date dte_fec_fin_lic) { 
  this.dte_fec_fin_lic = dte_fec_fin_lic; 
} 
public Integer getInt_dias_lic() { 
  return int_dias_lic; 
} 
public void setInt_dias_lic(Integer int_dias_lic) { 
  this.int_dias_lic = int_dias_lic; 
} 
public Integer getInt_est_lic() { 
  return int_est_lic; 
} 
public void setInt_est_lic(Integer int_est_lic) { 
  this.int_est_lic = int_est_lic; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getSrl_id_per_activ() { 
  return srl_id_per_activ; 
} 
public void setSrl_id_per_activ(Integer srl_id_per_activ) { 
  this.srl_id_per_activ = srl_id_per_activ; 
} 

} 
