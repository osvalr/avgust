package sernanp.rrhh.vo;

import java.sql.Time;
import java.sql.Timestamp;


public class PersonalDescuentosVO {
	
	  private int srl_id_pers_desc;
	  private PersonalVO personaldescuento;
	  private int int_periodo_desc;
	  private int int_mes_desc;
	  private String nom_mes_desc;
	  private double num_monto_desc;
	  private Tipo tipodescuento;
	  private Timestamp tsp_fec_pers_desc;
	  
	  private int minutos_tardanza;
	  private int permisos;
	  private int inasistencias;	  
	  private double total_descuento;
	  
	  //05-12-2013
	  private Time permiso_tiempo;
	  private int permiso_horas;
	  private int permiso_minutos;
	  //
	  
	  //18-07-2014
	  private int licencias_sgh;
	  //

	  public PersonalDescuentosVO(){
		  personaldescuento = new PersonalVO();
		  tipodescuento		= new Tipo(29);
	  }
	  
	 
	  
	public int getSrl_id_pers_desc() {
		return srl_id_pers_desc;
	}
	public void setSrl_id_pers_desc(int srl_id_pers_desc) {
		this.srl_id_pers_desc = srl_id_pers_desc;
	}
	public int getInt_periodo_desc() {
		return int_periodo_desc;
	}
	public void setInt_periodo_desc(int int_periodo_desc) {
		this.int_periodo_desc = int_periodo_desc;
	}
	public int getInt_mes_desc() {
		return int_mes_desc;
	}
	public void setInt_mes_desc(int int_mes_desc) {
		this.int_mes_desc = int_mes_desc;
	}
	public double getNum_monto_desc() {
		return num_monto_desc;
	}
	public void setNum_monto_desc(double num_monto_desc) {
		this.num_monto_desc = num_monto_desc;
	}
	public Timestamp getTsp_fec_pers_desc() {
		return tsp_fec_pers_desc;
	}
	public void setTsp_fec_pers_desc(Timestamp tsp_fec_pers_desc) {
		this.tsp_fec_pers_desc = tsp_fec_pers_desc;
	}
	public PersonalVO getPersonaldescuento() {
		return personaldescuento;
	}
	public void setPersonaldescuento(PersonalVO personaldescuento) {
		this.personaldescuento = personaldescuento;
	}
	public Tipo getTipodescuento() {
		return tipodescuento;
	}
	public void setTipodescuento(Tipo tipodescuento) {
		this.tipodescuento = tipodescuento;
	}



	public int getMinutos_tardanza() {
		return minutos_tardanza;
	}



	public void setMinutos_tardanza(int minutos_tardanza) {
		this.minutos_tardanza = minutos_tardanza;
	}



	public int getInasistencias() {
		return inasistencias;
	}



	public void setInasistencias(int inasistencias) {
		this.inasistencias = inasistencias;
	}



	public double getTotal_descuento() {
		return total_descuento;
	}



	public void setTotal_descuento(double total_descuento) {
		this.total_descuento = total_descuento;
	}



	public int getPermisos() {
		return permisos;
	}



	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}



	public int getPermiso_minutos() {
		return permiso_minutos;
	}



	public void setPermiso_minutos(int permiso_minutos) {
		this.permiso_minutos = permiso_minutos;
	}



	public int getPermiso_horas() {
		return permiso_horas;
	}



	public void setPermiso_horas(int permiso_horas) {
		this.permiso_horas = permiso_horas;
	}



	public Time getPermiso_tiempo() {
		return permiso_tiempo;
	}



	public void setPermiso_tiempo(Time permiso_tiempo) {
		this.permiso_tiempo = permiso_tiempo;
	}



	public int getLicencias_sgh() {
		return licencias_sgh;
	}



	public void setLicencias_sgh(int licencias_sgh) {
		this.licencias_sgh = licencias_sgh;
	}



	public String getNom_mes_desc() {
		return nom_mes_desc;
	}



	public void setNom_mes_desc(String nom_mes_desc) {
		this.nom_mes_desc = nom_mes_desc;
	}



	
	
}
