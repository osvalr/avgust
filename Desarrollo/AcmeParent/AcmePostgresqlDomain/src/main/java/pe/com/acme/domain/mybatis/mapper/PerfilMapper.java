package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Perfil;
import pe.com.acme.domain.mybatis.model.PerfilExample;
import pe.com.acme.domain.mybatis.model.PerfilKey;

public interface PerfilMapper {
    int countByExample(PerfilExample example);

    int deleteByExample(PerfilExample example);

    int deleteByPrimaryKey(PerfilKey key);

    int insert(Perfil record);

    int insertSelective(Perfil record);

    List<Perfil> selectByExampleWithRowbounds(PerfilExample example, RowBounds rowBounds);

    List<Perfil> selectByExample(PerfilExample example);

    Perfil selectByPrimaryKey(PerfilKey key);

    int updateByExampleSelective(@Param("record") Perfil record, @Param("example") PerfilExample example);

    int updateByExample(@Param("record") Perfil record, @Param("example") PerfilExample example);

    int updateByPrimaryKeySelective(Perfil record);

    int updateByPrimaryKey(Perfil record);
}