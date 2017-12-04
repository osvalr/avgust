package sernanp.rrhh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.vo.PersonalActividadVO;
import sernanp.rrhh.vo.Tipo;

@Repository
public class TipoDAO  {
	
	@SuppressWarnings("unused")
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	@SuppressWarnings("unused")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
    
   @SuppressWarnings("unchecked")
public List<Tipo> listarTipo(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipo);	
		if(tipo.getIdtabla()!=0){
			sqlb.append(" and t.idtabla=");
			sqlb.append(tipo.getIdtabla());
		}
		 String sql =sqlb.toString(); 
		 
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoMapper());
		 	
	}  
   
   
public List<Tipo> listarTiposEncontrados(Tipo tipo, int idanp){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTiposEncontrados);
		sqlb.append("group by t.idtablatipo, tvm.int_id_motivovisita");
		String sql =sqlb.toString(); 
		 
		return  this.jdbcTemplate.query(sql, new Object[]{tipo.getIdtabla(), idanp}, new RowMappersConstants.TipoMapper());
		 	
	} 
    
 public List<Tipo> listarTipoDocumentoIdentidad(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoDocumentoIdentidad);		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoDocumentoIdentidadMapper());
		 	
	}
	
	
 
 // DAVID 04-09-2013
 
 public List<Tipo> listarTipoMarcacion(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listarTipoMarcacion);		
		if(tipo.getIdtabla()!=0){
			sqlb.append(" and t.idtabla=");
			sqlb.append(tipo.getIdtabla());
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.listarTipoMarcacion());
		 	
	}
 
 
//DAVID 04-09-2013
 
public List<Tipo> listTipoLicencia_Anterior(){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoLicencia);		
		String sql =sqlb.toString();
		//MODIFY 31-07-2014 (D.V.R)
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listMotivoMarcacion());
//		return  this.jdbcTemplate.query(sql, new Object[] {ValueConstants.TipoLicencia}, new RowMappersConstants.listarTipoMarcacion());
		 	
	}


//DAVID 31-07-2014
 
public List<PersonalActividadVO> listTipoLicencia(){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoLicencia);		
		String sql =sqlb.toString();
		//MODIFY 31-07-2014 (D.V.R)
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listMotivoMarcacion());
//		return  this.jdbcTemplate.query(sql, new Object[] {ValueConstants.TipoLicencia}, new RowMappersConstants.listarTipoMarcacion());
		 	
	}
 
}
