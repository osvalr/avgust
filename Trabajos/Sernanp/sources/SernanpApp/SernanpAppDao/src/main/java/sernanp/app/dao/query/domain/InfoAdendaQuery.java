package sernanp.app.dao.query.domain; 

public class InfoAdendaQuery { 

private Integer srl_id_contrato; 
private Integer srl_id_contrato_padre;
private String var_num_contrato; 
private Integer srl_id_resp_unid_oper; 
private java.util.Date dte_fec_suscrip; 
private java.util.Date dte_fec_inicio; 
private java.util.Date dte_fec_termino; 
private Integer srl_id_plantilla_documento_archivo;
private String var_direccion_personal;

public Integer getSrl_id_contrato() { 
  return srl_id_contrato; 
} 
public void setSrl_id_contrato(Integer srl_id_contrato) { 
  this.srl_id_contrato = srl_id_contrato; 
} 
public String getVar_num_contrato() { 
  return var_num_contrato; 
} 
public void setVar_num_contrato(String var_num_contrato) { 
  this.var_num_contrato = var_num_contrato; 
} 
public Integer getSrl_id_resp_unid_oper() { 
  return srl_id_resp_unid_oper; 
} 
public void setSrl_id_resp_unid_oper(Integer srl_id_resp_unid_oper) { 
  this.srl_id_resp_unid_oper = srl_id_resp_unid_oper; 
} 
public java.util.Date getDte_fec_suscrip() { 
  return dte_fec_suscrip; 
} 
public void setDte_fec_suscrip(java.util.Date dte_fec_suscrip) { 
  this.dte_fec_suscrip = dte_fec_suscrip; 
} 
public java.util.Date getDte_fec_inicio() { 
  return dte_fec_inicio; 
} 
public void setDte_fec_inicio(java.util.Date dte_fec_inicio) { 
  this.dte_fec_inicio = dte_fec_inicio; 
} 
public java.util.Date getDte_fec_termino() { 
  return dte_fec_termino; 
} 
public void setDte_fec_termino(java.util.Date dte_fec_termino) { 
  this.dte_fec_termino = dte_fec_termino; 
}
public Integer getSrl_id_contrato_padre() {
	return srl_id_contrato_padre;
}
public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) {
	this.srl_id_contrato_padre = srl_id_contrato_padre;
}
public Integer getSrl_id_plantilla_documento_archivo() {
	return srl_id_plantilla_documento_archivo;
}
public void setSrl_id_plantilla_documento_archivo(
		Integer srl_id_plantilla_documento_archivo) {
	this.srl_id_plantilla_documento_archivo = srl_id_plantilla_documento_archivo;
}
public String getVar_direccion_personal() {
	return var_direccion_personal;
}
public void setVar_direccion_personal(String var_direccion_personal) {
	this.var_direccion_personal = var_direccion_personal;
} 

} 
