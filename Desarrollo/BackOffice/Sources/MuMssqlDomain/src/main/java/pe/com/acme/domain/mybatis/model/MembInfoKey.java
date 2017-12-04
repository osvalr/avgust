package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class MembInfoKey implements Serializable {
    private Integer memb_guid;

    private static final long serialVersionUID = 1L;

    public Integer getMemb_guid() {
        return memb_guid;
    }

    public void setMemb_guid(Integer memb_guid) {
        this.memb_guid = memb_guid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memb_guid=").append(memb_guid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}