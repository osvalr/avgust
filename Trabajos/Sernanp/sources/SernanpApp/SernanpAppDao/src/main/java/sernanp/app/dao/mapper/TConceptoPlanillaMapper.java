package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConceptoPlanilla;
import sernanp.app.dao.domain.TConceptoPlanillaExample;
import sernanp.app.dao.domain.TConceptoPlanillaKey;

public interface TConceptoPlanillaMapper {
    int countByExample(TConceptoPlanillaExample example);

    int deleteByExample(TConceptoPlanillaExample example);

    int deleteByPrimaryKey(TConceptoPlanillaKey key);

    int insert(TConceptoPlanilla record);

    int insertSelective(TConceptoPlanilla record);

    List<TConceptoPlanilla> selectByExample(TConceptoPlanillaExample example);

    TConceptoPlanilla selectByPrimaryKey(TConceptoPlanillaKey key);

    int updateByExampleSelective(@Param("record") TConceptoPlanilla record, @Param("example") TConceptoPlanillaExample example);

    int updateByExample(@Param("record") TConceptoPlanilla record, @Param("example") TConceptoPlanillaExample example);

    int updateByPrimaryKeySelective(TConceptoPlanilla record);

    int updateByPrimaryKey(TConceptoPlanilla record);
}