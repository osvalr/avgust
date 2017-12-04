package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TCargo;
import sernanp.app.dao.domain.TCargoExample;
import sernanp.app.dao.domain.TCargoKey;

public interface TCargoMapper {
    int countByExample(TCargoExample example);

    int deleteByExample(TCargoExample example);

    int deleteByPrimaryKey(TCargoKey key);

    int insert(TCargo record);

    int insertSelective(TCargo record);

    List<TCargo> selectByExample(TCargoExample example);

    TCargo selectByPrimaryKey(TCargoKey key);

    int updateByExampleSelective(@Param("record") TCargo record, @Param("example") TCargoExample example);

    int updateByExample(@Param("record") TCargo record, @Param("example") TCargoExample example);

    int updateByPrimaryKeySelective(TCargo record);

    int updateByPrimaryKey(TCargo record);
}