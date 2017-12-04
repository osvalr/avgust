package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TParametroPlanilla;
import sernanp.app.dao.domain.TParametroPlanillaExample;
import sernanp.app.dao.domain.TParametroPlanillaKey;

public interface TParametroPlanillaMapper {
    int countByExample(TParametroPlanillaExample example);

    int deleteByExample(TParametroPlanillaExample example);

    int deleteByPrimaryKey(TParametroPlanillaKey key);

    int insert(TParametroPlanilla record);

    int insertSelective(TParametroPlanilla record);

    List<TParametroPlanilla> selectByExample(TParametroPlanillaExample example);

    TParametroPlanilla selectByPrimaryKey(TParametroPlanillaKey key);

    int updateByExampleSelective(@Param("record") TParametroPlanilla record, @Param("example") TParametroPlanillaExample example);

    int updateByExample(@Param("record") TParametroPlanilla record, @Param("example") TParametroPlanillaExample example);

    int updateByPrimaryKeySelective(TParametroPlanilla record);

    int updateByPrimaryKey(TParametroPlanilla record);
}