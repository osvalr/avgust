package pe.kapcom.coravi.types;

/**
 * Created by JRaffo on 15/03/17.
 */

public class GrabarCobranzaRequestType {

    private String fecha_pago;
    private Integer id_cliente;
    private Double montoAmortizado;

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Double getMontoAmortizado() {
        return montoAmortizado;
    }

    public void setMontoAmortizado(Double montoAmortizado) {
        this.montoAmortizado = montoAmortizado;
    }
}
