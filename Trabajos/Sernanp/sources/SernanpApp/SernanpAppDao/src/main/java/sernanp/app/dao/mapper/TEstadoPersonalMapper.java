package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TEstadoPersonal;
import sernanp.app.dao.domain.TEstadoPersonalExample;
import sernanp.app.dao.domain.TEstadoPersonalKey;

public interface TEstadoPersonalMapper {
    int countByExample(TEstadoPersonalExample example);

    int deleteByExample(TEstadoPersonalExample example);

    int deleteByPrimaryKey(TEstadoPersonalKey key);

    int insert(TEstadoPersonal record);

    int insertSelective(TEstadoPersonal record);

    List<TEstadoPersonal> selectByExample(TEstadoPersonalExample example);

    TEstadoPersonal selectByPrimaryKey(TEstadoPersonalKey key);

    int updateByExampleSelective(@Param("record") TEstadoPersonal record, @Param("example") TEstadoPersonalExample example);

    int updateByExample(@Param("record") TEstadoPersonal record, @Param("example") TEstadoPersonalExample example);

    int updateByPrimaryKeySelective(TEstadoPersonal record);

    int updateByPrimaryKey(TEstadoPersonal record);
}