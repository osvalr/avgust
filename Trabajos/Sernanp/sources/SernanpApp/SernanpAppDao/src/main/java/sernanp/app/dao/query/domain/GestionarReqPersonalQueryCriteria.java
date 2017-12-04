package sernanp.app.dao.query.domain; 

public class GestionarReqPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_requerimiento_personal; 
private Integer idarea_solicitante; 
private Integer idunidad_solicitante; 
private Integer idarea_supervisora; 
private Integer idunidad_supervisora; 
private Integer int_id_estado; 
private Integer int_id_tipo_trabajador; 
private Integer idcategoriaanp; 
private Integer idsede; 
private Integer idareanatural; 
private Integer id_sede_ubicacion; 
private Integer srl_id_sede_req_sel; 

public GestionarReqPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
} 
public Integer getIdarea_solicitante() { 
  return idarea_solicitante; 
} 
public void setIdarea_solicitante(Integer idarea_solicitante) { 
  this.idarea_solicitante = idarea_solicitante; 
} 
public Integer getIdunidad_solicitante() { 
  return idunidad_solicitante; 
} 
public void setIdunidad_solicitante(Integer idunidad_solicitante) { 
  this.idunidad_solicitante = idunidad_solicitante; 
} 
public Integer getIdarea_supervisora() { 
  return idarea_supervisora; 
} 
public void setIdarea_supervisora(Integer idarea_supervisora) { 
  this.idarea_supervisora = idarea_supervisora; 
} 
public Integer getIdunidad_supervisora() { 
  return idunidad_supervisora; 
} 
public void setIdunidad_supervisora(Integer idunidad_supervisora) { 
  this.idunidad_supervisora = idunidad_supervisora; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getInt_id_tipo_trabajador() { 
  return int_id_tipo_trabajador; 
} 
public void setInt_id_tipo_trabajador(Integer int_id_tipo_trabajador) { 
  this.int_id_tipo_trabajador = int_id_tipo_trabajador; 
} 
public Integer getIdcategoriaanp() { 
  return idcategoriaanp; 
} 
public void setIdcategoriaanp(Integer idcategoriaanp) { 
  this.idcategoriaanp = idcategoriaanp; 
} 
public Integer getIdsede() { 
  return idsede; 
} 
public void setIdsede(Integer idsede) { 
  this.idsede = idsede; 
} 
public Integer getIdareanatural() { 
  return idareanatural; 
} 
public void setIdareanatural(Integer idareanatural) { 
  this.idareanatural = idareanatural; 
} 
public Integer getId_sede_ubicacion() { 
  return id_sede_ubicacion; 
} 
public void setId_sede_ubicacion(Integer id_sede_ubicacion) { 
  this.id_sede_ubicacion = id_sede_ubicacion; 
} 
public Integer getSrl_id_sede_req_sel() { 
  return srl_id_sede_req_sel; 
} 
public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) { 
  this.srl_id_sede_req_sel = srl_id_sede_req_sel; 
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

} 
