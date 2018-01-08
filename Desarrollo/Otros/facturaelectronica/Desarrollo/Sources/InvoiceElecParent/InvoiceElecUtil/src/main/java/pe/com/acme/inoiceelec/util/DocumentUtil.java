package pe.com.acme.inoiceelec.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory;

@Component
public class DocumentUtil {
	
	@Value("${keystore.type}")
	private String KEYSTORE_TYPE;
	@Value("${keystore.file}")
	private String KEYSTORE_FILE;
	@Value("${keystore.password}")
	private String KEYSTORE_PASSWORD;
	@Value("${private.key.password}")
	private String PRIVATE_KEY_PASSWORD;
	@Value("${private.key.alias}")
	private String PRIVATE_KEY_ALIAS;
	@Value("${path.doc.temp}")
	private String path_doc_temp;
	@Value("${path.docsign.temp}")
	private String path_docsign_temp;
	@Value("${path.doczip.temp}")
	private String path_doczip_temp;
	private Marshaller marshaller;
		
	@SuppressWarnings("deprecation")
	public String sign(String pathXml, String nameXml) throws Exception{
		org.apache.xml.security.Init.init();

		Document doc = DocumentUtil.loadDocumentFromFile(pathXml);
		
		String fileNameXmlSign = path_docsign_temp + "/" + nameXml +".xml";
		this.createFolder(path_docsign_temp);

		Constants.setSignatureSpecNSprefix("ds"); 

		// Cargamos el almacen de claves
		KeyStore ks = KeyStore.getInstance(KEYSTORE_TYPE);
		ks.load(new FileInputStream(KEYSTORE_FILE), KEYSTORE_PASSWORD.toCharArray());

		// Obtenemos la clave privada, pues la necesitaremos para encriptar.
		PrivateKey privateKey = (PrivateKey) ks.getKey(PRIVATE_KEY_ALIAS, PRIVATE_KEY_PASSWORD.toCharArray());
		File signatureFile = new File(fileNameXmlSign);
		String baseURI = signatureFile.toURL().toString(); // BaseURI para las URL Relativas.

		// Instanciamos un objeto XMLSignature desde el Document. El algoritmo
		// de firma será RSA
		XMLSignature xmlSignature = new XMLSignature(doc, baseURI, XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1);

		// Añadimos el nodo de la firma a la raiz antes de firmar.
		// Observe que ambos elementos pueden ser mezclados en una forma con
		// referencias separadas
		
		doc.setXmlStandalone(false);
		doc.getDocumentElement().setAttributeNS(Constants.NamespaceSpecNS, "xmlns:ds", "http://www.w3.org/2000/09/xmldsig#");
		
		Node UBLExtensions = doc.getElementsByTagNameNS("*", "UBLExtensions").item(0);
		Element UBLExtension = doc.createElement("ext:UBLExtension");
		Element ExtensionContent = doc.createElement("ext:ExtensionContent");
		UBLExtension.appendChild(ExtensionContent);
		ExtensionContent.appendChild(xmlSignature.getElement());
		
		UBLExtensions.appendChild(UBLExtension);
		
		// Creamos el objeto que mapea: Document/Reference
		Transforms transforms = new Transforms(doc);
		transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);

		// Añadimos lo anterior Documento / Referencia
		// ALGO_ID_DIGEST_SHA1 = "http://www.w3.org/2000/09/xmldsig#sha1";
		xmlSignature.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1);

		// Añadimos el KeyInfo del certificado cuya clave privada usamos
		X509Certificate cert = (X509Certificate) ks.getCertificate(PRIVATE_KEY_ALIAS);
		xmlSignature.addKeyInfo(cert);
		
		// Realizamos la firma
		xmlSignature.sign(privateKey);

		// Guardamos archivo de firma en disco
		DocumentUtil.outputDocToFile(doc, signatureFile);
		
		return fileNameXmlSign;
	}
	
	public SignInfoDto getSignInfo(String pathXmlSign) throws Exception{
		Document doc = DocumentUtil.loadDocumentFromFile(pathXmlSign);
		
		Node DigestValue = doc.getElementsByTagNameNS("*", "DigestValue").item(0);
		String stringDigestValue = DigestValue.getFirstChild().getTextContent();
		
		Node SignatureValue = doc.getElementsByTagNameNS("*", "SignatureValue").item(0);
		String stringSignatureValue = SignatureValue.getFirstChild().getTextContent();
		
		SignInfoDto signInfo = new SignInfoDto();
		
		signInfo.setSignResume(stringDigestValue);
		signInfo.setSignValue(stringSignatureValue);
		
		return signInfo;
	}
	/**
	 * Serializa un objeto Document en un archivo
	 */
	public static void outputDocToFile(Document doc, File file) throws Exception {
		
		FileOutputStream f = new FileOutputStream(file);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();

		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
		transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		transformer.transform(new DOMSource(doc), new StreamResult(f));

		f.close();
	}
	
	public JAXBElement<InvoiceType> createInvoice(InvoiceType invoiceType) throws JAXBException{
		
		ObjectFactory factory = new ObjectFactory();
		JAXBContext context = JAXBContext.newInstance("oasis.names.specification.ubl.schema.xsd.invoice_2");
		marshaller = context.createMarshaller();
        JAXBElement<InvoiceType> element = factory.createInvoice(invoiceType);
        
        return element;
	}
	
	public String createXml(JAXBElement<?> element, String nameXml) throws JAXBException{
		
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new PrefixNamespaceMapper());
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
        	            
        String fileName = path_doc_temp + "/" + nameXml;
        
        this.createFolder(path_doc_temp);
        
        marshaller.marshal(element, new File(fileName));
        
        return fileName;
	}
	
	public String zipXml(String pathXmlSign,String nameXml, String nameZip) throws JAXBException, IOException{
		
        String fileName = path_doczip_temp + "/" + nameZip;
        
        this.createFolder(path_doczip_temp);
		
//        byte[] buffer = new byte[1024];
//        
//		FileOutputStream fos = new FileOutputStream(fileName);
//		ZipOutputStream zos = new ZipOutputStream(fos);
//		ZipEntry ze= new ZipEntry(nameXml);
//		zos.putNextEntry(ze);
//		FileInputStream in = new FileInputStream(pathXmlSign);
//	   
//		int len;
//		while ((len = in.read(buffer)) > 0) {
//			zos.write(buffer, 0, len);
//		}
//
//		in.close();
//		zos.closeEntry();
//		zos.close();
        
        File f = new File(fileName);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry(nameXml);
        out.putNextEntry(e);

        Path path = Paths.get(pathXmlSign);
        byte[] data = Files.readAllBytes(path);
        out.write(data, 0, data.length);
        out.closeEntry();

        out.close();
		        	                    
        return fileName;
	}

	/**
	 * Lee un Document desde un archivo
	 */
	public static Document loadDocumentFromFile(java.io.File file) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;

		factory.setNamespaceAware(true);

		builder = factory.newDocumentBuilder();

		return builder.parse(file);
	}

	/**
	 * @return Devuelve un Document a firmar
	 * @throws Exception
	 *             Cualquier incidencia
	 */
	public static Document loadDocumentFromFile(String pathXml) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		Document doc = dbf.newDocumentBuilder().parse(new FileInputStream(pathXml));

		return doc;
	}
	
	public void createFolder(String path){
		File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
	}
	
	public String getDateYYYYMMDD(Date date){
		
		if(date == null){
			date = new Date();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		
		String formatted = format1.format(cal.getTime());
		
		return formatted;
	}
	
	public String getFileNameDocResume(String ruc, String tipoDoc,String dateCreated, String numero,String extension){
		String fileNameDoc = ruc+"-"+tipoDoc+"-"+dateCreated+"-"+numero+"."+extension;
		return fileNameDoc;
	}
	
	public String getFileNameDoc(String ruc, String tipoDoc,String serie, String numero,String extension){
		String fileNameDoc = ruc+"-"+tipoDoc+"-"+serie+"-"+numero+"."+extension;
		return fileNameDoc;
	}
	
	public int numeroCorrelativoInt(String serie, String numDoc){
		String ns = numDoc.replace(serie+"-", "");
		return Integer.parseInt(ns);
	}
	public String numeroCorrelativoString(String serie, String numDoc){
		String ns = numDoc.replace(serie+"-", "");
		return ns;
	}
	
	public BigDecimal round(Double val){
		BigDecimal amount = new BigDecimal(val);
		amount = amount.setScale(2, RoundingMode.CEILING);
		return amount;
	}
	
	public BigDecimal round(BigDecimal val){
		val = val.setScale(2, RoundingMode.CEILING);
		return val;
	}
}
