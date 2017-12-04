package proyecto.vo;

import java.io.Serializable;

public class TurismoPagosDetalle  implements Serializable {

	private static final long serialVersionUID = 1L;

	private int    nIdBoletaje;
	private String strNombreBoletaje;
	private int    nSerieBoletaje;
	private double dbValorBoletaje;
	private String strIdFichaTurismo;	
	private String strCodFicha;
	private double dbImpPag;
	private String strFechaMov;

	public int getnIdBoletaje() {
		return nIdBoletaje;
	}
	
	public void setnIdBoletaje(int nIdBoletaje) {
		this.nIdBoletaje = nIdBoletaje;
	}
	
	public String getStrNombreBoletaje() {
		return strNombreBoletaje;
	}
	
	public void setStrNombreBoletaje(String strNombreBoletaje) {
		this.strNombreBoletaje = strNombreBoletaje;
	}
	
	public String getStrIdFichaTurismo() {
		return strIdFichaTurismo;
	}
	
	public void setStrIdFichaTurismo(String strIdFichaTurismo) {
		this.strIdFichaTurismo = strIdFichaTurismo;
	}
	
	public String getStrCodFicha() {
		return strCodFicha;
	}
	
	public void setStrCodFicha(String strCodFicha) {
		this.strCodFicha = strCodFicha;
	}
	
	public double getDbImpPag() {
		return dbImpPag;
	}
	
	public void setDbImpPag(double dbImpPag) {
		this.dbImpPag = dbImpPag;
	}
	
	public String getStrFechaMov() {
		return strFechaMov;
	}

	public void setStrFechaMov(String strFechaMov) {
		this.strFechaMov = strFechaMov;
	}
	
	public int getnSerieBoletaje() {
		return nSerieBoletaje;
	}

	public void setnSerieBoletaje(int nSerieBoletaje) {
		this.nSerieBoletaje = nSerieBoletaje;
	}

	public double getDbValorBoletaje() {
		return dbValorBoletaje;
	}

	public void setDbValorBoletaje(double dbValorBoletaje) {
		this.dbValorBoletaje = dbValorBoletaje;
	}

}