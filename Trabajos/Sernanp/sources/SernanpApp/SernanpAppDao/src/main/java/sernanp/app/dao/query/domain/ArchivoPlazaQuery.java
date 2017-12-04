package sernanp.app.dao.query.domain; 

public class ArchivoPlazaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_archivo; 
private Integer srl_id_conv_area_org; 
private Integer srl_id_etapa_proceso_seleccion; 
private String var_nombre_etapa; 
private Integer srl_id_conv_area_org_etapa; 
private String var_descrip_subetapa; 
private String var_nombre_archivo; 
private String var_descrip_archivo; 
private String var_tipo_archivo; 
private String var_archivo_ruta_almacen; 
private Double num_size_archivo; 
private String tsp_fecha_registro; 
private String file_name_session;

public Integer getSrl_id_archivo() { 
  return srl_id_archivo; 
} 
public void setSrl_id_archivo(Integer srl_id_archivo) { 
  this.srl_id_archivo = srl_id_archivo; 
} 
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getSrl_id_etapa_proceso_seleccion() { 
  return srl_id_etapa_proceso_seleccion; 
} 
public void setSrl_id_etapa_proceso_seleccion(Integer srl_id_etapa_proceso_seleccion) { 
  this.srl_id_etapa_proceso_seleccion = srl_id_etapa_proceso_seleccion; 
} 
public String getVar_nombre_etapa() { 
  return var_nombre_etapa; 
} 
public void setVar_nombre_etapa(String var_nombre_etapa) { 
  this.var_nombre_etapa = var_nombre_etapa; 
} 
public Integer getSrl_id_conv_area_org_etapa() { 
  return srl_id_conv_area_org_etapa; 
} 
public void setSrl_id_conv_area_org_etapa(Integer srl_id_conv_area_org_etapa) { 
  this.srl_id_conv_area_org_etapa = srl_id_conv_area_org_etapa; 
} 
public String getVar_descrip_subetapa() { 
  return var_descrip_subetapa; 
} 
public void setVar_descrip_subetapa(String var_descrip_subetapa) { 
  this.var_descrip_subetapa = var_descrip_subetapa; 
} 
public String getVar_nombre_archivo() { 
  return var_nombre_archivo; 
} 
public void setVar_nombre_archivo(String var_nombre_archivo) { 
  this.var_nombre_archivo = var_nombre_archivo; 
} 
public String getVar_descrip_archivo() { 
  return var_descrip_archivo; 
} 
public void setVar_descrip_archivo(String var_descrip_archivo) { 
  this.var_descrip_archivo = var_descrip_archivo; 
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
public String getFile_name_session() {
	return file_name_session;
}
public void setFile_name_session(String file_name_session) {
	this.file_name_session = file_name_session;
} 

} 
