package proyecto.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.SqlConstants;
import proyecto.vo.Expediente;
import proyecto.vo.ExpedienteSancion;

@Repository
public class MultaDAO {

	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	//insertar multa
	public int insertar(Expediente exp){
		String sql = SqlConstants.insertarMulta;
		
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("montomulta", exp.getMulta().getMontomulta());
		parametros.put("estadomulta", exp.getMulta().getEstadomulta());
						
		return this.simpleJdbcTemplate.queryForInt(sql,parametros);
		
	}
	
	public void eliminar(Expediente exp){
		String sql = SqlConstants.eliminarMulta;
		sql += exp.getMulta().getIdmulta();
		System.out.println(sql);
		this.jdbcTemplate.update(sql);
	}

	/*
	public void actualizar(Expediente exp){
		System.out.println("ingreso a actualizar multa");
		String sql="update sernanp.multa set montomulta="+exp.getMulta().getMontomulta()+", estadomulta="+exp.getMulta().getEstadomulta() +
		" where idmulta="+exp.getMulta().getIdmulta();
		System.out.println("Esta es la sentencia para el update :"+sql);
		int x = this.jdbcTemplate.update(sql);
	}*/
	
	public void actualizar(ExpedienteSancion exp){
		//System.out.println("ingreso a actualizar multa");
		String sql="update sernanp.multa set montomulta="+exp.getExpediente().getMulta().getMontomulta()+", estadomulta="+exp.getExpediente().getMulta().getEstadomulta() +
		" where idmulta="+exp.getExpediente().getMulta().getIdmulta();
		
		this.jdbcTemplate.update(sql);
	}
	
	public void insertreplace(ExpedienteSancion exp){
		//System.out.println("ingreso a actualizar multa");
		String sql="replace into sernanp.multa(idmulat, montomulta , estadomulta) " +
				"values("+exp.getExpediente().getMulta().getIdmulta()+","+exp.getExpediente().getMulta().getMontomulta()+", "+exp.getExpediente().getMulta().getEstadomulta()+")";
				//" where idmulta="+exp.getExpediente().getMulta().getIdmulta();
		//System.out.println("Esta es la sentencia para el update :"+sql);
		this.jdbcTemplate.update(sql);
	}
	
	
	
}
