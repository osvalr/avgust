package sernanp.app.dao.query.domain; 

public class ObtenerPeriodosPorAnioQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_anio_periodo_planilla; 
private String descrip_periodo; 

public Integer getSrl_id_anio_periodo_planilla() { 
  return srl_id_anio_periodo_planilla; 
} 
public void setSrl_id_anio_periodo_planilla(Integer srl_id_anio_periodo_planilla) { 
  this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla; 
} 
public String getDescrip_periodo() { 
  return descrip_periodo; 
} 
public void setDescrip_periodo(String descrip_periodo) { 
  this.descrip_periodo = descrip_periodo; 
} 

} 
