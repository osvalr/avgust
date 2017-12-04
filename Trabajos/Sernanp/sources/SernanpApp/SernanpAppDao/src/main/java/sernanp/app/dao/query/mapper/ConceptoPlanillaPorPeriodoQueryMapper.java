package sernanp.app.dao.query.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoQuery;
import sernanp.app.dao.query.domain.ConceptoPlanillaPorPeriodoQueryCriteria;

public interface ConceptoPlanillaPorPeriodoQueryMapper {
	List<ConceptoPlanillaPorPeriodoQuery> getListQueryByCriteria(ConceptoPlanillaPorPeriodoQueryCriteria criteria);

	List<ConceptoPlanillaPorPeriodoQuery> getListQueryByMap(Map<String, Object> paramMap);

	List<ConceptoPlanillaPorPeriodoQuery> getListQueryPaginationByCriteria(ConceptoPlanillaPorPeriodoQueryCriteria criteria, RowBounds rowBounds);

	List<ConceptoPlanillaPorPeriodoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds);

	int getCountRowsByCriteria(ConceptoPlanillaPorPeriodoQueryCriteria criteria);

	int getCountRowsByMap(Map<String, Object> paramMap);
}
