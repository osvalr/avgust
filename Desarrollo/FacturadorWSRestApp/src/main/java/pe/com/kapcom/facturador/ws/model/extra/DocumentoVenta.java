package pe.com.kapcom.facturador.ws.model.extra;

public class DocumentoVenta {

    private String ventas_key;
    private Object ventasDetalle_1;
    private Object ventasDetalle_2;

    public String getVentas_key() {
        return ventas_key;
    }

    public void setVentas_key(String ventas_key) {
        this.ventas_key = ventas_key;
    }

    public Object getVentasDetalle_1() {
        return ventasDetalle_1;
    }

    public void setVentasDetalle_1(Object ventasDetalle_1) {
        this.ventasDetalle_1 = ventasDetalle_1;
    }

    public Object getVentasDetalle_2() {
        return ventasDetalle_2;
    }

    public void setVentasDetalle_2(Object ventasDetalle_2) {
        this.ventasDetalle_2 = ventasDetalle_2;
    }
}
