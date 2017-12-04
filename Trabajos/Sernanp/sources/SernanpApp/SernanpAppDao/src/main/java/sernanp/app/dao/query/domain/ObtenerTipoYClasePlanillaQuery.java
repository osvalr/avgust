package sernanp.app.dao.query.domain; 

public class ObtenerTipoYClasePlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String var_cod_tipo_planilla; 
private String var_cod_clase_planilla; 
private Integer int_correlativo; 

public String getVar_cod_tipo_planilla() { 
  return var_cod_tipo_planilla; 
} 
public void setVar_cod_tipo_planilla(String var_cod_tipo_planilla) { 
  this.var_cod_tipo_planilla = var_cod_tipo_planilla; 
} 
public String getVar_cod_clase_planilla() { 
  return var_cod_clase_planilla; 
} 
public void setVar_cod_clase_planilla(String var_cod_clase_planilla) { 
  this.var_cod_clase_planilla = var_cod_clase_planilla; 
} 
public Integer getInt_correlativo() { 
  return int_correlativo; 
} 
public void setInt_correlativo(Integer int_correlativo) { 
  this.int_correlativo = int_correlativo; 
} 

} 
