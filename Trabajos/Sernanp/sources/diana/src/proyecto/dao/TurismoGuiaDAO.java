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
import proyecto.vo.Guia;
import proyecto.vo.Turismo;
import proyecto.vo.TurismoGuia;

@Repository 
public class TurismoGuiaDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	
	
	
	 public void insertar(TurismoGuia turismoGuia){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaTurismoGuia);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idturismo",turismoGuia.getTurismo().getIdturismo());
			parametros.put("idguia", turismoGuia.getGuia().getIdguia());
			simpleJdbcTemplate.update(sql, parametros);
	}
	
     public List<Guia> listarGuiaUnicoxAreaNatural(TurismoGuia turismoguia){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaGuiaUnicoxAreaNatural);
		 if(turismoguia.getGuia().getFlagguia()==ValueConstants.VALOR_CERO){
	   			sqlb.append(" and g.flagguia=0" );
	   		   }else{
	   			sqlb.append(" and g.flagguia=" );
				sqlb.append(turismoguia.getGuia().getFlagguia());  
	      }
		if(turismoguia.getTurismo().getIdareanatural()!=0 ){
			sqlb.append(" and t.idareanatural=" );
			sqlb.append(turismoguia.getTurismo().getIdareanatural());
		}
		
		if( turismoguia.getGuia().getApemat()!=null || turismoguia.getGuia().getApemat()!=null || turismoguia.getGuia().getNombre()!=null){
			sqlb.append("  and  ( upper(pnat.apepat) like upper('%" );
			sqlb.append(turismoguia.getGuia().getApepat() );
			sqlb.append("%') " );
			sqlb.append("  or   upper(pnat.apemat) like  upper('%" );
			sqlb.append(turismoguia.getGuia().getApemat() );
			sqlb.append("%') " );
			sqlb.append("  or  upper(pnat.nombre) like  upper('%" );
			sqlb.append(turismoguia.getGuia().getNombre() );
			sqlb.append("%') )" );
			
		}
		sqlb.append(" order by pnat.apepat, pnat.apemat, pnat.nombre ");
	    
		
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.GuiaMapper());
		 	
	}
     
     public int contarUnico(TurismoGuia turismoGuia) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarTurismoGuiaUnico);
		 if(turismoGuia.getGuia().getIdguia()!=0){
			 sqlb.append(" and idguia=");
			 sqlb.append(turismoGuia.getGuia().getIdguia());
		 }
		  
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
     
     
     public List<Turismo> listarAreaNaturalTurismoxGuia(TurismoGuia turismoGuia){
  		
  		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNaturalxGuiaTurismo);
  		if(turismoGuia.getGuia().getIdguia()!=0 ){
  			sqlb.append(" and tg.idguia=" );
  			sqlb.append(turismoGuia.getGuia().getIdguia());
  		}
  		sqlb.append(" order by an.desareanatural " );
  		 String sql =sqlb.toString();
  		// System.out.println(sql);
  		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TurismoMapper());
  		 	
  	}
     
     
     
     public void eliminarDiferencia(List<Turismo> lista,int idguia){
			StringBuffer sqlb = new StringBuffer("delete from sernanp.turismoguia where ");
			if(lista.size()==0){
				sqlb.append(" idguia=");
				sqlb.append(idguia);
			}
			else{
				sqlb.append("idturismo in( select tab.idturismo from (");
				sqlb.append("select * from sernanp.turismoguia where idguia=");
				sqlb.append(idguia);
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
     
     public void insertarNoDuplicado(TurismoGuia turismoGuia){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idturismo",turismoGuia.getTurismo().getIdturismo());
			parametros.put("idguia",turismoGuia.getGuia().getIdguia() );
			this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoTurismoGuia,parametros);
	 }
     
//     public List<Areanatural> listarAreaNaturalxGuia(TurismoGuia turismoGuia){
// 		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNaturalxGuiaTurismo);
// 		if(turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo()!=0 ){
// 			sqlb.append(" and tot.idoperadorturismo=" );
// 			sqlb.append(turismoOperadorturismo.getOperadorturismo().getIdoperadorturismo());
// 		}
// 		sqlb.append(" order by an.desareanatural " );
// 		 String sql =sqlb.toString();
// 		//System.out.println(sql);
// 		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
// 		 	
// 	}
	
	
	
}
