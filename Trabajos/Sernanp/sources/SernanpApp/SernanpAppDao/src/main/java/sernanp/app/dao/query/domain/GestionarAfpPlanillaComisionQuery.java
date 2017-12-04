package sernanp.app.dao.query.domain; 

public class GestionarAfpPlanillaComisionQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_afp_comision; 
private Integer srl_id_afp; 
private Integer int_id_tipo_comision; 
private String descrip_tipo_comision; 
private Double dec_aporte; 
private Double dec_seguro; 
private Double dec_comision; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_afp_comision() { 
  return srl_id_afp_comision; 
} 
public void setSrl_id_afp_comision(Integer srl_id_afp_comision) { 
  this.srl_id_afp_comision = srl_id_afp_comision; 
} 
public Integer getSrl_id_afp() { 
  return srl_id_afp; 
} 
public void setSrl_id_afp(Integer srl_id_afp) { 
  this.srl_id_afp = srl_id_afp; 
} 
public Integer getInt_id_tipo_comision() { 
  return int_id_tipo_comision; 
} 
public void setInt_id_tipo_comision(Integer int_id_tipo_comision) { 
  this.int_id_tipo_comision = int_id_tipo_comision; 
} 
public String getDescrip_tipo_comision() { 
  return descrip_tipo_comision; 
} 
public void setDescrip_tipo_comision(String descrip_tipo_comision) { 
  this.descrip_tipo_comision = descrip_tipo_comision; 
} 
public Double getDec_aporte() { 
  return dec_aporte; 
} 
public void setDec_aporte(Double dec_aporte) { 
  this.dec_aporte = dec_aporte; 
} 
public Double getDec_seguro() { 
  return dec_seguro; 
} 
public void setDec_seguro(Double dec_seguro) { 
  this.dec_seguro = dec_seguro; 
} 
public Double getDec_comision() { 
  return dec_comision; 
} 
public void setDec_comision(Double dec_comision) { 
  this.dec_comision = dec_comision; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getDescrip_estado() { 
  return descrip_estado; 
} 
public void setDescrip_estado(String descrip_estado) { 
  this.descrip_estado = descrip_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
