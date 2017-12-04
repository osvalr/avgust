package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.UsuarioPerfil;
import pe.com.acme.domain.mybatis.model.UsuarioPerfilExample;
import pe.com.acme.domain.mybatis.model.UsuarioPerfilKey;

public interface UsuarioPerfilMapper {
    int countByExample(UsuarioPerfilExample example);

    int deleteByExample(UsuarioPerfilExample example);

    int deleteByPrimaryKey(UsuarioPerfilKey key);

    int insert(UsuarioPerfil record);

    int insertSelective(UsuarioPerfil record);

    List<UsuarioPerfil> selectByExampleWithRowbounds(UsuarioPerfilExample example, RowBounds rowBounds);

    List<UsuarioPerfil> selectByExample(UsuarioPerfilExample example);

    UsuarioPerfil selectByPrimaryKey(UsuarioPerfilKey key);

    int updateByExampleSelective(@Param("record") UsuarioPerfil record, @Param("example") UsuarioPerfilExample example);

    int updateByExample(@Param("record") UsuarioPerfil record, @Param("example") UsuarioPerfilExample example);

    int updateByPrimaryKeySelective(UsuarioPerfil record);

    int updateByPrimaryKey(UsuarioPerfil record);
}