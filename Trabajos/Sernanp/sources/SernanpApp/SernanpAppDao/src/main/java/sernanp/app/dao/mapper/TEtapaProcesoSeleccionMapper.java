package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TEtapaProcesoSeleccion;
import sernanp.app.dao.domain.TEtapaProcesoSeleccionExample;
import sernanp.app.dao.domain.TEtapaProcesoSeleccionKey;

public interface TEtapaProcesoSeleccionMapper {
    int countByExample(TEtapaProcesoSeleccionExample example);

    int deleteByExample(TEtapaProcesoSeleccionExample example);

    int deleteByPrimaryKey(TEtapaProcesoSeleccionKey key);

    int insert(TEtapaProcesoSeleccion record);

    int insertSelective(TEtapaProcesoSeleccion record);

    List<TEtapaProcesoSeleccion> selectByExample(TEtapaProcesoSeleccionExample example);

    TEtapaProcesoSeleccion selectByPrimaryKey(TEtapaProcesoSeleccionKey key);

    int updateByExampleSelective(@Param("record") TEtapaProcesoSeleccion record, @Param("example") TEtapaProcesoSeleccionExample example);

    int updateByExample(@Param("record") TEtapaProcesoSeleccion record, @Param("example") TEtapaProcesoSeleccionExample example);

    int updateByPrimaryKeySelective(TEtapaProcesoSeleccion record);

    int updateByPrimaryKey(TEtapaProcesoSeleccion record);
}