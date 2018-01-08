package pe.kapcom.coravi.types;

/**
 * Created by JRaffo on 14/03/17.
 */

public class DeudaClienteType {

    private String descrip;
    private Double importe;
    private Double amortizado;
    private Double deuda;

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getAmortizado() {
        return amortizado;
    }

    public void setAmortizado(Double amortizado) {
        this.amortizado = amortizado;
    }

    public Double getDeuda() {
        return deuda;
    }

    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }
}
