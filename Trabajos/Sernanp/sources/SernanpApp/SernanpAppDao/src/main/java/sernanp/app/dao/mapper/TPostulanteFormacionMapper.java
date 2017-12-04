package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPostulanteFormacion;
import sernanp.app.dao.domain.TPostulanteFormacionExample;
import sernanp.app.dao.domain.TPostulanteFormacionKey;

public interface TPostulanteFormacionMapper {
    int countByExample(TPostulanteFormacionExample example);

    int deleteByExample(TPostulanteFormacionExample example);

    int deleteByPrimaryKey(TPostulanteFormacionKey key);

    int insert(TPostulanteFormacion record);

    int insertSelective(TPostulanteFormacion record);

    List<TPostulanteFormacion> selectByExample(TPostulanteFormacionExample example);

    TPostulanteFormacion selectByPrimaryKey(TPostulanteFormacionKey key);

    int updateByExampleSelective(@Param("record") TPostulanteFormacion record, @Param("example") TPostulanteFormacionExample example);

    int updateByExample(@Param("record") TPostulanteFormacion record, @Param("example") TPostulanteFormacionExample example);

    int updateByPrimaryKeySelective(TPostulanteFormacion record);

    int updateByPrimaryKey(TPostulanteFormacion record);
}