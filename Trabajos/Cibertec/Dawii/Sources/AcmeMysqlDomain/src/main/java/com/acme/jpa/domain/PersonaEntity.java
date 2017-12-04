package com.acme.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="PersonaEntity.findAll", query="SELECT p FROM PersonaEntity p")
public class PersonaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_persona;
	private String ape_mater;
	private String ape_pater;
	private String clave;
	private String cod_persona;
	private String correo;
	private String direccion;
	private Timestamp fec_mod;
	private Timestamp fec_reg;
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	private Integer id_estado;
	private Integer id_sub_tipo_persona;
	private Integer id_tipo_docu_iden;
	private Integer id_tipo_persona;
	private Integer id_user;
	private Integer id_user_mod;
	private String nombres_completos;
	private String num_docu_iden;
	private String razon_social;
	private String sucursal;
	private String telefono;
	private String usuario;

	public PersonaEntity() {
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getApe_mater() {
		return ape_mater;
	}

	public void setApe_mater(String ape_mater) {
		this.ape_mater = ape_mater;
	}

	public String getApe_pater() {
		return ape_pater;
	}

	public void setApe_pater(String ape_pater) {
		this.ape_pater = ape_pater;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCod_persona() {
		return cod_persona;
	}

	public void setCod_persona(String cod_persona) {
		this.cod_persona = cod_persona;
	}

	public Timestamp getFec_mod() {
		return fec_mod;
	}

	public void setFec_mod(Timestamp fec_mod) {
		this.fec_mod = fec_mod;
	}

	public Timestamp getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Timestamp fec_reg) {
		this.fec_reg = fec_reg;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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

	public Integer getId_tipo_docu_iden() {
		return id_tipo_docu_iden;
	}

	public void setId_tipo_docu_iden(Integer id_tipo_docu_iden) {
		this.id_tipo_docu_iden = id_tipo_docu_iden;
	}

	public Integer getId_tipo_persona() {
		return id_tipo_persona;
	}

	public void setId_tipo_persona(Integer id_tipo_persona) {
		this.id_tipo_persona = id_tipo_persona;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_user_mod() {
		return id_user_mod;
	}

	public void setId_user_mod(Integer id_user_mod) {
		this.id_user_mod = id_user_mod;
	}

	public String getNombres_completos() {
		return nombres_completos;
	}

	public void setNombres_completos(String nombres_completos) {
		this.nombres_completos = nombres_completos;
	}

	public String getNum_docu_iden() {
		return num_docu_iden;
	}

	public void setNum_docu_iden(String num_docu_iden) {
		this.num_docu_iden = num_docu_iden;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
}