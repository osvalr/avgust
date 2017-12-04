package proyecto.dao;

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

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.PersonalFichaRegistro;
import proyecto.vo.PersonalRegistro;

public class PersonalRegistroDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired  
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	public void insertar(List<PersonalRegistro> pr){
    	
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( pr.toArray());
				
		simpleJdbcTemplate.batchUpdate(SqlConstants.insertaPersonaRegistro,batch);

	}
	
	public void eliminar(int idpr){
    	
		StringBuffer sqlb = new StringBuffer(SqlConstants.eliminarPersonaRegistro);
		sqlb.append("WHERE idpersonalregistro =" );
		sqlb.append(idpr);	
		
		String sql =sqlb.toString();
		
		this.simpleJdbcTemplate.update(sql);

	}
	
	public long insertarinform(PersonalRegistro pr){
    	
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaPersonaRegistroForm);
		String sql =sqlb.toString();
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("nombre", pr.getNombre());
		parametros.put("apepat", pr.getApepat());
		parametros.put("apemat", pr.getApemat());
		parametros.put("empresa", pr.getEmpresa());
		parametros.put("idtipodocumento", pr.getTipodocumento().getIdtipo());
		parametros.put("numerodocumento", pr.getNumerodocumento());
		parametros.put("idtipolocal", pr.getTipolocal().getIdtipo());
		parametros.put("idsexo", pr.getSexo().getIdtipo());
		parametros.put("idpersonajuridica", pr.getOperadorturismo().getIdpersonajuridica());
		parametros.put("idoperadorturismo", pr.getOperadorturismo().getIdoperadorturismo());
		parametros.put("idareanatural", pr.getAreanatural().getIdareanatural());
			
		return this.simpleJdbcTemplate.queryForLong(sql, parametros);	

	}
	
	public void actualizar(List<PersonalRegistro> pr){
    	
		StringBuffer sqlb = new StringBuffer(SqlConstants.actualizarPersonaRegistro);
		sqlb.append("WHERE idpersonalregistro =" );
		sqlb.append(pr.get(0).getIdpersonalregistro());	
		
		String sql =sqlb.toString();
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( pr.toArray());
				
		simpleJdbcTemplate.batchUpdate(sql,batch);

	}
	
	public List<PersonalRegistro> listarPersonalxPJyAN(int idpj, int idanp){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxPJyAN);
		
		sqlb.append("  and  pr.idpersonajuridica =" );
		sqlb.append(idpj);	
		sqlb.append("  and  pr.idareanatural =" );
		sqlb.append(idanp);
		sqlb.append(" order by pr.apepat, pr.apemat, pr.nombre asc");
				
		String sql =sqlb.toString();
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalRegistroMapper());
		 	
	}
		
	public List<PersonalRegistro> listarPersonaUnicoxAreaNatural(int idpj, int idanp, PersonalRegistro pr){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonaUnicoxAreaNatural);
		 
				
		if( pr.getApemat()!=null || pr.getApemat()!=null || pr.getNombre()!=null){
			sqlb.append("  and  ( upper(pr.apepat) like upper('%" );
			sqlb.append(pr.getApepat() );
			sqlb.append("%') " );
			sqlb.append("  or   upper(pr.apemat) like  upper('%" );
			sqlb.append(pr.getApemat() );
			sqlb.append("%') " );
			sqlb.append("  or  upper(pr.nombre) like  upper('%" );
			sqlb.append(pr.getNombre() );
			sqlb.append("%') )" );
			
		}
		
		sqlb.append("  and  pr.idpersonajuridica =" );
		sqlb.append(idpj);	
		sqlb.append("  and  pr.idareanatural =" );
		sqlb.append(idanp);
		sqlb.append(" order by pr.apepat, pr.apemat, pr.nombre ");
	    
		
		 String sql =sqlb.toString();
		 
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalRegistroMapper());
		 	
	}
	
public List<PersonalRegistro> listarPersonalxFicha(int idficharegistro){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxFicha);
		
		sqlb.append("and  pfr.idficharegistro =" );
		sqlb.append(idficharegistro);
				
		String sql =sqlb.toString();
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalRegistroMapper());
		 	
	}

public List<PersonalRegistro> listarPersonalRegistroxID(int idpersonalregistro){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxID);
	
	sqlb.append("WHERE pr.idpersonalregistro =" );
	sqlb.append(idpersonalregistro);
			
	String sql =sqlb.toString();
	
	return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalRegistroMapper());
	 	
}


public List<PersonalRegistro> listarPersonalxDoc(){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxDoc);				
	String sql =sqlb.toString();
	
	return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalRegistroMapperDoc());
	 	
}

public int listarPersonalxTipoNumdoc(int idtipo, String numdoc, int idpj){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxTipoIdDoc);
	sqlb.append("WHERE idtipodocumento =");
	sqlb.append(idtipo);
	sqlb.append(" AND numerodocumento =");
	sqlb.append(" trim('"+numdoc+"')");
	sqlb.append(" AND idpersonajuridica =");	
	sqlb.append(idpj);
	
	
	String sql =sqlb.toString();
			
	return  this.jdbcTemplate.queryForInt(sql);
}

public int listarPersonalxTipoNumdoc(int idtipo, String numdoc, int idpj, int idpr){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxTipoIdDoc);
	sqlb.append("WHERE idtipodocumento =");
	sqlb.append(idtipo);
	sqlb.append(" AND numerodocumento =");
	sqlb.append(" trim('"+numdoc+"')");
	sqlb.append(" AND idpersonajuridica =");	
	sqlb.append(idpj);
	sqlb.append(" AND idpersonalregistro !=");
	sqlb.append(idpr);
	
	String sql =sqlb.toString();
			
	return  this.jdbcTemplate.queryForInt(sql);
}

public int listarPersonalxID(int idpersonalregistro){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxFRxID);
	sqlb.append("WHERE idpersonalregistro =");
	sqlb.append(idpersonalregistro);
	
	String sql =sqlb.toString();
			
	return  this.jdbcTemplate.queryForInt(sql);
}

}
