package sernanp.app.dao.query.domain; 

public class PersonalVacacionesQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_pers_vac; 
private Integer int_periodo_vac; 
private java.util.Date dte_fec_inicio_programacion_vac; 
private Integer int_est_vacaciones; 
private java.util.Date tsp_fec_sys_crea; 
private Integer idpersonal; 
private Integer int_dias_vac_corresponde; 
private Integer int_dias_vac_goce; 
private Double int_dias_vac_truncas; 

public Integer getSrl_id_pers_vac() { 
  return srl_id_pers_vac; 
} 
public void setSrl_id_pers_vac(Integer srl_id_pers_vac) { 
  this.srl_id_pers_vac = srl_id_pers_vac; 
} 
public Integer getInt_periodo_vac() { 
  return int_periodo_vac; 
} 
public void setInt_periodo_vac(Integer int_periodo_vac) { 
  this.int_periodo_vac = int_periodo_vac; 
} 
public java.util.Date getDte_fec_inicio_programacion_vac() { 
  return dte_fec_inicio_programacion_vac; 
} 
public void setDte_fec_inicio_programacion_vac(java.util.Date dte_fec_inicio_programacion_vac) { 
  this.dte_fec_inicio_programacion_vac = dte_fec_inicio_programacion_vac; 
} 
public Integer getInt_est_vacaciones() { 
  return int_est_vacaciones; 
} 
public void setInt_est_vacaciones(Integer int_est_vacaciones) { 
  this.int_est_vacaciones = int_est_vacaciones; 
} 
public java.util.Date getTsp_fec_sys_crea() { 
  return tsp_fec_sys_crea; 
} 
public void setTsp_fec_sys_crea(java.util.Date tsp_fec_sys_crea) { 
  this.tsp_fec_sys_crea = tsp_fec_sys_crea; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getInt_dias_vac_corresponde() { 
  return int_dias_vac_corresponde; 
} 
public void setInt_dias_vac_corresponde(Integer int_dias_vac_corresponde) { 
  this.int_dias_vac_corresponde = int_dias_vac_corresponde; 
} 
public Integer getInt_dias_vac_goce() { 
  return int_dias_vac_goce; 
} 
public void setInt_dias_vac_goce(Integer int_dias_vac_goce) { 
  this.int_dias_vac_goce = int_dias_vac_goce; 
} 
public Double getInt_dias_vac_truncas() { 
  return int_dias_vac_truncas; 
} 
public void setInt_dias_vac_truncas(Double int_dias_vac_truncas) { 
  this.int_dias_vac_truncas = int_dias_vac_truncas; 
} 

} 
