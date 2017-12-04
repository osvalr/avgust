package proyecto.service;

import java.util.List;

import proyecto.dao.MonedaDAO;
import proyecto.vo.Moneda;

public class MonedaService {

	private MonedaDAO monedaDAO;

	public void setMonedaDAO(MonedaDAO monedaDAO) {
		this.monedaDAO = monedaDAO;
	}

	

	public List<Moneda> listarTipoMonedas(){
		return monedaDAO.listarTipoMoneda(new Moneda());
	}

	
	


}
