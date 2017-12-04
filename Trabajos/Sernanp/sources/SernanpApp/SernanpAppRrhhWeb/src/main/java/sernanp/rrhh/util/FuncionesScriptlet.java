package sernanp.rrhh.util;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class FuncionesScriptlet extends JRDefaultScriptlet{

	public String formatoDouble(double numero) throws JRScriptletException{
		NumberFormat nf = NumberFormat.getInstance(java.util.Locale.US);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		nf.setGroupingUsed(true);
		
		return nf.format(numero);
	}
	
	public String formatoFecha(Timestamp t, String pattern){
		
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		
		return f.format(t);
		
	}
	
}