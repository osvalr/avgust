package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.Querys;
import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.param.BoletajeParam;
import proyecto.vo.Boletaje;

@Repository
public class BoletajeDAO implements Querys {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource){
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Boletaje> listar( int idareanatural ){
		String sql ="select idboletaje,nombreboletaje,valorboletaje,serieboletaje,obsboletaje " +
				"from sernanp.boletaje b " +
				"inner join sernanp.rutaturismo rt on rt.idrutaturismo = b.idrutaturismo " +
				"inner join sernanp.turismo t on t.idturismo = rt.idturismo " +
				"and t.idareanatural = "+ idareanatural;
		
		return simpleJdbcTemplate.query(
				sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Boletaje.class)
			);
	}

	public List<Boletaje> listarxRuta( int idrutaturismo ){

		return simpleJdbcTemplate.query(
				BOLETOS + " AND idrutaturismo = "+ idrutaturismo,
				ParameterizedBeanPropertyRowMapper.newInstance(Boletaje.class)
			);
	}
	
	
	
	public List<BoletajeParam> listarBoletajexFicha(long idficha){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaBoletajexFicha);
		sqlb.append(" and v.flagregistro=1 ");
		if(idficha!=0){
			sqlb.append(" and v.idfichaturismo="+idficha);
		}
		sqlb.append(" group by v.idboletaje ) as bol " +
				" left join sernanp.boletaje b on b.idboletaje=bol.idboletaje   order by valorboletaje ");
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.BoletajeParamMapper());
	}
	
	
	public List<Boletaje> listar(Boletaje boletaje){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaBoletaje);
		if(boletaje.getRutaturismo().getIdrutaturismo()!=0){
			sqlb.append(" and b.idrutaturismo=" );
			sqlb.append(boletaje.getRutaturismo().getIdrutaturismo());
		}
		if(boletaje.getFlagmayoredad()!=0 ){
			if(boletaje.getFlagmayoredad()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and b.flagmayoredad=0" );
			}else{
				sqlb.append(" and b.flagmayoredad=" );
				sqlb.append(boletaje.getFlagmayoredad());
			}
			
		}
		if(boletaje.getTipoboletaje().getIdtipo()!=0 ){
			if(boletaje.getTipoboletaje().getIdtipo()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and b.idtipoboletaje=0" );
			}else{
				sqlb.append(" and b.idtipoboletaje=" );
				sqlb.append(boletaje.getTipoboletaje().getIdtipo());
			}
			
		}
		sqlb.append(" order by b.nombreboletaje, b.obsboletaje ");
		String sql =sqlb.toString();
		//System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.BoletajeMapper());
	}
	
	
	
	
}
