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
import pe.com.acme.invoiceelec.business.service.GestionarBoletaService;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElect;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElectExample;
import pe.com.acme.invoiceelec.model.mybatis.mapper.VentElectMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaDetalleQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaDetalleQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.BoletaDetalleQueryMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.BoletaWebQueryMapper;
import pe.com.acme.util.MybatisRepositoryHelper;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalMonetaryTotalType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalPropertyType;
import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;

@Service
public class GestionarBoletaServiceImpl extends MybatisRepositoryHelper implements GestionarBoletaService {

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
	public GeneratedDocInfoDto generarDocumentoElectronico(BoletaQuery boletaQuery) throws Exception {

		InvoiceType invoiceType = new InvoiceType();
		GeneratedDocInfoDto generatedDocInfo = this.setMain(boletaQuery, invoiceType);

		return generatedDocInfo;
	}


	public GeneratedDocInfoDto setMain(BoletaQuery boletaQuery, InvoiceType invoiceType) throws Exception {
		
		//Obtener el numero de documento
		String numDoc = commonService.obtenerCorrelativo(Constantes.Empresa.ID_EMP, Constantes.Correlativo.TIPO_DOCUMENTO, Constantes.Correlativo.SERIE_BOLETA);
		
		//obtener moneda principal
		if(boletaQuery.getMonedadocumentoelectronico() == null){
			MONEDA_DOCUMENTO = CurrencyCodeContentType.PEN;
		}else{
			MONEDA_DOCUMENTO = CurrencyCodeContentType.fromValue(boletaQuery.getMonedadocumentoelectronico());
		}

		// Creación de documento

		// Fecha de emision
		this.setFechaEmsion(boletaQuery.getFechaemision(), invoiceType);

		// Info de contribuyente
		this.setInfoContribuyente(boletaQuery, invoiceType);

		// Tipo y numero de documento electronicos
		InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
		invoiceTypeCodeType.setValue(Constantes.DocumentoElectronico.BOLETA);
		invoiceType.setInvoiceTypeCode(invoiceTypeCodeType);
		{
			IDType idType = new IDType();
			idType.setValue(numDoc);
			invoiceType.setID(idType);
		}

		// Info de usuario
		this.setInfoUsuario(boletaQuery, invoiceType);
 
		// Info Extensiones
		this.setExtensiones(boletaQuery, invoiceType);

		// Sumatoria tributos
		this.setSumatorias(boletaQuery, invoiceType);

		// Sumatoria otros cargos
		ChargeTotalAmountType chargeTotalAmountType = new ChargeTotalAmountType();
		chargeTotalAmountType.setValue(documentUtil.round(boletaQuery.getSumotroscargos()));
		chargeTotalAmountType.setCurrencyID(MONEDA_DOCUMENTO);
		// Total venta
		PayableAmountType payableAmountType = new PayableAmountType();
		payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
		payableAmountType.setValue(documentUtil.round(boletaQuery.getMontototalventa()));

		MonetaryTotalType monetaryTotalType = new MonetaryTotalType();
		monetaryTotalType.setChargeTotalAmount(chargeTotalAmountType);
		monetaryTotalType.setPayableAmount(payableAmountType);

		invoiceType.setLegalMonetaryTotal(monetaryTotalType);

		// Guia Remision
		{
			DocumentReferenceType documentReferenceType = new DocumentReferenceType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getNumeroguiaremision());
			documentReferenceType.setID(idType);
			DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
			documentTypeCodeType.setValue(boletaQuery.getTipodocumentoguiaremision());
			invoiceType.getDespatchDocumentReference().add(documentReferenceType);
		}

		// Otro documento de referencia
		{
			DocumentReferenceType documentReferenceType = new DocumentReferenceType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getNumerootrodocumento());
			documentReferenceType.setID(idType);
			DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
			documentTypeCodeType.setValue(boletaQuery.getTipodocumentootro());
			invoiceType.getAdditionalDocumentReference().add(documentReferenceType);
		}

		// Version
		UBLVersionIDType ublVersionIDType = new UBLVersionIDType();
		ublVersionIDType.setValue("2.0");
		CustomizationIDType customizationIDType = new CustomizationIDType();
		customizationIDType.setValue("1.0");

		invoiceType.setUBLVersionID(ublVersionIDType);
		invoiceType.setCustomizationID(customizationIDType);

		this.setDetail(boletaQuery, invoiceType);
		
		//Nombres de archivos
		String fileNameXml = documentUtil.getFileNameDoc(boletaQuery.getNumeroruc(), Constantes.DocumentoElectronico.BOLETA, Constantes.Correlativo.SERIE_BOLETA, documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_BOLETA,numDoc), Constantes.Extension.XML);
		String fileNameXmlSign = documentUtil.getFileNameDoc(boletaQuery.getNumeroruc(), Constantes.DocumentoElectronico.BOLETA, Constantes.Correlativo.SERIE_BOLETA, documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_BOLETA,numDoc), Constantes.Extension.XML);
		String fileNameXmlSignZip = documentUtil.getFileNameDoc(boletaQuery.getNumeroruc(), Constantes.DocumentoElectronico.BOLETA, Constantes.Correlativo.SERIE_BOLETA, documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_BOLETA,numDoc), Constantes.Extension.ZIP);

		
		//Generando y Firmando XML
		JAXBElement<InvoiceType> element = documentUtil.createInvoice(invoiceType);
		String pathXml = documentUtil.createXml(element, fileNameXml);
		String pathXmlSign = documentUtil.sign(pathXml,fileNameXmlSign);
		String pathXmlSignZip =  documentUtil.zipXml(pathXmlSign, fileNameXmlSign, fileNameXmlSignZip);

		//Codigos de barra
		String pathBarCode =  barCodeUtil.generateBarCode(numDoc, numDoc);
		
		SignInfoDto signInfo = documentUtil.getSignInfo(pathXmlSign);
		
		//
		String valorCodBar = boletaQuery.getNumeroruc() + "|";
		valorCodBar += boletaQuery.getTipodocumentoruc() + "|";
		valorCodBar += Constantes.Correlativo.SERIE_BOLETA + "|";
		valorCodBar += documentUtil.numeroCorrelativoString(Constantes.Correlativo.SERIE_BOLETA,numDoc) + "|";
		valorCodBar += boletaQuery.getSumigv().toString() + "|";
		valorCodBar += boletaQuery.getMontototalventa() + "|";
		valorCodBar += boletaQuery.getFechaemision() + "|";
		valorCodBar += boletaQuery.getTipodocumentousuario() + "|";
		valorCodBar += boletaQuery.getNumerodocumentousuario() + "|";
		valorCodBar += signInfo.getSignResume() + "|";
		valorCodBar += signInfo.getSignValue() + "|";
		
		String pathBarCodeMatrix =  barCodeUtil.generateBarCodeMatrix(valorCodBar, numDoc);
		
		//Grabar en bd
		//Eliminar
		VentElectExample ventElectExample = new VentElectExample();
		ventElectExample.createCriteria().andEmpIdEqualTo(Constantes.Empresa.ID_EMP).andDocumKeyEqualTo(boletaQuery.getVentas_key());
		ventElectMapper.deleteByExample(ventElectExample);
		
		//Grabando en tabla fact elect
		VentElect ventElect = new VentElect();
		
		ventElect.setEmpId(Constantes.Empresa.ID_EMP);
		ventElect.setEstadoDoc(Constantes.EstadoDocumentoElectronico.GENERADO);
		ventElect.setDocumKey(boletaQuery.getVentas_key());
		
		ventElect.setRutaDocElec(pathXmlSignZip);
		ventElect.setRutaCodBarras(pathBarCode);
		ventElect.setRutaCodBarrasMatrix(pathBarCodeMatrix);
		ventElect.setTipDocElect(Constantes.DocumentoElectronico.BOLETA);
		ventElect.setNumfSerie(Constantes.Correlativo.SERIE_BOLETA);
		ventElect.setNumfCorrel(documentUtil.numeroCorrelativoInt(Constantes.Correlativo.SERIE_BOLETA,numDoc));
		ventElect.setNumDocElect(numDoc);
		
		this.insert(VentElectMapper.class, ventElect);
		
		GeneratedDocInfoDto generatedDocInfo = new GeneratedDocInfoDto();
		generatedDocInfo.setNumDoc(numDoc);
		generatedDocInfo.setPathFileZip(pathXmlSignZip);
		generatedDocInfo.setStatus(true);
		
		return generatedDocInfo;
	}

	public void setDetail(BoletaQuery boletaQuery, InvoiceType invoiceType) throws Exception {

		BoletaDetalleQueryCriteria boletaDetalleQueryCriteria = new BoletaDetalleQueryCriteria();
		boletaDetalleQueryCriteria.setEmp_id(boletaQuery.getEmp_id());
		boletaDetalleQueryCriteria.setVentas_key(boletaQuery.getVentas_key());

		List<BoletaDetalleQuery> boletaDetalleQueries = this.selectByQuery(BoletaDetalleQueryMapper.class, boletaDetalleQueryCriteria);

		for (BoletaDetalleQuery boletaDetalleQuery : boletaDetalleQueries) {

			InvoiceLineType invoiceLineType = new InvoiceLineType();

			InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType();
			invoicedQuantityType.setUnitCode(boletaDetalleQuery.getUnidadmedidaitem());
			invoicedQuantityType.setValue(documentUtil.round(boletaDetalleQuery.getCantidaditem()));

			ItemType itemType = new ItemType();
			DescriptionType descriptionType = new DescriptionType();
			descriptionType.setValue(boletaDetalleQuery.getDescripcionitem());
			itemType.getDescription().add(descriptionType);

			invoiceLineType.setInvoicedQuantity(invoicedQuantityType);
			invoiceLineType.setItem(itemType);

			{
				PriceType priceType = new PriceType();
				PriceAmountType priceAmountType = new PriceAmountType();
				priceAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				priceAmountType.setValue(documentUtil.round(boletaDetalleQuery.getValorunitarioitem()));
				priceType.setPriceAmount(priceAmountType);

				invoiceLineType.setPrice(priceType);
			}

			PricingReferenceType pricingReferenceType = new PricingReferenceType();
			{
				PriceType priceType = new PriceType();
				PriceAmountType priceAmountType = new PriceAmountType();
				priceAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				priceAmountType.setValue(documentUtil.round(boletaDetalleQuery.getPrecioventa()));
				priceType.setPriceAmount(priceAmountType);

				PriceTypeCodeType priceTypeCodeType = new PriceTypeCodeType();
				priceTypeCodeType.setValue(boletaDetalleQuery.getCodtipoprecioventa());

				priceType.setPriceTypeCode(priceTypeCodeType);

				pricingReferenceType.getAlternativeConditionPrice().add(priceType);

			}

			{
				PriceType priceType = new PriceType();
				PriceAmountType priceAmountType = new PriceAmountType();
				priceAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				priceAmountType.setValue(documentUtil.round(boletaDetalleQuery.getMontovalorrefunitario()));
				priceType.setPriceAmount(priceAmountType);

				PriceTypeCodeType priceTypeCodeType = new PriceTypeCodeType();
				priceTypeCodeType.setValue(boletaDetalleQuery.getCodtipoprecioref());

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
					taxAmountType.setValue(documentUtil.round(boletaDetalleQuery.getMontoigv()));
					taxTotalType.setTaxAmount(taxAmountType);
				}

				{
					TaxAmountType taxAmountType = new TaxAmountType();
					taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
					taxAmountType.setValue(documentUtil.round(boletaDetalleQuery.getMontoigv()));

					taxSubtotalType.setTaxAmount(taxAmountType);

					TaxCategoryType taxCategoryType = new TaxCategoryType();
					TaxSchemeType taxSchemeType = new TaxSchemeType();
					IDType idType = new IDType();
					idType.setValue(boletaDetalleQuery.getCodtributoigv());
					taxSchemeType.setID(idType);
					NameType nameType = new NameType();
					nameType.setValue(boletaDetalleQuery.getNombretributoigv());
					taxSchemeType.setName(nameType);
					TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
					taxTypeCodeType.setValue(boletaDetalleQuery.getCodtributointerigv());
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
					taxAmountType.setValue(documentUtil.round(boletaDetalleQuery.getMontoisc()));
					taxTotalType.setTaxAmount(taxAmountType);
				}

				{
					TaxAmountType taxAmountType = new TaxAmountType();
					taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
					taxAmountType.setValue(documentUtil.round(boletaDetalleQuery.getMontoisc()));

					taxSubtotalType.setTaxAmount(taxAmountType);

					TaxCategoryType taxCategoryType = new TaxCategoryType();
					TaxSchemeType taxSchemeType = new TaxSchemeType();
					IDType idType = new IDType();
					idType.setValue(boletaDetalleQuery.getCodtributoisc());
					taxSchemeType.setID(idType);
					NameType nameType = new NameType();
					nameType.setValue(boletaDetalleQuery.getNombretributoisc());
					taxSchemeType.setName(nameType);
					TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
					taxTypeCodeType.setValue(boletaDetalleQuery.getCodtributointerisc());
					taxSchemeType.setTaxTypeCode(taxTypeCodeType);

					taxCategoryType.setTaxScheme(taxSchemeType);
					taxSubtotalType.setTaxCategory(taxCategoryType);
				}
				taxTotalType.getTaxSubtotal().add(taxSubtotalType);
				invoiceLineType.getTaxTotal().add(taxTotalType);
			}

			LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
			lineExtensionAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			lineExtensionAmountType.setValue(documentUtil.round(boletaDetalleQuery.getValorventa()));

			invoiceLineType.setLineExtensionAmount(lineExtensionAmountType);

			{
				IDType idType = new IDType();
				idType.setValue(boletaDetalleQuery.getNumeroordenitem().toString());
				invoiceLineType.setID(idType);
			}

			{
				ItemType itemType2 = new ItemType();
				ItemIdentificationType itemIdentificationType = new ItemIdentificationType();
				{
					IDType idType = new IDType();
					idType.setValue(boletaDetalleQuery.getCodproducto());
					itemIdentificationType.setID(idType);
				}

				itemType2.setSellersItemIdentification(itemIdentificationType);
			}
			invoiceLineType.setItem(itemType);

			invoiceType.getInvoiceLine().add(invoiceLineType);
		}
	}

	public void setFechaEmsion(String fechaEmision, InvoiceType invoiceType) throws DatatypeConfigurationException, ParseException {
		
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaEmision);

		IssueDateType issueDateType = new IssueDateType();
		issueDateType.setValue(xmlGregorianCalendar);

		invoiceType.setIssueDate(issueDateType);
		
	}

	public void setInfoContribuyente(BoletaQuery documento, InvoiceType invoiceType) {

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

		supplierPartyType.setParty(partyType);

		CustomerAssignedAccountIDType customerAssignedAccountIDType = new CustomerAssignedAccountIDType();
		customerAssignedAccountIDType.setValue(documento.getNumeroruc());

		supplierPartyType.setCustomerAssignedAccountID(customerAssignedAccountIDType);
		AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
		additionalAccountIDType.setValue(documento.getTipodocumentoruc());
		supplierPartyType.getAdditionalAccountID().add(additionalAccountIDType);

		invoiceType.setAccountingSupplierParty(supplierPartyType);

	}

	public void setInfoUsuario(BoletaQuery documento, InvoiceType invoiceType) {

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

	public void setExtensiones(BoletaQuery boletaQuery, InvoiceType invoiceType) {

		UBLExtensionsType ublExtensionsType = new UBLExtensionsType();
		UBLExtensionType ublExtensionType = new UBLExtensionType();
		ExtensionContentType extensionContentType = new ExtensionContentType();

		AdditionalInformationType additionalInformationType = new AdditionalInformationType();
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getCodtipomontoopg());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(boletaQuery.getMontototalopg()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getCodtipomontoopi());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(boletaQuery.getMontototalopi()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getCodtipomontoopex());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(boletaQuery.getMontototalopex()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}
		// Total Descuentos
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getCodtipomontototaldscto());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(boletaQuery.getMontototaldscto()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
		}

		// Leyenda
		{
			{
				AdditionalPropertyType additionalPropertyType = new AdditionalPropertyType();
				IDType idType = new IDType();
				idType.setValue(boletaQuery.getCodigoleyendamoneda());
				additionalPropertyType.setID(idType);
				ValueType valueType = new ValueType();
				valueType.setValue(boletaQuery.getDescripcionleyendamoneda());
				additionalPropertyType.setValue(valueType);
				additionalInformationType.getAdditionalProperty().add(additionalPropertyType);
			}
			{
				AdditionalPropertyType additionalPropertyType = new AdditionalPropertyType();
				IDType idType = new IDType();
				idType.setValue(boletaQuery.getCodigoleyendapercepcion());
				additionalPropertyType.setID(idType);
				ValueType valueType = new ValueType();
				valueType.setValue(boletaQuery.getDescripcionleyendapercepcion());
				additionalPropertyType.setValue(valueType);
				additionalInformationType.getAdditionalProperty().add(additionalPropertyType);
			}
			
		}
		
		// Percepcion
		{
			AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
			IDType idType = new IDType();
			idType.setValue(boletaQuery.getCodtipomontopercepcion());
			additionalMonetaryTotalType.setID(idType);
			PayableAmountType payableAmountType = new PayableAmountType();
			payableAmountType.setCurrencyID(MONEDA_DOCUMENTO);
			payableAmountType.setValue(documentUtil.round(boletaQuery.getMontopercepcion()));

			additionalMonetaryTotalType.setPayableAmount(payableAmountType);
			AmountType amountType = new AmountType();
			amountType.setCurrencyID(MONEDA_DOCUMENTO);
			amountType.setValue(documentUtil.round(boletaQuery.getMontototalpercepcion()));
			additionalMonetaryTotalType.setTotalAmount(amountType);
			additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);

		}

		extensionContentType.setAdditionalInformation(additionalInformationType);
		ublExtensionType.setExtensionContent(extensionContentType);
		ublExtensionsType.getUBLExtension().add(ublExtensionType);
		invoiceType.setUBLExtensions(ublExtensionsType);
	}

	public void setSumatorias(BoletaQuery boletaQuery, InvoiceType invoiceType) {
		// IGV
		{
			TaxTotalType taxTotalType = new TaxTotalType();
			TaxSubtotalType taxSubtotalType = new TaxSubtotalType();

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(boletaQuery.getSumigv()));
				taxTotalType.setTaxAmount(taxAmountType);
			}

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(boletaQuery.getSumigv()));

				taxSubtotalType.setTaxAmount(taxAmountType);

				TaxCategoryType taxCategoryType = new TaxCategoryType();
				TaxSchemeType taxSchemeType = new TaxSchemeType();
				IDType idType = new IDType();
				idType.setValue(boletaQuery.getCodtributoigv());
				taxSchemeType.setID(idType);
				NameType nameType = new NameType();
				nameType.setValue(boletaQuery.getNombretributoigv());
				taxSchemeType.setName(nameType);
				TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
				taxTypeCodeType.setValue(boletaQuery.getCodtributointerigv());
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
				taxAmountType.setValue(documentUtil.round(boletaQuery.getSumisc()));
				taxTotalType.setTaxAmount(taxAmountType);
			}

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(boletaQuery.getSumisc()));

				taxSubtotalType.setTaxAmount(taxAmountType);

				TaxCategoryType taxCategoryType = new TaxCategoryType();
				TaxSchemeType taxSchemeType = new TaxSchemeType();
				IDType idType = new IDType();
				idType.setValue(boletaQuery.getCodtributoisc());
				taxSchemeType.setID(idType);
				NameType nameType = new NameType();
				nameType.setValue(boletaQuery.getNombretributoisc());
				taxSchemeType.setName(nameType);
				TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
				taxTypeCodeType.setValue(boletaQuery.getCodtributointerisc());
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
				taxAmountType.setValue(documentUtil.round(boletaQuery.getSumotrotributo()));
				taxTotalType.setTaxAmount(taxAmountType);
			}

			{
				TaxAmountType taxAmountType = new TaxAmountType();
				taxAmountType.setCurrencyID(MONEDA_DOCUMENTO);
				taxAmountType.setValue(documentUtil.round(boletaQuery.getSumotrotributo()));

				taxSubtotalType.setTaxAmount(taxAmountType);

				TaxCategoryType taxCategoryType = new TaxCategoryType();
				TaxSchemeType taxSchemeType = new TaxSchemeType();
				IDType idType = new IDType();
				idType.setValue(boletaQuery.getCodotrotributo());
				taxSchemeType.setID(idType);
				NameType nameType = new NameType();
				nameType.setValue(boletaQuery.getNombreotrotributo());
				taxSchemeType.setName(nameType);
				TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
				taxTypeCodeType.setValue(boletaQuery.getCodotrotributointer());
				taxSchemeType.setTaxTypeCode(taxTypeCodeType);

				taxCategoryType.setTaxScheme(taxSchemeType);
				taxSubtotalType.setTaxCategory(taxCategoryType);
			}
			taxTotalType.getTaxSubtotal().add(taxSubtotalType);
			invoiceType.getTaxTotal().add(taxTotalType);
		}
	}

	@Override
	public List<BoletaWebQuery> list(BoletaWebQueryCriteria criteria) throws Exception {
		List<BoletaWebQuery> list = this.selectByQuery(BoletaWebQueryMapper.class, criteria,criteria.getStart(),criteria.getLimit());
		return list;
	}

	@Override
	public int countRecords(BoletaWebQueryCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(BoletaWebQueryMapper.class, criteria);
		return count;
	}
	
}
