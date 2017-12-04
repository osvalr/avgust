package sernanp.rrhh.web.action.persona;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.cons.Sesiones;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.persona.service.BuscarPersonaService;
import sernanp.app.business.core.persona.service.GestionarPersonalService;
import sernanp.app.business.dto.PersonalDto;
import sernanp.app.dao.domain.Pais;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.PersonalExample;
import sernanp.app.dao.domain.TEntidadBancaria;
import sernanp.app.dao.domain.TGrupoOcupacional;
import sernanp.app.dao.domain.TNivelEstudio;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.domain.TRegimenPensionario;
import sernanp.app.dao.domain.TTipoProfesion;
import sernanp.app.dao.domain.Tablatipo;
import sernanp.app.dao.domain.Ubigeo;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.TEntidadBancariaMapper;
import sernanp.app.dao.mapper.TablatipoMapper;
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQuery;
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQuery;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQueryCriteria;
import sernanp.app.dao.query.domain.PersonaNaturalQuery;
import sernanp.app.dao.query.domain.PersonalQuery;
import sernanp.app.dao.query.domain.PersonalQueryCriteria;
import sernanp.app.dao.query.mapper.FormacionAcademicaPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerDatosBasicosPersonalQueryMapper;
import sernanp.app.dao.query.mapper.PersonalQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class GestionarPersonalAction extends ActionHelper {

	private static Logger log = Logger.getLogger(GestionarPersonalAction.class);
	
	private static final long serialVersionUID = -8901916746697082453L;
	
	@Autowired
	private GestionarPersonalService gestionarPersonalService;
	
		
	@Autowired
	BuscarPersonaService buscarPersonaService;
	
	@Autowired
	CommonService commonService;
	
		
	private PersonalDto personal;
	
	private PersonalQuery personalQuery;
	private PersonaNaturalQuery personaNatural;
	private ObtenerDatosBasicosPersonalQuery datosBasicosQuery;
	private Integer idPersonaNatural;
	private Integer idPersonal;
	private Integer srl_id_personanatural_formacion;

	private List<Ubigeo> listUbigeoDepartamento;
	private List<Pais> listPais;
	private List<Tablatipo> listEstadoCivil;
	private List<Tablatipo> listTipoDocumento;
	private List<Tablatipo> listGenero;
	private List<TRegimenContractual> listRegimenContractual;
	private List<TRegimenPensionario> listRegimenPensionario;
	private List<TEntidadBancaria> listEntidadBancaria;
	private List<TGrupoOcupacional> listGrupoOcupacional;
	private List<TNivelEstudio> listNivelEstudio;
	private List<TTipoProfesion> listTipoProfesion;
	
	private String op;
	private String tipoReg;
	private String numLegajo;
	
	private FormacionAcademicaPersonalQuery formacionAcademica;
	private Integer index;
	private String nombreEntidadBancaria;
	private String nombreTipoLegajo;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Object record;
	
	
	
	
	public String gestionarPersonal(){
		
		if(idPersonal == null){
			return ERROR;
		}
		
		personalQuery=null;
		PersonalQueryCriteria criteria = new PersonalQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		
		List<PersonalQuery> list = buscarPersonaService.selectByCriteria(PersonalQueryMapper.class, criteria);
		if(!list.isEmpty()){
			personalQuery = list.get(0);
//			idPersonal = obtenerIdPersonal(idPersonaNatural);
		    this.getSessionContext().setAttribute(Sesiones.LISTA_INFO_ACADEMICA,null);
		}
		
		if(personalQuery == null){
			return ERROR;
		}
		
		listPais = commonService.obtenerValoresPais();
		listUbigeoDepartamento = commonService.obtenerDepartamentosUbigeo();
		listEstadoCivil = commonService.obtenerValoresTablaTipo(3);
		listTipoDocumento = commonService.obtenerValoresTablaTipo(1);
		listGenero = commonService.obtenerValoresTablaTipo(2);
		listRegimenContractual = commonService.obtenerRegimenContractual();
		listRegimenPensionario = commonService.obtenerRegimenPensionario();
		listEntidadBancaria = commonService.obtenerEntidadBancaria();
		listGrupoOcupacional = commonService.obtenerGrupoOcupacional();
		listNivelEstudio = commonService.obtenerValoresNivelEstudio();
		listTipoProfesion = commonService.obtenerTipoProfesion();
		
		return SUCCESS;
	}
	
	
	public String gestionarPersonalLegajo(){
		
		if(idPersonal == null){
			return ERROR;
		}
		
		datosBasicosQuery=null;
		ObtenerDatosBasicosPersonalQueryCriteria criteria = new ObtenerDatosBasicosPersonalQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		criteria.setIdpersonanatural(idPersonaNatural);
		
		List<ObtenerDatosBasicosPersonalQuery> list = buscarPersonaService.selectByCriteria(ObtenerDatosBasicosPersonalQueryMapper.class, criteria);
		if(!list.isEmpty()){
			record = list.get(0);
		}
		
//		if(datosBasicosQuery == null){
//			return ERROR;
//		}
		
		return SUCCESS;
	}
	
	public String gestionarDesvinculacionPersonal(){
		
		if(idPersonal == null){
			return ERROR;
		}
		
		personalQuery=null;
		ObtenerDatosBasicosPersonalQueryCriteria criteria = new ObtenerDatosBasicosPersonalQueryCriteria();
		criteria.setIdpersonal(idPersonal);
		
		List<ObtenerDatosBasicosPersonalQuery> list = buscarPersonaService.selectByCriteria(ObtenerDatosBasicosPersonalQueryMapper.class, criteria);
		if(!list.isEmpty()){
			record = list.get(0);
		}
		
		if(datosBasicosQuery == null){
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String grabarPersonal(){

		try {
				List<FormacionAcademicaPersonalQuery> listIA = (List<FormacionAcademicaPersonalQuery>) this.getSessionContext().getAttribute(Sesiones.LISTA_INFO_ACADEMICA);
				gestionarPersonalService.actualizarPersonal(personal, listIA);
				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Personal actualizado con éxito.");
		}catch (BusinessException e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(),e);
			
		} catch (Exception e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
			
			log.error(e.getMessage(),e);
			
		}

		return SUCCESS;
	}
		
	public String grabarDesvinculacion(){

		return SUCCESS;
	}	
	

		
	public String gestionarUpload(){
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String agregarEstudio(){
		
		List<FormacionAcademicaPersonalQuery> listIA = (List<FormacionAcademicaPersonalQuery>) this.getSessionContext().getAttribute(Sesiones.LISTA_INFO_ACADEMICA);
		
		if(listIA == null){
			listIA = new ArrayList<FormacionAcademicaPersonalQuery>();
		}
		
		formacionAcademica.setVar_descripcion_institucion(formacionAcademica.getVar_descripcion_institucion().toUpperCase());
		listIA.add(formacionAcademica);
		
		this.getSessionContext().setAttribute(Sesiones.LISTA_INFO_ACADEMICA, listIA);
		
		return SUCCESS;
	}
		
	@SuppressWarnings("unchecked")
	public String eliminarEstudio(){
		
		List<FormacionAcademicaPersonalQuery> listIA = (List<FormacionAcademicaPersonalQuery>) this.getSessionContext().getAttribute(Sesiones.LISTA_INFO_ACADEMICA);
		
		if(listIA == null){
			listIA = new ArrayList<FormacionAcademicaPersonalQuery>();
		}
		
		FormacionAcademicaPersonalQuery obj =listIA.get(index);
		if(obj.getSrl_id_personanatural_formacion() != null){
			obj.setFlagEliminado(1);
		}else{
			listIA.remove(obj);
		}
		
		
		this.getSessionContext().setAttribute(Sesiones.LISTA_INFO_ACADEMICA, listIA);
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String listarEstudios(){
		
		List<FormacionAcademicaPersonalQuery> listIA = (List<FormacionAcademicaPersonalQuery>) this.getSessionContext().getAttribute(Sesiones.LISTA_INFO_ACADEMICA);
		
		if(listIA == null){
			listIA = new ArrayList<FormacionAcademicaPersonalQuery>();
		}
		
		if(listIA.isEmpty()){
			FormacionAcademicaPersonalQueryCriteria criteria = new FormacionAcademicaPersonalQueryCriteria();
			criteria.setIdpersonanatural(idPersonaNatural);
			listIA = commonService.selectByCriteria(FormacionAcademicaPersonalQueryMapper.class, criteria);
			this.getSessionContext(true).setAttribute(Sesiones.LISTA_INFO_ACADEMICA, listIA);
		}
		
		listResult = listIA;
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String editarEstudios(){
		
		List<FormacionAcademicaPersonalQuery> listIA = (List<FormacionAcademicaPersonalQuery>) this.getSessionContext().getAttribute(Sesiones.LISTA_INFO_ACADEMICA);
		
		if(listIA == null){
			listIA = new ArrayList<FormacionAcademicaPersonalQuery>();
		}
		
		FormacionAcademicaPersonalQuery obj = listIA.get(index);
		record = obj;
        
		this.getSessionContext(true).setAttribute(Sesiones.LISTA_INFO_ACADEMICA, listIA);
		
		return SUCCESS;
	}
	
	public String agregarEntidadBancaria(){
		TEntidadBancaria eb = new TEntidadBancaria();
		eb.setVar_desc_entidad_bancaria(nombreEntidadBancaria.toUpperCase());
		commonService.insertarSelectivo(TEntidadBancariaMapper.class, eb);
		record = eb;
		return SUCCESS;
	}
	
	public Integer obtenerIdPersonal(Integer idPersonaNatural){
		PersonalExample example = new PersonalExample();
		example.createCriteria().andIdpersonanaturalEqualTo(idPersonaNatural);
		
		List<Personal> list = commonService.selectByExample(PersonalMapper.class, example);
		
		if(!list.isEmpty()){
			return list.get(0).getIdpersonal();
		}
		else{
			return null;
		}
		
	}
	
	public String listarEntidadBancaria(){
		listResult = commonService.obtenerEntidadBancaria();
		return SUCCESS;
	}
	
	public String agregarTipoLegajo(){
		Tablatipo tt = new Tablatipo();
//		tt.setOrdtablatipo(tt.getOrdtablatipo() + 1);
		tt.setDestablatipo(nombreTipoLegajo.toUpperCase());
		tt.setIdtabla(38);
		commonService.insertarSelectivo(TablatipoMapper.class, tt);
		record = tt;
		return SUCCESS; 
	}
	
	public String listarTipoLegajo(){
		listResult = commonService.obtenerValoresTablaTipo("Tipo de Legajo");
		listResult.remove(0);
		return SUCCESS;
	}
	
	
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		return transaccionUtil;
	}

	public PersonaNaturalQuery getPersonaNatural() {
		return personaNatural;
	}

	public void setPersonaNatural(PersonaNaturalQuery personaNatural) {
		this.personaNatural = personaNatural;
	}

	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}
		
	public List<Tablatipo> getListGenero() {
		return listGenero;
	}

	public void setListGenero(List<Tablatipo> listGenero) {
		this.listGenero = listGenero;
	}
	
	public List<TEntidadBancaria> getListEntidadBancaria() {
		return listEntidadBancaria;
	}

	public void setListEntidadBancaria(List<TEntidadBancaria> listEntidadBancaria) {
		this.listEntidadBancaria = listEntidadBancaria;
	}
	public List<TRegimenContractual> getListRegimenContractual() {
		return listRegimenContractual;
	}

	public void setListRegimenContractual(
			List<TRegimenContractual> listRegimenContractual) {
		this.listRegimenContractual = listRegimenContractual;
	}

	public List<TRegimenPensionario> getListRegimenPensionario() {
		return listRegimenPensionario;
	}

	public void setListRegimenPensionario(
			List<TRegimenPensionario> listRegimenPensionario) {
		this.listRegimenPensionario = listRegimenPensionario;
	}

	public List<Tablatipo> getListTipoDocumento() {
		return listTipoDocumento;
	}

	public void setListTipoDocumento(List<Tablatipo> listTipoDocumento) {
		this.listTipoDocumento = listTipoDocumento;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	public List<Tablatipo> getListEstadoCivil() {
		return listEstadoCivil;
	}

	public void setListEstadoCivil(List<Tablatipo> listEstadoCivil) {
		this.listEstadoCivil = listEstadoCivil;
	}

	public String getTipoReg() {
		return tipoReg;
	}

	public void setTipoReg(String tipoReg) {
		this.tipoReg = tipoReg;
	}
   
	
	public PersonalDto getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalDto personal) {
		this.personal = personal;
	}

	public String getNumLegajo() {
		return numLegajo;
	}

	public void setNumLegajo(String numLegajo) {
		this.numLegajo = numLegajo;
	}

	public List<Ubigeo> getListUbigeoDepartamento() {
		return listUbigeoDepartamento;
	}

	public void setListUbigeoDepartamento(List<Ubigeo> listUbigeoDepartamento) {
		this.listUbigeoDepartamento = listUbigeoDepartamento;
	}

	public List<Pais> getListPais() {
		return listPais;
	}

	public void setListPais(List<Pais> listPais) {
		this.listPais = listPais;
	}


	public List<TGrupoOcupacional> getListGrupoOcupacional() {
		return listGrupoOcupacional;
	}


	public void setListGrupoOcupacional(List<TGrupoOcupacional> listGrupoOcupacional) {
		this.listGrupoOcupacional = listGrupoOcupacional;
	}


	public List<TNivelEstudio> getListNivelEstudio() {
		return listNivelEstudio;
	}


	public void setListNivelEstudio(List<TNivelEstudio> listNivelEstudio) {
		this.listNivelEstudio = listNivelEstudio;
	}


	public List<TTipoProfesion> getListTipoProfesion() {
		return listTipoProfesion;
	}


	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public void setListTipoProfesion(List<TTipoProfesion> listTipoProfesion) {
		this.listTipoProfesion = listTipoProfesion;
	}


	public PersonalQuery getPersonalQuery() {
		return personalQuery;
	}


	public void setPersonalQuery(PersonalQuery personalQuery) {
		this.personalQuery = personalQuery;
	}


	public Integer getIdPersonal() {
		return idPersonal;
	}


	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}


	public FormacionAcademicaPersonalQuery getFormacionAcademica() {
		return formacionAcademica;
	}


	public void setFormacionAcademica(
			FormacionAcademicaPersonalQuery formacionAcademica) {
		this.formacionAcademica = formacionAcademica;
	}


	public Integer getIndex() {
		return index;
	}


	public void setIndex(Integer index) {
		this.index = index;
	}


	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}


	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}


	public String getNombreEntidadBancaria() {
		return nombreEntidadBancaria;
	}


	public void setNombreEntidadBancaria(String nombreEntidadBancaria) {
		this.nombreEntidadBancaria = nombreEntidadBancaria;
	}


	public Object getRecord() {
		return record;
	}


	public void setRecord(Object record) {
		this.record = record;
	}


	public ObtenerDatosBasicosPersonalQuery getDatosBasicosQuery() {
		return datosBasicosQuery;
	}


	public void setDatosBasicosQuery(ObtenerDatosBasicosPersonalQuery datosBasicosQuery) {
		this.datosBasicosQuery = datosBasicosQuery;
	}


	public String getNombreTipoLegajo() {
		return nombreTipoLegajo;
	}


	public void setNombreTipoLegajo(String nombreTipoLegajo) {
		this.nombreTipoLegajo = nombreTipoLegajo;
	}


	public Integer getSrl_id_personanatural_formacion() {
		return srl_id_personanatural_formacion;
	}


	public void setSrl_id_personanatural_formacion(
			Integer srl_id_personanatural_formacion) {
		this.srl_id_personanatural_formacion = srl_id_personanatural_formacion;
	}
	
	
}
