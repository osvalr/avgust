package proyecto.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.TurismoPagos;
import proyecto.vo.TurismoPagosDetalle;

@Repository
public class TurismoPagosDao {

    private JdbcTemplate jdbcTemplate;	 
	
	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// JCEV 01-08-2012, actualizado 06-08-2012
	public List<TurismoPagos> listarPagos(TurismoPagos tur, String strForm){
		List<TurismoPagos> lLst = null;
		StringBuffer sqlb       = null;
		String sql              = null;
		try {
			lLst = new ArrayList<TurismoPagos>(); 
			sqlb = new StringBuffer(SqlConstants.listaTurismoControlPagos);
		    if(!tur.getStrFecIni().equalsIgnoreCase("")){
		    	sqlb.append(" and b.fechamovimiento between to_date('" + tur.getStrFecIni() + "', '" + strForm + "')");
		    }
		    if(!tur.getStrFecFin().equalsIgnoreCase("") && !tur.getStrFecIni().equalsIgnoreCase("")){
		    	sqlb.append(" and to_date('" + tur.getStrFecFin() + "', '" + strForm + "')");
		    }
		    if(tur.getStrCodCateg() != null && !tur.getStrCodCateg().equalsIgnoreCase("--Todos--")){
				//sqlb.append(" and c.codcategoriaanp = '" + tur.getStrCodCateg() + "'");
				sqlb.append(" and TRIM(b.codcategoriaanp) = '" + tur.getStrCodCateg() + "'");
		    }else{
				//sqlb.append(" and c.codcategoriaanp <> '00'");
				sqlb.append(" and TRIM(b.codcategoriaanp) <> '00'");
		    }
		    if(tur.getStrCodAreaNat() != null && !tur.getStrCodAreaNat().equalsIgnoreCase("--Todos--")){
				//sqlb.append(" and d.codareanatural  = '" + tur.getStrCodAreaNat() + "'");
				sqlb.append(" and TRIM(b.codareanatural)  = '" + tur.getStrCodAreaNat() + "'");
		    }else{
				//sqlb.append(" and d.codareanatural  <> '0000'");
				sqlb.append(" and TRIM(b.codareanatural)  <> '0000'");
		    }
			//if(tur.getStrRutaTurimo() != null && !tur.getStrRutaTurimo().equalsIgnoreCase("--Todos--")){
		    if(tur.getStrRutaTurimo() != null && !tur.getStrRutaTurimo().equals("")){
		    	//sqlb.append(" and e.codrutaturismo  = '" + tur.getStrRutaTurimo() + "'");
				//sqlb.append(" and e.codrutaturismo  = '" + tur.getStrRutaTurimo() + "'");
				sqlb.append(" and TRIM(b.codrutaturismo) = '" + tur.getStrRutaTurimo() + "'");
		    }else{
		    	sqlb.append(" and TRIM(b.codrutaturismo) LIKE '"+ tur.getStrCodAreaNat() +"__'");
				//sqlb.append(" and e.codrutaturismo  <> '000000'");
				//sqlb.append(" and b.codrutaturismo  <> '000000'");
		    }
		    sqlb.append(" and d.flagactivoareanatural = 1 ");
			sqlb.append(" ORDER BY b.codcategoriaanp, b.codareanatural, b.codrutaturismo, b.fechamovimiento");
			sql  = sqlb.toString();

			lLst = this.jdbcTemplate.query(sql, new RowMappersConstants.TurismoControlPagosMapper());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lLst;
	}

	// JCEV 07-08-2012  ('0408041109150002%')
	public List<TurismoPagosDetalle> ListaDetallePagos(String strId){
		List<TurismoPagosDetalle> lLst = null;
		StringBuffer sqlb              = null;
		String sql                     = null;
		try {
			lLst = new ArrayList<TurismoPagosDetalle>(); 
			sqlb = new StringBuffer(SqlConstants.listaDetalleBoletaje);
	    	sqlb.append(" a.registroturista LIKE '" + strId + "%' and ");
	    	sqlb.append(" a.codigoficha     LIKE '" + strId + "%' and ");
	    	sqlb.append(" c.idfichaturismo  = b.idfichaturismo    and ");
	    	sqlb.append(" d.idboletaje      = c.idboletaje ");
			sql  = sqlb.toString();
			System.out.println("Sql (ListaDetallePagos)   : " + sql);
			lLst = this.jdbcTemplate.query(sql, new RowMappersConstants.DetalleTurismoControlPagosMapper());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lLst;			 
		
	}
	
}

//@SuppressWarnings("unchecked")
//public List<TurismoPagos> listarPagosDetalle(TurismoPagos tur, String strForm, String strCodCat, String strCodArea, String strRuta){
//	List<TurismoPagos> lLst = null;
//	StringBuffer sqlb       = null;
//	String sql              = null;
//	try {
//		lLst = new ArrayList<TurismoPagos>(); 
//		sqlb = new StringBuffer(SqlConstants.listaDetalleBoletaje);
//	    if(!tur.getStrFecIni().equalsIgnoreCase("")){
//	    	sqlb.append(" to_char(b.fechamovimiento, '" + strForm + "') >= '" + tur.getStrFecIni() + "'");
//	    }
//	    if(!tur.getStrFecFin().equalsIgnoreCase("")){
//			sqlb.append(" and to_char(b.fechamovimiento, '" + strForm + "') <= '" + tur.getStrFecFin() + "'");
//	    }
//	    if(strCodCat != null){
//			sqlb.append(" and c.codcategoriaanp = '" + strCodCat + "'");
//	    }
//	    if(strCodArea != null){
//			sqlb.append(" and d.codareanatural  = '" + strCodArea + "'");
//	    }
//	    if(strRuta != null){
//			sqlb.append(" and e.codrutaturismo  = '" + strRuta + "'");
//	    }
//		sqlb.append(" ORDER BY b.codcategoriaanp, b.codareanatural, b.codrutaturismo, b.fecharegturismo ASC");
//		System.out.println("Sql    : " + sqlb.toString());
//		sql  = sqlb.toString();
//		lLst = this.jdbcTemplate.query(sql, new RowMappersConstants.TurismoControlPagosMapper());	
//		System.out.println("lLst : " + lLst.size());
//		for (TurismoPagos xtur : lLst) {
//			System.out.println("ID : " + xtur.getStrCodRutaTurismo());
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return lLst;
//}
