package pe.com.jrtotem.app.generator.mybatis.domain;

public class InfoDbConnection extends InfoDbConnectionKey {
    private String name;

    private Integer engine;

    private String url;

    private String jdbc_class;

    private String name_user;

    private String password_user;

    private Integer state;

    private String date_record;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEngine() {
        return engine;
    }

    public void setEngine(Integer engine) {
        this.engine = engine;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJdbc_class() {
        return jdbc_class;
    }

    public void setJdbc_class(String jdbc_class) {
        this.jdbc_class = jdbc_class;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
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