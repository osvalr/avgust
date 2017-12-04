package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPostulanteCapacitacion;
import sernanp.app.dao.domain.TPostulanteCapacitacionExample;
import sernanp.app.dao.domain.TPostulanteCapacitacionKey;

public interface TPostulanteCapacitacionMapper {
    int countByExample(TPostulanteCapacitacionExample example);

    int deleteByExample(TPostulanteCapacitacionExample example);

    int deleteByPrimaryKey(TPostulanteCapacitacionKey key);

    int insert(TPostulanteCapacitacion record);

    int insertSelective(TPostulanteCapacitacion record);

    List<TPostulanteCapacitacion> selectByExample(TPostulanteCapacitacionExample example);

    TPostulanteCapacitacion selectByPrimaryKey(TPostulanteCapacitacionKey key);

    int updateByExampleSelective(@Param("record") TPostulanteCapacitacion record, @Param("example") TPostulanteCapacitacionExample example);

    int updateByExample(@Param("record") TPostulanteCapacitacion record, @Param("example") TPostulanteCapacitacionExample example);

    int updateByPrimaryKeySelective(TPostulanteCapacitacion record);

    int updateByPrimaryKey(TPostulanteCapacitacion record);
}