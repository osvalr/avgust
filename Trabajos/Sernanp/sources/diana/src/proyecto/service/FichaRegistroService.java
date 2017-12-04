package proyecto.service;

import java.util.List;
import java.util.Map;

import proyecto.constants.ValueConstants;
import proyecto.dao.FichaRegistroDAO;
import proyecto.util.GestorEnvioMail;
import proyecto.vo.Areanatural;
import proyecto.vo.FichaRegistro;
import proyecto.vo.HistorialJefesAnp;
import proyecto.vo.Operadorturismo;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Tipo;

public class FichaRegistroService {

	private FichaRegistroDAO ficharegistroDAO;

	public void setFicharegistroDAO(FichaRegistroDAO ficharegistroDAO) {
		this.ficharegistroDAO = ficharegistroDAO;
	}	

	public Map guardarFicha(FichaRegistro fr){
		
		return ficharegistroDAO.guardarFicha(fr);
	}
	
	public void actualizarFicha(FichaRegistro fr){
		
		ficharegistroDAO.actualizarFicha(fr);
	}
	
	public List<FichaRegistro> listarEnviados(Areanatural an, Operadorturismo ot){
		
		return ficharegistroDAO.listarEnviados(an, ot);
	}
	
	public List<FichaRegistro> listarEnviadosxAreaNatural(Areanatural an){
		
		return ficharegistroDAO.listarEnviadosxAreaNatural(an);
	}
	
	public List<FichaRegistro> listarAprobadosxAreaNatural(Areanatural an){
		
		return ficharegistroDAO.listarAprobadosxAreaNatural(an);
	}
	
	public FichaRegistro muestraFichaFormulario(int idficharegistro){
		
		return ficharegistroDAO.muestraFicha(idficharegistro).get(0);
	}
	
	

	public boolean enviarMailConfirmacionRegistro(FichaRegistro fr, HistorialJefesAnp hja){
		try {
			
			String hostname = "mail.sernanp.gob.pe";
		    String puerto = "25";
		    String username = "desarrollo";
		    String password = "Geniu2015";
		    String remitente = "webmaster@sernanp.gob.pe";
		    int ssl= 0;
		    
		    GestorEnvioMail.setearParametrosEnvio(hostname, puerto, username, password, remitente, ssl); 
		    //redactar msg
	    	String cuerpomsg = "SU SOLICTUD DE INGRESO CON CODIGO : "+fr.getCodigoficha()+" FUE ENVIADO CORRECTAMENTE.";
		    //obtener asunto msg
	    	String asuntomsg = "CONFIRMACION DE ENVIO";
	    	
			GestorEnvioMail.enviarMail(fr.getPersonajuridica().getCorreoinstitucional(),asuntomsg,cuerpomsg);
			
			
			cuerpomsg = "SE LE INFORMA QUE SE HA REALIZADO UNA SOLICITUD DE INGRESO AL ANP";		    
	    	asuntomsg = "SOLICITUD DE INGRESO AL ANP";
	    				
			GestorEnvioMail.enviarMail(hja.getPersonal().getMailpersonal(),asuntomsg,cuerpomsg);
			
		} catch (Exception e) {			
			return false;			
			//e.printStackTrace();			
		}
    	
    	return true;
    }
	
	public boolean enviarMailDesaprobacionFicha(FichaRegistro fr, HistorialJefesAnp hja){
		try {
			
			String hostname = "mail.sernanp.gob.pe";
		    String puerto = "25";
		    String username = "desarrollo";
		    String password = "002056D";
		    String remitente = "webmaster@sernanp.gob.pe";
		    int ssl= 0;
		    
		    GestorEnvioMail.setearParametrosEnvio(hostname, puerto, username, password, remitente, ssl); 
		    //redactar msg
	    	String cuerpomsg = "SE LE COMUNICA QUE SU SOLICITUD DE INGRESO CON CODIGO : "+fr.getCodigoficha()+" FUE RECHAZADA.";
	    	cuerpomsg += "<br>"+fr.getObservacion();
		    //obtener asunto msg
	    	String asuntomsg = "SOLICITUD DE INGRESO RECHAZADA";
	    	
			GestorEnvioMail.enviarMail(fr.getPersonajuridica().getCorreoinstitucional(),asuntomsg,cuerpomsg);
			
			
	    	cuerpomsg = "SE LE INFORMA QUE LA SOLICITUD DE INGRESO CON CODIGO : "+fr.getCodigoficha()+" FUE RECHAZADA.";
	    	cuerpomsg += "<br>"+fr.getObservacion();		    
	    	asuntomsg = "SOLICITUD DE INGRESO RECHAZADA";
	    	
			GestorEnvioMail.enviarMail(hja.getPersonal().getMailpersonal(),asuntomsg,cuerpomsg);
						
			
		} catch (Exception e) {			
			return false;			
			//e.printStackTrace();			
		}
    	
    	return true;
    }	
	
	
	public boolean enviarMailConfirmacionRegistroConAdjunto(FichaRegistro fr,String adjunto, HistorialJefesAnp hja){
		try {
			
		String hostname = "mail.sernanp.gob.pe";
	    String puerto = "25";
	    String username = "desarrollo";
	    String password = "Geniu2015";
	    String remitente = "webmaster@sernanp.gob.pe";
	    int ssl= 0;
	    
	    GestorEnvioMail.setearParametrosEnvio(hostname, puerto, username, password, remitente, ssl); 
	    //redactar msg
    	String cuerpomsg = "Su solicitud de ingreso con código:"+fr.getCodigoficha()+" fue aprobado. Se adjunta Ficha para su Impresión y presentación al momento del ingreso.";
	    //obtener asunto msg
    	String asuntomsg = "Confirmación de envío";
    	
		GestorEnvioMail.enviarMail(fr.getPersonajuridica().getCorreoinstitucional(),asuntomsg,cuerpomsg,adjunto);
		
					
		cuerpomsg = "SE LE INFORMA QUE SE HA APROBADO UNA SOLICITUD DE INGRESO AL ANP CON CODIGO: "+fr.getCodigoficha();
    	asuntomsg = "APROBACION DE SOLICITUD DE INGRESO AL ANP";
    			
		GestorEnvioMail.enviarMail(hja.getPersonal().getMailpersonal(),asuntomsg,cuerpomsg,adjunto);
		} catch (Exception e) {			
			return false;			
			//e.printStackTrace();			
		}
    	
    	return true;
    }
	
	public void aprobarFichaRegistro(FichaRegistro fr){
		ficharegistroDAO.aprobarFichaRegistro(fr);
	}
	
	public void desaprobarFichaRegistro(FichaRegistro fr){
		
		ficharegistroDAO.desaprobarFichaRegistro(fr);
	}
}
