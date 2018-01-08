//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:54:32 PM PET 
//


package sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1 package. 
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

    private final static QName _SummaryDocuments_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SummaryDocuments-1", "SummaryDocuments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SummaryDocumentsType }
     * 
     */
    public SummaryDocumentsType createSummaryDocumentsType() {
        return new SummaryDocumentsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SummaryDocumentsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SummaryDocuments-1", name = "SummaryDocuments")
    public JAXBElement<SummaryDocumentsType> createSummaryDocuments(SummaryDocumentsType value) {
        return new JAXBElement<SummaryDocumentsType>(_SummaryDocuments_QNAME, SummaryDocumentsType.class, null, value);
    }

}
