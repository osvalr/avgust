package sernanp.app.business.core.estado.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.app.business.core.estado.service.EstadoService;
import sernanp.app.dao.domain.TDetalleHistorialEstado;
import sernanp.app.dao.domain.TEstadoTabla;
import sernanp.app.dao.domain.TEstadoTablaExample;
import sernanp.app.dao.mapper.TDetalleHistorialEstadoMapper;
import sernanp.app.dao.mapper.TEstadoTablaMapper;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQuery;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQueryCriteria;
import sernanp.app.dao.query.mapper.ObtenerUltimoEstadoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;

@Service
public class EstadoServiceImpl extends HelperService implements EstadoService {

	@Autowired
	ObtenerUltimoEstadoQueryMapper obtenerUltimoEstadoQueryMapper;
	
	@Autowired
	TEstadoTablaMapper tEstadoTablaMapper;
	
	@Autowired
	TDetalleHistorialEstadoMapper tDetalleHistorialEstadoMapper;
	
	@Override
	public ObtenerUltimoEstadoQuery obtenerUltimoEstado(String nombreTabla, Integer idRegistro,Date fechaCorte) throws BusinessException {

		if(fechaCorte == null){
			fechaCorte = new Date();
		}
		
		ObtenerUltimoEstadoQueryCriteria criteria = new ObtenerUltimoEstadoQueryCriteria();
		criteria.setInt_id_registro(idRegistro);
		criteria.setInt_id_registro_sub_query(idRegistro);
		criteria.setVar_nombre_tabla(nombreTabla);
		criteria.setTsp_fecha_registro(fechaCorte);
		
		
		List<ObtenerUltimoEstadoQuery> list = obtenerUltimoEstadoQueryMapper.getListQuery(criteria);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public TEstadoTabla obtenerEstadoTabla(String nombreTabla) throws BusinessException {
		
		TEstadoTablaExample example = new TEstadoTablaExample();
		example.createCriteria().andVar_nombre_tablaEqualTo(nombreTabla);
		
		List<TEstadoTabla> list = tEstadoTablaMapper.selectByExample(example);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public void registrarEstado(String nomTabla, Integer idRegistro, String codEstado) throws BusinessException {
		
		TEstadoTabla et = this.obtenerEstadoTabla(nomTabla);
		TDetalleHistorialEstado dhe = new TDetalleHistorialEstado();
		dhe.setSrl_id_estado_tabla(et.getSrl_id_estado_tabla());
		dhe.setInt_id_registro(idRegistro);
		dhe.setVar_cod_estado(codEstado);
		dhe.setTsp_fecha_registro(new Date());
		
		tDetalleHistorialEstadoMapper.insertSelective(dhe);
		
	}

}
