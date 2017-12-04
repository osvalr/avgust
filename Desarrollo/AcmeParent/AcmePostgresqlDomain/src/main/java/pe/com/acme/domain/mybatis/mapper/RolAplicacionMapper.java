package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.RolAplicacion;
import pe.com.acme.domain.mybatis.model.RolAplicacionExample;
import pe.com.acme.domain.mybatis.model.RolAplicacionKey;

public interface RolAplicacionMapper {
    int countByExample(RolAplicacionExample example);

    int deleteByExample(RolAplicacionExample example);

    int deleteByPrimaryKey(RolAplicacionKey key);

    int insert(RolAplicacion record);

    int insertSelective(RolAplicacion record);

    List<RolAplicacion> selectByExampleWithRowbounds(RolAplicacionExample example, RowBounds rowBounds);

    List<RolAplicacion> selectByExample(RolAplicacionExample example);

    RolAplicacion selectByPrimaryKey(RolAplicacionKey key);

    int updateByExampleSelective(@Param("record") RolAplicacion record, @Param("example") RolAplicacionExample example);

    int updateByExample(@Param("record") RolAplicacion record, @Param("example") RolAplicacionExample example);

    int updateByPrimaryKeySelective(RolAplicacion record);

    int updateByPrimaryKey(RolAplicacion record);
}