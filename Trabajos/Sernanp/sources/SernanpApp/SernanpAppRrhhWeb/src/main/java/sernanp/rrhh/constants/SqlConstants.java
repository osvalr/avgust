package sernanp.rrhh.constants;

import java.io.Serializable;

public class SqlConstants implements Serializable{

	/**	 *	 */	
	private static final long serialVersionUID = 1L;
		

	public static final String listaPais=
		"select p.* " +
		"from sernanp.pais p " +
		"where 1=1 " ;	
	
	public static final String contarUsuarioUnico=
			"select count(*) as total from sernanp.usuario u " +
			"  where 1=1 "  ; 
	
	public static final String contarRucUnicoPersona=
		"select count(*) as total from sernanp.persona per " +
		"  where 1=1 "  ; 
	
	public static final String contarNumeroDocumentoUnicoPersonaNatural=
		"select count(*) as total from sernanp.personanatural pnat " +
		"  where 1=1 "  ; 
			
	
	public static final String listaAreaNatural=
		"select a.*,cat.*,a.estado as estadoarea,cat.estado as estadocat " +
		"from sernanp.areanatural a " +
		"left join sernanp.categoriaanp cat on cat.idcategoriaanp=a.idcategoriaanp " +
		"where 1=1 " ;
	
	
	public static final String listaRolModulo=
		"select rm.*,m.*,r.* " +
		" from sernanp.rolmodulo rm " + 
		" left join sernanp.rol r on r.idrol=rm.idrol " + //Agregado 13-05-2012
		" left join sernanp.modulo m on m.idmodulo=rm.idmodulo " +
		"where 1=1 " ;
	
	public static final String listaLogo=
		"select l.*,dar.*,tip " +
		" from sernanp.logo l " +
		" left join sernanp.directorioarchivo dar on dar.iddirectorioarchivo=l.iddirectorioarchivo " +
		" left join sernanp.tablatipo tip on tip.idtablatipo=l.idtipologo " +
		"where 1=1 " ;		 
	 
	 
	 public static final String listaTipo=
			"select t.* " +
			" from sernanp.tablatipo t " +
			"where 1=1 " ;
	 
	 public static final String listaTiposEncontrados=
				"select t.* " +
				" from sernanp.tablatipo t " +
				" inner join sernanp.t_visitante_museo tvm On t.idtablatipo = tvm.int_id_motivovisita " +
				"where t.idtabla = ? and tvm.int_id_areanatural = ? ";
				
	 
	 public static final String listaTipoDocumentoIdentidad=
			"select tdi.* " +
			" from tipodocumento tdi " +
			"where 1=1 " ;
	 
	 
	 public static final String listaArchivo=
			"select a.*,dir.* " +
			" from sernanp.archivo a " +
			" left join sernanp.directorioarchivo dir on dir.iddirectorioarchivo=a.iddirectorioarchivo " +
			"where 1=1 " ;
	 
	
	 public static final String listaUsuario=
			"select u.*," +
			"pnat.*, p.*,ps.*,ao.*,sede.* " +
			" from sernanp.usuario u " +
			"left join sernanp.personal per on per.idpersonal=u.idpersonal " +			
			"left join sernanp.personanatural pnat on pnat.idpersonanatural=per.idpersonanatural " +
			"left join sernanp.persona p on p.idpersona=pnat.idpersona OR p.idpersona=u.idpersona " +//Modifocado 26/05/2012 (Y.C.B.)
			"left join sernanp.pais ps on ps.idpais=p.idpais " +
			"left join sernanp.areaorganica ao on ao.idarea=u.idArea " +
			"left join sernanp.sede sede on sede.idsede=ao.idsede " +
			"where 1=1 " ;
	 
	 //Agregado 02-08-2013 (D.V.R)
	 public static final String listaUsuarioRol=
				"select ur.*,u.*,r.* " +
				" from sernanp.usuariorol ur " + 
				" left join sernanp.rol r on r.idrol=ur.idrol " + 
				" left join sernanp.usuario u on u.idusuario=ur.idusuario " +
				"where 1=1 " ;
	
	 
	 public static final String listaUsuarioArea=
			"select u.*," +
			"ao.idareanatural " +
			" from usuario u " +
			"left join areaorganica ao on ao.idarea=u.idArea " +
			"left join areanatural an on an.idareanatural=an.idareanatural " +
			"where 1=1 " ;
	 
	 
	 	 
	 public static final String listaTelefono=
			"select distinct t.idpersonal, t.*," +
			"tf.nombretipotelefono, " +
			"p.*,pnat.* " +
			" from telefono t " +
			"left join tipotelefono tf on tf.idtipotelefono=t.idtipotelefono " +
			"left join personal p on p.idpersonal=t.idpersonal " +
			"left join personanatural pnat on pnat.idpersonanatural=p.idpersonanatural " +
			"where 1=1 " ;
	 
	 public static final String listaPersonal=
			"select p.idpersonal,p.mailpersonal," +
			"ao.*, " +
			"pnat.*,an.*,c.* " +
			" from personal p " +
			"left join personanatural pnat on pnat.idpersonanatural=p.idpersonanatural " +
			"left join areaorganica ao on ao.idarea=p.idarea " +
			"left join areanatural an on an.idareanatural=ao.idareanatural " +
			"left join cargo c on c.idcargo=p.idcargo " +
			"where 1=1 " ;
	 
	 
	 public static final String listaPersonalUnico=
			"select distinct p.idpersonal,p.mailpersonal," +
			"ao.*, " +
			"pnat.*,an.*,c.* " +
			" from personal p " +
			"left join personanatural pnat on pnat.idpersonanatural=p.idpersonanatural " +
			"left join areaorganica ao on ao.idarea=p.idarea " +
			"left join areanatural an on an.idareanatural=ao.idareanatural " +
			"left join cargo c on c.idcargo=p.idcargo " +
			"where 1=1 " ;
	 	 
	 	 
	 
	 
	 
	 
	 public static final String insertaUsuario=
			"insert into sernanp.usuario(usuario,clave," +
			"estado,idarea,idrol,idpersonal)"+
			" VALUES(:usuario,md5(:clave)," +
			" :estado,:idarea,:idrol,:idpersonal) "+
			" RETURNING  idusuario ";
	 
	
	 
	 public static final String listaAreaOrganica=
			"select ao.idarea,ao.codarea,ao.desarea," +
			"ao.idtipoarea,ao.idareanatural  " +
			" from areaorganica ao " +
			"left join tipoareaorganica tpa on tpa.idtipoarea=ao.idtipoarea " +
			"where 1=1 " ;
	 
	 public static final String listaCategoriaAnp=
			"select c.* " +
			" from sernanp.categoriaanp c " +
			"where 1=1 " ;
	 
	 
	 public static final String listaIdAreanaturalxAreaNatural=
		  " :idareanatural )" ;
		 
	 public static final String listaUbigeo=
			"select u.* " +
			" from sernanp.ubigeo u " +
			"where 1=1 " ;
	 
	 
		
		public static final String listaPersonaJuridica=
				"select cpj.idpersonajuridica, cpj.idpersona, p.correoinstitucional, p.telefono,pj.ruc, pj.nombrepersonajuridica " +
				"from sernanp.personajuridica pj " +
				"inner join sernanp.contactopersonajuridica cpj on cpj.idpersonajuridica=pj.idpersonajuridica " +
				"inner join sernanp.persona p on p.idpersona=cpj.idpersona " +								
				"where 1=1 " ;
		
		public static final String listarJefesAnp = "SELECT hja.idareanatural, p.* FROM sernanp.historialjefesanp hja inner join sernanp.personal p on hja.idpersonal = p.idpersonal ";
		
		//Módulo SGMVEMI - 28/08/12
		public static final String insertLogin = "INSERT INTO sernanp.login (clave, usuario, idsistema, idusuario, fecha) VALUES ";
		
	
	

		//Sistema de RR. HH  03-08-2013 (D. V. R)

		
		public static final String estadoAsistenciaxidPersonal = "SELECT pa.hor_hor_ingreso as asistencia_ingreso, pa.hor_hor_salida as asistencia_Salida, "+
				"CASE	WHEN pa.hor_hor_ingreso > pt.hor_hor_ingreso 	THEN "+
				"pa.hor_hor_ingreso - pt.hor_hor_ingreso END as minutos_tardanza, 	pa.int_estado , "+ 
				"CASE WHEN pa.hor_hor_ingreso ISNULL AND pa.hor_hor_salida ISNULL THEN "+
				"1 END AS int_estado_tmp , int_vac_lic "+
				"FROM sernanp.personal p "+
				"INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno "+ 
				"INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal "+
				"INNER JOIN sernanp.t_personal_contrato pc ON pc.idpersonal = p.idpersonal "+
				"AND (pc.dte_fec_cese ISNULL  OR pa.dte_fecha <= pc.dte_fec_cese ) ";

		
		
		public static final String listapersonal =	"SELECT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal, pa.dte_fecha, " +
						"pa.hor_hor_ingreso as asistencia_ingreso, pt.hor_hor_ingreso as Turno_Ingreso, " +
						"pa.hor_hor_salida as asistencia_Salida, pt.hor_hor_salida as Turno_Salida, " +
						"CASE	WHEN pa.hor_hor_ingreso > pt.hor_hor_ingreso 	THEN pa.hor_hor_ingreso - pt.hor_hor_ingreso " +
						"END as minutos_tardanza, pa.int_estado " +
						", CASE WHEN pa.hor_hor_ingreso ISNULL AND pa.hor_hor_salida ISNULL THEN 1 END AS int_estado_tmp ";
//						"FROM sernanp.personanatural pn " +
//						"INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural " +
//						"AND p.int_estado = 0  "+
//						//+ "AND p.int_flag = 0 " + SE COMENTO EL 02/07/2014 PARA EFECTOS DE CONSULTAR TODO EL PERSONAL (LIMA Y PROVINCIAS)
//						"INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno " +
//						"INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal ";
		 			
		
		public static final String incidencias = "SELECT COUNT(pa.int_estado) ||'-'|| ";
		

		

		/*---  Para sacar las tardanzas del Personal -----*/
		public static final String listapersonalTardanza  = "SELECT distinct pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, " +//No se esta utilizando
				"pa.dte_fecha, pa.hor_hor_ingreso as asistencia_ingreso, pt.hor_hor_ingreso as Turno_Ingreso, " +
				"pa.hor_hor_salida as Asistencia_Salida, pt.hor_hor_salida as Turno_Salida, " +
				"p.idpersonal,(pa.hor_hor_ingreso - pt.hor_hor_ingreso) as minutos_tardanza, pa.int_estado " +
				"FROM sernanp.personanatural pn " +
				"INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural " +
				"INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal " +
				"INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno " +
				"WHERE 	pt.hor_hor_ingreso < pa.hor_hor_ingreso AND ";//Se cambio por obtenerpersonalcontardanza
		
		

		public static final String obtenertardanzaxidpersonal = " SELECT 	p.idpersonal, pa.dte_fecha, (pa.hor_hor_ingreso - pt.hor_hor_ingreso) as tardanza " +
				"FROM sernanp.personal p " +
				"INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno " +
				"INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal AND " +
				"p.int_estado = 0 AND pa.hor_hor_ingreso > pt.hor_hor_ingreso AND pa.int_estado = 0 AND " +
				"ORDER BY p.idpersonal";//Por utilizar
		//pa.dte_fecha BETWEEN '01/09/2013'  AND '30/09/2013' --AND p.idpersonal = 3475 
		
		public static final String contartardanzas = "SELECT COUNT(*) "
				+ "FROM sernanp.t_personal_tardanza pt ";
//				+ "WHERE pt.dte_fec_pers_tard BETWEEN '2013-09-01' AND '2013-09-30'";
		
		
		public static final String contardescuentosTMPxperiodo = "SELECT COUNT(* ) "+
				"FROM sernanp.t_personal_descuento_tmp pd ";
		
		public static final String contardescuentosvalidadosxperiodo = "SELECT COUNT(* ) "+
				"FROM sernanp.t_personal_descuento pd ";
		
		
		public static final String listapersonalcontardanzaTMP = "SELECT 	DISTINCT p.idpersonal, " +
				"SUM((EXTRACT (HOUR FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer*60) + "+
				"(EXTRACT (MINUTE FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer)) as tardanza, pc.num_sueldo " +
				"FROM sernanp.personal p " +
				"INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno " +
				"INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal "+
				"INNER JOIN sernanp.t_personal_contrato pc ON p.idpersonal = pc.idpersonal " +
				"WHERE pa.int_estado = 0 AND " ;
//				"AND EXTRACT(DOW FROM pa.dte_fecha) NOT IN (6,0) ";		 
		
		
		public static final String listapersonalcontardanza = "SELECT 	DISTINCT p.idpersonal, pa.dte_fecha, " +
				"((EXTRACT (HOUR FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer*60) + "+
				"(EXTRACT (MINUTE FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer)) as tardanza, pc.num_sueldo " +
				"FROM sernanp.personal p " +
				"INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno " +
				"INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal " +
				"INNER JOIN sernanp.t_personal_contrato pc ON p.idpersonal = pc.idpersonal " +
				"WHERE pa.dte_fecha NOT IN ( " +
				"SELECT pt.dte_fec_pers_tard " +
				"FROM 	sernanp.t_personal_tardanza pt " +
				"WHERE  pa.dte_fecha = pt.dte_fec_pers_tard AND p.idpersonal = pt.idpersonal) AND p.int_estado = 0 AND " +
				"EXTRACT(MINUTE FROM (pa.hor_hor_ingreso)) > EXTRACT(MINUTE FROM (pt.hor_hor_ingreso)) AND pa.int_estado = 0 AND ";
//				"pa.hor_hor_ingreso > pt.hor_hor_ingreso AND ";
		
		
		
		public static final String listapersonaltardanzadesc = "SELECT  pt.idpersonal,CASE	WHEN SUM(pt.int_min_tard) > 30 THEN ( " +
				"SELECT ROUND((pc.num_sueldo /14400) * (SUM(pt.int_min_tard) - 30),2) " +
				"FROM sernanp.t_personal_contrato pc " +
				"WHERE pc.idpersonal = pt.idpersonal) ELSE 0	END AS descuento " +
				"FROM sernanp.t_personal_tardanza pt " +
				"WHERE 	pt.dte_fec_pers_tard "; 
		
		
		public static final String listapersonalinasistenciadesc = "SELECT pc.idpersonal, ROUND(((pc.num_sueldo / 30) * (" +
				"SELECT count(pa.idpersonal) " +
				"FROM sernanp.t_personal_asistencia pa " +
				"WHERE pa.dte_fecha ";
		
		
		public static final String listapersonalinasistenciadescSP =  "SELECT sernanp.fn_genera_descuento_personal ";
		
		
		public static final String listainasistenciasPermisosxidpersonal = "SELECT pa.idpersonal, pa.dte_fecha, pa.int_estado, pa.int_vac_lic "+
				"FROM sernanp.t_personal_asistencia pa ";
//				"INNER JOIN sernanp.t_personal_descuento_tmp pd ON pd.idpersonal  = pa.idpersonal ";
				 
		
		
		public static final String insertar_updateasistencias 		= "SELECT sernanp.insertar_updateasistencias ";
		public static final String actualizar_asistencia_marcacion 	= "SELECT sernanp.actualizar_asistencia_marcacion ";
		
		public static final String countAsistenciasxfecha		= "SELECT COUNT(*) FROM sernanp.t_personal_asistencia a ";
      
		
		/*----------------------------------*/
		
		
		
		public static final String listapersonalxid = "SELECT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal " +
				"FROM sernanp.personanatural pn " +
				"INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural " +
				"WHERE p.idpersonal = ?";
		
		
		public static final String personalturno = "SELECT at.hor_hor_ingreso, at.hor_hor_salida "+  
				"FROM sernanp.t_asistencia_turno at "+
				"INNER JOIN sernanp.personal p ON at.srl_id_asis_turno = p.srl_id_asis_turno "+ 
				"WHERE 	p.idpersonal 	= ? ";
		
		
		
		public static final String Idpersonalxnumerodoc = "SELECT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal, pn.idpersonanatural " +
				"FROM sernanp.personanatural pn " +
				"INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural " +
				"WHERE pn.numerodoc = ?";
		
		//Se esta remplanzando con el query siguiente
		public static final String MarcacionxIdpersonalfechamarchoramarc = "SELECT pm.*, tm.destablatipo, pa.var_des_per_activ  "+				
				"FROM sernanp.t_personal_marcacion pm "+
				"LEFT JOIN sernanp.tablatipo tm ON tm.idtablatipo = pm.idtablatipo " +
				"LEFT JOIN sernanp.t_personal_actividad pa ON pa.srl_id_per_activ = pm.srl_id_per_activ " +
				"WHERE 	pm.idpersonal 	= ? AND ";
		
		
		public static final String MarcacionxIdpersonalfechamarc = "SELECT pm.*, tm.destablatipo, pa.var_des_per_activ "+
				"FROM sernanp.t_personal_marcacion pm "+ 
				"INNER JOIN sernanp.tablatipo tm ON tm.idtablatipo = pm.idtablatipo "+ 
				"LEFT JOIN sernanp.t_personal_actividad pa ON pa.srl_id_per_activ = pm.srl_id_per_activ "+ 
				"WHERE 	pm.idpersonal 	= ? AND "; 
				
				
				/*"SELECT pm.*, tm.destablatipo, " +
				"pa.var_des_per_activ, at.hor_hor_ingreso, at.hor_hor_salida  "+				
				"FROM sernanp.t_personal_marcacion pm "+
				"INNER JOIN sernanp.tablatipo tm ON tm.idtablatipo = pm.idtablatipo "+
				"INNER JOIN sernanp.personal p ON p.idpersonal = pm.idpersonal "+
				"INNER JOIN sernanp.t_asistencia_turno at ON at.srl_id_asis_turno = p.srl_id_asis_turno "+
				"LEFT JOIN sernanp.t_personal_actividad pa ON pa.srl_id_per_activ = pm.srl_id_per_activ "+ 
				"INNER JOIN sernanp.t_personal_asistencia pas ON pm.idpersonal = pas.idpersonal "+
//				"AND (pas.hor_hor_ingreso IS NOT NULL OR pas.hor_hor_salida IS NOT NULL) "+
				"AND pas.dte_fecha = pm.dte_fec_marc "+
				"WHERE 	pm.idpersonal 	= ? AND ";*/
		
		
	
		
		public static final String MarcacionxId = "SELECT pm.srl_id_pers_marc, pm.dte_fec_marc, pm.hor_hor_marc, pm.idpersonal, pm.var_descripcion, "+
				"pa.*, tm.idtablatipo, tm.destablatipo, "+
				"CASE 	WHEN pm.hor_hor_marc = pas.hor_hor_ingreso THEN 0 ELSE 1 END AS hor_en_asistencia, pas.srl_id_personal_asistencia, "+
				"CASE 	WHEN pm.hor_hor_marc = pd.hor_hor_sal_desp THEN 0	WHEN pm.hor_hor_marc = pd.hor_hor_ret_desp THEN 1 END AS hor_sal_o_ret, pd.srl_id_desp " +
				"FROM sernanp.t_personal_marcacion pm " +
				"LEFT JOIN sernanp.t_personal_actividad pa ON pa.srl_id_per_activ = pm.srl_id_per_activ " +
				"LEFT JOIN sernanp.tablatipo tm ON tm.idtablatipo = pm.idtablatipo " +				
				"LEFT JOIN sernanp.t_personal_desplazamiento pd ON pd.idpersonal = pm.idpersonal  " + 
				"AND (pd.hor_hor_sal_desp = pm.hor_hor_marc OR pd.hor_hor_ret_desp = pm.hor_hor_marc) AND pd.dte_fec_sal_desp = pm.dte_fec_marc AND pd.dte_fec_ret_desp ISNULL "+
				"INNER JOIN sernanp.t_personal_asistencia pas ON pas.idpersonal = pm.idpersonal "+
				"AND pm.dte_fec_marc = pas.dte_fecha AND pm.srl_id_pers_marc = ? ";
		
//				"WHERE 	pm.srl_id_pers_marc = ?";
		
		
		
		public static final String listaidMarcaciones ="SELECT pm.srl_id_pers_marc FROM  sernanp.t_personal_marcacion pm "+
				"WHERE pm.srl_id_desp =  ? "+
				 "ORDER BY 1 ASC ";
		
		public static final String MarcacionxIdpersonalActividadfechamarchoramarc = "SELECT pm.dte_fec_marc, pm.hor_hor_marc, pm.idpersonal, pm.srl_id_per_activ "+
				"FROM sernanp.t_personal_marcacion pm " +
				"WHERE 	pm.idpersonal 	= ? AND " +
				"pm.srl_id_per_activ = ? AND ";
		
		
	

		public static final String listapersonalmarcxid = "SELECT pm.* , tm.destablatipo, pa.var_des_per_activ " +
				"FROM sernanp.t_personal_marcacion pm " +
				"LEFT JOIN sernanp.tablatipo tm ON tm.idtablatipo = pm.idtablatipo " +
				"LEFT JOIN sernanp.t_personal_actividad pa ON pa.srl_id_per_activ = pm.srl_id_per_activ " +
				"WHERE pm.idpersonal = ? AND ";
		
		
		public static final String listapersonalDescuentoTMP = "SELECT 	p.idpersonal, pn.numerodoc, pn.nombre,  pn.apepat, pn.apemat, "+
				"SUM(pd.int_minutos_tardanza) AS minutos_tardanza, "+
				"(SELECT COUNT(pa.int_estado) "+
				"FROM sernanp.t_personal_asistencia pa "+
				"WHERE 	pa.idpersonal = p.idpersonal AND pa.int_estado = 1 AND pa.int_vac_lic ISNULL AND ";
				
		
		
		public static final String listapersonalDescuento = "SELECT 	p.idpersonal, pn.numerodoc, pn.nombre,  pn.apepat, pn.apemat, (" +
				"SELECT CASE WHEN SUM(pt.int_min_tard) > 30 THEN (SUM(pt.int_min_tard) - 30 ) END " +
				"FROM sernanp.t_personal_tardanza pt " +
				"WHERE pt.idpersonal = p.idpersonal ";

		public static final String listapersonalDescuentoFinal = "SELECT 	p.idpersonal, pn.numerodoc, pn.nombre,  pn.apepat, pn.apemat, ";

		public static final String listarPeriodoMesDescuentoAnterior = "SELECT DISTINCT pd.int_periodo_desc, pd.int_mes_desc FROM sernanp.t_personal_descuento pd;";
		
		
		public static final String listarPeriodoDescuento = "SELECT DISTINCT (SELECT EXTRACT (YEAR FROM dte_fecha)) AS int_periodo_desc "+
				"FROM sernanp.t_personal_asistencia ORDER BY 1 DESC ";
		
		public static final String listarMesDescuento = "SELECT DISTINCT (SELECT EXTRACT (MONTH FROM dte_fecha)) AS int_mes_desc "+				
				"FROM sernanp.t_personal_asistencia ORDER BY 1 ";
		
		
		public static final String listapersonanaturalxdocid = "SELECT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersona " +
				"FROM sernanp.personanatural pn " +
				"INNER JOIN  sernanp.persona p ON  pn.idpersona = p.idpersona ";

		
		public static final String listaapesencontrados = "SELECT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc FROM sernanp.personanatural pn " +
				"INNER JOIN  sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural "+
				"ORDER BY pn.apepat ASC";
		

		public static final String obentermarcacionesxtrabajador = "SELECT pm.hor_hor_marc, pm.dte_fec_marc, pn.nombre, pn.apepat, pn.apemat " +
				"FROM sernanp.t_personal_marcacion pm " +
				"INNER JOIN sernanp.personal p ON p.idpersonal = pm.idpersonal "+
				"INNER JOIN sernanp.personanatural pn ON pn.idpersonanatural = p.idpersonanatural "+		
				"WHERE pn.numerodoc =  ? and "+
				"pm.dte_fec_marc = ? "+
				"ORDER BY pm.hor_hor_marc ASC";	
		

		public static final String listarpersonal= "SELECT pn.idpersonanatural, pn.numerodoc, ps.idpersonal " +
				"FROM sernanp.personanatural pn " +				
				"INNER JOIN sernanp.personal ps ON pn.idpersonanatural = ps.idpersonanatural ";
		
		public static final String listarpersonalcontratoxid = "SELECT pn.nombre, pn.apepat, pn.apemat, pn.idtipodocumento, pn.numerodoc, pn.idsexo, " +
				"p.idpersona, ps.idpersonal, tpc.dte_fec_inicio " +
				"FROM sernanp.personanatural pn " +
				"INNER JOIN sernanp.persona p ON pn.idpersona = p.idpersona " +
				"INNER JOIN sernanp.personal ps ON pn.idpersonanatural = ps.idpersonanatural " +
				"INNER JOIN sernanp.t_personal_contrato tpc ON ps.idpersonal = tpc.idpersonal ";
		
		public static final String listacontratosxid ="SELECT 	COUNT(pc.srl_id_contrato) AS ncontratos, MAX(pc.dte_fec_inicio) as fechmax " +
				"FROM sernanp.t_personal_contrato pc " +
				"WHERE pc.idpersonal = ?"; 
		
		//Se remplazo por listacontratosxid ---- Hay que eliminarlo
		public static final String verificaultimafecha = "SELECT COUNT(*) FROM " +
				"(SELECT MAX(pc.dte_fec_inicio) as fechmax FROM sernanp.t_personal_contrato pc "+
				"WHERE pc.idpersonal = ? ) t " +
				"WHERE fechmax < ? ";
		
		public static final String verificaPersonanaturalexcelBD = "SELECT COUNT(*) " +
				"FROM sernanp.personanatural pn " +
				"WHERE pn.idpersonanatural = ? AND " +
				"pn.numerodoc =  ? ";
		
		
		
		public static final String insertarpersona  = "INSERT INTO sernanp.persona(idpersona) " +
				"SELECT nextval('sernanp.persona_idpersona_seq') " +
				"RETURNING idpersona";
		
		public static final String insertarpersonanatural = "INSERT INTO sernanp.personanatural(idpersonanatural, idpersona, nombre, apepat, apemat, " +
				"idtipodocumento, numerodoc, fechanacimiento, ruc, direccion) " +
				"SELECT nextval('sernanp.personanatural_idpersonanatural_seq'), :idpersona, :nombre, :apepat, :apemat, :idtipodocumento, " +
				":numerodoc, :fechanacimiento, :ruc, :direccion " +
				"RETURNING idpersonanatural";
		
		public static final String insertarpersonal = "INSERT INTO sernanp.personal(idpersonal, idpersonanatural, int_estado, srl_id_asis_turno, int_flag ) " +
				"SELECT nextval('sernanp.personal_idpersonal_seq'), :idpersonanatural, :estado, :srl_id_asis_turno, :int_flag " +
				"RETURNING idpersonal";
		
		public static final String insertarpersonalcontrato = "INSERT INTO sernanp.t_personal_contrato(srl_id_contrato, num_sueldo, idpersonal, dte_fec_inicio, int_id_tab_tip, srl_id_cargo) " +
				"SELECT nextval('sernanp.t_personal_contrato_srl_id_contrato_seq'), :num_sueldo, :idpersonal, :dte_fec_inicio, 1 ,5";	
		
		
		public static final String actualizarPersonalEstado= "UPDATE sernanp.personal "+
				"SET int_estado 		= :estado, "+
				"int_flag		 		= :int_flag "+
//				"srl_id_asis_turno 		= :srl_id_asis_turno "+
			 	"WHERE idpersonal 		= :idpersonal";
		
		
		public static final String insertarPersonalMarcacion = "INSERT INTO sernanp.t_personal_marcacion "+
				"(srl_id_pers_marc, dte_fec_marc, hor_hor_marc, idpersonal, tsp_fec_crea, int_id_usu_crea, tsp_fec_mod, " +
				"int_id_usu_mod, idtablatipo, srl_id_per_activ, var_descripcion, int_flag, srl_id_desp ) " +
				"SELECT nextval('sernanp.t_personal_marcacion_srl_id_pers_marc_seq'), :dte_fec_marc, :hor_hor_marc, :idpersonal, :tsp_fec_crea, :int_id_usu_crea, " +
				":tsp_fec_mod, :int_id_usu_mod, :idtablatipo, :srl_id_per_activ, :var_descripcion, :int_flag, :idpapeleta ";
		
		
		
		public static final String UpdateAsistencia = "UPDATE sernanp.t_personal_asistencia ";
		
		
		public static final String actualizarPersonalMarcacion = "UPDATE sernanp.t_personal_marcacion " +
				"SET hor_hor_marc 		= :hor_hor_marc," +
				"tsp_fec_mod 			= :tsp_fec_mod, " +
				"int_id_usu_mod 		= :int_id_usu_mod, " +
				"srl_id_per_activ 		= :srl_id_per_activ, " +
				"var_descripcion 		= :var_descripcion " +
				"WHERE srl_id_pers_marc = :srl_id_pers_marc ";	
		
		
		public static final String actualizarPapeleta = "UPDATE sernanp.t_personal_desplazamiento SET " +
				"hor_hor_sal_desp 		= :hor_hor_sal_desp," +
				"hor_hor_ret_desp 		= :hor_hor_ret_desp, " +				
				"srl_id_per_activ 		= :srl_id_per_activ, " +
				"var_lug_desp 			= :var_lug_desp " +
				"WHERE srl_id_desp 		= :srl_id_desp ";	
		
		

		
		
		/*public static final String actualizarPersonalMarcacion = "INSERT INTO sernanp.t_personal_marcacion "+
				"(srl_id_pers_marc, dte_fec_marc, hor_hor_marc, idpersonal, tsp_fec_crea, int_id_usu_crea, tsp_fec_mod, " +
				"int_id_usu_mod, idtablatipo, srl_id_per_activ, var_descripcion ) " +
				"SELECT nextval('sernanp.t_personal_marcacion_srl_id_pers_marc_seq'), :dte_fec_marc, :hor_hor_marc, :idpersonal, :tsp_fec_crea, :int_id_usu_crea, " +
				":tsp_fec_mod, :int_id_usu_mod, :idtablatipo, :srl_id_per_activ, :var_descripcion ";*/
		
		public static final String listarTipoMarcacion=
				"SELECT t.* " +
				" FROM sernanp.tablatipo t " +				
				"where 1 = 1 ";
		
		public static final String listMotivoMarcacionJustificaInasistenciaCGH=
				"SELECT t.*  " +
				"FROM sernanp.t_personal_actividad t " +				
				"WHERE t.int_estado_utiliz = 0 AND t.srl_id_per_activ NOT IN (4, 5, 26) ";
		
		public static final String listMotivoMarcacionJustificaInasistenciaCGH_SGH=
				"SELECT t.*  " +
				"FROM sernanp.t_personal_actividad t " +			
				"WHERE t.srl_id_per_activ NOT BETWEEN 6 AND 12 AND t.srl_id_per_activ != 28";
		
		
		public static final String listMotivoPapeleta=
				"SELECT t.* " +
				"FROM sernanp.t_personal_actividad t " +				
				"WHERE t.srl_id_per_activ < 6 AND  t.srl_id_per_activ > 12";
		
		
		public static final String personalPermisoComisionExiste = "SELECT count(pp.idpersonal)||''|| ("+
				"SELECT count(pd.idpersonal) as PermisoComision "+
				"FROM  sernanp.t_personal_desplazamiento pd ";
		
		
		public static final String personalPermisoExiste = "SELECT count(pp.idpersonal) "+
				"FROM sernanp.t_personal_permiso pp ";

		
		
		public static final String insertarPersonalComision = "INSERT INTO sernanp.t_personal_desplazamiento "+
				"(srl_id_desp, dte_fec_sal_desp, hor_hor_sal_desp, dte_fec_ret_desp, hor_hor_ret_desp, var_lug_desp, "+
				"tsp_fec_sys_crea, int_usu_crea, idpersonal, srl_id_per_activ) "+
				"SELECT nextval ('sernanp.t_personal_desplazamiento_srl_id_desp_seq'), :dte_fec_sal_desp, :hor_hor_sal_desp, "+
				":dte_fec_ret_desp, :hor_hor_ret_desp, :var_lug_desp, :tsp_fec_sys_crea, "+
				":int_usu_crea, :idpersonal, :srl_id_per_activ";
		
		
		
		public static final String insertarPersonalPermiso = "INSERT INTO sernanp.t_personal_permiso "+
				"(srl_id_pers_perm, dte_fec_pers_perm_sal, hor_hor_salida, dte_fec_pers_perm_ret, "+ 
				"hor_hor_retorno, var_desc_pers_perm, idtablatipo, int_estado, "+ 
				"tsp_fec_sys_crea, int_id_usu_crea, tsp_fec_sys_anul, int_id_usu_anul, idpersonal, srl_id_per_activ) "+
				"SELECT nextval ('sernanp.t_personal_permiso_srl_id_pers_perm_seq'), :dte_fec_pers_perm_sal, :hor_hor_salida, "+ 
				":dte_fec_pers_perm_ret, :hor_hor_retorno, :var_desc_pers_perm, :idtablatipo, :int_estado, "+ 
				":tsp_fec_sys_crea, :int_id_usu_crea, :tsp_fec_sys_anul, :int_id_usu_anul, :idpersonal, :srl_id_per_activ";	
		

		public static final String insertarPapeleta = "INSERT INTO sernanp.t_personal_desplazamiento "+
				"(srl_id_desp, dte_fec_sal_desp, hor_hor_sal_desp, dte_fec_ret_desp, hor_hor_ret_desp, var_lug_desp, "+
				"tsp_fec_sys_crea, int_usu_crea, idpersonal, srl_id_per_activ) "+
				"SELECT nextval ('sernanp.t_personal_desplazamiento_srl_id_desp_seq'), :dte_fec_sal_desp, :hor_hor_sal_desp, "+
				":dte_fec_ret_desp, :hor_hor_ret_desp, :var_lug_desp, :tsp_fec_sys_crea, "+
				":int_usu_crea, :idpersonal, :srl_id_per_activ " + 
				"RETURNING srl_id_desp";
		
		
		public static final String listapapeletaxidP = "SELECT pd.srl_id_desp, pd.idpersonal, pa.*, pd.var_lug_desp, pd.dte_fec_sal_desp,   pd.dte_fec_ret_desp, pd.hor_hor_sal_desp,  pd.hor_hor_ret_desp "+
				"FROM sernanp.t_personal_desplazamiento pd "+
				"INNER JOIN sernanp.t_personal_actividad pa ON pd.srl_id_per_activ = pa.srl_id_per_activ "+
				"WHERE pd.idpersonal = ? AND (SELECT EXTRACT (YEAR FROM dte_fec_sal_desp)) >= ? "+
				"ORDER BY pd.dte_fec_sal_desp DESC, pd.hor_hor_sal_desp ASC ";
		
		
		public static final String papeletaxid = "SELECT  pd.*, pa.* "+
				"FROM  sernanp.t_personal_desplazamiento pd "+
				"INNER JOIN sernanp.t_personal_actividad pa ON pa.srl_id_per_activ = pd.srl_id_per_activ " +
				"WHERE pd.srl_id_desp = ? ";
		//05-06-2014: D.V.R
		/*---------------------VACACIONES-------------------------*/
		
		public static final String listapersonalVacaciones = "SELECT DISTINCT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal, pc.dte_fec_inicio "+
				",pv.int_periodo_vac, pv.int_dias_vac_goce, pv.int_dias_vac_corresponde - pv.int_dias_vac_goce AS pendientes ";
				
		/*public static final String listapersonalVacacionesProyecto = "SELECT DISTINCT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal, pc.dte_fec_inicio, pc.dte_fec_termino, pc.dte_fec_cese " +
				", pv.int_periodo_vac, pv.dte_fec_inicio_programacion_vac, pv.int_dias_vac_corresponde,  pv.int_dias_vac_goce,   pv.int_dias_vac_truncas  ";*/
		public static final String listapersonalVacacionesProyecto = "SELECT DISTINCT pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal, "+
				//"( SELECT pc.dte_fec_inicio	FROM sernanp.t_personal_contrato pc	WHERE pc.idpersonal = p.idpersonal	ORDER BY 1 DESC	LIMIT 1	)AS dte_fec_inicio, "+
				//"( SELECT pc.dte_fec_cese	FROM sernanp.t_personal_contrato pc	WHERE pc.idpersonal = p.idpersonal AND pc.int_est_contrato = 1	ORDER BY 1 DESC	LIMIT 1	)AS dte_fec_cese, " +
				"pv.int_periodo_vac, pv.dte_fec_inicio_programacion_vac, pv.int_dias_vac_corresponde,  pv.int_dias_vac_goce,   pv.int_dias_vac_truncas,  " + 
				"COALESCE(( "+
						"SELECT pcx.dte_fec_inicio FROM sernanp.t_personal_contrato pcx WHERE pcx.idpersonal = p.idpersonal AND pcx.srl_id_contrato = pv.srl_id_contrato), "+
							"MAX(pc.dte_fec_inicio)) AS dte_fec_inicio, "+ 
						"COALESCE(("+
						"SELECT pcx.dte_fec_cese FROM sernanp.t_personal_contrato pcx WHERE pcx.idpersonal = p.idpersonal AND pcx.srl_id_contrato = pv.srl_id_contrato), "+
							"MAX(pc.dte_fec_cese)) AS dte_fec_cese "; 
				
				//"MAX(pc.dte_fec_inicio) AS dte_fec_inicio, MAX(pc.dte_fec_cese) AS dte_fec_cese ";
		
		public static final String listaVacacionesxidpersonal = "SELECT pvg.*, pv.* FROM sernanp.t_personal_vacaciones pv "+
				"LEFT JOIN sernanp.t_personal_goce_vacaciones pvg ON pv.srl_id_pers_vac = pvg.id_pers_vac ";
		
//		public static final String tieneVacacionesAutorizadas = "SELECT pv.* FROM sernanp.t_personal_vacaciones pv ";
		//ADD 06-05-2015 - DVR
		public static final String tieneVacacionesAutorizadas = "SELECT pv.srl_id_pers_vac, pv. int_periodo_vac, pv.dte_fec_inicio_programacion_vac, pv.int_est_vacaciones, pv.tsp_fec_sys_crea, pv.tsp_fec_sys_mod, pv.int_dias_vac_corresponde " +
				",COALESCE((SELECT SUM(pvg.int_dias_goce_vac) FROM sernanp.t_personal_goce_vacaciones pvg WHERE pvg.id_pers_vac = pv.srl_id_pers_vac GROUP BY pvg.id_pers_vac),0) as int_dias_vac_goce " +
				"FROM sernanp.t_personal_vacaciones pv ";
				
		public static final String insertarVacacionesPersonal = "INSERT INTO sernanp.t_personal_goce_vacaciones "+
				"(srl_id_pers_goce_vac, id_pers_vac, int_dias_goce_vac, dte_fec_inicio_goc_vac, dte_fec_fin_goc_vac, int_estado_goce_vac, tsp_fec_post_goce_vac, var_justificacion_post) "+
				"SELECT nextval ('sernanp.t_personal_goce_vacaciones_srl_id_pers_goce_vac_seq'), :id_pers_vac, :int_dias_goce_vac, :dte_fec_inicio_goc_vac, :dte_fec_fin_goc_vac, :int_estado_goce_vac, :tsp_fec_post_goce_vac, :var_justificacion_post ";
								  
		public static final String obtenerVacacionesProgramadaxid = "SELECT pvg.*, pv.int_dias_vac_goce, pv.srl_id_pers_vac FROM sernanp.t_personal_goce_vacaciones pvg " +
				"INNER JOIN sernanp.t_personal_vacaciones pv ON pv.srl_id_pers_vac = pvg.id_pers_vac AND pvg.srl_id_pers_goce_vac = ? AND pvg.int_estado_goce_vac = 1 ";
		
		public static final String updateGoceVacacionesPersonal = "UPDATE sernanp.t_personal_goce_vacaciones SET ";
		
		public static final String updateVacacionesPersonal = "UPDATE sernanp.t_personal_vacaciones SET ";		
		

		
		
		//08-07-2014: D.V.R
		/*----------------------------LICENCIAS-------------------------*/
		
		public static final String listaLicenciasxidPersonal= "SELECT pl.*, tt.var_des_per_activ "+
				"FROM sernanp.t_personal_licencias pl "+
				"INNER JOIN sernanp.t_personal_actividad tt ON tt.srl_id_per_activ = pl.srl_id_per_activ "+
				"WHERE pl.idpersonal = ? 	ORDER BY 1 ";
				
		public static final String listaTipoLicencia1 = "select t.* " +
				"from sernanp.tablatipo t " +
				"where t.idtabla = ? " ;	
		
		//ADD 31-07-2014: D.V.R
		public static final String listaTipoLicencia = "SELECT pac.* " +
				"FROM sernanp.t_personal_actividad pac "+
//				"WHERE pac.srl_id_per_activ BETWEEN 6 AND 12 ";
				"WHERE pac.int_clase_actividad = 1 ";
		
		public static final String insertarLicenciasPersonal = "INSERT INTO sernanp.t_personal_licencias( "+
			            "srl_id_pers_lic, dte_fec_inicio_lic, dte_fec_fin_lic, int_dias_lic,  int_est_lic, var_num_resol_autoriza_lic, var_descripcion_lic, "+ 
			            "tsp_fec_sys_crea, idpersonal, srl_id_per_activ) "+
						"SELECT nextval ('sernanp.t_personal_licencias_srl_id_pers_lic_seq'), :dte_fec_inicio_lic, :dte_fec_fin_lic, :int_dias_lic, "+
						":int_est_lic, :var_num_resol_autoriza_lic, :var_descripcion_lic, :tsp_fec_sys_crea, :idpersonal,  :srl_id_per_activ";
		
		public static final String updateLicenciasPersonal = "UPDATE sernanp.t_personal_licencias SET ";
		
		public static final String eliminarLicenciasPersonal = "DELETE FROM sernanp.t_personal_licencias WHERE srl_id_pers_lic =  ";
	
		
		
		
		
		
		
		public static final String listarCategoriaANP = "SELECT canp.idcategoriaanp, canp.descategoriaanp "+
				"FROM sernanp.categoriaanp canp "+
				"WHERE canp.estado <> 0 "+
				"ORDER BY 2";
		
		/*----------------REPORTES ---- 16-10-2014---------------*/
		
		public static final String listaInasistenciasRangoFechas = 
				/*"SELECT pa.*, "+ 
				"(SELECT SUM(hor_fuera_horario) FROM sernanp.personal_asistencia WHERE idpersonal = pa.idpersonal GROUP BY idpersonal)::text AS hor_fuera_horario_total " +
				"FROM sernanp.personal_asistencia pa ";*/
		
				"SELECT 	pa.idpersonal, pa.apepat, pa.apemat, pa.nombre, pa.numerodoc, pa.dte_fecha, pa.hor_hor_ingreso, pa.hor_hor_salida, " +
				"pa.tardanza::text AS minutos_tardanza, pa.hor_antes_horario, pa.hor_despues_horario, pa.hor_fuera_horario	 " +
				",(SELECT SUM(tardanza) FROM sernanp.personal_asistencia  " +
				"WHERE idpersonal = pa.idpersonal GROUP BY idpersonal)::text AS minutos_tardanza_total " +
				",(SELECT SUM(hor_antes_horario) FROM sernanp.personal_asistencia  " +
				"WHERE idpersonal = pa.idpersonal GROUP BY idpersonal)::text AS hor_antes_horario_total " + 
				",(SELECT SUM(hor_despues_horario) FROM sernanp.personal_asistencia  " +
				"WHERE idpersonal = pa.idpersonal GROUP BY idpersonal)::text AS hor_despues_horario_total " + 
				",(SELECT SUM(hor_fuera_horario) FROM sernanp.personal_asistencia  " +
				"WHERE idpersonal = pa.idpersonal GROUP BY idpersonal)::text AS hor_fuera_horario_total " + 
				"FROM sernanp.personal_asistencia pa  ";
		
				
				/*"SELECT 	p.idpersonal, pn.apepat, pn.apemat, pn.nombre, pn.numerodoc, " +
				"pa.dte_fecha, pa.hor_hor_ingreso, pa.hor_hor_salida, pa.int_vac_lic " +				
				", CASE WHEN ((EXTRACT (HOUR FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer*60) + " + 
				"(EXTRACT (MINUTE FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer)) > 0 THEN " +
				"((EXTRACT (HOUR FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer*60) + " + 
				"(EXTRACT (MINUTE FROM (pa.hor_hor_ingreso - pt.hor_hor_ingreso)) :: integer)) 	END as tardanza " +
				", CASE WHEN ((EXTRACT (HOUR FROM (pa.hor_hor_salida - pt.hor_hor_salida)) :: integer*60) + " + 
				"(EXTRACT (MINUTE FROM (pa.hor_hor_salida - pt.hor_hor_salida)) :: integer)) > 0 THEN " +
				"((EXTRACT (HOUR FROM (pa.hor_hor_salida - pt.hor_hor_salida)) :: integer*60) + " + 
				"(EXTRACT (MINUTE FROM (pa.hor_hor_salida - pt.hor_hor_salida)) :: integer)) END as excedente "	+
				
				",CASE WHEN pa.hor_hor_ingreso < pt.hor_hor_ingreso THEN pt.hor_hor_ingreso - pa.hor_hor_ingreso END AS hor_antes_horario " +
				",CASE WHEN pa.hor_hor_salida > pt.hor_hor_salida THEN pa.hor_hor_salida - pt.hor_hor_salida END as hor_despues_horario " +	
				",CASE WHEN " + 
				"CASE WHEN pa.hor_hor_ingreso < pt.hor_hor_ingreso THEN pt.hor_hor_ingreso - pa.hor_hor_ingreso	ELSE '00:00:00' END  + " + 
				"CASE WHEN pa.hor_hor_salida > pt.hor_hor_salida THEN pa.hor_hor_salida - pt.hor_hor_salida ELSE '00:00:00' END	 = time '00:00:00' THEN NULL " + 
				"ELSE " +
				"CASE WHEN pa.hor_hor_ingreso < pt.hor_hor_ingreso THEN pt.hor_hor_ingreso - pa.hor_hor_ingreso	ELSE '00:00:00' END  + " + 
				"CASE WHEN pa.hor_hor_salida > pt.hor_hor_salida THEN pa.hor_hor_salida - pt.hor_hor_salida ELSE '00:00:00' END "+		 
				"END AS hor_fuera_horario " +
				
				"FROM sernanp.personanatural pn " ;*/
		
		


		
		public static final String listaPersonalporActividad = "SELECT pvw.*, " +
				"CASE 	WHEN pvw.fecha_fin_papeleta ISNULL THEN pvw.hora_salida_papeleta ::text " +
				"ELSE to_char(pvw.fecha_inicio_papeleta,'dd/MM/yyyy') END AS inicio, " + 
				"CASE	WHEN pvw.fecha_fin_papeleta ISNULL THEN pvw.hora_retorno_papeleta :: text " + 
				"ELSE to_char(pvw.fecha_fin_papeleta,'dd/MM/yyyy') END AS fin "+				
				"FROM sernanp.PERSONAL_PAPELETA_ACTIVIDAD pvw "+
				"INNER JOIN sernanp.personal p ON p.idpersonal = pvw.idpersonal ";
		
		public static final String listarPersonalAsistenciaResumen = "SELECT parv.* " + 
				"FROM sernanp.personal_asistencia_resumen parv ";
		
		
		
		public static final String listarPersonalAsistenciaResumenRecord = "SELECT minutostardanza, permisoparticulardias, permisocongocedias, comisionlocaldias, " +  
				"comisionprovinciadias, comisionextranjerodias, inasistencias, vacaciones, licincapacidadtemporaltrabajo, licfallecimientofamiliar, "+ 
				"licpaternidad, liccapacitacionextranjero, liccapacitacionlocal, licenfermedadgravefamiliar, licsingocedehaber, saldovacaciones, fechaingreso, fechanacimiento " +				 
				"FROM sernanp.personal_record_asistencia_resumen parv ";

		
	
		public static final String listarPersonalRecordAsistencias = "SELECT pras.* " + 
				"FROM sernanp.recordpersonalasistencia pras ";
		
		public static final String listadiasnolaborables = "SELECT * FROM sernanp.t_dias_no_laborables ";
		
		
		public static final String periododiasnolaborables = "SELECT DISTINCT (SELECT EXTRACT (YEAR FROM dte_fec_no_laborable))  as periodo " + 
				"FROM sernanp.t_dias_no_laborables ";
		
}
