package com.acme.commons.business.implement;

import com.acme.commons.business.service.IGestionarCotizacionService;
import com.acme.commons.repository.service.ICotizacionProductoRepository;
import com.acme.commons.repository.service.ICotizacionRepository;
import com.acme.jpa.domain.CotizacionEntity;
import com.acme.jpa.domain.CotizacionProductoEntity;
import com.acme.mybatis.query.mapper.CodCotizacionMaximoQueryMapper;
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
public class GestionarCotizacionService extends MybatisRepositoryHelper implements IGestionarCotizacionService {

    @Autowired
    DtoUtil dto;

    @Autowired
    ICotizacionRepository iCotizacionRepository;

    @Autowired
    ICotizacionProductoRepository iCotizacionProductoRepository;

    @Override
    public Integer create(CotizacionQuery cotizacionQuery) throws Exception {

        CotizacionEntity cotizacionEntity = dto.copyBean(cotizacionQuery,CotizacionEntity.class);

        //Codigo Producto
        Calendar c = Calendar.getInstance();

        CodCotizacionMaximoQueryCriteria codCotizacionMaximoQueryCriteria = new CodCotizacionMaximoQueryCriteria();
        CodCotizacionMaximoQuery codCotizacionMaximoQuery = this.selectOneByQuery(CodCotizacionMaximoQueryMapper.class,codCotizacionMaximoQueryCriteria);

        String str = codCotizacionMaximoQuery.getCod_cotizacion_max();
        String[] arrStr = str.split("-");
        Formatter fmt = new Formatter();
        int num = Integer.parseInt(arrStr[2]);

        fmt.format("%06d", ++num);

        String newCod = "COT" + "-" + c.get(Calendar.YEAR) + "-" + fmt.toString();

        fmt.close();

        cotizacionEntity.setCod_cotizacion(newCod);


        //Auditoria
        cotizacionEntity.setFec_reg(new Timestamp(new Date().getTime()));
        cotizacionEntity.setId_user(1);
        cotizacionEntity.setId_user_mod(1);

        iCotizacionRepository.create(cotizacionEntity);
        Integer lastId = cotizacionEntity.getId_cotizacion();

        //this.insertNewRecords(cotizacionQuery.getCotizacionProductoQueryList(), lastId);

        return lastId;

    }

    @Override
    public void save(CotizacionQuery cotizacionQuery) throws Exception {

        CotizacionEntity cotizacionEntity = dto.copyBean(cotizacionQuery,CotizacionEntity.class);
        iCotizacionRepository.update(cotizacionEntity);

        //this.insertNewRecords(cotizacionQuery.getCotizacionProductoQueryList(),cotizacionQuery.getId_cotizacion());
        //this.updateModifiedRecords(cotizacionQuery.getCotizacionProductoQueryList());
        //this.removeRecords(cotizacionQuery.getCotizacionProductoQueryList(), true);

    }

    @Override
    public void remove(CotizacionQuery cotizacionQuery) throws Exception {

        //this.removeRecords(cotizacionQuery.getCotizacionProductoQueryList(),false);

        CotizacionEntity cotizacionEntity = dto.copyBean(cotizacionQuery,CotizacionEntity.class);
        iCotizacionRepository.delete(cotizacionEntity);

    }

    @Override
    public <T> List<T> list(Class mapperClass, CotizacionQueryCriteria cotizacionQueryCriteria, boolean pagination) throws Exception {
        return this.selectByQuery(mapperClass,cotizacionQueryCriteria,pagination);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void insertNewRecords(List<CotizacionProductoQuery> cotizacionProductoQueryList, Integer id) throws Exception{

        for(CotizacionProductoQuery cotizacionProductoQuery : cotizacionProductoQueryList){

            if(cotizacionProductoQuery.isNewEntry()){
                CotizacionProductoEntity cotizacionProductoEntity = dto.copyBean(cotizacionProductoQuery,CotizacionProductoEntity.class);
                cotizacionProductoEntity.setId_cotizacion_producto(null);
                CotizacionEntity cotizacionEntity = new CotizacionEntity();
                cotizacionEntity.setId_cotizacion(id);
                cotizacionProductoEntity.setCotizacion(cotizacionEntity);
                iCotizacionProductoRepository.create(cotizacionProductoEntity);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void updateModifiedRecords(List<CotizacionProductoQuery> cotizacionProductoQueryList) throws Exception{

        for(CotizacionProductoQuery cotizacionProductoQuery : cotizacionProductoQueryList){

            if(cotizacionProductoQuery.isUpdatedRecord()){
                CotizacionProductoEntity cotizacionProductoEntity = dto.copyBean(cotizacionProductoQuery,CotizacionProductoEntity.class);
                iCotizacionProductoRepository.update(cotizacionProductoEntity);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void removeRecords(List<CotizacionProductoQuery> cotizacionProductoQueryList, boolean check) throws Exception{

        for(CotizacionProductoQuery cotizacionProductoQuery : cotizacionProductoQueryList){

            if(check){
                if(cotizacionProductoQuery.isRemovedRecord()){
                    CotizacionProductoEntity cotizacionProductoEntity = dto.copyBean(cotizacionProductoQuery,CotizacionProductoEntity.class);
                    iCotizacionProductoRepository.delete(cotizacionProductoEntity);
                }
            }else{
                CotizacionProductoEntity cotizacionProductoEntity = dto.copyBean(cotizacionProductoQuery,CotizacionProductoEntity.class);
                iCotizacionProductoRepository.delete(cotizacionProductoEntity);
            }

        }

    }

}
