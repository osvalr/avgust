package proyecto.dao;

 



import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import proyecto.param.RecursoInformacionParam;
import proyecto.vo.RecursoInformacion;

@Repository 
public class RecursoInformacionDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
	
	
	public int obtenerNumeroDisponible(){
		int nro=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.obtenerNumeroDisponible);
		String sql =sqlb.toString();
		//return  this.jdbcTemplate.queryForInt(sql);
		//this.jdbcTemplate.queryForInt(sql)==0){
			//nro=1;
		
		
		return  this.jdbcTemplate.queryForInt(sql);
	} 
	
	public int obtenerNumeroAreaDisponible(int idarea){
		
		int nroarea=0; 
		StringBuffer sqlb = new StringBuffer("select if  (  (" +
				"select r1.numerorecursoinfoarea +1 as inicio " +
				"from   ( select * from  recursoinformacion where idareanatural=");
		sqlb.append(idarea);
		sqlb.append(") as r1 " +
				"left outer join ( select * from  recursoinformacion where idareanatural=");
		sqlb.append(idarea);
		sqlb.append(") as r2  on r2.numerorecursoinfoarea=r1.numerorecursoinfoarea+1 " +
				"where r2.numerorecursoinfoarea is null limit 0,1 ) is null " +
				"  ,1, " +
				"  (   select r1.numerorecursoinfoarea +1 as inicio  " +
				"  from   ( select * from  recursoinformacion where idareanatural=" );
				sqlb.append(idarea);	
				sqlb.append(") as r1 " +
				"left outer join ( select * from  recursoinformacion where idareanatural=");
		sqlb.append(idarea);
		sqlb.append(") as r2  on r2.numerorecursoinfoarea=r1.numerorecursoinfoarea+1 " +
				"where r2.numerorecursoinfoarea is null limit 0,1 ))  ");
		//"      )  ) ");
		String sql =sqlb.toString();
		System.out.println(sql);
		return this.jdbcTemplate.queryForInt(sql);
		/*if(this.jdbcTemplate.queryForInt(sql)==0){
			nroarea=1;
		}
		
		return  nroarea;
	*/
	} 
	
		
	 public List<RecursoInformacion> listar(RecursoInformacion recursoInformacion){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacion);
			if(recursoInformacion.getIdrecursoinformacion()!=0 ){
				sqlb.append(" and ri.idrecursoinformacion=" );
				sqlb.append(recursoInformacion.getIdrecursoinformacion());
			}
			if(recursoInformacion.getTitulo()!=null){
				sqlb.append(" and ri.titulo like '%" );
				sqlb.append(recursoInformacion.getTitulo() );
				sqlb.append("%' " );
				}
				if(recursoInformacion.getMediorecursoinformacion().getIdtipo()!=0){
					sqlb.append(" and ri.idmediorecursoinformacion=" );
					sqlb.append(recursoInformacion.getMediorecursoinformacion().getIdtipo());
				}
				if(recursoInformacion.getTiporecursoinformacion().getIdtipo()!=0){
					sqlb.append(" and ri.idtiporecursoinformacion=" );
					sqlb.append(recursoInformacion.getTiporecursoinformacion().getIdtipo());
				}
				if(recursoInformacion.getIdioma().getIdidioma()!=0 ){
					sqlb.append(" and ri.ididioma=" );
					sqlb.append(recursoInformacion.getIdioma().getIdidioma());
				}
				if(recursoInformacion.getTematicarecursoinformacion().getIdtematicarecursoinformacion()!=0 ){
					sqlb.append(" and ri.idtematicarecursoinformacion=" );
					sqlb.append(recursoInformacion.getTematicarecursoinformacion().getIdtematicarecursoinformacion());
				}
				if(recursoInformacion.getCodigosgd()!=null){
					sqlb.append(" and ri.codigosgd like '%" );
					sqlb.append(recursoInformacion.getCodigosgd() );
					sqlb.append("%' " );
				}
				if(recursoInformacion.getFlagrecursoinformacion()!=0 ){
					sqlb.append(" and ri.flagrecursoinformacion=" );
					sqlb.append(recursoInformacion.getFlagrecursoinformacion());
				}
				else
					if(recursoInformacion.getFlagrecursoinformacion()==ValueConstants.VALOR_CERO ){
						sqlb.append(" and ri.flagrecursoinformacion=0" );
					}
				if(recursoInformacion.getFlagtemporal()!=0 ){
					sqlb.append(" and ri.flagtemporal=" );
					sqlb.append(recursoInformacion.getFlagtemporal());
				}
				else
					if(recursoInformacion.getFlagtemporal()==ValueConstants.VALOR_CERO ){
						sqlb.append(" and ri.flagtemporal=0" );
					}
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionMapper());
			 	
		}
	 
	 
	 public int insertar(RecursoInformacion recursoInformacion){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaRecursoInformacion);
			String sql =sqlb.toString();
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("codigorecursoinformacion",recursoInformacion.getCodigorecursoinformacion() );
			parametros.put("titulo",recursoInformacion.getTitulo() );
			parametros.put("isbn", recursoInformacion.getIsbn());
			parametros.put("codigosgd", recursoInformacion.getCodigosgd());
			parametros.put("descripcionrecursoinformacion", recursoInformacion.getDescripcion());
			parametros.put("fecharegistro", recursoInformacion.getFecharegistro());
			if(recursoInformacion.getAniopublicacion()!=0){
				try {
					parametros.put("aniopublicacion", new java.sql.Date( formateador.parse(String.valueOf(recursoInformacion.getAniopublicacion())).getTime() ));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				parametros.put("aniopublicacion", null);
			}
			parametros.put("ididioma", recursoInformacion.getIdioma().getIdidioma());
			parametros.put("idtematicarecursoinformacion", recursoInformacion.getTematicarecursoinformacion().getIdtematicarecursoinformacion());
			parametros.put("idtiporecursoinformacion", recursoInformacion.getTiporecursoinformacion().getIdtipo());
			parametros.put("idmediorecursoinformacion", recursoInformacion.getMediorecursoinformacion().getIdtipo());
			if(recursoInformacion.getSedebiblioteca().getIdareanatural()!=0){
				parametros.put("idareanatural", recursoInformacion.getSedebiblioteca().getIdareanatural());
			}
			else{
				parametros.put("idareanatural", null);
			}
			parametros.put("numeropaginas", recursoInformacion.getNumeropaginas());
			parametros.put("flagtemporal",recursoInformacion.getFlagtemporal() );
			parametros.put("flagrecursoinformacion",recursoInformacion.getFlagrecursoinformacion() );
			parametros.put("numerorecursoinformacion", recursoInformacion.getNumerorecursoinformacion());
			parametros.put("numerorecursoinformacionarea", recursoInformacion.getNumerorecursoinformacionarea());
			
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	    
	 public void actualizar(RecursoInformacion recursoInformacion){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer("update recursoinformacion set idrecursoinformacion=idrecursoinformacion ");
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("codigorecursoinformacion",recursoInformacion.getCodigorecursoinformacion() );
			parametros.put("titulo",recursoInformacion.getTitulo() );
			parametros.put("isbn", recursoInformacion.getIsbn());
			parametros.put("codigosgd", recursoInformacion.getCodigosgd());
			parametros.put("descripcionrecursoinformacion", recursoInformacion.getDescripcion());
			parametros.put("fecharegistro", recursoInformacion.getFecharegistro());
			parametros.put("ididioma", recursoInformacion.getIdioma().getIdidioma());
			parametros.put("idtematicarecursoinformacion", recursoInformacion.getTematicarecursoinformacion().getIdtematicarecursoinformacion());
			parametros.put("idtiporecursoinformacion", recursoInformacion.getTiporecursoinformacion().getIdtipo());
			parametros.put("idmediorecursoinformacion", recursoInformacion.getMediorecursoinformacion().getIdtipo());
			parametros.put("idareanatural", recursoInformacion.getSedebiblioteca().getIdareanatural());
			parametros.put("numeropaginas", recursoInformacion.getNumeropaginas());
			parametros.put("numerorecursoinfo", recursoInformacion.getNumerorecursoinformacion());
			parametros.put("numerorecursoinfoarea", recursoInformacion.getNumerorecursoinformacionarea());
			if(recursoInformacion.getAniopublicacion()!=0){
				try {
					parametros.put("aniopublicacion", new java.sql.Date( formateador.parse(String.valueOf(recursoInformacion.getAniopublicacion())).getTime() ));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				parametros.put("aniopublicacion", null);
			}
			parametros.put("flagtemporal",recursoInformacion.getFlagtemporal() );
			parametros.put("flagrecursoinformacion",recursoInformacion.getFlagrecursoinformacion() );
			
			if(recursoInformacion.getCodigorecursoinformacion()!=null){
				sqlb.append(", codigorecursoinformacion=:codigorecursoinformacion");
			}
			if(recursoInformacion.getTitulo()!=null){
				sqlb.append(", titulo=:titulo");
			}
			if(recursoInformacion.getIsbn()!=null){
				sqlb.append(", isbn=:isbn");
			}
			if(recursoInformacion.getCodigosgd()!=null){
				sqlb.append(", codigosgd=:codigosgd");
			}
			if(recursoInformacion.getDescripcion()!=null){
				sqlb.append(", descripcionrecursoinformacion=:descripcionrecursoinformacion");
			}
			if(recursoInformacion.getIdioma().getIdidioma()!=0){
				sqlb.append(", ididioma=:ididioma");
			}
			if(recursoInformacion.getTematicarecursoinformacion().getIdtematicarecursoinformacion()!=0){
				sqlb.append(", idtematicarecursoinformacion=:idtematicarecursoinformacion");
			}
			if(recursoInformacion.getTiporecursoinformacion().getIdtipo()!=0){
				sqlb.append(", idtiporecursoinformacion=:idtiporecursoinformacion");
			}
			if(recursoInformacion.getMediorecursoinformacion().getIdtipo()!=0){
				sqlb.append(", idmediorecursoinformacion=:idmediorecursoinformacion");
			}
			if(recursoInformacion.getSedebiblioteca().getIdareanatural()!=0){
				sqlb.append(", idareanatural=:idareanatural");
			}
			if(recursoInformacion.getNumeropaginas()!=0){
				sqlb.append(", numeropaginas=:numeropaginas");
			}
			
			if(recursoInformacion.getAniopublicacion()!=0){
				sqlb.append(",  aniopublicacion=:aniopublicacion");
				
			}
			
			if(recursoInformacion.getFlagtemporal()!=0){
				if(recursoInformacion.getFlagtemporal()==ValueConstants.VALOR_CERO){
					sqlb.append(", flagtemporal=0");	
				}
				else{
					sqlb.append(", flagtemporal=:flagtemporal");
				}
			}
			
			if(recursoInformacion.getFlagrecursoinformacion()!=0){
				if(recursoInformacion.getFlagrecursoinformacion()==ValueConstants.VALOR_CERO){
					sqlb.append(", flagrecursoinformacion=0");	
				}
				else{
					sqlb.append(", flagrecursoinformacion=:flagrecursoinformacion");
				}
			}
			if(recursoInformacion.getNumerorecursoinformacion()!=0){
				sqlb.append(", numerorecursoinfo=:numerorecursoinfo");
			}
			
			if(recursoInformacion.getNumerorecursoinformacionarea()!=0){
				sqlb.append(",  numerorecursoinfoarea=:numerorecursoinfoarea");
				
			}
			sqlb.append(" where idrecursoinformacion=");
			sqlb.append(recursoInformacion.getIdrecursoinformacion());
			String sql =sqlb.toString();
			System.out.println(sql);
			simpleJdbcTemplate.update(sql, parametros);
	}
	 
	 
	 
	 
	 public int contarSubConsulta(RecursoInformacionParam recursoInformacionParam) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarRecursoInformacion);
		 if(recursoInformacionParam.getRecursoinformacion().getIdrecursoinformacion()!=0 ){
				sqlb.append(" and ri.idrecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getIdrecursoinformacion());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTitulo()!=null){
			sqlb.append(" and ri.titulo like '%" );
			sqlb.append(recursoInformacionParam.getRecursoinformacion().getTitulo() );
			sqlb.append("%' " );
			}
			if(recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().getIdtipo()!=0){
				sqlb.append(" and ri.idmediorecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().getIdtipo());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().getIdtipo()!=0){
				sqlb.append(" and ri.idtiporecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().getIdtipo());
			}
			if(recursoInformacionParam.getRecursoinformacion().getIdioma().getIdidioma()!=0 ){
				sqlb.append(" and ri.ididioma=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getIdioma().getIdidioma());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().getIdtematicarecursoinformacion()!=0 ){
				sqlb.append(" and ri.idtematicarecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().getIdtematicarecursoinformacion());
			}
			if(recursoInformacionParam.getRecursoinformacion().getCodigosgd()!=null){
				sqlb.append(" and ri.codigosgd like '%" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getCodigosgd() );
				sqlb.append("%' " );
			}
			
			if(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion()!=0 ){
				if(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and ri.flagrecursoinformacion=0" );
				}else{
					sqlb.append(" and ri.flagrecursoinformacion=" );
					sqlb.append(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion());
				}
				
			}
			
				
			if(recursoInformacionParam.getRecursoinformacion().getFlagtemporal()!=0 ){
				if(recursoInformacionParam.getRecursoinformacion().getFlagtemporal()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and ri.flagtemporal=0" );
				}else{
					sqlb.append(" and ri.flagtemporal=" );
					sqlb.append(recursoInformacionParam.getRecursoinformacion().getFlagtemporal());
				}
				
			}
			
			
			if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0 ||recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(SqlConstants.listaRecursoInformacionSubAreaNatural);
				
				if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0){
					sqlb.append(" and idareanatural=");
					sqlb.append(recursoInformacionParam.getAreanatural().getIdareanatural());
					
				}
				else 
				
					if(recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
					sqlb.append(" and idcategoriaanp=");
					sqlb.append(recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
					
				}
				sqlb.append(") ");
			}
			
			
			if(recursoInformacionParam.getAutor().getIdautor()!=0){
				sqlb.append(SqlConstants.listaRecursoInformacionSubAutor);
				sqlb.append(recursoInformacionParam.getAutor().getIdautor());
			}
			
			if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0 ||recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(")");
				}
			if(recursoInformacionParam.getAutor().getIdautor()!=0){
				sqlb.append(")");
			}
			String sql =sqlb.toString();
			System.out.println(sql);
			return  this.jdbcTemplate.queryForInt(sql);
		 
	 }
	 
	 
	 
	 public List<RecursoInformacion> listarPaginadoSubConsulta(RecursoInformacionParam recursoInformacionParam,int offset,int tamPagina) {
		 
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacion);
			if(recursoInformacionParam.getRecursoinformacion().getIdrecursoinformacion()!=0 ){
				sqlb.append(" and ri.idrecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getIdrecursoinformacion());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTitulo()!=null){
			sqlb.append(" and ri.titulo like '%" );
			sqlb.append(recursoInformacionParam.getRecursoinformacion().getTitulo() );
			sqlb.append("%' " );
			}
			if(recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().getIdtipo()!=0){
				sqlb.append(" and ri.idmediorecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().getIdtipo());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().getIdtipo()!=0){
				sqlb.append(" and ri.idtiporecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().getIdtipo());
			}
			if(recursoInformacionParam.getRecursoinformacion().getIdioma().getIdidioma()!=0 ){
				sqlb.append(" and ri.ididioma=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getIdioma().getIdidioma());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().getIdtematicarecursoinformacion()!=0 ){
				sqlb.append(" and ri.idtematicarecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().getIdtematicarecursoinformacion());
			}
			if(recursoInformacionParam.getRecursoinformacion().getCodigosgd()!=null){
				sqlb.append(" and ri.codigosgd like '%" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getCodigosgd() );
				sqlb.append("%' " );
			}
			if(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion()!=0 ){
				if(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and ri.flagrecursoinformacion=0" );
				}else{
					sqlb.append(" and ri.flagrecursoinformacion=" );
					sqlb.append(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion());
				}
				
			}
			
				
			if(recursoInformacionParam.getRecursoinformacion().getFlagtemporal()!=0 ){
				if(recursoInformacionParam.getRecursoinformacion().getFlagtemporal()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and ri.flagtemporal=0" );
				}else{
					sqlb.append(" and ri.flagtemporal=" );
					sqlb.append(recursoInformacionParam.getRecursoinformacion().getFlagtemporal());
				}
				
			}
			
			
			if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0 ||recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(SqlConstants.listaRecursoInformacionSubAreaNatural);
				
				if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0){
					sqlb.append(" and idareanatural=");
					sqlb.append(recursoInformacionParam.getAreanatural().getIdareanatural());
					
				}
				else 
				
					if(recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
					sqlb.append(" and idcategoriaanp=");
					sqlb.append(recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
					
				}
				sqlb.append(") ");
				}
			
			
			if(recursoInformacionParam.getAutor().getIdautor()!=0){
				sqlb.append(SqlConstants.listaRecursoInformacionSubAutor);
				sqlb.append(recursoInformacionParam.getAutor().getIdautor());
			}
			
			if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0 ||recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(")");
				}
			if(recursoInformacionParam.getAutor().getIdautor()!=0){
				sqlb.append(")");
			}
			sqlb.append(" order by ri.titulo ");
			sqlb.append(" LIMIT ");
			sqlb.append(offset);
			sqlb.append(",");
			sqlb.append(tamPagina);
			 String sql =sqlb.toString();
			 System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionMapper());
		 
	 }
	 
	 
	 
	 
public List<RecursoInformacion> listarSubConsulta(RecursoInformacionParam recursoInformacionParam) {
		 
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacion);
			if(recursoInformacionParam.getRecursoinformacion().getIdrecursoinformacion()!=0 ){
				sqlb.append(" and ri.idrecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getIdrecursoinformacion());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTitulo()!=null){
			sqlb.append(" and ri.titulo like '%" );
			sqlb.append(recursoInformacionParam.getRecursoinformacion().getTitulo() );
			sqlb.append("%' " );
			}
			if(recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().getIdtipo()!=0){
				sqlb.append(" and ri.idmediorecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getMediorecursoinformacion().getIdtipo());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().getIdtipo()!=0){
				sqlb.append(" and ri.idtiporecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getTiporecursoinformacion().getIdtipo());
			}
			if(recursoInformacionParam.getRecursoinformacion().getIdioma().getIdidioma()!=0 ){
				sqlb.append(" and ri.ididioma=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getIdioma().getIdidioma());
			}
			if(recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().getIdtematicarecursoinformacion()!=0 ){
				sqlb.append(" and ri.idtematicarecursoinformacion=" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getTematicarecursoinformacion().getIdtematicarecursoinformacion());
			}
			if(recursoInformacionParam.getRecursoinformacion().getCodigosgd()!=null){
				sqlb.append(" and ri.codigosgd like '%" );
				sqlb.append(recursoInformacionParam.getRecursoinformacion().getCodigosgd() );
				sqlb.append("%' " );
			}
			if(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion()!=0 ){
				if(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and ri.flagrecursoinformacion=0" );
				}else{
					sqlb.append(" and ri.flagrecursoinformacion=" );
					sqlb.append(recursoInformacionParam.getRecursoinformacion().getFlagrecursoinformacion());
				}
				
			}
			
				
			if(recursoInformacionParam.getRecursoinformacion().getFlagtemporal()!=0 ){
				if(recursoInformacionParam.getRecursoinformacion().getFlagtemporal()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and ri.flagtemporal=0" );
				}else{
					sqlb.append(" and ri.flagtemporal=" );
					sqlb.append(recursoInformacionParam.getRecursoinformacion().getFlagtemporal());
				}
				
			}
			
			
			if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0 ||recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(SqlConstants.listaRecursoInformacionSubAreaNatural);
				
				if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0){
					sqlb.append(" and idareanatural=");
					sqlb.append(recursoInformacionParam.getAreanatural().getIdareanatural());
					
				}
				else 
				
					if(recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
					sqlb.append(" and idcategoriaanp=");
					sqlb.append(recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
					
				}
				sqlb.append(") ");
				}
			
			
			if(recursoInformacionParam.getAutor().getIdautor()!=0){
				sqlb.append(SqlConstants.listaRecursoInformacionSubAutor);
				sqlb.append(recursoInformacionParam.getAutor().getIdautor());
			}
			
			if(recursoInformacionParam.getAreanatural().getIdareanatural()!=0 ||recursoInformacionParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(")");
				}
			if(recursoInformacionParam.getAutor().getIdautor()!=0){
				sqlb.append(")");
			}
			sqlb.append(" order by ri.titulo ");
			 String sql =sqlb.toString();
			 System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionMapper());
		 
	 }
	 
	 
	
}
