package proyecto.dao.procedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import proyecto.vo.PagoBanco;


public class PagoBancoProcedure extends StoredProcedure{
	
	private static String insertaNoDuplicadoPagoBanco="sernanp.insertar_pagobanco";
	public PagoBancoProcedure(DataSource dataSource){
		setDataSource(dataSource);
		setSql(insertaNoDuplicadoPagoBanco);

		declareParameter(new SqlParameter("codigopagobanco",Types.VARCHAR));
		declareParameter(new SqlParameter("codigotributo",Types.VARCHAR));
		declareParameter(new SqlParameter("tipodocumento",Types.VARCHAR));
		declareParameter(new SqlParameter("numerodocumento",Types.VARCHAR));
		declareParameter(new SqlParameter("codigoficha",Types.VARCHAR));			
		declareParameter(new SqlParameter("registro",Types.VARCHAR));
		declareParameter(new SqlParameter("cadimporte",Types.VARCHAR));
		declareParameter(new SqlParameter("cadfechamovimiento",Types.VARCHAR));
		declareParameter(new SqlParameter("hora",Types.VARCHAR));
		declareParameter(new SqlParameter("numerovoucher",Types.VARCHAR));
		declareParameter(new SqlParameter("chequeo",Types.VARCHAR));
		declareParameter(new SqlParameter("agencia",Types.VARCHAR));
		declareParameter(new SqlParameter("cajero",Types.VARCHAR));
		declareParameter(new SqlParameter("filler",Types.VARCHAR));
		declareParameter(new SqlParameter("importe",Types.NUMERIC));
		declareParameter(new SqlParameter("fechamovimiento",Types.TIMESTAMP));
		declareParameter(new SqlParameter("idtabla",Types.INTEGER));
		declareParameter(new SqlParameter("codigointtipo",Types.INTEGER));
		
		
		
	}

	
	public int insertarNoDuplicado(PagoBanco pagoBanco){
		try{
			Map<String,Object> datosEntrada= new HashMap<String,Object>();
			datosEntrada.put("codigopagobanco", pagoBanco.getCodigopagobanco());
			datosEntrada.put("codigotributo", pagoBanco.getCadcodigotributo());
			datosEntrada.put("tipodocumento", pagoBanco.getCadtipodocumento());
			datosEntrada.put("numerodocumento", pagoBanco.getCadnumerodocumento());
			datosEntrada.put("codigoficha", pagoBanco.getCadcodigoficha().trim());
			datosEntrada.put("registro",pagoBanco.getCadnumeroregistro());
			datosEntrada.put("cadimporte", pagoBanco.getCadimporte());
			datosEntrada.put("cadfechamovimiento",pagoBanco.getCadfechamovimiento());
			datosEntrada.put("hora",pagoBanco.getCadhora());
			datosEntrada.put("numerovoucher",pagoBanco.getCadnumerovoucher());
			datosEntrada.put("chequeo",pagoBanco.getCaddigitochequeo());
			datosEntrada.put("agencia",pagoBanco.getCadcodigoagencia());
			datosEntrada.put("cajero",pagoBanco.getCadcodigocajero());
			datosEntrada.put("filler",pagoBanco.getCadfiller());
			datosEntrada.put("importe",pagoBanco.getImporte());
			//datosEntrada.put("fechamovimiento",new java.sql.Date(pagoBanco.getFechamovimiento().getTime()));
			datosEntrada.put("fechamovimiento",pagoBanco.getFechamovimiento());
			datosEntrada.put("idtabla",pagoBanco.getIdtabla());
			datosEntrada.put("codigointtipo",pagoBanco.getCodigointtipo());
			super.execute(datosEntrada);
		} catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		return 0;
	}
}
