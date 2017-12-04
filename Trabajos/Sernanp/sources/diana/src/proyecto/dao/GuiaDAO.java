package proyecto.dao;

import java.text.SimpleDateFormat;
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
import proyecto.dao.procedure.GuiaProcedure;
import proyecto.param.GuiaParam;
import proyecto.vo.Guia;

@Repository 
public class GuiaDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private GuiaProcedure guiaProcedure;
 
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		this.guiaProcedure=new GuiaProcedure(dataSource);
	}

	public List<Guia> listar() {
		return simpleJdbcTemplate.query(
				"SELECT g.idguia, (n.nombre || ' ' || n.apepat) as nombre FROM sernanp.guia g "
						+ "INNER JOIN sernanp.personanatural n "
						+ "ON n.idpersonanatural= g.idpersonanatural;",
				ParameterizedBeanPropertyRowMapper.newInstance(Guia.class));
	}
 
	public List<Guia> listar( int idarea ) { 
		return simpleJdbcTemplate.query( 
				"SELECT g.idguia, (n.nombre || ' ' || n.apepat)as nombre FROM sernanp.guia g " +
				"INNER JOIN sernanp.personanatural n  ON n.idpersonanatural= g.idpersonanatural " +
				"INNER JOIN sernanp.turismoguia tg ON tg.idguia = g.idguia " +    
				"INNER JOIN sernanp.turismo t ON t.idturismo = tg.idturismo " +    
				"INNER JOIN sernanp.areanatural a ON a.idareanatural = t.idareanatural  AND a.idareanatural = " + 
				idarea,
				ParameterizedBeanPropertyRowMapper.newInstance(Guia.class));
	} 
	
	
	 public int insertarNoDuplicado(Guia guia){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idpersonanatural",guia.getIdpersonanatural() );
			parametros.put("codigoguia", guia.getCodigoguia());
			parametros.put("flagguia", guia.getFlagguia());
			return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoGuia,parametros);
	 }
	
     public List<Guia> listarUnico(Guia guia){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaGuiaUnico);
		if(guia.getFlagguia()!=0 ){
	   		   if(guia.getFlagguia()==ValueConstants.VALOR_CERO){
	   			sqlb.append(" and g.flagguia=0" );
	   		   }else{
	   			sqlb.append(" and g.flagguia=" );
				sqlb.append(guia.getFlagguia());  
	   		   }
				
			}
		if( guia.getApemat()!=null || guia.getApemat()!=null || guia.getNombre()!=null){
			sqlb.append("  and  ( pnat.apepat like '%" );
			sqlb.append(guia.getApepat() );
			sqlb.append("%' " );
			sqlb.append("  or pnat.apemat like '%" );
			sqlb.append(guia.getApemat() );
			sqlb.append("%' " );
			sqlb.append("  or pnat.nombre like '%" );
			sqlb.append(guia.getNombre() );
			sqlb.append("%' )" );
			
		}
		
		
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.GuiaMapper());
		 	
	}
     
     
     
     public int insertar(Guia guia){
 		   return guiaProcedure.insertar(guia);
 	 }
     
     
     public int contar(GuiaParam guiaParam) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarGuiaTurismo);
		 agregarClausulasConsulta(guiaParam, sqlb);
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
     
     
    public List<Guia> listar(Guia guia){
    	 StringBuffer sqlb = new StringBuffer(SqlConstants.listaGuiaTurismo);
		 agregarClausulasConsulta(guia, sqlb);
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.GuiaTurismoMapper() );	
    } 
     
    public List<Guia> listarPaginado(GuiaParam guiaParam,int offset,int tamPagina) {
		 
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaGuiaTurismo);
		 agregarClausulasConsulta(guiaParam, sqlb);
			sqlb.append(" order by pnat.apepat,pnat.apemat,pnat.nombre  ");
			sqlb.append(" LIMIT ");
			sqlb.append(tamPagina);
			sqlb.append(" OFFSET ");
			sqlb.append(offset);
			 String sql =sqlb.toString();
			//System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.GuiaTurismoMapper() );	 
	 }
     
    
    
    public void agregarClausulasConsulta(Guia guia, StringBuffer sqlb){
   	   
   	   //clausulas datos basicos guia
   	   if(guia.getIdguia()!=0 ){
   			sqlb.append(" and g.idguia=" );
   			sqlb.append(guia.getIdguia());
   		}
   	   if(guia.getFlagguia()!=0 ){
   		   if(guia.getFlagguia()==ValueConstants.VALOR_CERO){
   			sqlb.append(" and g.flagguia=0" );
   		   }else{
   			sqlb.append(" and g.flagguia=" );
			sqlb.append(guia.getFlagguia());  
   		   }
			
		}
   	   if( guia.getApemat()!=null ||
   			 guia.getApemat()!=null || guia.getNombre()!=null){
 			sqlb.append("  and  ( upper(pnat.apepat) like upper('%" );
 			sqlb.append(guia.getApepat() );
 			sqlb.append("%') " );
 			sqlb.append("  or   upper(pnat.apemat) like upper('%" );
 			sqlb.append(guia.getApemat() );
 			sqlb.append("%') " );
 			sqlb.append("  or  upper(pnat.nombre) like upper('%" );
 			sqlb.append(guia.getNombre() );
 			sqlb.append("%') )" );
 			
 		}
   		
      }
    
     public void agregarClausulasConsulta(GuiaParam guiaParam, StringBuffer sqlb){
  	   
  	   //clausulas datos basicos guia
  	   if(guiaParam.getGuia().getIdguia()!=0 ){
  			sqlb.append(" and g.idguia=" );
  			sqlb.append(guiaParam.getGuia().getIdguia());
  		}
  	 if(guiaParam.getGuia().getFlagguia()!=0 ){
 		   if(guiaParam.getGuia().getFlagguia()==ValueConstants.VALOR_CERO){
 			sqlb.append(" and g.flagguia=0" );
 		   }else{
 			sqlb.append(" and g.flagguia=" );
			sqlb.append(guiaParam.getGuia().getFlagguia());  
 		   }
			
		}
  	   if( guiaParam.getGuia().getApemat()!=null ||
  			 guiaParam.getGuia().getApemat()!=null || guiaParam.getGuia().getNombre()!=null){
			sqlb.append("  and  ( upper(pnat.apepat) like upper('%" );
			sqlb.append(guiaParam.getGuia().getApepat() );
			sqlb.append("%') " );
			sqlb.append("  or   upper(pnat.apemat) like upper('%" );
			sqlb.append(guiaParam.getGuia().getApemat() );
			sqlb.append("%') " );
			sqlb.append("  or  upper(pnat.nombre) like upper('%" );
			sqlb.append(guiaParam.getGuia().getNombre() );
			sqlb.append("%') )" );
			
		}
  		
  		//clausulas datos anp con turismo
  		
  		if(guiaParam.getTurismo().getIdturismo()!=0){
  			sqlb.append(SqlConstants.listaGuiaSubTurismo);
  			sqlb.append(guiaParam.getTurismo().getIdturismo());
  		    sqlb.append(")");
  		}
  		
     }
     
     
     public void actualizar(Guia guia){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer("update sernanp.guia set idguia=idguia ");
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("flagguia", guia.getFlagguia());
			parametros.put("codigoguia", guia.getCodigoguia());
			if(guia.getFlagguia()!=0){
				if(guia.getFlagguia()==ValueConstants.VALOR_CERO){
					sqlb.append(", flagguia=0");	
				}
				else{
					sqlb.append(", flagguia=:flagguia");
				}
			}	
			if(guia.getCodigoguia()!=null){
				sqlb.append(", codigoguia=:codigoguia");
			}
			sqlb.append(" where idguia=");
			sqlb.append(guia.getIdguia());
			String sql =sqlb.toString();
			//System.out.println(sql);
			simpleJdbcTemplate.update(sql, parametros);
	      
    }	
     
    
     
     
}
