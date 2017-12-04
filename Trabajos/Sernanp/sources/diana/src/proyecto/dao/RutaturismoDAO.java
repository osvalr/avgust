package proyecto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.Querys;
import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Areanatural;
import proyecto.vo.Rutaturismo;

@Repository 
public class RutaturismoDAO implements Querys {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;
	private static Logger logger = Logger.getLogger(RutaturismoDAO.class); 
	@Autowired
	public void init(DataSource dataSource) {   
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource); 
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
		this.simpleInsert = new SimpleJdbcInsert(dataSource)
        	.withTableName("rutaturismo")
        	.usingGeneratedKeyColumns("idrutaturismo");
	}

	
	public int contarxAreaNatural(Areanatural areanatural){
		StringBuffer sqlb = new StringBuffer(SqlConstants.contarRutaTurismo);
		if(areanatural.getIdareanatural()!=0){
			sqlb.append(" and rt.idturismo in ( select idturismo from sernanp.turismo where idareanatural=" );
			sqlb.append(areanatural.getIdareanatural());
			sqlb.append(")");
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
	
	public List<Rutaturismo> listarxAreaNatural( Areanatural areanatural ){
		StringBuffer sqlb = new StringBuffer("select * from sernanp.rutaturismo rt where 1=1 ");
		if(areanatural.getIdareanatural()!=0){
			sqlb.append(" and rt.idturismo in ( select idturismo from sernanp.turismo where idareanatural=" );
			sqlb.append(areanatural.getIdareanatural());
			sqlb.append(")");
		}
		sqlb.append(" order by rt.nombrerutaturismo ");
		String sql =sqlb.toString();
		//System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RutaTurismoMapper());
		
	}
	
	
	
	public List<Rutaturismo> listar( Rutaturismo rutaturismo ){
		StringBuffer sqlb = new StringBuffer("select * from sernanp.rutaturismo rt where 1=1 ");
		if(rutaturismo.getIdrutaturismo()!=0){
			sqlb.append(" and rt.idrutaturismo=" );
			sqlb.append(rutaturismo.getIdrutaturismo());
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RutaTurismoMapper());
		
	}
	
	
	
	
	public int size( int idareanatural ) {
		String sql = "SELECT count(*) FROM sernanp.rutaturismo r " +
				"inner join sernanp.turismo t on  t.idturismo = r.idturismo " +
				"inner join sernanp.areanatural a on a.idareanatural = t.idareanatural " +
				"where a.idareanatural = " +
				idareanatural;
	    return simpleJdbcTemplate.queryForInt(sql);
	}
	
	public List<Rutaturismo> listar() {
		return simpleJdbcTemplate.query(
				"SELECT r.idrutaturismo, r.nombrerutaturismo FROM sernanp.rutaturismo r",
				ParameterizedBeanPropertyRowMapper.newInstance(Rutaturismo.class));
	}

	public List<Rutaturismo> listarxTipo( int idtipoturismo ) {
		return simpleJdbcTemplate.query(
				"SELECT r.idrutaturismo, r.nombrerutaturismo  FROM sernanp.rutaturismo r " +
				"INNER JOIN sernanp.rutaturismotipoturismo rt ON rt.idrutaturismo = r.idrutaturismo " +
				"AND rt.idtipoturismo = "+idtipoturismo,
				ParameterizedBeanPropertyRowMapper.newInstance(Rutaturismo.class));
	}

	
	// JCEV 30-07-2012	
		public List<Rutaturismo> listar(Areanatural areanatural){
			StringBuffer sqlb      = null;
			List<Rutaturismo> lLst = null;
			String sql             = null;
			try {
				sqlb = new StringBuffer("select * from sernanp.rutaturismo rt where 1=1 ");
				if(areanatural.getCodareanatural() != null){
					sqlb.append(" and rt.codrutaturismo LIKE '" );
					sqlb.append(areanatural.getCodareanatural());
					sqlb.append("%'");
				}
				sql = sqlb.toString();
//				System.out.println("sql listar [RutaturismoDAO]: " + sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			lLst = this.jdbcTemplate.query(sql, new RowMappersConstants.RutaTurismoMapper());
	 	    return lLst;		
		}
		
		// JCEV 08-08-2012, actualizado : 15/08/2012
//		public List<Rutaturismo> listarDetalleBoletaje(String strId, String strFecIni, String strFecFin){
		public List<Rutaturismo> listarDetalleBoletaje(String strId){
			StringBuffer sqlb      = null;
			List<Rutaturismo> lLst = null;
			String sql             = null;
			try {
				lLst = new ArrayList<Rutaturismo>();
				sqlb = new StringBuffer(SqlConstants.listaDetalleBoletaje);
				if(!strId.equalsIgnoreCase("")){
					sqlb.append(" TRIM(a.registroturista) LIKE '" + strId + "' and");
					sqlb.append(" TRIM(b.codigoficha)     LIKE '" + strId + "' and");
					sqlb.append(" c.idfichaturismo  =  b.idfichaturismo   and");
					sqlb.append(" d.idrutaturismo   = b.idrutaturismo     and");
					sqlb.append(" d.idboletaje      =  c.idboletaje ");
				}
//				if(strFecIni != null && strFecFin != null){
//					sqlb.append(" and a.fechamovimiento between to_date('" + strFecIni + "', 'dd/MM/yyyy') and " +
//				                "to_date('" + strFecIni + "', 'dd/MM/yyyy')");
//				}
				sqlb.append(" ORDER BY c.idvisitante, d.idboletaje, a.fechamovimiento");			
				sql = sqlb.toString();				
				
				lLst = this.jdbcTemplate.query(sql, new RowMappersConstants.DetalleTurismoControlPagosMapper());
			} catch (Exception e) {
				e.printStackTrace();
			}
	 	    return lLst;
		}	
	
	
	/*
	public List<Rutaturismo> listarxArea( int idareanatural ){
		String sql =   
			"SELECT r.idrutaturismo, r.nombrerutaturismo  FROM sernanp.rutaturismo r " +
			"INNER JOIN sernanp.turismo t ON t.idturismo = r.idturismo " +
			"INNER JOIN sernanp.boletaje b ON b.idrutaturismo = r.idrutaturismo "+   
			"WHERE t.idareanatural = " +idareanatural+ " "+
			"GROUP BY r.idrutaturismo"
			;
		return simpleJdbcTemplate.query(  
				sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Rutaturismo.class) );
		
	}
	*/
	
	
	
//	public Rutaturismo save(Rutaturismo ruta){    
//
//		ruta.setCodrutaturismo( 
//				simpleJdbcTemplate.queryForObject(
//							GENERATECODETURISMO, 
//							String.class,  
//							new Object[]{ ruta.getIdturismo() } ) 
//			);
//		ruta.setIdrutaturismo( 
//				(Long)simpleInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(ruta))
//			);   
//
//		for(Boletaje b : ruta.getBoletajes()){ 
//				b.setIdrutaturismo( ruta.getIdrutaturismo() ); 
//		}
//		
//		for(Tipoturismo t : ruta.getTipoturismos() ){  
//				t.setIdrutaturismo( ruta.getIdrutaturismo() );    
//		}   
//		  
// 		simpleJdbcTemplate.batchUpdate(
//				INSERTBOLETOS,      
//				SqlParameterSourceUtils.createBatch( ruta.getBoletajes().toArray() ) );          
// 
// 		simpleJdbcTemplate.batchUpdate(
// 				INSERT_RUTATURISMO_TIPOTURISMO,     
//				SqlParameterSourceUtils.createBatch( ruta.getTipoturismos().toArray() ) ); 
//
// 		
//		return ruta;
//	}
	
}
