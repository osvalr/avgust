package sernanp.rrhh.vo;

import java.util.Date;

public class LoginVO {
	private Integer intIdLogin;
	private String strClave;
	private String strClaveMD5;
	private String strUsuario;
	private Integer intIdUsuario;
	private Integer intIdSistema;
	private Date dteFecha;
	public Integer getIntIdLogin() {
		return intIdLogin;
	}
	public void setIntIdLogin(Integer intIdLogin) {
		this.intIdLogin = intIdLogin;
	}
	public String getStrClave() {
		return strClave;
	}
	public void setStrClave(String strClave) {
		this.strClave = strClave;
	}
	public String getStrUsuario() {
		return strUsuario;
	}
	public void setStrUsuario(String strUsuario) {
		this.strUsuario = strUsuario;
	}
	public Integer getIntIdSistema() {
		return intIdSistema;
	}
	public void setIntIdSistema(Integer intIdSistema) {
		this.intIdSistema = intIdSistema;
	}
	public Date getDteFecha() {
		return dteFecha;
	}
	public void setDteFecha(Date dteFecha) {
		this.dteFecha = dteFecha;
	}
	public String getStrClaveMD5() {
		return strClaveMD5;
	}
	public void setStrClaveMD5(String strClaveMD5) {
		this.strClaveMD5 = strClaveMD5;
	}
	public Integer getIntIdUsuario() {
		return intIdUsuario;
	}
	public void setIntIdUsuario(Integer intIdUsuario) {
		this.intIdUsuario = intIdUsuario;
	}
	
//	sernanp.login
//		idlogin serial NOT NULL,
//		clave character varying(100),
//		usuario character varying(50),
//		idsistema integer NOT NULL,
//		fecha timestamp without time zone,
	
}
