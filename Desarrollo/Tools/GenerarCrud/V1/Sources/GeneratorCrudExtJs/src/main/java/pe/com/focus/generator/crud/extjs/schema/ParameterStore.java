//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.09 at 08:21:21 PM PET 
//


package pe.com.focus.generator.crud.extjs.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterStore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterStore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nameParameter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idFieldValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterStore", propOrder = {
    "nameParameter",
    "idFieldValue",
    "dataType"
})
public class ParameterStore {

    @XmlElement(required = true)
    protected String nameParameter;
    @XmlElement(required = true)
    protected String idFieldValue;
    protected String dataType;

    /**
     * Gets the value of the nameParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameParameter() {
        return nameParameter;
    }

    /**
     * Sets the value of the nameParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameParameter(String value) {
        this.nameParameter = value;
    }

    /**
     * Gets the value of the idFieldValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFieldValue() {
        return idFieldValue;
    }

    /**
     * Sets the value of the idFieldValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFieldValue(String value) {
        this.idFieldValue = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

}
