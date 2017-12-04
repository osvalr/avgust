package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Usuario;
import pe.com.acme.domain.mybatis.model.UsuarioExample;
import pe.com.acme.domain.mybatis.model.UsuarioKey;

public interface UsuarioMapper {
    int countByExample(UsuarioExample example);

    int deleteByExample(UsuarioExample example);

    int deleteByPrimaryKey(UsuarioKey key);

    int insert(Usuario record);

    int insertSelective(Usuario record);

    List<Usuario> selectByExampleWithRowbounds(UsuarioExample example, RowBounds rowBounds);

    List<Usuario> selectByExample(UsuarioExample example);

    Usuario selectByPrimaryKey(UsuarioKey key);

    int updateByExampleSelective(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    int updateByExample(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    int updateByPrimaryKeySelective(Usuario record);

    int updateByPrimaryKey(Usuario record);
}