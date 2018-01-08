package pe.com.coravi.ventas.business.service;

import pe.com.coravi.ventas.repository.model.mapper.DocumentoBoletaQueryMapper;
import pe.com.kapcom.util.IRepositoryModelService;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaQuery;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaQueryCriteria;

/**
 * Created by JRaffo on 23/11/16.
 */
public interface IGestionarBoletaService extends IRepositoryModelService<DocumentoBoletaQuery,DocumentoBoletaQueryCriteria,DocumentoBoletaQueryMapper> {
}
