package pe.com.acme.seguridad.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.query.mybatis.mapper.CatalogoPorNombreQueryMapper;
import pe.com.acme.query.mybatis.model.CatalogoPorNombreQueryCriteria;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController extends ControllerHelper {
	
	@Autowired
	private CatalogoPorNombreQueryMapper catalogoPorNombreQueryMapper;
	
	@RequestMapping(value="/buscarPorNombre")
	public @ResponseBody Map<String,? extends Object> buscarPorNombre(String nombre_catalogo){
		
		CatalogoPorNombreQueryCriteria criteria = new CatalogoPorNombreQueryCriteria();
		criteria.setNombre_catalogo(nombre_catalogo);
		return JsonReturnUtil.returnList(catalogoPorNombreQueryMapper.getListQueryByCriteria(criteria));
		
	}
		
}
