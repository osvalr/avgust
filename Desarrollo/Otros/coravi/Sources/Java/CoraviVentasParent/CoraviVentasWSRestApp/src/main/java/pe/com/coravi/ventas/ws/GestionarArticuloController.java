package pe.com.coravi.ventas.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.coravi.ventas.business.service.IGestionarArticuloService;
import pe.com.coravi.ventas.repository.model.dto.ArticuloQuery;
import pe.com.coravi.ventas.repository.model.dto.ArticuloQueryCriteria;
import pe.com.coravi.ventas.repository.model.mapper.ArticuloQueryMapper;
import pe.com.kapcom.util.KapcomController;
import pe.com.kapcom.util.RestCrudController;

/**
 * Created by JRaffo on 10/04/17.
 */
@RestController
@RequestMapping("/GestionarArticulo")
@RestCrudController(classModelService = IGestionarArticuloService.class,propertyId = "id_articulo")
public class GestionarArticuloController extends KapcomController<ArticuloQuery,ArticuloQueryCriteria,ArticuloQueryMapper> {

}
