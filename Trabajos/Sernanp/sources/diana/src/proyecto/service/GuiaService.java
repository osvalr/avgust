package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.GuiaDAO;
import proyecto.dao.PersonaDAO;
import proyecto.dao.PersonaNaturalDAO;
import proyecto.dao.TurismoGuiaDAO;
import proyecto.param.GuiaParam;
import proyecto.util.Pagination;
import proyecto.vo.Guia;
import proyecto.vo.Persona;
import proyecto.vo.Personanatural;
import proyecto.vo.Turismo;
import proyecto.vo.TurismoGuia;

@Service
public class GuiaService {
	@Autowired
	private GuiaDAO guiaDAO; 
	@Autowired
	private TurismoGuiaDAO turismoGuiaDAO;
	@Autowired
	private PersonaNaturalDAO personaNaturalDAO;
	@Autowired
	private PersonaDAO personaDAO;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private PersonaNaturalService personaNaturalService;
	
	
	public List<Guia> listar()  {
		return guiaDAO.listar(); 
	}
	      
	public List<Guia> listar( int idarea )  {
		return guiaDAO.listar( idarea ); 
	}
	
	 
	public List<Guia> listarGuiaxNombreCompleto(TurismoGuia turismoguia){
		turismoguia.getGuia().setFlagguia(ValueConstants.FLAG_ACTIVO);
		return turismoGuiaDAO.listarGuiaUnicoxAreaNatural(turismoguia);
	}
	
	
	
	public Pagination calcularPaginacion(GuiaParam guiaParam,int tamanio,int numeropagina){
		guiaParam.getGuia().setFlagguia(ValueConstants.FLAG_ACTIVO);
		int total= guiaDAO.contar(guiaParam);
		Pagination paginacion=new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
	
	public List<Guia> consultarGuiaTurismoPaginado(GuiaParam guiaParam,int offset, int tamaniopagina){
		guiaParam.getGuia().setFlagguia(ValueConstants.FLAG_ACTIVO); 
		return guiaDAO.listarPaginado(guiaParam, offset, tamaniopagina);	
	}
	
	
	
	public Personanatural setearAtributosPersonaNatural(Guia guia){
		Personanatural pnat=new Personanatural();
		pnat.setIdpersonanatural(guia.getIdpersonanatural());
		pnat.setNombre(guia.getNombre());
		pnat.setApepat(guia.getApepat());
		pnat.setApemat(guia.getApemat());
		pnat.getTipodocumento().setIdtipo(guia.getTipodocumento().getIdtipo());
		pnat.setNumerodocumento(guia.getNumerodocumento());
		pnat.setIdpersona(guia.getIdpersona());
		pnat.getSexo().setIdtipo(guia.getSexo().getIdtipo());
		pnat.setFechanacimiento(guia.getFechanacimiento());
		pnat.getEstadocivil().setIdtipo(guia.getEstadocivil().getIdtipo());
		pnat.getUbigeo().setIdubigeo(guia.getUbigeo().getIdubigeo());
		pnat.setDireccion(guia.getDireccion());
		pnat.setRuc(guia.getRuc());
		pnat.setCorreopersonal(guia.getCorreopersonal());
		pnat.setCorreoinstitucional(guia.getCorreoinstitucional());
		pnat.setTelefono(guia.getTelefono());
		pnat.getPais().setIdpais(guia.getPais().getIdpais());
		return pnat;
			
	}
	
	
	public Persona setearAtributosPersona(Guia guia){
		Persona per=new Persona();
		per.setIdpersona(guia.getIdpersona());
		per.getUbigeo().setIdubigeo(guia.getUbigeo().getIdubigeo());
		per.setDireccion(guia.getDireccion());
		per.setRuc(guia.getRuc());
		per.setCorreopersonal(guia.getCorreopersonal());
		per.setCorreoinstitucional(guia.getCorreoinstitucional());
		per.setTelefono(guia.getTelefono());
		per.getPais().setIdpais(guia.getPais().getIdpais());
		return per;
			
	}
	
	public Guia consultarGuiaTurismoxId(int idguia){
    	Guia g=new Guia();
    	List<Guia> lista=guiaDAO.listar(new Guia(idguia));
    	if(lista.size()==1){
    		g= lista.get(0);
    		//consultar anps con turismo
    		TurismoGuia tg=new TurismoGuia();
    		tg.getGuia().setIdguia(g.getIdguia());
    		List<Turismo> listaanptur=turismoGuiaDAO.listarAreaNaturalTurismoxGuia(tg);
    		g.setListaAnpturismo(listaanptur);
    	}
    	return g;  	
    }
	
	
	public int guardarGuiaTurismo(Guia guia){
		int mensaje=0;
		
		//insertar
		if(guia.getIdguia()==0){
			guia.setFlagguia(ValueConstants.FLAG_ACTIVO);
			Personanatural pnatudoc=new Personanatural();
			pnatudoc.setNumerodocumento(guia.getNumerodocumento());
			//boolean validanumdocunico=personaNaturalService.validarNumeroDocumentoUnico(pnatudoc);
			//if(validanumdocunico){
				Personanatural pnat=setearAtributosPersonaNatural(guia);
				int idpnat= personaNaturalDAO.insertarNoDuplicado(pnat);
				//Guia g=new Guia();
				guia.setIdpersonanatural(idpnat);
				int idguia= guiaDAO.insertarNoDuplicado(guia);
				if(idguia!=0){
					//inserta operador al area con turismo
		      		for(Turismo tur:guia.getListaAnpturismo()){
		      			TurismoGuia tg=new TurismoGuia();
		          		tg.getTurismo().setIdturismo(tur.getIdturismo());
		      			tg.getGuia().setIdguia(idguia);
		          		turismoGuiaDAO.insertar(tg); 
		          	}
				}else{
					mensaje=ValueConstants.MENSAJE_GUIA_EXISTE;
				}
//			}else{
//				mensaje=ValueConstants.MENSAJE_DNI_EXISTE;
//			}			
		//actualizar	
		}else{
			int idguia=guia.getIdguia();
			Personanatural pnatudoc=new Personanatural();
    		pnatudoc.setNumerodocumento(guia.getNumerodocumento());
    		pnatudoc.setIdpersonanatural(guia.getIdpersonanatural());
    		boolean validanumdocunico=personaNaturalService.validarNumeroDocumentoUnico(pnatudoc);
    		if(validanumdocunico){
				//actualiza persona
				Persona per=setearAtributosPersona(guia);
        		personaDAO.actualizar(per);
        		//actualiza persona natural
        		Personanatural pnat=setearAtributosPersonaNatural(guia);
        		personaNaturalDAO.actualizar(pnat);
        		//actualizar guia
        		guiaDAO.actualizar(guia);
        		//actualiza anps con turismo
        		turismoGuiaDAO.eliminarDiferencia(guia.getListaAnpturismo(), idguia);
        		if(guia.getListaAnpturismo().size()!=0){
         			for(Turismo tur:guia.getListaAnpturismo()){
         				TurismoGuia tg=new TurismoGuia();
         				tg.getTurismo().setIdturismo(tur.getIdturismo());
         				tg.getGuia().setIdguia(idguia);
         				turismoGuiaDAO.insertarNoDuplicado(tg);
         			}
         	    }
			}else{
				mensaje=ValueConstants.MENSAJE_DNI_EXISTE;
			}
			
		}
		return mensaje;
		
	}
	
	
	public void eliminarListadoGuiasxId(List<Integer> lista){
		for(Integer i:lista){
			Guia g=new Guia();
			g.setIdguia(i);
			g.setFlagguia(ValueConstants.VALOR_CERO);
			guiaDAO.actualizar(g);
			
		}
	}
	
	
}
