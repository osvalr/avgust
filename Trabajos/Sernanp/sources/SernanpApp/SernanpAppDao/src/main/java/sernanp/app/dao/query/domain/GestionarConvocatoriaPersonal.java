package sernanp.app.dao.query.domain; 

public class GestionarConvocatoriaPersonal implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_convocatoria; 
private String var_num_convocatoria; 
private String dte_fecha_aprobacion; 
private String dte_fecha_inicio_publicacion; 
private String dte_fecha_termino_publicacion; 
private Integer idarea; 
private Integer idunidad; 
private Integer int_num_activacion; 
private Integer int_id_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public String getVar_num_convocatoria() { 
  return var_num_convocatoria; 
} 
public void setVar_num_convocatoria(String var_num_convocatoria) { 
  this.var_num_convocatoria = var_num_convocatoria; 
} 
public String getDte_fecha_aprobacion() { 
  return dte_fecha_aprobacion; 
} 
public void setDte_fecha_aprobacion(String dte_fecha_aprobacion) { 
  this.dte_fecha_aprobacion = dte_fecha_aprobacion; 
} 
public String getDte_fecha_inicio_publicacion() { 
  return dte_fecha_inicio_publicacion; 
} 
public void setDte_fecha_inicio_publicacion(String dte_fecha_inicio_publicacion) { 
  this.dte_fecha_inicio_publicacion = dte_fecha_inicio_publicacion; 
} 
public String getDte_fecha_termino_publicacion() { 
  return dte_fecha_termino_publicacion; 
} 
public void setDte_fecha_termino_publicacion(String dte_fecha_termino_publicacion) { 
  this.dte_fecha_termino_publicacion = dte_fecha_termino_publicacion; 
} 
public Integer getIdarea() { 
  return idarea; 
} 
public void setIdarea(Integer idarea) { 
  this.idarea = idarea; 
} 
public Integer getIdunidad() { 
  return idunidad; 
} 
public void setIdunidad(Integer idunidad) { 
  this.idunidad = idunidad; 
} 
public Integer getInt_num_activacion() { 
  return int_num_activacion; 
} 
public void setInt_num_activacion(Integer int_num_activacion) { 
  this.int_num_activacion = int_num_activacion; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
