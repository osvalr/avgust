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
 * <p>Java class for Service complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nameService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameServiceImpl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageServiceImpl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pathProject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Service", propOrder = {
    "nameService",
    "packageService",
    "nameServiceImpl",
    "packageServiceImpl",
    "pathProject"
})
public class Service {

    protected String nameService;
    @XmlElement(required = true)
    protected String packageService;
    protected String nameServiceImpl;
    @XmlElement(required = true)
    protected String packageServiceImpl;
    protected String pathProject;

    /**
     * Gets the value of the nameService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameService() {
        return nameService;
    }

    /**
     * Sets the value of the nameService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameService(String value) {
        this.nameService = value;
    }

    /**
     * Gets the value of the packageService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageService() {
        return packageService;
    }

    /**
     * Sets the value of the packageService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageService(String value) {
        this.packageService = value;
    }

    /**
     * Gets the value of the nameServiceImpl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameServiceImpl() {
        return nameServiceImpl;
    }

    /**
     * Sets the value of the nameServiceImpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameServiceImpl(String value) {
        this.nameServiceImpl = value;
    }

    /**
     * Gets the value of the packageServiceImpl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageServiceImpl() {
        return packageServiceImpl;
    }

    /**
     * Sets the value of the packageServiceImpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageServiceImpl(String value) {
        this.packageServiceImpl = value;
    }

    /**
     * Gets the value of the pathProject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathProject() {
        return pathProject;
    }

    /**
     * Sets the value of the pathProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathProject(String value) {
        this.pathProject = value;
    }

}