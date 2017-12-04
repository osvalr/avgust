package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Persona extends PersonaKey implements Serializable {
    private String nombres;

    private String ape_pater;

    private String ape_mater;

    private String razon_social;

    private Integer id_tipo_doc;

    private String num_tipo_doc;

    private Date fecha_nacimiento;

    private String email;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_pater() {
        return ape_pater;
    }

    public void setApe_pater(String ape_pater) {
        this.ape_pater = ape_pater;
    }

    public String getApe_mater() {
        return ape_mater;
    }

    public void setApe_mater(String ape_mater) {
        this.ape_mater = ape_mater;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public Integer getId_tipo_doc() {
        return id_tipo_doc;
    }

    public void setId_tipo_doc(Integer id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }

    public String getNum_tipo_doc() {
        return num_tipo_doc;
    }

    public void setNum_tipo_doc(String num_tipo_doc) {
        this.num_tipo_doc = num_tipo_doc;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
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
        sb.append(", nombres=").append(nombres);
        sb.append(", ape_pater=").append(ape_pater);
        sb.append(", ape_mater=").append(ape_mater);
        sb.append(", razon_social=").append(razon_social);
        sb.append(", id_tipo_doc=").append(id_tipo_doc);
        sb.append(", num_tipo_doc=").append(num_tipo_doc);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append(", email=").append(email);
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