package proyecto.action;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import proyecto.constants.ValueConstants;
import proyecto.service.AreaNaturalService;
import proyecto.service.OperadorService;
import proyecto.service.PersonaNaturalService;
import proyecto.service.UsuarioService;
import proyecto.vo.Modulo;
import proyecto.vo.RolModulo;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

 

public class LoginAction extends ActionSupport{

	  
	private static final long serialVersionUID = 1L;
	private String log;
    private Usuario usuario;
    private Map<String,Object> datos;
    private int paginalogin;
    public LoginAction(){
    	usuario=new Usuario();
    	datos=new HashMap<String, Object>();
    }
    
    
	public String Logueo()  {
		
		//Locale.setDefault(new Locale("es","PE"));
		String resultado="";
		//System.out.println("usuario"+usuario.getUsername());
		//System.out.println("clave"+usuario.getClave());
		boolean existe=false;	
        existe=usuarioService.verificarUsuario(usuario);
                        
	    if(existe){
	    	Usuario u=new Usuario();
			u=usuarioService.consultarUsuario(usuario);
			usuarioService.consultarModulosxUsuario(u);
			addUserSession(u);
						
        	if(u.getPersonal().getIdpersonal()==0){
   	  			if(paginalogin==1 && u.getRol().getListaRolModulo().get(0).getRol().getFlagrol().equals(String.valueOf(paginalogin))){
   	  				resultado="portadaoperadorturismo";
   	  			}else if(paginalogin==2 && u.getRol().getListaRolModulo().get(0).getRol().getFlagrol().equals(String.valueOf(paginalogin))){
   	  				resultado="portadaregistro";
   	  			}else if(paginalogin==3 && u.getRol().getListaRolModulo().get(0).getRol().getFlagrol().equals(String.valueOf(paginalogin))){
   	  				resultado="portadasaddde";
   	  			}else if(paginalogin==4){
   	  				resultado="portadaredcap";
   	  			}else if(paginalogin==5){
   	  				resultado="portadaconvoca";
   	  			}else {
   	  				if(paginalogin==0)resultado="errorOperador";
   	  				if(paginalogin==1)resultado="errorPersonal";
   	  				if(paginalogin==2)resultado="errorRegistro";
   	  				if(paginalogin==3)resultado="errorSaddde";
   	  				if(paginalogin==4)resultado="errorRedcap";
   	  				if(paginalogin==5)resultado="errorConvoca";
   	  				
   	  			//ServletActionContext.getRequest().setAttribute("error2", "Error Usuario/Password");
   	  			//ServletActionContext.getRequest().setAttribute("error", "Ingrese por la pantalla correcta");
   	  			ServletActionContext.getRequest().setAttribute("error", "Error Usuario/Password");
   	  			}
	  		}
	  		else{
	  			if(paginalogin==0){
	  				resultado="success";
	  			}else if(paginalogin == 1){
	  					resultado="errorPersonal";
	  			}else if(paginalogin == 2){
	  					resultado="errorRegistro";
	  			}else if(paginalogin == 3){
  					resultado="errorSaddde";
	  			}else if(paginalogin == 4){
  					resultado="errorRedcap";
	  			}else if(paginalogin == 5){
  					resultado="errorConvoca";
	  			}
	  				
	  			//ServletActionContext.getRequest().setAttribute("error2", "Error Usuario/Password");
	  			//ServletActionContext.getRequest().setAttribute("error", "Ingrese por la pantalla correcta");
	  			ServletActionContext.getRequest().setAttribute("error", "Error Usuario/Password");
	  			}
	  			
	  			
	  		}
	  	  
        else{
        	
        	if(paginalogin==1){
        		resultado="errorPersonal";
   	  		}else if(paginalogin==2){
        		resultado="errorRegistro";
   	  		}else if(paginalogin==3){
        		resultado="errorSaddde";
   	  		}else if(paginalogin==4){
        		resultado="errorRedcap";
   	  		}else if(paginalogin==5){
        		resultado="errorConvoca";
   	  		}else if(paginalogin==0){
        		resultado="errorOperador";        		
   	  		}
        	
        	//ServletActionContext.getRequest().setAttribute("error2", "Error Usuario/Password");
			ServletActionContext.getRequest().setAttribute("error", "Error Usuario/Password");
			
		}	                          
		return resultado;	
	}
	
	
	
	public void addUserSession(Usuario usuario){
		HttpSession session =ServletActionContext.getRequest().getSession();
		List<Modulo> listaMenuActual=new ArrayList<Modulo>();
		
		for(RolModulo rm:usuario.getRol().getListaRolModulo()){
			if(rm.getModulo().getNiveldependemodulo()==0){
								
				Modulo mod=new Modulo();
				mod=rm.getModulo();
				listaMenuActual.add(mod);				
			}			
		}
		/*
		for(Modulo m:listaMenuActual){
			System.out.println("nom mod"+m.getNombremodulo());
		}
		*/
		Date factual=new Date();
		session.setAttribute("USUARIO_ACTUAL", usuario);
		
		if(usuario.getPersonal().getIdpersonal()==0){
			//Operadorturismo ot=operadorService.consultarOperadorTurismoxIdUsuario(usuario.getIdUsuario());
			if(paginalogin==1 || paginalogin==2){
				session.setAttribute("operadorturismo",operadorService.consultarOperadorTurismoxIdUsuario(usuario.getIdUsuario()));
				session.setAttribute("paginalogin", paginalogin);
			}else if(paginalogin==3 || paginalogin==4 || paginalogin==5){
				
				session.setAttribute("usuarioexterno",personanaturalService.listarPersonaNaturalxID(usuario.getPersona().getIdpersona()));
				session.setAttribute("paginalogin", paginalogin);
			}
				
		}
		else{
			session.setAttribute("area",  areaNaturalService.consultarAreasNaturalxId(usuario.getAreaorganica().getSede().getAreanatural().getIdareanatural()) );
		}
		session.setAttribute("idmoduloactual", 0);
		session.setAttribute("listaMenuActual", listaMenuActual);
		session.setAttribute("fechaActual", factual);
		
	}
	
	public void addUrlApplication(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String,Object> mapApp =ServletActionContext.getContext().getApplication();
		try {
			URL u = new URL(request.getRequestURL().toString());
			String url=u.getProtocol()+"://"+request.getHeader("Host")+request.getContextPath()+"/";
	        //System.out.println("url:"+url);
			mapApp.put("url",url );
	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
	public String modificarClaveUsuario(){
		 Map<String, Object> session = ActionContext.getContext().getSession();
		 HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		 String clave1=String.valueOf(request.getParameter("clave1"));
		 String clave2=String.valueOf(request.getParameter("clave2"));
    	 String clave3=String.valueOf(request.getParameter("clave3"));
		 Usuario u=(Usuario) session.get("USUARIO_ACTUAL");
		 int respuesta=0;
		 if(u.getPersonal().getIdpersonal()==0){
			Usuario user=new Usuario();
			user.setUsername(u.getUsername());
			user.setClave(clave1);
			boolean clavecorrecta=false;
			clavecorrecta= usuarioService.verificarUsuario(user);
			if(!clavecorrecta){
				respuesta=1;
			}else{
			
				if(!clave2.equals(clave3)){
		    		 //System.out.println("dist clave");
		    		 respuesta=2;
		    	 }else{
		    		 Usuario usu=new Usuario();
		    		 usu.setIdUsuario(u.getIdUsuario());
		    		 usu.setClave(clave2);
		    		 usu.setLoginfirst(ValueConstants.FLAG_ACTIVO);
		    		//System.out.println("camb id"+usu.getIdUsuario());
		    		//System.out.println("camb clave"+usu.getClave());
		    		
		    		 usuarioService.modificarClaveUsuario(usu);
		       	 }
				
				
			}
			
	    	 
	    	 
	         datos.put("respuesta", respuesta);	 
			
			
			
		}
		return "success";
	}
	
	
	
	
	@Autowired 
	private UsuarioService usuarioService;
	@Autowired 
	private AreaNaturalService areaNaturalService;
	@Autowired 
	private OperadorService operadorService;
	@Autowired 
	private PersonaNaturalService personanaturalService;

	
	


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setLog(String log) {
		this.log = log;
	}

	public String getLog() {
		return log;
	}


	public Map<String, Object> getDatos() {
		return datos;
	}


	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}


	public int getPaginalogin() {
		return paginalogin;
	}


	public void setPaginalogin(int paginalogin) {
		this.paginalogin = paginalogin;
	}	
 
}