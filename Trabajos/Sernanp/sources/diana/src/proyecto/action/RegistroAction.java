package proyecto.action;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts2.ServletActionContext;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import proyecto.excel.ProcesarDatosHoja;
import proyecto.quartz.QuartzJob;
import proyecto.service.AreaNaturalService;
import proyecto.service.DirectorioArchivoService;
import proyecto.service.DirectorioarchivoModuloService;
import proyecto.service.FichaRegistroService;
import proyecto.service.HistorialJefesAnpService;
import proyecto.service.OperadorService;
import proyecto.service.PersonaJuridicaService;
import proyecto.service.PersonaNaturalService;
import proyecto.service.PersonalFichaRegistroService;
import proyecto.service.PersonalRegistroService;
import proyecto.service.TipoService;
import proyecto.util.Funciones;
import proyecto.vo.Areanatural;
import proyecto.vo.DirectorioarchivoModulo;
import proyecto.vo.FichaRegistro;
import proyecto.vo.HistorialJefesAnp;
import proyecto.vo.Operadorturismo;
import proyecto.vo.Personajuridica;
import proyecto.vo.PersonalFichaRegistro;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;
import proyecto.vo.Tipo;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class RegistroAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cadena;
	
	private List<Areanatural> listaAreanatural;
	
	private HashMap<String, Object> datos;
	
	@Autowired
	private AreaNaturalService areaNaturalService;
	@Autowired
	private OperadorService operadorService;
	@Autowired
	private PersonaNaturalService personanaturalService;
	@Autowired
	private PersonaJuridicaService personaJuridicaService;
	@Autowired
	private PersonalRegistroService personalregistroService;
	@Autowired
	private TipoService tipoService;
	@Autowired
	private FichaRegistroService ficharegistroService;
	@Autowired
	private PersonalFichaRegistroService personalficharegistroService;
	@Autowired
	private HistorialJefesAnpService historialjefesanpService;
	@Autowired
	private DirectorioarchivoModuloService directorioarchivomoduloService;
	@Autowired
	private DirectorioArchivoService directorioarchivoService;
	
	private Areanatural areanatural;
	private Operadorturismo operadorturismo;
	private Personajuridica personajuridica;
	private Personanatural personanatural;	
	private FichaRegistro ficharegistro;
	private PersonalFichaRegistro personalficharegistro;
	private HistorialJefesAnp historialjefesanp;
			
	private String[] numerodocumento;
	private String nombrearchivo;
	private int paramidmodulo;
	
	private List<PersonalRegistro> datosp;
	private List<PersonalRegistro> personalregistro;
	
	private List<PersonalFichaRegistro> listapersonalficharegistro;
	
	private List<Tipo> tipodocumento;
	private List<Tipo> tipogenero;
	private List<Tipo> tipolocal;
	private List<Tipo> tipomediotra;
	private List<Tipo> tipomediotraedit;
	private LinkedHashMap<String, String> tipos;
	
	private List<FichaRegistro> listaficharegistro;
	
	
	private InputStream inputStream;
	
	
	
	public RegistroAction(){
		areanatural = new Areanatural();
		operadorturismo = new Operadorturismo();
		personajuridica = new Personajuridica();
		personanatural = new Personanatural();
		
		ficharegistro = new FichaRegistro();
		personalficharegistro = new PersonalFichaRegistro();
		
		personalregistro = new ArrayList<PersonalRegistro>();
		
		listapersonalficharegistro = new ArrayList<PersonalFichaRegistro>();
		
		datos = new HashMap<String, Object>();
		datosp = new ArrayList<PersonalRegistro>();		
		tipomediotra = new ArrayList<Tipo>();
		tipomediotraedit = new ArrayList<Tipo>();
		
		listaficharegistro =new ArrayList<FichaRegistro>();
	}
	
	public String execute()  {
					
		return SUCCESS;
	}
	
	public String ingresoComoExterno(){
			
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		Operadorturismo ot = (Operadorturismo) session.get("operadorturismo");
		listaAreanatural = operadorService.consultarAreasNaturalesxIdOperadorTurismo(ot.getIdoperadorturismo());
		
		
		int idareanat = listaAreanatural.get(0).getIdareanatural();
		session.put("area",areaNaturalService.consultarAreasNaturalxId(idareanat));
		
		session.put("noMuestraMenu", 0);
		
		return "success";
			
	}
	
	
	public String irAreaNaturalConRegistro() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		int idareanat = Integer.parseInt(String.valueOf(request
				.getParameter("idarea")));
		session.put("area",
				areaNaturalService.consultarAreasNaturalxId(idareanat));
		return SUCCESS;
	}
	
	
	public String listarAreasNaturalesRegistroIngreso() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		Operadorturismo ot = (Operadorturismo) session.get("operadorturismo");
		listaAreanatural = operadorService
				.consultarAreasNaturalesxIdOperadorTurismo(ot
						.getIdoperadorturismo());
		session.put("noMuestraMenu", 1);
		return "success";
	}
	
	
	public String registroFormulario(){		
				
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
				
		Map<String, Object> session = ActionContext.getContext().getSession();
		//Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		
		//request.setAttribute("fechaactual", Funciones.fechaSiguiente("M-d-yyyy"));
		request.setAttribute("fechaactual", Funciones.fechaSiguiente("yyyy-MM-dd"));	
		
		Operadorturismo ot = (Operadorturismo) session.get("operadorturismo");
		
		personajuridica = personaJuridicaService.listarPersonaJuridica(ot.getIdpersonajuridica());
		personanatural=personanaturalService.listarPersonaNaturalxID(personajuridica.getIdpersona()); 
		areanatural = (Areanatural) session.get("area");
						
		tipomediotra = tipoService.listarMediosTransporte();
		
		
		return SUCCESS;
	}
	
	public String mantenimientoPersonal(){
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		
		//request.setAttribute("fechaactual", Funciones.fechaHoy("M-d-yyyy"));
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		areanatural = (Areanatural) session.get("area");

		tipodocumento = tipoService.listarTipoDocumentoIdentidad();
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
        
        
        tipos = new LinkedHashMap<String, String>();
        
        for(Tipo t1 : tipodocumento){
        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
        }        
        for(Tipo t2 : tipogenero){        	
        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
        }        
        for(Tipo t3 : tipolocal){        	
        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
        }
		
		datosp = personalregistroService.listarPersonalxPJyAN(operadorturismo.getIdpersonajuridica(),areanatural.getIdareanatural());
		
		return SUCCESS;
	}


	public String listadoFormularioEnvio(){	
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural = (Areanatural) session.get("area");
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		
		
		listaficharegistro = ficharegistroService.listarEnviados(areanatural,operadorturismo);				
		
		return SUCCESS;
	}
	
	public String listadoFormularioEnvioxArea(){		
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural = (Areanatural) session.get("area");			
		
		listaficharegistro = ficharegistroService.listarEnviadosxAreaNatural(areanatural);
		
		return SUCCESS;
	}
	
	public String listadoFormularioAprobEnvioxArea(){	
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural = (Areanatural) session.get("area");		
		
		listaficharegistro = ficharegistroService.listarAprobadosxAreaNatural(areanatural);
		
		return SUCCESS;
	}
	
	
	
	public String buscarPersona() {
		
		//HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//cadena = request.getParameter("term");
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		areanatural = (Areanatural) session.get("area");
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		
		PersonalRegistro pn = new PersonalRegistro();
		pn.setApepat(cadena);
		pn.setApemat(cadena);
		pn.setNombre(cadena);
		//pn.getPersonaRegistro.setIdareanatural(areanatural.getIdareanatural());
		List<PersonalRegistro> listapersonalreg = personalregistroService.listarPersonaxNombreCompleto(operadorturismo.getIdpersonajuridica(), areanatural.getIdareanatural(),pn);
		
		tipodocumento = tipoService.listarTipoDocumentoIdentidad();
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
        
        
        tipos = new LinkedHashMap<String, String>();
        
        for(Tipo t1 : tipodocumento){
        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
        }        
        for(Tipo t2 : tipogenero){        	
        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
        }        
        for(Tipo t3 : tipolocal){        	
        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
        }
		
		datos.put("person", listapersonalreg);
		datos.put("tipos", tipos);
		
				
		return "success";
	}
	
	public String insertarPersonalExcel(){
	
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		
		
		Operadorturismo ot = (Operadorturismo) session.get("operadorturismo");
		Areanatural areanatural = (Areanatural) session.get("area");
		
		//String filePath = "/home/yonny/tmp/";
		//String filePath = "/tmp/";
		String filePath = getText("ruta.tmp");
		
		filePath += this.nombrearchivo;		
				
        ProcesarDatosHoja hoja = new ProcesarDatosHoja();
        List<PersonalRegistro> lista = new ArrayList<PersonalRegistro>();
        try {
			datosp = hoja.cargarDatos(filePath, 0);
			
			for(PersonalRegistro pr : datosp){
				if( Funciones.in_array(numerodocumento, pr.getNumerodocumento()) ){
					pr.setOperadorturismo(ot);
					pr.setAreanatural(areanatural);
					lista.add(pr);
				}
			}
			
		
		personalregistroService.guardarPersonal(lista);
		
		this.eliminarFileTmp(filePath);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("Lo sentimos, no se pudo registrar su información, por favor vuelva a intentarlo o comuniquese con su administrador.");
									
			return ERROR;
		}
		
		
		return SUCCESS;
		
	}
	
	
public void eliminarFileTmp(String fileName){
	File f = new File(fileName);
	
	if (!f.exists())
	      throw new IllegalArgumentException(
	          "Delete: no such file or directory: " + fileName);

	    if (!f.canWrite())
	      throw new IllegalArgumentException("Delete: write protected: "
	          + fileName);

	    // If it is a directory, make sure it is empty
	    if (f.isDirectory()) {
	      String[] files = f.list();
	      if (files.length > 0)
	        throw new IllegalArgumentException(
	            "Delete: directory not empty: " + fileName);
	    }

	    // Attempt to delete it
	    boolean success = f.delete();

	    if (!success)
	      throw new IllegalArgumentException("Delete: deletion failed");
	
	
}
	
public String registrarFicha() throws Exception{
		
		try{
		//HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		areanatural = (Areanatural) session.get("area");
		
		ficharegistro.setOperadorturismo(operadorturismo);
		ficharegistro.setAreanatural(areanatural);
		ficharegistro.setTipomediotra(tipomediotra);
						
		ficharegistro.setPersonalregistro(personalregistro);
		
		Timestamp fechaHoy = Funciones.fechaHoyTimeStamp();
		
		ficharegistro.setFechacreacion(fechaHoy);
	
		int horas = Integer.valueOf( getText("cant.horas.aprob") );
		
		ficharegistro.setFechaaprobsys(Funciones.sumaHoras(fechaHoy, horas, true));
		
		personajuridica = personaJuridicaService.listarPersonaJuridica(operadorturismo.getIdpersonajuridica());		
		ficharegistro.setPersonajuridica(personajuridica);
		
		//String codigoficha = ficharegistroService.guardarFicha(ficharegistro);
		Map mr = ficharegistroService.guardarFicha(ficharegistro);
		
		String codigoficha = (String)mr.get("codigoficha");
		
		ficharegistro.setCodigoficha(codigoficha);
		
		ficharegistro.setIdficharegistro(Integer.valueOf( mr.get("idficharegistro").toString() ));
		
		historialjefesanp = historialjefesanpService.listarActualJefe(areanatural).get(0);
		
		this.programadorTareaApruebaFicha(ficharegistro);
		
		addActionMessage("Formulario Registrado con &Eacute;xito!!!<br><br>");		
		addActionMessage("Código de Registro: "+ficharegistro.getCodigoficha()+"<br><br>");		
		
		if( ficharegistroService.enviarMailConfirmacionRegistro(ficharegistro, historialjefesanp) ){			
			addActionMessage("Se remiti&oacute; la confirmaci&oacute;n al correo electr&oacute;nico : "+personajuridica.getCorreoinstitucional());
		}else{
			addActionError("Hubieron problemas al remitir la confirmaci&oacute;n al correo electr&oacute;nico : "+personajuridica.getCorreoinstitucional());
		}	
		
		}catch(Exception e){
			e.printStackTrace();
			addActionError("Lo sentimos, no se pudo registrar el formulario, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");			
		}
		
		return SUCCESS;
	}
	
public String actualizarFicha() throws Exception{
		try{
		//HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		areanatural = (Areanatural) session.get("area");
		
		ficharegistro.setOperadorturismo(operadorturismo);
		ficharegistro.setAreanatural(areanatural);
		ficharegistro.setTipomediotra(tipomediotra);
								
		ficharegistro.setPersonalregistro(personalregistro);
		ficharegistro.setFechacreacion(Funciones.fechaHoyTimeStamp());
					
		ficharegistroService.actualizarFicha(ficharegistro);		
		
		addActionMessage("Ficha Actualizada con &Eacute;xito!!!");		
		
		}catch(Exception e){
			addActionError("Lo sentimos, no se pudo registrar su informaci&oacute;n, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");			
		}
		
		return SUCCESS;
	}

public String consolidarFicha() throws Exception{
	try{
	
	
	personalficharegistroService.consolidarFicha(listapersonalficharegistro);		
	
	addActionMessage("Ficha Consolidada con &Eacute;xito!!!");		
	
	}catch(Exception e){
		e.printStackTrace();
		addActionError("Lo sentimos, no se pudo registrar su informaci&oacute;n, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");			
	}
	
	return SUCCESS;
}
	
	public String mostrarFichaFormulario(){
		
				
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
						
		//request.setAttribute("fechaactual", Funciones.fechaSiguiente("M-d-yyyy"));
		request.setAttribute("fechaactual", Funciones.fechaSiguiente("yyyy-MM-dd"));
		
		Operadorturismo ot = (Operadorturismo) session.get("operadorturismo");
		
		personajuridica = personaJuridicaService.listarPersonaJuridica(ot.getIdpersonajuridica());
		personanatural=personanaturalService.listarPersonaNaturalxID(personajuridica.getIdpersona()); 
		areanatural = (Areanatural) session.get("area");
						
		ficharegistro = ficharegistroService.muestraFichaFormulario(ficharegistro.getIdficharegistro());
		
		tipomediotra = tipoService.listarMediosTransporte();
		
		tipomediotraedit = tipoService.listarMediosTransporteFichaRegistro(ficharegistro.getIdficharegistro());
		
		tipodocumento = tipoService.listarTipoDocumentoIdentidad();
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
        
        
        tipos = new LinkedHashMap<String, String>();
        
        for(Tipo t1 : tipodocumento){
        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
        }        
        for(Tipo t2 : tipogenero){        	
        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
        }        
        for(Tipo t3 : tipolocal){        	
        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
        }
		
		personalregistro = personalregistroService.listarPersonalxFicha(ficharegistro.getIdficharegistro());
		
		StringBuffer arregloidpr = new StringBuffer();
		for(PersonalRegistro p : personalregistro){
			arregloidpr.append(p.getIdpersonalregistro());
			arregloidpr.append(",");
		}
		arregloidpr.append("");
		
		request.setAttribute("arregloidpr",arregloidpr.toString());
		
								
		return SUCCESS;
	}

	
public String mostrarFichaFormularioAprob(){
		
		//HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();						
				 
		areanatural = (Areanatural) session.get("area");
						
		ficharegistro = ficharegistroService.muestraFichaFormulario(ficharegistro.getIdficharegistro());
		personajuridica = personaJuridicaService.listarPersonaJuridica(ficharegistro.getOperadorturismo().getIdpersonajuridica());
		personanatural=personanaturalService.listarPersonaNaturalxID(personajuridica.getIdpersona());
		
		tipomediotra = tipoService.listarMediosTransporte();
		
		tipomediotraedit = tipoService.listarMediosTransporteFichaRegistro(ficharegistro.getIdficharegistro());
		
		tipodocumento = tipoService.listarTipoDocumentoIdentidad();
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
        
        
        tipos = new LinkedHashMap<String, String>();
        
        for(Tipo t1 : tipodocumento){
        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
        }        
        for(Tipo t2 : tipogenero){        	
        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
        }        
        for(Tipo t3 : tipolocal){        	
        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
        }
		
		personalregistro = personalregistroService.listarPersonalxFicha(ficharegistro.getIdficharegistro());
		
		
		for(PersonalRegistro pr : personalregistro){			
			personalficharegistroService.datosConsolidado(ficharegistro,pr);			
		}
										
		return SUCCESS;
	}
	

	public String agregarPersonalRegistro(){
		
		tipodocumento = tipoService.listarTipoDocumentoIdentidad();		
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
		
        		
		return SUCCESS;
	}
	
	public String editarPersonalRegistro(){
		
		tipodocumento = tipoService.listarTipoDocumentoIdentidad();		
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
		
		personalregistro = personalregistroService.listarPersonalRegistroxID(personalregistro.get(0).getIdpersonalregistro());
		
				
		return SUCCESS;
	}
	
	public String insertarPersonalRegistro() throws Exception{
	
		try{
		//HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		areanatural = (Areanatural) session.get("area");
		
		personalregistro.get(0).setOperadorturismo(operadorturismo);
		personalregistro.get(0).setAreanatural(areanatural);
		personalregistro.get(0).setTipodocumento(tipodocumento.get(0));
		personalregistro.get(0).setSexo(tipogenero.get(0));
		personalregistro.get(0).setTipolocal(tipolocal.get(0));
		
		personalregistroService.guardarPersonal(personalregistro);
		
		
		}catch(Exception e){
			//e.printStackTrace();
			addActionError("Lo sentimos, no se pudo registrar su información, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String eliminarPersonalRegistro() throws Exception{
		
		try{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//Map<String, Object> session = ActionContext.getContext().getSession();
		
		int idpr = Integer.valueOf(request.getParameter("idpersonalregistro"));		
				
		personalregistroService.eliminarPersonal(idpr);
				
		}catch(Exception e){
			//e.printStackTrace();
			addActionError("Lo sentimos, no se pudo realizar la acción solicitada, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	public String insertarPersonalRegistroForm() throws Exception{
		
		try{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		PersonalRegistro pr = new PersonalRegistro();
		
		operadorturismo = (Operadorturismo) session.get("operadorturismo");
		areanatural = (Areanatural) session.get("area");
		
		pr.setOperadorturismo(operadorturismo);
		pr.setAreanatural(areanatural);
		
		pr.setNombre(request.getParameter("nombre"));
		pr.setApepat(request.getParameter("apepat"));
		pr.setApemat(request.getParameter("apemat"));
		pr.setEmpresa(request.getParameter("empresa"));
		pr.setNumerodocumento(request.getParameter("numerodocumento"));
		
		Tipo t = new Tipo(1);
	    Tipo s = new Tipo(2);
	    Tipo l = new Tipo(22);
	    
	    t.setIdtipo( Integer.valueOf(request.getParameter("idtipodocumento")) );	    
	    s.setIdtipo( Integer.valueOf(request.getParameter("idsexo")) );
	    l.setIdtipo( Integer.valueOf(request.getParameter("intipodoc")) );
		
	    pr.setTipodocumento(t);
	    pr.setSexo(s);
	    pr.setTipolocal(l);
	   	    	    
		long idpr = personalregistroService.guardarPersonalinform(pr);
				
		pr.setIdpersonalregistro((int)idpr);
		
		tipodocumento = tipoService.listarTipoDocumentoIdentidad();
        tipogenero = tipoService.listarGenero();        
        tipolocal = tipoService.listarLocal();
        
        
        tipos = new LinkedHashMap<String, String>();
        
        for(Tipo t1 : tipodocumento){
        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
        }        
        for(Tipo t2 : tipogenero){        	
        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
        }        
        for(Tipo t3 : tipolocal){        	
        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
        }
		
		datos.put("person", pr);
		datos.put("tipos", tipos);
		
		
		}catch(Exception e){
			//e.printStackTrace();
			addActionError("Lo sentimos, no se pudo registrar su información, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	public String actualizarPersonalRegistro() throws Exception{
		try{			
						
		personalregistro.get(0).setTipodocumento(tipodocumento.get(0));
		personalregistro.get(0).setSexo(tipogenero.get(0));
		personalregistro.get(0).setTipolocal(tipolocal.get(0));
		
		personalregistroService.actualizarPersonal(personalregistro);
		}catch(Exception e){
			//e.printStackTrace();
			
			addActionError("Lo sentimos, no se pudo registrar su información, por favor vuelva a intentarlo mas tarde o comuniquese con su administrador.");
			
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	public String aprobarFichaFormulario(){
		
		List<FichaRegistro> listaficharegistro = new ArrayList<FichaRegistro>();
		
		try {
		
			
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			Map<String, Object> session = ActionContext.getContext().getSession();
							
					 
			areanatural = (Areanatural) session.get("area");
							
			ficharegistro = ficharegistroService.muestraFichaFormulario(ficharegistro.getIdficharegistro());
			personajuridica = personaJuridicaService.listarPersonaJuridica(ficharegistro.getOperadorturismo().getIdpersonajuridica());
			personanatural=personanaturalService.listarPersonaNaturalxID(personajuridica.getIdpersona());
			
			//tipomediotra = tipoService.listarMediosTransporte();
			
			tipomediotraedit = tipoService.listarMediosTransporteFichaRegistro(ficharegistro.getIdficharegistro());
			
			tipodocumento = tipoService.listarTipoDocumentoIdentidad();
	        tipogenero = tipoService.listarGenero();        
	        tipolocal = tipoService.listarLocal();
	        
	        
	        tipos = new LinkedHashMap<String, String>();
	        
	        for(Tipo t1 : tipodocumento){
	        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
	        }        
	        for(Tipo t2 : tipogenero){        	
	        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
	        }        
	        for(Tipo t3 : tipolocal){        	
	        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
	        }
			
			personalregistro = personalregistroService.listarPersonalxFicha(ficharegistro.getIdficharegistro());
									
			ficharegistro.setPersonajuridica(personajuridica);
			ficharegistro.setTipomediotra(tipomediotraedit);
			ficharegistro.setPersonalregistro(personalregistro);
			
			listaficharegistro.add(ficharegistro);
			
			//int idmoduloactual = (Integer)session.get("idmoduloactual");			
			//DirectorioarchivoModulo dam = directorioarchivomoduloService.listar(idmoduloactual).get(0);
			
			String path = getText("ruta.jasper");
								
			Map reportParams = new HashMap();
		
			reportParams.put("contacto", personanatural.getApepat()+" "+personanatural.getApemat()+", "+personanatural.getNombre());
			reportParams.put("SUBREPORT_DIR", path);
			reportParams.put("tipos", tipos);
			reportParams.put("nombreanp", areanatural.getCategoriaanp().getDescategoriaanp()+" "+areanatural.getDesareanatural());
			reportParams.put("firmasello", "FirmaSello_"+areanatural.getIdareanatural());
		
			String pathPDF = getText("ruta.descarga.ficha");
					
			
		JasperReport reporte = (JasperReport) JRLoader.loadObject(path+"FichaRegistro.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, reportParams, new JRBeanCollectionDataSource(listaficharegistro));

        JRExporter exporter = new JRPdfExporter();
        
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
        	        
        String rutaArch = pathPDF;
        
        String nombreArch = "FA"+Funciones.fechaHoy("ddMMyyyy")+"-"+ficharegistro.getIdficharegistro()+".pdf";
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(rutaArch+nombreArch));        	                
        
		exporter.exportReport();
		
		ficharegistro.setNombrearchivo(nombreArch);
		ficharegistro.setIdestadoficha(2);
		ficharegistro.setFechaaprobacion(Funciones.fechaHoyTimeStamp());
		
		ficharegistroService.aprobarFichaRegistro(ficharegistro);
		
		historialjefesanp = historialjefesanpService.listarActualJefe(areanatural).get(0);
		
		addActionMessage("Formulario Aprobado con &Eacute;xito!!!<br><br>");
		
		String sfecha = ficharegistro.getFechacreacion().getTime()+""+ficharegistro.getIdficharegistro();
		
		this.deleteJobUnschedulingTriggers(sfecha);
						
		if( ficharegistroService.enviarMailConfirmacionRegistroConAdjunto(ficharegistro, rutaArch+nombreArch, historialjefesanp) ){
			addActionMessage("Se remiti&oacute; Documento de aprobaci&oacute;n al siguiente correo: "+personajuridica.getCorreoinstitucional());
		}else{
			addActionError("Lo sentimos: no se pudo remitir la aprobaci&oacute;n al siguiente correo: "+personajuridica.getCorreoinstitucional()+", por favor comuniquese con su administrador");
		}	
		
		}catch(Exception e){
			e.printStackTrace();
			addActionError("Lo sentimos, no se pudo aprobar la Ficha, por favor comuniquese con su administrador.");
		}
		
		
		return SUCCESS;
	}
	
	
	public String desaprobarFichaFormulario(){
		
		try{
			
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			Map<String, Object> session = ActionContext.getContext().getSession();
				 
			areanatural = (Areanatural) session.get("area");
			
			String observacion = ficharegistro.getObservacion();
			ficharegistro = ficharegistroService.muestraFichaFormulario(ficharegistro.getIdficharegistro());
			personajuridica = personaJuridicaService.listarPersonaJuridica(ficharegistro.getOperadorturismo().getIdpersonajuridica());
			ficharegistro.setPersonajuridica(personajuridica);
			
			ficharegistro.setIdestadoficha(4); //0:anulado 1:pendiente 2:aprobado, 3:consolidado, 4:noaprobado
			ficharegistro.setObservacion(observacion);
			ficharegistro.setFechadesaprobacion(Funciones.fechaHoyTimeStamp());
			
			ficharegistroService.desaprobarFichaRegistro(ficharegistro);
			
			historialjefesanp = historialjefesanpService.listarActualJefe(areanatural).get(0);
			
			String sfecha = ficharegistro.getFechacreacion().getTime()+""+ficharegistro.getIdficharegistro();
			
			this.deleteJobUnschedulingTriggers(sfecha);
			
			addActionMessage("Ficha Desaprobada con &Eacute;xito!!!<br><br>");		
							
			if( ficharegistroService.enviarMailDesaprobacionFicha(ficharegistro, historialjefesanp) ){
				addActionMessage("Se informó dicha acción al siguiente correo: "+personajuridica.getCorreoinstitucional());
			}else{
				addActionError("Lo sentimos: no se pudo informar la desaprobaci&oacute;n al siguiente correo: "+personajuridica.getCorreoinstitucional()+", por favor comuniquese con su administrador");
			}	
			
			}catch(Exception e){
				e.printStackTrace();
				addActionError("Lo sentimos, no se pudo desaprobar la Ficha, por favor comuniquese con su administrador.");
			}	
		
		
		return SUCCESS;		
	}
	
	
	public String descargaFichaFormularioAprob(){
		
		try {
			
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			Map<String, Object> session = ActionContext.getContext().getSession();
			
			ficharegistro.setIdficharegistro(Integer.valueOf(request.getParameter("idficharegistro_")));
			ficharegistro = ficharegistroService.muestraFichaFormulario(ficharegistro.getIdficharegistro());
			
			
			//int idmoduloactual = (Integer)session.get("idmoduloactual");						
			//DirectorioarchivoModulo dam = directorioarchivomoduloService.listar(idmoduloactual).get(0);
			//String path= dam.getDirectorioarchivo().getDirdirectorio();
			
			String pathPDF = getText("ruta.descarga.ficha");
									
			//String path= "/media/ea221faa-886c-4ea9-97c5-1e13a81e195d/workspace-sts/diana/WebContent/jasper/";
			//String path= "/home/yonny/Documents/workspace-sts-2.9.2.RELEASE/diana/WebContent/jasper/";
			//String path= "/etc/apache-tomcat-6.0.29/webapps/diana/jasper/";
			
			String nombreArch = ficharegistro.getNombrearchivo();
			
			inputStream = new DataInputStream(new FileInputStream(pathPDF+nombreArch));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	private void programadorTareaApruebaFicha(FichaRegistro fr) throws SchedulerException{
		/*
		Map<String, Object> session = ActionContext.getContext().getSession();
		int idmoduloactual = (Integer)session.get("idmoduloactual");
		DirectorioarchivoModulo dam = directorioarchivomoduloService.listar(idmoduloactual).get(0);
		*/
		System.out.println("Añadiendo tarea "+Funciones.fechaHoy());
		
		Timestamp fechaaprobsys = fr.getFechacreacion();
		
		//String sfecha = System.currentTimeMillis()+"";
		String sfecha = fechaaprobsys.getTime()+""+fr.getIdficharegistro();

		System.out.println("Creando tarea: JOB : job"+sfecha+"GROUP : group"+sfecha);
		
		JobDetail jobd = newJob(QuartzJob.class).withIdentity("job"+sfecha, "group"+sfecha).build();
		jobd.getJobDataMap().put("ficharegistro", fr);
		jobd.getJobDataMap().put("areanatural", areanatural);
		
		jobd.getJobDataMap().put("ficharegistroService", ficharegistroService);
		jobd.getJobDataMap().put("personaJuridicaService", personaJuridicaService);
		jobd.getJobDataMap().put("personanaturalService", personanaturalService);
		jobd.getJobDataMap().put("tipoService", tipoService);
		jobd.getJobDataMap().put("personalregistroService", personalregistroService);
		jobd.getJobDataMap().put("historialjefesanpService", historialjefesanpService);
		jobd.getJobDataMap().put("DirectorioJasper", getText("ruta.jasper"));
		jobd.getJobDataMap().put("DirectorioDescarga", getText("ruta.descarga.ficha"));
		
		
		
		
		//Trigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0 08 10 ? * *")).build();									
		//Date fecha_ejec = new Date(System.currentTimeMillis() + 10000);
		Date fecha_ejec = new Date(fr.getFechaaprobsys().getTime());			
		//Trigger trigger = newTrigger().withIdentity("trigger"+sfecha, "group"+sfecha).startAt(fecha_ejec).build();
		SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger"+sfecha, "group"+sfecha).startAt(fecha_ejec).forJob("job"+sfecha, "group"+sfecha).build();			
				
		SchedulerFactory schedfact=new StdSchedulerFactory();
		Scheduler sched=schedfact.getScheduler();
		
		sched.start();			
		sched.scheduleJob(jobd, trigger);
		
	}
	
	
	private void deleteJobUnschedulingTriggers(String sfecha) throws SchedulerException{
		
		
		System.out.println("Eliminando Tarea: " + "JOB: job"+sfecha+ "GROUP: group"+sfecha);
		
		SchedulerFactory schedfact=new StdSchedulerFactory();
		Scheduler scheduler=schedfact.getScheduler();
		
		// Unschedule a particular trigger from the job (a job may have more than one trigger)
		scheduler.unscheduleJob(TriggerKey.triggerKey("trigger"+sfecha, "group"+sfecha));
		
		// Schedule the job with the trigger
		scheduler.deleteJob(JobKey.jobKey("job"+sfecha, "group"+sfecha));
		
	}
	
	/**/
	
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public HashMap<String, Object> getDatos() {
		return datos;
	}

	public void setDatos(HashMap<String, Object> datos) {
		this.datos = datos;
	}

	public List<Areanatural> getListaAreanatural() {
		return listaAreanatural;
	}

	public void setListaAreanatural(List<Areanatural> listaAreanatural) {
		this.listaAreanatural = listaAreanatural;
	}

	public void setAreaNaturalService(AreaNaturalService areaNaturalService) {
		this.areaNaturalService = areaNaturalService;
	}

	public void setOperadorService(OperadorService operadorService) {
		this.operadorService = operadorService;
	}

	public void setPersonanaturalService(PersonaNaturalService personanaturalService) {
		this.personanaturalService = personanaturalService;
	}

	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}

	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}

	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}

	

	public List<PersonalRegistro> getPersonalregistro() {
		return personalregistro;
	}

	public void setPersonalregistro(List<PersonalRegistro> personalregistro) {
		this.personalregistro = personalregistro;
	}

	public void setPersonaJuridicaService(
			PersonaJuridicaService personaJuridicaService) {
		this.personaJuridicaService = personaJuridicaService;
	}

	public void setPersonalregistroService(
			PersonalRegistroService personalregistroService) {
		this.personalregistroService = personalregistroService;
	}

	public void setFicharegistroService(FichaRegistroService ficharegistroService) {
		this.ficharegistroService = ficharegistroService;
	}
		
	public void setPersonalficharegistroService(
			PersonalFichaRegistroService personalficharegistroService) {
		this.personalficharegistroService = personalficharegistroService;
	}

	public void setHistorialjefesanpService(
			HistorialJefesAnpService historialjefesanpService) {
		this.historialjefesanpService = historialjefesanpService;
	}
	
	public void setDirectorioarchivomoduloService(
			DirectorioarchivoModuloService directorioarchivomoduloService) {
		this.directorioarchivomoduloService = directorioarchivomoduloService;
	}

	public void setDirectorioarchivoService(
			DirectorioArchivoService directorioarchivoService) {
		this.directorioarchivoService = directorioarchivoService;
	}

	public Personajuridica getPersonajuridica() {
		return personajuridica;
	}

	public void setPersonajuridica(Personajuridica personajuridica) {
		this.personajuridica = personajuridica;
	}

	public Personanatural getPersonanatural() {
		return personanatural;
	}

	public void setPersonanatural(Personanatural personanatural) {
		this.personanatural = personanatural;
	}

	public HistorialJefesAnp getHistorialjefesanp() {
		return historialjefesanp;
	}

	public void setHistorialjefesanp(HistorialJefesAnp historialjefesanp) {
		this.historialjefesanp = historialjefesanp;
	}

	public FichaRegistro getFicharegistro() {
		return ficharegistro;
	}

	public void setFicharegistro(FichaRegistro ficharegistro) {
		this.ficharegistro = ficharegistro;
	}

	public PersonalFichaRegistro getPersonalficharegistro() {
		return personalficharegistro;
	}

	public void setPersonalficharegistro(PersonalFichaRegistro personalficharegistro) {
		this.personalficharegistro = personalficharegistro;
	}

	public String[] getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String[] numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public List<PersonalRegistro> getDatosp() {
		return datosp;
	}

	public void setDatosp(List<PersonalRegistro> datosp) {
		this.datosp = datosp;
	}

	public List<Tipo> getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(List<Tipo> tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public List<Tipo> getTipogenero() {
		return tipogenero;
	}

	public void setTipogenero(List<Tipo> tipogenero) {
		this.tipogenero = tipogenero;
	}

	public List<Tipo> getTipolocal() {
		return tipolocal;
	}

	public void setTipolocal(List<Tipo> tipolocal) {
		this.tipolocal = tipolocal;
	}

	public LinkedHashMap<String, String> getTipos() {
		return tipos;
	}

	public void setTipos(LinkedHashMap<String, String> tipos) {
		this.tipos = tipos;
	}

	public List<Tipo> getTipomediotra() {
		return tipomediotra;
	}

	public void setTipomediotra(List<Tipo> tipomediotra) {
		this.tipomediotra = tipomediotra;
	}

	public List<Tipo> getTipomediotraedit() {
		return tipomediotraedit;
	}

	public void setTipomediotraedit(List<Tipo> tipomediotraedit) {
		this.tipomediotraedit = tipomediotraedit;
	}

	public List<FichaRegistro> getListaficharegistro() {
		return listaficharegistro;
	}

	public void setListaficharegistro(List<FichaRegistro> listaficharegistro) {
		this.listaficharegistro = listaficharegistro;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<PersonalFichaRegistro> getListapersonalficharegistro() {
		return listapersonalficharegistro;
	}

	public void setListapersonalficharegistro(
			List<PersonalFichaRegistro> listapersonalficharegistro) {
		this.listapersonalficharegistro = listapersonalficharegistro;
	}

	public int getParamidmodulo() {
		return paramidmodulo;
	}

	public void setParamidmodulo(int paramidmodulo) {
		this.paramidmodulo = paramidmodulo;
	}

	

	
	
	
}
