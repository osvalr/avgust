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
 * <p>Java class for Crud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Crud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="titleCrud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathAppExtJs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameApp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="model" type="{http://www.focus.com.pe/generator/crud/extjs}Model"/>
 *         &lt;element name="typePersitence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generateServiceBackEnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="generateControllerBackEnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="generateControllerFrontEnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="generateStoreFrontEnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="generateModelFrontEnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Crud", propOrder = {
    "name",
    "titleCrud",
    "type",
    "prefix",
    "pathTemplate",
    "pathAppExtJs",
    "nameApp",
    "model",
    "typePersitence",
    "generateServiceBackEnd",
    "generateControllerBackEnd",
    "generateControllerFrontEnd",
    "generateStoreFrontEnd",
    "generateModelFrontEnd"
})
public class Crud {

    @XmlElement(required = true)
    protected String name;
    protected String titleCrud;
    protected String type;
    protected String prefix;
    protected String pathTemplate;
    @XmlElement(required = true)
    protected String pathAppExtJs;
    @XmlElement(required = true)
    protected String nameApp;
    @XmlElement(required = true)
    protected Model model;
    @XmlElement(required = true)
    protected String typePersitence;
    protected boolean generateServiceBackEnd;
    protected boolean generateControllerBackEnd;
    protected boolean generateControllerFrontEnd;
    protected boolean generateStoreFrontEnd;
    protected boolean generateModelFrontEnd;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the titleCrud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleCrud() {
        return titleCrud;
    }

    /**
     * Sets the value of the titleCrud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleCrud(String value) {
        this.titleCrud = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the pathTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathTemplate() {
        return pathTemplate;
    }

    /**
     * Sets the value of the pathTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathTemplate(String value) {
        this.pathTemplate = value;
    }

    /**
     * Gets the value of the pathAppExtJs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathAppExtJs() {
        return pathAppExtJs;
    }

    /**
     * Sets the value of the pathAppExtJs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathAppExtJs(String value) {
        this.pathAppExtJs = value;
    }

    /**
     * Gets the value of the nameApp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameApp() {
        return nameApp;
    }

    /**
     * Sets the value of the nameApp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameApp(String value) {
        this.nameApp = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link Model }
     *     
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link Model }
     *     
     */
    public void setModel(Model value) {
        this.model = value;
    }

    /**
     * Gets the value of the typePersitence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypePersitence() {
        return typePersitence;
    }

    /**
     * Sets the value of the typePersitence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypePersitence(String value) {
        this.typePersitence = value;
    }

    /**
     * Gets the value of the generateServiceBackEnd property.
     * 
     */
    public boolean isGenerateServiceBackEnd() {
        return generateServiceBackEnd;
    }

    /**
     * Sets the value of the generateServiceBackEnd property.
     * 
     */
    public void setGenerateServiceBackEnd(boolean value) {
        this.generateServiceBackEnd = value;
    }

    /**
     * Gets the value of the generateControllerBackEnd property.
     * 
     */
    public boolean isGenerateControllerBackEnd() {
        return generateControllerBackEnd;
    }

    /**
     * Sets the value of the generateControllerBackEnd property.
     * 
     */
    public void setGenerateControllerBackEnd(boolean value) {
        this.generateControllerBackEnd = value;
    }

    /**
     * Gets the value of the generateControllerFrontEnd property.
     * 
     */
    public boolean isGenerateControllerFrontEnd() {
        return generateControllerFrontEnd;
    }

    /**
     * Sets the value of the generateControllerFrontEnd property.
     * 
     */
    public void setGenerateControllerFrontEnd(boolean value) {
        this.generateControllerFrontEnd = value;
    }

    /**
     * Gets the value of the generateStoreFrontEnd property.
     * 
     */
    public boolean isGenerateStoreFrontEnd() {
        return generateStoreFrontEnd;
    }

    /**
     * Sets the value of the generateStoreFrontEnd property.
     * 
     */
    public void setGenerateStoreFrontEnd(boolean value) {
        this.generateStoreFrontEnd = value;
    }

    /**
     * Gets the value of the generateModelFrontEnd property.
     * 
     */
    public boolean isGenerateModelFrontEnd() {
        return generateModelFrontEnd;
    }

    /**
     * Sets the value of the generateModelFrontEnd property.
     * 
     */
    public void setGenerateModelFrontEnd(boolean value) {
        this.generateModelFrontEnd = value;
    }

}
