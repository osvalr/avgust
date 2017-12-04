package sernanp.app.dao.query.domain; 

public class GestionarReqArchivoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_archivo; 
private Integer srl_id_requerimiento_personal; 
private String var_nombre_archivo; 
private String var_tipo_archivo; 
private String var_archivo_ruta_almacen; 
private Double num_size_archivo; 
private String tsp_fecha_registro; 
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
public String getVar_nombre_archivo() { 
  return var_nombre_archivo; 
} 
public void setVar_nombre_archivo(String var_nombre_archivo) { 
  this.var_nombre_archivo = var_nombre_archivo; 
} 
public String getVar_tipo_archivo() { 
  return var_tipo_archivo; 
} 
public void setVar_tipo_archivo(String var_tipo_archivo) { 
  this.var_tipo_archivo = var_tipo_archivo; 
} 
public String getVar_archivo_ruta_almacen() { 
  return var_archivo_ruta_almacen; 
} 
public void setVar_archivo_ruta_almacen(String var_archivo_ruta_almacen) { 
  this.var_archivo_ruta_almacen = var_archivo_ruta_almacen; 
} 
public Double getNum_size_archivo() { 
  return num_size_archivo; 
} 
public void setNum_size_archivo(Double num_size_archivo) { 
  this.num_size_archivo = num_size_archivo; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 
public String getVar_descripcion_archivo() { 
  return var_descripcion_archivo; 
} 
public void setVar_descripcion_archivo(String var_descripcion_archivo) { 
  this.var_descripcion_archivo = var_descripcion_archivo; 
} 

} 
