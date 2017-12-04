package proyecto.util;

import java.io.Serializable;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class CeldaTablaPdf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private PdfPTable tabla;
	private String frase;
	private Font fuente;
	private PdfPCell celda;

	
	
	public CeldaTablaPdf(){
		
		
	}

	
    public CeldaTablaPdf(PdfPTable tabla,String frase, Font fuente){
		this.tabla=tabla;
		this.frase=frase;
		this.fuente=fuente;
		//this.codalineacion=codalineacion;
		celda=new PdfPCell();
	}


	public PdfPTable getTabla() {
		return tabla;
	}



	public void setTabla(PdfPTable tabla) {
		this.tabla = tabla;
	}



	public String getFrase() {
		return frase;
	}



	public void setFrase(String frase) {
		this.frase = frase;
	}



	public Font getFuente() {
		return fuente;
	}



	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}


	public PdfPCell getCelda() {
		return celda;
	}


	public void setCelda(PdfPCell celda) {
		this.celda = celda;
	}



	
	
	
	
	
	
	

}
