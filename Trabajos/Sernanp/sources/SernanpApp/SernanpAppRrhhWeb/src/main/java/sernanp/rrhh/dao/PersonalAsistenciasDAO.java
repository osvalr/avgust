package sernanp.rrhh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;

public class PersonalAsistenciasDAO {
	@SuppressWarnings("unused")
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;	
    @SuppressWarnings("unused")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	/*
	
	//Creado 18-04-2013
	public void guardarListaData(List<VisitanteVO> alLista){
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( alLista.toArray());
		
		String sql = "INSERT INTO sernanp.t_visitante_museo(srl_id_visitante, var_nombre, var_ape_paterno, var_ape_materno, int_id_tipodocumento, var_num_documento, int_id_genero, " +
				"int_id_areanatural, int_edad, int_id_pais, var_profesion, var_correo, int_id_motivovisita, txt_comentario, txt_recomendacion, dte_fec_ingreso, tsp_fec_system) " +
				"SELECT nextval('sernanp.t_visitante_museo_srl_id_visitante_seq'), :var_nombre, :var_ape_paterno, :var_ape_materno, :tipodocumento.idtipo, :var_num_documento, :genero.idtipo, :areanatural.idareanatural, " +
				":int_edad, :pais.idpais, :var_profesion, :var_correo, :motivovisita.idtipo, :txt_comentario, :txt_recomendacion, :dte_fec_ingreso, :tsp_fec_sistema ";
		
				simpleJdbcTemplate.batchUpdate(sql, batch);
	}*/
	
	
	//Creado 18-04-2013
	
	public void guardarListaData(List<PersonalMarcacionVO> alLista) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( alLista.toArray());
		
		String sql = "INSERT INTO sernanp.personalmarcaciones(idpersonalmarcacion, fechamarcacion, descripcion) " +
				"SELECT nextval('sernanp.personalmarcaciones_idpersonalmarcacion_seq'), :fechamarcacion, :descripcion";		

				simpleJdbcTemplate.batchUpdate(sql, batch);
	}
	

	/*srl_id_pers_marc serial NOT NULL,
	  dte_fec_marc date,
	  hor_hor_marc time without time zone,
	  idpersonal integer,
	  tsp_fec_crea timestamp without time zone,
	  int_id_usu_crea integer,
	  tsp_fec_mod timestamp without time zone,
	  int_id_usu_mod integer NOT NULL,*/
	public void guardarListaMarcacionesData(List<PersonalMarcacionVO> alLista) {
				
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch( alLista.toArray());
//		SqlParameterSource[] batch = null;
		String sql                 = null;
//		if(alLista.size()>0){	
//			for(PersonalMarcacionVO x: alLista){
//				try {

					sql   = "INSERT INTO sernanp.personalmarcaciones(srl_id_pers_marc, dte_fec_marc, hor_hor_marc, idpersonal, tsp_fec_crea, " +
							"int_id_usu_crea, tsp_fec_mod, int_id_usu_mod) " +
							"SELECT nextval('sernanp.t_personal_marcacion_srl_id_pers_marc_seq'), :dte_fec_marc, :hor_hor_marc, :tsp_fec_crea, :" +
							"int_id_usu_crea, :tsp_fec_mod, :int_id_usu_mod";					
					System.out.println("guardarListaMarcacionesData - sql : " + sql);
//					simpleJdbcTemplate.batchUpdate(sql, batch);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
				
	
	}
	
		
	



}
