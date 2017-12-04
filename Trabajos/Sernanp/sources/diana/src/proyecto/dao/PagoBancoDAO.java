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
import proyecto.dao.procedure.PagoBancoProcedure;
import proyecto.param.PagoBancoParam;
import proyecto.vo.Operadorturismo;
import proyecto.vo.PagoBanco;





@Repository 
public class PagoBancoDAO  {

	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;
	private PagoBancoProcedure pagoBancoProcedure;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.dataSource=dataSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		this.pagoBancoProcedure=new PagoBancoProcedure(dataSource);
	}
	  

	String insertaPagoBanco="insert into sernanp.pagobanco(idpagobanco,codigopagobanco,codigotributo," +
	"tipodocumento,numerodocumento,codigoficha,registro,cadimporte,cadfechamovimiento,hora,numerovoucher," +
	"chequeo,agencia,cajero,filler,importe,fechamovimiento) " +
	" select nextval('sernanp.pagobanco_idpagobanco_seq'),:codigopagobanco,:codigotributo," +
	":tipodocumento,:numerodocumento,:codigoficha,:registro,:cadimporte,:cadfechamovimiento,:hora,:numerovoucher," +
	":chequeo,:agencia,:cajero,:filler,:importe,:fechamovimiento " +
	" RETURNING  rowidpagobanco ";
	
	
	
	 public static final String insertaNoDuplicadoPagoBanco=
			"select sernanp.insertar_pagobanco(:idpagobanco,:codigotributo," +
	":tipodocumento,:numerodocumento,:codigoficha,:registro,:cadimporte,:cadfechamovimiento,:hora,:numerovoucher," +
	":chequeo,:agencia,:cajero,:filler,:importe,:fechamovimiento) " ;
	

//	public int insertar(PagoBanco pagoBanco){
//		int id=0;
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("idpagobanco", pagoBanco.getIdpagobanco());
//		parametros.put("codigotributo",pagoBanco.getCadcodigotributo());
//		parametros.put("tipodocumento",pagoBanco.getCadtipodocumento());
//		parametros.put("numerodocumento",pagoBanco.getCadnumerodocumento());
//		parametros.put("codigoficha", pagoBanco.getCadcodigoficha());
//		parametros.put("registro", pagoBanco.getCadnumeroregistro());
//		parametros.put("cadimporte", pagoBanco.getCadimporte());
//		parametros.put("cadfechamovimiento", pagoBanco.getCadfechamovimiento());
//		parametros.put("hora", pagoBanco.getCadhora());
//		parametros.put("numerovoucher", pagoBanco.getCadnumerovoucher());
//		parametros.put("chequeo", pagoBanco.getCaddigitochequeo());
//		parametros.put("agencia",pagoBanco.getCadcodigoagencia());
//		parametros.put("cajero", pagoBanco.getCadcodigocajero());
//		parametros.put("filler", pagoBanco.getCadfiller());
//		parametros.put("importe", pagoBanco.getImporte());
//		parametros.put("fechamovimiento", pagoBanco.getFechamovimiento());
//		id=simpleJdbcTemplate.queryForInt(insertaPagoBanco,parametros);
//		return id;
//	}
//	
//	
//	public void insertar(List<PagoBanco> listaPagoBanco){
//	  Map[] arraymap=new Map[listaPagoBanco.size()];
//      int i=0;
//	  for (PagoBanco pagoBanco : listaPagoBanco) {
//    	  Map<String, Object> parametros = new HashMap<String, Object>();
//  		parametros.put("codigopagobanco", pagoBanco.getCodigopagobanco());
//  		parametros.put("codigotributo",pagoBanco.getCadcodigotributo());
//  		parametros.put("tipodocumento",pagoBanco.getCadtipodocumento());
//  		parametros.put("numerodocumento",pagoBanco.getCadnumerodocumento());
//  		parametros.put("codigoficha", pagoBanco.getCadcodigoficha());
//  		parametros.put("registro", pagoBanco.getCadnumeroregistro());
//  		parametros.put("cadimporte", pagoBanco.getCadimporte());
//		parametros.put("cadfechamovimiento", pagoBanco.getCadfechamovimiento());
//  		parametros.put("hora", pagoBanco.getCadhora());
//  		parametros.put("numerovoucher", pagoBanco.getCadnumerovoucher());
//  		parametros.put("chequeo", pagoBanco.getCaddigitochequeo());
//  		parametros.put("agencia",pagoBanco.getCadcodigoagencia());
//  		parametros.put("cajero", pagoBanco.getCadcodigocajero());
//  		parametros.put("filler", pagoBanco.getCadfiller());
//  		parametros.put("importe", pagoBanco.getImporte());
//		parametros.put("fechamovimiento", pagoBanco.getFechamovimiento());
//        arraymap[i]=parametros;
//        i++;
//      }
//        int[] updateCounts = simpleJdbcTemplate.batchUpdate(
//                insertaPagoBanco,
//                arraymap);
//	}

	public void insertarNoDuplicado(PagoBanco pagoBanco){
		pagoBancoProcedure.insertarNoDuplicado(pagoBanco);
	}
	
	
	public List<PagoBanco> listar(PagoBanco pagobanco){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPagoBanco);
		if(pagobanco.getCadcodigoficha()!=null ){
			sqlb.append(" and pb.codigoficha='" );
			sqlb.append(pagobanco.getCadcodigoficha()+"'");
		}
		if(pagobanco.getIdpagobanco()!=0){
			sqlb.append(" and pb.idpagobanco=" );
			sqlb.append(pagobanco.getIdpagobanco());
		}
	
		String sql =sqlb.toString();
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PagoBancoMapper());		 	
	}
	
	
	public List<PagoBanco> listarxIdpagoficha(int idpagoficha){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPagoBancoxIdPagoFicha);
		if(idpagoficha!=0 ){
			sqlb.append(idpagoficha);
		}
		sqlb.append(")");
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PagoBancoMapper());		 	
	}

	public List<PagoBanco> listarxOperador(PagoBancoParam pagoBancoParam){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPagoBancoxOperadorturismo);
		if(pagoBancoParam.getOperadorturismo().getIdoperadorturismo()!=0 ){
			sqlb.append(pagoBancoParam.getOperadorturismo().getIdoperadorturismo());
		}
		sqlb.append(" )");
		if(pagoBancoParam.getSaldo()!=0){
			if(pagoBancoParam.getSaldo()==ValueConstants.VALOR_CERO){
				sqlb.append(" and pb.saldo=0");
			}else{
				sqlb.append(" and pb.saldo!=0 and pb.saldo<>pb.importe");
			}
		}	
		String sql =sqlb.toString();
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PagoBancoMapper());		 	
	}
	
	
	
	public List<PagoBanco> listarDisponiblexOperador(PagoBancoParam pagoBancoParam){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPagoBancoDisponiblexOperadorturismo);
		if(pagoBancoParam.getCodigoficha()!=null ){
			sqlb.append(pagoBancoParam.getCodigoficha());
		}
		sqlb.append("'");
		if(pagoBancoParam.getOperadorturismo().getIdoperadorturismo()!=0 ){
			sqlb.append(" or codigoficha in (select codigoficha from sernanp.fichaturismo where idoperadorturismo= ");
			sqlb.append(pagoBancoParam.getOperadorturismo().getIdoperadorturismo());
			sqlb.append(" )");
		}
		sqlb.append(" )");
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PagoBancoMapper());		 	
	}
	
	
	public void actualizar(PagoBanco pagobanco){
		StringBuffer sqlb = new StringBuffer("update sernanp.pagobanco set idpagobanco=idpagobanco ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("saldo", pagobanco.getSaldo());
		if(pagobanco.getSaldo()!=0){
			if(pagobanco.getSaldo()==ValueConstants.VALOR_CERO){
				sqlb.append(", saldo=0");	
			}
			else{
				sqlb.append(", saldo=:saldo");
			}
		}
		sqlb.append(" where idpagobanco=");
		sqlb.append(pagobanco.getIdpagobanco());
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql, parametros);
	}
	
	
	public void agregarClausulasConsulta(PagoBancoParam pagoBancoParam, StringBuffer sqlb){
		   
		   //clausulas 
		   if(pagoBancoParam.getAreanatural().getIdareanatural()!=0 ){
				sqlb.append(" and pb.codigoficha in (select codigoficha from sernanp.fichaturismo where idareanatural=" );
				sqlb.append(pagoBancoParam.getAreanatural().getIdareanatural());
				sqlb.append(")");
			}
		   if(pagoBancoParam.getCodigoficha()!=null ){
				sqlb.append(" and pb.codigoficha='" );
				sqlb.append(pagoBancoParam.getCodigoficha());
				sqlb.append("'");
			}
		  
			
			
	   }
	
	 public int contar(PagoBancoParam pagoBancoParam) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarPagoBanco);
		 agregarClausulasConsulta(pagoBancoParam, sqlb);
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
	
	 
    public List<PagoBanco> listarPaginado(PagoBancoParam pagoBancoParam,int offset,int tamPagina) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.listaPagoBanco);
		 agregarClausulasConsulta(pagoBancoParam, sqlb);
			sqlb.append(" LIMIT ");
			sqlb.append(tamPagina);
			sqlb.append(" OFFSET ");
			sqlb.append(offset);
			 String sql =sqlb.toString();
			//System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PagoBancoMapper() );	 
	 }
	
	
	
}
