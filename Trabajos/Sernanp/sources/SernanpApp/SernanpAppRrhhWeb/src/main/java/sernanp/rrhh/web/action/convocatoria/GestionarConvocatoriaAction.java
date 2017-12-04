package sernanp.rrhh.web.action.convocatoria;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.convocatoria.service.GestionarConvocatoriaService;
import sernanp.app.business.dto.ResultRegistroConvocatoriaDto;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class GestionarConvocatoriaAction extends ActionHelper {

	private static final long serialVersionUID = -7690064688798928870L;

	private Integer idConvocatoria;
	private Integer idArea;
	private String codigoPostulacion;
	private ResultRegistroConvocatoriaDto resultDto;
	private Integer idConvocatoriaAreaOrganica;
	private Integer cantidadVacantes;
	private Integer idUnidadOperativa;
	
	@Autowired
	GestionarConvocatoriaService gestionarConvocatoriaService;
	
	public String registrarConvocatoriaConCodPostulacion(){
		try {
			resultDto = gestionarConvocatoriaService.registrarConvocatoriaConCodPostulacion(idArea,idUnidadOperativa, codigoPostulacion,cantidadVacantes);
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
		} catch (BusinessException e) {
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.getMensajes().put(e.getCodError(), e.getMsjError());
		}
		return SUCCESS;
	}
	
	public String registrarCodigoPostulacion(){
		
		try {
			idConvocatoriaAreaOrganica = gestionarConvocatoriaService.registrarCodigoPostulacion(idConvocatoria, idArea,idUnidadOperativa, codigoPostulacion,cantidadVacantes);
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
		} catch (BusinessException e) {
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.getMensajes().put(e.getCodError(), e.getMsjError());
		}
		
		return SUCCESS;
	}
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		return transaccionUtil;
	}

	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}

	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getCodigoPostulacion() {
		return codigoPostulacion;
	}

	public void setCodigoPostulacion(String codigoPostulacion) {
		this.codigoPostulacion = codigoPostulacion;
	}

	public ResultRegistroConvocatoriaDto getResultDto() {
		return resultDto;
	}

	public void setResultDto(ResultRegistroConvocatoriaDto resultDto) {
		this.resultDto = resultDto;
	}

	public Integer getIdConvocatoriaAreaOrganica() {
		return idConvocatoriaAreaOrganica;
	}

	public void setIdConvocatoriaAreaOrganica(Integer idConvocatoriaAreaOrganica) {
		this.idConvocatoriaAreaOrganica = idConvocatoriaAreaOrganica;
	}

	public Integer getCantidadVacantes() {
		return cantidadVacantes;
	}

	public void setCantidadVacantes(Integer cantidadVacantes) {
		this.cantidadVacantes = cantidadVacantes;
	}

	public Integer getIdUnidadOperativa() {
		return idUnidadOperativa;
	}

	public void setIdUnidadOperativa(Integer idUnidadOperativa) {
		this.idUnidadOperativa = idUnidadOperativa;
	}

}
