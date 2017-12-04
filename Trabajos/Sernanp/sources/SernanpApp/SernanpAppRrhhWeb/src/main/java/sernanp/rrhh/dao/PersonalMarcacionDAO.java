package sernanp.rrhh.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalVO;

public class PersonalMarcacionDAO {
	@SuppressWarnings("unused")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	@SuppressWarnings("unused")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private DataSource dataSource;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.dataSource = dataSource;
	}

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public int insertar_updateasistencias(String fechaFile) {
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertar_updateasistencias);
		sqlb.append("( '" + fechaFile + "' )");
		String sql = sqlb.toString();		

		return this.jdbcTemplate.queryForInt(sql);
	}

	public int actualizar_asistencia_marcacion(String fechaFile) {
		StringBuffer sqlb = new StringBuffer(SqlConstants.actualizar_asistencia_marcacion);
		sqlb.append("( '" + fechaFile + "' )");
		String sql = sqlb.toString();

//		System.out.println("actualizar_asistencia_marcacion - sql : " + sql);

		return this.jdbcTemplate.queryForInt(sql);
	}

	@Transactional
	public void guardarListaMarcacionesData(List<PersonalMarcacionVO> alLista, int int_flag) {
				
		SqlParameterSource[] batch 	= SqlParameterSourceUtils.createBatch( alLista.toArray());
		String sql                 	= null;
		StringBuffer sqlb			= new StringBuffer(SqlConstants.countAsistenciasxfecha);		
		String fechaFile			= null;
		int	resultSP				= 0;
		
		if(alLista.size() > 0 && alLista.get(0).getDte_fec_marc() != null){
		
			sql   = "INSERT INTO sernanp.t_personal_marcacion(srl_id_pers_marc, dte_fec_marc, hor_hor_marc, idpersonal, tsp_fec_crea, " +
					"int_id_usu_crea, tsp_fec_mod, int_id_usu_mod, idtablatipo, int_flag, int_marc_refrigerio) " +
					"SELECT nextval('sernanp.t_personal_marcacion_srl_id_pers_marc_seq'), :dte_fec_marc, :hor_hor_marc, :idpersonal, :tsp_fec_crea, :" +
					"int_id_usu_crea, :tsp_fec_mod, :int_id_usu_mod, :tipomarcacion.idtipo, :int_flag, :int_marc_refrigerio";					
			simpleJdbcTemplate.batchUpdate(sql, batch);

		}
		


		// PARA LEER LOS TXT DE LA SEDE CENTRAL
		
		if (int_flag == 0){ 
			
			//ADD 13-07-2015 D.V.R VALIDA QUE LA LISTA SEA MAYOR QUE 0 Y LA PROPIEDAD FECHA MARCACIÓN DISTINTO A NULL
			if(alLista.size() > 0 && alLista.get(0).getDte_fec_marc() != null){
				fechaFile = alLista.get(0).getDte_fec_marc().toString();
				
			//ADD 13-07-2015 D.V.R OBTIENE LA FECHA DEL ARCHIVO		
			}else if(alLista.size() > 0 && alLista.get(0).getDte_fec_marc1() != null){
				fechaFile				= alLista.get(0).getDte_fec_marc1().toString();
			}
			
			sqlb.append( "WHERE a.dte_fecha = '" +fechaFile + "'" );
			sql	  = sqlb.toString();
				
			int nCount	= simpleJdbcTemplate.queryForInt(sql);
			

				resultSP = insertar_updateasistencias(fechaFile);			
		
			if (nCount > 0 ){
				resultSP = actualizar_asistencia_marcacion(fechaFile);			
			}
			
			// PARA LEER LOS EXCEL DE LAS ANPs
			
		}else if(int_flag == 1){
						
			if(alLista.size() > 0){
				Map<Integer, Date> fechasMarcacion = new HashMap<Integer, Date>();
				int j1 = 0;
				
				for(PersonalMarcacionVO i : alLista){
										
					for(PersonalMarcacionVO j : alLista){
						
						if (j.getDte_fec_marc().equals(i.getDte_fec_marc()) ){							
							
							if(!fechasMarcacion.containsValue(i.getDte_fec_marc())){
								fechasMarcacion.put(j1, i.getDte_fec_marc());									
								j1++;
//							}else{
//								System.out.println("La fecha " + i.getDte_fec_marc() + " ya existe en la nueva Lista");
							}								
							break;
						}
					}					
				}
				
				if(fechasMarcacion.size() > 0){
					System.out.println("fechasMarcacion.size() --> " + fechasMarcacion.size());
					sqlb.append( "WHERE a.dte_fecha = '");
					for(int i= 0; i < fechasMarcacion.size(); i++){
						System.out.println("Actualizando asistencias del personal ANPs --> " + fechasMarcacion.get(i).toString());
						fechaFile = fechasMarcacion.get(i).toString();
						sql		= sqlb.toString() + fechaFile + "'" ;
							
						int nCount	= simpleJdbcTemplate.queryForInt(sql);
						if (nCount > 0 ){
							resultSP = actualizar_asistencia_marcacion(fechaFile);			
						}
	
					}
				}
			}				
				
		}
		


	
	}

	public List<PersonalVO> Idpersonalxnumerodoc(String nrodoc) {

		StringBuffer sqlb = new StringBuffer(SqlConstants.Idpersonalxnumerodoc);
		String sql = sqlb.toString();

		return this.jdbcTemplate.query(sql, new Object[] { nrodoc },new RowMappersConstants.Personal());
	}

	public List<PersonalMarcacionVO> MarcacionxIdpersonalfechamarchoramarc(int idpersonal, String strfechamarc, String strhoramarc) {

		StringBuffer sqlb = new StringBuffer(SqlConstants.MarcacionxIdpersonalfechamarchoramarc);
		sqlb.append("pm.dte_fec_marc = '" + strfechamarc + "' AND ");
		sqlb.append("pm.hor_hor_marc = '" + strhoramarc + "' ");
		sqlb.append("ORDER BY pm.hor_hor_marc ");
		// sqlb.append("GROUP BY pm.idpersonal ");

		String sql = sqlb.toString();
//		System.out.println("MarcacionxIdpersonalfechamarchoramarc - sql :"		+ sql + " / " + idpersonal);

		return this.jdbcTemplate.query(sql, new Object[] { idpersonal }, new RowMappersConstants.PersonalListaMarcacion());
	}

	//4780
	public List<PersonalMarcacionVO> MarcacionxIdpersonalfechamarc(int idpersonal, String strfechamarc) {

		StringBuffer sqlb = new StringBuffer(SqlConstants.MarcacionxIdpersonalfechamarc);

		sqlb.append("pm.dte_fec_marc = '" + strfechamarc + "' ");
		sqlb.append("ORDER BY pm.hor_hor_marc ");

		String sql = sqlb.toString();
//		System.out.println("MarcacionxIdpersonalfechamarc - sql :" + sql + " -- " + idpersonal);

		return this.jdbcTemplate.query(sql, new Object[] { idpersonal },new RowMappersConstants.PersonalMarcacion());

	}

	public List<PersonalMarcacionVO> MarcacionxId(int idMarcacion) {

		StringBuffer sqlb = new StringBuffer(SqlConstants.MarcacionxId);
		String sql = sqlb.toString();

//		System.out.println("MarcacionxId - SQL : " + sql + "/ " + idMarcacion);

		return this.jdbcTemplate.query(sql, new Object[] { idMarcacion }, new RowMappersConstants.PersonalMarcacionxId());
	}

	
	public List<PersonalMarcacionVO> MarcacionxIdPapeleta(int idPapeleta) {

		StringBuffer sqlb = new StringBuffer(SqlConstants.listaidMarcaciones);
		
		String sql = sqlb.toString();

//		System.out.println("Marcacion Ids - SQL : " + sql + "/ " + idPapeleta);

		return this.jdbcTemplate.query(sql, new Object[] { idPapeleta }, new RowMappersConstants.MarcacionesId());
	}

	
	public List<PersonalMarcacionVO> MarcacionxIdpersonalActividadfechamarchoramarc(int idpersonal, int idactividad, String strfechamarc,String strhoramarc) {

		StringBuffer sqlb = new StringBuffer(SqlConstants.MarcacionxIdpersonalActividadfechamarchoramarc);
		sqlb.append("pm.dte_fec_marc = '" + strfechamarc + "' AND ");
		sqlb.append("pm.hor_hor_marc = '" + strhoramarc + "'");
		String sql = sqlb.toString();
//		System.out.println(sql + " " + idpersonal);

		return this.jdbcTemplate.query(sql, new Object[] { idpersonal,	idactividad }, new RowMappersConstants.PersonalMarcacion());
	}

	
	
	//MODIFY 23-07-2014 (D.V.R)
	@Transactional
	public void guardarMarcacionManual(PersonalMarcacionVO vo, int i, PersonalDesplazamientoVO vop) {
		StringBuffer sqlb	= null;
		String sql  		= null;
		
		sqlb		= new StringBuffer(SqlConstants.insertarPapeleta);
		sql			= null;
		
		Map<String, Object> parametrosp = new HashMap<String, Object>();

		parametrosp.put("dte_fec_sal_desp", vop.getDte_fec_sal_desp());
		parametrosp.put("hor_hor_sal_desp", vop.getHor_hor_sal_desp());
		parametrosp.put("dte_fec_ret_desp", vop.getDte_fec_ret_desp());
		parametrosp.put("hor_hor_ret_desp", vop.getHor_hor_ret_desp());
		parametrosp.put("var_lug_desp", vop.getVar_lug_desp().toUpperCase());
		parametrosp.put("tsp_fec_sys_crea", Funciones.fechaHoyTimeStamp());
		parametrosp.put("int_usu_crea", vop.getInt_usu_crea());
		parametrosp.put("idpersonal", vop.getPersonal().getIdpersonal());
		parametrosp.put("srl_id_per_activ", vop.getPersonalActividad().getSrl_id_per_activ());
		
		sql	= sqlb.toString();
				
		int idpapeleta = this.simpleJdbcTemplate.queryForInt(sql, parametrosp);	

		if (vop.getDte_fec_ret_desp() != null ){
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_papeleta("+vop.getPersonal().getIdpersonal()+")");
		}else{
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			if (i > 0){
				sqlb 	= new StringBuffer(SqlConstants.insertarPersonalMarcacion);
				sql 	= sqlb.toString();			

				for (int j = 1; j <= i; j++) {

					if (j == 2) {
						parametros.put("hor_hor_marc", vo.getHor_hor_marc1());
					} else {
						parametros.put("hor_hor_marc", vo.getHor_hor_marc());
					}
					parametros.put("dte_fec_marc", vo.getDte_fec_marc());
					parametros.put("idpersonal", vo.getPersonal().getIdpersonal());
					parametros.put("tsp_fec_crea", Funciones.fechaHoyTimeStamp());
					parametros.put("int_id_usu_crea", vo.getInt_id_usu_crea());
					parametros.put("tsp_fec_mod", null);
					parametros.put("int_id_usu_mod", 0);
					parametros.put("srl_id_per_activ", vo.getPersonalActividad().getSrl_id_per_activ());
					parametros.put("idtablatipo", ValueConstants.TipoMarcacionManual);
					parametros.put("var_descripcion", vo.getVar_descripcion().toUpperCase());
					parametros.put("int_flag",1);
					parametros.put("idpapeleta", idpapeleta);

					this.simpleJdbcTemplate.update(sql, parametros);
//					System.out.println("Fecha Asistencia : " + vo.getDte_fec_marc());
				}
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_marcacion_manual('"+vo.getDte_fec_marc()+"',"+vo.getPersonal().getIdpersonal() +", " + vo.getPersonalActividad().getSrl_id_per_activ() + ")");
					
			}
			
		}		
		
//		}else{
		
		
/*			
		if(his.equalsIgnoreCase("P")){
			
			StringBuffer sqlb2 = new StringBuffer(SqlConstants.insertarPersonalPermiso);
			
			if(vo.getDte_fec_marc1() != null){
				parametros.put("dte_fec_pers_perm_sal", vo.getDte_fec_marc1());	
			}else{
				parametros.put("dte_fec_pers_perm_sal", vo.getDte_fec_marc());
			}
			
			parametros.put("hor_hor_salida", vo.getHor_hor_marc());
			parametros.put("dte_fec_pers_perm_ret",vo.getDte_fec_marc2());
			parametros.put("hor_hor_retorno", vo.getHor_hor_marc1());
			parametros.put("var_desc_pers_perm", vo.getVar_descripcion());			
			parametros.put("idtablatipo", ValueConstants.TipoPermisoSGH);			
			parametros.put("int_estado", 0);
			parametros.put("tsp_fec_sys_crea", Funciones.fechaHoyTimeStamp());
			parametros.put("int_id_usu_crea", vo.getInt_id_usu_crea());
			parametros.put("tsp_fec_sys_anul", null);
			parametros.put("int_id_usu_anul", null);
			parametros.put("idpersonal", vo.getPersonal().getIdpersonal());
			parametros.put("srl_id_per_activ", vo.getPersonalActividad().getSrl_id_per_activ());		
			
			sql	= sqlb2.toString();
			
			this.simpleJdbcTemplate.update(sql, parametros);
			
			if(vo.getDte_fec_marc1() != null)
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_Insert_Permiso(" + vo.getPersonal().getIdpersonal()+ ", '"+vo.getDte_fec_marc1()+"', '"+vo.getDte_fec_marc2()+"'," + vo.getPersonalActividad().getSrl_id_per_activ()+ ")");			
			else{
				this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencias_with_Insert_Permiso(" + vo.getPersonal().getIdpersonal()+ ", '"+vo.getDte_fec_marc()+"', '"+vo.getDte_fec_marc()+"'," + vo.getPersonalActividad().getSrl_id_per_activ()+ ")");
			}
		}else if (his.equalsIgnoreCase("")){
			//LLAMAR A LA FUNCION QUE SE CREO ...23-07-2014 (D.V.R)
			this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_marcacion_manual('"+vo.getDte_fec_marc()+"',"+vo.getPersonal().getIdpersonal() +", " + vo.getPersonalActividad().getSrl_id_per_activ() + ")");
		}
*/
		
//		}

	}

	@Transactional
	public void actualizarMarcacionManual(PersonalDesplazamientoVO vop, List<PersonalMarcacionVO> vo, int estadoAsistencia) {

		StringBuffer sqlb 	= null;
//		sqlb 				= new StringBuffer(SqlConstants.actualizarPersonalMarcacion);
		sqlb 				= new StringBuffer(SqlConstants.actualizarPapeleta);
		
		String sql 			= sqlb.toString();

		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("srl_id_desp", vop.getSrl_id_desp());
		parametros.put("hor_hor_sal_desp", vop.getHor_hor_sal_desp());
		parametros.put("hor_hor_ret_desp", vop.getHor_hor_ret_desp());
		parametros.put("srl_id_per_activ", vop.getPersonalActividad().getSrl_id_per_activ());
		parametros.put("var_lug_desp", vop.getVar_lug_desp().toUpperCase());
		
//		System.out.println("Actualizando Papeleta : " + sql);
		
		this.simpleJdbcTemplate.update(sql, parametros);



		for(int i= 0; i< vo.size(); i++){
			sqlb = new StringBuffer("UPDATE sernanp.t_personal_marcacion SET ");
			if(i == 0){
				sqlb.append("hor_hor_marc = '" + vop.getHor_hor_sal_desp() + "', ");	
			}else{
				sqlb.append("hor_hor_marc = '" + vop.getHor_hor_ret_desp() + "', ");
			}
			
			sqlb.append("var_descripcion = '" + vop.getVar_lug_desp()+ "', ");
			sqlb.append("srl_id_per_activ = " + vop.getPersonalActividad().getSrl_id_per_activ() + " ");
			sqlb.append("WHERE srl_id_pers_marc = " + vo.get(i).getSrl_id_personal_marcacion());			

			sql = sqlb.toString();
			
//			System.out.println("actualizarMarcacionManual  : "+ sql);
			
			this.jdbcTemplate.update(sql);
	
		}
				
				

		//LLAMAR A LA FUNCION  ...23-07-2014 (D.V.R)
		this.jdbcTemplate.queryForInt("SELECT sernanp.fn_update_asistencia_with_marcacion_manual('"+vop.getDte_fec_sal_desp()+"',"+vop.getPersonal().getIdpersonal() +", " + vop.getPersonalActividad().getSrl_id_per_activ() + ")");
		

	}

}
