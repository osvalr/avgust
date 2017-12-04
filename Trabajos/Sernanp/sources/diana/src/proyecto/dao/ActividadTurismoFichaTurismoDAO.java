package proyecto.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Actividadturismo;

@Repository 
public class ActividadTurismoFichaTurismoDAO{
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	} 
	
	
	
	
	public List<Actividadturismo> listarxFicha(long idficha  ) {
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaActividadTurismoxFicha);
		if(idficha!=0 ){
			sqlb.append(" and atft.idfichaturismo=" );
			sqlb.append(idficha);
		}
		
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.ActividadTurismoMapper());	
	}
	
	
	public void insertarNoDuplicado(Actividadturismo actividadturismo,long idfichaturismo){
    	Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idactividadturismo",actividadturismo.getIdactividadturismo());
		parametros.put("idfichaturismo",idfichaturismo );
		this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoActividadTurismoFichaTurismo,parametros);
    }
	
	public void insertar(Actividadturismo actividadturismo,long idfichaturismo){
    	Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idactividadturismo",actividadturismo.getIdactividadturismo());
		parametros.put("idfichaturismo",idfichaturismo );
		this.simpleJdbcTemplate.update(SqlConstants.insertaActividadFichaturismo,parametros);
    }
	
 
   public void eliminarDiferencia(List<Actividadturismo> lista,long idfichaturismo){
		StringBuffer sqlb = new StringBuffer("delete from sernanp.actividadturismofichaturismo where ");
		if(lista.size()==0){
			sqlb.append(" idfichaturismo=");
			sqlb.append(idfichaturismo);
		}
		else{
			sqlb.append("idactividadturismo in( select tab.idactividadturismo from (");
			sqlb.append("select * from sernanp.actividadturismofichaturismo where idfichaturismo=");
			sqlb.append(idfichaturismo);
			sqlb.append(") as tab  where tab.idactividadturismo not in(");
			for(Actividadturismo a:lista){
				sqlb.append(a.getIdactividadturismo());
				sqlb.append(",");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append("))");
		}
		String sql =sqlb.toString();
		 //System.out.println(sql);
		simpleJdbcTemplate.update(sql);			
	}
	
	
	 
}
