package pe.com.coravi.ventas.business.service;

import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaDetalleQuery;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaDetalleQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.DocumentoBoletaDetalleQueryMapper;
import pe.com.kapcom.util.IRepositoryModelService;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IGestionarBoletaDetalleService extends IRepositoryModelService<DocumentoBoletaDetalleQuery,DocumentoBoletaDetalleQueryCriteria,DocumentoBoletaDetalleQueryMapper> {
}
