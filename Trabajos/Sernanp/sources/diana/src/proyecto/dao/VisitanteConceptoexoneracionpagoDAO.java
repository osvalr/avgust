package proyecto.dao;

 



import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.SqlConstants;
import proyecto.vo.Fichaturismo;
import proyecto.vo.Visitante;
import proyecto.vo.VisitanteConceptoexoneracionpago;

@Repository 
public class VisitanteConceptoexoneracionpagoDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	 
	 public void insertar(Visitante visitante){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaVisitanteConceptoexoneracionpago);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idvisitante",visitante.getIdvisitante());
			parametros.put("idconceptoexoneracionpago", visitante.getConceptoexoneracionpago().getIdconceptoexoneracionpago());
			simpleJdbcTemplate.update(sql, parametros);
	}
	
	 public void eliminar(Visitante visitante){
			StringBuffer sqlb = new StringBuffer(SqlConstants.eliminaVisitanteConceptoexoneracionpago);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idvisitante",visitante.getIdvisitante());
			simpleJdbcTemplate.update(sql, parametros);
	}
	 
	 
	 public void eliminarxFicha(Fichaturismo fichaturismo){
			StringBuffer sqlb = new StringBuffer(SqlConstants.eliminaVisitanteConceptoexoneracionpagoxFicha);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idfichaturismo",fichaturismo.getIdfichaturismo());
			simpleJdbcTemplate.update(sql, parametros);
	}
	 
	 public void insertarNoDuplicado(VisitanteConceptoexoneracionpago visitanteConceptoexoneracionpago){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idvisitante",visitanteConceptoexoneracionpago.getVisitante().getIdvisitante());
			parametros.put("idconceptoexoneracionpago",visitanteConceptoexoneracionpago.getConceptoexoneracionpago().getIdconceptoexoneracionpago() );
			this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoVisitanteConceptoExoneracionPago,parametros);
	 } 
	 
//	 public List<TipoturismoFichaturismo> listar(TipoturismoFichaturismo tipoturismoFichaturismo){
//			
//			StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoturismoFichaTurismo);
//			if(tipoturismoFichaturismo.getFichaturismo().getIdfichaturismo()!=0 ){
//				sqlb.append(" and tipft.idfichaturismo=" );
//				sqlb.append(tipoturismoFichaturismo.getFichaturismo().getIdfichaturismo());
//			}
//			if(tipoturismoFichaturismo.getTipoturismo().getIdtipoturismo()!=0 ){
//				sqlb.append(" and tipft.idtipoturismo=" );
//				sqlb.append(tipoturismoFichaturismo.getTipoturismo().getIdtipoturismo());
//			}
//			 String sql =sqlb.toString();
//			 //System.out.println(sql);
//			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoturismoFichaturismoMapper());
//			 	
//	}
	 
	 
	
}
