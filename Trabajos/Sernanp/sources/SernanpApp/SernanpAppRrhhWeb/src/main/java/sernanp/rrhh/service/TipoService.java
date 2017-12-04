package sernanp.rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.dao.TipoDAO;
import sernanp.rrhh.vo.PersonalActividadVO;
import sernanp.rrhh.vo.Tipo;

@Service
public class TipoService {

	@Autowired
	private TipoDAO tipoDAO;

    public List<Tipo>  listarTipoMarcacion()  {
		return tipoDAO.listarTipoMarcacion(new Tipo(ValueConstants.TipoMarcacionTempus));		
    }
	
//    public List<Tipo> listTipoLicencia(){
//    	return tipoDAO.listTipoLicencia();
//    }
    
    public List<PersonalActividadVO> listTipoLicencia(){
    	return tipoDAO.listTipoLicencia();
    }
    
}
