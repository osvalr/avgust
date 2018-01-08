package pe.kapcom.coravi.types;

/**
 * Created by JRaffo on 13/03/17.
 */

public class ClientesRequestType {

    private String query;
    private Integer start;
    private Integer limit;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
