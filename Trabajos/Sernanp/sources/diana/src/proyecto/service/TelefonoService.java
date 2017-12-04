package proyecto.service;

import java.util.List;

import proyecto.constants.ValueConstants;
import proyecto.dao.PersonalDAO;
import proyecto.dao.TelefonoDAO;
import proyecto.dao.TipoDAO;
import proyecto.param.ProyectoParam;
import proyecto.vo.Personal;
import proyecto.vo.Telefono;

public class TelefonoService {

	private TelefonoDAO telefonoDAO;
	private TipoDAO tipoDAO;
	
	
	public void setTelefonoDAO(TelefonoDAO telefonoDAO) {
		this.telefonoDAO = telefonoDAO;
	}


	public void setTipoDAO(TipoDAO tipoDAO) {
		this.tipoDAO = tipoDAO;
	}
	
	
	public int  calcularCantidadRegistrosDirectorio(Telefono telefono)  {
		
		return telefonoDAO.contar(telefono);		
    }
	
	public List<Telefono> consultarDirectorioPaginado(Telefono telefono,int offset,int tamPagina){
		return telefonoDAO.listarPaginado(telefono,offset,tamPagina);
	}
	
	
	
	
	
	

}
