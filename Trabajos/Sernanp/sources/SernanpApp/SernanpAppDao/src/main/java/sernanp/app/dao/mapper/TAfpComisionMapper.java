package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAfpComision;
import sernanp.app.dao.domain.TAfpComisionExample;
import sernanp.app.dao.domain.TAfpComisionKey;

public interface TAfpComisionMapper {
    int countByExample(TAfpComisionExample example);

    int deleteByExample(TAfpComisionExample example);

    int deleteByPrimaryKey(TAfpComisionKey key);

    int insert(TAfpComision record);

    int insertSelective(TAfpComision record);

    List<TAfpComision> selectByExample(TAfpComisionExample example);

    TAfpComision selectByPrimaryKey(TAfpComisionKey key);

    int updateByExampleSelective(@Param("record") TAfpComision record, @Param("example") TAfpComisionExample example);

    int updateByExample(@Param("record") TAfpComision record, @Param("example") TAfpComisionExample example);

    int updateByPrimaryKeySelective(TAfpComision record);

    int updateByPrimaryKey(TAfpComision record);
}