package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaExample;
import sernanp.app.dao.domain.TAnioPlanillaKey;

public interface TAnioPlanillaMapper {
    int countByExample(TAnioPlanillaExample example);

    int deleteByExample(TAnioPlanillaExample example);

    int deleteByPrimaryKey(TAnioPlanillaKey key);

    int insert(TAnioPlanilla record);

    int insertSelective(TAnioPlanilla record);

    List<TAnioPlanilla> selectByExample(TAnioPlanillaExample example);

    TAnioPlanilla selectByPrimaryKey(TAnioPlanillaKey key);

    int updateByExampleSelective(@Param("record") TAnioPlanilla record, @Param("example") TAnioPlanillaExample example);

    int updateByExample(@Param("record") TAnioPlanilla record, @Param("example") TAnioPlanillaExample example);

    int updateByPrimaryKeySelective(TAnioPlanilla record);

    int updateByPrimaryKey(TAnioPlanilla record);
}