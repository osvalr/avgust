package proyecto.dao;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.Querys;
import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.param.TurismoParam;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Fichaturismo;
import proyecto.vo.Visitante;

@Repository
public class VisitanteDAO implements Querys {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private Fichaturismo ficha;
	
	@Autowired
	FichaturismoDAO fichaturismoDAO;
	GuiaFichaturismoDAO guiaFichaturismoDAO;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
  
	
	
//	public long save(List<Visitante> listaVisitante) {
//		ficha = listaVisitante.get(0).getFichaturismo();
//		long idfichat= fichaturismoDAO.save(ficha);
//		//guardar guias
//		List<GuiaFichaTurismo> listaguiaficha=ficha.getListaGuiaFichaturismo();
//		for(GuiaFichaTurismo guiaficha: listaguiaficha){
//			//System.out.println("idguia"+guiaficha.getGuia().getIdguia());
//			guiaficha.getFichaturismo().setIdfichaturismo(idfichat);
//			guiaFichaturismoDAO.insertar(guiaficha);
//		}
//		for (Visitante v : listaVisitante) {
//			if (v != null) {     
//				v.getFichaturismo().setIdfichaturismo(idfichat);
//				insertarVisitante(v);
//			}   
//		}
//		
//		return idfichat;
//	} 
	
	
	
	public int[] consolidarVisitantes(List<Visitante> visitantes){
		
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(visitantes.toArray());
        int[] updateCounts = simpleJdbcTemplate.batchUpdate(
        		VISITANTEOK,
                batch);
        return updateCounts;
        
	}
	
//	public int saveVisitante(Visitante v) {
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("numerodoc",v.getNumerodocumento() );
//		parametros.put("idpais",v.getPais().getIdpais());
//		parametros.put("obsvisitante",v.getObsvisitante());
//		if(v.getFechanacimiento()!=null){
//			parametros.put("fechanacimiento", new java.sql.Date(v.getFechanacimiento().getTime()));
//		}
//		else{
//			parametros.put("fechanacimiento", null);
//		}
//		if(v.getEstadocivil().getIdtipo()!=0){
//			parametros.put("idestadocivil", v.getEstadocivil().getIdtipo());
//		}
//		else{
//			parametros.put("idestadocivil", 5);
//		}
//		if(v.getTipodocumento().getIdtipo()!=0){
//			parametros.put("idtipodocumento", v.getTipodocumento().getIdtipo());
//		}
//		else{
//			parametros.put("idtipodocumento", null);
//		}
//		if(v.getUbigeo().getIdubigeo()!=0){
//			parametros.put("idubigeo", v.getUbigeo().getIdubigeo());
//		}
//		else{
//			parametros.put("idubigeo", 1);
//		}
//		parametros.put("idfichaturismo",(int)v.getFichaturismo().getIdfichaturismo() );
//		parametros.put("nombre",v.getNombre() );
//		parametros.put("apepat",v.getApepat());
//		parametros.put("apemat",v.getApemat() );
//		parametros.put("idsexo",v.getSexo().getIdtipo() );
//		if(v.getBoletaje().getIdboletaje()!=0){
//			parametros.put("idboletaje",v.getBoletaje().getIdboletaje());
//		}
//		else{
//			parametros.put("idboletaje",null);
//		}
//		return  simpleJdbcTemplate.queryForInt(VISITANTESAVE, parametros);
//	}

	
	
	
	public int insertar(Visitante v) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numerodoc",v.getNumerodocumento() );
		parametros.put("idpais",v.getPais().getIdpais());
		parametros.put("obsvisitante",v.getObsvisitante());
		if(v.getFechanacimiento()!=null){
			parametros.put("fechanacimiento", new java.sql.Date(v.getFechanacimiento().getTime()));
		}
		else{
			parametros.put("fechanacimiento", null);
		}
		if(v.getEstadocivil().getIdtipo()!=0){
			parametros.put("idestadocivil", v.getEstadocivil().getIdtipo());
		}
		else{
			parametros.put("idestadocivil", null);
		}
		if(v.getTipodocumento().getIdtipo()!=0){
			parametros.put("idtipodocumento", v.getTipodocumento().getIdtipo());
		}
		else{
			parametros.put("idtipodocumento", null);
		}
		if(v.getTipoocupacion().getIdtipo()!=0){
			parametros.put("idtipoocupacion", v.getTipoocupacion().getIdtipo());
		}
		else{
			parametros.put("idtipoocupacion", null);
		}
		if(v.getMotivovisita().getIdtipo()!=0){
			parametros.put("idmotivovisita", v.getMotivovisita().getIdtipo());
		}
		else{
			parametros.put("idmotivovisita", null);
		}
		if(v.getUbigeo().getIdubigeo()!=0){
			parametros.put("idubigeo", v.getUbigeo().getIdubigeo());
		}
		else{
			parametros.put("idubigeo", null);
		}
		parametros.put("idfichaturismo",(int)v.getFichaturismo().getIdfichaturismo() );
		parametros.put("nombre",v.getNombre() );
		parametros.put("apepat",v.getApepat());
		parametros.put("apemat",v.getApemat() );
		parametros.put("idsexo",v.getSexo().getIdtipo() );
		parametros.put("flagcompleto",v.getFlagcompleto() );
		parametros.put("flagregistro",v.getFlagregistro() );
		if(v.getBoletaje().getIdboletaje()!=0){
			parametros.put("idboletaje",v.getBoletaje().getIdboletaje());
		}
		else{
			parametros.put("idboletaje",null);
		}
		return  simpleJdbcTemplate.queryForInt(VISITANTESAVE, parametros);
	}
	
	
	
	
	
	public List<Map<String, Object>> reporte(String codareanatural) {   
		List< Map<String, Object> > list = this.simpleJdbcTemplate        
			.queryForList( 
					VISITANTEREPORTE + 
					" AND a.codareanatural=?" +
					VISITANTEGROUP,new Object[]{ codareanatural }); 
		return addPercent(list);
	} 


	public List<Map<String, Object>> reporteVisitantexRutaAnual(TurismoParam turismoparam) {   
		StringBuffer sqlb = new StringBuffer("select * from " +
				" (select r.idrutaturismo,date_part('year',f.fecharegistro), count(v.idvisitante) total,  " +
				"  sum (case when v.idpais=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 1 " +
				"when v.idpais!=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 0 end ) nacional, " +
				"sum(case when v.idpais!=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 1 " +
				"when v.idpais=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 0 end ) extranjero " +
				" from sernanp.visitante v " +
				" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
				" left join sernanp.rutaturismo r on r.idrutaturismo=f.idrutaturismo " +
				//" left join sernanp.personanatural pn on pn.idpersonanatural = v.idpersonanatural " +
				//" left join sernanp.persona p on p.idpersona = pn.idpersona " +
				" where 1=1 and v.flagvisitante=1 " );
		   if(turismoparam.getAreanatural().getIdareanatural()!=0){
			   sqlb.append(" and f.idareanatural=");
			   sqlb.append(turismoparam.getAreanatural().getIdareanatural());  
		   }
		   
		   if(turismoparam.getPeriodo()!=0){
			   sqlb.append(" and date_part('year',f.fecharegistro)=");
				sqlb.append(turismoparam.getPeriodo()); 
		   }
		   
		
		sqlb.append(" group by r.idrutaturismo, date_part('year', f.fecharegistro) ) as visitantexruta " +
				" left join  sernanp.rutaturismo r on r.idrutaturismo=visitantexruta.idrutaturismo");
		String sql =sqlb.toString();
		//System.out.println(sql);
		List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
		return addPercent(list);
	}
	
	
	
	
	public List<Map<String, Object>> reporteVisitantexRutaMensual(TurismoParam turismoparam) {   
		StringBuffer sqlb = new StringBuffer("select * from " +
				" (select r.idrutaturismo,date_part('year',f.fecharegistro) as anio, count(v.idvisitante) total,  " +
				" date_part('month', f.fecharegistro) as mes, " +
				//"to_char((f.fecharegistro), 'TMmonth' ) as mesingreso, " +
				"  sum(b.valorboletaje) as boleto, " +
				"  sum (case when v.idpais=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 1 " +
				"when v.idpais!=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 0 end ) nacional, " +
				"sum(case when v.idpais!=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 1 " +
				"when v.idpais=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 0 end ) extranjero " +
				" from sernanp.visitante v " +
				" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
				" left join sernanp.rutaturismo r on r.idrutaturismo=f.idrutaturismo " +
				" left join sernanp.boletaje b on b.idboletaje=v.idboletaje " +
				//" left join sernanp.personanatural pn on pn.idpersonanatural = v.idpersonanatural " +
				//" left join sernanp.persona p on p.idpersona = pn.idpersona " +
				" where 1=1 and v.flagvisitante=1 " +
				"and f.idareanatural=");
		sqlb.append(turismoparam.getAreanatural().getIdareanatural());
		sqlb.append(" and date_part('year',f.fecharegistro)=");
		sqlb.append(turismoparam.getPeriodo());
		sqlb.append(" group by date_part('month', f.fecharegistro), " +
				"r.idrutaturismo, date_part('year', f.fecharegistro)   " +
				" order by  date_part('month', f.fecharegistro), r.idrutaturismo   ) as visitantexruta " +
				" left join  sernanp.rutaturismo r on r.idrutaturismo=visitantexruta.idrutaturismo ");
		String sql =sqlb.toString();
		//System.out.println(sql);
		List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
		return addPercent(list);
	}
	
	
	
	
	public List<Map<String, Object>> reporteCruzadoVisitantexRutaMensual(TurismoParam turismoparam) {   
		StringBuffer sqlb = new StringBuffer("select * from "+
   "(select  idrutaturismo,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=1  THEN 1 ELSE 0 END) As enero,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=2  THEN 1 ELSE 0 END) As febrero,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=3  THEN 1 ELSE 0 END) As marzo,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=4  THEN 1 ELSE 0 END) As abril,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=5  THEN 1 ELSE 0 END) As mayo,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=6  THEN 1 ELSE 0 END) As junio,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=7  THEN 1 ELSE 0 END) As julio,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=8  THEN 1 ELSE 0 END) As agosto,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=9  THEN 1 ELSE 0 END) As setiembre,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=10  THEN 1 ELSE 0 END) As octubre,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=11  THEN 1 ELSE 0 END) As noviembre,"+
  "SUM(CASE WHEN date_part('month', f.fecharegistro)=12  THEN 1 ELSE 0 END) As diciembre"+
  " from sernanp.visitante v "+
  " left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo "+
				" where 1=1 and v.flagvisitante=1 " +
				"and f.idareanatural=");
		sqlb.append(turismoparam.getAreanatural().getIdareanatural());
		sqlb.append(" and date_part('year',f.fecharegistro)=");
		sqlb.append(turismoparam.getPeriodo());
		sqlb.append(" group by f.idrutaturismo, " +
				" date_part('year', f.fecharegistro) ) as tab  " +
				" left join  sernanp.rutaturismo r on r.idrutaturismo=tab.idrutaturismo " +
				" order by r.nombrerutaturismo ");
		String sql =sqlb.toString();
		//System.out.println(sql);
		List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
		return list;
	}
	
	
	
	public List<Map<String, Object>> reporteCruzadoVisitantexNacionalidad(TurismoParam turismoparam) {   
		
		StringBuffer sqlb = new StringBuffer("select date_part('year',f.fechaingreso), "+
      " date_part('month', f.fechaingreso) as mes," +
      "  (CASE WHEN date_part('month', f.fechaingreso)=1  THEN 'ENERO'  "+
      " WHEN date_part('month', f.fechaingreso)=2  THEN 'FEBRERO' "+
      " WHEN date_part('month', f.fechaingreso)=3  THEN 'MARZO' "+
      " WHEN date_part('month', f.fechaingreso)=4  THEN 'ABRIL' "+
      " WHEN date_part('month', f.fechaingreso)=5  THEN 'MAYO' "+
      " WHEN date_part('month', f.fechaingreso)=6  THEN 'JUNIO' "+
      " WHEN date_part('month', f.fechaingreso)=7  THEN 'JULIO' "+
      " WHEN date_part('month', f.fechaingreso)=8  THEN 'AGOSTO' "+
      " WHEN date_part('month', f.fechaingreso)=9  THEN 'SETIEMBRE' "+
      " WHEN date_part('month', f.fechaingreso)=10  THEN 'OCTUBRE' "+
      " WHEN date_part('month', f.fechaingreso)=11  THEN 'NOVIEMBRE' "+
      " WHEN date_part('month', f.fechaingreso)=12  THEN 'DICIEMBRE' "+
      " ELSE '' END) as nommes, "+
      " count(v.idvisitante) total,"+
      "  sum (case when v.idpais=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 1 " +
				"when v.idpais!=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 0 end ) nacional, " +
				"sum(case when v.idpais!=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 1 " +
				"when v.idpais=");
		sqlb.append(ValueConstants.ID_PAIS_PERU);
		sqlb.append(" then 0 end ) extranjero ,sum(b.valorboletaje) as boleto " +
				" from sernanp.visitante v " +
				" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
				" left join sernanp.boletaje b on b.idboletaje=v.idboletaje " +
				//" left join sernanp.personanatural pn on pn.idpersonanatural = v.idpersonanatural " +
				//" left join sernanp.persona p on p.idpersona = pn.idpersona " +
				" where 1=1 and v.flagvisitante=1 " +
				"and f.idareanatural=");
		sqlb.append(turismoparam.getAreanatural().getIdareanatural());
		sqlb.append(" and date_part('year',f.fechaingreso)=");
		sqlb.append(turismoparam.getPeriodo());
		sqlb.append(" group by date_part('month', f.fechaingreso), " +
				" date_part('year', f.fechaingreso)   " +
				" order by  date_part('month', f.fechaingreso) ");
				
		String sql =sqlb.toString();
		//System.out.println(sql);
		List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
		return list;
	}
	
	
public List<Map<String, Object>> reporteCruzadoVisitantexGenero(TurismoParam turismoparam,Map<Integer, Integer> mapCodigoIdtipo) {   
		
		StringBuffer sqlb = new StringBuffer("select date_part('year',f.fechaingreso), "+
      " date_part('month', f.fechaingreso) as mes," +
      "  (CASE WHEN date_part('month', f.fechaingreso)=1  THEN 'ENERO'  "+
      " WHEN date_part('month', f.fechaingreso)=2  THEN 'FEBRERO' "+
      " WHEN date_part('month', f.fechaingreso)=3  THEN 'MARZO' "+
      " WHEN date_part('month', f.fechaingreso)=4  THEN 'ABRIL' "+
      " WHEN date_part('month', f.fechaingreso)=5  THEN 'MAYO' "+
      " WHEN date_part('month', f.fechaingreso)=6  THEN 'JUNIO' "+
      " WHEN date_part('month', f.fechaingreso)=7  THEN 'JULIO' "+
      " WHEN date_part('month', f.fechaingreso)=8  THEN 'AGOSTO' "+
      " WHEN date_part('month', f.fechaingreso)=9  THEN 'SETIEMBRE' "+
      " WHEN date_part('month', f.fechaingreso)=10  THEN 'OCTUBRE' "+
      " WHEN date_part('month', f.fechaingreso)=11  THEN 'NOVIEMBRE' "+
      " WHEN date_part('month', f.fechaingreso)=12  THEN 'DICIEMBRE' "+
      " ELSE '' END) as nommes, "+
      " count(v.idvisitante) total,"+
      "  sum (case when v.idsexo=");
		sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_GENERO_MASCULINO));
		sqlb.append(" then 1 " +
				"when v.idsexo!=");
		sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_GENERO_MASCULINO));
		sqlb.append(" then 0 end ) masculino, " +
				"sum(case when v.idsexo=");
		sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_GENERO_FEMENINO));
		sqlb.append(" then 1 " +
				"when v.idsexo!=");
		sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_GENERO_FEMENINO));
		sqlb.append(" then 0 end ) femenino ,sum(b.valorboletaje) as boleto " +
				" from sernanp.visitante v " +
				" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
				" left join sernanp.boletaje b on b.idboletaje=v.idboletaje " +
				" where 1=1 and v.flagvisitante=1 " +
				"and f.idareanatural=");
		sqlb.append(turismoparam.getAreanatural().getIdareanatural());
		sqlb.append(" and date_part('year',f.fechaingreso)=");
		sqlb.append(turismoparam.getPeriodo());
		sqlb.append(" group by date_part('month', f.fechaingreso), " +
				" date_part('year', f.fechaingreso)   " +
				" order by  date_part('month', f.fechaingreso) ");
				
		String sql =sqlb.toString();
		//System.out.println(sql);
		List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
		return list;
	}
	
	
	

public List<Map<String, Object>> reporteCruzadoVisitantexOcupacion(TurismoParam turismoparam,Map<Integer, Integer> mapCodigoIdtipo) {   
	
	StringBuffer sqlb = new StringBuffer("select date_part('year',f.fechaingreso), "+
  " date_part('month', f.fechaingreso) as mes," +
  "  (CASE WHEN date_part('month', f.fechaingreso)=1  THEN 'ENERO'  "+
  " WHEN date_part('month', f.fechaingreso)=2  THEN 'FEBRERO' "+
  " WHEN date_part('month', f.fechaingreso)=3  THEN 'MARZO' "+
  " WHEN date_part('month', f.fechaingreso)=4  THEN 'ABRIL' "+
  " WHEN date_part('month', f.fechaingreso)=5  THEN 'MAYO' "+
  " WHEN date_part('month', f.fechaingreso)=6  THEN 'JUNIO' "+
  " WHEN date_part('month', f.fechaingreso)=7  THEN 'JULIO' "+
  " WHEN date_part('month', f.fechaingreso)=8  THEN 'AGOSTO' "+
  " WHEN date_part('month', f.fechaingreso)=9  THEN 'SETIEMBRE' "+
  " WHEN date_part('month', f.fechaingreso)=10  THEN 'OCTUBRE' "+
  " WHEN date_part('month', f.fechaingreso)=11  THEN 'NOVIEMBRE' "+
  " WHEN date_part('month', f.fechaingreso)=12  THEN 'DICIEMBRE' "+
  " ELSE '' END) as nommes, "+
  " count(v.idvisitante) total,"+
  "  sum (case when v.idtipoocupacion=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_OCUPACION_ESTUDIANTE));
	sqlb.append(" then 1 " +
			"when v.idtipoocupacion!=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_OCUPACION_ESTUDIANTE));
	sqlb.append(" then 0 end ) estudiante, " +
			"sum(case when v.idtipoocupacion=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_OCUPACION_PROFESIONAL));
	sqlb.append(" then 1 " +
			"when v.idtipoocupacion!=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_OCUPACION_PROFESIONAL));
	sqlb.append(" then 0 end ) profesional, " +
	"sum(case when v.idtipoocupacion=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_OCUPACION_OTROS));
	sqlb.append(" then 1 " +
			"when v.idtipoocupacion!=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_OCUPACION_OTROS));
	sqlb.append(" then 0 end ) otros ,sum(b.valorboletaje) as boleto " +
			" from sernanp.visitante v " +
			" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
			" left join sernanp.boletaje b on b.idboletaje=v.idboletaje " +
			" where 1=1 and v.flagvisitante=1 " +
			"and f.idareanatural=");
	sqlb.append(turismoparam.getAreanatural().getIdareanatural());
	sqlb.append(" and date_part('year',f.fechaingreso)=");
	sqlb.append(turismoparam.getPeriodo());
	sqlb.append(" group by date_part('month', f.fechaingreso), " +
			" date_part('year', f.fechaingreso)   " +
			" order by  date_part('month', f.fechaingreso) ");
			
	String sql =sqlb.toString();
	//System.out.println(sql);
	List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
	return list;
}




public List<Map<String, Object>> reporteCruzadoVisitantexMotivoVisita(TurismoParam turismoparam,Map<Integer, Integer> mapCodigoIdtipo) {   
	
	StringBuffer sqlb = new StringBuffer("select date_part('year',f.fechaingreso), "+
  " date_part('month', f.fechaingreso) as mes," +
  "  (CASE WHEN date_part('month', f.fechaingreso)=1  THEN 'ENERO'  "+
  " WHEN date_part('month', f.fechaingreso)=2  THEN 'FEBRERO' "+
  " WHEN date_part('month', f.fechaingreso)=3  THEN 'MARZO' "+
  " WHEN date_part('month', f.fechaingreso)=4  THEN 'ABRIL' "+
  " WHEN date_part('month', f.fechaingreso)=5  THEN 'MAYO' "+
  " WHEN date_part('month', f.fechaingreso)=6  THEN 'JUNIO' "+
  " WHEN date_part('month', f.fechaingreso)=7  THEN 'JULIO' "+
  " WHEN date_part('month', f.fechaingreso)=8  THEN 'AGOSTO' "+
  " WHEN date_part('month', f.fechaingreso)=9  THEN 'SETIEMBRE' "+
  " WHEN date_part('month', f.fechaingreso)=10  THEN 'OCTUBRE' "+
  " WHEN date_part('month', f.fechaingreso)=11  THEN 'NOVIEMBRE' "+
  " WHEN date_part('month', f.fechaingreso)=12  THEN 'DICIEMBRE' "+
  " ELSE '' END) as nommes, "+
  " count(v.idvisitante) total,"+
  "  sum (case when v.idmotivovisita=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_MOTIVOVISITA_TURISMO));
	sqlb.append(" then 1 " +
			"when v.idmotivovisita!=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_MOTIVOVISITA_TURISMO));
	sqlb.append(" then 0 end ) turismo, " +
			"sum(case when v.idmotivovisita=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_MOTIVOVISITA_ESTUDIO));
	sqlb.append(" then 1 " +
			"when v.idmotivovisita!=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_MOTIVOVISITA_ESTUDIO));
	sqlb.append(" then 0 end ) estudio, " +
	"sum(case when v.idmotivovisita=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_MOTIVOVISITA_OTROS));
	sqlb.append(" then 1 " +
			"when v.idmotivovisita!=");
	sqlb.append(mapCodigoIdtipo.get(ValueConstants.CODIGO_MOTIVOVISITA_OTROS));
	sqlb.append(" then 0 end ) otros ,sum(b.valorboletaje) as boleto " +
			" from sernanp.visitante v " +
			" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
			" left join sernanp.boletaje b on b.idboletaje=v.idboletaje " +
			" where 1=1 and v.flagvisitante=1 " +
			"and f.idareanatural=");
	sqlb.append(turismoparam.getAreanatural().getIdareanatural());
	sqlb.append(" and date_part('year',f.fechaingreso)=");
	sqlb.append(turismoparam.getPeriodo());
	sqlb.append(" group by date_part('month', f.fechaingreso), " +
			" date_part('year', f.fechaingreso)   " +
			" order by  date_part('month', f.fechaingreso) ");
			
	String sql =sqlb.toString();
	//System.out.println(sql);
	List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
	return list;
}







public List<Map<String, Object>> reporteCruzadoVisitantexCaracteristicas(TurismoParam turismoparam,Map<String, Map<Integer, Integer>> mapCodigoIdtipo) {   
	
	StringBuffer sqlb = new StringBuffer("select date_part('year',f.fechaingreso), "+
  " date_part('month', f.fechaingreso) as mes," +
  "  (CASE WHEN date_part('month', f.fechaingreso)=1  THEN 'ENERO'  "+
  " WHEN date_part('month', f.fechaingreso)=2  THEN 'FEBRERO' "+
  " WHEN date_part('month', f.fechaingreso)=3  THEN 'MARZO' "+
  " WHEN date_part('month', f.fechaingreso)=4  THEN 'ABRIL' "+
  " WHEN date_part('month', f.fechaingreso)=5  THEN 'MAYO' "+
  " WHEN date_part('month', f.fechaingreso)=6  THEN 'JUNIO' "+
  " WHEN date_part('month', f.fechaingreso)=7  THEN 'JULIO' "+
  " WHEN date_part('month', f.fechaingreso)=8  THEN 'AGOSTO' "+
  " WHEN date_part('month', f.fechaingreso)=9  THEN 'SETIEMBRE' "+
  " WHEN date_part('month', f.fechaingreso)=10  THEN 'OCTUBRE' "+
  " WHEN date_part('month', f.fechaingreso)=11  THEN 'NOVIEMBRE' "+
  " WHEN date_part('month', f.fechaingreso)=12  THEN 'DICIEMBRE' "+
  " ELSE '' END) as nommes, "+
  " count(v.idvisitante) total,"+
	 "  sum (case when v.idpais=");
	sqlb.append(ValueConstants.ID_PAIS_PERU);
	sqlb.append(" then 1 " +
			"when v.idpais!=");
	sqlb.append(ValueConstants.ID_PAIS_PERU);
	sqlb.append(" then 0 end ) nacional, " +
			"sum(case when v.idpais!=");
	sqlb.append(ValueConstants.ID_PAIS_PERU);
	sqlb.append(" then 1 " +
			"when v.idpais=");
	sqlb.append(ValueConstants.ID_PAIS_PERU);
	sqlb.append(" then 0 end ) extranjero,"+
	 "  sum (case when v.idsexo=");
	sqlb.append( mapCodigoIdtipo.get("genero").get(ValueConstants.CODIGO_GENERO_MASCULINO));
	sqlb.append(" then 1 " +
			"when v.idsexo!=");
	sqlb.append(mapCodigoIdtipo.get("genero").get(ValueConstants.CODIGO_GENERO_MASCULINO));
	sqlb.append(" then 0 end ) masculino, " +
			"sum(case when v.idsexo=");
	sqlb.append(mapCodigoIdtipo.get("genero").get(ValueConstants.CODIGO_GENERO_FEMENINO));
	sqlb.append(" then 1 " +
			"when v.idsexo!=");
	sqlb.append(mapCodigoIdtipo.get("genero").get(ValueConstants.CODIGO_GENERO_FEMENINO));
	sqlb.append(" then 0 end ) femenino ,"+		
	"  sum (case when v.idtipoocupacion=");
	sqlb.append(mapCodigoIdtipo.get("ocupacion").get(ValueConstants.CODIGO_OCUPACION_ESTUDIANTE));
	sqlb.append(" then 1 " +
			"when v.idtipoocupacion!=");
	sqlb.append(mapCodigoIdtipo.get("ocupacion").get(ValueConstants.CODIGO_OCUPACION_ESTUDIANTE));
	sqlb.append(" then 0 end ) estudiante, " +
			"sum(case when v.idtipoocupacion=");
	sqlb.append(mapCodigoIdtipo.get("ocupacion").get(ValueConstants.CODIGO_OCUPACION_PROFESIONAL));
	sqlb.append(" then 1 " +
			"when v.idtipoocupacion!=");
	sqlb.append(mapCodigoIdtipo.get("ocupacion").get(ValueConstants.CODIGO_OCUPACION_PROFESIONAL));
	sqlb.append(" then 0 end ) profesional, " +
	"sum(case when v.idtipoocupacion=");
	sqlb.append(mapCodigoIdtipo.get("ocupacion").get(ValueConstants.CODIGO_OCUPACION_OTROS));
	sqlb.append(" then 1 " +
			"when v.idtipoocupacion!=");
	sqlb.append(mapCodigoIdtipo.get("ocupacion").get(ValueConstants.CODIGO_OCUPACION_OTROS));
	sqlb.append(" then 0 end ) otrosocupacion ,"+		
   "  sum (case when v.idmotivovisita=");
	sqlb.append(mapCodigoIdtipo.get("motivovisita").get(ValueConstants.CODIGO_MOTIVOVISITA_TURISMO));
	sqlb.append(" then 1 " +
			"when v.idmotivovisita!=");
	sqlb.append(mapCodigoIdtipo.get("motivovisita").get(ValueConstants.CODIGO_MOTIVOVISITA_TURISMO));
	sqlb.append(" then 0 end ) turismo, " +
			"sum(case when v.idmotivovisita=");
	sqlb.append(mapCodigoIdtipo.get("motivovisita").get(ValueConstants.CODIGO_MOTIVOVISITA_ESTUDIO));
	sqlb.append(" then 1 " +
			"when v.idmotivovisita!=");
	sqlb.append(mapCodigoIdtipo.get("motivovisita").get(ValueConstants.CODIGO_MOTIVOVISITA_ESTUDIO));
	sqlb.append(" then 0 end ) estudio, " +
	"sum(case when v.idmotivovisita=");
	sqlb.append(mapCodigoIdtipo.get("motivovisita").get(ValueConstants.CODIGO_MOTIVOVISITA_OTROS));
	sqlb.append(" then 1 " +
			"when v.idmotivovisita!=");
	sqlb.append(mapCodigoIdtipo.get("motivovisita").get(ValueConstants.CODIGO_MOTIVOVISITA_OTROS));
	sqlb.append(" then 0 end ) otrosmotivovisita ,sum(b.valorboletaje) as boleto " +
			" from sernanp.visitante v " +
			" left join sernanp.fichaturismo f on f.idfichaturismo=v.idfichaturismo " +
			" left join sernanp.boletaje b on b.idboletaje=v.idboletaje " +
			" where 1=1 and v.flagvisitante=1 " +
			"and f.idareanatural=");
	sqlb.append(turismoparam.getAreanatural().getIdareanatural());
	sqlb.append(" and date_part('year',f.fechaingreso)=");
	sqlb.append(turismoparam.getPeriodo());
	sqlb.append(" group by date_part('month', f.fechaingreso), " +
			" date_part('year', f.fechaingreso)   " +
			" order by  date_part('month', f.fechaingreso) ");
			
	String sql =sqlb.toString();
	//System.out.println(sql);
	List< Map<String, Object> > list = this.jdbcTemplate.queryForList(sql);
	return list;
}



	public List<Visitante> listar(Visitante visitante,int ordenconsulta){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaVisitante);
		if(visitante.getIdvisitante()!=0 ){
			sqlb.append(" and v.idvisitante=" );
			sqlb.append(visitante.getIdvisitante());
		}
		if(visitante.getBoletaje().getIdboletaje()!=0 ){
			sqlb.append(" and v.idboletaje=" );
			sqlb.append(visitante.getBoletaje().getIdboletaje());
		}
		if(visitante.getFichaturismo().getIdfichaturismo()!=0 ){
			if(visitante.getFichaturismo().getIdfichaturismo()==ValueConstants.VALOR_CERO){
				sqlb.append(" and v.idfichaturismo=0" );
			}
			  else{
				 sqlb.append(" and v.idfichaturismo=" );
				sqlb.append(visitante.getFichaturismo().getIdfichaturismo());
			      }
			
		}
		if(visitante.getFlagregistro()!=0 ){
			if(visitante.getFlagregistro()==ValueConstants.VALOR_CERO){
				sqlb.append(" and (v.flagregistro=0 or v.flagregistro is null) ");
			}
			  else{
				sqlb.append(" and v.flagregistro=" );
				sqlb.append(visitante.getFlagregistro());
			      }			
		}
		if(ordenconsulta==ValueConstants.ORDEN_CONSULTA_IDVISITANTE){
			sqlb.append(" order by v.idvisitante " );
		}else
			if(ordenconsulta==ValueConstants.ORDEN_CONSULTA_IDBOLETAJE){
				sqlb.append(" order by v.idboletaje,v.apepat,v.apemat,v.nombre " );
			}
			else
				if(ordenconsulta==ValueConstants.ORDEN_CONSULTA_NOMBRECOMPVISITANTE){
					sqlb.append(" order by v.apepat,v.apemat,v.nombre " );
				}
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.VisitanteMapper());
	}
	
	
	
	
//	public List<Visitante> listarxFicha(long ficha) {     
//		
//		String sql = 
//				VISITANTEFULL
//				+ "AND v.idfichaturismo = "+ficha+" order by  v.idboletaje,v.apepat,v.apemat,v.nombre ";   
//        //System.out.println(sql);
//		return  this.jdbcTemplate.query(sql, new RowMappersConstants.VisitanteMapper());
//	}
	
	
	public List<Map<String, Object>> addPercent( List<Map<String, Object>> list ){
		int i,size = list.size();
		int total=0;
		for( i = 0; i < size ;i++){
			int subtotal= Integer.parseInt(list.get(i).get("total").toString());
			total += subtotal;
		}
		for(i = 0;i<size;i++){ 
			int subtotal= Integer.parseInt(list.get(i).get("total").toString());
			double psubtotal=   ( (double) (subtotal*100)/ (double) total);
			if(psubtotal<10){
				psubtotal=ProyectoUtil.redondear(psubtotal, 2);
			}else{
				psubtotal=ProyectoUtil.redondear(psubtotal, 1);
			}
			
			list.get(i).put("percent",  ( psubtotal ));
		}
		return list;
	}
	
	
	public void actualizarxFicha(Fichaturismo fichaturismo,Visitante visitante){
		StringBuffer sqlb = new StringBuffer("update sernanp.visitante set idvisitante=idvisitante ");
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("flagcompleto", visitante.getFlagcompleto());
		parametros.put("flagregistro", visitante.getFlagregistro());
		parametros.put("idboletaje", visitante.getBoletaje().getIdboletaje());
		parametros.put("flagvisitante", visitante.getFlagvisitante());
		if(visitante.getFlagcompleto()!=0){
			if(visitante.getFlagcompleto()==ValueConstants.VALOR_CERO){
				sqlb.append(", flagcompleto=0");	
			}
			else{
				sqlb.append(", flagcompleto=:flagcompleto");
			}
		}
		if(visitante.getFlagregistro()!=0){
			if(visitante.getFlagregistro()==ValueConstants.VALOR_CERO){
				sqlb.append(", flagregistro=0");	
			}
			else{
				sqlb.append(", flagregistro=:flagregistro");
			}
		}
		if(visitante.getBoletaje().getIdboletaje()!=0){
			if(visitante.getBoletaje().getIdboletaje()==ValueConstants.VALOR_CERO){
				sqlb.append(", idboletaje=null");	
			}
			else{
				sqlb.append(", idboletaje=:idboletaje");
			}
		}
		if(visitante.getFlagvisitante()!=0){
			if(visitante.getFlagvisitante()==ValueConstants.VALOR_CERO){
				sqlb.append(", flagvisitante=0");	
			}
			else{
				sqlb.append(", flagvisitante=:flagvisitante");
			}
		}
		sqlb.append(" where idfichaturismo=");
		sqlb.append(fichaturismo.getIdfichaturismo());
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql, parametros);
	}
	
	
	
	public void actualizarxLista(Visitante visitante,List<Visitante> lista ){
		StringBuffer sqlb = new StringBuffer("update sernanp.visitante set idvisitante=idvisitante ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("flagvisitante", visitante.getFlagvisitante());
		if(visitante.getFlagvisitante()!=0){
			if(visitante.getFlagvisitante()==ValueConstants.VALOR_CERO){
				sqlb.append(", flagvisitante=0");	
			}
			else{
				sqlb.append(", flagvisitante=:flagvisitante");
			}
			
		}
		if(lista.size()!=0){
		    	sqlb.append(" where idvisitante in(");
		    	for(Visitante v:lista){
					sqlb.append(v.getIdvisitante());
					sqlb.append(",");
			    }
		    	sqlb.delete(sqlb.length()-1, sqlb.length());
			    sqlb.append(")");
		    }
		    else{
		    	sqlb.append(" where idvisitante=0");
		  }
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql, parametros);
		
	}
	
	public void actualizaLista(int flagregistro,Visitante visitante ){
		StringBuffer sqlb = new StringBuffer("update sernanp.visitante set idvisitante=idvisitante ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("flagregistrocambiar", flagregistro);
		parametros.put("flagregistro", visitante.getFlagregistro());
		if(flagregistro!=0){
			if(flagregistro==ValueConstants.VALOR_CERO){
				sqlb.append(", flagregistro=0");	
			}
			else{
				sqlb.append(", flagregistro=:flagregistrocambiar");
			}
		}
		sqlb.append(" where idvisitante in (select idvisitante from sernanp.visitante where idfichaturismo=");
		sqlb.append(visitante.getFichaturismo().getIdfichaturismo());
		if(visitante.getFlagregistro()!=0){
			if(visitante.getFlagregistro()==ValueConstants.VALOR_CERO){
				sqlb.append(" and flagregistro=0");	
			}
			else{
				sqlb.append(" and flagregistro=:flagregistro");
			}
		}
		sqlb.append(")");
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql, parametros);
		
	}
	
	 public void actualizar(Visitante visitante){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer("update sernanp.visitante set idvisitante=idvisitante ");
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("nombre",visitante.getNombre() );
			parametros.put("apepat",visitante.getApepat() );
			parametros.put("apemat", visitante.getApemat());
			parametros.put("numerodoc", visitante.getNumerodocumento());
			parametros.put("idtipodocumento", visitante.getTipodocumento().getIdtipo());
			parametros.put("idtipoocupacion", visitante.getTipoocupacion().getIdtipo());
			parametros.put("idmotivovisita", visitante.getMotivovisita().getIdtipo());
			parametros.put("idsexo", visitante.getSexo().getIdtipo());
			parametros.put("idpais", visitante.getPais().getIdpais());
			parametros.put("idboletaje", visitante.getBoletaje().getIdboletaje());
			parametros.put("flagregistro", visitante.getFlagregistro());
			parametros.put("flagcompleto", visitante.getFlagcompleto());
			if(visitante.getFechanacimiento()!=null){
				
				parametros.put("fechanacimiento", new java.sql.Date( visitante.getFechanacimiento().getTime())) ;
			    //System.out.println( "fecha nac"+new java.sql.Date( visitante.getFechanacimiento().getTime()) );
		    }
		   else{
			parametros.put("fechanacimiento", null);
		    }
		
			
			if(visitante.getNombre()!=null){
				sqlb.append(", nombre=upper(:nombre)");
			}
			if(visitante.getApepat()!=null){
				sqlb.append(", apepat=upper(:apepat)");
			}
			if(visitante.getApemat()!=null){
				sqlb.append(", apemat=upper(:apemat)");
			}
			if(visitante.getNumerodocumento()!=null){
				sqlb.append(", numerodoc=:numerodoc");
			}
			if(visitante.getTipodocumento().getIdtipo()!=0){
				if(visitante.getTipodocumento().getIdtipo()==ValueConstants.VALOR_CERO){
					sqlb.append(", idtipodocumento=null");	
				}
				else{
					sqlb.append(", idtipodocumento=:idtipodocumento");
				}
			}
			if(visitante.getTipoocupacion().getIdtipo()!=0){
				if(visitante.getTipoocupacion().getIdtipo()==ValueConstants.VALOR_CERO){
					sqlb.append(", idtipoocupacion=null");	
				}
				else{
					sqlb.append(", idtipoocupacion=:idtipoocupacion");
				}
			}
			if(visitante.getMotivovisita().getIdtipo()!=0){
				if(visitante.getMotivovisita().getIdtipo()==ValueConstants.VALOR_CERO){
					sqlb.append(", idmotivovisita=null");	
				}
				else{
					sqlb.append(", idmotivovisita=:idmotivovisita");
				}
			}
			if(visitante.getBoletaje().getIdboletaje()!=0){
				if(visitante.getBoletaje().getIdboletaje()==ValueConstants.VALOR_CERO){
					sqlb.append(", idboletaje=null");	
				}
				else{
					sqlb.append(", idboletaje=:idboletaje");
				}
			}
			if(visitante.getSexo().getIdtipo()!=0){
				sqlb.append(", idsexo=:idsexo");
			}
			if(visitante.getPais().getIdpais()!=0){
				sqlb.append(", idpais=:idpais");
			}
			if(visitante.getFechanacimiento()!=null){
				sqlb.append(", fechanacimiento=:fechanacimiento");
			}
			if(visitante.getFlagregistro()!=0){
				if(visitante.getFlagregistro()==ValueConstants.VALOR_CERO){
					sqlb.append(", flagregistro=0");	
				}
				else{
					sqlb.append(", flagregistro=:flagregistro");
				}
			}
			if(visitante.getFlagcompleto()!=0){
				if(visitante.getFlagcompleto()==ValueConstants.VALOR_CERO){
					sqlb.append(", flagcompleto=0");	
				}
				else{
					sqlb.append(", flagcompleto=:flagcompleto");
				}
			}
			sqlb.append(" where idvisitante=");
			sqlb.append(visitante.getIdvisitante());
			String sql =sqlb.toString();
			//System.out.println(sql);
			simpleJdbcTemplate.update(sql, parametros);
	}
	
	 
	 public void actualizarDiferencia(List<Visitante> lista,long idfichaturismo){
			StringBuffer sqlb = new StringBuffer("update  sernanp.visitante set idfichaturismo=null ");
			Map<String, Object> parametros = new HashMap<String, Object>();
			//parametros.put("idfichaturismo",idfichaturismo);
//			if(idfichaturismo!=0){
//				if(idfichaturismo==ValueConstants.VALOR_CERO ){
//					sqlb.append(", idfichaturismo=null " );
//				}else{
//					sqlb.append(", idfichaturismo=:idfichaturismo ");
//				}		
//			}
			sqlb.append(" where idvisitante in( select tab.idvisitante from (");
			sqlb.append("select * from sernanp.visitante v " +
					"where   v.idfichaturismo=");
			sqlb.append(idfichaturismo);
			sqlb.append(") as tab  where tab.idvisitante not in(");
			for(Visitante v:lista){
					sqlb.append(v.getIdvisitante());
					sqlb.append(",");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append("))");
			String sql =sqlb.toString();
			 //System.out.println(sql);
			simpleJdbcTemplate.update(sql,parametros);			
		} 
	 
	
	 public void eliminarxIdficha(int idfichaturismo){
		 StringBuffer sqlb = new StringBuffer("delete from sernanp.visitante v where (v.flagregistro=0 or v.flagregistro is null) " +
		 		"   and v.idfichaturismo=");
		 sqlb.append(idfichaturismo);
		 String sql =sqlb.toString();
		 this.simpleJdbcTemplate.update(sql);
	 }
	 
	 public double obtenerMontoCalculadoFichaxId(int idficha){
			double monto=0;
		    StringBuffer sqlb = new StringBuffer(SqlConstants.obtenerMontoCalculadoFichaxId);
			if(idficha!=0 ){
				sqlb.append(" and v.idfichaturismo=" );
				sqlb.append(idficha);
			}
			String sql =sqlb.toString();
			Map<String,Object> map=this.jdbcTemplate.queryForMap(sql);
			if(map.get("monto")!=null){
				monto=(Double) map.get("monto");
			}
			return monto;
	 }
	 
	 public double obtenerMontoCalculadoFichaxListadoVisitantes(List<Visitante> lista){
			double monto=0;
		    StringBuffer sqlb = new StringBuffer(SqlConstants.obtenerMontoCalculadoFichaxId);
		    if(lista.size()!=0){
		    	sqlb.append(" and v.idvisitante in(");
		    	for(Visitante v:lista){
					sqlb.append(v.getIdvisitante());
					sqlb.append(",");
			    }
		    	sqlb.delete(sqlb.length()-1, sqlb.length());
			    sqlb.append(")");
		    }
		    else{
		    	sqlb.append(" and v.idvisitante=0");
		    }
			String sql =sqlb.toString();
			//System.out.println(sql);
			Map<String,Object> map=this.jdbcTemplate.queryForMap(sql);
			if(map.get("monto")!=null){
				monto=(Double) map.get("monto");
		}
		return monto;
	 }
	
	 
	 
	 
	
}
