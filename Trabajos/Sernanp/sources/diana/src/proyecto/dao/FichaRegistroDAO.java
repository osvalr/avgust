package proyecto.dao;


import java.util.ArrayList;
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

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Areanatural;
import proyecto.vo.FichaRegistro;
import proyecto.vo.Operadorturismo;


public class FichaRegistroDAO{
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Transactional
	public Map guardarFicha(FichaRegistro fr){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaFichaRegistro);
		String sql =sqlb.toString();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigoficha",fr.getAreanatural().getIdareanatural()+""+fr.getOperadorturismo().getIdpersonajuridica());
		parametros.put("lote", fr.getLote());
		parametros.put("nombreproyecto",fr.getNombreproyecto());
		parametros.put("actividad", fr.getActividad());
		parametros.put("lugar", fr.getLugar());
		parametros.put("idareanatural", fr.getAreanatural().getIdareanatural());		
		parametros.put("idpersonajuridica", fr.getOperadorturismo().getIdpersonajuridica());
		parametros.put("idoperadorturismo", fr.getOperadorturismo().getIdoperadorturismo());
		parametros.put("fechacreacion", fr.getFechacreacion());
		parametros.put("fechaaprobsys", fr.getFechaaprobsys());
		parametros.put("comentario", fr.getComentario());
		
				
		long idficharegistro = this.simpleJdbcTemplate.queryForLong(sql, parametros);
						
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( fr.getPersonalregistro().toArray());
		
		simpleJdbcTemplate.batchUpdate("INSERT INTO sernanp.personalficharegistro(idficharegistro,idpersonalregistro,fechaingreso) " +
				"VALUES ("+idficharegistro+",:idpersonalregistro,:fechaingreso)",batch);
		
		SqlParameterSource[] batch2 = SqlParameterSourceUtils.createBatch( fr.getTipomediotra().toArray());
		
		simpleJdbcTemplate.batchUpdate("INSERT INTO sernanp.tablatipoficharegistro(idficharegistro,idtablatipo) " +
				"VALUES ("+idficharegistro+",:idtipo)",batch2);
		
		Map<String, Object> mr = new HashMap<String, Object>();
		
		mr.put("codigoficha", fr.getAreanatural().getIdareanatural()+""+fr.getOperadorturismo().getIdpersonajuridica()+""+idficharegistro);
		mr.put("idficharegistro", idficharegistro);
		
		return mr;
		
	}
	
	@Transactional
	public void actualizarFicha(FichaRegistro fr){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.actualizaFichaRegistro);
		sqlb.append("WHERE idficharegistro =");
		sqlb.append(fr.getIdficharegistro());
		
		String sql =sqlb.toString();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("lote", fr.getLote());
		parametros.put("nombreproyecto",fr.getNombreproyecto());
		parametros.put("actividad", fr.getActividad());
		parametros.put("lugar", fr.getLugar());
		parametros.put("comentario", fr.getComentario());
		
		parametros.put("fechacreacion", fr.getFechacreacion());		
		
				
		this.simpleJdbcTemplate.update(sql, parametros);
		
		
		this.simpleJdbcTemplate.update("DELETE FROM sernanp.personalficharegistro WHERE idficharegistro = "+fr.getIdficharegistro());
		
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( fr.getPersonalregistro().toArray());
		
		
		
		simpleJdbcTemplate.batchUpdate("INSERT INTO sernanp.personalficharegistro(idficharegistro,idpersonalregistro,fechaingreso) " +
				"VALUES ("+fr.getIdficharegistro()+",:idpersonalregistro,:fechaingreso)",batch);
		
		
		this.simpleJdbcTemplate.update("DELETE FROM sernanp.tablatipoficharegistro WHERE idficharegistro = "+fr.getIdficharegistro());
		
		SqlParameterSource[] batch2 = SqlParameterSourceUtils.createBatch( fr.getTipomediotra().toArray());
		
		simpleJdbcTemplate.batchUpdate("INSERT INTO sernanp.tablatipoficharegistro(idficharegistro,idtablatipo) " +
				"VALUES ("+fr.getIdficharegistro()+",:idtipo)",batch2);
		
	}
	
	
	public List<FichaRegistro> listarEnviados(Areanatural an, Operadorturismo ot){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listarFichasRegistro);
		sqlb.append("WHERE fr.idareanatural = ");
		sqlb.append(an.getIdareanatural());
		sqlb.append(" AND fr.idpersonajuridica = ");
		sqlb.append(ot.getIdpersonajuridica());
		sqlb.append(" ORDER BY fr.fechacreacion desc");
		
		String sql =sqlb.toString();
		
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaRegistroMapper());
		
	}
	
public List<FichaRegistro> listarEnviadosxAreaNatural(Areanatural an){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listarFichasRegistroxAreaNatural);
		sqlb.append("WHERE fr.idareanatural = ");
		sqlb.append(an.getIdareanatural());
		sqlb.append(" ORDER BY fr.fechacreacion desc");
		
		String sql =sqlb.toString();
		
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaRegistroxANMapper());
		
	}

public List<FichaRegistro> listarAprobadosxAreaNatural(Areanatural an){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listarFichasRegistroxAreaNatural);
	sqlb.append("WHERE fr.idareanatural = ");
	sqlb.append(an.getIdareanatural());
	sqlb.append(" AND fr.idestadoficha between ");
	sqlb.append(2);
	sqlb.append(" AND ");
	sqlb.append(3);
	
	sqlb.append(" ORDER BY fr.fechacreacion desc");
	
	String sql =sqlb.toString();
	
	
	return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaRegistroxANMapper());
	
}
	
	public List<FichaRegistro> muestraFicha(int idficharegistro){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFichaRegistro);
		sqlb.append("WHERE fr.idficharegistro = ");
		sqlb.append(idficharegistro);
		
		String sql =sqlb.toString();
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaRegistroMapper_());
	}
	
	public void aprobarFichaRegistro(FichaRegistro fr){
		StringBuffer sqlb = new StringBuffer(SqlConstants.aprobarFichaRegistro);
		sqlb.append("WHERE idficharegistro = ");
		sqlb.append(fr.getIdficharegistro());
		
		String sql =sqlb.toString();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("idestadoficha",fr.getIdestadoficha());
		parametros.put("nombrearchivo",fr.getNombrearchivo());
		parametros.put("fechaaprobacion",fr.getFechaaprobacion());
		
		this.simpleJdbcTemplate.update(sql,parametros);
	}
	
	public void desaprobarFichaRegistro(FichaRegistro fr){
		StringBuffer sqlb = new StringBuffer(SqlConstants.desaprobarFichaRegistro);
		sqlb.append("WHERE idficharegistro = ");
		sqlb.append(fr.getIdficharegistro());
		
		String sql =sqlb.toString();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("idestadoficha",fr.getIdestadoficha());
		parametros.put("observacion", fr.getObservacion());
		parametros.put("fechadesaprobacion", fr.getFechadesaprobacion());
		
		this.simpleJdbcTemplate.update(sql,parametros);
	}
}
