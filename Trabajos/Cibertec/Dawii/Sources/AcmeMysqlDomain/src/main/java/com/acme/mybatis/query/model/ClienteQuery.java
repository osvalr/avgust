package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class ClienteQuery extends DataTranferObject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id_persona;
    private String cod_persona;
    private Integer id_tipo_persona;
    private String descrip_tipo_persona;
    private Integer id_sub_tipo_persona;
    private String descrip_sub_tipo_persona;
    private String nombres_completos;
    private String ape_pater;
    private String ape_mater;
    private Integer id_tipo_docu_iden;
    private String descrip_tipo_docu_iden;
    private String num_docu_iden;
    private String fecha_nacimiento;
    private String correo;
    private String direccion;
    private String telefono;
    private String razon_social;
    private String nombre_razon;
    private String nom_user;
    private String nom_user_mod;
    private String descrip_estado;

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(String cod_persona) {
        this.cod_persona = cod_persona;
    }

    public Integer getId_tipo_persona() {
        return id_tipo_persona;
    }

    public void setId_tipo_persona(Integer id_tipo_persona) {
        this.id_tipo_persona = id_tipo_persona;
    }

    public String getDescrip_tipo_persona() {
        return descrip_tipo_persona;
    }

    public void setDescrip_tipo_persona(String descrip_tipo_persona) {
        this.descrip_tipo_persona = descrip_tipo_persona;
    }

    public Integer getId_sub_tipo_persona() {
        return id_sub_tipo_persona;
    }

    public void setId_sub_tipo_persona(Integer id_sub_tipo_persona) {
        this.id_sub_tipo_persona = id_sub_tipo_persona;
    }

    public String getDescrip_sub_tipo_persona() {
        return descrip_sub_tipo_persona;
    }

    public void setDescrip_sub_tipo_persona(String descrip_sub_tipo_persona) {
        this.descrip_sub_tipo_persona = descrip_sub_tipo_persona;
    }

    public String getNombres_completos() {
        return nombres_completos;
    }

    public void setNombres_completos(String nombres_completos) {
        this.nombres_completos = nombres_completos;
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

    public Integer getId_tipo_docu_iden() {
        return id_tipo_docu_iden;
    }

    public void setId_tipo_docu_iden(Integer id_tipo_docu_iden) {
        this.id_tipo_docu_iden = id_tipo_docu_iden;
    }

    public String getDescrip_tipo_docu_iden() {
        return descrip_tipo_docu_iden;
    }

    public void setDescrip_tipo_docu_iden(String descrip_tipo_docu_iden) {
        this.descrip_tipo_docu_iden = descrip_tipo_docu_iden;
    }

    public String getNum_docu_iden() {
        return num_docu_iden;
    }

    public void setNum_docu_iden(String num_docu_iden) {
        this.num_docu_iden = num_docu_iden;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getNom_user_mod() {
        return nom_user_mod;
    }

    public void setNom_user_mod(String nom_user_mod) {
        this.nom_user_mod = nom_user_mod;
    }

    public String getDescrip_estado() {
        return descrip_estado;
    }

    public void setDescrip_estado(String descrip_estado) {
        this.descrip_estado = descrip_estado;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_razon() {
        return nombre_razon;
    }

    public void setNombre_razon(String nombre_razon) {
        this.nombre_razon = nombre_razon;
    }
}
