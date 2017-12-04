package pe.com.jrtotem.app.generator.mybatis.domain;

public class BuildSetting extends BuildSettingKey {
    private String name_setting;

    private String main_path;

    private String model_path;

    private String criteria_path;

    private String mapper_path;

    private String xml_path;

    private Integer state;

    private String date_record;

    public String getName_setting() {
        return name_setting;
    }

    public void setName_setting(String name_setting) {
        this.name_setting = name_setting;
    }

    public String getMain_path() {
        return main_path;
    }

    public void setMain_path(String main_path) {
        this.main_path = main_path;
    }

    public String getModel_path() {
        return model_path;
    }

    public void setModel_path(String model_path) {
        this.model_path = model_path;
    }

    public String getCriteria_path() {
        return criteria_path;
    }

    public void setCriteria_path(String criteria_path) {
        this.criteria_path = criteria_path;
    }

    public String getMapper_path() {
        return mapper_path;
    }

    public void setMapper_path(String mapper_path) {
        this.mapper_path = mapper_path;
    }

    public String getXml_path() {
        return xml_path;
    }

    public void setXml_path(String xml_path) {
        this.xml_path = xml_path;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDate_record() {
        return date_record;
    }

    public void setDate_record(String date_record) {
        this.date_record = date_record;
    }
}