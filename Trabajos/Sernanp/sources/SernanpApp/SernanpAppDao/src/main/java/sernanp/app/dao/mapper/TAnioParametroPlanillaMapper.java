package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAnioParametroPlanilla;
import sernanp.app.dao.domain.TAnioParametroPlanillaExample;
import sernanp.app.dao.domain.TAnioParametroPlanillaKey;

public interface TAnioParametroPlanillaMapper {
    int countByExample(TAnioParametroPlanillaExample example);

    int deleteByExample(TAnioParametroPlanillaExample example);

    int deleteByPrimaryKey(TAnioParametroPlanillaKey key);

    int insert(TAnioParametroPlanilla record);

    int insertSelective(TAnioParametroPlanilla record);

    List<TAnioParametroPlanilla> selectByExample(TAnioParametroPlanillaExample example);

    TAnioParametroPlanilla selectByPrimaryKey(TAnioParametroPlanillaKey key);

    int updateByExampleSelective(@Param("record") TAnioParametroPlanilla record, @Param("example") TAnioParametroPlanillaExample example);

    int updateByExample(@Param("record") TAnioParametroPlanilla record, @Param("example") TAnioParametroPlanillaExample example);

    int updateByPrimaryKeySelective(TAnioParametroPlanilla record);

    int updateByPrimaryKey(TAnioParametroPlanilla record);
}