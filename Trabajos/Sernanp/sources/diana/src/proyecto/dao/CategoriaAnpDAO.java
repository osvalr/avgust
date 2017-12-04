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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Archivo;
import proyecto.vo.Categoriaanp;

@Repository
public class CategoriaAnpDAO  {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

   public List<Categoriaanp> listar(Categoriaanp categoriaanp){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCategoriaAnp);
		if(categoriaanp.getIdcategoriaanp()!=0 ){
			sqlb.append(" and c.idcategoriaanp=" );
			sqlb.append(categoriaanp.getIdcategoriaanp());
		}
		String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.CategoriaAnpMapper());
		 	
	}

// JCEV 24-07-2012
   public List<Categoriaanp> listarCategoriasAnps(){		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCategoriaAnp);		
		String sql = sqlb.toString();
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.CategoriaAnpMapper());		 
   }
   

	/*
	public List<Categoriaanp> listar(Categoriaanp categoriaanp) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCategoriaAnp);
	    sqlb.append(" and c.estado=" );
		sqlb.append(categoriaanp.getEstado());
		sqlb.append(" order by c.descategoriaanp " );
		String sql =sqlb.toString();
		System.out.println(sql);
		
		List<Categoriaanp> lista=new ArrayList<Categoriaanp>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Categoriaanp c=new Categoriaanp();
				 c.setIdcategoriaanp(rs.getInt("idcategoriaanp"));
				 c.setCodcategoriaanp(rs.getString("codcategoriaanp"));
				 c.setDescategoriaanp(rs.getString("descategoriaanp"));
				 c.setSiglascategoriaanp(rs.getString("siglascategoriaanp"));
				 c.setEstado(rs.getInt("estado"));
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
	*/
	
	
	
	
	
	
	/*
	public UsuarioVO insertar(UsuarioVO vo) throws DAOException {
		Session session = getSession();
		Transaction tx = session.beginTransaction();// habre transsaccion
		session.save(vo);
		tx.commit();
		session.close();
		return vo;
	}
	
	public UsuarioVO actualizar(UsuarioVO vo) throws DAOException {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(vo);
		tx.commit();
		session.close();
		return vo;
	}

	public void eliminar(UsuarioVO vo) throws DAOException {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.delete(vo);
		tx.commit();
		session.close();
	}
    */
	
}
