package pe.com.coravi.ventas.business.service;

import pe.com.coravi.ventas.repository.model.mapper.DocumentoFacturaQueryMapper;
import pe.com.kapcom.util.IRepositoryModelService;
import pe.com.coravi.ventas.repository.model.dto.DocumentoFacturaQuery;
import pe.com.coravi.ventas.repository.model.dto.DocumentoFacturaQueryCriteria;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IGestionarFacturaService extends IRepositoryModelService<DocumentoFacturaQuery,DocumentoFacturaQueryCriteria,DocumentoFacturaQueryMapper> {
}
