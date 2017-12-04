package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.InfraccionDAO;
import proyecto.dao.InfractorDAO;
import proyecto.dao.SancionDAO;
import proyecto.vo.Infraccion;
import proyecto.vo.Infractor;
import proyecto.vo.Personal;
import proyecto.vo.Sancion;

@Service
public class InfractorService {
	
	@Autowired
	private InfraccionDAO infraccionDAO;
	@Autowired
	private InfractorDAO infractorDAO;
	@Autowired
	private SancionDAO sancionDAO;
	
	
	public List<Infraccion> listarInfracciones(){
		
		return infraccionDAO.listar();
	}
	
	public List <Sancion> listarSanciones(){
		return sancionDAO.listar();
	}
	
	// Verifica en las tablas de personanatural o juridica si existes
	
//	if(lista.size() > 0){
//		infra = lista.get(0);
//		return infra;
//	}else{
//		return null;
//	}
	
	// JCEV 17-10-2012
//	public Personal verifySystem(String numeroDoc, int tipDoc){
//		Personal infra      = new Personal();
//		List<Personal>lista = new ArrayList<Personal>();		
//		lista               = infractorDAO.verifyInfractor(numeroDoc, tipDoc);		
//		if(lista.size() > 0){
//			infra = lista.get(0);
//			return infra;
//		}
//		return null;
//	}	
	
	// JCEV 16-10-2012
	public Infractor verificaEnSistema(String numeroDoc, int tipDoc){
		Infractor infra      = new Infractor();
		List<Infractor>lista = new ArrayList<Infractor>();		
//		System.out.println("InfractorService(Infractor verificaEnSistema) - Doc. " + numeroDoc);		
		lista                = infractorDAO.verificaInfractor(numeroDoc, tipDoc);		
		if(lista.size() > 0){
			infra = lista.get(0);
			return infra;
		}
		return null;
	}	
	
	//verifica reincidencia de infracciones 
	public List<Infraccion> obtieneInfraccionesAntiguas(int idInfractor){
		return infractorDAO.obtenerInfraccionesAntiguas(idInfractor);
	}
	
}