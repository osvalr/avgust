package pe.com.focus.sakerk.business.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.repository.mybatis.mapper.CongregacionGeneralMapper;
import pe.com.focus.repository.mybatis.mapper.EstudioMapper;
import pe.com.focus.repository.mybatis.mapper.PersonaJuridicaMapper;
import pe.com.focus.repository.mybatis.mapper.RolMapper;
import pe.com.focus.repository.mybatis.mapper.UbigeoMapper;
import pe.com.focus.repository.mybatis.model.CongregacionGeneral;
import pe.com.focus.repository.mybatis.model.CongregacionGeneralExample;
import pe.com.focus.repository.mybatis.model.Estudio;
import pe.com.focus.repository.mybatis.model.EstudioExample;
import pe.com.focus.repository.mybatis.model.PersonaJuridica;
import pe.com.focus.repository.mybatis.model.PersonaJuridicaExample;
import pe.com.focus.repository.mybatis.model.Rol;
import pe.com.focus.repository.mybatis.model.RolExample;
import pe.com.focus.repository.mybatis.model.Ubigeo;
import pe.com.focus.repository.mybatis.model.UbigeoExample;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;
import pe.com.focus.sakerk.business.service.CommonService;
import pe.com.focus.sakerk.repository.custom.mapper.ListaCongregacionLocalQueryMapper;
import pe.com.focus.sakerk.repository.custom.mapper.ListaPersonaNaturalParentescoQueryMapper;
import pe.com.focus.sakerk.repository.custom.mapper.TablaGeneralDetalleQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.ListaCongregacionLocalQuery;
import pe.com.focus.sakerk.repository.custom.model.ListaCongregacionLocalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.model.ListaPersonaNaturalParentescoQuery;
import pe.com.focus.sakerk.repository.custom.model.ListaPersonaNaturalParentescoQueryCriteria;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQueryCriteria;
import pe.com.focus.util.ExtJsReturnCommon;

@Service
public class CommonServiceImpl extends HelperServiceImpl implements CommonService {

	@Transactional(readOnly=true)
	@Override
	public ExtJsReturnCommon listaTablaGeneralDetalle(String nombre_tabla_general) throws BusinessException {
		TablaGeneralDetalleQueryCriteria criteria = new TablaGeneralDetalleQueryCriteria();
		criteria.setNombre_tabla_general(nombre_tabla_general);
		criteria.setOrderColumn("valor_general");
		criteria.setOrderDirecction("ASC");
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(this.getListByQuery(TablaGeneralDetalleQueryMapper.class, criteria));
		return common;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Ubigeo> obtenerDepartamentosUbigeo() throws BusinessException {

		UbigeoExample example = new UbigeoExample();
		example.createCriteria().andCod_provEqualTo("00").andCod_distEqualTo("00");

		return this.selectByExample(UbigeoMapper.class, example);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Ubigeo> obtenerProvinciaUbigeo(String idDepartamento)throws BusinessException {

		UbigeoExample example = new UbigeoExample();
		example.createCriteria().andCod_provNotEqualTo("00").andCod_distEqualTo("00").andCod_deptoEqualTo(idDepartamento);

		return this.selectByExample(UbigeoMapper.class,example);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Ubigeo> obtenerDistritoUbigeo(String idDepartamento,String idProvincia) throws BusinessException {

		UbigeoExample example = new UbigeoExample();
		example.createCriteria().andCod_provEqualTo(idProvincia).andCod_distNotEqualTo("00").andCod_deptoEqualTo(idDepartamento);

		return this.selectByExample(UbigeoMapper.class,example);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Estudio> listaEstudio(Integer id_categoria_estudio) throws BusinessException {
		List<Estudio> list = null;
		if(id_categoria_estudio != null){
			EstudioExample example = new EstudioExample();
			example.createCriteria().andId_estadoEqualTo(1).andId_categoria_estudioEqualTo(id_categoria_estudio);		
			list =  this.selectByExample(EstudioMapper.class, example);
		}
		return list;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<PersonaJuridica> listaPersonaJuridica() throws BusinessException {
		List<PersonaJuridica> list = this.selectAll(PersonaJuridicaMapper.class);
		return list;
	}
	@Transactional(readOnly=true)
	@Override
	public List<PersonaJuridica> listaPersonaJuridica(Integer id_tipo_persona_juridica) throws BusinessException {
		PersonaJuridicaExample example = new PersonaJuridicaExample();
		example.createCriteria().andId_tipo_persona_juridicaEqualTo(id_tipo_persona_juridica);
		List<PersonaJuridica> list = this.selectByExample(PersonaJuridicaMapper.class, example);
		return list;
	}
	@Transactional(readOnly=true)
	@Override
	public List<CongregacionGeneral> listaCongregacionPorReferido(Integer id_congregacion_padre) throws BusinessException {
		CongregacionGeneralExample example = new CongregacionGeneralExample();
		if(id_congregacion_padre == null){
			example.createCriteria().andId_congregacion_padreIsNull();
		}else{
			example.createCriteria().andId_congregacion_padreEqualTo(id_congregacion_padre);
		}
		List<CongregacionGeneral> list = this.selectByExample(CongregacionGeneralMapper.class, example);
		return list;
	}
	@Transactional(readOnly=true)
	@Override
	public List<CongregacionGeneral> listaCongregacionDistrito()throws BusinessException {
		CongregacionGeneralExample example = new CongregacionGeneralExample();
		example.createCriteria().andId_congregacion_padreIsNotNull();
		List<CongregacionGeneral> list = this.selectByExample(CongregacionGeneralMapper.class, example);
		return list;
	}
	@Transactional(readOnly=true)
	@Override
	public List<ListaPersonaNaturalParentescoQuery> listaPersonaNatural(Integer id_persona_natural) throws BusinessException {
		
		ListaPersonaNaturalParentescoQueryCriteria criteria = new ListaPersonaNaturalParentescoQueryCriteria();
		criteria.setId_persona_natural(id_persona_natural);
		
		List<ListaPersonaNaturalParentescoQuery> list = this.getListByQuery(ListaPersonaNaturalParentescoQueryMapper.class, criteria);
		
		return list;
	}
	@Transactional(readOnly=true)
	@Override
	public List<Rol> listarRolesCongregacion() throws BusinessException {
		RolExample example = new RolExample();
//		example.createCriteria().andId_tipo_rolEqualTo(Constantes.TIPO_ROL_CONGREGACION);
		List<Rol> list = this.selectByExample(RolMapper.class,example);
		return list;
	}
	@Transactional(readOnly=true)
	@Override
	public List<ListaCongregacionLocalQuery> listaCongregacionLocal(Integer id_congregacion_general) throws BusinessException {
		List<ListaCongregacionLocalQuery> list = null;
		if(id_congregacion_general !=null){
			ListaCongregacionLocalQueryCriteria criteria = new ListaCongregacionLocalQueryCriteria();
			criteria.setId_congregacion_general(id_congregacion_general);
			
			list = this.getListByQuery(ListaCongregacionLocalQueryMapper.class, criteria);
			
		}
		
		return list;
	}
	
}
