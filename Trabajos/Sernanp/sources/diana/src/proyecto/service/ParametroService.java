package proyecto.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.ParametroDAO;
import proyecto.dao.TipoDAO;
import proyecto.vo.Parametro;

@Service
public class ParametroService {

	
	@Autowired
	private TipoDAO tipoDAO;
	@Autowired
	private ParametroDAO parametroDAO;


	public Map<String, String> obtenerParametros(){
		return parametroDAO.obtenerMap(new Parametro());
	}
	

}
