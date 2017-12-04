package com.acme.util;

/**
 * Created by JRaffo on 9/10/15.
 */
public abstract class DataCriteria {

    protected String order_column;
    protected String order_direction;
    protected Integer start;
    protected Integer limit;

    public DataCriteria() {
        this.setOrder_column("1");
        this.setOrder_direction("ASC");
    }

    public String getOrder_column() {
        return order_column;
    }

    public void setOrder_column(String order_column) {
        this.order_column = order_column;
    }

    public String getOrder_direction() {
        return order_direction;
    }

    public void setOrder_direction(String order_direction) {
        this.order_direction = order_direction;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
