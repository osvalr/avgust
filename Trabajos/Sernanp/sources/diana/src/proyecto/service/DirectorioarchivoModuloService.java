package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.DirectorioArchivoModuloDAO;
import proyecto.vo.DirectorioarchivoModulo;

@Service
public class DirectorioarchivoModuloService {

	@Autowired
	private DirectorioArchivoModuloDAO directorioArchivoModuloDAO;
	
	public List<DirectorioarchivoModulo> listar(int idMod){

		return directorioArchivoModuloDAO.listarDirectorioModulo(idMod);
		
	}
}
