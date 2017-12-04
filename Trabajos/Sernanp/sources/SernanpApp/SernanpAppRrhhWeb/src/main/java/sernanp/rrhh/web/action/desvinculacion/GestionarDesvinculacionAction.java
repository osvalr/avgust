package sernanp.rrhh.web.action.desvinculacion;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.desvinculacion.service.GestionarDesvinculacionService;
import sernanp.app.business.dto.PersonalDesvinculacionDto;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class GestionarDesvinculacionAction extends ActionHelper{

	
	private static final long serialVersionUID = 2512069725373210463L;
	private final String INSERT = "insert";
	private final String UPDATE = "update";
	
	private String op;
	
	private static Logger log = Logger.getLogger(GestionarDesvinculacionAction.class);

	@Autowired
	GestionarDesvinculacionService gestionarDesvinculacionService;
	
	
	private PersonalDesvinculacionDto desvinculacion;
	
	private ObtenerDatosBasicosPersonalQuery obtenerDBPQuery; 
	
	private Integer srl_id_estado_personal;
	private Integer idpersonal;
	
	public String grabarDesvinculacion(){
		
		try {
			
			if(op.equals(INSERT)){
			
			 gestionarDesvinculacionService.registrarDesvinculacion(desvinculacion);
			 transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
			 transaccionUtil.setMensaje("Desvinculacion registrada con éxito.");
			 
			}else if(op.equals(UPDATE)){
			 
			 gestionarDesvinculacionService.actualizar(desvinculacion);
			 transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
			 transaccionUtil.setMensaje("Desvinculacion registrada con éxito.");	
			}
			
		} catch (BusinessException e) {
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(),e);
		}catch (Exception e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
						
			log.error(e.getMessage(),e);
		}
		
       
		return SUCCESS;
		
	}
	
	public String eliminar(){
		
		gestionarDesvinculacionService.eliminarDesvinculacion(srl_id_estado_personal, idpersonal);
		
		return SUCCESS;
	}
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		
		return transaccionUtil;
	}

	public ObtenerDatosBasicosPersonalQuery getObtenerDBPQuery() {
		return obtenerDBPQuery;
	}

	public void setObtenerDBPQuery(ObtenerDatosBasicosPersonalQuery obtenerDBPQuery) {
		this.obtenerDBPQuery = obtenerDBPQuery;
	}

	public PersonalDesvinculacionDto getDesvinculacion() {
		return desvinculacion;
	}

	public void setDesvinculacion(PersonalDesvinculacionDto desvinculacion) {
		this.desvinculacion = desvinculacion;
	}

	public Integer getSrl_id_estado_personal() {
		return srl_id_estado_personal;
	}

	public void setSrl_id_estado_personal(Integer srl_id_estado_personal) {
		this.srl_id_estado_personal = srl_id_estado_personal;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
    
	
}
