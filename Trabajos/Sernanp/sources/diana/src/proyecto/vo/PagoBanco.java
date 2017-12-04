package proyecto.vo;

import java.io.Serializable;
import java.sql.Timestamp;


public class PagoBanco  implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idpagobanco;
	private String codigopagobanco;
	private String cadcodigotributo;
	private String cadtipodocumento;
	private String cadnumerodocumento;
	private String cadcodigoficha;
	private String cadnumeroregistro;
	private String cadimporte;
	private double importe;
	private Timestamp fechamovimiento;
	private String cadfechamovimiento;
	private String cadnumerovoucher;
	private String cadhora;
	private String caddigitochequeo;
	private String cadcodigoagencia;
	private String cadcodigocajero;
	private String cadfiller;
	private double saldo;
	private int idtabla;
	private int codigointtipo;
	
	public PagoBanco() {
		
	}

	

   public PagoBanco(int idpagobanco) {
		this.idpagobanco=idpagobanco;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}


	
	
	

	

	public Timestamp getFechamovimiento() {
		return fechamovimiento;
	}

	public void setFechamovimiento(Timestamp fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}

	
	public String getCadcodigotributo() {
		return cadcodigotributo;
	}

	public void setCadcodigotributo(String cadcodigotributo) {
		this.cadcodigotributo = cadcodigotributo;
	}

	public String getCadtipodocumento() {
		return cadtipodocumento;
	}

	public void setCadtipodocumento(String cadtipodocumento) {
		this.cadtipodocumento = cadtipodocumento;
	}

	public String getCadnumerodocumento() {
		return cadnumerodocumento;
	}

	public void setCadnumerodocumento(String cadnumerodocumento) {
		this.cadnumerodocumento = cadnumerodocumento;
	}

	public String getCadcodigoficha() {
		return cadcodigoficha;
	}

	public void setCadcodigoficha(String cadcodigoficha) {
		this.cadcodigoficha = cadcodigoficha;
	}

	public String getCadnumeroregistro() {
		return cadnumeroregistro;
	}

	public void setCadnumeroregistro(String cadnumeroregistro) {
		this.cadnumeroregistro = cadnumeroregistro;
	}

	public String getCadimporte() {
		return cadimporte;
	}

	public void setCadimporte(String cadimporte) {
		this.cadimporte = cadimporte;
	}

	public String getCadfechamovimiento() {
		return cadfechamovimiento;
	}

	public void setCadfechamovimiento(String cadfechamovimiento) {
		this.cadfechamovimiento = cadfechamovimiento;
	}

	public String getCadnumerovoucher() {
		return cadnumerovoucher;
	}

	public void setCadnumerovoucher(String cadnumerovoucher) {
		this.cadnumerovoucher = cadnumerovoucher;
	}

	public String getCadhora() {
		return cadhora;
	}

	public void setCadhora(String cadhora) {
		this.cadhora = cadhora;
	}

	public String getCaddigitochequeo() {
		return caddigitochequeo;
	}

	public void setCaddigitochequeo(String caddigitochequeo) {
		this.caddigitochequeo = caddigitochequeo;
	}

	public String getCadcodigoagencia() {
		return cadcodigoagencia;
	}

	public void setCadcodigoagencia(String cadcodigoagencia) {
		this.cadcodigoagencia = cadcodigoagencia;
	}

	public String getCadcodigocajero() {
		return cadcodigocajero;
	}

	public void setCadcodigocajero(String cadcodigocajero) {
		this.cadcodigocajero = cadcodigocajero;
	}

	public String getCadfiller() {
		return cadfiller;
	}

	public void setCadfiller(String cadfiller) {
		this.cadfiller = cadfiller;
	}

	

	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}





	public int getIdpagobanco() {
		return idpagobanco;
	}





	public void setIdpagobanco(int idpagobanco) {
		this.idpagobanco = idpagobanco;
	}



	public String getCodigopagobanco() {
		return codigopagobanco;
	}



	public void setCodigopagobanco(String codigopagobanco) {
		this.codigopagobanco = codigopagobanco;
	}



	public int getIdtabla() {
		return idtabla;
	}



	public void setIdtabla(int idtabla) {
		this.idtabla = idtabla;
	}



	public int getCodigointtipo() {
		return codigointtipo;
	}



	public void setCodigointtipo(int codigointtipo) {
		this.codigointtipo = codigointtipo;
	}

	
	
	
	
	
	
	
	
}
