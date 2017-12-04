package sernanp.rrhh.web.action.desvinculacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.desvinculacion.service.BuscarDesvinculacionService;
import sernanp.app.dao.domain.TTipificacion;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQuery;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDesvinculacionQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDetalleDesvinculacionQueryCriteria;
import sernanp.app.dao.query.mapper.ObtenerDatosBasicosPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDesvinculacionQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDetalleDesvinculacionQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDetalleLegajoPersonalQueryMapper;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class BuscarDesvinculacionAction extends ActionHelper {

	private static final long serialVersionUID = 7410934530146212566L;
    
	@Autowired
	CommonService commonService;
	
	@Autowired
	BuscarDesvinculacionService buscarDesvinculacionService;
	
	private ObtenerDesvinculacionQueryCriteria criteriaOD;
	private ObtenerDetalleDesvinculacionQueryCriteria criteriaDD;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object record;
	
	private List<TTipificacion> listTipificacion;
	private ObtenerDatosBasicosPersonalQuery datosPersonalQuery;
	private Integer idPersonaNatural;
	private Integer idPersonal;
	
	public String obtenerDatosBasicosPersonal(){
		
		if(idPersonaNatural == null && idPersonal == null){
			return ERROR;
		}

		ObtenerDatosBasicosPersonalQueryCriteria criteria = new ObtenerDatosBasicosPersonalQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		criteria.setIdpersonanatural(idPersonaNatural);
		
		listResult = buscarDesvinculacionService.selectByCriteria(ObtenerDatosBasicosPersonalQueryMapper.class, criteria);
		if(!listResult.isEmpty()){
			record = listResult.get(0);
		}
		
		listTipificacion = commonService.obtenerTipificacion();
		listTipificacion.remove(2);
			
		return SUCCESS;
	}

		
	public String buscarDesvinculacionPorPersona(){
		listResult = buscarDesvinculacionService.selectByCriteria(ObtenerDesvinculacionQueryMapper.class, criteriaOD);
		return SUCCESS;
	}
	
	public String obtenerDetalleDesvinculacion(){
		
		listResult = buscarDesvinculacionService.selectByCriteria(ObtenerDetalleDesvinculacionQueryMapper.class, criteriaDD);
		if(!listResult.isEmpty()){
			record = listResult.get(0);
		}
		return SUCCESS;
	}
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		
		return transaccionUtil;
	}

	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	
	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}


	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}


	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}

	public Integer getIdPersonal() {
		return idPersonal;
	}


	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}


	public List<TTipificacion> getListTipificacion() {
		return listTipificacion;
	}

	public void setListTipificacion(List<TTipificacion> listTipificacion) {
		this.listTipificacion = listTipificacion;
	}

	public ObtenerDatosBasicosPersonalQuery getDatosPersonalQuery() {
		return datosPersonalQuery;
	}

	public void setDatosPersonalQuery(ObtenerDatosBasicosPersonalQuery datosPersonalQuery) {
		this.datosPersonalQuery = datosPersonalQuery;
	}

	public ObtenerDesvinculacionQueryCriteria getCriteriaOD() {
		return criteriaOD;
	}

	public void setCriteriaOD(ObtenerDesvinculacionQueryCriteria criteriaOD) {
		this.criteriaOD = criteriaOD;
	}


	public ObtenerDetalleDesvinculacionQueryCriteria getCriteriaDD() {
		return criteriaDD;
	}


	public void setCriteriaDD(ObtenerDetalleDesvinculacionQueryCriteria criteriaDD) {
		this.criteriaDD = criteriaDD;
	}
	
}
