package sernanp.app.dao.query.domain;

public class ReporteResumenNominaPagoFFMP_728Query_Liquidacion implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;
	private String var_nombre_afp;
	private String var_descrip_concepto;
	private Double dec_monto_calculado;
	private String c_meta;
	private Double liquido_pagar;
	private Double a19990;

	public String getVar_nombre_afp() {
		return var_nombre_afp;
	}

	public void setVar_nombre_afp(String var_nombre_afp) {
		this.var_nombre_afp = var_nombre_afp;
	}

	public String getVar_descrip_concepto() {
		return var_descrip_concepto;
	}

	public void setVar_descrip_concepto(String var_descrip_concepto) {
		this.var_descrip_concepto = var_descrip_concepto;
	}

	public Double getDec_monto_calculado() {
		return dec_monto_calculado;
	}

	public void setDec_monto_calculado(Double dec_monto_calculado) {
		this.dec_monto_calculado = dec_monto_calculado;
	}

	public String getC_meta() {
		return c_meta;
	}

	public void setC_meta(String c_meta) {
		this.c_meta = c_meta;
	}

	public Double getLiquido_pagar() {
		return liquido_pagar;
	}

	public void setLiquido_pagar(Double liquido_pagar) {
		this.liquido_pagar = liquido_pagar;
	}

	public Double getA19990() {
		return a19990;
	}

	public void setA19990(Double a19990) {
		this.a19990 = a19990;
	}

}
