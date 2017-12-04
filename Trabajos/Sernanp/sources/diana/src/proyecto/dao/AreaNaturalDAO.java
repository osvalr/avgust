package proyecto.dao;

 



import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;

@Repository 
public class AreaNaturalDAO  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	  
	public AreaNaturalDAO(){
			dt = new ConexionBD();		
	}
	
	public Areanatural buscarxAreaOrganica(int idAreaorganica){
		String sql =     
				"select c.descategoriaanp as categoriaareanatural,an.* " +  
				"from sernanp.areanatural an " +
				"inner join sernanp.areaorganica ao on an.idareanatural = ao.idareanatural and ao.idarea = " + 
				idAreaorganica + 
				" inner join sernanp.categoriaanp c ON c.idcategoriaanp = an.idcategoriaanp "  
				; 
		return this.simpleJdbcTemplate.queryForObject(sql, 
				ParameterizedBeanPropertyRowMapper.newInstance(Areanatural.class));
	}
	
	
	
	
	
	
	
   public List<Areanatural> listar(Areanatural areanatural){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNatural);
		if(areanatural.getIdareanatural()!=0 ){
			sqlb.append(" and a.idareanatural=" );
			sqlb.append(areanatural.getIdareanatural());
		}
		if(areanatural.getCodareanatural()!=null ){
			sqlb.append(" and a.codareanatural='" );
			sqlb.append(areanatural.getCodareanatural());
			sqlb.append("'");
		}
		if(areanatural.getCategoriaanp().getIdcategoriaanp()!=0 ){
			sqlb.append(" and a.idcategoriaanp=" );
			sqlb.append(areanatural.getCategoriaanp().getIdcategoriaanp());
		}
		if(areanatural.getAdministracionAreanatural().getIdadministracionareanatural()!=0 ){
			sqlb.append(" and a.idadministracionareanatural=" );
			sqlb.append(areanatural.getAdministracionAreanatural().getIdadministracionareanatural());
		}
		if(areanatural.getFlagestado()!=0 ){
			if(areanatural.getFlagestado()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and a.estado=0" );
			}else{
				sqlb.append(" and a.estado=" );
				sqlb.append(areanatural.getFlagestado());
			}
		}
		if(areanatural.getFlagactivo()!=0 ){
			if(areanatural.getFlagactivo()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and a.flagactivoareanatural=0" );
			}else{
				sqlb.append(" and a.flagactivoareanatural=" );
				sqlb.append(areanatural.getFlagactivo());
			}
		}
		
		sqlb.append(" order by a.idcategoriaanp , a.desareanatural " );
		
		String sql =sqlb.toString();
		
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
		 	
	}
   
   //Agregado JCV
   public List<Areanatural> listar(Categoriaanp ctg){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNatural);
		
		sqlb.append(" and a.codareanatural like '" );
		sqlb.append(ctg.getCodcategoriaanp());
		sqlb.append("__'");		
		sqlb.append(" and a.flagactivoareanatural=1" );
		
		sqlb.append(" order by a.idcategoriaanp , a.desareanatural " );
		
		String sql =sqlb.toString();
		
		//System.out.println(sql);
		
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
		 	
	}
   
	
  //09-05-2013 (Y.C.)
   public List<Areanatural> listarxctg(Categoriaanp ctg){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNatural);
		
		sqlb.append(" and a.idcategoriaanp = " );
		sqlb.append(ctg.getIdcategoriaanp());				
		sqlb.append(" and a.flagactivoareanatural=1" );		
		sqlb.append(" order by a.idcategoriaanp , a.desareanatural " );
		
		String sql =sqlb.toString();
		
			
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
		 	
	}
	
	
}
