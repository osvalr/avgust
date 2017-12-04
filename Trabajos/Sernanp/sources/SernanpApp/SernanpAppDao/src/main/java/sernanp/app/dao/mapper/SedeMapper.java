package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Sede;
import sernanp.app.dao.domain.SedeExample;
import sernanp.app.dao.domain.SedeKey;

public interface SedeMapper {
    int countByExample(SedeExample example);

    int deleteByExample(SedeExample example);

    int deleteByPrimaryKey(SedeKey key);

    int insert(Sede record);

    int insertSelective(Sede record);

    List<Sede> selectByExample(SedeExample example);

    Sede selectByPrimaryKey(SedeKey key);

    int updateByExampleSelective(@Param("record") Sede record, @Param("example") SedeExample example);

    int updateByExample(@Param("record") Sede record, @Param("example") SedeExample example);

    int updateByPrimaryKeySelective(Sede record);

    int updateByPrimaryKey(Sede record);
}