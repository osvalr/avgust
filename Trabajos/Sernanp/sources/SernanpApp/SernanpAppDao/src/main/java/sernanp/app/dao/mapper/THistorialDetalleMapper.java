package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.THistorialDetalle;
import sernanp.app.dao.domain.THistorialDetalleExample;
import sernanp.app.dao.domain.THistorialDetalleKey;

public interface THistorialDetalleMapper {
    int countByExample(THistorialDetalleExample example);

    int deleteByExample(THistorialDetalleExample example);

    int deleteByPrimaryKey(THistorialDetalleKey key);

    int insert(THistorialDetalle record);

    int insertSelective(THistorialDetalle record);

    List<THistorialDetalle> selectByExample(THistorialDetalleExample example);

    THistorialDetalle selectByPrimaryKey(THistorialDetalleKey key);

    int updateByExampleSelective(@Param("record") THistorialDetalle record, @Param("example") THistorialDetalleExample example);

    int updateByExample(@Param("record") THistorialDetalle record, @Param("example") THistorialDetalleExample example);

    int updateByPrimaryKeySelective(THistorialDetalle record);

    int updateByPrimaryKey(THistorialDetalle record);
}