package sernanp.app.business.core.desvinculacion.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.core.desvinculacion.service.GestionarDesvinculacionService;
import sernanp.app.business.core.planilla.service.ProcesoNominaService;
import sernanp.app.business.dto.PersonalDesvinculacionDto;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaExample;
import sernanp.app.dao.domain.TEstadoPersonal;
import sernanp.app.dao.domain.TEstadoPersonalKey;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalMetaFteFto;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.mapper.TEstadoPersonalMapper;
import sernanp.app.dao.mapper.TPersonalContratoMapper;
import sernanp.app.dao.query.domain.ObtenerPersonalSinContratoQuery;
import sernanp.app.dao.query.domain.ObtenerPersonalSinContratoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerUltimoContratoAlternoQuery;
import sernanp.app.dao.query.domain.ObtenerUltimoContratoAlternoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerVacacionesQuery;
import sernanp.app.dao.query.domain.ObtenerVacacionesQueryCriteria;
import sernanp.app.dao.query.domain.PersonalContratoNominaQuery;
import sernanp.app.dao.query.domain.PersonalVacacionesQuery;
import sernanp.app.dao.query.domain.PersonalVacacionesQueryCriteria;
import sernanp.app.dao.query.domain.ResultadoVacacionesQuery;
import sernanp.app.dao.query.domain.ResultadoVacacionesQueryCriteria;
import sernanp.app.dao.query.domain.UltimaAdendaPorContratoQuery;
import sernanp.app.dao.query.domain.UltimaAdendaPorContratoQueryCriteria;
import sernanp.app.dao.query.domain.UltimoEstadoPersonalQuery;
import sernanp.app.dao.query.domain.UltimoEstadoPersonalQueryCriteria;
import sernanp.app.dao.query.mapper.AdendaFinalPorContratoQueryMapper;
import sernanp.app.dao.query.mapper.GestionarAsignarConceptoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerPersonalSinContratoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerUltimoContratoAlternoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerVacacionesQueryMapper;
import sernanp.app.dao.query.mapper.PersonalVacacionesQueryMapper;
import sernanp.app.dao.query.mapper.ResultadoVacacionesQueryMapper;
import sernanp.app.dao.query.mapper.UltimaAdendaPorContratoQueryMapper;
import sernanp.app.dao.query.mapper.UltimoEstadoPersonalQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;
import sernanp.app.util.IntrospeccionUtil;

@Service
public class GestionarDesvinculacionServiceImpl extends HelperService  implements GestionarDesvinculacionService{
	
	
	@Autowired
	TEstadoPersonalMapper tEstadoPersonalMapper; 
	
	@Autowired
	PersonalMapper personalMapper;
	
	@Autowired
	TPersonalContratoMapper tPersonalContratoMapper;
	
	@Autowired
	ResultadoVacacionesQueryMapper resultadoVacacionesQueryMapper;
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private Object objeto;
	
	@Autowired
	PersonalVacacionesQueryMapper personalVacacionesQueryMapper;
	
	@Autowired
	GestionarAsignarConceptoQueryMapper gestionarAsignarConceptoQueryMapper;
	
	@Autowired
	AdendaFinalPorContratoQueryMapper adendaFinalPorContratoQueryMapper;
	
	@Autowired
	ProcesoNominaService procesoNominaService;
	
	@Autowired
	TAnioPlanillaMapper tAnioPlanillaMapper; 
	
	@Autowired
	TAnioPeriodoPlanillaMapper tAnioPeriodoPlanillaMapper; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {

          this.setJdbcTemplate(new JdbcTemplate(dataSource));
          
          this.dataSource = dataSource;
    }
		   
	@Transactional
	@Override
	public void registrarDesvinculacion(PersonalDesvinculacionDto record) throws BusinessException{
		
		// YA SE REGISTRO UNA DESVINCULACION? 
		UltimoEstadoPersonalQuery uepq = existeDesvinculacion(record.getIdpersonal());
		
		if(uepq != null){
			if(uepq.getInt_id_estado().equals(Estados.PERSONAL_INACTIVO)){
			throw new BusinessException("Error", "Ya existe una desvinculación registrada.");
			}
		}		
	   
	   //EXISTEN VACACIONES PENDIENTES?
	   ObtenerVacacionesQuery  ovq = existeVacaciones(record.getIdpersonal());
	   
	   if(ovq != null ){
		   
		   throw new BusinessException("Error", "No se puede desvincular al personal, posee Vacaciones y/o Licencias pendientes de Cerrar.");
	   }
	  
		//POSEE UN CONTRATO?
	    ObtenerUltimoContratoAlternoQuery ucq = obtenerUltimoContrato(null, record.getIdpersonal(), null,ConvertirStringDate(record.getDte_fec_cese()));
	    // 19-09-2015 DAVID
	    TPersonalContrato pc = null;
	    
		if(ucq != null){
			
				//19-09-2015 DAVID
//				TPersonalContrato pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
				pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
				pc.setSrl_id_contrato(ucq.getSrl_id_contrato());
				// SE AÑADE LA FECHA DE CESE AL ULTIMO CONTRATO
				pc.setDte_fec_cese(ConvertirStringDate(record.getDte_fec_cese())); 
				tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
				
		}else{
		
				//FIX - NO ENCUENTRA EL ULTIMO CONTRATO (728) AÑADE SU FECHA DE CESE
				ObtenerPersonalSinContratoQuery psc = obtenerPersonalSinContrato(record.getIdpersonal());
				// 19-09-2015 DAVID					
//				TPersonalContrato pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
				pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
				pc.setSrl_id_contrato(psc.getSrl_id_contrato());
				pc.setDte_fec_cese(ConvertirStringDate(record.getDte_fec_cese())); 
				tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
		
		}
		
		// SE EJECUTA LA FUNCION VACACIONES TRUNCAS
		this.jdbcTemplate.queryForInt("select sernanp.fn_genera_vacaciones_truncas_personal(?)", Integer.valueOf(record.getIdpersonal()));
		
		PersonalVacacionesQueryCriteria personalVacacionesQueryCriteria = new PersonalVacacionesQueryCriteria();
		personalVacacionesQueryCriteria.setIdpersonal(record.getIdpersonal());
		
		List<PersonalVacacionesQuery> listPersonalVacacionesQuery = personalVacacionesQueryMapper.getListQueryByCriteria(personalVacacionesQueryCriteria);
		PersonalVacacionesQuery personalVacacionesQuery = null;
		
		if(!listPersonalVacacionesQuery.isEmpty()){
			
			personalVacacionesQuery = listPersonalVacacionesQuery.get(0);
			
		}
		
		TPersonalContrato pcx = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
		
		Calendar c = Calendar.getInstance();
		c.setTime(pcx.getDte_fec_cese());
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 2;
//		int monthCurrent = Calendar.getInstance().get(Calendar.MONTH) + 1;
		
		TAnioPlanillaExample example = new TAnioPlanillaExample();
		example.createCriteria().andInt_anioEqualTo(year);
		
		List<TAnioPlanilla> listTAnioPlanilla = tAnioPlanillaMapper.selectByExample(example);
			
		TAnioPlanilla tAnioPlanilla = null;
		
		if(!listTAnioPlanilla.isEmpty()){
			tAnioPlanilla = listTAnioPlanilla.get(0);
		}
		
//		TAnioPeriodoPlanillaExample tAnioPeriodoPlanillaExample = new TAnioPeriodoPlanillaExample();
//		tAnioPeriodoPlanillaExample.createCriteria().andInt_id_periodo_mesEqualTo(monthCurrent).andSrl_id_anio_planillaEqualTo(tAnioPlanilla.getSrl_id_anio_planilla());
//		
//		List<TAnioPeriodoPlanilla> listTAnioPeriodoPlanilla = tAnioPeriodoPlanillaMapper.selectByExample(tAnioPeriodoPlanillaExample);
//		
//		TAnioPeriodoPlanilla tAnioPeriodoPlanilla = null;
//		
//		if(!listTAnioPeriodoPlanilla.isEmpty()){
//			tAnioPeriodoPlanilla = listTAnioPeriodoPlanilla.get(0);
//		}
//		
//		procesoNominaService.precargarInfo(tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla());

		TPersonalMetaFteFto tPersonalMetaFteFto = procesoNominaService.obtenerMetaFteFtoAlterno(tAnioPlanilla.getSrl_id_anio_planilla(), record.getIdpersonal());


		// 19-09-2015 DAVID
//		PersonalContratoNominaQuery pc = procesoNominaService.obtenerInfoContrato(record.getIdpersonal());
		PersonalContratoNominaQuery pcy = procesoNominaService.obtenerInfoContrato(record.getIdpersonal());
		//END

	    //SE CAMBIA EL ESTADO EN LA TABLA personal
		//ADD 17-09-2015 DAVID
		if (pcy.getDte_fec_cese() != null){
		    Personal p = new Personal();
			p.setIdpersonal(record.getIdpersonal());
			p.setInt_estado(Estados.PERSONAL_INACTIVO);
			personalMapper.updateByPrimaryKeySelective(p);			
		}
		
		String sql = "INSERT INTO sernanp.t_estado_personal " +
			     "(idpersonal, var_motivo, int_id_estado, int_id_tipificacion, dte_fecha_estado,srl_id_contrato,c_fte_fto,c_meta,int_anio,int_mes,dec_dias_vac_truncas) " +
			     "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?,?,?)";

	   jdbcTemplate = new JdbcTemplate(dataSource);
	
	   jdbcTemplate.update(sql, new Object[] {
				
				record.getIdpersonal(),
				record.getVar_motivo(),
				Estados.PERSONAL_INACTIVO,
				record.getInt_id_tipificacion(),
				new Date(),
				pc.getSrl_id_contrato(),
				tPersonalMetaFteFto.getC_fte_fto(),
				tPersonalMetaFteFto.getC_meta(),
				year,
				month,
				(personalVacacionesQuery == null ? 0.0 : personalVacacionesQuery.getInt_dias_vac_truncas())

				
		});
				
		
	}
	
	@Transactional
	@Override
	public void actualizar(PersonalDesvinculacionDto record) throws BusinessException {
		
		TEstadoPersonal ep = IntrospeccionUtil.tranferBean(record, TEstadoPersonal.class, true);
	    ep.setDte_fecha_estado(new Date());
	    tEstadoPersonalMapper.updateByPrimaryKeySelective(ep);
	    
		
		ObtenerUltimoContratoAlternoQuery ucq = obtenerUltimoContrato(null, record.getIdpersonal(), null, ConvertirStringDate(record.getDte_fec_cese()));
		
		if(ucq != null){
				TPersonalContrato pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
				pc.setSrl_id_contrato(ucq.getSrl_id_contrato());
				//pc.setDte_fec_cese(ConvertirStringDate(record.getDte_fec_cese())); 
				tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
		
		}
		else{
			
			//FIX - NO ENCUENTRA EL ULTIMO CONTRATO (728) AÑADE SU FECHA DE CESE
			ObtenerPersonalSinContratoQuery psc = obtenerPersonalSinContrato(record.getIdpersonal());
				
			TPersonalContrato pc = IntrospeccionUtil.tranferBean(record, TPersonalContrato.class, true);
			pc.setSrl_id_contrato(psc.getSrl_id_contrato());
			//pc.setDte_fec_cese(ConvertirStringDate(record.getDte_fec_cese())); 
			tPersonalContratoMapper.updateByPrimaryKeySelective(pc);
			
		}
		
		
	}
	
	
	public UltimoEstadoPersonalQuery existeDesvinculacion(Integer idpersonal){
		
		UltimoEstadoPersonalQueryCriteria criteria = new UltimoEstadoPersonalQueryCriteria();
		criteria.setIdpersonal(idpersonal);
		
		List<UltimoEstadoPersonalQuery> list = selectByCriteria(UltimoEstadoPersonalQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	public ResultadoVacacionesQuery sinPendientesVacaciones(Integer idpersonal){
		
		ResultadoVacacionesQueryCriteria rc = new ResultadoVacacionesQueryCriteria();
		rc.setIdpersonal(idpersonal);
		
		List<ResultadoVacacionesQuery> list = selectByCriteria(ResultadoVacacionesQueryMapper.class, rc);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	
	
	public ObtenerVacacionesQuery existeVacaciones(Integer idPersonal){
		
		ObtenerVacacionesQueryCriteria criteria = new ObtenerVacacionesQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		
		List<ObtenerVacacionesQuery> list = selectByCriteria(ObtenerVacacionesQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	@Transactional
	@Override
	public void eliminarDesvinculacion(Integer idDesvinculacion,Integer idPersonal) throws BusinessException {
		TEstadoPersonalKey pk = new TEstadoPersonalKey();
		pk.setIdpersonal(idPersonal);
		pk.setSrl_id_estado_personal(idDesvinculacion);
		tEstadoPersonalMapper.deleteByPrimaryKey(pk);
		
		UltimoEstadoPersonalQuery uepq = existeDesvinculacion(idPersonal);
		
		if(uepq != null){
			Personal p = new Personal();
			p.setIdpersonal(idPersonal);
			p.setInt_estado(uepq.getInt_id_estado());
			personalMapper.updateByPrimaryKeySelective(p);
		}else{
			Personal p = new Personal();
			p.setIdpersonal(idPersonal);
			p.setInt_estado(Estados.PERSONAL_ACTIVO);
			personalMapper.updateByPrimaryKeySelective(p);
		}
	}
	
	
	public ObtenerPersonalSinContratoQuery obtenerPersonalSinContrato(Integer idPersonal){
		
		ObtenerPersonalSinContratoQueryCriteria criteria = new ObtenerPersonalSinContratoQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		
		List<ObtenerPersonalSinContratoQuery> list = selectByCriteria(ObtenerPersonalSinContratoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}

	}
	
	public ObtenerUltimoContratoAlternoQuery obtenerUltimoContrato(Integer idPersonaNatrual, Integer idPersonal, Integer idContrato, Date dte_fec_cese){
		
		ObtenerUltimoContratoAlternoQueryCriteria criteria = new ObtenerUltimoContratoAlternoQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatrual);
		criteria.setIdpersonal(idPersonal);
		criteria.setSrl_id_contrato(idContrato);
		criteria.setDte_fec_cese(dte_fec_cese);
		
		List<ObtenerUltimoContratoAlternoQuery> objeto = selectByCriteria(ObtenerUltimoContratoAlternoQueryMapper.class, criteria);
		
		if(!objeto.isEmpty()){
			
			return	 objeto.get(0);
			 //list.get(0);
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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static Date ConvertirStringDate(String fecha)
	{
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    Date fechaDate = null;
	    try {
	        fechaDate = formato.parse(fecha);
	    }
	    catch (ParseException ex)
	    {
	        System.out.println(ex);
	    }
	    return fechaDate;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
}	
