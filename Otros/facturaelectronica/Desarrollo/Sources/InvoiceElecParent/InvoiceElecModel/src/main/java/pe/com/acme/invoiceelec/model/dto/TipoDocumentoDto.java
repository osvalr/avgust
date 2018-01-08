package pe.com.acme.invoiceelec.model.dto;

public class TipoDocumentoDto {
	
	private String codDocumento;
	private String descripDocumento;
	
	public String getDescripDocumento() {
		return descripDocumento;
	}
	public void setDescripDocumento(String descripDocumento) {
		this.descripDocumento = descripDocumento;
	}
	public String getCodDocumento() {
		return codDocumento;
	}
	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}
}
