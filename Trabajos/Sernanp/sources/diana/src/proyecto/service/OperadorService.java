package proyecto.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.OperadorDAO;
import proyecto.dao.PersonaDAO;
import proyecto.dao.PersonaJuridicaDAO;
import proyecto.dao.TurismoOperadorturismoDAO;
import proyecto.dao.UsuarioDAO;
import proyecto.param.OperadorParam;
import proyecto.util.GestorEnvioMail;
import proyecto.util.Pagination;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Areanatural;
import proyecto.vo.Operadorturismo;
import proyecto.vo.Persona;
import proyecto.vo.Personajuridica;
import proyecto.vo.Turismo;
import proyecto.vo.TurismoOperadorturismo;

@Service
public class OperadorService {
	@Autowired
	private OperadorDAO operadorDAO; 
	@Autowired
	private TurismoOperadorturismoDAO turismoOperadorturismoDAO; 
	@Autowired UsuarioDAO usuarioDAO; 
	@Autowired
	private PersonaDAO personaDAO;
	@Autowired
	private PersonaJuridicaDAO personaJuridicaDAO;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ParametroService parametroService;
	public List<Operadorturismo> listar()  {
		return operadorDAO.listar();  
	}
	
	public List<Operadorturismo> listar( int idarea)  {
		return operadorDAO.listar( idarea );  
	}
	
	
	
	
	public Pagination calcularPaginacion(Operadorturismo operadorturismo,int tamanio,int numeropagina){
		operadorturismo.setFlagregistro(ValueConstants.FLAG_ACTIVO);
		int total= operadorDAO.contar(operadorturismo);
		Pagination paginacion=new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
	public List<Operadorturismo> consultarOperadorTurismoPaginado(Operadorturismo operadorturismo,int offset, int tamaniopagina){
		operadorturismo.setFlagregistro(ValueConstants.FLAG_ACTIVO);
		return operadorDAO.listarPaginado(operadorturismo, offset, tamaniopagina) ;
    }
	
	
	
	public Pagination calcularPaginacion(OperadorParam operadorParam,int tamanio,int numeropagina){
		operadorParam.getOperadorturismo().setFlagregistro(ValueConstants.FLAG_ACTIVO);
		int total= operadorDAO.contar(operadorParam);
		Pagination paginacion=new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
	
	public List<Operadorturismo> consultarOperadorTurismoPaginado(OperadorParam operadorParam,int offset, int tamaniopagina){
		operadorParam.getOperadorturismo().setFlagregistro(ValueConstants.FLAG_ACTIVO); 
		return operadorDAO.listarPaginado(operadorParam, offset, tamaniopagina) ;
	    }
	
	public List<Operadorturismo> listarAgenciasDeViajexAreaNatural( int idareanatural)  {
		 TurismoOperadorturismo tot=new TurismoOperadorturismo();
		 tot.getOperadorturismo().setFlagregistro(ValueConstants.FLAG_ACTIVO);
		 tot.getTurismo().setIdareanatural(idareanatural);
		 tot.getOperadorturismo().setFlagagenciaviaje(ValueConstants.FLAG_ACTIVO);
		 return operadorDAO.listarxAreaNatural(tot);
	}
	
	public List<Operadorturismo> listarOperadoresTurismoxAreaNatural( int idareanatural)  {
		 TurismoOperadorturismo tot=new TurismoOperadorturismo();
		 tot.getOperadorturismo().setFlagregistro(ValueConstants.FLAG_ACTIVO);
		 tot.getTurismo().setIdareanatural(idareanatural);
		 return operadorDAO.listarxAreaNatural(tot);
	}
	
	
	public List<Operadorturismo> listarOperadoresTurismo()  {
		 return operadorDAO.listar(new Operadorturismo());
	}
	
	
    public List<Areanatural> consultarAreasNaturalesxIdOperadorTurismo(int idoperadorturismo){
		
    	TurismoOperadorturismo tot=new TurismoOperadorturismo();
    	tot.getOperadorturismo().setIdoperadorturismo(idoperadorturismo);
		return turismoOperadorturismoDAO.listarAreaNaturalxOperadorTurismo(tot);
		
	}
	
    public Operadorturismo consultarOperadorTurismoxIdUsuario(int idusuario){
    	Operadorturismo ot=new Operadorturismo();
    	ot.getUsuario().setIdUsuario(idusuario);
    	List<Operadorturismo> lista=operadorDAO.listar(ot);
    	if(lista.size()==1){
    		return lista.get(0);
    	}else{
    		return null;
    	}
    	
    }
    
       
    public Operadorturismo consultarOperadorTurismoxId(int idoperadorturismo){
    	Operadorturismo ot=new Operadorturismo();
    	List<Operadorturismo> lista=operadorDAO.listar(new Operadorturismo(idoperadorturismo));
    	if(lista.size()==1){
    		ot= lista.get(0);
    		//consultar anps con turismo
    		TurismoOperadorturismo tot=new TurismoOperadorturismo();
    		tot.getOperadorturismo().setIdoperadorturismo(ot.getIdoperadorturismo());
    		List<Turismo> listaanptur=turismoOperadorturismoDAO.listarAreaNaturalTurismoxOperadorTurismo(tot);
    		ot.setListaAnpturismo(listaanptur);
    	}
    	return ot;  	
    }
    
    
    public Operadorturismo consultarDatosOperadorTurismoxId(int idoperadorturismo){
    	Operadorturismo ot=new Operadorturismo();
    	List<Operadorturismo> lista=operadorDAO.listar(new Operadorturismo(idoperadorturismo));
    	if(lista.size()==1){
    		ot= lista.get(0);
    	}
    	return ot;  	
    }
    
//    public int generarUsuarioOperadorTurismo(Operadorturismo operadorturismo){
//    	String clave=RandomStringUtils.randomAlphanumeric(ValueConstants.LONGITUD_MINIMA_CADENA_ALEATORIA);
//    	System.out.println("clave"+clave);
//    	operadorturismo.getUsuario().setClave(clave);
//    	return guardarOperadorTurismo(operadorturismo);
//    }
    
    
    
    
//    public int generarUsuarioOperadorTurismo(Operadorturismo operadorturismo){
//    	
//    	int msg= guardarUsuarioOperadorTurismo(operadorturismo);
//    	if(msg==0){
//    		enviarClaveAlOperadorTurismo(op, operadorturismo.getUsuario().getClave());
//    	}
//    }
    
    public void enviarClaveAlOperadorTurismo(Operadorturismo operadorturismo){
    	//inicilizar correo
    	Map<String,String> mapParametros= parametroService.obtenerParametros();
	    String hostname=mapParametros.get(ValueConstants.SMTP_HOST_NAME);
	    String puerto=mapParametros.get(ValueConstants.SMTP_PORT);
	    String username=mapParametros.get(ValueConstants.SMTP_AUTH_USER);
	    String password=mapParametros.get(ValueConstants.SMTP_AUTH_PWD);
	    String remitente=mapParametros.get(ValueConstants.SMTP_FROM_ADDRESS);
	    int ssl= Integer.parseInt(mapParametros.get(ValueConstants.SMTP_SSL));
	    GestorEnvioMail.setearParametrosEnvio(hostname, puerto, username, password, remitente,ssl);
	    //redactar msg
	    String cuerpomsg=redactarMensajeCreacionUsuarioAlOperadorTurismo(operadorturismo);
	    //obtener asunto msg
	    String asuntomsg=mapParametros.get(ValueConstants.ASUNTO_MAIL_NEWUSEROPERADOR);
    	try {
			GestorEnvioMail.enviarMail(operadorturismo.getCorreopersonal(),asuntomsg,cuerpomsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
   
    
    
  
    public void enviarNuevaClaveAlOperadorTurismo(Operadorturismo operadorturismo){
    	//inicilizar correo
    	Map<String,String> mapParametros= parametroService.obtenerParametros();
	    String hostname=mapParametros.get(ValueConstants.SMTP_HOST_NAME);
	    String puerto=mapParametros.get(ValueConstants.SMTP_PORT);
	    String username=mapParametros.get(ValueConstants.SMTP_AUTH_USER);
	    String password=mapParametros.get(ValueConstants.SMTP_AUTH_PWD);
	    String remitente=mapParametros.get(ValueConstants.SMTP_FROM_ADDRESS);
	    int ssl= Integer.parseInt(mapParametros.get(ValueConstants.SMTP_SSL));
	    System.out.println("ssl"+operadorturismo.getCorreopersonal());
	    GestorEnvioMail.setearParametrosEnvio(hostname, puerto, username, password, remitente, ssl); 
	    //redactar msg
    	String cuerpomsg=redactarMensajeRestablecerClaveAlOperadorTurismo(operadorturismo);
	    //obtener asunto msg
    	String asuntomsg=mapParametros.get(ValueConstants.ASUNTO_MAIL_NEWCLAVEOPERADOR);
    	try {
			GestorEnvioMail.enviarMail(operadorturismo.getCorreopersonal(),asuntomsg,cuerpomsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    public String redactarMensajeRestablecerClaveAlOperadorTurismo(Operadorturismo operadorturismo){
    	Map<String,String> mapParametros= parametroService.obtenerParametros();
    	String rutaplantillamsg=mapParametros.get(ValueConstants.RUTA_MAIL_NEWCLAVEOPERADOR); 
    	return redactarMensajeAlOperadorTurismo(operadorturismo, rutaplantillamsg);
    	   	
    }
    
    
    public String redactarMensajeCreacionUsuarioAlOperadorTurismo(Operadorturismo operadorturismo){
    	Map<String,String> mapParametros= parametroService.obtenerParametros();
    	String rutaplantillamsg=mapParametros.get(ValueConstants.RUTA_MAIL_NEWUSEROPERADOR); 
    	//String rutaplantillamsg="/mail/mailnewuseroperador.htm";
    	return redactarMensajeAlOperadorTurismo(operadorturismo, rutaplantillamsg);
    	   	
    }
    
    
    public String redactarMensajeAlOperadorTurismo(Operadorturismo operadorturismo,String rutaplantillamsg ){
    	File file=new File(rutaplantillamsg);
    	String sfile=ProyectoUtil.fileToString(file);
    	Map pmail = new HashMap<String,String>();
    	pmail.put("username", operadorturismo.getUsuario().getUsername());
    	pmail.put("clave", operadorturismo.getUsuario().getClave());
    	pmail.put("nomboperador",operadorturismo.getNombrepersonajuridica());
    	//String templateString = "The ${animal} jumped over the ${target}.";
    	 StrSubstitutor sub = new StrSubstitutor(pmail);
    	 String sfileredactado = sub.replace(sfile);
		return sfileredactado;
    }
    
//    public int crearUsuarioOperadorTurismo(Operadorturismo operadorturismo){
//    	int mensaje=0;
//    	//generar clave
//    	String clave=RandomStringUtils.randomAlphanumeric(ValueConstants.LONGITUD_MINIMA_CADENA_ALEATORIA);
//		operadorturismo.getUsuario().setClave(clave);
//		//inserto usuario
//		operadorturismo.getUsuario().getRol().setIdrol(ValueConstants.ID_ROL_OPERADOR_TURISMO);
//		operadorturismo.getUsuario().setEstado(ValueConstants.FLAG_ACTIVO);
//		int idusuario=usuarioService.guardarUsuarioUnico(operadorturismo.getUsuario());
//		if(idusuario==0){
//			mensaje=ValueConstants.MENSAJE_NOMBRE_USUARIO_EXISTE;
//		}
//		else{
//			enviarClaveAlOperadorTurismo(operadorturismo);
//		}
//		return mensaje;
//    }
    
    public void modificarClaveOperadorTurismo(Operadorturismo operadorturismo){
    	String clave=RandomStringUtils.randomAlphanumeric(ValueConstants.LONGITUD_MINIMA_CADENA_ALEATORIA);
		operadorturismo.getUsuario().setClave(clave);
		usuarioService.modificarClaveUsuario(operadorturismo.getUsuario());
		enviarNuevaClaveAlOperadorTurismo(operadorturismo);
    }
    
    
//    public int guardarUsuarioOperadorTurismo(Operadorturismo operadorturismo){
//    	int mensaje=0;
//    	//genera clave por primera vez
//    	if(operadorturismo.getUsuario().getIdUsuario()==0){
//    		String clave=RandomStringUtils.randomAlphanumeric(ValueConstants.LONGITUD_MINIMA_CADENA_ALEATORIA);
//    		operadorturismo.getUsuario().setClave(clave);
//    	}
//   		operadorturismo.getUsuario().getRol().setIdrol(ValueConstants.ID_ROL_OPERADOR_TURISMO);
//		operadorturismo.getUsuario().setEstado(ValueConstants.FLAG_ACTIVO);
//		int idusuario=usuarioService.guardarUsuarioUnico(operadorturismo.getUsuario());
//		if(idusuario==0){
//			mensaje=ValueConstants.MENSAJE_NOMBRE_USUARIO_EXISTE;
//		}
//		//envia clave x primera vez
//		if(operadorturismo.getUsuario().getIdUsuario()==0){
//    		enviarClaveAlOperadorTurismo(operadorturismo.getCorreopersonal(), operadorturismo.getUsuario().getClave());
//    	}
//		return mensaje;
//    }
    
    
    public Personajuridica setearAtributosPersonaJuridica(Operadorturismo operadorturismo){
		Personajuridica pj=new Personajuridica();
		pj.setIdpersonajuridica(operadorturismo.getIdpersonajuridica());
		pj.setNombrepersonajuridica(operadorturismo.getNombrepersonajuridica());
		pj.setSiglas(operadorturismo.getSiglas());
		pj.setIdpersona(operadorturismo.getIdpersona());
		pj.setRuc(operadorturismo.getRuc());
		pj.setRazonsocial(operadorturismo.getRazonsocial());
		pj.getUbigeo().setIdubigeo(operadorturismo.getUbigeo().getIdubigeo());
		pj.setDireccion(operadorturismo.getDireccion());
		pj.setCorreopersonal(operadorturismo.getCorreopersonal());
		pj.setCorreoinstitucional(operadorturismo.getCorreoinstitucional());
		pj.setTelefono(operadorturismo.getTelefono());
		pj.getPais().setIdpais(operadorturismo.getPais().getIdpais());
		return pj;
			
	}
    
    
    public Persona setearAtributosPersona(Operadorturismo operadorturismo){
    	Persona per=new Persona();
    	per.setIdpersona(operadorturismo.getIdpersona());
		per.setDireccion(operadorturismo.getDireccion());
		per.setCorreopersonal(operadorturismo.getCorreopersonal());
		per.setCorreoinstitucional(operadorturismo.getCorreoinstitucional());
		per.setTelefono(operadorturismo.getTelefono());
		per.getPais().setIdpais(operadorturismo.getPais().getIdpais());
		per.setRuc(operadorturismo.getRuc());
		per.getUbigeo().setIdubigeo(operadorturismo.getUbigeo().getIdubigeo());
    	return per;
    	
    }
    
    public int guardarOperadorTurismo(Operadorturismo operadorturismo){
    	int mensaje=0;
    	//insertar operador
       if(operadorturismo.getIdoperadorturismo()==0){
    	       operadorturismo.setFlagregistro(ValueConstants.FLAG_ACTIVO);
        		operadorturismo.getUsuario().setEstado(ValueConstants.FLAG_ACTIVO);
    	       //genera clave
            	String clave=RandomStringUtils.randomAlphanumeric(ValueConstants.LONGITUD_MINIMA_CADENA_ALEATORIA);
        		operadorturismo.getUsuario().setClave(clave);
        		//inserto usuario
        		operadorturismo.getUsuario().getRol().setIdrol(ValueConstants.ID_ROL_OPERADOR_TURISMO);
        		operadorturismo.getUsuario().setEstado(ValueConstants.FLAG_ACTIVO);
        	  Persona per=new Persona();
        	  per.setRuc(operadorturismo.getRuc());
        	  boolean validausernameunico=usuarioService.validarUsuarioUnico(operadorturismo.getUsuario());
        	 // boolean validarucunico=personaService.validarRucUnico(per);
        	  if(validausernameunico){
        		 //if(validarucunico){
        			 //int idusuario=usuarioService.guardarUsuario(operadorturismo.getUsuario());
              	     int idoperadorturismo=0;
              			//inserta operador
                  		//operadorturismo.getUsuario().setIdUsuario(idusuario);
                  		Personajuridica pj=setearAtributosPersonaJuridica(operadorturismo);
                  		int idpersonajuridica=personaJuridicaDAO.insertarNoDuplicado(pj);
                  		operadorturismo.setIdpersonajuridica(idpersonajuridica);
                  		idoperadorturismo=operadorDAO.insertarNoDuplicado(operadorturismo);
                  		if(idoperadorturismo!=0){
                  			//inserta operador al area con turismo
                      		for(Turismo tur:operadorturismo.getListaAnpturismo()){
                      			TurismoOperadorturismo tot=new TurismoOperadorturismo();
                          		tot.getTurismo().setIdturismo(tur.getIdturismo());
                          		tot.getOperadorturismo().setIdoperadorturismo(idoperadorturismo);
                          		turismoOperadorturismoDAO.insertar(tot);
                      		}
                      		//enviar msg
                      		enviarClaveAlOperadorTurismo(operadorturismo);
                  		}
        		 //} 
        		 else{
        			 mensaje=ValueConstants.MENSAJE_RUC_EXISTE;
        		 }
        	  }	else{
        		  mensaje=ValueConstants.MENSAJE_NOMBRE_USUARIO_EXISTE;
        	  }
        		
        
        //actualizar operador		
    	}else{
    		Persona per=new Persona();
    		per.setRuc(operadorturismo.getRuc());
    		per.setIdpersona(operadorturismo.getIdpersona());
    		if(personaDAO.contarUnico(per)!=0){
    			mensaje=ValueConstants.MENSAJE_RUC_EXISTE;
    		}else{
    			int idoperadorturismo=operadorturismo.getIdoperadorturismo();
    			//actualiza persona
    			Persona persona=setearAtributosPersona(operadorturismo);
        		personaDAO.actualizar(persona);
        		//actualiza persona juridica
        		Personajuridica pj=new Personajuridica();
        		pj.setIdpersonajuridica(operadorturismo.getIdpersonajuridica());
        		pj.setNombrepersonajuridica(operadorturismo.getNombrepersonajuridica());
        		pj.setRazonsocial(operadorturismo.getRazonsocial());
        		pj.setSiglas(operadorturismo.getSiglas());
        		personaJuridicaDAO.actualizar(pj);
        		//actualiza anps con turismo
        		turismoOperadorturismoDAO.eliminarDiferencia(operadorturismo.getListaAnpturismo(),idoperadorturismo);
        		if(operadorturismo.getListaAnpturismo().size()!=0){
         			for(Turismo tur:operadorturismo.getListaAnpturismo()){
         				TurismoOperadorturismo tot=new TurismoOperadorturismo();
         				tot.getTurismo().setIdturismo(tur.getIdturismo());
         				tot.getOperadorturismo().setIdoperadorturismo(idoperadorturismo);
         				turismoOperadorturismoDAO.insertarNoDuplicado(tot);
         			}
         	    }
    		}
    		
    	}
    	return mensaje;
    }
	
    
    
    public void eliminarListadoOperadoresxId(List<Integer> lista){
		for(Integer i:lista){
			//elimina operador
			Operadorturismo op=new Operadorturismo();
			op.setIdoperadorturismo(i);
			op.setFlagregistro(ValueConstants.VALOR_CERO);
			operadorDAO.actualizar(op);
			//invalida usuario
			op.getUsuario().setEstado(ValueConstants.VALOR_CERO);
			operadorDAO.actualizarUsuario(op);
		}
	}
    
    
    
 
}
