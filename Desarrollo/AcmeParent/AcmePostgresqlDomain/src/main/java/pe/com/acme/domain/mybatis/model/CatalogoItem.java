package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class CatalogoItem extends CatalogoItemKey implements Serializable {
    private Integer id_catalogo;

    private Short valor_item;

    private String descrip_item;

    private String valor_a;

    private String valor_b;

    private String valor_c;

    private String valor_d;

    private String valor_e;

    private Short id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(Integer id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    public Short getValor_item() {
        return valor_item;
    }

    public void setValor_item(Short valor_item) {
        this.valor_item = valor_item;
    }

    public String getDescrip_item() {
        return descrip_item;
    }

    public void setDescrip_item(String descrip_item) {
        this.descrip_item = descrip_item;
    }

    public String getValor_a() {
        return valor_a;
    }

    public void setValor_a(String valor_a) {
        this.valor_a = valor_a;
    }

    public String getValor_b() {
        return valor_b;
    }

    public void setValor_b(String valor_b) {
        this.valor_b = valor_b;
    }

    public String getValor_c() {
        return valor_c;
    }

    public void setValor_c(String valor_c) {
        this.valor_c = valor_c;
    }

    public String getValor_d() {
        return valor_d;
    }

    public void setValor_d(String valor_d) {
        this.valor_d = valor_d;
    }

    public String getValor_e() {
        return valor_e;
    }

    public void setValor_e(String valor_e) {
        this.valor_e = valor_e;
    }

    public Short getId_estado() {
        return id_estado;
    }

    public void setId_estado(Short id_estado) {
        this.id_estado = id_estado;
    }

    public Integer getId_usuario_reg() {
        return id_usuario_reg;
    }

    public void setId_usuario_reg(Integer id_usuario_reg) {
        this.id_usuario_reg = id_usuario_reg;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Integer getId_usuario_mod() {
        return id_usuario_mod;
    }

    public void setId_usuario_mod(Integer id_usuario_mod) {
        this.id_usuario_mod = id_usuario_mod;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_catalogo=").append(id_catalogo);
        sb.append(", valor_item=").append(valor_item);
        sb.append(", descrip_item=").append(descrip_item);
        sb.append(", valor_a=").append(valor_a);
        sb.append(", valor_b=").append(valor_b);
        sb.append(", valor_c=").append(valor_c);
        sb.append(", valor_d=").append(valor_d);
        sb.append(", valor_e=").append(valor_e);
        sb.append(", id_estado=").append(id_estado);
        sb.append(", id_usuario_reg=").append(id_usuario_reg);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", id_usuario_mod=").append(id_usuario_mod);
        sb.append(", fecha_modificacion=").append(fecha_modificacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}