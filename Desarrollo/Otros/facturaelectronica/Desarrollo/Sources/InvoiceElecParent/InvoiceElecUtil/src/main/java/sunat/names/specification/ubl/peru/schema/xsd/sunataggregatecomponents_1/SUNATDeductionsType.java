//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:55:13 PM PET 
//


package sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SUNATDeductionsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATDeductionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATReferenceValue" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATAquaticResources" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATGoldTrading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATDeductionsType", propOrder = {
    "sunatReferenceValue",
    "sunatAquaticResources",
    "sunatGoldTrading"
})
public class SUNATDeductionsType {

    @XmlElement(name = "SUNATReferenceValue")
    protected SUNATReferenceValueType sunatReferenceValue;
    @XmlElement(name = "SUNATAquaticResources")
    protected List<SUNATAquaticResourcesType> sunatAquaticResources;
    @XmlElement(name = "SUNATGoldTrading")
    protected List<SUNATGoldTradingType> sunatGoldTrading;

    /**
     * Obtiene el valor de la propiedad sunatReferenceValue.
     * 
     * @return
     *     possible object is
     *     {@link SUNATReferenceValueType }
     *     
     */
    public SUNATReferenceValueType getSUNATReferenceValue() {
        return sunatReferenceValue;
    }

    /**
     * Define el valor de la propiedad sunatReferenceValue.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATReferenceValueType }
     *     
     */
    public void setSUNATReferenceValue(SUNATReferenceValueType value) {
        this.sunatReferenceValue = value;
    }

    /**
     * Gets the value of the sunatAquaticResources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sunatAquaticResources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSUNATAquaticResources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SUNATAquaticResourcesType }
     * 
     * 
     */
    public List<SUNATAquaticResourcesType> getSUNATAquaticResources() {
        if (sunatAquaticResources == null) {
            sunatAquaticResources = new ArrayList<SUNATAquaticResourcesType>();
        }
        return this.sunatAquaticResources;
    }

    /**
     * Gets the value of the sunatGoldTrading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sunatGoldTrading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSUNATGoldTrading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SUNATGoldTradingType }
     * 
     * 
     */
    public List<SUNATGoldTradingType> getSUNATGoldTrading() {
        if (sunatGoldTrading == null) {
            sunatGoldTrading = new ArrayList<SUNATGoldTradingType>();
        }
        return this.sunatGoldTrading;
    }

}
