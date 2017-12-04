package pe.com.jrtotem.app.generator.mybatis.domain;

public class Property extends PropertyKey {
    private Integer id_model_input;

    private Integer id_model_output;

    private String name;

    private String type;

    private String data_type;

    private Integer state;

    private String date_record;

    public Integer getId_model_input() {
        return id_model_input;
    }

    public void setId_model_input(Integer id_model_input) {
        this.id_model_input = id_model_input;
    }

    public Integer getId_model_output() {
        return id_model_output;
    }

    public void setId_model_output(Integer id_model_output) {
        this.id_model_output = id_model_output;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
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