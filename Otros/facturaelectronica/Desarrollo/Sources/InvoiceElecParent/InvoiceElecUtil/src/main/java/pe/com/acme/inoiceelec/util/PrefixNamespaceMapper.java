package pe.com.acme.inoiceelec.util;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

@SuppressWarnings("restriction")
public class PrefixNamespaceMapper extends NamespacePrefixMapper {

	private static final String INVOICE_PREFIX = "";
	private static final String INVOICE_URI = "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2";
	
	private static final String COMMONAGGREGATECOMPONENTS_PREFIX = "cac";
	private static final String COMMONAGGREGATECOMPONENTS_URI = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";
	
	private static final String COMMONBASICCOMPONENTS_PREFIX = "cbc";
	private static final String COMMONBASICCOMPONENTS_URI = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";

	private static final String COMMONEXTENSIONCOMPONENTS_PREFIX = "ext";
	private static final String COMMONEXTENSIONCOMPONENTS_URI = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";
	
	private static final String QUALIFIEDDATATYPES_PREFIX = "qdt";
	private static final String QUALIFIEDDATATYPES_URI = "urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2";
	
	private static final String SUNATAGGREGATECOMPONENTS_PREFIX = "sac";
	private static final String SUNATAGGREGATECOMPONENTS_URI = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1";
	
	
	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
		
		if(INVOICE_URI.equals(namespaceUri)) {
            return INVOICE_PREFIX;
        } 
		
		if(COMMONAGGREGATECOMPONENTS_URI.equals(namespaceUri)) {
            return COMMONAGGREGATECOMPONENTS_PREFIX;
        }
		
		if(COMMONBASICCOMPONENTS_URI.equals(namespaceUri)) {
            return COMMONBASICCOMPONENTS_PREFIX;
        }
		
		if(COMMONEXTENSIONCOMPONENTS_URI.equals(namespaceUri)) {
            return COMMONEXTENSIONCOMPONENTS_PREFIX;
        }
		
		if(QUALIFIEDDATATYPES_URI.equals(namespaceUri)) {
            return QUALIFIEDDATATYPES_PREFIX;
        }
		
		if(SUNATAGGREGATECOMPONENTS_URI.equals(namespaceUri)) {
            return SUNATAGGREGATECOMPONENTS_PREFIX;
        }
        return suggestion;
	}
	
	@Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] { INVOICE_URI,COMMONAGGREGATECOMPONENTS_URI, COMMONBASICCOMPONENTS_URI,COMMONEXTENSIONCOMPONENTS_URI,QUALIFIEDDATATYPES_URI,SUNATAGGREGATECOMPONENTS_URI };
    }
}
