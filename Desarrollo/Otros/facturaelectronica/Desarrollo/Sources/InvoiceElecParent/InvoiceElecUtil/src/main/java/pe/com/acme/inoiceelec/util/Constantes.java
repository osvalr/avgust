package pe.com.acme.inoiceelec.util;

public class Constantes {
	
	public class Empresa{
		public static final String ID_EMP = "52";
	} 
	
	public class Correlativo{
		public static final String TIPO_DOCUMENTO = "DE";
		public static final String SERIE_FACTURA = "F001";
		public static final String SERIE_BOLETA = "B001";
		public static final String SERIE_NOTA_CREDITO = "C001";
		public static final String SERIE_NOTA_DEBITO = "D001";
	}
	
	public class DocumentoElectronico{
		public static final String FACTURA = "01";
		public static final String BOLETA = "03";
		public static final String NOTA_CREDITO = "07";
		public static final String NOTA_DEBITO = "08";
		public static final String RESUMEN_DIARIO = "RC";
		public static final String CUMUNICACION_BAJA = "RA";
	}
	
	public class EstadoDocumentoElectronico{
		public static final String GENERADO = "1";
		public static final String EN_PROCESO = "2";
		public static final String ACEPTADO = "3";
		public static final String RECHAZADO = "4";
	}
	
	public class Extension{
		public static final String XML = "XML";
		public static final String ZIP = "ZIP";
	}
}
