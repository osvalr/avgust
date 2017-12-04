package proyecto.dao;

import java.util.List;

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
import proyecto.vo.FichaRegistro;
import proyecto.vo.PersonalFichaRegistro;
import proyecto.vo.PersonalRegistro;

public class PersonalFichaRegistroDAO {

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
	public void consolidarFicha(List<PersonalFichaRegistro> lpfr){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.consolidaFichaRegistro);		
		String sql =sqlb.toString();				
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( lpfr.toArray());		
		
		simpleJdbcTemplate.batchUpdate(sql,batch);
		
		simpleJdbcTemplate.update("update sernanp.ficharegistro set idestadoficha=3 where idficharegistro="+lpfr.get(0).getIdficharegistro());
				
	}
	
	public List<PersonalFichaRegistro> datosConsolidado(FichaRegistro fr,PersonalRegistro pr){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalFichaRegistroxFicha);
		
		sqlb.append("where  pfr.idficharegistro =" );
		sqlb.append(fr.getIdficharegistro());
		sqlb.append(" and  pfr.idpersonalregistro =" );
		sqlb.append(pr.getIdpersonalregistro());
				
		String sql =sqlb.toString();
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalFichaRegistroMapper());
		 	
	}
}
