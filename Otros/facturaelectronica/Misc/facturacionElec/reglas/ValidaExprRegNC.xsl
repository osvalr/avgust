<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:regexp="http://exslt.org/regular-expressions" xmlns:gemfunc="http://www.sunat.gob.pe/gem/functions" xmlns:func="http://exslt.org/functions" xmlns="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:ext="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2" xmlns:sac="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:dp="http://www.datapower.com/extensions" extension-element-prefixes="dp" exclude-result-prefixes="dp" version="1.0">
  <xsl:include href="local:///sistemagem/util/ThrowError.xsl" dp:ignore-multiple="yes"/>
  <xsl:key name="by-document-billing-reference" match="cac:BillingReference" use="concat(cac:InvoiceDocumentReference/cbc:DocumentTypeCode,' ', cac:InvoiceDocumentReference/cbc:ID)"/>
  <xsl:key name="by-document-despatch-reference" match="cac:DespatchDocumentReference" use="concat(cbc:DocumentTypeCode,' ', cbc:ID)"/>
  <xsl:key name="by-document-additional-reference" match="cac:AdditionalDocumentReference" use="concat(cbc:DocumentTypeCode,' ', cbc:ID)"/>
  <xsl:template match="/*">
    <xsl:variable name="existOperationNoOnerosa" select="count(cac:CreditNoteLine/cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount[text()&gt;0 and parent::node()/cbc:PriceTypeCode=02])&gt;0"/>
    <xsl:variable name="sacAdditionalInformation" select="ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation"/>
    <xsl:if test="count($sacAdditionalInformation)&gt;1">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'2427'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC  (codigo: 2427)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:choose>
      <xsl:when test="not(string(cac:AccountingSupplierParty/cbc:CustomerAssignedAccountID))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'1006'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 1006)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cac:AccountingSupplierParty/cbc:CustomerAssignedAccountID,&quot;^[0-9]{11}$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'1005'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 1005)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:if test="not(string(cac:AccountingSupplierParty/cbc:AdditionalAccountID))">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'1008'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC (codigo: 1008)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:if test="not(regexp:match(cac:AccountingSupplierParty/cbc:AdditionalAccountID,&quot;^[6]{1}$&quot;))">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'1007'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC (codigo: 1007)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:if test="count(cac:AccountingSupplierParty/cbc:AdditionalAccountID)&gt;1">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'2362'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC (codigo: 2362)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:choose>
      <xsl:when test="not(string(cbc:ID))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'1002'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 1002)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cbc:ID,&quot;^[F][A-Z0-9]{3}-[0-9]{1,8}&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'1001'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 1001)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="not(string(cbc:CustomizationID))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2073'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2073)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cbc:CustomizationID,&quot;^[0-9]{1,7}(\.[0-9]{1,2})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2072'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2072)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="not(string(cbc:UBLVersionID))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2075'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2075)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cbc:UBLVersionID,&quot;^[2]{1}(\.[0]{1})$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2074'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2074)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="not(string(cac:AccountingSupplierParty/cac:Party/cac:PartyLegalEntity/cbc:RegistrationName))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'1037'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 1037)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cac:AccountingSupplierParty/cac:Party/cac:PartyLegalEntity/cbc:RegistrationName,&quot;^(?!\s*$).{1,100}&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'1038'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 1038)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:for-each select="cac:CreditNoteLine">
      <xsl:if test="./cbc:LineExtensionAmount">
        <xsl:if test="not(regexp:match(./cbc:LineExtensionAmount,&quot;(-?[0-9]+){1,12}(\.[0-9]{1,2})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2370'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2370)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:if test="not(regexp:match(./cbc:ID,&quot;^[0-9]{1,3}?$&quot;))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2137'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2137)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="./cbc:CreditedQuantity/@unitCode">
        <xsl:if test="not(regexp:match(./cbc:CreditedQuantity/@unitCode,&quot;^[A-Z0-9]{1,3}?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2138'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2138)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:if test="./cbc:CreditedQuantity">
        <xsl:if test="not(regexp:match(./cbc:CreditedQuantity,&quot;^[0-9]{1,12}(\.[0-9]{1,10})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2139'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2139)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:if test="(count(./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode[text()='01'])&gt;1 or count(./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode[text()='02'])&gt;1)">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2409'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC  (codigo: 2409)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode">
        <xsl:if test="not(./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode=01 or ./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode=02)">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2410'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2410)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:if test="./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount">
        <xsl:if test="./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode=01 and not(regexp:match(./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,10})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2367'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2367)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:if test="./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount">
        <xsl:if test="./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode=02 and not(regexp:match(./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,10})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2408'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2408)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:if test="./cac:Price/cbc:PriceAmount">
        <xsl:if test="not(regexp:match(./cac:Price/cbc:PriceAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,10})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2369'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2369)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:for-each select="./cac:TaxTotal">
        <xsl:if test="./cbc:TaxAmount">
          <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000 and count(./cbc:TaxAmount)&gt;1">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2355'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2355)'"/>
            </xsl:message>
          </xsl:if>
          <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000 and count(./cbc:TaxAmount)&gt;1">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2356'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2356)'"/>
            </xsl:message>
          </xsl:if>
          <xsl:if test="./cbc:TaxAmount!=./cac:TaxSubtotal/cbc:TaxAmount">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2372'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2372)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cbc:TaxAmount">
          <xsl:if test="not(regexp:match(./cac:TaxSubtotal/cbc:TaxAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,2})?$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2368'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2368)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000">
          <xsl:choose>
            <xsl:when test="not(./cac:TaxSubtotal/cac:TaxCategory/cbc:TaxExemptionReasonCode)">
              <xsl:call-template name="throwError">
                <xsl:with-param name="codigo" select="'2371'"/>
              </xsl:call-template>
              <xsl:message terminate="yes" dp:priority="debug">
                <xsl:value-of select="'Error Expr Regular NC (codigo: 2371)'"/>
              </xsl:message>
            </xsl:when>
            <xsl:otherwise>
              <xsl:if test="not(./cac:TaxSubtotal/cac:TaxCategory/cbc:TaxExemptionReasonCode[text()=10 or text()=11 or text()=12 or text()=13 or text()=14 or                    text()=15 or text()=16 or text()=20 or                    text()=30 or text()=31 or text()=32 or text()=33 or text()=34 or                    text()=35 or text()=36 or text()=40 or text()=21])">
                <xsl:call-template name="throwError">
                  <xsl:with-param name="codigo" select="'2145'"/>
                </xsl:call-template>
                <xsl:message terminate="yes" dp:priority="debug">
                  <xsl:value-of select="'Error Expr Regular NC (codigo: 2145)'"/>
                </xsl:message>
              </xsl:if>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000">
          <xsl:choose>
            <xsl:when test="./cbc:TaxAmount&gt;0 and not(string(./cac:TaxSubtotal/cac:TaxCategory/cbc:TierRange))">
              <xsl:call-template name="throwError">
                <xsl:with-param name="codigo" select="'2373'"/>
              </xsl:call-template>
              <xsl:message terminate="yes" dp:priority="debug">
                <xsl:value-of select="'Error Expr Regular NC (codigo: 2373)'"/>
              </xsl:message>
            </xsl:when>
            <xsl:otherwise>
              <xsl:if test="not(./cac:TaxSubtotal/cac:TaxCategory/cbc:TierRange=01 or ./cac:TaxSubtotal/cac:TaxCategory/cbc:TierRange=02 or ./cac:TaxSubtotal/cac:TaxCategory/cbc:TierRange=03)">
                <xsl:call-template name="throwError">
                  <xsl:with-param name="codigo" select="'2147'"/>
                </xsl:call-template>
                <xsl:message terminate="yes" dp:priority="debug">
                  <xsl:value-of select="'Error Expr Regular NC (codigo: 2147)'"/>
                </xsl:message>
              </xsl:if>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID">
          <xsl:if test="not(regexp:match(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID,&quot;^[0-9]{4}$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2141'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2141)'"/>
            </xsl:message>
          </xsl:if>
          <xsl:if test="not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000 or ./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000)">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2142'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2142)'"/>
            </xsl:message>
          </xsl:if>
          <xsl:choose>
            <xsl:when test="not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name)">
              <xsl:call-template name="throwError">
                <xsl:with-param name="codigo" select="'2143'"/>
              </xsl:call-template>
              <xsl:message terminate="yes" dp:priority="debug">
                <xsl:value-of select="'Error Expr Regular NC (codigo: 2143)'"/>
              </xsl:message>
            </xsl:when>
            <xsl:otherwise>
              <xsl:if test="not(regexp:match(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name,&quot;^[A-Z]{1,6}?$&quot;))">
                <xsl:call-template name="throwError">
                  <xsl:with-param name="codigo" select="'2143'"/>
                </xsl:call-template>
                <xsl:message terminate="yes" dp:priority="debug">
                  <xsl:value-of select="'Error Expr Regular NC (codigo: 2143)'"/>
                </xsl:message>
              </xsl:if>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode ">
          <xsl:if test="not(regexp:match(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode,&quot;^[A-Z]{3}$|^$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2144'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2144)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:if>
      </xsl:for-each>
      <xsl:if test="count(./cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount[text()&gt;0 and parent::node()/cbc:PriceTypeCode=02])&gt;0 and ./cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cbc:TaxExemptionReasonCode[text() = '10' or text() = '20' or text() = '30']">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2425'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular Factura (codigo: 2425)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:for-each>
    <xsl:for-each select="cac:TaxTotal">
      <xsl:choose>
        <xsl:when test="not(./cbc:TaxAmount)">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2155'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2155)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="./cbc:TaxAmount and not(regexp:match(./cbc:TaxAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,2})?$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2154'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2154)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID">
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000">
          <xsl:if test="count(./cbc:TaxAmount)&gt;1">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2352'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2352)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000">
          <xsl:if test="count(./cbc:TaxAmount)&gt;1">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2353'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2353)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=9999">
          <xsl:if test="count(./cbc:TaxAmount)&gt;1">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2354'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2354)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:if>
      </xsl:if>
      <xsl:if test="./cac:TaxSubtotal/cbc:TaxAmount">
        <xsl:if test="./cbc:TaxAmount!=./cac:TaxSubtotal/cbc:TaxAmount">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2061'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2061)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:choose>
        <xsl:when test="not(string(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2158'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2158)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="not(regexp:match(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID,&quot;^[0-9]{4}$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2156'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2156)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID">
        <xsl:if test="not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000 or ./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000 or ./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=9999)">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2157'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2157)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:choose>
        <xsl:when test="not(string(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2160'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2160)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="not(regexp:match(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name,&quot;^[A-Z]{1,6}?$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2159'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2159)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000 and not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name='IGV')">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2057'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2057)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000 and not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name='ISC')">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2058'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2058)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode and not(gemfunc:is-blank(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode))">
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=1000 and not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode='VAT')">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2057'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2057)'"/>
          </xsl:message>
        </xsl:if>
        <xsl:if test="./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID=2000 and not(./cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode='EXC')">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2058'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2058)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
    </xsl:for-each>
    <xsl:if test="cac:LegalMonetaryTotal/cbc:ChargeTotalAmount">
      <xsl:if test="not(regexp:match(cac:LegalMonetaryTotal/cbc:ChargeTotalAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,2})?$&quot;))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2064'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2064)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:if>
    <xsl:for-each select="ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal">
      <xsl:if test="./cbc:PayableAmount">
        <xsl:if test="not(regexp:match(./cbc:PayableAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,2})?$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2149'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2149)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:if>
      <xsl:choose>
        <xsl:when test="not(string(./cbc:ID))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2151'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2151)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:variable name="allowID" select="./cbc:ID[text()='1001' or text()='1002' or text()='1003' or text()='1004' or text()='2001' or text()='2005']"/>
          <xsl:if test="not(regexp:match(./cbc:ID,'^[0-9]{4}$')) or not($allowID) or (not($existOperationNoOnerosa) and ./cbc:ID[text()='1004'])">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2150'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2150)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:if test="(./cbc:ID=1001 and count(./cbc:ID)&gt;1)">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2349'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2349)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="(./cbc:ID=1002 and count(./cbc:ID)&gt;1)">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2350'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2350)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="(./cbc:ID=1003 and count(./cbc:ID)&gt;1)">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2351'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2351)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="(./cbc:ID=1001 and count(./cbc:ID)&gt;1) or (./cbc:ID=1002 and count(./cbc:ID)&gt;1) or (./cbc:ID=1003 and count(./cbc:ID)&gt;1) or (./cbc:ID=2005 and count(./cbc:ID)&gt;1)">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2406'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2406)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:for-each>
    <xsl:if test="cac:LegalMonetaryTotal/cbc:PayableAmount">
      <xsl:choose>
        <xsl:when test="not(string(cac:LegalMonetaryTotal/cbc:PayableAmount))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2122'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2122)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="not(regexp:match(cac:LegalMonetaryTotal/cbc:PayableAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,2})?$&quot;))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2062'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2062)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:if>
    <xsl:if test="cac:LegalMonetaryTotal/cbc:PrepaidAmount">
      <xsl:choose>
        <xsl:when test="cac:LegalMonetaryTotal/cbc:PrepaidAmount and not(cac:LegalMonetaryTotal/cbc:PrepaidAmount/@currencyID)">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'0306'"/>
          </xsl:call-template>
          <xsl:message terminate="no" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 0306)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:when test="not(string(cac:LegalMonetaryTotal/cbc:PrepaidAmount != ''))">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'0306'"/>
          </xsl:call-template>
          <xsl:message terminate="no" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 0306)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:when test="not(regexp:match(cac:LegalMonetaryTotal/cbc:PrepaidAmount,&quot;^[0-9]{1,12}(\.[0-9]{1,2})?$&quot;))">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'0306'"/>
          </xsl:call-template>
          <xsl:message terminate="no" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 0306)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="cac:LegalMonetaryTotal/cbc:PrepaidAmount &lt;= 0">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'2527'"/>
            </xsl:call-template>
            <xsl:message terminate="no" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 2527)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:if>
    <xsl:variable name="tipoDocumentoModifica" select="string(substring(cbc:ID, 1, 1))"/>
    <xsl:variable name="abc" select="cac:DiscrepancyResponse/cbc:ResponseCode"/>
    <xsl:for-each select="cac:BillingReference/cac:InvoiceDocumentReference">
      <xsl:if test="$tipoDocumentoModifica ='F' and not(./cbc:DocumentTypeCode[text() = '01' or text() = '12' or text() = '56'])">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2116'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular ND (codigo: 2116)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:if test="$tipoDocumentoModifica ='B' and not(./cbc:DocumentTypeCode[text() = '03'])">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2399'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular ND (codigo: 2399)'"/>
        </xsl:message>
      </xsl:if>
      <xsl:choose>
        <xsl:when test="$abc[text()='10']">
          <xsl:if test="not(./cbc:ID = '') and ./cbc:DocumentTypeCode[text() = '01'] and  not(regexp:match(./cbc:ID,'^[F][A-Z0-9]{3}-[0-9]{1,8}?$|^(E001)-[0-9]{1,8}?$|^[B][A-Z0-9]{3}-[0-9]{1,8}?$|^[0-9]{1,4}-[0-9]{1,8}?$') )">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'2630'"/>
            </xsl:call-template>
            <xsl:message terminate="no" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2630)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="./cbc:DocumentTypeCode[text() = '01'] and not(regexp:match(./cbc:ID,'^[F][A-Z0-9]{3}-[0-9]{1,8}?$|^(E001)-[0-9]{1,8}?$|^[B][A-Z0-9]{3}-[0-9]{1,8}?$|^[0-9]{1,4}-[0-9]{1,8}?$') ) ">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2117'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2117)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:choose>
        <xsl:when test="$abc[text()='10']">
          <xsl:if test="not(./cbc:ID = '') and ./cbc:DocumentTypeCode[text() = '12'] and  not(regexp:match(./cbc:ID,'^[a-zA-Z0-9-]{1,20}-[0-9]{1,10}?$') )">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'2631'"/>
            </xsl:call-template>
            <xsl:message terminate="no" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2631)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="./cbc:DocumentTypeCode[text() = '12'] and not(regexp:match(./cbc:ID,'^[a-zA-Z0-9-]{1,20}-[0-9]{1,10}?$') ) ">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2117'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2117)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:choose>
        <xsl:when test="$abc[text()='10']">
          <xsl:if test="not(./cbc:ID = '') and ./cbc:DocumentTypeCode[text() = '56'] and  not(regexp:match(./cbc:ID,'^[\s]*$') )">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'2632'"/>
            </xsl:call-template>
            <xsl:message terminate="no" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2632)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="./cbc:DocumentTypeCode[text() = '56'] and not(regexp:match(./cbc:ID,'^[\s]*$') ) ">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2117'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2117)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:choose>
        <xsl:when test="$abc[text()='10']">
          <xsl:if test="not(./cbc:ID = '') and ./cbc:DocumentTypeCode[text() = '03'] and  not(regexp:match(./cbc:ID,'^[B][A-Z0-9]{3}-[0-9]{1,8}?$|^[0-9]{1,4}-[0-9]{1,8}?$') )">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'2633'"/>
            </xsl:call-template>
            <xsl:message terminate="no" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2633)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="./cbc:DocumentTypeCode[text() = '03'] and not(regexp:match(./cbc:ID,'^[B][A-Z0-9]{3}-[0-9]{1,8}?$|^[0-9]{1,4}-[0-9]{1,8}?$') ) ">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'2117'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular ND (codigo: 2117)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:if test="count(./cbc:ID)=0">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2118'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular ND (codigo: 2118)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:for-each>
    <xsl:choose>
      <xsl:when test="not(string(cac:DiscrepancyResponse))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2414'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2414)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="count(cac:DiscrepancyResponse)&gt;1">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2415'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2415)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="cac:DiscrepancyResponse/cbc:ResponseCode[text()='10']">
        <xsl:if test="not(cac:DiscrepancyResponse/cbc:ReferenceID = '') and not(regexp:match(cac:DiscrepancyResponse/cbc:ReferenceID,'^[F][A-Z0-9]{3}-[0-9]{1,8}?$|^(E001)-[0-9]{1,8}?$|^[B][A-Z0-9]{3}-[0-9]{1,8}?$|^[0-9]{1,4}-[0-9]{1,8}?$|^--[0-9]{1,8}$'))">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'2634'"/>
          </xsl:call-template>
          <xsl:message terminate="no" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2634)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(cac:DiscrepancyResponse/cbc:ResponseCode[text()='10']) and not(string(cac:DiscrepancyResponse/cbc:ReferenceID))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2126'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2126)'"/>
          </xsl:message>
        </xsl:if>
        <xsl:if test="not(regexp:match(cac:DiscrepancyResponse/cbc:ReferenceID,&quot;^[F][A-Z0-9]{3}-[0-9]{1,8}?$|^(E001)-[0-9]{1,8}?$|^[B][A-Z0-9]{3}-[0-9]{1,8}?$|^[0-9]{1,4}-[0-9]{1,8}?$|^--[0-9]{1,8}$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2125'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2125)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="not(string(cac:DiscrepancyResponse/cbc:ResponseCode))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2128'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2128)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cac:DiscrepancyResponse/cbc:ResponseCode,&quot;^[0-9]{2}$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2127'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2127)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="not(string(cac:DiscrepancyResponse/cbc:Description))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2136'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2136)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cac:DiscrepancyResponse/cbc:Description,&quot;^(?!\s*$).{1,250}&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2135'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2135)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:if test="cac:DespatchDocumentReference/cbc:DocumentTypeCode">
      <xsl:choose>
        <xsl:when test="not(regexp:match(cac:DespatchDocumentReference/cbc:DocumentTypeCode,&quot;^[0-9]{2}$&quot;))">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'4004'"/>
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="not((cac:DespatchDocumentReference/cbc:DocumentTypeCode=09) or (cac:DespatchDocumentReference/cbc:DocumentTypeCode=31))">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'4005'"/>
            </xsl:call-template>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:if>
    <xsl:if test="cac:DespatchDocumentReference/cbc:ID">
      <xsl:choose>
        <xsl:when test="not(cac:DespatchDocumentReference/cbc:ID)">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'4007'"/>
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="not(regexp:match(cac:DespatchDocumentReference/cbc:ID,&quot;^(.){1,4}-[0-9]{1,}$&quot;))">
            <xsl:call-template name="addWarning">
              <xsl:with-param name="codigo" select="'4006'"/>
            </xsl:call-template>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:if>
    <xsl:choose>
      <xsl:when test="cac:DiscrepancyResponse/cbc:ResponseCode[text()='10']">
        <xsl:if test="not(cac:AdditionalDocumentReference/cbc:DocumentTypeCode=99) or (not(count(cac:AdditionalDocumentReference/cbc:DocumentTypeCode)&gt;1))">
          <xsl:call-template name="addWarning">
            <xsl:with-param name="codigo" select="'2635'"/>
          </xsl:call-template>
          <xsl:message terminate="no" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2635)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:when>
      <xsl:otherwise/>
    </xsl:choose>
    <xsl:if test="cac:DiscrepancyResponse/cbc:ResponseCode[text()='10'] and cac:AdditionalDocumentReference/cbc:DocumentTypeCode=99">
      <xsl:if test="cac:AdditionalDocumentReference/cbc:ID =''">
        <xsl:call-template name="addWarning">
          <xsl:with-param name="codigo" select="'2636'"/>
        </xsl:call-template>
        <xsl:message terminate="no" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2636)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:if>
    <xsl:if test="cac:DiscrepancyResponse/cbc:ResponseCode[text()='10'] and cac:AdditionalDocumentReference/cbc:DocumentTypeCode=99">
      <xsl:if test="cac:AdditionalDocumentReference/cbc:DocumentType =''">
        <xsl:call-template name="addWarning">
          <xsl:with-param name="codigo" select="'2637'"/>
        </xsl:call-template>
        <xsl:message terminate="no" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2637)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:if>
    <xsl:for-each select="cac:AdditionalDocumentReference">
      <xsl:choose>
        <xsl:when test="(./DocumentTypeCode ='') or (not(regexp:match(./cbc:DocumentTypeCode,'^[0-9]{2}$')))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'4008'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 4008)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="not((./cbc:DocumentTypeCode=04) or (./cbc:DocumentTypeCode=05) or (./cbc:DocumentTypeCode=99) or (./cbc:DocumentTypeCode=01))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'4009'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 4009)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:for-each>
    <xsl:for-each select="cac:AdditionalDocumentReference">
      <xsl:choose>
        <xsl:when test="not(./cbc:ID)">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'4011'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 4011)'"/>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="(./cbc:ID='') or (not(regexp:match(./cbc:ID,'^[0-9]{6}$')))">
            <xsl:call-template name="throwError">
              <xsl:with-param name="codigo" select="'4010'"/>
            </xsl:call-template>
            <xsl:message terminate="yes" dp:priority="debug">
              <xsl:value-of select="'Error Expr Regular NC (codigo: 4010)'"/>
            </xsl:message>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:for-each>
    <xsl:choose>
      <xsl:when test="not(string(cbc:DocumentCurrencyCode))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2070'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2070)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cbc:DocumentCurrencyCode,&quot;^[A-Z0-9]{3}$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2069'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2069)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:if test="(cbc:DocumentCurrencyCode!=cac:LegalMonetaryTotal/cbc:PayableAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:TaxTotal/cbc:TaxAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:TaxTotal/cac:TaxSubtotal/cbc:TaxAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:LegalMonetaryTotal/cbc:ChargeTotalAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:CreditNoteLine/cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:CreditNoteLine/cac:Price/cbc:PriceAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:CreditNoteLine/cbc:LineExtensionAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:CreditNoteLine/cac:TaxTotal/cbc:TaxAmount/@currencyID) or (cbc:DocumentCurrencyCode!=cac:CreditNoteLine/cac:TaxTotal/cac:TaxSubtotal/cbc:TaxAmount/@currencyID)">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'2071'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC (codigo: 2071)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:if test="(cbc:DocumentCurrencyCode!=ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/@currencyID)">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'2071'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC (codigo: 2071)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:choose>
      <xsl:when test="not(string(cac:AccountingCustomerParty/cbc:CustomerAssignedAccountID))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2014'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2014)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="cac:AccountingCustomerParty/cbc:AdditionalAccountID[text()='6'] and not(regexp:match(cac:AccountingCustomerParty/cbc:CustomerAssignedAccountID,'^[0-9]{11}$|^[-]{1}$'))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2017'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2017)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:if test="count(cac:AccountingCustomerParty/cbc:AdditionalAccountID)&gt;1">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'2363'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular Nc (codigo: 2363)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:if test="not(string(cac:AccountingCustomerParty/cbc:AdditionalAccountID))">
      <xsl:call-template name="throwError">
        <xsl:with-param name="codigo" select="'2015'"/>
      </xsl:call-template>
      <xsl:message terminate="yes" dp:priority="debug">
        <xsl:value-of select="'Error Expr Regular NC (codigo: 2015)'"/>
      </xsl:message>
    </xsl:if>
    <xsl:choose>
      <xsl:when test="cac:CreditNoteLine/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cbc:TaxExemptionReasonCode[text()='40']">
        <xsl:if test="not(regexp:match(cac:AccountingCustomerParty/cbc:AdditionalAccountID,&quot;^[01467A\-]{1}$&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2016'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2016)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(cac:AccountingCustomerParty/cbc:AdditionalAccountID[text()=6])">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2016'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2016)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="not(string(cac:AccountingCustomerParty/cac:Party/cac:PartyLegalEntity/cbc:RegistrationName))">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2021'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC (codigo: 2021)'"/>
        </xsl:message>
      </xsl:when>
      <xsl:otherwise>
        <xsl:if test="not(regexp:match(cac:AccountingCustomerParty/cac:Party/cac:PartyLegalEntity/cbc:RegistrationName/text(),&quot;^(?!\s*$).{1,100}&quot;))">
          <xsl:call-template name="throwError">
            <xsl:with-param name="codigo" select="'2022'"/>
          </xsl:call-template>
          <xsl:message terminate="yes" dp:priority="debug">
            <xsl:value-of select="'Error Expr Regular NC (codigo: 2022)'"/>
          </xsl:message>
        </xsl:if>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:for-each select="cac:BillingReference">
      <xsl:if test="count(key('by-document-billing-reference', concat(cac:InvoiceDocumentReference/cbc:DocumentTypeCode,' ', cac:InvoiceDocumentReference/cbc:ID))) &gt; 1">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2365'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC  (codigo: 2365)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:for-each>
    <xsl:for-each select="cac:DespatchDocumentReference">
      <xsl:if test="count(key('by-document-despatch-reference', concat(cbc:DocumentTypeCode,' ', cbc:ID))) &gt; 1">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2364'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC  (codigo: 2364)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:for-each>
    <xsl:for-each select="cac:AdditionalDocumentReference">
      <xsl:if test="count(key('by-document-additional-reference', concat(cbc:DocumentTypeCode,' ', cbc:ID))) &gt; 1">
        <xsl:call-template name="throwError">
          <xsl:with-param name="codigo" select="'2426'"/>
        </xsl:call-template>
        <xsl:message terminate="yes" dp:priority="debug">
          <xsl:value-of select="'Error Expr Regular NC  (codigo: 2426)'"/>
        </xsl:message>
      </xsl:if>
    </xsl:for-each>
    <xsl:copy-of select="."/>
  </xsl:template>
  <func:function name="gemfunc:is-blank">
    <xsl:param name="data" select="''"/>
    <func:result select="regexp:match($data,'^[\s]*$')"/>
  </func:function>
</xsl:stylesheet>
