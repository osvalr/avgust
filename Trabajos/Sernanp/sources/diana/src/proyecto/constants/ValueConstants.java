package proyecto.constants;

import java.io.Serializable;

public class ValueConstants implements Serializable{

	/**	 *	 */	private static final long serialVersionUID = 1L;

	
	
	public static final int ID_ADMIN_TOTAL=1;
	
	public static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
	public static final int NUMERODIASXMES=30;
	public static final String PERIODO_ANUAL="S";
	
	public static final String TITULO_SERNANP="Sistema Integrado de SERNANP";
	public static final String NOMBRE_LOGO_SERNANP="logo.sernanp.jpg";
	
	public static final String PROYECTO_PRINCIPAL="Proyecto Principal";
	public static final int ID_PROYECTO_PRINCIPAL=-2;
	public static final int NIVEL_UNO=1;
	
	public static final int ANIO_BASE=1999;
	
	public static final int ANIO_BASE_PUBLICACION=1900;
	public static final int AREA_ADMINISTRACION_PUBLICA=1;
	
	public static final int MENSAJE_EXITO=1;
	
	
	public static final int MENSAJE_NOMBRE_USUARIO_EXISTE=1;
	public static final int MENSAJE_RUC_EXISTE=2;
	
	public static final int MENSAJE_DNI_EXISTE=1;
	public static final int MENSAJE_GUIA_EXISTE=2;
	
	public static final int LINK_INICIO=1;
	public static final int CONTROL_NUMPAGINA=2;
	public static final int CBO_CATEGORIA=1;
	public static final int CBO_ANP=2;
	
	
	public static final int EJECUTOR_FINANCIERO=1;
	public static final int EJECUTOR_TECNICO=2;
	
	public static final int FUENTE_FINANCIAMIENTO=3;
	
	public static final int FLAG_SI=1;
	public static final int FLAG_NO=2;
	
	public static final int FLAG_ACTIVO=1;
	public static final int FLAG_INACTIVO=-1;
	
	public static final int VALOR_CERO=-1;
	
	public static final int ESTADO_VIGENTE=1;
	public static final int FLAG_TODOS=10;
	
	public static final int ID_SUPER_PROYECTO=233;
	
	public static final int TIPO_EXP_EXCEL=1;
	public static final int TIPO_EXP_PDF=2;
	
	public static final int OPCION_REPORTE_CANTIDAD=1;
	public static final int OPCION_REPORTE_MONTO=2;
	
	public static final int TOTAL=1;
	public static final int VIGENTES=2;
	public static final int CONCLUIDOS=3;
	
	public static final int MONEDA_SOL=1;
	
	public static final int ORDEN_MONTO=1;
	
	public static final int ID_PERSONA_JURIDICA_TODOS=190;
	
	
	public static final int TIPO_FILE_DOCUMENTO=1;
	public static final int TIPO_FILE_IMAGEN=2;
	
	
	
	//IDS 
	public static final int ID_PAIS_PERU=171;
	public static final int ID_ROL_OPERADOR_TURISMO=2;
	
	public  int getID_PAIS_PERU() {
		return ID_PAIS_PERU;
	}
	
	
	//tipos
	public static final int TIPO_DOCUMENTO=1;
	public static final int TIPO_GENERO=2;
	public static final int TIPO_ESTADO_CIVIL=3;
	public static final int TIPO_ESTADO_PAGO_BANCO=7;
	public static final int TIPO_OCUPACION=8;
	public static final int TIPO_MOTIVO_VISITA=9;
	public static final int TIPO_ESTADO_FICHA_TURISMO=14;
	public static final int TIPO_MODALIDAD_PAGO_FICHA_TURISMO=15;
	public static final int TIPO_ACCION_FICHA_TURISMO=16;
//	public static final int TIPO_ESTADO_FICHA_TURISMO=6;
//	public static final int TIPO_MODALIDAD_PAGO_FICHA_TURISMO=10;
//	public static final int TIPO_ACCION_FICHA_TURISMO=11;
	public static final int TIPO_ESTADO_MULTA=17;
	
	//tipo rol
	public static final int TIPO_ROL_ADMINISTRADOR_TOTAL=100;
	public static final int TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL=1;
	public static final int TIPO_ROL_ADMINISTRADOR_SEDE_ANP=2;
	public static final int TIPO_ROL_OPERADOR_TURISMO=3;
	
	//
	public static final int TIPO_LOCAL=22;
	public static final int TIPO_MEDIO_TRAN=23;
	
	
	
	
	
	
	public  int getTIPO_ROL_ADMINISTRADOR_TOTAL() {
		return TIPO_ROL_ADMINISTRADOR_TOTAL;
	}
	public  int getTIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL() {
		return TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL;
	}
	public  int getTIPO_ROL_ADMINISTRADOR_SEDE_ANP() {
		return TIPO_ROL_ADMINISTRADOR_SEDE_ANP;
	}
	
	public  int getTIPO_ROL_OPERADOR_TURISMO() {
		return TIPO_ROL_OPERADOR_TURISMO;
	}
	
	
	//tipo consulta
	public static final int TIPO_CONSULTA_FICHA_GENERADA=1;
	public static final int TIPO_CONSULTA_FICHA_GENERADA_AND_CREADA=2;
	
	
	//codigos
	public static final int CODIGO_TIPO_LOGO_PRINCIPAL=1;
	public static final int CODIGO_ESTADO_PAGOBANCO_COMPLETO=1;
	public static final int CODIGO_ESTADO_PAGOBANCO_FALTANTE=2;
	public  int getCODIGO_ESTADO_PAGOBANCO_COMPLETO() {
		return CODIGO_ESTADO_PAGOBANCO_COMPLETO;
	}
	public  int getCODIGO_ESTADO_PAGOBANCO_FALTANTE() {
		return CODIGO_ESTADO_PAGOBANCO_FALTANTE;
	}
//	public static final int CODIGO_ESTADO_PAGOBANCO_SOBRANTE=3;
//	public static final int CODIGO_ESTADO_PAGOBANCO_PROCESO=4;
	
	public static final int CODIGO_TIPO_ACCION_FICHA_CREAR=1;
	public static final int CODIGO_TIPO_ACCION_FICHA_GUARDAR=2;
	public static final int CODIGO_TIPO_ACCION_FICHA_GENERAR=3;
	public static final int CODIGO_TIPO_ACCION_FICHA_PAGAR=4;
	public static final int CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR=5;
	
	public  int getCODIGO_TIPO_ACCION_FICHA_CREAR() {
		return CODIGO_TIPO_ACCION_FICHA_CREAR;
	}
	public  int getCODIGO_TIPO_ACCION_FICHA_GUARDAR() {
		return CODIGO_TIPO_ACCION_FICHA_GUARDAR;
	}
	public  int getCODIGO_TIPO_ACCION_FICHA_GENERAR() {
		return CODIGO_TIPO_ACCION_FICHA_GENERAR;
	}
	public  int getCODIGO_TIPO_ACCION_FICHA_PAGAR() {
		return CODIGO_TIPO_ACCION_FICHA_PAGAR;
	}
	public  int getCODIGO_TIPO_ACCION_FICHA_CONSOLIDAR() {
		return CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR;
	}
	
	
	
	public static final int CODIGO_ESTADO_FICHA_CREADO=1;
	//public static final int CODIGO_ESTADO_FICHA_ACTUALIZADO=2;
	public static final int CODIGO_ESTADO_FICHA_GENERADO=2;
//	public static final int CODIGO_ESTADO_FICHA_PAGADO_COMPLETO=4;
//	public static final int CODIGO_ESTADO_FICHA_PAGADO_INCOMPLETO=5;
	public static final int CODIGO_ESTADO_FICHA_CONSOLIDADO=3;
	
	
	public  int getCODIGO_ESTADO_FICHA_CREADO() {
		return CODIGO_ESTADO_FICHA_CREADO;
	}
//	public  int getCODIGO_ESTADO_FICHA_ACTUALIZADO() {
//		return CODIGO_ESTADO_FICHA_ACTUALIZADO;
//	}
	public  int getCODIGO_ESTADO_FICHA_GENERADO() {
		return CODIGO_ESTADO_FICHA_GENERADO;
	}
//	public  int getCODIGO_ESTADO_FICHA_PAGADO_COMPLETO() {
//		return CODIGO_ESTADO_FICHA_PAGADO_COMPLETO;
//	}
//	public  int getCODIGO_ESTADO_FICHA_PAGADO_INCOMPLETO() {
//		return CODIGO_ESTADO_FICHA_PAGADO_INCOMPLETO;
//	}
	public  int getCODIGO_ESTADO_FICHA_CONSOLIDADO() {
		return CODIGO_ESTADO_FICHA_CONSOLIDADO;
	}
	
	
	public static final int CODIGO_MODPAGOFICHA_BANCO=1;
	public static final int CODIGO_MODPAGOFICHA_SEDE=2;
	public static final int CODIGO_MODPAGOFICHA_BANCO_FICHA=3;
	
	public  int getCODIGO_MODPAGOFICHA_BANCO() {
		return CODIGO_MODPAGOFICHA_BANCO;
	}
	public  int getCODIGO_MODPAGOFICHA_SEDE() {
		return CODIGO_MODPAGOFICHA_SEDE;
	}
	public  int getCODIGO_MODPAGOFICHA_BANCO_FICHA() {
		return CODIGO_MODPAGOFICHA_BANCO_FICHA;
	}
	
	
	
	public static final int CODIGO_GENERO_MASCULINO=1;
	public static final int CODIGO_GENERO_FEMENINO=2;
	
	public static final int CODIGO_OCUPACION_ESTUDIANTE=1;
	public static final int CODIGO_OCUPACION_PROFESIONAL=2;
	public static final int CODIGO_OCUPACION_OTROS=3;
	
	public static final int CODIGO_MOTIVOVISITA_TURISMO=1;
	public static final int CODIGO_MOTIVOVISITA_ESTUDIO=2;
	public static final int CODIGO_MOTIVOVISITA_OTROS=3;
	
	
	
	
	public static final int CODIGO_GRUPO_EDAD_MAYOREDAD=1;
	public static final int CODIGO_GRUPO_EDAD_MENOREDAD=2;
	public static final int CODIGO_GRUPO_EDAD_INFANTE=3;
	
	
	
	public static final int LONGITUD_MINIMA_CADENA_ALEATORIA=7;
	
	public static final long NUMERO_DIAS_COTA_INF_EDAD_MAYOR=4745;
	public static final long NUMERO_DIAS_COTA_INF_EDAD_MENOR=1825;
	
	//tipo usuario sistema
	public static final int TIPO_USUARIO_OPERADOR_TURISTICO=1;
	
	
	//PARAMETROS
	public static final int TAMANIO_PAGINA_20=20;
	public static final int TAMANIO_NUMFECHA_CODIGO_FICHA_TURISMO=4;
	
	
	//id 
	public static final int ID_CONCEPTO_EXONERACION_PAGO_MENOR=1;
	
	
	public static final String TXT_NO_APLICA="No Aplica";
	
	public static final int LINK_INICIO_0=0;
	public static final int CONTROL_NUMPAGINA_1=1;
	
	
	
//	public static final int FLAG_REGISTRO_ALMACENADO=-1;
//	public static final int FLAG_REGISTRO_GUARDADO=1;
//	public static final int FLAG_REGISTRO_QUITADO=2;
//	public static final int FLAG_REGISTRO_ELIMINADO=3;
//	public static final int FLAG_REGISTRO_GUARDADO_ALMACENADO=11;
	
	
	
	public static final int ORDEN_CONSULTA_IDVISITANTE=1;
	public static final int ORDEN_CONSULTA_IDBOLETAJE=2;
	public static final int ORDEN_CONSULTA_NOMBRECOMPVISITANTE=3;
	
	
	public static final int ORDEN_CONSULTA_ORD=1;
	public static final int ORDEN_CONSULTA_CODIGOINT=2;
	
	
	public static final int TIPO_REGISTRO_CREAR=1;
	public static final int TIPO_REGISTRO_EDITAR=2;
	
	
	public static final int TIPO_CLAUSULA_IGUALDAD=0;
	public static final int TIPO_CLAUSULA_LIKE=1;
	
	
	public static final int OPCION_ELIMINAR=3;
	
	

	
	
	public  int getTIPO_REGISTRO_CREAR() {
		return TIPO_REGISTRO_CREAR;
	}
	public  int getTIPO_REGISTRO_EDITAR() {
		return TIPO_REGISTRO_EDITAR;
	}
	
	//
	public static final String EST_PAGO_FICHA_PROCESO_DES="Pago en Proceso";
	public static final String EST_PAGO_FICHA_PROCESO_MSG="El pago de la ficha se encuentra en proceso";

	public  int getCODIGO_GRUPO_EDAD_MAYOREDAD() {
		return CODIGO_GRUPO_EDAD_MAYOREDAD;
	}
	public  int getCODIGO_GRUPO_EDAD_MENOREDAD() {
		return CODIGO_GRUPO_EDAD_MENOREDAD;
	}
	public  int getCODIGO_GRUPO_EDAD_INFANTE() {
		return CODIGO_GRUPO_EDAD_INFANTE;
	}
	
	
	//indices banco
	
	public static final int IDXF_CODIGO_TRIBUTO=5;
	public static final int IDXF_TIPO_DOCUMENTO=6;
	public static final int IDXF_NUMERO_DOCUMENTO=21;
	public static final int IDXF_CODIGO_SERNANP=44;
	public static final int IDXF_NUMERO_REGISTROS=48;
	public static final int IDXF_IMPORTE=61;
	public static final int IDXF_FECHA_MOVIMIENTO=69;
	public static final int IDXF_NUMERO_SECUENCIA=75;
	public static final int IDXF_HORA=81;
	public static final int IDXF_DIGITO_CHEQUEO=82;
	public static final int IDXF_COD_AGENCIA=86;
	public static final int IDXF_COD_CAJERO=90;
	public static final int IDXF_FILLER=100;
		
	public static final String FINAL_ARCHIVO="99999";
	public static final int IDX_FINAL_ARCHIVO=5;
	public static final String NOMBRE_ARCHIVO="REPA_SERNP";//REPA_SERNP20110711.TXT
	public static final String EXT_ARCHIVO=".txt";
	
	
	//parametros
	
	public static final String SMTP_HOST_NAME="SMTP_HOST_NAME";
	public static final String SMTP_PORT="SMTP_PORT";
	public static final String SMTP_AUTH_USER="SMTP_AUTH_USER";
	public static final String SMTP_AUTH_PWD="SMTP_AUTH_PWD";
	public static final String SMTP_FROM_ADDRESS="SMTP_FROM_ADDRESS";
	public static final String ASUNTO_MAIL_NEWUSEROPERADOR="ASUNTO_MAIL_NEWUSEROPERADOR";
	public static final String RUTA_MAIL_NEWUSEROPERADOR="RUTA_MAIL_NEWUSEROPERADOR";
	public static final String ASUNTO_MAIL_NEWCLAVEOPERADOR="ASUNTO_MAIL_NEWCLAVEOPERADOR";
	public static final String RUTA_MAIL_NEWCLAVEOPERADOR="RUTA_MAIL_NEWCLAVEOPERADOR";
	public static final String SMTP_SSL="SMTP_SSL";

	public static final String RUTA_ARCHIVOS_PAGOSBANCO="RUTA_ARCHIVOS_PAGOSBANCO";
	
	
}




