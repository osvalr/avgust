package proyecto.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import proyecto.vo.RolModulo;
import proyecto.vo.Usuario;

public class ProyectoUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	
	public static double truncar(double nD, int nDec){

		if (nD > 0)

			nD = Math.floor(nD * Math.pow(10, nDec)) / Math.pow(10, nDec);

		else

			nD = Math.ceil(nD * Math.pow(10, nDec)) / Math.pow(10, nDec);

		return nD;

	}

	public static double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales))
				/ Math.pow(10, decimales);
	}
	
	
	public String formatoMiles(String valor){
		double val=Double.parseDouble(valor);
		DecimalFormat num=new DecimalFormat("#,###.00");
		return num.format(val);
	}
	
	
	
	public static int obtenerPrivilegioRol(Usuario usuario, int idmodulo){
		int pesorol=0;
		List<RolModulo> lista= usuario.getRol().getListaRolModulo();
		for(RolModulo rm:lista){
			if(rm.getModulo().getIdmodulo()==idmodulo){
				pesorol=rm.getPesorol();
				break;
			}
		}
		System.out.println("peso rol"+pesorol);
		pesorol=88;
		return pesorol;
	}
	
	
	
	public static long diferenciaEntreFechas(Date fecha1,Date fecha2){
		long f1=fecha1.getTime();
		long f2=fecha2.getTime();
		long dif=f1-f2;
		long dias = Math.round((dif/(1000*60*60*24)));
		return dias;
	}
	
	
	
	
	
	public static String fileToString(File file){
	    StringBuffer buffer = new StringBuffer();
	    String line;
	    FileReader fReader;
	    BufferedReader bReader;try {
	      fReader = new FileReader(file);
	      bReader = new BufferedReader(fReader);
	      while ((line = bReader.readLine()) != null){
	        buffer.append(line);
	      }
	      bReader.close();
	      fReader.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }return buffer.toString();
	  }
	
	

	public static void stringToFile(String string, File file){
	    FileWriter fWriter;
	    BufferedWriter bWriter;try {
	      fWriter = new FileWriter(file);
	      bWriter = new BufferedWriter(fWriter);
	      bWriter.write(string);
	      bWriter.close();
	      fWriter.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	public static Timestamp obtenerFechaHoraActual(){
		 java.util.Date hoy = new java.util.Date();
		 return new Timestamp(hoy.getTime());
	}	
	
	

}
