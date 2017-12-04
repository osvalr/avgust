package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.ExpedienteSancionDAO;
import proyecto.vo.ExpedienteSancion;

@Service
public class ExpedienteSancionService {
	
	@Autowired
	private ExpedienteSancionDAO expedientesancionDAO;

	
	public List<ExpedienteSancion> listarExpedienteSancion(int idexpediente){
		return expedientesancionDAO.listarExpedienteSancion(idexpediente);
	}
	
	// JCEV 04-10-2012
	public String determinaMorocidadResolucionExpediente(int idExpediente){
		String strRet = null;
		try {
			strRet = expedientesancionDAO.listarMorosidad(idExpediente);
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		System.out.println("determinaMorocidadResolucionExpediente -- Exp: " + idExpediente + " Ret : " + strRet);
		return strRet;
	}

	// JCEV 11-10-2012
	public int extraeFlagMorocidad(int idExpediente){
		int nRet = 0;
		try {
			nRet = expedientesancionDAO.extraeFlagMorocidad(idExpediente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nRet;
	}
	
}
