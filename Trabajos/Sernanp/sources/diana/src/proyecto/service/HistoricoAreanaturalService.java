package proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.HistoricoAreanaturalDAO;
import proyecto.vo.HistoricoAreanatural;

@Service
public class HistoricoAreanaturalService {
	
	@Autowired
	private HistoricoAreanaturalDAO historicoAreanaturalDAO; 
	
	public List<HistoricoAreanatural> listar() {
		return historicoAreanaturalDAO.listar();  
	}
	public List<Map<String, Object>> historico(){
		return historicoAreanaturalDAO.historico();
	}
}
