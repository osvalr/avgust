//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.09 at 08:21:21 PM PET 
//


package pe.com.focus.generator.crud.extjs.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.com.focus.generator.crud.extjs.schema package. 
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

    private final static QName _Crud_QNAME = new QName("http://www.focus.com.pe/generator/crud/extjs", "crud");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.com.focus.generator.crud.extjs.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Crud }
     * 
     */
    public Crud createCrud() {
        return new Crud();
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link Entities }
     * 
     */
    public Entities createEntities() {
        return new Entities();
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link Fields }
     * 
     */
    public Fields createFields() {
        return new Fields();
    }

    /**
     * Create an instance of {@link Store }
     * 
     */
    public Store createStore() {
        return new Store();
    }

    /**
     * Create an instance of {@link BackEnd }
     * 
     */
    public BackEnd createBackEnd() {
        return new BackEnd();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link Properties }
     * 
     */
    public Properties createProperties() {
        return new Properties();
    }

    /**
     * Create an instance of {@link Listener }
     * 
     */
    public Listener createListener() {
        return new Listener();
    }

    /**
     * Create an instance of {@link SubModels }
     * 
     */
    public SubModels createSubModels() {
        return new SubModels();
    }

    /**
     * Create an instance of {@link Controller }
     * 
     */
    public Controller createController() {
        return new Controller();
    }

    /**
     * Create an instance of {@link Listeners }
     * 
     */
    public Listeners createListeners() {
        return new Listeners();
    }

    /**
     * Create an instance of {@link ParameterStore }
     * 
     */
    public ParameterStore createParameterStore() {
        return new ParameterStore();
    }

    /**
     * Create an instance of {@link SubModel }
     * 
     */
    public SubModel createSubModel() {
        return new SubModel();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Crud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.focus.com.pe/generator/crud/extjs", name = "crud")
    public JAXBElement<Crud> createCrud(Crud value) {
        return new JAXBElement<Crud>(_Crud_QNAME, Crud.class, null, value);
    }

}
