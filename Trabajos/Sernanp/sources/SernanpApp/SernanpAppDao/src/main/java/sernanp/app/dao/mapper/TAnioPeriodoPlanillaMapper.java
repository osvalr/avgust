package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaExample;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaKey;

public interface TAnioPeriodoPlanillaMapper {
    int countByExample(TAnioPeriodoPlanillaExample example);

    int deleteByExample(TAnioPeriodoPlanillaExample example);

    int deleteByPrimaryKey(TAnioPeriodoPlanillaKey key);

    int insert(TAnioPeriodoPlanilla record);

    int insertSelective(TAnioPeriodoPlanilla record);

    List<TAnioPeriodoPlanilla> selectByExample(TAnioPeriodoPlanillaExample example);

    TAnioPeriodoPlanilla selectByPrimaryKey(TAnioPeriodoPlanillaKey key);

    int updateByExampleSelective(@Param("record") TAnioPeriodoPlanilla record, @Param("example") TAnioPeriodoPlanillaExample example);

    int updateByExample(@Param("record") TAnioPeriodoPlanilla record, @Param("example") TAnioPeriodoPlanillaExample example);

    int updateByPrimaryKeySelective(TAnioPeriodoPlanilla record);

    int updateByPrimaryKey(TAnioPeriodoPlanilla record);
}