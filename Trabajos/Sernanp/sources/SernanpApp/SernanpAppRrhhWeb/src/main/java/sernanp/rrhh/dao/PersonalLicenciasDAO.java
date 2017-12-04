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
import sernanp.rrhh.vo.PersonalLicenciasVO;

public class PersonalLicenciasDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public List<PersonalLicenciasVO> listaLicenciasxidPersonal(int idPersonal){
		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listaLicenciasxidPersonal);
		String sql 			= sqlb.toString();
		
//		System.out.println("sql-Licencias : " + sql+" - "+idPersonal);
		
		return this.jdbcTemplate.query(sql, new Object[] {idPersonal}, new RowMappersConstants.listapersonalLicencias());
	}
	
	
//	public void insertarLicenciasPersonal(PersonalLicenciasVO vo, int intEstado){
	@Transactional
	public void insertarLicenciasPersonal(PersonalLicenciasVO vo){
		StringBuffer sqlb 	= null;
		String sql 			= null;
//		if(vo.getInt_est_lic() == 0){//Valor inicial antes de realizar el insert (1)
//		if(intEstado == 0){
			sqlb 	= new StringBuffer(SqlConstants.insertarLicenciasPersonal);
			sql 	= sqlb.toString();
			Map<String, Object> parametros 	= new HashMap<String, Object>();

			parametros.put("dte_fec_inicio_lic", vo.getDte_fec_inicio_lic());
			parametros.put("dte_fec_fin_lic", vo.getDte_fec_fin_lic());
			parametros.put("int_dias_lic", vo.getInt_dias_lic());
			parametros.put("int_est_lic", 1);//1, Esta pendiente, hay que cambiar el estado a 0 para que se pueda ingresar otra licencia
			parametros.put("var_num_resol_autoriza_lic", vo.getVar_num_resol_autoriza_lic().toUpperCase());		
			parametros.put("var_descripcion_lic", vo.getVar_descripcion_lic().toUpperCase());
			parametros.put("tsp_fec_sys_crea", Funciones.fechaHoyTimeStamp());
			parametros.put("idpersonal", vo.getIdPersonallicencia());
			parametros.put("srl_id_per_activ", vo.getTipolicencia().getSrl_id_per_activ());
			
			this.simpleJdbcTemplate.update(sql, parametros);
		/*	
		}else{
			sqlb 	= new StringBuffer(SqlConstants.updateLicenciasPersonal);
			sqlb.append(" dte_fec_inicio_lic = '" + vo.getDte_fec_inicio_lic()+"'");
			sqlb.append(", dte_fec_fin_lic = '" + vo.getDte_fec_fin_lic()+"'");
			sqlb.append(", int_dias_lic = " + vo.getInt_dias_lic());
			sqlb.append(", var_num_resol_autoriza_lic = '" + vo.getVar_num_resol_autoriza_lic()+"'");
			sqlb.append(", var_descripcion_lic = '" + vo.getVar_descripcion_lic()+"'");
			sqlb.append(", tsp_fec_sys_mod = '" + Funciones.fechaHoyTimeStamp()+"'");
			sqlb.append(", srl_id_per_activ = " + vo.getTipolicencia().getSrl_id_per_activ());
			sqlb.append(" WHERE srl_id_pers_lic = " + vo.getSrl_id_pers_lic());
			sql 	= sqlb.toString();				
			
			this.simpleJdbcTemplate.update(sql);
		}*/
		
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_insert_update_licencias(" + vo.getIdPersonallicencia() +",'" + vo.getDte_fec_inicio_lic() + "' )");
		

	}
	
	public void cerrarLicenciasPersonal(int IdLicencia){
		StringBuffer sqlb 	= null;
		String sql 			= null;
		sqlb 	= new StringBuffer(SqlConstants.updateLicenciasPersonal);
		sqlb.append("int_est_lic = 0 ");
		sqlb.append(" WHERE srl_id_pers_lic = " + IdLicencia);
		sql 	= sqlb.toString();			
			
		this.simpleJdbcTemplate.update(sql);		
		
		
	}
	
	
	
	public void eliminarLicenciasPersonal(int IdLicencia, int idPersonal, Date f_iniocLic, Date f_finLic){
		StringBuffer sqlb 	= null;
		String sql 			= null;
		sqlb 	= new StringBuffer(SqlConstants.eliminarLicenciasPersonal);
		sqlb.append(IdLicencia + " AND int_est_lic != 0 " );
		sql 	= sqlb.toString();			
			
		this.simpleJdbcTemplate.update(sql);
		
		
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_delete_licencias(" + idPersonal +",'" + f_iniocLic + "'," +"'"+f_finLic+ "')");
	}
	
	
	public int licenciasRangoFechas(int idPersonal, Date finicio, Date ffin){

		StringBuffer sqlb = new StringBuffer("SELECT count(pl.*) FROM sernanp.t_personal_licencias pl ");
		sqlb.append("WHERE pl.idpersonal = "+idPersonal+" ");
		sqlb.append(" AND (pl.dte_fec_inicio_lic BETWEEN '" + finicio + "'  AND '" + ffin + "' ");
		sqlb.append("OR pl.dte_fec_fin_lic BETWEEN '" + finicio + "'  AND '" + ffin + "' ");
		sqlb.append("OR '" + finicio + "' BETWEEN pl.dte_fec_inicio_lic AND pl.dte_fec_fin_lic ");
		sqlb.append("OR '" + ffin + "' BETWEEN pl.dte_fec_inicio_lic AND pl.dte_fec_fin_lic )");
//		sqlb.append("OR '" + finicio + "' <= pl.dte_fec_fin_lic )");
		
		String sql =  sqlb.toString();
		
//		System.out.println("Licencias registradas - Validando para Vacaciones 1: " + sql);
		
		return	this.jdbcTemplate.queryForInt(sql);			
		
	}
	
	
}