package sernanp.app.business.core.convocatoria.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.cons.Tablas;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.convocatoria.service.GestionarConvocatoriaService;
import sernanp.app.business.core.estado.service.EstadoService;
import sernanp.app.business.dto.ResultRegistroConvocatoriaDto;
import sernanp.app.business.dto.VacantesDto;
import sernanp.app.dao.domain.TConvocatoria;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgKey;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgExample;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgKey;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TConvocatoriaMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulantePersonalMapper;
import sernanp.app.dao.query.domain.ObtenerCantidadPostulacionesPorConvocatoriaQuery;
import sernanp.app.dao.query.domain.ObtenerCantidadPostulacionesPorConvocatoriaQueryCriteria;
import sernanp.app.dao.query.mapper.ObtenerCantidadPostulacionesPorConvocatoriaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;

@Service
public class GestionarConvocatoriaServiceImpl extends HelperService implements GestionarConvocatoriaService{

	@Autowired
	CommonService commonService;
	
	@Autowired
	TConvocatoriaAreaOrgMapper tConvocatoriaAreaOrgMapper;
		
	@Autowired
	TConvocatoriaMapper tConvocatoriaMapper;
		
	@Autowired
	EstadoService estadoService;
	
	@Autowired
	TPostulantePersonalMapper tPostulantePersonalMapper;
	
	@Autowired
	TPostulanteCnvAreaOrgMapper tPostulanteCnvAreaOrgMapper;
	
	@Autowired
	ObtenerCantidadPostulacionesPorConvocatoriaQueryMapper obtenerCantidadPostulacionesPorConvocatoriaQueryMapper;
	
	@Transactional
	@Override
	public ResultRegistroConvocatoriaDto registrarConvocatoriaConCodPostulacion(Integer idArea, Integer idUnidadOperativa, String codigoPostulacion,Integer cantidadVacantes) throws BusinessException {
		
		ResultRegistroConvocatoriaDto dto = new ResultRegistroConvocatoriaDto();
		String numSecuencia = commonService.obtenerSecuencia(Tablas.T_CONVOCATORIA, true,true);
		
		TConvocatoria cnv = new TConvocatoria();
		cnv.setVar_num_convocatoria(numSecuencia);
		cnv.setInt_id_estado(Estados.CONVOCATORIA_EN_PROCESO);
		cnv.setTsp_fecha_registro(new Date());
		
		tConvocatoriaMapper.insertSelective(cnv);
		
		if(idArea != null && !codigoPostulacion.equals("") && cantidadVacantes.intValue() > 0){
			
			TConvocatoriaAreaOrg cao = new TConvocatoriaAreaOrg();
			cao.setSrl_id_convocatoria(cnv.getSrl_id_convocatoria());
			cao.setVar_codigo_postulacion(codigoPostulacion.toUpperCase());
			cao.setIdarea(idArea);
			cao.setInt_id_estado(Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO);
			cao.setInt_num_puestos(cantidadVacantes);
			cao.setInt_num_activacion(1);
			cao.setIdunidad(idUnidadOperativa);
			cao.setTsp_fecha_registro(new Date());
			tConvocatoriaAreaOrgMapper.insertSelective(cao);
			
			estadoService.registrarEstado(Tablas.T_CONVOCATORIA_AREA_ORG, cao.getSrl_id_conv_area_org(), Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO.toString());
			
			dto.setIdConvocatoria(cnv.getSrl_id_convocatoria());
			dto.setIdConvocatoriaAreaOrganica(cao.getSrl_id_conv_area_org());	
		}

		return dto;
	}

	@Transactional
	@Override
	public Integer registrarCodigoPostulacion(Integer idConvocatoria,Integer idArea,Integer idUnidadOperativa,String codigoPostulacion,Integer cantidadVacantes) throws BusinessException {
		
		TConvocatoriaAreaOrgExample example = new TConvocatoriaAreaOrgExample();
		example.createCriteria().andVar_codigo_postulacionEqualTo(codigoPostulacion).andSrl_id_convocatoriaEqualTo(idConvocatoria).andIdareaEqualTo(idArea);
		
		List<TConvocatoriaAreaOrg> list = tConvocatoriaAreaOrgMapper.selectByExample(example);
		
		if(!list.isEmpty()){
			throw new BusinessException("ERROR", "EL CODIGO DE POSTULACION YA ESTA REGISTRADO.");
		}
						
		TConvocatoriaAreaOrg cao = new TConvocatoriaAreaOrg();
		cao.setSrl_id_convocatoria(idConvocatoria);
		cao.setVar_codigo_postulacion(codigoPostulacion.toUpperCase());
		cao.setIdarea(idArea);
		cao.setInt_id_estado(Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO);
		cao.setInt_num_puestos(cantidadVacantes);
		cao.setInt_num_activacion(1);
		cao.setIdunidad(idUnidadOperativa);
		cao.setTsp_fecha_registro(new Date());
		
		tConvocatoriaAreaOrgMapper.insertSelective(cao);
		
		estadoService.registrarEstado(Tablas.T_CONVOCATORIA_AREA_ORG, cao.getSrl_id_conv_area_org(), Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO.toString());
		
		return cao.getSrl_id_conv_area_org();
		
	}
	
	@Override
	public Integer obtenerNumActivacionConvAreaOrg(Integer idConvAreaOrg){
		Integer numActivacion = null;
		
		TConvocatoriaAreaOrgKey key = new TConvocatoriaAreaOrgKey();
		key.setSrl_id_conv_area_org(idConvAreaOrg);
		
		TConvocatoriaAreaOrg cao = tConvocatoriaAreaOrgMapper.selectByPrimaryKey(key);
		
		numActivacion = cao.getInt_num_activacion();
		
		return numActivacion;
	}
	
	@Override
	public boolean verificarNumeroConvocatoria(Integer idPostulacion, Integer idConv){
		boolean result = false;
		Integer idConvAreaOrg = null;
		
		TPostulanteCnvAreaOrgKey pcaoKey = new TPostulanteCnvAreaOrgKey();
		pcaoKey.setSrl_id_postulante_conv_area_org(idPostulacion);
		
		TPostulanteCnvAreaOrg pcao = tPostulanteCnvAreaOrgMapper.selectByPrimaryKey(pcaoKey);
		
		idConvAreaOrg = pcao.getSrl_id_conv_area_org();
		
		TConvocatoriaAreaOrgKey key = new TConvocatoriaAreaOrgKey();
		key.setSrl_id_conv_area_org(idConvAreaOrg);
		
		TConvocatoriaAreaOrg cao = tConvocatoriaAreaOrgMapper.selectByPrimaryKey(key);
		
		if(idConv.intValue() == cao.getSrl_id_convocatoria().intValue()){
			return true;
		}
		return result;
	}
	
	@Override
	public Integer obtenerCantidadPostulacionesPorConvocatoria(Integer idPostulante, Integer idConv){
		
		ObtenerCantidadPostulacionesPorConvocatoriaQueryCriteria criteria = new ObtenerCantidadPostulacionesPorConvocatoriaQueryCriteria();
		criteria.setInt_id_postulante(idPostulante);
		criteria.setSrl_id_convocatoria(idConv);
		
		List<ObtenerCantidadPostulacionesPorConvocatoriaQuery> list = obtenerCantidadPostulacionesPorConvocatoriaQueryMapper.getListQuery(criteria);
		
		if(!list.isEmpty()){
			return list.get(0).getCount();
		}
		
		return 0;
	}
	
	@Override
	public VacantesDto obtenerInfoVacantes(Integer idConvocatoriaAreaOrganica,Integer idPostulacion) throws BusinessException {
		
		VacantesDto dto = new VacantesDto();
		
		Integer vacantes = null;
		
		if(idPostulacion == null){
			idPostulacion = 0;
		}
			
		TConvocatoriaAreaOrgKey caok = new TConvocatoriaAreaOrgKey();
		caok.setSrl_id_conv_area_org(idConvocatoriaAreaOrganica);
		
		TConvocatoriaAreaOrg cao = tConvocatoriaAreaOrgMapper.selectByPrimaryKey(caok);
		vacantes = cao.getInt_num_puestos();
		
		List<Integer> values = new ArrayList<Integer>();
		values.add(Estados.POSTULACION_PERSONA_GANADOR);
		values.add(Estados.POSTULACION_PERSONA_CONTRATO_SUSCRITO);
		
		Integer registrados = null;
		TPostulanteCnvAreaOrgExample example = new TPostulanteCnvAreaOrgExample();
		example.createCriteria().andSrl_id_conv_area_orgEqualTo(idConvocatoriaAreaOrganica)
		.andInt_id_estadoIn(values)
		.andSrl_id_postulante_conv_area_orgNotEqualTo(idPostulacion);
		
		registrados = tPostulanteCnvAreaOrgMapper.countByExample(example);
		
		Integer ordenMerito = null;
		TPostulanteCnvAreaOrgExample example2 = new TPostulanteCnvAreaOrgExample();
		example2.createCriteria().andSrl_id_conv_area_orgEqualTo(idConvocatoriaAreaOrganica);
		
		ordenMerito = tPostulanteCnvAreaOrgMapper.countByExample(example2);

		dto.setCantidadVacantes(vacantes);
		dto.setCantidadRegistros(registrados);
		dto.setCantidadDisponibles(vacantes-registrados);
		dto.setOrdenMerito(++ordenMerito);
		
		return dto;
	}
}
