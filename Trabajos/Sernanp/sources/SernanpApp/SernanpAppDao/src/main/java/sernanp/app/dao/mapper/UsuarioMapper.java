package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Usuario;
import sernanp.app.dao.domain.UsuarioExample;
import sernanp.app.dao.domain.UsuarioKey;

public interface UsuarioMapper {
    int countByExample(UsuarioExample example);

    int deleteByExample(UsuarioExample example);

    int deleteByPrimaryKey(UsuarioKey key);

    int insert(Usuario record);

    int insertSelective(Usuario record);

    List<Usuario> selectByExample(UsuarioExample example);

    Usuario selectByPrimaryKey(UsuarioKey key);

    int updateByExampleSelective(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    int updateByExample(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    int updateByPrimaryKeySelective(Usuario record);

    int updateByPrimaryKey(Usuario record);
}