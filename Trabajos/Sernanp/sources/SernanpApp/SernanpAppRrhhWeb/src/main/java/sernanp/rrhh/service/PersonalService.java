package sernanp.rrhh.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalDAO;
import sernanp.rrhh.vo.Areanatural;
import sernanp.rrhh.vo.Categoriaanp;
import sernanp.rrhh.vo.Persona;
import sernanp.rrhh.vo.PersonalAsistenciaResumenVO;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalContratoVO;
import sernanp.rrhh.vo.PersonalDescuentosVO;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;
import sernanp.rrhh.vo.PersonalTardanzaVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.PersonaldiasnolaborablesVO;
import sernanp.rrhh.vo.Personanatural;


public class PersonalService {

	@Autowired
	private PersonalDAO personalDAO;	
	
	public void setPersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO;
	}	
	
	
	public Personanatural listapersonalxID(int idp){
		return personalDAO.listapersonalxID(idp).get(0);
	}
	
	
	public PersonalVO personalTurno(int idp){
		return personalDAO.personalTurno(idp).get(0);
	}
	

	
	public List<PersonalAsistenciaVO> Incidencias(String fechaAsist){
		return personalDAO.Incidencias(fechaAsist);
	}
	

	
	public List<PersonalVO> listapersonalxfechaymotivoAsistApepat(String fechaAsist, int estadoAsist, String aPaterno, int idregcontractual, int ubicacionPersonal, int idANP, int nroRegistros){
		return personalDAO.listapersonalxfechaymotivoAsistApepat(fechaAsist, estadoAsist, aPaterno, idregcontractual, ubicacionPersonal, idANP, nroRegistros);
	}
	

	
	public void guardardiasnolaborables(PersonaldiasnolaborablesVO personaldiasnolaborablesVO){

//		return personalDAO.guardardiasnolaborables(personaldiasnolaborablesVO);
	}
	
	public List<PersonaldiasnolaborablesVO> listadiasnolaborables (int anio){
		return personalDAO.listadiasnolaborables(anio);

	}

	public List<PersonaldiasnolaborablesVO> listaperiododiasnolaborables (){
		return personalDAO.listaperiododiasnolaborables();

	}
	
/*25-09-2014
	public List<PersonalMarcacionVO> listapersonalmarcxID(int idpersonal, String fecmarc){
		return personalDAO.listapersonalmarcxID(idpersonal, fecmarc);
	}
*/
	
	public List<PersonalTardanzaVO> listapersonalconTardanzaTMP(String primerdiames, String ultimodiames){
		return personalDAO.listapersonalconTardanzaTMP(primerdiames, ultimodiames);
	}
	
	
	public List<PersonalTardanzaVO> listapersonalconTardanza(String primerdiames, String ultimodiames, int generaoValidadesc, int ubicacion, int idreg){
		return personalDAO.listapersonalconTardanza(primerdiames, ultimodiames,generaoValidadesc, ubicacion, idreg);
	}
	

	public List<PersonalDescuentosVO> listapersonaltardanzaDesc(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, int generaoValidadesc){
		return personalDAO.listapersonaltardanzaDesc(primerdiamesdesc, ultimodiamesdesc, periododesc, mesdesc, generaoValidadesc);
	}
	
	
	public List<PersonalDescuentosVO> listapersonalinasistenciaDesc(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, int generaoValidadesc){
		return personalDAO.listapersonalinasistenciaDesc(primerdiamesdesc, ultimodiamesdesc, periododesc, mesdesc, generaoValidadesc);
	}
	

	
	public List<PersonalAsistenciaVO> listainasistenciasPermisosxidpersonal(int periodo, int mes, int idPersonal, String primerdiames, String ultimodiames, int descValidados){
		return personalDAO.listainasistenciasPermisosxidpersonal(periodo, mes, idPersonal, primerdiames, ultimodiames, descValidados);
	}
	

	
	public void guardarListaTardanza(List<PersonalTardanzaVO> tardanzaLista){
		personalDAO.guardarListaTardanza(tardanzaLista);
	}
	
	
//	public void guardarListaDescuentos(List<PersonalDescuentosVO> ListaDescuentos){
//		personalDAO.guardarListaDescuentos(ListaDescuentos);
//	}
	
		
	public void guardarListaDescuentos(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, int ubicacion, int idreg, int idanp, String nombreTabla){
	personalDAO.guardarListaDescuentos( primerdiamesdesc,  ultimodiamesdesc, periododesc, mesdesc, ubicacion, idreg, idanp, nombreTabla);
	}
	
	public void	guardarListaDescuentosValid(List<PersonalDescuentosVO> ListaDescuentos){
		personalDAO.guardarListaDescuentosValid(ListaDescuentos);
	}
	
	public void	eliminarDescuentosTmp(){
		personalDAO.eliminarDescuentosTmp();
	}
	
	
	public List<PersonalDescuentosVO> listapersonalDescuento(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, String apepat, 
			int descTmpValid, int regcontractual, int ubicacionPersonal, int idANP){
		return personalDAO.listapersonalDescuento(primerdiamesdesc, ultimodiamesdesc, periododesc, mesdesc, apepat, descTmpValid, regcontractual, ubicacionPersonal, idANP);
	}


	public List<PersonalDescuentosVO> listarPeriodoMesDescuento(int anio_mes){
		return personalDAO.listarPeriodoMesDescuento(anio_mes);
	}
	
	
//	public List<PersonalDescuentosVO> buscarpersonalDescuentoxapepat(String primerdiamesdesc, String ultimodiamesdesc, int periododesc, int mesdesc, String apaterno, int descValidados){
//		return personalDAO.buscarpersonalDescuentoxapepat(primerdiamesdesc, ultimodiamesdesc, periododesc, mesdesc, apaterno, descValidados);
//	}
//	
	
	
	public List<Personanatural> listaapesencontrados(){
		return personalDAO.listaapepatencontrados();
	}
		
	
	public void guardarPersona(List<Persona> listPersonanoExiste){
		personalDAO.guardarPersona(listPersonanoExiste);
	}
	
	
	public List<PersonalVO> lista_personal(){
		
		return personalDAO.lista_personal();
	}
	
	
	public int tardanzasgeneradas(String primerdiamesdesc, String ultimodiamesdesc){
		
		return personalDAO.tardanzasgeneradas(primerdiamesdesc, ultimodiamesdesc);
	}
	
	
	public int contardescuentosvalidadosxperiodo(int periododes, int mesdesc, int ubicacion, int idANP, int idregimen){
		
		return personalDAO.contardescuentosvalidadosxperiodo(periododes, mesdesc, ubicacion, idANP, idregimen);
	}
	
	
	public int contardescuentosTMPxperiodo(int periododes, int mesdesc){
		
		return personalDAO.contardescuentosTMPxperiodo(periododes, mesdesc);
	}
	
	
	
	public void guardarPersonal(List<PersonalVO> lp){
		
		personalDAO.guardarPersonal(lp);
	}

	public void updatePersonalEstado(List<PersonalVO> lpe){
		
		personalDAO.updatePersonalEstado(lpe);
	}
	
	
	public void updatePersonalContrato(List<PersonalContratoVO> upc){
		
		personalDAO.updatePersonalContrato(upc);
	}	
	
	
	
	
	public int verificarLicenciasPersonal(int idP, String fechaAsist){
		return personalDAO.verificarLicenciasPersonal(idP, fechaAsist);
	}
	
	public int verificarVacacionesPersonal(int idP, String fechaAsist){
		return personalDAO.verificarVacacionesPersonal(idP, fechaAsist);
	}
	
	
	
	/*ADD 19-08-2014 (D.V.R)      -----------      OBTENER EL ESTADO DE ASISTENCIA X FECHA  ---------*/
	
	
	public List<PersonalAsistenciaVO> obtenerEstadoAsistencia(int idPersonal, String dte_fec_marc){
		return personalDAO.obtenerEstadoAsistencia(idPersonal, dte_fec_marc);
	}
	
	//09-09-2014 CATEGORIAS ANP
	public List<Categoriaanp>listaCatANPs(){
		return personalDAO.listaCatANPs();
	}	
	
	public List<Areanatural>listaANPs(int idCatANP){
		return personalDAO.listaANPs(idCatANP);
	}
	
	/*REPORTES*/
	
	public List<PersonalAsistenciaVO>listaInasistenciasRangoFechas(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual, int tipoReporte){
		return personalDAO.listaInasistenciasRangoFechas(fechaInicio, fechaFin, intUbicacion, idPersonal, regimenContractual, tipoReporte);
	}


	public List<PersonalDesplazamientoVO>listarPersonalporActividad(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){
		return personalDAO.listarPersonalporActividad(fechaInicio, fechaFin, intUbicacion, idPersonal, regimenContractual);
	}
	
	
	public List<PersonalAsistenciaResumenVO>listarPersonalResumenAsistencia(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){
		return personalDAO.listarPersonalResumenAsistencia(fechaInicio, fechaFin, intUbicacion, idPersonal, regimenContractual);
	}
	
	public PersonalAsistenciaResumenVO listarPersonalResumenAsistenciaRecord(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){
		return personalDAO.listarPersonalResumenAsistenciaRecord(fechaInicio, fechaFin, intUbicacion, idPersonal, regimenContractual).get(0);
	}
	
	public List<PersonalAsistenciaVO>listarPersonalRecordAsistencias(Date fechaInicio, Date fechaFin, int intUbicacion, int idPersonal, int regimenContractual){		
		return personalDAO.listarPersonalRecordAsistencias(fechaInicio, fechaFin, intUbicacion, idPersonal, regimenContractual);
	}
	
}
