package proyecto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StreamResult;
import org.springframework.beans.factory.annotation.Autowired;

import proyecto.constants.ValueConstants;
import proyecto.param.FichaTurismoParam;
import proyecto.param.GuiaParam;
import proyecto.param.OperadorParam;
import proyecto.param.PagoBancoParam;
import proyecto.param.TurismoParam;
import proyecto.service.ActividadTurismoService;
import proyecto.service.AreaNaturalService;
import proyecto.service.BoletajeService;
import proyecto.service.DocumentoService;
import proyecto.service.FichaturismoService;
import proyecto.service.GuiaService;
import proyecto.service.LogoService;
import proyecto.service.OperadorService;
import proyecto.service.PagoBancoService;
import proyecto.service.PaisService;
import proyecto.service.RutaturismoService;
import proyecto.service.TipoService;
import proyecto.service.TipoTurismoService;
import proyecto.service.TurismoService;
import proyecto.service.UbigeoService;
import proyecto.service.VisitanteService;
import proyecto.util.Pagination;
import proyecto.vo.Actividadturismo;
import proyecto.vo.Areanatural;
import proyecto.vo.Boletaje;
import proyecto.vo.Conceptoexoneracionpago;
import proyecto.vo.Fichaturismo;
import proyecto.vo.Guia;
import proyecto.vo.GuiaFichaTurismo;
import proyecto.vo.Operadorturismo;
import proyecto.vo.PagoBanco;
import proyecto.vo.PagoFichaturismo;
import proyecto.vo.Rutaturismo;
import proyecto.vo.Tipo;
import proyecto.vo.Tipoturismo;
import proyecto.vo.TipoturismoFichaturismo;
import proyecto.vo.Turismo;
import proyecto.vo.TurismoGuia;
import proyecto.vo.Ubigeo;
import proyecto.vo.Usuario;
import proyecto.vo.Visitante;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;

public class TurismoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TurismoAction.class);
	
	private HashMap reportParams = new HashMap();
	
	private Document document;
	private PdfPTable table;
	private BaseColor baseColor;

	private Visitante visitante;
	private Usuario usuario;
	private Fichaturismo fichaturismo;
	private Rutaturismo rutaturismo;

	private InputStream pdfStream;
	private InputStream imagenLogo;

	private List<Visitante> visitantes;
	private List<Fichaturismo> fichas;
	private List<Areanatural> areasNaturales;
	private List<Guia> guias;
	private List<Operadorturismo> operadores;
	private List<Actividadturismo> actividades;
	private List<Rutaturismo> rutas;
	private List<Rutaturismo> listaRutaturismo;
	private List<Boletaje> boletajes;
	private List<Conceptoexoneracionpago> listaConceptoexoneracionpago;
	private List<?> paises, tiposturismo, idActividadeTurismo;
	private Map<String, Object> map;
	private String numerodoc, json, data, log, q, codareanatural;
	private Areanatural areanatural;
	private Integer idarea, id;
	private Pagination pager;
	private int pag;
	private long ficha, size;
	private List<Tipo> listaSexo;
	private List<Tipo> listaTipoDocumento;
	private List<Tipo> listaEstadocivil; 
	private List<Tipo> listaTipoocupacion;
	private List<Tipo> listaMotivovisita; 
	private List<Tipo> listaEstadoficha;
	private Map<String, Object> datos;
	private String datosJson1;
	private String datosJson2;
	private String datosJson3;
	private List<Tipo> listaGenero;
	private int visibilidadmenu;
	private int idmodulo;
	private int idcodigo;
	private List<Tipo> listaAnio;
	private List<Tipoturismo> listaTipoturismo;
	private int idanio;
	private int periodo;
	private String cadena;
	private String nombrearchivo;
	private int idparam;
	private int idruta;
	private int idcontrol;
	private int idaccion;
	private int numpagina;
	private int idpais;
	private int idfichaturismo;
	private int idtiporegistro;
	private int cantidadparam;
	private int idestado;
	private ValueConstants constantes;
	private List<Operadorturismo> listaAgenciaviaje;
	private List<Operadorturismo> listaOperadorturismo;
	private List<Guia> listaGuiaturismo;
	private List<Fichaturismo> listaFichaturismo;
	private List<Fichaturismo> listaFichaturismosel;
	private List<Fichaturismo> listaFichaturismosel1;
	private List<Fichaturismo> listaFichaturismosel2;
	private List<Tipo> listaModalidadpago;
	private List<Boletaje> listaBoletajemayoredad;
	private List<Boletaje> listaBoletajemenoredad;
	private List<Boletaje> listaBoletajeinfante;
	private List<Boletaje> listaBoletaje;
	private List<Integer> listaCodigo;
	private List<Conceptoexoneracionpago> listaConceptoexoninfante;
	private List<Conceptoexoneracionpago> listaConceptoexonnoinfante;
	private List<Visitante> listaVisitante;
	private List<Visitante> listaVisitantesel;
	private List<Ubigeo> listaUbigeodepartamento;
	private List<Ubigeo> listaUbigeoprovincia;
	private List<Ubigeo> listaUbigeodistrito;
	private Operadorturismo operadorturismo;
	private Guia guia;
	private List<Areanatural> listaAreanatural;
	private PagoFichaturismo pagofichaturismo;
	private List<Turismo> listaAnpturismo;
	private List<PagoBanco> listaPagobanco;
	private Boletaje boletaje;
	List<Map<String, Object>> listaReporte1;
	List<Map<String, Object>> listaReporte2;
	List<Map<String, Object>> listaReporte3;
	List<Map<String, Object>> listaReporte4;
	List<Map<String, Object>> listaReporte5;
	List<Map<String, Object>> listaReporte6;

	@Autowired
	private FichaturismoService fichaturismoService;
	@Autowired
	private RutaturismoService rutaturismoService;
	@Autowired
	private GuiaService guiaService;
	@Autowired
	private AreaNaturalService areaNaturalService;
	@Autowired
	private BoletajeService boletajeService;
	@Autowired
	private ActividadTurismoService actividadTurismoService;
	@Autowired
	private OperadorService operadorService;
	@Autowired
	private PaisService paisService;
	@Autowired
	private TipoTurismoService tipoTurismoService;
	@Autowired
	private TipoService tipoService;
	@Autowired
	private VisitanteService visitanteService;
	@Autowired
	private PagoBancoService pagoBancoService;
	@Autowired
	private DocumentoService documentoService;
	@Autowired
	private LogoService logoService;
	@Autowired
	private TurismoService turismoService;
	@Autowired
	private UbigeoService ubigeoService;

	
	public String execute()  {
		return SUCCESS;
	}
	
	public TurismoAction() {
		areasNaturales = new ArrayList<Areanatural>();
		map = new HashMap<String, Object>();
		datos = new HashMap<String, Object>();
		listaTipoDocumento = new ArrayList<Tipo>();
		listaGenero = new ArrayList<Tipo>();
		areanatural = new Areanatural();
		listaReporte1 = new ArrayList<Map<String, Object>>();
		listaReporte2 = new ArrayList<Map<String, Object>>();
		listaReporte3 = new ArrayList<Map<String, Object>>();
		listaReporte4 = new ArrayList<Map<String, Object>>();
		listaReporte5 = new ArrayList<Map<String, Object>>();
		listaReporte6 = new ArrayList<Map<String, Object>>();
		listaAnio = new ArrayList<Tipo>();
		fichaturismo = new Fichaturismo();
		listaTipoturismo = new ArrayList<Tipoturismo>();
		listaConceptoexoneracionpago = new ArrayList<Conceptoexoneracionpago>();
		listaAgenciaviaje = new ArrayList<Operadorturismo>();
		listaOperadorturismo = new ArrayList<Operadorturismo>();
		listaFichaturismo=new ArrayList<Fichaturismo>();
		listaBoletajemayoredad=new ArrayList<Boletaje>();
		listaBoletajemenoredad=new ArrayList<Boletaje>();
		listaBoletajeinfante=new ArrayList<Boletaje>();
		listaConceptoexoninfante=new ArrayList<Conceptoexoneracionpago>();
		listaConceptoexonnoinfante=new ArrayList<Conceptoexoneracionpago>();
		listaVisitante=new ArrayList<Visitante>();
		constantes=new ValueConstants();
		visitante=new Visitante();
		listaBoletaje=new ArrayList<Boletaje>();
		operadorturismo=new Operadorturismo();
		listaUbigeodepartamento=new ArrayList<Ubigeo>();
		listaUbigeoprovincia=new ArrayList<Ubigeo>();
		listaUbigeodistrito=new ArrayList<Ubigeo>();
		listaAreanatural=new ArrayList<Areanatural>();
		listaAnpturismo=new ArrayList<Turismo>();
		listaGuiaturismo=new ArrayList<Guia>();
		listaEstadocivil=new ArrayList<Tipo>();
		guia=new Guia();
		listaTipoocupacion=new ArrayList<Tipo>();
		listaMotivovisita=new ArrayList<Tipo>();
		listaRutaturismo=new ArrayList<Rutaturismo>();
		listaFichaturismosel=new ArrayList<Fichaturismo>();
		listaFichaturismosel1=new ArrayList<Fichaturismo>();
		listaFichaturismosel2=new ArrayList<Fichaturismo>();
		listaEstadoficha=new ArrayList<Tipo>();
		pagofichaturismo=new PagoFichaturismo();
		listaModalidadpago=new ArrayList<Tipo>();
		boletaje=new Boletaje();
		listaVisitantesel=new ArrayList<Visitante>();
		listaPagobanco=new ArrayList<PagoBanco>();
	}

	public void addUrlApplication() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> mapApp = ServletActionContext.getContext()
				.getApplication();
		try {
			URL u = new URL(request.getRequestURL().toString());
			String url = u.getProtocol() + "://" + request.getHeader("Host")
					+ request.getContextPath() + "/";
			mapApp.put("url", url);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String listarAreasNaturalesConTurismo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		listaAreanatural=areaNaturalService.consultarAreasNaturalesConTurismo();
		session.put("noMuestraMenu", 1);
		return SUCCESS;
	}
	
	public String irAreaNaturalConTurismo() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		int idareanat = Integer.parseInt(String.valueOf(request
				.getParameter("idarea")));
		session.put("area",
				areaNaturalService.consultarAreasNaturalxId(idareanat));
		return SUCCESS;
	}	
	
	public String irMenuOperadorTurismo() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String, Object> session = ActionContext.getContext().getSession();
		int idareanat = Integer.parseInt(String.valueOf(request
				.getParameter("idarea")));
		session.put("area",
				areaNaturalService.consultarAreasNaturalxId(idareanat));
		return "success";
	}

	public String listarAreasNaturalesConTurismoxOperador() {
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
	

//	public String irInicioRegistroTurismo() {
//		HttpServletRequest request = (HttpServletRequest) ActionContext
//				.getContext().get(ServletActionContext.HTTP_REQUEST);
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		String resultado = "";
//		int modulo = Integer.parseInt(String.valueOf(request
//				.getParameter("idmodulo")));
//		session.put("moduloactual", modulo);
//		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
//		int tiporol = u.getRol().getMapModuloTipoRol().get(modulo);
//		if (tiporol == ValueConstants.TIPO_ROL_ADMINISTRADOR_TOTAL) {
//			resultado = "admintotal";
//			session.put("noMuestraMenu", 1);
//		} else if (tiporol == ValueConstants.TIPO_ROL_ADMINISTRADOR_LOCAL) {
//			resultado = "userarea";
//		}
//		return resultado;
//	}

//	public String irMenuTurismo() {
//		HttpServletRequest request = (HttpServletRequest) ActionContext
//				.getContext().get(ServletActionContext.HTTP_REQUEST);
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
//		int modulo = Integer.parseInt(session.get("idmoduloactual").toString());
//		if (u.getPersonal().getIdpersonal() != 0) {
//			int tiporol = u.getRol().getMapModuloTipoRol().get(modulo);
//			if (tiporol == ValueConstants.TIPO_ROL_ADMINISTRADOR_TOTAL) {
//				int idareanat = Integer.parseInt(String.valueOf(request
//						.getParameter("idarea")));
//				session.put("area",
//						areaNaturalService.consultarAreasNaturalxId(idareanat));
//			}
//		} else {
//			int idareanat = Integer.parseInt(String.valueOf(request
//					.getParameter("idarea")));
//			session.put("area",
//					areaNaturalService.consultarAreasNaturalxId(idareanat));
//		}
//		return "success";
//	}

	public String registrar() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		Visitante vis = new Visitante();
		// System.out.println(vis.getVisitanteConceptoexoneracionpago().getConceptoexoneracionpago().getIdconceptoexoneracionpago());

		if (u.getPersonal().getIdpersonal() == 0) {
			Operadorturismo ot = (Operadorturismo) session
					.get("operadorturismo");
			fichaturismo.getOperadorturismo().setIdoperadorturismo(
					ot.getIdoperadorturismo());
		}
		idpais=ValueConstants.ID_PAIS_PERU;
		areanatural = (Areanatural) session.get("area");
		int idarea = areanatural.getIdareanatural();
		setSize(rutaturismoService.size(idarea));
		listaAgenciaviaje = operadorService
				.listarAgenciasDeViajexAreaNatural(idarea);
		listaOperadorturismo = operadorService
				.listarOperadoresTurismoxAreaNatural(idarea);
		// setOperadores( operadorService.listar( idarea ) );
		// setGuias( guiaService.listar( idarea ) );
		setRutas(rutaturismoService.listarxArea(idarea));
		setTiposturismo(tipoTurismoService.listar(idarea));
		// setActividades( actividadTurismoService.listar( idarea ) );
		listaGenero = tipoService.listarGenero();
		listaTipoDocumento = tipoService.listarTipoDocumentoIdentidad();
		listaTipoturismo = tipoTurismoService.listarTipoTurismo();
		listaConceptoexoneracionpago = tipoService
				.listarConceptoExoneracionPago();
		setPaises(paisService.listar());
		boletajes = boletajeService.listar(idarea);
		return SUCCESS;
	}

	public String buscarGuiaTurismo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural = (Areanatural) session.get("area");
		TurismoGuia tg = new TurismoGuia();
		tg.getGuia().setApepat(cadena);
		tg.getGuia().setApemat(cadena);
		tg.getGuia().setNombre(cadena);
		tg.getTurismo().setIdareanatural(areanatural.getIdareanatural());
		List<Guia> listaGuia = guiaService.listarGuiaxNombreCompleto(tg);
		datos.put("guias", listaGuia);
		return "success";
	}

	

	public String consultarReporteTurismoxAreaNatural() {

		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural = areaNaturalService
				.consultarAreaNaturalxCodigo(codareanatural);
		if (areanatural != null) {
			TurismoParam turismoparam = new TurismoParam();
			turismoparam.getAreanatural().setIdareanatural(
					areanatural.getIdareanatural());
			turismoparam.setPeriodo(2010);
			listaReporte1 = visitanteService
					.reporteVisitantexRutaAnual(turismoparam);
			datosJson1 = JSONArray.fromObject(listaReporte1).toString();
			listaReporte2 = visitanteService
					.reporteVisitantexRutaMensual(turismoparam);
			datosJson2 = JSONArray.fromObject(listaReporte2).toString();
		}
		return "success";
	}

	public String consultarTipoturismo() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		int idruta = Integer
				.parseInt(request.getParameter("idruta").toString());
		listaTipoturismo = tipoTurismoService.listarTipoTurismoxRuta(idruta);
		return "success";
	}

	public String consultarActividadxTipoturismo() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		datos.put("listaActividadturismo",
				actividadTurismoService.listarActividadesxTipoTurismo(idparam));
		return "success";
	}

	public String boletos() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String fechanac = String.valueOf(request.getParameter("fechanac"));
		int idruta = Integer
				.parseInt(request.getParameter("idruta").toString());
		Date fnac = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fnac = formateador.parse(fechanac);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Boletaje bol = new Boletaje();
//		bol.getRutaturismo().setIdrutaturismo(idruta);
		List<Boletaje> listabol = new ArrayList<Boletaje>();
		List<Conceptoexoneracionpago> listaconcepto = new ArrayList<Conceptoexoneracionpago>();
		
			int flagconceptomenor = 0;
			Tipo grupoedad=visitanteService.determinarGrupoEdadVisitantexFechaNacimiento(fnac);
			if (grupoedad.getCodigointtipo()==ValueConstants.CODIGO_GRUPO_EDAD_MAYOREDAD) {
			listabol=boletajeService.listarBoletajeMayorEdadxIdruta(idruta);	
			listaconcepto=tipoService.listarConceptoExoneracionPagoNoInfante();
		} else if (grupoedad.getCodigointtipo()==ValueConstants.CODIGO_GRUPO_EDAD_MENOREDAD) {
			listabol=boletajeService.listarBoletajeMenorEdadxIdruta(idruta);
			listaconcepto=tipoService.listarConceptoExoneracionPagoNoInfante();
		}
		else if (grupoedad.getCodigointtipo()==ValueConstants.CODIGO_GRUPO_EDAD_INFANTE){
			listabol=boletajeService.listarBoletajeInfante();
			listaconcepto=tipoService.listarConceptoExoneracionPagoInfante();
		}
			
//			if (grupoedad.getCodigointtipo()==1) {
//				bol.setFlagmayoredad(ValueConstants.FLAG_ACTIVO);
//				listabol=boletajeService.listarBoletaje(bol);			
//			} else if (grupoedad.getCodigointtipo()==2) {
//				bol.setFlagmayoredad(ValueConstants.VALOR_CERO);
//				listabol=boletajeService.listarBoletaje(bol);
//			}
//			else if (grupoedad.getCodigointtipo()==3){
//				flagconceptomenor = ValueConstants.FLAG_ACTIVO;
//			}
		map.put("listabol", listabol);
		map.put("listaconcepto", listaconcepto);
		map.put("idgrupoedad", grupoedad.getCodigointtipo());
		map.put("flagconceptomenor", flagconceptomenor);
		map.put("idconceptoexonpagomenor", ValueConstants.ID_CONCEPTO_EXONERACION_PAGO_MENOR);
		return SUCCESS;
	}

	public String tiposturismo() {
		map.put("data", tipoTurismoService.listarxRuta(getId()));
		return SUCCESS;
	}

	public String rutasturismo() {
		map.put("data", rutaturismoService.listarxArea(idarea));
		return SUCCESS;
	}

	public String reporte() {
		Calendar c = Calendar.getInstance();
		int anioActual = c.get(Calendar.YEAR);
		listaAnio = fichaturismoService.listarPeriodosconFichasConsolidadas();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		int anio = anioActual;
		if (request.getParameter("idanio") != null) {
			anio = Integer.parseInt(request.getParameter("idanio").toString());
		}
		idanio = anio;
		Map<String, Object> session = ActionContext.getContext().getSession();
		areanatural = (Areanatural) session.get("area");
		TurismoParam turismoparam = new TurismoParam();
		turismoparam.getAreanatural().setIdareanatural(
				areanatural.getIdareanatural());
		turismoparam.setPeriodo(anio);
		listaReporte1 = visitanteService
				.reporteVisitantexRutaAnual(turismoparam);
		datosJson1 = JSONArray.fromObject(listaReporte1).toString();
		listaReporte2 = visitanteService
				.reporteVisitantexRutaMensual(turismoparam);
		datosJson2 = JSONArray.fromObject(listaReporte2).toString();
//		listaReporte2 = visitanteService
//				.reporteCruzadoVisitantexRutaMensual(turismoparam);
//		listaReporte3 = visitanteService
//				.reporteCruzadoVisitantexNacionalidad(turismoparam);
		listaReporte3 = visitanteService
		.reporteCruzadoVisitantexCaracteristicas(turismoparam);
		listaReporte4=visitanteService.reporteCruzadoVisitantexRutaMensual(turismoparam);
		return SUCCESS;
	}

	public String estadisticas() {
		areanatural = areaNaturalService
				.consultarAreaNaturalxCodigo(codareanatural);
		if (areanatural != null) {
			cadena = codareanatural;
			Calendar c = Calendar.getInstance();
			int anioActual = c.get(Calendar.YEAR);
			//listaAnio = fichaturismoService.listarPeriodosconFechaRegistro();
			listaAnio = fichaturismoService.listarPeriodosconFichasConsolidadas();
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			int anio = anioActual;
			if (request.getParameter("idanio") != null) {
				anio = Integer.parseInt(request.getParameter("idanio")
						.toString());
			}
			idanio = anio;
			TurismoParam turismoparam = new TurismoParam();
			turismoparam.getAreanatural().setIdareanatural(
					areanatural.getIdareanatural());
			turismoparam.setPeriodo(anio);
			listaReporte1 = visitanteService
					.reporteVisitantexRutaAnual(turismoparam);
			datosJson1 = JSONArray.fromObject(listaReporte1).toString();
			listaReporte2 = visitanteService
					.reporteVisitantexRutaMensual(turismoparam);
			datosJson2 = JSONArray.fromObject(listaReporte2).toString();
			listaReporte2 = visitanteService
					.reporteCruzadoVisitantexRutaMensual(turismoparam);
			listaReporte3 = visitanteService
					.reporteCruzadoVisitantexNacionalidad(turismoparam);
		}

		return SUCCESS;
	}

//	public String elegirArea() {
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		setAreasNaturales(areaNaturalService
//				.consultarAreasNaturalesConTurismo());
//		return SUCCESS;
//	}

	public String listarFicha() {
		initFichas();
		return SUCCESS;
	}

	public String ficha() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		int idfichaturismo = (int) ficha;
		//fichaturismo = fichaturismoService.consultarDetalleFichaTurismoxId(idfichaturismo);		
		visitantes = fichaturismo.getListaVisitante();
		areanatural = (Areanatural) session.get("area");
		idarea = areanatural.getIdareanatural();
		fichaturismo = fichaturismoService.consultarDetalleFichaTurismoxIdxAnp(idfichaturismo, idarea);
		
		return SUCCESS;
	}

//	public String  accederFichaTurismo(){
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		listaModalidadpago=tipoService.listarModalidadPagoFichaTurismo();
//		areanatural = (Areanatural) session.get("area");
//		idarea = areanatural.getIdareanatural();
//		fichaturismo = fichaturismoService.consultarDetalleFichaConPagosxIdxAnp(idfichaturismo, idarea);
//		boletaje=boletajeService.obtenerBoletajeAdicionalxRutaTurismo(fichaturismo.getRutaturismo().getIdrutaturismo());
//		return "success"; 
//	}
	
	public String consultarDetalleFichaTurismo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		visitantes = fichaturismo.getListaVisitante();
		areanatural = (Areanatural) session.get("area");
		idarea = areanatural.getIdareanatural();
		fichaturismo = fichaturismoService.consultarDetalleFichaTurismoxIdxAnp(idfichaturismo, idarea);
		return SUCCESS;
	}
	
	public String editFicha() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		//fichaturismo = fichaturismoService.consultarDetalleFichaTurismoxId(idcodigo);
		fichaturismo = fichaturismoService.consultarDetalleFichaPagoBancoxIdFichaturismo(idcodigo);
		areanatural = (Areanatural) session.get("area");
		visitantes = fichaturismo.getListaVisitante();
		return SUCCESS;
	}

	public String consolidarFicha() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		fichaturismo.getListaPagoFichaturismo().removeAll(Collections.singleton(null));
		// formatear fechas hasta encontrar conversor
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fichaturismo.setFechaingreso(formateador.parse(fichaturismo
					.getFingreso()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		//double montocalculado=fichaturismoService.calcularMontoFichaTurismoxId((int)fichaturismo.getIdfichaturismo());
		List<Visitante> listavsel=fichaturismoService.obtenerListadoVisitantesSeleccionados(listaVisitantesel);
		double montocalculado=fichaturismoService.calcularMontoFichaTurismoxVisitantesPresentes(listavsel);
		double montocaladi=0;
		if(fichaturismo.getFichaturismoboletaje().getCantidad()!=0){
			Fichaturismo ft=fichaturismoService.consultarMinimoFichaTurismoxId(fichaturismo.getIdfichaturismo());
			//System.out.println("ruta"+ft.getRutaturismo().getIdrutaturismo());
			boletaje=boletajeService.obtenerBoletajeAdicionalxRutaTurismo(ft.getRutaturismo().getIdrutaturismo());
			fichaturismo.getFichaturismoboletaje().getBoletaje().setIdboletaje(boletaje.getIdboletaje());
			montocaladi=boletaje.getValorboletaje()*fichaturismo.getFichaturismoboletaje().getCantidad();
		}
		//pagos
		double montopagado=0;
		for(PagoFichaturismo pft:fichaturismo.getListaPagoFichaturismo()){
			montopagado+=pft.getMonto();
		}
		
		int msgconsolidacion=0;
		montocalculado+=montocaladi;
		//System.out.println("mcal"+montocalculado+"mpag"+montopagado);
		if(montopagado<montocalculado){
			msgconsolidacion=1;
		}else{
			fichaturismo.setListaVisitante(listavsel);
			fichaturismoService.consolidarFicha(fichaturismo);
			fichaturismoService.guardarHistorialAccionFicha
			(fichaturismo.getIdfichaturismo(),u.getIdUsuario(),ValueConstants.CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR);
		}
		datos.put("msgconsolidacion", msgconsolidacion);
		//historial consolidar
//		HistFichaturismoAccion histf=new HistFichaturismoAccion();
//		histf.setIdfichaturismo(fichaturismo.getIdfichaturismo());
//		histf.getUsuario().setIdUsuario(u.getIdUsuario());
//		histf.setFecha(ProyectoUtil.obtenerFechaHoraActual());
//		fichaturismoService.guardarHistorialAccionConsolidarFicha(histf);
		//consolidar visitantes
		//int[] update = visitanteService.consolidarVisitantes(visitantes);
		//historial
		
		//map.put("save", true);
		//map.put("update", update);
		return SUCCESS;
	}

	
	public String validarPagoBancoFichaturismo(){
		fichaturismoService.validarPagoBancoFichaturismoxIdficha(idparam);
		return "success";
	}
	
	public String validarPagoBancoFichaturismoxConsolidar(){
		fichaturismoService.validarPagoBancoFichaturismoxIdficha(idparam);
		return "success";
	}
	
	public String fichasAjax() {
		initFichas();
		return SUCCESS;

	}

	public String consultarFichasTurismo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		listaGenero = tipoService.listarGenero();
		listaTipoDocumento = tipoService.listarTipoDocumentoIdentidad();
		areanatural = (Areanatural) session.get("area");
		paises = paisService.listar();
		String resultado = "";
		FichaTurismoParam fichaturismoparam = new FichaTurismoParam();
		// consultar los no consolidados/generados y creados por el user
		Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
		int idtiporol=(Integer)session.get("idtiporol");
		//fichaturismoparam.getFichaturismo().setIdtiporolcreacion(idtiporol);
		
		fichaturismoparam.getFichaturismo().getAreanatural()
				.setIdareanatural(areanatural.getIdareanatural());
		
		listaRutaturismo=rutaturismoService.listarxArea(areanatural.getIdareanatural());
		listaEstadoficha=tipoService.listarEstadoFichaTurismo();
		Operadorturismo ot=new Operadorturismo();
		//para usuarios de sede central
		if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL){
			listaOperadorturismo=operadorService.listarOperadoresTurismoxAreaNatural(areanatural.getIdareanatural());
			fichaturismoparam.setIdtipoconsulta(ValueConstants.TIPO_CONSULTA_FICHA_GENERADA);
			
		}else
			//para usuarios de sede anp
			if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
				listaOperadorturismo=operadorService.listarOperadoresTurismoxAreaNatural(areanatural.getIdareanatural());
				fichaturismoparam.setIdtiporolcreacion(idtiporol);
				fichaturismoparam.setIdtipoconsulta(ValueConstants.TIPO_CONSULTA_FICHA_GENERADA_AND_CREADA);
				
			}
		//para el operador
			else
				if(idtiporol==ValueConstants.TIPO_ROL_OPERADOR_TURISMO){
					ot = (Operadorturismo) session
					.get("operadorturismo");
			fichaturismoparam.getFichaturismo().getOperadorturismo()
					.setIdoperadorturismo(ot.getIdoperadorturismo());
			fichaturismoparam.getFichaturismo().setIdtiporolcreacion(idtiporol);
					
				}
		

		int tamanio = ValueConstants.TAMANIO_PAGINA_20;
		int indice=0;
		
		//ingreso x link
		int idestadoficha=0;

		
		if (idcontrol == ValueConstants.LINK_INICIO_0) {
			if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL){
			//constante combo
			idestado=tipoService.obtenerIdtipoxCodigo
			(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_CONSOLIDADO);
	        idestadoficha=idestado;
			}else
				if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
					idestado=tipoService.obtenerIdtipoxCodigo
					(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_GENERADO);
			        idestadoficha=idestado;
				}
			resultado = "inicio";
		} 
		//ingreso x boton
		else if (idcontrol == ValueConstants.CONTROL_NUMPAGINA_1) {
			indice = ((numpagina - 1) * tamanio);
			String codigoficha = String.valueOf(request.getParameter("q"));
			if (!codigoficha.equals("")) {
				fichaturismoparam.getFichaturismo().setCodigoficha(codigoficha);
			}
		
			String fpropuestainicio = String.valueOf(request
					.getParameter("fpropuestainicio"));
			String fpropuestafin = String.valueOf(request
					.getParameter("fpropuestafin"));
			
			int idoperadorturismo=0;
			if(request.getParameter("idoperadorturismo")!=null){
				idoperadorturismo=Integer.parseInt(String.valueOf(request
						.getParameter("idoperadorturismo")));
			}else{
				idoperadorturismo=ot.getIdoperadorturismo();
			}
			
			int idrutaturismo=Integer.parseInt(String.valueOf(request
					.getParameter("idrutaturismo")));
			
			
//			if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL
//					|| idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP	 ){
//					idestadoficha=tipoService.obtenerIdtipoxCodigo
//					(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_GENERADO);
//			}
			
			if(request.getParameter("idestadoficha")!=null){
					idestadoficha=Integer.parseInt(String.valueOf(request
							.getParameter("idestadoficha")));		
			}
			
			
			fichaturismoparam.setFpropuestainicio(fpropuestainicio);
			fichaturismoparam.setFpropuestafin(fpropuestafin);
			fichaturismoparam.getFichaturismo().getOperadorturismo().setIdoperadorturismo(idoperadorturismo);
			fichaturismoparam.getFichaturismo().getRutaturismo().setIdrutaturismo(idrutaturismo);
			
			resultado = "lista";
			
		}
		fichaturismoparam.getFichaturismo().getEstadoficha().setIdtipo(idestadoficha);
		pager = fichaturismoService.calcularPaginacion(fichaturismoparam,
				tamanio, numpagina);
		fichas = fichaturismoService.consultarFichaTurismoPaginado(
				fichaturismoparam, indice, tamanio);
		return resultado;
	}

	public String checkFicha() {
		map.put("find", fichaturismoService.count(q));
		return SUCCESS;
	}

	public void initFichas() {
		idarea = ((Areanatural) ActionContext.getContext().getSession()
				.get("area")).getIdareanatural();
		pager = new Pagination(pag,
				(int) fichaturismoService.countActives(idarea));
		fichas = fichaturismoService.listarActivas(idarea, pager.getPagina(),
				pager.getItemsxpag());
	}

	public String guardarRegistroVisitante() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		// SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		int idvisitante = Integer.parseInt(request.getParameter("idvisitante")
				.toString());
		String apepat = String.valueOf(request.getParameter("apepat"));
		String apemat = String.valueOf(request.getParameter("apemat"));
		String nombre = String.valueOf(request.getParameter("nombre"));
		String fnacimiento = String.valueOf(request.getParameter("fnac"));
		int idpais = Integer
				.parseInt(request.getParameter("idpais").toString());
		int idsexo = Integer
				.parseInt(request.getParameter("idsexo").toString());
		int idtipodoc = Integer.parseInt(request
				.getParameter("idtipodocumento").toString());
		String numerodoc = String.valueOf(request
				.getParameter("numerodocumento"));
		Date fnac = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fnac = formateador.parse(fnacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Visitante v = new Visitante();
		v.setIdvisitante(idvisitante);
		v.setApepat(apepat);
		v.setApemat(apemat);
		v.setNombre(nombre);
		v.getPais().setIdpais(idpais);
		v.getSexo().setIdtipo(idsexo);
		if (idtipodoc == 0) {
			v.getTipodocumento().setIdtipo(ValueConstants.VALOR_CERO);
		} else {
			v.getTipodocumento().setIdtipo(idtipodoc);
		}
		if (numerodoc == null) {
			numerodoc = "";
		}
		v.setNumerodocumento(numerodoc);
		v.setFechanacimiento(fnac);
		visitanteService.actualizarRegistroVisitante(v);
		return "success";
	}

	
	public String areas() {
		setAreasNaturales(areaNaturalService
				.consultarAreasNaturalesConTurismo());
		return SUCCESS;
	}

	
//public Fichaturismo getDatosFichaTurismo(){
//    	
//    	fichaturismo = fichaturismoService.consultarDetalleFichaTurismoxId(idfichaturismo);
//		
//    	
//    	List<TipoturismoFichaturismo> tl = fichaturismo.getListaTipoturismoFichaturismo();
//    	String cadTipoturismo = "";
//    	for(TipoturismoFichaturismo t : tl){
//    		if(cadTipoturismo.equals(""))
//    			cadTipoturismo += t.getTipoturismo().getNombretipoturismo();
//    		else
//    			cadTipoturismo += ", "+t.getTipoturismo().getNombretipoturismo();
//    			
//    	}
//    	
//    	reportParams.put("cadTipoturismo", cadTipoturismo);
//    	
//    	List<Actividadturismo> at = fichaturismo.getListaActividadturismo();
//    	String cadActividadturismo = "";
//    	for(Actividadturismo a : at){
//    		if(cadActividadturismo.equals(""))
//    			cadActividadturismo += a.getNombreactividadturismo();
//    		else
//    			cadActividadturismo += ", "+a.getNombreactividadturismo();
//    			
//    	}
//    	
//    	reportParams.put("cadActividadturismo", cadActividadturismo);
//    	
//    	List<GuiaFichaTurismo> gt = fichaturismo.getListaGuiaFichaturismo();
//    	String cadGuiaFichaturismo = "";
//    	for(GuiaFichaTurismo g : gt){
//    		if(cadGuiaFichaturismo.equals(""))
//    			cadGuiaFichaturismo += g.getGuia().getApepat()+" "+g.getGuia().getApemat()+", "+g.getGuia().getNombre();
//    		else
//    			cadGuiaFichaturismo += "\n"+g.getGuia().getApepat()+" "+g.getGuia().getApemat()+", "+g.getGuia().getNombre();
//    			
//    	}
//    	
//    	reportParams.put("cadGuiaFichaturismo", cadGuiaFichaturismo);
//    	String rutaLogo = logoService.consultarRutaLogoPrincipalxIdareanatural(fichaturismo.getAreanatural().getIdareanatural());
//		
//    	reportParams.put("rutaLogo", rutaLogo);
//		return fichaturismo;
//	}  
	



   public String generarPdfFicha(){
	   fichaturismo=fichaturismoService.consultarDetalleFichaTurismoxId(idfichaturismo);
	   List<TipoturismoFichaturismo> tl = fichaturismo.getListaTipoturismoFichaturismo();
   	String cadTipoturismo = "";
   	for(TipoturismoFichaturismo t : tl){
   		if(cadTipoturismo.equals(""))
   			cadTipoturismo += t.getTipoturismo().getNombretipoturismo();
   		else
   			cadTipoturismo += ", "+t.getTipoturismo().getNombretipoturismo();
   			
   	}
   	
   	reportParams.put("cadTipoturismo", cadTipoturismo);
   	
   	List<Actividadturismo> at = fichaturismo.getListaActividadturismo();
   	String cadActividadturismo = "";
   	for(Actividadturismo a : at){
   		if(cadActividadturismo.equals(""))
   			cadActividadturismo += a.getNombreactividadturismo();
   		else
   			cadActividadturismo += ", "+a.getNombreactividadturismo();
   			
   	}
   	
   	reportParams.put("cadActividadturismo", cadActividadturismo);
   	
   	List<GuiaFichaTurismo> gt = fichaturismo.getListaGuiaFichaturismo();
   	String cadGuiaFichaturismo = "";
   	for(GuiaFichaTurismo g : gt){
   		if(cadGuiaFichaturismo.equals(""))
   			cadGuiaFichaturismo += g.getGuia().getApepat()+" "+g.getGuia().getApemat()+", "+g.getGuia().getNombre();
   		else
   			cadGuiaFichaturismo += "\n"+g.getGuia().getApepat()+" "+g.getGuia().getApemat()+", "+g.getGuia().getNombre();
   			
   	}
   	
   	reportParams.put("cadGuiaFichaturismo", cadGuiaFichaturismo);
   	String rutaLogo = logoService.consultarRutaLogoPrincipalxIdareanatural(fichaturismo.getAreanatural().getIdareanatural());
		
   	reportParams.put("rutaLogo", rutaLogo);
	   nombrearchivo="ficha_"+fichaturismo.getCodigoficha();
	   
	   return "success";
   }

    public InputStream getImagenLogo() throws Exception { 
	Map<String, Object> session = ActionContext.getContext().getSession(); 
	areanatural=(Areanatural) session.get("area");
	String contentType = "image/gif"; 
	//String rutaimagen=session.get("rutaImagenVS").toString();
	String rutaimagen=logoService.consultarRutaLogoPrincipalxIdareanatural(areanatural.getIdareanatural());
	//System.out.println("ruta:"+rutaimagen+"/"+areanatural.getIdareanatural());
	File file = new File(rutaimagen);
     Result result = ActionContext.getContext(). getActionInvocation().getResult();
     if (result != null && result instanceof StreamResult) {
			StreamResult streamResult = (StreamResult) result;
			streamResult.setContentType(contentType); } 
		try { 
			return new FileInputStream(file); }
		catch (IOException ex) { } 
     return null;
	
    }


    public String consultarPagosFichaTurismo(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String resultado="";
		areanatural = (Areanatural) session.get("area");
		String codigoficha = String.valueOf(request.getParameter("codigoficha"));
	    FichaTurismoParam fichaturismoparam=new FichaTurismoParam();
	    fichaturismoparam.getFichaturismo().getAreanatural()
		.setIdareanatural(areanatural.getIdareanatural());
		int tamanio = ValueConstants.TAMANIO_PAGINA_20;
		//tamanio=5;
		int indice=0;
		if(idcontrol==ValueConstants.LINK_INICIO_0){
			resultado="inicio";
		}else
			if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
				if (!codigoficha.equals("")) {
					fichaturismoparam.getFichaturismo().setCodigoficha(codigoficha);
				}
				indice = ((numpagina - 1) * tamanio);
				resultado="lista";
			}
		pager = fichaturismoService.calcularPaginacionFichasPagoValidado(fichaturismoparam,
				tamanio, numpagina);
	    listaFichaturismo=fichaturismoService.consultarFichasPagoValidadoPaginado(fichaturismoparam, indice, tamanio);
    	return resultado;
    }
    
    

    
    
    public String consultarDetallePagoFichaturismo(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String codigoficha = String.valueOf(request.getParameter("codigoficha"));
		fichaturismo=fichaturismoService.consultarDetalleFichaPagoBancoxCodigoFichaturismo(codigoficha);
    	
		return "success";
    }

    
    //old registro fichaturismo
//    public String irRegistroFichaTurismo(){
//    	Map<String, Object> session = ActionContext.getContext().getSession();
//    	Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
//    	idpais=ValueConstants.ID_PAIS_PERU;
//    	areanatural = (Areanatural) session.get("area");
//		int idarea = areanatural.getIdareanatural();
//		setSize(rutaturismoService.size(idarea));
//		//listas
//		listaAgenciaviaje = operadorService
//				.listarAgenciasDeViajexAreaNatural(idarea);
//		listaOperadorturismo = operadorService
//		.listarOperadoresTurismoxAreaNatural(idarea);
//		rutas=rutaturismoService.listarxArea(idarea);
//		fichaturismo=fichaturismoService.consultarDetalleFichaTurismoxId(idparam);
//		
//		listaTipoturismo = tipoTurismoService.listarTipoTurismo();
//		listaGenero = tipoService.listarGenero();
//		listaTipoDocumento = tipoService.listarTipoDocumentoIdentidad();
//		listaTipoturismo = tipoTurismoService.listarTipoTurismo();
//		listaConceptoexoneracionpago = tipoService
//				.listarConceptoExoneracionPago();
//		paises=paisService.listar();
//		boletajes = boletajeService.listar(idarea);
//		visitantes=fichaturismo.getListaVisitante();
//		listaBoletajemayoredad=boletajeService.listarBoletajeMayorEdadxIdruta(fichaturismo.getRutaturismo().getIdrutaturismo());
//		listaBoletajemenoredad=boletajeService.listarBoletajeMenorEdadxIdruta(fichaturismo.getRutaturismo().getIdrutaturismo());
//		listaBoletajeinfante=boletajeService.listarBoletajeInfante();
//		listaConceptoexoninfante=tipoService.listarConceptoExoneracionPagoInfante();
//		listaConceptoexonnoinfante=tipoService.listarConceptoExoneracionPagoNoInfante();
//		return "success";
//    }
    
    
    public String irRegistroFichaTurismo(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
    	areanatural = (Areanatural) session.get("area");
    	if (u.getPersonal().getIdpersonal() == 0) {
			Operadorturismo ot = (Operadorturismo) session
					.get("operadorturismo");
			fichaturismo.getOperadorturismo().setIdoperadorturismo(
					ot.getIdoperadorturismo());
		}
    	//idpais=ValueConstants.ID_PAIS_PERU;
		int idarea = areanatural.getIdareanatural();
		 listaAgenciaviaje = operadorService
		.listarAgenciasDeViajexAreaNatural(idarea);
         listaOperadorturismo = operadorService
        .listarOperadoresTurismoxAreaNatural(idarea);
        rutas=rutaturismoService.listarxArea(idarea);
        listaTipoturismo = tipoTurismoService.listarTipoTurismo();
        if(idparam!=0){
        	//fichaturismoService.quitarFlagRegistroQuitadoVisitantesxIdficha(idparam);
        	//fichaturismoService.eliminarVisitantesTemporalesxIdficha(idparam);
			fichaturismo=fichaturismoService.consultarFichaTurismoxId(idparam);
			//listaVisitante=fichaturismo.getListaVisitante();
			
		}
        int tiporegistro=0;
        if(idparam==0){
        	tiporegistro=ValueConstants.TIPO_REGISTRO_CREAR;
        }else{
        	tiporegistro=ValueConstants.TIPO_REGISTRO_EDITAR;
        }
        session.put("idtiporegistro", tiporegistro);
		//setSize(rutaturismoService.size(idarea));
		//listas
		
		//listaGenero = tipoService.listarGenero();
		//listaTipoDocumento = tipoService.listarTipoDocumentoIdentidad();
		
		//listaConceptoexoneracionpago = tipoService.listarConceptoExoneracionPago();
		//paises=paisService.listar();
		//boletajes = boletajeService.listar(idarea);
		//visitantes=fichaturismo.getListaVisitante();
		//listaBoletajemayoredad=boletajeService.listarBoletajeMayorEdadxIdruta(fichaturismo.getRutaturismo().getIdrutaturismo());
		//listaBoletajemenoredad=boletajeService.listarBoletajeMenorEdadxIdruta(fichaturismo.getRutaturismo().getIdrutaturismo());
		//listaBoletajeinfante=boletajeService.listarBoletajeInfante();
		//listaConceptoexoninfante=tipoService.listarConceptoExoneracionPagoInfante();
		//listaConceptoexonnoinfante=tipoService.listarConceptoExoneracionPagoNoInfante();
		return "success";
    }
    
 
    
    public String consultarMinimoFichaTurismo(){
    	Fichaturismo ft= fichaturismoService.consultarMinimoFichaTurismoxId(idfichaturismo);
    	datos.put("fichaturismo", ft);
    	return "success";
    }
    
    

    public Usuario capturarRegistroFichaTurismo(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	Usuario u= (Usuario) session.get("USUARIO_ACTUAL");
    	fichaturismo.getListaTipoturismoFichaturismo().removeAll(Collections.singleton(null));
		fichaturismo.getListaGuiaFichaturismo().removeAll(Collections.singleton(null));
		fichaturismo.getListaActividadturismo().removeAll(Collections.singleton(null));
    	//formatear fechas hasta encontrar conversor
    	SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
    	try {
			if (!fichaturismo.getFpropuesta().equals("")) {
				fichaturismo.setFechapropuesta(formateador.parse(fichaturismo
						.getFpropuesta()));
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//end formateo fechas
		if (u.getPersonal().getIdpersonal() == 0) {
			Operadorturismo ot = (Operadorturismo) session
					.get("operadorturismo");
			fichaturismo.getOperadorturismo().setIdoperadorturismo(
					ot.getIdoperadorturismo());
		}
		return u;
    }
    
    
    
    
    public String generarFichaTurismo(){
    	Usuario u=capturarRegistroFichaTurismo();
    	fichaturismoService.generarFichaturismo(fichaturismo);
    	 //historial
    	fichaturismoService.guardarHistorialAccionFicha(fichaturismo.getIdfichaturismo(), u.getIdUsuario(), ValueConstants.CODIGO_TIPO_ACCION_FICHA_GENERAR);
    	datos.put("idficha", fichaturismo.getIdfichaturismo());
    	return "success";
    }
    
    
    public String generarConsolidarFichaTurismo(){
    	Usuario u=capturarRegistroFichaTurismo();
    	//generar
    	fichaturismoService.generarFichaturismo(fichaturismo);
    	fichaturismoService.guardarHistorialAccionFicha(fichaturismo.getIdfichaturismo(), u.getIdUsuario(), ValueConstants.CODIGO_TIPO_ACCION_FICHA_GENERAR);
    	//fichaturismoService.guardarHistorialAccionFicha(fichaturismo.getIdfichaturismo(), u.getIdUsuario(), ValueConstants.CODIGO_TIPO_ACCION_FICHA_PAGAR);
    	//consolidar
    	fichaturismo.setFechaingreso(fichaturismo.getFechapropuesta());
    	fichaturismoService.consolidarFichaDirecto(fichaturismo);
    	double monto=fichaturismoService.calcularMontoFichaTurismoxId((int)fichaturismo.getIdfichaturismo());
    	fichaturismo.getListaPagoFichaturismo().get(0).setMonto(monto);
    	fichaturismoService.guardarListadoPagosFichaTurismo(fichaturismo);
    	fichaturismoService.guardarHistorialAccionFicha(fichaturismo.getIdfichaturismo(), u.getIdUsuario(), ValueConstants.CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR);
    	datos.put("idficha", fichaturismo.getIdfichaturismo());
    	return "success";
    }
    
    public String guardarRegistroFichaTurismo(){ 
    	Usuario u=capturarRegistroFichaTurismo();
    	
    	
//    	 java.util.Date hoy = new java.util.Date();
//    	fichaturismo.setFechacreacion(new Timestamp(hoy.getTime()));
    	int codtipoaccion=0;
    	if(fichaturismo.getIdfichaturismo()==0){
    		codtipoaccion=ValueConstants.CODIGO_TIPO_ACCION_FICHA_CREAR;
    		Map<String, Object> session = ActionContext.getContext().getSession();
        	int idtiporol= (Integer)session.get("idtiporol");
    		fichaturismo.setIdtiporolcreacion(idtiporol);
//    		if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
//    			fichaturismo.getModalidadpago().setIdtipo
//    			(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_MODALIDAD_PAGO, ValueConstants.CODIGO_MODPAGOFICHA_SEDE));
//    		}else
//    			if(idtiporol==ValueConstants.TIPO_ROL_OPERADOR_TURISMO){
//    				fichaturismo.getModalidadpago().setIdtipo
//        			(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_MODALIDAD_PAGO, ValueConstants.CODIGO_MODPAGOFICHA_BANCO));
//
//        		}	
    	}
        long idficha= fichaturismoService.guardarPermanenteFichaTurismo(fichaturismo);
        //historial
        if(codtipoaccion==ValueConstants.CODIGO_TIPO_ACCION_FICHA_CREAR){
        	fichaturismoService.guardarHistorialAccionFicha(idficha,u.getIdUsuario(),codtipoaccion);
        }
        
        datos.put("idficha",idficha);
  	 return "success";
    }
      
    
    public String guardarTemporalRegistroFichaTurismo(){
    	Usuario u=capturarRegistroFichaTurismo();
		long idficha=0;
		idficha=fichaturismoService.guardarTemporalFichaTurismo(fichaturismo);
    	datos.put("idficha", idficha);
		return "success";
    }
    
    
//    public String validarPagoIncompleto(){
//    	Map<String, Object> session = ActionContext.getContext().getSession();
//    	Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
//    	pagofichaturismo.setIdfichaturismo((int)fichaturismo.getIdfichaturismo());
//    	fichaturismoService.adjuntarVoucherAPagoIncompleto(pagofichaturismo);
//		fichaturismoService.guardarHistorialAccionFicha
//		(fichaturismo.getIdfichaturismo(),u.getIdUsuario(),ValueConstants.CODIGO_TIPO_ACCION_FICHA_PAGAR);
//    	 return "success";
//    }

    
    public String irRegistroVisitante(){
    	paises=paisService.listar();
    	listaGenero = tipoService.listarGenero();
    	listaTipoDocumento = tipoService.listarTipoDocumentoIdentidad();
    	listaTipoocupacion=tipoService.listarTipoOcupacion();
    	listaMotivovisita=tipoService.listarMotivoVisita();
    	visitante.getPais().setIdpais(ValueConstants.ID_PAIS_PERU);
    	if(idparam!=0){
    		listaConceptoexoninfante=tipoService.listarConceptoExoneracionPagoInfante();
    		listaConceptoexonnoinfante=tipoService.listarConceptoExoneracionPagoNoInfante();
    		visitante=visitanteService.consultarVisitantexId(idparam);
    		if(visitante.getGrupoedad().getCodigointtipo()==ValueConstants.CODIGO_GRUPO_EDAD_MAYOREDAD){
    			listaBoletaje=boletajeService.listarBoletajeMayorEdadxIdruta(idruta);
    		}else
    		 if(visitante.getGrupoedad().getCodigointtipo()==ValueConstants.CODIGO_GRUPO_EDAD_MENOREDAD){
    				listaBoletaje=boletajeService.listarBoletajeMenorEdadxIdruta(idruta);
        	 }
    		else
             if(visitante.getGrupoedad().getCodigointtipo()==ValueConstants.CODIGO_GRUPO_EDAD_INFANTE){
            	listaBoletaje=boletajeService.listarBoletajeInfante();
    		  }
    		if(visitante.getFlagcompleto()==0){
    			visitante.getBoletaje().setIdboletaje(ValueConstants.VALOR_CERO);
    		}
    		
    	}
    	
    	return "success";
    }
    
    public String guardarRegistroVisitanteFicha(){
    	SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		try {
			if (!visitante.getFnacimiento().equals("")) {
				visitante.setFechanacimiento(formateador.parse(visitante.getFnacimiento()));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
//		int flagregistroficha=0;
//		if(cantidadparam==0){
//			//registrar ficha
//          fichaturismoService.guardarPermanenteFichaTurismoConVisitante(visitante.getFichaturismo().getIdfichaturismo());
//          flagregistroficha=1;
//		}
    	int idvis=visitanteService.guardarVisitante(visitante);
    	datos.put("idvisitante", idvis);
    	return "success";
    }
    
    public String eliminarListadoVisitantes(){
    	visitanteService.eliminarListadoVisitantesxId(listaCodigo);
    	return "success";
    }
    
    public String determinarBolejateVisitantes(){
    	fichaturismoService.actualizarRegistroIncompletoVisitantesxIdficha(idfichaturismo);
    	return "success";
    }
    
    

    
    public String listarVisitantesxFicha(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	if(idfichaturismo!=0){
    		listaVisitante=visitanteService.listarVisitantesxFichaTurismo(idfichaturismo);
    		int idtiporol=(Integer)session.get("idtiporol");
    		if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
    			listaModalidadpago=tipoService.listarModalidadPagoFichaTurismoSedeAnp();
    			PagoFichaturismo pft=new PagoFichaturismo();
    			fichaturismo.getListaPagoFichaturismo().add(pft);
    			fichaturismo.getListaPagoFichaturismo().get(0).getModalidadpago().setCodigointtipo(ValueConstants.CODIGO_MODPAGOFICHA_SEDE);
    		}
//    		paises=paisService.listar();
//        	listaGenero = tipoService.listarGenero();
//        	listaTipoDocumento = tipoService.listarTipoDocumentoIdentidad();
//        	listaTipoocupacion=tipoService.listarTipoOcupacion();
//        	listaMotivovisita=tipoService.listarMotivoVisita();
//        	visitante.getPais().setIdpais(ValueConstants.ID_PAIS_PERU);
    	}
    	return "success";
    }
    
    
    public String consultarPagosBancoFichaTurismo(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String resultado="";
		int tamanio = ValueConstants.TAMANIO_PAGINA_20;
		//int tamanio = 5;
		int indice=0;
		PagoBancoParam pbp=new PagoBancoParam();
		int idanpturismo=0;
		int idtiporol=(Integer) session.get("idtiporol");
		if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
			areanatural = (Areanatural) session.get("area");
			idanpturismo=areanatural.getIdareanatural();
	    }
		if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
			String codigof=String.valueOf(request.getParameter("codigoficha"));
			if(!codigof.equals("")){
				pbp.setCodigoficha(codigof);
			}
			
//			
//			 if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL){
//				 idanpturismo= Integer.parseInt(String.valueOf(request.getParameter("idanpturismo")));
//			 }
				
		}
		pbp.getAreanatural().setIdareanatural(idanpturismo);
		if(idcontrol==ValueConstants.LINK_INICIO_0){
			

			resultado="inicio";
		}else
			if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
				
				indice = ((numpagina - 1) * tamanio);
				resultado="lista";
			}
		pager = pagoBancoService.calcularPaginacion(pbp,
				tamanio, numpagina);
		listaPagobanco=pagoBancoService.consultarPagoBancoPaginado(pbp, indice, tamanio);
		return resultado;
    	
    }
    
    
    public String cargarPagosPancoFichaTurismo(){
    	pagoBancoService.copiarPagosBancoDeArchivosATablas();
    	return "success";
    }
    
    
    public String consultarOperadoresTurismo(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String resultado="";
		int tamanio = ValueConstants.TAMANIO_PAGINA_20;
		//int tamanio = 5;
		int indice=0;
		OperadorParam otp=new OperadorParam();
		int idanpturismo=0;
		int idtiporol=(Integer) session.get("idtiporol");
		if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
			areanatural = (Areanatural) session.get("area");
			idanpturismo=turismoService.consultarIdTurismoxIdAreanatural(areanatural.getIdareanatural());
	    }
		if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
			String nombperjur = String.valueOf(request.getParameter("nombperjur"));
			String username = String.valueOf(request.getParameter("username"));
			if(!nombperjur.equals("")){
				otp.getOperadorturismo().setNombrepersonajuridica(nombperjur);
				//ot.setNombrepersonajuridica(nombperjur);
			}
			if(!username.equals("")){
				otp.getOperadorturismo().getUsuario().setUsername(username);
				//ot.getUsuario().setUsername(username);
			}
			 if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL){
				 idanpturismo= Integer.parseInt(String.valueOf(request.getParameter("idanpturismo")));
			 }
				
		}
		otp.getTurismo().setIdturismo(idanpturismo);
		if(idcontrol==ValueConstants.LINK_INICIO_0){
			listaAnpturismo=turismoService.listarAreasNaturalesConTurismo();
//			otp.getOperadorturismo().setNombrepersonajuridica("");
//			otp.getOperadorturismo().getUsuario().setUsername("");
//			otp.getTurismo().setIdturismo(0);
			resultado="inicio";
		}else
			if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
				
				indice = ((numpagina - 1) * tamanio);
				resultado="lista";
			}
		pager = operadorService.calcularPaginacion(otp,
				tamanio, numpagina);
	    listaOperadorturismo=operadorService.consultarOperadorTurismoPaginado(otp, indice, tamanio);
	    return resultado;
    	
    }
    
    public String buscarAreaNaturalconTurismo(){
    	datos.put("listanptur", turismoService.consultarAreaNaturalConTurismoxNombreAnp(cadena));
    	return "success";
    }
 
   public String irRegistroOperadorTurismo(){
	   paises=paisService.listar();
		listaUbigeodepartamento=ubigeoService.consultarUbigeoDepartamentos();
	   operadorturismo.getPais().setIdpais(ValueConstants.ID_PAIS_PERU);
	   if(idparam!=0){
		   operadorturismo=operadorService.consultarOperadorTurismoxId(idparam);
		   String coddepartamento=operadorturismo.getUbigeo().getCoddepartamento();
			String codprovincia=operadorturismo.getUbigeo().getCodprovincia();
			listaUbigeoprovincia=ubigeoService.listarUbigeosProvinciaxCodigoDepartamento(coddepartamento);
			listaUbigeodistrito=ubigeoService.listarUbigeosDistritoxCodigoProvincia(coddepartamento, codprovincia);
	   }
	   return "success";
   } 
    
   public String guardarRegistroOperadorTurismo(){
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   HttpServletRequest request = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
	   int mensaje=0;
	   operadorturismo.getListaAnpturismo().removeAll(Collections.singleton(null));
	   //poner razon social hasta solucionar modelo
	   operadorturismo.setRazonsocial(operadorturismo.getNombrepersonajuridica());
	   //areanatural = (Areanatural) session.get("area");
	   //trim
	   if(operadorturismo.getIdoperadorturismo()==0){
		   operadorturismo.getUsuario().setUsername(operadorturismo.getUsuario().getUsername().trim());  
	   }
	   mensaje=operadorService.guardarOperadorTurismo(operadorturismo);
	   datos.put("mensaje", mensaje);
	   return "success";
   }
   

   
 public String irRegistroRestablecerClaveOperadorTurismo(){
	   operadorturismo=operadorService.consultarDatosOperadorTurismoxId(idparam);
	   return "success";
   }
   
   public String restablecerClaveOperadorTurismo(){
	   operadorService.modificarClaveOperadorTurismo(operadorturismo);
	   return "success";
   }


   public String ejecutarAccionListadoOperadores(){
   	   if(idaccion==ValueConstants.OPCION_ELIMINAR){
   		operadorService.eliminarListadoOperadoresxId(listaCodigo);
       }
   	   return "success";
   }
   
   public String guardarUsuarioOperadorTurismo(){
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   operadorService.modificarClaveOperadorTurismo(operadorturismo);
	   //datos.put("mensaje", mensaje);
	   return "success";
   }
   
   public String consultarPagosBancoxOperadorTurismo(){
	   //System.out.println("idf"+idfichaturismo);
	   fichaturismo=fichaturismoService.consultarMinimoFichaTurismoxId(idfichaturismo);
	   listaPagobanco=pagoBancoService.consultarPagosBancoConSaldoxIdOperadorTurismo
	   (fichaturismo.getOperadorturismo().getIdoperadorturismo());
//	   listaPagobanco=pagoBancoService.consultarPagosBancoConSaldoxIdOperadorTurismo
//	   (fichaturismo.getOperadorturismo().getIdoperadorturismo(), fichaturismo.getCodigoficha());
	   return "success";
   }
   
   
   public String consultarGuiasTurismo(){
   	Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String resultado="";
		int tamanio = ValueConstants.TAMANIO_PAGINA_20;
		//int tamanio = 5;
		int indice=0;
		GuiaParam guiap=new GuiaParam();
		int idanpturismo=0;
		int idtiporol=(Integer) session.get("idtiporol");
		if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP){
			areanatural = (Areanatural) session.get("area");
			idanpturismo=turismoService.consultarIdTurismoxIdAreanatural(areanatural.getIdareanatural());
	    }
		if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
			String nombpernat = String.valueOf(request.getParameter("nombpernat"));
			if(!nombpernat.equals("")){
				guiap.getGuia().setApepat(nombpernat);
				guiap.getGuia().setApemat(nombpernat);
				guiap.getGuia().setNombre(nombpernat);		
			}
			 if(idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL){
				 idanpturismo= Integer.parseInt(String.valueOf(request.getParameter("idanpturismo")));
			 }
			
		}
		guiap.getTurismo().setIdturismo(idanpturismo);
		if(idcontrol==ValueConstants.LINK_INICIO_0){
			listaAnpturismo=turismoService.listarAreasNaturalesConTurismo();
			resultado="inicio";
		}else
			if(idcontrol==ValueConstants.CONTROL_NUMPAGINA_1){
				indice = ((numpagina - 1) * tamanio);
				resultado="lista";
			}
		pager = guiaService.calcularPaginacion(guiap,
				tamanio, numpagina);
	    listaGuiaturismo=guiaService.consultarGuiaTurismoPaginado(guiap, indice, tamanio);
   	return resultado;
   	
   }
   
   
   
   public String irRegistroGuiaTurismo(){
	   paises=paisService.listar();
	   listaUbigeodepartamento=ubigeoService.consultarUbigeoDepartamentos();
	   listaTipoDocumento=tipoService.listarTipoDocumentoIdentidad();
	   listaGenero=tipoService.listarGenero();
	   listaEstadocivil=tipoService.listarEstadoCivil();
	   guia.getPais().setIdpais(ValueConstants.ID_PAIS_PERU);
	   if(idparam!=0){
	  guia=guiaService.consultarGuiaTurismoxId(idparam);
		   String coddepartamento=guia.getUbigeo().getCoddepartamento();
			String codprovincia=guia.getUbigeo().getCodprovincia();
			listaUbigeoprovincia=ubigeoService.listarUbigeosProvinciaxCodigoDepartamento(coddepartamento);
			listaUbigeodistrito=ubigeoService.listarUbigeosDistritoxCodigoProvincia(coddepartamento, codprovincia);
	   }
	   return "success";
   } 
    
   public String guardarRegistroGuiaTurismo(){
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   HttpServletRequest request = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
	   SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		try {
			if (!guia.getFnacimiento().equals("")) {
				guia.setFechanacimiento(formateador.parse(guia.getFnacimiento()));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	   int mensaje=0;
	   guia.getListaAnpturismo().removeAll(Collections.singleton(null));
//	   if(operadorturismo.getIdoperadorturismo()==0){
//		   operadorturismo.getUsuario().setUsername(operadorturismo.getUsuario().getUsername().trim());  
//	   }
	   mensaje=guiaService.guardarGuiaTurismo(guia);
	   datos.put("mensaje", mensaje);
       return "success";
   }
   
   
   public String ejecutarAccionListadoGuias(){
   	   if(idaccion==ValueConstants.OPCION_ELIMINAR){
   		 guiaService.eliminarListadoGuiasxId(listaCodigo);  
       }
   return "success";
   }
   
   
  
   
   
   public String ejecutarAccionListadoFichas(){
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   Usuario u = (Usuario) session.get("USUARIO_ACTUAL");
	   SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	   //listaFichaturismosel.removeAll(Collections.singleton(null));
	   List<Fichaturismo> lista=new ArrayList<Fichaturismo>();
	   for(Integer i:listaCodigo){
		   Fichaturismo ft=new Fichaturismo();
		   ft=fichaturismoService.consultarMinimoFichaTurismoxId(i);
		   ft.setFechaingreso(ft.getFechapropuesta());
		   lista.add(ft);
	   }
//	   listaFichaturismosel1.removeAll(Collections.singleton(null));
//	   listaFichaturismosel2.removeAll(Collections.singleton(null));
//	   for(Fichaturismo f:listaFichaturismosel){
//		   System.out.println(f.getIdfichaturismo());
//			SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
//	    	try {
//				if (!f.getFpropuesta().equals("")) {
//					f.setFechaingreso(formateador.parse(f
//							.getFpropuesta()));
//				}
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		  
//	   }
	   
	   
	   
   		if(idaccion==ValueConstants.CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR){
      		fichaturismoService.consolidarListadoFichas(lista,u.getIdUsuario());
        }
   return "success";
   }
   
   
   
   public String irFichaTurismoConsolidada(){
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   String resultado="";
	   int idtiporol=(Integer) session.get("idtiporol");
	   fichaturismo=fichaturismoService.consultarMinimoFichaTurismoxId(idfichaturismo);
	  // session.put("idfichaturismovs", idfichaturismo);
	   listaModalidadpago=tipoService.listarModalidadPagoFichaTurismo();
		areanatural = (Areanatural) session.get("area");
		idarea = areanatural.getIdareanatural();
		fichaturismo = fichaturismoService.consultarDetalleFichaConPagosxIdxAnp(idfichaturismo, idarea);
		boletaje=boletajeService.obtenerBoletajeAdicionalxRutaTurismo(fichaturismo.getRutaturismo().getIdrutaturismo());
	   if(fichaturismo.getEstadoficha().getCodigointtipo()==ValueConstants.CODIGO_ESTADO_FICHA_GENERADO 
			  && idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_ANP ){
		   resultado="registro";
	   }else
		   if(fichaturismo.getEstadoficha().getCodigointtipo()==ValueConstants.CODIGO_ESTADO_FICHA_CONSOLIDADO
				||   idtiporol==ValueConstants.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL   ){
			   resultado="detalle";
		   }
	   return resultado;
   }
   
   
   
   public String validarMontoPagoBanco(){
	   boolean pasamonto=false;
	   for(PagoFichaturismo pft:fichaturismo.getListaPagoFichaturismo()){
		   //System.out.println("idpagoficha"+pft.getIdpagofichaturismo());
		   PagoFichaturismo pagoft= fichaturismoService.consultarPagoFichaTurismoxId(pft.getIdpagofichaturismo());
		   if(pagoft.getModalidadpago().getCodigointtipo()==ValueConstants.CODIGO_MODPAGOFICHA_BANCO_FICHA){
			   //System.out.println("idpb"+pagoft.getPagobanco().getIdpagobanco());
			   if(pagoft.getPagobanco().getIdpagobanco()!=0){
				   PagoBanco pb=pagoBancoService.consultarPagoBancoxId(pagoft.getPagobanco().getIdpagobanco());
				   //System.out.println("m"+pft.getMonto());
				   //System.out.println("s"+pb.getSaldo());
				   if(pft.getMonto()>pb.getSaldo()){
					   pasamonto=true;
				   }
			   }
			   
		   }
	   }
	   datos.put("pasamonto", pasamonto);
	   return "success";
   }
   
   
   public String consultarDetalleGuiaTurismo(){
	   guia=guiaService.consultarGuiaTurismoxId(idparam);
	   return "success";
   }
   
   
//   public String irRegistroFichaTurismoConsolidada(){
//	   Map<String, Object> session = ActionContext.getContext().getSession();
//		//idfichaturismo=(Integer) session.get("idfichaturismovs");
//	   listaModalidadpago=tipoService.listarModalidadPagoFichaTurismo();
//		areanatural = (Areanatural) session.get("area");
//		idarea = areanatural.getIdareanatural();
//		fichaturismo = fichaturismoService.consultarDetalleFichaConPagosxIdxAnp(idfichaturismo, idarea);
//		boletaje=boletajeService.obtenerBoletajeAdicionalxRutaTurismo(fichaturismo.getRutaturismo().getIdrutaturismo());
//		return "success"; 
//	   
//   }
//   
//   public String consultarDetalleFichaTurismoConsolidada(){
//	   Map<String, Object> session = ActionContext.getContext().getSession();
//	   idfichaturismo=(Integer) session.get("idfichaturismovs");
//		listaModalidadpago=tipoService.listarModalidadPagoFichaTurismo();
//		areanatural = (Areanatural) session.get("area");
//		idarea = areanatural.getIdareanatural();
//		fichaturismo = fichaturismoService.consultarDetalleFichaConPagosxIdxAnp(idfichaturismo, idarea);
//		boletaje=boletajeService.obtenerBoletajeAdicionalxRutaTurismo(fichaturismo.getRutaturismo().getIdrutaturismo());
//		return "success"; 
//   }
   
	/********** getters and setters *********/

	public List<?> getIdActividadeTurismo() {
		return idActividadeTurismo;
	}

	public void setIdActividadeTurismo(List<?> idActividadeTurismo) {
		this.idActividadeTurismo = idActividadeTurismo;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public void setPaises(List<?> paises) {
		this.paises = paises;
	}

	public List<?> getPaises() {
		return paises;
	}

	public void setOperadores(List<Operadorturismo> operadores) {
		this.operadores = operadores;
	}

	public List<Operadorturismo> getOperadores() {
		return operadores;
	}

	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}

	public List<Guia> getGuias() {
		return guias;
	}

	public void setTiposturismo(List<?> tiposturismo) {
		this.tiposturismo = tiposturismo;
	}

	public List<?> getTiposturismo() {
		return tiposturismo;
	}

	public void setActividades(List<Actividadturismo> actividades) {
		this.actividades = actividades;
	}

	public List<Actividadturismo> getActividades() {
		return actividades;
	}

	public void setRutas(List<Rutaturismo> rutas) {
		this.rutas = rutas;
	}

	public List<Rutaturismo> getRutas() {
		return rutas;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getJson() {
		return json;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getLog() {
		return log;
	}

	public List<Visitante> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setFicha(long ficha) {
		this.ficha = ficha;
	}

	public long getFicha() {
		return ficha;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setAreasNaturales(List<Areanatural> areasNaturales) {
		this.areasNaturales = areasNaturales;
	}

	public List<Areanatural> getAreasNaturales() {
		return areasNaturales;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getSize() {
		return size;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setBoletajes(List<Boletaje> boletajes) {
		this.boletajes = boletajes;
	}

	public List<Boletaje> getBoletajes() {
		return boletajes;
	}

	public void setFichas(List<Fichaturismo> fichas) {
		this.fichas = fichas;
	}

	public List<Fichaturismo> getFichas() {
		return fichas;
	}

	public void setFichaturismo(Fichaturismo fichaturismo) {
		this.fichaturismo = fichaturismo;
	}

	public Fichaturismo getFichaturismo() {
		return fichaturismo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setPag(int pag) {
		this.pag = pag;
	}

	public int getPag() {
		return pag;
	}

	public void setPager(Pagination pager) {
		this.pager = pager;
	}

	public Pagination getPager() {
		return pager;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getQ() {
		return q;
	}

	public void setCodareanatural(String codareanatural) {
		this.codareanatural = codareanatural;
	}

	public String getCodareanatural() {
		return codareanatural;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setRutaturismo(Rutaturismo rutaturismo) {
		this.rutaturismo = rutaturismo;
	}

	public Rutaturismo getRutaturismo() {
		return rutaturismo;
	}

	public void setPdfStream(InputStream pdfStream) {
		this.pdfStream = pdfStream;
	}

	public InputStream getPdfStream() {
		return pdfStream;
	}

	public List<Map<String, Object>> getListaReporte1() {
		return listaReporte1;
	}

	public void setListaReporte1(List<Map<String, Object>> listaReporte1) {
		this.listaReporte1 = listaReporte1;
	}

	public int getVisibilidadmenu() {
		return visibilidadmenu;
	}

	public void setVisibilidadmenu(int visibilidadmenu) {
		this.visibilidadmenu = visibilidadmenu;
	}

	public Map<String, Object> getDatos() {
		return datos;
	}

	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}

	public List<Tipo> getListaTipoDocumento() {
		return listaTipoDocumento;
	}

	public void setListaTipoDocumento(List<Tipo> listaTipoDocumento) {
		this.listaTipoDocumento = listaTipoDocumento;
	}

	public List<Tipo> getListaGenero() {
		return listaGenero;
	}

	public void setListaGenero(List<Tipo> listaGenero) {
		this.listaGenero = listaGenero;
	}

	public String getDatosJson1() {
		return datosJson1;
	}

	public void setDatosJson1(String datosJson1) {
		this.datosJson1 = datosJson1;
	}

	public String getDatosJson2() {
		return datosJson2;
	}

	public void setDatosJson2(String datosJson2) {
		this.datosJson2 = datosJson2;
	}

	public List<Map<String, Object>> getListaReporte2() {
		return listaReporte2;
	}

	public void setListaReporte2(List<Map<String, Object>> listaReporte2) {
		this.listaReporte2 = listaReporte2;
	}

	public List<Map<String, Object>> getListaReporte3() {
		return listaReporte3;
	}

	public void setListaReporte3(List<Map<String, Object>> listaReporte3) {
		this.listaReporte3 = listaReporte3;
	}

	public List<Map<String, Object>> getListaReporte4() {
		return listaReporte4;
	}

	public void setListaReporte4(List<Map<String, Object>> listaReporte4) {
		this.listaReporte4 = listaReporte4;
	}

	public int getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}

	public int getIdcodigo() {
		return idcodigo;
	}

	public void setIdcodigo(int idcodigo) {
		this.idcodigo = idcodigo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public List<Tipo> getListaAnio() {
		return listaAnio;
	}

	public void setListaAnio(List<Tipo> listaAnio) {
		this.listaAnio = listaAnio;
	}

	public int getIdanio() {
		return idanio;
	}

	public void setIdanio(int idanio) {
		this.idanio = idanio;
	}

	public List<Tipoturismo> getListaTipoturismo() {
		return listaTipoturismo;
	}

	public void setListaTipoturismo(List<Tipoturismo> listaTipoturismo) {
		this.listaTipoturismo = listaTipoturismo;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	
	public List<Conceptoexoneracionpago> getListaConceptoexoneracionpago() {
		return listaConceptoexoneracionpago;
	}

	public void setListaConceptoexoneracionpago(
			List<Conceptoexoneracionpago> listaConceptoexoneracionpago) {
		this.listaConceptoexoneracionpago = listaConceptoexoneracionpago;
	}

	public int getIdparam() {
		return idparam;
	}

	public void setIdparam(int idparam) {
		this.idparam = idparam;
	}

	public List<Operadorturismo> getListaAgenciaviaje() {
		return listaAgenciaviaje;
	}

	public void setListaAgenciaviaje(List<Operadorturismo> listaAgenciaviaje) {
		this.listaAgenciaviaje = listaAgenciaviaje;
	}

	public List<Operadorturismo> getListaOperadorturismo() {
		return listaOperadorturismo;
	}

	public void setListaOperadorturismo(
			List<Operadorturismo> listaOperadorturismo) {
		this.listaOperadorturismo = listaOperadorturismo;
	}
	
	public HashMap getReportParams() {
		return reportParams;
	}

	public void setReportParams(HashMap reportParams) {
		this.reportParams = reportParams;
	}

	public List<Fichaturismo> getListaFichaturismo() {
		return listaFichaturismo;
	}

	public void setListaFichaturismo(List<Fichaturismo> listaFichaturismo) {
		this.listaFichaturismo = listaFichaturismo;
	}

	public int getIdcontrol() {
		return idcontrol;
	}

	public void setIdcontrol(int idcontrol) {
		this.idcontrol = idcontrol;
	}

	public int getNumpagina() {
		return numpagina;
	}

	public void setNumpagina(int numpagina) {
		this.numpagina = numpagina;
	}

	public List<Boletaje> getListaBoletajemayoredad() {
		return listaBoletajemayoredad;
	}

	public void setListaBoletajemayoredad(List<Boletaje> listaBoletajemayoredad) {
		this.listaBoletajemayoredad = listaBoletajemayoredad;
	}

	public List<Boletaje> getListaBoletajemenoredad() {
		return listaBoletajemenoredad;
	}

	public void setListaBoletajemenoredad(List<Boletaje> listaBoletajemenoredad) {
		this.listaBoletajemenoredad = listaBoletajemenoredad;
	}

	public List<Boletaje> getListaBoletajeinfante() {
		return listaBoletajeinfante;
	}

	public void setListaBoletajeinfante(List<Boletaje> listaBoletajeinfante) {
		this.listaBoletajeinfante = listaBoletajeinfante;
	}

	public List<Conceptoexoneracionpago> getListaConceptoexoninfante() {
		return listaConceptoexoninfante;
	}

	public void setListaConceptoexoninfante(
			List<Conceptoexoneracionpago> listaConceptoexoninfante) {
		this.listaConceptoexoninfante = listaConceptoexoninfante;
	}

	public List<Conceptoexoneracionpago> getListaConceptoexonnoinfante() {
		return listaConceptoexonnoinfante;
	}

	public void setListaConceptoexonnoinfante(
			List<Conceptoexoneracionpago> listaConceptoexonnoinfante) {
		this.listaConceptoexonnoinfante = listaConceptoexonnoinfante;
	}

	public int getIdpais() {
		return idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	public ValueConstants getConstantes() {
		return constantes;
	}

	public void setConstantes(ValueConstants constantes) {
		this.constantes = constantes;
	}

	public List<Visitante> getListaVisitante() {
		return listaVisitante;
	}

	public void setListaVisitante(List<Visitante> listaVisitante) {
		this.listaVisitante = listaVisitante;
	}

	public int getIdfichaturismo() {
		return idfichaturismo;
	}

	public void setIdfichaturismo(int idfichaturismo) {
		this.idfichaturismo = idfichaturismo;
	}

	public int getIdruta() {
		return idruta;
	}

	public void setIdruta(int idruta) {
		this.idruta = idruta;
	}

	public List<Boletaje> getListaBoletaje() {
		return listaBoletaje;
	}

	public void setListaBoletaje(List<Boletaje> listaBoletaje) {
		this.listaBoletaje = listaBoletaje;
	}

	public int getIdtiporegistro() {
		return idtiporegistro;
	}

	public void setIdtiporegistro(int idtiporegistro) {
		this.idtiporegistro = idtiporegistro;
	}

	public List<Integer> getListaCodigo() {
		return listaCodigo;
	}

	public void setListaCodigo(List<Integer> listaCodigo) {
		this.listaCodigo = listaCodigo;
	}

	public int getCantidadparam() {
		return cantidadparam;
	}

	public void setCantidadparam(int cantidadparam) {
		this.cantidadparam = cantidadparam;
	}

	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}

	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}

	public List<Ubigeo> getListaUbigeodepartamento() {
		return listaUbigeodepartamento;
	}

	public void setListaUbigeodepartamento(List<Ubigeo> listaUbigeodepartamento) {
		this.listaUbigeodepartamento = listaUbigeodepartamento;
	}

	public List<Ubigeo> getListaUbigeoprovincia() {
		return listaUbigeoprovincia;
	}

	public void setListaUbigeoprovincia(List<Ubigeo> listaUbigeoprovincia) {
		this.listaUbigeoprovincia = listaUbigeoprovincia;
	}

	public List<Ubigeo> getListaUbigeodistrito() {
		return listaUbigeodistrito;
	}

	public void setListaUbigeodistrito(List<Ubigeo> listaUbigeodistrito) {
		this.listaUbigeodistrito = listaUbigeodistrito;
	}

	public List<Areanatural> getListaAreanatural() {
		return listaAreanatural;
	}

	public void setListaAreanatural(List<Areanatural> listaAreanatural) {
		this.listaAreanatural = listaAreanatural;
	}

	public List<Turismo> getListaAnpturismo() {
		return listaAnpturismo;
	}

	public void setListaAnpturismo(List<Turismo> listaAnpturismo) {
		this.listaAnpturismo = listaAnpturismo;
	}

	public List<Guia> getListaGuiaturismo() {
		return listaGuiaturismo;
	}

	public void setListaGuiaturismo(List<Guia> listaGuiaturismo) {
		this.listaGuiaturismo = listaGuiaturismo;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public List<Tipo> getListaEstadocivil() {
		return listaEstadocivil;
	}

	public void setListaEstadocivil(List<Tipo> listaEstadocivil) {
		this.listaEstadocivil = listaEstadocivil;
	}

	public int getIdaccion() {
		return idaccion;
	}

	public void setIdaccion(int idaccion) {
		this.idaccion = idaccion;
	}

	public List<Tipo> getListaTipoocupacion() {
		return listaTipoocupacion;
	}

	public void setListaTipoocupacion(List<Tipo> listaTipoocupacion) {
		this.listaTipoocupacion = listaTipoocupacion;
	}

	public List<Tipo> getListaMotivovisita() {
		return listaMotivovisita;
	}

	public void setListaMotivovisita(List<Tipo> listaMotivovisita) {
		this.listaMotivovisita = listaMotivovisita;
	}

	public List<Rutaturismo> getListaRutaturismo() {
		return listaRutaturismo;
	}

	public void setListaRutaturismo(List<Rutaturismo> listaRutaturismo) {
		this.listaRutaturismo = listaRutaturismo;
	}

	public List<Fichaturismo> getListaFichaturismosel() {
		return listaFichaturismosel;
	}

	public void setListaFichaturismosel(List<Fichaturismo> listaFichaturismosel) {
		this.listaFichaturismosel = listaFichaturismosel;
	}

	public List<Fichaturismo> getListaFichaturismosel1() {
		return listaFichaturismosel1;
	}

	public void setListaFichaturismosel1(List<Fichaturismo> listaFichaturismosel1) {
		this.listaFichaturismosel1 = listaFichaturismosel1;
	}

	public List<Fichaturismo> getListaFichaturismosel2() {
		return listaFichaturismosel2;
	}

	public void setListaFichaturismosel2(List<Fichaturismo> listaFichaturismosel2) {
		this.listaFichaturismosel2 = listaFichaturismosel2;
	}

	public List<Tipo> getListaEstadoficha() {
		return listaEstadoficha;
	}

	public void setListaEstadoficha(List<Tipo> listaEstadoficha) {
		this.listaEstadoficha = listaEstadoficha;
	}

	public PagoFichaturismo getPagofichaturismo() {
		return pagofichaturismo;
	}

	public void setPagofichaturismo(PagoFichaturismo pagofichaturismo) {
		this.pagofichaturismo = pagofichaturismo;
	}

	public List<Tipo> getListaModalidadpago() {
		return listaModalidadpago;
	}

	public void setListaModalidadpago(List<Tipo> listaModalidadpago) {
		this.listaModalidadpago = listaModalidadpago;
	}

	public Boletaje getBoletaje() {
		return boletaje;
	}

	public void setBoletaje(Boletaje boletaje) {
		this.boletaje = boletaje;
	}

	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public List<Visitante> getListaVisitantesel() {
		return listaVisitantesel;
	}

	public void setListaVisitantesel(List<Visitante> listaVisitantesel) {
		this.listaVisitantesel = listaVisitantesel;
	}

	public List<PagoBanco> getListaPagobanco() {
		return listaPagobanco;
	}

	public void setListaPagobanco(List<PagoBanco> listaPagobanco) {
		this.listaPagobanco = listaPagobanco;
	}

	public List<Map<String, Object>> getListaReporte5() {
		return listaReporte5;
	}

	public void setListaReporte5(List<Map<String, Object>> listaReporte5) {
		this.listaReporte5 = listaReporte5;
	}

	public List<Map<String, Object>> getListaReporte6() {
		return listaReporte6;
	}

	public void setListaReporte6(List<Map<String, Object>> listaReporte6) {
		this.listaReporte6 = listaReporte6;
	}

	public String getDatosJson3() {
		return datosJson3;
	}

	public void setDatosJson3(String datosJson3) {
		this.datosJson3 = datosJson3;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
	
	

	


	
	
	
	
	
	
}
