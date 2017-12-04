package proyecto.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.TipoDAO;
import proyecto.dao.VisitanteConceptoexoneracionpagoDAO;
import proyecto.dao.VisitanteDAO;
import proyecto.param.TurismoParam;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Tipo;
import proyecto.vo.Visitante;
import proyecto.vo.VisitanteConceptoexoneracionpago;

@Service
public class VisitanteService {  

	@Autowired
	private VisitanteDAO visitanteDAO;
	@Autowired
	private VisitanteConceptoexoneracionpagoDAO visitanteConceptoexoneracionpagoDAO;
	@Autowired
	private TipoDAO tipoDAO;
	
//	public long save(List<Visitante> visitantes) {   
//		return getVisitanteDAO().save(visitantes);   
//	}

//	public long saveTest(List<Visitante> visitantes) {  
//		return getVisitanteDAO().saveTest(visitantes);   
//	}
	
//	public void setVisitanteDAO(VisitanteDAO visitanteDAO) {
//		this.visitanteDAO = visitanteDAO;
//	}
//
//	public VisitanteDAO getVisitanteDAO() { 
//		return visitanteDAO;
//	}
	
	public List<Map<String,Object>> reporteVisitantexRutaAnual( TurismoParam turismoparam){
		List<Map<String,Object>>lista= 	visitanteDAO.reporteVisitantexRutaAnual(turismoparam);
		/*
		for(Map<String, Object> map:lista){
			System.out.println("nombreruta anual:"+map.get("nombrerutaturismo"));
			System.out.println("total anual: "+map.get("total"));
			System.out.println("panual%: "+map.get("percent"));
		}
		*/
		return visitanteDAO.reporteVisitantexRutaAnual(turismoparam); 
	}
	
	public List<Map<String,Object>> reporteVisitantexRutaMensual( TurismoParam turismoparam){
		//List<Map<String,Object>>lista= 	visitanteDAO.reporteVisitantexRutaAnual(turismoparam);
//		for(Map<String, Object> map:lista){
//			System.out.println("nombreruta mensual:"+map.get("nombrerutaturismo"));
//			System.out.println("total mensual: "+map.get("total"));
//			System.out.println("pmensual%: "+map.get("percent"));
//		}
		return visitanteDAO.reporteVisitantexRutaMensual(turismoparam);
		
	}
	
	
	
	public List<Map<String,Object>> reporteCruzadoVisitantexRutaMensual( TurismoParam turismoparam){
		//List<Map<String,Object>>lista= 	visitanteDAO.reporteCruzadoVisitantexRutaMensual(turismoparam);
		/*
		for(Map<String, Object> map:lista){
			System.out.println("nombreruta mensual:"+map.get("nombrerutaturismo"));
			System.out.println("total mensual: "+map.get("total"));
			System.out.println("pmensual%: "+map.get("percent"));
		}
		*/
		return visitanteDAO.reporteCruzadoVisitantexRutaMensual(turismoparam);
		
	}
	
	
	public Tipo determinarGrupoEdadVisitantexFechaNacimiento(Date fechanacimiento){
		Tipo grupoedad=new Tipo();
		Date factual = new Date();
		long difdias = ProyectoUtil.diferenciaEntreFechas(factual, fechanacimiento);
		if (difdias > ValueConstants.NUMERO_DIAS_COTA_INF_EDAD_MAYOR) {
			grupoedad.setCodigointtipo(1);
		} else if (difdias > ValueConstants.NUMERO_DIAS_COTA_INF_EDAD_MENOR) {
			grupoedad.setCodigointtipo(2);
		}
		else {
			grupoedad.setCodigointtipo(3);
		}
		return grupoedad;
	}
	
	
	public List<Map<String,Object>> reporteCruzadoVisitantexNacionalidad( TurismoParam turismoparam){
		
		return visitanteDAO.reporteCruzadoVisitantexNacionalidad(turismoparam);
		
	}
	
	
	
    public List<Map<String,Object>> reporteCruzadoVisitantexGenero( TurismoParam turismoparam){
		Map<Integer, Integer> mapGenero=tipoDAO.obtenerMapCodigoIdxTabla(ValueConstants.TIPO_GENERO); 
		return visitanteDAO.reporteCruzadoVisitantexGenero(turismoparam, mapGenero);
	}
    
    
    public List<Map<String,Object>> reporteCruzadoVisitantexOcupacion( TurismoParam turismoparam){
		Map<Integer, Integer> mapOcupacion=tipoDAO.obtenerMapCodigoIdxTabla(ValueConstants.TIPO_OCUPACION); 
		return visitanteDAO.reporteCruzadoVisitantexOcupacion(turismoparam, mapOcupacion);
	}
    
    public List<Map<String,Object>> reporteCruzadoVisitantexMotivoVisita( TurismoParam turismoparam){
		Map<Integer, Integer> mapMotivoVisita=tipoDAO.obtenerMapCodigoIdxTabla(ValueConstants.TIPO_MOTIVO_VISITA); 
		return visitanteDAO.reporteCruzadoVisitantexMotivoVisita(turismoparam, mapMotivoVisita);
	}
	
    
    
    
    public List<Map<String,Object>> reporteCruzadoVisitantexCaracteristicas( TurismoParam turismoparam){
    	Map<String, Map<Integer, Integer>> mapCaracteristicas=new HashMap<String, Map<Integer, Integer>>();
    	Map<Integer, Integer> mapGenero=tipoDAO.obtenerMapCodigoIdxTabla(ValueConstants.TIPO_GENERO); 
    	Map<Integer, Integer> mapOcupacion=tipoDAO.obtenerMapCodigoIdxTabla(ValueConstants.TIPO_OCUPACION); 
		Map<Integer, Integer> mapMotivoVisita=tipoDAO.obtenerMapCodigoIdxTabla(ValueConstants.TIPO_MOTIVO_VISITA); 
		mapCaracteristicas.put("genero", mapGenero);
		mapCaracteristicas.put("ocupacion", mapOcupacion);
		mapCaracteristicas.put("motivovisita", mapMotivoVisita);
		return visitanteDAO.reporteCruzadoVisitantexCaracteristicas(turismoparam, mapCaracteristicas);
	}
    
    
	public void actualizarRegistroVisitante(Visitante visitante){
		visitanteDAO.actualizar(visitante);
	}
	
	public int guardarVisitante(Visitante visitante){
		int idvisitante=0;
		visitante.setFlagcompleto(ValueConstants.FLAG_ACTIVO);
		visitante.setFlagregistro(ValueConstants.FLAG_ACTIVO);
		if(visitante.getIdvisitante()==0){
			idvisitante= visitanteDAO.insertar(visitante);
			visitante.setIdvisitante(idvisitante);
			if(visitante.getBoletaje().getIdboletaje()==0){
       			visitanteConceptoexoneracionpagoDAO.insertar(visitante);
       		}
		}else{
			idvisitante=(int)visitante.getIdvisitante();
			if(visitante.getBoletaje().getIdboletaje()==0){
				visitante.getBoletaje().setIdboletaje(ValueConstants.VALOR_CERO);
			}
			visitanteDAO.actualizar(visitante);
			if(visitante.getBoletaje().getIdboletaje()==ValueConstants.VALOR_CERO){
				VisitanteConceptoexoneracionpago vc=new VisitanteConceptoexoneracionpago();
				vc.getVisitante().setIdvisitante(visitante.getIdvisitante());
				vc.getConceptoexoneracionpago()
				.setIdconceptoexoneracionpago(visitante.getConceptoexoneracionpago().getIdconceptoexoneracionpago());
       			visitanteConceptoexoneracionpagoDAO.insertarNoDuplicado(vc);
       		}else{
       			visitanteConceptoexoneracionpagoDAO.eliminar(visitante);
       		}
		}	
		return idvisitante;	
	}
	
	
	public Visitante consultarVisitantexId(int idvisitante){
		Visitante v=new Visitante();
		List<Visitante>lista= visitanteDAO.listar(new Visitante(idvisitante),0);
		if(lista.size()==1){
			v=lista.get(0);
			v.setGrupoedad(determinarGrupoEdadVisitantexFechaNacimiento(v.getFechanacimiento()));
		}
		return v;
	}
	
	public void eliminarListadoVisitantesxId(List<Integer> lista){
		for(Integer i:lista){
			Visitante v=new Visitante();
			v.setIdvisitante(i);
			v.setFlagregistro(ValueConstants.VALOR_CERO);
			visitanteDAO.actualizar(v);
		}
	}
	
	/*
	public List<Map<String,Object>> reporte( String codareanatural){
		return visitanteDAO.reporte( codareanatural );
	}

	public List<Map<String,Object>> reportexRuta( String codareanatural){
		return visitanteDAO.reportexRuta( codareanatural ); 
	}
	*/
//	Date fnac = new Date();
//	SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
//	try {
//		fnac = formateador.parse(visitante.getFechanacimiento());
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
	
//	}
//	public List<Visitante> listarxFicha(long ficha) {
//		return visitanteDAO.listarxFicha(ficha); 
//	}
	
	public List<Visitante> listarVisitantesTemporalesxFichaTurismo(long idficha){
		Visitante v=new Visitante();
		v.getFichaturismo().setIdfichaturismo(idficha);
		//v.setFlagregistro(ValueConstants.FLAG_REGISTRO_GUARDADO_ALMACENADO);
		return visitanteDAO.listar(v,ValueConstants.ORDEN_CONSULTA_NOMBRECOMPVISITANTE);
	}
	
	public List<Visitante> listarVisitantesxFichaTurismo(long idfichaturismo){
		List<Visitante> lista=new ArrayList<Visitante>();
		Visitante vbus=new Visitante();
		vbus.getFichaturismo().setIdfichaturismo(idfichaturismo);
		vbus.setFlagregistro(ValueConstants.FLAG_ACTIVO);
		lista=visitanteDAO.listar(vbus, ValueConstants.ORDEN_CONSULTA_NOMBRECOMPVISITANTE);
		for(Visitante v:lista){
			v.setGrupoedad(determinarGrupoEdadVisitantexFechaNacimiento(v.getFechanacimiento()));
		}
		return lista;
	}
	
	
//	public void quitarListadoVisitantesDeFicha(List<Visitante> lista){
//		for(Visitante v:lista){
//			System.out.println("idvis"+v.getIdvisitante());
//			v.setFlagregistro(ValueConstants.FLAG_REGISTRO_QUITADO);
//			visitanteDAO.actualizar(v);
//		}
//	}
	
	
	public int[] consolidarVisitantes( List<Visitante> visitantes ){
		return visitanteDAO.consolidarVisitantes(visitantes);
	}
}
