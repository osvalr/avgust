package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.THistorial;
import sernanp.app.dao.domain.THistorialExample;
import sernanp.app.dao.domain.THistorialKey;

public interface THistorialMapper {
    int countByExample(THistorialExample example);

    int deleteByExample(THistorialExample example);

    int deleteByPrimaryKey(THistorialKey key);

    int insert(THistorial record);

    int insertSelective(THistorial record);

    List<THistorial> selectByExample(THistorialExample example);

    THistorial selectByPrimaryKey(THistorialKey key);

    int updateByExampleSelective(@Param("record") THistorial record, @Param("example") THistorialExample example);

    int updateByExample(@Param("record") THistorial record, @Param("example") THistorialExample example);

    int updateByPrimaryKeySelective(THistorial record);

    int updateByPrimaryKey(THistorial record);
}