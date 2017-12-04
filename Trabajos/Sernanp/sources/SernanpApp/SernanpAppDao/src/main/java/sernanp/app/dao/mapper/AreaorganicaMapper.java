package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Areaorganica;
import sernanp.app.dao.domain.AreaorganicaExample;
import sernanp.app.dao.domain.AreaorganicaKey;

public interface AreaorganicaMapper {
    int countByExample(AreaorganicaExample example);

    int deleteByExample(AreaorganicaExample example);

    int deleteByPrimaryKey(AreaorganicaKey key);

    int insert(Areaorganica record);

    int insertSelective(Areaorganica record);

    List<Areaorganica> selectByExample(AreaorganicaExample example);

    Areaorganica selectByPrimaryKey(AreaorganicaKey key);

    int updateByExampleSelective(@Param("record") Areaorganica record, @Param("example") AreaorganicaExample example);

    int updateByExample(@Param("record") Areaorganica record, @Param("example") AreaorganicaExample example);

    int updateByPrimaryKeySelective(Areaorganica record);

    int updateByPrimaryKey(Areaorganica record);
}