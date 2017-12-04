package pe.com.focus.sakerk.repository.custom.model; 

public class InformacionAcademicaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_informacion_academica; 
private Integer id_persona_natural; 
private Integer id_categoria_estudio; 
private Integer id_estudio; 
private Integer id_centro_estudio; 
private Integer id_tipo_grado_instruccion; 
private Integer flag_encurso; 

public InformacionAcademicaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_informacion_academica() { 
  return id_informacion_academica; 
} 
public void setId_informacion_academica(Integer id_informacion_academica) { 
  this.id_informacion_academica = id_informacion_academica; 
} 
public Integer getId_persona_natural() { 
  return id_persona_natural; 
} 
public void setId_persona_natural(Integer id_persona_natural) { 
  this.id_persona_natural = id_persona_natural; 
} 
public Integer getId_categoria_estudio() { 
  return id_categoria_estudio; 
} 
public void setId_categoria_estudio(Integer id_categoria_estudio) { 
  this.id_categoria_estudio = id_categoria_estudio; 
} 
public Integer getId_estudio() { 
  return id_estudio; 
} 
public void setId_estudio(Integer id_estudio) { 
  this.id_estudio = id_estudio; 
} 
public Integer getId_tipo_grado_instruccion() { 
  return id_tipo_grado_instruccion; 
} 
public void setId_tipo_grado_instruccion(Integer id_tipo_grado_instruccion) { 
  this.id_tipo_grado_instruccion = id_tipo_grado_instruccion; 
} 
public Integer getFlag_encurso() { 
  return flag_encurso; 
} 
public void setFlag_encurso(Integer flag_encurso) { 
  this.flag_encurso = flag_encurso; 
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
public Integer getId_centro_estudio() {
	return id_centro_estudio;
}
public void setId_centro_estudio(Integer id_centro_estudio) {
	this.id_centro_estudio = id_centro_estudio;
}

} 
