package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Personanatural;
import sernanp.app.dao.domain.PersonanaturalExample;
import sernanp.app.dao.domain.PersonanaturalKey;

public interface PersonanaturalMapper {
    int countByExample(PersonanaturalExample example);

    int deleteByExample(PersonanaturalExample example);

    int deleteByPrimaryKey(PersonanaturalKey key);

    int insert(Personanatural record);

    int insertSelective(Personanatural record);

    List<Personanatural> selectByExample(PersonanaturalExample example);

    Personanatural selectByPrimaryKey(PersonanaturalKey key);

    int updateByExampleSelective(@Param("record") Personanatural record, @Param("example") PersonanaturalExample example);

    int updateByExample(@Param("record") Personanatural record, @Param("example") PersonanaturalExample example);

    int updateByPrimaryKeySelective(Personanatural record);

    int updateByPrimaryKey(Personanatural record);
}