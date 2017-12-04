package proyecto.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FichaRegistro {

	private int idficharegistro;
	private String codigoficha;
	private String lote;
	private String nombreproyecto;
	private String actividad;
	private String lugar;
	private Areanatural areanatural;
	private Personajuridica personajuridica;
	private Operadorturismo operadorturismo;
	private int idestadoficha;
	private Timestamp fechacreacion;
	private Timestamp fechaaprobacion;
	private Timestamp fechaaprobsys;
	private Timestamp fechadesaprobacion;
	
	private String nombrearchivo;
	private String observacion;
	private String comentario;
	
	private List<Tipo> tipomediotra;
	private List<PersonalRegistro> personalregistro;
	
		
	public FichaRegistro() {
		areanatural = new Areanatural();
		personajuridica = new Personajuridica();
		operadorturismo = new Operadorturismo();
		
		tipomediotra = new ArrayList<Tipo>();
		personalregistro = new ArrayList<PersonalRegistro>();
	}
	
	public int getIdficharegistro() {
		return idficharegistro;
	}
	public void setIdficharegistro(int idficharegistro) {
		this.idficharegistro = idficharegistro;
	}
	public String getCodigoficha() {
		return codigoficha;
	}
	public void setCodigoficha(String codigoficha) {
		this.codigoficha = codigoficha;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getNombreproyecto() {
		return nombreproyecto;
	}
	public void setNombreproyecto(String nombreproyecto) {
		this.nombreproyecto = nombreproyecto;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}		
	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public Personajuridica getPersonajuridica() {
		return personajuridica;
	}

	public void setPersonajuridica(Personajuridica personajuridica) {
		this.personajuridica = personajuridica;
	}

	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}

	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}

	public int getIdestadoficha() {
		return idestadoficha;
	}
	public void setIdestadoficha(int idestadoficha) {
		this.idestadoficha = idestadoficha;
	}
	public Timestamp getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Timestamp getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(Timestamp fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	public Timestamp getFechaaprobsys() {
		return fechaaprobsys;
	}

	public void setFechaaprobsys(Timestamp fechaaprobsys) {
		this.fechaaprobsys = fechaaprobsys;
	}

	public List<Tipo> getTipomediotra() {
		return tipomediotra;
	}

	public void setTipomediotra(List<Tipo> tipomediotra) {
		this.tipomediotra = tipomediotra;
	}

	public List<PersonalRegistro> getPersonalregistro() {
		return personalregistro;
	}

	public void setPersonalregistro(List<PersonalRegistro> personalregistro) {
		this.personalregistro = personalregistro;
	}

	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Timestamp getFechadesaprobacion() {
		return fechadesaprobacion;
	}

	public void setFechadesaprobacion(Timestamp fechadesaprobacion) {
		this.fechadesaprobacion = fechadesaprobacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
