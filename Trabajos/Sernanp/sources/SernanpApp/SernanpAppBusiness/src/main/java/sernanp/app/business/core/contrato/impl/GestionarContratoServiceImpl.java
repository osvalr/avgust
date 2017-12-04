package sernanp.app.business.core.contrato.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.cons.Tablas;
import sernanp.app.business.cons.Tipos;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.contrato.service.GestionarContratoService;
import sernanp.app.business.core.estado.service.EstadoService;
import sernanp.app.business.dto.ContratoDto;
import sernanp.app.business.dto.GenerateDocDto;
import sernanp.app.dao.domain.Areanatural;
import sernanp.app.dao.domain.AreanaturalKey;
import sernanp.app.dao.domain.Areaorganica;
import sernanp.app.dao.domain.AreaorganicaKey;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.PersonalExample;
import sernanp.app.dao.domain.Sede;
import sernanp.app.dao.domain.SedeKey;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgKey;
import sernanp.app.dao.domain.TEstadoPersonal;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalContratoExample;
import sernanp.app.dao.domain.TPersonalContratoKey;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgKey;
import sernanp.app.dao.domain.TRequerimientoPersonal;
import sernanp.app.dao.domain.TRequerimientoPersonalKey;
import sernanp.app.dao.mapper.AreanaturalMapper;
import sernanp.app.dao.mapper.AreaorganicaMapper;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.SedeMapper;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TEstadoPersonalMapper;
import sernanp.app.dao.mapper.TPersonalContratoMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.mapper.TRequerimientoPersonalMapper;
import sernanp.app.dao.query.domain.AdendaEntrePeriodoPorContratoQuery;
import sernanp.app.dao.query.domain.AdendaEntrePeriodoPorContratoQueryCriteria;
import sernanp.app.dao.query.domain.ContratoCasCcQuery;
import sernanp.app.dao.query.domain.ContratoCasCcQueryCriteria;
import sernanp.app.dao.query.domain.ContratoEntrePeriodoQuery;
import sernanp.app.dao.query.domain.ContratoEntrePeriodoQueryCriteria;
import sernanp.app.dao.query.domain.ContratoPorteriorAdendaQuery;
import sernanp.app.dao.query.domain.ContratoPorteriorAdendaQueryCriteria;
import sernanp.app.dao.query.domain.InfoAdendaQuery;
import sernanp.app.dao.query.domain.InfoAdendaQueryCriteria;
import sernanp.app.dao.query.domain.InfoContratoAdendaQuery;
import sernanp.app.dao.query.domain.InfoContratoAdendaQueryCriteria;
import sernanp.app.dao.query.domain.InfoContratoQuery;
import sernanp.app.dao.query.domain.InfoContratoQueryCriteria;
import sernanp.app.dao.query.domain.InfoResponsableSernanp;
import sernanp.app.dao.query.domain.InfoResponsableSernanpCriteria;
import sernanp.app.dao.query.domain.InfoResponsableUnidadOperativaQuery;
import sernanp.app.dao.query.domain.InfoResponsableUnidadOperativaQueryCriteria;
import sernanp.app.dao.query.domain.InfoTrabajadorQuery;
import sernanp.app.dao.query.domain.InfoTrabajadorQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQuery;
import sernanp.app.dao.query.domain.PlantillaDocumentoQuery;
import sernanp.app.dao.query.domain.PlantillaDocumentoQueryCriteria;
import sernanp.app.dao.query.domain.ResponsableUnidadOperativaQuery;
import sernanp.app.dao.query.domain.ResponsableUnidadOperativaQueryCriteria;
import sernanp.app.dao.query.domain.UltimaAdendaPorContratoQuery;
import sernanp.app.dao.query.domain.UltimaAdendaPorContratoQueryCriteria;
import sernanp.app.dao.query.domain.UltimaPlantillaDocumentoQuery;
import sernanp.app.dao.query.domain.UltimaPlantillaDocumentoQueryCriteria;
import sernanp.app.dao.query.domain.UltimoContratoQuery;
import sernanp.app.dao.query.domain.UltimoContratoQueryCriteria;
import sernanp.app.dao.query.mapper.AdendaEntrePeriodoPorContratoQueryMapper;
import sernanp.app.dao.query.mapper.ContratoCasCcQueryMapper;
import sernanp.app.dao.query.mapper.ContratoEntrePeriodoQueryMapper;
import sernanp.app.dao.query.mapper.ContratoPorteriorAdendaQueryMapper;
import sernanp.app.dao.query.mapper.InfoAdendaQueryMapper;
import sernanp.app.dao.query.mapper.InfoContratoAdendaQueryMapper;
import sernanp.app.dao.query.mapper.InfoContratoQueryMapper;
import sernanp.app.dao.query.mapper.InfoResponsableSernanpMapper;
import sernanp.app.dao.query.mapper.InfoResponsableUnidadOperativaQueryMapper;
import sernanp.app.dao.query.mapper.InfoTrabajadorQueryMapper;
import sernanp.app.dao.query.mapper.PlantillaDocumentoQueryMapper;
import sernanp.app.dao.query.mapper.ResponsableUnidadOperativaQueryMapper;
import sernanp.app.dao.query.mapper.UltimaAdendaPorContratoQueryMapper;
import sernanp.app.dao.query.mapper.UltimaPlantillaDocumentoQueryMapper;
import sernanp.app.dao.query.mapper.UltimoContratoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;
import sernanp.app.util.IntrospeccionUtil;
import sernanp.app.util.PropUtil;

@Service
public class GestionarContratoServiceImpl extends HelperService implements GestionarContratoService {

	@Autowired
	TPersonalContratoMapper tPersonalContratoMapper;
	
	@Autowired
	PersonalMapper personalMapper;
	
	@Autowired
	TPostulanteCnvAreaOrgMapper tPostulanteCnvAreaOrgMapper;
	
	@Autowired
	EstadoService estadoService;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	TEstadoPersonalMapper tEstadoPersonalMapper;
	
	@Transactional
	@Override
	public void registrarContrato(ContratoDto record, String tipoReg) throws BusinessException {

		TPersonalContrato pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);

		String secuencia;
//		Date fechaCorte = obtenerFechaCorteContratos();
				
		if(tipoReg.equals("contrato")){
			
			if(pc.getSrl_id_postulante_conv_area_org() == null){
				throw new BusinessException("Error", "Es necesaria una postulación en estado ganador para generar un contrato.");
			}
			
			if(cantidadPostulacionesRegistradas(pc.getSrl_id_postulante_conv_area_org()).intValue() > 0){
				throw new BusinessException("Error", "La postulación ya esta registrada.");
			}
			
			 secuencia = commonService.obtenerSecuencia(Tablas.T_PERSONAL_CONTRATO, true, true);
		}else{
			 secuencia = commonService.obtenerSecuenciaAdenda(record.getSrl_id_contrato_padre(),pc.getDte_fec_inicio(), false);
//			 UltimaAdendaPorContratoQuery uapcq = obtenerUltimaAdenda(record.getSrl_id_contrato_padre());
//			 if(uapcq != null){
//				 Integer cantidadContratosPosteriores = cantidadContratosPosteriores(record.getIdpersonanatural(), record.getIdpersonal(), uapcq.getSrl_id_contrato());
//				 if(cantidadContratosPosteriores.intValue() > 0){
//					 throw new BusinessException("Error", "Existe al menos un contrato posterior a la ultima adenda.");
//				 }
//			 }
		}
		
		Integer cantidadContratos = contratosEntrePeriodos(record.getIdpersonanatural(), record.getIdpersonal(),pc.getSrl_id_contrato(),pc.getDte_fec_inicio(),pc.getDte_fec_termino());
		if(cantidadContratos.intValue() > 0){
				throw new BusinessException("Error", "Existe al menos un contrato que inicia entre las fechas de periodo enviados.");
		}
		
		UltimoContratoQuery ultimoContrato = obtenerUltimoContrato(record.getIdpersonanatural(), record.getIdpersonal(), pc.getSrl_id_contrato(),pc.getDte_fec_termino());
		if(ultimoContrato != null){
			Integer cantidadAdendas = adendasEntrePeriodos(pc.getSrl_id_contrato(), ultimoContrato.getSrl_id_contrato(),pc.getDte_fec_inicio(),pc.getDte_fec_termino());
			
			// ADD 13-08-2015 DAVID
			// SE COMMENTO LA SIGUIENTE RESTRICCIÓN PARA PERMITIR REGISTRAR ADENDAS DE CONTRATOS QUE NO SON LOS ULTIMOS 
			if(cantidadAdendas.intValue() > 0){
					throw new BusinessException("Error", "Existe al menos una adenda que inicia entre las fechas de periodo enviados.");
			}
			// END DAVID
			
		}
		if(pc.getSrl_id_contrato_padre() == null){
			if(pc.getSrl_id_regimen_contractual().equals(Tipos.CONTRATO_CAS)){
				if(!validarPeriodoContrato(pc.getDte_fec_inicio(), pc.getDte_fec_termino())){
					throw new BusinessException("Error", "El dia de la fecha de termino debe ser la ultima del mes.");
				}
//				if(pc.getDte_fec_termino().after(fechaCorte)){
//					throw new BusinessException("Error", "La fecha de termino del contrato excede al año fiscal actual.");
//				}
				

				if (pc.getDte_fec_inicio().before(pc.getDte_fec_suscrip()) ){
					throw new BusinessException("Error", "La fecha de suscripción del contrato es mayor a la fecha de inicio del contrato.");
				}
				
				if(pc.getDte_fec_inicio().after(pc.getDte_fec_termino())){
					throw new BusinessException("Error", "La fecha de termino debe ser mayor que la fecha de inicio.");
				}
			}else{
				pc.setDte_fec_termino(null);
			}
		}else{
			if(!validarPeriodoContrato(pc.getDte_fec_inicio(), pc.getDte_fec_termino())){
				throw new BusinessException("Error", "El dia de la fecha de termino debe ser la ultima del mes.");
			}
//			if(pc.getDte_fec_termino().after(fechaCorte)){
//				throw new BusinessException("Error", "La fecha de termino del contrato excede al año fiscal actual.");
//			}
			
			if (pc.getDte_fec_inicio().before(pc.getDte_fec_suscrip()) ){
				throw new BusinessException("Error", "La fecha de suscripción del contrato es mayor a la fecha de inicio del contrato.");
			}
			
			if(pc.getDte_fec_inicio().after(pc.getDte_fec_termino())){
				throw new BusinessException("Error", "La fecha de termino debe ser mayor que la fecha de inicio.");
			}
		}

		
		
		pc.setVar_num_contrato(secuencia);
		ResponsableUnidadOperativaQuery ruoq = obtenerResponsableUnidadOperativa(Tipos.UOF_RRHH);
		
		UltimaPlantillaDocumentoQuery updq = null;
		if(tipoReg.equals("contrato")){
			if(pc.getSrl_id_regimen_contractual().equals(Tipos.CONTRATO_CAS)){
				updq = obtenerUltimaPlantilla("CAS_TEMPLATE", new Date());
				
				pc.setSrl_id_resp_unid_oper(ruoq.getSrl_id_resp_unid_oper());
			}else{
				updq = obtenerUltimaPlantilla("CASCC_TEMPLATE", new Date());
			}
			
			pc.setIdarea(obtenerAreaOrganica(pc.getSrl_id_postulante_conv_area_org()));
			pc.setIdunidad(obtenerUnidadOperativa(pc.getSrl_id_postulante_conv_area_org()));
			
			/*FALTA OBTENER LA SEDE DE PRESTACION, SEGUN EL REQUERIMIENTO*/
			pc.setSrl_id_sede_pres(obtenerSede(pc.getSrl_id_postulante_conv_area_org()));
			
		}else{
			updq = obtenerUltimaPlantilla("ACAS_TEMPLATE", new Date());
			pc.setSrl_id_resp_unid_oper(ruoq.getSrl_id_resp_unid_oper());
		}
		
		pc.setSrl_id_plantilla_documento_archivo(updq.getSrl_id_plantilla_documento_archivo());
		
//		Integer cantCasCc = cantidadContratosCasCc(record.getIdpersonanatural());
//		if(cantCasCc.intValue() > 0){
//			throw new BusinessException("Error", "No es posible registrar mas contratos o adendas cuando la persona ya tiene un contrato CAS CARGO DE CONFIANZA.");
//		}
		
		tPersonalContratoMapper.insertSelective(pc);
		estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), Estados.CONTRATO_GENERADO.toString());
	}

	@Transactional
	@Override
	public void actualizar(ContratoDto record, String tipoReg) throws BusinessException {
		
		
		TPersonalContrato pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
		
//		Date fechaCorte = obtenerFechaCorteContratos();
		
		if(pc.getSrl_id_contrato_padre() == null){
			
			if(pc.getSrl_id_regimen_contractual().equals(Tipos.CONTRATO_CAS)){
				
				if(!validarPeriodoContrato(pc.getDte_fec_inicio(), pc.getDte_fec_termino())){
					throw new BusinessException("Error", "El dia de la fecha de termino debe ser la ultima del mes.");
				}
				
//				if(pc.getDte_fec_termino().after(fechaCorte)){
//					throw new BusinessException("Error", "La fecha de termino del contrato excede al año fiscal actual.");
//				}
				
				if (pc.getDte_fec_inicio().before(pc.getDte_fec_suscrip()) ){
					throw new BusinessException("Error", "La fecha de suscripción del contrato es mayor a la fecha de inicio del contrato.");
				}
				
				if(pc.getDte_fec_inicio().after(pc.getDte_fec_termino())){
					throw new BusinessException("Error", "La fecha de termino debe ser mayor que la fecha de inicio.");
				}
				
			}
		}else{
			if(!validarPeriodoContrato(pc.getDte_fec_inicio(), pc.getDte_fec_termino())){
				throw new BusinessException("Error", "El dia de la fecha de termino debe ser la ultima del mes.");
			}
			
//			if(pc.getDte_fec_termino().after(fechaCorte)){
//				throw new BusinessException("Error", "La fecha de termino del contrato excede al año fiscal actual.");
//			}
			
			if (pc.getDte_fec_inicio().before(pc.getDte_fec_suscrip()) ){
				throw new BusinessException("Error", "La fecha de suscripción del contrato es mayor a la fecha de inicio del contrato.");
			}
			
			if(pc.getDte_fec_inicio().after(pc.getDte_fec_termino())){
				throw new BusinessException("Error", "La fecha de termino debe ser mayor que la fecha de inicio.");
			}
		}
		

		Integer cantidadContratos = contratosEntrePeriodos(record.getIdpersonanatural(), record.getIdpersonal(),pc.getSrl_id_contrato(),pc.getDte_fec_inicio(),pc.getDte_fec_termino());
		if(cantidadContratos.intValue() > 0){
				throw new BusinessException("Error", "Existe al menos un contrato que inicia entre las fechas de periodo enviados.");
		}
		
		UltimoContratoQuery ultimoContrato = obtenerUltimoContrato(record.getIdpersonanatural(), record.getIdpersonal(), pc.getSrl_id_contrato(),pc.getDte_fec_termino());
		if(ultimoContrato != null){
			Integer cantidadAdendas = adendasEntrePeriodos(pc.getSrl_id_contrato(),ultimoContrato.getSrl_id_contrato(),pc.getDte_fec_inicio(),pc.getDte_fec_termino());
			if(cantidadAdendas.intValue() > 0){
					throw new BusinessException("Error", "Existe al menos una adenda que inicia entre las fechas de periodo enviados.");
			}
		}
		
//		Integer cantCasCc = cantidadContratosCasCc(record.getIdpersonanatural());
//		if(cantCasCc.intValue() > 0){
//			throw new BusinessException("Error", "No es posible registrar mas contratos o adendas cuando la persona ya tiene un contrato CAS CARGO DE CONFIANZA.");
//		}
		
		UltimaPlantillaDocumentoQuery updq = null;
		if(tipoReg.equals("contrato")){
			
			if(pc.getSrl_id_regimen_contractual().equals(Tipos.CONTRATO_CAS)){
				updq = obtenerUltimaPlantilla("CAS_TEMPLATE", new Date());
				ResponsableUnidadOperativaQuery ruoq = obtenerResponsableUnidadOperativa(Tipos.UOF_RRHH);
				pc.setSrl_id_resp_unid_oper(ruoq.getSrl_id_resp_unid_oper());
				pc.setVar_num_resolucion(null);
			}else{
				updq = obtenerUltimaPlantilla("CASCC_TEMPLATE", new Date());
				pc.setSrl_id_resp_unid_oper(null);
				pc.setDte_fec_termino(null);
			}
			
			if(pc.getSrl_id_postulante_conv_area_org() != null){
				pc.setIdarea(obtenerAreaOrganica(pc.getSrl_id_postulante_conv_area_org()));
				pc.setIdunidad(obtenerUnidadOperativa(pc.getSrl_id_postulante_conv_area_org()));
				pc.setSrl_id_sede_pres(obtenerSede(pc.getSrl_id_postulante_conv_area_org()));
			}

			if(pc.getDte_fec_cese() != null){
				
				UltimaAdendaPorContratoQuery uapcq = obtenerUltimaAdenda(pc.getSrl_id_contrato());
				if(uapcq != null){
					TPersonalContrato pca = new TPersonalContrato();
					pca.setSrl_id_contrato(uapcq.getSrl_id_contrato());
					pca.setDte_fec_cese(pc.getDte_fec_cese());
					tPersonalContratoMapper.updateByPrimaryKeySelective(pca);
				}
				
			}else{
				
				TPersonalContratoKey pck = new TPersonalContratoKey();
				pck.setSrl_id_contrato(pc.getSrl_id_contrato());
				TPersonalContrato pcx = tPersonalContratoMapper.selectByPrimaryKey(pck);
				pcx.setDte_fec_cese(null);
				tPersonalContratoMapper.updateByPrimaryKey(pcx);
				
				TPersonalContratoExample epca = new TPersonalContratoExample();
				epca.createCriteria().andSrl_id_contrato_padreEqualTo(pcx.getSrl_id_contrato());
				
				List<TPersonalContrato> list = tPersonalContratoMapper.selectByExample(epca);
				for (TPersonalContrato x : list) {
					x.setDte_fec_cese(null);
					tPersonalContratoMapper.updateByPrimaryKey(x);
				}
				
			}
			
		}else{
			updq = obtenerUltimaPlantilla("ACAS_TEMPLATE", new Date());
			
			if(pc.getDte_fec_cese() != null){
					TPersonalContratoExample epc = new TPersonalContratoExample();
					epc.createCriteria().andSrl_id_contratoEqualTo(pc.getSrl_id_contrato_padre());
					List<TPersonalContrato> list = tPersonalContratoMapper.selectByExample(epc);
					if(!list.isEmpty()){
						TPersonalContrato pca = list.get(0);
						pca.setDte_fec_cese(pc.getDte_fec_cese());
						tPersonalContratoMapper.updateByPrimaryKeySelective(pca);
					}
	
			}else{
				TPersonalContratoExample epc = new TPersonalContratoExample();
				epc.createCriteria().andSrl_id_contratoEqualTo(pc.getSrl_id_contrato_padre());
				List<TPersonalContrato> list = tPersonalContratoMapper.selectByExample(epc);
				if(!list.isEmpty()){
					TPersonalContrato pca = list.get(0);
					pca.setDte_fec_cese(null);
					tPersonalContratoMapper.updateByPrimaryKey(pca);
				}
			}
			
		}
		
		pc.setSrl_id_plantilla_documento_archivo(updq.getSrl_id_plantilla_documento_archivo());
		
		
		
		ObtenerUltimoEstadoQuery oueq = estadoService.obtenerUltimoEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), new Date());
		
			if(Integer.parseInt(oueq.getVar_cod_estado()) != pc.getInt_id_estado().intValue()){
				
				if(Integer.parseInt(oueq.getVar_cod_estado()) == Estados.CONTRATO_SUSCRITO.intValue()){
					throw new BusinessException("Error", "No es posible cambiar el estado del contrato / adenda cuando ya se encuentra en estado SUSCRITO.");
				}else{
					if(pc.getInt_id_estado().equals(Estados.CONTRATO_SUSCRITO)){
						if(pc.getSrl_id_contrato_padre() == null){
							this.suscribirContrato(pc, null);
							estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), pc.getInt_id_estado().toString());
						}
						
					}
				}
				
				if(Integer.parseInt(oueq.getVar_cod_estado()) == Estados.CONTRATO_NO_SUSCRITO.intValue()){
					throw new BusinessException("Error", "No es posible cambiar el estado del contrato / adenda cuando ya se encuentra en estado NO SUSCRITO.");
				}else{
					if(pc.getInt_id_estado().equals(Estados.CONTRATO_NO_SUSCRITO)){
						if(pc.getSrl_id_contrato_padre() == null){
							this.noSuscribirContrato(pc);
							estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), pc.getInt_id_estado().toString());
						}
					}
				}
				
				//estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), pc.getInt_id_estado().toString());
			}

			
		//estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), pc.getInt_id_estado().toString());
			

			
		tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
		
		TPersonalContratoKey pck = new TPersonalContrato();
		pck.setSrl_id_contrato(pc.getSrl_id_contrato());
		
		TPersonalContrato pcx = tPersonalContratoMapper.selectByPrimaryKey(pck);
		pcx.setVar_num_resolucion(pc.getVar_num_resolucion());
//		pcx.setSrl_id_resp_unid_oper(pc.getSrl_id_resp_unid_oper());
		pcx.setDte_fec_termino(pc.getDte_fec_termino());
		pcx.setDte_fec_cese(pc.getDte_fec_cese());
		tPersonalContratoMapper.updateByPrimaryKey(pcx);

	}
	
	public Date obtenerFechaCorteContratos(){
		Calendar calendar = new GregorianCalendar(2014,11,31);
		Date date=null;
		date = calendar.getTime();
		return date;
	}
	
	public Integer contratosEntrePeriodos(Integer idPersonaNatrual, Integer idPersonal, Integer idContrato, Date fecIni, Date fecFin){
		
		ContratoEntrePeriodoQueryCriteria criteria = new ContratoEntrePeriodoQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatrual);
		criteria.setIdpersonal(idPersonal);
		criteria.setSrl_id_contrato(idContrato);
		criteria.setDte_fec_inicio(fecIni);
		criteria.setDte_fec_termino(fecFin);
		
		List<ContratoEntrePeriodoQuery> list = selectByCriteria(ContratoEntrePeriodoQueryMapper.class, criteria);
		
		return list.size();

	}
	
	public Integer adendasEntrePeriodos(Integer idContrato, Integer idContratoPadre, Date fecIni, Date fecFin){
		
//		if(idContrato != null){
			AdendaEntrePeriodoPorContratoQueryCriteria criteria = new AdendaEntrePeriodoPorContratoQueryCriteria();
			criteria.setSrl_id_contrato_padre(idContratoPadre);
			criteria.setSrl_id_contrato(idContratoPadre);
			criteria.setDte_fec_inicio(fecIni);
			criteria.setDte_fec_termino(fecFin);
			
//			System.out.println(idContratoPadre +" *** " + idContratoPadre +" *** " + fecIni +" *** " + fecFin);
			List<AdendaEntrePeriodoPorContratoQuery> list = selectByCriteria(AdendaEntrePeriodoPorContratoQueryMapper.class, criteria);
			
			return list.size();

//		}else{
//			return 0;
//		}
		
	}
		
	public int obtenerUltimoDiaDelMes(Date fecFin) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecFin);   
        int d = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return d;
    }
	
	public boolean validarPeriodoContrato(Date fecIni, Date fecFin){
		boolean result = false;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecIni);
		int mesInicio = cal.get(Calendar.MONTH);
		int anhoInicio = cal.get(Calendar.YEAR);
		cal = Calendar.getInstance();
		cal.setTime(fecFin);
		int mesFin = cal.get(Calendar.MONTH);
		int anhoFin = cal.get(Calendar.YEAR);
		int diaFin = cal.get(Calendar.DAY_OF_MONTH);
		
		if(anhoInicio != anhoFin){
			result = true;
		}else if(mesInicio != mesFin){
			result = true;
		}else{
			if(diaFin == obtenerUltimoDiaDelMes(fecFin)){
				result = true;
			}
		}
		
		return result;
	}
	
	public UltimoContratoQuery obtenerUltimoContrato(Integer idPersonaNatrual, Integer idPersonal, Integer idContrato, Date fecFin){
		
		UltimoContratoQueryCriteria criteria = new UltimoContratoQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatrual);
		criteria.setIdpersonal(idPersonal);
		criteria.setSrl_id_contrato(idContrato);
		criteria.setDte_fec_termino(fecFin);
		
//		System.out.println(idPersonaNatrual + " *** " + idPersonal  + " *** " + idContrato + " *** " +fecFin);
		
		List<UltimoContratoQuery> list = selectByCriteria(UltimoContratoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}

	}
	
	public UltimaAdendaPorContratoQuery obtenerUltimaAdenda(Integer idContrato){
		
		UltimaAdendaPorContratoQueryCriteria criteria = new UltimaAdendaPorContratoQueryCriteria();
		criteria.setSrl_id_contrato_padre(idContrato);
		
		List<UltimaAdendaPorContratoQuery> list = selectByCriteria(UltimaAdendaPorContratoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}

	}
	
	public Integer cantidadContratosPosteriores(Integer idPersonaNatrual, Integer idPersonal, Integer idAdenda){
		
		ContratoPorteriorAdendaQueryCriteria criteria = new ContratoPorteriorAdendaQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatrual);
		criteria.setIdpersonal(idPersonal);
		criteria.setId_adenda(idAdenda);
			
		List<ContratoPorteriorAdendaQuery> list = selectByCriteria(ContratoPorteriorAdendaQueryMapper.class, criteria);
			
		return list.size();
		
	}
	public Integer cantidadPostulacionesRegistradas(Integer idPostulacion){
		
		Integer cant = null;
		
		TPersonalContratoExample example = new TPersonalContratoExample();
		example.createCriteria().andSrl_id_contrato_padreIsNull().andSrl_id_postulante_conv_area_orgEqualTo(idPostulacion).andInt_id_estadoNotEqualTo(4);
		
		cant = tPersonalContratoMapper.countByExample(example);
		
		return cant;
		
	}
	
	public ResponsableUnidadOperativaQuery obtenerResponsableUnidadOperativa(Integer idUnidadOperativa){
		ResponsableUnidadOperativaQueryCriteria criteria = new ResponsableUnidadOperativaQueryCriteria();
		criteria.setIdunidad(idUnidadOperativa);
		criteria.setTsp_fecha_corte(new Date());
		List<ResponsableUnidadOperativaQuery> list = selectByCriteria(ResponsableUnidadOperativaQueryMapper.class, criteria);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public GenerateDocDto generarContratoPdf(Integer idContrato) throws BusinessException {
		
		InfoContratoQuery contrato = obtenerInfoContrato(idContrato);
		InfoResponsableUnidadOperativaQuery responsable = null;
		InfoResponsableSernanp responsableSernanp = null;
		
		if(contrato.getSrl_id_regimen_contractual().equals(Tipos.CONTRATO_CAS)){
			 responsable = obtenerInfoResponsable(contrato.getSrl_id_resp_unid_oper());
		}else{
			responsableSernanp = obtenerInfoResponsableSernanp(contrato.getDte_fec_inicio());
		}
		
		InfoTrabajadorQuery trabajador = obtenerInfoTrabajador(contrato.getIdpersonanatural());
		
		PlantillaDocumentoQuery plantilla = obtenerPlantillaDocumento(contrato.getSrl_id_plantilla_documento_archivo());
		
		GenerateDocDto dto = new GenerateDocDto();
		dto.setContrato(contrato);
		dto.setTrabajador(trabajador);
		dto.setResponsable(responsable);
		dto.setResponsableSernanp(responsableSernanp);
		dto.setPathRutaTmp(PropUtil.getInstance().getPropVal("documents.properties", "ruta.temp"));
		dto.setPathTemplate(plantilla.getVar_archivo_ruta_almacen());
		dto.setIdContrato(idContrato);
		
		return dto;
		
	}
	
	@Override
	public GenerateDocDto generarAdendaPdf(Integer idAdenda) throws BusinessException {
		
		InfoAdendaQuery adenda = obtenerInfoAdenda(idAdenda);
		InfoContratoAdendaQuery contrato = obtenerInfoContratoAdenda(adenda.getSrl_id_contrato_padre());
		InfoResponsableUnidadOperativaQuery responsable = null;
		responsable = obtenerInfoResponsable(adenda.getSrl_id_resp_unid_oper());
		InfoTrabajadorQuery trabajador = obtenerInfoTrabajador(contrato.getIdpersonanatural());
		
		PlantillaDocumentoQuery plantilla = obtenerPlantillaDocumento(adenda.getSrl_id_plantilla_documento_archivo());
		
		GenerateDocDto dto = new GenerateDocDto();
		dto.setAdenda(adenda);
		dto.setContratoAdenda(contrato);
		dto.setTrabajador(trabajador);
		dto.setResponsable(responsable);
		dto.setPathRutaTmp(PropUtil.getInstance().getPropVal("documents.properties", "ruta.temp"));
		dto.setPathTemplate(plantilla.getVar_archivo_ruta_almacen());
		dto.setIdContrato(idAdenda);
		
		return dto;
	}
	
	public InfoContratoQuery obtenerInfoContrato(Integer idContrato){
		InfoContratoQueryCriteria criteria = new InfoContratoQueryCriteria();
		criteria.setSrl_id_contrato(idContrato);
		
		List<InfoContratoQuery> list = selectByCriteria(InfoContratoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	public InfoContratoAdendaQuery obtenerInfoContratoAdenda(Integer idContrato){
		InfoContratoAdendaQueryCriteria criteria = new InfoContratoAdendaQueryCriteria();
		criteria.setSrl_id_contrato(idContrato);
		
		List<InfoContratoAdendaQuery> list = selectByCriteria(InfoContratoAdendaQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	public InfoResponsableUnidadOperativaQuery obtenerInfoResponsable(Integer idResponsableUnidadOperativa){
		InfoResponsableUnidadOperativaQueryCriteria criteria = new InfoResponsableUnidadOperativaQueryCriteria();
		criteria.setSrl_id_resp_unid_oper(idResponsableUnidadOperativa);
		
		List<InfoResponsableUnidadOperativaQuery> list = selectByCriteria(InfoResponsableUnidadOperativaQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	public InfoTrabajadorQuery obtenerInfoTrabajador(Integer idpersonanatural){
		InfoTrabajadorQueryCriteria criteria = new InfoTrabajadorQueryCriteria();
		criteria.setIdpersonanatural(idpersonanatural);
		
		List<InfoTrabajadorQuery> list = selectByCriteria(InfoTrabajadorQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	public PlantillaDocumentoQuery obtenerPlantillaDocumento(Integer idPlantilla){
		PlantillaDocumentoQueryCriteria criteria = new PlantillaDocumentoQueryCriteria();
		criteria.setSrl_id_plantilla_documento_archivo(idPlantilla);
		
		List<PlantillaDocumentoQuery> list = selectByCriteria(PlantillaDocumentoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	
	public InfoResponsableSernanp obtenerInfoResponsableSernanp(Date fecSuscrip){
		InfoResponsableSernanpCriteria criteria = new InfoResponsableSernanpCriteria();
		criteria.setTsp_fecha_inicio_ejercicio(fecSuscrip);
		
		List<InfoResponsableSernanp> list = selectByCriteria(InfoResponsableSernanpMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public InfoAdendaQuery obtenerInfoAdenda(Integer idAdenda){
		InfoAdendaQueryCriteria criteria = new InfoAdendaQueryCriteria();
		criteria.setSrl_id_contrato(idAdenda);
		
		List<InfoAdendaQuery> list = selectByCriteria(InfoAdendaQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	public UltimaPlantillaDocumentoQuery obtenerUltimaPlantilla(String nombrePlantilla, Date fechaValidez){
		UltimaPlantillaDocumentoQueryCriteria criteria = new UltimaPlantillaDocumentoQueryCriteria();
		criteria.setVar_nombre_plantilla(nombrePlantilla);
		criteria.setDte_fecha_validez(fechaValidez);
		
		List<UltimaPlantillaDocumentoQuery> list = selectByCriteria(UltimaPlantillaDocumentoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	@Transactional
	@Override
	public void suscribirContrato(TPersonalContrato pc, Integer idContrato) throws BusinessException {
		InfoTrabajadorQuery it = null;
		TPersonalContrato pcx = null;
		Personal p = null;
		if(pc == null){
			
			TPersonalContratoKey key = new TPersonalContratoKey();
			key.setSrl_id_contrato(idContrato);
			pc = tPersonalContratoMapper.selectByPrimaryKey(key);
			pc.setInt_id_estado(Estados.CONTRATO_SUSCRITO);
			
			TPersonalContratoKey kpcx = new TPersonalContratoKey();
			kpcx.setSrl_id_contrato(pc.getSrl_id_contrato());
			pcx = tPersonalContratoMapper.selectByPrimaryKey(kpcx);
			Integer idPersonaNatural = obtenerIdPersonaNatural(pcx.getSrl_id_postulante_conv_area_org());
			it = obtenerInfoTrabajador(idPersonaNatural);
			
			// Start JRaffo 19/01/2014
			Areanatural areaNatural = obtenerAreaNatural(pcx.getSrl_id_postulante_conv_area_org());
			// End JRaffo 19/01/2014
			
			p = obtenerPersonal(it.getIdpersonanatural());
				
				if(p == null){
					
					p = new Personal();
					p.setIdpersonanatural(it.getIdpersonanatural());
					p.setInt_estado(Estados.PERSONAL_ACTIVO);
					
					// Start JRaffo 19/01/2015
					if(areaNatural != null){
						if(areaNatural.getIdcategoriaanp().intValue() == 11){
							p.setInt_flag(0);
						}else{
							p.setInt_flag(1);
						}
					}
					p.setSrl_id_asis_turno(2);
					// End JRaffo 19/01/2015
					
					personalMapper.insertSelective(p);
						
				}else{
					// Start JRaffo 19/01/2015
					if(areaNatural != null){
						if(areaNatural.getIdcategoriaanp().intValue() == 11){
							p.setInt_flag(0);
						}else{
							p.setInt_flag(1);
						}
					}
					p.setSrl_id_asis_turno(2);
					//Start DAVID 13-02-2015
					p.setInt_estado(Estados.PERSONAL_ACTIVO);
					//End DAVID 13-02-2015
					personalMapper.updateByPrimaryKey(p);
					// End JRaffo 19/01/2015
				}
				
				TEstadoPersonal ep = new TEstadoPersonal();
				ep.setIdpersonal(p.getIdpersonal());
				ep.setDte_fecha_estado(new Date());
				ep.setInt_id_estado(Estados.PERSONAL_ACTIVO);
				ep.setInt_id_tipificacion(Tipos.TIPIFICACION_INGRESO_CONTRATACION);
				ep.setVar_motivo("SUSCRIPCIÓN CONTRATO");
				tEstadoPersonalMapper.insertSelective(ep);
			
				
			/*STAR DAVID 03-08-2015 -- MATRICULA UBIGEO Y DIRECCIÓN EN CONTRATO */
			
			pc.setInt_id_idubigeo(it.getInt_id_idubigeo());
			pc.setVar_direccion_personal(it.getVar_direccion_domiciliaria());
				
			/*END DAVID*/
			pc.setIdpersonal(p.getIdpersonal());
			
			tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
			
			TRequerimientoPersonal rq = this.obtenerRequerimientoPersonal(pc.getSrl_id_postulante_conv_area_org());
			
			if(rq != null){
				pc.setCodmeta(rq.getC_meta());
				pc.setCodfuente(rq.getC_fte_fto());
			}
			
			estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), Estados.CONTRATO_SUSCRITO.toString());
			
		}else{
			
			TPersonalContratoKey kpcx = new TPersonalContratoKey();
			kpcx.setSrl_id_contrato(pc.getSrl_id_contrato());
			pcx = tPersonalContratoMapper.selectByPrimaryKey(kpcx);
			Integer idPersonaNatural = obtenerIdPersonaNatural(pcx.getSrl_id_postulante_conv_area_org());
			it = obtenerInfoTrabajador(idPersonaNatural);
			
			// Start DAVID 13/02/2015
			Areanatural areaNatural = obtenerAreaNatural(pcx.getSrl_id_postulante_conv_area_org());
			// End DAVID 13/02/2015
			
			p = obtenerPersonal(it.getIdpersonanatural());
				
				if(p == null){
					p = new Personal();
					p.setIdpersonanatural(it.getIdpersonanatural());
					p.setInt_estado(Estados.PERSONAL_ACTIVO);
					
//					Start DAVID 13-02-2015	
					if(areaNatural != null){
						if(areaNatural.getIdcategoriaanp().intValue() == 11){
							p.setInt_flag(0);
						}else{
							p.setInt_flag(1);
						}
					}

					p.setSrl_id_asis_turno(2);
					p.setDte_fec_ingreso(pc.getDte_fec_inicio());
//					End DAVID 13-02-2015	
					
					personalMapper.insertSelective(p);
				}
//				Start DAVID 13-02-2015				
				else{
					if(areaNatural != null){
						if(areaNatural.getIdcategoriaanp().intValue() == 11){
							p.setInt_flag(0);
						}else{
							p.setInt_flag(1);
						}
					}
					p.setSrl_id_asis_turno(2);
					p.setInt_estado(Estados.PERSONAL_ACTIVO);
					personalMapper.updateByPrimaryKey(p);
				}
//				End DAVID 13-02-2015		
				
				TEstadoPersonal ep = new TEstadoPersonal();
				ep.setIdpersonal(p.getIdpersonal());
				ep.setDte_fecha_estado(new Date());
				ep.setInt_id_estado(Estados.PERSONAL_ACTIVO);
				ep.setInt_id_tipificacion(Tipos.TIPIFICACION_INGRESO_CONTRATACION);
				ep.setVar_motivo("SUSCRIPCIÓN CONTRATO");
				tEstadoPersonalMapper.insertSelective(ep);
			
				
			/*STAR DAVID 03-08-2015 -- MATRICULA UBIGEO Y DIRECCIÓN EN CONTRATO */
			
			pc.setInt_id_idubigeo(it.getInt_id_idubigeo());
			pc.setVar_direccion_personal(it.getVar_direccion_domiciliaria());
				
			/*END DAVID*/	
			
			pc.setIdpersonal(p.getIdpersonal());
			
			TRequerimientoPersonal rq = this.obtenerRequerimientoPersonal(pc.getSrl_id_postulante_conv_area_org());
			
			if(rq != null){
				pc.setCodmeta(rq.getC_meta());
				pc.setCodfuente(rq.getC_fte_fto());
			}
			
			tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
			
		}
		
		TPostulanteCnvAreaOrgKey kpcao = new TPostulanteCnvAreaOrgKey();
		kpcao.setSrl_id_postulante_conv_area_org(pcx.getSrl_id_postulante_conv_area_org());
		TPostulanteCnvAreaOrg pcao = tPostulanteCnvAreaOrgMapper.selectByPrimaryKey(kpcao);
		pcao.setInt_id_estado(Estados.POSTULACION_PERSONA_CONTRATO_SUSCRITO);
		tPostulanteCnvAreaOrgMapper.updateByPrimaryKeySelective(pcao);
		
		estadoService.registrarEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, pcao.getSrl_id_postulante_conv_area_org(), Estados.POSTULACION_PERSONA_CONTRATO_SUSCRITO.toString());
			
	}
	
	@Transactional
	@Override
	public void noSuscribirContrato(TPersonalContrato pc) throws BusinessException {
				
		TPersonalContratoKey kpcx = new TPersonalContratoKey();
		kpcx.setSrl_id_contrato(pc.getSrl_id_contrato());
		TPersonalContrato pcx = tPersonalContratoMapper.selectByPrimaryKey(kpcx);
		
		TPostulanteCnvAreaOrgKey kpcao = new TPostulanteCnvAreaOrgKey();
		kpcao.setSrl_id_postulante_conv_area_org(pcx.getSrl_id_postulante_conv_area_org());
		TPostulanteCnvAreaOrg pcao = tPostulanteCnvAreaOrgMapper.selectByPrimaryKey(kpcao);
		pcao.setInt_id_estado(Estados.POSTULACION_PERSONA_CONTRATO_NO_SUSCRITO);
		tPostulanteCnvAreaOrgMapper.updateByPrimaryKeySelective(pcao);
		
		estadoService.registrarEstado(Tablas.T_POSTULANTE_CNV_AREA_ORG, pcao.getSrl_id_postulante_conv_area_org(), Estados.POSTULACION_PERSONA_CONTRATO_NO_SUSCRITO.toString());
		
	}

	@Transactional
	@Override
	public void suscribirAdenda(Integer idContrato) throws BusinessException {
		TPersonalContratoKey kpc = new TPersonalContratoKey();
		kpc.setSrl_id_contrato(idContrato);
		TPersonalContrato pc = tPersonalContratoMapper.selectByPrimaryKey(kpc);
		pc.setInt_id_estado(Estados.CONTRATO_SUSCRITO);
		tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
		estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), Estados.CONTRATO_SUSCRITO.toString());
	}

	@Transactional
	@Override
	public void noSuscribirAdenda(Integer idContrato) throws BusinessException {
		TPersonalContratoKey kpc = new TPersonalContratoKey();
		kpc.setSrl_id_contrato(idContrato);
		TPersonalContrato pc = tPersonalContratoMapper.selectByPrimaryKey(kpc);
		pc.setInt_id_estado(Estados.CONTRATO_NO_SUSCRITO);
		tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
		estadoService.registrarEstado(Tablas.T_PERSONAL_CONTRATO, pc.getSrl_id_contrato(), Estados.CONTRATO_NO_SUSCRITO.toString());
	}
	
	public Personal obtenerPersonal(Integer idPersonaNatural){
		PersonalExample ep = new PersonalExample();
		ep.createCriteria().andIdpersonanaturalEqualTo(idPersonaNatural);
		List<Personal> list = personalMapper.selectByExample(ep);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	public Integer cantidadContratosCasCc(Integer idPersonaNatural){
		ContratoCasCcQueryCriteria criteria = new ContratoCasCcQueryCriteria();
		criteria.setInt_id_tab_tip(Tipos.CONTRATO_CAS_CARGO_CONFIANZA);
		criteria.setIdpersonanatural(idPersonaNatural);
		List<ContratoCasCcQuery> list = selectByCriteria(ContratoCasCcQueryMapper.class, criteria);
		return list.size();
	}
	public Integer obtenerUnidadOperativa(Integer idPostulacion){
		TPostulanteCnvAreaOrgKey pcaok = new TPostulanteCnvAreaOrgKey();
		pcaok.setSrl_id_postulante_conv_area_org(idPostulacion);
		TPostulanteCnvAreaOrg pcao = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, pcaok);
		
		TConvocatoriaAreaOrgKey caok = new TConvocatoriaAreaOrgKey();
		caok.setSrl_id_conv_area_org(pcao.getSrl_id_conv_area_org());
		TConvocatoriaAreaOrg cao = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, caok);
		
		return cao.getIdunidad();
		
	}
	
	public Areanatural obtenerAreaNatural(Integer idPostulacion){
			
			TPostulanteCnvAreaOrgKey pcaok = new TPostulanteCnvAreaOrgKey();
			pcaok.setSrl_id_postulante_conv_area_org(idPostulacion);
			TPostulanteCnvAreaOrg pcao = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, pcaok);
			
			TConvocatoriaAreaOrgKey caok = new TConvocatoriaAreaOrgKey();
			caok.setSrl_id_conv_area_org(pcao.getSrl_id_conv_area_org());
			TConvocatoriaAreaOrg cao = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, caok);
			
			AreaorganicaKey aok = new AreaorganicaKey();
			aok.setIdarea(cao.getIdarea());
			Areaorganica ao = this.selectByPrimaryKey(AreaorganicaMapper.class,aok);
			
			SedeKey sk = new SedeKey();
			sk.setIdsede(ao.getIdsede());
			Sede s = this.selectByPrimaryKey(SedeMapper.class, sk);
			
			AreanaturalKey areaNaturalKey = new AreanaturalKey();
			areaNaturalKey.setIdareanatural(s.getIdareanatural());
			Areanatural areaNatural = this.selectByPrimaryKey(AreanaturalMapper.class, areaNaturalKey);
			
			return areaNatural;
			
	}
	
	public Integer obtenerSede(Integer idPostulacion){
		
		TPostulanteCnvAreaOrgKey pcaok = new TPostulanteCnvAreaOrgKey();
		pcaok.setSrl_id_postulante_conv_area_org(idPostulacion);
		TPostulanteCnvAreaOrg pcao = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, pcaok);
		
		TConvocatoriaAreaOrgKey caok = new TConvocatoriaAreaOrgKey();
		caok.setSrl_id_conv_area_org(pcao.getSrl_id_conv_area_org());
		TConvocatoriaAreaOrg cao = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, caok);
		
		AreaorganicaKey aok = new AreaorganicaKey();
		aok.setIdarea(cao.getIdarea());
		Areaorganica ao = this.selectByPrimaryKey(AreaorganicaMapper.class,aok);
		
		SedeKey sk = new SedeKey();
		sk.setIdsede(ao.getIdsede());
		Sede s = this.selectByPrimaryKey(SedeMapper.class, sk);
		
		return s.getIdsede();
		
	}
	
	public Integer obtenerAreaOrganica(Integer idPostulacion){
		
		TPostulanteCnvAreaOrgKey pcaok = new TPostulanteCnvAreaOrgKey();
		pcaok.setSrl_id_postulante_conv_area_org(idPostulacion);
		TPostulanteCnvAreaOrg pcao = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, pcaok);
		
		TConvocatoriaAreaOrgKey caok = new TConvocatoriaAreaOrgKey();
		caok.setSrl_id_conv_area_org(pcao.getSrl_id_conv_area_org());
		TConvocatoriaAreaOrg cao = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, caok);
		
		AreaorganicaKey aok = new AreaorganicaKey();
		aok.setIdarea(cao.getIdarea());
		Areaorganica ao = this.selectByPrimaryKey(AreaorganicaMapper.class,aok);
		
		return ao.getIdarea();
		
	}
	
	public Integer obtenerIdPersonaNatural(Integer idPostulacion){
		
		TPostulanteCnvAreaOrgKey pcaok = new TPostulanteCnvAreaOrgKey();
		pcaok.setSrl_id_postulante_conv_area_org(idPostulacion);
		TPostulanteCnvAreaOrg pcao = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, pcaok);
				
		return pcao.getInt_id_postulante();
		
	}
	
	public TRequerimientoPersonal obtenerRequerimientoPersonal(Integer idPostulacion){
		
		if(idPostulacion != null){
			
			TPostulanteCnvAreaOrgKey key = new TPostulanteCnvAreaOrgKey();
			key.setSrl_id_postulante_conv_area_org(idPostulacion);
			
			TPostulanteCnvAreaOrg p = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, key);
			
			TConvocatoriaAreaOrgKey pk = new TConvocatoriaAreaOrgKey();
			pk.setSrl_id_conv_area_org(p.getSrl_id_conv_area_org());
			
			TConvocatoriaAreaOrg c = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, pk);
			
			if(c.getSrl_id_requerimiento_personal() != null){
				
				TRequerimientoPersonalKey rpk = new TRequerimientoPersonalKey();
				rpk.setSrl_id_requerimiento_personal(c.getSrl_id_requerimiento_personal());
				
				TRequerimientoPersonal r = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, rpk);
				
				return r;
				
			}else{
				return null;
			}
			
		}else{
			return null;
		}
		
	}
	
}
