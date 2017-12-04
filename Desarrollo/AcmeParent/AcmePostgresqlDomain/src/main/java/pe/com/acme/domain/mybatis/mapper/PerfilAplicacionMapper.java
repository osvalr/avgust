package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.PerfilAplicacion;
import pe.com.acme.domain.mybatis.model.PerfilAplicacionExample;
import pe.com.acme.domain.mybatis.model.PerfilAplicacionKey;

public interface PerfilAplicacionMapper {
    int countByExample(PerfilAplicacionExample example);

    int deleteByExample(PerfilAplicacionExample example);

    int deleteByPrimaryKey(PerfilAplicacionKey key);

    int insert(PerfilAplicacion record);

    int insertSelective(PerfilAplicacion record);

    List<PerfilAplicacion> selectByExampleWithRowbounds(PerfilAplicacionExample example, RowBounds rowBounds);

    List<PerfilAplicacion> selectByExample(PerfilAplicacionExample example);

    PerfilAplicacion selectByPrimaryKey(PerfilAplicacionKey key);

    int updateByExampleSelective(@Param("record") PerfilAplicacion record, @Param("example") PerfilAplicacionExample example);

    int updateByExample(@Param("record") PerfilAplicacion record, @Param("example") PerfilAplicacionExample example);

    int updateByPrimaryKeySelective(PerfilAplicacion record);

    int updateByPrimaryKey(PerfilAplicacion record);
}