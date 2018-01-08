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
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
 * 					&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;
 * 					&lt;ccts:DictionaryEntryName&gt;Consolidated Invoice Line Details
 * 					&lt;/ccts:DictionaryEntryName&gt;
 * 					&lt;ccts:Definition&gt;Information about a Consolidated Invoice Line.
 * 					&lt;/ccts:Definition&gt;
 * 					&lt;ccts:ObjectClass&gt;Consolidated Invoice Line&lt;/ccts:ObjectClass&gt;
 * 				&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 			
 * 
 * <p>Clase Java para AdditionalInformationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AdditionalInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}AdditionalMonetaryTotal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}AdditionalProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATTransaction" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATEmbededDespatchAdvice" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATDeductions" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATCosts" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalInformationType", propOrder = {
    "additionalMonetaryTotal",
    "additionalProperty",
    "sunatTransaction",
    "sunatEmbededDespatchAdvice",
    "sunatDeductions",
    "sunatCosts"
})
public class AdditionalInformationType {

    @XmlElement(name = "AdditionalMonetaryTotal")
    protected List<AdditionalMonetaryTotalType> additionalMonetaryTotal;
    @XmlElement(name = "AdditionalProperty")
    protected List<AdditionalPropertyType> additionalProperty;
    @XmlElement(name = "SUNATTransaction")
    protected SUNATTransactionType sunatTransaction;
    @XmlElement(name = "SUNATEmbededDespatchAdvice")
    protected SUNATEmbededDespatchAdviceType sunatEmbededDespatchAdvice;
    @XmlElement(name = "SUNATDeductions")
    protected SUNATDeductionsType sunatDeductions;
    @XmlElement(name = "SUNATCosts")
    protected SUNATCostsType sunatCosts;

    /**
     * 
     * 						
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
     * 							&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;
     * 							&lt;ccts:DictionaryEntryName&gt;Consolidated Invoice Line. Identifier
     * 							&lt;/ccts:DictionaryEntryName&gt;
     * 							&lt;ccts:Definition&gt;Identifies the Consolidated Invoice Line.
     * 							&lt;/ccts:Definition&gt;
     * 							&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;
     * 							&lt;ccts:ObjectClass&gt;Consolidated Invoice Line&lt;/ccts:ObjectClass&gt;
     * 							&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;
     * 							&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;
     * 							&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;
     * 						&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 					Gets the value of the additionalMonetaryTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalMonetaryTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalMonetaryTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalMonetaryTotalType }
     * 
     * 
     */
    public List<AdditionalMonetaryTotalType> getAdditionalMonetaryTotal() {
        if (additionalMonetaryTotal == null) {
            additionalMonetaryTotal = new ArrayList<AdditionalMonetaryTotalType>();
        }
        return this.additionalMonetaryTotal;
    }

    /**
     * 
     * 						
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
     * 							&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;
     * 							&lt;ccts:DictionaryEntryName&gt;Consolidated Invoice Line Type Code.
     * 								Code
     * 							&lt;/ccts:DictionaryEntryName&gt;
     * 							&lt;ccts:Definition&gt;Code specifying the type of the Invoice.
     * 							&lt;/ccts:Definition&gt;
     * 							&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;
     * 							&lt;ccts:ObjectClass&gt;Consolidated Invoice Line&lt;/ccts:ObjectClass&gt;
     * 							&lt;ccts:PropertyTerm&gt;Consolidated Invoice Line Type Code
     * 							&lt;/ccts:PropertyTerm&gt;
     * 							&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;
     * 							&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;
     * 						&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 					Gets the value of the additionalProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalPropertyType }
     * 
     * 
     */
    public List<AdditionalPropertyType> getAdditionalProperty() {
        if (additionalProperty == null) {
            additionalProperty = new ArrayList<AdditionalPropertyType>();
        }
        return this.additionalProperty;
    }

    /**
     * Obtiene el valor de la propiedad sunatTransaction.
     * 
     * @return
     *     possible object is
     *     {@link SUNATTransactionType }
     *     
     */
    public SUNATTransactionType getSUNATTransaction() {
        return sunatTransaction;
    }

    /**
     * Define el valor de la propiedad sunatTransaction.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATTransactionType }
     *     
     */
    public void setSUNATTransaction(SUNATTransactionType value) {
        this.sunatTransaction = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatEmbededDespatchAdvice.
     * 
     * @return
     *     possible object is
     *     {@link SUNATEmbededDespatchAdviceType }
     *     
     */
    public SUNATEmbededDespatchAdviceType getSUNATEmbededDespatchAdvice() {
        return sunatEmbededDespatchAdvice;
    }

    /**
     * Define el valor de la propiedad sunatEmbededDespatchAdvice.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATEmbededDespatchAdviceType }
     *     
     */
    public void setSUNATEmbededDespatchAdvice(SUNATEmbededDespatchAdviceType value) {
        this.sunatEmbededDespatchAdvice = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatDeductions.
     * 
     * @return
     *     possible object is
     *     {@link SUNATDeductionsType }
     *     
     */
    public SUNATDeductionsType getSUNATDeductions() {
        return sunatDeductions;
    }

    /**
     * Define el valor de la propiedad sunatDeductions.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATDeductionsType }
     *     
     */
    public void setSUNATDeductions(SUNATDeductionsType value) {
        this.sunatDeductions = value;
    }

    /**
     * Obtiene el valor de la propiedad sunatCosts.
     * 
     * @return
     *     possible object is
     *     {@link SUNATCostsType }
     *     
     */
    public SUNATCostsType getSUNATCosts() {
        return sunatCosts;
    }

    /**
     * Define el valor de la propiedad sunatCosts.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATCostsType }
     *     
     */
    public void setSUNATCosts(SUNATCostsType value) {
        this.sunatCosts = value;
    }

}
