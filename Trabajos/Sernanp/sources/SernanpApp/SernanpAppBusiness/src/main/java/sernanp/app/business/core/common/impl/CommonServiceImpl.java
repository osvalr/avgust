package sernanp.app.business.core.common.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.dao.domain.Areanatural;
import sernanp.app.dao.domain.AreanaturalExample;
import sernanp.app.dao.domain.Pais;
import sernanp.app.dao.domain.PersonaExample;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.PersonalExample;
import sernanp.app.dao.domain.PersonanaturalExample;
import sernanp.app.dao.domain.TCargo;
import sernanp.app.dao.domain.TCargoExample;
import sernanp.app.dao.domain.TEntidadBancaria;
import sernanp.app.dao.domain.TGrupoOcupacional;
import sernanp.app.dao.domain.THistorial;
import sernanp.app.dao.domain.THistorialDetalle;
import sernanp.app.dao.domain.THistorialExample;
import sernanp.app.dao.domain.TNivelEstudio;
import sernanp.app.dao.domain.TPostulantePersonalExample;
import sernanp.app.dao.domain.TProfesion;
import sernanp.app.dao.domain.TProfesionExample;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.domain.TRegimenPensionario;
import sernanp.app.dao.domain.TSecuenciaDefinicion;
import sernanp.app.dao.domain.TSecuenciaDefinicionExample;
import sernanp.app.dao.domain.TSecuenciaNumero;
import sernanp.app.dao.domain.TSecuenciaNumeroExample;
import sernanp.app.dao.domain.TTipificacion;
import sernanp.app.dao.domain.TTipoProfesion;
import sernanp.app.dao.domain.Tablatipo;
import sernanp.app.dao.domain.TablatipoExample;
import sernanp.app.dao.domain.Ubigeo;
import sernanp.app.dao.domain.UbigeoExample;
import sernanp.app.dao.mapper.AreanaturalMapper;
import sernanp.app.dao.mapper.PaisMapper;
import sernanp.app.dao.mapper.PersonaMapper;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.PersonanaturalMapper;
import sernanp.app.dao.mapper.SedeMapper;
import sernanp.app.dao.mapper.TCargoMapper;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TEntidadBancariaMapper;
import sernanp.app.dao.mapper.TEstadoPersonalMapper;
import sernanp.app.dao.mapper.TGrupoOcupacionalMapper;
import sernanp.app.dao.mapper.THistorialDetalleMapper;
import sernanp.app.dao.mapper.THistorialMapper;
import sernanp.app.dao.mapper.TMetaFuenteGenericaMapper;
import sernanp.app.dao.mapper.TNivelEstudioMapper;
import sernanp.app.dao.mapper.TParametroPlanillaMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulantePersonalMapper;
import sernanp.app.dao.mapper.TProfesionMapper;
import sernanp.app.dao.mapper.TRegimenContractualMapper;
import sernanp.app.dao.mapper.TRegimenPensionarioMapper;
import sernanp.app.dao.mapper.TRequerimientoPersonalMapper;
import sernanp.app.dao.mapper.TSecuenciaDefinicionMapper;
import sernanp.app.dao.mapper.TSecuenciaNumeroMapper;
import sernanp.app.dao.mapper.TTipificacionMapper;
import sernanp.app.dao.mapper.TTipoProfesionMapper;
import sernanp.app.dao.mapper.TablatipoMapper;
import sernanp.app.dao.mapper.UbigeoMapper;
import sernanp.app.dao.mapper.UnidadoperativaMapper;
import sernanp.app.dao.query.domain.AdendaQuery;
import sernanp.app.dao.query.domain.AdendaQueryCriteria;
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQuery;
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQuery;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaRegistradaQuery;
import sernanp.app.dao.query.domain.ConvocatoriaRegistradaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQueryCriteria;
import sernanp.app.dao.query.domain.TablaTipoQuery;
import sernanp.app.dao.query.domain.TablaTipoQueryCriteria;
import sernanp.app.dao.query.mapper.AdendaQueryMapper;
import sernanp.app.dao.query.mapper.CodigoPostulacionDisponibleQueryMapper;
import sernanp.app.dao.query.mapper.ConvocatoriaDisponibleQueryMapper;
import sernanp.app.dao.query.mapper.ConvocatoriaRegistradaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerSedeAdministrativaAreaOrganicaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerSedeAdministrativaUnidadOperativaQueryMapper;
import sernanp.app.dao.query.mapper.TablaTipoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;

import com.google.gson.Gson;

@Service
public class CommonServiceImpl extends HelperService implements CommonService {

	@Autowired
	TSecuenciaDefinicionMapper tSecuenciaDefinicionMapper;

	@Autowired
	TSecuenciaNumeroMapper tSecuenciaNumeroMapper;

	@Autowired
	THistorialMapper tHistorialMapper;

	@Autowired
	THistorialDetalleMapper tHistorialDetalleMapper;

	@Autowired
	TablatipoMapper tablatipoMapper;

	@Autowired
	UbigeoMapper ubigeoMapper;

	@Autowired
	TNivelEstudioMapper tNivelEstudioMapper;

	@Autowired
	PaisMapper paisMapper;

	@Autowired
	TPostulantePersonalMapper tPostulantePersonalMapper;

	@Autowired
	PersonaMapper personaMapper;

	@Autowired
	PersonanaturalMapper personanaturalMapper;

	@Autowired
	TPostulanteCnvAreaOrgMapper tPostulanteCnvAreaOrgMapper;

	@Autowired
	ConvocatoriaRegistradaQueryMapper convocatoriaRegistradaQueryMapper;

	@Autowired
	PersonalMapper personalMapper;

	@Autowired
	TEstadoPersonalMapper tEstadoPersonalMapper;

	@Autowired
	TConvocatoriaAreaOrgMapper tConvocatoriaAreaOrgMapper;

	@Autowired
	TGrupoOcupacionalMapper tGrupoOcupacionalMapper;

	@Autowired
	TRegimenPensionarioMapper tRegimenPensionarioMapper;

	@Autowired
	TEntidadBancariaMapper tEntidadBancariaMapper;

	@Autowired
	TTipoProfesionMapper tTipoProfesionMapper;

	@Autowired
	TProfesionMapper tProfesionMapper;
	
	@Autowired
	TTipificacionMapper tTipificacionMapper;
	
	@Autowired
	TCargoMapper tCargoMapper;
	
	@Autowired
	AreanaturalMapper areanaturalMapper;
	
	@Autowired
	SedeMapper sedeMapper;
	
	@Autowired
	UnidadoperativaMapper unidadoperativaMapper;
	
    TParametroPlanillaMapper tParametroPlanillaMapper;
	/* Begin Alanmar 15/04/2015 */ 
	
	@Autowired
	TRequerimientoPersonalMapper tRequerimientoPersonalMapper;
	
	@Autowired
	TMetaFuenteGenericaMapper tMetaFuenteGenericaMapper;
	
	/* End Alanmar 15/04/2015 */

	
	
	@Override
	public void registrarHistorial(String codigo, Object recordCambios,
			Object record, String tipoOp, Integer idResponsable,
			String nombreTabla) throws BusinessException {

		THistorialExample example = new THistorialExample();
		example.createCriteria().andVar_codigo_registroEqualTo(codigo)
				.andVar_nombre_tablaEqualTo(nombreTabla);

		List<THistorial> list = tHistorialMapper.selectByExample(example);

		THistorial h = null;

		if (!list.isEmpty()) {
			h = list.get(0);
		}

		if (h != null) {

			h.setVar_valor_json_actual(new Gson().toJson(record));
			tHistorialMapper.updateByPrimaryKeySelective(h);

			THistorialDetalle hd = new THistorialDetalle();
			hd.setVar_codigo_registro(codigo);
			hd.setTsp_fecha_registro(new Date());
			hd.setVar_id_responsable(idResponsable.toString());
			hd.setVar_id_tipo_operacion(tipoOp);
			hd.setVar_valor_json(new Gson().toJson(recordCambios));

			tHistorialDetalleMapper.insertSelective(hd);

		} else {

			h = new THistorial();
			h.setVar_codigo_registro(codigo);
			h.setVar_nombre_tabla(nombreTabla);
			h.setVar_valor_json_actual(new Gson().toJson(record));
			tHistorialMapper.insertSelective(h);

			THistorialDetalle hd = new THistorialDetalle();
			hd.setVar_codigo_registro(codigo);
			hd.setTsp_fecha_registro(new Date());
			hd.setVar_id_responsable(idResponsable.toString());
			hd.setVar_id_tipo_operacion(tipoOp);
			hd.setVar_valor_json(new Gson().toJson(record));

			tHistorialDetalleMapper.insertSelective(hd);
		}

	}

	// @Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Transactional
	@Override
	public String obtenerSecuencia(String nomTabla, boolean save, boolean forma)
			throws BusinessException {

		TSecuenciaDefinicionExample example = new TSecuenciaDefinicionExample();
		example.createCriteria().andVar_nombre_tablaEqualTo(nomTabla);

		List<TSecuenciaDefinicion> list = tSecuenciaDefinicionMapper
				.selectByExample(example);

		TSecuenciaDefinicion secuencia = null;
		String nuevoNumero = null;
		Calendar c = Calendar.getInstance();

		if (!list.isEmpty()) {
			secuencia = list.get(0);
		}

		if (secuencia != null) {

			TSecuenciaNumero secuenciaNumero = null;

			TSecuenciaNumeroExample exampleSn = new TSecuenciaNumeroExample();
			exampleSn.createCriteria().andSrl_id_secuenciaEqualTo(
					secuencia.getSrl_id_secuencia());

			List<TSecuenciaNumero> listSn = tSecuenciaNumeroMapper
					.selectByExample(exampleSn);

			if (!listSn.isEmpty()) {
				secuenciaNumero = listSn.get(0);
			} else {
				secuenciaNumero = new TSecuenciaNumero();
				secuenciaNumero.setSrl_id_secuencia(secuencia
						.getSrl_id_secuencia());
				secuenciaNumero.setVar_numero_secuencia(secuencia
						.getVar_prefijo_secuencia()
						+ "-"
						+ "0"
						+ "-"
						+ c.get(Calendar.YEAR));
			}

			String[] arr = secuenciaNumero.getVar_numero_secuencia().split("-");

			if (c.get(Calendar.YEAR) == Integer.parseInt(arr[2])) {

				Integer numeroDoc = Integer.parseInt(arr[1]);
				numeroDoc++;

				Formatter fmt = new Formatter();
				fmt.format("%04d", numeroDoc);

				nuevoNumero = secuencia.getVar_prefijo_secuencia() + "-"
						+ fmt.toString() + "-" + arr[2];
				fmt.close();

			} else {

				Formatter fmt = new Formatter();
				fmt.format("%04d", 1);

				nuevoNumero = secuencia.getVar_prefijo_secuencia() + "-"
						+ fmt.toString() + "-" + c.get(Calendar.YEAR);
				fmt.close();
			}

			secuenciaNumero.setVar_numero_secuencia(nuevoNumero);

			if (save) {
				if (secuenciaNumero.getSrl_id_sequencia_numero() == null) {
					tSecuenciaNumeroMapper.insertSelective(secuenciaNumero);
				} else {
					tSecuenciaNumeroMapper
							.updateByPrimaryKeySelective(secuenciaNumero);
				}
			}

		} else {

			throw new BusinessException("ERROR:",
					"NO ESTA REGISTRADA LA SECUENCIA PARA LA TABLA: "
							+ nomTabla.toUpperCase() + ".");

		}

		if (forma == false) {
			String seq[] = nuevoNumero.split("-");
			nuevoNumero = secuencia.getVar_descrip_prefijo() + " " + seq[1]
					+ "-" + seq[2];
		}

		return nuevoNumero;
	}

	@Override
	public List<Tablatipo> obtenerValoresTablaTipo(Integer idTabla)
			throws BusinessException {

		TablatipoExample example = new TablatipoExample();

		if (idTabla == 1) {
			example.createCriteria().andIdtablaEqualTo(idTabla)
					.andIdtablatipoEqualTo(1);
		} else {
			example.createCriteria().andIdtablaEqualTo(idTabla);
		}

		List<Tablatipo> list = tablatipoMapper.selectByExample(example);

		return list;
	}

	@Override
	public List<Ubigeo> obtenerDepartamentosUbigeo() throws BusinessException {

		UbigeoExample example = new UbigeoExample();
		example.createCriteria().andCodprovEqualTo("00")
				.andCoddistEqualTo("00");

		return ubigeoMapper.selectByExample(example);
	}

	@Override
	public List<Ubigeo> obtenerProvinciaUbigeo(String idDepartamento) throws BusinessException {

		UbigeoExample example = new UbigeoExample();
		
		if(idDepartamento != null){
			example.createCriteria().andCodprovNotEqualTo("00").andCoddistEqualTo("00").andCoddptoEqualTo(idDepartamento);
			return ubigeoMapper.selectByExample(example);
		}

		return null;
	}

	@Override
	public List<Ubigeo> obtenerDistritoUbigeo(String idDepartamento, String idProvincia) throws BusinessException {

		UbigeoExample example = new UbigeoExample();
		if(idDepartamento != null && idProvincia != null){
			example.createCriteria().andCodprovEqualTo(idProvincia).andCoddistNotEqualTo("00").andCoddptoEqualTo(idDepartamento);
			return ubigeoMapper.selectByExample(example);
		}
		
		return null;
	}

	@Override
	public List<TNivelEstudio> obtenerValoresNivelEstudio()
			throws BusinessException {

		return this.selectAll(TNivelEstudioMapper.class);
	}

	@Override
	public List<Pais> obtenerValoresPais() throws BusinessException {

		return this.selectAll(PaisMapper.class);
	}

	@Override
	public List<Tablatipo> obtenerValoresTablaTipo(Integer idTabla,
			Integer codIntTablaTipo) throws BusinessException {
		TablatipoExample example = new TablatipoExample();
		example.createCriteria().andIdtablaEqualTo(idTabla)
				.andCodinttablatipoEqualTo(codIntTablaTipo);

		List<Tablatipo> list = tablatipoMapper.selectByExample(example);

		return list;
	}

	@Override
	public List<ConvocatoriaDisponibleQuery> obtenerConvocatoriasDisponibles(
			ConvocatoriaDisponibleQueryCriteria criteria)
			throws BusinessException {
		return this.selectByCriteria(ConvocatoriaDisponibleQueryMapper.class,
				criteria);
	}

	@Override
	public List<CodigoPostulacionDisponibleQuery> obtenerCodigoPostulacionesDisponibles(
			CodigoPostulacionDisponibleQueryCriteria criteria)
			throws BusinessException {
		return this.selectByCriteria(
				CodigoPostulacionDisponibleQueryMapper.class, criteria);
	}

	@Override
	public Integer buscarExistenciaEmail(String val, Integer idPostulante)
			throws BusinessException {

		TPostulantePersonalExample example = new TPostulantePersonalExample();
		example.createCriteria()
				.andVar_email_principalEqualTo(val)
				.andInt_id_postulanteNotEqualTo(
						(idPostulante == null) ? 0 : idPostulante);

		Integer count = tPostulantePersonalMapper.countByExample(example);

		return count;
	}

	@Override
	public Integer buscarExistenciaNumeroRuc(String val, Integer idPersona)
			throws BusinessException {

		PersonaExample example = new PersonaExample();
		example.createCriteria().andRucEqualTo(val)
				.andIdpersonaNotEqualTo((idPersona == null) ? 0 : idPersona);

		Integer count = personaMapper.countByExample(example);

		return count;
	}

	@Override
	public Integer buscarExistenciaTipoNumeroDocIdentidad(Integer tipoDoc,
			String numeroDoc, Integer idPersonaNatural)
			throws BusinessException {

		PersonanaturalExample example = new PersonanaturalExample();
		example.createCriteria()
				.andIdtipodocumentoEqualTo(tipoDoc)
				.andNumerodocEqualTo(numeroDoc)
				.andIdpersonanaturalNotEqualTo(
						(idPersonaNatural == null) ? 0 : idPersonaNatural);

		Integer count = personanaturalMapper.countByExample(example);

		return count;
	}

	@Override
	public Integer buscarExistenciaPostulanteConCodPostulacion(
			Integer idPostulanteConvocatoriaAreaOrganica, Integer idPostulante)
			throws BusinessException {

		// TPostulanteCnvAreaOrgExample example = new
		// TPostulanteCnvAreaOrgExample();
		// example.createCriteria().andSrl_id_conv_area_orgEqualTo(idPostulanteConvocatoriaAreaOrganica).andInt_id_estadoEqualTo(ConstantesUtil.POSTULACION_PERSONA_ESTADO_GANADOR).andInt_id_postulanteNotEqualTo((idPostulante==null)?0:idPostulante);
		//
		// Integer count =
		// tPostulanteConvocatoriaAreaOrganicaMapper.countByExample(example);

		return null;
	}

	@Override
	public List<ConvocatoriaRegistradaQuery> obtenerConvocatoriasRegistradas(
			Integer idPersona) throws BusinessException {
		ConvocatoriaRegistradaQueryCriteria criteria = new ConvocatoriaRegistradaQueryCriteria();
		criteria.setIdpersona(idPersona);
		return convocatoriaRegistradaQueryMapper.getListQuery(criteria);
	}

	@Override
	public Integer obtenerEstadoPersonal(Integer idPersonaNatural)
			throws BusinessException {

		Integer estado = Estados.PERSONAL_INACTIVO;

		PersonalExample example = new PersonalExample();
		example.createCriteria().andIdpersonanaturalEqualTo(idPersonaNatural);

		List<Personal> list = personalMapper.selectByExample(example);

		if (!list.isEmpty()) {
			estado = list.get(0).getInt_estado();
		}

		return estado;
	}

	/* alanmar 0143 06082014 */

	@Override
	public List<TGrupoOcupacional> obtenerGrupoOcupacional()
			throws BusinessException {

		return this.selectAll(TGrupoOcupacionalMapper.class);
	}

	@Override
	public List<TRegimenPensionario> obtenerRegimenPensionario()
			throws BusinessException {

		return this.selectAll(TRegimenPensionarioMapper.class);
	}

	@Override
	public List<TRegimenContractual> obtenerRegimenContractual()
			throws BusinessException {

		return this.selectAll(TRegimenContractualMapper.class);
	}
	

	@Override
	public List<TEntidadBancaria> obtenerEntidadBancaria()
			throws BusinessException {
		return this.selectAll(TEntidadBancariaMapper.class);
	}

	@Override
	public List<TTipoProfesion> obtenerTipoProfesion() throws BusinessException {

		return this.selectAll(TTipoProfesionMapper.class);
	}

	@Override
	public List<TProfesion> obtenerProfesion(Integer idTipoProfesion)
			throws BusinessException {

		TProfesionExample example = new TProfesionExample();
		example.createCriteria().andSrl_id_tipo_profesionEqualTo(idTipoProfesion);

		return tProfesionMapper.selectByExample(example);
	}
	
	@Override
	public List<Areanatural> obtenerAreaNatural(Integer idCategoriaAnp)
			throws BusinessException {

	    AreanaturalExample example = new AreanaturalExample();
		example.createCriteria().andIdcategoriaanpEqualTo(idCategoriaAnp);

		return areanaturalMapper.selectByExample(example);
	}
	
	@Override
	public List<TTipificacion> obtenerTipificacion()
			throws BusinessException {

		return this.selectAll(TTipificacionMapper.class);
	}
	
	/* Alanmar se ordena la lista de cargos por el nombre 04022015 */ 
	@Override
	public List<TCargo> obtenerCargo()
			throws BusinessException {
        
		TCargoExample example = new TCargoExample();
		example.createCriteria().andSrl_id_cargoIsNotNull();
		example.setOrderByClause("var_nom_cargo");
		return this.selectByExample(TCargoMapper.class,example);
		
	}

	/* fin alanmar */
	
		
	@Override
	public String obtenerFormatoLargoSecuencia(String nomTabla, String secuencia)
			throws BusinessException {

		TSecuenciaDefinicionExample example = new TSecuenciaDefinicionExample();
		example.createCriteria().andVar_nombre_tablaEqualTo(nomTabla);

		List<TSecuenciaDefinicion> list = tSecuenciaDefinicionMapper
				.selectByExample(example);

		TSecuenciaDefinicion sd = null;

		if (!list.isEmpty()) {
			sd = list.get(0);
		}

		if (sd != null) {
			String[] arr = secuencia.split("-");
			secuencia = sd.getVar_descrip_prefijo() + " " + arr[1] + "-"
					+ arr[2];
		}

		return secuencia;
	}

	@Override
	public String obtenerSecuenciaAdenda(Integer idContrato, Date fechaInicio, boolean formatoLargo) throws BusinessException {

		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaInicio);
		String nuevoNumero;
		String numero, anho, secuencia;

		AdendaQueryCriteria aqc = new AdendaQueryCriteria();
		aqc.setSrl_id_contrato_padre(idContrato);
		List<AdendaQuery> listAq = this.selectByCriteria(AdendaQueryMapper.class, aqc);

		if (!listAq.isEmpty()) {
			AdendaQuery aq = listAq.get(0);
			secuencia = aq.getVar_num_contrato();
		} else {
			secuencia = null;
		}

		if (secuencia == null) {
			numero = "0";
			anho = c.get(Calendar.YEAR) + "";
		} else {
			String[] arr = secuencia.split("-");
			numero = arr[1];
			anho = arr[2];
		}

		if (c2.get(Calendar.YEAR) == Integer.parseInt(anho)) {

			Integer numeroDoc = Integer.parseInt(numero);
			numeroDoc++;

			Formatter fmt = new Formatter();
			fmt.format("%04d", numeroDoc);

			if (formatoLargo) {
				nuevoNumero = "Adenda CAS Nº " + fmt.toString() + "-" + anho;
				fmt.close();
			} else {
				nuevoNumero = "ACAS-" + fmt.toString() + "-" + anho;
				fmt.close();
			}

		} else {

			Formatter fmt = new Formatter();
			fmt.format("%04d", 1);

			if (formatoLargo) {
				nuevoNumero = "Adenda CAS Nº " + fmt.toString() + "-" + c2.get(Calendar.YEAR);
				fmt.close();
			} else {
				nuevoNumero = "ACAS-" + fmt.toString() + "-" + c2.get(Calendar.YEAR);
				fmt.close();
			}

		}

		return nuevoNumero;
	}

	@Override
	public String obtenerFormatoLargoSecuenciaAdenda(String secuencia)
			throws BusinessException {
		String[] arr = secuencia.split("-");
		String nuevoNumero = "Adenda CAS Nº " + arr[1] + "-" + arr[2];
		return nuevoNumero;
	}

	@Override
	public List<TablaTipoQuery> obtenerValoresTablaTipo(String desTabla)throws BusinessException {
		
		TablaTipoQueryCriteria criteria = new TablaTipoQueryCriteria();
		criteria.setDestabla(desTabla);
		
		return this.selectByCriteria(TablaTipoQueryMapper.class, criteria);
	}

	@Override
	public List<Tablatipo> obtenerValoresTablaTipo(Integer idTabla, List<Integer> val) throws BusinessException {
		// TODO Auto-generated method stub
	
		TablatipoExample example = new TablatipoExample();
		example.createCriteria().andIdtablaEqualTo(57).andCodinttablatipoNotIn(val);
		List<Tablatipo> list = tablatipoMapper.selectByExample(example);
		
		return list;
	}	

   
}
