package sernanp.app.dao.query.domain; 

public class ComisionArchivoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_comision_archivo; 
private Integer srl_id_suspension; 

public Integer getSrl_id_comision_archivo() { 
  return srl_id_comision_archivo; 
} 
public void setSrl_id_comision_archivo(Integer srl_id_comision_archivo) { 
  this.srl_id_comision_archivo = srl_id_comision_archivo; 
} 
public Integer getSrl_id_suspension() { 
  return srl_id_suspension; 
} 
public void setSrl_id_suspension(Integer srl_id_suspension) { 
  this.srl_id_suspension = srl_id_suspension; 
} 

} 
