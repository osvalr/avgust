package sernanp.app.business.core.persona.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.cons.Tablas;
import sernanp.app.business.core.estado.service.EstadoService;
import sernanp.app.business.core.persona.service.GestionarPostulacionService;
import sernanp.app.business.dto.PostulanteDto;
import sernanp.app.business.dto.VacantesDto;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IntrospeccionUtil;

@Service
public class GestionarPostulacionServiceImpl extends GestionarPersonaServiceImpl implements GestionarPostulacionService {

	@Autowired
	TPostulanteCnvAreaOrgMapper tPostulanteCnvAreaOrgMapper;
	
	@Autowired
	TConvocatoriaAreaOrgMapper tConvocatoriaAreaOrgMapper;
	
	@Autowired
	EstadoService estadoService;
	
	@Transactional
	@Override
	public void registrarPostulacion(PostulanteDto dto)	throws BusinessException {
		
		VacantesDto vacantes = gestionarConvocatoriaService.obtenerInfoVacantes(dto.getSrl_id_conv_area_org(), dto.getSrl_id_postulante_conv_area_org());
		if(vacantes.getCantidadDisponibles()<=0){
			throw new BusinessException("Error", "No hay vacantes disponibles para el número de convocatoria y código de postulación seleccionado.");
		}
		
		Integer idPostulante = this.registrarPostulante(dto);
		
		TPostulanteCnvAreaOrg postulanteConvocatoria = IntrospeccionUtil.tranferBean(dto, TPostulanteCnvAreaOrg.class,true);
		postulanteConvocatoria.setInt_id_postulante(idPostulante);
		postulanteConvocatoria.setTsp_fecha_registro(new Date());
		postulanteConvocatoria.setInt_orden_merito(1);
//		postulanteConvocatoria.setInt_num_activacion(gestionarConvocatoriaService.obtenerNumActivacionConvAreaOrg(dto.getSrl_id_conv_area_org()));
		postulanteConvocatoria.setInt_num_activacion(dto.getInt_num_activacion());
		postulanteConvocatoria.setInt_id_estado(Estados.POSTULACION_PERSONA_GANADOR);
		tPostulanteCnvAreaOrgMapper.insertSelective(postulanteConvocatoria);
		
		estadoService.registrarEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, postulanteConvocatoria.getSrl_id_postulante_conv_area_org(), Estados.POSTULACION_PERSONA_GANADOR.toString());
	}
	
	@Transactional
	@Override
	public void actualizarPostulacion(PostulanteDto dto) throws BusinessException {
		
		this.actualizarPostulante(dto);
		
		TPostulanteCnvAreaOrg postulanteConvocatoria = IntrospeccionUtil.tranferBean(dto, TPostulanteCnvAreaOrg.class,true);
		
		VacantesDto vacantes = gestionarConvocatoriaService.obtenerInfoVacantes(dto.getSrl_id_conv_area_org(), dto.getSrl_id_postulante_conv_area_org());
		if(vacantes.getCantidadDisponibles()<=0){
			throw new BusinessException("Error", "No hay vacantes disponibles para el número de convocatoria y código de postulación seleccionado.");
		}
		
		if(dto.getSrl_id_postulante_conv_area_org() == null){
		
			postulanteConvocatoria.setInt_id_postulante(dto.getIdpersonanatural());
			postulanteConvocatoria.setTsp_fecha_registro(new Date());
//			postulanteConvocatoria.setInt_num_activacion(gestionarConvocatoriaService.obtenerNumActivacionConvAreaOrg(dto.getSrl_id_conv_area_org()));
			postulanteConvocatoria.setInt_num_activacion(dto.getInt_num_activacion());
			postulanteConvocatoria.setInt_id_estado(Estados.POSTULACION_PERSONA_GANADOR);
			tPostulanteCnvAreaOrgMapper.insertSelective(postulanteConvocatoria);
			
			estadoService.registrarEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, postulanteConvocatoria.getSrl_id_postulante_conv_area_org(), Estados.POSTULACION_PERSONA_GANADOR.toString());
			
		}else{
						
			
			if(gestionarConvocatoriaService.verificarNumeroConvocatoria(dto.getSrl_id_postulante_conv_area_org(), dto.getSrl_id_convocatoria())){
				ObtenerUltimoEstadoQuery oueq = estadoService.obtenerUltimoEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, dto.getSrl_id_postulante_conv_area_org(), null);
				
				postulanteConvocatoria.setInt_id_estado(dto.getInt_id_estado());
				tPostulanteCnvAreaOrgMapper.updateByPrimaryKeySelective(postulanteConvocatoria);
				
				if(Integer.parseInt(oueq.getVar_cod_estado()) != dto.getInt_id_estado()){
					estadoService.registrarEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, postulanteConvocatoria.getSrl_id_postulante_conv_area_org(), dto.getInt_id_estado().toString());
				}
				
			}else{
				
				if(gestionarConvocatoriaService.obtenerCantidadPostulacionesPorConvocatoria(dto.getIdpersonanatural(),dto.getSrl_id_convocatoria()) > 0){
					throw new BusinessException("Error", "Ya existe un registro de postulación vigente para el número de convocatoria seleccionado.");
				}
				
				postulanteConvocatoria.setInt_id_postulante(dto.getIdpersonanatural());
				postulanteConvocatoria.setTsp_fecha_registro(new Date());
//				postulanteConvocatoria.setInt_num_activacion(gestionarConvocatoriaService.obtenerNumActivacionConvAreaOrg(dto.getSrl_id_conv_area_org()));
				postulanteConvocatoria.setInt_num_activacion(dto.getInt_num_activacion());
				postulanteConvocatoria.setInt_id_estado(Estados.POSTULACION_PERSONA_GANADOR);
				tPostulanteCnvAreaOrgMapper.insertSelective(postulanteConvocatoria);
				
				estadoService.registrarEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, postulanteConvocatoria.getSrl_id_postulante_conv_area_org(), Estados.POSTULACION_PERSONA_GANADOR.toString());
				
			}
						
		}
	}


}
