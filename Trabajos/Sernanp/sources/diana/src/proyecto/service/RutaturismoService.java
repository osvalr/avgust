package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.RutaturismoDAO;
import proyecto.vo.Areanatural;
import proyecto.vo.Rutaturismo;

@Service
public class RutaturismoService {
	
	@Autowired
	private RutaturismoDAO rutaturismoDAO;
	
	public int size(int idareanatural){
		//return rutaturismoDAO.size(idareanatural);
		
	     return rutaturismoDAO.contarxAreaNatural(new Areanatural(idareanatural)); 
	}
	public List<Rutaturismo> listar() {
		return this.rutaturismoDAO.listar();  
	}

	public List<Rutaturismo> listarxTipo( int idtipoturismo) {
		return this.rutaturismoDAO.listarxTipo( idtipoturismo );  
	}

	public List<Rutaturismo> listarxArea( int idareanatural) {
		//return this.rutaturismoDAO.listarxArea( idareanatural );  
	     return rutaturismoDAO.listarxAreaNatural(new Areanatural(idareanatural));
	}
	
	
	public Rutaturismo consultarRutaTurismoxId(int idrutaturismo){
		List<Rutaturismo> lista=new ArrayList<Rutaturismo>();
		Rutaturismo rt=new Rutaturismo();
		lista=rutaturismoDAO.listar(new Rutaturismo(idrutaturismo));
		if(lista.size()==1){
			rt=lista.get(0);
		}
		return rt;
	}
	
	// JCEV 30-07-2012
		public List<Rutaturismo> listarRutaTurismo(Areanatural anat)  {	
			//System.out.println("Cod. Area [listarRutaTurismo - Service] : " + anat.getCodareanatural());
		    return rutaturismoDAO.listar(anat);	
		}
		
		// JCEV 08-08-2012
//		public List<Rutaturismo> listarDetalleBoletaje(String strId, String strFecIni, String strFecFin)  {	
		public List<Rutaturismo> listarDetalleBoletaje(String strId)  {	
//			System.out.println("listarDetalleBoletaje - service : " + strId);
//		    return rutaturismoDAO.listarDetalleBoletaje(strId.trim(), strFecIni, strFecFin);	
		    return rutaturismoDAO.listarDetalleBoletaje(strId.trim());	
		}
	
//	public Rutaturismo save(Rutaturismo ruta){
//		Rutaturismo newRuta = this.rutaturismoDAO.save(ruta);
//		return newRuta;
//	}
}
