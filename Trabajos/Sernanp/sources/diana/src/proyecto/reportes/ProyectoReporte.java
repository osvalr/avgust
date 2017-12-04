package proyecto.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
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

import proyecto.vo.Proyecto;
import proyecto.vo.Usuario;

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


public class ProyectoReporte {

	
	
	
	
	
	public String exportarExcelProyecto(List<Proyecto> lista,Map<String, Object> mapParam){
		
		String rutaArchivo="";
		Workbook wb = new HSSFWorkbook();
		Date instante=new Date();
   	 	long inst =instante.getTime();
		rutaArchivo=mapParam.get("rutaArchivo").toString()+inst+".xls";
		SimpleDateFormat formateador=(SimpleDateFormat) mapParam.get("formateador");
      	SimpleDateFormat formateador2=(SimpleDateFormat) mapParam.get("formateador2");
      	Usuario user=(Usuario) mapParam.get("user");
		String nombreImagen=mapParam.get("nombreImagen").toString(); 
		String rutaImagen=mapParam.get("rutaImagen").toString(); 
    	 
		 try {
			 
				FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
			int indrow=0;
		    CreationHelper createHelper = wb.getCreationHelper();  
		    Sheet sheet = wb.createSheet("Poyectos");  
		    
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
           Cell cellt = rowt.createCell(1);
           cellt.setCellStyle(stltitulo);
           cellt.setCellValue(mapParam.get("titulo").toString());
           
           //
           rowt = sheet.createRow((short) 3);
           cellt = rowt.createCell(1);
           stltitulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
           cellt.setCellStyle(stltitulo);
           cellt.setCellValue("Listado de Proyectos");
           
           
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
           listaCabecera.add("PROYECTO");
           listaCabecera.add("FECHA INICIO");
           listaCabecera.add("FECHA FIN");
           listaCabecera.add("VIGENCIA");
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
              	
              	Proyecto p=lista.get(i);
              
              
              	List<String> listaAtributos=new ArrayList<String>();
                  
              
              	
              	
              	//nfila
              	listaAtributos.add(String.valueOf(i+1));
              	//nombre
              	listaAtributos.add(  p.getNombreproyecto()!= null ? p.getNombreproyecto():"" );
              	//fechas
              	//listaAtributos.add(String.valueOf(p.getFechainicioproyecto())==null ? "" : formateador.format(p.getFechainicioproyecto()));
              	String fini="";
              	
              	if(p.getFechainicioproyecto()!=null){
              		fini=formateador.format(p.getFechainicioproyecto());
              	}
              	listaAtributos.add(fini); 
              	String ffin="";
              	if(p.getFechafinproyecto()!=null){
              		ffin=formateador.format(p.getFechafinproyecto());
              	}
              	listaAtributos.add(ffin);  
                String vigencia="";
              
              	if(p.getFlagVigencia()==1){
              		vigencia="Vigente";
              	} 
              	else
              		if(p.getFlagVigencia()==2){
              			vigencia="Concluido";	
                  	} 
              	listaAtributos.add(vigencia);	
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
           listaPie.add("Fecha Reporte: "+formateador2.format(new Date()));
           listaPie.add("Usuario:"+user.getUsuario());
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
	
	
	
	
	
	
	
	
	
   public String exportarPdfProyecto(List<Proyecto> lista,Map<String, Object> mapParam){
		
	   String rutaArchivo="";
		
	   
	   Date instante=new Date();
  	 	long inst =instante.getTime();
		rutaArchivo=mapParam.get("rutaArchivo").toString()+inst+".pdf";
		SimpleDateFormat formateador=(SimpleDateFormat) mapParam.get("formateador");
     	SimpleDateFormat formateador2=(SimpleDateFormat) mapParam.get("formateador2");
     	Usuario user=(Usuario) mapParam.get("user");
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
			float[] medidaCeldas = {0.15f, 2.25f, 0.40f, 0.40f,0.40f};
			documento.addTitle("Reporte de Proyectos");

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
			Paragraph ptit=new Paragraph("LISTADO DE PROYECTOS",new Font(Font.getFamily("Arial"), 9, Font.BOLD));
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
			ccab =new PdfPCell (new Paragraph("Proyecto",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			ccab =new PdfPCell (new Paragraph("Fecha Inicio",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			ccab =new PdfPCell (new Paragraph("Fecha Fin",fuenteCabecera)); 
			ccab.setHorizontalAlignment(Element.ALIGN_CENTER);
			ccab.setGrayFill(0.8f);
			tabla.addCell(ccab);
			
			ccab =new PdfPCell (new Paragraph("Vigencia",fuenteCabecera)); 
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
				PdfPCell cnombre =new PdfPCell (new Paragraph(lista.get(i).getNombreproyecto()==null ? "" : lista.get(i).getNombreproyecto(),
						      fuenteContenido));                  
				tabla.addCell(cnombre);
				PdfPCell cfini =new PdfPCell (new Paragraph(lista.get(i).getFechainicioproyecto()==null ? "" : formateador.format(lista.get(i).getFechainicioproyecto()),
		                 fuenteContenido));
				cfini.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cfini);
				PdfPCell cffin =new PdfPCell (new Paragraph(lista.get(i).getFechafinproyecto()==null ? "" : formateador.format(lista.get(i).getFechafinproyecto()),
		                fuenteContenido));    
				cffin.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cffin);
				
				String vigencia="";
                
            	if(lista.get(i).getFlagVigencia()==1){
            		vigencia="Vigente";
            	} 
            	else
            		if(lista.get(i).getFlagVigencia()==2){
            			vigencia="Concluido";	
                	}
				PdfPCell cvig =new PdfPCell (new Paragraph(vigencia,
		                fuenteContenido));    
				cvig.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cvig);
				//tabla.addCell(lista.get(i).getNombreproyecto()==null ? "" : lista.get(i).getNombreproyecto());
				//tabla.addCell(lista.get(i).getFechainicioproyecto()==null ? "" : formateador.format(lista.get(i).getFechainicioproyecto()));
				//tabla.addCell(lista.get(i).getFechafinproyecto()==null ? "" : formateador.format(lista.get(i).getFechafinproyecto()));
				 
            	//tabla.addCell(vigencia);
			}
			tabla.setHeaderRows(1);
			documento.add(tabla);
			
			Font fuente=new Font(FontFactory.getFont("arial",7));
			Paragraph pfecha=new Paragraph("Fecha Reporte:"+String.valueOf(formateador2.format(new Date()))+"\n",fuente);
			Paragraph puser=new Paragraph("Usuario:"+user.getUsuario()+"\n",fuente);
			Paragraph p1=new Paragraph("Estado Vigencia:"+user.getUsuario()+"\n",fuente);
			documento.add(pfecha);
			documento.add(puser);
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
	
	
	
	
	


