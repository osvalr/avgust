package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConfiguracionEtapa;
import sernanp.app.dao.domain.TConfiguracionEtapaExample;
import sernanp.app.dao.domain.TConfiguracionEtapaKey;

public interface TConfiguracionEtapaMapper {
    int countByExample(TConfiguracionEtapaExample example);

    int deleteByExample(TConfiguracionEtapaExample example);

    int deleteByPrimaryKey(TConfiguracionEtapaKey key);

    int insert(TConfiguracionEtapa record);

    int insertSelective(TConfiguracionEtapa record);

    List<TConfiguracionEtapa> selectByExample(TConfiguracionEtapaExample example);

    TConfiguracionEtapa selectByPrimaryKey(TConfiguracionEtapaKey key);

    int updateByExampleSelective(@Param("record") TConfiguracionEtapa record, @Param("example") TConfiguracionEtapaExample example);

    int updateByExample(@Param("record") TConfiguracionEtapa record, @Param("example") TConfiguracionEtapaExample example);

    int updateByPrimaryKeySelective(TConfiguracionEtapa record);

    int updateByPrimaryKey(TConfiguracionEtapa record);
}