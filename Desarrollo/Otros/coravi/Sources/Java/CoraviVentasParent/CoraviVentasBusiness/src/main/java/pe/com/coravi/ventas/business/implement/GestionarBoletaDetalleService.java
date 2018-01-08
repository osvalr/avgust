package pe.com.coravi.ventas.business.implement;

import org.springframework.stereotype.Service;
import pe.com.coravi.domain.hibernate.service.ComprobanteItemRepository;
import pe.com.coravi.ventas.business.service.IGestionarBoletaDetalleService;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaDetalleQuery;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaDetalleQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.DocumentoBoletaDetalleQueryMapper;
import pe.com.kapcom.util.MasterCrudRepository;
import pe.com.kapcom.util.RepositoryModelService;

/**
 * Created by JRaffo on 23/11/16.
 */

@Service
@MasterCrudRepository(classRepository = ComprobanteItemRepository.class)
public class GestionarBoletaDetalleService extends RepositoryModelService<DocumentoBoletaDetalleQuery,DocumentoBoletaDetalleQueryCriteria,DocumentoBoletaDetalleQueryMapper> implements IGestionarBoletaDetalleService {

}
