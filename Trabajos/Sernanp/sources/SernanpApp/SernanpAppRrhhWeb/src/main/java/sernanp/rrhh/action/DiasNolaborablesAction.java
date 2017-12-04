package sernanp.rrhh.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.asistencia.service.GestionarDiasNoLaborablesService;
import sernanp.app.business.dto.DiasNoLaborablesDTO;
import sernanp.app.dao.domain.TDiasNoLaborables;
import sernanp.app.dao.domain.TDiasNoLaborablesExample;
import sernanp.app.dao.mapper.TDiasNoLaborablesMapper;
import sernanp.app.dao.query.domain.Anios_dias_no_laborablesQuery;
import sernanp.app.dao.query.domain.Anios_dias_no_laborablesQueryCriteria;
import sernanp.app.dao.query.domain.DiasNolaborablesPorMesAnioQuery;
import sernanp.app.dao.query.domain.DiasNolaborablesPorMesAnioQueryCriteria;
import sernanp.app.dao.query.mapper.Anios_dias_no_laborablesQueryMapper;
import sernanp.app.dao.query.mapper.DiasNolaborablesPorMesAnioQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class DiasNolaborablesAction extends ActionHelper {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(DiasNolaborablesAction.class);

	@Autowired
	GestionarDiasNoLaborablesService gestionarDiasNoLaborablesService;


	private TDiasNoLaborables tDiasNoLaborables;
	
	private DiasNoLaborablesDTO diasNoLaborablesDTO;
	
	private Integer anio;
	private Integer mes;
	private List<Anios_dias_no_laborablesQuery> listaniosDiasNoLaborables;
	private List<Anios_dias_no_laborablesQuery> listamesesDiasNoLaborables;
	private List listResult;
	
	
	public String listarAniosdiasnolaborables() {

		try {

			Anios_dias_no_laborablesQueryCriteria criteria = new Anios_dias_no_laborablesQueryCriteria();
			criteria.setSrl_id_no_laborable(null);

			listaniosDiasNoLaborables = new ArrayList<Anios_dias_no_laborablesQuery>();
						
			listaniosDiasNoLaborables = this.gestionarDiasNoLaborablesService.getListByQuery(Anios_dias_no_laborablesQueryMapper.class, criteria);
			
			
			listamesesDiasNoLaborables = new ArrayList<Anios_dias_no_laborablesQuery>();
			
			for(int i = 1; i <= 12; i++){
				
				Anios_dias_no_laborablesQuery mes = new Anios_dias_no_laborablesQuery();
				mes.setPeriodo(i);
				mes.setDescripcion(Funciones.nombreMes(i));				
				listamesesDiasNoLaborables.add(mes);
			}
			


		} catch (Exception e) {
			
			log.error(e.getMessage(),e);
		}

		return SUCCESS;
	}
	

	public String grabarDiasNoLaborables() {
		

		try {
			
			
			if(diasNoLaborablesDTO != null){
				
				diasNoLaborablesDTO.setInt_estado(0);
				gestionarDiasNoLaborablesService.registrarDiaNoLaborable(diasNoLaborablesDTO);

				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Día se registro con éxito.");
	
			}
			
						 

		} catch (BusinessException e) {
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

	public String buscarDiasNoLaborablesxPeriodo() {
		
		DiasNolaborablesPorMesAnioQueryCriteria criteria = new DiasNolaborablesPorMesAnioQueryCriteria();
		criteria.setInt_anio(anio);
		criteria.setInt_mes(mes);
		
		listResult = gestionarDiasNoLaborablesService.getListByQuery(DiasNolaborablesPorMesAnioQueryMapper.class, criteria);

		return SUCCESS;
	}
	
	
	
	
	public String eliminarDiasNoLaborables(){
		System.out.println(diasNoLaborablesDTO.getSrl_id_no_laborable());
		
		try {
			gestionarDiasNoLaborablesService.eliminarDiaNoLaborable(diasNoLaborablesDTO);
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
			transaccionUtil.setMensaje("Día se elimino con éxito.");
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
	
	
	public TDiasNoLaborables gettDiasNoLaborables() {
		return tDiasNoLaborables;
	}

	public void settDiasNoLaborables(TDiasNoLaborables tDiasNoLaborables) {
		this.tDiasNoLaborables = tDiasNoLaborables;
	}
	
	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public List<Anios_dias_no_laborablesQuery> getListaniosDiasNoLaborables() {
		return listaniosDiasNoLaborables;
	}

	public void setListaniosDiasNoLaborables(List<Anios_dias_no_laborablesQuery> listaniosDiasNoLaborables) {
		this.listaniosDiasNoLaborables = listaniosDiasNoLaborables;
	}
	
	public List getListResult() {
		return listResult;
	}

	public void setListResult(List listResult) {
		this.listResult = listResult;
	}


	public DiasNoLaborablesDTO getDiasNoLaborablesDTO() {
		return diasNoLaborablesDTO;
	}


	public void setDiasNoLaborablesDTO(DiasNoLaborablesDTO diasNoLaborablesDTO) {
		this.diasNoLaborablesDTO = diasNoLaborablesDTO;
	}


	public Integer getMes() {
		return mes;
	}


	public void setMes(Integer mes) {
		this.mes = mes;
	}


	public List<Anios_dias_no_laborablesQuery> getListamesesDiasNoLaborables() {
		return listamesesDiasNoLaborables;
	}


	public void setListamesesDiasNoLaborables(List<Anios_dias_no_laborablesQuery> listamesesDiasNoLaborables) {
		this.listamesesDiasNoLaborables = listamesesDiasNoLaborables;
	}

	

}
