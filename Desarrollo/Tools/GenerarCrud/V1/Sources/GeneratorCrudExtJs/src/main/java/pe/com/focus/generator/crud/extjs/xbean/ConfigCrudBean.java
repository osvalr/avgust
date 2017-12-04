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
public class ConfigCrudBean {

    private String xmlModel;
    private String nameCrud;
    private String titleCrud;
    private String servicePackage;
    private String implementPackage;
    private String controllerPackage;
    private String generateServiceImplemente;
    private String generateControllerBackend;
    private String generateControllerFrontEnd;
    private String generateStoreExtJs;
    private String generateModelExtjs;
    private ModelBean modelBean;
    private String type;

    public String getNameCrud() {
        return nameCrud;
    }

    public void setNameCrud(String nameCrud) {
        this.nameCrud = nameCrud;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getImplementPackage() {
        return implementPackage;
    }

    public void setImplementPackage(String implementPackage) {
        this.implementPackage = implementPackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getGenerateServiceImplemente() {
        return generateServiceImplemente;
    }

    public void setGenerateServiceImplemente(String generateServiceImplemente) {
        this.generateServiceImplemente = generateServiceImplemente;
    }

    public String getGenerateControllerBackend() {
        return generateControllerBackend;
    }

    public void setGenerateControllerBackend(String generateControllerBackend) {
        this.generateControllerBackend = generateControllerBackend;
    }

    public String getGenerateControllerFrontEnd() {
        return generateControllerFrontEnd;
    }

    public void setGenerateControllerFrontEnd(String generateControllerFrontEnd) {
        this.generateControllerFrontEnd = generateControllerFrontEnd;
    }

    public String getGenerateStoreExtJs() {
        return generateStoreExtJs;
    }

    public void setGenerateStoreExtJs(String generateStoreExtJs) {
        this.generateStoreExtJs = generateStoreExtJs;
    }

    public ModelBean getModelBean() {
        return modelBean;
    }

    public void setModelBean(ModelBean modelBean) {
        this.modelBean = modelBean;
    }

    public String getGenerateModelExtjs() {
        return generateModelExtjs;
    }

    public void setGenerateModelExtjs(String generateModelExtjs) {
        this.generateModelExtjs = generateModelExtjs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitleCrud() {
        return titleCrud;
    }

    public void setTitleCrud(String titleCrud) {
        this.titleCrud = titleCrud;
    }
    public String getXmlModel() {
        return xmlModel;
    }

    public void setXmlModel(String xmlModel) {
        this.xmlModel = xmlModel;
    }
}
