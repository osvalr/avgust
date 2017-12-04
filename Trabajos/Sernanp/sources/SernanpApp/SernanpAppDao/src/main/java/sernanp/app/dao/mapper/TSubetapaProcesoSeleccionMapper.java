package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccion;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionExample;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionKey;

public interface TSubetapaProcesoSeleccionMapper {
    int countByExample(TSubetapaProcesoSeleccionExample example);

    int deleteByExample(TSubetapaProcesoSeleccionExample example);

    int deleteByPrimaryKey(TSubetapaProcesoSeleccionKey key);

    int insert(TSubetapaProcesoSeleccion record);

    int insertSelective(TSubetapaProcesoSeleccion record);

    List<TSubetapaProcesoSeleccion> selectByExampleWithRowbounds(TSubetapaProcesoSeleccionExample example, RowBounds rowBounds);

    List<TSubetapaProcesoSeleccion> selectByExample(TSubetapaProcesoSeleccionExample example);

    TSubetapaProcesoSeleccion selectByPrimaryKey(TSubetapaProcesoSeleccionKey key);

    int updateByExampleSelective(@Param("record") TSubetapaProcesoSeleccion record, @Param("example") TSubetapaProcesoSeleccionExample example);

    int updateByExample(@Param("record") TSubetapaProcesoSeleccion record, @Param("example") TSubetapaProcesoSeleccionExample example);

    int updateByPrimaryKeySelective(TSubetapaProcesoSeleccion record);

    int updateByPrimaryKey(TSubetapaProcesoSeleccion record);
}