package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.param.AreanaturalParam;
import proyecto.util.ConexionBD;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.Proyecto;
import proyecto.vo.ProyectoAreanatural;


public class ProyectoAreanaturalDAO  {


	private ConexionBD dt;
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
    public ProyectoAreanaturalDAO(){
    	dt=new ConexionBD();
    }
	
    
    
    
	
    public List<Areanatural> listar(Proyecto proyecto ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreanaturalxProyecto);
		if(proyecto.getIdproyecto()!=0){
			sqlb.append(" and pa.idproyecto=" );
			sqlb.append(proyecto.getIdproyecto());
		}
		
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Areanatural> lista=new ArrayList<Areanatural>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Areanatural a=new Areanatural();
				 a.setIdareanatural(rs.getInt("idareanatural"));
				 a.setCodareanatural(rs.getString("codareanatural"));
				 a.setDesareanatural(rs.getString("desareanatural"));
				 a.setSiglasareanatural(rs.getString("siglasareanatural"));
				 a.getCategoriaanp().setIdcategoriaanp(rs.getInt("idcategoriaanp"));
				 a.getCategoriaanp().setDescategoriaanp(rs.getString("descategoriaanp"));
				 a.getCategoriaanp().setSiglascategoriaanp(rs.getString("siglascategoriaanp"));
				 lista.add(a);
			 }
			 dt.cerrarConexion(cn,rs,st);
					
					
		}catch(SQLException e){
					e.printStackTrace();
		}
	    catch(Exception e){
					e.printStackTrace();
		}		
				
	return lista;
}
    
    
    
    public List<Areanatural> listarProyectoAgrupado(Areanatural areanatural ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAgrupadoProyectoxAreanatural);
		if(areanatural.getIdareanatural()!=0){
			sqlb.append(" and a.idareanatural=" );
			sqlb.append(areanatural.getIdareanatural());
		}
		if(areanatural.getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(" and a.idcategoriaanp=" );
			sqlb.append(areanatural.getCategoriaanp().getIdcategoriaanp());
		}
		sqlb.append(" and a.estado=" );
		sqlb.append(areanatural.getFlagestado());
		sqlb.append(" group by pa.idareaNatural " );
		sqlb.append(" order by  a.desareanatural " ); 
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Areanatural> lista=new ArrayList<Areanatural>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Areanatural a=new Areanatural();
				 a.setIdareanatural(rs.getInt("idareanatural"));
				 a.setCodareanatural(rs.getString("codareanatural"));
				 a.setDesareanatural(rs.getString("desareanatural"));
				 a.setSiglasareanatural(rs.getString("siglasareanatural"));
				 a.setFlagestado(rs.getInt("estado"));
				 a.setCantidad(rs.getInt("cantidadproyecto"));
				 a.getCategoriaanp().setIdcategoriaanp(rs.getInt("idcategoriaanp"));
				 lista.add(a);
			 }
			 dt.cerrarConexion(cn,rs,st);
					
					
		}catch(SQLException e){
					e.printStackTrace();
		}
	    catch(Exception e){
					e.printStackTrace();
		}		
				
	return lista;
}
    
    
    
	public List<AreanaturalParam> listarCantidadProyectoxAreaNatural(ProyectoAreanatural proyectoAreanatural ,int orden){
		
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCantidadProyectoxAreanatural);
		if(proyectoAreanatural.getAreanatural().getIdareanatural()!=0){
			sqlb.append(" and pa.idareaNatural=");
			sqlb.append(proyectoAreanatural.getAreanatural().getIdareanatural());
		}
		if(proyectoAreanatural.getProyecto().getFlagProyecto()!=0){
			sqlb.append(" and tab.flagproyecto=");
			sqlb.append(proyectoAreanatural.getProyecto().getFlagProyecto())  ;
		}
		sqlb.append(" group by pa.idareaNatural");
		if(orden==ValueConstants.TOTAL){
			sqlb.append(" order by canttotal desc");
		}
		else
			if(orden==ValueConstants.VIGENTES){
				sqlb.append(" order by cantvigente desc");
			}
			else
           if(orden==ValueConstants.CONCLUIDOS){
        	   sqlb.append(" order by cantvencido desc");
		    } 
		 String sql =sqlb.toString();
		
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.CantidadProyectoxAreanaturalMapper());
		 	
	}
	
	public List<AreanaturalParam> listarMontoProyectoxAreaNatural(ProyectoAreanatural proyectoAreanatural,int orden ){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaMontoProyectoxAreanatural);
		if(proyectoAreanatural.getAreanatural().getIdareanatural()!=0){
			sqlb.append(" and pa.idareaNatural=");
			sqlb.append(proyectoAreanatural.getAreanatural().getIdareanatural());
		}
		if(proyectoAreanatural.getProyecto().getFlagProyecto()!=0){
			sqlb.append(" and tab.flagproyecto=");
			sqlb.append(proyectoAreanatural.getProyecto().getFlagProyecto())  ;
		}
		sqlb.append(" group by pa.idareaNatural");
		if(orden==ValueConstants.TOTAL){
			sqlb.append(" order by montototal desc");
		}
		else
			if(orden==ValueConstants.VIGENTES){
				sqlb.append(" order by montovigente desc");
			}
			else
           if(orden==ValueConstants.CONCLUIDOS){
        	   sqlb.append(" order by montovencido desc");
		    } 
		 String sql =sqlb.toString();
		
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.MontoProyectoxAreanaturalMapper());
		 	
	}
    
	/*
    public List<AreanaturalParam> listarCantidadProyectoxAreaNatural(ProyectoAreanatural proyectoAreanatural ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCantidadProyectoxAreanatural);
		
		
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<AreanaturalParam> lista=new ArrayList<AreanaturalParam>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 AreanaturalParam a=new AreanaturalParam();
				 a.getAreanatural().setIdareanatural(rs.getInt("idareaNatural"));
				 a.getAreanatural().setDesareanatural(rs.getString("desareanatural"));
				 a.setCantidadProyectos(rs.getInt("total"));
				 a.setCantidadProyectosVigente(rs.getInt("vigentes"));
				 a.setCantidadProyectosVencidos(rs.getInt("concluidos"));
				 lista.add(a);
			 }
			 dt.cerrarConexion(cn,rs,st);
					
					
		}catch(SQLException e){
					e.printStackTrace();
		}
	    catch(Exception e){
					e.printStackTrace();
		}		
				
	return lista;
}
  */  
    
    
    
    public List<Categoriaanp> listarProyectoAgrupadoxCategoria(Categoriaanp categoriaanp ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAgrupadoProyectoxCategoriaAnp);
		if(categoriaanp.getIdcategoriaanp()!=0){
			sqlb.append(" and c.descategoriaanp=" );
			sqlb.append(categoriaanp.getIdcategoriaanp());
		}
		sqlb.append(" and c.estado=" );
		sqlb.append(categoriaanp.getFlagestado());
		sqlb.append(" group by a.idcategoriaanp "  );
		sqlb.append(" order by c.idcategoriaanp "  );
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Categoriaanp> lista=new ArrayList<Categoriaanp>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Categoriaanp c=new Categoriaanp();
				 c.setIdcategoriaanp(rs.getInt("idcategoriaanp"));
				 c.setDescategoriaanp(rs.getString("descategoriaanp"));
				 c.setFlagestado(rs.getInt("estado"));
				 lista.add(c);
			 }
			 dt.cerrarConexion(cn,rs,st);
					
					
		}catch(SQLException e){
					e.printStackTrace();
		}
	    catch(Exception e){
					e.printStackTrace();
		}		
				
	return lista;
}
    
    
    public void insertar(ProyectoAreanatural proyectoAreanatural){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(SqlConstants.insertaProyectoAreanatural); 
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 i=1;
			 st.setInt(i++, proyectoAreanatural.getAreanatural().getIdareanatural());
			 st.setInt(i++, proyectoAreanatural.getProyecto().getIdproyecto());
			 st.execute();
            
			dt.cerrarConexion(cn,rs,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		//return idproyecto;
		
	}    
	
    
    
    public void insertarNoDuplicado(List<ProyectoAreanatural> lista){
    	Connection cn = null;
		PreparedStatement st = null;
		StringBuffer sql = new StringBuffer("insert into " +
				"areanaturalproyecto(idareaNatural," +
				"idproyecto) " +
				"values ");
		for(ProyectoAreanatural pa:lista){
			sql.append("(");
			sql.append(pa.getAreanatural().getIdareanatural());
			sql.append(",");
			sql.append(pa.getProyecto().getIdproyecto());
			sql.append("),");
		}
		sql.delete(sql.length()-1, sql.length());
		sql.append(" on duplicate key update" +
				" idareaNatural=values(idareaNatural);");
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 st.executeUpdate();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}				
	}   
    
    
    public void eliminarDiferencia(List<ProyectoAreanatural> lista,Proyecto proyecto){
    	Connection cn = null;
		PreparedStatement st = null;
		
		StringBuffer sql = new StringBuffer("delete  from areanaturalproyecto where idproyecto=");
		sql.append(proyecto.getIdproyecto());
		
		if(lista.size()!=0){
		sql.append(" and idareaNatural in  (  select idAreaNatural  from   (select * from areanaturalproyecto where idproyecto=");
		sql.append(proyecto.getIdproyecto());
		//sql.append(lista.get(0).getProyecto().getIdproyecto());
		sql.append(")as tab where   idareaNatural not in(");
		for(ProyectoAreanatural pa:lista){
			sql.append(pa.getAreanatural().getIdareanatural());
			sql.append(",");
		}
		sql.delete(sql.length()-1, sql.length());
		sql.append("))");
		}
		
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 st.executeUpdate();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}				
	}   
    
    
   

   
	
	
}
