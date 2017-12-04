package sernanp.rrhh.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import sernanp.app.business.core.asistencia.service.BuscarLicenciasPersonalService;
//import scala.annotation.meta.getter;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.domain.TRegimenContractualExample;
import sernanp.app.dao.mapper.TRegimenContractualMapper;
import sernanp.app.dao.query.domain.AniosLicenciasPersonalQuery;
import sernanp.app.dao.query.domain.AniosLicenciasPersonalQueryCriteria;
import sernanp.app.dao.query.domain.Anios_dias_no_laborablesQuery;
import sernanp.app.dao.query.domain.Anios_dias_no_laborablesQueryCriteria;
import sernanp.app.dao.query.domain.LicenciasPersonalPorMesAnioActividadQueryCriteria;
import sernanp.app.dao.query.domain.MesesLicenciasPersonalQuery;
import sernanp.app.dao.query.domain.MesesLicenciasPersonalQueryCriteria;
import sernanp.app.dao.query.mapper.AniosLicenciasPersonalQueryMapper;
import sernanp.app.dao.query.mapper.LicenciasPersonalPorMesAnioActividadQueryMapper;
import sernanp.app.dao.query.mapper.MesesLicenciasPersonalQueryMapper;
import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.service.PersonalActividadService;
import sernanp.rrhh.service.PersonalLicenciasService;
import sernanp.rrhh.service.PersonalMarcacionService;
import sernanp.rrhh.service.PersonalPapeletaService;
import sernanp.rrhh.service.PersonalService;
import sernanp.rrhh.service.PersonalVacacionesService;
import sernanp.rrhh.service.TipoService;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.Areanatural;
import sernanp.rrhh.vo.Categoriaanp;
import sernanp.rrhh.vo.PersonalActividadVO;
import sernanp.rrhh.vo.PersonalAsistenciaRecordVO;
import sernanp.rrhh.vo.PersonalAsistenciaResumenVO;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalDescuentosVO;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;
import sernanp.rrhh.vo.PersonalLicenciasVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalPermisoVO;
import sernanp.rrhh.vo.PersonalTardanzaVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.PersonalVacacionesGoceVO;
import sernanp.rrhh.vo.PersonalVacacionesVO;
import sernanp.rrhh.vo.PersonaldiasnolaborablesVO;
import sernanp.rrhh.vo.Personanatural;
import sernanp.rrhh.vo.Tipo;
import sernanp.rrhh.vo.Usuario;

public class PersonalAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	CommonService commonService;
	
	private String dtpage;
	private Map<String, Object> datos;
	private String MsgTransaction;
	
	private Areanatural areanatural;
	private int descValidados = 0;
	
	private PersonalService personalService;
	private PersonalActividadService personalActividadService;
	private PersonalMarcacionService personalMarcacionService;
	private TipoService tipoService;
	private PersonalPapeletaService personalPapeletaService;
	private List<Tipo> listaTipoMarcacion;
	private List<PersonalActividadVO> listaMotivoMarcacion;
	private List<PersonalVO> listapersonal;
	private List<PersonalTardanzaVO> listapersonaltardanza;
	private List<PersonalTardanzaVO> listapersonaltardanzaTMP;
	private List<PersonalDescuentosVO> listapersonaltardanzadesc;
	private List<PersonalDescuentosVO> listapersonaltardanzadescSave;
	private List<PersonalDescuentosVO> listapersonalinasistenciadescSave;
	private List<PersonalDescuentosVO> listapersonaldescuentos;
	private List<Personanatural> listaapespersonal;
	private List<PersonalAsistenciaVO> listapersonalinasistencias;
	private Personanatural personanatural;
	private PersonalMarcacionVO personalMarcacion;
	private PersonalActividadVO personalActividadVO;
	
	private PersonalVO personal;
	private PersonalPermisoVO personalPermiso;
	private List<PersonalDesplazamientoVO> personalDesplazamiento;
	private PersonalDesplazamientoVO personalPapeleta;
	
	private List <PersonalMarcacionVO> listamarcacionesxtrabajador;
	
	private Map reportParams;
	
	private PersonaldiasnolaborablesVO personaldiasnolaborablesVO;
	
	private Usuario user;
	private PersonalVO personalTurno;  
	private List<PersonalDescuentosVO> listarPeriodoMesDescuento;
	
	//17-07-2014: D.V.R ---------------MARCACIONES
	private String dte_fec_marc;
	private int idPapeleta;
	private int idMarcacion;
	
	
	
	
	
	//05-06-2014: D.V.R ---------------VACACIONES
	private PersonalVacacionesService personalVacacionesService;
	private List<PersonalVacacionesVO> listapersonalVacaciones;
	private List<PersonalVacacionesGoceVO> listapersonalVacacionesGoce;
	private List<PersonalVacacionesVO> listaPeriodosVacaciones;
	private PersonalVacacionesGoceVO personalVacacionesGoce;
	private PersonalVacacionesVO personalVacaciones;
	private int periodoVacaciones 		= 0;
//	private int tieneVacacionesconGoce 	= 0;
	private int idPersonal 				= 0;
	private Date f_inicioVac			= null;
	private Date f_finVac				= null;
	private Date f_aprobVac 			= null;
	private int idVacaciones 			= 0;
	private int idVacacionesGoce 		= 0;
	private int ndiasProgVac			= 0;
	
	//08-07-2014: D.V.R ------------LICENCIAS
	
	private PersonalLicenciasService personalLicenciasService;
	private List<PersonalLicenciasVO> listapersonalLicencias;
	private PersonalLicenciasVO personalLicencias;
	private List<PersonalActividadVO> listTipoLicencia;
	private int addLicencia				= 0;
	private int intEstado				= 0;
	private int idLicencia				= 0;
	private int idActividad				= 0;
	private Date f_inicioLic 			= null;
	private Date f_finLic	 			= null;
	private Date fechaAsistenciaLic		= null;
	
	
	
	
	//24-07-2014 (D.V.R)
	private int timePermiso = -1;
	
	
	
	//12-08-2014
	private int nroRegistros = 0;
	
	//14-08-2014
	private List<TRegimenContractual> regimenContractual;
	private int idregimenContractual;
	
	
	
	
	//02/09/2014
	private List<PersonalDescuentosVO> listaaniosDescuentos;
	private List<PersonalDescuentosVO> listamesDescuentos;
	private int periododesc;
	private int mesdesc;
	
	
	// 07/09/2014
	private int ubicacionPersonal = -1; 
	private List<Categoriaanp> listcategoriaanp;
	private List<Areanatural> listareanatural;
	private int idANP;
	
	
	private Integer isajax;
	private Integer int_mes_desc;
	private Integer int_periodo_desc;
	private Integer estadoPersonal = -1;
	
	/* ------------------ MAPS para optgroup -----------*/
	private HashMap<Object,Object> mapcat;
	private HashMap<Object, Object> mapanp;
	
	
	private Date AsistenciafechaInicio = null;
	private Date AsistenciafechaFin = null;
	private int tiempoReportePersonal = -1;
	private int tipoReporte = 0;
	
	
	private List<PersonalAsistenciaVO> listaPersonalAsistencia;
	private List<PersonalDesplazamientoVO> listaPersonalDesplazamiento;
	private List<PersonalAsistenciaResumenVO> listaPersonalResumenAsistencia;
	private List<PersonalAsistenciaRecordVO> listaPersonalAsistenciaRecord;
	
	private List<PersonaldiasnolaborablesVO> listadiasnolaborables;
	private List<PersonaldiasnolaborablesVO> listadiasnolaborablesperiodo;
	

	private List<AniosLicenciasPersonalQuery> anios_licencias_personal;
	private List<MesesLicenciasPersonalQuery> meses_licencias_personal;
	@Autowired
	BuscarLicenciasPersonalService buscarLicenciasPersonalService;
	
	
	public List<AniosLicenciasPersonalQuery> getAnios_licencias_personal() {
		return anios_licencias_personal;
	}


	public void setAnios_licencias_personal(List<AniosLicenciasPersonalQuery> anios_licencias_personal) {
		this.anios_licencias_personal = anios_licencias_personal;
	}


	public List<MesesLicenciasPersonalQuery> getMeses_licencias_personal() {
		return meses_licencias_personal;
	}


	public void setMeses_licencias_personal(List<MesesLicenciasPersonalQuery> meses_licencias_personal) {
		this.meses_licencias_personal = meses_licencias_personal;
	}


	public void setPersonalLicenciasService(
			PersonalLicenciasService personalLicenciasService) {
		this.personalLicenciasService = personalLicenciasService;
	}


	public void setPersonalPapeletaService(PersonalPapeletaService personalPapeletaService) {
		this.personalPapeletaService = personalPapeletaService;
	}


	public void setPersonalMarcacionService(PersonalMarcacionService personalMarcacionService) {
		this.personalMarcacionService = personalMarcacionService;
	}


	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}
	
			
	public void setPersonalActividadService(PersonalActividadService personalActividadService) {
		this.personalActividadService = personalActividadService;
	}


	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}



	public PersonalAction(){
		areanatural 						= new Areanatural();
		datos 								= new HashMap<String, Object>();		
		listapersonal 						= new ArrayList<PersonalVO>();
		listaapespersonal 					= new ArrayList<Personanatural>();
		listamarcacionesxtrabajador 		= new ArrayList<PersonalMarcacionVO>();
		personanatural						= new Personanatural();
		personalMarcacion					= new PersonalMarcacionVO();
		personalActividadVO					= new PersonalActividadVO();
		personal							= new PersonalVO();
		listapersonaltardanza				= new ArrayList<PersonalTardanzaVO>();
		listapersonaltardanzaTMP			= new ArrayList<PersonalTardanzaVO>();
		
		listapersonaltardanzadesc			= new ArrayList<PersonalDescuentosVO>(); 
		listapersonaltardanzadescSave		= new ArrayList<PersonalDescuentosVO>();
		listapersonalinasistenciadescSave	= new ArrayList<PersonalDescuentosVO>();		
		listapersonaldescuentos				= new ArrayList<PersonalDescuentosVO>();
		listapersonalinasistencias			= new ArrayList<PersonalAsistenciaVO>();
		personalPermiso						= new PersonalPermisoVO();
		personalDesplazamiento				= new ArrayList<PersonalDesplazamientoVO>();
		personalPapeleta					= new PersonalDesplazamientoVO();
		
		reportParams 						= new HashMap();
		personaldiasnolaborablesVO			= new PersonaldiasnolaborablesVO();
		personalTurno						= new PersonalVO();
		
		listapersonalVacaciones				= new ArrayList<PersonalVacacionesVO>();
		listapersonalVacacionesGoce			= new ArrayList<PersonalVacacionesGoceVO>();
		personalVacaciones					= new PersonalVacacionesVO();
		personalVacacionesGoce				= new PersonalVacacionesGoceVO();
		
		listapersonalLicencias				= new ArrayList<PersonalLicenciasVO>();
		personalLicencias					= new PersonalLicenciasVO();
		listTipoLicencia					= new ArrayList<PersonalActividadVO>();	
		
		listcategoriaanp					= new ArrayList<Categoriaanp>();
		listareanatural						= new ArrayList<Areanatural>();

		
		listaPersonalAsistencia				= new ArrayList<PersonalAsistenciaVO>();
		
	}

	
	public String execute(){        
		String strReturn			= null;
		try {
			
			personalPapeleta			= personalPapeletaService.papeletaxid(idPapeleta);				
			personanatural 				= personalService.listapersonalxID(personalPapeleta.getPersonal().getIdpersonal());		
			listaMotivoMarcacion		= personalActividadService.listMotivoMarcacionJustificaInasistenciaCGH();
			ServletActionContext.getRequest().setAttribute("hor_salida_papeleta", personalPapeleta.getHor_hor_sal_desp().toString());
			if(personalPapeleta.getHor_hor_ret_desp() != null){
				ServletActionContext.getRequest().setAttribute("hor_retorno_papeleta", personalPapeleta.getHor_hor_ret_desp().toString());
			}
			strReturn = "EditMarcacion";			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strReturn;
	}	

	
	
	public void verificaExisteMarcaciones(int idpersonal, String fecha_reg_marc){
		
		listamarcacionesxtrabajador	= personalMarcacionService.MarcacionxIdpersonalfechamarc(idpersonal,fecha_reg_marc);			

		if(isajax == null){
//			System.out.println("isajax is null");
				personal.setIdpersonal(idpersonal);
				personalMarcacion.setPersonal(personal);			
				listaMotivoMarcacion		= personalActividadService.listMotivoMarcacionJustificaInasistenciaCGH_SGH();	
		}

		ServletActionContext.getRequest().setAttribute("cantMarcacion", listamarcacionesxtrabajador.size());		
	}
	

	
	public String obtenermarcacionesxtrabajador(){		
		String estadoAsist			= null;
		String [] periododescsave	= null;
		String strReadOnly			= null;	
		int tipoMarcacion			= 0;
		
		periododescsave = dte_fec_marc.split("/");		
		
		if(isajax != null){
			
			listamarcacionesxtrabajador	= personalMarcacionService.MarcacionxIdpersonalfechamarc(idPersonal,dte_fec_marc);			
			descValidados				= personalService.contardescuentosvalidadosxperiodo(Integer.parseInt(periododescsave[2]),	Integer.parseInt(periododescsave[1]), ubicacionPersonal, idANP, idregimenContractual);
			
			for(PersonalMarcacionVO x : listamarcacionesxtrabajador){
				if(x.getTipomarcacion().getIdtipo() == 127){
					tipoMarcacion++;
					break;
				}
			}
			
			
			if (descValidados > 0 ){
				addActionMessage("Periodo CERRADO!");
//				strReadOnly = "ESCRITURA";
			}else{			
				
//				strReadOnly = "ESCRITURA";
			}
			
			/*ADD 19-08-2014 (D.V.R)      -----------      OBTENER EL ESTADO DE ASISTENCIA X FECHA  ---------*/
			List<PersonalAsistenciaVO> pa	= new ArrayList<PersonalAsistenciaVO>();
			pa	= personalService.obtenerEstadoAsistencia(idPersonal,	dte_fec_marc);

			if(pa.size() > 0){
				if(pa.get(0).getEstado() == 2){
						addActionMessage("Permiso");
						estadoAsist = "Permiso";
				}else if(pa.get(0).getEstado() == 1){
					if(pa.get(0).getInt_vac_lic() == 2){
						addActionMessage("Licencia sin goce");
						estadoAsist = "Licencia sin goce";
					}else{
						if(pa.get(0).getEstadoTmp() == 1){
							addActionMessage("Inasistencia");
							estadoAsist = "Inasistencia";
						}else{
							addActionMessage("Observado");
							estadoAsist = "Observado";
						}
					}
				}else{
					if(pa.get(0).getInt_vac_lic() == 1){
						addActionMessage("Vacaciones");
						estadoAsist = "Vacaciones";
					}else if(pa.get(0).getInt_vac_lic() == 2){					
						addActionMessage("Licencia");
						estadoAsist = "Licencia";
					}
				}
				ServletActionContext.getRequest().setAttribute("hor_ingreso", pa.get(0).getHor_hor_ingreso());		
				ServletActionContext.getRequest().setAttribute("hor_salida",pa.get(0).getHor_hor_salida());
				ServletActionContext.getRequest().setAttribute("minutos_tardanza", pa.get(0).getMinutostardanza());		
				ServletActionContext.getRequest().setAttribute("estadoAsist",estadoAsist);
			}
			
			ServletActionContext.getRequest().setAttribute("elininarMarcacion",tipoMarcacion);
			ServletActionContext.getRequest().setAttribute("cantMarcacion", listamarcacionesxtrabajador.size());			
			strReadOnly = "isajax";
			
			
		}else{			
//			System.out.println("isajax is null");
			personal.setIdpersonal(idPersonal);
			personalMarcacion.setPersonal(personal);			
//			listaMotivoMarcacion		= personalActividadService.listMotivoMarcacionJustificaInasistenciaCGH_SGH();
			listaMotivoMarcacion		= personalActividadService.listMotivoMarcacionJustificaInasistenciaCGH();	
			personanatural 				= personalService.listapersonalxID(idPersonal);	
			strReadOnly 				= "ESCRITURA";

		}	
		
//		ServletActionContext.getRequest().setAttribute("PersonalPermiso", personalconP);
		ServletActionContext.getRequest().setAttribute("dte_fec_marc", dte_fec_marc);		
		ServletActionContext.getRequest().setAttribute("descValidados",descValidados);
		

        
//        return SUCCESS;
		return strReadOnly;
	}
	
	
	public String grabarMarcacionManual(){

		String MSGTRX 						= null;
		int cantMarcacaciones				= 0;
		
		try{			
			Map<String, Object> session 	= ActionContext.getContext().getSession();
			user          					= (Usuario) session.get("USUARIO_ACTUAL");

			personalMarcacion.setInt_id_usu_crea(user.getIdUsuario());	
			
			if(personalMarcacion.getHor_hor_marc() != null && personalMarcacion.getHor_hor_marc1() != null){
				cantMarcacaciones	= 2;
				
			}else if(personalMarcacion.getHor_hor_marc() == null && personalMarcacion.getHor_hor_marc1() != null){
					personalMarcacion.setHor_hor_marc(personalMarcacion.getHor_hor_marc1());
					cantMarcacaciones	= 1;
				
			}else if(personalMarcacion.getHor_hor_marc1() == null && personalMarcacion.getHor_hor_marc() != null){
					cantMarcacaciones	= 1;
			}						
				
		//14-08-2014   -------------- Actividad 26 es Sanciones, por lo tanto no debe registrar marcaciones
				
			personalPapeleta.setHor_hor_sal_desp(personalMarcacion.getHor_hor_marc());
			personalPapeleta.setHor_hor_ret_desp(personalMarcacion.getHor_hor_marc1());				
			personalPapeleta.setDte_fec_ret_desp(personalMarcacion.getDte_fec_marc2());
			personalPapeleta.setPersonal(personalMarcacion.getPersonal());
			personalPapeleta.setPersonalActividad(personalMarcacion.getPersonalActividad());
			personalPapeleta.setInt_usu_crea(user.getIdUsuario());
			personalPapeleta.setVar_lug_desp(personalMarcacion.getVar_descripcion());
			
			if(personalMarcacion.getDte_fec_marc1() == null){
				personalPapeleta.setDte_fec_sal_desp(personalMarcacion.getDte_fec_marc());
			}else{
				personalPapeleta.setDte_fec_sal_desp(personalMarcacion.getDte_fec_marc1());	
			}

			personalMarcacionService.guardarMarcacionManual(personalMarcacion, cantMarcacaciones,personalPapeleta);											

			MSGTRX = SUCCESS;				

			addActionMessage("Se agregó con éxito");
			
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción");
			MSGTRX = ERROR;
		}
		
//		datos.put("MsgTrx", MSGTRX);
		return SUCCESS;
	}
	
	
	
	public String papeletaxidP(){
		String [] periodox  = null;
		String Msg			= null;
		periodox = dte_fec_marc.split("/");
		
//		System.out.println("PapeletaxidP - isajax " + isajax);
		
		
		if(isajax == 0){
			Msg = SUCCESS;
		}else{
			personalDesplazamiento = personalPapeletaService.listapapeletaxidP(idPersonal, Integer.parseInt(periodox[2]));
			Msg = "isajax";
		}
		
		return Msg;
	}

	
	
	public String actualizarMarcacionManual(){
		
		String MSGTRX 				= "";
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String,Object> session 	= ActionContext.getContext().getSession();		

		int estadoAsistencia		= 0;
		String estadoAsist			= null;
		
		try{		
			user					= (Usuario)session.get("USUARIO_ACTUAL");
			areanatural 			= (Areanatural) session.get("area");
//			idPersonal				= personalMarcacion.getPersonal().getIdpersonal();
			idPersonal				= personalPapeleta.getPersonal().getIdpersonal();
			

			listamarcacionesxtrabajador	= personalMarcacionService.MarcacionxIdPapeleta(personalPapeleta.getSrl_id_desp());
			
			personalMarcacionService.actualizarMarcacionManual(personalPapeleta, listamarcacionesxtrabajador, estadoAsistencia);
	
			List<PersonalAsistenciaVO> pa	= new ArrayList<PersonalAsistenciaVO>();

			pa	= personalService.obtenerEstadoAsistencia(idPersonal,	personalPapeleta.getDte_fec_sal_desp().toString());
			

			if(pa.size() > 0){
				if(pa.get(0).getEstado() == 2){
//						addActionMessage("Permiso");
						estadoAsist = "Permiso";
				}else if(pa.get(0).getEstado() == 1){
					if(pa.get(0).getInt_vac_lic() == 2){
//						addActionMessage("Licencia sin goce");
						estadoAsist = "Licencia sin goce";
					}else{
						if(pa.get(0).getEstadoTmp() == 1){
//							addActionMessage("Inasistencia");
							estadoAsist = "Inasistencia";
						}else{
//							addActionMessage("Observado");
							estadoAsist = "Observado";
						}
					}
				}else{
					if(pa.get(0).getInt_vac_lic() == 1){
//						addActionMessage("Vacaciones");
						estadoAsist = "Vacaciones";
					}else if(pa.get(0).getInt_vac_lic() == 2){					
//						addActionMessage("Licencia");
						estadoAsist = "Licencia";
					}
				}
				
				if(pa.get(0).getHor_hor_ingreso() != null){datos.put("hor_ingreso", pa.get(0).getHor_hor_ingreso().toString());	}else{datos.put("hor_ingreso", "");	}
				if(pa.get(0).getHor_hor_ingreso() != null){	datos.put("hor_ingreso", pa.get(0).getHor_hor_ingreso().toString());}else{datos.put("hor_ingreso", "");	}
				if(pa.get(0).getHor_hor_salida() != null){datos.put("hor_salida",pa.get(0).getHor_hor_salida().toString());	}else{datos.put("hor_salida","");}
				if(pa.get(0).getMinutostardanza() != null){	datos.put("minutos_tardanza", pa.get(0).getMinutostardanza().toString());}else{datos.put("minutos_tardanza", "");}
				
				datos.put("estadoAsist",estadoAsist);
			}
			
			MSGTRX = SUCCESS;
			datos.put("exito", "Se Actualizó exitosamente!");
//			addActionMessage("Se Actualizó exitosamente!");
		}catch(Exception e){
			e.printStackTrace();
			MSGTRX = ERROR;
		}
		
		datos.put("MsgTrx", MSGTRX);		
		
		return SUCCESS;	
	}
	
	
	
	public String eliminarMarcacion(){
		String MSGTRX				= null;

		try {	

			personalPapeletaService.eliminarPapeletaMarcacion(idPapeleta, idPersonal, dte_fec_marc, idMarcacion);			
			addActionMessage("Se eliminó con éxito");
			MSGTRX 					= SUCCESS;	
			
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción");
			MSGTRX = ERROR;
		}
		
		return MSGTRX;
	}
	
	
	public String eliminarPapeleta(){
		String MSGTRX	= null;

		if(f_finVac == null || f_finVac.toString().equals("")) f_finVac  = f_inicioVac;
		
		try {
			personalPapeletaService.eliminarPapeleta(idPersonal, idPapeleta, f_inicioVac, f_finVac, idMarcacion);				
			addActionMessage("Se eliminó con éxito");
			MSGTRX 	= SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción");
			MSGTRX = ERROR;
		}
		
		return MSGTRX;
	}
	
	
	
	
	/*ADD 14-08-2014 (D.V.R)      -------------- CARGA REGIMEN CONTRACTUAL -------*/
	
	public String listRegimenContractual(){	

		ServletActionContext.getRequest().setAttribute("dte_fec_asist", Funciones.fechaHoy("dd/MM/yyyy"));
		
//		regimenContractual			= commonService.selectAll(TRegimenContractualMapper.class);
		List<Integer> val			= new ArrayList<Integer>();
		val.add(1);
		val.add(3);
		TRegimenContractualExample example = new TRegimenContractualExample();
		example.createCriteria().andSrl_id_regimen_contractualIn(val);		
		
		regimenContractual = commonService.selectByExample(TRegimenContractualMapper.class, example);

		listcategoriaanp	= personalService.listaCatANPs();
		
		return SUCCESS;
	}
	
	public String listAnpsxidCategoria(){
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		listareanatural	= personalService.listaANPs(Integer.parseInt(request.getParameter("idCategoriaANP")));
		datos.put("listaANPs",listareanatural);
		return SUCCESS;
	}
		
	
	
	
	
	public String listadopersonal(){
		
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural 				= (Areanatural) session.get("area");
		dtpage 						= request.getParameter("d-16544-p");
		int cantidadincidencias		= 0;
		String [] incid				= null;
		String fechasist 			= null;
		int motivoAsist				= 0;
		String aPaterno				= null;	
		
//		System.out.println("listadopersonal - isajax : " + isajax);
		
		if(isajax == null){
			this.listRegimenContractual();			
		}else{
			
			if(request.getParameter("Motivo") != null){
				motivoAsist	= Integer.parseInt(request.getParameter("Motivo"));	
			}else{
				motivoAsist	= 4;//Es el valor que tiene por defecto el combo en la vista, el cual permite mostrar todas las asistencias
			}		
//			
//			System.out.println("fechasist 1 : "+fechasist);
			
			if(request.getParameter("dte_fec_asist") != null){	
				fechasist 	= request.getParameter("dte_fec_asist");
				aPaterno	= request.getParameter("aPaterno");
			}else{			
				fechasist 		 		= Funciones.fechaHoy("dd/MM/yyyy");			
			}
		
			
//			System.out.println("ubicacionPersonal : " + ubicacionPersonal);
//			System.out.println("aPaterno : " + aPaterno);
//			System.out.println("Motivo : " + motivoAsist);
//			System.out.println("idregimenContractual : " + idregimenContractual);
//			System.out.println("nroRegistros : " + nroRegistros);
//			System.out.println("idANP : " + idANP);
						
			
			
			listapersonal 				= personalService.listapersonalxfechaymotivoAsistApepat(fechasist, motivoAsist, aPaterno,idregimenContractual, ubicacionPersonal, idANP, nroRegistros);			

//	 		Inasistencia-Permisos-Observado-Asistencia
			listapersonalinasistencias  = personalService.Incidencias(fechasist);
			incid						= listapersonalinasistencias.get(0).getIncidencias().split("-");
			cantidadincidencias 		= Integer.parseInt(incid[1]+incid[3]);
			
			ServletActionContext.getRequest().setAttribute(	"msgincidencias", "SE ENCONTRO: Asistencias ("+incid[0]+"),   Inasistencias ("+incid[1]+
															"),   Regularizadas ("+incid[2] + ") y   Observadas: ("+incid[3]+").");		 
			
			ServletActionContext.getRequest().setAttribute("cantidadincidencias", cantidadincidencias);
			ServletActionContext.getRequest().setAttribute("dte_fec_asist", fechasist);
			
		}
		


		
		return SUCCESS;
	}


/*--------------------- REPORTES ------------------*/
	
	
	public String viewOptionsReporte() {
		
		this.listRegimenContractual();
		
		listaaniosDescuentos 	= personalService.listarPeriodoMesDescuento(0);			
		listamesDescuentos		= personalService.listarPeriodoMesDescuento(1);
		
		if(idPersonal > 0){
			personanatural 			= personalService.listapersonalxID(idPersonal);
		}
		
		int_mes_desc			= Funciones.obtenerNroMesDescuento() + 1;
		int_periodo_desc		= Funciones.obtenerAnioOfDescuento();
		AsistenciafechaInicio 	= Funciones.convertString2SqldateFormat(Funciones.fechaHoy("dd-MM-yyyy"),"dd-MM-yyyy");
		AsistenciafechaFin 		= AsistenciafechaInicio; 
		
		ServletActionContext.getRequest().setAttribute("AsistenciafechaInicio",	Funciones.fechaFormat("dd/MM/yyyy",	AsistenciafechaInicio));
		ServletActionContext.getRequest().setAttribute("AsistenciafechaFin",	Funciones.fechaFormat("dd/MM/yyyy",	AsistenciafechaFin));

		return SUCCESS;
	}
	
	
	
	public void listarAsistenciasPersonal(){
		
		listaPersonalAsistencia  = personalService.listaInasistenciasRangoFechas(AsistenciafechaInicio, AsistenciafechaFin, ubicacionPersonal, idPersonal, idregimenContractual, tipoReporte);

	}
	
	public void listarPersonalporActividad(){
		
		listaPersonalDesplazamiento  = personalService.listarPersonalporActividad(AsistenciafechaInicio, AsistenciafechaFin, ubicacionPersonal, idPersonal, idregimenContractual);
		
	}
	
	
	public void listarPersonalResumenAsistencia(){

		listaPersonalResumenAsistencia	= personalService.listarPersonalResumenAsistencia(AsistenciafechaInicio, AsistenciafechaFin, ubicacionPersonal, idPersonal, idregimenContractual);

	}	

	
	public void listarPersonalRecordAsistencias(){
		int n2 = 0, diasT = 0, numdia=0, idPersonalRecord 	= 0;
		int idPersonal2										= 0;
		String diafimes [] 									= null;
		PersonalAsistenciaRecordVO  parObj					= null;
		List<PersonalAsistenciaVO>listaPersonalAsistencia1 	= null;
		PersonalAsistenciaVO pa 							= null;
		Date	AsistenciafechaInicio1						= null;
		PersonalVO	ps										= null;
		PersonalAsistenciaResumenVO par 					= null;

		listaPersonalAsistencia  		= personalService.listarPersonalRecordAsistencias(AsistenciafechaInicio, AsistenciafechaFin, ubicacionPersonal, idPersonal, idregimenContractual);

		listaPersonalAsistenciaRecord	= new ArrayList<PersonalAsistenciaRecordVO>();
		diafimes						= AsistenciafechaFin.toString().split("-");	
		numdia 							= Integer.valueOf(diafimes[2]);
		
		if(listaPersonalAsistencia.size() > 0 ) {			
		
			for(PersonalAsistenciaVO x : listaPersonalAsistencia){
				
				n2 						= 0;
				idPersonal2				= 0;
				AsistenciafechaInicio1	= AsistenciafechaInicio;
				ps						= new PersonalVO();			
				
				if(idPersonalRecord != x.getPersonal().getIdpersonal()){				
					
					listaPersonalAsistencia1	= new ArrayList<PersonalAsistenciaVO>();
					
					ps							= x.getPersonal();				
						
					for(PersonalAsistenciaVO y : listaPersonalAsistencia){
						if(x.getPersonal().getIdpersonal() == y.getPersonal().getIdpersonal()){
							idPersonal2++;						
						}else{
							break;
						}
					}
					
					/*System.out.println("idPersonal2 inicial por Personal --> " + idPersonal2);
					System.out.println("numdia --> " + numdia);*/
					
					
					for(PersonalAsistenciaVO y : listaPersonalAsistencia){						
						
						if(x.getPersonal().getIdpersonal() == y.getPersonal().getIdpersonal() && n2 == 0)	n2	= 1;
						
						
						if(x.getPersonal().getIdpersonal() == y.getPersonal().getIdpersonal()){
							/*System.out.println(n2 + " .- " + x.getPersonal().getApepat());
							System.out.println(n2 + ".- x.getPersonal().getIdpersonal() " + x.getPersonal().getIdpersonal() + "  <--->  y.getPersonal().getIdpersonal() --> " +  y.getPersonal().getIdpersonal());						
							System.out.println("n2 dentro de Lista --> " + n2);*/
							
							if(n2 >= 1 && n2 <= numdia){						
								
								diasT = Funciones.diasTranscurridosEntre(AsistenciafechaInicio1, y.getDte_fecha());
								
	//							System.out.println("diasT --> " + diasT);
								
								if(diasT > 0 ){
									
									for(int k=0; k <= diasT; k++){										
										
										if(y.getDte_fecha().equals(AsistenciafechaInicio1)){
	
											listaPersonalAsistencia1.add(y);
	
										}else{
											
											pa = new PersonalAsistenciaVO();
											pa.setPersonal(ps);
											pa.setDte_fecha(AsistenciafechaInicio1);
											
											if(personalVacacionesService.vacacionesRangoFecha(y.getPersonal().getIdpersonal(), AsistenciafechaInicio1, AsistenciafechaInicio1) > 0){
												pa.setStr_hor_ingreso("VAC");
												pa.setStr_hor_salida("VAC");
											}else{
												pa.setStr_hor_ingreso("");
												pa.setStr_hor_salida("");	
											}
											
											listaPersonalAsistencia1.add(pa);
	//													
										}
										
										AsistenciafechaInicio1 =  Funciones.convertString2SqldateFormat(Funciones.fechaFormat("yyyy-MM-dd", Funciones.sumarDiasAFecha(Funciones.String2Date(AsistenciafechaInicio1.toString(),"yyyy-MM-dd"), 1)),"yyyy-MM-dd");
										n2++;
										
									}
									
									n2--;
									
								}else if(diasT == 0){
								
									listaPersonalAsistencia1.add(y);
									AsistenciafechaInicio1 =  Funciones.convertString2SqldateFormat(Funciones.fechaFormat("yyyy-MM-dd", Funciones.sumarDiasAFecha(Funciones.String2Date(AsistenciafechaInicio1.toString(),"yyyy-MM-dd"), 1)),"yyyy-MM-dd");
									
								}else{
									if(x.getPersonal().getIdpersonal() == y.getPersonal().getIdpersonal()){
										listaPersonalAsistencia1.add(y);	
									}else{
										pa = new PersonalAsistenciaVO();
										pa.setPersonal(ps);
										pa.setDte_fecha(AsistenciafechaInicio1);
	
										if(personalVacacionesService.vacacionesRangoFecha(y.getPersonal().getIdpersonal(), AsistenciafechaInicio1, AsistenciafechaInicio1) > 0){
											pa.setStr_hor_ingreso("VAC");
											pa.setStr_hor_salida("VAC");
										}else{
											pa.setStr_hor_ingreso("");
											pa.setStr_hor_salida("");	
										}
										
										listaPersonalAsistencia1.add(pa);
									}
									AsistenciafechaInicio1 =  Funciones.convertString2SqldateFormat(Funciones.fechaFormat("yyyy-MM-dd", Funciones.sumarDiasAFecha(Funciones.String2Date(AsistenciafechaInicio1.toString(),"yyyy-MM-dd"), 1)),"yyyy-MM-dd");
								}
								
								idPersonal2 = n2;
										
								n2++;						
	
							}						
							
						}
	
					}
					
					/*System.out.println("AsistenciafechaInicio1 -- > " + AsistenciafechaInicio1);				
					System.out.println("n2 fuera de Lista --> " + n2);				
					System.out.println("idPersonal2 para completar --> " + idPersonal2);*/
					
					if(idPersonal2 < numdia){					
						
						for(int i = idPersonal2 ; i <= numdia; i++){
							idPersonal2 =  i;						
							pa = new PersonalAsistenciaVO();
							pa.setPersonal(ps);
							pa.setDte_fecha(AsistenciafechaInicio1);
							pa.setStr_hor_ingreso("");
							pa.setStr_hor_salida("");						
							
							listaPersonalAsistencia1.add(pa);
							
							AsistenciafechaInicio1 =  Funciones.convertString2SqldateFormat(Funciones.fechaFormat("yyyy-MM-dd", Funciones.sumarDiasAFecha(Funciones.String2Date(AsistenciafechaInicio1.toString(),"yyyy-MM-dd"), 1)),"yyyy-MM-dd");
							
						}
					}
					
					
				}
				
				/*System.out.println("n2 para llenar lista final --> " + n2);
				System.out.println("idPersonal2 para llenar lista final --> " + idPersonal2);*/
				
				if(idPersonal2 == numdia){
//					System.out.println(x.getPersonal().getApepat() + " " + x.getPersonal().getApemat());
					par = new PersonalAsistenciaResumenVO();						
					par	= personalService.listarPersonalResumenAsistenciaRecord(AsistenciafechaInicio, AsistenciafechaFin, 0, x.getPersonal().getIdpersonal(), 0);
	
					
					for(int jj=0; jj < 3; jj++){
						parObj	= new PersonalAsistenciaRecordVO();
						parObj.setPersonal(x.getPersonal());
						parObj.setAsistenciaResumen(par);
						
						if(jj== 0){
							
							parObj.setEntradasalida("");
							parObj.setDia1("1°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(0).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia2("2°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(1).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia3("3°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(2).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia4("4°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(3).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia5("5°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(4).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia6("6°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(5).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia7("7°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(6).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia8("8°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(7).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia9("9°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(8).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia10("10°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(9).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia11("11°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(10).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia12("12°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(11).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia13("13°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(12).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia14("14°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(13).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia15("15°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(14).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia16("16°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(15).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia17("17°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(16).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia18("18°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(17).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia19("19°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(18).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia20("20°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(19).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia21("21°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(20).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia22("22°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(21).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia23("23°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(22).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia24("24°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(23).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia25("25°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(24).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia26("26°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(25).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia27("27°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(26).getDte_fecha().toString(), "yyyy-MM-dd")));
							parObj.setDia28("28°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(27).getDte_fecha().toString(), "yyyy-MM-dd")));
							if(numdia > 28 )	parObj.setDia29("29°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(28).getDte_fecha().toString(), "yyyy-MM-dd")));
							if(numdia > 29)		parObj.setDia30("30°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(29).getDte_fecha().toString(), "yyyy-MM-dd")));		
							if(numdia == 31)	parObj.setDia31("31°\n"+Funciones.nombredia(Funciones.String2Date(listaPersonalAsistencia1.get(30).getDte_fecha().toString(), "yyyy-MM-dd")));
						
						}else if(jj== 1){
							
							parObj.setEntradasalida("E");
							parObj.setDia1(listaPersonalAsistencia1.get(0).getStr_hor_ingreso());
							parObj.setDia2(listaPersonalAsistencia1.get(1).getStr_hor_ingreso());
							parObj.setDia3(listaPersonalAsistencia1.get(2).getStr_hor_ingreso());
							parObj.setDia4(listaPersonalAsistencia1.get(3).getStr_hor_ingreso());
							parObj.setDia5(listaPersonalAsistencia1.get(4).getStr_hor_ingreso());
							parObj.setDia6(listaPersonalAsistencia1.get(5).getStr_hor_ingreso());
							parObj.setDia7(listaPersonalAsistencia1.get(6).getStr_hor_ingreso());
							parObj.setDia8(listaPersonalAsistencia1.get(7).getStr_hor_ingreso());
							parObj.setDia9(listaPersonalAsistencia1.get(8).getStr_hor_ingreso());
							parObj.setDia10(listaPersonalAsistencia1.get(9).getStr_hor_ingreso());
							parObj.setDia11(listaPersonalAsistencia1.get(10).getStr_hor_ingreso());
							parObj.setDia12(listaPersonalAsistencia1.get(11).getStr_hor_ingreso());
							parObj.setDia13(listaPersonalAsistencia1.get(12).getStr_hor_ingreso());
							parObj.setDia14(listaPersonalAsistencia1.get(13).getStr_hor_ingreso());
							parObj.setDia15(listaPersonalAsistencia1.get(14).getStr_hor_ingreso());
							parObj.setDia16(listaPersonalAsistencia1.get(15).getStr_hor_ingreso());
							parObj.setDia17(listaPersonalAsistencia1.get(16).getStr_hor_ingreso());
							parObj.setDia18(listaPersonalAsistencia1.get(17).getStr_hor_ingreso());
							parObj.setDia19(listaPersonalAsistencia1.get(18).getStr_hor_ingreso());
							parObj.setDia20(listaPersonalAsistencia1.get(19).getStr_hor_ingreso());
							parObj.setDia21(listaPersonalAsistencia1.get(20).getStr_hor_ingreso());
							parObj.setDia22(listaPersonalAsistencia1.get(21).getStr_hor_ingreso());
							parObj.setDia23(listaPersonalAsistencia1.get(22).getStr_hor_ingreso());
							parObj.setDia24(listaPersonalAsistencia1.get(23).getStr_hor_ingreso());
							parObj.setDia25(listaPersonalAsistencia1.get(24).getStr_hor_ingreso());
							parObj.setDia26(listaPersonalAsistencia1.get(25).getStr_hor_ingreso());
							parObj.setDia27(listaPersonalAsistencia1.get(26).getStr_hor_ingreso());
							parObj.setDia28(listaPersonalAsistencia1.get(27).getStr_hor_ingreso());
							if(numdia > 28 )	parObj.setDia29(listaPersonalAsistencia1.get(28).getStr_hor_ingreso());
							if(numdia > 29)		parObj.setDia30(listaPersonalAsistencia1.get(29).getStr_hor_ingreso());		
							if(numdia == 31)	parObj.setDia31(listaPersonalAsistencia1.get(30).getStr_hor_ingreso());										
												
						}else if(jj== 2){
							parObj.setEntradasalida("S");
							parObj.setDia1(listaPersonalAsistencia1.get(0).getStr_hor_salida());
							parObj.setDia2(listaPersonalAsistencia1.get(1).getStr_hor_salida());
							parObj.setDia3(listaPersonalAsistencia1.get(2).getStr_hor_salida());
							parObj.setDia4(listaPersonalAsistencia1.get(3).getStr_hor_salida());
							parObj.setDia5(listaPersonalAsistencia1.get(4).getStr_hor_salida());
							parObj.setDia6(listaPersonalAsistencia1.get(5).getStr_hor_salida());
							parObj.setDia7(listaPersonalAsistencia1.get(6).getStr_hor_salida());
							parObj.setDia8(listaPersonalAsistencia1.get(7).getStr_hor_salida());
							parObj.setDia9(listaPersonalAsistencia1.get(8).getStr_hor_salida());
							parObj.setDia10(listaPersonalAsistencia1.get(9).getStr_hor_salida());
							parObj.setDia11(listaPersonalAsistencia1.get(10).getStr_hor_salida());
							parObj.setDia12(listaPersonalAsistencia1.get(11).getStr_hor_salida());
							parObj.setDia13(listaPersonalAsistencia1.get(12).getStr_hor_salida());
							parObj.setDia14(listaPersonalAsistencia1.get(13).getStr_hor_salida());
							parObj.setDia15(listaPersonalAsistencia1.get(14).getStr_hor_salida());
							parObj.setDia16(listaPersonalAsistencia1.get(15).getStr_hor_salida());
							parObj.setDia17(listaPersonalAsistencia1.get(16).getStr_hor_salida());
							parObj.setDia18(listaPersonalAsistencia1.get(17).getStr_hor_salida());
							parObj.setDia19(listaPersonalAsistencia1.get(18).getStr_hor_salida());
							parObj.setDia20(listaPersonalAsistencia1.get(19).getStr_hor_salida());
							parObj.setDia21(listaPersonalAsistencia1.get(20).getStr_hor_salida());
							parObj.setDia22(listaPersonalAsistencia1.get(21).getStr_hor_salida());
							parObj.setDia23(listaPersonalAsistencia1.get(22).getStr_hor_salida());
							parObj.setDia24(listaPersonalAsistencia1.get(23).getStr_hor_salida());
							parObj.setDia25(listaPersonalAsistencia1.get(24).getStr_hor_salida());
							parObj.setDia26(listaPersonalAsistencia1.get(25).getStr_hor_salida());
							parObj.setDia27(listaPersonalAsistencia1.get(26).getStr_hor_salida());
							parObj.setDia28(listaPersonalAsistencia1.get(27).getStr_hor_salida());
							if(numdia > 28)		parObj.setDia29(listaPersonalAsistencia1.get(28).getStr_hor_salida());
							if(numdia > 29)		parObj.setDia30(listaPersonalAsistencia1.get(29).getStr_hor_salida());		
							if(numdia == 31)	parObj.setDia31(listaPersonalAsistencia1.get(30).getStr_hor_salida());								
							
						}
						
						listaPersonalAsistenciaRecord.add(parObj);
					}							
	
					n2 = 0;				
				}			
	
				idPersonalRecord	= x.getPersonal().getIdpersonal();				
				
			}
		}
		
	}
	
	
	
	public String reportes(){
		
		String MSGTRX 			= null;
		String Ubicacion		= null;
		String regContract		= null;
		String tituloReporte	= null;
		ResourceBundle rb		= null;
		String title_asistencia	= null;
		
		try {
			
			if(tiempoReportePersonal >= 0){
				
				rb = ResourceBundle.getBundle("personal");
				
				if(tiempoReportePersonal == 0){

					tituloReporte	= "DESDE  " + Funciones.fechaFormat("dd/MM/yyyy", AsistenciafechaInicio) + "  -  HASTA  " + Funciones.fechaFormat("dd/MM/yyyy", AsistenciafechaFin);
					
				}else if(tiempoReportePersonal == 1){
					
					tituloReporte				= "PERIODO : " + Funciones.nombreMes(mesdesc) + " - " + periododesc;
					
					if(mesdesc < 10){
						AsistenciafechaInicio 	= Funciones.convertString2SqldateFormat(periododesc+"-"+"0"+mesdesc+"-01","yyyy-MM-dd");
					}else{
						AsistenciafechaInicio 	= Funciones.convertString2SqldateFormat(periododesc+"-"+mesdesc+"-01","yyyy-MM-dd");
					}
					
					AsistenciafechaFin 			= Funciones.convertString2SqldateFormat(Funciones.fechaFormat("yyyy-MM-dd", 
													Funciones.getUltimoDiaDelMes(AsistenciafechaInicio)),"yyyy-MM-dd");
				}				

				
				if(tipoReporte == 1 || tipoReporte == 0 || tipoReporte == -1){
					this.listarAsistenciasPersonal();	
					
				}else if(tipoReporte == 2){
					this.listarPersonalporActividad();		

				}else if(tipoReporte == 3){
					this.listarPersonalResumenAsistencia();
				}else if(tipoReporte == 4){
					this.listarPersonalRecordAsistencias();
				}

				if (idregimenContractual > 0){
					this.listRegimenContractual();
					if(idregimenContractual == 1){
						regContract	= regimenContractual.get(0).getVar_descripcion_regimen_contractual().toUpperCase();
					}else if(idregimenContractual == 3){
						regContract	= regimenContractual.get(1).getVar_descripcion_regimen_contractual().toUpperCase();
					}
				}else{
					regContract="";
				}
				
				
				if(ubicacionPersonal == 0){
					Ubicacion ="  -  SEDE CENTRAL";
				}else if(ubicacionPersonal == 1){
					Ubicacion ="  -  ÁREAS NATURALES";
				}else{
					Ubicacion ="";
				}
				
				if(tipoReporte == -1){					
					title_asistencia	= " "+rb.getString("title_report_is") + " ";
				}else if(tipoReporte == 0){
					title_asistencia	= " "+rb.getString("title_report_a") + " ";					
				}else if(tipoReporte == 1){
					title_asistencia	= " "+rb.getString("title_report_i") + " ";
				}
				
				if(tipoReporte <= 1){
					Ubicacion	= title_asistencia + regContract + Ubicacion;
				}else{
					Ubicacion	= regContract + Ubicacion;	
				}
													
				reportParams.put("SUBREPORT_DIR", rb.getString("ruta.logo"));
				reportParams.put("tipoReporte", tituloReporte);
				reportParams.put("Ubicacion", Ubicacion);
			
				MSGTRX	= SUCCESS;
				
			}else{
				MSGTRX	= ERROR;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			MSGTRX = ERROR;
		}	
		
		return MSGTRX;
		
	}
		
	
/*------------------ FIN REPOTES ------------------------------*/	
	
		
		
	public int cantidadtardanzasgeneradas(){
		int tardanzas	= personalService.tardanzasgeneradas(
							Funciones.sumarMesesAFecha(Funciones.getPrimerDiaDelMes(), -1).toString(), 
							Funciones.getUltimoDiaDelMes(Funciones.sumarMesesAFecha(Funciones.getPrimerDiaDelMes(), -1)).toString());

		return tardanzas;
	}
	
	
	
	public void obtenerListaTardanzas(int descValidados, int ubicacion, int idreg){
		
		try {		
			
			Date fechaFiltro = null;//Date.valueOf(periododesc+"-"+mesdesc+"-01");
			if(mesdesc < 10){
				fechaFiltro = Date.valueOf(periododesc+"-"+"0"+mesdesc+"-01");
			}else{
				fechaFiltro = Date.valueOf(periododesc+"-"+mesdesc+"-01");
			}
			
			listapersonaltardanza		= personalService.listapersonalconTardanza(fechaFiltro.toString(),	
					Funciones.getUltimoDiaDelMes(fechaFiltro).toString(),descValidados, ubicacion, idreg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
public void contardescuentosvalidadosxperiodo(){
	String mesofcontdesc			= null;
	String mesofefectuadesc			= null;
	int periodofcontdesc			= 0;		
	int periodoefectuadesc			= 0;
		/*--- SIEMPRE SE CONSIDERA UN MES ANTERIOR PARA EL NRO DE MES DEL DESCUENTO*/
		descValidados	= personalService.contardescuentosvalidadosxperiodo(Funciones.obtenerAnioOfDescuento(),	Funciones.obtenerNroMesDescuento() + 1, ubicacionPersonal, idANP,idregimenContractual);		

		mesofcontdesc			= Funciones.nombreMes(Funciones.obtenerNroMesDescuento() + 1 ).toUpperCase();
		periodofcontdesc		= Funciones.obtenerAnioOfDescuento();
		
		int_mes_desc			= Funciones.obtenerNroMesDescuento() + 1;
		int_periodo_desc		= periodofcontdesc;
		isajax					= 0;
		
		if(Funciones.obtenerNroMesDescuento() == 12){
			mesofefectuadesc	= Funciones.nombreMes(1).toUpperCase();
			periodoefectuadesc	= Funciones.obtenerAnioOfDescuento() + 1;
		}else{
			mesofefectuadesc	= Funciones.nombreMes(Funciones.obtenerNroMesDescuento() + 2).toUpperCase();
			periodoefectuadesc	= Funciones.obtenerAnioOfDescuento();
		}			
		
		reportParams.put("mesofcontdesc", mesofcontdesc);
		reportParams.put("periodofcontdesc", periodofcontdesc);
		reportParams.put("mesofefectuadesc", mesofefectuadesc);
		reportParams.put("periodoefectuadesc", periodoefectuadesc);
		reportParams.put("descValidados", descValidados);
		
//		reportParams.put("cantdescuentos", listapersonaldescuentos.size());
		reportParams.put("cantdescuentos", 1);
	}
	

	public String listapersonalDescuentoView(){
		
		this.listRegimenContractual();
		
		listaaniosDescuentos 	= personalService.listarPeriodoMesDescuento(0);			
		listamesDescuentos		= personalService.listarPeriodoMesDescuento(1);
		
		contardescuentosvalidadosxperiodo();
		
		return SUCCESS;
		
	}
	
	
	
	public String listapersonalDescuento(){
		
		HttpServletRequest request 		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session 	= ActionContext.getContext().getSession();
		
		String mesofcontdesc			= null;
		String mesofefectuadesc			= null;
		int periodofcontdesc			= 0;		
		int periodoefectuadesc			= 0;
		String apepat					= null;
		areanatural 					= (Areanatural) session.get("area");
		dtpage 							= request.getParameter("d-16544-p");
		Date fechaFiltro 				= null;//Date.valueOf(periododesc+"-"+"0"+mesdesc+"-01");	
			
			
		if (request.getParameter("aPaterno") != null){
			apepat = request.getParameter("aPaterno");
		}

		if(periododesc > 0 && mesdesc > 0 ){
			if(mesdesc < 10){
				fechaFiltro = Date.valueOf(periododesc+"-"+"0"+mesdesc+"-01");
			}else{
				fechaFiltro = Date.valueOf(periododesc+"-"+mesdesc+"-01");
			}			
						
			descValidados	= personalService.contardescuentosvalidadosxperiodo(periododesc, mesdesc, ubicacionPersonal, idANP, idregimenContractual);				
		
			if (descValidados == 0 && isajax == 1){
				
				personalService.eliminarDescuentosTmp();
				
				personalService.guardarListaDescuentos(Funciones.getPrimerDiaDelMesWithParameter(fechaFiltro).toString(), 
						Funciones.getUltimoDiaDelMes(fechaFiltro).toString(), periododesc, mesdesc, -1, idregimenContractual, idANP,
						ValueConstants.NombreTablaDescTMP);
			}
			
			listapersonaldescuentos		= personalService.listapersonalDescuento(
					Funciones.getPrimerDiaDelMesWithParameter(fechaFiltro).toString(), 
					Funciones.getUltimoDiaDelMes(fechaFiltro).toString(),										
					periododesc, mesdesc,apepat,descValidados, idregimenContractual, ubicacionPersonal, idANP);
			
			mesofcontdesc			= Funciones.nombreMes(mesdesc).toUpperCase();
			periodofcontdesc		= periododesc;
			
			if(mesdesc == 12){
				mesofefectuadesc	= Funciones.nombreMes(1).toUpperCase();
				periodoefectuadesc	= periododesc + 1;
			}else{
				mesofefectuadesc	= Funciones.nombreMes(mesdesc + 1).toUpperCase();
				periodoefectuadesc	= periododesc;
			}
			
			
		}else{				
			
			listapersonaldescuentos		= personalService.listapersonalDescuento(
					Funciones.sumarMesesAFecha(Funciones.getPrimerDiaDelMes(), -1).toString(), 
					Funciones.getUltimoDiaDelMes(Funciones.sumarMesesAFecha(Funciones.getPrimerDiaDelMes(), -1)).toString(),										
					Funciones.obtenerAnioOfDescuento(), Funciones.obtenerNroMesDescuento() + 1,apepat,descValidados, idregimenContractual, ubicacionPersonal, idANP);
			
			
			mesofcontdesc			= Funciones.nombreMes(Funciones.obtenerNroMesDescuento()).toUpperCase();
			periodofcontdesc		= Funciones.obtenerAnioOfDescuento();
			
			if(Funciones.obtenerNroMesDescuento() == 12){
				mesofefectuadesc	= Funciones.nombreMes(1).toUpperCase();
				periodoefectuadesc	= Funciones.obtenerAnioOfDescuento() + 1;
			}else{
				mesofefectuadesc	= Funciones.nombreMes(Funciones.obtenerNroMesDescuento() + 1).toUpperCase();
				periodoefectuadesc	= Funciones.obtenerAnioOfDescuento();
			}
			
		}

		reportParams.put("mesofcontdesc", mesofcontdesc);
		reportParams.put("periodofcontdesc", periodofcontdesc);
		reportParams.put("mesofefectuadesc", mesofefectuadesc);
		reportParams.put("periodoefectuadesc", periodoefectuadesc);
		reportParams.put("descValidados", descValidados);
		
		if(listapersonaldescuentos.size() == 0)addActionMessage("No éxiste información registrada y/o procesada del periodo: " + mesofcontdesc +" - "+periodofcontdesc);
//		if(descValidados != 0)addActionMessage("REPORTE DESCUENTO CERRADO: " + mesofcontdesc +" - "+periodofcontdesc);	
		
		reportParams.put("cantdescuentos", listapersonaldescuentos.size());		
		ResourceBundle rb = ResourceBundle.getBundle("personal");	
		reportParams.put("SUBREPORT_DIR", rb.getString("ruta.logo"));		


		return SUCCESS;
	}
	
		
	

	

	public String personalGeneraDescuento(){
		
		String MSGTRX					= null;
		
		try {
			HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			Map<String, Object> session = ActionContext.getContext().getSession();
			areanatural 				= (Areanatural) session.get("area");
			dtpage 						= request.getParameter("d-16544-p");
			Date fechaFiltro 			= null;//Date.valueOf(periododesc+"-"+mesdesc+"-01");			
			
			descValidados	= personalService.contardescuentosvalidadosxperiodo(periododesc, mesdesc, ubicacionPersonal, idANP, idregimenContractual);
			
			if(periododesc > 0 && mesdesc > 0 ){
				if(mesdesc < 10){
					fechaFiltro = Date.valueOf(periododesc+"-"+"0"+mesdesc+"-01");
				}else{
					fechaFiltro = Date.valueOf(periododesc+"-"+mesdesc+"-01");
				}
			}
			
			if(descValidados 	== 0){
				personalService.eliminarDescuentosTmp();
				obtenerListaTardanzas(1, ubicacionPersonal, idregimenContractual);//El valor (1), es un parametro que obtiene los minutos de tardanza por fecha para registrarlos en la BD.

				if (listapersonaltardanza.size() > 0)	personalService.guardarListaTardanza(listapersonaltardanza);
				
				personalService.guardarListaDescuentos(fechaFiltro.toString(), Funciones.getUltimoDiaDelMes(fechaFiltro).toString(), 
						periododesc, mesdesc, ubicacionPersonal, idregimenContractual, idANP, ValueConstants.NombreTablaDesc);

				descValidados	= personalService.contardescuentosvalidadosxperiodo(periododesc, mesdesc, ubicacionPersonal, idANP, idregimenContractual);
				
				if(descValidados > 0){	
					MSGTRX = SUCCESS;
					datos.put("MsgExito", "LOS DESCUENTOS SE VALIDARON CON ÉXITO");							
				}else{
					MSGTRX = SUCCESS;
					datos.put("MsgExito", "NO ÉXISTE DESCUENTOS PARA VALIDAR.");					
				}					
			}			

			
		} catch (Exception e) {
			e.printStackTrace();
			MSGTRX = ERROR;
		}			
		
		datos.put("MsgTrx", MSGTRX);
		
		return MSGTRX;
	}
	
	
	public String listaInasistenciasxidPersonal(){
		HttpServletRequest request  = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural 				= (Areanatural) session.get("area");
		String [] periodoAsist		= null;
				
		
		if(request.getParameter("idPersonal") != null){
			Date fechaFiltro = null;//Date.valueOf(periododesc+"-"+mesdesc+"-01");
			
			personanatural 				= personalService.listapersonalxID(idPersonal);
			
//			System.out.println("dte_fec_marc : " + dte_fec_marc);
			if (dte_fec_marc == null){
				if(mesdesc < 10){
					fechaFiltro = Date.valueOf(periododesc+"-"+"0"+mesdesc+"-01");
				}else{
					fechaFiltro = Date.valueOf(periododesc+"-"+mesdesc+"-01");
				}

			}else{
				periodoAsist = dte_fec_marc.split("/");
				periododesc = Integer.valueOf(periodoAsist[2]);
				mesdesc		= Integer.valueOf(periodoAsist[1]);
				
				if(mesdesc < 10){
					fechaFiltro = Date.valueOf(periododesc+"-"+"0"+mesdesc+"-01");
				}else{
					fechaFiltro = Date.valueOf(periododesc+"-"+mesdesc+"-01");
				}
			}
			
			listapersonalinasistencias  = personalService.listainasistenciasPermisosxidpersonal(periododesc, mesdesc, idPersonal,	fechaFiltro.toString(),	Funciones.getUltimoDiaDelMes(fechaFiltro).toString(), 0);
			
			ServletActionContext.getRequest().setAttribute("mesIP", mesdesc);
			ServletActionContext.getRequest().setAttribute("periodoIP", periododesc);
			ServletActionContext.getRequest().setAttribute("Inasistencias", listapersonalinasistencias.size());
			if (dte_fec_marc == null){
				if(listapersonalinasistencias.size() == 0){
					addActionMessage("Disculpe! Solo muestra Inasistencia(s) y/o Permiso(s).");	
				}
			}else{
				if(listapersonalinasistencias.size() == 0){
					addActionMessage("No tiene Inasistencias.");	
				}
			}
		}
		
		return SUCCESS;
	}

	
	
	
	
	/*-------- PROGRAMACIÓN PARA GENERAR, REGISTRAR EL ROL DE VACACIONES - ASIMISMO REGISTRAR Y EDITAR VACACIONES PROGRAMADAS ---------------*/
	
	
	
	
	
	public String listarVacaciones(){
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String apepat				= null;
		dtpage 						= request.getParameter("d-16544-p");
		try {

			if(request.getParameter("periodoVacaciones") == null || request.getParameter("periodoVacaciones").isEmpty() ){

				periodoVacaciones		= Integer.valueOf(Funciones.fechaHoy("yyyy"));
			}else{
				periodoVacaciones	= Integer.valueOf(request.getParameter("periodoVacaciones"));
			}

			if (request.getParameter("aPaterno") != null)	apepat 	= request.getParameter("aPaterno");
			
			listapersonalVacaciones = personalVacacionesService.listapersonalVacacionesProyecto(apepat, periodoVacaciones, idregimenContractual, ubicacionPersonal, idANP, estadoPersonal);

			
		} catch (Exception e) {
			e.printStackTrace();
		}		

	
		return SUCCESS;
	}
	
	
	
	
	
	public String listarPeriodoVacaciones(){

		try {

			periodoVacaciones		= Integer.valueOf(Funciones.fechaHoy("yyyy"));
			listaPeriodosVacaciones = personalVacacionesService.listaPeriodosVacaciones(periodoVacaciones);
			this.listRegimenContractual();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return SUCCESS;
	}
	
	
	
	
	public String vacacionesPendientesxidPersonal(){
		try {
			personanatural 				= personalService.listapersonalxID(idPersonal);		
			listapersonalVacaciones 	= personalVacacionesService.vacacionesPendientesxidPersonal(idPersonal, periodoVacaciones);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	public String listaVacacionesxidPersonal(){
		int addProgVac				= 0;
		int diasPendientes			= 0;
		int diasCorresponde			= 0;
		int ndiasProgramaVac		= 0;
		int ndiasPrograma			= 0;
		String strReturn			= null;
		int ndiasGoceVac			= 0;
		
		listapersonalVacaciones 	= personalVacacionesService.obtieneVacacionesAutorizadasxidP(idPersonal);
		
		for(PersonalVacacionesVO x : listapersonalVacaciones){
			if (x.getInt_est_vacaciones() > 0){
				if(isajax == null)	periodoVacaciones 	= x.getInt_periodo_vac();
				f_inicioVac			= x.getDte_fec_inicio_programacion_vac();
				diasCorresponde		= x.getInt_dias_vac_corresponde();
				ndiasProgramaVac	= x.getInt_dias_vac_goce();			
				addProgVac = 1;		
				ServletActionContext.getRequest().setAttribute("f_inicioVac_dataTable",	Funciones.fechaFormat("dd/MM/yyyy",	f_inicioVac));
				ServletActionContext.getRequest().setAttribute("diasCorresponde_dataTable",	diasCorresponde);
				ServletActionContext.getRequest().setAttribute("diasGoce_dataTable", ndiasProgramaVac);
				break;			 
			}
		}
				
		
		if (isajax == null){		
	
			personanatural 			= personalService.listapersonalxID(idPersonal);
			listaPeriodosVacaciones = personalVacacionesService.listaPeriodosVacaciones(Integer.valueOf(Funciones.fechaHoy("yyyy")));
			
			strReturn = SUCCESS;
			
		}else{
			for(PersonalVacacionesVO x : listapersonalVacaciones){				
				if(periodoVacaciones 	== x.getInt_periodo_vac()){
					f_inicioVac			= x.getDte_fec_inicio_programacion_vac();
					diasCorresponde		= x.getInt_dias_vac_corresponde();
					ndiasProgramaVac	= x.getInt_dias_vac_goce();			
					addProgVac = 1;		
					ServletActionContext.getRequest().setAttribute("f_inicioVac_dataTable",	Funciones.fechaFormat("dd/MM/yyyy",	f_inicioVac));
					ServletActionContext.getRequest().setAttribute("diasCorresponde_dataTable",	diasCorresponde);
					ServletActionContext.getRequest().setAttribute("diasGoce_dataTable", ndiasProgramaVac);
					break;					
				}				
			}

			diasCorresponde		= 0;
			ndiasProgramaVac	= 0;		
				
			listapersonalVacacionesGoce	= personalVacacionesService.listaVacacionesxidpersonal(idPersonal,periodoVacaciones);
			
			for(PersonalVacacionesGoceVO x : listapersonalVacacionesGoce){
				ndiasGoceVac  += x.getInt_dias_goce_vac();
				
			}	
			
			if(listapersonalVacacionesGoce.size() >= 1 ){
				if(listapersonalVacacionesGoce.get(0).getDte_fec_inicio_goc_vac() == null){
	
					if(f_inicioVac.after(Funciones.convertString2SqldateFormat(Funciones.fechaHoy("yyyy-MM-dd"), "yyyy-MM-dd"))){
						addProgVac = 0;	
					}
				}
				
				if(addProgVac > 0){
					if(listapersonalVacacionesGoce.get(0).getPersonalVacaciones().getInt_est_vacaciones() > 0){	//Puede agregar vacaciones
						
						//2: No ha utilizado sus vacaciones, 1: Parcialmente utilizadas, 0: Utilizadas en totalidad				
						
						diasCorresponde = listapersonalVacacionesGoce.get(0).getPersonalVacaciones().getInt_dias_vac_corresponde();
				
						for(PersonalVacacionesGoceVO x : listapersonalVacacionesGoce){
							if(x.getInt_dias_goce_vac() > 0 ){//Si se puede agregar vacaciones
								ndiasPrograma = x.getInt_dias_goce_vac() + ndiasPrograma;
							}
						}
						
						if(ndiasPrograma == diasCorresponde) addProgVac = 0;
						
						diasPendientes = diasCorresponde - ndiasPrograma;						
						
						if(diasPendientes < 14){
							ndiasProgramaVac = diasPendientes; 			
						}else{
							ndiasProgramaVac = 7;
						}
						
						ServletActionContext.getRequest().setAttribute("diasPendientes",  diasPendientes - ndiasProgramaVac);
						personalVacaciones.setInt_dias_vac_pendientes(diasCorresponde - ndiasGoceVac);
						ServletActionContext.getRequest().setAttribute("AddProgVac", addProgVac);
						
	//					if(addProgVac > 0 ){
							
							if(listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getDte_fec_fin_goc_vac() != null){
								ServletActionContext.getRequest().setAttribute("fechaFinVacacUtilizadas", 
										Funciones.fechaFormat("dd/MM/yyyy",
										Funciones.sumaDias(listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getDte_fec_fin_goc_vac(), 1)));					
	
								ServletActionContext.getRequest().setAttribute("fechaFinVacacadd7",
										Funciones.fechaFormat("dd/MM/yyyy",
										Funciones.sumaDias(listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getDte_fec_fin_goc_vac(), ndiasProgramaVac)));
							
								personalVacacionesGoce.setDte_fec_inicio_goc_vac(
										Funciones.convertString2SqldateFormat(
										Funciones.fechaFormat("dd/MM/yyyy",
										Funciones.sumaDias(listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getDte_fec_fin_goc_vac(), 1)),"dd/MM/yyyy"));
								personalVacacionesGoce.setDte_fec_fin_goc_vac(
										Funciones.convertString2SqldateFormat(
										Funciones.fechaFormat("dd/MM/yyyy",
										Funciones.sumaDias(listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getDte_fec_fin_goc_vac(), ndiasProgramaVac)),"dd/MM/yyyy"));						
							}else{
								personalVacacionesGoce.setDte_fec_inicio_goc_vac(
										Funciones.convertString2SqldateFormat(Funciones.fechaFormat("dd/MM/yyyy",
										listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getPersonalVacaciones().getDte_fec_inicio_programacion_vac()),"dd/MM/yyyy"));
								personalVacacionesGoce.setDte_fec_fin_goc_vac(
										Funciones.convertString2SqldateFormat(
										Funciones.fechaFormat("dd/MM/yyyy",	Funciones.sumaDias(
										listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getPersonalVacaciones().getDte_fec_inicio_programacion_vac(), ndiasProgramaVac - 1)),"dd/MM/yyyy"));	
								
								ServletActionContext.getRequest().setAttribute("fechaFinVacacUtilizadas", 
										Funciones.fechaFormat("dd/MM/yyyy",
										listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getPersonalVacaciones().getDte_fec_inicio_programacion_vac()));					
	
								ServletActionContext.getRequest().setAttribute("fechaFinVacacadd7",
										Funciones.fechaFormat("dd/MM/yyyy",	Funciones.sumaDias(
										listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getPersonalVacaciones().getDte_fec_inicio_programacion_vac(), ndiasProgramaVac - 1)));						
							}
							
							personalVacacionesGoce.setInt_dias_goce_vac(ndiasProgramaVac);
							personalVacacionesGoce.setId_pers_vac(listapersonalVacacionesGoce.get(0).getPersonalVacaciones().getSrl_id_pers_vac());
								
	//					}
					
					}else{
						addActionMessage("Vacaciones utilizadas.");
					}
				}else{
					if (listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getSrl_id_pers_goce_vac() == 0){
						ServletActionContext.getRequest().setAttribute("f_iniProgVaciones", Funciones.fechaFormat("dd/MM/yyyy",f_inicioVac));
						addActionMessage("La programación de vacaciones se realiza a partir de la fecha programada!!!");//Se considera que debe estar autorizado para el periodo					
					}
	
				}
				ServletActionContext.getRequest().setAttribute("tieneVacacionesconGoce",listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 1).getSrl_id_pers_goce_vac());
			}
	
				strReturn = "ajax";
			
		}
	
		ServletActionContext.getRequest().setAttribute("periodoVacaciones", periodoVacaciones);	
		return strReturn;
		
	}
	
	

	
	public String insertarVacacionesPersonal(){
		String MSGTRX 				= null;
		Map<String,Object> session 	= ActionContext.getContext().getSession();	
		
		try{
			user			= (Usuario)session.get("USUARIO_ACTUAL");		
			
			if(personalVacacionesGoce.getInt_dias_goce_vac() <= 30 && personalVacacionesGoce.getInt_dias_goce_vac() > 0){
				personalVacacionesService.insertarVacacionesPersonal(personalVacacionesGoce, idPersonal);
				addActionMessage("Se agregó con éxito");	
				MSGTRX	= SUCCESS;				
			}else{
				addActionMessage("Inconsistencia en cantidad de días.");
				MSGTRX = ERROR;
			}			
		
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción");
			MSGTRX = ERROR;
		}
		
		return MSGTRX;
	}
	
	
	
	
	public String eliminarVacacionesProgramada(){
		String MSGTRX 	= null;	
		try {
			
			personalVacacionesService.eliminarVacacionesProgramada(idPersonal, periodoVacaciones, idVacaciones, idVacacionesGoce);
			addActionMessage("Se eliminó con éxito");
			MSGTRX	= SUCCESS;	
		} catch (Exception e) {
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción, vuelva a intentarlo");
			MSGTRX	= ERROR;	
		}
		
		return MSGTRX;
	}
	

	public String editarVacacionesPersonal(){

		String MSGTRX 		= null;	
		
		try{

			personanatural 				= personalService.listapersonalxID(idPersonal);
			listapersonalVacacionesGoce	= personalVacacionesService.listaVacacionesxidpersonal(idPersonal,periodoVacaciones);
			personalVacacionesGoce 		= personalVacacionesService.obtenerVacacionesProgramadaxid(idVacacionesGoce);			
			idVacaciones				= personalVacacionesGoce.getPersonalVacaciones().getSrl_id_pers_vac();
			if(listapersonalVacacionesGoce.size() > 1 ){
				ServletActionContext.getRequest().setAttribute("f_inicioVacLimitar",
						Funciones.fechaFormat("dd/MM/yyyy",Funciones.sumaDias(
								listapersonalVacacionesGoce.get(listapersonalVacacionesGoce.size() - 2).getDte_fec_fin_goc_vac(), 1)));				
			}else{
				ServletActionContext.getRequest().setAttribute("f_inicioVacLimitar",Funciones.fechaFormat("dd/MM/yyyy",personalVacacionesGoce.getDte_fec_inicio_goc_vac()));
			}
				ServletActionContext.getRequest().setAttribute("f_inicioVac",Funciones.fechaFormat("dd/MM/yyyy",personalVacacionesGoce.getDte_fec_inicio_goc_vac()));					
				ServletActionContext.getRequest().setAttribute("f_finVac",	Funciones.fechaFormat("dd/MM/yyyy",personalVacacionesGoce.getDte_fec_fin_goc_vac()));
			
			
			MSGTRX	= SUCCESS;	
		}catch(Exception e){
			e.printStackTrace();
			MSGTRX = ERROR;
		}
		
		datos.put("MsgTrx", MSGTRX);
		return SUCCESS;
	}
	
	
	
	
	public String updateVacacionesPersonal(){
		String MSGTRX 	= null;	
	
		try{
			
//			System.out.println("idVacaciones -  idVacacionesGoce : " + idVacaciones +" - "+ idVacacionesGoce);
			
			if(idVacaciones > 0 && idVacacionesGoce > 0 ){
				personalVacacionesGoce.setSrl_id_pers_goce_vac(idVacacionesGoce);
			}

			personalVacacionesService.updateVacacionesPersonal(personalVacacionesGoce, idVacaciones, idVacacionesGoce, idPersonal);
			if(idVacaciones > 0 && idVacacionesGoce > 0){
				addActionMessage("Se cerró con éxito");
			}else{
				addActionMessage("Se actualizó con éxito");	
			}
				
			MSGTRX	= SUCCESS;			
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción");
			MSGTRX = ERROR;
		}
		
//		datos.put("MsgTrx", MSGTRX);
		return MSGTRX;
	}
	

	
	
	
	
	public String cantdiasentre2fechas(){
		String MSGTRX 				= null;
		int ndiasPendientes			= 0;
		int ndiasentredosfechas		= 0;
		int ndiasProgramaPost		= 0;
		int vacacionesRangoFechas	= 0;
		int licenciasRangoFechas	= 0;
//		System.out.println("Inicio : " + f_inicioVac + " - Fin : "+ f_finVac);
		try{			
			
			if (idPersonal > 0 && periodoVacaciones > 0){
//				
				ndiasPendientes			= personalVacacionesService.vacacionesPendientesxPeriodoxidPersonal(idPersonal, periodoVacaciones);
				
				if(ndiasProgVac == 0){
					ndiasentredosfechas	= Funciones.diasTranscurridosEntre(f_inicioVac, f_finVac) + 1; //Se agrega un día porque, las vacaciones se contabilizan desde la fecha inicio
					datos.put("fechaFinVacacadd7", Funciones.fechaFormat("dd/MM/yyyy",	f_finVac));
				}else{
					ndiasentredosfechas = ndiasProgVac;
					datos.put("fechaFinVacacadd7", Funciones.fechaFormat("dd/MM/yyyy",	Funciones.sumaDias(f_inicioVac,(ndiasentredosfechas - 1))));				
				}
				
				ndiasProgramaPost 	= ndiasPendientes - ndiasentredosfechas;

				if (ndiasProgramaPost < 0 ){
//					datos.put("Msgdias", "Se recomienda que el periodo de vacaciones debe ser de: "+ ndiasPendientes +" días.");
//					if (ndiasProgramaPost  > 0){
//						MSGTRX = ERROR;	
//					}else if(ndiasProgramaPost < 0){
//						MSGTRX = ERROR;	
//					}else{
//						MSGTRX = SUCCESS;
//					}
//				}else if(ndiasentredosfechas < 7){
//					datos.put("Msgdias", "Los periodos de vacaciones debe ser de 7 días como mínimo.");
					MSGTRX = ERROR;					
				}else{
					MSGTRX = SUCCESS;					
				}
				
				datos.put("ndias",ndiasentredosfechas);
				datos.put("diasPendientes", ndiasProgramaPost);
			}else{
				
//				vacacionesRangoFechas	= personalVacacionesService.vacacionesRangoFechas(idPersonal, f_inicioVac, f_finVac);
	
				if(ndiasProgVac == 0){
					ndiasentredosfechas	= Funciones.diasTranscurridosEntre(f_inicioVac, f_finVac) + 1; 
				}else{
					ndiasentredosfechas = ndiasProgVac;	
				}				

				datos.put("fechaFinLic", Funciones.fechaFormat("dd/MM/yyyy",	Funciones.sumaDias(f_inicioVac,ndiasentredosfechas - 1)));
				datos.put("ndias",ndiasentredosfechas);
//				datos.put("vacaciones", vacacionesRangoFechas);
				MSGTRX = NONE;	
			}
				

		
		}catch(Exception e){
			e.printStackTrace();
			MSGTRX = ERROR;
		}
		
		datos.put("MsgTrx", MSGTRX);
		return SUCCESS;
	}
	
	
	/*-------- FIN VACACIONES---------------*/
	
	
	
	
	
	
	/*-------- PROGRAMACIÓN PARA REGISTRAR, EDITAR y CERRAR LICENCIAS  ---------------*/
	
	
	public String listaLicenciasxidPersonal(){
		String estadoAsist			= null;
//		int nro_Actividad = 0;
		
		try {

			personanatural 				= personalService.listapersonalxID(idPersonal);
//			listapersonalLicencias 		= personalLicenciasService.listaLicenciasxidPersonal(idPersonal);			
			listTipoLicencia 			= tipoService.listTipoLicencia();	
			listapersonalVacacionesGoce	= personalVacacionesService.listaVacacionesxidpersonal(idPersonal,periodoVacaciones);
			
			
			AniosLicenciasPersonalQueryCriteria criteria = new AniosLicenciasPersonalQueryCriteria();
			criteria.setInt_anio(null);
			
			anios_licencias_personal = buscarLicenciasPersonalService.getListByQuery(AniosLicenciasPersonalQueryMapper.class, criteria);
			
			MesesLicenciasPersonalQueryCriteria criteriaM = new MesesLicenciasPersonalQueryCriteria();
			criteriaM.setInt_mes(null);
			
			List<MesesLicenciasPersonalQuery> listMesLicencias = buscarLicenciasPersonalService.getListByQuery(MesesLicenciasPersonalQueryMapper.class, criteriaM);
			
			meses_licencias_personal =  new ArrayList<MesesLicenciasPersonalQuery>();
			
			for(int i = 0; i < listMesLicencias.size(); i++){
				
				MesesLicenciasPersonalQuery mes = new MesesLicenciasPersonalQuery();
				mes.setInt_mes(listMesLicencias.get(i).getInt_mes());				
				mes.setDescripcion(Funciones.nombreMes(listMesLicencias.get(i).getInt_mes()));				
				meses_licencias_personal.add(mes);
			}
			
			
			
			if(listapersonalLicencias.size() > 0 ){

						ServletActionContext.getRequest().setAttribute("fechaIniLic", 
								Funciones.fechaFormat("dd/MM/yyyy", listapersonalLicencias.get(listapersonalLicencias.size() - 1).getDte_fec_fin_lic()));
						ServletActionContext.getRequest().setAttribute("fechaFinLic", 
								Funciones.fechaFormat("dd/MM/yyyy", listapersonalLicencias.get(listapersonalLicencias.size() - 1).getDte_fec_fin_lic()));
			}else{

				ServletActionContext.getRequest().setAttribute("fechaIniLic", Funciones.fechaHoy("dd/MM/yyyy"));
				ServletActionContext.getRequest().setAttribute("fechaFinLic", Funciones.fechaHoy("dd/MM/yyyy"));
			}

			personalLicencias.setInt_dias_lic(1);//POR DEFECTO EXISTE UN DIA DE DIFERENCIA ENTRE LA FECHA DE INICIO Y FIN.	
			
			List<PersonalAsistenciaVO> pa	= new ArrayList<PersonalAsistenciaVO>();
			pa	= personalService.obtenerEstadoAsistencia(idPersonal,	fechaAsistenciaLic.toString());

			if(pa.size() > 0){
				if(pa.get(0).getEstado() == 2){
						estadoAsist = "Permiso";
				}else if(pa.get(0).getEstado() == 1){
					if(pa.get(0).getInt_vac_lic() == 2){
						estadoAsist = "Licencia sin goce";
					}else{
						if(pa.get(0).getEstadoTmp() == 1){
							estadoAsist = "Inasistencia";
						}else{
							estadoAsist = "Observado";
						}
					}
				}else{
					if(pa.get(0).getInt_vac_lic() == 1){
						estadoAsist = "Vacaciones";
					}else if(pa.get(0).getInt_vac_lic() == 2){					
						estadoAsist = "Licencia";
					}
				}

				ServletActionContext.getRequest().setAttribute("estadoAsist",estadoAsist);
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	public String insertarLicenciasPersonal(){
		
		Map<String,Object> session 	= ActionContext.getContext().getSession();		
		String MSGTRX 				= null;		

		try{
			user			= (Usuario)session.get("USUARIO_ACTUAL");

//			System.out.println("Licencias id : " +personalLicencias.getSrl_id_pers_lic());
			
			personalLicenciasService.insertarLicenciasPersonal(personalLicencias);
		
			if(personalLicencias.getSrl_id_pers_lic() > 0){
				addActionMessage("Se actualizó con éxito");			
			}else{
				addActionMessage("Se agregó con éxito");				
			}
			
			MSGTRX	= SUCCESS;			
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción");
			MSGTRX = ERROR;
		}
		
//		datos.put("MsgTrx", MSGTRX);		
		
		return MSGTRX;
	}
	
	
	public String cerrarLicenciasPersonal(){
		
		String MSGTRX 	= null;	

		try{
			
			if(idLicencia > 0){
				personalLicenciasService.cerrarLicenciasPersonal(idLicencia);
				MSGTRX	= SUCCESS;
			}					
			
		}catch(Exception e){
			e.printStackTrace();
			MSGTRX = ERROR;
		}
		
		datos.put("MsgTrx", MSGTRX);
		
		return SUCCESS;
	}
	
	
	
	public String eliminarLicencias(){
		String MSGTRX 	= null;	
		try {
			
			personalLicenciasService.eliminarLicenciasPersonal(idLicencia, idPersonal, f_inicioLic, f_finLic);
			addActionMessage("Se eliminó con éxito");
			MSGTRX	= SUCCESS;	
		} catch (Exception e) {
			e.printStackTrace();
			addActionMessage("No se pudo ejecutar la acción, vuelva a intentarlo");
			MSGTRX	= ERROR;	
		}
		
		return MSGTRX;
	}
	
		
	
	
	/*-------- FIN LICENCIAS ---------------*/
	
	
	public String grabarPapeleta(){

		String MSGTRX 							= "";
		int actividad							= 0;
		String fechaPerm_com					= null;
		
		try{	
			
			actividad 			= personalPapeleta.getPersonalActividad().getSrl_id_per_activ();// 0 es Comision de Servicio, 4 es para descuento
			fechaPerm_com		= personalPapeleta.getDte_fec_sal_desp().toString();			
			
			int personalconPC	= personalPapeletaService.verificaexistePermisoComision(personalPapeleta.getPersonal().getIdpersonal(),fechaPerm_com);
			
//			System.out.println("personalconPC : "+personalconPC);
			
			if (personalconPC >= 10 ){//Tiene Permiso

				datos.put("MsgDuplex", "El trabajador está de permiso.");
				MSGTRX = ERROR;		
				
				
			}else if (personalconPC == 1){//Tiene comision
				datos.put("MsgDuplex", "El trabajador ya tiene comisión registrada.");
				MSGTRX = ERROR;				
			
			}else {
				personalPapeletaService.guardarPapeleta(personalPapeleta, actividad);
				datos.put("MsgDuplex", "No puede registrar H. Salida, revise que no sea menor igual a la H. Ingreso" );
				MSGTRX = SUCCESS;
			}
		
		}catch(Exception e){
			e.printStackTrace();
			MSGTRX = ERROR;
		}
		
		datos.put("MsgTrx", MSGTRX);
		return SUCCESS;
	}

	
	
	public String registrarPapeleta(){		
        
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request  = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		areanatural 				= (Areanatural) session.get("area");
		int idpersonal				= 0;		
		String strReturn			= null;
		idpersonal 					= Integer.valueOf(request.getParameter("idpersonal"));
		personal.setIdpersonal(idpersonal);
		personalPapeleta.setPersonal(personal);
		
		strReturn = "RegPapeleta";		
		
		personanatural 				= personalService.listapersonalxID(idpersonal);		
		listaMotivoMarcacion		= personalActividadService.listMotivoPapeleta();
		
		return strReturn;
	} 
	
	
	
	
	
		
	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}
	
	public String getMsgTransaction() {
		return MsgTransaction;
	}

	public void setMsgTransaction(String msgTransaction) {
		MsgTransaction = msgTransaction;
	}

	public String getDtpage() {
		return dtpage;
	}

	public void setDtpage(String dtpage) {
		this.dtpage = dtpage;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<PersonalVO> getListapersonal() {
		return listapersonal;
	}

	public void setListapersonal(List<PersonalVO> listapersonal) {
		this.listapersonal = listapersonal;
	}



	public List<Personanatural> getListaapespersonal() {
		return listaapespersonal;
	}

	public Map<String, Object> getDatos() {
		return datos;
	}
	
	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}


	public Personanatural getPersonanatural() {
		return personanatural;
	}

	public void setPersonanatural(Personanatural personanatural) {
		this.personanatural = personanatural;
	}

	public List<PersonalMarcacionVO> getListamarcacionesxtrabajador() {
		return listamarcacionesxtrabajador;
	}

	public void setListamarcacionesxtrabajador(
			List<PersonalMarcacionVO> listamarcacionesxtrabajador) {
		this.listamarcacionesxtrabajador = listamarcacionesxtrabajador;
	}

	public void setListaapespersonal(List<Personanatural> listaapespersonal) {
		this.listaapespersonal = listaapespersonal;
	}



	public List<Tipo> getListaTipoMarcacion() {
		return listaTipoMarcacion;
	}



	public void setListaTipoMarcacion(List<Tipo> listaTipoMarcacion) {
		this.listaTipoMarcacion = listaTipoMarcacion;
	}


	public List<PersonalActividadVO> getListaMotivoMarcacion() {
		return listaMotivoMarcacion;
	}


	public void setListaMotivoMarcacion(
			List<PersonalActividadVO> listaMotivoMarcacion) {
		this.listaMotivoMarcacion = listaMotivoMarcacion;
	}


	public PersonalMarcacionVO getPersonalMarcacion() {
		return personalMarcacion;
	}


	public void setPersonalMarcacion(PersonalMarcacionVO personalMarcacion) {
		this.personalMarcacion = personalMarcacion;
	}


	public PersonalVO getPersonal() {
		return personal;
	}


	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}


	public List<PersonalTardanzaVO> getListapersonaltardanza() {
		return listapersonaltardanza;
	}


	public void setListapersonaltardanza(
			List<PersonalTardanzaVO> listapersonaltardanza) {
		this.listapersonaltardanza = listapersonaltardanza;
	}

	

	public List<PersonalTardanzaVO> getListapersonaltardanzaTMP() {
		return listapersonaltardanzaTMP;
	}


	public void setListapersonaltardanzaTMP(
			List<PersonalTardanzaVO> listapersonaltardanzaTMP) {
		this.listapersonaltardanzaTMP = listapersonaltardanzaTMP;
	}


	public List<PersonalDescuentosVO> getListapersonaltardanzadesc() {
		return listapersonaltardanzadesc;
	}


	public void setListapersonaltardanzadesc(
			List<PersonalDescuentosVO> listapersonaltardanzadesc) {
		this.listapersonaltardanzadesc = listapersonaltardanzadesc;
	}



	public List<PersonalDescuentosVO> getListapersonalinasistenciadescSave() {
		return listapersonalinasistenciadescSave;
	}


	public void setListapersonalinasistenciadescSave(
			List<PersonalDescuentosVO> listapersonalinasistenciadescSave) {
		this.listapersonalinasistenciadescSave = listapersonalinasistenciadescSave;
	}


	public List<PersonalDescuentosVO> getListapersonaltardanzadescSave() {
		return listapersonaltardanzadescSave;
	}


	public void setListapersonaltardanzadescSave(
			List<PersonalDescuentosVO> listapersonaltardanzadescSave) {
		this.listapersonaltardanzadescSave = listapersonaltardanzadescSave;
	}


	public List<PersonalDescuentosVO> getListapersonaldescuentos() {
		return listapersonaldescuentos;
	}


	public void setListapersonaldescuentos(
			List<PersonalDescuentosVO> listapersonaldescuentos) {
		this.listapersonaldescuentos = listapersonaldescuentos;
	}


	public PersonalActividadVO getPersonalActividadVO() {
		return personalActividadVO;
	}


	public void setPersonalActividadVO(PersonalActividadVO personalActividadVO) {
		this.personalActividadVO = personalActividadVO;
	}


	public PersonalPermisoVO getPersonalPermiso() {
		return personalPermiso;
	}


	public void setPersonalPermiso(PersonalPermisoVO personalPermiso) {
		this.personalPermiso = personalPermiso;
	}





	public List<PersonalDesplazamientoVO> getPersonalDesplazamiento() {
		return personalDesplazamiento;
	}


	public void setPersonalDesplazamiento(
			List<PersonalDesplazamientoVO> personalDesplazamiento) {
		this.personalDesplazamiento = personalDesplazamiento;
	}


	public PersonalDesplazamientoVO getPersonalPapeleta() {
		return personalPapeleta;
	}


	public void setPersonalPapeleta(PersonalDesplazamientoVO personalPapeleta) {
		this.personalPapeleta = personalPapeleta;
	}


	public List<PersonalAsistenciaVO> getListapersonalinasistencias() {
		return listapersonalinasistencias;
	}


	public void setListapersonalinasistencias(
			List<PersonalAsistenciaVO> listapersonalinasistencias) {
		this.listapersonalinasistencias = listapersonalinasistencias;
	}


	public int getDescValidados() {
		return descValidados;
	}


	public void setDescValidados(int descValidados) {
		this.descValidados = descValidados;
	}


	public Map getReportParams() {
		return reportParams;
	}


	public void setReportParams(Map reportParams) {
		this.reportParams = reportParams;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}


	public PersonalVO getPersonalTurno() {
		return personalTurno;
	}


	public void setPersonalTurno(PersonalVO personalTurno) {
		this.personalTurno = personalTurno;
	}


	public List<PersonalDescuentosVO> getListarPeriodoMesDescuento() {
		return listarPeriodoMesDescuento;
	}


	public void setListarPeriodoMesDescuento(
			List<PersonalDescuentosVO> listarPeriodoMesDescuento) {
		this.listarPeriodoMesDescuento = listarPeriodoMesDescuento;
	}


	public List<PersonalVacacionesVO> getListapersonalVacaciones() {
		return listapersonalVacaciones;
	}


	public void setListapersonalVacaciones(
			List<PersonalVacacionesVO> listapersonalVacaciones) {
		this.listapersonalVacaciones = listapersonalVacaciones;
	}


	public List<PersonalVacacionesVO> getListaPeriodosVacaciones() {
		return listaPeriodosVacaciones;
	}


	public void setListaPeriodosVacaciones(
			List<PersonalVacacionesVO> listaPeriodosVacaciones) {
		this.listaPeriodosVacaciones = listaPeriodosVacaciones;
	}


	public int getPeriodoVacaciones() {
		return periodoVacaciones;
	}


	public void setPeriodoVacaciones(int periodoVacaciones) {
		this.periodoVacaciones = periodoVacaciones;
	}


	public List<PersonalVacacionesGoceVO> getListapersonalVacacionesGoce() {
		return listapersonalVacacionesGoce;
	}


	public void setListapersonalVacacionesGoce(
			List<PersonalVacacionesGoceVO> listapersonalVacacionesGoce) {
		this.listapersonalVacacionesGoce = listapersonalVacacionesGoce;
	}



	public void setPersonalVacacionesService(
			PersonalVacacionesService personalVacacionesService) {
		this.personalVacacionesService = personalVacacionesService;
	}


	public int getIdPersonal() {
		return idPersonal;
	}


	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}


	public PersonalVacacionesGoceVO getPersonalVacacionesGoce() {
		return personalVacacionesGoce;
	}


	public void setPersonalVacacionesGoce(
			PersonalVacacionesGoceVO personalVacacionesGoce) {
		this.personalVacacionesGoce = personalVacacionesGoce;
	}


	public Date getF_inicioVac() {
		return f_inicioVac;
	}


	public void setF_inicioVac(Date f_inicioVac) {
		this.f_inicioVac = f_inicioVac;
	}


	public Date getF_finVac() {
		return f_finVac;
	}


	public void setF_finVac(Date f_finVac) {
		this.f_finVac = f_finVac;
	}
	
	
	public int getIdVacaciones() {
		return idVacaciones;
	}


	public void setIdVacaciones(int idVacaciones) {
		this.idVacaciones = idVacaciones;
	}


	public int getIdVacacionesGoce() {
		return idVacacionesGoce;
	}


	public void setIdVacacionesGoce(int idVacacionesGoce) {
		this.idVacacionesGoce = idVacacionesGoce;
	}


	public PersonalVacacionesVO getPersonalVacaciones() {
		return personalVacaciones;
	}


	public void setPersonalVacaciones(PersonalVacacionesVO personalVacaciones) {
		this.personalVacaciones = personalVacaciones;
	}


//	public int getTieneVacacionesconGoce() {
//		return tieneVacacionesconGoce;
//	}
//
//
//	public void setTieneVacacionesconGoce(int tieneVacacionesconGoce) {
//		this.tieneVacacionesconGoce = tieneVacacionesconGoce;
//	}


	public Date getF_aprobVac() {
		return f_aprobVac;
	}


	public void setF_aprobVac(Date f_aprobVac) {
		this.f_aprobVac = f_aprobVac;
	}


	public int getNdiasProgVac() {
		return ndiasProgVac;
	}


	public void setNdiasProgVac(int ndiasProgVac) {
		this.ndiasProgVac = ndiasProgVac;
	}


	public List<PersonalLicenciasVO> getListapersonalLicencias() {
		return listapersonalLicencias;
	}


	public void setListapersonalLicencias(
			List<PersonalLicenciasVO> listapersonalLicencias) {
		this.listapersonalLicencias = listapersonalLicencias;
	}


	public PersonalLicenciasVO getPersonalLicencias() {
		return personalLicencias;
	}


	public void setPersonalLicencias(PersonalLicenciasVO personalLicencias) {
		this.personalLicencias = personalLicencias;
	}


	public int getAddLicencia() {
		return addLicencia;
	}


	public void setAddLicencia(int addLicencia) {
		this.addLicencia = addLicencia;
	}





	public List<PersonalActividadVO> getListTipoLicencia() {
		return listTipoLicencia;
	}


	public void setListTipoLicencia(List<PersonalActividadVO> listTipoLicencia) {
		this.listTipoLicencia = listTipoLicencia;
	}


	public int getIntEstado() {
		return intEstado;
	}


	public void setIntEstado(int intEstado) {
		this.intEstado = intEstado;
	}


	public int getIdLicencia() {
		return idLicencia;
	}


	public void setIdLicencia(int idLicencia) {
		this.idLicencia = idLicencia;
	}


	public String getDte_fec_marc() {
		return dte_fec_marc;
	}


	public void setDte_fec_marc(String dte_fec_marc) {
		this.dte_fec_marc = dte_fec_marc;
	}


	public int getTimePermiso() {
		return timePermiso;
	}


	public void setTimePermiso(int timePermiso) {
		this.timePermiso = timePermiso;
	}


	public int getIdActividad() {
		return idActividad;
	}


	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}


	public int getNroRegistros() {
		return nroRegistros;
	}


	public void setNroRegistros(int nroRegistros) {
		this.nroRegistros = nroRegistros;
	}


	public CommonService getCommonService() {
		return commonService;
	}


	public List<TRegimenContractual> getRegimenContractual() {
		return regimenContractual;
	}


	public void setRegimenContractual(List<TRegimenContractual> regimenContractual) {
		this.regimenContractual = regimenContractual;
	}


	public int getIdregimenContractual() {
		return idregimenContractual;
	}


	public void setIdregimenContractual(int idregimenContractual) {
		this.idregimenContractual = idregimenContractual;
	}


	public Integer getIsajax() {
		return isajax;
	}


	public void setIsajax(Integer isajax) {
		this.isajax = isajax;
	}


	public List<PersonalDescuentosVO> getListaaniosDescuentos() {
		return listaaniosDescuentos;
	}


	public void setListaaniosDescuentos(
			List<PersonalDescuentosVO> listaaniosDescuentos) {
		this.listaaniosDescuentos = listaaniosDescuentos;
	}


	public List<PersonalDescuentosVO> getListamesDescuentos() {
		return listamesDescuentos;
	}


	public void setListamesDescuentos(List<PersonalDescuentosVO> listamesDescuentos) {
		this.listamesDescuentos = listamesDescuentos;
	}


	public int getPeriododesc() {
		return periododesc;
	}


	public void setPeriododesc(int periododesc) {
		this.periododesc = periododesc;
	}


	public int getMesdesc() {
		return mesdesc;
	}


	public void setMesdesc(int mesdesc) {
		this.mesdesc = mesdesc;
	}


	public Date getF_inicioLic() {
		return f_inicioLic;
	}


	public void setF_inicioLic(Date f_inicioLic) {
		this.f_inicioLic = f_inicioLic;
	}


	public Date getF_finLic() {
		return f_finLic;
	}


	public void setF_finLic(Date f_finLic) {
		this.f_finLic = f_finLic;
	}


	public int getUbicacionPersonal() {
		return ubicacionPersonal;
	}


	public void setUbicacionPersonal(int ubicacionPersonal) {
		this.ubicacionPersonal = ubicacionPersonal;
	}


	public List<Categoriaanp> getListcategoriaanp() {
		return listcategoriaanp;
	}


	public void setListcategoriaanp(List<Categoriaanp> listcategoriaanp) {
		this.listcategoriaanp = listcategoriaanp;
	}


	public List<Areanatural> getListareanatural() {
		return listareanatural;
	}


	public void setListareanatural(List<Areanatural> listareanatural) {
		this.listareanatural = listareanatural;
	}


	public int getIdANP() {
		return idANP;
	}


	public void setIdANP(int idANP) {
		this.idANP = idANP;
	}


	public Integer getInt_mes_desc() {
		return int_mes_desc;
	}


	public void setInt_mes_desc(Integer int_mes_desc) {
		this.int_mes_desc = int_mes_desc;
	}


	public Integer getInt_periodo_desc() {
		return int_periodo_desc;
	}


	public void setInt_periodo_desc(Integer int_periodo_desc) {
		this.int_periodo_desc = int_periodo_desc;
	}


	public HashMap<Object, Object> getMapcat() {
		return mapcat;
	}


	public void setMapcat(HashMap<Object, Object> mapcat) {
		this.mapcat = mapcat;
	}


	public HashMap<Object, Object> getMapanp() {
		return mapanp;
	}


	public void setMapanp(HashMap<Object, Object> mapanp) {
		this.mapanp = mapanp;
	}


	public Integer getEstadoPersonal() {
		return estadoPersonal;
	}


	public void setEstadoPersonal(Integer estadoPersonal) {
		this.estadoPersonal = estadoPersonal;
	}


	public Date getFechaAsistenciaLic() {
		return fechaAsistenciaLic;
	}


	public void setFechaAsistenciaLic(Date fechaAsistenciaLic) {
		this.fechaAsistenciaLic = fechaAsistenciaLic;
	}



	public int getIdMarcacion() {
		return idMarcacion;
	}


	public void setIdMarcacion(int idMarcacion) {
		this.idMarcacion = idMarcacion;
	}


	public int getIdPapeleta() {
		return idPapeleta;
	}


	public void setIdPapeleta(int idPapeleta) {
		this.idPapeleta = idPapeleta;
	}


	public List<PersonalAsistenciaVO> getListaPersonalAsistencia() {
		return listaPersonalAsistencia;
	}


	public void setListaPersonalAsistencia(
			List<PersonalAsistenciaVO> listaPersonalAsistencia) {
		this.listaPersonalAsistencia = listaPersonalAsistencia;
	}


	public Date getAsistenciafechaInicio() {
		return AsistenciafechaInicio;
	}


	public void setAsistenciafechaInicio(Date asistenciafechaInicio) {
		AsistenciafechaInicio = asistenciafechaInicio;
	}


	public Date getAsistenciafechaFin() {
		return AsistenciafechaFin;
	}


	public void setAsistenciafechaFin(Date asistenciafechaFin) {
		AsistenciafechaFin = asistenciafechaFin;
	}


	public int getTiempoReportePersonal() {
		return tiempoReportePersonal;
	}


	public void setTiempoReportePersonal(int tiempoReportePersonal) {
		this.tiempoReportePersonal = tiempoReportePersonal;
	}


	public int getTipoReporte() {
		return tipoReporte;
	}


	public void setTipoReporte(int tipoReporte) {
		this.tipoReporte = tipoReporte;
	}


	public List<PersonalDesplazamientoVO> getListaPersonalDesplazamiento() {
		return listaPersonalDesplazamiento;
	}


	public void setListaPersonalDesplazamiento(
			List<PersonalDesplazamientoVO> listaPersonalDesplazamiento) {
		this.listaPersonalDesplazamiento = listaPersonalDesplazamiento;
	}


	public List<PersonalAsistenciaResumenVO> getListaPersonalResumenAsistencia() {
		return listaPersonalResumenAsistencia;
	}


	public void setListaPersonalResumenAsistencia(
			List<PersonalAsistenciaResumenVO> listaPersonalResumenAsistencia) {
		this.listaPersonalResumenAsistencia = listaPersonalResumenAsistencia;
	}


	public List<PersonalAsistenciaRecordVO> getListaPersonalAsistenciaRecord() {
		return listaPersonalAsistenciaRecord;
	}


	public void setListaPersonalAsistenciaRecord(
			List<PersonalAsistenciaRecordVO> listaPersonalAsistenciaRecord) {
		this.listaPersonalAsistenciaRecord = listaPersonalAsistenciaRecord;
	}


	public List<PersonaldiasnolaborablesVO> getListadiasnolaborables() {
		return listadiasnolaborables;
	}


	public void setListadiasnolaborables(
			List<PersonaldiasnolaborablesVO> listadiasnolaborables) {
		this.listadiasnolaborables = listadiasnolaborables;
	}


	public List<PersonaldiasnolaborablesVO> getListadiasnolaborablesperiodo() {
		return listadiasnolaborablesperiodo;
	}


	public void setListadiasnolaborablesperiodo(
			List<PersonaldiasnolaborablesVO> listadiasnolaborablesperiodo) {
		this.listadiasnolaborablesperiodo = listadiasnolaborablesperiodo;
	}
	
	
}


