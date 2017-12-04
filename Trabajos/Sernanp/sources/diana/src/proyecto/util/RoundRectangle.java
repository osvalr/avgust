package proyecto.util;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;

public class RoundRectangle implements PdfPCellEvent {
	public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
	    PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
	    cb.setLineWidth(0.1f);
	    //cb.setColorStroke(new GrayColor(0.8f));
	    //cb.roundRectangle(rect.getLeft() + 4, rect.getBottom()+1, rect.getWidth()-8, rect.getHeight() - 4, 4);
	    //cb.setHorizontalScaling(2);
	    cb.roundRectangle(rect.getLeft() + 4, rect.getBottom()+1, rect.getWidth()-8, rect.getHeight() - 4, 4);
	    cb.stroke();
	  }


}
