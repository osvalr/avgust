package sernanp.rrhh.web.action.persona;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.persona.service.BuscarPersonaService;
import sernanp.app.dao.query.domain.ConvocatoriaRegistradaQuery;
import sernanp.app.dao.query.domain.DetallePostulacionPersonaQuery;
import sernanp.app.dao.query.domain.DetallePostulacionPersonaQueryCriteria;
import sernanp.app.dao.query.domain.FiltrarPersonalQueryCriteria;
import sernanp.app.dao.query.domain.PostulanteGanadorQueryCriteria;
import sernanp.app.dao.query.domain.ResumenPostulacionPersonaQueryCriteria;
import sernanp.app.dao.query.mapper.DetallePostulacionPersonaQueryMapper;
import sernanp.app.dao.query.mapper.FiltrarPersonalQueryMapper;
import sernanp.app.dao.query.mapper.PostulanteGanadorQueryMapper;
import sernanp.app.dao.query.mapper.ResumenPostulacionPersonaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class BuscarPersonaAction extends ActionHelper {

	private static Logger log = Logger.getLogger(BuscarPersonaAction.class);
	
	private static final long serialVersionUID = 8664602601639367983L;

	private ResumenPostulacionPersonaQueryCriteria criteriaResumen;
	private PostulanteGanadorQueryCriteria criteriaPostulanteGanador;
	private DetallePostulacionPersonaQueryCriteria criteriaDetalle;
	private FiltrarPersonalQueryCriteria criteriaPersonalContrato;
	
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object record;
	
	private String tipoResultado;
	
	@Autowired
	private BuscarPersonaService buscarPersonaService;
	@Autowired
	CommonService commonService;
	
	public String listarResumenPostulaciones(){
		
		criteriaResumen.setNombres((criteriaResumen.getNombres().equals("") ? null : criteriaResumen.getNombres().toUpperCase()));
		criteriaResumen.setNumerodoc((criteriaResumen.getNumerodoc().equals("") ? null : criteriaResumen.getNumerodoc()));
		criteriaResumen.setNumeroRuc((criteriaResumen.getNumeroRuc().equals("") ? null : criteriaResumen.getNumeroRuc()));
				
		listResult = buscarPersonaService.selectByCriteria(ResumenPostulacionPersonaQueryMapper.class, criteriaResumen);
		return tipoResultado;
	}
	
	public String listarPostulanteGanador(){
		
		criteriaPostulanteGanador.setNombres((criteriaPostulanteGanador.getNombres().equals("") ? null : criteriaPostulanteGanador.getNombres().toUpperCase()));
		criteriaPostulanteGanador.setNumerodoc((criteriaPostulanteGanador.getNumerodoc().equals("") ? null : criteriaPostulanteGanador.getNumerodoc()));
		criteriaPostulanteGanador.setNumeroRuc((criteriaPostulanteGanador.getNumeroRuc().equals("") ? null : criteriaPostulanteGanador.getNumeroRuc()));
					
		listResult = buscarPersonaService.selectByCriteria(PostulanteGanadorQueryMapper.class, criteriaPostulanteGanador);
		return tipoResultado;
	}
	
	@SuppressWarnings("unchecked")
	public String obtenerDetallePostulacion(){
		
		criteriaDetalle.setNumerodoc((criteriaDetalle.getNumerodoc().equals("") ? null : criteriaDetalle.getNumerodoc()));
		criteriaDetalle.setRuc((criteriaDetalle.getRuc().equals("") ? null : criteriaDetalle.getRuc()));
		
		List<DetallePostulacionPersonaQuery> list = buscarPersonaService.selectByCriteria(DetallePostulacionPersonaQueryMapper.class, criteriaDetalle);
		
		if(!list.isEmpty()){
			record = list.get(0);
		}
				
		if(tipoResultado.equals("pdf")){
			listResult = commonService.obtenerConvocatoriasRegistradas(criteriaDetalle.getIdpersona());
			if(listResult.isEmpty()){
				
				ConvocatoriaRegistradaQuery obj =  new ConvocatoriaRegistradaQuery();
				obj.setDesarea("Sin Datos");
				obj.setEstado_descrip("Sin Datos");
				obj.setInt_num_activacion("-1");
				obj.setInt_orden_merito(-1);
				obj.setNomunidad("Sin Datos");
				obj.setTsp_fecha_registro("Sin Datos");
				obj.setVar_codigo_postulacion("Sin Datos");
				obj.setVar_num_convocatoria("Sin Datos");
				listResult = new ArrayList<ConvocatoriaRegistradaQuery>();
				listResult.add(obj);
				
			}
		}
		
		return tipoResultado;
	}
		
	public String buscarPersonalContrato(){
		
		try{
			criteriaPersonalContrato.setNumerodoc((criteriaPersonalContrato.getNumerodoc().equals("") ? null : criteriaPersonalContrato.getNumerodoc()));
			criteriaPersonalContrato.setNombres((criteriaPersonalContrato.getNombres().equals("") ? null : criteriaPersonalContrato.getNombres().toUpperCase()));
			criteriaPersonalContrato.setRuc((criteriaPersonalContrato.getRuc().equals("") ? null : criteriaPersonalContrato.getRuc()));
						
			listResult = buscarPersonaService.selectByCriteria(FiltrarPersonalQueryMapper.class, criteriaPersonalContrato);
		}catch(BusinessException e){
			log.error(e.getMessage(),e);
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

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}


	public String getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(String tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	public ResumenPostulacionPersonaQueryCriteria getCriteriaResumen() {
		return criteriaResumen;
	}

	public void setCriteriaResumen(
			ResumenPostulacionPersonaQueryCriteria criteriaResumen) {
		this.criteriaResumen = criteriaResumen;
	}

	public DetallePostulacionPersonaQueryCriteria getCriteriaDetalle() {
		return criteriaDetalle;
	}

	public void setCriteriaDetalle(
			DetallePostulacionPersonaQueryCriteria criteriaDetalle) {
		this.criteriaDetalle = criteriaDetalle;
	}

	public FiltrarPersonalQueryCriteria getCriteriaPersonalContrato() {
		return criteriaPersonalContrato;
	}

	public void setCriteriaPersonalContrato(FiltrarPersonalQueryCriteria criteriaPersonalContrato) {
		this.criteriaPersonalContrato = criteriaPersonalContrato;
	}

	public PostulanteGanadorQueryCriteria getCriteriaPostulanteGanador() {
		return criteriaPostulanteGanador;
	}

	public void setCriteriaPostulanteGanador(PostulanteGanadorQueryCriteria criteriaPostulanteGanador) {
		this.criteriaPostulanteGanador = criteriaPostulanteGanador;
	}
}
