package proyecto.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import proyecto.service.AreaNaturalService;
import proyecto.service.CategoriaAnpService;
import proyecto.service.RutaturismoService;
import proyecto.service.TurismoPagosService;
import proyecto.util.Funciones;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.Fichaturismo;
import proyecto.vo.Rutaturismo;
import proyecto.vo.TurismoPagos;

import com.opensymphony.xwork2.ActionSupport;

public class TurismoPagosAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TurismoPagosAction.class);	

	// 19-07-2012
	private List<TurismoPagos> listaTurismoPagos;
	private List<Categoriaanp> listaCategoriaAnp;
	private List<Areanatural> listaAreasNaturales;
	private List<Rutaturismo> listaRutasTurismo;
	
	// JCEV 19-07-2012
	private TurismoPagosService turismopagosService;
	private CategoriaAnpService categoriaAnpService;
	private AreaNaturalService areaNaturalService;
	private RutaturismoService rutaturismoService;
//	private FichaturismoService fichaturismoService;
	
	private Categoriaanp categoriaanp;
	
	// JCEV 30-07-2012
	private Areanatural areanatural;
	private Rutaturismo rutaturismo;

	// JCEV 30-07-2012
	private TurismoPagos turismopagos;

	// JCEV 08-08-2012
	private Fichaturismo fichaturismo;
	
	public void setTurismopagosService(TurismoPagosService turismopagosService) {
		this.turismopagosService = turismopagosService;
	}
	
	public void setCategoriaAnpService(CategoriaAnpService categoriaAnpService) {
		this.categoriaAnpService = categoriaAnpService;
	}
		
	public void setAreaNaturalService(AreaNaturalService areaNaturalService) {
		this.areaNaturalService = areaNaturalService;
	}
	
	public void setRutaturismoService(RutaturismoService rutaturismoService) {
		this.rutaturismoService = rutaturismoService;
	}

	// JCEV 08-08-2012
//	public void setFichaturismoService(FichaturismoService fichaturismoService) {
//		this.fichaturismoService = fichaturismoService;
//	}

	public TurismoPagosAction(){
		categoriaanp = new Categoriaanp();

		// JCEV 30-07-2012
		areanatural  = new Areanatural();
		rutaturismo  = new Rutaturismo();
		turismopagos = new TurismoPagos();
		fichaturismo = new Fichaturismo();
	}

	// Actualizado JCEV - 31/07/2012 [Al Inicial, carga la Tabla de CATEGORIAS]
	public String listarRegBnkNacion(){
//		HttpServletRequest request = null;
//		Categoriaanp categ         = null;
		String strCant             = null;
		try{
			listaCategoriaAnp = categoriaAnpService.listarCategoriasAnps();			
			strCant 		  = categoriaanp.getCodcategoriaanp();
			
			if(strCant != null){
				listaAreasNaturales = areaNaturalService.listarAreasNaturales(categoriaanp);				
				if(listaAreasNaturales.size() > 0){							
					strCant = areanatural.getCodareanatural();
					if(strCant == null){
						areanatural  = listaAreasNaturales.get(0);
					}										
					listaRutasTurismo = rutaturismoService.listarRutaTurismo(areanatural);
					strCant           = rutaturismo.getCodrutaturismo();
					if(strCant == null){
						rutaturismo  = listaRutasTurismo.get(0);
					}
					this.RecallRegistBnkNacion();				
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return SUCCESS;
	}

	// Actualizado JCEV 31-07-2012
	public String listaAreaNatural(){
		try{			
			listaAreasNaturales = areaNaturalService.listarAreasNaturales(categoriaanp);			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return SUCCESS;
	}

	// Actualizado JCEV 31-07-2012
	public String listaRutaTurismo(){
		try{
			
			listaRutasTurismo = rutaturismoService.listarRutaTurismo(areanatural);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// JCEV - 17/07/2012 actualizado 01-08-2012
	public String RecallRegistBnkNacion(){
		
		String strForm   = null;
		String strFecIni = null;
		String strFecFin = null;
		Date dFecIni     = null;  
		Date dFecFin     = null;
		try {			
//			System.out.println("Entre RecallRegistBnkNacion");
			strForm   = "dd-MM-yyyy";
			strFecIni = turismopagos.getStrFecIni(); // turismopagos.getStrFecIni();
			strFecFin = turismopagos.getStrFecFin();
			dFecIni   = new Date();  
			dFecFin   = new Date();  
			if(strFecIni != null){
				dFecIni = Funciones.String2Date(strFecIni.replace("/", "-"), strForm);
			}
			if(strFecFin != null){
				dFecFin = Funciones.String2Date(strFecFin.replace("/", "-"), strForm);			
			}
			turismopagos.setStrCodCateg(categoriaanp.getCodcategoriaanp());
			turismopagos.setStrCodAreaNat(areanatural.getCodareanatural());			
			turismopagos.setStrRutaTurimo(rutaturismo.getCodrutaturismo());
									
//			System.out.println("fecIni : "+ strFecIni);
//			System.out.println("fecFin : "+ strFecFin);
			
			//listaTurismoPagos = turismopagosService.consultarListaRegPagoBnkNacion(dFecIni, dFecFin,rutaturismo, strForm);			
			listaTurismoPagos = turismopagosService.consultarListaRegPagoBnkNacion(dFecIni, dFecFin,turismopagos, strForm);
			
//			if(listaTurismoPagos.size()>0){
//				for (TurismoPagos x : listaTurismoPagos) {
//					System.out.println("Linea     : " + x.getStrCodCateg() + 
//							           " Fec.Mov. : " + x.getStrFecMov() + 
//							           " Monto    : " + x.getDbImpPag()); 
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String mostrarDetalletaBoletaje(){
		try{
//			listaRutasTurismo = rutaturismoService.listarDetalleBoletaje(turismopagos.getStrRegistroTurista(), 
//                    turismopagos.getStrFecIni(), 
//                    turismopagos.getStrFecFin());
			
			listaRutasTurismo = rutaturismoService.listarDetalleBoletaje(turismopagos.getStrRegistroTurista());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public List<TurismoPagos> getListaTurismoPagos() {
		return listaTurismoPagos;
	}

	public void setListaTurismoPagos(List<TurismoPagos> listaTurismoPagos) {
		this.listaTurismoPagos = listaTurismoPagos;
	}

	public List<Categoriaanp> getListaCategoriaAnp() {
		return listaCategoriaAnp;
	}

	public void setListaCategoriaAnp(List<Categoriaanp> listaCategoriaAnp) {
		this.listaCategoriaAnp = listaCategoriaAnp;
	}

	public List<Areanatural> getListaAreasNaturales() {
		return listaAreasNaturales;
	}

	public void setListaAreasNaturales(List<Areanatural> listaAreasNaturales) {
		this.listaAreasNaturales = listaAreasNaturales;
	}

	public List<Rutaturismo> getListaRutasTurismo() {
		return listaRutasTurismo;
	}

	public void setListaRutasTurismo(List<Rutaturismo> listaRutasTurismo) {
		this.listaRutasTurismo = listaRutasTurismo;
	}

	public Categoriaanp getCategoriaanp() {
		return categoriaanp;
	}

	public void setCategoriaanp(Categoriaanp categoriaanp) {
		this.categoriaanp = categoriaanp;
	}

	// JCEV 30-07-2012
	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public Rutaturismo getRutaturismo() {
		return rutaturismo;
	}

	public void setRutaturismo(Rutaturismo rutaturismo) {
		this.rutaturismo = rutaturismo;
	}
	
	public TurismoPagos getTurismopagos() {
		return turismopagos;
	}

	public void setTurismopagos(TurismoPagos turismopagos) {
		this.turismopagos = turismopagos;
	}	

	public Fichaturismo getFichaturismo() {
		return fichaturismo;
	}

	public void setFichaturismo(Fichaturismo fichaturismo) {
		this.fichaturismo = fichaturismo;
	}
	
}




/*

// JCEV - 17/07/2012
public String listarRegBnkNacion(){
	String strCodCat  = null;
	String strCodArea = null;
	String strRuta    = null;
	Date dFecIni      = null;  
	Date dFecFin      = null;
	try {
		
		logger.info("Entre listarRegBnkNacion ");
		if(dFecIni == null){
			dFecIni = new Date();  
		}
		if(dFecFin == null){
			dFecFin = new Date();  
		}
		listaTurismoPagos = turismopagosService.consultarListaRegPagoBnkNacion(dFecIni, dFecFin, 
				                                                               strCodCat, strCodArea, 
				                                                               strRuta);
		if(listaTurismoPagos.size()>0){
			for (TurismoPagos x : listaTurismoPagos) {
				System.out.println("Linea     : " + x.getnIdtPago() + 
						           " Fec.Mov. : " + x.getStrFecMov() + 
						           " Monto    : " + x.getDbImpPag()); 
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	listaCategoriaAnp = categoriaAnpService.listarCategoriasAnps();
	
	return SUCCESS;
}

	
	// JCEV - 17/07/2012 [Al Inicial, carga la Tabla de CATEGORIAS]
	public String xlistarRegBnkNacion(){				
		HttpServletRequest request = null;
		request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		categoriaanp.setCodcategoriaanp(request.getParameter("codcategoriaanp"));		
		return SUCCESS;
	}

	// Hecho por Yonny Coyla 25-07-2012
	public String xlistaAreaNatural(){
		HttpServletRequest request = null;
		try{
			request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);		
			System.out.println(request.getParameter("codcategoriaanp"));			
			categoriaanp.setCodcategoriaanp(request.getParameter("codcategoriaanp"));			
			listaAreasNaturales = areaNaturalService.listarAreasNaturales(categoriaanp);			
			System.out.println("Count [listaAreasNaturales] : " + listaAreasNaturales.size());
		}catch(Exception e){
			e.printStackTrace();
		}		
		return SUCCESS;
	}

	// JCEV 30-07-2012
	public String xlistaRutaTurismo(){
		HttpServletRequest request = null;
		String strAreanatural      = null;
		try{
			request           = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);		
			strAreanatural    = request.getParameter("codareanatural");
			if(strAreanatural != null){
				areanatural.setCodareanatural(strAreanatural);			
				System.out.println("codareanatural [listaRutasTurismo] : " + areanatural.getCodareanatural());			
				listaRutasTurismo = rutaturismoService.listarRutaTurismo(areanatural);
				System.out.println("Count [listaRutasTurismo] : " + listaRutasTurismo.size());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	*/

//strCodCat  		  = categoriaanp.getCodcategoriaanp();
//strCodArea 		  = areanatural.getCodareanatural();
//strRuta    		  = rutaturismo.getCodrutaturismo();
//listaTurismoPagos = turismopagosService.consultarListaRegPagoBnkNacion(dFecIni, dFecFin, 
//        strCodCat, strCodArea, 
//        strRuta, strForm);
//String strCodCat  = null;
//String strCodArea = null;
//String strRuta    = null;
//listaCategoriaAnp = categoriaAnpService.listarCategoriasAnps();
// turismopagos.setStrCodCateg(categoriaanp.getCodcategoriaanp());


/*
//Areanatural area           = null;	
//Rutaturismo rtur           = null;
//String strFecIni           = null;
//String strFecFin           = null;
//int nLista                 = 0;
//request           = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//strFecIni         = request.getParameter("fechaIni");
//strFecFin         = request.getParameter("fechaFin");
if(strCant == null){
//	if(strCant == null && listaCategoriaAnp.size() == 0){
	categ = listaCategoriaAnp.get(0);				
	categoriaanp.setCodcategoriaanp(categ.getCodcategoriaanp());
}
*/
/*
nLista              = listaAreasNaturales.size(); 
strCant             = areanatural.getCodareanatural();

if(strCant == null && nLista == 0){
	listaAreasNaturales = areaNaturalService.listarSedes();
	areanatural.setCodareanatural((listaAreasNaturales.get(0)).getCodareanatural());
}*/							
//area              = listaAreasNaturales.get(0);

//areanatural.setCodareanatural(areanatural.getCodareanatural());
//nLista            = listaRutasTurismo.size();
//strCant           = String.valueOf(nLista).trim();										

//if(strCant.equalsIgnoreCase("0")){
//	listaRutasTurismo = new ArrayList<Rutaturismo>(); // rutaturismoService.listar();
//	rtur              = new Rutaturismo();
//	rtur.setCodrutaturismo("000000");
//	rtur.setNombrerutaturismo("[--Seleccione--]");
//	listaRutasTurismo.add(rtur);
//}
//rutaturismo.setCodrutaturismo((listaRutasTurismo.get(0)).getCodrutaturismo());
//turismopagos.setStrFecIni(strFecIni);
//turismopagos.setStrFecFin(strFecFin);
