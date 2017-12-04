package sernanp.rrhh.web.action.persona;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.persona.service.GestionarPostulacionService;
import sernanp.app.business.dto.PostulanteDto;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class GestionarPostulacionAction extends ActionHelper {

	private static Logger log = Logger.getLogger(GestionarPostulacionAction.class);
	
	private static final long serialVersionUID = -759706993132837503L;

	private PostulanteDto postulante;
	private String op;
	
	@Autowired
	private GestionarPostulacionService gestionarPostulacionService;
	
	public String grabarPostulante(){

		try {
			
			if(op.equals("insert")){
				gestionarPostulacionService.registrarPostulacion(postulante);
				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Postulante registrado con éxito.");
			}else if(op.equals("update")) {
				gestionarPostulacionService.actualizarPostulacion(postulante);
				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Postulante actualizado con éxito.");
			}		
			
		}catch (BusinessException e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(),e);
			
		} catch (Exception e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
			
			log.error(e.getMessage(),e);
			
		}
		

		return SUCCESS;
	}
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		return transaccionUtil;
	}

	public PostulanteDto getPostulante() {
		return postulante;
	}

	public void setPostulante(PostulanteDto postulante) {
		this.postulante = postulante;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

}
