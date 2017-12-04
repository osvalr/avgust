package proyecto.service;

import java.util.List;
import proyecto.dao.DetalleExpedienteSancionDAO;
import proyecto.vo.DetalleExpedienteSancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleExpedienteSancionService {
	
	@Autowired
	private DetalleExpedienteSancionDAO detalleExpedienteSancionDAO;
	
	public List<DetalleExpedienteSancion>listarDetalleExpedienteSancion(int idexpediente){
		return detalleExpedienteSancionDAO.listarDetalleExpedienteSancion(idexpediente);
	}

}