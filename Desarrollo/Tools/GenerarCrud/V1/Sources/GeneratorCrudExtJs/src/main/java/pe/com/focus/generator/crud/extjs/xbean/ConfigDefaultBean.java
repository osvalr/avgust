package pe.com.focus.generator.crud.extjs.xbean;

import java.util.ArrayList;
import java.util.List;

public class ConfigDefaultBean {
    
    private String pathMainProject;
    private String nameApp;
    private String pathExtjsApp;
    private String pathTemplates;
    private String pathRepositoryProject;
    private String packageModel;
    private String packageMapperModel;
    private String pathEntitiesProject;
    private String packageEntity;
    private String packageMapperEntity;
    private String pathServiceProject;
    private String packageService;
    private String packageImplement;
    private String pathWebProject;
    private String packageController;
    private String typePersistence;
    private String typeFwWeb;
    private String pathResultXmlFile;
    
    private List<ConfigCrudBean> listConfigCrudBean = new ArrayList<ConfigCrudBean>();

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    public String getPathExtjsApp() {
        return pathExtjsApp;
    }

    public void setPathExtjsApp(String pathExtjsApp) {
        this.pathExtjsApp = pathExtjsApp;
    }

    public String getPathTemplates() {
        return pathTemplates;
    }

    public void setPathTemplates(String pathTemplates) {
        this.pathTemplates = pathTemplates;
    }

    public String getPathRepositoryProject() {
        return pathRepositoryProject;
    }

    public void setPathRepositoryProject(String pathRepositoryProject) {
        this.pathRepositoryProject = pathRepositoryProject;
    }

    public String getPathServiceProject() {
        return pathServiceProject;
    }

    public void setPathServiceProject(String pathServiceProject) {
        this.pathServiceProject = pathServiceProject;
    }

    public String getPathWebProject() {
        return pathWebProject;
    }

    public void setPathWebProject(String pathWebProject) {
        this.pathWebProject = pathWebProject;
    }

    public String getTypePersistence() {
        return typePersistence;
    }

    public void setTypePersistence(String typePersistence) {
        this.typePersistence = typePersistence;
    }

    public String getTypeFwWeb() {
        return typeFwWeb;
    }

    public void setTypeFwWeb(String typeFwWeb) {
        this.typeFwWeb = typeFwWeb;
    }

    public String getPackageModel() {
        return packageModel;
    }

    public void setPackageModel(String packageModel) {
        this.packageModel = packageModel;
    }

    public String getPackageMapperModel() {
        return packageMapperModel;
    }

    public void setPackageMapperModel(String packageMapperModel) {
        this.packageMapperModel = packageMapperModel;
    }

    public String getPackageEntity() {
        return packageEntity;
    }

    public void setPackageEntity(String packageEntity) {
        this.packageEntity = packageEntity;
    }

    public String getPackageMapperEntity() {
        return packageMapperEntity;
    }

    public void setPackageMapperEntity(String packageMapperEntity) {
        this.packageMapperEntity = packageMapperEntity;
    }

    public String getPackageService() {
        return packageService;
    }

    public void setPackageService(String packageService) {
        this.packageService = packageService;
    }

    public String getPackageImplement() {
        return packageImplement;
    }

    public void setPackageImplement(String packageImplement) {
        this.packageImplement = packageImplement;
    }

    public String getPackageController() {
        return packageController;
    }

    public void setPackageController(String packageController) {
        this.packageController = packageController;
    }

    @Override
    public String toString() {
        return "ConfigDefaultBean{" + "nameApp=" + getNameApp() + ", pathExtjsApp=" + getPathExtjsApp() + ", pathTemplates=" + getPathTemplates() + ", pathRepositoryProject=" + getPathRepositoryProject() + ", packageModel=" + getPackageModel() + ", packageMapperModel=" + getPackageMapperModel() + ", packageEntity=" + getPackageEntity() + ", packageMapperEntity=" + getPackageMapperEntity() + ", pathServiceProject=" + getPathServiceProject() + ", packageService=" + getPackageService() + ", packageImplement=" + getPackageImplement() + ", pathWebProject=" + getPathWebProject() + ", packageController=" + getPackageController() + ", typePersistence=" + getTypePersistence() + ", typeFwWeb=" + getTypeFwWeb() + '}';
    }

    public List<ConfigCrudBean> getListConfigCrudBean() {
        return listConfigCrudBean;
    }

    public void setListConfigCrudBean(List<ConfigCrudBean> listConfigCrudBean) {
        this.listConfigCrudBean = listConfigCrudBean;
    }

    public String getPathEntitiesProject() {
        return pathEntitiesProject;
    }

    public void setPathEntitiesProject(String pathEntitiesProject) {
        this.pathEntitiesProject = pathEntitiesProject;
    }

    public String getPathMainProject() {
        return pathMainProject;
    }

    public void setPathMainProject(String pathMainProject) {
        this.pathMainProject = pathMainProject;
    }

    public String getPathResultXmlFile() {
        return pathResultXmlFile;
    }

    public void setPathResultXmlFile(String pathResultXmlFile) {
        this.pathResultXmlFile = pathResultXmlFile;
    }

}
