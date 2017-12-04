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
import proyecto.vo.Expediente;
import proyecto.vo.Infraccion;
import proyecto.vo.Infractor;
import proyecto.vo.Personal;

@Repository
public class InfractorDAO {
		
		private SimpleJdbcTemplate simpleJdbcTemplate;
	    private JdbcTemplate jdbcTemplate;
		private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
		@Autowired
		public void init(DataSource dataSource) {
			this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
			this.jdbcTemplate=new JdbcTemplate(dataSource);
			this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		}
			
	// Inserta Infractor Natural o Juridico 13-09-2012
	public int insertar(Expediente exp) throws Exception {
		Map<String, Object> parametros = null;
		String strConstants            = null;
		int nTipo                      = 0;
		
		nTipo        = exp.getInfractor().getTipodocumento().getIdtipo();
		parametros   = new HashMap<String, Object>();
		parametros.put("numerodoc", exp.getInfractor().getNumerodocumento());		
		parametros.put("idtipodocumento", nTipo);
				
		if (nTipo == 4){ // Para el Caso de RUC
			// Datos Persona Juridica - 13-09-2012
			strConstants = SqlConstants.insertaInfractorJuridico;
			parametros.put("razonsocial", exp.getInfractor().getEmpresa());
			parametros.put("personJurid", exp.getInfractor().getNombrepersonajuridica());
//			System.out.println("insertar(Expediente exp 1) Razon Social  : " + exp.getInfractor().getEmpresa());
		}else{
			// Datos Persona Natural - 13-09-2012
			strConstants = SqlConstants.insertaInfractor;
			parametros.put("nombre", exp.getInfractor().getNombre());		
			parametros.put("apepat", exp.getInfractor().getApepat());
			parametros.put("apemat", exp.getInfractor().getApemat());
		}		
		return this.simpleJdbcTemplate.queryForInt(strConstants,parametros);
		//return this.simpleJdbcTemplate.update(strConstants,parametros);
	}	
	
	public void actualizar(Expediente exp){
//		String sql="update sernanp.personanatural set nombre=:nombre,apepat=:apepat,apemat=:apemat," +
//		"idsexo=:sexo,idestadocivil=:idestadocivil where idpersonanatural=:idpersonanatural";

		String sql="update sernanp.personanatural set nombre=:nombre,apepat=:apepat,apemat=:apemat " +
		"where idpersonanatural=:idpersonanatural";
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre",exp.getInfractor().getNombre());
		parametros.put("apepat",exp.getInfractor().getApepat());
		parametros.put("apemat",exp.getInfractor().getApemat());
//		parametros.put("sexo",exp.getInfractor().getSexo().getIdtipo());
//		parametros.put("idestadocivil",exp.getInfractor().getEstadocivil().getIdtipo());
		parametros.put("idpersonanatural",exp.getInfractor().getIdpersonanatural());		
		simpleJdbcTemplate.update(sql, parametros);
	}
	
	//SUMAR una infraccion
	public void aumentarInfraccion(int idinfractor){
		String sql = SqlConstants.aumentaInfraccion;
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idinfractor",idinfractor);
		simpleJdbcTemplate.update(sql, parametros);
//		System.out.println("se actualizo la infraccion");		
	}
		
	// Version 17-10-2012 JCEV
	@SuppressWarnings("unchecked")
	public List<Infractor> verificaInfractor(String numeroDoc, int tipDoc){
		List<Infractor> alList = null;
		String sql             = null;
		if(tipDoc == 4){
			// JCEV 17-10-2012
			StringBuffer sqlb = new StringBuffer(SqlConstants.verifiyNotNaturalUser);			
			sqlb.append(" WHERE pj.ruc= '");
			sqlb.append(numeroDoc+"'");			
			sql    = sqlb.toString();
			alList = this.jdbcTemplate.query(sql, new RowMappersConstants.InfractorJuridicoMapper());
		}else{
			// JCEV 17-10-2012
			StringBuffer sqlb = new StringBuffer(SqlConstants.verifyNaturalUser);
			sqlb.append(" WHERE pn.idtipodocumento = ");
			sqlb.append(tipDoc);
			sqlb.append(" AND pn.numerodoc= '");
			sqlb.append(numeroDoc+"'");
			sql    = sqlb.toString();
			alList = this.jdbcTemplate.query(sql, new RowMappersConstants.InfractorMapper());
		}
		return alList;
	}
	
	
	// Verifica infractor en el sistema  JCEV 22-08-2012
	// Version Antigua : 16-10-2012 JCEV
	@SuppressWarnings("unchecked")
	public List<Infractor> xverificaInfractor(String numeroDoc, int tipDoc){
		List<Infractor> alList = null;
		String sql             = null;
		// int nLen               = 0;
		
		// Controla si es una Persona Juridica
		// nLen = numeroDoc.length();
		// System.out.println("entro al rowmapper : " + nLen);
		if(tipDoc == 4){
			StringBuffer sqlb = new StringBuffer(SqlConstants.verificaUsuarioEnSistemaJuridico);			
			sqlb.append(" WHERE pj.ruc= '");
			sqlb.append(numeroDoc+"'");			
			sql    = sqlb.toString();
//			System.out.println("List<Infractor> verificaInfractor : " + sql);		
			alList = this.jdbcTemplate.query(sql, new RowMappersConstants.InfractorJuridicoMapper());
		}else{
			StringBuffer sqlb = new StringBuffer(SqlConstants.verificaUsuarioEnSistema);
			sqlb.append(" WHERE pn.idtipodocumento = ");
			sqlb.append(tipDoc);
			sqlb.append(" AND pn.numerodoc= '");
			sqlb.append(numeroDoc+"'");
			sql    = sqlb.toString();
//			System.out.println("List<Infractor> verificaInfractor : " + sql);		
			alList = this.jdbcTemplate.query(sql, new RowMappersConstants.InfractorMapper());
		}
//		System.out.println("alList = " + alList);
		return alList;
	}

	//obtiene antiguas infracciones en el sistema  JCEV 22-08-2012
	@SuppressWarnings("unchecked")
	public List<Infraccion> obtenerInfraccionesAntiguas(int idInfractor){
		String sql = SqlConstants.obtieneInfraccionesAntiguas;
		sql        += "'" + idInfractor + "'";
//		System.out.println("List<Infraccion> obtenerInfraccionesAntiguas : " + sql);
		return this.jdbcTemplate.query(sql, new RowMappersConstants.InfraccionMapper());
	}

}

/*
 * Original
@SuppressWarnings("unchecked")
public List<Infractor> verificaInfractor(String numeroDoc){
	String sql= SqlConstants.verificaUsuarioEnSistema;
	sql+="'"+numeroDoc+"'";		
	System.out.println("List<Infractor> verificaInfractor : " + sql);		
	return this.jdbcTemplate.query(sql,new RowMappersConstants.InfractorMapper());
}
	public int insertar(Expediente exp){
		//"select sernanp.insertar_infractor(:nombre,:apepat,:apemat,:dni,:sexo,:estadocivil)";
//		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaInfractor);
//		String sql =sqlb.toString();
//		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-mm-dd");
		
		int codigo = 0;
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre", exp.getInfractor().getNombre());		
		parametros.put("apepat", exp.getInfractor().getApepat());
		parametros.put("apemat", exp.getInfractor().getApemat());
		parametros.put("numerodoc", exp.getInfractor().getNumerodocumento());
		
		// JCEV 22-08-2012
//		parametros.put("sexo",exp.getInfractor().getSexo().getIdtipo());
//		parametros.put("estadocivil",exp.getInfractor().getEstadocivil().getIdtipo());
		
		System.out.println("insertar(Expediente exp) Tipo de Documento : " + exp.getInfractor().getTipodocumento() );
		
		parametros.put("idtipodocumento", exp.getInfractor().getTipodocumento().getIdtipo());
						
		return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaInfractor,parametros);		
	}	

	
	public void actualizar(Expediente exp){
//		String sql="update sernanp.personanatural set nombre='" +exp.getInfractor().getNombre()+
//		"',apepat='"+ exp.getInfractor().getApepat()+"',apemat='"+exp.getInfractor().getApemat()+"'," +
//		"idsexo="+exp.getInfractor().getSexo().getIdtipo()+",idestadocivil="+exp.getInfractor().getEstadocivil().getIdtipo();
		
		String sql="update sernanp.personanatural set nombre=:nombre,apepat=:apepat,apemat=:apemat," +
		"idsexo=:sexo,idestadocivil=:idestadocivil where idpersonanatural=:idpersonanatural";
		
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre",exp.getInfractor().getNombre());
		parametros.put("apepat",exp.getInfractor().getApepat());
		parametros.put("apemat",exp.getInfractor().getApemat());
		parametros.put("sexo",exp.getInfractor().getSexo().getIdtipo());
		parametros.put("idestadocivil",exp.getInfractor().getEstadocivil().getIdtipo());
		parametros.put("idpersonanatural",exp.getInfractor().getIdpersonanatural());		
		simpleJdbcTemplate.update(sql, parametros);
	}


*/
