package pe.com.coravi.ventas.business.service;

import pe.com.coravi.ventas.repository.model.mapper.GuiaRemisionQueryMapper;
import pe.com.kapcom.util.IRepositoryModelService;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionQuery;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionQueryCriteria;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IGestionarGuiaRemisionService extends IRepositoryModelService<GuiaRemisionQuery,GuiaRemisionQueryCriteria,GuiaRemisionQueryMapper> {
}
