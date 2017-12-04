package sernanp.app.business.cons;

public class Estados {
		
	//Estados Postulaciones
	public static final Integer POSTULACION_PERSONA_REGISTRADO = 1;
	public static final Integer POSTULACION_PERSONA_GANADOR = 2;
	public static final Integer POSTULACION_PERSONA_CONTRATO_SUSCRITO = 3;
	public static final Integer POSTULACION_PERSONA_ANULADO = 4;
	public static final Integer POSTULACION_PERSONA_DESCARTADO = 5;
	public static final Integer POSTULACION_PERSONA_CONTRATO_NO_SUSCRITO = 6;
	
	//Estados Codigo postulacion
	public static final Integer CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO = 1;
	public static final Integer CODIGO_POSTULACION_CONVOCATORIA_DESIERTO = 2;
	public static final Integer CODIGO_POSTULACION_CONVOCATORIA_CERRADO = 3;
	
	//Estados convocatoria
	public static final Integer CONVOCATORIA_EN_PROCESO = 1;
	public static final Integer CONVOCATORIA_FINALIZADO = 2;
	
	//Estados Personal
	public static final Integer PERSONAL_ACTIVO = 0;
	public static final Integer PERSONAL_INACTIVO = 1;
	
	//Estados Personal
	public static final Integer CONTRATO_GENERADO = 1;
	public static final Integer CONTRATO_SUSCRITO = 2;
	public static final Integer CONTRATO_NO_SUSCRITO = 3;
	public static final Integer CONTRATO_ANULADO = 4;
	
	public static final Integer ESTADO_GENERICO_ACTIVO = 1;
	public static final Integer ESTADO_GENERICO_INACTIVO = 2;
	
	/* Begin Alanmar 21/04/2015 */
	
	//Estados Requerimiento
	public static final Integer CODIGO_REQUERIMIENTO_EN_PROCESO = 1;
	public static final Integer CODIGO_REQUERIMIENTO_CERRADO = 2; 
	
	/* End Alanmar 21/04/2015 */
}
