package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TFactorEvaluacion;
import sernanp.app.dao.domain.TFactorEvaluacionExample;
import sernanp.app.dao.domain.TFactorEvaluacionKey;

public interface TFactorEvaluacionMapper {
    int countByExample(TFactorEvaluacionExample example);

    int deleteByExample(TFactorEvaluacionExample example);

    int deleteByPrimaryKey(TFactorEvaluacionKey key);

    int insert(TFactorEvaluacion record);

    int insertSelective(TFactorEvaluacion record);

    List<TFactorEvaluacion> selectByExampleWithRowbounds(TFactorEvaluacionExample example, RowBounds rowBounds);

    List<TFactorEvaluacion> selectByExample(TFactorEvaluacionExample example);

    TFactorEvaluacion selectByPrimaryKey(TFactorEvaluacionKey key);

    int updateByExampleSelective(@Param("record") TFactorEvaluacion record, @Param("example") TFactorEvaluacionExample example);

    int updateByExample(@Param("record") TFactorEvaluacion record, @Param("example") TFactorEvaluacionExample example);

    int updateByPrimaryKeySelective(TFactorEvaluacion record);

    int updateByPrimaryKey(TFactorEvaluacion record);
}