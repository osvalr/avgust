package proyecto.util;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class GestorEnvioMail {
	
//	    private  static String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
//		private  static  String SMTP_PORT = "465";
//		private  static  String SMTP_AUTH_USER = "turismohelp@yahoo.com";
//		private  static String SMTP_AUTH_PWD = "123456789";
//		private  static String SMTP_FROM_ADDRESS = "turismohelp@yahoo.com";

		
		
		 private  static String SMTP_HOST_NAME = "";
			private  static  String SMTP_PORT = "";
			private  static  String SMTP_AUTH_USER = "";
			private  static String SMTP_AUTH_PWD = "";
			private  static String SMTP_FROM_ADDRESS = "";
			private  static int SMTP_SSL = 0;
		
			
			
			
		public static void setearParametrosEnvio(
				String hostname,String puerto,String username,String password,String remitente,int ssl){
			    SMTP_HOST_NAME=hostname;
			    SMTP_PORT=puerto;
			    SMTP_AUTH_USER=username;
			    SMTP_AUTH_PWD=password;
			    SMTP_FROM_ADDRESS=remitente;
			    SMTP_SSL=ssl;
			    
		}
		
		
	//uno
		public static void enviarMail(String email, String subject, String cuerpomsg)
			throws Exception
		{
			String[] emailList = new String[1];
			emailList[0] = email;
			enviarMail(emailList, subject, cuerpomsg);
		}

	//varios
		
		public static void enviarMail(String[] emailList, String subject, String cuerpomsg)
			throws Exception
		{
			boolean debug = true;
			 
			Properties props = new Properties();

			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);
			props.put("mail.smtp.port", SMTP_PORT );
			if(SMTP_SSL==1){
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			}
			
			//props.put("mail.debug", "true");
			//props.put("mail.smtp.socketFactory.port", "smtp.mail.yahoo.com ");
			//props.put("mail.smtp.socketFactory.fallback", "false"); 
			Authenticator auth = new SMTPAuthenticator();
			
			Session session = Session.getDefaultInstance(props, auth);
			 
			//session.setDebug(debug);
			 
			Message msg = new MimeMessage(session);
			 
			InternetAddress addressFrom = new InternetAddress(SMTP_FROM_ADDRESS);
			msg.setFrom(addressFrom);
			 
			InternetAddress[] addressTo = new InternetAddress[emailList.length];

			for (int i = 0; i < emailList.length; i++)
			{
				addressTo[i] = new InternetAddress(emailList[i]);
			}
			
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			msg.setContent(cuerpomsg,"text/html");
			msg.setSubject(subject);
			//msg.setContent(text, "text/plain");

			Transport.send(msg);		
			
		}
		
		
		//uno con adjunto
				public static void enviarMail(String email, String subject, String cuerpomsg, String adjunto)
					throws Exception
				{
					String[] emailList = new String[1];
					emailList[0] = email;
					enviarMailConAdjunto(emailList, subject, cuerpomsg, adjunto);
				}
		
		//Con adjunto
		public static void enviarMailConAdjunto(String[] emailList, String subject, String cuerpomsg, String adjunto)
				throws Exception
			{
				boolean debug = true;
				 
				Properties props = new Properties();

				props.put("mail.smtp.host", SMTP_HOST_NAME);
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.user", SMTP_AUTH_USER);
				props.put("mail.smtp.password", SMTP_AUTH_PWD);
				props.put("mail.smtp.port", SMTP_PORT );
				if(SMTP_SSL==1){
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				}
				
				//props.put("mail.debug", "true");
				//props.put("mail.smtp.socketFactory.port", "smtp.mail.yahoo.com ");
				//props.put("mail.smtp.socketFactory.fallback", "false"); 
				Authenticator auth = new SMTPAuthenticator();
				
				Session session = Session.getDefaultInstance(props, auth);
				 
				//session.setDebug(debug);
								
				Message msg = new MimeMessage(session);
				 
				InternetAddress addressFrom = new InternetAddress(SMTP_FROM_ADDRESS);
				msg.setFrom(addressFrom);
				 
				InternetAddress[] addressTo = new InternetAddress[emailList.length];

				for (int i = 0; i < emailList.length; i++)
				{
					addressTo[i] = new InternetAddress(emailList[i]);
				}
				
				msg.setRecipients(Message.RecipientType.TO, addressTo);
				//msg.setContent(cuerpomsg,"text/html");
				msg.setSubject(subject);
				//msg.setContent(text, "text/plain");
								
				//Se seteo el mensaje del e-mail
			      MimeBodyPart messageBodyPart = new MimeBodyPart();			        
			      messageBodyPart.setContent(cuerpomsg,"text/html");
			            
			      Multipart multipart = new MimeMultipart();
			      multipart.addBodyPart(messageBodyPart);
			      
			      			      
			      //Se adjuntan los archivos al correo
			      if( adjunto!=null ){
			    	  
			    	  String rutaAdjunto = adjunto;
			    	  
			             messageBodyPart = new MimeBodyPart();
			             File f = new File(rutaAdjunto);
			             if( f.exists() ){
			                DataSource source = new FileDataSource( rutaAdjunto );
			                messageBodyPart.setDataHandler( new DataHandler(source) );
			                messageBodyPart.setFileName( f.getName() );
			                multipart.addBodyPart(messageBodyPart);
			             }
			         
			      }
			      
			      //Se junta el mensaje y los archivos adjuntos
			      msg.setContent(multipart);
				
				Transport.send(msg);		
				
			}
	 
		private static class SMTPAuthenticator extends javax.mail.Authenticator
		{
			public PasswordAuthentication getPasswordAuthentication()
			{
				String username = SMTP_AUTH_USER;
				String password = SMTP_AUTH_PWD;
				return new PasswordAuthentication(username, password);
			}
		}
	

}
