package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TDetalleHistorialEstado;
import sernanp.app.dao.domain.TDetalleHistorialEstadoExample;
import sernanp.app.dao.domain.TDetalleHistorialEstadoKey;

public interface TDetalleHistorialEstadoMapper {
    int countByExample(TDetalleHistorialEstadoExample example);

    int deleteByExample(TDetalleHistorialEstadoExample example);

    int deleteByPrimaryKey(TDetalleHistorialEstadoKey key);

    int insert(TDetalleHistorialEstado record);

    int insertSelective(TDetalleHistorialEstado record);

    List<TDetalleHistorialEstado> selectByExample(TDetalleHistorialEstadoExample example);

    TDetalleHistorialEstado selectByPrimaryKey(TDetalleHistorialEstadoKey key);

    int updateByExampleSelective(@Param("record") TDetalleHistorialEstado record, @Param("example") TDetalleHistorialEstadoExample example);

    int updateByExample(@Param("record") TDetalleHistorialEstado record, @Param("example") TDetalleHistorialEstadoExample example);

    int updateByPrimaryKeySelective(TDetalleHistorialEstado record);

    int updateByPrimaryKey(TDetalleHistorialEstado record);
}