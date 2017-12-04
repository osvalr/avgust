package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TGrupoOcupacional;
import sernanp.app.dao.domain.TGrupoOcupacionalExample;
import sernanp.app.dao.domain.TGrupoOcupacionalKey;

public interface TGrupoOcupacionalMapper {
    int countByExample(TGrupoOcupacionalExample example);

    int deleteByExample(TGrupoOcupacionalExample example);

    int deleteByPrimaryKey(TGrupoOcupacionalKey key);

    int insert(TGrupoOcupacional record);

    int insertSelective(TGrupoOcupacional record);

    List<TGrupoOcupacional> selectByExample(TGrupoOcupacionalExample example);

    TGrupoOcupacional selectByPrimaryKey(TGrupoOcupacionalKey key);

    int updateByExampleSelective(@Param("record") TGrupoOcupacional record, @Param("example") TGrupoOcupacionalExample example);

    int updateByExample(@Param("record") TGrupoOcupacional record, @Param("example") TGrupoOcupacionalExample example);

    int updateByPrimaryKeySelective(TGrupoOcupacional record);

    int updateByPrimaryKey(TGrupoOcupacional record);
}