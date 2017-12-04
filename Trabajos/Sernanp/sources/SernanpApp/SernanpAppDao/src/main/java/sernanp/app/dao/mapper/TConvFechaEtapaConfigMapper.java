package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConvFechaEtapaConfig;
import sernanp.app.dao.domain.TConvFechaEtapaConfigExample;
import sernanp.app.dao.domain.TConvFechaEtapaConfigKey;

public interface TConvFechaEtapaConfigMapper {
    int countByExample(TConvFechaEtapaConfigExample example);

    int deleteByExample(TConvFechaEtapaConfigExample example);

    int deleteByPrimaryKey(TConvFechaEtapaConfigKey key);

    int insert(TConvFechaEtapaConfig record);

    int insertSelective(TConvFechaEtapaConfig record);

    List<TConvFechaEtapaConfig> selectByExample(TConvFechaEtapaConfigExample example);

    TConvFechaEtapaConfig selectByPrimaryKey(TConvFechaEtapaConfigKey key);

    int updateByExampleSelective(@Param("record") TConvFechaEtapaConfig record, @Param("example") TConvFechaEtapaConfigExample example);

    int updateByExample(@Param("record") TConvFechaEtapaConfig record, @Param("example") TConvFechaEtapaConfigExample example);

    int updateByPrimaryKeySelective(TConvFechaEtapaConfig record);

    int updateByPrimaryKey(TConvFechaEtapaConfig record);
}