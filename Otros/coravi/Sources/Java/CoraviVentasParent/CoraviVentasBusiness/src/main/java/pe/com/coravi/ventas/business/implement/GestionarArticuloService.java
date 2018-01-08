package pe.com.coravi.ventas.business.implement;

import org.springframework.stereotype.Service;
import pe.com.coravi.domain.hibernate.service.ArticuloRepository;
import pe.com.coravi.ventas.business.service.IGestionarArticuloService;
import pe.com.coravi.ventas.repository.model.dto.ArticuloQuery;
import pe.com.coravi.ventas.repository.model.dto.ArticuloQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.ArticuloQueryMapper;
import pe.com.kapcom.util.MasterCrudRepository;
import pe.com.kapcom.util.RepositoryModelService;

import javax.transaction.Transactional;

/**
 * Created by JRaffo on 23/11/16.
 */

@Service
@Transactional
@MasterCrudRepository(classRepository = ArticuloRepository.class)
public class GestionarArticuloService extends RepositoryModelService<ArticuloQuery,ArticuloQueryCriteria,ArticuloQueryMapper> implements IGestionarArticuloService {

}
