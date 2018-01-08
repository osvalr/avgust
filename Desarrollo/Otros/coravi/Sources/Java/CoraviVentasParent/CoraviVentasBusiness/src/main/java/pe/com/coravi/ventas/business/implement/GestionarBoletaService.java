package pe.com.coravi.ventas.business.implement;

import org.springframework.stereotype.Service;
import pe.com.coravi.domain.hibernate.service.ComprobantePagoRepository;
import pe.com.coravi.ventas.business.service.IGestionarBoletaDetalleService;
import pe.com.coravi.ventas.business.service.IGestionarBoletaService;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaQuery;
import pe.com.coravi.ventas.repository.model.dto.DocumentoBoletaQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.DocumentoBoletaQueryMapper;
import pe.com.kapcom.util.DetailCrudRepositories;
import pe.com.kapcom.util.DetailCrudRepository;
import pe.com.kapcom.util.MasterCrudRepository;
import pe.com.kapcom.util.RepositoryModelService;

import javax.transaction.Transactional;

/**
 * Created by JRaffo on 23/11/16.
 */

@Service
@Transactional
@MasterCrudRepository(classRepository = ComprobantePagoRepository.class)
@DetailCrudRepositories(
        @DetailCrudRepository(classModelService = IGestionarBoletaDetalleService.class,namePropertyList = "listDocumentoBoletaDetalleQuery",unionProperty = "id_comprobante_pago")
)
public class GestionarBoletaService extends RepositoryModelService<DocumentoBoletaQuery,DocumentoBoletaQueryCriteria,DocumentoBoletaQueryMapper> implements IGestionarBoletaService {
    
}
