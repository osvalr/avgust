//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:54:19 PM PET 
//


package oasis.names.specification.ubl.schema.xsd.debitnote_2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.specification.ubl.schema.xsd.debitnote_2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DebitNote_QNAME = new QName("urn:oasis:names:specification:ubl:schema:xsd:DebitNote-2", "DebitNote");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.specification.ubl.schema.xsd.debitnote_2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DebitNoteType }
     * 
     */
    public DebitNoteType createDebitNoteType() {
        return new DebitNoteType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebitNoteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oasis:names:specification:ubl:schema:xsd:DebitNote-2", name = "DebitNote")
    public JAXBElement<DebitNoteType> createDebitNote(DebitNoteType value) {
        return new JAXBElement<DebitNoteType>(_DebitNote_QNAME, DebitNoteType.class, null, value);
    }

}
