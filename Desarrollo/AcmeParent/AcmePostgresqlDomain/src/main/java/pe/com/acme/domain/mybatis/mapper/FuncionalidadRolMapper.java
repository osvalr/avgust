package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.FuncionalidadRol;
import pe.com.acme.domain.mybatis.model.FuncionalidadRolExample;
import pe.com.acme.domain.mybatis.model.FuncionalidadRolKey;

public interface FuncionalidadRolMapper {
    int countByExample(FuncionalidadRolExample example);

    int deleteByExample(FuncionalidadRolExample example);

    int deleteByPrimaryKey(FuncionalidadRolKey key);

    int insert(FuncionalidadRol record);

    int insertSelective(FuncionalidadRol record);

    List<FuncionalidadRol> selectByExampleWithRowbounds(FuncionalidadRolExample example, RowBounds rowBounds);

    List<FuncionalidadRol> selectByExample(FuncionalidadRolExample example);

    FuncionalidadRol selectByPrimaryKey(FuncionalidadRolKey key);

    int updateByExampleSelective(@Param("record") FuncionalidadRol record, @Param("example") FuncionalidadRolExample example);

    int updateByExample(@Param("record") FuncionalidadRol record, @Param("example") FuncionalidadRolExample example);

    int updateByPrimaryKeySelective(FuncionalidadRol record);

    int updateByPrimaryKey(FuncionalidadRol record);
}