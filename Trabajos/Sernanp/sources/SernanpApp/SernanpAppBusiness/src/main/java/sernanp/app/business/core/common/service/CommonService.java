package sernanp.app.business.core.common.service;

import java.util.Date;
import java.util.List;

import sernanp.app.dao.domain.Areanatural;
import sernanp.app.dao.domain.Pais;
import sernanp.app.dao.domain.TCargo;
import sernanp.app.dao.domain.TEntidadBancaria;
import sernanp.app.dao.domain.TGrupoOcupacional;
import sernanp.app.dao.domain.TNivelEstudio;
import sernanp.app.dao.domain.TProfesion;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.domain.TRegimenPensionario;
import sernanp.app.dao.domain.TTipificacion;
import sernanp.app.dao.domain.TTipoProfesion;
import sernanp.app.dao.domain.Tablatipo;
import sernanp.app.dao.domain.Ubigeo;
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQuery;
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQuery;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaRegistradaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQuery;
import sernanp.app.dao.query.domain.TablaTipoQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface CommonService extends IHelperService {
    void registrarHistorial(String codigo,Object recordCambios,Object record, String tipoOp,Integer idResponsable,String nombreTabla) throws BusinessException;
    String obtenerSecuencia(String nomTabla,boolean save, boolean forma) throws BusinessException;
    String obtenerFormatoLargoSecuencia(String nomTabla,String secuencia) throws BusinessException;
    List<Tablatipo> obtenerValoresTablaTipo(Integer idTabla) throws BusinessException;
    List<Tablatipo> obtenerValoresTablaTipo(Integer idTabla,Integer codIntTablaTipo) throws BusinessException;
    List<TablaTipoQuery> obtenerValoresTablaTipo(String desTabla) throws BusinessException;
    List<Ubigeo> obtenerDepartamentosUbigeo() throws BusinessException;
    List<Ubigeo> obtenerProvinciaUbigeo(String idDepartamento) throws BusinessException;
    List<Ubigeo> obtenerDistritoUbigeo(String idDepartamento,String idProvincia) throws BusinessException;
    List<TNivelEstudio> obtenerValoresNivelEstudio() throws BusinessException;
    List<Pais> obtenerValoresPais() throws BusinessException;
    List<ConvocatoriaDisponibleQuery> obtenerConvocatoriasDisponibles(ConvocatoriaDisponibleQueryCriteria criteria) throws BusinessException;
    List<CodigoPostulacionDisponibleQuery> obtenerCodigoPostulacionesDisponibles(CodigoPostulacionDisponibleQueryCriteria criteria) throws BusinessException;
    Integer buscarExistenciaEmail(String email, Integer idPostulante) throws BusinessException;
    Integer buscarExistenciaNumeroRuc(String val, Integer idPersona) throws BusinessException;
    Integer buscarExistenciaTipoNumeroDocIdentidad(Integer tipoDoc, String numeroDoc,Integer idPersonaNatural) throws BusinessException;
    Integer buscarExistenciaPostulanteConCodPostulacion(Integer idPostulanteConvocatoriaAreaOrganica,Integer idPostulante) throws BusinessException;
    List<ConvocatoriaRegistradaQuery> obtenerConvocatoriasRegistradas(Integer idPersona) throws BusinessException;
    Integer obtenerEstadoPersonal(Integer idPersonaNatural) throws BusinessException;
    String obtenerSecuenciaAdenda(Integer idContrato, Date fechaInicio, boolean formatoLargo) throws BusinessException;
    String obtenerFormatoLargoSecuenciaAdenda(String secuencia) throws BusinessException;
    /*cambio alanmar 1232 06082014*/
    List<TGrupoOcupacional> obtenerGrupoOcupacional() throws BusinessException;
    List<TRegimenPensionario> obtenerRegimenPensionario() throws BusinessException;
    List<TEntidadBancaria> obtenerEntidadBancaria() throws BusinessException;
    List<TRegimenContractual> obtenerRegimenContractual() throws BusinessException;
    List<TTipoProfesion> obtenerTipoProfesion() throws BusinessException;
    List<TProfesion> obtenerProfesion(Integer idTipoProfesion) throws BusinessException;
	List<TTipificacion> obtenerTipificacion() throws BusinessException;
	List<TCargo> obtenerCargo() throws BusinessException;
	List<Areanatural> obtenerAreaNatural(Integer idCategoriaAnp) throws BusinessException;
	/*fin cambio*/
	 List<Tablatipo> obtenerValoresTablaTipo(Integer idTabla, List<Integer> codIntTablaTipo) throws BusinessException;
	 
}
