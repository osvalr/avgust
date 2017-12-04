package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TUnidadOperativa;
import sernanp.app.dao.domain.TUnidadOperativaExample;
import sernanp.app.dao.domain.TUnidadOperativaKey;

public interface TUnidadOperativaMapper {
    int countByExample(TUnidadOperativaExample example);

    int deleteByExample(TUnidadOperativaExample example);

    int deleteByPrimaryKey(TUnidadOperativaKey key);

    int insert(TUnidadOperativa record);

    int insertSelective(TUnidadOperativa record);

    List<TUnidadOperativa> selectByExample(TUnidadOperativaExample example);

    TUnidadOperativa selectByPrimaryKey(TUnidadOperativaKey key);

    int updateByExampleSelective(@Param("record") TUnidadOperativa record, @Param("example") TUnidadOperativaExample example);

    int updateByExample(@Param("record") TUnidadOperativa record, @Param("example") TUnidadOperativaExample example);

    int updateByPrimaryKeySelective(TUnidadOperativa record);

    int updateByPrimaryKey(TUnidadOperativa record);
}