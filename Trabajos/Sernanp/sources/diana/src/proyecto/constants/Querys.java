package proyecto.constants;

public interface Querys {
	static String
	
	
		/**COMMONS ***********************************************************/
	
		//LASTID = "SELECT LAST_INSERT_ID();",
	LASTID = "RETURNING ",
		
		/**FICHA *************************************************************/

		FICHA = 
			"SELECT * FROM sernanp.fichaturismo " +
			"WHERE 1=1 ", 
			
		FICHAID =
			"SELECT idfichaturismo FROM sernanp.fichaturismo WHERE 1=1 "
			,

		FICHACOUNT = 
			"SELECT count(*) FROM sernanp.fichaturismo " +
			"WHERE 1=1 "
			,

			
			FICHAFULL = 
				"SELECT f.*,pb.*, " +
				//"codigoficha,idfichaturismo,fecharegistro,flagfichaturismo, " +
					//"fechapropuesta,"+
				   //"TO_CHAR(fechapropuesta, 'y-MM-d') as fechapropuesta , " + 
					//" TO_CHAR(fechaingreso, 'y-MM-d')  as fechaingreso, " +     
					"pjo.nombrepersonajuridica as nombreoperador," + 
					"pje.nombrepersonajuridica as nombreempresa," +
					"rt.nombrerutaturismo," +
					"estpb.destablatipo as desestpb,estpb.codinttablatipo as codintestpb," +
					"estpb.mensajetablatipo as msgestpb  " + 
					//"rt.nombrerutaturismo,tt.nombretipoturismo " +   
					//"(png.nombre ||' ' || png.apepat) as nombreguia,png.nombre as nombreguia," +
					//"png.apepat as apepatguia, png.apemat as apematguia   "  +  
				"FROM sernanp.fichaturismo f " +
					"LEFT JOIN sernanp.operadorturismo ot ON ot.idoperadorturismo = f.idoperadorturismo " +
					"LEFT JOIN sernanp.personajuridica pjo ON pjo.idpersonajuridica = ot.idpersonajuridica " +
					"LEFT JOIN sernanp.operadorturismo et ON et.idoperadorturismo = f.idempresaturismo " +
					"LEFT JOIN sernanp.personajuridica pje ON pje.idpersonajuridica = et.idpersonajuridica " +
					//"LEFT JOIN sernanp.guia g ON g.idguia = f.idguia " +
					//"LEFT JOIN sernanp.personanatural png ON png.idpersonanatural = g.idpersonanatural " +
					"INNER JOIN sernanp.rutaturismo rt ON rt.idrutaturismo = f.idrutaturismo " +
					"LEFT JOIN sernanp.pagobanco pb ON pb.codigoficha = f.codigoficha " +
					"LEFT JOIN sernanp.tablatipo estpb ON estpb.idtablatipo = f.idestadopago " +
					//"LEFT JOIN sernanp.tipoturismo tt ON tt.idtipoturismo = f.idtipoturismo " +
				"WHERE 1=1 "
				,
		/*	
		FICHAFULL = 
			"SELECT codigoficha,idfichaturismo,fecharegistro,flagfichaturismo, " +
				"DATE_FORMAT(fechapropuesta,'%Y-%m-%d') as fechapropuesta , " + 
				"DATE_FORMAT(fechaingreso,'%Y-%m-%d') as fechaingreso, " +     
				"pjo.nombrepersonajuridica as nombreoperador," + 
				"pje.nombrepersonajuridica as nombreempresa," + 
				"rt.nombrerutaturismo,tt.nombretipoturismo," +   
				"CONCAT(png.nombre,' ',png.apepat) nombreguia "  +  
			"FROM sernanp.fichaturismo f " +
				"LEFT JOIN sernanp.operadorturismo ot ON ot.idoperadorturismo = f.idoperadorturismo " +
				"LEFT JOIN sernanp.personajuridica pjo ON pjo.idpersonajuridica = ot.idpersonajuridica " +
				"LEFT JOIN sernanp.operadorturismo et ON et.idoperadorturismo = f.idempresaturismo " +
				"LEFT JOIN sernanp.personajuridica pje ON pje.idpersonajuridica = et.idpersonajuridica " +
				"LEFT JOIN sernanp.guia g ON g.idguia = f.idguia " +
				"LEFT JOIN sernanp.personanatural png ON png.idpersonanatural = g.idpersonanatural " +
				"INNER JOIN sernanp.rutaturismo rt ON rt.idrutaturismo = f.idrutaturismo " +
				"LEFT JOIN sernanp.tipoturismo tt ON tt.idtipoturismo = f.idtipoturismo " +
			"WHERE 1=1 "
			,
*/

				
				
				
				
				
				
				
				
				FICHAINSERT =
				"INSERT INTO sernanp.fichaturismo (idfichaturismo,idareanatural,idrutaturismo," +
					"fechaingreso,fecharegistro,idoperadorturismo,idempresaturismo,fechapropuesta,flagfichaturismo,codigoficha) " +
					"SELECT " +
						" nextval('sernanp.fichaturismo_idfichaturismo_seq'),:idareanatural,:idrutaturismo," +
						":fechaingreso,CURRENT_DATE,:idoperadorturismo,:idempresaturismo,:fechapropuesta,:flagfichaturismo," +
						" TO_CHAR(current_date, 'yyMMdd') || "+
						"lpad(trim(to_char(( "+
						"SELECT "+
						"case "+ 
						"when sum( CASE WHEN f.idfichaturismo!=0 THEN 1 "+
						"            WHEN f.idfichaturismo=0 THEN 0 "+
						 "        END ) "+
						  "   is null then 1 "+  
						"when sum( "+
						 "      CASE WHEN f.idfichaturismo!=0 THEN 1 "+
						  "          WHEN f.idfichaturismo=0 THEN 0 "+
						   "     END "+
						    "   ) is not null then   ( sum( "+
						     "  CASE WHEN f.idfichaturismo!=0 THEN 1 "+
						      "      WHEN f.idfichaturismo=0 THEN 0 "+
						       " END "+
						      " ) +1    ) "+ 
						" end "+
						" FROM sernanp.fichaturismo f "+  
						" where  current_date = f.fecharegistro AND   idrutaturismo = :idrutaturismo "+

						" ),'9999999999999999999')), 4,'0') "+
						 
						" from sernanp.rutaturismo rt "+
                        " where rt.idrutaturismo= :idrutaturismo "+
						" RETURNING  idfichaturismo ",		
				
				
				
				
				
				
				
				
				
//			
//			FICHAINSERT =
//				"INSERT INTO sernanp.fichaturismo (idfichaturismo,idareanatural,idrutaturismo," +
//					"fechaingreso,fecharegistro,idoperadorturismo,idempresaturismo,fechapropuesta,flagfichaturismo,codigoficha) " +
//					"SELECT " +
//						" nextval('sernanp.fichaturismo_idfichaturismo_seq'),:idareanatural,:idrutaturismo," +
//						":fechaingreso,CURRENT_DATE,:idoperadorturismo,:idempresaturismo,:fechapropuesta,:flagfichaturismo," +
//						" SUBSTRING(rt.codrutaturismo from 3) ||  TO_CHAR(current_date, 'yyMMdd') || "+
//						"lpad(trim(to_char(( "+
//						"SELECT "+
//						"case "+ 
//						"when sum( CASE WHEN f.idfichaturismo!=0 THEN 1 "+
//						"            WHEN f.idfichaturismo=0 THEN 0 "+
//						 "        END ) "+
//						  "   is null then 1 "+  
//						"when sum( "+
//						 "      CASE WHEN f.idfichaturismo!=0 THEN 1 "+
//						  "          WHEN f.idfichaturismo=0 THEN 0 "+
//						   "     END "+
//						    "   ) is not null then   ( sum( "+
//						     "  CASE WHEN f.idfichaturismo!=0 THEN 1 "+
//						      "      WHEN f.idfichaturismo=0 THEN 0 "+
//						       " END "+
//						      " ) +1    ) "+ 
//						" end "+
//						" FROM sernanp.fichaturismo f "+  
//						" where  current_date = f.fecharegistro AND   idrutaturismo = :idrutaturismo "+
//
//						" ),'9999999999999999999')), 4,'0') "+
//						 
//						" from sernanp.rutaturismo rt "+
//                        " where rt.idrutaturismo= :idrutaturismo "+
//						" RETURNING  idfichaturismo ",
			
			/*
		FICHAINSERT =
			"INSERT INTO sernanp.fichaturismo (idareanatural,idrutaturismo,idtipoturismo," +
				"fechaingreso,fecharegistro,idguia,idoperadorturismo,idempresaturismo,fechapropuesta,codigoficha) " +
				"SELECT " +
					"?,?,?,?,NOW(),?,?,?,?," +
					"CONCAT( SUBSTRING(rt.codrutaturismo FROM 3),DATE_FORMAT(NOW(),'%y%m%d')," +    
						"LPAD(( " +
						"SELECT IF( SUM(IF(f.idfichaturismo,1,0)) IS NULL, 1,  SUM(IF(f.idfichaturismo,1,0) ) + 1  ) " +
						"FROM sernanp.fichaturismo f " +
						"WHERE  curdate() = date_format(f.fecharegistro,'%Y-%m-%d') AND idrutaturismo = ? " +
						") 	,4, '0') )" +
				"FROM sernanp.rutaturismo rt " +
				"WHERE rt.idrutaturismo = ? " 
			  
			,
           */
			
			FICHAINSERTFECHA =
				"INSERT INTO sernanp.fichaturismo (idareanatural,idrutaturismo,idtipoturismo," +
					"fechaingreso,fecharegistro,idguia,idoperadorturismo,idempresaturismo,codigoficha) " +
						"SELECT " +
						"?,?,?,?,?,?,?,?," +
						" rt.codrutaturismo ||  TO_CHAR(?, 'yyMMdd') || "+
						"lpad(trim(to_char(( "+
						"SELECT "+
						"case "+ 
						"when sum( CASE WHEN f.idfichaturismo!=0 THEN 1 "+
						"            WHEN f.idfichaturismo=0 THEN 0 "+
						 "        END ) "+
						  "   is null then 1 "+  
						"when sum( "+
						 "      CASE WHEN f.idfichaturismo!=0 THEN 1 "+
						  "          WHEN f.idfichaturismo=0 THEN 0 "+
						   "     END "+
						    "   ) is not null then   ( sum( "+
						     "  CASE WHEN f.idfichaturismo!=0 THEN 1 "+
						      "      WHEN f.idfichaturismo=0 THEN 0 "+
						       " END "+
						      " ) +1    ) "+ 
						" end "+
						" FROM sernanp.fichaturismo f "+  
						" where  ? = f.fecharegistro AND   idrutaturismo = ? "+

						" ),'9999999999999999999')), 4,'0') "+
						 
						" from sernanp.rutaturismo rt "+
                        " where rt.idrutaturismo=? "+
						" RETURNING  idfichaturismo ",
						
						
							
		/*	
		FICHAINSERTFECHA =
			"INSERT INTO sernanp.fichaturismo (idareanatural,idrutaturismo,idtipoturismo," +
				"fechaingreso,fecharegistro,idguia,idoperadorturismo,idempresaturismo,codigoficha) " +
				"SELECT " +
					"?,?,?,?,?,?,?,?," +
					"CONCAT( rt.codrutaturismo,DATE_FORMAT(?,'%y%m%d')," +
						"LPAD(( " +
						"SELECT IF( SUM(IF(f.idfichaturismo,1,0)) IS NULL, 1,  SUM(IF(f.idfichaturismo,1,0) ) + 1  ) " +
						"FROM sernanp.fichaturismo f " +
						"WHERE  ? = date_format(f.fecharegistro,'%Y-%m-%d') AND idrutaturismo = ? " + 
						") 	,4, '0') )" +
				"FROM sernanp.rutaturismo rt " +
			"WHERE rt.idrutaturismo = ? " 
				,
		 */
		/** VISITANTES **********************************************************/
		
						
		VISITANTESAVE =
			" select  sernanp.p_add_visitante(:numerodoc,:idpais,:idtipodocumento,:fechanacimiento,:idestadocivil," +
			":idubigeo,:idfichaturismo,:nombre,:apepat,:apemat,:idsexo,:idboletaje,:obsvisitante,:flagcompleto,:flagregistro," +
			":idtipoocupacion,:idmotivovisita  ) "
			,
			
						/*
						VISITANTESAVE =
							" select sernanp.p_add_visitante(?,?,?,?,?,?,?,?,?,?) "
							,
							*/				
						
		VISITANTEOK = 
			"UPDATE sernanp.visitante SET flagvisitante = :flagvisitante WHERE idvisitante = :idvisitante"
			,
			
		VISITANTEFULL = 
			"SELECT "   +
				"v.*,ft.*, vcep.*, cep.*, "  +     
				 " ps.*, "+ 
				 "td.*,td.destablatipo as nomtipodocumento,td.abrtablatipo as abrtipodocumento," +
				 " sx.*,sx.destablatipo as nomsexo,sx.abrtablatipo as abrsexo,  " +
				 " b.*,"   +       
				 "  TRUNC(  (CAST (b.valorboletaje as numeric)  ) ,  2  )  AS valorboletaje "
				//+ "b.serieboletaje, FORMAT(b.valorboletaje, 2) valorboletaje, "
				//+ "b.valorboletaje valorboleto "  
			+ "FROM sernanp.visitante v "    
				//+ "INNER join sernanp.personanatural pn on pn.idpersonanatural = v.idpersonanatural "
				//+ "INNER join sernanp.persona p on p.idpersona = pn.idpersona "
				+ "LEFT join sernanp.boletaje b on b.idboletaje = v.idboletaje "
				+ "LEFT join sernanp.pais ps on ps.idpais = v.idpais " 
				+ "LEFT join sernanp.tablatipo td on td.idtablatipo = v.idtipodocumento "
				+ "LEFT join sernanp.tablatipo sx on sx.idtablatipo = v.idsexo "
				+ "LEFT join sernanp.fichaturismo ft on ft.idfichaturismo = v.idfichaturismo "
				+ "LEFT join sernanp.visitanteconceptoexoneracionpago vcep on vcep.idvisitante = v.idvisitante "
				+ "LEFT join sernanp.conceptoexoneracionpago cep on cep.idconceptoexoneracionpago = vcep.idconceptoexoneracionpago "
				//+ "LEFT join sernanp.tipodocumento td on td.idtipodocumento = pn.idtipodocumento " 
			+ "WHERE 1=1 " 
			,
		        
			
		
			
		REPORTE_VISITANTEXRUTA_ANIO=
			"SELECT * FROM " +
			"(SELECT r.idrutaturismo,date_part('year',f.fecharegistro), count(v.idvisitante) total," +
			" SUM( CASE WHEN p.idpais=)   )" +
			"",
			
			
			
			
	    	
			
			
		VISITANTEREPORTE =  
			"SELECT " +
				"COUNT(idvisitante) total, SUM(IF(idpais=171,1,0)) nacional ," +
				"r.idrutaturismo,r.nombrerutaturismo,  " +
				"SUM(IF(idpais!=171,1,0)) extranjero, DATE_FORMAT(fecharegistro,'%Y') year , " +
				"DATE_FORMAT(fecharegistro,'%c') mes ,DATE_FORMAT(fecharegistro,'%m') mesingreso,  " +
				"SUM(b.valorboletaje) boleto " +   
			"FROM visitante v " +    
				"INNER JOIN sernanp.personanatural pn ON pn.idpersonanatural = v.idpersonanatural " +
				"INNER JOIN sernanp.persona p ON p.idpersona = pn.idpersona " +
				"INNER JOIN sernanp.boletaje b ON b.idboletaje = v.idboletaje " +
				"LEFT JOIN sernanp.fichaturismo f ON f.idfichaturismo = v.idfichaturismo " +
				"LEFT JOIN sernanp.rutaturismo r ON f.idrutaturismo = r.idrutaturismo " +
				"LEFT JOIN sernanp.turismo t ON t.idturismo = r.idturismo " +
				"LEFT JOIN sernanp.areanatural a ON a.idareanatural=t.idareanatural " +
				"WHERE 1=1 AND year(fecharegistro) = 2010 " 
			,
			
			
			
			
		VISITANTEGROUP = 
			" GROUP BY  month(fecharegistro) ,idrutaturismo,year(fecharegistro) " +
			" ORDER BY month(fecharegistro),nombrerutaturismo "  
			,
		              
			      
		/**HISTORICO AREA NATURAL***********************************************************************/
		HISTORICOBYYEAR=
			"SELECT SUM(extension) totalextension,COUNT(idareanatural) totalareas," +
				"YEAR(h.fechahistoricoareanatural) anio " +
			"FROM sernanp.historicoareanatural h " +     
			"GROUP BY year(h.fechahistoricoareanatural) " +
			"ORDER BY h.fechahistoricoareanatural"    
			,   
		/* Take a Bug MySQL*/
		HISTORICOLIST =    
			"SELECT h.*,a.*,ad.siglasadministracionareanatural " +   
			"FROM sernanp.historicoareanatural h " +  
				"INNER JOIN sernanp.areanatural a ON a.idareanatural = h.idareanatural " +   
				"INNER JOIN sernanp.administracionareanatural ad ON ad.idadministracionareanatural = a.idadministracionareanatural " +
			"ORDER BY h.fechahistoricoareanatural"  
		,
	 
		/**ADMINISTRACION AREA NATURAL *****************************************************************/
		ADMINISTRACIONLIST = 
			"SELECT * FROM sernanp.administracionareanatural " +
			"WHERE 1=1"
		,
		
		/** RUTATURISMO ********************************************************************************/
		INSERTRUTATURISMO =
			"INSERT INTO " +
				"sernanp.rutaturismo (idturismo,nombrerutaturismo,detallerutaturismo) " +
			"VALUES( ?,?,? ) "  
				,
			
		INSERTRUTATURISMOFULL =   
			"INSERT INTO " +
				"sernanp.rutaturismo (idturismo,nombrerutaturismo,detallerutaturismo,codrutaturismo) " +
			"SELECT ?,?,?," +
				"( SELECT CONCAT( a.codareanatural,LPAD( (count(*) + 1) ,2,'00') ) code " +
				"FROM sernanp.rutaturismo r " +
					"INNER JOIN sernanp.turismo t on t.idturismo = r.idturismo " +
					"INNER JOIN sernanp.areanatural a on a.idareanatural = t.idareanatural " +
				"WHERE t.idturismo = ? ) "  
		,
		GENERATECODETURISMO =
			"SELECT CONCAT( a.codareanatural,LPAD( (count(*) ) ,2,'00') ) code " +
			"FROM sernanp.rutaturismo r " +
				"INNER JOIN sernanp.turismo t on t.idturismo = r.idturismo " +
				"INNER JOIN sernanp.areanatural a on a.idareanatural = t.idareanatural " +
			"WHERE t.idturismo = ? " 
		,
		
		/** BOLETOS ***********************************************************************************/
		BOLETOS = 
			"SELECT idboletaje,nombreboletaje,valorboletaje,serieboletaje,obsboletaje " +
			"FROM sernanp.boletaje b WHERE 1=1 "
		,
		INSERTBOLETOS =
			"INSERT INTO sernanp.boletaje (nombreboletaje,valorboletaje,serieboletaje,obsboletaje,idrutaturismo) " +
			" VALUES( :nombreboletaje, :valorboletaje, :serieboletaje , :obsboletaje, :idrutaturismo) " 
		,	
			
		/** TIPOTURISMO *******************************************************************************/
 
		INSERT_RUTATURISMO_TIPOTURISMO =
			"INSERT INTO sernanp.rutaturismotipoturismo (idrutaturismo,idtipoturismo) " +
			" VALUES( :idrutaturismo, :idtipoturismo) " 
			
		;
	
		
	   
}
