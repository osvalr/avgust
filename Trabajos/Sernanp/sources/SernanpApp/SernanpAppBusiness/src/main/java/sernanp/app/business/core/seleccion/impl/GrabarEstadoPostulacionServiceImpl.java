package sernanp.app.business.core.seleccion.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.seleccion.service.GrabarEstadoPostulacionService;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgKey;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgExample;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgKey;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GrabarEstadoPostulacionServiceImpl extends HelperServiceMybatisImpl implements GrabarEstadoPostulacionService {

	
	public final int ESTADO_POSTULACION_GANADOR = 2;
	public final int ESTADO_POSTULACION_CONTRATO_NO_SUSCRITO = 6;
	public final int ESTADO_POSTULACION_APROBADO = 7;
	
	@Transactional
	@Override
	public void grabarEstado(Integer srl_id_postulante_conv_area_org, Integer int_orden_merito, Integer int_id_estado) throws BusinessException {
		
		if(int_id_estado.intValue() == ESTADO_POSTULACION_GANADOR){
			
			TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
			tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(srl_id_postulante_conv_area_org);
			
			TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
			
			TConvocatoriaAreaOrgKey tConvocatoriaAreaOrgKey = new TConvocatoriaAreaOrgKey();
			tConvocatoriaAreaOrgKey.setSrl_id_conv_area_org(tPostulanteCnvAreaOrg.getSrl_id_conv_area_org());

			TConvocatoriaAreaOrg tConvocatoriaAreaOrg = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgKey);
			
			int vacantes = tConvocatoriaAreaOrg.getInt_num_puestos().intValue();
			
			TPostulanteCnvAreaOrgExample tPostulanteCnvAreaOrgExample = new TPostulanteCnvAreaOrgExample();
			tPostulanteCnvAreaOrgExample.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org()).andInt_id_estadoEqualTo(ESTADO_POSTULACION_GANADOR);
			
			List<TPostulanteCnvAreaOrg> listTPostulanteCnvAreaOrgs = this.selectByExample(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgExample);
			
			if(listTPostulanteCnvAreaOrgs.size() >= vacantes){
				throw new BusinessException("No hay vacantes disponibles.");
			}
			
		}
		
		TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
		tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(srl_id_postulante_conv_area_org);
		
		TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
		
		if(int_id_estado.intValue() == ESTADO_POSTULACION_APROBADO){
			tPostulanteCnvAreaOrg.setInt_orden_merito(null);
		}else{
			tPostulanteCnvAreaOrg.setInt_orden_merito(int_orden_merito);
		}
		
		tPostulanteCnvAreaOrg.setInt_id_estado(int_id_estado);
		
		this.updateByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
		
	}
	
	@Transactional
	@Override
	public void seleccionarGanadores(Integer srl_id_conv_area_org) throws BusinessException {
		
		TConvocatoriaAreaOrgKey tConvocatoriaAreaOrgKey = new TConvocatoriaAreaOrgKey();
		tConvocatoriaAreaOrgKey.setSrl_id_conv_area_org(srl_id_conv_area_org);

		TConvocatoriaAreaOrg tConvocatoriaAreaOrg = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgKey);
		
		int vacantes = tConvocatoriaAreaOrg.getInt_num_puestos().intValue();
		
		TPostulanteCnvAreaOrgExample tPostulanteCnvAreaOrgExample = new TPostulanteCnvAreaOrgExample();
		tPostulanteCnvAreaOrgExample.createCriteria().andInt_id_estadoEqualTo(ESTADO_POSTULACION_APROBADO).andSrl_id_conv_area_orgEqualTo(srl_id_conv_area_org);
		tPostulanteCnvAreaOrgExample.setOrderByClause("dec_puntaje_total desc");
		
		List<TPostulanteCnvAreaOrg> listTPostulanteCnvAreaOrgs = this.selectByExample(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgExample);
		
		for(TPostulanteCnvAreaOrg obj : listTPostulanteCnvAreaOrgs){
			obj.setInt_orden_merito(null);
			this.updateByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, obj);
		}
		
		List<TPostulanteCnvAreaOrg> subList = null;
		
		if(listTPostulanteCnvAreaOrgs.size() > vacantes){
			subList =  listTPostulanteCnvAreaOrgs.subList(0, vacantes);
		}else{
			subList = listTPostulanteCnvAreaOrgs;
		}
		
		int orden = 1;
		for(TPostulanteCnvAreaOrg obj : subList){
			obj.setInt_orden_merito(orden);
			obj.setInt_id_estado(ESTADO_POSTULACION_GANADOR);
			this.updateByPrimaryKeySelective(TPostulanteCnvAreaOrgMapper.class, obj);
			orden++;
		}
		
	}

}
