package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Funcionalidad extends FuncionalidadKey implements Serializable {
    private String nombre_funcionalidad;

    private String recurso_funcionalidad;

    private String icon_cls;

    private String alias_component;

    private String component_controllers;

    private Short id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public String getNombre_funcionalidad() {
        return nombre_funcionalidad;
    }

    public void setNombre_funcionalidad(String nombre_funcionalidad) {
        this.nombre_funcionalidad = nombre_funcionalidad;
    }

    public String getRecurso_funcionalidad() {
        return recurso_funcionalidad;
    }

    public void setRecurso_funcionalidad(String recurso_funcionalidad) {
        this.recurso_funcionalidad = recurso_funcionalidad;
    }

    public String getIcon_cls() {
        return icon_cls;
    }

    public void setIcon_cls(String icon_cls) {
        this.icon_cls = icon_cls;
    }

    public String getAlias_component() {
        return alias_component;
    }

    public void setAlias_component(String alias_component) {
        this.alias_component = alias_component;
    }

    public String getComponent_controllers() {
        return component_controllers;
    }

    public void setComponent_controllers(String component_controllers) {
        this.component_controllers = component_controllers;
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
        sb.append(", nombre_funcionalidad=").append(nombre_funcionalidad);
        sb.append(", recurso_funcionalidad=").append(recurso_funcionalidad);
        sb.append(", icon_cls=").append(icon_cls);
        sb.append(", alias_component=").append(alias_component);
        sb.append(", component_controllers=").append(component_controllers);
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