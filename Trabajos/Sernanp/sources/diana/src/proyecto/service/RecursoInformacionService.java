package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.AprobacionRecursoInformacionDAO;
import proyecto.dao.ArchivoDAO;
import proyecto.dao.EditorialDAO;
import proyecto.dao.RecursoInformacionArchivoDAO;
import proyecto.dao.RecursoInformacionAreanaturalDAO;
import proyecto.dao.RecursoInformacionAutorDAO;
import proyecto.dao.RecursoInformacionDAO;
import proyecto.dao.RecursoInformacionEditorialDAO;
import proyecto.dao.RecursoInformacionTemaDAO;
import proyecto.param.RecursoInformacionParam;
import proyecto.util.Pagination;
import proyecto.vo.AprobacionRecursoInformacion;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.RecursoInformacion;
import proyecto.vo.RecursoInformacionArchivo;
import proyecto.vo.RecursoInformacionAreanatural;
import proyecto.vo.RecursoInformacionAutor;
import proyecto.vo.RecursoInformacionEditorial;
import proyecto.vo.RecursoInformacionTema;
@Service
public class RecursoInformacionService {
	
	@Autowired
	private RecursoInformacionEditorialDAO recursoInformacionEditorialDAO;
	@Autowired
	private RecursoInformacionAutorDAO recursoInformacionAutorDAO;
	@Autowired
	private RecursoInformacionTemaDAO recursoInformacionTemaDAO;
	@Autowired
	private RecursoInformacionAreanaturalDAO recursoInformacionAreanaturalDAO;
    @Autowired
	private RecursoInformacionDAO recursoInformacionDAO;
	@Autowired
	private RecursoInformacionArchivoDAO recursoInformacionArchivoDAO;
	@Autowired
	private EditorialDAO editorialDAO;
	@Autowired
	private AprobacionRecursoInformacionDAO aprobacionRecursoInformacionDAO;
	@Autowired
	private ArchivoDAO archivoDAO;
	
	
	
	
	
	



	public void setRecursoInformacionEditorialDAO(
			RecursoInformacionEditorialDAO recursoInformacionEditorialDAO) {
		this.recursoInformacionEditorialDAO = recursoInformacionEditorialDAO;
	}



	public void setRecursoInformacionDAO(RecursoInformacionDAO recursoInformacionDAO) {
		this.recursoInformacionDAO = recursoInformacionDAO;
	}
	
	
	
	public void setRecursoInformacionArchivoDAO(
			RecursoInformacionArchivoDAO recursoInformacionArchivoDAO) {
		this.recursoInformacionArchivoDAO = recursoInformacionArchivoDAO;
	}

	


	


	public void setRecursoInformacionAreanaturalDAO(
			RecursoInformacionAreanaturalDAO recursoInformacionAreanaturalDAO) {
		this.recursoInformacionAreanaturalDAO = recursoInformacionAreanaturalDAO;
	}



	public void setRecursoInformacionAutorDAO(
			RecursoInformacionAutorDAO recursoInformacionAutorDAO) {
		this.recursoInformacionAutorDAO = recursoInformacionAutorDAO;
	}



	public void setEditorialDAO(EditorialDAO editorialDAO) {
		this.editorialDAO = editorialDAO;
	}


	
	

	public void setAprobacionRecursoInformacionDAO(
			AprobacionRecursoInformacionDAO aprobacionRecursoInformacionDAO) {
		this.aprobacionRecursoInformacionDAO = aprobacionRecursoInformacionDAO;
	}


	
	
	
	
	
	
	public RecursoInformacion consultarDetalleRecursoInformacionxId(int idrecursoinformacion){
		RecursoInformacion ri=new RecursoInformacion();
		List<RecursoInformacion> lista=new ArrayList<RecursoInformacion>();
		lista=recursoInformacionDAO.listar(new RecursoInformacion(idrecursoinformacion));
		if(lista.size()!=0){
			ri=lista.get(0);
			//editoriales
			RecursoInformacionEditorial rie=new RecursoInformacionEditorial();
			rie.setIdrecursoinformacion(idrecursoinformacion);
			ri.setListaRecursoInformacionEditorial(recursoInformacionEditorialDAO.listar(rie));
			//autor
			RecursoInformacionAutor ria=new RecursoInformacionAutor();
			ria.setIdrecursoinformacion(idrecursoinformacion);
			ri.setListaRecursoInformacionAutor(recursoInformacionAutorDAO.listar(ria));
			//tema
			RecursoInformacionTema rit=new RecursoInformacionTema();
			rit.setIdrecursoinformacion(idrecursoinformacion);
			ri.setListaRecursoInformacionTema(recursoInformacionTemaDAO.listar(rit));
			//area natural
			RecursoInformacionAreanatural rian=new RecursoInformacionAreanatural();
			rian.getRecursoinformacion().setIdrecursoinformacion(idrecursoinformacion);
			ri.setListaRecursoInformacionAreanatural(recursoInformacionAreanaturalDAO.listar(rian));
			//aprobacion ri
			AprobacionRecursoInformacion apri=new AprobacionRecursoInformacion();
			apri.setIdrecursoinformacion(idrecursoinformacion);
			List<AprobacionRecursoInformacion> listaApri=new ArrayList<AprobacionRecursoInformacion>();
			listaApri=aprobacionRecursoInformacionDAO.listar(apri);
			if(listaApri.size()!=0){
				ri.setAprobacionrecursoinformacion(listaApri.get(0));
			}
			//archivos
			RecursoInformacionArchivo riarch=new RecursoInformacionArchivo();
			riarch.getRecursoinformacion().setIdrecursoinformacion(idrecursoinformacion);
			ri.setListaRecursoInformacionArchivo(recursoInformacionArchivoDAO.listar(riarch));
			
		}
		
		
		return ri;
	}
	
	
	
	public Pagination calcularPaginacion(RecursoInformacionParam recursoInformacionParam,int tamanio,int numeropagina){
		recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
		int total=recursoInformacionDAO.contarSubConsulta(recursoInformacionParam);
		Pagination paginacion=new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
	
	public List<RecursoInformacion> consultarRecursoInformacionPaginado(RecursoInformacionParam recursoInformacionParam,int offset, int tamaniopagina){
		
		recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
		recursoInformacionParam.getRecursoinformacion().setFlagtemporal(ValueConstants.FLAG_ACTIVO);
		return recursoInformacionDAO.listarPaginadoSubConsulta(recursoInformacionParam, offset, tamaniopagina);
	}
	
    
	
    public List<RecursoInformacion> consultarRecursoInformacionPaginadoTemporales(RecursoInformacionParam recursoInformacionParam,int offset, int tamaniopagina){
		
		recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
		recursoInformacionParam.getRecursoinformacion().setFlagtemporal(ValueConstants.VALOR_CERO);
		return recursoInformacionDAO.listarPaginadoSubConsulta(recursoInformacionParam, offset, tamaniopagina);
	}
	
	
	
	/*
	public void generarCodigoRecursoInformacion(RecursoInformacion recursoinformacion){
	
		int numero= recursoInformacionDAO.obtenerNumeroDisponible();
		System.out.println("codigo generado");
		recursoinformacion.setNumerorecursoinformacion(numero);
	}
	*/

	public int guardarRecursoinformacion(RecursoInformacion recursoinformacion){
		int idrecurso=0;
		if(recursoinformacion.getIdrecursoinformacion()==0){
			//flag activo
			recursoinformacion.setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
			//insertar datos basicos recurso informacion
			recursoinformacion.setNumerorecursoinformacion(recursoInformacionDAO.obtenerNumeroDisponible());
			//recursoinformacion.setNumerorecursoinformacionarea(recursoInformacionDAO.obtenerNumeroAreaDisponible(recursoinformacion.getSedebiblioteca().getIdareanatural()));
			
			idrecurso=recursoInformacionDAO.insertar(recursoinformacion);
			//insertar editoriales
			for(RecursoInformacionEditorial rie:recursoinformacion.getListaRecursoInformacionEditorial()){
				rie.setIdrecursoinformacion(idrecurso);	
				recursoInformacionEditorialDAO.insertar(rie);
			}
			//insertar autores
			for(RecursoInformacionAutor ria:recursoinformacion.getListaRecursoInformacionAutor()){
				ria.setIdrecursoinformacion(idrecurso);	
				recursoInformacionAutorDAO.insertar(ria);
			}
			//insertar temas
			for(RecursoInformacionTema rit:recursoinformacion.getListaRecursoInformacionTema()){
				rit.setIdrecursoinformacion(idrecurso);	
				recursoInformacionTemaDAO.insertar(rit);
			}
			//insertar areas naturales involucradas
			for(RecursoInformacionAreanatural rian:recursoinformacion.getListaRecursoInformacionAreanatural()){
				rian.getRecursoinformacion().setIdrecursoinformacion(idrecurso);	
				recursoInformacionAreanaturalDAO.insertar(rian);
			}
			//insertar datos de aprobacion producto institucional
			//recursoinformacion.getAprobacionrecursoinformacion().setIdrecursoinformacion(idrecurso);
			//aprobacionRecursoInformacionDAO.insertar(recursoinformacion.getAprobacionrecursoinformacion());
			//insertar archivos
			
			for(RecursoInformacionArchivo rarch:recursoinformacion.getListaRecursoInformacionArchivo()){
				rarch.getRecursoinformacion().setIdrecursoinformacion(idrecurso);
				int idarchivo=0;
				if(rarch.getArchivo()!=null){
					idarchivo= archivoDAO.insertar(rarch.getArchivo());
					rarch.getArchivo().setIdarchivo(idarchivo);
				}
			    recursoInformacionArchivoDAO.insertar(rarch);
			}
			
			
		}
		else{
			
			
			//if(recursoinformacion.getFlagtemporal()!=0 ){
				if(recursoinformacion.getSedebiblioteca().getIdareanatural()!=0){
					recursoinformacion.setNumerorecursoinformacionarea(recursoInformacionDAO.obtenerNumeroAreaDisponible(recursoinformacion.getSedebiblioteca().getIdareanatural()));
				}
			
			
			recursoInformacionDAO.actualizar(recursoinformacion);
			idrecurso=recursoinformacion.getIdrecursoinformacion();
			
			//actualizar editoriales
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionEditorial().size();i++){
				recursoinformacion.getListaRecursoInformacionEditorial().get(i).setIdrecursoinformacion(recursoinformacion.getIdrecursoinformacion());
			}
			recursoInformacionEditorialDAO.eliminarDiferencia(recursoinformacion.getListaRecursoInformacionEditorial(), recursoinformacion.getIdrecursoinformacion());
			if(recursoinformacion.getListaRecursoInformacionEditorial().size()!=0){
					recursoInformacionEditorialDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionEditorial());
			}
			//actualizar autores
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionAutor().size();i++){
				recursoinformacion.getListaRecursoInformacionAutor().get(i).setIdrecursoinformacion(recursoinformacion.getIdrecursoinformacion());
			}
			recursoInformacionAutorDAO.eliminarDiferencia(recursoinformacion.getListaRecursoInformacionAutor(), recursoinformacion.getIdrecursoinformacion());
			if(recursoinformacion.getListaRecursoInformacionAutor().size()!=0){
					recursoInformacionAutorDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionAutor());
			}
			//actualizar temas
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionTema().size();i++){
				recursoinformacion.getListaRecursoInformacionTema().get(i).setIdrecursoinformacion(recursoinformacion.getIdrecursoinformacion());
			}
			recursoInformacionTemaDAO.eliminarDiferencia(recursoinformacion.getListaRecursoInformacionTema(), recursoinformacion.getIdrecursoinformacion());
			if(recursoinformacion.getListaRecursoInformacionTema().size()!=0){
					recursoInformacionTemaDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionTema());
			} 
			//actualizar areas naturales
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionAreanatural().size();i++){
				recursoinformacion.getListaRecursoInformacionAreanatural().get(i).getRecursoinformacion().setIdrecursoinformacion(recursoinformacion.getIdrecursoinformacion());
			}
			recursoInformacionAreanaturalDAO.eliminarDiferencia(recursoinformacion.getListaRecursoInformacionAreanatural(), recursoinformacion.getIdrecursoinformacion());
			if(recursoinformacion.getListaRecursoInformacionAreanatural().size()!=0){
					recursoInformacionAreanaturalDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionAreanatural());
			}
			
			//insertar o actualizar aprobacion
			if(recursoinformacion.getAprobacionrecursoinformacion().getPersonal().getIdpersonal()!=0){
				if(recursoinformacion.getAprobacionrecursoinformacion().getIdaprobacionrecursoinformacion()==0){
					recursoinformacion.getAprobacionrecursoinformacion().setIdrecursoinformacion(idrecurso);
					aprobacionRecursoInformacionDAO.eliminar(recursoinformacion.getAprobacionrecursoinformacion());
					aprobacionRecursoInformacionDAO.insertar(recursoinformacion.getAprobacionrecursoinformacion());
				}
				else{
					aprobacionRecursoInformacionDAO.actualizar(recursoinformacion.getAprobacionrecursoinformacion());
					
			    }
			}
			else
				{
				recursoinformacion.getAprobacionrecursoinformacion().setIdrecursoinformacion(idrecurso);
				aprobacionRecursoInformacionDAO.eliminar(recursoinformacion.getAprobacionrecursoinformacion());
				
				}
			
			
			//archivos
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionArchivo().size();i++){
				recursoinformacion.getListaRecursoInformacionArchivo().get(i).getRecursoinformacion().setIdrecursoinformacion(recursoinformacion.getIdrecursoinformacion());
			    if(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo()!=null){
			    	if(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().getIdarchivo()==0){
						int idarchivo= archivoDAO.insertar(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo());
						recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().setIdarchivo(idarchivo);
					}
				    //recursoInformacionArchivoDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionArchivo().get(i));
			    	  
			    }
			    
			    recursoInformacionArchivoDAO.actualizar(recursoinformacion.getListaRecursoInformacionArchivo().get(i)); 
			}
			//recursoInformacionArchivoDAO.eliminarDiferencia(recursoinformacion.getListaRecursoInformacionArchivo(), recursoinformacion.getIdrecursoinformacion());
			/*
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionArchivo().size();i++){
				recursoinformacion.getListaRecursoInformacionArchivo().get(i).getRecursoinformacion().setIdrecursoinformacion(recursoinformacion.getIdrecursoinformacion());
			    System.out.println("idrecarch"+recursoinformacion.getListaRecursoInformacionArchivo().get(i).getIdrecursoinformacionarchivo());
			    if(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().getIdarchivo()==0){
					int idarchivo= archivoDAO.insertar(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo());
					recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().setIdarchivo(idarchivo);
				}
			    recursoInformacionArchivoDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionArchivo().get(i));
			    //recursoInformacionArchivoDAO.actualizar(recursoinformacion.getListaRecursoInformacionArchivo().get(i));
			}
			*/
			/*
			recursoInformacionArchivoDAO.eliminarDiferencia(recursoinformacion.getListaRecursoInformacionArchivo(), recursoinformacion.getIdrecursoinformacion());
			for(int i=0;i<recursoinformacion.getListaRecursoInformacionArchivo().size();i++){
				if(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().getIdarchivo()==0){
					int idarchivo= archivoDAO.insertar(recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo());
					recursoinformacion.getListaRecursoInformacionArchivo().get(i).getArchivo().setIdarchivo(idarchivo);
					
					 
				}
				recursoInformacionArchivoDAO.insertarNoDuplicado(recursoinformacion.getListaRecursoInformacionArchivo().get(i));
				
			}
			*/
			/*
			for(RecursoInformacionArchivo rarch:recursoinformacion.getListaRecursoInformacionArchivo()){
				if(rarch.getArchivo().getIdarchivo()==0){
					int idarchivo=archivoDAO.insertar(rarch.getArchivo());
					//RecursoInformacionArchivo riarch=new RecursoInformacionArchivo();
					//riarch.getRecursoinformacion().setIdrecursoinformacion(rarch.getRecursoinformacion().getIdrecursoinformacion());
					rarch.getArchivo().setIdarchivo(idarchivo);
					//riarch.getArchivo().setIdarchivo(idarchivo);
					System.out.println("ant inser ra");
					recursoInformacionArchivoDAO.insertar(rarch);
					System.out.println("des inser ra");
				}
				
			}
			*/
			
		}
		return idrecurso;
	}
	
	
	
	public RecursoInformacion consultarRecursoInformacionxId(int idrecursoinformacion){
		RecursoInformacion ri=new RecursoInformacion();
		List<RecursoInformacion> lista=new ArrayList<RecursoInformacion>();
		RecursoInformacion r=new RecursoInformacion();
		r.setIdrecursoinformacion(idrecursoinformacion);
		r.setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
		r.setFlagtemporal(ValueConstants.FLAG_ACTIVO);
		lista=recursoInformacionDAO.listar(r);
		if(lista.size()==1){
			ri=lista.get(0);
			return ri;
		}else
		{
			return null;
		}
		
	}
	
	
	
	public void eliminarRecursosInformacion(List<Integer> lista){
		for(Integer i:lista){
			RecursoInformacion ri=new RecursoInformacion();
			ri.setIdrecursoinformacion(i);
			ri.setFlagrecursoinformacion(ValueConstants.VALOR_CERO);
			recursoInformacionDAO.actualizar(ri);
		}
		
	}
	
	
	public List<Categoriaanp> listarCategoriasAnpConRecursosInformacion(){
		
		return recursoInformacionAreanaturalDAO.listarCategoriaAnpxRecursoInformacion(new RecursoInformacionAreanatural());
	} 
	
    public List<Areanatural> listarAreasNaturalesConRecursosInformacion(){
		
		return recursoInformacionAreanaturalDAO.listarAreasNaturalesxRecursoInformacion(new RecursoInformacionAreanatural());
	} 
	
    
    public List<Areanatural> consultarAreasNaturalesConRecursosInformacionxCategoriaAnp(int idcategoriaanp){
		RecursoInformacionAreanatural rian=new RecursoInformacionAreanatural();
		rian.getAreanatural().getCategoriaanp().setIdcategoriaanp(idcategoriaanp);
		return recursoInformacionAreanaturalDAO.listarAreasNaturalesxRecursoInformacion(rian);
	} 
    
    
    public List<RecursoInformacion> consultarRecursosInformacion(RecursoInformacionParam recursoInformacionParam){
    	recursoInformacionParam.getRecursoinformacion().setFlagrecursoinformacion(ValueConstants.FLAG_ACTIVO);
    	return recursoInformacionDAO.listarSubConsulta(recursoInformacionParam);
    }
    

}
