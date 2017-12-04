package sernanp.rrhh.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalVacacionesGoceVO;
import sernanp.rrhh.vo.PersonalVacacionesVO;

public class PersonalVacacionesDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	
	//05-06-2014: D.V.R
		public List<PersonalVacacionesVO> listapersonalVacaciones(String lastdayofyear, String nowdayofyear, String apepat){
			StringBuffer sqlb = new StringBuffer(SqlConstants.listapersonalVacaciones);
			sqlb.append(",CASE WHEN (SELECT EXTRACT(YEAR from (age('"+lastdayofyear+ "',pc.dte_fec_inicio)))) >=1  THEN "); 
			sqlb.append("(SELECT pc.dte_fec_inicio + ((SELECT EXTRACT(YEAR from (age('"+lastdayofyear+ "',pc.dte_fec_inicio))))::character varying ||' year')::interval) END AS fec_ini_prog_vac ");
			sqlb.append(",CASE WHEN (SELECT EXTRACT(YEAR from (age('"+lastdayofyear+"',pc.dte_fec_inicio)))) >=1 AND pv.int_dias_vac_corresponde IS NULL THEN 30 ");
			sqlb.append(" WHEN (SELECT EXTRACT(YEAR from (age('"+lastdayofyear+"',pc.dte_fec_inicio)))) = 0 AND (SELECT EXTRACT(MONTH from (age('"+nowdayofyear+"',pc.dte_fec_inicio)))) > 0 AND pv.int_dias_vac_corresponde IS NULL THEN ");
			sqlb.append("((SELECT EXTRACT(MONTH from (age('" + nowdayofyear + "',pc.dte_fec_inicio)))) * 30 )/12 ");
			sqlb.append("ELSE pv.int_dias_vac_corresponde END AS int_dias_vac_corresponde ");
			sqlb.append("FROM sernanp.personanatural pn "); 
			sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural AND p.int_estado = 0 "); 
			sqlb.append("INNER JOIN sernanp.t_personal_contrato pc ON pc.idpersonal = p.idpersonal "); 
			sqlb.append("LEFT JOIN sernanp.t_personal_vacaciones pv ON pv.idpersonal = p.idpersonal AND pv.int_periodo_vac = (SELECT EXTRACT(YEAR FROM DATE '"+lastdayofyear+"'))");
			
			if(apepat != null) sqlb.append("WHERE pn.apepat LIKE '"+apepat.toUpperCase()+"%'");
			
			sqlb.append("ORDER BY pn.apepat, pn.apemat, pn.nombre ");
			
			
			String sql = sqlb.toString();
			
//			System.out.println("sql-Vacaciones : " + sql);
			
			return this.jdbcTemplate.query(sql,new RowMappersConstants.listapersonalVacaciones());
		}
		
		
		
//		public List<PersonalVacacionesVO> listapersonalVacacionesProyecto(String lastdayofyear, String nowdayofyear, String apepat, int periodo){
		public List<PersonalVacacionesVO> listapersonalVacacionesProyecto(String apepat, int periodo, int idregcontractual, int ubicacion, int idANP, int estadoP){
//			StringBuffer sqlb  	= new StringBuffer("SELECT sernanp.fn_genera_rol_vacaciones_personal(" + periodo	+")");
//			String sql 			= sqlb.toString();
//			this.jdbcTemplate.queryForInt(sql);				
			
			StringBuffer sqlb	= null;
			String sql			= null;
			sqlb = new StringBuffer(SqlConstants.listapersonalVacacionesProyecto);

			//PARA VER SI TIENE VACACIONES PENDIENTES
			sqlb.append(",(SELECT sum(pvx.int_dias_vac_corresponde) - /* SUM(pvx.int_dias_vac_goce)*/ "
					+ "COALESCE((SELECT SUM(pvg.int_dias_goce_vac) FROM sernanp.t_personal_goce_vacaciones pvg "
					+ " INNER JOIN sernanp.t_personal_vacaciones pv ON pv.srl_id_pers_vac = pvg.id_pers_vac "
					+ "	WHERE pv.idpersonal = p.idpersonal),0)"
					+ " FROM sernanp.t_personal_vacaciones pvx ");
			sqlb.append("WHERE pvx.idpersonal = p.idpersonal AND pvx.int_est_vacaciones > 0 AND pvx.int_periodo_vac < " + periodo + ") as vac_pendientes_periodos_ant, p.int_estado  ,pv.int_cant_dias_laborados_truncos ");
			//FIN
			sqlb.append("FROM sernanp.personanatural pn ");
//			sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural AND p.int_estado = 0 ");
			sqlb.append("INNER JOIN sernanp.personal p ON  pn.idpersonanatural = p.idpersonanatural ");			
			if(estadoP >= 0)	sqlb.append("AND p.int_estado = " + estadoP + " ");
//			if(ubicacion == 0){
//				ubicacion = 1;
//			}else if(ubicacion == 1){
//				ubicacion = 0;
//			}
			
			if(ubicacion >= 0 && idANP <= 0)	sqlb.append(" AND p.int_flag = " + ubicacion + " "); 			
			sqlb.append("INNER JOIN sernanp.t_personal_contrato pc ON pc.idpersonal = p.idpersonal AND pc.srl_id_contrato_padre ISNULL ");//04-08-2014  AND pc.int_est_contrato = 0 ");
			if(idregcontractual > 0) 	sqlb.append(" AND pc.srl_id_regimen_contractual = " + idregcontractual + " ");
			if(idANP > 0) {
				sqlb.append("INNER JOIN sernanp.sede pse ON pse.idsede = pc.srl_id_sede_pres AND pse.idareanatural = " + idANP + " ");
			}			

			sqlb.append("LEFT JOIN sernanp.t_personal_vacaciones pv ON pv.idpersonal = p.idpersonal AND pv.int_periodo_vac  = "+periodo+" ");		

			sqlb.append("GROUP BY pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc, p.idpersonal,pv.int_periodo_vac, pv.dte_fec_inicio_programacion_vac, pv.int_dias_vac_corresponde,  pv.int_dias_vac_goce,   pv.int_dias_vac_truncas,  pv.int_cant_dias_laborados_truncos , pv.srl_id_contrato ");
			
			sqlb.append("ORDER BY pn.apepat, pn.apemat, pn.nombre ");
			
			sql = sqlb.toString();
			
//			System.out.println("sql-Lista Vacaciones : " + sql);			
			
			return this.jdbcTemplate.query(sql,new RowMappersConstants.listapersonalVacaciones());
		}	
		
		
		
		
		public List<PersonalVacacionesVO> listaPeriodosVacaciones (int periodo){
			
			StringBuffer sqlb  	= new StringBuffer("SELECT sernanp.fn_genera_rol_vacaciones_personal(" + periodo	+")");
			String sql 			= sqlb.toString();
			this.jdbcTemplate.queryForInt(sql);	
			
			sqlb = new StringBuffer("SELECT DISTINCT int_periodo_vac  ");
			sqlb.append("FROM sernanp.t_personal_vacaciones ");
			sqlb.append("ORDER BY 1 DESC ");
			sql =  sqlb.toString();
		
			
			return this.jdbcTemplate.query(sql, new RowMappersConstants.listaPeriodosVacaciones());

		}
		
		
		public List<PersonalVacacionesGoceVO> listaVacacionesxidpersonal(int idPersonal, int periodo){
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaVacacionesxidpersonal);
			sqlb.append("WHERE pv.idpersonal = "+idPersonal+" ");
			if(periodo > 0){
				sqlb.append("AND pv.int_periodo_vac = "+periodo+" ");
			}
			
//			sqlb.append("WHERE pv.int_periodo_vac = "+periodo+" AND pv.idpersonal = "+idPersonal+" ");
			sqlb.append("ORDER BY pvg.dte_fec_inicio_goc_vac");				
			String sql =  sqlb.toString();
			
//			System.out.println("Listado Vacaciones : " + sql);
			
			return this.jdbcTemplate.query(sql, new RowMappersConstants.listaVacacionesxidpersonal());
		}
		
		
		

		public List<PersonalVacacionesVO> obtieneVacacionesAutorizadasxidP(int idPersonal){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.tieneVacacionesAutorizadas);		
			sqlb.append("WHERE pv.idpersonal = "+idPersonal);
			sqlb.append(" ORDER BY 2 asc	");		
			String sql =  sqlb.toString();
			
//			System.out.println("obtieneVacacionesAutorizadasxidP : " + sql);
			
			return	this.jdbcTemplate.query(sql, new RowMappersConstants.obtieneVacacionesAutorizadasxidP());
			
			
		}
		
		
		public List<PersonalVacacionesVO> vacacionesPendientesxidPersonal(int idPersonal, int periodo){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.tieneVacacionesAutorizadas);		
			sqlb.append("WHERE pv.idpersonal = "+idPersonal );
			sqlb.append(" AND pv.int_periodo_vac < (SELECT MAX(int_periodo_vac) FROM sernanp.t_personal_vacaciones pv) ");
			sqlb.append(" ORDER BY 2 DESC	");		
			String sql =  sqlb.toString();
			
//			System.out.println("obtieneVacacionesAutorizadasxidP : " + sql);
			
			return	this.jdbcTemplate.query(sql, new RowMappersConstants.obtieneVacacionesAutorizadasxidP());
			
			
		}
		
		
		public int tieneVacacionesconGoce(int idPersonal, int periodo){

			StringBuffer sqlb = new StringBuffer("SELECT count(pvg.*) FROM sernanp.t_personal_goce_vacaciones pvg ");
			sqlb.append("INNER JOIN sernanp.t_personal_vacaciones pv ON pvg.id_pers_vac = pv.srl_id_pers_vac ");//AND pvg.int_estado_goce_vac = 0 ");
			sqlb.append("WHERE pv.int_periodo_vac = "+periodo+" AND pv.idpersonal = "+idPersonal+" ");
			
		
			String sql =  sqlb.toString();
			
//			System.out.println("Tiene Vacaciones utilizadas : " + sql);
			
			return	this.jdbcTemplate.queryForInt(sql);			
			
		}
		
		
//		public int obtienePeriodoVacacionesPendientes(int idPersonal){
//			
//			StringBuffer sqlb = new StringBuffer("SELECT pv.int_periodo_vac FROM sernanp.t_personal_vacaciones pv ");
//			sqlb.append("WHERE pv.idpersonal = "+idPersonal + " ");//+" AND int_est_vacaciones > 0 ");
//			sqlb.append("ORDER BY 1 asc		LIMIT 1 ");
//		
//			String sql =  sqlb.toString();
//			
//			System.out.println("Periodo Vacaciones pendientes : " + sql);
//			
//			return	this.jdbcTemplate.queryForInt(sql);			
//			
//		}
		
		
		
		public int vacacionesPendientesxPeriodoxidPersonal(int idPersonal, int periodo){
			/*StringBuffer sqlb = new StringBuffer("SELECT pv.int_dias_vac_corresponde - pv.int_dias_vac_goce FROM sernanp.t_personal_vacaciones pv ");		
			sqlb.append("WHERE pv.int_periodo_vac = "+periodo+" AND pv.idpersonal = "+idPersonal+" ");*/
			StringBuffer sqlb 	= new StringBuffer("SELECT pv.int_dias_vac_corresponde -  ");
			sqlb.append("(SELECT CASE WHEN SUM(pvg.int_dias_goce_vac) > 0 THEN SUM(pvg.int_dias_goce_vac) ELSE 0 END ");
			sqlb.append("FROM sernanp.t_personal_goce_vacaciones pvg ");
			sqlb.append("LEFT JOIN sernanp.t_personal_vacaciones pv ON pv.srl_id_pers_vac = pvg.id_pers_vac ");
			sqlb.append("WHERE pv.int_periodo_vac = "+periodo+" AND pv.idpersonal = "+idPersonal+") ");
			sqlb.append("FROM sernanp.t_personal_vacaciones pv ");
			sqlb.append("WHERE pv.int_periodo_vac = "+periodo+" AND pv.idpersonal = "+idPersonal);
	
			String sql =  sqlb.toString();
//			System.out.println("Vacaciones Pendientes x periodo : " + sql);
			return this.jdbcTemplate.queryForInt(sql);
		}
		
		
		@Transactional
		public void insertarVacacionesPersonal(PersonalVacacionesGoceVO vo, int idPersonal){
			StringBuffer sqlb 				= new StringBuffer(SqlConstants.insertarVacacionesPersonal);
//			sqlb.append(" RETURNING srl_id_pers_goce_vac ");
			String sql 						= sqlb.toString();
			Map<String, Object> parametros 	= new HashMap<String, Object>();
			parametros.put("id_pers_vac", vo.getId_pers_vac());
			parametros.put("int_dias_goce_vac", vo.getInt_dias_goce_vac());
			parametros.put("dte_fec_inicio_goc_vac", vo.getDte_fec_inicio_goc_vac());
			parametros.put("dte_fec_fin_goc_vac", vo.getDte_fec_fin_goc_vac());
			parametros.put("int_estado_goce_vac", 1);		//1, Esta pendiente, hay que cambiar el estado a 0 para que se pueda ingresar otro periodo de vacaciones
			parametros.put("tsp_fec_post_goce_vac", null);
			parametros.put("var_justificacion_post", vo.getVar_justificacion_post().toUpperCase());

//			System.out.println("sql-insert VaccionesGoce : "+ sql);
			
			this.simpleJdbcTemplate.update(sql, parametros);
			
			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_goce_vacaciones(" + vo.getId_pers_vac()	+", " + idPersonal + ", '" + vo.getDte_fec_inicio_goc_vac() + "')");
			
		}
		
		@Transactional
		public void eliminarVacacionesProgramada(int idp, int periodo, int idVacaciones, int idVacacionesProg){
			
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_delete_vacaciones(" + idp +", "  + idVacacionesProg + ")");

				StringBuffer sqlb 	= new StringBuffer("DELETE FROM sernanp.t_personal_goce_vacaciones "); 
				sqlb.append("WHERE srl_id_pers_goce_vac = " +idVacacionesProg);
				this.simpleJdbcTemplate.update(sqlb.toString());				
				
				
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_rol_vacaciones_fechaInicioProgramacion_when_delete("+ idp + " ," + idVacaciones + " ," +periodo + ")");
			
		}
		
		
		
		@Transactional
		public void updateVacacionesPersonal(PersonalVacacionesGoceVO vo, int idVacaciones, int idVacacionesGoce, int idPersonal){
			StringBuffer sqlb 				= new StringBuffer(SqlConstants.updateGoceVacacionesPersonal);
			StringBuffer sqlb1 				= null;
			String sql 						= null;

			if(idVacacionesGoce > 0 && idVacaciones > 0 ){
				sqlb.append(" int_estado_goce_vac = "+ 0);		//0, Se utilizo las vacaciones
			}else{
				sqlb.append(" int_dias_goce_vac = " + vo.getInt_dias_goce_vac());
				sqlb.append(", dte_fec_inicio_goc_vac = '" + vo.getDte_fec_inicio_goc_vac() + "'");
				sqlb.append(", dte_fec_fin_goc_vac = '" + vo.getDte_fec_fin_goc_vac() + "'");
				//1, Esta pendiente, hay que cambiar el estado a 0 para que se pueda ingresar otro periodo de vacaciones e implica que fue utilizado ese periodo de vacaciones.
				sqlb.append(", int_estado_goce_vac = " + 1);		
				sqlb.append(", tsp_fec_post_goce_vac = '" + Funciones.fechaHoyTimeStamp() + "'");
				sqlb.append(", var_justificacion_post = '" + vo.getVar_justificacion_post() + "'");
//				sqlb.append(" WHERE srl_id_pers_goce_vac = " + vo.getSrl_id_pers_goce_vac());				
			}
			
//			System.out.println("PersonalVacacionesDAO - idGoceVaciones : " + vo.getSrl_id_pers_goce_vac());
			sqlb.append(" WHERE srl_id_pers_goce_vac = " + vo.getSrl_id_pers_goce_vac());			
			
			sql = sqlb.toString();
			
			this.simpleJdbcTemplate.update(sql);			

			if(vo.getDte_fec_inicio_goc_vac() != null ){
				sqlb  = new StringBuffer("SELECT sernanp.fn_update_asistencias_with_goce_vacaciones(" + idVacaciones	+", " + idPersonal + ", '" + vo.getDte_fec_inicio_goc_vac() + "')");
				sql 			= sqlb.toString();
				this.jdbcTemplate.queryForInt(sql);
			}

			
			if(idVacacionesGoce > 0 && idVacaciones > 0 ){
				sqlb  = new StringBuffer("SELECT sernanp.fn_update_rol_vacaciones_with_goce_vacaciones(" + idVacaciones	+ ")");
				sql 			= sqlb.toString();
				this.jdbcTemplate.queryForInt(sql);
			}		
			
		}	
		
		
		public List<PersonalVacacionesGoceVO> obtenerVacacionesProgramadaxid(int id){
			StringBuffer sqlb = new StringBuffer(SqlConstants.obtenerVacacionesProgramadaxid);							
			String sql =  sqlb.toString();
//			System.out.println("obtenerVacacionesProgramadaxid : " + sql+"/"+id);
			return this.jdbcTemplate.query(sql,new Object[] {id}, new RowMappersConstants.obtenerVacacionesProgramadaxid());
		}
		
/*		SE HA DEJADO DE UTILIZAR A SOLICITUD DEL USUARIO (REUNION: 11-07-2014)	
		public void updateFechIniVacacionesPersonal(PersonalVacacionesVO vo){
			StringBuffer sqlb 				= new StringBuffer(SqlConstants.updateVacacionesPersonal);
			String sql 						= null;	

			sqlb.append(" dte_fec_inicio_programacion_vac = '" + vo.getDte_fec_inicio_programacion_vac()+"'");
			sqlb.append(" WHERE srl_id_pers_vac = " + vo.getSrl_id_pers_vac());
			
			sql = sqlb.toString();
			
			this.simpleJdbcTemplate.update(sql);	
		}
		*/
		
		
		
		public int vacacionesRangoFechas(int idPersonal, Date finicio, Date ffin){

			StringBuffer sqlb = new StringBuffer("SELECT count(pvg.*) FROM sernanp.t_personal_goce_vacaciones pvg ");
			sqlb.append("INNER JOIN sernanp.t_personal_vacaciones pv ON pvg.id_pers_vac = pv.srl_id_pers_vac ");//AND pvg.int_estado_goce_vac = 0 ");
			sqlb.append("WHERE pv.idpersonal = "+idPersonal+" ");
			sqlb.append("AND (pvg.dte_fec_inicio_goc_vac BETWEEN '" + finicio + "'  AND '" + ffin + "' ");
			sqlb.append("OR pvg.dte_fec_fin_goc_vac BETWEEN '" + finicio + "'  AND '" + ffin + "' ");
			sqlb.append("OR '" + finicio + "' BETWEEN pvg.dte_fec_inicio_goc_vac AND pvg.dte_fec_fin_goc_vac ");
			sqlb.append("OR '" + ffin + "' BETWEEN pvg.dte_fec_inicio_goc_vac AND pvg.dte_fec_fin_goc_vac )");

			String sql =  sqlb.toString();
			
//			System.out.println("Vacaciones registradas - Validando para Licencias: 1 " + sql);
			
			return	this.jdbcTemplate.queryForInt(sql);			
			
		}
		
		
		public int vacacionesRangoFecha(int idPersonal, Date finicio, Date ffin){

			StringBuffer sqlb = new StringBuffer("SELECT count(pvg.*) FROM sernanp.t_personal_goce_vacaciones pvg ");
			sqlb.append("INNER JOIN sernanp.t_personal_vacaciones pv ON pvg.id_pers_vac = pv.srl_id_pers_vac ");//AND pvg.int_estado_goce_vac = 0 ");
			sqlb.append("WHERE pv.idpersonal = "+idPersonal+" ");
			sqlb.append("AND '" + finicio + "' BETWEEN  pvg.dte_fec_inicio_goc_vac AND pvg.dte_fec_fin_goc_vac ");

			String sql =  sqlb.toString();
			
//			System.out.println("Vacaciones registradas - Reporte Record Asistencia " + sql);
			
			return	this.jdbcTemplate.queryForInt(sql);			
			
		}
		
				

		
}
