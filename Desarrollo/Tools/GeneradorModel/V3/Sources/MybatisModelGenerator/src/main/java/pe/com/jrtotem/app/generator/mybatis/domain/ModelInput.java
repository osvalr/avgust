package pe.com.jrtotem.app.generator.mybatis.domain;

public class ModelInput extends ModelInputKey {
    private Integer id_info_db_connection;

    private String name_model;

    private String sql_text;

    private Integer state;

    private String date_record;

    public Integer getId_info_db_connection() {
        return id_info_db_connection;
    }

    public void setId_info_db_connection(Integer id_info_db_connection) {
        this.id_info_db_connection = id_info_db_connection;
    }

    public String getName_model() {
        return name_model;
    }

    public void setName_model(String name_model) {
        this.name_model = name_model;
    }

    public String getSql_text() {
        return sql_text;
    }

    public void setSql_text(String sql_text) {
        this.sql_text = sql_text;
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