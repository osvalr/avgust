package sernanp.app.dao.query.domain; 

public class ConfParametroQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_parametro_planilla; 
private String var_descrip_parametro; 
private Double dec_valor_parametro; 

public Integer getSrl_id_parametro_planilla() { 
  return srl_id_parametro_planilla; 
} 
public void setSrl_id_parametro_planilla(Integer srl_id_parametro_planilla) { 
  this.srl_id_parametro_planilla = srl_id_parametro_planilla; 
} 
public String getVar_descrip_parametro() { 
  return var_descrip_parametro; 
} 
public void setVar_descrip_parametro(String var_descrip_parametro) { 
  this.var_descrip_parametro = var_descrip_parametro; 
} 
public Double getDec_valor_parametro() { 
  return dec_valor_parametro; 
} 
public void setDec_valor_parametro(Double dec_valor_parametro) { 
  this.dec_valor_parametro = dec_valor_parametro; 
} 

} 
