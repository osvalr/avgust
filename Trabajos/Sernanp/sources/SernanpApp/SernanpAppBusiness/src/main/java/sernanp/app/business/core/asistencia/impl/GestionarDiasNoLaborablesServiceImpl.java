package sernanp.app.business.core.asistencia.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.asistencia.service.GestionarDiasNoLaborablesService;
import sernanp.app.business.dto.DiasNoLaborablesDTO;
import sernanp.app.dao.domain.TDiasNoLaborables;
import sernanp.app.dao.domain.TDiasNoLaborablesExample;
import sernanp.app.dao.domain.TDiasNoLaborablesKey;
import sernanp.app.dao.mapper.TDiasNoLaborablesMapper;
import sernanp.app.dao.query.domain.ExisteFechaInPersonalAsistenciaQuery;
import sernanp.app.dao.query.domain.ExisteFechaInPersonalAsistenciaQueryCriteria;
import sernanp.app.dao.query.mapper.ExisteFechaInPersonalAsistenciaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;
import sernanp.app.util.IntrospeccionUtil;


@Service
public class GestionarDiasNoLaborablesServiceImpl extends HelperServiceMybatisImpl implements GestionarDiasNoLaborablesService{
	
	@Autowired
	TDiasNoLaborablesMapper tDiasNoLaborablesMapper;
	
	@Transactional
	@Override
	public void registrarDiaNoLaborable(DiasNoLaborablesDTO tDiasNoLaborables)throws BusinessException{
		
		TDiasNoLaborables dnl 				= IntrospeccionUtil.tranferBean(tDiasNoLaborables, TDiasNoLaborables.class, true);
		
		TDiasNoLaborablesExample exampleDNL 	= new TDiasNoLaborablesExample();
		exampleDNL.createCriteria().andDte_fec_no_laborableEqualTo(dnl.getDte_fec_no_laborable());
		
		List<TDiasNoLaborables> diaExiste 	= this.selectByExample(TDiasNoLaborablesMapper.class, exampleDNL);
		
		
		if(!diaExiste.isEmpty()){
			
			throw new BusinessException("Error","El día que intenta registrar, ya éxite.");
			
		}

		
		ExisteFechaInPersonalAsistenciaQueryCriteria criteria = new ExisteFechaInPersonalAsistenciaQueryCriteria();
		criteria.setDte_fecha(null);
		
		
		List<ExisteFechaInPersonalAsistenciaQuery> existeFechaMayor = this.getListByQuery(ExisteFechaInPersonalAsistenciaQueryMapper.class, criteria);

		if(!existeFechaMayor.isEmpty()){
			
			if(!dnl.getDte_fec_no_laborable().after(existeFechaMayor.get(0).getDte_fecha())){
				
				throw new BusinessException("Error","El día que intenta registrar debe ser mayor a la última fecha de Asistencia procesada.");	
			}			
		}		
		
		tDiasNoLaborablesMapper.insertSelective(dnl);
		
		
	}

	@Transactional
	@Override
	public void eliminarDiaNoLaborable(DiasNoLaborablesDTO tDiasNoLaborablesDTO) throws BusinessException {
		
		TDiasNoLaborables dnl 				= IntrospeccionUtil.tranferBean(tDiasNoLaborablesDTO, TDiasNoLaborables.class, true);
		
		TDiasNoLaborablesKey pkdnl = new TDiasNoLaborablesKey();
		
		pkdnl.setSrl_id_no_laborable(dnl.getSrl_id_no_laborable());	
		
		TDiasNoLaborables tdnl = 	this.selectByPrimaryKey(TDiasNoLaborablesMapper.class, pkdnl);		
		
		ExisteFechaInPersonalAsistenciaQueryCriteria criteria = new ExisteFechaInPersonalAsistenciaQueryCriteria();
		criteria.setDte_fecha(null);		
		
		List<ExisteFechaInPersonalAsistenciaQuery> existeFechaMayor = this.getListByQuery(ExisteFechaInPersonalAsistenciaQueryMapper.class, criteria);
				
		if(!existeFechaMayor.isEmpty()){
			
			if(!tdnl.getDte_fec_no_laborable().after(existeFechaMayor.get(0).getDte_fecha())){
				
				throw new BusinessException("Error","En el proceso de Asistencia fue considerado el día que intenta borrar.");
			}			
		}
		
		tDiasNoLaborablesMapper.deleteByPrimaryKey(pkdnl);
		
		
	}

}
