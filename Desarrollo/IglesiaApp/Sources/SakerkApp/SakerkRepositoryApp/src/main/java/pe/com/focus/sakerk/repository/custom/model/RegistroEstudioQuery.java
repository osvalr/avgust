package pe.com.focus.sakerk.repository.custom.model; 

public class RegistroEstudioQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer id_estudio; 
private Integer id_categoria_estudio; 
private String nombre_estudio
			; 

public Integer getId_estudio() { 
  return id_estudio; 
} 
public void setId_estudio(Integer id_estudio) { 
  this.id_estudio = id_estudio; 
} 
public Integer getId_categoria_estudio() { 
  return id_categoria_estudio; 
} 
public void setId_categoria_estudio(Integer id_categoria_estudio) { 
  this.id_categoria_estudio = id_categoria_estudio; 
} 
public String getNombre_estudio
			() { 
  return nombre_estudio
			; 
} 
public void setNombre_estudio
			(String nombre_estudio
			) { 
  this.nombre_estudio
			 = nombre_estudio
			; 
} 

} 
