package pe.com.acme.invoiceelec.business.impl;

import java.text.ParseException;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PricingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomerAssignedAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StreetNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UBLVersionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import pe.com.acme.inoiceelec.util.BarCodeUtil;
import pe.com.acme.inoiceelec.util.Constantes;
import pe.com.acme.inoiceelec.util.DocumentUtil;
import pe.com.acme.inoiceelec.util.GeneratedDocInfoDto;
import pe.com.acme.inoiceelec.util.SignInfoDto;
import pe.com.acme.invoiceelec.business.service.CommonService;
import pe.com.acme.invoiceelec.business.service.GestionarFacturaService;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElect;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElectExample;
import pe.com.acme.invoiceelec.model.mybatis.mapper.VentElectMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaDetalleQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaDetalleQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaWebQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.FacturaDetalleQueryMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.FacturaWebQueryMapper;
import pe.com.acme.util.MybatisRepositoryHelper;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalMonetaryTotalType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalPropertyType;
import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;

/**
 * Created by JRaffo on 23/06/16.
 */
@Service
public class GestionarFacturaServiceImpl extends MybatisRepositoryHelper implements GestionarFacturaService {

	private CurrencyCodeContentType MONEDA_DOCUMENTO = null;

	@Autowired
	private DocumentUtil documentUtil;

	@Autowired
	private BarCodeUtil barCodeUtil;

	@Autowired
	private CommonService commonService;

	@Autowired
	private VentElectMapper ventElectMapper;

	@Transactional
	@Override
	public GeneratedDocInfoDto generarDocumentoElectronico(FacturaQuery facturaQuery) throws Exception {

		InvoiceType invoiceType = new InvoiceType();
		GeneratedDocInfoDto generatedDocInfo = this.setMain(facturaQuery, invoiceType);

		return generatedDocInfo;
	}

	public GeneratedDocInfoDto setMain(FacturaQuery facturaQuery, InvoiceType invoiceType) throws Exception {

		// Obtener el numero de documento
		String numDoc = commonService.obtenerCorrelativo(Constantes.Empresa.ID_EMP,
				Constantes.Correlativo.TIPO_DOCUMENTO, Constantes.Correlativo.SERIE_FACTURA);

		// obtener moneda principal
		if (facturaQuery.getMonedadocumentoelectronico() == null) {
			MONEDA_DOCUMENTO = CurrencyCodeContentType.PEN;
		} else {
			MONEDA_DOCUMENTO = CurrencyCodeContentType.fromValue(facturaQuery.getMonedadocumentoelectronico());
		}

		// Creación de documento

		// Fecha de emision
		this.setFechaEmsion(facturaQuery.getFechaemision(), invoiceType);

		// Info de contribuyente
		this.setInfoContribuyente(facturaQuery, invoiceType);

		// Tipo y numero de documento electronicos
		InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
		invoiceTypeCodeType.setValue(Constantes.DocumentoElectronico.FACTURA);
		invoiceType.setInvoiceTypeCode(invoiceTypeCodeType);
		{
			IDType idType = new IDType();
			idType.setValue(numDoc);
			invoiceType.setID(idType);
		}

		// Info de usuario
		this.setInfoUsuario(facturaQuery, invoiceType);

		// Info Extensiones
		this.setExtensiones(facturaQuery, invoiceType);

		// Sumatoria tributos
		this.setSumatorias(facturaQuery, invoiceType);

		// Sumatoria otros cargos
		ChargeTotalAmountType chargeTotalAmountType = new ChargeTotalAmountType();
		chargeTotalAmountType.setValue(documentUtil.round(facturaQuery.getSumotroscargos()));
		chargeTotalAmountType.setCurrencyID(MONEDA_DOCUMENTO);
		// Total venta
		PayableAmountType payableAmountType = new PayableAmountType();
		payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
		payableAmountType.setValue(documentUtil.round(facturaQuery.getMontototalventa()));

		MonetaryTotalType monetaryTotalType = new MonetaryTotalType();
		monetaryTotalType.setChargeTotalAmount(chargeTotalAmountType);
		monetaryTotalType.setPayableAmount(payableAmountType);

		invoiceType.setLegalMonetaryTotal(monetaryTotalType);

		// Guia Remision
		{
			DocumentReferenceType documentReferenceType = new DocumentReferenceType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getNumeroguiaremision());
			documentReferenceType.setID(idType);
			DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
			documentTypeCodeType.setValue(facturaQuery.getTipodocumentoguiaremision());
			invoiceType.getDespatchDocumentReference().add(documentReferenceType);
		}

		// Otro documento de referencia
		{
			DocumentReferenceType documentReferenceType = new DocumentReferenceType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getNumerootrodocumento());
			documentReferenceType.setID(idType);
			DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
			documentTypeCodeType.setValue(facturaQuery.getTipodocumentootro());
			invoiceType.getAdditionalDocumentReference().add(documentReferenceType);
		}

		// Version
		UBLVersionIDType ublVersionIDType = new UBLVersionIDType();
		ublVersionIDType.setValue("2.0");
		CustomizationIDType customizationIDType = new CustomizationIDType();
		customizationIDType.setValue("1.0");

		invoiceType.setUBLVersionID(ublVersionIDType);
		invoiceType.setCustomizationID(customizationIDType);

		this.setDetail(facturaQuery, invoiceType);

		// Nombres de archivos
		String fileNameXml = documentUtil.getFileNameDoc(facturaQuery.getNumeroruc(),
				Constantes.DocumentoElectronico.FACTURA, Constantes.Correlativo.SERIE_FACTURA,
				documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_FACTURA, numDoc),
				Constantes.Extension.XML);
		String fileNameXmlSign = documentUtil.getFileNameDoc(facturaQuery.getNumeroruc(),
				Constantes.DocumentoElectronico.FACTURA, Constantes.Correlativo.SERIE_FACTURA,
				documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_FACTURA, numDoc),
				Constantes.Extension.XML);
		String fileNameXmlSignZip = documentUtil.getFileNameDoc(facturaQuery.getNumeroruc(),
				Constantes.DocumentoElectronico.FACTURA, Constantes.Correlativo.SERIE_FACTURA,
				documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_FACTURA, numDoc),
				Constantes.Extension.ZIP);

		// Generando y Firmando XML
		JAXBElement<InvoiceType> element = documentUtil.createInvoice(invoiceType);
		String pathXml = documentUtil.createXml(element, fileNameXml);
		String pathXmlSign = documentUtil.sign(pathXml, fileNameXmlSign);
		String pathXmlSignZip = documentUtil.zipXml(pathXmlSign, fileNameXmlSign, fileNameXmlSignZip);

		// Codigos de barra
		String pathBarCode = barCodeUtil.generateBarCode(numDoc, numDoc);

		SignInfoDto signInfo = documentUtil.getSignInfo(pathXmlSign);

		//
		String valorCodBar = facturaQuery.getNumeroruc() + "|";
		valorCodBar += facturaQuery.getTipodocumentoruc() + "|";
		valorCodBar += Constantes.Correlativo.SERIE_FACTURA + "|";
		valorCodBar += documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_FACTURA, numDoc) + "|";
		valorCodBar += facturaQuery.getSumigv().toString() + "|";
		valorCodBar += facturaQuery.getMontototalventa() + "|";
		valorCodBar += facturaQuery.getFechaemision() + "|";
		valorCodBar += facturaQuery.getTipodocumentousuario() + "|";
		valorCodBar += facturaQuery.getNumerodocumentousuario() + "|";
		valorCodBar += signInfo.getSignResume() + "|";
		valorCodBar += signInfo.getSignValue() + "|";

		String pathBarCodeMatrix = barCodeUtil.generateBarCodeMatrix(valorCodBar, numDoc);

		// Grabar en bd
		// Eliminar
		VentElectExample ventElectExample = new VentElectExample();
		ventElectExample.createCriteria().andEmpIdEqualTo(Constantes.Empresa.ID_EMP)
				.andDocumKeyEqualTo(facturaQuery.getVentas_key());
		ventElectMapper.deleteByExample(ventElectExample);

		// Grabando en tabla fact elect
		VentElect ventElect = new VentElect();

		ventElect.setEmpId(Constantes.Empresa.ID_EMP);
		ventElect.setEstadoDoc(Constantes.EstadoDocumentoElectronico.GENERADO);
		ventElect.setDocumKey(facturaQuery.getVentas_key());

		ventElect.setRutaDocElec(pathXmlSignZip);
		ventElect.setRutaCodBarras(pathBarCode);
		ventElect.setRutaCodBarrasMatrix(pathBarCodeMatrix);
		ventElect.setTipDocElect(Constantes.DocumentoElectronico.FACTURA);
		ventElect.setNumfSerie(Constantes.Correlativo.SERIE_FACTURA);
		ventElect.setNumfCorrel(documentUtil.numeroCorrelativoInt(Constantes.Correlativo.SERIE_FACTURA, numDoc));
		ventElect.setNumDocElect(numDoc);

		this.insert(VentElectMapper.class, ventElect);

		GeneratedDocInfoDto generatedDocInfo = new GeneratedDocInfoDto();
		generatedDocInfo.setNumDoc(facturaQuery.getVentas_key());
		generatedDocInfo.setNumDocElect(numDoc);
		generatedDocInfo.setPathFileZip(pathXmlSignZip);
		generatedDocInfo.setStatus(true);

		return generatedDocInfo;
	}

	public void setDetail(FacturaQuery facturaQuery, InvoiceType invoiceType) throws Exception {

		FacturaDetalleQueryCriteria facturaDetalleQueryCriteria = new FacturaDetalleQueryCriteria();
		facturaDetalleQueryCriteria.setEmp_id(facturaQuery.getEmp_id());
		facturaDetalleQueryCriteria.setVentas_key(facturaQuery.getVentas_key());

		List<FacturaDetalleQuery> facturaDetalleQueries = this.selectByQuery(FacturaDetalleQueryMapper.class,facturaDetalleQueryCriteria);

		int num = 1;
		
		for (FacturaDetalleQuery facturaDetalleQuery : facturaDetalleQueries) {

			InvoiceLineType invoiceLineType = new InvoiceLineType();

			InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType();
			invoicedQuantityType.setUnitCode(facturaDetalleQuery.getUnidadmedidaitem());
			invoicedQuantityType.setValue(documentUtil.round(facturaDetalleQuery.getCantidaditem()));

			ItemType itemType = new ItemType();
			DescriptionType descriptionType = new DescriptionType();
			descriptionType.setValue(facturaDetalleQuery.getDescripcionitem());
			itemType.getDescription().add(descriptionType);

			invoiceLineType.setInvoicedQuantity(invoicedQuantityType);
			invoiceLineType.setItem(itemType);

			{
				PriceType priceType = new PriceType();
				PriceAmountType priceAmountType = new PriceAmountType();
				priceAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				priceAmountType.setValue(documentUtil.round(facturaDetalleQuery.getValorunitarioitem()));
				priceType.setPriceAmount(priceAmountType);

				invoiceLineType.setPrice(priceType);
			}

			PricingReferenceType pricingReferenceType = new PricingReferenceType();
			{
				PriceType priceType = new PriceType();
				PriceAmountType priceAmountType = new PriceAmountType();
				priceAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				priceAmountType.setValue(documentUtil.round(facturaDetalleQuery.getPrecioventa()));
				priceType.setPriceAmount(priceAmountType);

				PriceTypeCodeType priceTypeCodeType = new PriceTypeCodeType();
				priceTypeCodeType.setValue(facturaDetalleQuery.getCodtipoprecioventa());

				priceType.setPriceTypeCode(priceTypeCodeType);

				pricingReferenceType.getAlternativeConditionPrice().add(priceType);

			}

			{
				PriceType priceType = new PriceType();
				PriceAmountType priceAmountType = new PriceAmountType();
				priceAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				priceAmountType.setValue(documentUtil.round(facturaDetalleQuery.getMontovalorrefunitario()));
				priceType.setPriceAmount(priceAmountType);

				PriceTypeCodeType priceTypeCodeType = new PriceTypeCodeType();
				priceTypeCodeType.setValue(facturaDetalleQuery.getCodtipoprecioref());

				priceType.setPriceTypeCode(priceTypeCodeType);

				pricingReferenceType.getAlternativeConditionPrice().add(priceType);

			}

			invoiceLineType.setPricingReference(pricingReferenceType);

			// IGV
			{
				TaxTotalType taxTotalType = new TaxTotalType();
				TaxSubtotalType taxSubtotalType = new TaxSubtotalType();

				{
					TaxAmountType taxAmountType = new TaxAmountType();
					taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
					taxAmountType.setValue(documentUtil.round(facturaDetalleQuery.getMontoigv()));
					taxTotalType.setTaxAmount(taxAmountType);
				}

				{
					TaxAmountType taxAmountType = new TaxAmountType();
					taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
					taxAmountType.setValue(documentUtil.round(facturaDetalleQuery.getMontoigv()));

					taxSubtotalType.setTaxAmount(taxAmountType);

					TaxCategoryType taxCategoryType = new TaxCategoryType();
					TaxSchemeType taxSchemeType = new TaxSchemeType();
					IDType idType = new IDType();
					idType.setValue(facturaDetalleQuery.getCodtributoigv());
					taxSchemeType.setID(idType);
					NameType nameType = new NameType();
					nameType.setValue(facturaDetalleQuery.getNombretributoigv());
					taxSchemeType.setName(nameType);
					TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
					taxTypeCodeType.setValue(facturaDetalleQuery.getCodtributointerigv());
					taxSchemeType.setTaxTypeCode(taxTypeCodeType);

					taxCategoryType.setTaxScheme(taxSchemeType);
					taxSubtotalType.setTaxCategory(taxCategoryType);
				}
				taxTotalType.getTaxSubtotal().add(taxSubtotalType);
				invoiceLineType.getTaxTotal().add(taxTotalType);
			}

			// ISC
			{
				TaxTotalType taxTotalType = new TaxTotalType();
				TaxSubtotalType taxSubtotalType = new TaxSubtotalType();

				{
					TaxAmountType taxAmountType = new TaxAmountType();
					taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
					taxAmountType.setValue(documentUtil.round(facturaDetalleQuery.getMontoisc()));
					taxTotalType.setTaxAmount(taxAmountType);
				}

				{
					TaxAmountType taxAmountType = new TaxAmountType();
					taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
					taxAmountType.setValue(documentUtil.round(facturaDetalleQuery.getMontoisc()));

					taxSubtotalType.setTaxAmount(taxAmountType);

					TaxCategoryType taxCategoryType = new TaxCategoryType();
					TaxSchemeType taxSchemeType = new TaxSchemeType();
					IDType idType = new IDType();
					idType.setValue(facturaDetalleQuery.getCodtributoisc());
					taxSchemeType.setID(idType);
					NameType nameType = new NameType();
					nameType.setValue(facturaDetalleQuery.getNombretributoisc());
					taxSchemeType.setName(nameType);
					TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
					taxTypeCodeType.setValue(facturaDetalleQuery.getCodtributointerisc());
					taxSchemeType.setTaxTypeCode(taxTypeCodeType);

					taxCategoryType.setTaxScheme(taxSchemeType);
					taxSubtotalType.setTaxCategory(taxCategoryType);
				}
				taxTotalType.getTaxSubtotal().add(taxSubtotalType);
				invoiceLineType.getTaxTotal().add(taxTotalType);
			}

			LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
			lineExtensionAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			lineExtensionAmountType.setValue(documentUtil.round(facturaDetalleQuery.getValorventa()));

			invoiceLineType.setLineExtensionAmount(lineExtensionAmountType);

			{
				IDType idType = new IDType();
				idType.setValue(String.valueOf(num));
				invoiceLineType.setID(idType);
			}

			{
				ItemType itemType2 = new ItemType();
				ItemIdentificationType itemIdentificationType = new ItemIdentificationType();
				{
					IDType idType = new IDType();
					idType.setValue(facturaDetalleQuery.getCodproducto());
					itemIdentificationType.setID(idType);
				}

				itemType2.setSellersItemIdentification(itemIdentificationType);
			}
			invoiceLineType.setItem(itemType);

			invoiceType.getInvoiceLine().add(invoiceLineType);
			num++;
		}
	}

	public void setFechaEmsion(String fechaEmision, InvoiceType invoiceType)
			throws DatatypeConfigurationException, ParseException {

		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaEmision);

		IssueDateType issueDateType = new IssueDateType();
		issueDateType.setValue(xmlGregorianCalendar);

		invoiceType.setIssueDate(issueDateType);

	}

	public void setInfoContribuyente(FacturaQuery documento, InvoiceType invoiceType) {

		SupplierPartyType supplierPartyType = new SupplierPartyType();
		PartyType partyType = new PartyType();

		RegistrationNameType registrationNameType = new RegistrationNameType();
		registrationNameType.setValue(documento.getRazonsocial());

		PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
		partyLegalEntityType.setRegistrationName(registrationNameType);

		PartyNameType partyNameType = new PartyNameType();
		NameType nameType = new NameType();
		nameType.setValue(documento.getNombrecomercial());
		partyNameType.setName(nameType);

		partyType.getPartyLegalEntity().add(partyLegalEntityType);
		partyType.getPartyName().add(partyNameType);

		AddressType addressType = new AddressType();
		IDType idType = new IDType();
		idType.setValue(documento.getIdubigeo());
		addressType.setID(idType);

		StreetNameType streetNameType = new StreetNameType();
		streetNameType.setValue(documento.getDireccioncompleta());

		addressType.setStreetName(streetNameType);

		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
		citySubdivisionNameType.setValue(documento.getNombreurbanizacion());

		addressType.setCitySubdivisionName(citySubdivisionNameType);

		CityNameType cityNameType = new CityNameType();
		cityNameType.setValue(documento.getNombreprovincia());

		addressType.setCityName(cityNameType);

		CountrySubentityType countrySubentityType = new CountrySubentityType();
		countrySubentityType.setValue(documento.getNombredepartamento());

		addressType.setCountrySubentity(countrySubentityType);

		DistrictType districtType = new DistrictType();
		districtType.setValue(documento.getNombredistrito());

		addressType.setDistrict(districtType);

		CountryType countryType = new CountryType();

		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		identificationCodeType.setValue(documento.getCodigopais());

		countryType.setIdentificationCode(identificationCodeType);
		addressType.setCountry(countryType);

		partyType.setPostalAddress(addressType);
		
		supplierPartyType.setParty(partyType);
		

		CustomerAssignedAccountIDType customerAssignedAccountIDType = new CustomerAssignedAccountIDType();
		customerAssignedAccountIDType.setValue(documento.getNumeroruc());

		supplierPartyType.setCustomerAssignedAccountID(customerAssignedAccountIDType);
		AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
		additionalAccountIDType.setValue(documento.getTipodocumentoruc());
		supplierPartyType.getAdditionalAccountID().add(additionalAccountIDType);

		invoiceType.setAccountingSupplierParty(supplierPartyType);

	}

	public void setInfoUsuario(FacturaQuery documento, InvoiceType invoiceType) {

		CustomerPartyType customerPartyType = new CustomerPartyType();
		CustomerAssignedAccountIDType customerAssignedAccountIDType = new CustomerAssignedAccountIDType();
		customerAssignedAccountIDType.setValue(documento.getNumerodocumentousuario());
		customerPartyType.setCustomerAssignedAccountID(customerAssignedAccountIDType);
		AdditionalAccountIDType additionalAccountIDType2 = new AdditionalAccountIDType();
		additionalAccountIDType2.setValue(documento.getTipodocumentousuario());
		customerPartyType.getAdditionalAccountID().add(additionalAccountIDType2);

		PartyType partyType2 = new PartyType();

		PartyLegalEntityType partyLegalEntityType2 = new PartyLegalEntityType();
		RegistrationNameType registrationNameType = new RegistrationNameType();
		registrationNameType.setValue(documento.getRazonsocialusuario());
		partyLegalEntityType2.setRegistrationName(registrationNameType);

		partyType2.getPartyLegalEntity().add(partyLegalEntityType2);

		customerPartyType.setParty(partyType2);

		invoiceType.setAccountingCustomerParty(customerPartyType);

	}

	public void setExtensiones(FacturaQuery facturaQuery, InvoiceType invoiceType) {

		UBLExtensionsType ublExtensionsType = new UBLExtensionsType();
		UBLExtensionType ublExtensionType = new UBLExtensionType();
		ExtensionContentType extensionContentType = new ExtensionContentType();

		AdditionalInformationType additionalInformationType = new AdditionalInformationType();
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getCodtipomontoopg());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(facturaQuery.getMontototalopg()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getCodtipomontoopi());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(facturaQuery.getMontototalopi()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getCodtipomontoopex());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(facturaQuery.getMontototalopex()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}
		// Total Descuentos
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getCodtipomontototaldscto());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(facturaQuery.getMontototaldscto()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}

		// Leyenda
		{
			{
				AdditionalPropertyType additionalPropertyType = new AdditionalPropertyType();
				IDType idType = new IDType();
				idType.setValue(facturaQuery.getCodigoleyendamoneda());
				additionalPropertyType.setID(idType);
				ValueType valueType = new ValueType();
				valueType.setValue(facturaQuery.getDescripcionleyendamoneda());
				additionalPropertyType.setValue(valueType);
				additionalInformationType.getAdditionalProperty().add(additionalPropertyType);
			}
			{
				AdditionalPropertyType additionalPropertyType = new AdditionalPropertyType();
				IDType idType = new IDType();
				idType.setValue(facturaQuery.getCodigoleyendapercepcion());
				additionalPropertyType.setID(idType);
				ValueType valueType = new ValueType();
				valueType.setValue(facturaQuery.getDescripcionleyendapercepcion());
				additionalPropertyType.setValue(valueType);
				additionalInformationType.getAdditionalProperty().add(additionalPropertyType);
			}

		}

		// Percepcion
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(facturaQuery.getCodtipomontopercepcion());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(facturaQuery.getMontopercepcion()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			AmountType amountType = new AmountType();
			amountType.setCurrencyID(MONEDA_DOCUMENTO);
			amountType.setValue(documentUtil.round(facturaQuery.getMontototalpercepcion()));
			additionalMonetaryTotalType.setTotalAmount(amountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);

		}

		extensionContentType.setAdditionalInformation(additionalInformationType);
		ublExtensionType.setExtensionContent(extensionContentType);
		ublExtensionsType.getUBLExtension().add(ublExtensionType);
		invoiceType.setUBLExtensions(ublExtensionsType);
	}

	public void setSumatorias(FacturaQuery facturaQuery, InvoiceType invoiceType) {
		// IGV
		{
			TaxTotalType taxTotalType = new TaxTotalType();
			TaxSubtotalType taxSubtotalType = new TaxSubtotalType();

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(facturaQuery.getSumigv()));
				taxTotalType.setTaxAmount(taxAmountType);
			}

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(facturaQuery.getSumigv()));

				taxSubtotalType.setTaxAmount(taxAmountType);

				TaxCategoryType taxCategoryType = new TaxCategoryType();
				TaxSchemeType taxSchemeType = new TaxSchemeType();
				IDType idType = new IDType();
				idType.setValue(facturaQuery.getCodtributoigv());
				taxSchemeType.setID(idType);
				NameType nameType = new NameType();
				nameType.setValue(facturaQuery.getNombretributoigv());
				taxSchemeType.setName(nameType);
				TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
				taxTypeCodeType.setValue(facturaQuery.getCodtributointerigv());
				taxSchemeType.setTaxTypeCode(taxTypeCodeType);

				taxCategoryType.setTaxScheme(taxSchemeType);
				taxSubtotalType.setTaxCategory(taxCategoryType);
			}
			taxTotalType.getTaxSubtotal().add(taxSubtotalType);
			invoiceType.getTaxTotal().add(taxTotalType);
		}

		// ISC
		{
			TaxTotalType taxTotalType = new TaxTotalType();
			TaxSubtotalType taxSubtotalType = new TaxSubtotalType();

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(facturaQuery.getSumisc()));
				taxTotalType.setTaxAmount(taxAmountType);
			}

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(facturaQuery.getSumisc()));

				taxSubtotalType.setTaxAmount(taxAmountType);

				TaxCategoryType taxCategoryType = new TaxCategoryType();
				TaxSchemeType taxSchemeType = new TaxSchemeType();
				IDType idType = new IDType();
				idType.setValue(facturaQuery.getCodtributoisc());
				taxSchemeType.setID(idType);
				NameType nameType = new NameType();
				nameType.setValue(facturaQuery.getNombretributoisc());
				taxSchemeType.setName(nameType);
				TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
				taxTypeCodeType.setValue(facturaQuery.getCodtributointerisc());
				taxSchemeType.setTaxTypeCode(taxTypeCodeType);

				taxCategoryType.setTaxScheme(taxSchemeType);
				taxSubtotalType.setTaxCategory(taxCategoryType);
			}
			taxTotalType.getTaxSubtotal().add(taxSubtotalType);
			invoiceType.getTaxTotal().add(taxTotalType);
		}

		// OTROS
		{
			TaxTotalType taxTotalType = new TaxTotalType();
			TaxSubtotalType taxSubtotalType = new TaxSubtotalType();

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(facturaQuery.getSumotrotributo()));
				taxTotalType.setTaxAmount(taxAmountType);
			}

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(facturaQuery.getSumotrotributo()));

				taxSubtotalType.setTaxAmount(taxAmountType);

				TaxCategoryType taxCategoryType = new TaxCategoryType();
				TaxSchemeType taxSchemeType = new TaxSchemeType();
				IDType idType = new IDType();
				idType.setValue(facturaQuery.getCodotrotributo());
				taxSchemeType.setID(idType);
				NameType nameType = new NameType();
				nameType.setValue(facturaQuery.getNombreotrotributo());
				taxSchemeType.setName(nameType);
				TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
				taxTypeCodeType.setValue(facturaQuery.getCodotrotributointer());
				taxSchemeType.setTaxTypeCode(taxTypeCodeType);

				taxCategoryType.setTaxScheme(taxSchemeType);
				taxSubtotalType.setTaxCategory(taxCategoryType);
			}
			taxTotalType.getTaxSubtotal().add(taxSubtotalType);
			invoiceType.getTaxTotal().add(taxTotalType);
		}
	}

	@Override
	public List<FacturaWebQuery> list(FacturaWebQueryCriteria criteria) throws Exception {
		List<FacturaWebQuery> list = this.selectByQuery(FacturaWebQueryMapper.class, criteria,criteria.getStart(),criteria.getLimit());
		return list;
	}

	@Transactional(rollbackForClassName = { "Exception" })
	@Override
	public int countRecords(FacturaWebQueryCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(FacturaWebQueryMapper.class, criteria);
		return count;
	}
}
