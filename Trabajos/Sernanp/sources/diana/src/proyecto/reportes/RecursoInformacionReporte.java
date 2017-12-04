package proyecto.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import proyecto.vo.Editorial;
import proyecto.vo.RecursoInformacion;
import proyecto.vo.RecursoInformacionAreanatural;
import proyecto.vo.RecursoInformacionAutor;
import proyecto.vo.RecursoInformacionEditorial;
import proyecto.vo.RecursoInformacionTema;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class RecursoInformacionReporte {

	
	
	
	
	
	public String exportarExcelRecursoInformacion(List<RecursoInformacion> lista,Map<String, Object> mapParam){
		
		String rutaArchivo="";
		Workbook wb = new HSSFWorkbook();
		Date instante=new Date();
   	 	long inst =instante.getTime();
		rutaArchivo=mapParam.get("rutaArchivo").toString()+inst+".xls";
		//SimpleDateFormat formateador=(SimpleDateFormat) mapParam.get("formateador");
      	//SimpleDateFormat formateador2=(SimpleDateFormat) mapParam.get("formateador2");
      	//Usuario user=(Usuario) mapParam.get("user");
		String nombreImagen=mapParam.get("nombreImagen").toString(); 
		String rutaImagen=mapParam.get("rutaImagen").toString(); 
    	 
		 try {
			 
				FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
			int indrow=0;
		    CreationHelper createHelper = wb.getCreationHelper();  
		    Sheet sheet = wb.createSheet("Biblioteca Institucional");  
		    
           sheet.setColumnWidth(1, (short)((50 * 38) / ((double)1 / 20)));
           //cabecera
           String rutaArchivoImagen=rutaImagen+nombreImagen;
			 
           
           
                                                                            
           InputStream is = new FileInputStream(rutaArchivoImagen);
           byte[] bytes = IOUtils.toByteArray(is);
           int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
           is.close();
           Drawing drawing = sheet.createDrawingPatriarch();
           ClientAnchor anchor = createHelper.createClientAnchor();
           anchor.setRow1(0);
           anchor.setRow2(3);
           anchor.setCol1(2);
           anchor.setCol2(4);
           
           Picture pict = drawing.createPicture(anchor, pictureIdx);
          
           

           
           //titulo
           //estilo titulo
           HSSFCellStyle stltitulo =(HSSFCellStyle) wb.createCellStyle(); 
           HSSFFont ftitulo= (HSSFFont) wb.createFont();
           ftitulo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
           ftitulo.setFontHeightInPoints((short)14);
           stltitulo.setFont(ftitulo);
           stltitulo.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
          
           //add celda titulo
           Row rowt = sheet.createRow((short) 0);
           Cell cellt = rowt.createCell(2);
           cellt.setCellStyle(stltitulo);
           cellt.setCellValue(mapParam.get("titulo").toString());
           
           //
           rowt = sheet.createRow((short) 3);
           cellt = rowt.createCell(2);
           stltitulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
           cellt.setCellStyle(stltitulo);
           cellt.setCellValue("Biblioteca Institucional");
           
           
           //estilo encabezado tabla
           HSSFCellStyle stlenctab =(HSSFCellStyle) wb.createCellStyle(); 
           HSSFFont fenctab= (HSSFFont) wb.createFont();
           fenctab.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
           fenctab.setFontHeightInPoints((short)8);
           stlenctab.setFont(fenctab);
           stlenctab.setAlignment(HSSFCellStyle.ALIGN_CENTER);
           stlenctab.setFillBackgroundColor(HSSFColor.AQUA.index );
           stlenctab.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
           stlenctab.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

           //add celda encabezado
           int indexContenidoCabecera=4;
           indrow=indexContenidoCabecera;
           Row rowc = sheet.createRow((short) indrow);
           List<String> listaCabecera=new ArrayList<String>();
           listaCabecera.add("NRO");
           listaCabecera.add("CODIGO");
           listaCabecera.add("RECURSO INFORMACION");
           listaCabecera.add("TIPO");
           listaCabecera.add("MEDIO");
           //celdas
           for(int j=0;j<listaCabecera.size();j++){
       		Cell cell = rowc.createCell(j);  
       		{
       			cell.setCellStyle(stlenctab);
       			cell.setCellValue(listaCabecera.get(j));	
       		}
       	   }
           
           
           
          
           int indexContenidoLista=5;
        
           for (int i = 0; i < lista.size(); i++) { 
              	indrow=i+indexContenidoLista;
              	Row row = sheet.createRow((short) indrow); 
              	//sheet.setColumnWidth((short)0, (short) (3/((double)1/256)) );// 
              	//lista
              	
              	RecursoInformacion ri=lista.get(i);
              
              
              	List<String> listaAtributos=new ArrayList<String>();
                  
              
              	
              	
              	//nfila
              	listaAtributos.add(String.valueOf(i+1));
                //codigo
              	listaAtributos.add(  ri.getCodigorecursoinformacion()!= null ? ri.getCodigorecursoinformacion():"" );
              	//titulo
              	listaAtributos.add(  ri.getTitulo()!= null ? ri.getTitulo():"" );
                //tipo
              	listaAtributos.add(  ri.getTiporecursoinformacion().getNombretipo()!= null ? ri.getTiporecursoinformacion().getNombretipo():"" );
                //medio
              	listaAtributos.add(  ri.getMediorecursoinformacion().getNombretipo()!= null ? ri.getMediorecursoinformacion().getNombretipo():"" );
              
              	//listaAtributos.add(String.valueOf(p.getFechainicioproyecto())==null ? "" : formateador.format(p.getFechainicioproyecto()));
              	
              	
              	       	//para llenar columnas
              	for(int j=0;j<listaAtributos.size();j++){
              		Cell cell = row.createCell(j);
              		if(j!=1){
              			HSSFCellStyle cellStyle = (HSSFCellStyle) wb.createCellStyle();
                  		//cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
                  		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                  		//cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
                  		cell.setCellStyle(cellStyle);

              		}
              		
              		cell.setCellValue(listaAtributos.get(j));	         		
              	}
           }
           
           //int pie=contenido+1+lista.size()+5;
         
           
           List<String> listaPie=new ArrayList<String>();
          // listaPie.add("Fecha Reporte: "+formateador2.format(new Date()));
           //listaPie.add("Usuario:"+user.getUsuario());
           int indexPie=indexContenidoLista+lista.size()+5;
           for(int j=0;j<listaPie.size();j++){
        	   indrow=j+indexPie;
        	   Row rowp = sheet.createRow((short)indrow); 
        	   Cell cellp = rowp.createCell(1);
        	  
        	   cellp.setCellValue(listaPie.get(j));
           }
           
           
           
     
           wb.write(fileOut);
		    fileOut.close();
		 
		    // return resultadoListaProyecto= new FileInputStream(new File(rutaArchivo));
		//File fdel=new File(rutaArchivo);
		//fdel.delete();
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
     } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
		
		
     return rutaArchivo;
		
	}
	
	
	
	
	
	
	public String generarPdfRegistroRecursoInformacion(RecursoInformacion recursoinformacion ,Map<String, Object> mapParam){
		String rutaArchivo="";
		Date instante=new Date();
  	 	long inst =instante.getTime();
		rutaArchivo=mapParam.get("rutaArchivo").toString()+inst+".pdf";
		//String titulo=mapParam.get("titulo").toString();
     	String rutaImagen=mapParam.get("rutaImagen").toString();
     	String nombreImagen=mapParam.get("nombreImagen").toString();
       String rutaArchivoImagen=rutaImagen+nombreImagen;
		
       Document documento = new Document(PageSize.A4, 36, 30, 30, 30);
		  
		 
       try { 
			FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
			PdfWriter.getInstance(documento,fileOut);
			documento.open();
			documento.addTitle("Reporte de Biblioteca Institucional");
			//logo
			Image logo=Image.getInstance(rutaArchivoImagen);
			logo.setAlignment(Image.LEFT| Image.TEXTWRAP);
			logo.scaleAbsolute(70, 30);
			Chunk imgDoc = new Chunk(logo, 0, -15);
			Phrase fenc=new Phrase();
			fenc.add(imgDoc);
			//fenc.add(tituloDoc);
			Paragraph penc=new Paragraph(fenc);
			documento.add(penc);
			//salto de linea
			Paragraph pesp=new Paragraph("\n");
			documento.add(pesp);
			//titulo
			Paragraph ptit=new Paragraph("FICHA RECURSO DE INFORMACION",new Font(Font.getFamily("Arial"), 9, Font.BOLD));
			ptit.setAlignment(Element.ALIGN_CENTER);
			documento.add(ptit);
			documento.add(pesp);
			//fuentes 
			Font fuenteCabecera=new Font(
			FontFactory.getFont("arial",   // fuente
	                 7,                            // tama�o
	                 Font.BOLD,                   // estilo
	                 BaseColor.BLACK));	
	        Font fuenteContenido=new Font(
			FontFactory.getFont("arial",   // fuente
	                 7,                            // tama�o
	                 Font.NORMAL,                   // estilo
	                 BaseColor.BLACK));    
			
			//datos generales
			PdfPTable tabla = new PdfPTable(2);
			float[] medidaCeldas = { 0.40f, 2.25f};
			tabla.setWidths(medidaCeldas);
			tabla.setWidthPercentage(100);
			
			Font fontCab = new Font(Font.getFamily("GEORGIA"), 10, Font.BOLD);
			
			
			
			Paragraph pdatgen=new Paragraph("DATOS GENERALES",new Font(Font.getFamily("Arial"), 9, Font.BOLD));
			ptit.setAlignment(Element.ALIGN_LEFT);
			documento.add(pdatgen);
			documento.add(pesp);
			
			
			CeldaPdf ccab=new CeldaPdf("DATOS",fuenteCabecera,Element.ALIGN_CENTER);
			ccab.agregarCelda(tabla,0.8f);
			CeldaPdf cdes=new CeldaPdf("DESCRIPCION",fuenteCabecera,Element.ALIGN_CENTER);
			cdes.agregarCelda(tabla,0.8f);
			CeldaPdf clblcodigo=new CeldaPdf("CODIGO",fuenteContenido,Element.ALIGN_LEFT);
			clblcodigo.agregarCelda(tabla);
			CeldaPdf ccodigo=new CeldaPdf(recursoinformacion.getCodigorecursoinformacion(),fuenteContenido,Element.ALIGN_LEFT);
			ccodigo.agregarCelda(tabla);
			CeldaPdf clbltitulo=new CeldaPdf("TITULO",fuenteContenido,Element.ALIGN_LEFT);
			clbltitulo.agregarCelda(tabla);
			CeldaPdf ctitulo=new CeldaPdf(recursoinformacion.getTitulo()==null ?"":recursoinformacion.getTitulo().toUpperCase(),fuenteContenido,Element.ALIGN_LEFT);
			ctitulo.agregarCelda(tabla);
			CeldaPdf clbltiprecinf=new CeldaPdf("TIPO RECURSO INFORMACION",fuenteContenido,Element.ALIGN_LEFT);
			clbltiprecinf.agregarCelda(tabla);
			CeldaPdf ctiprecinf=new CeldaPdf(recursoinformacion.getTiporecursoinformacion().getIdtipo()==0 ?"":recursoinformacion.getTiporecursoinformacion().getNombretipo().toUpperCase(),fuenteContenido,Element.ALIGN_LEFT);
			ctiprecinf.agregarCelda(tabla);
			CeldaPdf clblmedio=new CeldaPdf("MEDIO",fuenteContenido,Element.ALIGN_LEFT);
			clblmedio.agregarCelda(tabla);
			CeldaPdf cmedio=new CeldaPdf(recursoinformacion.getMediorecursoinformacion().getIdtipo()==0 ?"":recursoinformacion.getMediorecursoinformacion().getNombretipo().toUpperCase(),fuenteContenido,Element.ALIGN_LEFT);
			cmedio.agregarCelda(tabla);
			CeldaPdf clbltematica=new CeldaPdf("TEMATICA",fuenteContenido,Element.ALIGN_LEFT);
			clbltematica.agregarCelda(tabla);
			CeldaPdf ctematica=new CeldaPdf(recursoinformacion.getTematicarecursoinformacion().getIdtematicarecursoinformacion()==0 ?"":recursoinformacion.getTematicarecursoinformacion().getNombretematicarecursoinformacion().toUpperCase(),fuenteContenido,Element.ALIGN_LEFT);
			ctematica.agregarCelda(tabla);
			CeldaPdf clblidioma=new CeldaPdf("IDIOMA",fuenteContenido,Element.ALIGN_LEFT);
			clblidioma.agregarCelda(tabla);
			CeldaPdf cidioma=new CeldaPdf(recursoinformacion.getIdioma().getIdidioma()==0 ?"":recursoinformacion.getIdioma().getNombreidioma().toUpperCase(),fuenteContenido,Element.ALIGN_LEFT);
			cidioma.agregarCelda(tabla);
			CeldaPdf clblisbn=new CeldaPdf("ISBN",fuenteContenido,Element.ALIGN_LEFT);
			clblisbn.agregarCelda(tabla);
			CeldaPdf cisbn=new CeldaPdf(recursoinformacion.getIsbn()==null ?"":recursoinformacion.getIsbn(),fuenteContenido,Element.ALIGN_LEFT);
			cisbn.agregarCelda(tabla);
			CeldaPdf clblcodsgd=new CeldaPdf("CODIGO SGD",fuenteContenido,Element.ALIGN_LEFT);
			clblcodsgd.agregarCelda(tabla);
			CeldaPdf ccodsgd=new CeldaPdf(recursoinformacion.getCodigosgd()==null ?"":recursoinformacion.getCodigosgd().toUpperCase(),fuenteContenido,Element.ALIGN_LEFT);
			ccodsgd.agregarCelda(tabla);
			documento.add(tabla);
			documento.add(pesp);
			
			
			
			
			//datos bibliograficos
			PdfPTable tabladatbiblio = new PdfPTable(2);
			float[] medidaCeldasbiblio = { 0.40f, 2.25f};
			tabladatbiblio.setWidths(medidaCeldasbiblio);
			tabladatbiblio.setWidthPercentage(100);
			
			Paragraph pdatbiblio=new Paragraph("DATOS BIBLIOGRAFICOS",new Font(Font.getFamily("Arial"), 9, Font.BOLD));
			ptit.setAlignment(Element.ALIGN_LEFT);
			documento.add(pdatbiblio);
			documento.add(pesp);
			//editoriales
			if(recursoinformacion.getListaRecursoInformacionEditorial().size()!=0){
			CeldaPdf clbledit=new CeldaPdf("EDITORIAL(ES)",fuenteCabecera,Element.ALIGN_LEFT);
			clbledit.agregarCelda(tabladatbiblio,2,0.8f);
			for(RecursoInformacionEditorial re:recursoinformacion.getListaRecursoInformacionEditorial()){
				CeldaPdf cedit=new CeldaPdf(re.getEditorial().getNombrepersonajuridica()==null ?"":re.getEditorial().getNombrepersonajuridica(),fuenteContenido,Element.ALIGN_LEFT);
				cedit.agregarCelda(tabladatbiblio,2);
				
			}
			}
			//autores
			if(recursoinformacion.getListaRecursoInformacionAutor().size()!=0){
			CeldaPdf clblaut=new CeldaPdf("AUTOR(ES)",fuenteCabecera,Element.ALIGN_LEFT);
			clblaut.agregarCelda(tabladatbiblio,2,0.8f);
			for(RecursoInformacionAutor ra:recursoinformacion.getListaRecursoInformacionAutor()){
				CeldaPdf caut=new CeldaPdf( ra.getAutor().getApepat()+" "+ra.getAutor().getApemat()+","+ ra.getAutor().getNombre(),fuenteContenido,Element.ALIGN_LEFT);
				caut.agregarCelda(tabladatbiblio,2);
				
			}
			}
			//temas
			if(recursoinformacion.getListaRecursoInformacionTema().size()!=0){
				CeldaPdf clbltema=new CeldaPdf("TEMA(ES)",fuenteCabecera,Element.ALIGN_LEFT);
				clbltema.agregarCelda(tabladatbiblio,2,0.8f);
				for(RecursoInformacionTema rt:recursoinformacion.getListaRecursoInformacionTema()){
					CeldaPdf ctem=new CeldaPdf(rt.getTema().getNombretema()==null ?"":rt.getTema().getNombretema(),fuenteContenido,Element.ALIGN_LEFT);
					ctem.agregarCelda(tabladatbiblio,2);
					
				}
			}
			
			
			//descripcion bibliografica
			CeldaPdf clbltdesbib=new CeldaPdf("DESCRIPCION BIBLIOGRAFICA",fuenteCabecera,Element.ALIGN_LEFT);
			clbltdesbib.agregarCelda(tabladatbiblio,2,0.8f);
			CeldaPdf clbldesbib=new CeldaPdf("DESCRIPCION",fuenteContenido,Element.ALIGN_LEFT);
			clbldesbib.agregarCelda(tabladatbiblio);
			CeldaPdf cdesbib=new CeldaPdf(recursoinformacion.getDescripcion()==null?"":recursoinformacion.getDescripcion(),fuenteContenido,Element.ALIGN_LEFT);
			cdesbib.agregarCelda(tabladatbiblio);
			if(recursoinformacion.getNumeropaginas()!=0){
				CeldaPdf clblnumpag=new CeldaPdf("N DE PAGINAS",fuenteContenido,Element.ALIGN_LEFT);
				clblnumpag.agregarCelda(tabladatbiblio);
				CeldaPdf cnumpag=new CeldaPdf(String.valueOf(recursoinformacion.getNumeropaginas()),fuenteContenido,Element.ALIGN_LEFT);
				cnumpag.agregarCelda(tabladatbiblio);
			}
			
			
			documento.add(tabladatbiblio);
			
			documento.add(pesp);
			
			//datos adicionales
			Paragraph pdatadic=new Paragraph("DATOS ADICIONALES",new Font(Font.getFamily("Arial"), 9, Font.BOLD));
			ptit.setAlignment(Element.ALIGN_LEFT);
			documento.add(pdatadic);
			documento.add(pesp);
			PdfPTable tabladatadic = new PdfPTable(2);
			float[] medidaCeldasdatadic = { 0.40f, 2.25f};
			tabladatadic.setWidths(medidaCeldasdatadic);
			tabladatadic.setWidthPercentage(100);
			
			if(recursoinformacion.getListaRecursoInformacionAreanatural().size()!=0){
				CeldaPdf clbltanp=new CeldaPdf("AREA(S) NATURAL(ES) INVOLUCRADA(S)",fuenteCabecera,Element.ALIGN_LEFT);
				clbltanp.agregarCelda(tabladatadic,2,0.8f);
				CeldaPdf clblcatanp=new CeldaPdf("CATEGORIA ANP",fuenteContenido,Element.ALIGN_LEFT);
				clblcatanp.agregarCelda(tabladatadic);
				CeldaPdf clblanp=new CeldaPdf("ANP",fuenteContenido,Element.ALIGN_LEFT);
				clblanp.agregarCelda(tabladatadic);
				for(RecursoInformacionAreanatural ranp:recursoinformacion.getListaRecursoInformacionAreanatural()){
					CeldaPdf ccatanp=new CeldaPdf(ranp.getAreanatural().getCategoriaanp().getDescategoriaanp()==null?"":ranp.getAreanatural().getCategoriaanp().getDescategoriaanp(),fuenteContenido,Element.ALIGN_LEFT);
					ccatanp.agregarCelda(tabladatadic);
					CeldaPdf canp=new CeldaPdf(ranp.getAreanatural().getDesareanatural()==null?"":ranp.getAreanatural().getDesareanatural(),fuenteContenido,Element.ALIGN_LEFT);
					canp.agregarCelda(tabladatadic);
					
				}
			}
			
			if(recursoinformacion.getAprobacionrecursoinformacion().getIdaprobacionrecursoinformacion()!=0){
				CeldaPdf clbltanp=new CeldaPdf("DATOS DE APROBACION",fuenteCabecera,Element.ALIGN_LEFT);
				clbltanp.agregarCelda(tabladatadic,2,0.8f);
				CeldaPdf clbldep=new CeldaPdf("DEPENDENCIA",fuenteContenido,Element.ALIGN_LEFT);
				clbldep.agregarCelda(tabladatadic);
				CeldaPdf cdep=new CeldaPdf(recursoinformacion.getAprobacionrecursoinformacion().getAreaorganica().getDesarea()==null?"":recursoinformacion.getAprobacionrecursoinformacion().getAreaorganica().getDesarea(),fuenteContenido,Element.ALIGN_LEFT);
				cdep.agregarCelda(tabladatadic);
				CeldaPdf clbljef=new CeldaPdf("JEFE/DIRECTOR",fuenteContenido,Element.ALIGN_LEFT);
				clbljef.agregarCelda(tabladatadic);
				CeldaPdf cjef=new CeldaPdf(recursoinformacion.getAprobacionrecursoinformacion().getPersonal().getApepat()+" "+
						recursoinformacion.getAprobacionrecursoinformacion().getPersonal().getApemat()+","+
						 recursoinformacion.getAprobacionrecursoinformacion().getPersonal().getNombre() ,fuenteContenido,Element.ALIGN_LEFT);
				cjef.agregarCelda(tabladatadic);
				
			}
			
		
			documento.add(tabladatadic);
		    tabla.setHeaderRows(1);
		
			
			documento.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return rutaArchivo;
    
	}

		
		
	
	
	//listado de recursos pdf
   public String exportarPdfRecursoInformacion(List<RecursoInformacion> lista,Map<String, Object> mapParam){
		
	   String rutaArchivo="";
		
	   
	    Date instante=new Date();
  	 	long inst =instante.getTime();
		rutaArchivo=mapParam.get("rutaArchivo").toString()+inst+".pdf";
		//SimpleDateFormat formateador=(SimpleDateFormat) mapParam.get("formateador");
     	//SimpleDateFormat formateador2=(SimpleDateFormat) mapParam.get("formateador2");
     	//Usuario user=(Usuario) mapParam.get("user");
     	String titulo=mapParam.get("titulo").toString();
     	String rutaImagen=mapParam.get("rutaImagen").toString();
     	String nombreImagen=mapParam.get("nombreImagen").toString();
       String rutaArchivoImagen=rutaImagen+nombreImagen;
     	 
     
		  Document documento = new Document(PageSize.A4, 36, 30, 30, 30);
		  
		  try { 
			FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
			PdfWriter.getInstance(documento,fileOut);
			documento.open();
			PdfPTable tabla = new PdfPTable(5);
			float[] medidaCeldas = {0.15f,0.25f, 2.25f, 0.40f, 0.40f};
			documento.addTitle("Reporte de Biblioteca Institucional");

			tabla.setWidths(medidaCeldas);
			tabla.setWidthPercentage(100);
			
			Image logo=Image.getInstance(rutaArchivoImagen);
			logo.setAlignment(Image.LEFT| Image.TEXTWRAP);
			//logo.scaleAbsoluteWidth((float)100);
			logo.scaleAbsolute(70, 30);
			Chunk imgDoc = new Chunk(logo, 0, -15);
			//Chunk logo = new Chunk(Image.getInstance(rutaImagen), 0, -15);
			//documento.add(fox);
			Font fontCab = new Font(Font.getFamily("GEORGIA"), 10, Font.BOLD);
			//Paragraph tituloDoc = new Paragraph(titulo,FontFactory.getFont("arial"));
			Chunk tituloDoc = new Chunk(titulo,fontCab);
			Phrase fenc=new Phrase();
			fenc.add(imgDoc);
			fenc.add(tituloDoc);
			Paragraph penc=new Paragraph(fenc);
			documento.add(penc);
			Paragraph pesp=new Paragraph("\n");
					documento.add(pesp);
			Paragraph ptit=new Paragraph("LISTADO DE RECURSOS DE INFORMACION",new Font(Font.getFamily("Arial"), 9, Font.BOLD));
			ptit.setAlignment(Element.ALIGN_CENTER);
			documento.add(ptit);
			documento.add(pesp);
		
			
			Font fuenteCabecera=new Font(
					FontFactory.getFont("arial",   // fuente
			                 7,                            // tama�o
			                 Font.BOLD,                   // estilo
			                 BaseColor.BLACK));	
			
			PdfPCell ccab =new PdfPCell (new Paragraph("N",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			ccab =new PdfPCell (new Paragraph("Código",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			ccab =new PdfPCell (new Paragraph("Título",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			ccab =new PdfPCell (new Paragraph("Tipo",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			ccab =new PdfPCell (new Paragraph("Medio",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			
			
			Font fuenteContenido=new Font(
					FontFactory.getFont("arial",   // fuente
			                 7,                            // tama�o
			                 Font.NORMAL,                   // estilo
			                 BaseColor.BLACK));    
			
			Font fuenteContenidoNum=new Font(
					FontFactory.getFont("arial",   // fuente
			                 5,                            // tama�o
			                 Font.NORMAL,                   // estilo
			                 BaseColor.BLACK));
			for(int i=0;i<lista.size();i++){
				PdfPCell cnum =new PdfPCell (new Paragraph(String.valueOf(i+1),
		                 fuenteContenidoNum));    
				cnum.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cnum);
				PdfPCell ccodigo =new PdfPCell (new Paragraph(lista.get(i).getCodigorecursoinformacion()==null ? "" : lista.get(i).getCodigorecursoinformacion(),
					      fuenteContenido));                  
			tabla.addCell(ccodigo);
				PdfPCell ctitulo =new PdfPCell (new Paragraph(lista.get(i).getTitulo()==null ? "" : lista.get(i).getTitulo(),
						      fuenteContenido));                  
				tabla.addCell(ctitulo);
				PdfPCell ctipo =new PdfPCell (new Paragraph(lista.get(i).getTiporecursoinformacion().getNombretipo()==null ? "" :
					lista.get(i).getTiporecursoinformacion().getNombretipo(),
					      fuenteContenido));
				ctipo.setHorizontalAlignment(Element.ALIGN_CENTER);
			    tabla.addCell(ctipo);
				PdfPCell cmedio =new PdfPCell (new Paragraph(lista.get(i).getMediorecursoinformacion().getNombretipo()==null ? "" :
					lista.get(i).getMediorecursoinformacion().getNombretipo(),
					      fuenteContenido));                  
				cmedio.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cmedio);
			    
				
				//tabla.addCell(lista.get(i).getNombreproyecto()==null ? "" : lista.get(i).getNombreproyecto());
				//tabla.addCell(lista.get(i).getFechainicioproyecto()==null ? "" : formateador.format(lista.get(i).getFechainicioproyecto()));
				//tabla.addCell(lista.get(i).getFechafinproyecto()==null ? "" : formateador.format(lista.get(i).getFechafinproyecto()));
				 
            	//tabla.addCell(vigencia);
			}
			tabla.setHeaderRows(1);
			documento.add(tabla);
			
			Font fuente=new Font(FontFactory.getFont("arial",7));
			/*Paragraph pfecha=new Paragraph("Fecha Reporte:"+String.valueOf(formateador2.format(new Date()))+"\n",fuente);
			Paragraph puser=new Paragraph("Usuario:"+user.getUsuario()+"\n",fuente);
			Paragraph p1=new Paragraph("Estado Vigencia:"+user.getUsuario()+"\n",fuente);
			documento.add(pfecha);
			documento.add(puser);
			*/
			documento.close();
			 //resultadoListaProyecto= new FileInputStream(new File(rutaArchivo));
			 //File fdel=new File(rutaArchivo);
		   		//fdel.delete();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rutaArchivo;
	  }
	   
	   
	   
	}
	
	
	
	
	


