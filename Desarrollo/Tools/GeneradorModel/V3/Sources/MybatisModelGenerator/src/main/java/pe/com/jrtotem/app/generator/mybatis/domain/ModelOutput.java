package pe.com.jrtotem.app.generator.mybatis.domain;

public class ModelOutput extends ModelOutputKey {
    private Integer id_model_input;

    private String outputs;

    private String inputs;

    private String froms;

    private Integer version;

    private Integer state;

    private String date_record;

    public Integer getId_model_input() {
        return id_model_input;
    }

    public void setId_model_input(Integer id_model_input) {
        this.id_model_input = id_model_input;
    }

    public String getOutputs() {
        return outputs;
    }

    public void setOutputs(String outputs) {
        this.outputs = outputs;
    }

    public String getInputs() {
        return inputs;
    }

    public void setInputs(String inputs) {
        this.inputs = inputs;
    }

    public String getFroms() {
        return froms;
    }

    public void setFroms(String froms) {
        this.froms = froms;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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