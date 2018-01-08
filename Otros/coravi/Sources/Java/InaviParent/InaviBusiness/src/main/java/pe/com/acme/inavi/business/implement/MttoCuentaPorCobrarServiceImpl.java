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
* @since   25/07/2016 19:41:32
*/

package pe.com.acme.inavi.business.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.MybatisRepositoryHelper;

import pe.com.acme.inavi.business.service.MttoCuentaPorCobrarService;
import pe.com.acme.query.mybatis.model.CuentaXCobrarQuery;
import pe.com.acme.query.mybatis.model.CuentaXCobrarQueryCriteria;
import pe.com.acme.query.mybatis.mapper.CuentaXCobrarQueryMapper;

import pe.com.acme.domain.mybatis.model.CuentaXCobrar;
import pe.com.acme.domain.mybatis.mapper.CuentaXCobrarMapper;

import pe.com.acme.query.mybatis.model.CuentaAmortizacionQuery;
import pe.com.acme.domain.mybatis.model.CuentaAmortizacion;
import pe.com.acme.domain.mybatis.mapper.CuentaAmortizacionMapper;

@Service
public class MttoCuentaPorCobrarServiceImpl extends MybatisRepositoryHelper implements MttoCuentaPorCobrarService {

	@Autowired
	private DtoUtil dtoUtil;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(CuentaXCobrarQuery model) throws Exception {
		
		Integer lastId = null;

		CuentaXCobrar cuentaXCobrar = dtoUtil.copyBean(model, CuentaXCobrar.class);
		this.insertSelective(CuentaXCobrarMapper.class, cuentaXCobrar);
		
        this.insertNewRecordsCuentaAmortizacionQuery(model.getListCuentaAmortizacionQuery(), cuentaXCobrar.getId_cuenta_x_cobrar());
		lastId = cuentaXCobrar.getId_cuenta_x_cobrar();
		return lastId;

	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void update(CuentaXCobrarQuery model) throws Exception {
	
		CuentaXCobrar cuentaXCobrar = dtoUtil.copyBean(model, CuentaXCobrar.class);
		this.updateByPrimaryKeySelective(CuentaXCobrarMapper.class, cuentaXCobrar);
		
        this.insertNewRecordsCuentaAmortizacionQuery(model.getListCuentaAmortizacionQuery(), cuentaXCobrar.getId_cuenta_x_cobrar());
        this.updateModifiedRecordsCuentaAmortizacionQuery(model.getListCuentaAmortizacionQuery());
        this.removeRecordsCuentaAmortizacionQuery(model.getListCuentaAmortizacionQuery(), true);
		
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void destroy(CuentaXCobrarQuery model) throws Exception {
	
        this.removeRecordsCuentaAmortizacionQuery(model.getListCuentaAmortizacionQuery(), false);

		CuentaXCobrar cuentaXCobrar = dtoUtil.copyBean(model, CuentaXCobrar.class);
		this.deleteByPrimaryKey(CuentaXCobrarMapper.class, cuentaXCobrar);
	}

	@Override
	public List<CuentaXCobrarQuery> list(CuentaXCobrarQueryCriteria criteria) throws Exception {
		List<CuentaXCobrarQuery> list = this.selectByQuery(CuentaXCobrarQueryMapper.class, criteria, criteria.getStart(), criteria.getLimit());
		return list;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public int countRecords(CuentaXCobrarQueryCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(CuentaXCobrarQueryMapper.class, criteria);
		return count;
	}

    @Transactional(rollbackForClassName = {"Exception"})
    private void insertNewRecordsCuentaAmortizacionQuery(List<CuentaAmortizacionQuery> listCuentaAmortizacionQuery, Integer id) throws Exception{

        for(CuentaAmortizacionQuery cuentaAmortizacionQuery : listCuentaAmortizacionQuery){

            if(cuentaAmortizacionQuery.isNewEntry()){
                cuentaAmortizacionQuery.setId_cuenta_x_cobrar(id);
                CuentaAmortizacion cuentaAmortizacion = dtoUtil.copyBean(cuentaAmortizacionQuery, CuentaAmortizacion.class);                
                this.insertSelective(CuentaAmortizacionMapper.class, cuentaAmortizacion);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void updateModifiedRecordsCuentaAmortizacionQuery(List<CuentaAmortizacionQuery> listCuentaAmortizacionQuery) throws Exception{

        for(CuentaAmortizacionQuery cuentaAmortizacionQuery : listCuentaAmortizacionQuery){

            if(cuentaAmortizacionQuery.isUpdatedRecord()){
            	CuentaAmortizacion cuentaAmortizacion = dtoUtil.copyBean(cuentaAmortizacionQuery, CuentaAmortizacion.class);
            	this.updateByPrimaryKeySelective(CuentaAmortizacionMapper.class, cuentaAmortizacion);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void removeRecordsCuentaAmortizacionQuery(List<CuentaAmortizacionQuery> listCuentaAmortizacionQuery, boolean onlyFlag) throws Exception{

    	for(CuentaAmortizacionQuery cuentaAmortizacionQuery : listCuentaAmortizacionQuery){

            if(onlyFlag){
                if(cuentaAmortizacionQuery.isRemovedRecord()){
                    CuentaAmortizacion cuentaAmortizacion = dtoUtil.copyBean(cuentaAmortizacionQuery, CuentaAmortizacion.class);
                    this.deleteByPrimaryKey(CuentaAmortizacionMapper.class, cuentaAmortizacion);
                }
            }else{
            	CuentaAmortizacion cuentaAmortizacion = dtoUtil.copyBean(cuentaAmortizacionQuery, CuentaAmortizacion.class);
                this.deleteByPrimaryKey(CuentaAmortizacionMapper.class, cuentaAmortizacion);
            }

        }

    }	
}
