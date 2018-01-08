package pe.kapcom.coravi.types;

/**
 * Created by JRaffo on 15/03/17.
 */

public class ResumenPagosType {

    private Integer id_cliente;
    private String nombres_completos;
    private String fecha_jornada;
    private Double total_peso_neto;
    private Double total_importe;
    private Double monto_amortizado;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres_completos() {
        return nombres_completos;
    }

    public void setNombres_completos(String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }

    public String getFecha_jornada() {
        return fecha_jornada;
    }

    public void setFecha_jornada(String fecha_jornada) {
        this.fecha_jornada = fecha_jornada;
    }

    public Double getTotal_peso_neto() {
        return total_peso_neto;
    }

    public void setTotal_peso_neto(Double total_peso_neto) {
        this.total_peso_neto = total_peso_neto;
    }

    public Double getTotal_importe() {
        return total_importe;
    }

    public void setTotal_importe(Double total_importe) {
        this.total_importe = total_importe;
    }

    public Double getMonto_amortizado() {
        return monto_amortizado;
    }

    public void setMonto_amortizado(Double monto_amortizado) {
        this.monto_amortizado = monto_amortizado;
    }
}
