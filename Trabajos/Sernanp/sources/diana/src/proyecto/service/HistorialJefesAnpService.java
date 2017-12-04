package proyecto.service;

import java.util.List;

import proyecto.dao.HistorialJefesAnpDAO;
import proyecto.vo.Areanatural;
import proyecto.vo.HistorialJefesAnp;

public class HistorialJefesAnpService {

	private HistorialJefesAnpDAO historialjefesanpDAO;

	public void setHistorialjefesanpDAO(HistorialJefesAnpDAO historialjefesanpDAO) {
		this.historialjefesanpDAO = historialjefesanpDAO;
	}
	
	public List<HistorialJefesAnp> listarActualJefe(Areanatural an){
		
		return historialjefesanpDAO.listarActualJefe(an);
		
	}
}
