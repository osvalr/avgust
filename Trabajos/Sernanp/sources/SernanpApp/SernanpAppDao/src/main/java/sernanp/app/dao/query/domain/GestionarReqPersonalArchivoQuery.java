package sernanp.app.dao.query.domain; 

public class GestionarReqPersonalArchivoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_archivo; 
private Integer srl_id_requerimiento_personal; 
private String var_descripcion_archivo; 

public Integer getSrl_id_archivo() { 
  return srl_id_archivo; 
} 
public void setSrl_id_archivo(Integer srl_id_archivo) { 
  this.srl_id_archivo = srl_id_archivo; 
} 
public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
} 
public String getVar_descripcion_archivo() { 
  return var_descripcion_archivo; 
} 
public void setVar_descripcion_archivo(String var_descripcion_archivo) { 
  this.var_descripcion_archivo = var_descripcion_archivo; 
} 

} 
