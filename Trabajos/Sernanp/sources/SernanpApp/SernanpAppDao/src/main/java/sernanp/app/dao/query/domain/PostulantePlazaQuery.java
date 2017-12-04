package sernanp.app.dao.query.domain; 

public class PostulantePlazaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_postulante_conv_area_org; 
private Integer srl_id_conv_area_org; 
private Integer int_id_postulante; 
private String nombres_completos; 
private Integer idtipodocumento; 
private String descrip_tipo_documento; 
private String numerodoc; 
private Integer int_orden_merito;
private Double dec_puntaje_total; 
private Integer int_id_estado; 
private String var_nombre_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_postulante_conv_area_org() { 
  return srl_id_postulante_conv_area_org; 
} 
public void setSrl_id_postulante_conv_area_org(Integer srl_id_postulante_conv_area_org) { 
  this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org; 
} 
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getInt_id_postulante() { 
  return int_id_postulante; 
} 
public void setInt_id_postulante(Integer int_id_postulante) { 
  this.int_id_postulante = int_id_postulante; 
} 
public String getNombres_completos() { 
  return nombres_completos; 
} 
public void setNombres_completos(String nombres_completos) { 
  this.nombres_completos = nombres_completos; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public String getDescrip_tipo_documento() { 
  return descrip_tipo_documento; 
} 
public void setDescrip_tipo_documento(String descrip_tipo_documento) { 
  this.descrip_tipo_documento = descrip_tipo_documento; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public Double getDec_puntaje_total() { 
  return dec_puntaje_total; 
} 
public void setDec_puntaje_total(Double dec_puntaje_total) { 
  this.dec_puntaje_total = dec_puntaje_total; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_nombre_estado() { 
  return var_nombre_estado; 
} 
public void setVar_nombre_estado(String var_nombre_estado) { 
  this.var_nombre_estado = var_nombre_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
}
public Integer getInt_orden_merito() {
	return int_orden_merito;
}
public void setInt_orden_merito(Integer int_orden_merito) {
	this.int_orden_merito = int_orden_merito;
} 

} 
