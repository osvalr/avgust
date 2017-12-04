package sernanp.app.dao.query.mapper;

import java.util.List;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQuery;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQueryCriteria;

public interface ObtenerUltimoEstadoQueryMapper {
	List<ObtenerUltimoEstadoQuery> getListQuery(ObtenerUltimoEstadoQueryCriteria criteria);
}
