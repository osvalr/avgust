package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPostulantePersonal extends TPostulantePersonalKey implements Serializable {
    private Integer int_porta_lic_conducir;

    private Integer int_clase_lic;

    private Integer int_categoria_lic;

    private Integer int_id_ubigeo_nacimiento;

    private String var_email_principal;

    private String var_email_secundario;

    private String var_telefono;

    private String var_codigo_ciudad_telefono;

    private String var_celular;

    private String var_codigo_ciudad_telefono2;

    private String var_telefono2;

    private String var_celular2;

    private String var_codigo_ciudad_telefono3;

    private String var_telefono3;

    private String var_celular3;

    private String var_resumen_profesional;

    private Integer int_persona_discapacitada;

    private Integer int_pertenece_ffaa;

    private Integer int_culmino_edu_prima;

    private Integer int_culmino_edu_secun;
    
    private String var_observacion_registro;

    private static final long serialVersionUID = 1L;

    public Integer getInt_porta_lic_conducir() {
        return int_porta_lic_conducir;
    }

    public void setInt_porta_lic_conducir(Integer int_porta_lic_conducir) {
        this.int_porta_lic_conducir = int_porta_lic_conducir;
    }

    public Integer getInt_clase_lic() {
        return int_clase_lic;
    }

    public void setInt_clase_lic(Integer int_clase_lic) {
        this.int_clase_lic = int_clase_lic;
    }

    public Integer getInt_categoria_lic() {
        return int_categoria_lic;
    }

    public void setInt_categoria_lic(Integer int_categoria_lic) {
        this.int_categoria_lic = int_categoria_lic;
    }

    public Integer getInt_id_ubigeo_nacimiento() {
        return int_id_ubigeo_nacimiento;
    }

    public void setInt_id_ubigeo_nacimiento(Integer int_id_ubigeo_nacimiento) {
        this.int_id_ubigeo_nacimiento = int_id_ubigeo_nacimiento;
    }

    public String getVar_email_principal() {
        return var_email_principal;
    }

    public void setVar_email_principal(String var_email_principal) {
        this.var_email_principal = var_email_principal;
    }

    public String getVar_email_secundario() {
        return var_email_secundario;
    }

    public void setVar_email_secundario(String var_email_secundario) {
        this.var_email_secundario = var_email_secundario;
    }

    public String getVar_telefono() {
        return var_telefono;
    }

    public void setVar_telefono(String var_telefono) {
        this.var_telefono = var_telefono;
    }

    public String getVar_codigo_ciudad_telefono() {
        return var_codigo_ciudad_telefono;
    }

    public void setVar_codigo_ciudad_telefono(String var_codigo_ciudad_telefono) {
        this.var_codigo_ciudad_telefono = var_codigo_ciudad_telefono;
    }

    public String getVar_celular() {
        return var_celular;
    }

    public void setVar_celular(String var_celular) {
        this.var_celular = var_celular;
    }

    public String getVar_codigo_ciudad_telefono2() {
        return var_codigo_ciudad_telefono2;
    }

    public void setVar_codigo_ciudad_telefono2(String var_codigo_ciudad_telefono2) {
        this.var_codigo_ciudad_telefono2 = var_codigo_ciudad_telefono2;
    }

    public String getVar_telefono2() {
        return var_telefono2;
    }

    public void setVar_telefono2(String var_telefono2) {
        this.var_telefono2 = var_telefono2;
    }

    public String getVar_celular2() {
        return var_celular2;
    }

    public void setVar_celular2(String var_celular2) {
        this.var_celular2 = var_celular2;
    }

    public String getVar_codigo_ciudad_telefono3() {
        return var_codigo_ciudad_telefono3;
    }

    public void setVar_codigo_ciudad_telefono3(String var_codigo_ciudad_telefono3) {
        this.var_codigo_ciudad_telefono3 = var_codigo_ciudad_telefono3;
    }

    public String getVar_telefono3() {
        return var_telefono3;
    }

    public void setVar_telefono3(String var_telefono3) {
        this.var_telefono3 = var_telefono3;
    }

    public String getVar_celular3() {
        return var_celular3;
    }

    public void setVar_celular3(String var_celular3) {
        this.var_celular3 = var_celular3;
    }

    public String getVar_resumen_profesional() {
        return var_resumen_profesional;
    }

    public void setVar_resumen_profesional(String var_resumen_profesional) {
        this.var_resumen_profesional = var_resumen_profesional;
    }

    public Integer getInt_persona_discapacitada() {
        return int_persona_discapacitada;
    }

    public void setInt_persona_discapacitada(Integer int_persona_discapacitada) {
        this.int_persona_discapacitada = int_persona_discapacitada;
    }

    public Integer getInt_pertenece_ffaa() {
        return int_pertenece_ffaa;
    }

    public void setInt_pertenece_ffaa(Integer int_pertenece_ffaa) {
        this.int_pertenece_ffaa = int_pertenece_ffaa;
    }

    public Integer getInt_culmino_edu_prima() {
        return int_culmino_edu_prima;
    }

    public void setInt_culmino_edu_prima(Integer int_culmino_edu_prima) {
        this.int_culmino_edu_prima = int_culmino_edu_prima;
    }

    public Integer getInt_culmino_edu_secun() {
        return int_culmino_edu_secun;
    }

    public void setInt_culmino_edu_secun(Integer int_culmino_edu_secun) {
        this.int_culmino_edu_secun = int_culmino_edu_secun;
    }


	public String getVar_observacion_registro() {
		return var_observacion_registro;
	}

	public void setVar_observacion_registro(String var_observacion_registro) {
		this.var_observacion_registro = var_observacion_registro;
	}
	

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", int_porta_lic_conducir=").append(int_porta_lic_conducir);
        sb.append(", int_clase_lic=").append(int_clase_lic);
        sb.append(", int_categoria_lic=").append(int_categoria_lic);
        sb.append(", int_id_ubigeo_nacimiento=").append(int_id_ubigeo_nacimiento);
        sb.append(", var_email_principal=").append(var_email_principal);
        sb.append(", var_email_secundario=").append(var_email_secundario);
        sb.append(", var_telefono=").append(var_telefono);
        sb.append(", var_codigo_ciudad_telefono=").append(var_codigo_ciudad_telefono);
        sb.append(", var_celular=").append(var_celular);
        sb.append(", var_codigo_ciudad_telefono2=").append(var_codigo_ciudad_telefono2);
        sb.append(", var_telefono2=").append(var_telefono2);
        sb.append(", var_celular2=").append(var_celular2);
        sb.append(", var_codigo_ciudad_telefono3=").append(var_codigo_ciudad_telefono3);
        sb.append(", var_telefono3=").append(var_telefono3);
        sb.append(", var_celular3=").append(var_celular3);
        sb.append(", var_resumen_profesional=").append(var_resumen_profesional);
        sb.append(", int_persona_discapacitada=").append(int_persona_discapacitada);
        sb.append(", int_pertenece_ffaa=").append(int_pertenece_ffaa);
        sb.append(", int_culmino_edu_prima=").append(int_culmino_edu_prima);
        sb.append(", int_culmino_edu_secun=").append(int_culmino_edu_secun);
        sb.append(", var_observacion_registro=").append(var_observacion_registro);        
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
	
}