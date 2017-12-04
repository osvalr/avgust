package pe.com.focus.sakerk.business.service;

import java.util.List;

import pe.com.focus.repository.mybatis.model.CongregacionGeneral;
import pe.com.focus.repository.mybatis.model.Estudio;
import pe.com.focus.repository.mybatis.model.PersonaJuridica;
import pe.com.focus.repository.mybatis.model.Rol;
import pe.com.focus.repository.mybatis.model.Ubigeo;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperService;
import pe.com.focus.sakerk.repository.custom.model.ListaCongregacionLocalQuery;
import pe.com.focus.sakerk.repository.custom.model.ListaPersonaNaturalParentescoQuery;
import pe.com.focus.util.ExtJsReturnCommon;

public interface CommonService extends HelperService {
	ExtJsReturnCommon listaTablaGeneralDetalle(String nombre_tabla_general) throws BusinessException;
	List<Ubigeo> obtenerDepartamentosUbigeo() throws BusinessException;
    List<Ubigeo> obtenerProvinciaUbigeo(String idDepartamento) throws BusinessException;
    List<Ubigeo> obtenerDistritoUbigeo(String idDepartamento,String idProvincia) throws BusinessException;
    List<Estudio> listaEstudio(Integer id_categoria_estudio) throws BusinessException;
    List<PersonaJuridica> listaPersonaJuridica() throws BusinessException;
    List<PersonaJuridica> listaPersonaJuridica(Integer id_tipo_persona_juridica) throws BusinessException;
    List<CongregacionGeneral> listaCongregacionPorReferido(Integer id_congregacion_padre) throws BusinessException;
    List<CongregacionGeneral> listaCongregacionDistrito() throws BusinessException;
    List<ListaPersonaNaturalParentescoQuery> listaPersonaNatural(Integer id_persona_natural) throws BusinessException;
    List<Rol> listarRolesCongregacion() throws BusinessException;
    List<ListaCongregacionLocalQuery> listaCongregacionLocal(Integer id_congregacion_general) throws BusinessException;
}
