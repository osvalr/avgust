package sernanp.rrhh.web.action.legajo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.legajo.service.BuscarLegajoService;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQuery;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDetalleLegajoPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerLegajosPersonalQueryCriteria;
import sernanp.app.dao.query.domain.TablaTipoQuery;
import sernanp.app.dao.query.domain.TablaTipoQueryCriteria;
import sernanp.app.dao.query.mapper.ObtenerDatosBasicosPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDetalleLegajoPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerLegajosPersonalQueryMapper;
import sernanp.app.dao.query.mapper.TablaTipoQueryMapper;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class BuscarLegajoAction extends ActionHelper {

	private static final long serialVersionUID = 7410934530146212566L;
    
	@Autowired
	CommonService commonService;
	
	@Autowired
	BuscarLegajoService buscarLegajoService; 
	
	private ObtenerLegajosPersonalQueryCriteria criteriaOLP;
	private ObtenerDetalleLegajoPersonalQueryCriteria criteriaODLP;
	private ObtenerDatosBasicosPersonalQuery datosPersonalQuery;
	
	private Integer idPersonaNatural;
	private Integer idPersonal;
	
	private List<TablaTipoQuery> listTipoLegajo;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object record;
	
	public String buscarLegajoPorPersona(){
		
		listResult = buscarLegajoService.selectByCriteria(ObtenerLegajosPersonalQueryMapper.class, criteriaOLP);
		
		return SUCCESS;
	}
	
	public String obtenerDetalleLegajo(){
		
		listResult = buscarLegajoService.selectByCriteria(ObtenerDetalleLegajoPersonalQueryMapper.class, criteriaODLP);
		if(!listResult.isEmpty()){
			record = listResult.get(0);
		}
		return SUCCESS;
	}
	
	public String obtenerDatosBasicosPersonal(){
		
		if(idPersonaNatural == null && idPersonal == null){
			return ERROR;
		}

		ObtenerDatosBasicosPersonalQueryCriteria criteria = new ObtenerDatosBasicosPersonalQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		criteria.setIdpersonanatural(idPersonaNatural);
		
		listResult = buscarLegajoService.selectByCriteria(ObtenerDatosBasicosPersonalQueryMapper.class, criteria);
		if(!listResult.isEmpty()){
			record = listResult.get(0);
		}
		
		
		TablaTipoQueryCriteria ttc = new TablaTipoQueryCriteria();
		ttc.setDestabla("Tipo de Legajo");
		
		listTipoLegajo = commonService.selectByCriteria(TablaTipoQueryMapper.class, ttc);
		listTipoLegajo.remove(0);

		//12-02-2015 DAVID
		for (int i = 0; i < listTipoLegajo.size(); i++){			
			
			if(listTipoLegajo.get(i).getIdtablatipo() == 161){
				listTipoLegajo.remove(i);
			}
			
			if(listTipoLegajo.get(i).getIdtablatipo() == 167){
				listTipoLegajo.remove(i);
			}
		}
		
//		System.out.println("********************* LISTANDO NUEVA LISTA DE DOCS. LEGAJOS *************************");
//		
//		for (int i = 0; i < listTipoLegajo.size(); i++){
//			
//			System.out.println(i + ".- " + listTipoLegajo.get(i).getIdtablatipo() + " - " + listTipoLegajo.get(i).getDestablatipo());
//			
//		}
		
	
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

	public ObtenerLegajosPersonalQueryCriteria getCriteriaOLP() {
		return criteriaOLP;
	}

	public void setCriteriaOLP(ObtenerLegajosPersonalQueryCriteria criteriaOLP) {
		this.criteriaOLP = criteriaOLP;
	}

	public ObtenerDetalleLegajoPersonalQueryCriteria getCriteriaODLP() {
		return criteriaODLP;
	}

	public void setCriteriaODLP(ObtenerDetalleLegajoPersonalQueryCriteria criteriaODLP) {
		this.criteriaODLP = criteriaODLP;
	}

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}

	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	public ObtenerDatosBasicosPersonalQuery getDatosPersonalQuery() {
		return datosPersonalQuery;
	}

	public void setDatosPersonalQuery(ObtenerDatosBasicosPersonalQuery datosPersonalQuery) {
		this.datosPersonalQuery = datosPersonalQuery;
	}

	public List<TablaTipoQuery> getListTipoLegajo() {
		return listTipoLegajo;
	}

	public void setListTipoLegajo(List<TablaTipoQuery> listTipoLegajo) {
		this.listTipoLegajo = listTipoLegajo;
	}


	

}
