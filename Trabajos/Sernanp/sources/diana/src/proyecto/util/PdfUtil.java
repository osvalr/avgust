package proyecto.util;

import java.io.Serializable;
import java.util.List;

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	
//	Font fuenteContenido=new Font(
//			FontFactory.getFont("arial",   // fuente
//	                 7,                            // tama�o
//	                 Font.NORMAL,                   // estilo
//	                 BaseColor.BLACK));
	
	
	
	
	
	
	
	public void agregarCeldaR(String frase,CeldaTablaPdf celdatpdf){
		PdfPCell cell = new PdfPCell(new Phrase(frase,celdatpdf.getFuente() ));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT); 
		celdatpdf.getTabla().addCell( cell ); 		
	}
	
	
	public void agregarCelda(String frase,CeldaTablaPdf celdatpdf){
		PdfPCell cell = new PdfPCell(celdatpdf.getCelda());
		cell.setPhrase(new Phrase(frase,celdatpdf.getFuente()));
		celdatpdf.getTabla().addCell( cell ); 		
	}
	
	

	
	
	public void agregarCelda(CeldaTablaPdf celdatpdf){
		celdatpdf.setCelda(new PdfPCell(new Phrase(celdatpdf.getFrase(),celdatpdf.getFuente() ))) ;
//		int alineacion=0;
//		if(celdatpdf.getCodalineacion()==1){
//			alineacion=Element.ALIGN_CENTER;
//		}
//		else
//			if(celdatpdf.getCodalineacion()==2){
//				alineacion=Element.ALIGN_RIGHT;
//			}
//			else
//				if(celdatpdf.getCodalineacion()==3){
//					alineacion=Element.ALIGN_LEFT;
//				}
		 
		celdatpdf.getTabla().addCell( celdatpdf.getCelda() ); 		
	}
	
	
	public void agregarListaCelda(List<CeldaTablaPdf> lista){
		for(CeldaTablaPdf cel:lista){
			agregarCelda(cel);
		}
	}
	
	
	public void agregarCeldas(String celda, String celdas[], CeldaTablaPdf celdagen){
		for(String c:celdas){
			CeldaTablaPdf cel=new CeldaTablaPdf();
			cel.setFrase(c);
			
			cel.setFuente(celdagen.getFuente());
			cel.setTabla(celdagen.getTabla());
			agregarCelda(cel);
		}
	}
	
	
	
	public PdfPTable agregarCurvaTabla(PdfPTable tabla){
		
		RoundRectangle curva = new RoundRectangle();
		PdfPTable tablaCurva = new PdfPTable(1); 
		tablaCurva.setWidthPercentage(95);
        PdfPCell celltc = new PdfPCell(tabla);
        celltc.setBorder(Rectangle.NO_BORDER);
        celltc.setCellEvent(curva);
        //celltc.setPadding(4);
        celltc.setPaddingLeft(4);
        celltc.setPaddingRight(4);
        celltc.setPaddingBottom(2);
        celltc.setPaddingTop(2);
        celltc.setVerticalAlignment(Rectangle.ALIGN_TOP);
        tablaCurva.addCell(celltc);
		return tablaCurva;
	}
	
public PdfPCell agregarCurvaCelda(PdfPCell celda){
		RoundRectangle curva = new RoundRectangle();
		PdfPCell celltc = new PdfPCell(celda);
        celltc.setBorder(Rectangle.NO_BORDER);
        celltc.setCellEvent(curva);
		return celltc;
	}
	
	
	

}
