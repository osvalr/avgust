package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionPadre;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionPadreExample;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionPadreKey;

public interface TSubetapaProcesoSeleccionPadreMapper {
    int countByExample(TSubetapaProcesoSeleccionPadreExample example);

    int deleteByExample(TSubetapaProcesoSeleccionPadreExample example);

    int deleteByPrimaryKey(TSubetapaProcesoSeleccionPadreKey key);

    int insert(TSubetapaProcesoSeleccionPadre record);

    int insertSelective(TSubetapaProcesoSeleccionPadre record);

    List<TSubetapaProcesoSeleccionPadre> selectByExample(TSubetapaProcesoSeleccionPadreExample example);

    TSubetapaProcesoSeleccionPadre selectByPrimaryKey(TSubetapaProcesoSeleccionPadreKey key);

    int updateByExampleSelective(@Param("record") TSubetapaProcesoSeleccionPadre record, @Param("example") TSubetapaProcesoSeleccionPadreExample example);

    int updateByExample(@Param("record") TSubetapaProcesoSeleccionPadre record, @Param("example") TSubetapaProcesoSeleccionPadreExample example);

    int updateByPrimaryKeySelective(TSubetapaProcesoSeleccionPadre record);

    int updateByPrimaryKey(TSubetapaProcesoSeleccionPadre record);
}