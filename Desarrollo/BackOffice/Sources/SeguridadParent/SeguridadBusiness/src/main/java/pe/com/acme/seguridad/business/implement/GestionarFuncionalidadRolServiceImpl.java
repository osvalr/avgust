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
* @since   26/02/2016 19:43:25
*/

package pe.com.acme.seguridad.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.MybatisRepositoryHelper;

import pe.com.acme.seguridad.business.service.GestionarFuncionalidadRolService;
import pe.com.acme.query.mybatis.model.FuncionalidadRolCrud;
import pe.com.acme.query.mybatis.model.FuncionalidadRolCrudCriteria;
import pe.com.acme.query.mybatis.mapper.FuncionalidadRolCrudMapper;

import pe.com.acme.domain.mybatis.model.FuncionalidadRol;
import pe.com.acme.domain.mybatis.mapper.FuncionalidadRolMapper;

@Service
public class GestionarFuncionalidadRolServiceImpl extends MybatisRepositoryHelper implements GestionarFuncionalidadRolService {

	@Autowired
	private DtoUtil dtoUtil;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(FuncionalidadRolCrud model) throws Exception {
	
		Integer lastId = null;

		FuncionalidadRol funcionalidadRol = dtoUtil.copyBean(model, FuncionalidadRol.class);
		this.insertSelective(FuncionalidadRolMapper.class, funcionalidadRol);

		lastId = funcionalidadRol.getId_funcionalidad();
		return lastId;
	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void update(FuncionalidadRolCrud model) throws Exception {

		FuncionalidadRol funcionalidadRol = dtoUtil.copyBean(model, FuncionalidadRol.class);
		this.updateByPrimaryKeySelective(FuncionalidadRolMapper.class, funcionalidadRol);
		
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void destroy(FuncionalidadRolCrud model) throws Exception {

		FuncionalidadRol funcionalidadRol = dtoUtil.copyBean(model, FuncionalidadRol.class);
		this.deleteByPrimaryKey(FuncionalidadRolMapper.class, funcionalidadRol);
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public List<FuncionalidadRolCrud> list(FuncionalidadRolCrudCriteria criteria) throws Exception {
		List<FuncionalidadRolCrud> list = this.selectByQuery(FuncionalidadRolCrudMapper.class, criteria);
		return list;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public int countRecords(FuncionalidadRolCrudCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(FuncionalidadRolCrudMapper.class, criteria);
		return count;
	}
}
