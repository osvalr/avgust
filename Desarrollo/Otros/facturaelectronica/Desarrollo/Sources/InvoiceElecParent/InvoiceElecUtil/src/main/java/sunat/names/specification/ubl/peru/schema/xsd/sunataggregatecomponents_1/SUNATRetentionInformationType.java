//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:55:13 PM PET 
//


package sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExchangeRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;


/**
 * <p>Clase Java para SUNATRetentionInformationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATRetentionInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATRetentionAmount"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATRetentionDate"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATNetTotalPaid"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExchangeRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATRetentionInformationType", propOrder = {
    "sunatRetentionAmount",
    "sunatRetentionDate",
    "sunatNetTotalPaid",
    "exchangeRate"
})
public class SUNATRetentionInformationType {

    @XmlElement(name = "SUNATRetentionAmount", required = true)
    protected AmountType sunatRetentionAmount;
    @XmlElement(name = "SUNATRetentionDate", required = true)
    protected SUNATRetentionDateType sunatRetentionDate;
    @XmlElement(name = "SUNATNetTotalPaid", required = true)
    protected AmountType sunatNetTotalPaid;
    @XmlElement(name = "ExchangeRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ExchangeRateType exchangeRate;

    /**
     * Obtiene el valor de la propiedad sunatRetentionAmount.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getSUNATRetentionAmount() {
        return sunatRetentionAmount;
    }

    /**
     * Define el valor de la propiedad sunatRetentionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setSUNATRetentionAmount(AmountType value) {
        this.sunatRetentionAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatRetentionDate.
     * 
     * @return
     *     possible object is
     *     {@link SUNATRetentionDateType }
     *     
     */
    public SUNATRetentionDateType getSUNATRetentionDate() {
        return sunatRetentionDate;
    }

    /**
     * Define el valor de la propiedad sunatRetentionDate.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATRetentionDateType }
     *     
     */
    public void setSUNATRetentionDate(SUNATRetentionDateType value) {
        this.sunatRetentionDate = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatNetTotalPaid.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getSUNATNetTotalPaid() {
        return sunatNetTotalPaid;
    }

    /**
     * Define el valor de la propiedad sunatNetTotalPaid.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setSUNATNetTotalPaid(AmountType value) {
        this.sunatNetTotalPaid = value;
    }

    /**
     * Obtiene el valor de la propiedad exchangeRate.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRateType }
     *     
     */
    public ExchangeRateType getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Define el valor de la propiedad exchangeRate.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRateType }
     *     
     */
    public void setExchangeRate(ExchangeRateType value) {
        this.exchangeRate = value;
    }

}
