package proyecto.dao.procedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import proyecto.vo.Personanatural;


public class PersonaNaturalProcedure extends StoredProcedure{
	
	private static String insertaNoDuplicadoPersonaNatural="sernanp.insertar_no_duplicado_personanatural";
	public PersonaNaturalProcedure(DataSource dataSource){
		setDataSource(dataSource);
		setSql(insertaNoDuplicadoPersonaNatural);

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
		declareParameter(new SqlOutParameter("idpersonanatural", Types.INTEGER));
		
	}

	
	public int insertar(Personanatural personanatural){
		int idpnat=0;
		try{
			Map<String,Object> datosEntrada= new HashMap<String,Object>();
			datosEntrada.put("nombre", personanatural.getNombre());
			datosEntrada.put("apepat", personanatural.getApepat());
			datosEntrada.put("apemat", personanatural.getApemat());
			if(personanatural.getTipodocumento().getIdtipo()!=0){
				datosEntrada.put("idtipodocumento", personanatural.getTipodocumento().getIdtipo());
			}else{
				datosEntrada.put("idtipodocumento", null);
			}
			
			datosEntrada.put("numerodoc", personanatural.getNumerodocumento());
			datosEntrada.put("fechanacimiento", personanatural.getFechanacimiento());
			datosEntrada.put("idsexo", personanatural.getSexo().getIdtipo());
			if(personanatural.getEstadocivil().getIdtipo()!=0){
				datosEntrada.put("idestadocivil", personanatural.getEstadocivil().getIdtipo());
			}else{
				datosEntrada.put("idestadocivil", null);
			}
			
			datosEntrada.put("direccion", personanatural.getDireccion());
			datosEntrada.put("telefono", personanatural.getTelefono());
			
			if(personanatural.getPais().getIdpais()!=0){
				datosEntrada.put("idpais", personanatural.getPais().getIdpais());
			}else{
				datosEntrada.put("idpais", null);
			}
			if(personanatural.getUbigeo().getIdubigeo()!=0){
				datosEntrada.put("idubigeo", personanatural.getUbigeo().getIdubigeo());
			}else{
				datosEntrada.put("idubigeo", null);
			}
			
			datosEntrada.put("correopersonal", personanatural.getCorreopersonal());
			
			 Map<String, Object> map= super.execute(datosEntrada);
			 idpnat=(Integer)(map.get("idpersonanatural"));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return idpnat;
	}
}
