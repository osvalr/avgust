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
public class ListenerBean {
    
    private String type;
    private String onIdField;
    private List<ParameterBean> parameters = new ArrayList<ParameterBean>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOnIdField() {
        return onIdField;
    }

    public void setOnIdField(String onIdField) {
        this.onIdField = onIdField;
    }

    public List<ParameterBean> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterBean> parameters) {
        this.parameters = parameters;
    }
    
}
