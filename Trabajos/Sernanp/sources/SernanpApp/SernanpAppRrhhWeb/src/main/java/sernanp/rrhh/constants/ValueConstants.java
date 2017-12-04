package sernanp.rrhh.constants;

import java.io.Serializable;

public class ValueConstants implements Serializable{

	/**	 *	 */	
	private static final long serialVersionUID = 1L;
		

	public static final int VALOR_CERO=-1;
	public static final int FLAG_ACTIVO=1;
	public static final int AREA_ADMINISTRACION_PUBLICA=1;
	
	public static final int TipoMarcacionTempus = 126;
	public static final int TipoMarcacionManual = 127;
	public static final int TipoDescuentoInasistencia = 128;
	public static final int TipoDescuentoTardanza = 129;
	public static final int TipoPermisoCGH	= 130;
	public static final int TipoPermisoSGH	= 131;
	
	public static final int CantDiasMes	= 30;
	public static final int CantMinMes	= 14400;
	public static final int CantMinMaxToler	= 30;
	public static final String NombreTablaDescTMP	= "sernanp.t_personal_descuento_tmp";
	public static final String NombreTablaDesc	= "sernanp.t_personal_descuento";
	
	//09-07-2014: D.V.R
	
	public static final int TipoLicencia = 35;

}