<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:regexp="http://exslt.org/regular-expressions" xmlns:gemfunc="http://www.sunat.gob.pe/gem/functions" xmlns:func="http://exslt.org/functions" xmlns="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:ext="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2" xmlns:sac="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:dp="http://www.datapower.com/extensions" extension-element-prefixes="dp" exclude-result-prefixes="dp" version="1.0">
  <xsl:include href="local:///commons/error/error_utils.xsl" dp:ignore-multiple="yes"/>
  <xsl:template match="/*">
    <xsl:variable name="cbcUBLVersionID" select="cbc:UBLVersionID"/>
    <xsl:variable name="cbcCustomizationID" select="cbc:CustomizationID"/>
    <xsl:variable name="cbcID" select="cbc:ID"/>
    <xsl:variable name="cbcDespatchAdviceTypeCode" select="cbc:DespatchAdviceTypeCode"/>
    <xsl:variable name="cacOrderReference" select="cac:OrderReference"/>
    <xsl:variable name="cacAdditionalDocumentReference" select="cac:AdditionalDocumentReference"/>
    <xsl:variable name="cbcDespatchSupplierAccountID" select="cac:DespatchSupplierParty/cbc:CustomerAssignedAccountID"/>
    <xsl:variable name="cbcDespatchSupplierName" select="cac:DespatchSupplierParty/cac:Party/cac:PartyLegalEntity/cbc:RegistrationName"/>
    <xsl:variable name="cbcDespatchSupplierAddressID" select="cac:DespatchSupplierParty/cac:Party/cac:PostalAddress/cbc:ID"/>
    <xsl:variable name="cbcDespatchSupplierAddressStreetName" select="cac:DespatchSupplierParty/cac:Party/cac:PostalAddress/cbc:StreetName"/>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'2111'"/>
      <xsl:with-param name="errorCodeValidate" select="'2110'"/>
      <xsl:with-param name="node" select="$cbcUBLVersionID"/>
      <xsl:with-param name="regexp" select="'^(2.1)$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'2113'"/>
      <xsl:with-param name="errorCodeValidate" select="'2112'"/>
      <xsl:with-param name="node" select="$cbcCustomizationID"/>
      <xsl:with-param name="regexp" select="'^(1.0)$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'1002'"/>
      <xsl:with-param name="errorCodeValidate" select="'1001'"/>
      <xsl:with-param name="node" select="$cbcID"/>
      <xsl:with-param name="regexp" select="'^[T][A-Z0-9]{3}-[0-9]{1,8}?$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'1050'"/>
      <xsl:with-param name="errorCodeValidate" select="'1051'"/>
      <xsl:with-param name="node" select="$cbcDespatchAdviceTypeCode"/>
      <xsl:with-param name="regexp" select="'^(09)$'"/>
    </xsl:call-template>
    <xsl:if test="$cacOrderReference">
      <xsl:choose>
        <xsl:when test="count($cacOrderReference)&gt;1">
          <xsl:call-template name="rejectCall">
            <xsl:with-param name="errorCode" select="'9995'"/>
            <xsl:with-param name="errorMessage" select="'Error Expr Regular guia remision (codigo: 9995)'"/>
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
          <xsl:for-each select="$cacOrderReference">
            <xsl:call-template name="existAndRegexpValidateElement">
              <xsl:with-param name="errorCodeNotExist" select="'1055'"/>
              <xsl:with-param name="errorCodeValidate" select="'9991'"/>
              <xsl:with-param name="node" select="$cacOrderReference/cbc:ID"/>
              <xsl:with-param name="regexp" select="'^[T][A-Z0-9]{3}-[0-9]{1,8}$|^(EG01)-[0-9]{1,8}$'"/>
            </xsl:call-template>
            <xsl:call-template name="existAndRegexpValidateElement">
              <xsl:with-param name="errorCodeNotExist" select="'1057'"/>
              <xsl:with-param name="errorCodeValidate" select="'2536'"/>
              <xsl:with-param name="node" select="$cacOrderReference/cbc:OrderTypeCode"/>
              <xsl:with-param name="regexp" select="'^(09)$'"/>
            </xsl:call-template>
          </xsl:for-each>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:if>
    <xsl:if test="$cacAdditionalDocumentReference">
      <xsl:for-each select="$cacAdditionalDocumentReference">
        <xsl:call-template name="existAndRegexpValidateElement">
          <xsl:with-param name="errorCodeNotExist" select="'1053'"/>
          <xsl:with-param name="errorCodeValidate" select="'9992'"/>
          <xsl:with-param name="node" select="$cacAdditionalDocumentReference/cbc:ID"/>
          <xsl:with-param name="regexp" select="'^.{1,25}$'"/>
        </xsl:call-template>
        <xsl:call-template name="findElementInCatalog">
          <xsl:with-param name="errorCodeValidate" select="'2536'"/>
          <xsl:with-param name="node" select="$cacAdditionalDocumentReference/cbc:DocumentTypeCode"/>
          <xsl:with-param name="catalogo" select="'21'"/>
        </xsl:call-template>
      </xsl:for-each>
    </xsl:if>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'9993'"/>
      <xsl:with-param name="errorCodeValidate" select="'9994'"/>
      <xsl:with-param name="node" select="$cbcDespatchSupplierAccountID"/>
      <xsl:with-param name="regexp" select="'^[1-2][0-9]{10}$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'2538'"/>
      <xsl:with-param name="errorCodeValidate" select="'2539'"/>
      <xsl:with-param name="node" select="$cbcDespatchSupplierAccountID/@schemeID"/>
      <xsl:with-param name="regexp" select="'^(6)$|^(06)$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElement">
      <xsl:with-param name="errorCodeValidate" select="'4031'"/>
      <xsl:with-param name="node" select="$cbcDespatchSupplierName"/>
      <xsl:with-param name="regexp" select="'^(.{1,120})$'"/>
    </xsl:call-template>
    <xsl:copy-of select="."/>
  </xsl:template>
</xsl:stylesheet>
