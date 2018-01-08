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
 * <p>Clase Java para SUNATPerceptionInformationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATPerceptionInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATPerceptionAmount"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATPerceptionDate"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATNetTotalCashed"/>
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
@XmlType(name = "SUNATPerceptionInformationType", propOrder = {
    "sunatPerceptionAmount",
    "sunatPerceptionDate",
    "sunatNetTotalCashed",
    "exchangeRate"
})
public class SUNATPerceptionInformationType {

    @XmlElement(name = "SUNATPerceptionAmount", required = true)
    protected AmountType sunatPerceptionAmount;
    @XmlElement(name = "SUNATPerceptionDate", required = true)
    protected SUNATPerceptionDateType sunatPerceptionDate;
    @XmlElement(name = "SUNATNetTotalCashed", required = true)
    protected AmountType sunatNetTotalCashed;
    @XmlElement(name = "ExchangeRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ExchangeRateType exchangeRate;

    /**
     * Obtiene el valor de la propiedad sunatPerceptionAmount.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getSUNATPerceptionAmount() {
        return sunatPerceptionAmount;
    }

    /**
     * Define el valor de la propiedad sunatPerceptionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setSUNATPerceptionAmount(AmountType value) {
        this.sunatPerceptionAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatPerceptionDate.
     * 
     * @return
     *     possible object is
     *     {@link SUNATPerceptionDateType }
     *     
     */
    public SUNATPerceptionDateType getSUNATPerceptionDate() {
        return sunatPerceptionDate;
    }

    /**
     * Define el valor de la propiedad sunatPerceptionDate.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATPerceptionDateType }
     *     
     */
    public void setSUNATPerceptionDate(SUNATPerceptionDateType value) {
        this.sunatPerceptionDate = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatNetTotalCashed.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getSUNATNetTotalCashed() {
        return sunatNetTotalCashed;
    }

    /**
     * Define el valor de la propiedad sunatNetTotalCashed.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setSUNATNetTotalCashed(AmountType value) {
        this.sunatNetTotalCashed = value;
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
