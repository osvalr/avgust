package sernanp.rrhh.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.asistencia.service.BuscarLicenciasPersonalService;
import sernanp.app.dao.query.domain.LicenciasPersonalPorMesAnioActividadQuery;
import sernanp.app.dao.query.domain.LicenciasPersonalPorMesAnioActividadQueryCriteria;
import sernanp.app.dao.query.mapper.LicenciasPersonalPorMesAnioActividadQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class LicenciasPersonalAction extends ActionHelper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(DiasNolaborablesAction.class);

	@Autowired
	BuscarLicenciasPersonalService buscarLicenciasPersonalService;

	
	private List listResult;
	
	
	private Integer anio;
	private Integer mes;
	private Integer idPersonal;
	private Integer srl_id_actividad;
	
	
	public String listarLicencias() {

		try {
			LicenciasPersonalPorMesAnioActividadQueryCriteria criteria = new LicenciasPersonalPorMesAnioActividadQueryCriteria();
			criteria.setInt_anio(anio);
			criteria.setInt_mes(mes);
			criteria.setIdpersonal(idPersonal);
			criteria.setSrl_id_per_activ(srl_id_actividad);
			
			listResult = buscarLicenciasPersonalService.getListByQuery(LicenciasPersonalPorMesAnioActividadQueryMapper.class, criteria);		

			List<LicenciasPersonalPorMesAnioActividadQuery> listLic = new ArrayList<LicenciasPersonalPorMesAnioActividadQuery>();
			
			listLic = listResult;			

			
		}catch (BusinessException e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			log.error(e.getMessage(),e);
			
		} catch (Exception e) {
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
			log.error(e.getMessage(), e);
		}

		return SUCCESS;
	}

	@Override
	public TransaccionUtil getTransaccionUtil() {
		// TODO Auto-generated method stub
		return transaccionUtil;
	}



	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Integer getSrl_id_actividad() {
		return srl_id_actividad;
	}

	public void setSrl_id_actividad(Integer srl_id_actividad) {
		this.srl_id_actividad = srl_id_actividad;
	}

	public List getListResult() {
		return listResult;
	}

	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

}
