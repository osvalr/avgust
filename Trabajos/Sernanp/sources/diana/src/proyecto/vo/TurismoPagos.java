package proyecto.vo;

import java.io.Serializable;
import java.util.Date;

// JCEV 17-07-2012 al 19-07-2012
public class TurismoPagos  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String strFecIni;
	private String strFecFin;
	
	private int    nIdtPago;
	private String strCodTPago;
	private String strTipoDoc;
	private String strNumDoc;
	private String strRegTurismo;	
	private String strRegistroTurista;	
	private String strCodRutaTurismo;
	private String strCodCateg;
	private String strCodAreaNat;	
	private String strRutaTurimo;
//	private String strFecRegTur;
	private Date   dFecRegTur;
	private Date   dFechaPago;
	private double dbImpPag;
	private String strFecMov;

	private String strCodAge;
	private String strCodCaj;
	private String strIdtCtl;

	public TurismoPagos() {
	}

	public int getnIdtPago() {
		return nIdtPago;
	}

	public void setnIdtPago(int nIdtPago) {
		this.nIdtPago = nIdtPago;
	}
	
	public String getStrFecMov() {
		return strFecMov;
	}

	public void setStrFecMov(String strFecMov) {
		this.strFecMov = strFecMov;
	}

	public String getStrFecIni() {
		return strFecIni;
	}

	public void setStrFecIni(String strFecIni) {
		this.strFecIni = strFecIni;
	}

	public String getStrFecFin() {
		return strFecFin;
	}

	public void setStrFecFin(String strFecFin) {
		this.strFecFin = strFecFin;
	}
	
	public String getStrCodTPago() {
		return strCodTPago;
	}

	public void setStrCodTPago(String strCodTPago) {
		this.strCodTPago = strCodTPago;
	}

	public String getStrTipoDoc() {
		return strTipoDoc;
	}

	public void setStrTipoDoc(String strTipoDoc) {
		this.strTipoDoc = strTipoDoc;
	}

	public String getStrNumDoc() {
		return strNumDoc;
	}

	public void setStrNumDoc(String strNumDoc) {
		this.strNumDoc = strNumDoc;
	}

	public String getStrRegTurismo() {
		return strRegTurismo;
	}

	public void setStrRegTurismo(String strRegTurismo) {
		this.strRegTurismo = strRegTurismo;
	}

	public String getStrCodCateg() {
		return strCodCateg;
	}

	public void setStrCodCateg(String strCodCateg) {
		this.strCodCateg = strCodCateg;
	}

	public String getStrCodAreaNat() {
		return strCodAreaNat;
	}

	public void setStrCodAreaNat(String strCodAreaNat) {
		this.strCodAreaNat = strCodAreaNat;
	}

	public String getStrRutaTurimo() {
		return strRutaTurimo;
	}

	public void setStrRutaTurimo(String strRutaTurimo) {
		this.strRutaTurimo = strRutaTurimo;
	}

	public Date getdFecRegTur() {
		return dFecRegTur;
	}

	public void setdFechaPago(Date dFechaPago) {
		this.dFechaPago = dFechaPago;
	}

	public void setdFecRegTur(Date dFecRegTur) {
		this.dFecRegTur = dFecRegTur;
	}

	public Date getdFechaPago() {
		return dFechaPago;
	}

	public double getDbImpPag() {
		return dbImpPag;
	}

	public void setDbImpPag(double dbImpPag) {
		this.dbImpPag = dbImpPag;
	}

	public String getStrCodAge() {
		return strCodAge;
	}

	public void setStrCodAge(String strCodAge) {
		this.strCodAge = strCodAge;
	}

	public String getStrCodCaj() {
		return strCodCaj;
	}

	public void setStrCodCaj(String strCodCaj) {
		this.strCodCaj = strCodCaj;
	}
	public String getStrIdtCtl() {
		return strIdtCtl;
	}

	public void setStrIdtCtl(String strIdtCtl) {
		this.strIdtCtl = strIdtCtl;
	}

	public String getStrCodRutaTurismo() {
		return strCodRutaTurismo;
	}

	public void setStrCodRutaTurismo(String strCodRutaTurismo) {
		this.strCodRutaTurismo = strCodRutaTurismo;
	}

	public String getStrRegistroTurista() {
		return strRegistroTurista;
	}

	public void setStrRegistroTurista(String strRegistroTurista) {
		this.strRegistroTurista = strRegistroTurista;
	}

}