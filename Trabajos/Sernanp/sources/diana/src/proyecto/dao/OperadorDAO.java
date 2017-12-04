package proyecto.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.param.OperadorParam;
import proyecto.vo.Operadorturismo;
import proyecto.vo.TurismoOperadorturismo;

@Repository 
public class OperadorDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired  
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	public int insertarNoDuplicado(Operadorturismo operadorturismo){
    	Map<String, Object> parametros = new HashMap<String, Object>();
    	parametros.put("idpersonajuridica",operadorturismo.getIdpersonajuridica());
    	parametros.put("flagregistro",operadorturismo.getFlagregistro());
    	parametros.put("username",operadorturismo.getUsuario().getUsername());
    	parametros.put("clave",operadorturismo.getUsuario().getClave());
    	parametros.put("idrol",operadorturismo.getUsuario().getRol().getIdrol());
		return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoOperadorturismo,parametros);
   }
	
	 public int insertar(Operadorturismo operadorturismo){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
	    	parametros.put("nombre",operadorturismo.getNombrepersonajuridica() );
			parametros.put("razonsocial",operadorturismo.getRazonsocial() );
			parametros.put("siglas",operadorturismo.getSiglas() );
			parametros.put("ruc",operadorturismo.getRuc());
			parametros.put("direccion",operadorturismo.getDireccion() );
			parametros.put("telefono",operadorturismo.getTelefono());
			parametros.put("correopersonal",operadorturismo.getCorreopersonal() );
			parametros.put("correoinstitucional",operadorturismo.getCorreoinstitucional() );
			parametros.put("idpais",operadorturismo.getPais().getIdpais());
			if(operadorturismo.getUbigeo().getIdubigeo()==0){
				parametros.put("idubigeo",null);
			}else{
				parametros.put("idubigeo",operadorturismo.getUbigeo().getIdubigeo());
			}
			parametros.put("flagregistro", operadorturismo.getFlagregistro());
			parametros.put("idusuario",operadorturismo.getUsuario().getIdUsuario());
			return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaOperadorTurismo,parametros);
	 }
   
   public List<Operadorturismo> listar(Operadorturismo operadorturismo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaOperadorTurismo);
		agregarClausulasConsulta(operadorturismo, sqlb);
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.OperadorTurismoMapper());
		 	
	}   
      
   public int contar(Operadorturismo operadorturismo) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarOperadorTurismo);
		 agregarClausulasConsulta(operadorturismo, sqlb);
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
  
   public List<Operadorturismo> listarPaginado(Operadorturismo operadorturismo,int offset,int tamPagina) {
		 
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaOperadorTurismo);
		 agregarClausulasConsulta(operadorturismo, sqlb);
			sqlb.append(" order by pj.nombrepersonajuridica  ");
			sqlb.append(" LIMIT ");
			sqlb.append(tamPagina);
			sqlb.append(" OFFSET ");
			sqlb.append(offset);
			 String sql =sqlb.toString();
			//System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.OperadorTurismoMapper() );	 
	 }
   
   
  public void agregarClausulasConsulta(Operadorturismo operadorturismo, StringBuffer sqlb){
	   
	   //clausulas datos basicos operador
	   if(operadorturismo.getIdoperadorturismo()!=0 ){
			sqlb.append(" and ot.idoperadorturismo=" );
			sqlb.append(operadorturismo.getIdoperadorturismo());
		}
	   if(operadorturismo.getFlagregistro()!=0){
		   if(operadorturismo.getFlagregistro()==ValueConstants.VALOR_CERO){
			   sqlb.append(" and ot.flagregistro=0" );
		   }else{
			   sqlb.append(" and ot.flagregistro=" );
				sqlb.append(operadorturismo.getFlagregistro());
		   }
		   
	   }
		if(operadorturismo.getUsuario().getIdUsuario()!=0 ){
			sqlb.append(" and ot.idusuario=" );
			sqlb.append(operadorturismo.getUsuario().getIdUsuario());
		}
		if(operadorturismo.getNombrepersonajuridica()!=null){
			sqlb.append(" and upper(pj.nombrepersonajuridica) like upper('%" );
			sqlb.append(operadorturismo.getNombrepersonajuridica());
			sqlb.append("%')");
		}
		if(operadorturismo.getUsuario().getUsername()!=null ){
			sqlb.append(" and upper(usu.usuario) like upper('%" );
			sqlb.append(operadorturismo.getUsuario().getUsername());
			sqlb.append("%')");
		}
		if(operadorturismo.getFlagagenciaviaje()!=0){
			if(operadorturismo.getFlagagenciaviaje()==ValueConstants.VALOR_CERO){
				sqlb.append(" and ot.flagagenciaviaje=0");	
			}
			else{
				sqlb.append(" and ot.flagagenciaviaje=");
				sqlb.append(operadorturismo.getFlagagenciaviaje());
			}
		}
		
		
		
   }
    
   public int contar(OperadorParam operadorParam) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarOperadorTurismo);
		 agregarClausulasConsulta(operadorParam, sqlb);
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
   
   public List<Operadorturismo> listarPaginado(OperadorParam operadorParam,int offset,int tamPagina) {
		 
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaOperadorTurismo);
		 agregarClausulasConsulta(operadorParam, sqlb);
			sqlb.append(" order by pj.nombrepersonajuridica  ");
			sqlb.append(" LIMIT ");
			sqlb.append(tamPagina);
			sqlb.append(" OFFSET ");
			sqlb.append(offset);
			 String sql =sqlb.toString();
			//System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.OperadorTurismoMapper() );	 
	 }
   
   
public void agregarClausulasConsulta(OperadorParam operadorParam, StringBuffer sqlb){
	   
	   //clausulas datos basicos operador
	   if(operadorParam.getOperadorturismo().getIdoperadorturismo()!=0 ){
			sqlb.append(" and ot.idoperadorturismo=" );
			sqlb.append(operadorParam.getOperadorturismo());
		}
	   if(operadorParam.getOperadorturismo().getFlagregistro()!=0){
		   if(operadorParam.getOperadorturismo().getFlagregistro()==ValueConstants.VALOR_CERO){
			   sqlb.append(" and ot.flagregistro=0" );
		   }else{
			   sqlb.append(" and ot.flagregistro=" );
				sqlb.append(operadorParam.getOperadorturismo().getFlagregistro());
		   }
		   
	   }
		if(operadorParam.getOperadorturismo().getUsuario().getIdUsuario()!=0 ){
			sqlb.append(" and ot.idusuario=" );
			sqlb.append(operadorParam.getOperadorturismo());
		}
		if(operadorParam.getOperadorturismo().getNombrepersonajuridica()!=null){
			sqlb.append(" and upper(pj.nombrepersonajuridica) like upper('%" );
			sqlb.append(operadorParam.getOperadorturismo().getNombrepersonajuridica());
			sqlb.append("%')");
		}
		if(operadorParam.getOperadorturismo().getUsuario().getUsername()!=null ){
			sqlb.append(" and upper(usu.usuario) like upper('%" );
			sqlb.append(operadorParam.getOperadorturismo().getUsuario().getUsername());
			sqlb.append("%')");
		}
		if(operadorParam.getOperadorturismo().getFlagagenciaviaje()!=0){
			if(operadorParam.getOperadorturismo().getFlagagenciaviaje()==ValueConstants.VALOR_CERO){
				sqlb.append(" and ot.flagagenciaviaje=0");	
			}
			else{
				sqlb.append(" and ot.flagagenciaviaje=");
				sqlb.append(operadorParam.getOperadorturismo().getFlagagenciaviaje());
			}
		}
		
		//clausulas datos anp con turismo
		
		if(operadorParam.getTurismo().getIdturismo()!=0){
			sqlb.append(SqlConstants.listaOperadorSubTurismo);
			sqlb.append(operadorParam.getTurismo().getIdturismo());
		    sqlb.append(")");
		}
		
   }
   
 
   
   public List<Operadorturismo> listarxAreaNatural(TurismoOperadorturismo turismoOperadorturismo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaOperadorTurismoxAreaNatural);
		if(turismoOperadorturismo.getOperadorturismo().getFlagagenciaviaje()!=0){
			if(turismoOperadorturismo.getOperadorturismo().getFlagagenciaviaje()==ValueConstants.VALOR_CERO){
				sqlb.append(" and ot.flagagenciaviaje=0");	
			}
			else{
				sqlb.append(" and ot.flagagenciaviaje=");
				sqlb.append(turismoOperadorturismo.getOperadorturismo().getFlagagenciaviaje());
			}
		}
		if(turismoOperadorturismo.getOperadorturismo().getFlagregistro()!=0){
			if(turismoOperadorturismo.getOperadorturismo().getFlagregistro()==ValueConstants.VALOR_CERO){
				sqlb.append(" and ot.flagregistro=0");
			}else{
				sqlb.append(" and ot.flagregistro=");
				sqlb.append(turismoOperadorturismo.getOperadorturismo().getFlagregistro());
			}
		}
		if(turismoOperadorturismo.getTurismo().getIdareanatural()!=0){
			sqlb.append(" and an.idareanatural=");
			sqlb.append(turismoOperadorturismo.getTurismo().getIdareanatural());
		}
		sqlb.append(" order by pj.nombrepersonajuridica");
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.OperadorTurismoxAreaNaturalMapper());
		 	
	}
   
   
 public void actualizar(Operadorturismo operadorturismo){
	StringBuffer sqlb = new StringBuffer("update sernanp.operadorturismo set idoperadorturismo=idoperadorturismo ");
	Map<String, Object> parametros = new HashMap<String, Object>();
	parametros.put("flagregistro", operadorturismo.getFlagregistro());
	
	if(operadorturismo.getFlagregistro()!=0){
		if(operadorturismo.getFlagregistro()==ValueConstants.VALOR_CERO){
			sqlb.append(", flagregistro=0");	
		}
		else{
			sqlb.append(", flagregistro=:flagregistro");
		}
	}
	sqlb.append(" where idoperadorturismo=");
	sqlb.append(operadorturismo.getIdoperadorturismo());
	String sql =sqlb.toString();
	simpleJdbcTemplate.update(sql, parametros);
}
 
 
 public void actualizarUsuario(Operadorturismo operadorturismo){
		StringBuffer sqlb = new StringBuffer("update sernanp.usuario set idusuario=idusuario ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("estado", operadorturismo.getUsuario().getEstado());
		
		if(operadorturismo.getUsuario().getEstado()!=0){
			if(operadorturismo.getUsuario().getEstado()==ValueConstants.VALOR_CERO){
				sqlb.append(", estado=0");	
			}
			else{
				sqlb.append(", estado=:estado");
			}
		}
		sqlb.append(" where idusuario=" +
		  " (select idusuario from sernanp.operadorturismo where idoperadorturismo=");
		sqlb.append(operadorturismo.getIdoperadorturismo());
		sqlb.append(")");
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql, parametros);
	}
 
   
//   public void actualizar(Operadorturismo operadorturismo){
//		StringBuffer sqlb = new StringBuffer("update sernanp.operadorturismo set idoperadorturismo=idoperadorturismo ");
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("clave",operadorturismo.getClave() );
//		parametros.put("firstlogin",operadorturismo.getFirstlogin());
//		if(operadorturismo.getClave()!=null){
//			sqlb.append(",  clave=md5(:clave)");
//		}
//		if(operadorturismo.getFirstlogin()!=0){
//			if(operadorturismo.getFirstlogin()==ValueConstants.VALOR_CERO){
//				sqlb.append(", firstlogin=0");	
//			}
//			else{
//				sqlb.append(", firstlogin=:firstlogin");
//			}
//		}
//		sqlb.append(" where idoperadorturismo=");
//		sqlb.append(operadorturismo.getIdoperadorturismo());
//		String sql =sqlb.toString();
//		System.out.println(sql);
//		simpleJdbcTemplate.update(sql, parametros);
//   }
   
	
	public List<Operadorturismo> listar() {
		return simpleJdbcTemplate.query(
				"SELECT o.idoperadorturismo,j.nombrepersonajuridica " +  
			    "FROM sernanp.operadorturismo o " +
			    "INNER JOIN sernanp.personajuridica j on o.idpersonajuridica = j.idpersonajuridica",
				ParameterizedBeanPropertyRowMapper.newInstance(Operadorturismo.class));
	} 

	public List<Operadorturismo> listar( int idarea ) {  
		return simpleJdbcTemplate.query(  
				"SELECT o.idoperadorturismo,j.nombrepersonajuridica " +  
			    "FROM sernanp.operadorturismo o " +  
			    "INNER JOIN sernanp.personajuridica j on o.idpersonajuridica = j.idpersonajuridica " +
			    "INNER JOIN sernanp.turismooperadorturismo tot ON tot.idoperadorturismo = o.idoperadorturismo " +
			    "INNER JOIN sernanp.turismo t ON t.idturismo = tot.idturismo    " + 
			    "INNER JOIN sernanp.areanatural a ON a.idareanatural  = t.idareanatural AND a.idareanatural = " +         
			    idarea, 
				ParameterizedBeanPropertyRowMapper.newInstance(Operadorturismo.class)); 
	}
	
}  
