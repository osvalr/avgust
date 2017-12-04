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
public class StoreBean {
    
    private String url;
    private String fields;
    private String rootProperty;
    private String autoLoad;
    private String typeProxy;
    private String typeReader;
    private String data;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getRootProperty() {
        return rootProperty;
    }

    public void setRootProperty(String rootProperty) {
        this.rootProperty = rootProperty;
    }

    public String getAutoLoad() {
        return autoLoad;
    }

    public void setAutoLoad(String autoLoad) {
        this.autoLoad = autoLoad;
    }

    public String getTypeProxy() {
        return typeProxy;
    }

    public void setTypeProxy(String typeProxy) {
        this.typeProxy = typeProxy;
    }

    public String getTypeReader() {
        return typeReader;
    }

    public void setTypeReader(String typeReader) {
        this.typeReader = typeReader;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
