package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConfiguracionFactorEvaluacion;
import sernanp.app.dao.domain.TConfiguracionFactorEvaluacionExample;
import sernanp.app.dao.domain.TConfiguracionFactorEvaluacionKey;

public interface TConfiguracionFactorEvaluacionMapper {
    int countByExample(TConfiguracionFactorEvaluacionExample example);

    int deleteByExample(TConfiguracionFactorEvaluacionExample example);

    int deleteByPrimaryKey(TConfiguracionFactorEvaluacionKey key);

    int insert(TConfiguracionFactorEvaluacion record);

    int insertSelective(TConfiguracionFactorEvaluacion record);

    List<TConfiguracionFactorEvaluacion> selectByExample(TConfiguracionFactorEvaluacionExample example);

    TConfiguracionFactorEvaluacion selectByPrimaryKey(TConfiguracionFactorEvaluacionKey key);

    int updateByExampleSelective(@Param("record") TConfiguracionFactorEvaluacion record, @Param("example") TConfiguracionFactorEvaluacionExample example);

    int updateByExample(@Param("record") TConfiguracionFactorEvaluacion record, @Param("example") TConfiguracionFactorEvaluacionExample example);

    int updateByPrimaryKeySelective(TConfiguracionFactorEvaluacion record);

    int updateByPrimaryKey(TConfiguracionFactorEvaluacion record);
}