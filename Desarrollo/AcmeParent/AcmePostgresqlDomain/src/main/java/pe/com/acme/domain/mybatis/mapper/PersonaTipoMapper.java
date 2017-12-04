package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.PersonaTipo;
import pe.com.acme.domain.mybatis.model.PersonaTipoExample;
import pe.com.acme.domain.mybatis.model.PersonaTipoKey;

public interface PersonaTipoMapper {
    int countByExample(PersonaTipoExample example);

    int deleteByExample(PersonaTipoExample example);

    int deleteByPrimaryKey(PersonaTipoKey key);

    int insert(PersonaTipo record);

    int insertSelective(PersonaTipo record);

    List<PersonaTipo> selectByExampleWithRowbounds(PersonaTipoExample example, RowBounds rowBounds);

    List<PersonaTipo> selectByExample(PersonaTipoExample example);

    PersonaTipo selectByPrimaryKey(PersonaTipoKey key);

    int updateByExampleSelective(@Param("record") PersonaTipo record, @Param("example") PersonaTipoExample example);

    int updateByExample(@Param("record") PersonaTipo record, @Param("example") PersonaTipoExample example);

    int updateByPrimaryKeySelective(PersonaTipo record);

    int updateByPrimaryKey(PersonaTipo record);
}