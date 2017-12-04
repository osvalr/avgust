package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.EditorialDAO;
import proyecto.dao.RecursoInformacionEditorialDAO;
import proyecto.dao.TemaDAO;
import proyecto.dao.UbigeoDAO;
import proyecto.vo.Editorial;
import proyecto.vo.Tema;
import proyecto.vo.Ubigeo;
@Service
public class UbigeoService {

	@Autowired
	private UbigeoDAO ubigeoDAO;
	

	
	public List<Ubigeo>  consultarUbigeoDepartamentos()  {
	    Ubigeo u=new Ubigeo();
	    u.setCodprovincia("00");
	    u.setCoddistrito("00");
		return ubigeoDAO.listar(u);
	}


	public List<Ubigeo>  listarUbigeosProvinciaxCodigoDepartamento(String coddepartamento)  {
	    Ubigeo u=new Ubigeo();
	    u.setCoddepartamento(coddepartamento);
	    u.setCoddistrito("00");
	    u.setIdubigeodepartamento(ValueConstants.VALOR_CERO);
		return ubigeoDAO.listar(u);
	}
	
	public List<Ubigeo>  listarUbigeosDistritoxCodigoProvincia(String coddepartamento,String codprovincia)  {
	    Ubigeo u=new Ubigeo();
	    u.setCoddepartamento(coddepartamento);
	    u.setCodprovincia(codprovincia);
	    u.setIdubigeoprovincia(ValueConstants.VALOR_CERO);
	    //u.setCoddistrito("00");
		return ubigeoDAO.listar(u);
	}
}
