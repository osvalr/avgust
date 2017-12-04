package com.acme.commons.business.implement;

import com.acme.commons.business.service.IGestionarClienteService;
import com.acme.commons.repository.service.IPersonaRepository;
import com.acme.jpa.domain.PersonaEntity;
import com.acme.mybatis.query.mapper.CodClienteMaximoQueryMapper;
import com.acme.mybatis.query.model.ClienteQuery;
import com.acme.mybatis.query.model.ClienteQueryCriteria;
import com.acme.mybatis.query.model.CodClienteMaximoQuery;
import com.acme.mybatis.query.model.CodClienteMaximoQueryCriteria;
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
public class GestionarClienteService extends MybatisRepositoryHelper implements IGestionarClienteService {

    @Autowired
    DtoUtil dto;

    @Autowired
    IPersonaRepository iPersonaRepository;

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public Integer create(ClienteQuery clienteQuery) throws Exception {

        PersonaEntity personaEntity = dto.copyBean(clienteQuery,PersonaEntity.class);

        //Codigo Cliente
        Calendar c = Calendar.getInstance();

        CodClienteMaximoQueryCriteria codClienteMaximoQueryCriteria = new CodClienteMaximoQueryCriteria();
        CodClienteMaximoQuery codClienteMaximoQuery = this.selectOneByQuery(CodClienteMaximoQueryMapper.class,codClienteMaximoQueryCriteria);

        String str = codClienteMaximoQuery.getCod_cliente_max();
        String[] arrStr = str.split("-");
        Formatter fmt = new Formatter();
        int num = Integer.parseInt(arrStr[2]);

        fmt.format("%06d", ++num);

        String newCod = "CLI" + "-" + c.get(Calendar.YEAR) + "-" + fmt.toString();

        fmt.close();

        personaEntity.setCod_persona(newCod);


        //Auditoria
        personaEntity.setFec_reg(new Timestamp(new Date().getTime()));
        personaEntity.setId_user(1);
        personaEntity.setId_user_mod(1);

        if(personaEntity.getId_sub_tipo_persona().intValue() == 2){
            personaEntity.setId_tipo_docu_iden(1); //DNI
            personaEntity.setId_tipo_persona(1); //P. Natural
        }else{
            personaEntity.setId_tipo_docu_iden(2); //RUC
            personaEntity.setId_tipo_persona(2); //P. Juridica
        }

        iPersonaRepository.create(personaEntity);
        Integer lastId = personaEntity.getId_persona();

        return lastId;

    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public void save(ClienteQuery clienteQuery) throws Exception {
        PersonaEntity personaEntity = dto.copyBean(clienteQuery,PersonaEntity.class);

        if(personaEntity.getId_sub_tipo_persona().intValue() == 2){
            personaEntity.setId_tipo_docu_iden(1); //DNI
            personaEntity.setId_tipo_persona(1); //P. Natural
        }else{
            personaEntity.setId_tipo_docu_iden(2); //RUC
            personaEntity.setId_tipo_persona(2); //P. Juridica
        }

        iPersonaRepository.update(personaEntity);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public void remove(ClienteQuery clienteQuery) throws Exception {

        PersonaEntity personaEntity = dto.copyBean(clienteQuery,PersonaEntity.class);
        iPersonaRepository.delete(personaEntity);

    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public <T> List<T> list(Class mapperClass, ClienteQueryCriteria clienteQueryCriteria, boolean pagination) throws Exception {
        return this.selectByQuery(mapperClass,clienteQueryCriteria,pagination);
    }

}
