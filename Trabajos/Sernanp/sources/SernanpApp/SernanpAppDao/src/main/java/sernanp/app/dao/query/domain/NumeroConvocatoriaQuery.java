package sernanp.app.dao.query.domain; 

public class NumeroConvocatoriaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String var_num_convocatoria; 
private String var_num_convocatoria_corto; 
private Integer num; 
private Integer anho; 

public String getVar_num_convocatoria() { 
  return var_num_convocatoria; 
} 
public void setVar_num_convocatoria(String var_num_convocatoria) { 
  this.var_num_convocatoria = var_num_convocatoria; 
} 
public String getVar_num_convocatoria_corto() { 
  return var_num_convocatoria_corto; 
} 
public void setVar_num_convocatoria_corto(String var_num_convocatoria_corto) { 
  this.var_num_convocatoria_corto = var_num_convocatoria_corto; 
} 
public Integer getNum() { 
  return num; 
} 
public void setNum(Integer num) { 
  this.num = num; 
} 
public Integer getAnho() { 
  return anho; 
} 
public void setAnho(Integer anho) { 
  this.anho = anho; 
} 

} 
