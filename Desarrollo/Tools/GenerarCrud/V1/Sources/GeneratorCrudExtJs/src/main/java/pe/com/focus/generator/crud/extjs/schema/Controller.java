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
 * <p>Java class for Controller complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Controller">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="module" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameController" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageController" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pathProject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeFw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Controller", propOrder = {
    "module",
    "nameController",
    "packageController",
    "pathProject",
    "typeFw"
})
public class Controller {

    protected String module;
    protected String nameController;
    @XmlElement(required = true)
    protected String packageController;
    protected String pathProject;
    protected String typeFw;

    /**
     * Gets the value of the module property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets the value of the module property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModule(String value) {
        this.module = value;
    }

    /**
     * Gets the value of the nameController property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameController() {
        return nameController;
    }

    /**
     * Sets the value of the nameController property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameController(String value) {
        this.nameController = value;
    }

    /**
     * Gets the value of the packageController property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageController() {
        return packageController;
    }

    /**
     * Sets the value of the packageController property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageController(String value) {
        this.packageController = value;
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

    /**
     * Gets the value of the typeFw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeFw() {
        return typeFw;
    }

    /**
     * Sets the value of the typeFw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeFw(String value) {
        this.typeFw = value;
    }

}