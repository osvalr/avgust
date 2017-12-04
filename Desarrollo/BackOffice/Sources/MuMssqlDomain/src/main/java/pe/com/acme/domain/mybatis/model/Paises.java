package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class Paises extends PaisesKey implements Serializable {
    private String iso;

    private String nombre;

    private static final long serialVersionUID = 1L;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iso=").append(iso);
        sb.append(", nombre=").append(nombre);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}