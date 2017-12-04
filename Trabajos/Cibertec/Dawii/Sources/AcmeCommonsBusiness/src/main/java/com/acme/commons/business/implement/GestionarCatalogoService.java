package com.acme.commons.business.implement;

import com.acme.commons.business.service.IGestionarCatalogoService;
import com.acme.commons.repository.service.ICatalogoItemRepository;
import com.acme.commons.repository.service.ICatalogoRepository;
import com.acme.jpa.domain.CatalogoEntity;
import com.acme.jpa.domain.CatalogoItemEntity;
import com.acme.mybatis.query.model.CatalogoItemQuery;
import com.acme.mybatis.query.model.CatalogoQuery;
import com.acme.mybatis.query.model.CatalogoQueryCriteria;
import com.acme.util.DtoUtil;
import com.acme.util.MybatisRepositoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GestionarCatalogoService extends MybatisRepositoryHelper implements IGestionarCatalogoService {

    @Autowired
    DtoUtil dto;

    @Autowired
    ICatalogoRepository iCatalogoRepository;

    @Autowired
    ICatalogoItemRepository iCatalogoItemRepository;

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public Integer create(CatalogoQuery catalogoQuery) throws Exception {

        CatalogoEntity catalogoEntity = dto.copyBean(catalogoQuery,CatalogoEntity.class);
        iCatalogoRepository.create(catalogoEntity);
        Integer lastId = catalogoEntity.getId_catalogo();

        this.insertNewRecords(catalogoQuery.getCatalogoItemQueryList(), lastId);

        return lastId;

    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public void save(CatalogoQuery catalogoQuery) throws Exception {

        CatalogoEntity catalogoEntity = dto.copyBean(catalogoQuery,CatalogoEntity.class);
        iCatalogoRepository.update(catalogoEntity);

        this.insertNewRecords(catalogoQuery.getCatalogoItemQueryList(),catalogoEntity.getId_catalogo());
        this.updateModifiedRecords(catalogoQuery.getCatalogoItemQueryList());
        this.removeRecords(catalogoQuery.getCatalogoItemQueryList(), true);

    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public void remove(CatalogoQuery catalogoQuery) throws Exception {

        this.removeRecords(catalogoQuery.getCatalogoItemQueryList(),false);

        CatalogoEntity catalogoEntity = dto.copyBean(catalogoQuery,CatalogoEntity.class);
        iCatalogoRepository.delete(catalogoEntity);

    }

    @Transactional(rollbackForClassName = {"Exception"})
    @Override
    public <T>  List<T> list(Class mapperClass, CatalogoQueryCriteria catalogoQueryCriteria, boolean pagination) throws Exception {
        return this.selectByQuery(mapperClass,catalogoQueryCriteria,pagination);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void insertNewRecords(List<CatalogoItemQuery> catalogoItemQueryList, Integer id) throws Exception{

        if(catalogoItemQueryList == null){
            return;
        }

        for(CatalogoItemQuery catalogoItemQuery : catalogoItemQueryList){

            if(catalogoItemQuery.isNewEntry()){
                CatalogoItemEntity catalogoItemEntity = dto.copyBean(catalogoItemQuery,CatalogoItemQuery.class);
                catalogoItemEntity.setId_catalogo_item(null);

                CatalogoEntity catalogoEntity = new CatalogoEntity();
                catalogoEntity.setId_catalogo(id);

                catalogoItemEntity.setCatalogo(catalogoEntity);
                iCatalogoItemRepository.create(catalogoItemEntity);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void updateModifiedRecords(List<CatalogoItemQuery> catalogoItemQueryList) throws Exception {

        if(catalogoItemQueryList == null){
            return;
        }

        for(CatalogoItemQuery catalogoItemQuery : catalogoItemQueryList){

            if(catalogoItemQuery.isUpdatedRecord()){
                CatalogoItemEntity catalogoItemEntity = dto.copyBean(catalogoItemQuery,CatalogoItemQuery.class);
                iCatalogoItemRepository.update(catalogoItemEntity);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void removeRecords(List<CatalogoItemQuery> catalogoItemQueryList, boolean check) throws Exception{

        if(catalogoItemQueryList == null){
            return;
        }

        for(CatalogoItemQuery catalogoItemQuery : catalogoItemQueryList){

            if(check){
                if(catalogoItemQuery.isRemovedRecord()){
                    CatalogoItemEntity catalogoItemEntity = dto.copyBean(catalogoItemQuery,CatalogoItemQuery.class);
                    iCatalogoItemRepository.delete(catalogoItemEntity);
                }
            }else{
                CatalogoItemEntity catalogoItemEntity = dto.copyBean(catalogoItemQuery,CatalogoItemQuery.class);
                iCatalogoItemRepository.delete(catalogoItemEntity);
            }

        }

    }

}
