package proyecto.dao.procedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import proyecto.vo.Guia;


public class GuiaProcedure extends StoredProcedure{
	
	private static String insertaGuiaTurismo="sernanp.insertar_guiaturismo";
	public GuiaProcedure(DataSource dataSource){
		setDataSource(dataSource);
		setSql(insertaGuiaTurismo);

		declareParameter(new SqlParameter("nombre",Types.VARCHAR));
		declareParameter(new SqlParameter("apepat",Types.VARCHAR));
		declareParameter(new SqlParameter("apemat",Types.VARCHAR));
		declareParameter(new SqlParameter("idtipodocumento",Types.INTEGER));
		declareParameter(new SqlParameter("numerodoc",Types.VARCHAR));
		declareParameter(new SqlParameter("fechanacimiento",Types.DATE));
		declareParameter(new SqlParameter("idsexo",Types.INTEGER));
		declareParameter(new SqlParameter("idestadocivil",Types.INTEGER));
		declareParameter(new SqlParameter("direccion",Types.VARCHAR));
		declareParameter(new SqlParameter("telefono",Types.VARCHAR));
		declareParameter(new SqlParameter("idpais",Types.INTEGER));
		declareParameter(new SqlParameter("idubigeo",Types.INTEGER));
		declareParameter(new SqlParameter("correopersonal",Types.VARCHAR));
		declareParameter(new SqlOutParameter("idguia", Types.INTEGER));
		
	}

	
	public int insertar(Guia guia){
		int idg=0;
		try{
			Map<String,Object> datosEntrada= new HashMap<String,Object>();
			datosEntrada.put("nombre", guia.getNombre());
			datosEntrada.put("apepat", guia.getApepat());
			datosEntrada.put("apemat", guia.getApemat());
			if(guia.getTipodocumento().getIdtipo()!=0){
				datosEntrada.put("idtipodocumento", guia.getTipodocumento().getIdtipo());
			}else{
				datosEntrada.put("idtipodocumento", null);
			}
			
			datosEntrada.put("numerodoc", guia.getNumerodocumento());
			datosEntrada.put("fechanacimiento", guia.getFechanacimiento());
			datosEntrada.put("idsexo", guia.getSexo().getIdtipo());
			if(guia.getEstadocivil().getIdtipo()!=0){
				datosEntrada.put("idestadocivil", guia.getEstadocivil().getIdtipo());
			}else{
				datosEntrada.put("idestadocivil", null);
			}
			
			datosEntrada.put("direccion", guia.getDireccion());
			datosEntrada.put("telefono", guia.getTelefono());
			
			if(guia.getPais().getIdpais()!=0){
				datosEntrada.put("idpais", guia.getPais().getIdpais());
			}else{
				datosEntrada.put("idpais", null);
			}
			datosEntrada.put("idubigeo", guia.getUbigeo().getIdubigeo());
			datosEntrada.put("correopersonal", guia.getCorreopersonal());
			
			 Map<String, Object> map= super.execute(datosEntrada);
			 idg=(Integer)(map.get("idguia"));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return idg;
	}
}
