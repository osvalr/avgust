package proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.AdministracionAreanaturalDAO;
import proyecto.dao.HistoricoAreanaturalDAO;
import proyecto.vo.AdministracionAreanatural;
import proyecto.vo.HistoricoAreanatural;

@Service
public class AdministracionAreanaturalService {
	
	@Autowired
	private AdministracionAreanaturalDAO administracionAreanaturalDAO; 
	
	public List<AdministracionAreanatural> listar() {
		return administracionAreanaturalDAO.listar();  
	}

}
