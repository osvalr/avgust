package pe.kapcom.iemail.service;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import pe.kapcom.iemail.util.AppUtil;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

public class MailService {

	private static Logger log = Logger.getLogger(MailService.class);

	private JavaMailSender  mailSender;
	private SimpleMailMessage simpleMailMessage;

	public void setMailSender(JavaMailSender  mailSender) {
		this.mailSender = mailSender;
	}	

	public void sendMail() throws Exception {

			log.info("============ INICIO ENVIO DE CORREO ============");
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(simpleMailMessage.getFrom());
//			helper.setTo(simpleMailMessage.getTo());

			helper.setTo("jrodriguez@senamhi.gob.pe");
//            helper.setTo("raffo8924@gmail.com");

//			String text = simpleMailMessage.getText();
//			text = String.format(text, customerMailQuery.getCli_razsoc(),customerMailQuery.getDoc_iden(),nombreDocumento,customerMailQuery.getNro_doc(), AppUtil.dateToString(customerMailQuery.getFec_emision()));
			helper.setText("mensaje de prueba");

//			String asunto = simpleMailMessage.getSubject();
//			asunto = String.format(asunto,nombreDocumento, customerMailQuery.getNro_doc());
			helper.setSubject("mensaje de prueba");

			log.info("============ INFORMACION INICIAL COMPLETADA ============");
//			log.info("============ ADJUNTANDO PDF ============");
			//Adjuntar PDF
			{
					FileSystemResource file = new FileSystemResource(new File("/Users/JRaffo/Downloads/doc_100100017701_100100017706.pdf"));
					helper.addAttachment(file.getFilename(), file);
			}
			log.info("============ FIN ADJUNTANDO PDF ============");

			mailSender.send(message);
			log.info("============ FIN ENVIO DE CORREO ============");

	}

	public void sendMail(String text) {
		try {

			log.info("============ INICIO ENVIO DE CORREO LOG ============");
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(simpleMailMessage.getFrom());
//			helper.setTo(username);
			helper.setText(text);
			helper.setSubject("PROCESO DE ENVIO DE CORREOS FE - LOG: "+ AppUtil.dateToString(new Date()));
			log.info("============ INFORMACION INICIAL COMPLETADA ============");
			mailSender.send(message);
			log.info("============ FIN ENVIO DE CORREO LOG ============");

		} catch (MessagingException e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
	}

	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public MailSender getMailSender() {
		return mailSender;
	}
	
	
}
