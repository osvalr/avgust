package sernanp.rrhh.web.action.contrato;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

//import com.sun.star.frame.status.UpperLowerMargin;

import sernanp.app.business.core.contrato.service.BuscarContratoService;
import sernanp.app.dao.query.domain.AdendaPorContratoQueryCriteria;
import sernanp.app.dao.query.domain.AdendasGeneradasQuery;
import sernanp.app.dao.query.domain.AdendasGeneradasQueryCriteria;
import sernanp.app.dao.query.domain.AdendasPorVencerQueryCriteria;
import sernanp.app.dao.query.domain.ContratoPorPersonaQueryCriteria;
import sernanp.app.dao.query.domain.ContratosGeneradosQueryCriteria;
import sernanp.app.dao.query.domain.ContratosPorVencerQueryCriteria;
import sernanp.app.dao.query.domain.ListaContratosPersonalVencimientoQuery;
import sernanp.app.dao.query.domain.ListaContratosPersonalVencimientoQueryCriteria;
import sernanp.app.dao.query.mapper.AdendaPorContratoQueryMapper;
import sernanp.app.dao.query.mapper.AdendasGeneradasQueryMapper;
import sernanp.app.dao.query.mapper.AdendasPorVencerQueryMapper;
import sernanp.app.dao.query.mapper.ContratoPorPersonaQueryMapper;
import sernanp.app.dao.query.mapper.ContratosGeneradosQueryMapper;
import sernanp.app.dao.query.mapper.ContratosPorVencerQueryMapper;
import sernanp.app.dao.query.mapper.ListaContratosPersonalVencimientoQueryMapper;
import sernanp.app.util.PropUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class BuscarContratoAction extends ActionHelper {

	private static final long serialVersionUID = 5563645364515107253L;

	@Autowired
	BuscarContratoService buscarContratoService;
	
	private ContratoPorPersonaQueryCriteria criteriaCPP;
	private AdendaPorContratoQueryCriteria criteriaAPC;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object record;
	private Map reportParams;
	
	public String buscarContratoPorPersona(){
		listResult = buscarContratoService.selectByCriteria(ContratoPorPersonaQueryMapper.class, criteriaCPP);
		return SUCCESS;
	}
	
	public String buscarAdendaPorContrato(){
		listResult = buscarContratoService.selectByCriteria(AdendaPorContratoQueryMapper.class, criteriaAPC);
		return SUCCESS;
	}
	
	public String buscarContratosGenerados(){
		
		ContratosGeneradosQueryCriteria criteria = new ContratosGeneradosQueryCriteria();
		criteria.setInt_id_estado(1);
		
		listResult = buscarContratoService.selectByCriteria(ContratosGeneradosQueryMapper.class, criteria);
		return SUCCESS;
	}
	
	public String buscarAdendasGeneradas(){
		
		AdendasGeneradasQueryCriteria criteria = new AdendasGeneradasQueryCriteria();
		criteria.setInt_id_estado(1);
		
		listResult = buscarContratoService.selectByCriteria(AdendasGeneradasQueryMapper.class, criteria);
		return SUCCESS;
	}
	
	public String contratosVencimiento(){
		
		ContratosPorVencerQueryCriteria criteria = new ContratosPorVencerQueryCriteria();
		criteria.setCant_dias(30);
		
		listResult = buscarContratoService.selectByCriteria(ContratosPorVencerQueryMapper.class, criteria);
		return SUCCESS;
	}
	
	public String adendasVencimiento(){
		
		AdendasPorVencerQueryCriteria criteria = new AdendasPorVencerQueryCriteria();
		criteria.setCant_dias(30);
		
		listResult = buscarContratoService.selectByCriteria(AdendasPorVencerQueryMapper.class, criteria);
		return SUCCESS;
	}
	
	/*ADD 12-08-2015   DAVID*/
	
	public String listaContratosPersonalVencimiento(){
		
				
		ListaContratosPersonalVencimientoQueryCriteria criteria = new ListaContratosPersonalVencimientoQueryCriteria();
		
//		listResult = buscarContratoService.selectByCriteria(ListaContratosPersonalVencimientoQueryMapper.class, criteria);
		List<ListaContratosPersonalVencimientoQuery >		list = buscarContratoService.selectByCriteria(ListaContratosPersonalVencimientoQueryMapper.class, criteria);
		
		if (list.size() > 0){
			String ruta = PropUtil.getInstance().getPropVal("personal.properties", "ruta.logo");			
			reportParams = new HashMap();
			reportParams.put("logo", ruta);
			reportParams.put("mes", Funciones.nombreMes(list.get(0).getMes()).toUpperCase());
	
		}

		listResult = list;
		return SUCCESS;
	}
	
	
	
	
	
	
	// ADD 11-11-2015 DAVID --> Reporte de Adendas Generadas
	
	public String downloadListaAdendasGeneradas(){
		
		AdendasGeneradasQueryCriteria criteria = new AdendasGeneradasQueryCriteria();
		criteria.setInt_id_estado(1);
		
		List<AdendasGeneradasQuery> list = buscarContratoService.selectByCriteria(AdendasGeneradasQueryMapper.class, criteria);
	
		if (list.size() > 0){
			String ruta = PropUtil.getInstance().getPropVal("personal.properties", "ruta.logo");			
			reportParams = new HashMap();
			reportParams.put("logo", ruta);
	
		}

		listResult = list;
		
		
		return SUCCESS;
	}
	
	//ADD 12-11-2015 DAVID
	
	public String adendasContratosVencimiento (){
		
		
		return SUCCESS;
		
	}
	
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		return transaccionUtil;
	}

	public ContratoPorPersonaQueryCriteria getCriteriaCPP() {
		return criteriaCPP;
	}

	public void setCriteriaCPP(ContratoPorPersonaQueryCriteria criteriaCPP) {
		this.criteriaCPP = criteriaCPP;
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

	public AdendaPorContratoQueryCriteria getCriteriaAPC() {
		return criteriaAPC;
	}

	public void setCriteriaAPC(AdendaPorContratoQueryCriteria criteriaAPC) {
		this.criteriaAPC = criteriaAPC;
	}

	public Map getReportParams() {
		return reportParams;
	}

	public void setReportParams(Map reportParams) {
		this.reportParams = reportParams;
	}

}
