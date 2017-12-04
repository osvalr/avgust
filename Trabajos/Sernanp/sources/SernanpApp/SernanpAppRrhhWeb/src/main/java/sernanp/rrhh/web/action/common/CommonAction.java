package sernanp.rrhh.web.action.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.cons.Tablas;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.common.service.CommonServiceMybatis;
import sernanp.app.business.core.convocatoria.service.GestionarConvocatoriaService;
import sernanp.app.dao.domain.AreanaturalExample;
import sernanp.app.dao.domain.AreaorganicaExample;
import sernanp.app.dao.domain.CategoriaanpExample;
import sernanp.app.dao.domain.TAfpExample;
import sernanp.app.dao.domain.TAnioMetaExample;
import sernanp.app.dao.domain.TAnioPlanillaExample;
import sernanp.app.dao.domain.TBeneficiarioDescuentoJudicialExample;
import sernanp.app.dao.domain.TClasificadorExample;
import sernanp.app.dao.domain.TConceptoPlanillaExample;
import sernanp.app.dao.domain.TConfiguracionFactorEvaluacionExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgExample;
import sernanp.app.dao.domain.TEtapaProcesoSeleccionExample;
import sernanp.app.dao.domain.TFuenteFinanciamientoExample;
import sernanp.app.dao.domain.TGenericaGastoExample;
import sernanp.app.dao.domain.TMetaPresupuestariaExample;
import sernanp.app.dao.domain.TParametroPlanillaExample;
import sernanp.app.dao.domain.TRegimenPensionarioExample;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionExample;
import sernanp.app.dao.domain.UnidadoperativaExample;
import sernanp.app.dao.mapper.AreanaturalMapper;
import sernanp.app.dao.mapper.AreaorganicaMapper;
import sernanp.app.dao.mapper.CategoriaanpMapper;
import sernanp.app.dao.mapper.TAfpMapper;
import sernanp.app.dao.mapper.TAnioMetaMapper;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.mapper.TBeneficiarioDescuentoJudicialMapper;
import sernanp.app.dao.mapper.TClasificadorMapper;
import sernanp.app.dao.mapper.TConceptoPlanillaMapper;
import sernanp.app.dao.mapper.TConfiguracionEvaluacionPersonalMapper;
import sernanp.app.dao.mapper.TConfiguracionFactorEvaluacionMapper;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TEtapaProcesoSeleccionMapper;
import sernanp.app.dao.mapper.TFuenteFinanciamientoMapper;
import sernanp.app.dao.mapper.TGenericaGastoMapper;
import sernanp.app.dao.mapper.TMetaPresupuestariaMapper;
import sernanp.app.dao.mapper.TParametroPlanillaMapper;
import sernanp.app.dao.mapper.TRegimenPensionarioMapper;
import sernanp.app.dao.mapper.TSubetapaProcesoSeleccionMapper;
import sernanp.app.dao.mapper.UnidadoperativaMapper;
import sernanp.app.dao.query.domain.AreaOrganicaQueryCriteria;
import sernanp.app.dao.query.domain.AreaOrganicaUnidadOperativaQueryCriteria;
import sernanp.app.dao.query.domain.BuscarPostulanteQueryCriteria;
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.DireccionSedePrestacionQueryCriteria;
import sernanp.app.dao.query.domain.EstadoQueryCriteria;
import sernanp.app.dao.query.domain.EstadosPostulantesAprobadosQueryCriteria;
import sernanp.app.dao.query.domain.FactorEvaluacionPadreQueryCriteria;
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQueryCriteria;
import sernanp.app.dao.query.domain.ListaCodigoPostulacionQueryCriteria;
import sernanp.app.dao.query.domain.ListaLanzamientoConvocatoriaQueryCriteria;
import sernanp.app.dao.query.domain.ListaPersonalQueryCriteria;
import sernanp.app.dao.query.domain.MenuReportesQueryCriteria;
import sernanp.app.dao.query.domain.NumeroConvocatoriaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerAreaActualPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDatosReqAreaOrgQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDatosReqPlazaQuery;
import sernanp.app.dao.query.domain.ObtenerDatosReqPlazaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDependenciaAnpSedeQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerMetaFuenteGenericaQuery;
import sernanp.app.dao.query.domain.ObtenerMetaFuenteGenericaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerMetaPorAreaAnhoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerNombresPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerPeriodosPorAnioQueryCriteria;
import sernanp.app.dao.query.domain.RequerimientoDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.SedesAdministrativasQueryCriteria;
import sernanp.app.dao.query.domain.SubEtapaPorPlazaQueryCriteria;
import sernanp.app.dao.query.domain.TablaTipoReferQueryCriteria;
import sernanp.app.dao.query.domain.listarDescuentoConceptoQueryCriteria;
import sernanp.app.dao.query.mapper.AreaOrganicaQueryMapper;
import sernanp.app.dao.query.mapper.AreaOrganicaUnidadOperativaQueryMapper;
import sernanp.app.dao.query.mapper.BuscarPostulanteQueryMapper;
import sernanp.app.dao.query.mapper.DireccionSedePrestacionQueryMapper;
import sernanp.app.dao.query.mapper.EstadoQueryMapper;
import sernanp.app.dao.query.mapper.EstadosPostulantesAprobadosQueryMapper;
import sernanp.app.dao.query.mapper.FactorEvaluacionPadreQueryMapper;
import sernanp.app.dao.query.mapper.GestionarAsignarConceptoQueryMapper;
import sernanp.app.dao.query.mapper.ListaCodigoPostulacionQueryMapper;
import sernanp.app.dao.query.mapper.ListaLanzamientoConvocatoriaQueryMapper;
import sernanp.app.dao.query.mapper.ListaPersonalQueryMapper;
import sernanp.app.dao.query.mapper.MenuReportesQueryMapper;
import sernanp.app.dao.query.mapper.NumeroConvocatoriaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerAreaActualPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDatosReqAreaOrgQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDatosReqPlazaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDependenciaAnpSedeQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerMetaFuenteGenericaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerMetaPorAreaAnhoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerNombresPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerPeriodosPorAnioQueryMapper;
import sernanp.app.dao.query.mapper.RequerimientoDisponibleQueryMapper;
import sernanp.app.dao.query.mapper.SedesAdministrativasQueryMapper;
import sernanp.app.dao.query.mapper.SubEtapaPorPlazaQueryMapper;
import sernanp.app.dao.query.mapper.TablaTipoReferQueryMapper;
import sernanp.app.dao.query.mapper.listarDescuentoConceptoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class CommonAction extends ActionHelper {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -596205608312940850L;

	@Autowired
	CommonService commonService;
	
	@Autowired
	CommonServiceMybatis commonServiceMybatis;
	
	@Autowired
	GestionarConvocatoriaService gestionarConvocatoriaService;
	
		
	private Integer idTablaTipo;
	private Integer codIntTablaTipo;
	
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object result;
	

	private String idDepartamento;
	private String idProvincia;

	private Integer idConvocatoria;
	private Integer idConvocatoriaAreaOrganica;
	
	private String email;
	private String numeroRuc;
	private Integer idTipoDoc;
	private String numeroDoc;
	private Integer registrado;
	
	private Integer idPersona;
	private Integer idPostulante;
	private Integer idPersonaNatural;
	private Integer idPostulanteConvocatoriaAreaOrganica;
	private Integer idAreaOrganica;
	
	private Integer idTipoProfesion;
	private Integer idCategoriaAnp;
	
	private String nom_tabla_estado;
	
	private String nombre_tabla;
	
	private String fileUploadFileName;
	
	
	
	private Integer idFuenteFinanciamiento;
    private Integer intCodGenericaGasto;
	private Integer idMetaFuenteGenerica;
	private Integer idReq;
	private Integer idArea;
	private Integer idAreaNatural;
	private Integer idAreaNaturalReq;

	private Integer int_cod_refer_tablatipo;
	private Integer int_id_tipo_concepto;
	private Integer int_id_subtipo_concepto;
	private Integer srl_id_convocatoria;
	private Integer int_num_activacion;
	private Integer int_anio;
	private Integer int_id_estado;

	private Integer idpersonal;
	private Integer srl_id_concepto_planilla;
	private Integer srl_id_anio_planilla;
	private Integer srl_id_afp;
	private Integer srl_id_etapa_proceso_seleccion;
	private Integer srl_id_generica_gasto;
	private Integer srl_id_conv_area_org;
	private Integer srl_id_regimen_contractual;
	
	private Integer idarea;
	private Integer idunidad;
	
	private Integer int_id_periodo_mes;
	
	private Integer int_sede_prestacion;
	
	@SuppressWarnings("rawtypes")
	private List listaRegimenContractual;
	
	@SuppressWarnings("rawtypes")
	private List listaRegimenPensionario;
	
	@SuppressWarnings("rawtypes")
	private List listaCargo;
	
	@SuppressWarnings("rawtypes")
	private List listaNombresPersonal;

	private Integer srl_id_unidad_operativa;
	
	//Begin JRaffo 20/03/2016
	private Integer idtipodocumento;
	private String numerodoc;
	private String fechanacimiento;
	
	public String buscarPostulante(){
		
		BuscarPostulanteQueryCriteria criteria = new BuscarPostulanteQueryCriteria();
		criteria.setIdtipodocumento(idtipodocumento);
		criteria.setNumerodoc(numerodoc);
		criteria.setFechanacimiento(fechanacimiento);
		
		listResult = commonServiceMybatis.getListByQuery(BuscarPostulanteQueryMapper.class, criteria);
		
		if(!listResult.isEmpty()){
			result = listResult.get(0);
		}else{
			result = null;
		}
		
		return SUCCESS;
	}
	//End JRaffo 20/03/2016
	public String obtenerValoresPais(){
		listResult = commonService.obtenerValoresPais();
		
		return SUCCESS;
	}

	public String obtenerValoresNivelEstudio(){
		listResult = commonService.obtenerValoresNivelEstudio();
		
		return SUCCESS;
	}
	
	public String obtenerValoresTablaTipo(){
		listResult = commonService.obtenerValoresTablaTipo(idTablaTipo);
		
		return SUCCESS;
	}
	
	public String obtenerValoresTablaTipoPorNombre(){
		
		/*ADD David 31-08-2015 	: 	OBTENER TIPOS DE EVALUACION*/
		if(codIntTablaTipo != null && codIntTablaTipo == -1){
			
			List<Integer> val			= new ArrayList<Integer>();
			val.add(2);
			val.add(3);
			listResult = commonService.obtenerValoresTablaTipo(57,val);
			
		}else{
			/*END*/
			listResult = commonService.obtenerValoresTablaTipo(nombre_tabla);
		}
		
		return SUCCESS;
	}
	
	public String obtenerValoresTablaTipoLic(){
		listResult = commonService.obtenerValoresTablaTipo(idTablaTipo,codIntTablaTipo);
		
		return SUCCESS;
	}
	
	public String obtenerDepartamentosUbigeo(){
		listResult = commonService.obtenerDepartamentosUbigeo();
		
		return SUCCESS;
	}
	
	public String obtenerProvinciaUbigeo(){
		listResult = commonService.obtenerProvinciaUbigeo(idDepartamento);
		
		return SUCCESS;
	}
	
	public String obtenerDistritoUbigeo(){
		listResult = commonService.obtenerDistritoUbigeo(idDepartamento, idProvincia);
		
		return SUCCESS;
	}
	
	public String obtenerConvocatorias(){
		
		ConvocatoriaDisponibleQueryCriteria criteria = new ConvocatoriaDisponibleQueryCriteria();
		criteria.setInt_id_estado(Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO);
		
		
		listResult = commonService.obtenerConvocatoriasDisponibles(criteria);		
		return SUCCESS;
	}
	
	public String obtenerCodigosPostulacion(){
		
		CodigoPostulacionDisponibleQueryCriteria criteria = new CodigoPostulacionDisponibleQueryCriteria();
		criteria.setInt_id_estado(Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO);
		criteria.setSrl_id_convocatoria(idConvocatoria);
		
		listResult = commonService.obtenerCodigoPostulacionesDisponibles(criteria);		
		return SUCCESS;
		
	}
	
	public String obtenerCodigosPostulacionSinResponsable(){

		TConvocatoriaAreaOrgExample tConvocatoriaAreaOrgExample = new TConvocatoriaAreaOrgExample();
		tConvocatoriaAreaOrgExample.createCriteria().andSrl_id_convocatoriaEqualTo(idConvocatoria).andIdpersonalIsNull();

		listResult = commonServiceMybatis.selectByExample(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgExample);
		return SUCCESS;

	}
	
	public String obtenerNumeroConvocatoria(){
				
		result = commonService.obtenerSecuencia(Tablas.T_CONVOCATORIA,false,false);		
		return SUCCESS;
		
	}
	
	public String obtenerAreasOrganicas(){
		
		AreaOrganicaQueryCriteria criteria = new AreaOrganicaQueryCriteria();
		
		listResult = commonService.selectByCriteria(AreaOrganicaQueryMapper.class, criteria);
		return SUCCESS;
		
	}
	
	/* Begin Alanmar 25/03/2015 */
	
	public String obtenerNumeroRequerimiento(){
		
		result = commonService.obtenerSecuencia(Tablas.T_REQUERIMIENTO, false, false);
		
		return SUCCESS;
	}
	
	public String listarAreaOrganica(){
		
		AreaorganicaExample example = new AreaorganicaExample();
		example.setOrderByClause("idarea");
		listResult = commonService.selectByExample(AreaorganicaMapper.class, example);
		return SUCCESS;
	}
	
	public String listarMetaPresupuestaria(){
		
		TMetaPresupuestariaExample example = new TMetaPresupuestariaExample();
		listResult = commonService.selectByExample(TMetaPresupuestariaMapper.class, example);
		return SUCCESS;
	}
	
	public String listarFuenteFinanciamiento(){
		
		TFuenteFinanciamientoExample example = new TFuenteFinanciamientoExample();
		example.setOrderByClause("srl_id_fuente_financiamiento");
		listResult = commonService.selectByExample(TFuenteFinanciamientoMapper.class, example);
		return SUCCESS;
	}
	
	public String obtenerRequerimientoDisponible(){
		
		RequerimientoDisponibleQueryCriteria reqDisponibleQueryCriteria = new RequerimientoDisponibleQueryCriteria();
		reqDisponibleQueryCriteria.setInt_id_estado(Estados.CODIGO_REQUERIMIENTO_EN_PROCESO);
		
		listResult = commonServiceMybatis.getListByQuery(RequerimientoDisponibleQueryMapper.class, reqDisponibleQueryCriteria);
		return SUCCESS;
	}
	

	public ObtenerMetaFuenteGenericaQuery obtenerMetaFuenteGenerica(Integer idMetaFuenteGenerica)
			throws BusinessException {
        
		ObtenerMetaFuenteGenericaQueryCriteria criteria = new ObtenerMetaFuenteGenericaQueryCriteria();
		criteria.setSrl_id_meta_fuente_generica(idMetaFuenteGenerica);
		
		List<ObtenerMetaFuenteGenericaQuery> list = commonService.selectByCriteria(ObtenerMetaFuenteGenericaQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	public String listarFactorEvaluacion(){
		
		TConfiguracionFactorEvaluacionExample example = new TConfiguracionFactorEvaluacionExample();
		listResult = commonService.selectByExample(TConfiguracionFactorEvaluacionMapper.class, example);
		
		return SUCCESS;
	}
	
	public String detalleRequerimientoPlaza(){
		
		ObtenerDatosReqPlazaQueryCriteria criteria = new ObtenerDatosReqPlazaQueryCriteria();
		criteria.setInt_id_estado(1);
		criteria.setSrl_id_requerimiento_personal(idReq);
		criteria.setSrl_id_convocatoria(srl_id_convocatoria);
		
		System.out.println("idReq --> " + idReq);
		
		System.out.println("srl_id_convocatoria --> " + srl_id_convocatoria);
		
		listResult = commonServiceMybatis.getListByQuery(ObtenerDatosReqPlazaQueryMapper.class, criteria);
		
		List<ObtenerDatosReqPlazaQuery> j = listResult;
		
		for(ObtenerDatosReqPlazaQuery x : j){
			System.out.println(x.getDte_fec_aprobacion_oa());
		}

		return SUCCESS;
	}
	
    public String detalleRequerimientoAreaOrganica(){
		
    	ObtenerDatosReqAreaOrgQueryCriteria criteria = new ObtenerDatosReqAreaOrgQueryCriteria();
		criteria.setInt_id_estado(1);
		criteria.setIdarea(idArea);
		
		listResult = commonServiceMybatis.getListByQuery(ObtenerDatosReqAreaOrgQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	
	
	/* End Alanmar 25/03/2015 */
	
	public String buscarExistenciaEmail(){
		registrado = commonService.buscarExistenciaEmail(email.toUpperCase(),idPostulante);		
		return SUCCESS;
	}
	
	public String buscarExistenciaNumeroRuc(){
		registrado = commonService.buscarExistenciaNumeroRuc(numeroRuc,idPersona);		
		return SUCCESS;
	}
	
	public String buscarExistenciaTipoNumeroDocIdentidad(){
		registrado = commonService.buscarExistenciaTipoNumeroDocIdentidad(idTipoDoc,numeroDoc,idPersonaNatural);		
		return SUCCESS;	
	}

	public String buscarExistenciaPostulanteConCodPostulacion(){
		registrado = commonService.buscarExistenciaPostulanteConCodPostulacion(idPostulanteConvocatoriaAreaOrganica, idPostulante);
		return SUCCESS;
	}
	
	public String obtenerConvocatoriasRegistradas(){
		listResult = commonService.obtenerConvocatoriasRegistradas(idPersona);
		return SUCCESS;
	}
	
	public String obtenerInfoVacantes(){
		result = gestionarConvocatoriaService.obtenerInfoVacantes(idConvocatoriaAreaOrganica, idPostulanteConvocatoriaAreaOrganica);
		return SUCCESS;
	}
	
	public String obtenerEstadoPersonal(){
		result = commonService.obtenerEstadoPersonal(idPersonaNatural);
		return SUCCESS;
	}
	
	public String obtenerUnidadOperativa(){
		
		if(idAreaOrganica != null){
			
			UnidadoperativaExample example = new UnidadoperativaExample();
			System.out.println("obtenerUnidadOperativa - idAreaOrganica --> " + idAreaOrganica);
			example.createCriteria().andIdareaEqualTo(idAreaOrganica);
			listResult = commonService.selectByExample(UnidadoperativaMapper.class, example);	
		}
		
		return SUCCESS;
	}
	
	public String obtenerEstados(){
		
		EstadoQueryCriteria estadoQueryCriteria = new EstadoQueryCriteria();
		estadoQueryCriteria.setVar_nombre_tabla(nom_tabla_estado);
		
		listResult = commonServiceMybatis.getListByQuery(EstadoQueryMapper.class, estadoQueryCriteria);
		
		return SUCCESS;
	}
	
	public String obtenerEstadoConvocatoria(){
		
		EstadoQueryCriteria criteria = new EstadoQueryCriteria();
		criteria.setVar_nombre_tabla("t_convocatoria");
		
		listResult = commonServiceMybatis.getListByQuery(EstadoQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
    public String obtenerEstadoPlaza(){
		
    	EstadoQueryCriteria criteria = new EstadoQueryCriteria();
		criteria.setVar_nombre_tabla("t_convocatoria_area_org");
		
		listResult = commonServiceMybatis.getListByQuery(EstadoQueryMapper.class, criteria);
		return SUCCESS;
	}
    
//    public String obtenerSedexAreaOrganica(){
//    	
//    	obtenerSedexAreaOrganicaQueryCriteria criteria = new obtenerSedexAreaOrganicaQueryCriteria();
//    	
//		criteria.setIdarea(idAreaNatural);
//    	
//    	listResult = commonServiceMybatis.getListByQuery(obtenerSedexAreaOrganicaQueryMapper.class, criteria);
//    	
//    	return SUCCESS;
//    }
    
    public String listarCategoriaAnp(){
    	
    	listResult = commonServiceMybatis.selectAll(CategoriaanpMapper.class);
    	
    	return SUCCESS;
    }
    
//    public String obtenerRequerimientoxAreaNatural(){
//    	
//    	obtenerRequerimientoxAreaNaturalQueryCriteria criteria = new obtenerRequerimientoxAreaNaturalQueryCriteria();
//    	criteria.setIdareanatural(idAreaNaturalReq);
//    	criteria.setInt_id_estado(Estados.ESTADO_GENERICO_ACTIVO);
//    	
//    	listResult = commonServiceMybatis.getListByQuery(obtenerRequerimientoxAreaNaturalQueryMapper.class, criteria);
//    	
//    	    	
//    	return SUCCESS;
//    }
    
//    public String obtenerAreaOrganicaxAreaNatural(){
//   
//    	obtenerAreaOrganicaxAreaNaturalQueryCriteria criteria = new obtenerAreaOrganicaxAreaNaturalQueryCriteria();
//    	criteria.setIdarea(idAreaNatural);
//    	
//    	listResult = commonServiceMybatis.getListByQuery(obtenerAreaOrganicaxAreaNaturalQueryMapper.class, criteria);
//    	
//    	return SUCCESS;
//    }
    
    
	/*cambio alanmar 1118 06082014*/
	
	public String obtenerGrupoOcupacional(){
		
		listResult = commonService.obtenerGrupoOcupacional();
		return SUCCESS;
	}

	public String obtenerRegimenPensionario(){
		
		listResult = commonService.obtenerRegimenPensionario();
		return SUCCESS;
	}
	
	public String obtenerRegimenContractual(){
		
		listResult = commonService.obtenerRegimenContractual();
		return SUCCESS;
	}
	
	public String obtenerEntidadBancaria(){
		
		listResult = commonService.obtenerEntidadBancaria();
		return SUCCESS;
	}
	
	public String obtenerProfesion(){
		
		listResult = commonService.obtenerProfesion(idTipoProfesion);
		return SUCCESS;
	}
	
	public String obtenerTipoProfesion(){
		
		listResult = commonService.obtenerTipoProfesion();
		return SUCCESS;
	}
	
	public String obtenerAreaNatural(){
		
		listResult = commonService.obtenerAreaNatural(idCategoriaAnp);
		return SUCCESS;
	}
	
	public String obtenerCargo(){
		
		listResult = commonService.obtenerCargo();
		return SUCCESS;
	}
	/*fin cambio*/
	
	
//	Begin JRaffo 07/03/2015
	public String obtenerValoresTablaTipoPorRefer(){

		TablaTipoReferQueryCriteria criteria = new TablaTipoReferQueryCriteria();
		criteria.setDestabla(nombre_tabla);
		criteria.setInt_cod_refer_tablatipo(int_cod_refer_tablatipo);

		listResult = commonServiceMybatis.getListByQuery(TablaTipoReferQueryMapper.class, criteria);

		return SUCCESS;
	}


	public String obtenerListaAfp() {

		TAfpExample example = new TAfpExample();
		example.createCriteria().andInt_id_estadoEqualTo(1);
		example.setOrderByClause("var_cod_afp");

		listResult = commonServiceMybatis.selectByExample(TAfpMapper.class,example);

		return SUCCESS;
	}

	public String obtenerListaConcepto() {

		TConceptoPlanillaExample example = new TConceptoPlanillaExample();
		example.createCriteria().
		andInt_id_tipo_conceptoEqualTo(int_id_tipo_concepto).
		andInt_id_sub_tipo_conceptoEqualTo(int_id_subtipo_concepto);

		listResult = commonServiceMybatis.selectByExample(TConceptoPlanillaMapper.class,example);

		return SUCCESS;
	}

	public String obtenerListaPersonal() {

		ListaPersonalQueryCriteria criteria = new ListaPersonalQueryCriteria();

		listResult = commonServiceMybatis.getListByQuery(ListaPersonalQueryMapper.class, criteria);

		return SUCCESS;
	}

	public String obtenerListaLanzamientoConvocatoria() {

		ListaLanzamientoConvocatoriaQueryCriteria criteria = new ListaLanzamientoConvocatoriaQueryCriteria();
		criteria.setSrl_id_convocatoria(srl_id_convocatoria);

		listResult = commonServiceMybatis.getListByQuery(ListaLanzamientoConvocatoriaQueryMapper.class, criteria);

		return SUCCESS;
	}

	public String obtenerListaCodPostulacionPorLanzamiento() {

		ListaCodigoPostulacionQueryCriteria criteria = new ListaCodigoPostulacionQueryCriteria();
		criteria.setSrl_id_convocatoria(srl_id_convocatoria);
		criteria.setInt_num_activacion(int_num_activacion);

		listResult = commonServiceMybatis.getListByQuery(ListaCodigoPostulacionQueryMapper.class, criteria);

		return SUCCESS;
	}

	public String obtenerPeriodosPorAnio(){
		
		ObtenerPeriodosPorAnioQueryCriteria criteria = new  ObtenerPeriodosPorAnioQueryCriteria();
		criteria.setInt_anio(int_anio);
		if(int_id_estado != null){
			criteria.setInt_id_estado(int_id_estado);
		}
		
		listResult = commonServiceMybatis.getListByQuery(ObtenerPeriodosPorAnioQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	public String listaBeneficiariosPorPersonal(){
		
		TBeneficiarioDescuentoJudicialExample example = new TBeneficiarioDescuentoJudicialExample();
		example.createCriteria().andIdpersonalEqualTo(idpersonal);
		
		listResult = commonServiceMybatis.selectByExample(TBeneficiarioDescuentoJudicialMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerConceptoPlanilla(){
		
		TConceptoPlanillaExample example = new TConceptoPlanillaExample();
		example.createCriteria().andSrl_id_concepto_planillaEqualTo(srl_id_concepto_planilla);
		
		listResult = commonServiceMybatis.selectByExample(TConceptoPlanillaMapper.class, example);
		
		if(!listResult.isEmpty()){
			result = listResult.get(0);
			listResult = null;
		}
		
		return SUCCESS;
	}
	
	public String obtenerAniosPlanilla(){
		
		TAnioPlanillaExample tAnioPlanillaExample = new TAnioPlanillaExample();
		tAnioPlanillaExample.createCriteria().andInt_id_estadoEqualTo(1);
		
		listResult = commonServiceMybatis.selectByExample(TAnioPlanillaMapper.class, tAnioPlanillaExample);
		
		return SUCCESS;
	}
	
	public String obtenerTodosAniosPlanilla(){
		
		TAnioPlanillaExample tAnioPlanillaExample = new TAnioPlanillaExample();
		
		listResult = commonServiceMybatis.selectByExample(TAnioPlanillaMapper.class, tAnioPlanillaExample);
		
		return SUCCESS;
	}
	
	public String obtenerMetaPorPeriodo(){
		
		TAnioMetaExample tAnioMetaExample = new TAnioMetaExample();
		tAnioMetaExample.createCriteria().andSrl_id_anio_planillaEqualTo(srl_id_anio_planilla);
		
		listResult = commonServiceMybatis.selectByExample(TAnioMetaMapper.class, tAnioMetaExample);
		
		return SUCCESS;
	}
	
	public String obtenerMeta(){
		
		TAnioMetaExample tAnioMetaExample = new TAnioMetaExample();
		tAnioMetaExample.createCriteria().andSrl_id_anio_planillaEqualTo(srl_id_anio_planilla);
		
		listResult = commonServiceMybatis.selectByExample(TAnioMetaMapper.class, tAnioMetaExample);
		
		return SUCCESS;
	}
	
	public String obtenerMetaPorAreaAnho(){
		
		ObtenerMetaPorAreaAnhoQueryCriteria criteria = new ObtenerMetaPorAreaAnhoQueryCriteria();
		criteria.setIdarea(idarea);
		criteria.setIdunidad(idunidad);
		criteria.setSrl_id_anio_planilla(srl_id_anio_planilla);
		
		System.out.println("idarea --> " +idarea );
		System.out.println("idunidad --> " +idunidad);
		System.out.println("srl_id_anio_planilla --> " +srl_id_anio_planilla);
		
		
		listResult = commonServiceMybatis.getListByQuery(ObtenerMetaPorAreaAnhoQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	public String obtenerListaPersonalPlanilla(){
		
		GestionarAsignarConceptoQueryCriteria criteria = new GestionarAsignarConceptoQueryCriteria();
		criteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
		listResult = commonServiceMybatis.getListByQuery(GestionarAsignarConceptoQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	public String obtenerListaRegimenPensionario(){
		
		TRegimenPensionarioExample tRegimenPensionarioExample = new TRegimenPensionarioExample();
		
		listResult = commonServiceMybatis.selectByExample(TRegimenPensionarioMapper.class, tRegimenPensionarioExample);
		
		return SUCCESS;
	}
	
	public String obtenerListaFactorEvaluacionPadre(){
		
		FactorEvaluacionPadreQueryCriteria criteria = new FactorEvaluacionPadreQueryCriteria();
		listResult = commonServiceMybatis.getListByQuery(FactorEvaluacionPadreQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	public String obtenerListaEtapa(){
		
		TEtapaProcesoSeleccionExample example = new TEtapaProcesoSeleccionExample();
		example.createCriteria().andInt_id_estadoEqualTo(1);
		listResult = commonServiceMybatis.selectByExample(TEtapaProcesoSeleccionMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerListaSubEtapa(){
		
		TSubetapaProcesoSeleccionExample example = new TSubetapaProcesoSeleccionExample();
		example.createCriteria().andInt_id_estadoEqualTo(1).andSrl_id_etapa_proceso_seleccionEqualTo(srl_id_etapa_proceso_seleccion);
		listResult = commonServiceMybatis.selectByExample(TSubetapaProcesoSeleccionMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerListaMetaPresupuestaria(){
		
		TMetaPresupuestariaExample example = new TMetaPresupuestariaExample();
		example.createCriteria().andInt_id_estadoEqualTo(0);
		
		listResult = commonServiceMybatis.selectByExample(TMetaPresupuestariaMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerListaFuenteFinanciamiento(){
		
		TFuenteFinanciamientoExample example = new TFuenteFinanciamientoExample();
		example.createCriteria().andInt_id_estadoEqualTo(1);
		
		listResult = commonServiceMybatis.selectByExample(TFuenteFinanciamientoMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerListaGenericaGasto(){
		
		TGenericaGastoExample example = new TGenericaGastoExample();
		listResult = commonServiceMybatis.selectByExample(TGenericaGastoMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerListaClasificador(){
		
		TClasificadorExample example = new TClasificadorExample();
		example.createCriteria().andInt_id_estadoEqualTo(1).andSrl_id_generica_gastoEqualTo(srl_id_generica_gasto);
		
		listResult = commonServiceMybatis.selectByExample(TClasificadorMapper.class, example);
		
		return SUCCESS;
	}
	
	public String obtenerListaSubEtapaPorEtapaPorPlaza(){
		
		SubEtapaPorPlazaQueryCriteria criteria = new SubEtapaPorPlazaQueryCriteria();
		criteria.setSrl_id_conv_area_org(srl_id_conv_area_org);
		criteria.setSrl_id_etapa_proceso_seleccion(srl_id_etapa_proceso_seleccion);
		
		listResult = commonServiceMybatis.getListByQuery(SubEtapaPorPlazaQueryMapper.class,criteria);
		
		return SUCCESS;
	}
	
	public String obtenerListaConfEtapas(){
		
		listResult = commonServiceMybatis.selectAll(TConfiguracionEvaluacionPersonalMapper.class);

		return SUCCESS;
	}
	
	public String obtenerEstadosPostulantes(){
		
		EstadosPostulantesAprobadosQueryCriteria criteria = new EstadosPostulantesAprobadosQueryCriteria();
		
		listResult = commonServiceMybatis.getListByQuery(EstadosPostulantesAprobadosQueryMapper.class, criteria);

		return SUCCESS;
	}
	
	public String obtenerFuentesFinanciamiento(){
		
		TFuenteFinanciamientoExample example = new TFuenteFinanciamientoExample();
		
		listResult = commonServiceMybatis.selectByExample(TFuenteFinanciamientoMapper.class, example);

		return SUCCESS;
	}
		
	//	DGonzales 14/03/2015
	public String obtenerParametrosPlanilla(){

		TParametroPlanillaExample example = new TParametroPlanillaExample();
		listResult = commonServiceMybatis.selectByExample(TParametroPlanillaMapper.class, example);
		return SUCCESS;
	
	}
	
	//	DGonzales 20/05/2015 
	
	public String listarCategoriaAreaNatural(){

		CategoriaanpExample example = new CategoriaanpExample();
		listResult = commonServiceMybatis.selectByExample(CategoriaanpMapper.class, example);
	
		return SUCCESS;
	}
	
	
	public String listarAreaNatural(){

		AreanaturalExample example = new AreanaturalExample();
		listResult = commonServiceMybatis.selectByExample(AreanaturalMapper.class, example);
	
		return SUCCESS;
	}
	
	
	//End DGonzalesc
	
    //	 Begin Alanmar 08/07/2015 
	public String listarMenuReportes(){
		
		MenuReportesQueryCriteria criteria = new MenuReportesQueryCriteria();
		criteria.setNiveldependemodulo(232);
		
		listResult = commonServiceMybatis.getListByQuery(MenuReportesQueryMapper.class, criteria);
		
//		listaRegimenContractual = commonService.obtenerRegimenContractual();
//		
//		listaRegimenPensionario = commonService.obtenerRegimenPensionario();
//		
//		listaCargo = commonService.obtenerCargo();
		
		return SUCCESS;
	}
	
	public String obtenerNombresPersonal(){
		
		ObtenerNombresPersonalQueryCriteria criteriaNombres = new ObtenerNombresPersonalQueryCriteria();
		criteriaNombres.setInt_anio(int_anio);
		criteriaNombres.setInt_id_periodo_mes(int_id_periodo_mes);
		criteriaNombres.setNombre_completo(null);
		
		listResult = commonServiceMybatis.getListByQuery(ObtenerNombresPersonalQueryMapper.class, criteriaNombres);
		
		return SUCCESS;
	}
	
	public String obtenerDescuentoConcepto(){
		
		listarDescuentoConceptoQueryCriteria criteriaConcepto = new listarDescuentoConceptoQueryCriteria();
		criteriaConcepto.setInt_anio(int_anio);
		criteriaConcepto.setInt_id_periodo_mes(int_id_periodo_mes);
		
		
		listResult = commonServiceMybatis.getListByQuery(listarDescuentoConceptoQueryMapper.class, criteriaConcepto);
		
		return SUCCESS;
	}
	
	
	//	 End Alanmar 08/07/2015 
	
	public String obtenerAreaActualPersonal(){
		
		ObtenerAreaActualPersonalQueryCriteria criteria = new ObtenerAreaActualPersonalQueryCriteria();
		criteria.setIdpersonal(idpersonal);
		
		result = commonServiceMybatis.getRecordByQuery(ObtenerAreaActualPersonalQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	public String obtenerListaNumeroConvocatoria(){
				
		listResult = commonServiceMybatis.getListByQuery(NumeroConvocatoriaQueryMapper.class, new NumeroConvocatoriaQueryCriteria());	
		return SUCCESS;
	}
	
	public String obtenerUnidadOperativaGeografica(){
		/*DAVID*/
//		listResult = commonServiceMybatis.selectAll(TUnidadOperativaMapper.class);
		
		return SUCCESS;
	}

	public String obtenerDependenciaSedeAnpGeografica(){
		
		ObtenerDependenciaAnpSedeQueryCriteria criteria = new ObtenerDependenciaAnpSedeQueryCriteria();
		criteria.setSrl_id_unidad_operativa(srl_id_unidad_operativa);
		System.out.println("llegamos ...");
		listResult = commonServiceMybatis.getListByQuery(ObtenerDependenciaAnpSedeQueryMapper.class,criteria);
		
		return SUCCESS;
	}
	
	
	/*DAVID*/
	
	public String obtenerSedePrestaciónServicio(){
		
		AreaOrganicaUnidadOperativaQueryCriteria criteria = new AreaOrganicaUnidadOperativaQueryCriteria();
		criteria.setIdsede(null);
		
		listResult	= commonServiceMybatis.getListByQuery(AreaOrganicaUnidadOperativaQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	
	public String obtenerDireccionDependenciaPrestacionServicio(){
		
		if(int_sede_prestacion != null){
			
			DireccionSedePrestacionQueryCriteria criteria = new DireccionSedePrestacionQueryCriteria();
			criteria.setIdsede(int_sede_prestacion);
			
			listResult = commonServiceMybatis.getListByQuery(DireccionSedePrestacionQueryMapper.class, criteria);
			
			
			if(!listResult.isEmpty()){
				result = listResult.get(0);
				listResult = null;
			}		
			
			
		}
		
		
		
		return SUCCESS;
	}
	
	public String obtenerSedeAdministrativa(){
		
		SedesAdministrativasQueryCriteria criteria = new SedesAdministrativasQueryCriteria();
		criteria.setSrl_id_sede_req_sel(null);
		
		listResult	= commonServiceMybatis.getListByQuery(SedesAdministrativasQueryMapper.class, criteria);
		
		return SUCCESS;
	}
	
	
	/*
	 * GET / SET
	 */
	
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}

	public Integer getIdTipoProfesion() {
		return idTipoProfesion;
	}

	public void setIdTipoProfesion(Integer idTipoProfesion) {
		this.idTipoProfesion = idTipoProfesion;
	}

	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public TransaccionUtil getTransaccionUtil() {
		return transaccionUtil;
	}
	
	public Integer getIdTablaTipo() {
		return idTablaTipo;
	}

	public void setIdTablaTipo(Integer idTablaTipo) {
		this.idTablaTipo = idTablaTipo;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	public Integer getCodIntTablaTipo() {
		return codIntTablaTipo;
	}

	public void setCodIntTablaTipo(Integer codIntTablaTipo) {
		this.codIntTablaTipo = codIntTablaTipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public Integer getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(Integer idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public Integer getRegistrado() {
		return registrado;
	}

	public void setRegistrado(Integer registrado) {
		this.registrado = registrado;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Integer idPostulante) {
		this.idPostulante = idPostulante;
	}

	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public Integer getIdPostulanteConvocatoriaAreaOrganica() {
		return idPostulanteConvocatoriaAreaOrganica;
	}

	public void setIdPostulanteConvocatoriaAreaOrganica(
			Integer idPostulanteConvocatoriaAreaOrganica) {
		this.idPostulanteConvocatoriaAreaOrganica = idPostulanteConvocatoriaAreaOrganica;
	}

	public Integer getIdConvocatoriaAreaOrganica() {
		return idConvocatoriaAreaOrganica;
	}

	public void setIdConvocatoriaAreaOrganica(Integer idConvocatoriaAreaOrganica) {
		this.idConvocatoriaAreaOrganica = idConvocatoriaAreaOrganica;
	}

	public Integer getIdAreaOrganica() {
		return idAreaOrganica;
	}

	public void setIdAreaOrganica(Integer idAreaOrganica) {
		this.idAreaOrganica = idAreaOrganica;
	}

	public Integer getIdCategoriaAnp() {
		return idCategoriaAnp;
	}

	public void setIdCategoriaAnp(Integer idCategoriaAnp) {
		this.idCategoriaAnp = idCategoriaAnp;
	}

	public String getNom_tabla_estado() {
		return nom_tabla_estado;
	}

	public void setNom_tabla_estado(String nom_tabla_estado) {
		this.nom_tabla_estado = nom_tabla_estado;
	}

	public String getNombre_tabla() {
		return nombre_tabla;
	}

	public void setNombre_tabla(String nombre_tabla) {
		this.nombre_tabla = nombre_tabla;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public Integer getIntCodGenericaGasto() {
		return intCodGenericaGasto;
	}

	public void setIntCodGenericaGasto(Integer intCodGenericaGasto) {
		this.intCodGenericaGasto = intCodGenericaGasto;
	}
	
	public Integer getIdFuenteFinanciamiento() {
		return idFuenteFinanciamiento;
	}

	public void setIdFuenteFinanciamiento(Integer idFuenteFinanciamiento) {
		this.idFuenteFinanciamiento = idFuenteFinanciamiento;
	}

	public Integer getIdMetaFuenteGenerica() {
		return idMetaFuenteGenerica;
	}

	public void setIdMetaFuenteGenerica(Integer idMetaFuenteGenerica) {
		this.idMetaFuenteGenerica = idMetaFuenteGenerica;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}
	public Integer getInt_cod_refer_tablatipo() {
		return int_cod_refer_tablatipo;
	}

	public void setInt_cod_refer_tablatipo(Integer int_cod_refer_tablatipo) {
		this.int_cod_refer_tablatipo = int_cod_refer_tablatipo;
	}

	public Integer getSrl_id_convocatoria() {
		return srl_id_convocatoria;
	}

	public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
		this.srl_id_convocatoria = srl_id_convocatoria;
	}

	public Integer getInt_num_activacion() {
		return int_num_activacion;
	}

	public void setInt_num_activacion(Integer int_num_activacion) {
		this.int_num_activacion = int_num_activacion;
	}

	public Integer getInt_anio() {
		return int_anio;
	}

	public void setInt_anio(Integer int_anio) {
		this.int_anio = int_anio;
	}

public Integer getInt_id_tipo_concepto() {
		return int_id_tipo_concepto;
	}

	public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) {
		this.int_id_tipo_concepto = int_id_tipo_concepto;
	}

	public Integer getInt_id_subtipo_concepto() {
		return int_id_subtipo_concepto;
	}

	public void setInt_id_subtipo_concepto(Integer int_id_subtipo_concepto) {
		this.int_id_subtipo_concepto = int_id_subtipo_concepto;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getSrl_id_concepto_planilla() {
		return srl_id_concepto_planilla;
	}

	public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
		this.srl_id_concepto_planilla = srl_id_concepto_planilla;
	}

	public Integer getSrl_id_anio_planilla() {
		return srl_id_anio_planilla;
	}

	public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
		this.srl_id_anio_planilla = srl_id_anio_planilla;
	}

	public Integer getSrl_id_afp() {
		return srl_id_afp;
	}

	public void setSrl_id_afp(Integer srl_id_afp) {
		this.srl_id_afp = srl_id_afp;
	}

	public Integer getSrl_id_etapa_proceso_seleccion() {
		return srl_id_etapa_proceso_seleccion;
	}

	public void setSrl_id_etapa_proceso_seleccion(
			Integer srl_id_etapa_proceso_seleccion) {
		this.srl_id_etapa_proceso_seleccion = srl_id_etapa_proceso_seleccion;
	}

	public Integer getSrl_id_generica_gasto() {
		return srl_id_generica_gasto;
	}

	public void setSrl_id_generica_gasto(Integer srl_id_generica_gasto) {
		this.srl_id_generica_gasto = srl_id_generica_gasto;
	}

	public Integer getSrl_id_conv_area_org() {
		return srl_id_conv_area_org;
	}

	public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
		this.srl_id_conv_area_org = srl_id_conv_area_org;
	}
	
	
	public Integer getIdReq() {
		return idReq;
	}

	public void setIdReq(Integer idReq) {
		this.idReq = idReq;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public Integer getIdAreaNatural() {
		return idAreaNatural;
	}

	public void setIdAreaNatural(Integer idAreaNatural) {
		this.idAreaNatural = idAreaNatural;
	}

	public Integer getIdAreaNaturalReq() {
		return idAreaNaturalReq;
	}

	public void setIdAreaNaturalReq(Integer idAreaNaturalReq) {
		this.idAreaNaturalReq = idAreaNaturalReq;
	}

	public Integer getSrl_id_regimen_contractual() {
		return srl_id_regimen_contractual;
	}

	public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
		this.srl_id_regimen_contractual = srl_id_regimen_contractual;
	}
	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getIdunidad() {
		return idunidad;
	}

	public void setIdunidad(Integer idunidad) {
		this.idunidad = idunidad;
	}

	@SuppressWarnings("rawtypes")
	public List getListaRegimenContractual() {
		return listaRegimenContractual;
	}

	@SuppressWarnings("rawtypes")
	public void setListaRegimenContractual(List listaRegimenContractual) {
		this.listaRegimenContractual = listaRegimenContractual;
	}

	@SuppressWarnings("rawtypes")
	public List getListaRegimenPensionario() {
		return listaRegimenPensionario;
	}

	@SuppressWarnings("rawtypes")
	public void setListaRegimenPensionario(List listaRegimenPensionario) {
		this.listaRegimenPensionario = listaRegimenPensionario;
	}

	@SuppressWarnings("rawtypes")
	public List getListaCargo() {
		return listaCargo;
	}

	@SuppressWarnings("rawtypes")
	public void setListaCargo(List listaCargo) {
		this.listaCargo = listaCargo;
	}

	@SuppressWarnings("rawtypes")
	public List getListaNombresPersonal() {
		return listaNombresPersonal;
	}

	@SuppressWarnings("rawtypes")
	public void setListaNombresPersonal(List listaNombresPersonal) {
		this.listaNombresPersonal = listaNombresPersonal;
	}

	public Integer getInt_id_periodo_mes() {
		return int_id_periodo_mes;
	}

	public void setInt_id_periodo_mes(Integer int_id_periodo_mes) {
		this.int_id_periodo_mes = int_id_periodo_mes;
	}

	public Integer getSrl_id_unidad_operativa() {
		return srl_id_unidad_operativa;
	}

	public void setSrl_id_unidad_operativa(Integer srl_id_unidad_operativa) {
		this.srl_id_unidad_operativa = srl_id_unidad_operativa;
	}

	public Integer getInt_sede_prestacion() {
		return int_sede_prestacion;
	}

	public void setInt_sede_prestacion(Integer int_sede_prestacion) {
		this.int_sede_prestacion = int_sede_prestacion;
	}

	public Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
}
