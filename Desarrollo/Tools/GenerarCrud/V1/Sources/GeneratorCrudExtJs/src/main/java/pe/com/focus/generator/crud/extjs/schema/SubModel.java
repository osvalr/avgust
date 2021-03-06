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
 * <p>Java class for SubModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nameModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titleModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="widthWindows" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="classModel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="classMapperModel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="classModelCriteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProperty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="joinProperty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="entities" type="{http://www.focus.com.pe/generator/crud/extjs}Entities"/>
 *         &lt;element name="tables" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fields" type="{http://www.focus.com.pe/generator/crud/extjs}Fields" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubModel", propOrder = {
    "nameModel",
    "titleModel",
    "widthWindows",
    "empty",
    "classModel",
    "classMapperModel",
    "classModelCriteria",
    "idProperty",
    "joinProperty",
    "entities",
    "tables",
    "fields"
})
public class SubModel {

    protected String nameModel;
    protected String titleModel;
    protected String widthWindows;
    protected String empty;
    @XmlElement(required = true)
    protected String classModel;
    @XmlElement(required = true)
    protected String classMapperModel;
    protected String classModelCriteria;
    @XmlElement(required = true)
    protected String idProperty;
    @XmlElement(required = true)
    protected String joinProperty;
    @XmlElement(required = true)
    protected Entities entities;
    protected String tables;
    protected Fields fields;

    /**
     * Gets the value of the nameModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameModel() {
        return nameModel;
    }

    /**
     * Sets the value of the nameModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameModel(String value) {
        this.nameModel = value;
    }

    /**
     * Gets the value of the titleModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleModel() {
        return titleModel;
    }

    /**
     * Sets the value of the titleModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleModel(String value) {
        this.titleModel = value;
    }

    /**
     * Gets the value of the widthWindows property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidthWindows() {
        return widthWindows;
    }

    /**
     * Sets the value of the widthWindows property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidthWindows(String value) {
        this.widthWindows = value;
    }

    /**
     * Gets the value of the empty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpty() {
        return empty;
    }

    /**
     * Sets the value of the empty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpty(String value) {
        this.empty = value;
    }

    /**
     * Gets the value of the classModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassModel() {
        return classModel;
    }

    /**
     * Sets the value of the classModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassModel(String value) {
        this.classModel = value;
    }

    /**
     * Gets the value of the classMapperModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassMapperModel() {
        return classMapperModel;
    }

    /**
     * Sets the value of the classMapperModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassMapperModel(String value) {
        this.classMapperModel = value;
    }

    /**
     * Gets the value of the classModelCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassModelCriteria() {
        return classModelCriteria;
    }

    /**
     * Sets the value of the classModelCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassModelCriteria(String value) {
        this.classModelCriteria = value;
    }

    /**
     * Gets the value of the idProperty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProperty() {
        return idProperty;
    }

    /**
     * Sets the value of the idProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProperty(String value) {
        this.idProperty = value;
    }

    /**
     * Gets the value of the joinProperty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJoinProperty() {
        return joinProperty;
    }

    /**
     * Sets the value of the joinProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJoinProperty(String value) {
        this.joinProperty = value;
    }

    /**
     * Gets the value of the entities property.
     * 
     * @return
     *     possible object is
     *     {@link Entities }
     *     
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     * Sets the value of the entities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Entities }
     *     
     */
    public void setEntities(Entities value) {
        this.entities = value;
    }

    /**
     * Gets the value of the tables property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTables() {
        return tables;
    }

    /**
     * Sets the value of the tables property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTables(String value) {
        this.tables = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link Fields }
     *     
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields }
     *     
     */
    public void setFields(Fields value) {
        this.fields = value;
    }

}
