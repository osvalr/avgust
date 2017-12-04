package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConfiguracionEvaluacionPersonal;
import sernanp.app.dao.domain.TConfiguracionEvaluacionPersonalExample;
import sernanp.app.dao.domain.TConfiguracionEvaluacionPersonalKey;

public interface TConfiguracionEvaluacionPersonalMapper {
    int countByExample(TConfiguracionEvaluacionPersonalExample example);

    int deleteByExample(TConfiguracionEvaluacionPersonalExample example);

    int deleteByPrimaryKey(TConfiguracionEvaluacionPersonalKey key);

    int insert(TConfiguracionEvaluacionPersonal record);

    int insertSelective(TConfiguracionEvaluacionPersonal record);

    List<TConfiguracionEvaluacionPersonal> selectByExample(TConfiguracionEvaluacionPersonalExample example);

    TConfiguracionEvaluacionPersonal selectByPrimaryKey(TConfiguracionEvaluacionPersonalKey key);

    int updateByExampleSelective(@Param("record") TConfiguracionEvaluacionPersonal record, @Param("example") TConfiguracionEvaluacionPersonalExample example);

    int updateByExample(@Param("record") TConfiguracionEvaluacionPersonal record, @Param("example") TConfiguracionEvaluacionPersonalExample example);

    int updateByPrimaryKeySelective(TConfiguracionEvaluacionPersonal record);

    int updateByPrimaryKey(TConfiguracionEvaluacionPersonal record);
}