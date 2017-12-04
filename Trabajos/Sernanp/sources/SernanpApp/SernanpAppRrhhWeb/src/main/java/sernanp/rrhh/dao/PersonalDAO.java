package sernanp.rrhh.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.vo.Areanatural;
import sernanp.rrhh.vo.Categoriaanp;
import sernanp.rrhh.vo.Persona;
import sernanp.rrhh.vo.PersonalAsistenciaResumenVO;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalContratoVO;
import sernanp.rrhh.vo.PersonalDescuentosVO;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;
import sernanp.rrhh.vo.PersonalTardanzaVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.PersonaldiasnolaborablesVO;
import sernanp.rrhh.vo.Personanatural;

public class PersonalDAO  {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	

	//Sistema de RR. HH  03-08-2013 (D. V. R)

	@Transactional
	public void guardarPersonal(List<PersonalVO> lp) {		
				
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertarpersona);
		String sql =sqlb.toString();
		
		StringBuffer sqlb2 = new StringBuffer(SqlConstants.insertarpersonanatural);
		String sql2 =sqlb2.toString();

		StringBuffer sqlb3 = new StringBuffer(SqlConstants.insertarpersonal);
		String sql3 =sqlb3.toString();
		
		/*
		StringBuffer sqlb4 = new StringBuffer(SqlConstants.insertarpersonalcontrato);
		String sql4 =sqlb4.toString();
		*/
		
		for(PersonalVO p : lp){
			
			int idpersona = this.simpleJdbcTemplate.queryForInt(sql);
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			parametros.put("idpersona",idpersona);
			parametros.put("nombre", p.getPersonanatural().getNombre());
			parametros.put("apepat", p.getPersonanatural().getApepat());
			parametros.put("apemat", p.getPersonanatural().getApemat());
			parametros.put("idtipodocumento", p.getPersonanatural().getTipodocumento().getIdtipo());
			parametros.put("numerodoc", p.getPersonanatural().getNumerodocumento());
			parametros.put("fechanacimiento", p.getPersonanatural().getFechanacimiento());
			parametros.put("ruc", p.getPersonanatural().getRuc());
			parametros.put("direccion", p.getPersonanatural().getDireccion());			
			
			int idpersonanatural = this.simpleJdbcTemplate.queryForInt(sql2, parametros);
			
			parametros = new HashMap<String, Object>();
			
			parametros.put("idpersonanatural",idpersonanatural);
			parametros.put("estado", p.getEstado());
			parametros.put("int_flag", p.getInt_flag());
			parametros.put("srl_id_asis_turno", 2);
			
			int idpersonal 			= this.simpleJdbcTemplate.queryForInt(sql3, parametros);
			/*
			parametros = new HashMap<String, Object>();			
			
			parametros.put("idpersonal",idpersonal);
			parametros.put("num_sueldo", p.getListapersonalcontrato().get(0).getNum_sueldo());
			parametros.put("dte_fec_inicio", p.getListapersonalcontrato().get(0).getDte_fec_inicio());
			
			this.simpleJdbcTemplate.update(sql4, parametros);
			*/
		}						
	
	}
	
		
	
	public void updatePersonalEstado(List<PersonalVO> pe){
	
		StringBuffer sqlb = new StringBuffer(SqlConstants.actualizarPersonalEstado);
		String sql = sqlb.toString();
		
		for (PersonalVO p : pe){
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			parametros.put("idpersonal", p.getIdpersonal());
			parametros.put("estado", p.getEstado());
			parametros.put("int_flag", p.getInt_flag());
//			parametros.put("srl_id_asis_turno", 2);	
			
			this.simpleJdbcTemplate.update(sql, parametros);		
			
		}
		
	}
	
		
	
	public void updatePersonalContrato(List<PersonalContratoVO> upc) {		
		SqlParameterSource[] batch 	= SqlParameterSourceUtils.createBatch( upc.toArray());
		String sql                 	= null;		
		sql   						= "INSERT INTO sernanp.t_personal_contrato(srl_id_contrato, num_sueldo, idpersonal, dte_fec_inicio, " +
									  "int_id_tab_tip, srl_id_cargo) " +
									  "SELECT nextval('sernanp.t_personal_contrato_srl_id_contrato_seq'), :num_sueldo, :idpersonal, " +
									  ":dte_fec_inicio, 1, 5";
	
		simpleJdbcTemplate.batchUpdate(sql, batch);	
	}

		
		
	public List<PersonalVO> listapersonalxfechaymotivoAsistApepat(String fechaAsist, int estadoAsist, String apaterno, int idregcontractual, int ubicacionPersonal, int idANP, int nroRegistros){

		StringBuffer sqlb 	= null;//new StringBuffer("SELECT 	sernanp.fn_udate_asistencias_with_vacaciones('"+fechaAsist+"' )");		
		String sql 			= null;//sqlb.toString();				
		
		try {

			if(fechaAsist != null  ){
//				System.out.println("Ejecutando Store Procedures ..." + fechaAsist);
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_papeletaall()");
//				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_permisoall()");
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_udate_asistencias_with_vacaciones('"+fechaAsist+"')");
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_udate_asistencias_with_licencias('" +fechaAsist+"')");	
				
			}
			
			sqlb				= new StringBuffer(SqlConstants.listapersonal);
			sqlb.append(", int_vac_lic, COALESCE (UPPER(uop.nomunidad), UPPER(ao.desarea), '') AS oficina ");
			//ADD 07-10-2015
			sqlb.append(",pc.dte_fec_inicio, pc.dte_fec_cese, UPPER(c.var_nom_cargo) AS cargo ");
			
			sqlb.append("FROM sernanp.personanatural pn ");
//			sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural AND p.int_estado = 0  ");
			sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural ");
			sqlb.append("INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno ");
			sqlb.append("INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal ");	
			
			sqlb.append("AND pa.dte_fecha = '" + fechaAsist + "' ");
			
			if(ubicacionPersonal >= 0 && idANP <= 0) sqlb.append("AND p.int_flag = " + ubicacionPersonal + " ");
			
			if (estadoAsist <= 3){
				if (estadoAsist == 1){				
					sqlb.append("AND pa.hor_hor_ingreso ISNULL AND pa.hor_hor_salida ISNULL ");
				}else if (estadoAsist == 3){
					estadoAsist = 1;
					sqlb.append("AND (pa.hor_hor_ingreso NOTNULL OR pa.hor_hor_salida NOTNULL) ");				
				}
				sqlb.append("AND pa.int_estado = " + estadoAsist +" ");
			}
			
			sqlb.append("INNER JOIN sernanp.t_personal_contrato pc ON pc.idpersonal = pa.idpersonal ");
//			sqlb.append("AND pc.dte_fec_inicio >= (SELECT MAX(pcx.dte_fec_inicio) FROM sernanp.t_personal_contrato pcx	WHERE pcx.idpersonal = p.idpersonal ) ");
			sqlb.append("AND pc.dte_fec_inicio = (SELECT MAX(pcx.dte_fec_inicio) FROM sernanp.t_personal_contrato pcx	WHERE pcx.idpersonal = p.idpersonal AND pcx.dte_fec_inicio <= pa.dte_fecha) ");
		
			if(idregcontractual > 0) sqlb.append("AND pc.srl_id_regimen_contractual = " + idregcontractual+" ");
			
			sqlb.append("LEFT JOIN sernanp.areaorganica ao ON ao.idarea = pc.idarea ");
			sqlb.append("LEFT JOIN sernanp.unidadoperativa uop ON uop.idunidad = pc.idunidad ");
			//ADD 07-10-2015
			sqlb.append("LEFT JOIN sernanp.t_cargo c ON c.srl_id_cargo = pc.srl_id_cargo ");
			
			if(idANP > 0) {
				sqlb.append("INNER JOIN sernanp.sede pse ON pse.idsede = pc.srl_id_sede_pres AND pse.idareanatural = " + idANP + " ");
			}		
			
			//if(apaterno != null && !apaterno.isEmpty())		sqlb.append("WHERE pn.nombre || ' ' || pn.apepat|| '' || pn.apemat || '' LIKE '%"+apaterno.toUpperCase()+"%' ");

			sqlb.append("ORDER BY pn.apepat, pn.apemat, pn.nombre, pa.dte_fecha, pa.int_estado ");
			
			sql			= sqlb.toString();
			
			System.out.println("listar personalAsistencia - sql : " + sql);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return this.jdbcTemplate.query(sql, new RowMappersConstants.Personal_Asistencia());
	}
	
	
	
	
	public List<PersonalAsistenciaVO> Incidencias(String fechaAsist){

		StringBuffer sqlb	= new StringBuffer(SqlConstants.incidencias);
		sqlb.append("(SELECT COUNT(pa.int_estado) ");
		sqlb.append("FROM sernanp.t_personal_asistencia pa "); 
		sqlb.append("WHERE pa.int_estado = 1 AND pa.dte_fecha = '"+fechaAsist+"' ");
		sqlb.append("AND pa.hor_hor_ingreso ISNULL AND pa.hor_hor_salida ISNULL )||'-'|| ");	
		sqlb.append("(SELECT COUNT(pa.int_estado) ");
		sqlb.append("FROM sernanp.t_personal_asistencia pa "); 
		sqlb.append("WHERE pa.int_estado = 2 AND pa.dte_fecha = '"+fechaAsist+"' ) ||'-'|| ");
		sqlb.append("(SELECT COUNT(pa.int_estado) ");
		sqlb.append("FROM sernanp.t_personal_asistencia pa "); 
		sqlb.append("WHERE pa.int_estado = 1 AND pa.dte_fecha = '"+fechaAsist+"' ");
		sqlb.append("AND (pa.hor_hor_ingreso NOTNULL OR pa.hor_hor_salida NOTNULL)) as incidencias ");
		sqlb.append("FROM sernanp.t_personal_asistencia pa "); 
		sqlb.append("WHERE pa.int_estado = 0 AND pa.dte_fecha = '"+fechaAsist+"' ");		
		
		String sql			= sqlb.toString();		
//		System.out.println("Incidencias --> " + sql);

		return this.jdbcTemplate.query(sql, new RowMappersConstants.Personal_Incidencias());
	}
	
	
	
	public List<Personanatural> listapersonalxID(int idp){
		
		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listapersonalxid);
		String sql 			= sqlb.toString();	 

		
		return  this.jdbcTemplate.query(sql, new Object[]{idp}, new RowMappersConstants.PersonaNatural());
	}
		
	
	
	
	public List<PersonalVO> personalTurno(int idp){
		
		StringBuffer sqlb 	= new StringBuffer(SqlConstants.personalturno);
		String sql 			= sqlb.toString();
		
//		System.out.println("Personal Turno : " + idp);
		
		return this.jdbcTemplate.query(sql, new Object[]{idp}, new RowMappersConstants.PersonalTurno());
	}
	
	
	
	
	/*25-09-2014
	public List<PersonalMarcacionVO> listapersonalmarcxID(int idpersonal, String fecmarc){

		StringBuffer sqlb 	= null;
		sqlb 				= new StringBuffer(SqlConstants.MarcacionxIdpersonalfechamarc);
		sqlb.append("pm.dte_fec_marc = '"+fecmarc+"'"); 
		sqlb.append(" ORDER BY hor_hor_marc");
		String sql 			= sqlb.toString();	
		
		return  this.jdbcTemplate.query(sql, new Object[]{idpersonal}, new RowMappersConstants.PersonalMarcacion());
	}
	*/
	public List<PersonalTardanzaVO> listapersonalconTardanzaTMP(String primerdiames, String ultimodiames){

		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listapersonalcontardanzaTMP);		
		sqlb.append("pa.dte_fecha BETWEEN'"+primerdiames+"' AND '"+ultimodiames+"'  ");
		sqlb.append("GROUP BY p.idpersonal, pc.num_sueldo ");
		sqlb.append("ORDER BY p.idpersonal ");
		String sql 			= sqlb.toString();	 

		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listaPersonalconTardanza());
	}
	
	
	

	
	public List<PersonalTardanzaVO> listapersonalconTardanza(String primerdiames, String ultimodiames, int generaoValidadesc, int ubicacion, int idreg){
		StringBuffer sqlb 	= new StringBuffer();
//		System.out.println("Listar Tardanzas ...");
		if(generaoValidadesc == 0){
			sqlb 	= new StringBuffer(SqlConstants.listapersonalcontardanzaTMP);
//			System.out.println("Listar Tardanzas ...Temporales");
		}else{  				
			sqlb 	= new StringBuffer(SqlConstants.listapersonalcontardanza);
//			System.out.println("Listar Tardanzas ...Definitivas");
		}
		
		if(ubicacion >= 0 ) sqlb.append("p.int_flag = " + ubicacion + " AND ");
//		if(idreg > 0 ) sqlb.append("pc.srl_id_regimen_contractual = " + idreg + " AND ");
		
		
		sqlb.append("pa.dte_fecha BETWEEN'"+primerdiames+"' AND '"+ultimodiames+"' ");
		sqlb.append("AND EXTRACT(DOW FROM pa.dte_fecha) NOT IN (6,0) "); 
		sqlb.append("AND pa.hor_hor_ingreso > pt.hor_hor_ingreso ");
		
		
		
		
		
		if(generaoValidadesc == 0){
			sqlb.append("GROUP BY p.idpersonal, pc.num_sueldo ");				
		}
		
		sqlb.append("ORDER BY p.idpersonal ");
		String sql 			= sqlb.toString();	 

		//System.out.println("listapersonalconTardanza - SQL yeye : "+sql);
		if(generaoValidadesc == 0){
			return  this.jdbcTemplate.query(sql, new RowMappersConstants.listaPersonalconTardanzaTMP());
		}else{
			return  this.jdbcTemplate.query(sql, new RowMappersConstants.listaPersonalconTardanza());
		}
		
	}
	
	
	
	public List<PersonalDescuentosVO> listapersonaltardanzaDesc(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, int generaoValidadesc){

		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listapersonaltardanzadesc);
		
		sqlb.append("BETWEEN '"+ primerdiamesdesc +"' AND '"+ ultimodiamesdesc +"' AND ");
		sqlb.append("pt.idpersonal NOT IN ( " );
		
		if (generaoValidadesc == 0){
			sqlb.append("SELECT pd.idpersonal FROM sernanp.t_personal_descuento_tmp pd " );	
		}else{
			sqlb.append("SELECT pd.idpersonal FROM sernanp.t_personal_descuento pd " );
		}

		sqlb.append("WHERE pd.int_periodo_desc = "+periododesc+" AND pd.int_mes_desc = "+mesdesc+" AND ");
		sqlb.append("pd.idtablatipo = "+ValueConstants.TipoDescuentoTardanza+" )");
		
		sqlb.append("GROUP BY pt.idpersonal ");
		
		String sql 			= sqlb.toString();	 

//		System.out.println("listapersonaltardanzaDesc - SQL : "+sql);
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listapersonaltardanzaDesc());
	}
	
	
	public List<PersonalDescuentosVO> listapersonalinasistenciaDesc(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, int generaoValidadesc){

		
		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listapersonalinasistenciadesc);
	
		sqlb.append("BETWEEN '"+ primerdiamesdesc +"' AND '"+ ultimodiamesdesc +"' ");
		sqlb.append("AND EXTRACT(DOW FROM pa.dte_fecha) NOT IN (6,0)");
		sqlb.append("AND pa.int_estado = 1 AND pa.idpersonal = pc.idpersonal)),2) AS descuento, ");
		
		sqlb.append("ROUND(((pc.num_sueldo / 30) * ");
		sqlb.append("(SELECT COUNT(pp.idpersonal) FROM sernanp.t_personal_permiso pp WHERE pp.idpersonal = pc.idpersonal ");
		sqlb.append("AND pp.int_estado = 0 AND pp.hor_hor_salida ISNULL  AND pp.hor_hor_retorno ISNULL ");
		sqlb.append("AND pp.dte_fec_pers_perm_sal BETWEEN '"+ primerdiamesdesc +"' AND '"+ ultimodiamesdesc +"' ");		
		sqlb.append(")),2) AS permisos_dias, ");
		
		sqlb.append("ROUND(((pc.num_sueldo / 14400) * ");
		sqlb.append("(SELECT (EXTRACT(HOUR FROM (SUM(pp.hor_hor_retorno - pp.hor_hor_salida))) *60)+ ");
		sqlb.append("EXTRACT(MINUTE FROM (SUM(pp.hor_hor_retorno - pp.hor_hor_salida))) ");
		sqlb.append("FROM sernanp.t_personal_permiso pp WHERE pp.idpersonal = pc.idpersonal AND pp.int_estado = 0 ");
		sqlb.append("AND pp.dte_fec_pers_perm_sal BETWEEN '"+ primerdiamesdesc +"' AND '"+ ultimodiamesdesc +"'");			
		sqlb.append(")::INT ),2) AS permisos_tiempo ");
		
		sqlb.append("FROM sernanp.t_personal_contrato pc ");
		sqlb.append("WHERE pc.idpersonal IN(  ");
		sqlb.append("SELECT pa.idpersonal FROM sernanp.t_personal_asistencia pa " );
		sqlb.append("WHERE pa.dte_fecha BETWEEN '"+ primerdiamesdesc +"' AND '"+ ultimodiamesdesc +"' AND ");
		sqlb.append("pa.idpersonal = pc.idpersonal AND (pa.int_estado = 1 OR pa.int_estado = 2) ");
		sqlb.append("AND EXTRACT(DOW FROM pa.dte_fecha) NOT IN (6,0))");
		
	
		String sql 			= sqlb.toString();	 

		
		
		//System.out.println("listapersonalinasistenciaDesc - SQL : "+sql);
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listapersonalinasistenciaDesc());
	}

	

	
	public List<PersonalAsistenciaVO> listainasistenciasPermisosxidpersonal(int periodo, int mes, int idPersonal, String primerdiames, String ultimodiames, int descValidados){
		
		
		/*--------------------------ADD 14-10-2014------------------------*/
		/*COMENTADO 07-10-2015 DAVID
		String ultimodia [] = ultimodiames.split(" ");
		String mesString	= null;
		String fechaVac 	= null;
		int ultimo 			= Integer.valueOf(ultimodia[2]);
		String dia 			= null;
		
		if(mes < 10){
			mesString = "0"+mes;
		}else{
			mesString = String.valueOf(mes);
		}

//		System.out.println("---------------------------Listar Inasistencias -----------");
		
		for(int i=1; i<=ultimo; i++){			
			if(i < 10){
				dia = "0"+i;
			}else{
				dia = String.valueOf(i);
			}
			fechaVac 	= periodo + "-" + mesString + "-" + dia;
//			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_papeletaall()");		
			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_udate_asistencias_with_licencias('" +fechaVac+"')");
			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_udate_asistencias_with_vacaciones('"+fechaVac+"')");			
		}		
		*/
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_papeleta("+idPersonal+")");		

		/*------------------FIN ADD------------------------------*/
		
		StringBuffer sqlb	= new StringBuffer(SqlConstants.listainasistenciasPermisosxidpersonal);
		/*if (descValidados > 0){
			sqlb.append("INNER JOIN sernanp.t_personal_descuento pd ON pd.idpersonal  = pa.idpersonal ");
		}else if (descValidados == 0){
			sqlb.append("INNER JOIN sernanp.t_personal_descuento_tmp pd ON pd.idpersonal  = pa.idpersonal ");	
		}*/
		
		sqlb.append("WHERE pa.dte_fecha BETWEEN '"+ primerdiames +"' AND '"+ ultimodiames +"' ");
		sqlb.append("AND EXTRACT(DOW FROM pa.dte_fecha) NOT IN (6,0) ");
		sqlb.append("AND(pa.int_estado = 1 OR pa.int_estado = 2) AND pa.idpersonal = " + idPersonal + " ");
		sqlb.append("GROUP BY pa.idpersonal,pa.dte_fecha, pa.int_estado , pa.int_vac_lic ");
		sqlb.append("ORDER BY pa.dte_fecha");
		
		String sql			= sqlb.toString();
//		System.out.println("listainasistenciasPermisosxidpersonal - sql : " + sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listainasistenciasPermisosxidpersonal());
			
	}
	
	
	public void eliminarDescuentosTmp(){
		
		String sql			= "TRUNCATE sernanp.t_personal_descuento_tmp";
		this.jdbcTemplate.execute(sql);
		
		
	}
	
	
	public void guardarListaTardanza(List<PersonalTardanzaVO> tardanzaLista) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( tardanzaLista.toArray());
		String sql                 = null;

		sql   = "INSERT INTO sernanp.t_personal_tardanza(srl_id_pers_tard, dte_fec_pers_tard, int_min_tard, idpersonal) " +
				"SELECT nextval('sernanp.t_personal_tardanza_srl_id_pers_tard_seq'), :dte_fec_pers_tard, :int_min_tard, :personal.idpersonal";					

//		System.out.println( "guardarListaTardanza - SQL : "+sql);
		
		simpleJdbcTemplate.batchUpdate(sql, batch);
	
	}
	
	
	
	
	public void guardarListaDescuentos(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, int ubicacion,  int idreg, int idanp, String nombreTabla){
//		System.out.println("( '" + primerdiamesdesc + "','"+ultimodiamesdesc+"'," + periododesc + ","+mesdesc+",'"+nombreTabla+"' )");
//		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listapersonalinasistenciadescSP);
		
		/*--------------------------ADD 14-10-2014------------------------*/
		String ultimodia [] = ultimodiamesdesc.split(" ");
		String mes			= null;
		String fechaVac 	= null;
		int ultimo 			= Integer.valueOf(ultimodia[2]);
		String dia 			= null;
		
		
		if(mesdesc < 10){
			mes = "0"+mesdesc;
		}else{
			mes = String.valueOf(mesdesc);
		}

//		System.out.println("--------------------------------Generando Descuentos ---------------------");
		for(int i=1; i<=ultimo; i++){			
			if(i < 10){
				dia = "0"+i;
			}else{
				dia = String.valueOf(i);
			}
			fechaVac 	= periododesc+"-"+mes+"-"+dia;
//			System.out.println(i + " - fecha : " + fechaVac);
			
			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_udate_asistencias_with_licencias('" +fechaVac+"')");
			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_udate_asistencias_with_vacaciones('"+fechaVac+"')");
		}
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_papeletaall()");		
		
		/*------------------FIN ADD------------------------------*/

		StringBuffer sqlb 	= new StringBuffer("SELECT sernanp.fn_genera_descuento_personal_new");		
		
//		System.out.println("ubicacion : " + ubicacion + " / regimen : " +idreg);
		
		if(ubicacion == 0){
			ubicacion = 1;			
		}else if(ubicacion == 1){
			ubicacion = 0;
		}
		
			
		sqlb.append("( '" + primerdiamesdesc + "','"+ultimodiamesdesc+"'," + periododesc + ","+mesdesc+","+ubicacion+","+idreg+","+idanp+",'"+nombreTabla+"' )");
		
		String sql = sqlb.toString();
		
//		System.out.println("Descuentos Ejecutando funcion : " + sql);
		
		this.jdbcTemplate.queryForInt(sql);
		
		
	}


	/*public void guardarListaDescuentos(List<PersonalDescuentosVO> ListaDescuentos) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( ListaDescuentos.toArray());
		String sql                 = null;

		sql   = "INSERT INTO sernanp.t_personal_descuento_tmp(srl_id_pers_desc_tmp, idpersonal, int_periodo_desc, " +
				"int_mes_desc, num_monto_desc, idtablatipo, tsp_fec_pers_desc, int_minutos_tardanza, int_inasistencias ) " +
				"SELECT nextval('sernanp.t_personal_descuento_tmp_srl_id_pers_desc_tmp_seq'), :personaldescuento.idpersonal, :int_periodo_desc, " +
				":int_mes_desc, :num_monto_desc, :tipodescuento.idtipo, :tsp_fec_pers_desc, :minutos_tardanza, :inasistencias ";
		
		
//		System.out.println( "guardarListaTardanza - SQL : "+sql);
		
		simpleJdbcTemplate.batchUpdate(sql, batch);
	
	}*/
	
	

	public void guardarListaDescuentosValid(List<PersonalDescuentosVO> ListaDescuentos) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( ListaDescuentos.toArray());
		String sql                 = null;

		sql   = "INSERT INTO sernanp.t_personal_descuento(srl_id_pers_desc, idpersonal, int_periodo_desc, " +
				"int_mes_desc, num_monto_desc, idtablatipo, tsp_fec_pers_desc ) " +
				"SELECT nextval('sernanp.t_personal_descuento_srl_id_pers_desc_seq'), :personaldescuento.idpersonal, :int_periodo_desc, " +
				":int_mes_desc, :num_monto_desc, :tipodescuento.idtipo, :tsp_fec_pers_desc ";		
		
		simpleJdbcTemplate.batchUpdate(sql, batch);
	
	}
	
	
	public List<PersonalDescuentosVO> listapersonalDescuento(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, String apepat, 
			int descTmpValid, int idregcontractual, int ubicacionPersonal, int idANP){		
		StringBuffer sqlb 	= null;
		String sql			= null;
		sqlb 				= new StringBuffer(SqlConstants.listapersonalDescuentoFinal);
		
		sqlb.append("SUM(pd.int_minutos_tardanza) AS minutos_tardanza, SUM(pd.int_cant_inasistencias) AS faltas, SUM(pd.int_cant_dias_licencias_sgh) AS licencias_sgh , ");
		sqlb.append("SUM(pd.int_cant_dias_permiso) AS permisos, (SELECT SUM(pp.hor_hor_ret_desp - pp.hor_hor_sal_desp) ");
		sqlb.append("FROM sernanp.t_personal_desplazamiento pp WHERE pp.idpersonal = p.idpersonal AND pp.dte_fec_ret_desp ISNULL AND pp.srl_id_per_activ = 24 "); 
		sqlb.append("AND pp.dte_fec_sal_desp BETWEEN '"+primerdiamesdesc+"' AND '"+ultimodiamesdesc+"' ");
		sqlb.append("GROUP BY pp.idpersonal ) AS permisos_tiempo, ");
		sqlb.append("SUM(pd.num_monto_desc) AS total_desc, pd.int_periodo_desc, pd.int_mes_desc ");
		sqlb.append("FROM sernanp.personanatural pn "); 
		sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural  = p.idpersonanatural "); 
 
		if (descTmpValid == 0) {
//			System.out.println("Obteniendo descuentos temporales ....");
			sqlb.append("INNER JOIN sernanp.t_personal_descuento_tmp pd ON p.idpersonal  = pd.idpersonal AND ");
		}else{
//			System.out.println("Obteniendo descuentos definitivos ....");
			sqlb.append("INNER JOIN sernanp.t_personal_descuento pd ON p.idpersonal  = pd.idpersonal AND ");
		}
		
//		if(ubicacionPersonal >= 0) sqlb.append("p.int_flag = " + ubicacionPersonal + " AND ");
		sqlb.append("pd.int_periodo_desc = "+periododesc+" AND pd.int_mes_desc = "+mesdesc+" " );
		if(ubicacionPersonal >= 0) sqlb.append("AND pd.int_flag_ubicacion = " + ubicacionPersonal + " ");			
		if(idregcontractual > 0 ) sqlb.append("AND pd.int_id_reg_contractual = " + idregcontractual + " ");
		
		if(idANP > 0 ) sqlb.append("INNER JOIN sernanp.sede pse ON pse.idsede = pd.int_id_sede AND pse.idareanatural = " + idANP + " ");
		
		sqlb.append("GROUP BY p.idpersonal, pn.numerodoc, pn.nombre,  pn.apepat, pn.apemat, pd.int_periodo_desc, pd.int_mes_desc ");
		sqlb.append("ORDER BY pn.apepat, pn.apemat, pn.nombre ");
	
		sql 			= sqlb.toString();
		
//		System.out.println("lista descuento - sql : " + sql);

		return  this.jdbcTemplate.query(sql, new RowMappersConstants.Personal_Descuentos());
	}
		
	
	public List<PersonalDescuentosVO>listarPeriodoMesDescuento(int anio_mes){
		StringBuffer sqlb 	=	null;
		String sql			= 	null;
		if(anio_mes == 0){
			sqlb		=	new StringBuffer(SqlConstants.listarPeriodoDescuento);
			sql			= 	sqlb.toString();
//			System.out.println("Query for años : " + sql);
			return this.jdbcTemplate.query(sql, new RowMappersConstants.listarPeriodoDescuento());
		}else {
			sqlb		=	new StringBuffer(SqlConstants.listarMesDescuento);
			sql			= 	sqlb.toString();
//			System.out.println("Query for meses : " + sql);
			return this.jdbcTemplate.query(sql, new RowMappersConstants.listarMesDescuento());
		}
			
		
	}
	
	public List<Personanatural> listaapepatencontrados(){
		StringBuffer sqlb	= new StringBuffer(SqlConstants.listaapesencontrados);
		String sql          = sqlb.toString();
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.Personanaturalxnrodoc());
	}	
	
	
	

	
	public void guardarPersona(List<Persona> listPersonanoExiste) {		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( listPersonanoExiste.toArray());
		String sql                 = null;		
		sql   = "INSERT INTO sernanp.persona(idpersona, ruc) " +
				"SELECT nextval('sernanp.persona_idpersona_seq'), :ruc";
		
		simpleJdbcTemplate.batchUpdate(sql, batch);				
	
	}
	
	///*****************
	
	
	public int tardanzasgeneradas(String primerdiamesdesc, String ultimodiamesdesc){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.contartardanzas);
		sqlb.append("WHERE pt.dte_fec_pers_tard BETWEEN '"+primerdiamesdesc+"' AND '"+ultimodiamesdesc+"'");			
				
		String sql =sqlb.toString();

		 int nt =  this.jdbcTemplate.queryForInt(sql);
		 
		 return nt;
		 	
	}
	
	
	public int contardescuentosvalidadosxperiodo(int periododesc, int mesdesc, int ubicacion, int idANP, int idreg){
		String sql 			= null;
		StringBuffer sqlb 	= null;
		sqlb				= new StringBuffer(SqlConstants.contardescuentosvalidadosxperiodo);
		
//		if(idANP > 0 ) 	sqlb.append("INNER JOIN sernanp.sede pse ON pse.idsede = pd.int_id_sede AND pse.idareanatural = " + idANP + " ");		
//		sqlb.append("WHERE pd.int_periodo_desc = " + periododesc + " AND pd.int_mes_desc = " + mesdesc + " AND pd.int_flag_ubicacion = " + ubicacion + " ");
		sqlb.append("WHERE pd.int_periodo_desc = " + periododesc + " AND pd.int_mes_desc = " + mesdesc + "  ");
		if(ubicacion >= 0 )	sqlb.append("AND pd.int_flag_ubicacion = " + ubicacion + " ");
		if(idreg > 0 )	sqlb.append("AND pd.int_id_reg_contractual = " + idreg + " ");

		sql = sqlb.toString();
		
//		System.out.println("Query validando descuentos : " + sql);
		
		return this.jdbcTemplate.queryForInt(sql);
	}
	

	public int contardescuentosTMPxperiodo(int periododesc, int mesdesc){
		StringBuffer sqlb = new StringBuffer(SqlConstants.contardescuentosTMPxperiodo);
				
		sqlb.append("WHERE pd.int_periodo_desc = " + periododesc + " AND pd.int_mes_desc = "+mesdesc);
		String sql = sqlb.toString();

		return this.jdbcTemplate.queryForInt(sql);
	}
	
	
	
	
	public List<PersonalVO> lista_personal(){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listarpersonal);
				
		String sql =sqlb.toString();
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.Personal());
		 	
	}

	
	/*ADD 14-07-2014  (D.V.R)*/
	
	public int verificarLicenciasPersonal(int idP, String fechaAsist){
		StringBuffer sqlb = new StringBuffer("SELECT count(pl.*) ");
		sqlb.append("FROM sernanp.t_personal_licencias pl "); 
		sqlb.append("WHERE pl.idpersonal = " + idP + " AND ");
		sqlb.append("'" +fechaAsist + "' BETWEEN pl.dte_fec_inicio_lic AND pl.dte_fec_fin_lic ");
		String sql = sqlb.toString();
		
		return this.simpleJdbcTemplate.queryForInt(sql);
		
		
	}
	
	
	public int verificarVacacionesPersonal(int idP, String fechaAsist){
		StringBuffer sqlb = new StringBuffer("SELECT count(pvg.*) ");
		sqlb.append("FROM sernanp.t_personal_goce_vacaciones pvg "); 
		sqlb.append("INNER JOIN sernanp.t_personal_vacaciones pv ON pvg.id_pers_vac = pv.srl_id_pers_vac ");
		sqlb.append("WHERE pv.idpersonal = " + idP + " AND ");
		sqlb.append("'" +fechaAsist + "' BETWEEN pvg.dte_fec_inicio_goc_vac AND pvg.dte_fec_fin_goc_vac ");
		String sql = sqlb.toString();		
	
		return this.simpleJdbcTemplate.queryForInt(sql);
		
		
	}
	
	
	/*ADD 19-08-2014 (D.V.R)      -----------      OBTENER EL ESTADO DE ASISTENCIA X FECHA  ---------*/
	
	public List<PersonalAsistenciaVO> obtenerEstadoAsistencia(int idPersonal, String fechaAsistencia){
		String sql 			= null;		
		StringBuffer sqlb	= new StringBuffer(SqlConstants.estadoAsistenciaxidPersonal);
//		StringBuffer sqlb	= new StringBuffer("SELECT 	pa.int_estado as int_estado, CASE WHEN pa.hor_hor_ingreso ISNULL AND pa.hor_hor_salida ISNULL THEN 1 END as int_estado_tmp, int_vac_lic ");
//		sqlb.append("FROM sernanp.t_personal_asistencia pa "); 
		sqlb.append("WHERE pa.idpersonal = " + idPersonal + " AND pa.dte_fecha = '" + fechaAsistencia +"' "); 
//		sqlb.append("ORDER BY pa.dte_fecha, pa.int_estado ");	

		
		sql		= sqlb.toString();
		
//		System.out.println("Estados - sql : " + sql);		

		
		return this.simpleJdbcTemplate.query(sql,new RowMappersConstants.Personal_estado_Asistencia());
	}
	
	
	
	
    public List<Categoriaanp> listaCatANPs(){
    	StringBuffer sqlb	= null;
    	String sql			= null;
    	sqlb 				= new StringBuffer(SqlConstants.listarCategoriaANP);
    	sql					= sqlb.toString();
    	
//    	System.out.println("sql - Categorias : "  + sql);

    	return this.jdbcTemplate.query(sql, new RowMappersConstants.CatAreanaturalMapper());
    }
	
	
    public List<Areanatural> listaANPs(int idcategoria){
    	StringBuffer sqlb	= null;
    	String sql			= null;
    	sqlb 				= new StringBuffer(SqlConstants.listaAreaNatural);
    	sqlb.append("AND a.idcategoriaanp = " + idcategoria + " ");
    	sqlb.append("ORDER BY a.desareanatural");
    	sql					= sqlb.toString();

//    	System.out.println("sql - lista ANPs : " + sql);
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
    }
    
    
    
    /*-----------------REPORTES------------*/
    public List<PersonalAsistenciaVO> listaInasistenciasRangoFechas(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual, int tipoReporte){
    	/*
    	if(intUbicacion == 0){
    		intUbicacion = 1;
    	}else if(intUbicacion == 1){
    		intUbicacion = 0;
    	}
    	
    	StringBuffer sqlb	= new StringBuffer(SqlConstants.listaInasistenciasRangoFechas);
    	
    	sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural  AND p.int_flag !=  " + intUbicacion +" ");
    	sqlb.append("INNER JOIN sernanp.t_personal_asistencia pa ON p.idpersonal = pa.idpersonal "); //AND pa.int_estado = 1 " ); 
    	sqlb.append("INNER JOIN sernanp.t_asistencia_turno pt ON pt.srl_id_asis_turno = p.srl_id_asis_turno ");
		sqlb.append("WHERE pa.dte_fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' ");
		sqlb.append("AND (SELECT EXTRACT(DOW FROM pa.dte_fecha)) NOT IN (6,0) ");
		
		if(idPersonal > 0 )sqlb.append("AND p.idpersonal = "+ idPersonal +" ");
		
		if (regimenContractual > 0 ){
			sqlb.append("AND (SELECT srl_id_regimen_contractual FROM sernanp.t_personal_contrato ");
			sqlb.append("WHERE idpersonal = p.idpersonal 	AND dte_fec_inicio <= '"  + fechaFin + "' ");
			sqlb.append("ORDER BY dte_fec_inicio DESC 	LIMIT 1	) = " + regimenContractual + " " );
		}
		
		sqlb.append("ORDER BY 2, 5, 6 ");*/
    	
    	this.jdbcTemplate.queryForInt("SELECT sernanp.fn_genera_view_personal_asistencia('" + fechaInicio + "', '" + fechaFin + "', " + intUbicacion +", " + idPersonal +", " + regimenContractual + ", " + tipoReporte + ")");
    	
    	StringBuffer sqlb	= new StringBuffer(SqlConstants.listaInasistenciasRangoFechas);
		String sql			= sqlb.toString();
//		System.out.println("Reporte Inansistencias - sql : " + sql);    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listaInasistenciaxRangoFechas());
    	
//    	return this.jdbcTemplate.query(sql,new Object[]{intUbicacion, fechaInicio, fechaFin}, new RowMappersConstants.listaInasistenciaxRangoFechas());
    	

    }
    
    
    public List<PersonalDesplazamientoVO> listarPersonalporActividad(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){
    	
    	this.jdbcTemplate.queryForInt("SELECT sernanp.fn_genera_view_personal_por_papeleta()");
    	
    	if(intUbicacion == 0){
    		intUbicacion = 1;
    	}else if(intUbicacion == 1){
    		intUbicacion = 0;
    	}
    	
    	StringBuffer sqlb	= new StringBuffer(SqlConstants.listaPersonalporActividad);
    	sqlb.append("AND p.int_flag !=  " + intUbicacion +" ");
    	
    	sqlb.append("WHERE fecha_inicio_papeleta BETWEEN '" + fechaInicio + "' AND '"+ fechaFin + "' AND ");
    	
    	
    	sqlb.append("COALESCE(fecha_fin_papeleta, fecha_inicio_papeleta) BETWEEN '" + fechaInicio + "' AND '"+ fechaFin + "' ");
    	
    	/*
    	 * SE COMENTO 22-01-2016 DAVID
    	 * 
    	sqlb.append("WHERE CASE 	WHEN fecha_fin_papeleta ISNULL THEN ");
    	
    	sqlb.append("fecha_inicio_papeleta BETWEEN '" + fechaInicio + "' AND '"+ fechaFin + "' ");
    	sqlb.append(" ELSE ");
    	sqlb.append("EXTRACT (YEAR FROM '" + fechaInicio + "'  :: DATE) BETWEEN EXTRACT(YEAR FROM fecha_inicio_papeleta) AND EXTRACT(YEAR FROM fecha_fin_papeleta) AND ");
    	sqlb.append("EXTRACT (MONTH FROM '" + fechaInicio + "' :: DATE) BETWEEN EXTRACT(MONTH FROM fecha_inicio_papeleta) AND EXTRACT(MONTH FROM fecha_fin_papeleta) OR ");
    	
    	sqlb.append("EXTRACT(MONTH FROM '" + fechaFin + "' :: DATE) BETWEEN EXTRACT(MONTH FROM fecha_inicio_papeleta) AND EXTRACT(MONTH FROM fecha_fin_papeleta) END ");
    	
    	sqlb.append("AND EXTRACT (YEAR FROM '" + fechaInicio + "' :: DATE) <= EXTRACT(YEAR FROM fecha_inicio_papeleta) ");
    	
    	*/
    	
//    	sqlb.append("WHERE fecha_inicio_papeleta BETWEEN '" + fechaInicio + "' AND '"+ fechaFin + "' ");
    	
    	if(idPersonal > 0 )sqlb.append("AND p.idpersonal = "+ idPersonal +" ");
    	
		if (regimenContractual > 0 ){
			sqlb.append("AND (SELECT srl_id_regimen_contractual FROM sernanp.t_personal_contrato ");
			sqlb.append("WHERE idpersonal = p.idpersonal 	ORDER BY dte_fec_inicio DESC 	LIMIT 1	) = " + regimenContractual + " " );
		}

		sqlb.append("ORDER BY 12, 2, 5, 7 ");
		String sql			= sqlb.toString();
		System.out.println("Reporte x actividad - sql : " + sql);    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listaPersonalporActividad());
    }
    
    
    
    public List<PersonalAsistenciaResumenVO> listarPersonalResumenAsistencia(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){
    	
    	this.jdbcTemplate.queryForInt("SELECT sernanp.fn_genera_view_personal_asistencia_resumen('"+fechaInicio+"', '"+fechaFin+"', "+intUbicacion +", "+idPersonal+")");
    	
    	StringBuffer sqlb	= new StringBuffer(SqlConstants.listarPersonalAsistenciaResumen);
    	
		if (regimenContractual > 0 ){
			sqlb.append("WHERE (SELECT srl_id_regimen_contractual FROM sernanp.t_personal_contrato pc ");
			sqlb.append("WHERE pc.idpersonal = parv.idpersonal ORDER BY dte_fec_inicio DESC 	LIMIT 1	) = " + regimenContractual + " " );
		}

		sqlb.append("ORDER BY 2, 3, 4 ");
		String sql			= sqlb.toString();
//		System.out.println("Reporte Resumen Asistencia - sql : " + sql);    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listarPersonalResumenAsistencia());
    }
    
    
    public List<PersonalAsistenciaVO> listarPersonalRecordAsistencias(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){

    	this.jdbcTemplate.queryForInt("SELECT sernanp.fn_genera_view_personal_record_asistencia('" + fechaInicio + "', '" + fechaFin + "', " + intUbicacion +", " + idPersonal +", " + regimenContractual + ")");
    	    	
    	StringBuffer sqlb	= new StringBuffer(SqlConstants.listarPersonalRecordAsistencias);
    	
		sqlb.append("ORDER BY 2, 5, 6 ");
		String sql			= sqlb.toString();
//		System.out.println("Reporte Record Ansistencias - sql : " + sql);    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listarPersonalRecordAsistencias());
    	
//    	return this.jdbcTemplate.query(sql,new Object[]{intUbicacion, fechaInicio, fechaFin}, new RowMappersConstants.listaInasistenciaxRangoFechas());
    	

    }
    
    
    public List<PersonalAsistenciaResumenVO> listarPersonalResumenAsistenciaRecord(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){
    	
    	this.jdbcTemplate.queryForInt("SELECT sernanp.fn_genera_view_personal_record_asistencia_resumen('"+fechaInicio+"', '"+fechaFin+"', "+intUbicacion +", "+idPersonal+")");
    	
    	StringBuffer sqlb	= new StringBuffer(SqlConstants.listarPersonalAsistenciaResumenRecord);		
		String sql			= sqlb.toString();
//		System.out.println("Reporte Resumen Asistencia - sql : " + sql);    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listarPersonalResumenAsistenciaRecord());
    }
    
    
    public List<PersonaldiasnolaborablesVO> listadiasnolaborables(int anio){
    	StringBuffer sqlb 	= new StringBuffer(SqlConstants.listadiasnolaborables);
    	String sql			= sqlb.toString();
    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listardiasnolaborables());
    }
	
    
    public List<PersonaldiasnolaborablesVO> listaperiododiasnolaborables(){
    	StringBuffer sqlb 	= new StringBuffer(SqlConstants.periododiasnolaborables);    	
    	String sql			= sqlb.toString();    	
    	
    	return this.jdbcTemplate.query(sql, new RowMappersConstants.listarperiodosdiasnolaborables());
    }
    
}
