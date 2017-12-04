package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Persona;
import sernanp.app.dao.domain.PersonaExample;
import sernanp.app.dao.domain.PersonaKey;

public interface PersonaMapper {
    int countByExample(PersonaExample example);

    int deleteByExample(PersonaExample example);

    int deleteByPrimaryKey(PersonaKey key);

    int insert(Persona record);

    int insertSelective(Persona record);

    List<Persona> selectByExample(PersonaExample example);

    Persona selectByPrimaryKey(PersonaKey key);

    int updateByExampleSelective(@Param("record") Persona record, @Param("example") PersonaExample example);

    int updateByExample(@Param("record") Persona record, @Param("example") PersonaExample example);

    int updateByPrimaryKeySelective(Persona record);

    int updateByPrimaryKey(Persona record);
}