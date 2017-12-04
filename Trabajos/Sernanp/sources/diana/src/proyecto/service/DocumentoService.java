package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.ArchivoDAO;
import proyecto.dao.DirectorioArchivoModuloDAO;
import proyecto.dao.DocumentoLogoAreaNaturalDAO;
import proyecto.vo.Archivo;
import proyecto.vo.Directorioarchivo;
import proyecto.vo.DirectorioarchivoModulo;
import proyecto.vo.Documento;
@Service
public class DocumentoService {

	
	@Autowired
	private ArchivoDAO archivoDAO;
	@Autowired
	private DirectorioArchivoModuloDAO directorioArchivoModuloDAO;
	@Autowired
	private DocumentoLogoAreaNaturalDAO documentoLogoAreaNaturalDAO;
	
	
	public Directorioarchivo obtenerDirectorioxIdmodulo(int idmodulo){
		
		Directorioarchivo d=new Directorioarchivo();
		DirectorioarchivoModulo dam=new DirectorioarchivoModulo();
		dam.getModulo().setIdmodulo(idmodulo);
		List<Directorioarchivo> lista=directorioArchivoModuloDAO.listarDirectorio(dam);
		if(lista.size()==1){
			d=lista.get(0);
		}
		return d;
	}
	
	
	public Archivo consultarArchivoxId(int idarchivo){
		Archivo a=new Archivo();
		List<Archivo> lista=archivoDAO.listar(new Archivo(idarchivo));
		if(lista.size()==1){
			a=lista.get(0);
		}
		return a;
	}


	
	public String consultarLogoAreaNaturalxId(int idareanatural){
		String ruta="";
		List<Documento> listadoc=documentoLogoAreaNaturalDAO.listarDocumento(idareanatural);
		if(listadoc.size()==1){
			Documento doc=listadoc.get(0);
			Archivo a=new Archivo();
			a.getDocumento().setIddocumento(doc.getIddocumento());
			List<Archivo> listaarch=archivoDAO.listar(a);
			if(listaarch.size()==1){
				a=listaarch.get(0);
				ruta=a.getDirectorioarchivo().getDirdirectorio()+a.getNombregenerado();
			}
		}
		return ruta;
	}
	

	
	
	
}
