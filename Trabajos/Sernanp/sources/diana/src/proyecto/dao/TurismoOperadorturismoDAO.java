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
import proyecto.vo.Areanatural;
import proyecto.vo.TipoturismoFichaturismo;
import proyecto.vo.Turismo;
import proyecto.vo.TurismoOperadorturismo;

@Repository 
public class TurismoOperadorturismoDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	
	 public void insertar(TurismoOperadorturismo turismoOperadorturismo){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaTurismoOperadorTurismo);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idturismo",turismoOperadorturismo.getTurismo().getIdturismo());
			parametros.put("idoperadorturismo", turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo());
			simpleJdbcTemplate.update(sql, parametros);
	}
	
     public List<Areanatural> listarAreaNaturalxOperadorTurismo(TurismoOperadorturismo turismoOperadorturismo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNaturalxOperadorTurismo);
		if(turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo()!=0 ){
			sqlb.append(" and tot.idoperadorturismo=" );
			sqlb.append(turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo());
		}
		sqlb.append(" order by an.desareanatural " );
		 String sql =sqlb.toString();
		//System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
		 	
	}
	
	
     
     public List<Turismo> listarAreaNaturalTurismoxOperadorTurismo(TurismoOperadorturismo turismoOperadorturismo){
 		
 		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNaturalxOperadorTurismo);
 		if(turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo()!=0 ){
 			sqlb.append(" and tot.idoperadorturismo=" );
 			sqlb.append(turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo());
 		}
 		sqlb.append(" order by an.desareanatural " );
 		 String sql =sqlb.toString();
 		// System.out.println(sql);
 		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TurismoMapper());
 		 	
 	}
     
     public void eliminarDiferencia(List<Turismo> lista,int idoperadorturismo){
			StringBuffer sqlb = new StringBuffer("delete from sernanp.turismooperadorturismo where ");
			if(lista.size()==0){
				sqlb.append(" idoperadorturismo=");
				sqlb.append(idoperadorturismo);
			}
			else{
				sqlb.append("idturismo in( select tab.idturismo from (");
				sqlb.append("select * from sernanp.turismooperadorturismo where idoperadorturismo=");
				sqlb.append(idoperadorturismo);
				sqlb.append(") as tab  where tab.idturismo not in(");
				for(Turismo tur:lista){
					sqlb.append(tur.getIdturismo());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
			}
			String sql =sqlb.toString();
			 //System.out.println(sql);
			simpleJdbcTemplate.update(sql);			
		} 
     
     public void insertarNoDuplicado(TurismoOperadorturismo turismoOperadorturismo){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idturismo",turismoOperadorturismo.getTurismo().getIdturismo());
			parametros.put("idoperadorturismo",turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo() );
			this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoTurismoOperadorTurismo,parametros);
	 }
     
	
}
