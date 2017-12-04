package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.DirectorioArchivoDAO;
import proyecto.vo.Directorioarchivo;

@Service
public class DirectorioArchivoService {
	
	@Autowired
	private DirectorioArchivoDAO directorioArchivoDAO;
	

	public Directorioarchivo obtener(int id){
		List<Directorioarchivo> lista = new ArrayList<Directorioarchivo>();
		Directorioarchivo directorio = new Directorioarchivo();
		//System.out.println(" me todo obtener en el service /"+id);
		
		lista = directorioArchivoDAO.obtener(id);
		
		if(lista.size()==1){
			
			directorio=lista.get(0);
			
			return directorio;
		}else
		{
			return null;
		}
	}
	
}
