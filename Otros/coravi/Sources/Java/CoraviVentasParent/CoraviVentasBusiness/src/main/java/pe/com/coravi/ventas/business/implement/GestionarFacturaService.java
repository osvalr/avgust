package pe.com.coravi.ventas.business.implement;

import org.springframework.stereotype.Service;
import pe.com.coravi.ventas.business.service.IGestionarFacturaService;
import pe.com.coravi.ventas.repository.model.dto.DocumentoFacturaQuery;
import pe.com.coravi.ventas.repository.model.dto.DocumentoFacturaQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.DocumentoFacturaQueryMapper;
import pe.com.kapcom.util.RepositoryModelService;

/**
 * Created by JRaffo on 23/11/16.
 */

@Service
public class GestionarFacturaService extends RepositoryModelService<DocumentoFacturaQuery,DocumentoFacturaQueryCriteria,DocumentoFacturaQueryMapper> implements IGestionarFacturaService {

}
