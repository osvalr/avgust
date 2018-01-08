//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.14 a las 06:55:13 PM PET 
//


package sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.RoadTransportType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeliveryTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.CodeType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.IdentifierType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.TextType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1 package. 
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

    private final static QName _SUNATRetentionAmount_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRetentionAmount");
    private final static QName _SUNATAquaticResources_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATAquaticResources");
    private final static QName _SUNATNetTotalCashed_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATNetTotalCashed");
    private final static QName _EndDocumentNumberID_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "EndDocumentNumberID");
    private final static QName _SUNATVerificationCode_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATVerificationCode");
    private final static QName _ReferenceAmount_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "ReferenceAmount");
    private final static QName _SUNATGoldTrading_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATGoldTrading");
    private final static QName _DeliveryCarrierTime_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "DeliveryCarrierTime");
    private final static QName _SUNATPerceptionDate_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATPerceptionDate");
    private final static QName _SUNATDespatchLine_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATDespatchLine");
    private final static QName _TotalAmount_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "TotalAmount");
    private final static QName _SUNATValueTravel_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATValueTravel");
    private final static QName _OriginalDespatchDocumentReference_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "OriginalDespatchDocumentReference");
    private final static QName _SUNATShipment_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATShipment");
    private final static QName _StartDocumentNumberID_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "StartDocumentNumberID");
    private final static QName _DocumentSerialID_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "DocumentSerialID");
    private final static QName _VoidReasonDescription_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "VoidReasonDescription");
    private final static QName _SUNATTotalPaid_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATTotalPaid");
    private final static QName _TransportReasonCode_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "TransportReasonCode");
    private final static QName _SUNATRetentionInformation_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRetentionInformation");
    private final static QName _SUNATRetentionSystemCode_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRetentionSystemCode");
    private final static QName _SUNATPerceptionDocumentReference_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATPerceptionDocumentReference");
    private final static QName _AdditionalInformation_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "AdditionalInformation");
    private final static QName _SUNATValueVehicle_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATValueVehicle");
    private final static QName _BillingPayment_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "BillingPayment");
    private final static QName _DespatchChangeReason_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "DespatchChangeReason");
    private final static QName _VoidedDocumentsLine_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "VoidedDocumentsLine");
    private final static QName _AdditionalMonetaryTotal_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "AdditionalMonetaryTotal");
    private final static QName _SUNATTransportMeans_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATTransportMeans");
    private final static QName _DocumentNumberID_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "DocumentNumberID");
    private final static QName _SUNATPerceptionAmount_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATPerceptionAmount");
    private final static QName _SUNATRetentionDate_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRetentionDate");
    private final static QName _DriverParty_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "DriverParty");
    private final static QName _SUNATFiscalPath_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATFiscalPath");
    private final static QName _SUNATReferenceValue_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATReferenceValue");
    private final static QName _SUNATCosts_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATCosts");
    private final static QName _OldDeliveryAddress_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "OldDeliveryAddress");
    private final static QName _OldOriginAddress_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "OldOriginAddress");
    private final static QName _SUNATShipmentStage_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATShipmentStage");
    private final static QName _ShipmentStageTypeCode_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "ShipmentStageTypeCode");
    private final static QName _SUNATPerceptionInformation_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATPerceptionInformation");
    private final static QName _SUNATRetentionDocumentReference_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRetentionDocumentReference");
    private final static QName _MultiStageIndicator_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "MultiStageIndicator");
    private final static QName _SUNATTotalCashed_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATTotalCashed");
    private final static QName _DeliveryCarrierDate_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "DeliveryCarrierDate");
    private final static QName _SUNATRoadTransport_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRoadTransport");
    private final static QName _SUNATCarrierParty_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATCarrierParty");
    private final static QName _SUNATTransaction_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATTransaction");
    private final static QName _OutsourcedIndicator_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "OutsourcedIndicator");
    private final static QName _SummaryDocumentsLine_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SummaryDocumentsLine");
    private final static QName _PeriodID_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "PeriodID");
    private final static QName _SUNATEmbededDespatchAdvice_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATEmbededDespatchAdvice");
    private final static QName _SemiTrailer_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SemiTrailer");
    private final static QName _SUNATPerceptionSystemCode_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATPerceptionSystemCode");
    private final static QName _SUNATNetTotalPaid_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATNetTotalPaid");
    private final static QName _SUNATPerceptionPercent_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATPerceptionPercent");
    private final static QName _AdditionalProperty_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "AdditionalProperty");
    private final static QName _SUNATTransport_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATTransport");
    private final static QName _SUNATDeductions_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATDeductions");
    private final static QName _SUNATRetentionPercent_QNAME = new QName("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", "SUNATRetentionPercent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SUNATCarrierPartyType }
     * 
     */
    public SUNATCarrierPartyType createSUNATCarrierPartyType() {
        return new SUNATCarrierPartyType();
    }

    /**
     * Create an instance of {@link SUNATRetentionDateType }
     * 
     */
    public SUNATRetentionDateType createSUNATRetentionDateType() {
        return new SUNATRetentionDateType();
    }

    /**
     * Create an instance of {@link SUNATFiscalPathType }
     * 
     */
    public SUNATFiscalPathType createSUNATFiscalPathType() {
        return new SUNATFiscalPathType();
    }

    /**
     * Create an instance of {@link SUNATPerceptionInformationType }
     * 
     */
    public SUNATPerceptionInformationType createSUNATPerceptionInformationType() {
        return new SUNATPerceptionInformationType();
    }

    /**
     * Create an instance of {@link SUNATTransactionType }
     * 
     */
    public SUNATTransactionType createSUNATTransactionType() {
        return new SUNATTransactionType();
    }

    /**
     * Create an instance of {@link SUNATAquaticResourcesType }
     * 
     */
    public SUNATAquaticResourcesType createSUNATAquaticResourcesType() {
        return new SUNATAquaticResourcesType();
    }

    /**
     * Create an instance of {@link AdditionalMonetaryTotalType }
     * 
     */
    public AdditionalMonetaryTotalType createAdditionalMonetaryTotalType() {
        return new AdditionalMonetaryTotalType();
    }

    /**
     * Create an instance of {@link SUNATShipmentStageType }
     * 
     */
    public SUNATShipmentStageType createSUNATShipmentStageType() {
        return new SUNATShipmentStageType();
    }

    /**
     * Create an instance of {@link VoidedDocumentsLineType }
     * 
     */
    public VoidedDocumentsLineType createVoidedDocumentsLineType() {
        return new VoidedDocumentsLineType();
    }

    /**
     * Create an instance of {@link SUNATGoldTradingType }
     * 
     */
    public SUNATGoldTradingType createSUNATGoldTradingType() {
        return new SUNATGoldTradingType();
    }

    /**
     * Create an instance of {@link DriverPartyType }
     * 
     */
    public DriverPartyType createDriverPartyType() {
        return new DriverPartyType();
    }

    /**
     * Create an instance of {@link SUNATRetentionInformationType }
     * 
     */
    public SUNATRetentionInformationType createSUNATRetentionInformationType() {
        return new SUNATRetentionInformationType();
    }

    /**
     * Create an instance of {@link SUNATEmbededDespatchAdviceType }
     * 
     */
    public SUNATEmbededDespatchAdviceType createSUNATEmbededDespatchAdviceType() {
        return new SUNATEmbededDespatchAdviceType();
    }

    /**
     * Create an instance of {@link SUNATTransportMeansType }
     * 
     */
    public SUNATTransportMeansType createSUNATTransportMeansType() {
        return new SUNATTransportMeansType();
    }

    /**
     * Create an instance of {@link SUNATShipmentType }
     * 
     */
    public SUNATShipmentType createSUNATShipmentType() {
        return new SUNATShipmentType();
    }

    /**
     * Create an instance of {@link DeliveryCarrierDateType }
     * 
     */
    public DeliveryCarrierDateType createDeliveryCarrierDateType() {
        return new DeliveryCarrierDateType();
    }

    /**
     * Create an instance of {@link SUNATPerceptionDateType }
     * 
     */
    public SUNATPerceptionDateType createSUNATPerceptionDateType() {
        return new SUNATPerceptionDateType();
    }

    /**
     * Create an instance of {@link SUNATValueVehicleType }
     * 
     */
    public SUNATValueVehicleType createSUNATValueVehicleType() {
        return new SUNATValueVehicleType();
    }

    /**
     * Create an instance of {@link SUNATPerceptionDocumentReferenceType }
     * 
     */
    public SUNATPerceptionDocumentReferenceType createSUNATPerceptionDocumentReferenceType() {
        return new SUNATPerceptionDocumentReferenceType();
    }

    /**
     * Create an instance of {@link SUNATReferenceValueType }
     * 
     */
    public SUNATReferenceValueType createSUNATReferenceValueType() {
        return new SUNATReferenceValueType();
    }

    /**
     * Create an instance of {@link SUNATValueTravelType }
     * 
     */
    public SUNATValueTravelType createSUNATValueTravelType() {
        return new SUNATValueTravelType();
    }

    /**
     * Create an instance of {@link SummaryDocumentsLineType }
     * 
     */
    public SummaryDocumentsLineType createSummaryDocumentsLineType() {
        return new SummaryDocumentsLineType();
    }

    /**
     * Create an instance of {@link AdditionalInformationType }
     * 
     */
    public AdditionalInformationType createAdditionalInformationType() {
        return new AdditionalInformationType();
    }

    /**
     * Create an instance of {@link SUNATDeductionsType }
     * 
     */
    public SUNATDeductionsType createSUNATDeductionsType() {
        return new SUNATDeductionsType();
    }

    /**
     * Create an instance of {@link SUNATTransportType }
     * 
     */
    public SUNATTransportType createSUNATTransportType() {
        return new SUNATTransportType();
    }

    /**
     * Create an instance of {@link SUNATRoadTransportType }
     * 
     */
    public SUNATRoadTransportType createSUNATRoadTransportType() {
        return new SUNATRoadTransportType();
    }

    /**
     * Create an instance of {@link SUNATCostsType }
     * 
     */
    public SUNATCostsType createSUNATCostsType() {
        return new SUNATCostsType();
    }

    /**
     * Create an instance of {@link SUNATRetentionDocumentReferenceType }
     * 
     */
    public SUNATRetentionDocumentReferenceType createSUNATRetentionDocumentReferenceType() {
        return new SUNATRetentionDocumentReferenceType();
    }

    /**
     * Create an instance of {@link SUNATDespatchLineType }
     * 
     */
    public SUNATDespatchLineType createSUNATDespatchLineType() {
        return new SUNATDespatchLineType();
    }

    /**
     * Create an instance of {@link AdditionalPropertyType }
     * 
     */
    public AdditionalPropertyType createAdditionalPropertyType() {
        return new AdditionalPropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRetentionAmount")
    public JAXBElement<AmountType> createSUNATRetentionAmount(AmountType value) {
        return new JAXBElement<AmountType>(_SUNATRetentionAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATAquaticResourcesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATAquaticResources")
    public JAXBElement<SUNATAquaticResourcesType> createSUNATAquaticResources(SUNATAquaticResourcesType value) {
        return new JAXBElement<SUNATAquaticResourcesType>(_SUNATAquaticResources_QNAME, SUNATAquaticResourcesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATNetTotalCashed")
    public JAXBElement<AmountType> createSUNATNetTotalCashed(AmountType value) {
        return new JAXBElement<AmountType>(_SUNATNetTotalCashed_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "EndDocumentNumberID")
    public JAXBElement<IdentifierType> createEndDocumentNumberID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_EndDocumentNumberID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATVerificationCode")
    public JAXBElement<IDType> createSUNATVerificationCode(IDType value) {
        return new JAXBElement<IDType>(_SUNATVerificationCode_QNAME, IDType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "ReferenceAmount")
    public JAXBElement<AmountType> createReferenceAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ReferenceAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATGoldTradingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATGoldTrading")
    public JAXBElement<SUNATGoldTradingType> createSUNATGoldTrading(SUNATGoldTradingType value) {
        return new JAXBElement<SUNATGoldTradingType>(_SUNATGoldTrading_QNAME, SUNATGoldTradingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryTimeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "DeliveryCarrierTime")
    public JAXBElement<DeliveryTimeType> createDeliveryCarrierTime(DeliveryTimeType value) {
        return new JAXBElement<DeliveryTimeType>(_DeliveryCarrierTime_QNAME, DeliveryTimeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATPerceptionDateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATPerceptionDate")
    public JAXBElement<SUNATPerceptionDateType> createSUNATPerceptionDate(SUNATPerceptionDateType value) {
        return new JAXBElement<SUNATPerceptionDateType>(_SUNATPerceptionDate_QNAME, SUNATPerceptionDateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATDespatchLineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATDespatchLine")
    public JAXBElement<SUNATDespatchLineType> createSUNATDespatchLine(SUNATDespatchLineType value) {
        return new JAXBElement<SUNATDespatchLineType>(_SUNATDespatchLine_QNAME, SUNATDespatchLineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "TotalAmount")
    public JAXBElement<AmountType> createTotalAmount(AmountType value) {
        return new JAXBElement<AmountType>(_TotalAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATValueTravelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATValueTravel")
    public JAXBElement<SUNATValueTravelType> createSUNATValueTravel(SUNATValueTravelType value) {
        return new JAXBElement<SUNATValueTravelType>(_SUNATValueTravel_QNAME, SUNATValueTravelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "OriginalDespatchDocumentReference")
    public JAXBElement<DocumentReferenceType> createOriginalDespatchDocumentReference(DocumentReferenceType value) {
        return new JAXBElement<DocumentReferenceType>(_OriginalDespatchDocumentReference_QNAME, DocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATShipmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATShipment")
    public JAXBElement<SUNATShipmentType> createSUNATShipment(SUNATShipmentType value) {
        return new JAXBElement<SUNATShipmentType>(_SUNATShipment_QNAME, SUNATShipmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "StartDocumentNumberID")
    public JAXBElement<IdentifierType> createStartDocumentNumberID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_StartDocumentNumberID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "DocumentSerialID")
    public JAXBElement<IdentifierType> createDocumentSerialID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_DocumentSerialID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "VoidReasonDescription")
    public JAXBElement<TextType> createVoidReasonDescription(TextType value) {
        return new JAXBElement<TextType>(_VoidReasonDescription_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATTotalPaid")
    public JAXBElement<AmountType> createSUNATTotalPaid(AmountType value) {
        return new JAXBElement<AmountType>(_SUNATTotalPaid_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "TransportReasonCode")
    public JAXBElement<CodeType> createTransportReasonCode(CodeType value) {
        return new JAXBElement<CodeType>(_TransportReasonCode_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATRetentionInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRetentionInformation")
    public JAXBElement<SUNATRetentionInformationType> createSUNATRetentionInformation(SUNATRetentionInformationType value) {
        return new JAXBElement<SUNATRetentionInformationType>(_SUNATRetentionInformation_QNAME, SUNATRetentionInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRetentionSystemCode")
    public JAXBElement<IDType> createSUNATRetentionSystemCode(IDType value) {
        return new JAXBElement<IDType>(_SUNATRetentionSystemCode_QNAME, IDType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATPerceptionDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATPerceptionDocumentReference")
    public JAXBElement<SUNATPerceptionDocumentReferenceType> createSUNATPerceptionDocumentReference(SUNATPerceptionDocumentReferenceType value) {
        return new JAXBElement<SUNATPerceptionDocumentReferenceType>(_SUNATPerceptionDocumentReference_QNAME, SUNATPerceptionDocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionalInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "AdditionalInformation")
    public JAXBElement<AdditionalInformationType> createAdditionalInformation(AdditionalInformationType value) {
        return new JAXBElement<AdditionalInformationType>(_AdditionalInformation_QNAME, AdditionalInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATValueVehicleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATValueVehicle")
    public JAXBElement<SUNATValueVehicleType> createSUNATValueVehicle(SUNATValueVehicleType value) {
        return new JAXBElement<SUNATValueVehicleType>(_SUNATValueVehicle_QNAME, SUNATValueVehicleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "BillingPayment")
    public JAXBElement<PaymentType> createBillingPayment(PaymentType value) {
        return new JAXBElement<PaymentType>(_BillingPayment_QNAME, PaymentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "DespatchChangeReason")
    public JAXBElement<IDType> createDespatchChangeReason(IDType value) {
        return new JAXBElement<IDType>(_DespatchChangeReason_QNAME, IDType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoidedDocumentsLineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "VoidedDocumentsLine")
    public JAXBElement<VoidedDocumentsLineType> createVoidedDocumentsLine(VoidedDocumentsLineType value) {
        return new JAXBElement<VoidedDocumentsLineType>(_VoidedDocumentsLine_QNAME, VoidedDocumentsLineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionalMonetaryTotalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "AdditionalMonetaryTotal")
    public JAXBElement<AdditionalMonetaryTotalType> createAdditionalMonetaryTotal(AdditionalMonetaryTotalType value) {
        return new JAXBElement<AdditionalMonetaryTotalType>(_AdditionalMonetaryTotal_QNAME, AdditionalMonetaryTotalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATTransportMeansType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATTransportMeans")
    public JAXBElement<SUNATTransportMeansType> createSUNATTransportMeans(SUNATTransportMeansType value) {
        return new JAXBElement<SUNATTransportMeansType>(_SUNATTransportMeans_QNAME, SUNATTransportMeansType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "DocumentNumberID")
    public JAXBElement<IdentifierType> createDocumentNumberID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_DocumentNumberID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATPerceptionAmount")
    public JAXBElement<AmountType> createSUNATPerceptionAmount(AmountType value) {
        return new JAXBElement<AmountType>(_SUNATPerceptionAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATRetentionDateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRetentionDate")
    public JAXBElement<SUNATRetentionDateType> createSUNATRetentionDate(SUNATRetentionDateType value) {
        return new JAXBElement<SUNATRetentionDateType>(_SUNATRetentionDate_QNAME, SUNATRetentionDateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverPartyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "DriverParty")
    public JAXBElement<DriverPartyType> createDriverParty(DriverPartyType value) {
        return new JAXBElement<DriverPartyType>(_DriverParty_QNAME, DriverPartyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATFiscalPathType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATFiscalPath")
    public JAXBElement<SUNATFiscalPathType> createSUNATFiscalPath(SUNATFiscalPathType value) {
        return new JAXBElement<SUNATFiscalPathType>(_SUNATFiscalPath_QNAME, SUNATFiscalPathType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATReferenceValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATReferenceValue")
    public JAXBElement<SUNATReferenceValueType> createSUNATReferenceValue(SUNATReferenceValueType value) {
        return new JAXBElement<SUNATReferenceValueType>(_SUNATReferenceValue_QNAME, SUNATReferenceValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATCostsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATCosts")
    public JAXBElement<SUNATCostsType> createSUNATCosts(SUNATCostsType value) {
        return new JAXBElement<SUNATCostsType>(_SUNATCosts_QNAME, SUNATCostsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "OldDeliveryAddress")
    public JAXBElement<AddressType> createOldDeliveryAddress(AddressType value) {
        return new JAXBElement<AddressType>(_OldDeliveryAddress_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "OldOriginAddress")
    public JAXBElement<AddressType> createOldOriginAddress(AddressType value) {
        return new JAXBElement<AddressType>(_OldOriginAddress_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATShipmentStageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATShipmentStage")
    public JAXBElement<SUNATShipmentStageType> createSUNATShipmentStage(SUNATShipmentStageType value) {
        return new JAXBElement<SUNATShipmentStageType>(_SUNATShipmentStage_QNAME, SUNATShipmentStageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "ShipmentStageTypeCode")
    public JAXBElement<IDType> createShipmentStageTypeCode(IDType value) {
        return new JAXBElement<IDType>(_ShipmentStageTypeCode_QNAME, IDType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATPerceptionInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATPerceptionInformation")
    public JAXBElement<SUNATPerceptionInformationType> createSUNATPerceptionInformation(SUNATPerceptionInformationType value) {
        return new JAXBElement<SUNATPerceptionInformationType>(_SUNATPerceptionInformation_QNAME, SUNATPerceptionInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATRetentionDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRetentionDocumentReference")
    public JAXBElement<SUNATRetentionDocumentReferenceType> createSUNATRetentionDocumentReference(SUNATRetentionDocumentReferenceType value) {
        return new JAXBElement<SUNATRetentionDocumentReferenceType>(_SUNATRetentionDocumentReference_QNAME, SUNATRetentionDocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndicatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "MultiStageIndicator")
    public JAXBElement<IndicatorType> createMultiStageIndicator(IndicatorType value) {
        return new JAXBElement<IndicatorType>(_MultiStageIndicator_QNAME, IndicatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATTotalCashed")
    public JAXBElement<AmountType> createSUNATTotalCashed(AmountType value) {
        return new JAXBElement<AmountType>(_SUNATTotalCashed_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryCarrierDateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "DeliveryCarrierDate")
    public JAXBElement<DeliveryCarrierDateType> createDeliveryCarrierDate(DeliveryCarrierDateType value) {
        return new JAXBElement<DeliveryCarrierDateType>(_DeliveryCarrierDate_QNAME, DeliveryCarrierDateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATRoadTransportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRoadTransport")
    public JAXBElement<SUNATRoadTransportType> createSUNATRoadTransport(SUNATRoadTransportType value) {
        return new JAXBElement<SUNATRoadTransportType>(_SUNATRoadTransport_QNAME, SUNATRoadTransportType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATCarrierPartyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATCarrierParty")
    public JAXBElement<SUNATCarrierPartyType> createSUNATCarrierParty(SUNATCarrierPartyType value) {
        return new JAXBElement<SUNATCarrierPartyType>(_SUNATCarrierParty_QNAME, SUNATCarrierPartyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATTransactionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATTransaction")
    public JAXBElement<SUNATTransactionType> createSUNATTransaction(SUNATTransactionType value) {
        return new JAXBElement<SUNATTransactionType>(_SUNATTransaction_QNAME, SUNATTransactionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndicatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "OutsourcedIndicator")
    public JAXBElement<IndicatorType> createOutsourcedIndicator(IndicatorType value) {
        return new JAXBElement<IndicatorType>(_OutsourcedIndicator_QNAME, IndicatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SummaryDocumentsLineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SummaryDocumentsLine")
    public JAXBElement<SummaryDocumentsLineType> createSummaryDocumentsLine(SummaryDocumentsLineType value) {
        return new JAXBElement<SummaryDocumentsLineType>(_SummaryDocumentsLine_QNAME, SummaryDocumentsLineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "PeriodID")
    public JAXBElement<IdentifierType> createPeriodID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_PeriodID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATEmbededDespatchAdviceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATEmbededDespatchAdvice")
    public JAXBElement<SUNATEmbededDespatchAdviceType> createSUNATEmbededDespatchAdvice(SUNATEmbededDespatchAdviceType value) {
        return new JAXBElement<SUNATEmbededDespatchAdviceType>(_SUNATEmbededDespatchAdvice_QNAME, SUNATEmbededDespatchAdviceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoadTransportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SemiTrailer")
    public JAXBElement<RoadTransportType> createSemiTrailer(RoadTransportType value) {
        return new JAXBElement<RoadTransportType>(_SemiTrailer_QNAME, RoadTransportType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATPerceptionSystemCode")
    public JAXBElement<IDType> createSUNATPerceptionSystemCode(IDType value) {
        return new JAXBElement<IDType>(_SUNATPerceptionSystemCode_QNAME, IDType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATNetTotalPaid")
    public JAXBElement<AmountType> createSUNATNetTotalPaid(AmountType value) {
        return new JAXBElement<AmountType>(_SUNATNetTotalPaid_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PercentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATPerceptionPercent")
    public JAXBElement<PercentType> createSUNATPerceptionPercent(PercentType value) {
        return new JAXBElement<PercentType>(_SUNATPerceptionPercent_QNAME, PercentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionalPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "AdditionalProperty")
    public JAXBElement<AdditionalPropertyType> createAdditionalProperty(AdditionalPropertyType value) {
        return new JAXBElement<AdditionalPropertyType>(_AdditionalProperty_QNAME, AdditionalPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATTransportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATTransport")
    public JAXBElement<SUNATTransportType> createSUNATTransport(SUNATTransportType value) {
        return new JAXBElement<SUNATTransportType>(_SUNATTransport_QNAME, SUNATTransportType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUNATDeductionsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATDeductions")
    public JAXBElement<SUNATDeductionsType> createSUNATDeductions(SUNATDeductionsType value) {
        return new JAXBElement<SUNATDeductionsType>(_SUNATDeductions_QNAME, SUNATDeductionsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PercentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", name = "SUNATRetentionPercent")
    public JAXBElement<PercentType> createSUNATRetentionPercent(PercentType value) {
        return new JAXBElement<PercentType>(_SUNATRetentionPercent_QNAME, PercentType.class, null, value);
    }

}