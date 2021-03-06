//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.12 at 10:42:45 PM PET 
//


package sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExchangeRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;


/**
 * <p>Java class for SUNATRetentionInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the sunatRetentionAmount property.
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
     * Sets the value of the sunatRetentionAmount property.
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
     * Gets the value of the sunatRetentionDate property.
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
     * Sets the value of the sunatRetentionDate property.
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
     * Gets the value of the sunatNetTotalPaid property.
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
     * Sets the value of the sunatNetTotalPaid property.
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
     * Gets the value of the exchangeRate property.
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
     * Sets the value of the exchangeRate property.
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
