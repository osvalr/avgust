package sernanp.app.business.core.persona.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.convocatoria.service.GestionarConvocatoriaService;
import sernanp.app.business.core.persona.service.GestionarPersonaService;
import sernanp.app.business.dto.PersonalDto;
import sernanp.app.business.dto.PostulanteDto;
import sernanp.app.dao.domain.Persona;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.Personanatural;
import sernanp.app.dao.domain.TDireccionDomicilioHistorial;
import sernanp.app.dao.domain.TDireccionDomicilioHistorialExample;
import sernanp.app.dao.domain.TPersonanaturalFormacion;
import sernanp.app.dao.domain.TPersonanaturalFormacionKey;
import sernanp.app.dao.domain.TPostulantePersonal;
import sernanp.app.dao.domain.TPostulantePersonalExample;
import sernanp.app.dao.domain.TRegimenPensionarioHistorial;
import sernanp.app.dao.mapper.PersonaMapper;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.PersonanaturalMapper;
import sernanp.app.dao.mapper.TDireccionDomicilioHistorialMapper;
import sernanp.app.dao.mapper.TPersonanaturalFormacionMapper;
import sernanp.app.dao.mapper.TPostulantePersonalMapper;
import sernanp.app.dao.mapper.TRegimenPensionarioHistorialMapper;
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQuery;
import sernanp.app.dao.query.domain.UltimaDireccionDomicilioQuery;
import sernanp.app.dao.query.domain.UltimaDireccionDomicilioQueryCriteria;
import sernanp.app.dao.query.domain.UltimoRegimenPensionarioQuery;
import sernanp.app.dao.query.domain.UltimoRegimenPensionarioQueryCriteria;
import sernanp.app.dao.query.mapper.UltimaDireccionDomicilioQueryMapper;
import sernanp.app.dao.query.mapper.UltimoRegimenPensionarioQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;
import sernanp.app.util.IntrospeccionUtil;

@Service
public class GestionarPersonaServiceImpl extends HelperService implements GestionarPersonaService {
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	PersonaMapper personaMapper;
	
	@Autowired
	PersonalMapper personalMapper;
	
	@Autowired
	PersonanaturalMapper personanaturalMapper;
	
	@Autowired
	TPostulantePersonalMapper tPostulantePersonalMapper;
	
	
	@Autowired
	TDireccionDomicilioHistorialMapper TDireccionDomicilioHistorialMapper;	
	
	@Autowired
	GestionarConvocatoriaService gestionarConvocatoriaService;
	
	@Autowired
	TRegimenPensionarioHistorialMapper tRegimenPensionarioHistorialMapper;
	
	@Autowired
	TPersonanaturalFormacionMapper tPersonanaturalFormacionMapper;
	
	@Transactional
	@Override
	public Integer registrarPostulante(PostulanteDto dto) throws BusinessException {
		
		Persona persona = IntrospeccionUtil.tranferBean(dto, Persona.class,true);
		personaMapper.insertSelective(persona);
		
		Personanatural personaNatural = IntrospeccionUtil.tranferBean(dto, Personanatural.class,true);
		personaNatural.setIdpersona(persona.getIdpersona());
		personanaturalMapper.insertSelective(personaNatural);
		
		TDireccionDomicilioHistorial ddh = new TDireccionDomicilioHistorial();
		ddh.setIdpersonanatural(personaNatural.getIdpersonanatural());
		ddh.setVar_direccion_domiciliaria(personaNatural.getDireccion());
		ddh.setInt_id_estado(1);
		ddh.setInt_id_ubigeo(personaNatural.getIdubigeo());
		ddh.setTsp_fecha_registro(new Date());
		TDireccionDomicilioHistorialMapper.insertSelective(ddh);		
		
		TPostulantePersonal postulante = IntrospeccionUtil.tranferBean(dto, TPostulantePersonal.class,true);
		postulante.setVar_email_principal((postulante.getVar_email_principal() == null) ? null : postulante.getVar_email_principal().toLowerCase());
		postulante.setInt_id_postulante(personaNatural.getIdpersonanatural());
		tPostulantePersonalMapper.insertSelective(postulante);
		
		return postulante.getInt_id_postulante();
				
	}

	@Transactional
	@Override
	public void actualizarPostulante(PostulanteDto dto)	throws BusinessException {
		
		Integer estadoPersonal = commonService.obtenerEstadoPersonal(dto.getIdpersonanatural());
		
		if(estadoPersonal == Estados.PERSONAL_INACTIVO){
			
			Persona persona = IntrospeccionUtil.tranferBean(dto, Persona.class,true);
			personaMapper.updateByPrimaryKeySelective(persona);
			
			Personanatural personaNatural = IntrospeccionUtil.tranferBean(dto, Personanatural.class,true);
			personaNatural.setIdpersona(persona.getIdpersona());
			personanaturalMapper.updateByPrimaryKeySelective(personaNatural);
			
			if(existeDireccionHistorica(personaNatural.getIdpersonanatural())){
			
				TDireccionDomicilioHistorial ddh = new TDireccionDomicilioHistorial();
				ddh.setIdpersonanatural(personaNatural.getIdpersonanatural());
				ddh.setVar_direccion_domiciliaria(personaNatural.getDireccion());
				ddh.setInt_id_estado(1);
				ddh.setInt_id_ubigeo(personaNatural.getIdubigeo());
				ddh.setTsp_fecha_registro(new Date());
				
				UltimaDireccionDomicilioQuery ddhActual = obtenerUltimaDirecionDomiciliaria(personaNatural.getIdpersonanatural());
				
				if(!ddh.getVar_direccion_domiciliaria().equals(ddhActual.getVar_direccion_domiciliaria()) || !ddh.getInt_id_ubigeo().equals(ddhActual.getInt_id_ubigeo())){
					TDireccionDomicilioHistorialMapper.insertSelective(ddh);	
				}
			}
		}
				
		TPostulantePersonal postulante = IntrospeccionUtil.tranferBean(dto, TPostulantePersonal.class,true);
		postulante.setVar_email_principal((postulante.getVar_email_principal() == null) ? null : postulante.getVar_email_principal().toLowerCase());
		postulante.setInt_id_postulante(dto.getIdpersonanatural());
		
		if(this.existePostulante(dto.getIdpersonanatural())){
			tPostulantePersonalMapper.updateByPrimaryKeySelective(postulante);
		}else{
			tPostulantePersonalMapper.insertSelective(postulante);
		}
						
	}
	
	@Transactional
	@Override
	public void actualizarPersonal(PersonalDto dto,  List<FormacionAcademicaPersonalQuery> listFormacion)	throws BusinessException {
		

			Persona persona = IntrospeccionUtil.tranferBean(dto, Persona.class,true);
			personaMapper.updateByPrimaryKeySelective(persona);
			
			Personanatural personaNatural = IntrospeccionUtil.tranferBean(dto, Personanatural.class,true);
			personaNatural.setIdpersona(persona.getIdpersona());
			personanaturalMapper.updateByPrimaryKeySelective(personaNatural);
			
			if(existeDireccionHistorica(personaNatural.getIdpersonanatural())){
			
				TDireccionDomicilioHistorial ddh = new TDireccionDomicilioHistorial();
				ddh.setIdpersonanatural(personaNatural.getIdpersonanatural());
				ddh.setVar_direccion_domiciliaria(personaNatural.getDireccion());
				ddh.setInt_id_estado(1);
				ddh.setInt_id_ubigeo(personaNatural.getIdubigeo());
				ddh.setTsp_fecha_registro(new Date());
				
				UltimaDireccionDomicilioQuery ddhActual = obtenerUltimaDirecionDomiciliaria(personaNatural.getIdpersonanatural());
				
				if(!ddh.getVar_direccion_domiciliaria().equals(ddhActual.getVar_direccion_domiciliaria()) || !ddh.getInt_id_ubigeo().equals(ddhActual.getInt_id_ubigeo())){
					TDireccionDomicilioHistorialMapper.insertSelective(ddh);	
				}
			}
			
			TPostulantePersonal postulante = IntrospeccionUtil.tranferBean(dto, TPostulantePersonal.class,true);
			postulante.setVar_email_principal((postulante.getVar_email_principal() == null) ? null : postulante.getVar_email_principal().toLowerCase());
			postulante.setInt_id_postulante(dto.getIdpersonanatural());
			
			if(this.existePostulante(dto.getIdpersonanatural())){
				tPostulantePersonalMapper.updateByPrimaryKeySelective(postulante);
			}else{
				tPostulantePersonalMapper.insertSelective(postulante);
			}
			
			Personal personal = IntrospeccionUtil.tranferBean(dto, Personal.class, true);
			personalMapper.updateByPrimaryKeySelective(personal);
			
			if(personal.getSrl_id_regimen_pensionario() != null){
				UltimoRegimenPensionarioQuery urpq = obtenerUltimoRegimenPensionario(personal.getIdpersonal());
				if(urpq == null){
					TRegimenPensionarioHistorial rph = new TRegimenPensionarioHistorial();
					rph.setIdpersonal(personal.getIdpersonal());
					rph.setSrl_id_regimen_pensionario(personal.getSrl_id_regimen_pensionario());
					rph.setVar_codigo_afiliacion(personal.getVar_codigo_afiliacion());
					rph.setVar_nombre_afp(personal.getVar_nombre_afp());
					rph.setDte_fecha_afiliacion(personal.getDte_fecha_afiliacion());
					rph.setInt_estado(1);
					tRegimenPensionarioHistorialMapper.insertSelective(rph);
				}else{
					if(!urpq.getSrl_id_regimen_pensionario().equals(personal.getSrl_id_regimen_pensionario())){
						
						TRegimenPensionarioHistorial rph = new TRegimenPensionarioHistorial();
						rph.setSrl_id_regimen_pensionario_historial(urpq.getSrl_id_regimen_pensionario_historial());
						rph.setInt_estado(0);
						tRegimenPensionarioHistorialMapper.updateByPrimaryKeySelective(rph);
						
						rph.setSrl_id_regimen_pensionario_historial(null);
						rph.setSrl_id_regimen_pensionario(personal.getSrl_id_regimen_pensionario());
						rph.setVar_codigo_afiliacion(personal.getVar_codigo_afiliacion());
						rph.setVar_nombre_afp(personal.getVar_nombre_afp());
						rph.setDte_fecha_afiliacion(personal.getDte_fecha_afiliacion());
						rph.setInt_estado(1);
						tRegimenPensionarioHistorialMapper.insertSelective(rph);
						
					}
				}
			}
			
			if(listFormacion != null){
				for (FormacionAcademicaPersonalQuery x : listFormacion) {
					TPersonanaturalFormacion pnf = IntrospeccionUtil.tranferBean(x, TPersonanaturalFormacion.class, true);
					pnf.setIdpersonanatural(personaNatural.getIdpersonanatural());
					if(x.getFlagEliminado() != null){
						TPersonanaturalFormacionKey key = new TPersonanaturalFormacion();
						key.setSrl_id_personanatural_formacion(pnf.getSrl_id_personanatural_formacion());
						tPersonanaturalFormacionMapper.deleteByPrimaryKey(key);
					}else{
						if(x.getSrl_id_personanatural_formacion() == null){
							tPersonanaturalFormacionMapper.insertSelective(pnf);
						}
					}
				}
			}
			

		
	}
	
	@Override
	public boolean existePostulante(Integer idPostulante){
		
		boolean result = false;
		
		Integer count = 0;
		
		TPostulantePersonalExample example = new TPostulantePersonalExample();
		example.createCriteria().andInt_id_postulanteEqualTo(idPostulante);
		
		count = tPostulantePersonalMapper.countByExample(example);
		
		if(count>0){
			result = true;
		}
		
		return result;
	}
	
	
	public boolean existeDireccionHistorica(Integer idPersonaNatural){
		boolean result= false;
		
		Integer count = null;
		TDireccionDomicilioHistorialExample example = new TDireccionDomicilioHistorialExample();
		example.createCriteria().andIdpersonanaturalEqualTo(idPersonaNatural);
		count = TDireccionDomicilioHistorialMapper.countByExample(example);
		
		if(count>0){
			result = true;
		}
		
		return result;
	}
	
	public UltimaDireccionDomicilioQuery obtenerUltimaDirecionDomiciliaria(Integer idPersonaNatural){
				
		UltimaDireccionDomicilioQueryCriteria criteria = new UltimaDireccionDomicilioQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatural);
		criteria.setInt_id_estado(1);
		criteria.setTsp_fecha_registro(new Date());
		
		List<UltimaDireccionDomicilioQuery> list = selectByCriteria(UltimaDireccionDomicilioQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	public UltimoRegimenPensionarioQuery obtenerUltimoRegimenPensionario(Integer idPersonal){
		
		UltimoRegimenPensionarioQueryCriteria criteria = new UltimoRegimenPensionarioQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		criteria.setInt_estado(1);
		
		List<UltimoRegimenPensionarioQuery> list = selectByCriteria(UltimoRegimenPensionarioQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}

}
