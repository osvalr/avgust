package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.AreaOrganicaDAO;
import proyecto.vo.Areaorganica;
@Service
public class AreaOrganicaService {

	@Autowired
	private AreaOrganicaDAO areaOrganicaDAO;
	
	
	


	public void setAreaOrganicaDAO(AreaOrganicaDAO areaOrganicaDAO) {
		this.areaOrganicaDAO = areaOrganicaDAO;
	}

	
	
	public List<Areaorganica>  listarAreasOrganicas()  {
		
	    Areaorganica ao=new Areaorganica();
	    return areaOrganicaDAO.listar(ao);
	
}
	
	
	
}
