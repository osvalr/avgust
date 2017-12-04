package com.acme.util;

/**
 * Created by JRaffo on 10/30/15.
 */
public class ModelWrapper<T> {

    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
