package pe.com.coravi.ventas.business.service;

import pe.com.coravi.ventas.repository.model.dto.ArticuloQuery;
import pe.com.coravi.ventas.repository.model.dto.ArticuloQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.ArticuloQueryMapper;
import pe.com.kapcom.util.IRepositoryModelService;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IGestionarArticuloService extends IRepositoryModelService<ArticuloQuery,ArticuloQueryCriteria,ArticuloQueryMapper> {
}
