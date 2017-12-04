//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.19 a las 07:07:55 PM PET 
//


package pe.com.jrtotem.app.generator.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ModelType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ModelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mainPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="criteriaPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mapperPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="xmlMapperPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameModel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameCriteria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameMapper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameXmlMapper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="namespaceModel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="namespaceCriteria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="namespaceMapper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="namespaceXmlMapper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="packageModel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="packageCriteria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="packageMapper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="packageXmlMapper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outputProperties" type="{http://www.jrtotem.com.pe}PropertiesType"/>
 *         &lt;element name="inputProperties" type="{http://www.jrtotem.com.pe}PropertiesType"/>
 *         &lt;element name="subModels" type="{http://www.jrtotem.com.pe}SubModelsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelType", propOrder = {
    "name",
    "mainPath",
    "modelPath",
    "criteriaPath",
    "mapperPath",
    "xmlMapperPath",
    "nameModel",
    "nameCriteria",
    "nameMapper",
    "nameXmlMapper",
    "namespaceModel",
    "namespaceCriteria",
    "namespaceMapper",
    "namespaceXmlMapper",
    "packageModel",
    "packageCriteria",
    "packageMapper",
    "packageXmlMapper",
    "outputProperties",
    "inputProperties",
    "subModels"
})
public class ModelType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String mainPath;
    @XmlElement(required = true)
    protected String modelPath;
    @XmlElement(required = true)
    protected String criteriaPath;
    @XmlElement(required = true)
    protected String mapperPath;
    @XmlElement(required = true)
    protected String xmlMapperPath;
    @XmlElement(required = true)
    protected String nameModel;
    @XmlElement(required = true)
    protected String nameCriteria;
    @XmlElement(required = true)
    protected String nameMapper;
    @XmlElement(required = true)
    protected String nameXmlMapper;
    @XmlElement(required = true)
    protected String namespaceModel;
    @XmlElement(required = true)
    protected String namespaceCriteria;
    @XmlElement(required = true)
    protected String namespaceMapper;
    @XmlElement(required = true)
    protected String namespaceXmlMapper;
    @XmlElement(required = true)
    protected String packageModel;
    @XmlElement(required = true)
    protected String packageCriteria;
    @XmlElement(required = true)
    protected String packageMapper;
    @XmlElement(required = true)
    protected String packageXmlMapper;
    @XmlElement(required = true)
    protected PropertiesType outputProperties;
    @XmlElement(required = true)
    protected PropertiesType inputProperties;
    protected SubModelsType subModels;

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad mainPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainPath() {
        return mainPath;
    }

    /**
     * Define el valor de la propiedad mainPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainPath(String value) {
        this.mainPath = value;
    }

    /**
     * Obtiene el valor de la propiedad modelPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelPath() {
        return modelPath;
    }

    /**
     * Define el valor de la propiedad modelPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelPath(String value) {
        this.modelPath = value;
    }

    /**
     * Obtiene el valor de la propiedad criteriaPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaPath() {
        return criteriaPath;
    }

    /**
     * Define el valor de la propiedad criteriaPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaPath(String value) {
        this.criteriaPath = value;
    }

    /**
     * Obtiene el valor de la propiedad mapperPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapperPath() {
        return mapperPath;
    }

    /**
     * Define el valor de la propiedad mapperPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapperPath(String value) {
        this.mapperPath = value;
    }

    /**
     * Obtiene el valor de la propiedad xmlMapperPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlMapperPath() {
        return xmlMapperPath;
    }

    /**
     * Define el valor de la propiedad xmlMapperPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlMapperPath(String value) {
        this.xmlMapperPath = value;
    }

    /**
     * Obtiene el valor de la propiedad nameModel.
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
     * Define el valor de la propiedad nameModel.
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
     * Obtiene el valor de la propiedad nameCriteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameCriteria() {
        return nameCriteria;
    }

    /**
     * Define el valor de la propiedad nameCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameCriteria(String value) {
        this.nameCriteria = value;
    }

    /**
     * Obtiene el valor de la propiedad nameMapper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameMapper() {
        return nameMapper;
    }

    /**
     * Define el valor de la propiedad nameMapper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameMapper(String value) {
        this.nameMapper = value;
    }

    /**
     * Obtiene el valor de la propiedad nameXmlMapper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameXmlMapper() {
        return nameXmlMapper;
    }

    /**
     * Define el valor de la propiedad nameXmlMapper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameXmlMapper(String value) {
        this.nameXmlMapper = value;
    }

    /**
     * Obtiene el valor de la propiedad namespaceModel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceModel() {
        return namespaceModel;
    }

    /**
     * Define el valor de la propiedad namespaceModel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceModel(String value) {
        this.namespaceModel = value;
    }

    /**
     * Obtiene el valor de la propiedad namespaceCriteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceCriteria() {
        return namespaceCriteria;
    }

    /**
     * Define el valor de la propiedad namespaceCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceCriteria(String value) {
        this.namespaceCriteria = value;
    }

    /**
     * Obtiene el valor de la propiedad namespaceMapper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceMapper() {
        return namespaceMapper;
    }

    /**
     * Define el valor de la propiedad namespaceMapper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceMapper(String value) {
        this.namespaceMapper = value;
    }

    /**
     * Obtiene el valor de la propiedad namespaceXmlMapper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceXmlMapper() {
        return namespaceXmlMapper;
    }

    /**
     * Define el valor de la propiedad namespaceXmlMapper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceXmlMapper(String value) {
        this.namespaceXmlMapper = value;
    }

    /**
     * Obtiene el valor de la propiedad packageModel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageModel() {
        return packageModel;
    }

    /**
     * Define el valor de la propiedad packageModel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageModel(String value) {
        this.packageModel = value;
    }

    /**
     * Obtiene el valor de la propiedad packageCriteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageCriteria() {
        return packageCriteria;
    }

    /**
     * Define el valor de la propiedad packageCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageCriteria(String value) {
        this.packageCriteria = value;
    }

    /**
     * Obtiene el valor de la propiedad packageMapper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageMapper() {
        return packageMapper;
    }

    /**
     * Define el valor de la propiedad packageMapper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageMapper(String value) {
        this.packageMapper = value;
    }

    /**
     * Obtiene el valor de la propiedad packageXmlMapper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageXmlMapper() {
        return packageXmlMapper;
    }

    /**
     * Define el valor de la propiedad packageXmlMapper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageXmlMapper(String value) {
        this.packageXmlMapper = value;
    }

    /**
     * Obtiene el valor de la propiedad outputProperties.
     * 
     * @return
     *     possible object is
     *     {@link PropertiesType }
     *     
     */
    public PropertiesType getOutputProperties() {
        return outputProperties;
    }

    /**
     * Define el valor de la propiedad outputProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesType }
     *     
     */
    public void setOutputProperties(PropertiesType value) {
        this.outputProperties = value;
    }

    /**
     * Obtiene el valor de la propiedad inputProperties.
     * 
     * @return
     *     possible object is
     *     {@link PropertiesType }
     *     
     */
    public PropertiesType getInputProperties() {
        return inputProperties;
    }

    /**
     * Define el valor de la propiedad inputProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesType }
     *     
     */
    public void setInputProperties(PropertiesType value) {
        this.inputProperties = value;
    }

    /**
     * Obtiene el valor de la propiedad subModels.
     * 
     * @return
     *     possible object is
     *     {@link SubModelsType }
     *     
     */
    public SubModelsType getSubModels() {
        return subModels;
    }

    /**
     * Define el valor de la propiedad subModels.
     * 
     * @param value
     *     allowed object is
     *     {@link SubModelsType }
     *     
     */
    public void setSubModels(SubModelsType value) {
        this.subModels = value;
    }

}
