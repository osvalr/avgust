package sernanp.rrhh.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalAsistenciaTurnoVO;
import sernanp.rrhh.vo.PersonalContratoVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.Personanatural;
import sernanp.rrhh.vo.Tipo;



public class ProcesarDatosHoja extends ManipularLibros {

	
	public List<PersonalVO> cargarDatosExcel(String strArchivoIn, int intIndice) throws FileNotFoundException,IOException, FormatoUsuariosException {

        Iterator<Row> row 				 = tomarRegistros(strArchivoIn, intIndice);                  
        Personanatural  pn 				 = null;
        PersonalVO		ps				 = null;
        PersonalContratoVO pc			 = null;
        
        //List<Personanatural> listapn 	 = new ArrayList<Personanatural>();
        
        List<PersonalVO> listaps		 = new ArrayList<PersonalVO>();
        
        List<PersonalContratoVO> listapc = null;
        row.next();

	        while (row.hasNext()) {
//	        for (int nr=1;nr<=nrowsExcel;nr++) {
	            XSSFRow r = (XSSFRow) row.next();
	            Iterator<Cell> celda = r.cellIterator();
	            ps = new PersonalVO();	            
	            pn = new Personanatural();
	            pc = new PersonalContratoVO();	
	            
	            while (celda.hasNext()) {
	              
	              XSSFCell cel = (XSSFCell) celda.next();
	              
	              if (cel.getColumnIndex() == 0) {//tipodoc
	                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	                    if (cel.getCellType() != 3 ) {
	                    	Tipo td = new Tipo(1);//idtabla = 1
	                    	if (cel.toString().trim().length()>0){	                    	
//		                    	char tde 	= cel.toString().charAt(0);
		                    	String tde1 = Character.toString(cel.getStringCellValue().charAt(0)).toUpperCase();
		                    	if(tde1.length()>0){
		                    		if(tde1.equals("D")){
		                    			td.setIdtipo(1);
		                    		}else if (tde1.equals("C")){
		                    			td.setIdtipo(2);                    			
		                    		}else if(tde1.equals("P")){
		                    			td.setIdtipo(9);
		                    		}
		                    	}
	                    	}	                    	
	                    	pn.setTipodocumento(td);
	                    } else {                    	
	                        establecerException(cel);
	                    }
	                }
	                
	                if (cel.getColumnIndex() == 1) {//numerodoc
	                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	                    if (cel.getCellType() != 3) {
	                    	if(cel.getStringCellValue().trim().length() < 8 && cel.getStringCellValue().trim().length() > 0 ){
	                    		pn.setNumerodocumento(String.format("%08d",Integer.parseInt(cel.getStringCellValue().trim())));
	                    	}else{
	                    		pn.setNumerodocumento(cel.getStringCellValue().trim());	
	                    	}
	                    	
	                    } else {
	                        establecerException(cel);
	                    }
	                }
	                
	                if (cel.getColumnIndex() == 2) {//apepat
	                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	                    if (cel.getCellType() != 3) {
	                    	if (!cel.toString().isEmpty() || cel.toString().equalsIgnoreCase(null)){
	                    		pn.setApepat(cel.getStringCellValue().trim().toUpperCase());
	                    	}
	                    } else {
	                        establecerException(cel);
	                    }
	                }
	
	                if (cel.getColumnIndex() == 3) {//apemat
	                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	                    if (cel.getCellType() != 3 ) {
	                    	if (!cel.toString().isEmpty() || cel.toString().equalsIgnoreCase(null)){
	                    		pn.setApemat(cel.getStringCellValue().trim().toUpperCase());
	                    	}
	                    } else {                    	
	                        establecerException(cel);
	                    }
	                }
	                 
	                if (cel.getColumnIndex() == 4) {//nombre
	                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	                    if (cel.getCellType() != 3) {
	                    	if (!cel.toString().isEmpty() || cel.toString().equalsIgnoreCase(null)){
	                    		pn.setNombre(cel.getStringCellValue().trim().toUpperCase());
	                    	}
	                    } else {
	                        establecerException(cel);
	                    }
	                }
	                
	               if (cel.getColumnIndex() == 5) {//direccion            	   
	               		cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	               		if (cel.getCellType() != 3) {
	               			if (!cel.toString().isEmpty() || cel.toString().equalsIgnoreCase(null)){
	               				pn.setDireccion(cel.getStringCellValue().trim().toUpperCase());
	                    	}
	               		} else {
	               			establecerException(cel);
	               		}
	               }
	               
	              if (cel.getColumnIndex() 	== 8) {//fechanacimiento,
	            	  cel.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
	            	  
	                  if (cel.getCellType() != 3) {
	                	  java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
	                	  String fecha = sdf.format(cel.getDateCellValue());
	                	  pn.setFechanacimiento(Funciones.convertString2Sqldate(fecha));
	                  } else {
//	                      establecerException(cel);
	                  }
	              }            
	
	              if (cel.getColumnIndex() == 9) {//ruc            	   
	                 cel.setCellType(XSSFCell.CELL_TYPE_STRING);	                 
	                  if (cel.getCellType() != 3) {
	                	  if (!cel.toString().isEmpty() || cel.toString().equalsIgnoreCase(null)){	                		  
	                		  String ruc = cel.getStringCellValue().trim();
	                		  if (ruc.length() == 11){
	                			  pn.setRuc(ruc);
	                		  }
	                	  }
	                  } else {
	                      establecerException(cel);
	                  }
	              }  
	              
	              if (cel.getColumnIndex() == 13) {//estado en tabla Personal
		                 cel.setCellType(XSSFCell.CELL_TYPE_STRING);	                 
		                  if (cel.getCellType() != 3) {
		                	  if (!cel.toString().isEmpty() || cel.toString().equalsIgnoreCase(null)){
	                			  PersonalAsistenciaTurnoVO pt = new PersonalAsistenciaTurnoVO();
	                			  pt.setSrl_id_asis_turno(2);
	                			  ps.setTurno(pt);
		                		  if (cel.getStringCellValue().toUpperCase().trim().equalsIgnoreCase("ACTIVO")){
		                			  ps.setEstado(0);
		                		  }else{
		                			  ps.setEstado(1);		                			  
		                		  }
		                	  }
		                  } else {
		                      establecerException(cel);
		                  }
		           }
	              
	              
	              if (cel.getColumnIndex() == 15) {//dte_fec_inicio en tabla t_personal_contrato            	   
	             	  cel.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
	                  if (cel.getCellType() != 3) {
	                	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	                	  String fecha = sdf.format(cel.getDateCellValue());
	                	  pc.setDte_fec_inicio(Funciones.convertString2Sqldate(fecha));
	                  } else {
//	                      establecerException(cel);
	                  }
	              }      
	              
	              
	              if (cel.getColumnIndex() == 26) {//Ubicacion del Trabajador
	                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
	                    if (cel.getCellType() != 3 ) {
	                    	 if (cel.getStringCellValue().toUpperCase().trim().equalsIgnoreCase("SEDE CENTRAL")){
	                			  ps.setInt_flag(0);//Pertenece a la Sede Central
	                		  }else{
	                			  ps.setInt_flag(1);//Pertenece a una ANP		                			  
	                		  }
	                    } else {                    	
	                        establecerException(cel);
	                    }
	               }
	              
	              if (cel.getColumnIndex() == 27) {//num_sueldo en tabla t_personal_contrato
	                 cel.setCellType(XSSFCell.CELL_TYPE_NUMERIC);	  
               		  pc.setNum_sueldo(cel.getNumericCellValue());
	              }
	              
	              	              
	           }	            

	            ps.setPersonanatural(pn);
	            
	            listapc = new ArrayList<PersonalContratoVO>();	            
	            listapc.add(pc);
	            
	            ps.setListapersonalcontrato(listapc);
	            
	            listaps.add(ps);	            
	            
	        }        
        return listaps;
	}
	
	
	public List<PersonalMarcacionVO> cargarMarcacionesANPsExcel(String strArchivoIn) throws FileNotFoundException,IOException, FormatoUsuariosException {
		
        PersonalMarcacionVO pm								= null;
        Personanatural pn									= null;
        PersonalVO ps										= null;
        String numerodoc									= null;        
		Date date 											= null;
		SimpleDateFormat formatTime 						= new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formatYearOnly 					= new SimpleDateFormat("yyyy");		  
		String getanio 										= null;
		java.sql.Date fechaMarcacion						= null;
//		Integer hojaReading							= 0;
		Map<Integer, java.sql.Date> listafechasDiasExcel 	= null;        
        List<PersonalMarcacionVO> listaMarcacionesP			= new ArrayList<PersonalMarcacionVO>();

        //Obtener el numero de hojas de un archivo excel
        Integer nroHojas = Obtenernrohojas(strArchivoIn);
//        System.out.println("nroHojas que tiene el excel --> " + nroHojas);
        
//      SE RESTA 3; PORQUE SE TOMA EN CUENTA LA PRIMERA HOJA (INSTRUCCIONES), Y LAS 2 ULTIMAS (EJEMPLO y RESUMEN)  
        nroHojas  = nroHojas - 3;
        System.out.println("nroHojas del excel que el sistema leera --> " + nroHojas);
        

//		OBTENER FECHA LA PRIMERA HOJA  - PRIMER DÍA DEL MES
        listafechasDiasExcel 	= new HashMap<Integer, java.sql.Date>();
        Integer rowx 			= 0;

        for (int hoja = 1; hoja <=  1; hoja++){
        	
        	
        	if (hoja >= 1){    			
    			Iterator<Row> row1 	= tomarRegistros(strArchivoIn, hoja);   			
    	        row1.next();  

//    	        System.out.println("Leyendo hoja N° --> " + hoja);
    	        
    		        while (row1.hasNext()) {
    		            XSSFRow r 				= (XSSFRow) row1.next();

    		            if(r.getRowNum() > 1) break;
    		            
    		            Iterator<Cell> celda 	= r.cellIterator();			            
    		            numerodoc				= "";
    		            rowx 					= r.getRowNum();
//    		            colx = 0;
    		            while (celda.hasNext()) {			              
    		              XSSFCell cel 	= (XSSFCell) celda.next();
    		              
    		              if(cel.getColumnIndex() > 2) break;
    		              
//    		              System.out.println("Hoja --> " +hoja +", Fila --> "+ r.getRowNum() + ", Columna --> " + cel.getColumnIndex());
    		              
    		              	//numerodoc
    		                if (cel.getColumnIndex() == 0) {
    		                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
    		                	if(!cel.toString().isEmpty()){
    			                    if (cel.getCellType() != 3) {
    			                    	if(cel.getStringCellValue().trim().length() < 8 && cel.getStringCellValue().trim().length() > 0 ){
    			                    		try {
    			                    			numerodoc = String.format("%08d",Integer.parseInt(cel.getStringCellValue().trim()));
											} catch (Exception e) {
    		    				            	listaMarcacionesP.clear();	
    		    				            	pm = new PersonalMarcacionVO();
    		    				            	pm.setVal_temp(hoja);
    		    				            	pm.setVar_descripcion(	"En la fila " + (rowx + 1) + " y columna DNI de la hoja (" + hoja + ") éxiste valores incorrectos.");
    		    				            	listaMarcacionesP.add(pm);
    		    				            	return listaMarcacionesP;
											}


    			                    	}else{
    			                    		numerodoc = cel.getStringCellValue().trim();
    			                    	}    			                    	
    			                    } else {
    			                        establecerException(cel);
    			                    }
    		                	}
    		                }
    		              
		                	//Columna Nombres y Apellidos
				              if (cel.getColumnIndex() == 1) {//Nombre Completo
				                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
				                    if (cel.getCellType() != 3 ) {
				                    	pn = new Personanatural();
				                    	pn.setNombre(cel.getStringCellValue());
				                    } else {                    	
				                        establecerException(cel);
				                    }
				                }    
				              
    		                
    		               //----------------- LEER LAS OTRAS CELDAS SIEMPRE  QUE EXISTA NUMERO DE DOCUMENTO OBTENIDO ANTERIORMENTE ----------------

    		                if(!numerodoc.equals("")){    		                	
				              if (cel.getColumnIndex() 	== 2) {
				            	  if(!cel.toString().isEmpty()){
    				            	  cel.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
    				                  if (cel.getCellType() != 3 ) {   
    				                	  
				                		  date = cel.getDateCellValue();
				                		  getanio = formatYearOnly.format(date);
				                		  
				                		  if(getanio.equals("1900")){
				                			  
				                			  listaMarcacionesP.clear();
				                			  pm = new PersonalMarcacionVO();
				                			  pm.setVal_temp(hoja);
				                			  pm.setVar_descripcion(	"Personal: " + pn.getNombre().toUpperCase() + " con FECHA  de asistencia invalidad, en la fila " + (rowx + 1) + " de la hoja (" + hoja + ").");
				                			  listaMarcacionesP.add(pm);
				                			  return listaMarcacionesP;
				                		  }else{
	    				                	  java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
	    				                	  String fecha = sdf.format(cel.getDateCellValue());
	    				                	  fechaMarcacion = Funciones.convertString2Sqldate(fecha);				                				  
				                		  }

//    				                	  System.out.println("fecha --> " +fecha);
    				                	  if(!listafechasDiasExcel.containsValue(fechaMarcacion)){
//    				                		  listafechasDiasExcel.put(hoja, fechaMarcacion);
    				                		  numerodoc = "";
    				                		  //Termina el bucle (while) de lectura de las celdas
    				                		  break;
    				                	  }
    				                	  
    				                  } else {
    				                      establecerException(cel);
    				                  }    				            		  
				            	  }else{
	    				            	listaMarcacionesP.clear();	
	    				            	pm = new PersonalMarcacionVO();
	    				            	pm.setVal_temp(hoja);
	    				            	pm.setVar_descripcion(	"En la fila " + (rowx + 1) + " de la columna FECHA de la hoja (" + hoja + ") es obligatorio.");
	    				            	listaMarcacionesP.add(pm);
	    				            	return listaMarcacionesP;
				            	  }
				              }
    		                }else{
    		                	break;
    		                }
    		           }

    		            //Termina el bucle (while) de lectura de las filas
    		            if(listafechasDiasExcel.containsValue(fechaMarcacion))  break;
    		            
    		        }   
    			}
        }       

//		FIN  OBTENCIÓN FECHA DE HOJA INICIAL
        
        
//      CREAMOS LISTA DE FECHAS QUE DEBERÍA TENER EL EXCEL, 
//		PARA VALIDAR QUE NO TENGAN FECHAS DISTINTAS AL MES BASANDONOS EN LA FECHA DE LA PRIMERA FILA y HOJA 
        
        for (int hoja = 1; hoja <=  nroHojas; hoja++){	
        	
        	java.util.Date javaDate = null;

//            javaDate = new Date(fechaMarcacion.getTime());
            javaDate = Funciones.sumarDiasAFecha(new Date(fechaMarcacion.getTime()), (hoja - 1));
            
    		java.text.SimpleDateFormat sdf 	= new java.text.SimpleDateFormat("dd-MM-yyyy");    		
    		
    		String fecha 					= sdf.format(javaDate);
    		
    		listafechasDiasExcel.put(hoja, Funciones.convertString2Sqldate(fecha));
        	
        }

        

		for (int hoja = 1; hoja <=  nroHojas ; hoja++){			
	        
			Iterator<Row> row 	= tomarRegistros(strArchivoIn, hoja);	
			
//			System.out.println("Leyendo hoja N° --> " + hoja);
			
	        row.next();
	
		        while (row.hasNext()) {
		            XSSFRow r 				= (XSSFRow) row.next();
		            rowx					= r.getRowNum();
		            Iterator<Cell> celda 	= r.cellIterator();		            
		            pm						= new PersonalMarcacionVO();
		            pn						= new Personanatural();
		            ps  					= new PersonalVO();
		            numerodoc				= "";		            
		            
		            while (celda.hasNext()) {
		              
		              XSSFCell cel 	= (XSSFCell) celda.next();
		              
		              if(cel.getColumnIndex() > 7 ) break;
		              
		                if (cel.getColumnIndex() == 0) {//numerodoc
		                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);

		                	if(!cel.toString().isEmpty()){
			                    if (cel.getCellType() != 3) {
			                    	if(cel.getStringCellValue().trim().length() < 8 && cel.getStringCellValue().trim().length() > 0 ){
			                    		
			                    		try {
			                    			pn.setNumerodocumento(String.format("%08d",Integer.parseInt(cel.getStringCellValue().trim())));
				                    		numerodoc = String.format("%08d",Integer.parseInt(cel.getStringCellValue().trim()));
										} catch (Exception e) {
		    				            	listaMarcacionesP.clear();	
		    				            	pm = new PersonalMarcacionVO();
		    				            	pm.setVal_temp(hoja);
		    				            	pm.setVar_descripcion(	"En la fila " + (rowx + 1) + " y columna DNI de la hoja (" + hoja + ") éxiste valores incorrectos.");
		    				            	listaMarcacionesP.add(pm);
		    				            	return listaMarcacionesP;
										}
			                    		
			                    		
			                    	}else{
			                    		pn.setNumerodocumento(cel.getStringCellValue().trim());
			                    		numerodoc = cel.getStringCellValue().trim();
			                    	}
			                    	
			                    }
		                	}else {
		                		numerodoc	= "";		                		
		                	}
		                }
		              
		               /*----------------- LEER LAS OTRAS CELDAS SIEMPRE  QUE EXISTA NUMERO DE DOCUMENTO OBTENIDO ANTERIORMENTE ----------------*/

//		                if (pn.getNumerodocumento() != null){
//		                if(!numerodoc.equals("")){		                	
		                	
		                	//Columna Nombres y Apellidos
				              if (cel.getColumnIndex() == 1) {//Nombre Completo
				                	cel.setCellType(XSSFCell.CELL_TYPE_STRING);
				                    if (cel.getCellType() != 3 ) {
				                    	pn.setNombre(cel.getStringCellValue());
				                    } else {                    	
				                        establecerException(cel);
				                    }
				                }    
				              
//				              System.out.println(pn.getNombre());
				            //Columna Fecha
				              if (cel.getColumnIndex() 	== 2) {
				            	  
				            	  if(!cel.toString().isEmpty()){
					            	  cel.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					                  if (cel.getCellType() != 3) {					                	  
					                	  
				                		  date = cel.getDateCellValue();
				                		  getanio = formatYearOnly.format(date);
				                		  
				                		  if(getanio.equals("1900")){
				                			  
				                			  listaMarcacionesP.clear();
				                			  pm.setVal_temp(hoja);
				                			  pm.setVar_descripcion(	"Personal: " + pn.getNombre().toUpperCase() + " con FECHA  de asistencia invalidad, en la fila " + (rowx + 1) + " de la hoja (" + hoja + ").");
				                			  listaMarcacionesP.add(pm);
				                			  return listaMarcacionesP;
				                			
				                		  }else{
				                			  java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
//						                	  String fecha = sdf.format(cel.getDateCellValue());
						                	  pm.setDte_fec_marc(Funciones.convertString2Sqldate(sdf.format(cel.getDateCellValue())));
				                		  }
					                	  
					                	  
					                  } else {
					                      establecerException(cel);
					                  }				            		  
				            	  }else{
	    				            	listaMarcacionesP.clear();
	    				            	pm.setVal_temp(hoja);
	    				            	pm.setVar_descripcion(	"Personal: " + pn.getNombre().toUpperCase() + " no tiene FECHA  de asistencia, en la fila " + (rowx + 1) + " de la hoja (" + hoja + ").");
	    				            	listaMarcacionesP.add(pm);
	    				            	return listaMarcacionesP;
				            	  }

				              }            
				
				              //HORA DE INGRESO
				              if (cel.getColumnIndex() == 3) {
				            	  if(cel.toString().isEmpty()){
//				            		  establecerException(cel);
				            	  }else{
					                  if (cel.getCellType() != 3) {					                	  
				                		  date = cel.getDateCellValue();
				                		  getanio = formatYearOnly.format(date);				                		  
				                		  if(getanio.equals("1899")){
				                			  pm.setHor_hor_marc(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }else{
				                			  pm.setHor_hor_marc(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }
					                  } else {
					                      establecerException(cel);
					                  }
				            	  }
				              }              
				              

				              //HORA DE SALIDA DE REFRIGERIO		              
				              if (cel.getColumnIndex() == 4) {
				            	  if(cel.toString().isEmpty()){
//				            		  establecerException(cel);
				            	  }else{
					                  if (cel.getCellType() != 3) {					                	  
				                		  date = cel.getDateCellValue();
				                		  getanio = formatYearOnly.format(date);				                		  
				                		  if(getanio.equals("1899")){
				                			  pm.setHor_hor_salida_ref(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }else{
				                			  pm.setHor_hor_salida_ref(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }	                		  
					                  	} else {
					                      establecerException(cel);
					                  	}
					              }				              
				              	}
				              
				              //HORA DE RETORNO REFRIGERIO
				              if (cel.getColumnIndex() == 5) {				            	  
				               	  if(cel.toString().isEmpty()){
//				               		establecerException(cel);
				            	  }else{
					                  if (cel.getCellType() != 3) {				                		  
				                		  date = cel.getDateCellValue();
				                		  getanio = formatYearOnly.format(date);				                		  
				                		  if(getanio.equals("1899")){
				                			  pm.setHor_hor_retorno_ref(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }else{
				                			  pm.setHor_hor_retorno_ref(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }
					                  } else {
					                      establecerException(cel);
					                  }
					              }  
				              	}
				              
				              //HORA DE SALIDA
				              if (cel.getColumnIndex() == 6) {
				            	  if(cel.toString().isEmpty()){
//				            		  establecerException(cel);
				            	  }else{
					                  if (cel.getCellType() != 3) {					                		  
					                	  date = cel.getDateCellValue();
					                	  getanio = formatYearOnly.format(date);
				                		  if(getanio.equals("1899")){
				                			  pm.setHor_hor_marc1(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }else{
				                			  pm.setHor_hor_marc1(Funciones.ConvertString2Time(formatTime.format(date)));
				                		  }		                		  
					                  	} else {
					                      establecerException(cel);
					                  }
					              }  
				              }		              
				              	  
//		                }
            
		           }	            
	
//		            if (pn.getNumerodocumento() != null){
		            if(!numerodoc.equals("") ){
		            	
//		            	System.out.println("Personal --> " + pn.getNombre() + " / Fecha --> " + pm.getDte_fec_marc());
		            	
		            	pm.setVal_temp(hoja);
		            	
		            	if(pm.getDte_fec_marc() != null){
		            		
				              
				            if(listaMarcacionesP.size() > 0 && hoja >= 1 ){
//					            if(pm.getDte_fec_marc().equals(fechaMarcacion)){
				            	if(!pm.getDte_fec_marc().equals(listafechasDiasExcel.get(hoja))){
					            	listaMarcacionesP.clear();
					            	pm.setVal_temp(hoja);
					            	pm.setVar_descripcion("En la fila " + (rowx + 1) + " de la hoja (" + hoja + "), la fecha (" + Funciones.fechaFormat("dd/MM/yyyy", pm.getDte_fec_marc())+ ") no corresponde a la hoja.");
					            	listaMarcacionesP.add(pm);
					            	return listaMarcacionesP;
					            }
				            }  
		            		
		            		
			            	if(pm.getHor_hor_marc() != null || pm.getHor_hor_salida_ref() != null || pm.getHor_hor_retorno_ref() != null || pm.getHor_hor_marc1() != null){		            		
			            		ps.setPersonanatural(pn);	
					            pm.setPersonal(ps);					            
					            listaMarcacionesP.add(pm);	
			            	}
			            	
		            	}else{
			            	listaMarcacionesP.clear();
			            	pm.setVal_temp(hoja);
			            	pm.setVar_descripcion("En la fila " + (rowx + 1) + " de la hoja (" + hoja + "), valor de FECHA es vacío.");
			            	listaMarcacionesP.add(pm);
			            	return listaMarcacionesP;	
		            	}            	
		            }else{
		            	
		            	pm.setVal_temp(hoja);
		            	
		            	if(pm.getDte_fec_marc() != null || pm.getHor_hor_marc() != null || pm.getHor_hor_salida_ref() != null || pm.getHor_hor_retorno_ref() != null || pm.getHor_hor_marc1() != null){		            	
			            	
			            	listaMarcacionesP.clear();
			            	pm.setVal_temp(hoja);
			            	pm.setVar_descripcion("En la fila " + (rowx + 1) + " de la hoja (" + hoja + "), el DNI está vacío.");
			            	listaMarcacionesP.add(pm);
			            	return listaMarcacionesP;
		            	}
		            }
		            
		        }      
		        
			}  
        return listaMarcacionesP;
	}
	
	
	
	
    public Iterator<Row> tomarRegistros(String strArchivoIn, int intIndice) throws FileNotFoundException, IOException {        
    	
    	XSSFSheet hojaxlsx 	= null;
    	HSSFSheet hojaxls  	= null;
    	Iterator<Row> rows	= null;

//    	System.out.println("Leyendo hoja N° " + intIndice);
    	
    	if (strArchivoIn.contains(".xlsx")) {
    		
    		InputStream ExcelFileToRead = new FileInputStream(strArchivoIn);
    		XSSFWorkbook  wb 	= new XSSFWorkbook(ExcelFileToRead); 
//    		XSSFWorkbook test 	= new XSSFWorkbook();     		
    		hojaxlsx			= wb.getSheetAt(intIndice);   
    		rows 				= hojaxlsx.rowIterator();		
    	} else if (strArchivoIn.contains(".xls")) {

    		cargarArchivo(strArchivoIn);
	        hojaxls 			= obtenerHoja(intIndice);
			rows	 			= hojaxls.rowIterator();
    		 
    	}

    	return rows;
    }

    
    public Integer Obtenernrohojas (String strArchivoIn ) throws FileNotFoundException, IOException {        

    	Integer nroHojas	= 0;
//    	System.out.println("Archivo --> " + strArchivoIn);
    	
    	if (strArchivoIn.contains(".xlsx")) {    		 
    		InputStream ExcelFileToRead = new FileInputStream(strArchivoIn);
//    		System.out.println("ExcelFileToRead --> " +ExcelFileToRead);
    		XSSFWorkbook  wb 	= new XSSFWorkbook(ExcelFileToRead); 
    		nroHojas			= wb.getNumberOfSheets();     		
	
    	} else if (strArchivoIn.contains(".xls")) {
    		cargarArchivo(strArchivoIn);
    		nroHojas		= obtenernrohojas();
    		 
    	}

    	return nroHojas;
    }    
    

    public void establecerException(XSSFCell cel) throws FormatoUsuariosException {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("La celda [").append(cel.getRowIndex()).append(",").append(cel.getColumnIndex());
        builder.append("] tiene un valor incorrecto[");
        builder.append(cel.toString()).append("]");
        throw new FormatoUsuariosException(builder.toString());
    }    
    
 
}
