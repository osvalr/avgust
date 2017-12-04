package sernanp.rrhh.web.action.seleccion;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.seleccion.service.GrabarEstadoPostulacionService;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class GrabarEstadoPostulacionAction extends ActionHelperExtjs {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GrabarEstadoPostulacionService grabarEstadoPostulacionService;
	
	public String grabarEstado(){
		
		try{
			
			Integer srl_id_postulante_conv_area_org = this.getIntegerParameter("srl_id_postulante_conv_area_org");
			Integer int_orden_merito = this.getIntegerParameter("int_orden_merito");
			Integer int_id_estado = this.getIntegerParameter("int_id_estado");
			
			grabarEstadoPostulacionService.grabarEstado(srl_id_postulante_conv_area_org, int_orden_merito, int_id_estado);
			
			this.success(null, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String seleccionarGanadores(){
		
		try{
			
			Integer srl_id_conv_area_org = this.getIntegerParameter("srl_id_conv_area_org");
			System.out.println("seleccionarGanadores - srl_id_conv_area_org --> " + srl_id_conv_area_org);
			grabarEstadoPostulacionService.seleccionarGanadores(srl_id_conv_area_org);
			this.success(null, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}

}
