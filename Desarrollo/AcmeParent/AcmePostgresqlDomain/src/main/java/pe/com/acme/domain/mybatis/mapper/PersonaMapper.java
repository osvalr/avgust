package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Persona;
import pe.com.acme.domain.mybatis.model.PersonaExample;
import pe.com.acme.domain.mybatis.model.PersonaKey;

public interface PersonaMapper {
    int countByExample(PersonaExample example);

    int deleteByExample(PersonaExample example);

    int deleteByPrimaryKey(PersonaKey key);

    int insert(Persona record);

    int insertSelective(Persona record);

    List<Persona> selectByExampleWithRowbounds(PersonaExample example, RowBounds rowBounds);

    List<Persona> selectByExample(PersonaExample example);

    Persona selectByPrimaryKey(PersonaKey key);

    int updateByExampleSelective(@Param("record") Persona record, @Param("example") PersonaExample example);

    int updateByExample(@Param("record") Persona record, @Param("example") PersonaExample example);

    int updateByPrimaryKeySelective(Persona record);

    int updateByPrimaryKey(Persona record);
}