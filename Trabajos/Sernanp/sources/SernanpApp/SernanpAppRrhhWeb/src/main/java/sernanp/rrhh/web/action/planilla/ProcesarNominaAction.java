package sernanp.rrhh.web.action.planilla;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ProcesoNominaService;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ProcesarNominaAction extends ActionHelperExtjs {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProcesoNominaService procesoNominaService;
		
	public String procesarNomina(){
		try {
			Integer srl_id_anio_periodo_planilla = this.getIntegerParameter("srl_id_anio_periodo_planilla");
			Integer srl_id_regimen_contractual = this.getIntegerParameter("srl_id_regimen_contractual");
			Integer idpersonal = this.getIntegerParameter("idpersonal");
			Integer int_id_estado = this.getIntegerParameter("int_id_estado");
			procesoNominaService.procesarNomina(srl_id_anio_periodo_planilla,srl_id_regimen_contractual,idpersonal,int_id_estado);
			this.success();
		} catch (BusinessException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String procesarNominaAlterno(){
		try {
			Integer srl_id_anio_periodo_planilla = this.getIntegerParameter("srl_id_anio_periodo_planilla");
			Integer idpersonal = this.getIntegerParameter("idpersonal");
			procesoNominaService.procesarNominaPersonalAlterno(srl_id_anio_periodo_planilla,idpersonal);
			this.success();
		} catch (BusinessException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String procesarNominaPersonal(){
		try {
			Integer srl_id_anio_periodo_planilla = this.getIntegerParameter("srl_id_anio_periodo_planilla");
			Integer idpersonal = this.getIntegerParameter("idpersonal");
			Integer int_id_estado = this.getIntegerParameter("int_id_estado");
			procesoNominaService.procesarNominaPersonal(srl_id_anio_periodo_planilla,idpersonal,int_id_estado);
			this.success();
		} catch (BusinessException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String procesarDecuentosDeplazamientoAsistencia(){
		try {
			Integer srl_id_anio_periodo_planilla = this.getIntegerParameter("srl_id_anio_periodo_planilla");
			Integer srl_id_regimen_contractual = this.getIntegerParameter("srl_id_regimen_contractual");
			Integer idpersonal = this.getIntegerParameter("idpersonal");
			procesoNominaService.procesarMarcaciones(srl_id_anio_periodo_planilla,srl_id_regimen_contractual,idpersonal);
			this.success();
		} catch (BusinessException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			this.exception(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return this.extjsReturn;
	}
	
}
