package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonanaturalComposicionFamiliar;
import sernanp.app.dao.domain.TPersonanaturalComposicionFamiliarExample;
import sernanp.app.dao.domain.TPersonanaturalComposicionFamiliarKey;

public interface TPersonanaturalComposicionFamiliarMapper {
    int countByExample(TPersonanaturalComposicionFamiliarExample example);

    int deleteByExample(TPersonanaturalComposicionFamiliarExample example);

    int deleteByPrimaryKey(TPersonanaturalComposicionFamiliarKey key);

    int insert(TPersonanaturalComposicionFamiliar record);

    int insertSelective(TPersonanaturalComposicionFamiliar record);

    List<TPersonanaturalComposicionFamiliar> selectByExample(TPersonanaturalComposicionFamiliarExample example);

    TPersonanaturalComposicionFamiliar selectByPrimaryKey(TPersonanaturalComposicionFamiliarKey key);

    int updateByExampleSelective(@Param("record") TPersonanaturalComposicionFamiliar record, @Param("example") TPersonanaturalComposicionFamiliarExample example);

    int updateByExample(@Param("record") TPersonanaturalComposicionFamiliar record, @Param("example") TPersonanaturalComposicionFamiliarExample example);

    int updateByPrimaryKeySelective(TPersonanaturalComposicionFamiliar record);

    int updateByPrimaryKey(TPersonanaturalComposicionFamiliar record);
}