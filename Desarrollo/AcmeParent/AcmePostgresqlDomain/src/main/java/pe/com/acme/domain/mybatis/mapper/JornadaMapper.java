package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Jornada;
import pe.com.acme.domain.mybatis.model.JornadaExample;
import pe.com.acme.domain.mybatis.model.JornadaKey;

public interface JornadaMapper {
    int countByExample(JornadaExample example);

    int deleteByExample(JornadaExample example);

    int deleteByPrimaryKey(JornadaKey key);

    int insert(Jornada record);

    int insertSelective(Jornada record);

    List<Jornada> selectByExampleWithRowbounds(JornadaExample example, RowBounds rowBounds);

    List<Jornada> selectByExample(JornadaExample example);

    Jornada selectByPrimaryKey(JornadaKey key);

    int updateByExampleSelective(@Param("record") Jornada record, @Param("example") JornadaExample example);

    int updateByExample(@Param("record") Jornada record, @Param("example") JornadaExample example);

    int updateByPrimaryKeySelective(Jornada record);

    int updateByPrimaryKey(Jornada record);
}