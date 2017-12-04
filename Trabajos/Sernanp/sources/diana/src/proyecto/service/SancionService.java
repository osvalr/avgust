package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.SancionDAO;
import proyecto.vo.Sancion;

@Service
public class SancionService {
	
	@Autowired
	private SancionDAO sancionDAO;
	
	//LISTA POR CODIGO DE EXPEDIENTE
	public List<Sancion>listarXExpediente(int idexpediente){
		return sancionDAO.listarXExpediente(idexpediente);
	}

}
