package pe.com.coravi.ventas.business.implement;

import org.springframework.stereotype.Service;
import pe.com.coravi.ventas.business.service.IGestionarGuiaRemisionService;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionQuery;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.GuiaRemisionQueryMapper;
import pe.com.kapcom.util.RepositoryModelService;

/**
 * Created by JRaffo on 23/11/16.
 */

@Service
public class GestionarGuiaRemisionService extends RepositoryModelService<GuiaRemisionQuery,GuiaRemisionQueryCriteria,GuiaRemisionQueryMapper>  implements IGestionarGuiaRemisionService {

}


