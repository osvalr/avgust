package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Funcionalidad;
import pe.com.acme.domain.mybatis.model.FuncionalidadExample;
import pe.com.acme.domain.mybatis.model.FuncionalidadKey;

public interface FuncionalidadMapper {
    int countByExample(FuncionalidadExample example);

    int deleteByExample(FuncionalidadExample example);

    int deleteByPrimaryKey(FuncionalidadKey key);

    int insert(Funcionalidad record);

    int insertSelective(Funcionalidad record);

    List<Funcionalidad> selectByExampleWithRowbounds(FuncionalidadExample example, RowBounds rowBounds);

    List<Funcionalidad> selectByExample(FuncionalidadExample example);

    Funcionalidad selectByPrimaryKey(FuncionalidadKey key);

    int updateByExampleSelective(@Param("record") Funcionalidad record, @Param("example") FuncionalidadExample example);

    int updateByExample(@Param("record") Funcionalidad record, @Param("example") FuncionalidadExample example);

    int updateByPrimaryKeySelective(Funcionalidad record);

    int updateByPrimaryKey(Funcionalidad record);
}