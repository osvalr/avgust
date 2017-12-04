/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 20:14:59
*/

package pe.com.acme.seguridad.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.MybatisRepositoryHelper;

import pe.com.acme.seguridad.business.service.GestionarRolService;
import pe.com.acme.query.mybatis.model.RolAplicacionCrud;
import pe.com.acme.query.mybatis.model.RolAplicacionCrudCriteria;
import pe.com.acme.query.mybatis.mapper.RolAplicacionCrudMapper;

import pe.com.acme.domain.mybatis.model.RolAplicacion;
import pe.com.acme.domain.mybatis.mapper.RolAplicacionMapper;

@Service
public class GestionarRolServiceImpl extends MybatisRepositoryHelper implements GestionarRolService {

	@Autowired
	private DtoUtil dtoUtil;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(RolAplicacionCrud model) throws Exception {
	
		Integer lastId = null;

		RolAplicacion rolAplicacion = dtoUtil.copyBean(model, RolAplicacion.class);
		this.insertSelective(RolAplicacionMapper.class, rolAplicacion);

		lastId = rolAplicacion.getId_rol();
		return lastId;
	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void update(RolAplicacionCrud model) throws Exception {

		RolAplicacion rolAplicacion = dtoUtil.copyBean(model, RolAplicacion.class);
		this.updateByPrimaryKeySelective(RolAplicacionMapper.class, rolAplicacion);
		
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void destroy(RolAplicacionCrud model) throws Exception {

		RolAplicacion rolAplicacion = dtoUtil.copyBean(model, RolAplicacion.class);
		this.deleteByPrimaryKey(RolAplicacionMapper.class, rolAplicacion);
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public List<RolAplicacionCrud> list(RolAplicacionCrudCriteria criteria) throws Exception {
		List<RolAplicacionCrud> list = this.selectByQuery(RolAplicacionCrudMapper.class, criteria);
		return list;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public int countRecords(RolAplicacionCrudCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(RolAplicacionCrudMapper.class, criteria);
		return count;
	}
}