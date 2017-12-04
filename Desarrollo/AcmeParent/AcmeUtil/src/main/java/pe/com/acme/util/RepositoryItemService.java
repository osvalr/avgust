package pe.com.acme.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by JRaffo on 23/11/16.
 */
@Component
public abstract class RepositoryItemService<Item,Criteria> extends MybatisRepositoryHelper implements IRepositoryItemHelper<Item,Criteria> {


    private static Logger log = Logger.getLogger(RepositoryItemService.class);

    private PagingAndSortingRepository repository;
    private Class<?> entity;
    private Class<?> mapperMybatis;

    @Autowired
    private DtoUtil dtoUtil;


//    @Override
//    public void createNewItem(Map<String,Object> mapItem, Integer id) throws Exception {
//
//        Boolean newEntry = (Boolean) mapItem.get("mapItem");
//
//        if(newEntry == null){
//            throw new AcmeException("newEntry should not be null, in the mapModel");
//        }
//
//        if(newEntry){
//            mapItem.put(nameJoinKey,id);
//            Object itemDomain = dtoUtil.copyBean(mapItem, classItemDomain);
//            this.insertSelective(classItemDomainMapper, itemDomain);
//            Object valueKey = PropertyUtils.getProperty(itemDomain,nameKey);
//            mapItem.put(nameKey,valueKey);
//        }
//
//    }
//
//    @Override
//    public void updateModifiedItem(Map<String,Object> mapItem) throws Exception {
//
//        Boolean updatedRecord = (Boolean) mapItem.get("updatedRecord");
//
//        if(updatedRecord == null){
//            throw new AcmeException("updatedRecord should not be null, in the mapModel");
//        }
//
//        if(updatedRecord){
//            Object itemDomain = dtoUtil.copyBean(mapItem, classItemDomain);
//            this.updateByPrimaryKey(classItemDomainMapper, itemDomain);
//        }
//    }
//
//    @Override
//    public void removeItem(Map<String,Object> mapItem, boolean onlyFlag) throws Exception {
//
//        Object itemDomain = dtoUtil.copyBean(mapItem, classItemDomain);
//
//        if(onlyFlag){
//
//            Boolean removedRecord = (Boolean) mapItem.get("removedRecord");
//
//            if(removedRecord == null){
//                throw new AcmeException("removedRecord should not be null, in the mapModel");
//            }
//
//            if(removedRecord){
//                this.deleteByPrimaryKey(classItemDomainMapper, itemDomain);
//            }
//
//        }else{
//            this.deleteByPrimaryKey(classItemDomainMapper, itemDomain);
//        }
//    }
//
//    @Override
//    public void createNewItem(List<Map<String,Object>> mapItems, Integer id) throws Exception {
//        for(Map<String,Object> mapItem : mapItems){
//            this.createNewItem(mapItem,id);
//        }
//    }
//
//    @Override
//    public void updateModifiedItem(List<Map<String,Object>> mapItems) throws Exception {
//        for(Map<String,Object> mapItem : mapItems){
//            this.updateModifiedItem(mapItem);
//        }
//    }
//
//    @Override
//    public void removeItem(List<Map<String,Object>> mapItems, boolean onlyFlag) throws Exception {
//        for(Map<String,Object> mapItem : mapItems){
//            this.removeItem(mapItem,onlyFlag);
//        }
//    }
//
//    @Override
//    public List<Map<String,Object>> list(Map<String,Object> mapCriteria) throws Exception {
//
//        List<Map<String,Object>> mapList = new ArrayList<>();
//
//        Integer start = (Integer) mapCriteria.get("start");
//        Integer limit = (Integer) mapCriteria.get("limit");
//
//        String order_column = (String) mapCriteria.get("order_column");
//        String order_direction = (String) mapCriteria.get("order_direction");
//
//        if(start == null){
//            throw new AcmeException("start should not be null, in the mapCriteria");
//        }
//
//        if(limit == null){
//            throw new AcmeException("limit should not be null, in the mapCriteria");
//        }
//
//        if(order_column == null){
//            throw new AcmeException("order_column should not be null, in the mapCriteria");
//        }
//
//        if(order_direction == null){
//            throw new AcmeException("order_direction should not be null, in the mapCriteria");
//        }
//
//        List<Item> list = this.selectByQuery(classItemMapper, mapCriteria, start, limit);
//
//        for (Item item: list) {
//            Map<String,Object> mapModel = objectMapper.convertValue(item,Map.class);
//            mapList.add(mapModel);
//        }
//
//        return mapList;
//    }
//
//    @Override
//    public int countItems(Map<String,Object> mapCriteria) throws Exception {
//        int count = this.selectCountByQuery(classItemMapper, mapCriteria);
//        return count;
//    }
//    public void setRepository(PagingAndSortingRepository pagingAndSortingRepository, Class clazzEntity, Class clazzMapper) {
//        this.repository = pagingAndSortingRepository;
//        this.entity = clazzEntity;
//        this.mapperMybatis = clazzMapper;
//    }
}
