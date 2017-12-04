package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.PersonalExample;
import sernanp.app.dao.domain.PersonalKey;

public interface PersonalMapper {
    int countByExample(PersonalExample example);

    int deleteByExample(PersonalExample example);

    int deleteByPrimaryKey(PersonalKey key);

    int insert(Personal record);

    int insertSelective(Personal record);

    List<Personal> selectByExample(PersonalExample example);

    Personal selectByPrimaryKey(PersonalKey key);

    int updateByExampleSelective(@Param("record") Personal record, @Param("example") PersonalExample example);

    int updateByExample(@Param("record") Personal record, @Param("example") PersonalExample example);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);
}