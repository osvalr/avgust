package com.acme.commons.business.implement;

import com.acme.commons.business.service.IGestionarVendedorService;
import com.acme.commons.repository.service.IPersonaRepository;
import com.acme.jpa.domain.PersonaEntity;
import com.acme.mybatis.query.mapper.CodClienteMaximoQueryMapper;
import com.acme.mybatis.query.mapper.CodVendedorMaximoQueryMapper;
import com.acme.mybatis.query.model.*;
import com.acme.util.DtoUtil;
import com.acme.util.MybatisRepositoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

/**
 * Created by JRaffo on 16/10/15.
 */

@Service
public class GestionarVendedorService extends MybatisRepositoryHelper implements IGestionarVendedorService {

    @Autowired
    DtoUtil dto;

    @Autowired
    IPersonaRepository iPersonaRepository;

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public Integer create(VendedorQuery vendedorQuery) throws Exception {

        PersonaEntity personaEntity = dto.copyBean(vendedorQuery,PersonaEntity.class);

        //Codigo Vendedor
        Calendar c = Calendar.getInstance();

        CodVendedorMaximoQueryCriteria codVendedorMaximoQueryCriteria = new CodVendedorMaximoQueryCriteria();
        CodVendedorMaximoQuery codVendedorMaximoQuery = this.selectOneByQuery(CodVendedorMaximoQueryMapper.class,codVendedorMaximoQueryCriteria);

        String str = codVendedorMaximoQuery.getCod_vendedor_max();
        String[] arrStr = str.split("-");
        Formatter fmt = new Formatter();
        int num = Integer.parseInt(arrStr[2]);

        fmt.format("%06d", ++num);

        String newCod = "VEN" + "-" + c.get(Calendar.YEAR) + "-" + fmt.toString();

        fmt.close();

        personaEntity.setCod_persona(newCod);

        //Auditoria
        personaEntity.setFec_reg(new Timestamp(new Date().getTime()));
        personaEntity.setId_user(1);
        personaEntity.setId_user_mod(1);

        personaEntity.setId_tipo_persona(1); //P. Natural
        personaEntity.setId_sub_tipo_persona(1); //Vendedor


        iPersonaRepository.create(personaEntity);
        Integer lastId = personaEntity.getId_persona();

        return lastId;

    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public void save(VendedorQuery vendedorQuery) throws Exception {
        PersonaEntity personaEntity = dto.copyBean(vendedorQuery,PersonaEntity.class);

        //Auditoria
        personaEntity.setFec_reg(new Timestamp(new Date().getTime()));
        personaEntity.setId_user(1);
        personaEntity.setId_user_mod(1);

        personaEntity.setId_tipo_persona(1); //P. Natural
        personaEntity.setId_sub_tipo_persona(1); //Vendedor

        iPersonaRepository.update(personaEntity);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public void remove(VendedorQuery vendedorQuery) throws Exception {
        PersonaEntity personaEntity = dto.copyBean(vendedorQuery,PersonaEntity.class);
        iPersonaRepository.delete(personaEntity);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public <T> List<T> list(Class mapperClass, VendedorQueryCriteria vendedorQueryCriteria, boolean pagination) throws Exception {
        return this.selectByQuery(mapperClass,vendedorQueryCriteria,pagination);
    }

}
