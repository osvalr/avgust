package pe.com.focus.sakerk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.focus.repository.mybatis.mapper.PaisMapper;
import pe.com.focus.sakerk.business.service.CommonService;
import pe.com.focus.util.ControllerHelper;
import pe.com.focus.util.ExtJsReturnCommon;

@Controller
@RequestMapping("/")
public class CommonController extends ControllerHelper {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="listaTablaGeneralDetalle.action")
	public @ResponseBody ExtJsReturnCommon listaTablaGeneralDetalle(String nombre_tabla_general){
		return commonService.listaTablaGeneralDetalle(nombre_tabla_general);
	}
	
	@RequestMapping(value="listaPaises.action")
	public @ResponseBody ExtJsReturnCommon listaPaises(){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.selectAll(PaisMapper.class));
		return common;
	}
			
	@RequestMapping(value="obtenerDepartamentosUbigeo.action")
	public @ResponseBody ExtJsReturnCommon obtenerDepartamentosUbigeo(){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.obtenerDepartamentosUbigeo());
		return common;
	}
	
	@RequestMapping(value="obtenerProvinciaUbigeo.action")
	public @ResponseBody ExtJsReturnCommon obtenerProvinciaUbigeo(@RequestParam String idDepartamento){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.obtenerProvinciaUbigeo(idDepartamento));
		return common;
	}
	
	@RequestMapping(value="obtenerDistritoUbigeo.action")
	public @ResponseBody ExtJsReturnCommon obtenerProvinciaUbigeo(@RequestParam String idDepartamento, @RequestParam String idProvincia){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.obtenerDistritoUbigeo(idDepartamento,idProvincia));
		return common;
	}
	
	@RequestMapping(value="listaEstudio.action")
	public @ResponseBody ExtJsReturnCommon listaEstudio(@RequestParam Integer id_categoria_estudio){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaEstudio(id_categoria_estudio));
		return common;
	}
	
	@RequestMapping(value="listaPersonaJuridica.action")
	public @ResponseBody ExtJsReturnCommon listaPersonaJuridica(){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaPersonaJuridica());
		return common;
	}
	@RequestMapping(value="listaPersonaJuridicaPorTipo.action")
	public @ResponseBody ExtJsReturnCommon listaPersonaJuridica(Integer id_tipo_persona_juridica){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaPersonaJuridica(id_tipo_persona_juridica));
		return common;
	}

	@RequestMapping(value="listaCongregacionPorReferido.action")
	public @ResponseBody ExtJsReturnCommon listaCongregacionPorReferido(Integer id_congregacion_padre){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaCongregacionPorReferido(id_congregacion_padre));
		return common;
	}
	
	@RequestMapping(value="listaCongregacionDistrito.action")
	public @ResponseBody ExtJsReturnCommon listaCongregacionDistrito(){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaCongregacionDistrito());
		return common;
	}

	@RequestMapping(value="listaPersonaNatural.action")
	public @ResponseBody ExtJsReturnCommon listaPersonaNatural(Integer id_persona_natural){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaPersonaNatural(id_persona_natural));
		return common;
	}
	
	@RequestMapping(value="listarRolesCongregacion.action")
	public @ResponseBody ExtJsReturnCommon listarRolesCongregacion(){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listarRolesCongregacion());
		return common;
	}

	@RequestMapping(value="listaCongregacionLocal.action")
	public @ResponseBody ExtJsReturnCommon listaCongregacionLocal(Integer id_congregacion_general){
		ExtJsReturnCommon common = new ExtJsReturnCommon();
		common.setListRecords(commonService.listaCongregacionLocal(id_congregacion_general));
		return common;
	}

	
}
