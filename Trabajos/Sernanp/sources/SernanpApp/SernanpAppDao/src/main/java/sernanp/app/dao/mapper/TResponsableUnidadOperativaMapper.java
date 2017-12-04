package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TResponsableUnidadOperativa;
import sernanp.app.dao.domain.TResponsableUnidadOperativaExample;
import sernanp.app.dao.domain.TResponsableUnidadOperativaKey;

public interface TResponsableUnidadOperativaMapper {
    int countByExample(TResponsableUnidadOperativaExample example);

    int deleteByExample(TResponsableUnidadOperativaExample example);

    int deleteByPrimaryKey(TResponsableUnidadOperativaKey key);

    int insert(TResponsableUnidadOperativa record);

    int insertSelective(TResponsableUnidadOperativa record);

    List<TResponsableUnidadOperativa> selectByExample(TResponsableUnidadOperativaExample example);

    TResponsableUnidadOperativa selectByPrimaryKey(TResponsableUnidadOperativaKey key);

    int updateByExampleSelective(@Param("record") TResponsableUnidadOperativa record, @Param("example") TResponsableUnidadOperativaExample example);

    int updateByExample(@Param("record") TResponsableUnidadOperativa record, @Param("example") TResponsableUnidadOperativaExample example);

    int updateByPrimaryKeySelective(TResponsableUnidadOperativa record);

    int updateByPrimaryKey(TResponsableUnidadOperativa record);
}