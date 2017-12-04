package sernanp.rrhh.web.action.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.persona.service.BuscarPersonaService;
import sernanp.app.business.core.planilla.service.ReporteResumenAltasBajasService;
import sernanp.app.business.dto.FiltrarPersonalReporteDto;
import sernanp.app.dao.domain.Areanatural;
import sernanp.app.dao.domain.Areaorganica;
import sernanp.app.dao.domain.Categoriaanp;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.TCargo;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.mapper.AreanaturalMapper;
import sernanp.app.dao.mapper.AreaorganicaMapper;
import sernanp.app.dao.mapper.CategoriaanpMapper;
import sernanp.app.dao.query.domain.FiltrarPersonalQueryCriteria;
import sernanp.app.dao.query.domain.FiltrarPersonalReporteQueryCriteria;
import sernanp.app.dao.query.mapper.FiltrarPersonalQueryMapper;
import sernanp.app.dao.query.mapper.FiltrarPersonalReporteQueryMapper;
import sernanp.app.util.IntrospeccionUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;


public class BuscarPersonalAction extends ActionHelper {

	private static final long serialVersionUID = 8664602601639367983L;

	private FiltrarPersonalQueryCriteria criteriaResumen;	
	private FiltrarPersonalReporteDto criteriaReporteResumen;
		
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object record;
	
	private String tipoResultado;
	private List<TRegimenContractual> listRegimenContractual;
	private List<TCargo> listCargo;
	private List<Personal> listEstadoPersonal;
	private List<Areaorganica> listAreaOrganica;
	private List<Categoriaanp> listCategoriaAnp;
	private List<Areanatural> listAreaNatural;
	
	@Autowired
	BuscarPersonaService buscarPersonaService;
	
	@Autowired
	private ReporteResumenAltasBajasService reporteResumenAltasBajasService;
	
	@Autowired
	CommonService commonService;
	
	private String format;
	
	String resultado;
	
	public String cargarCriterioBusqueda(){
		
		listRegimenContractual = commonService.obtenerRegimenContractual();
		listCargo = commonService.obtenerCargo();
		listAreaOrganica = commonService.selectAll(AreaorganicaMapper.class);
		listCategoriaAnp = commonService.selectAll(CategoriaanpMapper.class);
//		listAreaNatural = commonService.selectAll(AreanaturalMapper.class);
		
		return SUCCESS;
	}
	
	public String cargarCriterioBusquedaReporte(){
		
		listRegimenContractual = commonService.obtenerRegimenContractual();
		listCargo = commonService.obtenerCargo();
		
		return SUCCESS;
	}
	
	
	public String listarResumenPersonal(){
		
		criteriaResumen.setNombres((criteriaResumen.getNombres().equals("") ? null : criteriaResumen.getNombres().toUpperCase()));
		criteriaResumen.setNumerodoc((criteriaResumen.getNumerodoc().equals("") ? null : criteriaResumen.getNumerodoc()));
		criteriaResumen.setRuc((criteriaResumen.getRuc().equals("") ? null : criteriaResumen.getRuc()));

		listResult = buscarPersonaService.selectByCriteria(FiltrarPersonalQueryMapper.class, criteriaResumen);
		return SUCCESS;
		
	}
	
	public String listarResumenPersonalReporte(){
		
		criteriaReporteResumen.setDte_fec_inicio_desde((criteriaReporteResumen.getDte_fec_inicio_desde().equals("") ? null : criteriaReporteResumen.getDte_fec_inicio_desde()));
		criteriaReporteResumen.setDte_fec_inicio_hasta((criteriaReporteResumen.getDte_fec_inicio_hasta().equals("") ? null : criteriaReporteResumen.getDte_fec_inicio_hasta()));
		
		try {
			Integer.parseInt(criteriaReporteResumen.getAnho_inicio());
		} catch (Exception e) {
			criteriaReporteResumen.setAnho_inicio(null);
		}
		
		FiltrarPersonalReporteQueryCriteria criteria = IntrospeccionUtil.tranferBean(criteriaReporteResumen, FiltrarPersonalReporteQueryCriteria.class, false);
		
		listResult = buscarPersonaService.selectByCriteria(FiltrarPersonalReporteQueryMapper.class, criteria);
		return SUCCESS;
		
	}
	
	public String reportePersonal(){
		
		criteriaReporteResumen.setDte_fec_inicio_desde((criteriaReporteResumen.getDte_fec_inicio_desde().equals("") ? null : criteriaReporteResumen.getDte_fec_inicio_desde()));
		criteriaReporteResumen.setDte_fec_inicio_hasta((criteriaReporteResumen.getDte_fec_inicio_hasta().equals("") ? null : criteriaReporteResumen.getDte_fec_inicio_hasta()));
		
		try {
			Integer.parseInt(criteriaReporteResumen.getAnho_inicio());
		} catch (Exception e) {
			criteriaReporteResumen.setAnho_inicio(null);
		}
		
		FiltrarPersonalReporteQueryCriteria criteria = IntrospeccionUtil.tranferBean(criteriaReporteResumen, FiltrarPersonalReporteQueryCriteria.class, false);
		
//		format = "PDF";
		
		listResult = buscarPersonaService.selectByCriteria(FiltrarPersonalReporteQueryMapper.class, criteria);
		return SUCCESS;
		
	}
	
	public FiltrarPersonalQueryCriteria getCriteriaResumen() {
		return criteriaResumen;
	}


	public void setCriteriaResumen(FiltrarPersonalQueryCriteria criteriaResumen) {
		this.criteriaResumen = criteriaResumen;
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


	public List<TRegimenContractual> getListRegimenContractual() {
		return listRegimenContractual;
	}


	public void setListRegimenContractual(
			List<TRegimenContractual> listRegimenContractual) {
		this.listRegimenContractual = listRegimenContractual;
	}

	public List<Personal> getListEstadoPersonal() {
		return listEstadoPersonal;
	}

	public void setListEstadoPersonal(List<Personal> listEstadoPersonal) {
		this.listEstadoPersonal = listEstadoPersonal;
	}


	public List<TCargo> getListCargo() {
		return listCargo;
	}


	public void setListCargo(List<TCargo> listCargo) {
		this.listCargo = listCargo;
	}

	public FiltrarPersonalReporteDto getCriteriaReporteResumen() {
		return criteriaReporteResumen;
	}

	public void setCriteriaReporteResumen(FiltrarPersonalReporteDto criteriaReporteResumen) {
		this.criteriaReporteResumen = criteriaReporteResumen;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public List<Areaorganica> getListAreaOrganica() {
		return listAreaOrganica;
	}

	public void setListAreaOrganica(List<Areaorganica> listAreaOrganica) {
		this.listAreaOrganica = listAreaOrganica;
	}

	public List<Categoriaanp> getListCategoriaAnp() {
		return listCategoriaAnp;
	}

	public void setListCategoriaAnp(List<Categoriaanp> listCategoriaAnp) {
		this.listCategoriaAnp = listCategoriaAnp;
	}

	public List<Areanatural> getListAreaNatural() {
		return listAreaNatural;
	}

	public void setListAreaNatural(List<Areanatural> listAreaNatural) {
		this.listAreaNatural = listAreaNatural;
	}

	

	

}
