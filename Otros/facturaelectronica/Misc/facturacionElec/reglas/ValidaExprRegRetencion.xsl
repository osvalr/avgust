<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:regexp="http://exslt.org/regular-expressions" xmlns:gemfunc="http://www.sunat.gob.pe/gem/functions" xmlns:func="http://exslt.org/functions" xmlns="urn:sunat:names:specification:ubl:peru:schema:xsd:Retention-1" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:ext="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2" xmlns:sac="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:dp="http://www.datapower.com/extensions" extension-element-prefixes="dp" exclude-result-prefixes="dp" version="1.0">
  <xsl:include href="local:///commons/error/error_utils.xsl" dp:ignore-multiple="yes"/>
  <xsl:template match="/*">
    <xsl:variable name="cbcUBLVersionID" select="cbc:UBLVersionID"/>
    <xsl:variable name="cbcCustomizationID" select="cbc:CustomizationID"/>
    <xsl:variable name="cbcID" select="cbc:ID"/>
    <xsl:variable name="cbcIssueDate" select="cbc:IssueDate"/>
    <xsl:variable name="cacAgentParty" select="cac:AgentParty"/>
    <xsl:variable name="cacAgentPartyIdentificationID" select="$cacAgentParty/cac:PartyIdentification/cbc:ID"/>
    <xsl:variable name="cacAgentPartyIdentificationSchemeID" select="$cacAgentParty/cac:PartyIdentification/cbc:ID/@schemeID"/>
    <xsl:variable name="cacAgentPartyNameName" select="$cacAgentParty/cac:PartyName/cbc:Name"/>
    <xsl:variable name="cacAgentPartyPostalAddressID" select="$cacAgentParty/cac:PostalAddress/cbc:ID"/>
    <xsl:variable name="cacAgentPartyPostalAddressStreetName" select="$cacAgentParty/cac:PostalAddress/cbc:StreetName"/>
    <xsl:variable name="cacAgentPartyPostalAddressCitySubdivisionName" select="$cacAgentParty/cac:PostalAddress/cbc:CitySubdivisionName"/>
    <xsl:variable name="cacAgentPartyPostalAddressCityName" select="$cacAgentParty/cac:PostalAddress/cbc:CityName"/>
    <xsl:variable name="cacAgentPartyPostalAddressCountrySubentity" select="$cacAgentParty/cac:PostalAddress/cbc:CountrySubentity"/>
    <xsl:variable name="cacAgentPartyPostalAddressDistrict" select="$cacAgentParty/cac:PostalAddress/cbc:District"/>
    <xsl:variable name="cacAgentPartyLegalEntityName" select="$cacAgentParty/cac:PartyLegalEntity/cbc:RegistrationName"/>
    <xsl:variable name="cacAgentPartyCountryCode" select="$cacAgentParty/cac:PostalAddress/cac:Country/cbc:IdentificationCode"/>
    <xsl:variable name="cacReceiverParty" select="cac:ReceiverParty"/>
    <xsl:variable name="cacReceiverPartyIdentificationID" select="$cacReceiverParty/cac:PartyIdentification/cbc:ID"/>
    <xsl:variable name="cacReceiverPartyIdentificationSchemeID" select="$cacReceiverParty/cac:PartyIdentification/cbc:ID/@schemeID"/>
    <xsl:variable name="cacReceiverPartyLegalEntityName" select="$cacReceiverParty/cac:PartyLegalEntity/cbc:RegistrationName"/>
    <xsl:variable name="cacReceiverPartyCountryCode" select="$cacReceiverParty/cac:PostalAddress/cac:Country/cbc:IdentificationCode"/>
    <xsl:variable name="sacSUNATRetentionSystemCode" select="sac:SUNATRetentionSystemCode"/>
    <xsl:variable name="sacSUNATRetentionPercent" select="sac:SUNATRetentionPercent"/>
    <xsl:variable name="cbcNote" select="cbc:Note"/>
    <xsl:variable name="cbcTotalInvoiceAmount" select="cbc:TotalInvoiceAmount"/>
    <xsl:variable name="cbcTotalInvoiceAmountCurrencyID" select="cbc:TotalInvoiceAmount/@currencyID"/>
    <xsl:variable name="sacSUNATTotalCashed" select="sac:SUNATTotalPaid"/>
    <xsl:variable name="sacSUNATTotalCashedCurrencyID" select="sac:SUNATTotalPaid/@currencyID"/>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'2111'"/>
      <xsl:with-param name="errorCodeValidate" select="'2110'"/>
      <xsl:with-param name="node" select="$cbcUBLVersionID"/>
      <xsl:with-param name="regexp" select="'^(2.0)$'"/>
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
      <xsl:with-param name="regexp" select="'^[R][A-Z0-9]{3}-[0-9]{1,8}?$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'1010'"/>
      <xsl:with-param name="errorCodeValidate" select="'1009'"/>
      <xsl:with-param name="node" select="$cbcIssueDate"/>
      <xsl:with-param name="regexp" select="'^[0-9]{4}-[0-9]{2}-[0-9]{2}?$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'2630'"/>
      <xsl:with-param name="errorCodeValidate" select="'2631'"/>
      <xsl:with-param name="node" select="$cacAgentPartyIdentificationID"/>
      <xsl:with-param name="regexp" select="'^[0-9]{11}$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'2632'"/>
      <xsl:with-param name="errorCodeValidate" select="'2511'"/>
      <xsl:with-param name="node" select="$cacAgentPartyIdentificationSchemeID"/>
      <xsl:with-param name="regexp" select="'^(6)$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4094'"/>
      <xsl:with-param name="node" select="$cacAgentPartyNameName"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(.{1,100})$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4092'"/>
      <xsl:with-param name="node" select="$cacAgentPartyPostalAddressID"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'(?!^(00))^\d{2}(?!(00))\d{4}$(?&lt;!(00)$)'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4093'"/>
      <xsl:with-param name="node" select="$cacAgentPartyPostalAddressStreetName"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(.{1,100})$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4095'"/>
      <xsl:with-param name="node" select="$cacAgentPartyPostalAddressCitySubdivisionName"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(.{1,30})$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4096'"/>
      <xsl:with-param name="node" select="$cacAgentPartyPostalAddressCityName"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(.{1,30})$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4097'"/>
      <xsl:with-param name="node" select="$cacAgentPartyPostalAddressCountrySubentity"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(.{1,30})$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4098'"/>
      <xsl:with-param name="node" select="$cacAgentPartyPostalAddressDistrict"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(.{1,30})$'"/>
    </xsl:call-template>
    <xsl:call-template name="regexpValidateElementIfExist">
      <xsl:with-param name="errorCodeValidate" select="'4041'"/>
      <xsl:with-param name="node" select="$cacAgentPartyCountryCode"/>
      <xsl:with-param name="isError" select="false()"/>
      <xsl:with-param name="regexp" select="'^(PE)$'"/>
    </xsl:call-template>
    <xsl:call-template name="existAndRegexpValidateElement">
      <xsl:with-param name="errorCodeNotExist" select="'1037'"/>
      <xsl:with-param name="errorCodeValidate" select="'1038'"/>
      <xsl:with-param name="node" select="$cacAgentPartyLegalEntityName"/>
      <xsl:with-param name="regexp" select="'^(.{1,100})$'"/>
    </xsl:call-template>
    <xsl:copy-of select="."/>
  </xsl:template>
</xsl:stylesheet>
