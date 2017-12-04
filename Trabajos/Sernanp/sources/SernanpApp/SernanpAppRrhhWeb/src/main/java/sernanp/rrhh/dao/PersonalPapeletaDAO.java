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
import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;

public class PersonalPapeletaDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public int verificaexistePermisoComision(int idPersonal, String fechaPC){
		StringBuffer sqlb	= new StringBuffer(SqlConstants.personalPermisoComisionExiste);
		sqlb.append("WHERE pd.idpersonal = " + idPersonal + " AND pd.dte_fec_sal_desp = '" + fechaPC + "') ");
		sqlb.append("FROM sernanp.t_personal_permiso pp ");
		sqlb.append("WHERE pp.idpersonal = " + idPersonal + " AND (pp.dte_fec_pers_perm_sal = '" + fechaPC +"' ");
		sqlb.append("OR pp.dte_fec_pers_perm_ret = '" + fechaPC + "')");
		
		String sql	= sqlb.toString();
		
//		System.out.println("verificaexistePermisoComision - sql : "+sql);
		return this.jdbcTemplate.queryForInt(sql);
		
	}
	
	
	
	public int verificaexistePermiso(int idPersonal, String fechaP){
		StringBuffer sqlb	= new StringBuffer(SqlConstants.personalPermisoExiste);
		sqlb.append("WHERE pp.idpersonal = " + idPersonal + " AND pp.dte_fec_pers_perm_sal = '" + fechaP + "' ");
		
		String sql	= sqlb.toString();
		
//		System.out.println("verificaexistePermiso - sql : "+sql+"--"+idPersonal);
		return this.jdbcTemplate.queryForInt(sql);
		
	}
	
	
	
	@Transactional
	public void guardarPapeleta(PersonalDesplazamientoVO vo, int actividad){
		
		StringBuffer sqlb	= new StringBuffer(SqlConstants.insertarPersonalComision);
		StringBuffer sqlb1	= new StringBuffer(SqlConstants.insertarPersonalPermiso);
		StringBuffer sqlb2	= new StringBuffer(SqlConstants.UpdateAsistencia);
		String sql			= null;
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if(actividad == 0){// Comision, id = 2

			parametros.put("dte_fec_sal_desp", vo.getDte_fec_sal_desp());
			parametros.put("hor_hor_sal_desp", vo.getHor_hor_sal_desp());
			parametros.put("dte_fec_ret_desp", vo.getDte_fec_ret_desp());
			parametros.put("hor_hor_ret_desp", vo.getHor_hor_ret_desp());
			parametros.put("var_lug_desp", vo.getVar_lug_desp());
			parametros.put("tsp_fec_sys_crea", Funciones.fechaHoyTimeStamp());
			parametros.put("int_usu_crea", null);
			parametros.put("idpersonal", vo.getPersonal().getIdpersonal());
			parametros.put("srl_id_per_activ", 2);
			
			sql	= sqlb.toString();
//			this.simpleJdbcTemplate.update(sql, parametros);
			
		}else{// Permisos
			
			parametros.put("dte_fec_pers_perm_sal", vo.getDte_fec_sal_desp());
			parametros.put("hor_hor_salida", vo.getHor_hor_sal_desp());
			parametros.put("dte_fec_pers_perm_ret", vo.getDte_fec_ret_desp());
			parametros.put("hor_hor_retorno", vo.getHor_hor_ret_desp());
			parametros.put("var_desc_pers_perm", vo.getVar_lug_desp());
			
			if (actividad == 4){// Permiso con Descuento
				parametros.put("idtablatipo", ValueConstants.TipoPermisoSGH);
			}else{//Permiso sin Descuento
				parametros.put("idtablatipo", ValueConstants.TipoPermisoCGH);
			}
			
			parametros.put("int_estado", 0);
			parametros.put("tsp_fec_sys_crea", Funciones.fechaHoyTimeStamp());
			parametros.put("int_id_usu_crea", null);
			parametros.put("tsp_fec_sys_anul", null);
			parametros.put("int_id_usu_anul", null);
			parametros.put("idpersonal", vo.getPersonal().getIdpersonal());
			parametros.put("srl_id_per_activ", vo.getPersonalActividad().getSrl_id_per_activ());		
			
			sql	= sqlb1.toString();
			

		}
		
		this.simpleJdbcTemplate.update(sql, parametros);
		
		if (actividad == 4 ){
			sqlb2.append("SET int_estado = 1 ");
		}else{
			sqlb2.append("SET int_estado = 2 ");	
		}
		
		sqlb2.append("WHERE idpersonal 	= "+ vo.getPersonal().getIdpersonal() + " "); 
		sqlb2.append("AND dte_fecha = '" + vo.getDte_fec_sal_desp() + "'");
		
		sql = sqlb2.toString();
	
		this.jdbcTemplate.update(sql);
		
	}
	

	@Transactional
	
	public void guardarPapeleta(PersonalDesplazamientoVO vo){		
		StringBuffer sqlb1	= new StringBuffer(SqlConstants.insertarPapeleta);
		String sql			= null;
		
		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("dte_fec_sal_desp", vo.getDte_fec_sal_desp());
		parametros.put("hor_hor_sal_desp", vo.getHor_hor_sal_desp());
		parametros.put("dte_fec_ret_desp", vo.getDte_fec_ret_desp());
		parametros.put("hor_hor_ret_desp", vo.getHor_hor_ret_desp());
		parametros.put("var_lug_desp", vo.getVar_lug_desp());
		parametros.put("tsp_fec_sys_crea", Funciones.fechaHoyTimeStamp());
		parametros.put("int_usu_crea", vo.getInt_usu_crea());
		parametros.put("idpersonal", vo.getPersonal().getIdpersonal());
		parametros.put("srl_id_per_activ", vo.getPersonalActividad().getSrl_id_per_activ());
		
		sql	= sqlb1.toString();
				
		int idpapeleta = this.simpleJdbcTemplate.queryForInt(sql, parametros);	
		
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_papeleta("+vo.getPersonal().getIdpersonal()+")");

		
	}

	
	
	
	public List<PersonalDesplazamientoVO> listapapeletaxidP(int idPersonal, int periodo){
		
		StringBuffer sqlb	= new StringBuffer(SqlConstants.listapapeletaxidP);		
		String sql			= sqlb.toString();
		System.out.println("LISTA PAPELETAS X IDP - sql : " + sql+ "--" + idPersonal + " / "+periodo);
		return  this.jdbcTemplate.query(sql, new Object[]{idPersonal, periodo}	, new RowMappersConstants.listapapeletaxidP());
			
	}
	
	
	
	public int cantPapeletaxidPersonalFecha(int idP, Date fechaIni, Date fechFinPap){
		String sql			= null;
		StringBuffer sqlb 	= new StringBuffer("SELECT COUNT(pd.idpersonal) ");
		sqlb.append("FROM sernanp.t_personal_desplazamiento pd ");
		sqlb.append("WHERE pd.dte_fec_sal_desp BETWEEN '" + fechaIni + "' AND '" + fechFinPap + "'");
		sqlb.append("AND pd.hor_hor_sal_desp ISNULL AND pd.idpersonal = " + idP);
		
		sql	 = sqlb.toString();		
		
//		System.out.println("sql papeletas : "+ sql);
		
		return this.jdbcTemplate.queryForInt(sql);
		
		
	}
	
	
	public List<PersonalDesplazamientoVO> papeletaxidP(int idPapeleta){
		
		StringBuffer sqlb	= new StringBuffer(SqlConstants.papeletaxid);		
		String sql			= sqlb.toString();
//		System.out.println("Lista papeleta por id - sql : " + sql + "-- " +idPapeleta);
		return  this.jdbcTemplate.query(sql, new Object[]{idPapeleta}	, new RowMappersConstants.listapapeletaxidP());
			
	}
	
	
	@Transactional
	public void eliminarPapeletaMarcacion(int idPapeleta, int idPersonal, String fecha, int idMarcacion){	
//		System.out.println("EliminPapeletaMarcacion-DAO --> " +idPersonal +", " + idPapeleta + ",'" + fecha + "', '" + fecha + "', " + idMarcacion );		
//		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_delete_papeleta_marcacion_manual('" + fecha + "',"+ idPersonal +", " + idPapeleta + ", " + idMarcacion + ")");
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_delete_papeleta_marcacion_manual("+ idPersonal +", " + idPapeleta + ",'" + fecha + "', '" + fecha + "', " + idMarcacion + ")");
	}
	
	
	@Transactional
	public void eliminarPapeleta(int idPersonal, int idPapeleta, Date fecha_ini, Date fecha_fin, int idMarcacion){
//		System.out.println("EliminPapeleta-DAO --> " +idPersonal +", " + idPapeleta + ",'" + fecha_ini + "', '" + fecha_fin + "', " + idMarcacion );
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_delete_papeleta_marcacion_manual("+ idPersonal +", " + idPapeleta + ",'" + fecha_ini + "', '" + fecha_fin + "', " + idMarcacion + ")");
	}
	
	
	
	public int cantPermisosxidPersonalFecha(int idP, Date fechaIni, Date fechFinPap){
		String sql			= null;
		StringBuffer sqlb 	= new StringBuffer("SELECT count(pp.*)  ");
		sqlb.append("FROM sernanp.t_personal_permiso pp  ");
		sqlb.append("WHERE pp.dte_fec_pers_perm_sal BETWEEN '" + fechaIni + "'  AND '" + fechFinPap + "'");
		sqlb.append("AND pp.hor_hor_salida ISNULL AND pp.idpersonal = " + idP);
		
		sql	 = sqlb.toString();		
		
//		System.out.println("Validando si tiene Permisos : " + sql);
		
		return this.jdbcTemplate.queryForInt(sql);
		
		
	}
	

}
