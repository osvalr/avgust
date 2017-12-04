package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.UsuarioRol;
import pe.com.acme.domain.mybatis.model.UsuarioRolExample;
import pe.com.acme.domain.mybatis.model.UsuarioRolKey;

public interface UsuarioRolMapper {
    int countByExample(UsuarioRolExample example);

    int deleteByExample(UsuarioRolExample example);

    int deleteByPrimaryKey(UsuarioRolKey key);

    int insert(UsuarioRol record);

    int insertSelective(UsuarioRol record);

    List<UsuarioRol> selectByExampleWithRowbounds(UsuarioRolExample example, RowBounds rowBounds);

    List<UsuarioRol> selectByExample(UsuarioRolExample example);

    UsuarioRol selectByPrimaryKey(UsuarioRolKey key);

    int updateByExampleSelective(@Param("record") UsuarioRol record, @Param("example") UsuarioRolExample example);

    int updateByExample(@Param("record") UsuarioRol record, @Param("example") UsuarioRolExample example);

    int updateByPrimaryKeySelective(UsuarioRol record);

    int updateByPrimaryKey(UsuarioRol record);
}