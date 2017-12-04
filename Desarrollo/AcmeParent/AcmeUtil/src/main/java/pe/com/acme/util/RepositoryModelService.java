package pe.com.acme.util;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by JRaffo on 23/11/16.
 */
public abstract class RepositoryModelService<Model,Criteria> implements IRepositoryModelService<Model,Criteria>,ApplicationContextAware {

    private static Logger log = Logger.getLogger(RepositoryModelService.class);

    private PagingAndSortingRepository repository;
    private Class<?> entity;
    private Class<?> mapperMybatis;

    @Autowired
    private DtoUtil dtoUtil;

    @Override
    public void create(Model model) throws Exception {

        validate();

        Object objEntity = dtoUtil.copyBean(model,entity);

        repository.save(objEntity);

        model = dtoUtil.copyBean(objEntity,model);

    }

    @Override
    public void update(Model model) throws Exception {

        this.create(model);

    }

    @Override
    public void destroy(Model model) throws Exception {

        validate();
        Object objEntity = dtoUtil.copyBean(model,entity);

        repository.delete(objEntity);
    }

    @Override
    public List<Model> query(Criteria criteria) throws Exception {

        validate();
        List<Model> list = selectByQuery(mapperMybatis,criteria);
        return list;
    }

    @Override
    public List<Model> query(Criteria criteria, Integer start, Integer limit) throws Exception {

        validate();

        List<Model> list = selectByQuery(mapperMybatis,criteria,start,limit);
        return list;
    }

    @Override
    public Model recordQuery(Criteria criteria) throws Exception {
        validate();
        return selectOneByQuery(mapperMybatis,criteria);
    }

    @Override
    public Integer countRecords(Criteria criteria) throws Exception {
        validate();
        int count = selectCountByQuery(mapperMybatis,criteria);
        return count;
    }

    private List<Model> selectByQuery(Class mapperQuery, Object criteria) throws Exception {

        String operation = "getListQueryByCriteria";
        List<Model> list = null;

        list = executeQuery(operation,mapperQuery,criteria);

        return list;
    }

    private List<Model> selectByQuery(Class mapperCriteria, Object criteria, Integer start, Integer limit) throws Exception {
        String operation = "getListQueryPaginationByCriteria";
        List<Model> list = null;

        list = executeQuery(operation,mapperCriteria,criteria,start,limit);

        return list;
    }

    private Integer selectCountByQuery(Class mapperCriteria, Object criteria) throws Exception {
        String operation = "getCountRowsByCriteria";
        Integer count = null;

        count = this.executeCountQuery(operation, mapperCriteria, criteria);

        return count;
    }

    private Integer executeCountQuery(String operation, Class mapperCriteria, Object criteria) throws Exception {
        Integer count = null;

        if (this.getSqlSession() != null) {
            for (Method method : mapperCriteria.getMethods()) {
                if (method.getName().equals(operation)) {

                    Object mapper = this.getSqlSession().getMapper(mapperCriteria);
                    Object parameters[] =  { criteria };

                    try {

                        count =  (Integer) method.invoke(mapper, parameters);

                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(),e);
                        throw new Exception(e.getMessage(), e);
                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage(),e);
                        throw new Exception(e.getMessage(), e);
                    }
                    break;
                }
            }
        }
        return count;
    }

    private List<Model> executeQuery(String operation, Class mapperQuery, Object criteria) throws Exception {

        List<Model> list = null;

        if (this.getSqlSession() != null) {
            for (Method method : mapperQuery.getMethods()) {
                if (method.getName().equals(operation)) {

                    Object mapper = this.getSqlSession().getMapper(mapperQuery);
                    Object parameters[] =  { criteria };

                    try {

                        list = (List<Model>) method.invoke(mapper, parameters);

                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(),e);
                        throw new Exception(e.getMessage(), e);
                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage(),e);
                        throw new Exception(e.getMessage(), e);
                    }
                    break;
                }
            }
        }

        return list;
    }

    private List<Model> executeQuery(String operation, Class mapperCriteria, Object criteria, Integer start, Integer limit) throws Exception {

        List<Model> list = null;

        if (this.getSqlSession() != null) {
            for (Method method : mapperCriteria.getMethods()) {
                if (method.getName().equals(operation)) {

                    Object mapper = this.getSqlSession().getMapper(mapperCriteria);
                    RowBounds rb = new RowBounds(start,limit);
                    Object parameters[] =  { criteria,rb };

                    try {

                        list = (List<Model>) method.invoke(mapper, parameters);

                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(),e);
                        throw new Exception(e.getMessage(), e);
                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage(),e);
                        throw new Exception(e.getMessage(), e);
                    }
                    break;
                }
            }
        }

        return list;
    }

    private Model selectOneByQuery(Class mapperCriteria, Object criteria) throws Exception {
        List<Model> list = null;
        list = this.selectByQuery(mapperCriteria, criteria);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    private void validate() throws Exception{
        if(repository == null){
            throw new AcmeException("Repository is null");
        }

        if(entity == null){
            throw new AcmeException("Class Entity is null");
        }

        if(mapperMybatis == null){
            throw new AcmeException("Class Mapper is null");
        }
    }

    public void setRepository(PagingAndSortingRepository pagingAndSortingRepository, Class clazzEntity, Class clazzMapper) {
        this.repository = pagingAndSortingRepository;
        this.entity = clazzEntity;
        this.mapperMybatis = clazzMapper;
    }


    @Override
    public void setApplicationContext(ApplicationContext arg0) {
        SpringContextUtil.setCtx(arg0);
    }

    private ApplicationContext getApplicationContext(){
        return SpringContextUtil.getCtx();
    }

    private SqlSession getSqlSession(){
        return (SqlSession) getApplicationContext().getBean("sqlSession");
    }

}
