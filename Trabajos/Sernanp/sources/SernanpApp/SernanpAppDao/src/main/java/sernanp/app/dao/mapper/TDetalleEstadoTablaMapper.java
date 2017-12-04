package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TDetalleEstadoTabla;
import sernanp.app.dao.domain.TDetalleEstadoTablaExample;
import sernanp.app.dao.domain.TDetalleEstadoTablaKey;

public interface TDetalleEstadoTablaMapper {
    int countByExample(TDetalleEstadoTablaExample example);

    int deleteByExample(TDetalleEstadoTablaExample example);

    int deleteByPrimaryKey(TDetalleEstadoTablaKey key);

    int insert(TDetalleEstadoTabla record);

    int insertSelective(TDetalleEstadoTabla record);

    List<TDetalleEstadoTabla> selectByExample(TDetalleEstadoTablaExample example);

    TDetalleEstadoTabla selectByPrimaryKey(TDetalleEstadoTablaKey key);

    int updateByExampleSelective(@Param("record") TDetalleEstadoTabla record, @Param("example") TDetalleEstadoTablaExample example);

    int updateByExample(@Param("record") TDetalleEstadoTabla record, @Param("example") TDetalleEstadoTablaExample example);

    int updateByPrimaryKeySelective(TDetalleEstadoTabla record);

    int updateByPrimaryKey(TDetalleEstadoTabla record);
}