package sernanp.app.dao.query.domain; 

public class GestionarPersonaNaturalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idpersona; 
private Integer idpersonanatural; 
private Integer int_id_postulante; 
private String nombres_completos; 
private Integer idtipodocumento; 
private String numerodoc; 
private String ruc; 
private Integer idsexo; 
private String coddpto; 
private String codprov; 
private Integer idubigeo; 
private Integer idpais; 

//ADD 28-01-2016 DAVID

private Integer srl_id_conv_area_org;
private Integer srl_id_convocatoria;
private Integer srl_id_sede_req_sel;
private Integer int_id_estado;
private Integer idarea; 
private Integer idunidad;

private Integer int_id_estado_postulante;

private Integer int_id_tipo_factor;

//private Integer int_estado_postulante_prop;

/*END*/

public GestionarPersonaNaturalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
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
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getRuc() { 
  return ruc; 
} 
public void setRuc(String ruc) { 
  this.ruc = ruc; 
} 
public Integer getIdsexo() { 
  return idsexo; 
} 
public void setIdsexo(Integer idsexo) { 
  this.idsexo = idsexo; 
} 
public String getCoddpto() { 
  return coddpto; 
} 
public void setCoddpto(String coddpto) { 
  this.coddpto = coddpto; 
} 
public String getCodprov() { 
  return codprov; 
} 
public void setCodprov(String codprov) { 
  this.codprov = codprov; 
} 
public Integer getIdubigeo() { 
  return idubigeo; 
} 
public void setIdubigeo(Integer idubigeo) { 
  this.idubigeo = idubigeo; 
} 
public Integer getIdpais() { 
  return idpais; 
} 
public void setIdpais(Integer idpais) { 
  this.idpais = idpais; 
} 
public String getOrderColumn() {
return orderColumn;
}
public void setOrderColumn(String orderColumn) {
this.orderColumn = orderColumn;
}
public String getOrderDirecction() {
return orderDirecction;
}
public void setOrderDirecction(String orderDirecction) {
this.orderDirecction = orderDirecction;
}


public Integer getSrl_id_convocatoria() {
	return srl_id_convocatoria;
}
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
	this.srl_id_convocatoria = srl_id_convocatoria;
}
public Integer getInt_id_estado() {
	return int_id_estado;
}
public void setInt_id_estado(Integer int_id_estado) {
	this.int_id_estado = int_id_estado;
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
public Integer getSrl_id_conv_area_org() {
	return srl_id_conv_area_org;
}
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
	this.srl_id_conv_area_org = srl_id_conv_area_org;
}
public Integer getSrl_id_sede_req_sel() {
	return srl_id_sede_req_sel;
}
public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) {
	this.srl_id_sede_req_sel = srl_id_sede_req_sel;
}
public Integer getInt_id_tipo_factor() {
	return int_id_tipo_factor;
}
public void setInt_id_tipo_factor(Integer int_id_tipo_factor) {
	this.int_id_tipo_factor = int_id_tipo_factor;
}
//public Integer getInt_estado_postulante_prop() {
//	return int_estado_postulante_prop;
//}
//public void setInt_estado_postulante_prop(Integer int_estado_postulante_prop) {
//	this.int_estado_postulante_prop = int_estado_postulante_prop;
//}
public Integer getInt_id_estado_postulante() {
	return int_id_estado_postulante;
}
public void setInt_id_estado_postulante(Integer int_id_estado_postulante) {
	this.int_id_estado_postulante = int_id_estado_postulante;
}

} 
