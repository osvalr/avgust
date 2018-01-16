package pe.kapcom.iemail;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.kapcom.iemail.service.MailService;

/**
 * Hello world!
 *
 */
public class App {

	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		String logProceso = "Lista de clientes involucrados en el proceso de envio de correo\n";
		String template = "Cliente: %s, Número documento: %s, Fecha de emisión: %s, Estado: %s\n";

		log.info("============ INICIANDO APLICACION ============");
		log.info("============ CARGANDO CONTEXTO SPRING ============");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		log.info("============ OBTENIENDO INSTANCIA DE MAIL SERVICE ============");
		MailService mailService = (MailService) context.getBean("mailService");

//		log.info("============ CANTIDAD DE REGISTROS PENDIENTES: " + list.size()+ " ============");

//		for (CustomerMailQuery x : list){

//			log.info("============ INICIANDO ENVIO DE CORREO PARA CLIENTE: " + x.getCli_razsoc() + " ============");

			try {
				mailService.sendMail();
//				logProceso=logProceso+String.format(template,x.getCli_razsoc(),x.getNro_doc(), AppUtil.dateToString(x.getFec_emision()),"Exitoso");
//				log.info("============ GRABANDO FLAG DE ENVIO EN BD ============");
//				service.setFlag(x.getTipdoc_id(),x.getNro_doc(),"s");
//				log.info("============ FIN DE GRABACION DEL FLAG EN BD ============");
//				log.info("============ ENVIO FINALIZADO ============");
			}catch (Exception e) {
			    e.printStackTrace();
//				logProceso=logProceso+String.format(template,x.getCli_razsoc(),x.getNro_doc(),AppUtil.dateToString(x.getFec_emision()),"Error: "+e.getMessage());
//				log.error(e.getMessage(),e);
//				log.info("============ ERROR ENVIANDO CORREO!!! ============");
			}

//		}

//		mailService.sendMail(logProceso);

		log.info("============ FIN DEL PROCESO DE ENVIO DE CORREOS ============");
	}
}
