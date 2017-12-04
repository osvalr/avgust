package sernanp.app.dao.query.domain; 

public class ReporteVacantesPublicasQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String var_denominacion_requerimiento; 
private Integer int_cantidad_requerida; 

private String ultimo_lanzamiento_convocatoria; 
private String ultimo_lanzamiento_cod_postulacion;
private Integer lanzamientos_convocatoria;

public String getVar_denominacion_requerimiento() { 
  return var_denominacion_requerimiento; 
} 
public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) { 
  this.var_denominacion_requerimiento = var_denominacion_requerimiento; 
} 
public Integer getInt_cantidad_requerida() { 
  return int_cantidad_requerida; 
} 
public void setInt_cantidad_requerida(Integer int_cantidad_requerida) { 
  this.int_cantidad_requerida = int_cantidad_requerida; 
}
public String getUltimo_lanzamiento_convocatoria() {
	return ultimo_lanzamiento_convocatoria;
}
public void setUltimo_lanzamiento_convocatoria(String ultimo_lanzamiento_convocatoria) {
	this.ultimo_lanzamiento_convocatoria = ultimo_lanzamiento_convocatoria;
}
public String getUltimo_lanzamiento_cod_postulacion() {
	return ultimo_lanzamiento_cod_postulacion;
}
public void setUltimo_lanzamiento_cod_postulacion(String ultimo_lanzamiento_cod_postulacion) {
	this.ultimo_lanzamiento_cod_postulacion = ultimo_lanzamiento_cod_postulacion;
}
public Integer getLanzamientos_convocatoria() {
	return lanzamientos_convocatoria;
}
public void setLanzamientos_convocatoria(Integer lanzamientos_convocatoria) {
	this.lanzamientos_convocatoria = lanzamientos_convocatoria;
} 



} 
