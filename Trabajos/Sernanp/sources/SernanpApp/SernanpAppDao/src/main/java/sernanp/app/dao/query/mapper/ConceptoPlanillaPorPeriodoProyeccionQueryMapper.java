package sernanp.app.dao.query.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoProyeccionQuery;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoProyeccionQueryCriteria;

public interface ConceptoPlanillaPorPeriodoProyeccionQueryMapper {
	List<ConceptoPlanillaPorPeriodoProyeccionQuery> getListQueryByCriteria(ConceptoPlanillaPorPeriodoProyeccionQueryCriteria criteria);

	List<ConceptoPlanillaPorPeriodoProyeccionQuery> getListQueryByMap(Map<String, Object> paramMap);

	List<ConceptoPlanillaPorPeriodoProyeccionQuery> getListQueryPaginationByCriteria(ConceptoPlanillaPorPeriodoProyeccionQueryCriteria criteria, RowBounds rowBounds);

	List<ConceptoPlanillaPorPeriodoProyeccionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds);

	int getCountRowsByCriteria(ConceptoPlanillaPorPeriodoProyeccionQueryCriteria criteria);

	int getCountRowsByMap(Map<String, Object> paramMap);
}
