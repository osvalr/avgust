package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class ClienteQueryCriteria extends DataCriteria {

    private Integer id_persona;
    private Integer id_tipo_docu_iden;
    private String num_docu_iden;
    private String nombres_completos;
    private Integer id_estado;
    private Integer id_sub_tipo_persona;

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Integer getId_tipo_docu_iden() {
        return id_tipo_docu_iden;
    }

    public void setId_tipo_docu_iden(Integer id_tipo_docu_iden) {
        this.id_tipo_docu_iden = id_tipo_docu_iden;
    }

    public String getNum_docu_iden() {
        return num_docu_iden;
    }

    public void setNum_docu_iden(String num_docu_iden) {
        this.num_docu_iden = num_docu_iden;
    }

    public String getNombres_completos() {
        return nombres_completos;
    }

    public void setNombres_completos(String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }


    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public Integer getId_sub_tipo_persona() {
        return id_sub_tipo_persona;
    }

    public void setId_sub_tipo_persona(Integer id_sub_tipo_persona) {
        this.id_sub_tipo_persona = id_sub_tipo_persona;
    }
}
