package sernanp.app.util;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 6182952409968871179L;
	
	private String codError;
	private String msjError;
	
	public BusinessException(String codError, String msjError) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
	}
	
	public BusinessException(String msjError, Throwable cause) {
		super(msjError);	
	}
	public BusinessException(String msjError) {
		super(msjError);	
	}
	
	public String getCodError() {
		return codError;
	}
	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getMsjError() {
		return msjError;
	}
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}
	
	
}
