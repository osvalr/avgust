package com.acme.commons.business.implement;

import com.acme.commons.business.service.IGestionarProductoService;
import com.acme.commons.repository.service.IProductoRepository;
import com.acme.jpa.domain.ProductoEntity;
import com.acme.mybatis.query.mapper.CodClienteMaximoQueryMapper;
import com.acme.mybatis.query.mapper.CodProductoMaximoQueryMapper;
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
public class GestionarProductoService extends MybatisRepositoryHelper implements IGestionarProductoService {

    @Autowired
    DtoUtil dto;

    @Autowired
    IProductoRepository iProductoRepository;


    @Transactional
    @Override
    public Integer create(ProductoQuery productoQuery) throws Exception {

        ProductoEntity productoEntity = dto.copyBean(productoQuery,ProductoEntity.class);

        //Codigo Producto
        Calendar c = Calendar.getInstance();

        CodProductoMaximoQueryCriteria codProductoMaximoQueryCriteria = new CodProductoMaximoQueryCriteria();
        CodProductoMaximoQuery codProductoMaximoQuery = this.selectOneByQuery(CodProductoMaximoQueryMapper.class,codProductoMaximoQueryCriteria);

        String str = codProductoMaximoQuery.getCod_producto_max();
        String[] arrStr = str.split("-");
        Formatter fmt = new Formatter();
        int num = Integer.parseInt(arrStr[2]);

        fmt.format("%06d", ++num);

        String newCod = "PRO" + "-" + c.get(Calendar.YEAR) + "-" + fmt.toString();

        fmt.close();

        productoEntity.setCod_producto(newCod);


        //Auditoria
        productoEntity.setFec_reg(new Timestamp(new Date().getTime()));
        productoEntity.setId_user(1);
        productoEntity.setId_user_mod(1);

        iProductoRepository.create(productoEntity);
        Integer lastId = productoEntity.getId_producto();

        return lastId;

    }

    @Transactional
    @Override
    public void save(ProductoQuery productoQuery) throws Exception {
        ProductoEntity productoEntity = dto.copyBean(productoQuery,ProductoEntity.class);

        //Auditoria
        productoEntity.setFec_reg(new Timestamp(new Date().getTime()));
        productoEntity.setId_user(1);
        productoEntity.setId_user_mod(1);

        iProductoRepository.update(productoEntity);
    }

    @Transactional
    @Override
    public void remove(ProductoQuery productoQuery) throws Exception {
        ProductoEntity productoEntity = dto.copyBean(productoQuery,ProductoEntity.class);
        iProductoRepository.delete(productoEntity);
    }

    @Transactional
    @Override
    public <T> List<T> list(Class mapperClass, ProductoQueryCriteria productoQueryCriteria, boolean pagination) throws Exception {
        return this.selectByQuery(mapperClass,productoQueryCriteria,pagination);
    }

}
