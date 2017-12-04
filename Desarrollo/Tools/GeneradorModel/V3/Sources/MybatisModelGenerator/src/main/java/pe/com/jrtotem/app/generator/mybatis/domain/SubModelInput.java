package pe.com.jrtotem.app.generator.mybatis.domain;

public class SubModelInput extends SubModelInputKey {
    private Integer id_model_input_parent;

    private Integer id_model_input_child;

    public Integer getId_model_input_parent() {
        return id_model_input_parent;
    }

    public void setId_model_input_parent(Integer id_model_input_parent) {
        this.id_model_input_parent = id_model_input_parent;
    }

    public Integer getId_model_input_child() {
        return id_model_input_child;
    }

    public void setId_model_input_child(Integer id_model_input_child) {
        this.id_model_input_child = id_model_input_child;
    }
}