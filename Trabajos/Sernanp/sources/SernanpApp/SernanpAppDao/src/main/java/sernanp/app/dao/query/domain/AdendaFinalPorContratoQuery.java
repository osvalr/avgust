package sernanp.app.dao.query.domain; 

public class AdendaFinalPorContratoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_contrato; 
private String var_num_contrato; 
private Integer srl_id_regimen_contractual; 
private Integer srl_id_meta_fuente_generica; 

public Integer getSrl_id_contrato() { 
  return srl_id_contrato; 
} 
public void setSrl_id_contrato(Integer srl_id_contrato) { 
  this.srl_id_contrato = srl_id_contrato; 
} 
public String getVar_num_contrato() { 
  return var_num_contrato; 
} 
public void setVar_num_contrato(String var_num_contrato) { 
  this.var_num_contrato = var_num_contrato; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getSrl_id_meta_fuente_generica() { 
  return srl_id_meta_fuente_generica; 
} 
public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) { 
  this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica; 
} 

} 
