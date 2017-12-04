package sernanp.rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalActividadDAO;
import sernanp.rrhh.vo.PersonalActividadVO;

public class PersonalActividadService {
	@Autowired
	private PersonalActividadDAO personalActividadDAO;
	
	
	//	
	public List<PersonalActividadVO> listMotivoMarcacionJustificaInasistenciaCGH(){
		return personalActividadDAO.listMotivoMarcacionJustificaInasistenciaCGH();
	}

	public List<PersonalActividadVO> listMotivoMarcacionJustificaInasistenciaCGH_SGH(){
		return personalActividadDAO.listMotivoMarcacionJustificaInasistenciaCGH_SGH();
	}
	
	
	public List<PersonalActividadVO> listMotivoPapeleta(){
		return personalActividadDAO.listMotivoPapeleta();
	}
	

	

}
