package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TArchivo extends TArchivoKey {
    private String var_nombre_archivo;

    private String var_tipo_archivo;

    private String var_archivo_ruta_almacen;

    private BigDecimal num_size_archivo;

    private Date tsp_fecha_registro;

    public String getVar_nombre_archivo() {
        return var_nombre_archivo;
    }

    public void setVar_nombre_archivo(String var_nombre_archivo) {
        this.var_nombre_archivo = var_nombre_archivo;
    }

    public String getVar_tipo_archivo() {
        return var_tipo_archivo;
    }

    public void setVar_tipo_archivo(String var_tipo_archivo) {
        this.var_tipo_archivo = var_tipo_archivo;
    }

    public String getVar_archivo_ruta_almacen() {
        return var_archivo_ruta_almacen;
    }

    public void setVar_archivo_ruta_almacen(String var_archivo_ruta_almacen) {
        this.var_archivo_ruta_almacen = var_archivo_ruta_almacen;
    }

    public BigDecimal getNum_size_archivo() {
        return num_size_archivo;
    }

    public void setNum_size_archivo(BigDecimal num_size_archivo) {
        this.num_size_archivo = num_size_archivo;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }
}