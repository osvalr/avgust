package proyecto.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.Querys;
import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.param.FichaTurismoParam;
import proyecto.util.ProjectUtils;
import proyecto.vo.Fichaturismo;

@Repository  
public class FichaturismoDAO implements Querys{
  
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;  
	private String where,orderby = "";
	  
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	
	
	
	public int obtenerNumeroCorrelativoxFecha(Date fecharegistro){
		int nro=0;
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sqlb = new StringBuffer(SqlConstants.obtenerNumeroCorrelativoxFecha);
		if(fecharegistro!=null ){
			sqlb.append(" and TO_CHAR(ft.fecharegistro, 'yyyy-MM-dd')=" );
			sqlb.append("'"+formateador.format(fecharegistro)+"'");
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		nro=this.jdbcTemplate.queryForInt(sql);
		if(nro==0){
			nro=1;
		}else{
			nro++;
		}
		return nro;
		
	} 
	
	
	public int obtenerNumeroCorrelativoxAreaNatural(int idareanatural){
		int nro=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.obtenerNumeroCorrelativoxAreaNatural);
		if(idareanatural!=0 ){
			sqlb.append(" and ft.idareanatural=" );
			sqlb.append(idareanatural);
	    }
		String sql =sqlb.toString();
		//System.out.println(sql);
		//return  this.jdbcTemplate.queryForInt(sql);
		nro=this.jdbcTemplate.queryForInt(sql);
		if(nro==0){
			nro=1;
		}else{
			nro++;
		}
		return nro;
	}
	
	
	public int contar(FichaTurismoParam fichaturismoparam,int tipoclausulacodigo) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarFichaTurismo);
		 agregarClausulasConsulta(fichaturismoparam, sqlb,tipoclausulacodigo);
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
	
    public List<Fichaturismo> listarPaginado(FichaTurismoParam fichaturismoparam,int offset,int tamPagina,int tipoclausulacodigo) {
		 
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaFichaTurismo);
		 agregarClausulasConsulta(fichaturismoparam, sqlb,tipoclausulacodigo);
			sqlb.append(" order by ft.fechapropuesta desc, ft.numfecha desc ");
			sqlb.append(" LIMIT ");
			sqlb.append(tamPagina);
			sqlb.append(" OFFSET ");
			sqlb.append(offset);
			 String sql =sqlb.toString();
			//System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMapper() );
		 
	 }
	
     public List<Fichaturismo> listar(Fichaturismo fichaturismo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFichaTurismo);
		if(fichaturismo.getIdfichaturismo()!=0 ){
			sqlb.append(" and ft.idfichaturismo=" );
			sqlb.append(fichaturismo.getIdfichaturismo());
		}
		if(fichaturismo.getCodigoficha()!=null ){
			sqlb.append(" and ft.codigoficha='" );
			sqlb.append(fichaturismo.getCodigoficha()+"'");
	    }
		if(fichaturismo.getAreanatural().getIdareanatural()!=0 ){
			sqlb.append(" and ft.idareanatural=" );
			sqlb.append(fichaturismo.getAreanatural().getIdareanatural());
	    }
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMapper());
			
	}
    
     public List<Fichaturismo> listarMinimo(Fichaturismo fichaturismo){
 		StringBuffer sqlb = new StringBuffer(SqlConstants.listaMinimoFichaTurismo);
 		if(fichaturismo.getIdfichaturismo()!=0 ){
 			sqlb.append(" and ft.idfichaturismo=" );
 			sqlb.append(fichaturismo.getIdfichaturismo());
 		}
 		String sql =sqlb.toString();
 		//System.out.println(sql);
 		return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMinimoMapper());
 			
 	}
    
    
    public List<Fichaturismo> listar(FichaTurismoParam fichaturismoparam,int tipoclausulacodigo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFichaTurismo);
		agregarClausulasConsulta(fichaturismoparam, sqlb,tipoclausulacodigo);
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMapper());
			
	}
    
     public void agregarClausulasConsulta(FichaTurismoParam fichaturismoparam, StringBuffer sqlb,int tipoclausulacodigo){
    	 
    	 
    	 if(fichaturismoparam.getIdtipoconsulta()!=0 ){
    		   //ficha generada
    		   if(fichaturismoparam.getIdtipoconsulta()==ValueConstants.TIPO_CONSULTA_FICHA_GENERADA){
    			   sqlb.append(" and ft.codigoficha!=''" );
    		   }else
    			   if(fichaturismoparam.getIdtipoconsulta()==ValueConstants.TIPO_CONSULTA_FICHA_GENERADA_AND_CREADA){
        			   sqlb.append(" and ( ft.codigoficha!='' or ft.idtiporolcreacion=");
        			   sqlb.append(fichaturismoparam.getIdtiporolcreacion());
        			   sqlb.append(")");
        		   }
		 }
    	 
    	 if(fichaturismoparam.getFichaturismo().getIdfichaturismo()!=0 ){
				sqlb.append(" and ft.idfichaturismo=" );
				sqlb.append(fichaturismoparam.getFichaturismo().getIdfichaturismo());
		 }
    	 if(tipoclausulacodigo==0){
    		 if(fichaturismoparam.getFichaturismo().getCodigoficha()!=null ){
				    sqlb.append(" and ft.codigoficha='" );
					sqlb.append(fichaturismoparam.getFichaturismo().getCodigoficha()+"'"); 	
		      }
    	 }else{
    		 if(fichaturismoparam.getFichaturismo().getCodigoficha()!=null ){
				    sqlb.append(" and ft.codigoficha like'%" );
					sqlb.append(fichaturismoparam.getFichaturismo().getCodigoficha()+"%'"); 	
		      }  
    		  
    	 }
		 
		 if(fichaturismoparam.getFichaturismo().getAreanatural().getIdareanatural()!=0 ){
				sqlb.append(" and ft.idareanatural=" );
				sqlb.append(fichaturismoparam.getFichaturismo().getAreanatural().getIdareanatural());
		 }
		 if( !fichaturismoparam.getFpropuestainicio().equals("")){
				sqlb.append(" and ft.fechapropuesta>='" );
				sqlb.append(fichaturismoparam.getFpropuestainicio()+"'");
		 }
		 if(!fichaturismoparam.getFpropuestafin().equals("")){
				sqlb.append(" and ft.fechapropuesta<='" );
				sqlb.append(fichaturismoparam.getFpropuestafin()+"'");
		 }
		 if( !fichaturismoparam.getFregistroinicio().equals("")){
				sqlb.append(" and ft.fecharegistro>='" );
				sqlb.append(fichaturismoparam.getFregistroinicio()+"'");
		  }
		if(!fichaturismoparam.getFregistrofin().equals("")){
				sqlb.append(" and ft.fecharegistro<='" );
				sqlb.append(fichaturismoparam.getFregistrofin()+"'");
		}
//		if(fichaturismoparam.getFichaturismo().getFlagfichaturismo()!=0){
//			if(fichaturismoparam.getFichaturismo().getFlagfichaturismo()==ValueConstants.VALOR_CERO){
//				sqlb.append(" and ft.flagfichaturismo=0");	
//			}
//			else{
//				sqlb.append(" and ft.flagfichaturismo=");
//				sqlb.append(fichaturismoparam.getFichaturismo().getFlagfichaturismo());
//			}
//		}
		if(fichaturismoparam.getFichaturismo().getOperadorturismo().getIdoperadorturismo()!=0 ){
			sqlb.append(" and ft.idoperadorturismo=" );
			sqlb.append(fichaturismoparam.getFichaturismo().getOperadorturismo().getIdoperadorturismo());
	     }
		
		if(fichaturismoparam.getFichaturismo().getIdtiporolcreacion()!=0 ){
			sqlb.append(" and ft.idtiporolcreacion=" );
			sqlb.append(fichaturismoparam.getFichaturismo().getIdtiporolcreacion());
	     }
		
		if(fichaturismoparam.getFichaturismo().getRutaturismo().getIdrutaturismo()!=0 ){
			sqlb.append(" and ft.idrutaturismo=" );
			sqlb.append(fichaturismoparam.getFichaturismo().getRutaturismo().getIdrutaturismo());
	     }
//		if(fichaturismoparam.getFichaturismo().getFlagpagobanco()!=0){
//			if(fichaturismoparam.getFichaturismo().getFlagpagobanco()==ValueConstants.VALOR_CERO){
//				sqlb.append(" and ft.flagpagobanco=0");	
//			}
//			else{
//				sqlb.append(" and ft.flagpagobanco=");
//				sqlb.append(fichaturismoparam.getFichaturismo().getFlagpagobanco());
//			}
//		}
		
		
//		if(fichaturismoparam.getFichaturismo().getEstadopagobanco().getIdtipo()!=0){
//			if(fichaturismoparam.getFichaturismo().getEstadopagobanco().getIdtipo()==ValueConstants.VALOR_CERO){
//				sqlb.append(" and ft.idestadopago=0");	
//			}
//			else{
//				sqlb.append(" and ft.idestadopago=");
//				sqlb.append(fichaturismoparam.getFichaturismo().getEstadopagobanco().getIdtipo());
//			}
//		}
		if(fichaturismoparam.getFichaturismo().getFlagregistro()!=0){
			if(fichaturismoparam.getFichaturismo().getFlagregistro()==ValueConstants.VALOR_CERO){
				sqlb.append(" and ft.flagregistro=0");	
			}
			else{
				sqlb.append(" and ft.flagregistro=");
				sqlb.append(fichaturismoparam.getFichaturismo().getFlagregistro());
			}
		}
    	 
		if(fichaturismoparam.getFichaturismo().getIdtiporolcreacion()!=0){
				sqlb.append(" and ft.idtiporolcreacion=");
				sqlb.append(fichaturismoparam.getFichaturismo().getIdtiporolcreacion());		
		}
		if(fichaturismoparam.getFichaturismo().getEstadoficha().getIdtipo()!=0){
			sqlb.append(" and ft.idestadoficha=");
			sqlb.append(fichaturismoparam.getFichaturismo().getEstadoficha().getIdtipo());		
	    }
//		if(fichaturismoparam.getFichaturismo().getModalidadpago().getIdtipo()!=0){
//			sqlb.append(" and ft.idmodalidadpago=");
//			sqlb.append(fichaturismoparam.getFichaturismo().getModalidadpago().getIdtipo());		
//	    }
		
     }
    
    
	
    public List<Map<String, Object>> listarPeriodoconFechaRegistro(){
    	StringBuffer sqlb = new StringBuffer("select distinct date_part('year',fecharegistro) as periodo  from sernanp.fichaturismo order by date_part('year',fecharegistro)");
    	String sql =sqlb.toString();
		 //System.out.println(sql);
		 return this.simpleJdbcTemplate.queryForList(sql);
		//return  this.jdbcTemplate.query(sql, new RowMappersConstants().f );
    	
	}
	
   
    
    public List<Map<String, Object>> listarPeriodoconFichasConsolidadas(int idestado){
    	StringBuffer sqlb = new StringBuffer("select distinct date_part('year',fecharegistro) as periodo  " +
    			"from sernanp.fichaturismo   where 1=1 ");
    	sqlb.append(" and idestadoficha= ");
    	sqlb.append(idestado);
    		sqlb.append(" order by date_part('year',fecharegistro)");
    			
    	String sql =sqlb.toString();
		 //System.out.println(sql);
		 return this.simpleJdbcTemplate.queryForList(sql);
		//return  this.jdbcTemplate.query(sql, new RowMappersConstants().f );
    	
	}
    
    

	
   
   
   public long insertar(Fichaturismo ficha){  
//	    StringBuffer sqlb = new StringBuffer(SqlConstants.insertaFichaTurismo);
//		String sql =sqlb.toString();
  	    Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idareanatural",ficha.getAreanatural().getIdareanatural() );
		parametros.put("idrutaturismo",ficha.getRutaturismo().getIdrutaturismo() );
		//parametros.put("idtipoturismo", ficha.getTipoturismo().getIdtipoturismo());
		if(ficha.getFechaingreso()!=null){
			parametros.put("fechaingreso", new java.sql.Date(ficha.getFechaingreso().getTime()));
		}
		else{
			parametros.put("fechaingreso", null);
		}
		
		if(ficha.getOperadorturismo().getIdoperadorturismo()!=0){
			parametros.put("idoperadorturismo", ficha.getOperadorturismo().getIdoperadorturismo());
		}
		else{
			parametros.put("idoperadorturismo",null);
		}
		if(ficha.getEmpresaturismo().getIdoperadorturismo()!=0){
			parametros.put("idempresaturismo", ficha.getEmpresaturismo().getIdoperadorturismo());
		}else{
			parametros.put("idempresaturismo", null);
		}
		
		if(ficha.getFechapropuesta()!=null){
			parametros.put("fechapropuesta", new java.sql.Date(ficha.getFechapropuesta().getTime()));
		}
		else{
			parametros.put("fechapropuesta", null);
		}
		if(ficha.getFecharegistro()!=null){
			parametros.put("fecharegistro", new java.sql.Date(ficha.getFecharegistro().getTime()));
		}
		else{
			parametros.put("fecharegistro", null);
		}
		if(ficha.getIdtiporolcreacion()!=0){
			parametros.put("idtiporolcreacion",ficha.getIdtiporolcreacion());
		}
		else{
			parametros.put("idtiporolcreacion", null);
		}
		if(ficha.getEstadoficha().getIdtipo()!=0){
			parametros.put("idestadoficha",ficha.getEstadoficha().getIdtipo());
		}
		else{
			parametros.put("idestadoficha", null);
		}
//		if(ficha.getModalidadpago().getIdtipo()!=0){
//			parametros.put("idmodalidadpago",ficha.getModalidadpago().getIdtipo());
//		}
//		else{
//			parametros.put("idmodalidadpago", null);
//		}
//		if(ficha.getFechacreacion()!=null){
//			parametros.put("fechacreacion",  ficha.getFechacreacion());
//		}
//		else{
//			parametros.put("fechacreacion", null);
//		}
//		if(ficha.getUsuariocreacion().getIdUsuario()!=0){
//			parametros.put("idusuariocreacion", ficha.getUsuariocreacion().getIdUsuario() );
//		}
//		else{
//			parametros.put("idusuariocreacion", null);
//		}
		parametros.put("idrutaturismo", ficha.getRutaturismo().getIdrutaturismo());
		//parametros.put("flagfichaturismo", ficha.getFlagfichaturismo());
		//parametros.put("flagfichagenerada", ficha.getFlagfichagenerada());
		parametros.put("codigoficha", ficha.getCodigoficha());
		parametros.put("flagregistro", ficha.getFlagregistro());
        long id=this.simpleJdbcTemplate.queryForLong(SqlConstants.insertaFichaTurismo,parametros);
        ficha.setIdfichaturismo(id);
		saveActividades(ficha);
		return ficha.getIdfichaturismo();   
	} 
   
   
   
   
	
//     public long save(Fichaturismo ficha){  
//    	 
//    	 Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("idareanatural",ficha.getAreanatural().getIdareanatural() );
//		parametros.put("idrutaturismo",ficha.getRutaturismo().getIdrutaturismo() );
//		//parametros.put("idtipoturismo", ficha.getTipoturismo().getIdtipoturismo());
//		if(ficha.getFechaingreso()!=null){
//			parametros.put("fechaingreso", new java.sql.Date(ficha.getFechaingreso().getTime()));
//		}
//		else{
//			parametros.put("fechaingreso", null);
//		}
//		
//		if(ficha.getOperadorturismo().getIdoperadorturismo()!=0){
//			parametros.put("idoperadorturismo", ficha.getOperadorturismo().getIdoperadorturismo());
//		}
//		else{
//			parametros.put("idoperadorturismo",null);
//		}
//		if(ficha.getEmpresaturismo().getIdoperadorturismo()!=0){
//			parametros.put("idempresaturismo", ficha.getEmpresaturismo().getIdoperadorturismo());
//		}else{
//			parametros.put("idempresaturismo", null);
//		}
//		
//		if(ficha.getFechapropuesta()!=null){
//			parametros.put("fechapropuesta", new java.sql.Date(ficha.getFechapropuesta().getTime()));
//		}
//		else{
//			parametros.put("fechapropuesta", null);
//		}
//		parametros.put("idrutaturismo", ficha.getRutaturismo().getIdrutaturismo());
//		parametros.put("flagfichaturismo", ficha.getFlagfichaturismo());
//		//parametros.put("codigoficha", ficha.getFlagfichaturismo());
//		long id=
//		this.simpleJdbcTemplate.queryForLong(FICHAINSERT,
//		parametros		
//		);
//		ficha.setIdfichaturismo(id);
//		saveActividades(ficha);
//		return ficha.getIdfichaturismo();   
//	} 
	
	
	public void consolidarFicha(Fichaturismo ficha ){
		this.simpleJdbcTemplate.update(   
		        "UPDATE sernanp.fichaturismo SET flagfichaturismo = ? , fechaingreso=? WHERE idfichaturismo = ? ",   
		        new Object[] { ficha.getFlagfichaturismo() ,   new java.sql.Date(ficha.getFechaingreso().getTime()) , ficha.getIdfichaturismo() });
	}
	
	public void saveActividades(Fichaturismo ficha){
		 
		Long id = ficha.getIdfichaturismo();
		int[] ids = ficha.getActividades();
		if (ids != null && ids.length > 0) {

			List<String> inserts = new ArrayList<String>();
			String sql = "INSERT INTO sernanp.actividadturismofichaturismo VALUES";
			if (ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					inserts.add("(" + ids[i] + ","	+ id+ ")");
				}
			} else {
				inserts.add("(" + id + "," + ficha.getTipoturismo().getIdtipoturismo()
						+ " )");
			}
			sql += ProjectUtils.explode(inserts);

			this.simpleJdbcTemplate.update(sql);
		}
		
		
	}
	
	public List<Fichaturismo> listar() {
		return simpleJdbcTemplate.query(
				FICHA,
				ParameterizedBeanPropertyRowMapper.newInstance(Fichaturismo.class));
	}
	
	public long count( ) {
		return simpleJdbcTemplate.queryForLong(
				FICHACOUNT );
	}
	
	public long countActives( ) {
		return simpleJdbcTemplate.queryForLong(
				FICHACOUNT + " AND flagfichaturismo IS NULL ");
	}


	public long countActives( int idarea ) {
		return simpleJdbcTemplate.queryForLong(
				FICHACOUNT + "AND idareanatural = "+idarea+" AND flagfichaturismo =0 ");
	}

	public long count( String code ) {
		return simpleJdbcTemplate.queryForLong(
				FICHACOUNT +
				"AND codigoficha=?",new Object[]{code} );
	}

	public Fichaturismo getfromCode( String code ) {
		
		
		String sql= FICHAFULL + " AND f.codigoficha='"+code+"'";
		List<Fichaturismo> lista=this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMapper());
		return lista.get(0);
		/*
		return simpleJdbcTemplate.queryForObject(
				FICHAFULL+
				"AND codigoficha=?",
				ParameterizedBeanPropertyRowMapper.newInstance(Fichaturismo.class),
				new Object[]{code}
				
		);
		*/
	
	}

	public List<Fichaturismo> listar( int page, int limit ) {
		page--; 
		  
		String 	sql = FICHAFULL+
				" AND idfichaturismo > " +( limit*page ) +
				" LIMIT "+ limit;
		  
		return simpleJdbcTemplate.query(  
				sql ,
				ParameterizedBeanPropertyRowMapper.newInstance(Fichaturismo.class));
	}
	
	public List<Fichaturismo> listarActivas(int idarea, int page, int limit ) {
		page--; 
		String 	sql = FICHAFULL+    
				" AND idareanatural = " + idarea +
				" AND idfichaturismo > " +( limit*page ) +  
				" AND flagfichaturismo =0 " +     
				" LIMIT "+ limit;   
		//System.out.println("Listar Fichas Activas" + sql);      
		return this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMapper());
	}
	
	public Fichaturismo findById(Integer id){
		
		String sql= FICHAFULL + "AND f.idfichaturismo=" + id;
		List<Fichaturismo> lista=this.jdbcTemplate.query(sql, new RowMappersConstants.FichaTurismoMapper());
		return lista.get(0);
		/*
		return simpleJdbcTemplate.queryForObject(
				FICHAFULL +
				"AND f.idfichaturismo=" + id,
				ParameterizedBeanPropertyRowMapper.newInstance(Fichaturismo.class));
	     */
	}
	public String filter(){
		String sql = FICHAFULL +
					where +
					"ORDER BY " + orderby ;
		return sql;
	}
	
	
	
	 public void actualizar(Fichaturismo fichaturismo){
		 StringBuffer sqlb = new StringBuffer("update sernanp.fichaturismo set idfichaturismo=idfichaturismo ");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("flagregistro",fichaturismo.getFlagregistro() );
			//parametros.put("flagfichaturismo",fichaturismo.getFlagfichaturismo() );
			//parametros.put("flagpagobanco",fichaturismo.getFlagpagobanco() );
			//parametros.put("idestadopago",fichaturismo.getEstadopagobanco().getIdtipo());
			parametros.put("idrutaturismo",fichaturismo.getRutaturismo().getIdrutaturismo());
			parametros.put("idoperadorturismo",fichaturismo.getOperadorturismo().getIdoperadorturismo());
			parametros.put("idempresaturismo",fichaturismo.getEmpresaturismo().getIdoperadorturismo());
			parametros.put("numfecha",fichaturismo.getNumfecharegistro());
			parametros.put("fecharegistro", fichaturismo.getFecharegistro());
			parametros.put("fechapropuesta", fichaturismo.getFechapropuesta());
			parametros.put("codigoficha", fichaturismo.getCodigoficha());
			parametros.put("fechaingreso", fichaturismo.getFechaingreso());
			parametros.put("idestadoficha",fichaturismo.getEstadoficha().getIdtipo());
			//parametros.put("idmodalidadpago",fichaturismo.getModalidadpago().getIdtipo());
//			if(fichaturismo.getFlagpagobanco()!=0){
//				if(fichaturismo.getFlagpagobanco()==ValueConstants.VALOR_CERO){
//					sqlb.append(", flagpagobanco=0");	
//				}
//				else{
//					sqlb.append(", flagpagobanco=:flagpagobanco");
//				}
//			}
			if(fichaturismo.getFlagregistro()!=0){
				if(fichaturismo.getFlagregistro()==ValueConstants.VALOR_CERO){
					sqlb.append(", flagregistro=0");	
				}
				else{
					sqlb.append(", flagregistro=:flagregistro");
				}
			}
//			if(fichaturismo.getFlagfichaturismo()!=0){
//				if(fichaturismo.getFlagfichaturismo()==ValueConstants.VALOR_CERO){
//					sqlb.append(", flagfichaturismo=0");	
//				}
//				else{
//					sqlb.append(", flagfichaturismo=:flagfichaturismo");
//				}
//			}
//			if(fichaturismo.getEstadopagobanco().getIdtipo()!=0){
//				if(fichaturismo.getEstadopagobanco().getIdtipo()==ValueConstants.VALOR_CERO){
//					sqlb.append(", idestadopago=0");	
//				}
//				else{
//					sqlb.append(", idestadopago=:idestadopago");
//				}
//			}
			if(fichaturismo.getEstadoficha().getIdtipo()!=0){
				if(fichaturismo.getEstadoficha().getIdtipo()==ValueConstants.VALOR_CERO){
					sqlb.append(", idestadofichao=0");	
				}
				else{
					sqlb.append(", idestadoficha=:idestadoficha");
				}
			}
//			if(fichaturismo.getModalidadpago().getIdtipo()!=0){
//				if(fichaturismo.getModalidadpago().getIdtipo()==ValueConstants.VALOR_CERO){
//					sqlb.append(", idmodalidadpago=0");	
//				}
//				else{
//					sqlb.append(", idmodalidadpago=:idmodalidadpago");
//				}
//			}
			if(fichaturismo.getRutaturismo().getIdrutaturismo()!=0){
				sqlb.append(", idrutaturismo=:idrutaturismo");
			}
			if(fichaturismo.getEmpresaturismo().getIdoperadorturismo()!=0){
				if(fichaturismo.getEmpresaturismo().getIdoperadorturismo()==ValueConstants.VALOR_CERO){
					sqlb.append(", idempresaturismo=null");	
				}
				else{
					sqlb.append(", idempresaturismo=:idempresaturismo");
				}
			}
			if(fichaturismo.getOperadorturismo().getIdoperadorturismo()!=0){
				if(fichaturismo.getOperadorturismo().getIdoperadorturismo()==ValueConstants.VALOR_CERO){
					sqlb.append(", idoperadorturismo=null");	
				}
				else{
					sqlb.append(", idoperadorturismo=:idoperadorturismo");
				}
			}
			if(fichaturismo.getNumfecharegistro()!=0){
				sqlb.append(", numfecha=:numfecha");
			}
			if(fichaturismo.getFecharegistro()!=null){
				sqlb.append(", fecharegistro=:fecharegistro");
			}
			if(fichaturismo.getFechapropuesta()!=null){
				sqlb.append(", fechapropuesta=:fechapropuesta");
			}
			if(fichaturismo.getFechaingreso()!=null){
				sqlb.append(", fechaingreso=:fechaingreso");
			}
			if(fichaturismo.getCodigoficha()!=null){
				sqlb.append(", codigoficha=:codigoficha");
			}
			sqlb.append(" where idfichaturismo=");
			sqlb.append(fichaturismo.getIdfichaturismo());
			String sql =sqlb.toString();
			//System.out.println(sql);
		 simpleJdbcTemplate.update(sql, parametros);
	 }
	
	
	
	 
	
}
