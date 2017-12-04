package proyecto.dao;

 



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.dao.procedure.PersonaNaturalProcedure;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;

@Repository 
public class PersonaNaturalDAO  {


	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private PersonaNaturalProcedure personaNaturalProcedure;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		this.personaNaturalProcedure=new PersonaNaturalProcedure(dataSource);
	}
	  
    
	 public int insertarNoDuplicado(Personanatural personanatural){
		   return personaNaturalProcedure.insertar(personanatural);
	 }
    
	
	public int contarUnico(Personanatural personanatural) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarNumeroDocumentoUnicoPersonaNatural);
		 if(personanatural.getNumerodocumento()!=null){
			 sqlb.append(" and numerodoc='");
			 sqlb.append(personanatural.getNumerodocumento());
			 sqlb.append("'");
		 }
		 if(personanatural.getIdpersonanatural()!=0){
			 sqlb.append(" and idpersonanatural!=");
			 sqlb.append(personanatural.getIdpersonanatural()); 
		 }
		 
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
   
    
	public void actualizar(Personanatural personanatural ){
		StringBuffer sqlb = new StringBuffer("update sernanp.personanatural set idpersonanatural=idpersonanatural ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre",personanatural.getNombre());
		parametros.put("apepat",personanatural.getApepat());
		parametros.put("apemat",personanatural.getApemat());
		parametros.put("idtipodocumento",personanatural.getTipodocumento().getIdtipo());
		parametros.put("numerodoc",personanatural.getNumerodocumento());
		parametros.put("idsexo",personanatural.getSexo().getIdtipo());
		parametros.put("idestadocivil",personanatural.getEstadocivil().getIdtipo());
		parametros.put("fechanacimiento",personanatural.getFechanacimiento());
		if(personanatural.getNombre()!=null){
			sqlb.append(", nombre=upper(:nombre)");
		}
		if(personanatural.getApepat()!=null){
			sqlb.append(", apepat=upper(:apepat)");
		}
		if(personanatural.getApemat()!=null){
			sqlb.append(", apemat=upper(:apemat)");
		}
		if(personanatural.getNumerodocumento()!=null){
			sqlb.append(", numerodoc=:numerodoc");
		}
		if(personanatural.getTipodocumento().getIdtipo()!=0){
			if(personanatural.getTipodocumento().getIdtipo()==ValueConstants.VALOR_CERO){
				sqlb.append(", idtipodocumento=null");	
			}
			else{
				sqlb.append(", idtipodocumento=:idtipodocumento");
			}
		}
		if(personanatural.getSexo().getIdtipo()!=0){
				sqlb.append(", idsexo=:idsexo");
		}
		if(personanatural.getEstadocivil().getIdtipo()!=0){
			if(personanatural.getEstadocivil().getIdtipo()==ValueConstants.VALOR_CERO){
				sqlb.append(", idestadocivil=null");	
			}
			else{
				sqlb.append(", idestadocivil=:idestadocivil");
			}
		}
		if(personanatural.getFechanacimiento()!=null){
			sqlb.append(", fechanacimiento=:fechanacimiento");
		}
		sqlb.append(" where idpersonanatural=");
		sqlb.append(personanatural.getIdpersonanatural());
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql, parametros);
	}
	
	
	
	public void eliminar(int idpersonanatural){
		StringBuffer sqlb = new StringBuffer("delete from sernanp.personanatural ");
		sqlb.append(" where idpersonanatural=");
		sqlb.append(idpersonanatural);
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql);
	}
	
	
//Agregado (Y.C.B)	
	
public List<Personanatural> listarPersonaNaturalxID(int idpersona){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonaNaturalxID);
				
		if( idpersona != 0){
			sqlb.append("  and  idpersona =" );
			sqlb.append(idpersona);			
		}		
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonaNaturalMapper());
		 	
	}
   
//----------
	
	
	
}
