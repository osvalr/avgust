package pe.com.acme.inavi.ws.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.query.mybatis.mapper.ClienteQueryMapper;
import pe.com.acme.query.mybatis.mapper.JornadaQueryMapper;
import pe.com.acme.query.mybatis.mapper.ProveedorPorNombreQueryMapper;
import pe.com.acme.query.mybatis.model.ClienteQuery;
import pe.com.acme.query.mybatis.model.ClienteQueryCriteria;
import pe.com.acme.query.mybatis.model.JornadaQueryCriteria;
import pe.com.acme.query.mybatis.model.ProveedorPorNombreQuery;
import pe.com.acme.query.mybatis.model.ProveedorPorNombreQueryCriteria;
import pe.com.acme.util.JsonReturnUtil;

@Controller
@RequestMapping("/common")
public class InaviCommonController {
	
	@Autowired
	private JornadaQueryMapper jornadaQueryMapper;

	@Autowired
	private ClienteQueryMapper clienteQueryMapper;
	
	@Autowired
	private ProveedorPorNombreQueryMapper proveedorPorNombreQueryMapper;
		
	@RequestMapping(value="/jornadas")
	public @ResponseBody Map<String,? extends Object> jornadas(){
				
		return JsonReturnUtil.returnList(jornadaQueryMapper.getListQueryByCriteria(new JornadaQueryCriteria()));
		
	}
	
	@RequestMapping(value="/clientes")
	public @ResponseBody Map<String,? extends Object> clientes(String query, int start, int limit){
		
		ClienteQueryCriteria criteria = new ClienteQueryCriteria();
		criteria.setNombres(query);
		
		RowBounds rowBounds = new RowBounds(start,limit);
		
		List<ClienteQuery> list = clienteQueryMapper.getListQueryPaginationByCriteria(criteria, rowBounds);
		
		return JsonReturnUtil.returnList(list);
		
	}
	
	@RequestMapping(value="/proveedores")
	public @ResponseBody Map<String,? extends Object> proveedores(String query, int start, int limit){
		
		ProveedorPorNombreQueryCriteria criteria = new ProveedorPorNombreQueryCriteria();
		criteria.setNombre_proveedor(query);
		
		RowBounds rowBounds = new RowBounds(start,limit);
		
		List<ProveedorPorNombreQuery> list = proveedorPorNombreQueryMapper.getListQueryPaginationByCriteria(criteria, rowBounds);
		
		return JsonReturnUtil.returnList(list);
		
	}
	
}
