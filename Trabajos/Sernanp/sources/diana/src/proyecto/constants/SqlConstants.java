package proyecto.constants;

import java.io.Serializable;

public class SqlConstants implements Serializable{

	/**	 *	 */	private static final long serialVersionUID = 1L;
	
	  
	
	

	/*
	public static final String listaProyectoAreaNatural=
		
		"select p.idproyecto," +
		"p.nombreproyecto, " +
		"p.objetivoproyecto,p.areaespecificaproyecto,p.periodoproyecto, " +
		"p.anioinicioproyecto,p.aniofinproyecto,p.idtipoproyecto, " +
		"tp.nombretipoproyecto " +
		" from areanaturalproyecto ap " +
		"left join proyecto p on p.idproyecto=ap.idproyecto " +
		"left join tipoproyecto tp on tp.idtipoproyecto=p.idtipoproyecto " +
		"where 1=1 " ;
	*/
	
	public static final String eliminaProyecto=
		"delete from proyecto " +
		"where idproyecto=?" ;
	
	public static final String insertaTipoCambio=
		"insert into " +
		"tipocambio(tipocambio,fecha," +
		"idmoneda,idmoneda1)" +
		"values(?,?,?,?)";
	
	public static final String insertaTipoProyecto=
		"insert into " +
		"tipoproyecto(nombretipoproyecto)" +
		"values(?)";

	
	public static final String insertaPersona=
		"insert into " +
		"persona(direccion,telefono," +
		"email,idpais)" +
		"values(?,?,?,?)";
	
	
	public static final String insertaPersona1=
		"insert into " +
		"persona(direccion,telefono," +
		"email,idpais)" +
		"values(:direccion,:telefono,:email,:pais)";
	
	public static final String insertaEjecutor=
		"insert into " +
		"ejecutor(idpersonajuridica)" +
		"values(?)";
	
	public static final String insertaFuenteFinanciamiento=
		"insert into " +
		"fuentefinanciamiento(idpersonajuridica)" +
		"values(?)";
	
	public static final String insertaPersonaJuridica=
		"insert into " +
		"personajuridica(idpersona,nombrepersonajuridica," +
		"siglas,ruc)" +
		"values(?,?,?,?)";
	
	
	
	public static final String listaEditorial=
		"select e.*," +
		"pj.siglas,pj.nombrepersonajuridica " +
		" from editorial e " +
		"left join personajuridica pj on pj.idpersonajuridica=e.idpersonajuridica " +
		"where 1=1 " ;
	
	
	public static final String listaPais=
		"select p.* " +
		"from sernanp.pais p " +
		"where 1=1 " ;
	
	
	public static final String listaAutor=
		"select a.*," +
		"pnat.nombre,pnat.apepat,pnat.apepat,pnat.apemat " +
		" from autor a " +
		"left join personanatural pnat on pnat.idpersonanatural=a.idpersonanatural " +
		"where 1=1 " ;
	
	
	public static final String listaAutorUnico=
		"select distinct pnat.idpersonanatural, a.*," +
		"pnat.nombre,pnat.apepat,pnat.apepat,pnat.apemat " +
		" from autor a " +
		"left join personanatural pnat on pnat.idpersonanatural=a.idpersonanatural " +
		"where 1=1 " ;
	
	public static final String listaDirectorioArchivoModulo=
		"select da.*,d.* " +
		" from sernanp.directorioarchivomodulo da " +
		"  left join sernanp.directorioarchivo d on d.iddirectorioarchivo=da.iddirectorioarchivo " +
		"where 1=1 " ;
	
	public static final String listaDocumentoLogoAreaNatural=
		"select dla.*,d.* " +
		" from sernanp.documentologoareanatural dla " +
		"  left join sernanp.documento d on d.iddocumento=dla.iddocumento " +
		"where 1=1 " ;
	
	/*
	public static final String insertaProyecto=
		"insert into " +
		"proyecto(nombreproyecto,objetivoproyecto," +
		"areaespecificaproyecto,observacionproyecto,compromisoproyecto," +
		"idtipoproyecto,idcategoriaproyecto,idestadoproyecto,idmoneda," +
		"fechainicioproyecto,fechafinproyecto,idproyectogrupo) " +
		"values(?,?,?,?,?,?,?,?,?,?,?,?)";
	*/
	
	public static final String insertaNoDuplicadoUsuario=
		"select sernanp.insertar_no_duplicado_usuario(:usuario,md5(:clave),:estado," +
	":idarea,:idrol,:idpersonal)";
	
	
	
	public static final String insertaNoDuplicadoPersonaJuridica=
		"select sernanp.insertar_no_duplicado_personajuridica(:nombre,:razonsocial,:siglas,:ruc,:direccion" +
		",:telefono,:idpais,:idubigeo,:correopersonal,:correoinstitucional)";
	
	public static final String insertaOperadorTurismo=
		"select sernanp.insertar_operador_turismo(:nombre,:razonsocial,:siglas," +
	":ruc,:direccion,:telefono,:idpais,:idubigeo,:idusuario,:correopersonal,:correoinstitucional,:flagregistro)";
	
	public static final String insertaNoDuplicadoGuiaFichaTurismo=
		"select sernanp.insertar_no_duplicado_guiafichaturismo(:idguia,:idfichaturismo)";
		
	public static final String insertaNoDuplicadoGuia=
		"select sernanp.insertar_no_duplicado_guia(:idpersonanatural,:codigoguia,:flagguia)";
	
	public static final String insertaNoDuplicadoOperadorturismo=
		"select sernanp.insertar_no_duplicado_operadorturismo(:idpersonajuridica,:flagregistro,:username,md5(:clave),:idrol)";
	
	public static final String insertaNoDuplicadoTipoTurismoFichaTurismo=
		"select sernanp.insertar_no_duplicado_tipoturismofichaturismo(:idtipoturismo,:idfichaturismo)";
	
	
	
	public static final String insertaNoDuplicadoTurismoOperadorTurismo=
		"select sernanp.insertar_no_duplicado_turismooperadorturismo(:idturismo,:idoperadorturismo)";
	
	public static final String insertaNoDuplicadoTurismoGuia=
		"select sernanp.insertar_no_duplicado_turismoguia(:idturismo,:idguia)";
	
	public static final String insertaNoDuplicadoActividadTurismoFichaTurismo=
		"select sernanp.insertar_no_duplicado_actividadturismofichaturismo(:idactividadturismo,:idfichaturismo)";

	public static final String insertaNoDuplicadoVisitanteConceptoExoneracionPago=
		"select sernanp.insertar_no_duplicado_visitanteconcepto(:idvisitante,:idconceptoexoneracionpago)";
	
	
	
	public static final String insertaProyectoAreanatural=
		"insert into " +
		"areanaturalproyecto(idareaNatural," +
		"idproyecto) " +
		"values(?,?)";
	
	public static final String insertaProyectoEjecutor=
		"insert into " +
		"proyectoejecutor(idproyecto," +
		"idejecutor,idtipoejecutor) " +
		"values(?,?,?)";
	
	public static final String insertaProyectoFteFto=
		"insert into " +
		"proyectoftefto(idproyecto," +
		"idftefto,monto,idmoneda,idtipocambio) " +
		"values(?,?,?,?,?)";
	
	
	
	public static final String contarProyecto=
		"select count(*) as total from  " +
		"(select pr.* ,  " +
		" case when  curdate()<=fechafinproyecto then 1 " +
        " when curdate()>fechafinproyecto then 2 else 3 end  as flagvigencia  " +
        "  from proyecto  pr ) as p where 1=1 "  ; 
	
	
	public static final String contarRecursoInformacion=
		"select count(*) as total from recursoinformacion ri " +
		"  where 1=1 "  ; 
	
	
	public static final String contarUsuarioUnico=
		"select count(*) as total from sernanp.usuario u " +
		"  where 1=1 "  ; 
	
	public static final String contarRucUnicoPersona=
		"select count(*) as total from sernanp.persona per " +
		"  where 1=1 "  ; 
	
	public static final String contarNumeroDocumentoUnicoPersonaNatural=
		"select count(*) as total from sernanp.personanatural pnat " +
		"  where 1=1 "  ; 
	
	public static final String contarTurismoGuiaUnico=
		"select count(*) as total from sernanp.turismoguia tg " +
		"  where 1=1 "  ; 
	
	public static final String contarFichaTurismo=
		"select count(*) as total from sernanp.fichaturismo ft " +
		"  where 1=1 "  ; 
	
	public static final String contarOperadorTurismo=
		"select count(*) as total from sernanp.operadorturismo ot " +
		"left join sernanp.personajuridica pj on pj.idpersonajuridica=ot.idpersonajuridica " +
		"left join sernanp.persona per on per.idpersona=pj.idpersona " +
		" left join sernanp.ubigeo ubig on ubig.idubigeo=per.idubigeo " +
		"left join sernanp.usuario usu on usu.idusuario=ot.idusuario " +
		"  where 1=1 "  ; 
	
	public static final String contarPagoBanco=
		"select count(*) as total from sernanp.pagobanco pb " +
		"  where 1=1 "  ; 
	
	public static final String contarGuiaTurismo=
		"select count(*) as total from sernanp.guia g " +
		"left join sernanp.personanatural pnat on pnat.idpersonanatural=g.idpersonanatural " +
		"left join sernanp.persona per on per.idpersona=pnat.idpersona " +
		" left join sernanp.ubigeo ubig on ubig.idubigeo=per.idubigeo " +
		"  where 1=1 "  ;
	
	public static final String contarRutaTurismo=
		"select count(*) as total from sernanp.rutaturismo rt " +
		"  where 1=1 "  ; 
		
	/*
	 public static final String listaProyecto=
			
			"select * from " +
			"(select  pr.idproyecto," +
			"pr.nombreproyecto, " +
			"pr.objetivoproyecto,pr.areaespecificaproyecto," +
			"period_diff(  date_format( fechafinproyecto, '%Y%m' ), "+  
            "date_format( fechainicioproyecto , '%Y%m')  )  " +
            "as periodoproyecto," +
            " case when  curdate()<=fechafinproyecto then 1 " +
            "  when curdate()>fechafinproyecto then 2 else 3 end  as flagvigencia ," +
			//",p.periodoproyecto, " +
			"pr.fechainicioproyecto,pr.fechafinproyecto,pr.idtipoproyecto," +
			"pr.observacionproyecto,pr.compromisoproyecto, pr.idmoneda," +
			"tp.nombretipoproyecto " +
			" from proyecto pr " +
			"left join tipoproyecto tp on tp.idtipoproyecto=pr.idtipoproyecto " +
			" ) as p " +
			"where 1=1 " ;
	*/
	 
	
	
	public static final String listaMinimoFichaTurismo=
	" select ft.*,estf.* from sernanp.fichaturismo ft " +
	" left join sernanp.tablatipo estf on estf.idtablatipo=ft.idestadoficha " +
    " where 1=1 ";
	
	
	public static final String listaFichaTurismo=
		"SELECT ft.*, " +  
			"pjo.nombrepersonajuridica as nombreoperador," + 
			"pje.nombrepersonajuridica as nombreempresa," +
			"rt.nombrerutaturismo," +
			"estft.destablatipo as desestft,estft.codinttablatipo as codintestft," +
			//"modpg.destablatipo as desmodpg,modpg.codinttablatipo as codintmodpg," +
			//"estpb.destablatipo as desestpb,estpb.codinttablatipo as codintestpb," +
			//"estpb.mensajetablatipo as msgestpb," +
			" TRUNC(  (CAST (bol.valorboletaje as numeric)  ) ,  2  )*ftbol.cantidad  AS montoboletajeadicional," +
			" ftbol.cantidad as cantadic  " +  
		"FROM sernanp.fichaturismo ft " +
			"LEFT JOIN sernanp.operadorturismo ot ON ot.idoperadorturismo = ft.idoperadorturismo " +
			"LEFT JOIN sernanp.personajuridica pjo ON pjo.idpersonajuridica = ot.idpersonajuridica " +
			"LEFT JOIN sernanp.operadorturismo et ON et.idoperadorturismo = ft.idempresaturismo " +
			"LEFT JOIN sernanp.personajuridica pje ON pje.idpersonajuridica = et.idpersonajuridica " +
			"INNER JOIN sernanp.rutaturismo rt ON rt.idrutaturismo = ft.idrutaturismo " +
			"LEFT JOIN sernanp.tablatipo estft ON estft.idtablatipo = ft.idestadoficha " +
			//"LEFT JOIN sernanp.tablatipo modpg ON modpg.idtablatipo = ft.idmodalidadpago " +
			//"LEFT JOIN sernanp.pagobanco pb ON pb.codigoficha = ft.codigoficha " +
			//"LEFT JOIN sernanp.tablatipo estpb ON estpb.idtablatipo = ft.idestadopago " +
			"left join sernanp.fichaturismoboletaje ftbol on ftbol.idfichaturismo=ft.idfichaturismo " +
			"left join sernanp.boletaje bol on bol.idboletaje=ftbol.idboletaje  " +
		"WHERE 1=1 ";
	
	public static final String listaProyecto=
		
		"select * from " +
		"(select  pr.*," +
		"period_diff(  date_format( fechafinproyecto, '%Y%m' ), "+  
        "date_format( fechainicioproyecto , '%Y%m')  )  " +
        "as periodoproyecto," +
        " case when  curdate()<=fechafinproyecto then 1 " +
        "  when curdate()>fechafinproyecto then 2 else 3 end  as flagvigencia ," +
		"tp.nombretipoproyecto, cp.nombrecategoriaproyecto,mon.nombremoneda,mon.simbolomoneda," +
		" ep.descripcionestadoproyecto  " +
		" from proyecto pr " +
		"left join tipoproyecto tp on tp.idtipoproyecto=pr.idtipoproyecto " +
		"left join categoriaproyecto cp on cp.idcategoriaproyecto=pr.idcategoriaproyecto " +
		"left join estadoproyecto ep on ep.idestadoproyecto=pr.idestadoproyecto " +
		"left join moneda mon on mon.idmoneda=pr.idmoneda " +
		" ) as p " +
		"where 1=1 " ;
	
	
	public static final String listaAreaNatural=
		"select a.*,cat.*,a.estado as estadoarea,cat.estado as estadocat " +
		"from sernanp.areanatural a " +
		"left join sernanp.categoriaanp cat on cat.idcategoriaanp=a.idcategoriaanp " +
		"where 1=1 " ;
	/*
	public static final String listaAreaNatural=
		"select a.*," +
		"cat.descategoriaanp,cat.codcategoriaanp," +
		"cat.descategoriaanp,cat.estado as estadocatanp," +
		"cat.siglascategoriaanp  " +
		" from areanatural a " +
		"left join categoriaanp cat on cat.idcategoriaanp=a.idcategoriaanp " +
		"where 1=1 " ;
	*/ 
	
	public static final String listaRolModulo=
			"select rm.*,m.*,r.* " +
			" from sernanp.rolmodulo rm " + 
			" left join sernanp.rol r on r.idrol=rm.idrol " + //Agregado 13-05-2012
			" left join sernanp.modulo m on m.idmodulo=rm.idmodulo " +
			"where 1=1 " ;
	
	//Agregado 26-04-2013 (J.M.)
	public static final String listaUsuarioRol=
			"select ur.*,u.*,r.* " +
			" from sernanp.usuariorol ur " + 
			" left join sernanp.rol r on r.idrol=ur.idrol " + 
			" left join sernanp.usuario u on u.idusuario=ur.idusuario " +
			"where 1=1 " ;
	
	public static final String listaLogo=
		"select l.*,dar.*,tip " +
		" from sernanp.logo l " +
		" left join sernanp.directorioarchivo dar on dar.iddirectorioarchivo=l.iddirectorioarchivo " +
		" left join sernanp.tablatipo tip on tip.idtablatipo=l.idtipologo " +
		"where 1=1 " ;
	
	 public static final String listaTurismo=
			"select t.*, " +
			"an.* ," +
			"cat.*  " +
			" from sernanp.turismo t " +
			"left join sernanp.areanatural an on an.idareanatural=t.idareanatural " +
			"left join sernanp.categoriaanp cat on cat.idcategoriaanp=an.idcategoriaanp " +
			"where 1=1 " ;
	 

	// JCEV 17-07-2012, actualizado 02-08-2012, 06-08-2012
		 public static final String listaTurismoControlPagos =
				 "SELECT "                                           +
				 "b.idtpagos as idpago, "                            +
				 "b.codtpago as codpago, "                           +
			     "CASE WHEN b.tipodocumento = '1' THEN 'D.N.I.'    " +
			     "     WHEN b.tipodocumento = '4' THEN 'RUC'       " +
			     "     WHEN b.tipodocumento = '7' THEN 'PASAPORTE' " +
			     "     ELSE 'OTROS'                      " +
			     "END as tipo,                           " +
			     "b.numerodocumento as numero,           " +
			     "b.registroturista as regturista,       " +
			     "c.descategoriaanp as categoria,        " +
			     "d.desareanatural as anatural,          " +
			     "e.nombrerutaturismo as rturismo,       " +
			     "b.importepago as monto,                " +
			     "e.codrutaturismo as codigo,            " +
			     "to_char(b.fechamovimiento, 'dd/MM/yyyy') as fmov, " +
				 "b.fechamovimiento as freg " + 
				 "FROM                                         " +
				 "   sernanp.turismopagos as b,                " +
				 "   sernanp.categoriaanp as c,                " +
				 "   sernanp.areanatural as d,                 " +
				 "   sernanp.rutaturismo as e                  " + 
		 		 "WHERE " +
		 		 "TRIM(b.codcategoriaanp) = TRIM(c.codcategoriaanp) and " +
		 		 "TRIM(b.codareanatural) = TRIM(d.codareanatural) and " +
		 		 "TRIM(b.codrutaturismo) = TRIM(e.codrutaturismo) ";
		 
		 // JCEV 07-08-2012
		 public static final String listaDetalleBoletaje =
				 "SELECT "            +
				 "c.idboletaje as BOLETAJE,   " +
				 "d.nombreboletaje as NOMBRE, " +
				 "d.serieboletaje as SERIE,  " +
				 "d.valorboletaje as VALOR,  " +
				 "b.idfichaturismo, " +
				 "b.codigoficha,    " +
				 "a.importepago,    " +
				 "to_char(a.fechamovimiento, 'dd/MM/yyyy'), " + 
				 "c.idvisitante, " + 
				 "c.nombre,    " +
				 "c.apepat,    " +
				 "c.apemat,    " +
				 "c.numerodoc, " +
				 "to_char(c.fechanacimiento, 'dd/MM/yyyy'), " +
				 "c.direccion,  " +
				 "c.telefono    " +
				 "FROM                          " +
				 "   sernanp.turismopagos as a, " +
				 "   sernanp.fichaturismo as b, " +
				 "   sernanp.visitante as c,    " +
				 "   sernanp.boletaje as d      " +
		 		 "WHERE ";	 
	 
	 
	 public static final String listaEstadoProyecto=
			"select ep.* " +
			" from estadoproyecto ep " +
			"where 1=1 " ;
	 
	 
	 
	 public static final String listaTipo=
			"select t.* " +
			" from sernanp.tablatipo t " +
			"where 1=1 " ;
	 
	 public static final String listaTipoTurismo=
			"select t.* " +
			" from sernanp.tipoturismo t " +
			"where 1=1 " ;
	 
	 public static final String listaConceptoExoneracionPago=
			"select cexp.* " +
			" from sernanp.conceptoexoneracionpago cexp " +
			"where 1=1 " ;
	 
	 public static final String listaTipoturismoxRutaturismo=
			"select tt.*,rttipotur,* " +
			" from sernanp.rutaturismotipoturismo rttipotur " +
			" left join sernanp.tipoturismo tt on tt.idtipoturismo=rttipotur.idtipoturismo " +
			"where 1=1 " ;
	 
	 
	 public static final String listaTipoDocumentoIdentidad=
			"select tdi.* " +
			" from tipodocumento tdi " +
			"where 1=1 " ;
	 
	 public static final String listaTipoRecursoInformacion=
			"select tr.* " +
			" from tiporecursoinformacion tr " +
			"where 1=1 " ;
	 
	 public static final String listaMedioRecursoInformacion=
			"select mr.* " +
			" from mediorecursoinformacion mr " +
			"where 1=1 " ;
	 
	 public static final String listaTematicaRecursoInformacion=
			"select tmr.* " +
			" from tematicarecursoinformacion tmr " +
			"where 1=1 " ;
	 
	 public static final String listaArchivo=
			"select a.*,dir.* " +
			" from sernanp.archivo a " +
			" left join sernanp.directorioarchivo dir on dir.iddirectorioarchivo=a.iddirectorioarchivo " +
			"where 1=1 " ;
	 
	
	 
	 public static final String listaIdioma=
			"select i.* " +
			" from idioma i " +
			"where 1=1 " ;
	 
	 public static final String listaTema=
			"select t.* " +
			" from tema t " +
			"where 1=1 " ;
	 
	 /*
	 public static final String loginOperador=
			"select ot.* " +
			" from sernanp.operadorturismo ot " +
			"where 1=1 " ;
	 */
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
	 
	 
	 
	 public static final String listaAprobacionRecursoInformacion=
			"select apri.*,ao.desarea,pnat.* " +
			" from aprobacionrecursoinformacion apri " +
			" left join areaorganica ao on ao.idarea=apri.idarea " +
			" left join personal per on per.idpersonal=apri.idpersonal " +
			" left join personanatural pnat on pnat.idpersonanatural=per.idpersonanatural " +
			"where 1=1 " ;
	 
	 
	 public static final String obtenerNumeroDisponible=
	 		" select if ( (" +
	 		"select r1.numerorecursoinfo +1 as inicio " +
	 		"from recursoinformacion as r1 " +
	 		"left outer join recursoinformacion as r2 on r2.numerorecursoinfo=r1.numerorecursoinfo+1 " +
	 		"where  r2.numerorecursoinfo is null " +
	 		"limit 0,1 ) is null " +
	 		" ,1," +
	 		"(select r1.numerorecursoinfo +1 as inicio " +
	 		"from recursoinformacion as r1 " +
	 		"left outer join recursoinformacion as r2 on r2.numerorecursoinfo=r1.numerorecursoinfo+1 " +
	 		"where r2.numerorecursoinfo is null " +
	 		"limit 0,1 ))";
	 
	 
	 public static final String obtenerMontoCalculadoFichaxId=
		 " select sum(b.valorboletaje) as monto " +
		 " from sernanp.visitante v " +
		 " left join sernanp.boletaje b on b.idboletaje=v.idboletaje" +
		 " where  v.flagregistro=1" ;	
		 
	 public static final String obtenerNumeroCorrelativoxFecha=
			"select max(numfecha) " +
			" from sernanp.fichaturismo ft " +
			"where 1=1 " ;
		 
	 public static final String obtenerNumeroCorrelativoxAreaNatural=
			"select max(numarea) " +
			" from sernanp.fichaturismo ft " +
			"where 1=1 " ;
	 
	 
	 public static final String listaBoletaje=
			"select b.* " +
			" from sernanp.boletaje b " +
			"where 1=1 " ;
		 
	 public static final String listaBoletajexFicha=
		    " select * from ( select  v.idboletaje from sernanp.visitante v   "+
			" where 1=1 ";

	 
	 public static final String listaParametro=
		    " select * from sernanp.parametro "+
			" where 1=1 ";
	 
	 public static final String listaOperadorTurismo=
			"select ot.*,pj.*,per.*,per.ruc as rucp,usu.*,ubig.* " +
			" from sernanp.operadorturismo ot " +
			"left join sernanp.personajuridica pj on pj.idpersonajuridica=ot.idpersonajuridica " +
			"left join sernanp.persona per on per.idpersona=pj.idpersona " +
			" left join sernanp.ubigeo ubig on ubig.idubigeo=per.idubigeo " +
			"left join sernanp.usuario usu on usu.idusuario=ot.idusuario " +
			"where 1=1 " ;
	 
	 public static final String listaGuiaTurismo=
		 "select g.*,pnat.*,per.*,ubig.*," +
		 "tipdoc.destablatipo as destipdoc,tipdoc.abrtablatipo as abrtipdoc,tipdoc.codinttablatipo as codinttipdoc," +
		 "tipgen.destablatipo as destipgen,tipgen.abrtablatipo as abrtipgen,tipgen.codinttablatipo as codinttipgen " +
		 " from sernanp.guia g " +
		 " left join sernanp.personanatural pnat on pnat.idpersonanatural=g.idpersonanatural " +
		 " left join sernanp.persona per on per.idpersona=pnat.idpersona " +
		 " left join sernanp.ubigeo ubig on ubig.idubigeo=per.idubigeo " +
		 " left join sernanp.tablatipo tipdoc on tipdoc.idtablatipo=pnat.idtipodocumento " +
		 " left join sernanp.tablatipo tipgen on tipgen.idtablatipo=pnat.idsexo " +
		 "  where 1=1 "  ;
		
	 
	 
	 public static final String listaOperadorTurismoxAreaNatural=
		    "select ot.*,pj.*,per.*,per.ruc as rucp,usu.* " +  
		    "from sernanp.operadorturismo ot " +  
		    "left join sernanp.personajuridica pj on pj.idpersonajuridica=ot.idpersonajuridica " +
		    "left join sernanp.persona per on per.idpersona=pj.idpersona " +
		    "left join sernanp.turismooperadorturismo tot ON tot.idoperadorturismo = ot.idoperadorturismo " +
		    "left join sernanp.turismo t ON t.idturismo = tot.idturismo    " + 
		    "left join sernanp.areanatural an ON an.idareanatural  = t.idareanatural " +
		    "left join sernanp.usuario usu on usu.idusuario=ot.idusuario " + 	
		    "where 1=1 " ;
	 
	 
	 public static final String listaActividadTurismo=
			"select at.* " +
			" from sernanp.actividadturismo at " +
			" where 1=1 " ;
	 
	 public static final String listaActividadTurismoxFicha=
			"select atft.*,at.* " +
			" from sernanp.actividadturismofichaturismo atft " +
			" left join sernanp.actividadturismo at on at.idactividadturismo=atft.idactividadturismo " +
			" where 1=1 " ;
	 
	 
	 public static final String listaPagoBancoxOperadorturismo=
			"select pb.* " +
			" from sernanp.pagobanco pb " +
			" where codigoficha in (select codigoficha from sernanp.fichaturismo where idoperadorturismo= " ;
	 
	 
	 public static final String listaPagoBancoDisponiblexOperadorturismo=
			"select pb.* " +
			" from sernanp.pagobanco pb " +
			" where importe<>saldo and ( " +
			" codigoficha=' ";
			//"codigoficha in (select codigoficha from sernanp.fichaturismo where idoperadorturismo= " ;
	 
	 public static final String listaPagoBanco=
			"select pb.* " +
			" from sernanp.pagobanco pb " +
			" where 1=1 " ;
	 
	 public static final String listaPagoBancoxIdPagoFicha=
			"select pb.* " +
			" from sernanp.pagobanco pb " +
			" where codigoficha in( select codigoficha from sernanp.pagofichaturismo where idpagofichaturismo=" ;
	 
	 public static final String listaRecursoInformacion=
			"select ri.*,idm.* "+
		//"idm.nombreidioma,tmr.nombretematicarecursoinformacion,tr.nombretiporecursoinformacion," +
			"mr.nombremediorecursoinformacion," +
			"an.desareanatural,an.siglasareanatural " +
			" from recursoinformacion ri " +
			"left join idioma idm on idm.ididioma=ri.ididioma " +
			"left join tematicarecursoinformacion tmr on tmr.idtematicarecursoinformacion=ri.idtematicarecursoinformacion " +
			"left join tiporecursoinformacion tr on tr.idtiporecursoinformacion=ri.idtiporecursoinformacion " +
			"left join mediorecursoinformacion mr on mr.idmediorecursoinformacion=ri.idmediorecursoinformacion " +
			"left join areanatural an on an.idareanatural=ri.idareanatural " +
			"where 1=1 " ;
	 
	 
	 
	 public static final String listaRecursoInformacionEditorial=
			"select rie.*,pj.* " +
			" from recursoinformacioneditorial rie " +
			" left join editorial e on e.ideditorial=rie.ideditorial " +
			" left join personajuridica pj on pj.idpersonajuridica=e.idpersonajuridica " +
			"where 1=1 " ;
	 
	 
	 public static final String listaHistorialFichaTurismoAccion=
			"select hft.*, " +
			" taf.*,usu.usuario  " +
			" from sernanp.histfichaturismoaccion hft " +
			" left join sernanp.tablatipo taf on taf.idtablatipo=hft.idtipoaccionficha " +
			" left join sernanp.usuario usu on usu.idusuario=hft.idusuario " +
			"where 1=1 " ;
	 
	 public static final String listaGuiaFichaTurismo=
			"select gft.*,g.*,pnat.* " +
			" from sernanp.guiafichaturismo gft " +
			" left join sernanp.guia g on g.idguia=gft.idguia " +
			" left join sernanp.personanatural pnat on pnat.idpersonanatural=g.idpersonanatural " +
			"where 1=1 " ;
	 
	 public static final String listaTipoturismoFichaTurismo=
			"select tipft.*,tiptur.*  " +
			" from sernanp.tipoturismofichaturismo tipft " +
			" left join sernanp.tipoturismo tiptur on tiptur.idtipoturismo=tipft.idtipoturismo " +
			"where 1=1 " ;
	 
	 public static final String listaRecursoInformacionArchivo=
			"select riarch.*," +
			"a.nombreinicialarchivo, a.nombregeneradoarchivo " +
			" from recursoinformacionarchivo riarch " +
			" left join archivo a on a.idarchivo=riarch.idarchivo " +
			"where 1=1 " ;
	 
	 public static final String listaRecursoInformacionAutor=
			"select ria.*,pnat.* " +
			" from recursoinformacionautor ria " +
			" left join autor a on a.idautor=ria.idautor " +
			" left join personanatural pnat on pnat.idpersonanatural=a.idpersonanatural " +
			"where 1=1 " ;
	
	 public static final String listaRecursoInformacionTema=
			"select rit.*,tem.nombretema " +
			" from temarecursoinformacion rit " +
			" left join tema tem on tem.idtema=rit.idtema " +
			"where 1=1 " ;
	 
	 public static final String listaRecursoInformacionAreaNatural=
			"select rian.idrecursoinformacionareanatural,rian.idrecursoinformacion," +
			"an.* ,cat.descategoriaanp,cat.siglascategoriaanp " +
			" from recursoinformacionareanatural rian " +
			" left join areanatural an on an.idareanatural=rian.idareanatural " +
			" left join categoriaanp cat on cat.idcategoriaanp=an.idcategoriaanp " +
			"where 1=1 " ;
	 
	 public static final String listaUsuarioArea=
			"select u.*," +
			"ao.idareanatural " +
			" from usuario u " +
			"left join areaorganica ao on ao.idarea=u.idArea " +
			"left join areanatural an on an.idareanatural=an.idareanatural " +
			"where 1=1 " ;
	 
	 
	 public static final String listaVisitante=
			"select v.*," +
			"ft.*, vcep.*, cep.*, "  +     
			" ps.*, "+ 
			"td.*,td.destablatipo as nomtipodocumento,td.abrtablatipo as abrtipodocumento," +
			"tocup.destablatipo as nomtocup,tocup.abrtablatipo as abrtocup, tocup.codinttablatipo as codinttocup," +
			"tmvis.destablatipo as nomtmvis,tmvis.abrtablatipo as abrtmvis, tmvis.codinttablatipo as codinttmvis," +
			" sx.*,sx.destablatipo as nomsexo,sx.abrtablatipo as abrsexo,  " +
			" b.*,"   +       
			"  TRUNC(  (CAST (b.valorboletaje as numeric)  ) ,  2  )  AS valorboletaje " +
			" from sernanp.visitante v " +
			"left join sernanp.boletaje b on b.idboletaje = v.idboletaje "+
			"left join sernanp.pais ps on ps.idpais = v.idpais " +
			"left join sernanp.tablatipo td on td.idtablatipo = v.idtipodocumento "+
			"left join sernanp.tablatipo sx on sx.idtablatipo = v.idsexo "+
			"left join sernanp.tablatipo tocup on tocup.idtablatipo = v.idtipoocupacion "+
			"left join sernanp.tablatipo tmvis on tmvis.idtablatipo = v.idmotivovisita "+
			"left join sernanp.fichaturismo ft on ft.idfichaturismo = v.idfichaturismo "+
			"left join sernanp.visitanteconceptoexoneracionpago vcep on vcep.idvisitante = v.idvisitante "+
			"left join sernanp.conceptoexoneracionpago cep on cep.idconceptoexoneracionpago = vcep.idconceptoexoneracionpago " +
			"where 1=1 " ;
	 
	 
	 public static final String contarTelefono=
			"select count(*) from ( "+
		    "select distinct t.idpersonal " +
			//"tf.nombretipotelefono, " +
			//"p.*,pnat.* " +
			" from telefono t " +
			"left join tipotelefono tf on tf.idtipotelefono=t.idtipotelefono " +
			"left join personal p on p.idpersonal=t.idpersonal " +
			"left join personanatural pnat on pnat.idpersonanatural=p.idpersonanatural " +
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
	 
	 
	 public static final String listaPagoFichaTurismo=
			"select pft.*,modpag.*  from sernanp.pagofichaturismo pft " +
			" left join sernanp.tablatipo modpag on modpag.idtablatipo=pft.idmodalidadpago  " +
			" where 1=1 " ;
	 
	 public static final String listaGuiaUnico=
			"select distinct g.idguia," +
			"pnat.* " +
			" from sernanp.guia g " +
			"left join sernanp.personanatural pnat on pnat.idpersonanatural=g.idpersonanatural " +
			"where 1=1 " ;
	 

	//---------	 
	 
	 public static final String listaPersonaUnicoxAreaNatural=
			"select pr.*,'' as fechaingreso " +
			" from sernanp.personalregistro pr " +
			"where 1=1 " ;
	 
	 public static final String listaPersonaNaturalxID=
				"select pnat.* " +
				" from sernanp.personanatural pnat " +
				"where 1=1 " ;
	 
	 
	 public static final String listaPersonalRegistroxPJyAN=
				"select pr.*,'' as fechaingreso " +
				" from sernanp.personalregistro pr " +
				"where 1=1 " ;
	 
	 public static final String listaPersonalRegistroxDoc=
				"select pr.idtipodocumento, pr.numerodocumento " +
				" from sernanp.personalregistro pr " +
				"where 1=1 " ;
	 
	 public static final String listaPersonalRegistroxTipoIdDoc=
				"select count(1) " +
				" from sernanp.personalregistro ";
	 
	 public static final String listaPersonalRegistroxFicha=
				"select pr.*, pfr.* " +
				" from sernanp.personalregistro pr " +
				"inner join sernanp.personalficharegistro pfr on pr.idpersonalregistro = pfr.idpersonalregistro ";
	 
	 public static final String listaPersonalFichaRegistroxFicha=
				"select pfr.* " +
				" from sernanp.personalficharegistro pfr ";
	 
	 public static final String listaPersonalRegistroxID=
				"select pr.*, '' as fechaingreso " +
				" from sernanp.personalregistro pr ";
	 
	 public static final String listaPersonalRegistroxFRxID=
				"select count(*) " +
				" from sernanp.personalficharegistro "; 
	 	 
	//----
	 

	 public static final String listaGuiaUnicoxAreaNatural=
				"select distinct g.idguia," +
				"pnat.* " +
				" from sernanp.turismoguia tg " +
				"left join sernanp.turismo t on t.idturismo=tg.idturismo " +
				"left join sernanp.guia g on g.idguia=tg.idguia " +
				"left join sernanp.personanatural pnat on pnat.idpersonanatural=g.idpersonanatural " +
				"where 1=1 " ;
	 
 
	 
	 public static final String listaGuiaUnicoxOperadorTurismo=
			"select distinct g.idguia,got.*, " +
			"pnat.* " +
			" from  sernanp.guia g " +
			" left join sernanp.guiaoperadorturismo got on  got.idguia=g.idguia " +
			" left join sernanp.personanatural pnat on pnat.idpersonanatural=g.idpersonanatural " +
			"where 1=1 " ;
	 
	 
	 public static final String listaAreaNaturalxOperadorTurismo=
			"select an.*,cat.*,cat.estado as estadocat,tot.* " +
			" from sernanp.turismooperadorturismo tot " +
			"left join sernanp.operadorturismo ot on ot.idoperadorturismo=tot.idoperadorturismo " +
			"left join sernanp.turismo t on t.idturismo=tot.idturismo " +
			"left join sernanp.areanatural an on an.idareanatural=t.idareanatural " +
			"left join sernanp.categoriaanp cat on cat.idcategoriaanp=an.idcategoriaanp " +
			"where 1=1 " ;
	 
	 
	 public static final String listaAreaNaturalxGuiaTurismo=
			"select an.*,cat.*,cat.estado as estadocat,tg.* " +
			" from sernanp.turismoguia tg " +
			//"left join sernanp.operadorturismo ot on ot.idoperadorturismo=tot.idoperadorturismo " +
			"left join sernanp.turismo t on t.idturismo=tg.idturismo " +
			"left join sernanp.areanatural an on an.idareanatural=t.idareanatural " +
			"left join sernanp.categoriaanp cat on cat.idcategoriaanp=an.idcategoriaanp " +
			"where 1=1 " ;
	 
	 public static final String insertaProyectoArchivo=
			"insert into archivoproyecto(idarchivo,idproyecto)" +
			"values(:idarchivo,:idproyecto)" ;
	 
	 
	 public static final String insertaActividadFichaturismo=
			"insert into sernanp.actividadturismofichaturismo(idactividadturismo,idfichaturismo) " +
			"values(:idactividadturismo,:idfichaturismo)";
	 
	 
	 public static final String insertaGuiaFichaturismo=
			"insert into sernanp.guiafichaturismo(idguia,idfichaturismo) " +
			"values(:idguia,:idfichaturismo)";
	 
	 
	 public static final String insertaHistFichaturismoAccion=
		 "insert into sernanp.histfichaturismoaccion(idhistfichaturismoaccion,idfichaturismo," +
		 "idtipoaccionficha,fecha,idusuario)" +
		" select nextval('sernanp.histfichaturismoaccion_seq'),:idfichaturismo,:idtipoaccionficha," +
		" :fecha,:idusuario  " +
		" RETURNING  idhistfichaturismoaccion ";
	 
	 public static final String insertaTipoturismoFichaturismo=
			"insert into sernanp.tipoturismofichaturismo(idtipoturismo,idfichaturismo) " +
			"values(:idtipoturismo,:idfichaturismo)";
	 
	 
	 public static final String insertaTurismoOperadorTurismo=
			"insert into sernanp.turismooperadorturismo(idturismo,idoperadorturismo) " +
			"values(:idturismo,:idoperadorturismo)";
	 
	 public static final String insertaTurismoGuia=
			"insert into sernanp.turismoguia(idturismo,idguia) " +
			"values(:idturismo,:idguia)";
	 
	 public static final String insertaVisitanteConceptoexoneracionpago=
			"insert into sernanp.visitanteconceptoexoneracionpago(idvisitante,idconceptoexoneracionpago) " +
			"values(:idvisitante,:idconceptoexoneracionpago)";
	 
	 
	 public static final String insertaFichaturismoBoletaje=
			"insert into sernanp.fichaturismoboletaje(idfichaturismo,idboletaje,cantidad) " +
			"values(:idfichaturismo,:idboletaje,:cantidad)";
	 
	 public static final String insertaPersonal=
			"insert into personal(idpersonanatural,idarea,idcargo," +
			"mailpersonal )" +
			"values(:idpersonanatural,:idarea,:idcargo," +
			":mailpersonal ) ";
	 
	 public static final String insertaTelefono=
			"insert into telefono(numerotelefono,idtipotelefono,idpersonal," +
			"principaltelefono )" +
			"values(:numerotelefono,:idtipotelefono,:idpersonal," +
			":principaltelefono ) ";
	 
	 
	 
	 
	 public static final String insertaRecursoInformacionArchivo=
			"insert into recursoinformacionarchivo(idrecursoinformacion,idarchivo," +
			"tipoarchivo)" +
			"values(:idrecursoinformacion,:idarchivo,:tipoarchivo)";
			
	 
	 public static final String insertaTema=
			"insert into tema(nombretema)" +
			"values(:nombretema)";
	 
	 public static final String insertaAutor=
			"insert into autor(idpersonanatural)" +
			"values(:idpersonanatural)";
	 
	 public static final String insertaEditorial=
			"insert into editorial(idpersonajuridica)" +
			"values(:idpersonajuridica)";
	 
	 
	 public static final String insertaRecursoInformacionAutor=
			"insert into recursoinformacionautor(idrecursoinformacion,idautor)" +
			"values(:idrecursoinformacion,:idautor)";
	 
	 public static final String insertaRecursoInformacionEditorial=
			"insert into recursoinformacioneditorial(idrecursoinformacion,ideditorial)" +
			"values(:idrecursoinformacion,:ideditorial)";
	 
	 public static final String insertaRecursoInformacionTema=
			"insert into temarecursoinformacion(idrecursoinformacion,idtema)" +
			"values(:idrecursoinformacion,:idtema)";
	 
	 public static final String insertaRecursoInformacionAreaNatural=
			"insert into recursoinformacionareanatural(idrecursoinformacion,idareanatural)" +
			"values(:idrecursoinformacion,:idareanatural)";
	 
	 
	 
	 public static final String insertaUsuario=
			"insert into sernanp.usuario(usuario,clave," +
			"estado,idarea,idrol,idpersonal)"+
			" VALUES(:usuario,md5(:clave)," +
			" :estado,:idarea,:idrol,:idpersonal) "+
			" RETURNING  idusuario ";
	 
	 public static final String insertaPagoFichaTurismo=
			"insert into sernanp.pagofichaturismo(idpagofichaturismo,idfichaturismo,numvoucher," +
			"monto,idmodalidadpago,idpagobanco)"+
			" select nextval('sernanp.pagofichaturismo_idpagofichaturismo_seq'),:idfichaturismo,:numvoucher," +
			" :monto,:idmodalidadpago,:idpagobanco "+
			" RETURNING  idpagofichaturismo ";
	 
	 public static final String insertaFichaTurismo=
			"insert into sernanp.fichaturismo(idfichaturismo,idareanatural,idrutaturismo," +
			"fechaingreso,fecharegistro,idoperadorturismo,idempresaturismo,fechapropuesta," +
			"codigoficha,flagregistro,idtiporolcreacion,idestadoficha) " +
			" select nextval('sernanp.fichaturismo_idfichaturismo_seq'),:idareanatural,:idrutaturismo," +
			":fechaingreso,:fecharegistro,:idoperadorturismo,:idempresaturismo,:fechapropuesta," +
			":codigoficha,:flagregistro,:idtiporolcreacion,:idestadoficha " +
			" RETURNING  idfichaturismo ";
	 
	 public static final String insertaRecursoInformacion=
			"insert into recursoinformacion(codigorecursoinformacion,titulo,isbn," +
			"codigosgd,descripcionrecursoinformacion,fecharegistro,aniopublicacion," +
			"ididioma,idtematicarecursoinformacion,idtiporecursoinformacion,idmediorecursoinformacion," +
			"idareanatural, numeropaginas,flagtemporal,flagrecursoinformacion," +
			"numerorecursoinfo,numerorecursoinfoarea)" +
			"values(:codigorecursoinformacion,:titulo,:isbn," +
			":codigosgd,:descripcionrecursoinformacion,:fecharegistro,:aniopublicacion, "+
	        ":ididioma,:idtematicarecursoinformacion,:idtiporecursoinformacion,:idmediorecursoinformacion," +
	        ":idareanatural,:numeropaginas,:flagtemporal,:flagrecursoinformacion," +
	        ":numerorecursoinformacion,:numerorecursoinformacionarea)";
	 
	 
	 public static final String insertaAprobacionRecursoInformacion=
			"insert into aprobacionrecursoinformacion(idrecursoinformacion,idpersonal," +
			"idarea,fechaaprobacion)"+
			"values(:idrecursoinformacion,:idpersonal," +
			":idarea,:fechaaprobacion)";
	 
	 
	 
	 public static final String eliminaAprobacionRecursoInformacion=
			"delete  from " +
			" aprobacionrecursoinformacion where idrecursoinformacion=:idrecursoinformacion ";
	 
	 public static final String eliminaVisitanteConceptoexoneracionpago=
			"delete  from " +
			" sernanp.visitanteconceptoexoneracionpago where idvisitante=:idvisitante ";
	 
	 public static final String eliminaVisitanteConceptoexoneracionpagoxFicha=
			"delete  from " +
			" sernanp.visitanteconceptoexoneracionpago vc " +
			" where idvisitante in (" +
			" select idvisitante from sernanp.visitante " +
			" where idfichaturismo=:idfichaturismo )" ;
			
	 
	 public static final String insertaArchivo=
			"insert into archivo(nombreinicialarchivo,nombregeneradoarchivo,fechauploadarchivo," +
			"descripcionarchivo,idUsuario,idarchivopadre )" +
			"values(:nombreinicial,:nombregenerado,:fechaupload," +
			":descripcion,:idUsuario,:idarchivopadre ) ";
	 
	 public static final String insertaPersonaNatural=
			"insert into personanatural(idpersona,nombre,apepat," +
			"apemat,numerodoc,sexo,idtipodocumento )" +
			"values(:idpersona,:nombre,:apepat," +
			":apemat,:numerodoc,:sexo,:idtipodocumento ) ";
	 
	 
	 public static final String insertaProyecto=
			"insert into proyecto(nombreproyecto,siglasproyecto,objetivoproyecto,areaespecificaproyecto," +
			"fechainicioproyecto,fechafinproyecto,observacionproyecto,compromisoproyecto,idestadoproyecto," +
			"codigoproyecto,idmoneda,idproyectogrupo,idcategoriaproyecto,flagproyecto,idtipoproyecto,componenteproyecto," +
			"nivelproyecto )" +
			"values(:nombreproyecto,:siglasproyecto,:objetivoproyecto,:areaespecificaproyecto," +
			":fechainicioproyecto,:fechafinproyecto,:observacionproyecto,:compromisoproyecto,:idestadoproyecto," +
			":codigoproyecto,:idmoneda,:idproyectogrupo,:idcategoriaproyecto,:flagproyecto,:idtipoproyecto,:componenteproyecto," +
			":nivelproyecto )";
	 
	 
	 public static final String insertaNoDuplicadoArchivo=
			"insert into archivo(idarchivo,nombreinicialarchivo,nombregeneradoarchivo,fechauploadarchivo," +
			"descripcionarchivo,idUsuario,idarchivopadre )" +
			"values";
	 
	 
	 public static final String listaProyectoArchivo=
			"select ap.idproyecto, " +
			"ar.*  " +
			" from archivoproyecto ap " +
			"left join archivo ar on ar.idarchivo=ap.idarchivo " +
			"where 1=1 " ;
	 
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
	 
	 public static final String listaEjecutor=
			"select e.idejecutor,e.idpersonajuridica," +
			"pj.siglas,pj.nombrepersonajuridica " +
			" from ejecutor e " +
			"left join personajuridica pj on pj.idpersonajuridica=e.idpersonajuridica " +
			"where 1=1 " ;
	
	 public static final String listaFteFto=
			"select f.idftefto,f.idpersonajuridica," +
			"pj.siglas,pj.nombrepersonajuridica " +
			" from fuentefinanciamiento f " +
			"left join personajuridica pj on pj.idpersonajuridica=f.idpersonajuridica " +
			"where 1=1 " ;
	
	
	 public static final String listaProyectoSubAreaNatural=
			" and p.idproyecto in("+
			"select distinct p.idproyecto " +
			" from areanaturalproyecto p " +
			" where p.idareaNatural in( " +
			" select idareanatural from " +
			" areanatural where 1=1 ";
	 
	 
	 
	 public static final String listaRecursoInformacionSubAreaNatural=
			" and ri.idrecursoinformacion in("+
			"select distinct ri.idrecursoinformacion " +
			" from recursoinformacionareanatural ri " +
			" where ri.idareanatural in( " +
			" select idareanatural from " +
			" areanatural where 1=1 ";
	 
	 /*
	 public static final String listaProyectoSubAreaNatural=
			" and p.idproyecto in("+
			"select p.idproyecto " +
			" from areanaturalproyecto p " +
			" where p.idareaNatural in( ";
	 
	 public static final String listaIdAreanaturalxCategoria=
		  "select a.idareanatural " +
		  "from areanatural a " +
		  "where a.idcategoriaanp=";
	 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /*
     public static final String listaProyectoSubAreaNatural=
		" and p.idproyecto in("+
		"select p.idproyecto " +
		" from areanaturalproyecto p " +
		" where p.idareaNatural=:idareanatural ";
	*/
	 
	 
	 /*
	 public static final String listaIdAreanaturalxCategoria=
		  "select a.idareanatural " +
		  "from areanatural a " +
		  "where a.idcategoriaanp=:idcategoriaanp )";
	 */
	 public static final String listaIdAreanaturalxAreaNatural=
		  " :idareanatural )" ;
		  
    
	 /*
	 public static final String listaProyectoSubEjecutor=
    	" and p.idproyecto in("+
 		"select p.idproyecto " +
 		" from proyectoejecutor p " +
 		" where p.idejecutor= ";
 	*/
	 
	 
	 public static final String listaOperadorSubTurismo=
	    	" and ot.idoperadorturismo in("+
	 		"select idoperadorturismo " +
	 		" from sernanp.turismooperadorturismo tot " +
	 		" where tot.idturismo= ";
	 
	 
	 public static final String listaGuiaSubTurismo=
	    	" and g.idguia in("+
	 		"select idguia " +
	 		" from sernanp.turismoguia tg " +
	 		" where tg.idturismo= ";
	 
	 
	 public static final String listaProyectoSubEjecutorFinanciero=
	    	" and p.idproyecto in("+
	 		"select p.idproyecto " +
	 		" from proyectoejecutor p " +
	 		" where p.idejecutor= ";
	 
	 
	 public static final String listaProyectoSubEjecutorTecnico=
	    	" and p.idproyecto in("+
	 		"select p.idproyecto " +
	 		" from proyectoejecutor p " +
	 		" where p.idejecutor= ";
	 
	 public static final String listaProyectoSubFteFto=
    	 " and p.idproyecto in("+
  		"select idproyecto " +
  		" from proyectoftefto pfto " +
  		" where pfto.idftefto= ";
	 
	 
	 
	 public static final String listaRecursoInformacionSubAutor=
    	 " and ri.idrecursoinformacion in("+
  		"select idrecursoinformacion " +
  		" from recursoinformacionautor ria " +
  		" where ria.idautor= ";
	 
	 
	 public static final String listaProyectoAreanatural=
			"select idareaNatural," +
			"idproyecto  " +
			" from areanaturalproyecto " +
			"where 1=1 " ;
	
	 
	  
	 public static final String listaAreanaturalxProyecto=
			"select " +
			"a.idareaNatural,a.codareanatural,a.desareanatural," +
			"a.siglasareanatural," +
			"a.idcategoriaanp," +
			"c.descategoriaanp,c.idcategoriaanp,c.siglascategoriaanp  " +
			" from areanaturalproyecto pa " +
			"left join areanatural a on a.idareanatural=pa.idareaNatural " +
			"left join categoriaanp c on c.idcategoriaanp=a.idcategoriaanp " +
			"where 1=1 " ;
	 
	 
	 public static final String listaAgrupadoProyectoxAreanatural=
			"select  " +
			"a.idareaNatural,a.desareanatural," +
			"a.codareanatural,a.estado," +
			"a.siglasareanatural,a.idcategoriaanp, " +
			" count(idproyecto) as cantidadproyecto "+
			" from areanaturalproyecto pa " +
			"left join areanatural a on a.idareanatural=pa.idareaNatural " +
			"where 1=1 ";
			
	 public static final String listaCantidadProyectoxAreanatural=
		 "select   pa.idareaNatural,an.desareanatural,"+
		 "sum( if( tab.flagvigencia=1 ,1,null )  )  as cantvigente,"+
		 "sum( if( tab.flagvigencia=2 , 1,null )  )  as cantvencido,"+
		 "sum( if( tab.flagvigencia=3 , 1,null )  )  as cantsindatos,"+
		 "count(pa.idproyecto) as canttotal "+
         " from areanaturalproyecto pa "+
		 "left join ( "+
		 "	 select *, "+
		 "	 case when  curdate()<=proy.fechafinproyecto then 1 "+ 
		 "	     when curdate()>proy.fechafinproyecto then 2 else 3 end  as flagvigencia "+
		 "	 from proyecto proy "+
	 	 ") as tab on tab.idproyecto=pa.idproyecto "+
	 	  "left join areanatural an on an.idareanatural= pa.idareaNatural "+
	 	"	where 1=1 ";
		      
		 
		/*
	 public static final String listaCantidadProyectoxAreanatural=
		 "select * from ("+
		 "select  "+
		 "a.desareanatural,  tab.idareaNatural," +
		 "sum(  if(tab.flagvigencia=1 ,  1  ,   null  ))  as vigentes ," +
		 "sum(  if(tab.flagvigencia=2 ,  1  ,   null  ))  as concluidos ," +
		 "sum(  if(tab.flagvigencia=3 ,  1  ,   null  ))  as sindatos ," +
		 " count(idproyecto ) as total " +
		 "from  (" +
		 "select p.*," +
		 "case when  curdate()<=p.fechafinproyecto then 1 " +
		 "when curdate()>p.fechafinproyecto then 2 else 3 end  as flagvigencia "+ 
		 "from " +
		 " (select pa.idareaNatural,pr.*   " +
		 " from areanaturalproyecto pa  "+
		 " left join proyecto pr on pr.idproyecto=pa.idproyecto where 1=1 ";
		 */
	 
	 
	 
	 
	 
	 
	 
	 
	 public static final String listaMontoProyectoxAreanatural=
	 "select   pa.idareaNatural,an.desareanatural,"+
	"sum( if( tab.flagvigencia=1 , tab.monto,null )  )  as montovigente,"+
	"sum( if( tab.flagvigencia=2 , tab.monto,null )  )  as montovencido,"+
	"sum( if( tab.flagvigencia=3 , tab.monto,null )  )  as montosindatos,"+
	"sum(tab.monto) as montototal "+
    "from areanaturalproyecto pa "+
	"	 left join "+ 
    "(select pr.* ,sum( if( pf.idtipocambio is null, pf.monto,pf.monto*tc.tipocambio )  )  as monto  from "+
    "( select *, "+ 
	"	 case when  curdate()<=proy.fechafinproyecto then 1 "+
	"	     when curdate()>proy.fechafinproyecto then 2 else 3 end  as flagvigencia "+
	"	 from proyecto proy "+
	"	 ) as pr "+
    " left join proyectoftefto pf on pf.idproyecto=pr.idproyecto "+
	"	 left join tipocambio tc on tc.idtipocambio=pf.idtipocambio "+
	"	 group by pr.idproyecto  "+
	"	 order by pr.idproyecto  "+
    "	 ) as tab on tab.idproyecto=pa.idproyecto  " +
    "left join areanatural an on an.idareanatural= pa.idareaNatural "+
	"	where 1=1 ";
	      
	 
	 
	 
	 
	 public static final String listaFteFtoxAreanatural=
		 "select   pf.idftefto,pj.*, "+
		//"sum( if( tab.flagvigencia=1 , pf.monto,null )  )  as montovigente,"+
		//"sum( if( tab.flagvigencia=2 , pf.monto,null )  )  as montovencido,"+
		//"sum( if( tab.flagvigencia=3 , pf.monto,null )  )  as montosindatos,"+
		"  sum( if( pf.idtipocambio is null, pf.monto,pf.monto*tc.tipocambio )  )  as montototal "+
		 //"   if(   ) sum(pf.monto) as montototal "+
	    " from proyectoftefto pf "+
		"	 left join "+ 
	    "(select pr.*   from "+
	    "( select *, "+ 
		"	 case when  curdate()<=proy.fechafinproyecto then 1 "+
		"	     when curdate()>proy.fechafinproyecto then 2 else 3 end  as flagvigencia "+
		"	 from proyecto proy "+
		"	 ) as pr "+
		"	 group by pr.idproyecto  "+
		"	 order by pr.idproyecto  "+
	    "	 ) as tab on tab.idproyecto=pf.idproyecto  " +
	    "	 left join tipocambio tc on tc.idtipocambio=pf.idtipocambio "+
	    "	 left join fuentefinanciamiento fte on fte.idftefto=pf.idftefto "+
	    "	 left join personajuridica pj on pj.idpersonajuridica=fte.idpersonajuridica "+
		"	where 1=1 ";
	 
	
	 
	 public static final String listaFteFtoxAreanatural1=
			"select  pf.idftefto," +
			"p.nombrepersonajuridica,p.siglas,p.idpersonajuridica,p.ruc," +
			"sum(  if(pf.idtipocambio is null ,pf.monto  , pf.monto*tc.tipocambio ))  as montoFuente " +
			
			"from proyectoftefto pf " +
			" left join fuentefinanciamiento f on f.idftefto=pf.idftefto"+
			" left join personajuridica p on p.idpersonajuridica=f.idpersonajuridica "+
			" left join tipocambio tc on tc.idtipocambio=pf.idtipocambio "+
			"where idproyecto in(" +
			"select distinct idproyecto " +
			"from areanaturalproyecto pa " +
			"where idareaNatural in(" +
			"select idareanatural " +
			"from areanatural " +
			"where  1=1  ";
	 
	 
	 
	 
	 
	 
	 
	 public static final String listaCategoriaAnpxRecursoInformacion=
		 "select distinct c.idcategoriaanp, c.descategoriaanp, c.estado," +
		 "c.siglascategoriaanp " +
		 " from recursoinformacionareanatural rian " +
		 " left join areanatural a on a.idareanatural=rian.idareanatural " +
		 " left join categoriaanp c on c.idcategoriaanp=a.idcategoriaanp " +
		 " where 1=1 ";
	 
	 
	 
	 public static final String listaAreaNaturalxRecursoInformacion=
		 "select distinct a.idareanatural,a.desareanatural,a.idcategoriaanp,a.estado,a.idadministracionareanatural," +
		 "a.siglasareanatural,a.codareanatural, a.flagactivoareanatural," +
		 "c.descategoriaanp,c.codcategoriaanp, c.estado as estadocatanp," +
		 "c.siglascategoriaanp " +
		 " from recursoinformacionareanatural rian " +
		 " left join areanatural a on a.idareanatural=rian.idareanatural " +
		 " left join categoriaanp c on c.idcategoriaanp=a.idcategoriaanp " +
		 " where 1=1 "; 
	 
	 
	 
	 
	 
	 public static final String listaAgrupadoProyectoxCategoriaAnp=
		 "select  " +
			"c.*, "+
			" count(idproyecto) as cantidadproyecto "+
			" from areanaturalproyecto pa " +
			"left join areanatural a on a.idareanatural=pa.idareaNatural " +
			"left join categoriaanp c on c.idcategoriaanp=a.idcategoriaanp " +
			"where 1=1 ";
		 
	 public static final String listaEjecutorxProyecto=
			"select " +
			"e.idejecutor," +
			"pe.idproyectoejecutor, pe.idtipoejecutor," +
			"te.nombretipoejecutor," +
			"pj.idpersonajuridica,pj.nombrepersonajuridica," +
			"pj.siglas,pj.ruc " +
			" from proyectoejecutor pe " +
			"left join tipoejecutor te on te.idtipoejecutor=pe.idtipoejecutor "+
			"left join ejecutor e on e.idejecutor=pe.idejecutor " +
			"left join personajuridica pj on pj.idpersonajuridica=e.idpersonajuridica " +
			"where 1=1 " ;		
	 /*
	  * 
	  */
	 /*
	 public static final String listaEjecutorxProyecto=
			"select " +
			"e.idejecutor," +
			"pj.idpersonajuridica,pj.nombrepersonajuridica," +
			"pj.siglas,pj.ruc " +
			" from proyectoejecutor pe " +
			"left join ejecutor e on e.idejecutor=pe.idejecutor " +
			"left join personajuridica pj on pj.idpersonajuridica=e.idpersonajuridica " +
			"where 1=1 " ;
	 */
	 
	 //" left join tipocambio tcamb on tcamb.idmoneda=tab.idmoneda ";
	 
	 
		// "where tcamb.idtipocambio in(240,241) "+
      
		
	 /*
	 public static final String listaMontoProyectoxAreanatural=
		 "select * from ("+
		 "select  "+
		 "a.desareanatural,  tab.idareaNatural," +
		 "sum(  if(tab.flagvigencia=1 ,  tab.montoProyecto*tcamb.tipocambio  ,   null  ))  as montoTotalVigente ," +
		 "sum(  if(tab.flagvigencia=2 ,  tab.montoProyecto*tcamb.tipocambio  ,   null  ))  as montoTotalConcluido ," +
		 "sum(  if(tab.flagvigencia=3 ,  tab.montoProyecto*tcamb.tipocambio  ,   null  ))  as montoTotalSindata ," +
		 "sum(tab.montoProyecto*tcamb.tipocambio) as montoTotal, "+
		 " count(idproyecto ) as total " +
		 "from  (" +
		 "select p.*," +
		 "case when  curdate()<=p.fechafinproyecto then 1 " +
		 "when curdate()>p.fechafinproyecto then 2 else 3 end  as flagvigencia "+ 
		 "from " +
		 " (select pa.idareaNatural,pr.*,sum( pf.monto*tc.tipocambio) as montoProyecto   " +
		 " from areanaturalproyecto pa " +
		 " left join proyecto pr on pr.idproyecto=pa.idproyecto " +
		 " left join proyectoftefto pf on pf.idproyecto=pr.idproyecto " +
		 " left join tipocambio tc on tc.idtipocambio=pf.idtipocambio " +
		 "  group by pr.idproyecto" +
		 ") as p where p.flagproyecto= 1 "+
		 ") as tab "+
		 "left  join areanatural a on  a.idareanatural=tab.idareaNatural "+
		 " left join tipocambio tcamb on tcamb.idmoneda=tab.idmoneda " +
		 "where tcamb.idtipocambio in(240,241) "+
      "group by tab.idareaNatural "+
	     ") as t "+
	     "order by t.montoTotal desc";
	 /*
	  * 
	  */
	 
	 public static final String listaEjecutorxAreanatural=
			"select distinct pe.idejecutor,pe.idtipoejecutor," +
			"te.nombretipoejecutor, " +
			"p.nombrepersonajuridica,p.siglas,p.idpersonajuridica,p.ruc " +
			"from proyectoejecutor pe " +
			" left join ejecutor e on e.idejecutor=pe.idejecutor"+
			" left join tipoejecutor te on te.idtipoejecutor=pe.idtipoejecutor"+
			" left join personajuridica p on p.idpersonajuridica=e.idpersonajuridica "+
			"where idproyecto in(" +
			"select distinct idproyecto " +
			"from areanaturalproyecto pa " +
			"where idareaNatural in(" +
			"select idareanatural " +
			"from areanatural " +
			"where  1=1  " ;
	 /*
	 public static final String listaEjecutorxAreanatural=
			"select distinct pe.idejecutor," +
			"p.nombrepersonajuridica,p.siglas,p.idpersonajuridica,p.ruc " +
			"from proyectoejecutor pe " +
			" left join ejecutor e on e.idejecutor=pe.idejecutor"+
			" left join personajuridica p on p.idpersonajuridica=e.idpersonajuridica "+
			"where idproyecto in(" +
			"select distinct idproyecto " +
			"from areanaturalproyecto pa " +
			"where idareaNatural in(" +
			"select idareanatural " +
			"from areanatural " +
			"where  1=1  " ;
	*/		

	 /*
	 public static final String listaFteFtoxAreanatural=
			"select distinct pf.idftefto," +
			"p.nombrepersonajuridica,p.siglas,p.idpersonajuridica,p.ruc " +
			"from proyectoftefto pf " +
			" left join fuentefinanciamiento f on f.idftefto=pf.idftefto"+
			" left join personajuridica p on p.idpersonajuridica=f.idpersonajuridica "+
			"where idproyecto in(" +
			"select distinct idproyecto " +
			"from areanaturalproyecto pa " +
			"where idareaNatural in(" +
			"select idareanatural " +
			"from areanatural " +
			"where  1=1  " ;
    */
	 
	
			
	 
	 public static final String listaFteFtoxProyecto=
			"select " +
			"f.idftefto," +
			"pf.monto,pf.idtipocambio,pf.idmoneda," +
			"pj.idpersonajuridica,pj.nombrepersonajuridica," +
			"pj.siglas,pj.ruc,m.nombremoneda " +
			" from proyectoftefto pf " +
			"left join fuentefinanciamiento f on f.idftefto=pf.idftefto " +
			"left join personajuridica pj on pj.idpersonajuridica=f.idpersonajuridica " +
			"left join moneda m on m.idmoneda=pf.idmoneda "+
			"where 1=1 " ;
	
	 
	 
	 public static final String listaTipoProyecto=
			"select idtipoproyecto," +
			"nombretipoproyecto  " +
			" from tipoproyecto " +
			"where 1=1 " ;
	 
	 
	 public static final String listaTipoCambio=
		 
		    "  select tabtc.*, " +
		    "  m.nombremoneda,m1.nombremoneda as nombremoneda1 from ( " +
		    "  select  year(tc.fecha) as idanio, month(tc.fecha) as idmes, tc.* " +
		    "  from tipocambio tc )" +
		    "  as tabtc " +
			//"m.nombremoneda ,m1.nombremoneda as nombremoneda1 " +
			//" from tipocambio tc " +
			"left join moneda m on m.idmoneda=tabtc.idmoneda " +
			"left join moneda m1 on m1.idmoneda=tabtc.idmoneda1 " +
			"where 1=1 " ;
	 
	/* 
	 public static final String listaTipoCambio=
			"select tc.idtipocambio," +
			"tc.tipocambio,tc.fecha,tc.idmoneda,tc.idmoneda1," +
			"m.nombremoneda ,m1.nombremoneda as nombremoneda1 " +
			" from tipocambio tc " +
			"left join moneda m on m.idmoneda=tc.idmoneda " +
			"left join moneda m1 on m1.idmoneda=tc.idmoneda1 " +
			"where 1=1 " ;
	 */
	 public static final String listaCategoriaProyecto=
			"select idcategoriaproyecto," +
			"nombrecategoriaproyecto  " +
			" from categoriaproyecto " +
			"where 1=1 " ;
	 
	 public static final String listaTipoMoneda=
			"select idmoneda," +
			"nombremoneda,simbolomoneda  " +
			" from moneda " +
			"where 1=1 " ;
	 
	 public static final String listaUbigeo=
			"select u.* " +
			" from sernanp.ubigeo u " +
			"where 1=1 " ;
	 
	 /*
	  public static final String listaProyectoSubEjecutor=
    	" and p.idproyecto in("+
 		"select p.idproyecto " +
 		" from proyectoejecutor p " +
 		" where p.idejecutor=:idejecutor "; 
	  * */
	 
	 /*
     public static final String listaProyectoSubFteFto=
    	 " and p.idproyecto in("+
  		"select idproyecto " +
  		" from proyectoftefto pfto " +
  		" where pfto.idftefto=:idftefto ";
     */
	
	
	//AGREGADOS PARA INFRACCION	 
		public static final String generaCodigoInfraccion="select max(numeroexpediente)+1 as numeroexpediente" +
		 		" from sernanp.infraccion";
		 
		public static final String verificaReincidencia ="select p.*,i.* from sernanp.personanatural p inner join sernanp.infractor i " +
				"on p.idpersonanatural = i.idpersonanatural " +
				"where p.numerodoc like ";
		
		//public static final String obtieneDirectorio="select * from sernanp.directorioarchivo where iddirectorioarchivo = ";
		
		public static final String obtieneDirectorio="select da.* from sernanp.directorioarchivo da inner join sernanp.directorioarchivomodulo dam on da.iddirectorioarchivo = dam.iddirectorioarchivo where dam.idmodulo = ";
		
		// JCEV 22-08-2012 Actualizado
		public static final String insertaInfractor="select sernanp.insertar_infractor(:nombre, :apepat, :apemat, " +
				                                            ":numerodoc, :idtipodocumento);";
		
		// JCEV 27-08-2012 insertaInfractorJuridico
		public static final String insertaInfractorJuridico = 
				                     "select sernanp.insertar_infractorJuridico(" +
		                             ":razonsocial, :numerodoc, :personJurid)";
		
		public static final String insertarInfraccion="select sernanp.insertar_infraccion(:numeroexpediente,:fechainfraccion," +
				  ":idinfractor ,:descripcion,:fecharesolucion,:numeroresolucion,:sancioninfraccion," +
				  ":multainfraccion::numeric ,:estadomulta,:nombreinicialarchivo,:nombregeneradoarchivo,:mimearchivo)";
		
		public static final String aumentaInfraccion="update sernanp.infractor set faltas = faltas+1 where idinfractor = :idinfractor";

		public static final String listaInfracciones="Select * from sernanp.infraccion order by idinfraccion";
		
		
		// JCEV 18-09-2012
		public static final String listarDetalleExpedienteSancion = 
				                    //"select sernanp.listar_DetalleExpedienteSancion(:idexpediente)";
				 					"select * from sernanp.DetalleExpedienteSancion where idexpediente = ";
		
		public static final String listarExpedienteSancion =
				"SELECT * FROM sernanp.sancion s " +
				"INNER JOIN sernanp.expedientesancion es ON s.idsancion = es.idsancion " +
				"INNER JOIN sernanp.detalleexpedientesancion eds ON es.idexpedientesancion = eds.idexpedientesancion " +
				"WHERE es.idexpediente = ";
		
		// JCEV 05-10-2012 Para el lustado de Infracciones
		 public static final String verificarMorosidadExpediente=
					//"SELECT to_date(to_char(fechanotificacion + 15,'dd/mm/yyyy'),'dd/mm/yyyy') - " +
				    //"       to_date(to_char(now(),'dd/mm/yyyy'),'dd/mm/yyyy') " +
				 	"SELECT CASE WHEN sernanp.difdias(fechanotificacion,CURRENT_DATE) > 15 THEN -1 ELSE 1 END"+
					" as DiffDate " +
					"FROM sernanp.expediente exp " +
					"INNER JOIN sernanp.resolucion ein ON exp.idresolucion = ein.idresolucion " +
					//" and exp.flagmorosidad = '1' " +
					"INNER JOIN sernanp.expedientesancion exps ON exp.idexpediente = exps.idexpediente " +
					"WHERE exps.idsancion = 1 AND exp.idexpediente = ";
			
		// JCEV 11-10-2012 Para el lustado de Infracciones
		 public static final String verificarFlagMorosidadExpediente = "SELECT flagmorosidad " +
																	   "FROM sernanp.expediente " +
																	   "WHERE idexpediente = ";

		 public static final String listaSancion="Select * from sernanp.sancion";
		
		// Actualizado 17-09-2012 12:22pm
		// JCEV Actualizado 18-10-2012
		public static final String insertarResolucion = "Select sernanp.insertar_resolucion(:nombreinicialarchivo,  " +
                ":nombregeneradoarchivo, " +
                ":mimearchivo,           " +
                ":fecharesolucion,       " +
                ":numeroresolucion,      " +
                ":fechanotificacion,     " +
                ":iddirectorioarchivo,   " +
                ":annoresolucion)";
		
		// YCB Actualizado 01-02-2013 17:05pm
		public static final String insertarVoucherPagoInfractor = "Select sernanp.insertar_voucherpagoinfractor(:nombreinicialarchivo,  " +
                ":nombregeneradoarchivo, " +
                ":mimearchivo,           " +                
                ":iddirectorioarchivo)";
		
		// JCEV 17-09-2012 19:43 Actualizado 18-10-2012
		public static final String insertarResolucion_sf="Select sernanp.insertar_resolucion_(:fecharesolucion,    " +
																							  ":numeroresolucion,  " +
																							  ":fechanotificacion, " +
																							  ":annoresolucion)";
		
		public static final String insertarExpedienteInfraccion="select sernanp.insertar_infraccion(:idexpediente,:idinfraccion,:reincidencia)";

		// JCEV 17-09-2012 Antigua  Version, Nueva Version: insertarExpedienteSancion
//		public static final String insertar="select sernanp.insertar_sancion(:idexpediente,:idsancion, :observacion)";

		// JCEV 17-09-2012 Actualizado (Nueva Version)
		public static final String insertarExpedienteSancion =
				"select sernanp.insertar_ExpedienteSancion(:idExpediente, :idSancion, :estado)";

		// JCEV 17-09-2012 20:34 Nuevo, permite ingresar el Registro del detalleexpedientesancion
		public static final String 
					insertarDetalleExpedienteSancion = "select sernanp.insertar_detalleexpedientesancion(:datovariado, " +
							                                                                            ":observacion, " +
							                                                                            ":estado, " +
							                                                                            ":idExpediente, " +
							                                                                            ":idSancion," +
							                                                                            ":idexpsancion)";
	
		
		// JCEV Hay que cambiarlo por la parte de la multa !Ojo!  Antigua Version
		public static final String insertarExpedienteInfractor="select sernanp.insertar_expediente_wi(:idinfractor,:idresolucion,:idmulta,:idareanatural)";
		
		// JCEV 16-09-2012 Version Operativa
        public static final String insertarExpediente = "select sernanp.insertar_expediente(:idResolucion, " +
												        ":idInfractor, :idAreaNatural, :dFecha)";
		
		
//		para verificar el usuario en el sistema
		/*
		public static final String verificaUsuarioEnSistema="select * from sernanp.infractor i inner join sernanp.personanatural pn " +
				"on i.idpersonanatural = pn.idpersonanatural " +
				"where pn.numerodoc=";
		*/
		
        // JCEV 18-09-2012 Nueva Busqueda
		public static final String verificaUsuarioEnSistema = "select * from sernanp.infractor i " +
		                                                      "inner join sernanp.personanatural pn " +
															  "on i.idpersona = pn.idpersona ";

		// JCEV 17-10-2012 Busqueda por solamente Persona Natural
		public static final String verifyNaturalUser = "select * from sernanp.personanatural pn ";
		
        // JCEV 22-08-2012 Version Operativa 17-09-2012 16:25 pm
		public static final String verificaUsuarioEnSistemaJuridico = "SELECT * FROM sernanp.infractor i " +
                "INNER JOIN sernanp.personajuridica pj " +		                                                              
                "ON i.idpersona = pj.idpersona ";	
        
		// JCEV 17-10-2012 Busqueda por solamente Persona Juridica
		public static final String verifiyNotNaturalUser = "SELECT * FROM sernanp.personajuridica pj ";	

		public static final String obtieneInfraccionesAntiguas="select if.*, ei.reincidencia from sernanp.expedienteinfraccion ei ," +
				"sernanp.expediente ex ,sernanp.infractor i, sernanp.infraccion if " +
				"where ei.idexpediente = ex.idexpediente and  ex.idinfractor = i.idinfractor " +
				"and ei.idinfraccion = if.idinfraccion and i.idinfractor =";
		
		// JCEV 19-09-2012 Version Nueva 1709
		public static final String determinaTipoPersona = "select inf.tipopersona " +
																  "from sernanp.expediente exp " +
																  "Inner Join sernanp.infractor inf On exp.idinfractor = inf.idinfractor " + 
																  "where exp.idexpediente = ";
				
		
		// JCEV 19-09-2012 Version Nueva 1709
		public static final String listarExpedientes = "select exp.*, exp.idarchivo as idarchivo_v, inf.*, res.*, res.idarchivo as idarchivo_p, pn.*, pj.*, pj.ruc as elruc, arch.*, dir.*, anx.* " + 
															   "from sernanp.expediente exp " + 
															   "Inner Join sernanp.anpxexpedientexano anx On exp.idexpediente = anx.idexpediente " +
															   "Inner Join sernanp.infractor inf On exp.idinfractor   = inf.idinfractor " + 
															   "Inner Join sernanp.resolucion res On exp.idresolucion = res.idresolucion " +
															   "Inner Join sernanp.areanatural an On exp.idareanatural = an.idareanatural " + //Linea agregada para poder filtrar por categoría de anp
															   "Left Join sernanp.personanatural pn On inf.idpersona = pn.idpersona " +
															   "Left Join sernanp.personajuridica pj On inf.idpersona = pj.idpersona " +
															   "Left Join sernanp.archivo arch On res.idarchivo=arch.idarchivo and arch.flagarchivo = 1 " + 
															   "Left Join sernanp.directorioarchivo dir On arch.iddirectorioarchivo = dir.iddirectorioarchivo " + 
															   "where 1 = 1 ";

		
		// JCEV 19-09-2012 16:37 Version Nueva 
		public static final String listarExpedientesJuridicos = "select * " + 
															   			"from sernanp.expediente exp " + 
																		"Inner Join sernanp.infractor inf On exp.idinfractor    = inf.idinfractor " + 
																		"Inner Join sernanp.resolucion res On exp.idresolucion  = res.idresolucion " + 
																		"Inner Join sernanp.personajuridica pn On inf.idpersona = pn.idpersona " +
																		"Left Join sernanp.archivo arch On res.idarchivo=arch.idarchivo and arch.flagarchivo = 1 " + 
																		"Left Join sernanp.directorioarchivo dir On arch.iddirectorioarchivo = dir.iddirectorioarchivo " + 
																		"where 1 = 1 ";	
		
		public static final String listaInfraccionesXExpediente="select inf.*, ei.reincidencia from sernanp.expedienteinfraccion " +
				"ei inner join sernanp.infraccion inf on ei.idinfraccion = inf.idinfraccion " +
				"where idexpediente=";
		
		// JCEV 18-09-2012 Nueva Version
		public static final String listaSancionesXExpediente="select es.idexpediente, san.idsancion, san.descripcionsancion, es.datovariado, es.observacion from sernanp.detalleexpedientesancion  " +
						"es inner join sernanp.sancion san on es.idsancion = san.idsancion " +				
						"where es.idexpediente=";
		
		// JCEV 19-09-2012 Version Nueva
		public static final String contarExpediente = "select count(*) from sernanp.expediente exp where 1= 1 ";
		
		
		public static final String contarExpedientexNDoc = "select count(*) " +
				"from sernanp.expediente exp " +
				"Inner Join sernanp.infractor inf On exp.idinfractor   = inf.idinfractor " + 
				"Left Join sernanp.personanatural pn On inf.idpersona = pn.idpersona " +
				"Left Join sernanp.personajuridica pj On inf.idpersona = pj.idpersona " +
				"where 1= 1 ";
		
		// JCEV 19-09-2012 Version Nueva
		public static final String contarExpedienteJuridico = "select count(*) " +
				                                              "from sernanp.expediente exp, sernanp.infractor inf, " +
						                                      "sernanp.resolucion res, " +
															  "sernanp.personajuridica pn,sernanp.archivo arch  " +
															  "where exp.idinfractor = inf.idinfractor     and " +
															  "inf.idpersonanatural  = pn.idpersonanatural and " +
															  "res.idarchivo         = arch.idarchivo      and " +
															  "exp.idresolucion      = res.idresolucion";
	
		public static final String actualizaEstadoArchivo = "update sernanp.archivo set flagarchivo = 0 where idarchivo = ";
		
		public static final String insertarArchivo="select sernanp.insertar_archivo(:nombreinicialarchivo,:nombregeneradoarchivo,:mimearchivo,:iddirectorioarchivo)";
		
		//Agregado 26-05-2012 (Y.C.B.)
		
		public static final String listaPersonaJuridica=
				"select cpj.idpersonajuridica, cpj.idpersona, pp.correoinstitucional, pp.telefono,pj.ruc, pj.nombrepersonajuridica " +
				"from sernanp.personajuridica pj " +
				"inner join sernanp.contactopersonajuridica cpj on cpj.idpersonajuridica=pj.idpersonajuridica " +
				"inner join sernanp.persona pp on pp.idpersona=pj.idpersona " +
				"inner join sernanp.persona p on p.idpersona=cpj.idpersona " +
				"where 1=1 " ;
		
		public static final String insertaPersonaRegistro = "INSERT INTO sernanp.personalregistro(idpersonalregistro,nombre,apepat,apemat,idtipodocumento,numerodocumento,intipodoc,idsexo,empresa,idpersonajuridica,idoperadorturismo,idareanatural) " +
				"VALUES((select nextval('sernanp.personalregistro_idpersonalregistro_seq')),:nombre,:apepat,:apemat,:tipodocumento.idtipo,:numerodocumento,:tipolocal.idtipo,:sexo.idtipo,:empresa,:operadorturismo.idpersonajuridica,:operadorturismo.idoperadorturismo,:areanatural.idareanatural)";
				
		public static final String insertaPersonaRegistroForm = "INSERT INTO sernanp.personalregistro(idpersonalregistro,nombre,apepat,apemat,idtipodocumento,numerodocumento,intipodoc,idsexo,empresa,idpersonajuridica,idoperadorturismo,idareanatural) " +
				"VALUES((select nextval('sernanp.personalregistro_idpersonalregistro_seq')),:nombre,:apepat,:apemat,:idtipodocumento,:numerodocumento,:idtipolocal,:idsexo,:empresa,:idpersonajuridica,:idoperadorturismo,:idareanatural)"+

				" RETURNING  idpersonalregistro ";
		
		public static final String actualizarPersonaRegistro = "UPDATE sernanp.personalregistro set nombre=:nombre,apepat=:apepat,apemat=:apemat,idtipodocumento=:tipodocumento.idtipo,numerodocumento=:numerodocumento," +
				"intipodoc=:tipolocal.idtipo,idsexo=:sexo.idtipo,empresa=:empresa ";	
		
		public static final String eliminarPersonaRegistro = "DELETE FROM sernanp.personalregistro ";
		
		public static final String insertaFichaRegistro=
					"insert into sernanp.ficharegistro(idficharegistro,codigoficha,lote,nombreproyecto," +
					"actividad,lugar,idareanatural,idpersonajuridica,idoperadorturismo,fechacreacion,fechaaprobsys, comentario)" +
					
					" select nextval('sernanp.ficharegistro_idficharegistro_seq'),(:codigoficha || (select currval('sernanp.ficharegistro_idficharegistro_seq')) ),:lote,:nombreproyecto," +
					":actividad,:lugar,:idareanatural,:idpersonajuridica,:idoperadorturismo,:fechacreacion,:fechaaprobsys, :comentario " +
					
					" RETURNING  idficharegistro ";
		 
		public static final String actualizaFichaRegistro=
					"update sernanp.ficharegistro set lote=:lote, nombreproyecto = :nombreproyecto, actividad=:actividad,lugar=:lugar,fechacreacion=:fechacreacion,comentario=:comentario ";
		
		public static final String consolidaFichaRegistro=
				"update sernanp.personalficharegistro set horaingreso=:horaingreso, fechasalida=:fechasalida, horasalida=:horasalida, idestado=:idestado " +
				"where idficharegistro=:idficharegistro and idpersonalregistro=:idpersonalregistro";
	
		
		public static final String listarFichasRegistro = "SELECT fr.* FROM sernanp.ficharegistro fr ";
		
		public static final String listarFichasRegistroxAreaNatural = "SELECT fr.*, pj.* FROM sernanp.ficharegistro fr inner join sernanp.personajuridica pj on fr.idpersonajuridica=pj.idpersonajuridica ";
		
		public static final String listaFichaRegistro = "SELECT fr.* FROM sernanp.ficharegistro fr ";
		
		public static final String aprobarFichaRegistro = "UPDATE sernanp.ficharegistro SET idestadoficha = :idestadoficha, nombrearchivo=:nombrearchivo, fechaaprobacion=:fechaaprobacion ";
		
		public static final String aprobarFichaRegistro_ = "UPDATE sernanp.ficharegistro SET idestadoficha = ?, nombrearchivo = ?, fechaaprobacion = ? WHERE idficharegistro = ?";
		
		public static final String desaprobarFichaRegistro = "UPDATE sernanp.ficharegistro SET idestadoficha = :idestadoficha, observacion = :observacion, fechadesaprobacion=:fechadesaprobacion ";
		
		public static final String listaMedioTransporteFicha = "SELECT frt.*, tt.* FROM sernanp.tablatipoficharegistro frt inner join sernanp.tablatipo tt on frt.idtablatipo = tt.idtablatipo ";
		
		public static final String listarJefesAnp = "SELECT hja.idareanatural, p.* FROM sernanp.historialjefesanp hja inner join sernanp.personal p on hja.idpersonal = p.idpersonal ";
		
		//Módulo SGMVEMI - 28/08/12
		public static final String insertLogin = "INSERT INTO sernanp.login (clave, usuario, idsistema, idusuario, fecha) VALUES ";
		
		// JCEV 04-10-2012 
		public static final String cuentaReincidenciaXExpedienteInfraccion = "SELECT Count(ein.idinfraccion) as reincidencia, ein.idinfraccion as nro_infraccion " +
																					 "FROM sernanp.expediente exp " + 
																					 "INNER JOIN sernanp.expedienteinfraccion ein ON exp.idexpediente = ein.idexpediente " +      
																					 "WHERE 1 = 1 and ";
		// JCEV 04-10-2012 
		public static final String actualizaFlagMorosidad = "UPDATE sernanp.expediente";
		
		//YCB 04-02-2013
		public static final String actualizaIdArchivoVoucher = "UPDATE sernanp.expediente";
		
		public static final String estadoFlagMorosidad = "SELECT flagmorosidad " +
		                                                 "FROM sernanp.expediente exp " + 
		                                                 "WHERE exp.idexpediente = ";
		
		// JCEV 21-10-2012 
		public static final String actualizaFlagExpediente = "UPDATE sernanp.expediente " +
													         "SET estadoexpediente = ?, " + 
													         "obsestadoexpediente = ?,  " +
													         "fechaestadoexpediente = now(), idusuario = ? ";
		
		// JCEV 21-10-2012 
		public static final String anularExpediente = "UPDATE FROM sernanp.expediente";
		
}
