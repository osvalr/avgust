package sernanp.app.dao.query.domain; 

public class ObtenerMetaFuenteGenericaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_meta_fuente_generica; 
private Integer srl_id_fuente_financiamiento; 
private String var_descripcion_fuente_financiamiento; 
private Integer srl_id_meta_presupuestaria; 
private String var_descripcion; 

public Integer getSrl_id_meta_fuente_generica() { 
  return srl_id_meta_fuente_generica; 
} 
public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) { 
  this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica; 
} 
public Integer getSrl_id_fuente_financiamiento() { 
  return srl_id_fuente_financiamiento; 
} 
public void setSrl_id_fuente_financiamiento(Integer srl_id_fuente_financiamiento) { 
  this.srl_id_fuente_financiamiento = srl_id_fuente_financiamiento; 
} 
public String getVar_descripcion_fuente_financiamiento() { 
  return var_descripcion_fuente_financiamiento; 
} 
public void setVar_descripcion_fuente_financiamiento(String var_descripcion_fuente_financiamiento) { 
  this.var_descripcion_fuente_financiamiento = var_descripcion_fuente_financiamiento; 
} 
public Integer getSrl_id_meta_presupuestaria() { 
  return srl_id_meta_presupuestaria; 
} 
public void setSrl_id_meta_presupuestaria(Integer srl_id_meta_presupuestaria) { 
  this.srl_id_meta_presupuestaria = srl_id_meta_presupuestaria; 
} 
public String getVar_descripcion() { 
  return var_descripcion; 
} 
public void setVar_descripcion(String var_descripcion) { 
  this.var_descripcion = var_descripcion; 
} 

} 
