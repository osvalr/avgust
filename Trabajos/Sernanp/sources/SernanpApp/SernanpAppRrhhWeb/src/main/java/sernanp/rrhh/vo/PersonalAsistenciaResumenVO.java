package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Time;

public class PersonalAsistenciaResumenVO {
	
	private PersonalVO personal;
	private int minutosTardanza;
	private int	permisoParticularDias; 
	private Time permisoParticularHoras;
	private int	permisoConGoceDias; 
	private Time permisoConGoceHoras; 
	private int	comisionLocalDias; 
	private Time comisionLocalHoras;
	private int	comisionProvinciaDias;
	private Time comisionProvinciaHoras; 
	private int	comisionExtranjeroDias;
	private Time comisionExtranjeroHoras; 
	private int	inasistencias; 
	private int	vacaciones; 
	private int	licIncapacidadTemporalTrabajo; 
	private int	licFallecimientoFamiliar; 
	private int	licPaternidad; 
	private int	licCapacitacionExtranjero; 
	private int	licCapacitacionLocal; 
	private int	licEnfermedadGraveFamiliar; 
	private int	licSinGoceDeHaber;
	private String saldoVacaciones;
	private Date fechaingreso;
	private Date fechanacimiento;
	
	
	
	public PersonalAsistenciaResumenVO(){
		personal	= new PersonalVO();
	}

	
	
	
	
	public PersonalVO getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}

	public int getMinutosTardanza() {
		return minutosTardanza;
	}

	public void setMinutosTardanza(int minutosTardanza) {
		this.minutosTardanza = minutosTardanza;
	}

	public int getPermisoParticularDias() {
		return permisoParticularDias;
	}

	public void setPermisoParticularDias(int permisoParticularDias) {
		this.permisoParticularDias = permisoParticularDias;
	}

	public Time getPermisoParticularHoras() {
		return permisoParticularHoras;
	}

	public void setPermisoParticularHoras(Time permisoParticularHoras) {
		this.permisoParticularHoras = permisoParticularHoras;
	}

	public int getPermisoConGoceDias() {
		return permisoConGoceDias;
	}

	public void setPermisoConGoceDias(int permisoConGoceDias) {
		this.permisoConGoceDias = permisoConGoceDias;
	}

	public Time getPermisoConGoceHoras() {
		return permisoConGoceHoras;
	}

	public void setPermisoConGoceHoras(Time permisoConGoceHoras) {
		this.permisoConGoceHoras = permisoConGoceHoras;
	}

	public int getComisionLocalDias() {
		return comisionLocalDias;
	}

	public void setComisionLocalDias(int comisionLocalDias) {
		this.comisionLocalDias = comisionLocalDias;
	}

	public Time getComisionLocalHoras() {
		return comisionLocalHoras;
	}

	public void setComisionLocalHoras(Time comisionLocalHoras) {
		this.comisionLocalHoras = comisionLocalHoras;
	}

	public int getComisionProvinciaDias() {
		return comisionProvinciaDias;
	}

	public void setComisionProvinciaDias(int comisionProvinciaDias) {
		this.comisionProvinciaDias = comisionProvinciaDias;
	}

	public Time getComisionProvinciaHoras() {
		return comisionProvinciaHoras;
	}

	public void setComisionProvinciaHoras(Time comisionProvinciaHoras) {
		this.comisionProvinciaHoras = comisionProvinciaHoras;
	}

	public int getComisionExtranjeroDias() {
		return comisionExtranjeroDias;
	}

	public void setComisionExtranjeroDias(int comisionExtranjeroDias) {
		this.comisionExtranjeroDias = comisionExtranjeroDias;
	}

	public Time getComisionExtranjeroHoras() {
		return comisionExtranjeroHoras;
	}

	public void setComisionExtranjeroHoras(Time comisionExtranjeroHoras) {
		this.comisionExtranjeroHoras = comisionExtranjeroHoras;
	}

	public int getInasistencias() {
		return inasistencias;
	}

	public void setInasistencias(int inasistencias) {
		this.inasistencias = inasistencias;
	}

	public int getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(int vacaciones) {
		this.vacaciones = vacaciones;
	}

	public int getLicIncapacidadTemporalTrabajo() {
		return licIncapacidadTemporalTrabajo;
	}

	public void setLicIncapacidadTemporalTrabajo(int licIncapacidadTemporalTrabajo) {
		this.licIncapacidadTemporalTrabajo = licIncapacidadTemporalTrabajo;
	}

	public int getLicFallecimientoFamiliar() {
		return licFallecimientoFamiliar;
	}

	public void setLicFallecimientoFamiliar(int licFallecimientoFamiliar) {
		this.licFallecimientoFamiliar = licFallecimientoFamiliar;
	}

	public int getLicPaternidad() {
		return licPaternidad;
	}

	public void setLicPaternidad(int licPaternidad) {
		this.licPaternidad = licPaternidad;
	}

	public int getLicCapacitacionExtranjero() {
		return licCapacitacionExtranjero;
	}

	public void setLicCapacitacionExtranjero(int licCapacitacionExtranjero) {
		this.licCapacitacionExtranjero = licCapacitacionExtranjero;
	}

	public int getLicCapacitacionLocal() {
		return licCapacitacionLocal;
	}

	public void setLicCapacitacionLocal(int licCapacitacionLocal) {
		this.licCapacitacionLocal = licCapacitacionLocal;
	}

	public int getLicEnfermedadGraveFamiliar() {
		return licEnfermedadGraveFamiliar;
	}

	public void setLicEnfermedadGraveFamiliar(int licEnfermedadGraveFamiliar) {
		this.licEnfermedadGraveFamiliar = licEnfermedadGraveFamiliar;
	}

	public int getLicSinGoceDeHaber() {
		return licSinGoceDeHaber;
	}

	public void setLicSinGoceDeHaber(int licSinGoceDeHaber) {
		this.licSinGoceDeHaber = licSinGoceDeHaber;
	}


	public String getSaldoVacaciones() {
		return saldoVacaciones;
	}

	public void setSaldoVacaciones(String saldoVacaciones) {
		this.saldoVacaciones = saldoVacaciones;
	}


	public Date getFechaingreso() {
		return fechaingreso;
	}


	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}


	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
	

}
