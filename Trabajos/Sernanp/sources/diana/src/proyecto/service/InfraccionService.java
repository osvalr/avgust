package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.InfraccionDAO;
import proyecto.dao.InfractorDAO;
import proyecto.vo.Infraccion;
import proyecto.vo.Infractor;

@Service
public class InfraccionService {
	
	@Autowired
	private InfraccionDAO infraccionDAO;
	@Autowired
	private InfractorDAO infractorDAO;
	
	
	
	public int codigoGenerado(){
		return infraccionDAO.generaCodigo();
	}
	
	public Infractor  verificaReincidencia(int dni){
		
		List<Infractor> lista = new ArrayList<Infractor>();
		Infractor infractor = new Infractor();
		lista = infraccionDAO.verificaReincidencia(dni);
	
		if(lista.size()==1){
			
			infractor=lista.get(0);
			
			return infractor;
		}else
		{
			return null;
		}
	}
	
	public List<Infraccion> listar(){
		
		return infraccionDAO.listar();
	}
	
	
	//LISTA POR CODIGO DE EXPEDIENTE
	public List<Infraccion>listarXExpediente(int idexpediente){
		return infraccionDAO.listarXExpediente(idexpediente);
	}
	
	// JCEV 04-10-2012
	public List<Infraccion> contarReinidenciaXInfraccion(int idInfractor, int idInfraccion){
		return infraccionDAO.cuentaReincidenciaXExpedienteInfraccion(idInfractor, idInfraccion);
	}
	
//	public int insertar(Infraccion infraccion){
//		int result=-1;
//		int idInfractor=infraccion.getInfractor().getIdinfractor();
//		
//		System.out.println("Ingreso a el insertar de lservice");
//		System.out.println("nombre del infractor es : "+infraccion.getInfractor().getPersonanatural().getNombre());
//		
//		//validamos is es bueno o antiguo
//		if(infraccion.getInfractor().getIdinfractor()==0){
//			idInfractor = infractorDAO.insertar(infraccion.getInfractor());
//			System.out.println("INFRACTOR NUEVO id de infractor es :"+idInfractor);
//		
//		}else{
//			infractorDAO.aumentarInfraccion(idInfractor);
//			System.out.println("INFRACTOR REINCIDENTE id de infractor es :"+idInfractor);
//		}
//		infraccion.getInfractor().setIdinfractor(idInfractor);
//		
//		result = infraccionDAO.insertar(infraccion);
//		
//		
//		return result;
//	}
	
}
