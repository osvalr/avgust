package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAfp;
import sernanp.app.dao.domain.TAfpExample;
import sernanp.app.dao.domain.TAfpKey;

public interface TAfpMapper {
    int countByExample(TAfpExample example);

    int deleteByExample(TAfpExample example);

    int deleteByPrimaryKey(TAfpKey key);

    int insert(TAfp record);

    int insertSelective(TAfp record);

    List<TAfp> selectByExample(TAfpExample example);

    TAfp selectByPrimaryKey(TAfpKey key);

    int updateByExampleSelective(@Param("record") TAfp record, @Param("example") TAfpExample example);

    int updateByExample(@Param("record") TAfp record, @Param("example") TAfpExample example);

    int updateByPrimaryKeySelective(TAfp record);

    int updateByPrimaryKey(TAfp record);
}