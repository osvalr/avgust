package sernanp.rrhh.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class Funciones {

	public static String implode(int[] inputArray){
		String argidP = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append(inputArray[0]);
		for (int i=1;i<inputArray.length;i++) {
		sb.append(",");
		sb.append(inputArray[i]);
		}
		
		argidP = sb.toString();
		
		return argidP;
	}
	
	public static String implodeString(String[] inputArray){
		String argidP = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append(inputArray[0]);
		for (int i=1;i<inputArray.length;i++) {
		sb.append(",");
		sb.append(inputArray[i]);
		}
		
		argidP = sb.toString();
		
		return argidP;
	}
	
	public static String implodeString(String[] inputArray, String tok){
		String argidP = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append(inputArray[0]);
		for (int i=1;i<inputArray.length;i++) {
		sb.append(tok);
		sb.append(inputArray[i]);
		}
		
		argidP = sb.toString();
		
		return argidP;
	}
	
	
	public static String implodeStringStr(String[] inputArray, String tok){
		String argidP = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append("'"+inputArray[0]+"'");
		for (int i=1;i<inputArray.length;i++) {
		sb.append(tok);
		sb.append("'"+inputArray[i]+"'");
		}
		
		argidP = sb.toString();
		
		return argidP;
	}
	
	public static String fechaHoy(){
		
		String DATE_FORMAT 		= "dd/MM/yyyy H:mm:s";
		SimpleDateFormat sdf 	= new SimpleDateFormat(DATE_FORMAT);
		Calendar c1 			= Calendar.getInstance(); // today

		String ffecha 			= sdf.format(c1.getTime());
		
		return ffecha;
	}
	
	public static String fechaHoy(String format){
		
		String DATE_FORMAT 		= format;
				
		SimpleDateFormat sdf 	= new SimpleDateFormat(DATE_FORMAT);
		        		
		Calendar c1 			= Calendar.getInstance(); // today

		String ffecha 			= sdf.format(c1.getTime());
		return ffecha;
	}

	public static String fechaSiguiente(String format){
		
		String DATE_FORMAT 		= format;
				
		SimpleDateFormat sdf 	= new SimpleDateFormat(DATE_FORMAT);
		        		
		Calendar c1 			= Calendar.getInstance(); // today
		c1.add(Calendar.DATE, 1);
		String ffecha 			= sdf.format(c1.getTime());
		
		return ffecha;
	}
	
	
	public static String fechaFormat(String format, Date fecha){
		
		String DATE_FORMAT 		= format;				
		SimpleDateFormat sdf 	= new SimpleDateFormat(DATE_FORMAT);		
		String ffecha 			= sdf.format(fecha);
		return ffecha;
	}
	
	
	/*15-08-2013   D.V.R*/
	public static java.sql.Date convertString2Sqldate(String str){ 
		SimpleDateFormat sdf = null; 
		java.util.Date dt    = null;
		java.sql.Date dte    = null;
		try{
			sdf = new SimpleDateFormat("dd-MM-yyyy"); 
			dt  = sdf.parse(str);
			dte = new java.sql.Date(dt.getTime());
		}catch(Exception e){
			e.printStackTrace();	
		}	
		return dte;
	}
	
	/*17-06-2014   D.V.R*/
	public static java.sql.Date convertString2SqldateFormat(String fecha, String format){ 
		SimpleDateFormat sdf = null; 
		java.util.Date dt    = null;
		java.sql.Date dte    = null;
		try{
			sdf = new SimpleDateFormat(format); 
			dt  = sdf.parse(fecha);
			dte = new java.sql.Date(dt.getTime());
		}catch(Exception e){
			e.printStackTrace();	
		}	
		return dte;
	}
	

	
	public static java.sql.Time ConvertString2Time(String str){ 
		SimpleDateFormat sdf = null; 
		java.sql.Time dt    = null;		
		try{
			sdf = new SimpleDateFormat("hh:mm:ss");
			dt = Time.valueOf(str);
		}catch(Exception e){
			e.printStackTrace();	
		}	
		return dt;
	}
	
	
 

    public static Date getPrimerDiaDelMes() {

    	Calendar cal 			= Calendar.getInstance();
        
        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH),

                cal.getActualMinimum(Calendar.DAY_OF_MONTH),

                cal.getMinimum(Calendar.HOUR_OF_DAY),

                cal.getMinimum(Calendar.MINUTE),

                cal.getMinimum(Calendar.SECOND));

        return cal.getTime();

    }
    
    
    //02/09/2014
    public static Date getPrimerDiaDelMesWithParameter(Date fecha) {

    	Calendar cal 			= Calendar.getInstance();
    	cal.setTime(fecha);
        
        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH),

                cal.getActualMinimum(Calendar.DAY_OF_MONTH),

                cal.getMinimum(Calendar.HOUR_OF_DAY),

                cal.getMinimum(Calendar.MINUTE),

                cal.getMinimum(Calendar.SECOND));

        return cal.getTime();

    }

 
    
    public static Date getUltimoDiaDelMes(Date firstdayofmont) {

        Calendar cal 			= Calendar.getInstance();
        
        cal.setTime(firstdayofmont);
        
        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH ),

                cal.getActualMaximum(Calendar.DAY_OF_MONTH),

                cal.getMaximum(Calendar.HOUR_OF_DAY),

                cal.getMaximum(Calendar.MINUTE),

                cal.getMaximum(Calendar.SECOND));

        return cal.getTime();

    }
    
    
    public static Date getUltimoDiaDelMes() {

        Calendar cal 			= Calendar.getInstance();//        
        
        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH ),

                cal.getActualMaximum(Calendar.DAY_OF_MONTH)/*,

                cal.getMaximum(Calendar.HOUR_OF_DAY),

                cal.getMaximum(Calendar.MINUTE),

                cal.getMaximum(Calendar.SECOND)*/);

        return cal.getTime();

    }
	
	
    
    
    public static int obtenerNroMesDescuento(){
    	
    	int	mesnumero				= 0;
    	SimpleDateFormat sdfmesdesc = new SimpleDateFormat("MM");
//		mesnumero					= Integer.parseInt(sdfmesdesc.format(sumarMesesAFecha(getPrimerDiaDelMes(), -1)));		
    	mesnumero					= Integer.parseInt(sdfmesdesc.format(getPrimerDiaDelMes())) - 1;
    	if(mesnumero == 0) mesnumero= 12;
    	
		return mesnumero;
		
    }
    
    
    public static int obtenerAnioOfDescuento(){
    	int	periododesc				= 0;
  		SimpleDateFormat sdfperdesc	= null;
    	sdfperdesc					= new SimpleDateFormat("yyyy");
  		periododesc					= Integer.parseInt(sdfperdesc.format(sumarMesesAFecha(getPrimerDiaDelMes(), -1)));
  		
  		return periododesc;
    }
    
    public static String nombreMes(int numeromes){
    	String mesLetras	= null;
    	switch (numeromes){
    	case 1 :
    		mesLetras = "Enero";
    		break;
    	case 2 :
    		mesLetras = "Febrero";
    		break;
    	case 3 :
    		mesLetras = "Marzo";
    		break;
    	case 4 :
    		mesLetras = "Abril";
    		break;
    	case 5 :
    		mesLetras = "Mayo";
    		break;
    	case 6 :
    		mesLetras = "Junio";
    		break;
    	case 7 :
    		mesLetras = "Julio";
    		break;
    	case 8 :
    		mesLetras = "Agosto";
    		break;
    	case 9 :
    		mesLetras = "Setiembre";
    		break;
    	case 10 :
    		mesLetras = "Octubre";
    		break;
    	case 11 :
    		mesLetras = "Noviembre";
    		break;
    	default :
    		mesLetras = "Diciembre";
    		break;    	
    	}
    	
    	return mesLetras;    	
    	
    }
    
    
    
    
	public static String nombredia(java.util.Date d){
		
		int dia 		= 	0;
		String nomdia	=	null;
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		
		dia = cal.get(Calendar.DAY_OF_WEEK);
		
		switch (dia){
		case 1:
			nomdia ="Domingo";
			break;
		case 2:
			nomdia = "Lunes";
			break;
		case 3:
			nomdia = "Martes";
			break;
		case 4:
			nomdia = "Miercoles";
			break;
		case 5:
			nomdia = "Jueves";
			break;
		case 6:
			nomdia = "Viernes";
			break;
		default:
			nomdia = "Sabado";
			break;
			
		}
		
		
		return nomdia;
}
	/*--------------------------------*/
	
	public static Timestamp sumaHoras(Timestamp fechaOriginal, int horas, boolean b) {
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaOriginal);		
		
		int dia = calendario.get(Calendar.DAY_OF_WEEK);
		int h = calendario.get(Calendar.HOUR_OF_DAY);
		int m = calendario.get(Calendar.MINUTE);
		int s = calendario.get(Calendar.SECOND);
		int ms = calendario.get(Calendar.MILLISECOND);
		
		if(b){
			if(dia == 1){
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.DAY_OF_MONTH, 1);
				
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.HOUR_OF_DAY, -h);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.MINUTE, -m);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.SECOND, -s);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.MILLISECOND, -ms);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.SECOND, -1);				
				
			}else if(dia == 6){
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.DAY_OF_MONTH, 2);
			}else if(dia == 7){
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.DAY_OF_MONTH, 2);
				
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.HOUR_OF_DAY, -h);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.MINUTE, -m);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.SECOND, -s);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.MILLISECOND, -ms);
				fechaOriginal = sumaTiempo(fechaOriginal, Calendar.SECOND, -1);	
			}
		}		
		
		return  sumaTiempo(fechaOriginal, Calendar.HOUR_OF_DAY, horas);		
	}
		
	
	private static Timestamp sumaTiempo(Timestamp fechaOriginal, int field, int amount) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTimeInMillis(fechaOriginal.getTime());
		calendario.add(field, amount);
		Timestamp fechaResultante = new Timestamp(calendario.getTimeInMillis());

		return fechaResultante;
		}
	
	
	public static String[] explodeString(String strDatos, String tok){
		
		StringTokenizer tokens=new StringTokenizer(strDatos, tok);
	        int nDatos=tokens.countTokens();
	        String[] datos=new String[nDatos];
	        int i=0;
	        while(tokens.hasMoreTokens()){
	            String str=tokens.nextToken();
	            datos[i]=str;		            
	            i++;
	        }
	    return datos;
	}
	
	public static String MD5(String input) {
        byte[] source;
        try {
            //Get byte according by specified coding.
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public static String FormatNum(double numero){
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		nf.setGroupingUsed(true);
		
		return nf.format(numero);
	}
	
	public static boolean in_array(Object[] haystack, String needle) {
	    for(int i=0;i<haystack.length;i++) {
	        if(haystack[i].toString().equals(needle)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static Timestamp fechaHoyTimeStamp(){
		 Date today = new java.util.Date();
		 return new java.sql.Timestamp(today.getTime());
	}
	
	public static String fechaFormatTimeStamp(String s){
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
		String strFecha = s;
		Date fecha = null;
		
		try {
			fecha = formatoDelTexto.parse(strFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fecha.toString();		
	}
	
	public static Timestamp fechaStringtoTimeStamp(String fecha){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date parsedDate=null;
		
		try {
			parsedDate = dateFormat.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Timestamp(parsedDate.getTime());
		
	}
	
	public static String formatFechaCron(Timestamp fecha){
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		
		String sCronfecha = calendario.get(calendario.SECOND) + " " + calendario.get(calendario.MINUTE) + " " + calendario.get(calendario.HOUR_OF_DAY) + " " +	
				calendario.get(calendario.DAY_OF_MONTH) + " " + ( calendario.get(calendario.MONTH) + 1 ) + " ? " + calendario.get(calendario.YEAR);
		
		return sCronfecha;
	}
	
	
	// JCEV 02-08-2012
	
		/**
		 * Permite convertir un String en fecha (Date).
		 * @param strFecha (String) la fecha a la cual deseo convertir
		 * @param strFmt   (String) formato de la Fecha
		 * @return Date la fecha en formato Date
		 */
		public static Date String2Date(String strFecha, String strFmt){
	        SimpleDateFormat formato = null;
	        Date fechaDate           = null;
	        try {
	    		fechaDate = new Date(); 
	        	if(!strFecha.equalsIgnoreCase("")){
	            	if(strFmt.equalsIgnoreCase("")){
	            		strFmt = "dd-MM-yyyy";
		        	}
		            formato   = new SimpleDateFormat(strFmt);
		            fechaDate = formato.parse(strFecha);
	        	}
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	        }
	        return fechaDate;
	    }
		
		public static Date fechaHoyDmy(String strFmt){
	        SimpleDateFormat formato = null;
	        String strFecha          = null;
	        Date fechaDate           = null;
	        try {
	    		fechaDate = new Date(); 
	        	if(strFmt.equalsIgnoreCase("")){
	        		strFmt = "dd-MM-yyyy";
	        	}
	        	
	            formato   = new SimpleDateFormat(strFmt);
	            strFecha  = formato.format(fechaDate);
	            fechaDate = formato.parse(strFecha);
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	        }
	        return fechaDate;
	    }
		
		public static int diasTranscurridosEntre(Date fechaDesde, Date fechaHasta) {
			 long diff = fechaHasta.getTime() - fechaDesde.getTime();
			 long dias = diff / (1000 * 60 * 60 * 24);
			 return (int) dias;
		}
		
		/*
			Para sumar un número de meses a una fecha podemos utilizar el siguiente método:
	 	*/
		public static Date sumarMesesAFecha(Date f, int meses) {
		  Calendar c = Calendar.getInstance();
		  c.setTime(f);
		  c.add(Calendar.MONTH, meses);  
		  return c.getTime();
		 }

		/*
			Para sumar un número de días a una fecha podemos utilizar el siguiente método:
		*/
		public static Date sumarDiasAFecha(Date f, int dias) {
		  Calendar c = Calendar.getInstance();
		  c.setTime(f);
		  c.add(Calendar.DATE, dias);  
		  return c.getTime();
		 }	
		
		// JCEV 19-07-2012
		public static Date sumaDias(Date fecha, int dias){ 
			Calendar cal = null;
			try {
				cal = Calendar.getInstance();
				cal.setTime(fecha); 
				cal.add(Calendar.DAY_OF_YEAR, dias); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cal.getTime(); 
		}

		public static Date restaDias(Date fecha, int dias){ 
			Calendar cal = null;
			try {
				cal = Calendar.getInstance();
				cal.setTime(fecha); 
				cal.add(Calendar.DAY_OF_YEAR, - dias); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cal.getTime(); 
		} 
}
