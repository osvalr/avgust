/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.focus.generator.crud.extjs.xbean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JRaffo
 */
public class ModelBean {
    
    private String title;
    private String nameModel;
    private String classModel;
    private String criteriaModel;
    private String mapperModel;
    private String keyProperty;
    private String tables;
    private List<EntityBean> entities = new ArrayList<EntityBean>();
    private List<FieldBean> fields = new ArrayList<FieldBean>();
    private List<FieldBean> criteriaFields = new ArrayList<FieldBean>();
    private List<SubModelBean> subModels = new ArrayList<SubModelBean>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassModel() {
        return classModel;
    }

    public void setClassModel(String classModel) {
        this.classModel = classModel;
    }

    public String getCriteriaModel() {
        return criteriaModel;
    }

    public void setCriteriaModel(String criteriaModel) {
        this.criteriaModel = criteriaModel;
    }

    public String getMapperModel() {
        return mapperModel;
    }

    public void setMapperModel(String mapperModel) {
        this.mapperModel = mapperModel;
    }

    public String getKeyProperty() {
        return keyProperty;
    }

    public void setKeyProperty(String keyProperty) {
        this.keyProperty = keyProperty;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public List<EntityBean> getEntities() {
        return entities;
    }

    public void setEntities(List<EntityBean> entities) {
        this.entities = entities;
    }

    public List<FieldBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldBean> fields) {
        this.fields = fields;
    }

    public List<FieldBean> getCriteriaFields() {
        return criteriaFields;
    }

    public void setCriteriaFields(List<FieldBean> criteriaFields) {
        this.criteriaFields = criteriaFields;
    }

    public List<SubModelBean> getSubModels() {
        return subModels;
    }

    public void setSubModels(List<SubModelBean> subModels) {
        this.subModels = subModels;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }
    
}
