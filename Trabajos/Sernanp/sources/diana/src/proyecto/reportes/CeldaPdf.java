package proyecto.reportes;

import java.io.Serializable;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class CeldaPdf implements Serializable{
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private PdfPCell celda;
private String valorCelda;
private int alineacion;
private Font fuente;
private float fondoCelda;

public CeldaPdf() {

}

public CeldaPdf(String valorCelda,Font fuente,int alineacion,float fondoCelda) {
	this.valorCelda=valorCelda;
	this.fuente=fuente;
	this.alineacion=alineacion;
    this.fondoCelda=fondoCelda;
}

public CeldaPdf(String valorCelda,Font fuente,int alineacion) {
	this.valorCelda=valorCelda;
	this.fuente=fuente;
	this.alineacion=alineacion;
}




public void agregarCelda(PdfPTable tabla){
	PdfPCell ccab =new PdfPCell (new Paragraph(valorCelda,fuente)); 
	ccab.setHorizontalAlignment(alineacion);
	tabla.addCell(ccab);
}

public void agregarCelda(PdfPTable tabla,float fondoCelda){
	PdfPCell ccab =new PdfPCell (new Paragraph(valorCelda,fuente)); 
	ccab.setHorizontalAlignment(alineacion);
	ccab.setGrayFill(fondoCelda);
	tabla.addCell(ccab);
}

public void agregarCelda(PdfPTable tabla, int colspan){
	PdfPCell ccab =new PdfPCell (new Paragraph(valorCelda,fuente)); 
	ccab.setHorizontalAlignment(alineacion);
	ccab.setColspan(colspan);
	tabla.addCell(ccab);
}

public void agregarCelda(PdfPTable tabla, int colspan,float fondoCelda){
	PdfPCell ccab =new PdfPCell (new Paragraph(valorCelda,fuente)); 
	ccab.setHorizontalAlignment(alineacion);
	ccab.setColspan(colspan);
	ccab.setGrayFill(fondoCelda);
	tabla.addCell(ccab);
}


public PdfPCell getCelda() {
	return celda;
}

public void setCelda(PdfPCell celda) {
	this.celda = celda;
}

public String getValorCelda() {
	return valorCelda;
}

public void setValorCelda(String valorCelda) {
	this.valorCelda = valorCelda;
}

public int getAlineacion() {
	return alineacion;
}

public void setAlineacion(int alineacion) {
	this.alineacion = alineacion;
}

public Font getFuente() {
	return fuente;
}

public void setFuente(Font fuente) {
	this.fuente = fuente;
}

public float getFondoCelda() {
	return fondoCelda;
}

public void setFondoCelda(float fondoCelda) {
	this.fondoCelda = fondoCelda;
}

	





}
