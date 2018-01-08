package pe.com.acme.inavi.business.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InaviBusinessUtil {
	public static double round(double numero, int places) {
		
//		long iPart = (long) numero;
//		double fPart = numero - iPart;
//		
//		fPart = Math.round(fPart*Math.pow(10,4))/Math.pow(10,4);
//		fPart = Math.round(fPart*Math.pow(10,2))/Math.pow(10,2);
//		
//		return iPart + fPart;
				
		BigDecimal amount = new BigDecimal(numero);
		amount = amount.setScale(places, RoundingMode.HALF_UP);
		numero = amount.doubleValue();
		
		return numero;
		
	}
}
