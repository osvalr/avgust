package pe.kapcom.iemail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import pe.kapcom.iemail.repository.dto.CustomerMailQuery;
import pe.kapcom.iemail.util.AppUtil;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class MailService {

	private static Logger log = Logger.getLogger(MailService.class);

	private JavaMailSender  mailSender;
	private SimpleMailMessage simpleMailMessage;

	@Value("${url.generate.pdff}")
	private String pdff;

	@Value("${url.generate.pdfb}")
	private String pdfb;

	@Value("${url.generate.pdfnc}")
	private String pdfnc;

	@Value("${url.generate.pdfnb}")
	private String pdfnb;

	@Value("${username}")
	private String username;

	@Value("${ftp.user}")
	private String ftpUser;

	@Value("${ftp.password}")
	private String ftpPassword;

	public void setMailSender(JavaMailSender  mailSender) {
		this.mailSender = mailSender;
	}	

	public void sendMail(CustomerMailQuery customerMailQuery) throws Exception {

			log.info("============ INICIO ENVIO DE CORREO ============");
			MimeMessage message = mailSender.createMimeMessage();
			String urlPdf = null;
			String nombreDocumento = null;
			if(customerMailQuery.getTip().equals("F")){
				urlPdf = pdff;
				nombreDocumento="Factura";
			}else if(customerMailQuery.getTip().equals("B")){
				urlPdf = pdfb;
				nombreDocumento="Boleta";
			}
			String temp = System.getProperty("java.io.tmpdir");

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(simpleMailMessage.getFrom());
//			helper.setTo(simpleMailMessage.getTo());
			if(customerMailQuery.getMail() == null || customerMailQuery.getMail().trim().equals("")){
				throw new Exception("No tiene correo disponible");
			}
			helper.setTo(customerMailQuery.getMail());

			String text = simpleMailMessage.getText();
			text = String.format(text, customerMailQuery.getCli_razsoc(),customerMailQuery.getDoc_iden(),nombreDocumento,customerMailQuery.getNro_doc(), AppUtil.dateToString(customerMailQuery.getFec_emision()));
			helper.setText(text);

			String asunto = simpleMailMessage.getSubject();
			asunto = String.format(asunto,nombreDocumento, customerMailQuery.getNro_doc());
			helper.setSubject(asunto);

			log.info("============ INFORMACION INICIAL COMPLETADA ============");
			log.info("============ ADJUNTANDO PDF ============");
			//Adjuntar PDF
			{
				URL url = null;
					url = new URL(urlPdf+customerMailQuery.getTip()+customerMailQuery.getVcab_nrodoc());
					InputStream in = url.openStream();
					Files.copy(in, Paths.get(temp + "/"+customerMailQuery.getNro_doc()+".pdf"), StandardCopyOption.REPLACE_EXISTING);
					in.close();
					FileSystemResource file = new FileSystemResource(new File(temp + "/"+customerMailQuery.getNro_doc()+".pdf"));
					helper.addAttachment(file.getFilename(), file);
			}
			log.info("============ FIN ADJUNTANDO PDF ============");

			log.info("============ ADJUNTANDO FICHERO ZIP ============");
			//Adjuntar Fichero XML
			{
				URL url = null;
					String ftpPath = customerMailQuery.getRuta().replace("ftp://","ftp://"+ftpUser+":"+ftpPassword+"@");
					url = new URL(ftpPath);
					InputStream in = url.openStream();
					Files.copy(in, Paths.get(temp + "/"+customerMailQuery.getNro_doc()+".zip"), StandardCopyOption.REPLACE_EXISTING);
					in.close();
					FileSystemResource file = new FileSystemResource(new File(temp + "/"+customerMailQuery.getNro_doc()+".zip"));
					helper.addAttachment(file.getFilename(), file);
			}

			log.info("============ FIN ADJUNTANDO FICHERO ZIP ============");
			mailSender.send(message);
			log.info("============ FIN ENVIO DE CORREO ============");

	}

	public void sendMail(String text) {
		try {

			log.info("============ INICIO ENVIO DE CORREO LOG ============");
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(simpleMailMessage.getFrom());
			helper.setTo(username);
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
