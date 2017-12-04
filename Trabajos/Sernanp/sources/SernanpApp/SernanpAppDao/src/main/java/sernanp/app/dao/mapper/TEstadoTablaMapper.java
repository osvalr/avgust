package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TEstadoTabla;
import sernanp.app.dao.domain.TEstadoTablaExample;
import sernanp.app.dao.domain.TEstadoTablaKey;

public interface TEstadoTablaMapper {
    int countByExample(TEstadoTablaExample example);

    int deleteByExample(TEstadoTablaExample example);

    int deleteByPrimaryKey(TEstadoTablaKey key);

    int insert(TEstadoTabla record);

    int insertSelective(TEstadoTabla record);

    List<TEstadoTabla> selectByExample(TEstadoTablaExample example);

    TEstadoTabla selectByPrimaryKey(TEstadoTablaKey key);

    int updateByExampleSelective(@Param("record") TEstadoTabla record, @Param("example") TEstadoTablaExample example);

    int updateByExample(@Param("record") TEstadoTabla record, @Param("example") TEstadoTablaExample example);

    int updateByPrimaryKeySelective(TEstadoTabla record);

    int updateByPrimaryKey(TEstadoTabla record);
}