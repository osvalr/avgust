package sernanp.app.dao.query.domain; 

public class RptPlameMaestro implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String codigo_unidad_ejecutora; 
private Integer int_anio; 
private String int_id_periodo_mes; 
private String tipo_planilla; 
private String clase_planulla; 
private String num_correlativo; 
private Integer cantidad_registros_cargados; 
private Double dec_total_ingresos; 
private Double dec_total_descuentos; 
private Double dec_total_aportes; 
private Double dec_total_reintegros; 
private Double dec_total_encargaturas; 
private Double dec_total_otros_ingresos; 

public String getCodigo_unidad_ejecutora() { 
  return codigo_unidad_ejecutora; 
} 
public void setCodigo_unidad_ejecutora(String codigo_unidad_ejecutora) { 
  this.codigo_unidad_ejecutora = codigo_unidad_ejecutora; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public String getInt_id_periodo_mes() { 
  return int_id_periodo_mes; 
} 
public void setInt_id_periodo_mes(String int_id_periodo_mes) { 
  this.int_id_periodo_mes = int_id_periodo_mes; 
} 
public String getTipo_planilla() { 
  return tipo_planilla; 
} 
public void setTipo_planilla(String tipo_planilla) { 
  this.tipo_planilla = tipo_planilla; 
} 
public String getClase_planulla() { 
  return clase_planulla; 
} 
public void setClase_planulla(String clase_planulla) { 
  this.clase_planulla = clase_planulla; 
} 
public String getNum_correlativo() { 
  return num_correlativo; 
} 
public void setNum_correlativo(String num_correlativo) { 
  this.num_correlativo = num_correlativo; 
} 
public Integer getCantidad_registros_cargados() { 
  return cantidad_registros_cargados; 
} 
public void setCantidad_registros_cargados(Integer cantidad_registros_cargados) { 
  this.cantidad_registros_cargados = cantidad_registros_cargados; 
} 
public Double getDec_total_ingresos() { 
  return dec_total_ingresos; 
} 
public void setDec_total_ingresos(Double dec_total_ingresos) { 
  this.dec_total_ingresos = dec_total_ingresos; 
} 
public Double getDec_total_descuentos() { 
  return dec_total_descuentos; 
} 
public void setDec_total_descuentos(Double dec_total_descuentos) { 
  this.dec_total_descuentos = dec_total_descuentos; 
} 
public Double getDec_total_aportes() { 
  return dec_total_aportes; 
} 
public void setDec_total_aportes(Double dec_total_aportes) { 
  this.dec_total_aportes = dec_total_aportes; 
} 
public Double getDec_total_reintegros() { 
  return dec_total_reintegros; 
} 
public void setDec_total_reintegros(Double dec_total_reintegros) { 
  this.dec_total_reintegros = dec_total_reintegros; 
} 
public Double getDec_total_encargaturas() { 
  return dec_total_encargaturas; 
} 
public void setDec_total_encargaturas(Double dec_total_encargaturas) { 
  this.dec_total_encargaturas = dec_total_encargaturas; 
} 
public Double getDec_total_otros_ingresos() { 
  return dec_total_otros_ingresos; 
} 
public void setDec_total_otros_ingresos(Double dec_total_otros_ingresos) { 
  this.dec_total_otros_ingresos = dec_total_otros_ingresos; 
} 

} 
