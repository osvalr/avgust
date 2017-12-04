package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.ArchivoDAO;
import proyecto.dao.ProyectoArchivoDAO;
import proyecto.vo.Archivo;
@Service
public class ArchivoService {

	@Autowired
	private ArchivoDAO archivoDAO;
	@Autowired
	private ProyectoArchivoDAO proyectoArchivoDAO;

	
	





	public int guardarArchivo(Archivo archivo){
		int codigo=0;
		if(archivo.getIdarchivo()==0){
			codigo= archivoDAO.insertar(archivo);
		}
		return codigo;
		
	}

	
	public Archivo consultarArchivoxId(int idarchivo){
		Archivo a=new Archivo();
		List<Archivo> lista=new ArrayList<Archivo>();
		lista=archivoDAO.listar(new Archivo(idarchivo));
		if(lista.size()!=0){
			a=lista.get(0);
			 
		}
		return a;
		
	}
	
	public void actualizaEstadoArchivo(int idarchivo){
		archivoDAO.actualizaEstadoArchivo(idarchivo);
	}

	
}
