package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class ResetHistorico extends ResetHistoricoKey implements Serializable {
    private String accountID;

    private String nameCharacter;

    private Date fecha_registro;

    private static final long serialVersionUID = 1L;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountID=").append(accountID);
        sb.append(", nameCharacter=").append(nameCharacter);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}