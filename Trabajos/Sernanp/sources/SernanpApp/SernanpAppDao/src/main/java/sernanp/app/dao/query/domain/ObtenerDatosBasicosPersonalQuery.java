package sernanp.app.dao.query.domain; 

public class ObtenerDatosBasicosPersonalQuery { 

private Integer idpersonal;
private Integer idpersonanatural; 
private String nombrePersonal; 
private String apepat; 
private String apemat; 
private Integer idtipodocumento; 
private String descrip_tipo_documento; 
private String numerodoc;
private String dte_fec_inicio;
//private String dte_fec_inicio_max;

public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public String getNombrePersonal() { 
  return nombrePersonal; 
} 
public void setNombrePersonal(String nombrePersonal) { 
  this.nombrePersonal = nombrePersonal; 
} 
public String getApepat() { 
  return apepat; 
} 
public void setApepat(String apepat) { 
  this.apepat = apepat; 
} 
public String getApemat() { 
  return apemat; 
} 
public void setApemat(String apemat) { 
  this.apemat = apemat; 
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

public Integer getIdpersonal() {
	return idpersonal;
}
public void setIdpersonal(Integer idpersonal) {
	this.idpersonal = idpersonal;
}

public String getNumerodoc() {
	return numerodoc;
}
public void setNumerodoc(String numerodoc) {
	this.numerodoc = numerodoc;
}
public String getDte_fec_inicio() {
	return dte_fec_inicio;
}
public void setDte_fec_inicio(String dte_fec_inicio) {
	this.dte_fec_inicio = dte_fec_inicio;
}



} 
