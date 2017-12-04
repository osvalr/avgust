package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonanaturalFormacion;
import sernanp.app.dao.domain.TPersonanaturalFormacionExample;
import sernanp.app.dao.domain.TPersonanaturalFormacionKey;

public interface TPersonanaturalFormacionMapper {
    int countByExample(TPersonanaturalFormacionExample example);

    int deleteByExample(TPersonanaturalFormacionExample example);

    int deleteByPrimaryKey(TPersonanaturalFormacionKey key);

    int insert(TPersonanaturalFormacion record);

    int insertSelective(TPersonanaturalFormacion record);

    List<TPersonanaturalFormacion> selectByExample(TPersonanaturalFormacionExample example);

    TPersonanaturalFormacion selectByPrimaryKey(TPersonanaturalFormacionKey key);

    int updateByExampleSelective(@Param("record") TPersonanaturalFormacion record, @Param("example") TPersonanaturalFormacionExample example);

    int updateByExample(@Param("record") TPersonanaturalFormacion record, @Param("example") TPersonanaturalFormacionExample example);

    int updateByPrimaryKeySelective(TPersonanaturalFormacion record);

    int updateByPrimaryKey(TPersonanaturalFormacion record);
}