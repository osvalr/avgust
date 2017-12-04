/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.focus.generator.crud.extjs.xbean;

/**
 *
 * @author JRaffo
 */
public class EntityBean {
    
    private String classEntity;
    private String mapperClassEntity;
    private String primaryKeyEntity;
    private String joinProperty;
    private String entityRefer;
    private String returnLastId;

    public String getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(String classEntity) {
        this.classEntity = classEntity;
    }

    public String getMapperClassEntity() {
        return mapperClassEntity;
    }

    public void setMapperClassEntity(String mapperClassEntity) {
        this.mapperClassEntity = mapperClassEntity;
    }

    public String getPrimaryKeyEntity() {
        return primaryKeyEntity;
    }

    public void setPrimaryKeyEntity(String primaryKeyEntity) {
        this.primaryKeyEntity = primaryKeyEntity;
    }

    public String getJoinProperty() {
        return joinProperty;
    }

    public void setJoinProperty(String joinProperty) {
        this.joinProperty = joinProperty;
    }

    public String getEntityRefer() {
        return entityRefer;
    }

    public void setEntityRefer(String entityRefer) {
        this.entityRefer = entityRefer;
    }

    public String getReturnLastId() {
        return returnLastId;
    }

    public void setReturnLastId(String returnLastId) {
        this.returnLastId = returnLastId;
    }
    
}
