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
public class SubModelBean {
    private String title;
    private String nameModel;
    private String classModel;
    private String classCriteriaModel;
    private String classMapperModel;
    private String keyPropertyModel;
    private String joinPropertyModel;
    private String tables;
    private EntityBean entityBean;
    private List<FieldBean> fields = new ArrayList<FieldBean>();

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
    
    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public EntityBean getEntityBean() {
        return entityBean;
    }

    public void setEntityBean(EntityBean entityBean) {
        this.entityBean = entityBean;
    }

    public List<FieldBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldBean> fields) {
        this.fields = fields;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getClassCriteriaModel() {
        return classCriteriaModel;
    }

    public void setClassCriteriaModel(String classCriteriaModel) {
        this.classCriteriaModel = classCriteriaModel;
    }

    public String getClassMapperModel() {
        return classMapperModel;
    }

    public void setClassMapperModel(String classMapperModel) {
        this.classMapperModel = classMapperModel;
    }

    public String getKeyPropertyModel() {
        return keyPropertyModel;
    }

    public void setKeyPropertyModel(String keyPropertyModel) {
        this.keyPropertyModel = keyPropertyModel;
    }

    public String getJoinPropertyModel() {
        return joinPropertyModel;
    }

    public void setJoinPropertyModel(String joinPropertyModel) {
        this.joinPropertyModel = joinPropertyModel;
    }
    
}
