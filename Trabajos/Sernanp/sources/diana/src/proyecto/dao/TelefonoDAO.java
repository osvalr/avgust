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
import proyecto.util.ConexionBD;
import proyecto.vo.Telefono;

@Repository 
public class TelefonoDAO  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	  
	public TelefonoDAO(){
			dt = new ConexionBD();		
	}
	
	
	
	
	
public int contar(Telefono telefono){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.contarTelefono);
	if(telefono.getIdtelefono()!=0 ){
		sqlb.append(" and t.idtelefono=" );
		sqlb.append(telefono.getIdtelefono());
	}
	if(telefono.getNumerotelefono()!=null ){
		sqlb.append(" and t.numerotelefono like '%" );
		sqlb.append(telefono.getNumerotelefono() );
		sqlb.append("%' " );
		
	}
	if(telefono.getTipotelefono().getIdtipotelefono()!=0 ){
		sqlb.append(" and t.idtipotelefono=" );
		sqlb.append(telefono.getTipotelefono().getIdtipotelefono());
	}
	if(telefono.getPersonal().getIdpersonal()!=0 ){
		sqlb.append(" and t.idpersonal=" );
		sqlb.append(telefono.getPersonal().getIdpersonal());
	}
	sqlb.append(" ) as tab");
	String sql =sqlb.toString();
	 System.out.println(sql);
	 return this.jdbcTemplate.queryForInt(sql);
	
}	
	
	
	
public List<Telefono> listarPaginado(Telefono telefono,int offset,int tamPagina){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTelefono);
		if(telefono.getIdtelefono()!=0 ){
			sqlb.append(" and t.idtelefono=" );
			sqlb.append(telefono.getIdtelefono());
		}
		if(telefono.getNumerotelefono()!=null ){
			sqlb.append(" and t.numerotelefono like '%" );
			sqlb.append(telefono.getNumerotelefono() );
			sqlb.append("%' " );
			
		}
		if(telefono.getTipotelefono().getIdtipotelefono()!=0 ){
			sqlb.append(" and t.idtipotelefono=" );
			sqlb.append(telefono.getTipotelefono().getIdtipotelefono());
		}
		if(telefono.getPersonal().getIdpersonal()!=0 ){
			sqlb.append(" and t.idpersonal=" );
			sqlb.append(telefono.getPersonal().getIdpersonal());
		}
		
		
		sqlb.append(" order by pnat.apepat ");
		sqlb.append(" LIMIT ");
		sqlb.append(offset);
		sqlb.append(",");
		sqlb.append(tamPagina);
		
		 String sql =sqlb.toString();
		 System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TelefonoMapper());
		 	
	}
	
	
	
	
	public List<Telefono> listar(Telefono telefono){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTelefono);
		if(telefono.getIdtelefono()!=0 ){
			sqlb.append(" and t.idtelefono=" );
			sqlb.append(telefono.getIdtelefono());
		}
		if(telefono.getNumerotelefono()!=null ){
			sqlb.append(" and t.numerotelefono like '%" );
			sqlb.append(telefono.getNumerotelefono() );
			sqlb.append("%' " );
			
		}
		if(telefono.getTipotelefono().getIdtipotelefono()!=0 ){
			sqlb.append(" and t.idtipotelefono=" );
			sqlb.append(telefono.getTipotelefono().getIdtipotelefono());
		}
		if(telefono.getPersonal().getIdpersonal()!=0 ){
			sqlb.append(" and t.idpersonal=" );
			sqlb.append(telefono.getPersonal().getIdpersonal());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TelefonoMapper());
		 	
	}
	
	
	
	public int insertar(Telefono telefono){
		int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaTelefono);
		String sql =sqlb.toString();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numerotelefono", telefono.getNumerotelefono());
		parametros.put("idtipotelefono", telefono.getTipotelefono().getIdtipotelefono());
		parametros.put("idpersonal", telefono.getPersonal().getIdpersonal());
		parametros.put("principaltelefono", telefono.getFlagPrincipal());
		simpleJdbcTemplate.update(sql, parametros);
		codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		return codigo;	
	}
	
	
	/*
	public void actualizar(Archivo archivo){
		
		StringBuffer sqlb = new StringBuffer("update archivo set idarchivo=idarchivo ");
		if(archivo.getNombreInicial()!=null){
			sqlb.append(",  nombreinicialarchivo='");
			sqlb.append(archivo.getNombreInicial());
			sqlb.append("' ");
		}
		if(archivo.getNombreGenerado()!=null){
			sqlb.append(",  nombregeneradoarchivo='");
			sqlb.append(archivo.getNombreGenerado());
			sqlb.append("' ");
		}
		
		if(archivo.getFechaUpload()!=null){
			sqlb.append(",  fechauploadarchivo='");
			sqlb.append(new java.sql.Date(archivo.getFechaUpload().getTime()));
			sqlb.append("' ");
			
		}
		if(archivo.getDescripcion()!=null){
			sqlb.append(",  descripcionarchivo='");
			sqlb.append(archivo.getDescripcion());
			sqlb.append("' ");
		}
		if(archivo.getUsuario().getIdUsuario()!=0){
			sqlb.append(",  idUsuario=");
			sqlb.append(archivo.getUsuario().getIdUsuario());
			
		}
		if(archivo.getIdarchivoPadre()!=0){
			sqlb.append(",  idarchivo1=");
			sqlb.append(archivo.getIdarchivo());
			
		}
		else
			if(archivo.getIdarchivoPadre()==0){
				sqlb.append(",  idarchivo1=null");
				
				
			} 
		sqlb.append(" where idarchivo=");
		sqlb.append(archivo.getIdarchivo());
		String sql =sqlb.toString();
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		
		simpleJdbcTemplate.update(sql);
		
	
	}
	*/

	
	
	
	
	
}
