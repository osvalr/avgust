//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:55:13 PM PET 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineType;


/**
 * 
 *         
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
 *           &lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;
 *           &lt;ccts:DictionaryEntryName&gt;Address Line. Details&lt;/ccts:DictionaryEntryName&gt;
 *           &lt;ccts:Definition&gt;Information about a line of address expressed as unstructured text.&lt;/ccts:Definition&gt;
 *           &lt;ccts:ObjectClass&gt;Address Line&lt;/ccts:ObjectClass&gt;
 *         &lt;/ccts:Component&gt;
 * </pre>
 * 
 *       
 * 
 * <p>Clase Java para AddressLineType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AddressLineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Line"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressLineType", propOrder = {
    "line"
})
public class AddressLineType {

    @XmlElement(name = "Line", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LineType line;

    /**
     * 
     *             
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
     *               &lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;
     *               &lt;ccts:DictionaryEntryName&gt;Address Line. Line. Text&lt;/ccts:DictionaryEntryName&gt;
     *               &lt;ccts:Definition&gt;A line of address expressed as unstructured text.&lt;/ccts:Definition&gt;
     *               &lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;
     *               &lt;ccts:ObjectClass&gt;Address Line&lt;/ccts:ObjectClass&gt;
     *               &lt;ccts:PropertyTerm&gt;Line&lt;/ccts:PropertyTerm&gt;
     *               &lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;
     *               &lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;
     *               &lt;ccts:Examples&gt;"123 Standard Chartered Tower"&lt;/ccts:Examples&gt;
     *             &lt;/ccts:Component&gt;
     * </pre>
     * 
     *           
     * 
     * @return
     *     possible object is
     *     {@link LineType }
     *     
     */
    public LineType getLine() {
        return line;
    }

    /**
     * Define el valor de la propiedad line.
     * 
     * @param value
     *     allowed object is
     *     {@link LineType }
     *     
     */
    public void setLine(LineType value) {
        this.line = value;
    }

}
