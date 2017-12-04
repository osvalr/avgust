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
import proyecto.vo.Tipo;

@Repository
public class TipoDAO  {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
    

    
   public List<Tipo> listarTipo(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipo);	
		if(tipo.getIdtabla()!=0){
			sqlb.append(" and t.idtabla=");
			sqlb.append(tipo.getIdtabla());
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoMapper());
		 	
	}  
   
   
   public List<Tipo> listarTipo(Tipo tipo,int orden){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipo);	
		if(tipo.getIdtabla()!=0){
			sqlb.append(" and t.idtabla=");
			sqlb.append(tipo.getIdtabla());
		}
		if(orden==ValueConstants.ORDEN_CONSULTA_ORD){
			sqlb.append(" order by t.ordtablatipo ");
		}else
			if(orden==ValueConstants.ORDEN_CONSULTA_CODIGOINT){
				sqlb.append(" order by t.codinttablatipo ");
			}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoMapper());
		 	
	}
   
    
    
 public List<Tipo> listarTipoDocumentoIdentidad(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoDocumentoIdentidad);		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoDocumentoIdentidadMapper());
		 	
	}  

    
    
    
   public List<Tipo> listarTipoRecursoInformacion(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoRecursoInformacion);
		if(tipo.getIdtipo()!=0 ){
			sqlb.append(" and tr.idtiporecursoinformacion=" );
			sqlb.append(tipo.getIdtipo());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoRecursoInformacionMapper());
		 	
	}
    
    
   
   public List<Tipo> listarMedioRecursoInformacion(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaMedioRecursoInformacion);
		if(tipo.getIdtipo()!=0 ){
			sqlb.append(" and mr.idmediorecursoinformacion=" );
			sqlb.append(tipo.getIdtipo());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.MedioRecursoInformacionMapper());
		 	
	}
   
   
   public List<Tipo> listarTematicaRecursoInformacion(Tipo tipo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTematicaRecursoInformacion);
		if(tipo.getIdtipo()!=0 ){
			sqlb.append(" and tmr.idtematicarecursoinformacion=" );
			sqlb.append(tipo.getIdtipo());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TematicaRecursoInformacionMapper());
		 	
	}
   
   //Agregado 29-05-2012 Y.C.B.
   
   public List<Tipo> listarTipoMT(Tipo tipo, int idficharegistro){
	   
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaMedioTransporteFicha);
		
	sqlb.append("WHERE frt.idficharegistro=" );
	sqlb.append(idficharegistro);
	sqlb.append(" AND tt.idtabla=" );
	sqlb.append(tipo.getIdtabla());
		
		
	String sql =sqlb.toString();
	
	return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoMapper());
   }
   
   
   public Map<Integer, Object> obtenerMapOrdenxTabla(int idtabla){
		Map<Integer, Object> map=new HashMap<Integer, Object>();
		List<Tipo> lista= listarTipo(new Tipo(idtabla));
		for(Tipo t: lista){
			map.put(t.getOrdentipo(), t);
		}
		return map;
	}
	
   public Map<Integer, Object> obtenerMapCodigoxTabla(int idtabla){
		Map<Integer, Object> map=new HashMap<Integer, Object>();
		List<Tipo> lista= listarTipo(new Tipo(idtabla));
		for(Tipo t: lista){
			map.put(t.getCodigointtipo(), t);
		}
		return map;
	}
   
   
   
   public Map<Integer, Integer> obtenerMapCodigoIdxTabla(int idtabla){
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		List<Tipo> lista= listarTipo(new Tipo(idtabla));
		for(Tipo t: lista){
			map.put(t.getCodigointtipo(), t.getIdtipo());
		}
		return map;
	}
   
   public Map<Integer, Object> obtenerMapIdxTabla(int idtabla){
		Map<Integer, Object> map=new HashMap<Integer, Object>();
		List<Tipo> lista= listarTipo(new Tipo(idtabla));
		for(Tipo t: lista){
			map.put(t.getCodigointtipo(), t);
		}
		return map;
	}
   
    
//    public List<Tipo> listarTipoProyecto(Tipo tipo) {
//		Connection cn = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoProyecto);
//		
//		String sql =sqlb.toString();
//		//System.out.println(sql);
//		List<Tipo> lista=new ArrayList<Tipo>();
//		try{
//			 cn=dt.obtenerConexion();
//			 st=cn.prepareStatement(sql);
//			 rs=st.executeQuery();
//			 
//			 while(rs.next()){
//				 Tipo t=new Tipo();
//				 t.setIdtipo(rs.getInt("idtipoproyecto"));
//				 t.setNombretipo(rs.getString("nombretipoproyecto"));
//				 lista.add(t);
//			 }
//				
//			 dt.cerrarConexion(cn,rs,st);
//					
//					
//		}catch(SQLException e){
//					e.printStackTrace();
//		}
//	    catch(Exception e){
//					e.printStackTrace();
//		}		
//				
//	return lista;
//}

    
//    public List<Tipo> listarCategoriaProyecto(Tipo tipo) {
//		Connection cn = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCategoriaProyecto);
//		
//		String sql =sqlb.toString();
//		//System.out.println(sql);
//		List<Tipo> lista=new ArrayList<Tipo>();
//		try{
//			 cn=dt.obtenerConexion();
//			 st=cn.prepareStatement(sql);
//			 rs=st.executeQuery();
//			 
//			 while(rs.next()){
//				 Tipo t=new Tipo();
//				 t.setIdtipo(rs.getInt("idcategoriaproyecto"));
//				 t.setNombretipo(rs.getString("nombrecategoriaproyecto"));
//				 lista.add(t);
//			 }
//				
//			 dt.cerrarConexion(cn,rs,st);
//					
//					
//		}catch(SQLException e){
//					e.printStackTrace();
//		}
//	    catch(Exception e){
//					e.printStackTrace();
//		}		
//				
//	return lista;
//}
	
//    public int insertarTipoProyecto(Tipo tipoproyecto){
//		Connection cn = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		StringBuffer sql = new StringBuffer(SqlConstants.insertaTipoProyecto); 
//		String cad =sql.toString();
//		//System.out.println(cad);
//		int i;
//		int idtipoproyecto=0;
//		try{
//			 cn=dt.obtenerConexion();
//			 st=cn.prepareStatement(cad);
//			 i=1;
//			 st.setString(i++, tipoproyecto.getNombretipo());
//			 st.execute();
//             rs=st.executeQuery("SELECT LAST_INSERT_ID()");
//             if(rs.next())
//               idtipoproyecto = rs.getInt(1);
//			dt.cerrarConexion(cn,rs,st);
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}		
//		
//		return idtipoproyecto;
//		
//	}
    
   
	
	
}
