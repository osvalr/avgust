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
* @since   26/02/2016 22:13:22
*/

package pe.com.acme.seguridad.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.MybatisRepositoryHelper;

import pe.com.acme.seguridad.business.service.GestionarUsuarioRolService;
import pe.com.acme.query.mybatis.model.UsuarioRolCrud;
import pe.com.acme.query.mybatis.model.UsuarioRolCrudCriteria;
import pe.com.acme.query.mybatis.mapper.UsuarioRolCrudMapper;

import pe.com.acme.domain.mybatis.model.UsuarioRol;
import pe.com.acme.domain.mybatis.mapper.UsuarioRolMapper;

@Service
public class GestionarUsuarioRolServiceImpl extends MybatisRepositoryHelper implements GestionarUsuarioRolService {

	@Autowired
	private DtoUtil dtoUtil;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(UsuarioRolCrud model) throws Exception {
	
		Integer lastId = null;

		UsuarioRol usuarioRol = dtoUtil.copyBean(model, UsuarioRol.class);
		this.insertSelective(UsuarioRolMapper.class, usuarioRol);

		lastId = usuarioRol.getId_rol();
		return lastId;
	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void update(UsuarioRolCrud model) throws Exception {

		UsuarioRol usuarioRol = dtoUtil.copyBean(model, UsuarioRol.class);
		this.updateByPrimaryKeySelective(UsuarioRolMapper.class, usuarioRol);
		
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void destroy(UsuarioRolCrud model) throws Exception {

		UsuarioRol usuarioRol = dtoUtil.copyBean(model, UsuarioRol.class);
		this.deleteByPrimaryKey(UsuarioRolMapper.class, usuarioRol);
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public List<UsuarioRolCrud> list(UsuarioRolCrudCriteria criteria) throws Exception {
		List<UsuarioRolCrud> list = this.selectByQuery(UsuarioRolCrudMapper.class, criteria);
		return list;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public int countRecords(UsuarioRolCrudCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(UsuarioRolCrudMapper.class, criteria);
		return count;
	}
}
