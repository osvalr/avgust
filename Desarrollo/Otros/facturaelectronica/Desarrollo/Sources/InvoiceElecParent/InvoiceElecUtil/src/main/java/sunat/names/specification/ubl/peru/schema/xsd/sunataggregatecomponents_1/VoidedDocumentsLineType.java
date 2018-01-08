//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:55:13 PM PET 
//


package sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.IdentifierType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.TextType;


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
 * <p>Clase Java para VoidedDocumentsLineType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VoidedDocumentsLineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DocumentTypeCode"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}DocumentSerialID"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}DocumentNumberID"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}VoidReasonDescription"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoidedDocumentsLineType", propOrder = {
    "lineID",
    "documentTypeCode",
    "documentSerialID",
    "documentNumberID",
    "voidReasonDescription"
})
public class VoidedDocumentsLineType {

    @XmlElement(name = "LineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LineIDType lineID;
    @XmlElement(name = "DocumentTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DocumentTypeCodeType documentTypeCode;
    @XmlElement(name = "DocumentSerialID", required = true)
    protected IdentifierType documentSerialID;
    @XmlElement(name = "DocumentNumberID", required = true)
    protected IdentifierType documentNumberID;
    @XmlElement(name = "VoidReasonDescription", required = true)
    protected TextType voidReasonDescription;

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
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LineIDType }
     *     
     */
    public LineIDType getLineID() {
        return lineID;
    }

    /**
     * Define el valor de la propiedad lineID.
     * 
     * @param value
     *     allowed object is
     *     {@link LineIDType }
     *     
     */
    public void setLineID(LineIDType value) {
        this.lineID = value;
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
     * 					
     * 
     * @return
     *     possible object is
     *     {@link DocumentTypeCodeType }
     *     
     */
    public DocumentTypeCodeType getDocumentTypeCode() {
        return documentTypeCode;
    }

    /**
     * Define el valor de la propiedad documentTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentTypeCodeType }
     *     
     */
    public void setDocumentTypeCode(DocumentTypeCodeType value) {
        this.documentTypeCode = value;
    }

    /**
     * 
     * 						
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
     * 							&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;
     * 							&lt;ccts:DictionaryEntryName&gt;Consolidated Invoice Line Billing
     * 								Payment
     * 							&lt;/ccts:DictionaryEntryName&gt;
     * 							&lt;ccts:Definition&gt;An association to Billing Payment.
     * 							&lt;/ccts:Definition&gt;
     * 							&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;
     * 							&lt;ccts:ObjectClass&gt;Consolidated Invoice Line&lt;/ccts:ObjectClass&gt;
     * 							&lt;ccts:PropertyTerm&gt;Billing Payment&lt;/ccts:PropertyTerm&gt;
     * 							&lt;ccts:AssociatedObjectClass&gt;Consolidated Invoice Line
     * 							&lt;/ccts:AssociatedObjectClass&gt;
     * 						&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 					
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getDocumentSerialID() {
        return documentSerialID;
    }

    /**
     * Define el valor de la propiedad documentSerialID.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setDocumentSerialID(IdentifierType value) {
        this.documentSerialID = value;
    }

    /**
     * 
     * 						
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
     * 							&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;
     * 							&lt;ccts:DictionaryEntryName&gt;Consolidated Invoice Line Billing
     * 								Payment
     * 							&lt;/ccts:DictionaryEntryName&gt;
     * 							&lt;ccts:Definition&gt;An association to Billing Payment.
     * 							&lt;/ccts:Definition&gt;
     * 							&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;
     * 							&lt;ccts:ObjectClass&gt;Consolidated Invoice Line&lt;/ccts:ObjectClass&gt;
     * 							&lt;ccts:PropertyTerm&gt;Billing Payment&lt;/ccts:PropertyTerm&gt;
     * 							&lt;ccts:AssociatedObjectClass&gt;Consolidated Invoice Line
     * 							&lt;/ccts:AssociatedObjectClass&gt;
     * 						&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 					
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getDocumentNumberID() {
        return documentNumberID;
    }

    /**
     * Define el valor de la propiedad documentNumberID.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setDocumentNumberID(IdentifierType value) {
        this.documentNumberID = value;
    }

    /**
     * 
     * 						
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
     * 							&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;
     * 							&lt;ccts:DictionaryEntryName&gt;Voided Document Line Void Reason
     * 								Description
     * 							&lt;/ccts:DictionaryEntryName&gt;
     * 							&lt;ccts:Definition&gt;An association to Void Reason.&lt;/ccts:Definition&gt;
     * 							&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;
     * 							&lt;ccts:ObjectClass&gt;Voided Document Line&lt;/ccts:ObjectClass&gt;
     * 							&lt;ccts:PropertyTerm&gt;Voided Document&lt;/ccts:PropertyTerm&gt;
     * 							&lt;ccts:AssociatedObjectClass&gt;Voided Document Line
     * 							&lt;/ccts:AssociatedObjectClass&gt;
     * 						&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getVoidReasonDescription() {
        return voidReasonDescription;
    }

    /**
     * Define el valor de la propiedad voidReasonDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setVoidReasonDescription(TextType value) {
        this.voidReasonDescription = value;
    }

}
