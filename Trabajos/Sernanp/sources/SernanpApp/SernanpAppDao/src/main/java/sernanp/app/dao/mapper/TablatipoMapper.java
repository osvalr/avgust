package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Tablatipo;
import sernanp.app.dao.domain.TablatipoExample;
import sernanp.app.dao.domain.TablatipoKey;

public interface TablatipoMapper {
    int countByExample(TablatipoExample example);

    int deleteByExample(TablatipoExample example);

    int deleteByPrimaryKey(TablatipoKey key);

    int insert(Tablatipo record);

    int insertSelective(Tablatipo record);

    List<Tablatipo> selectByExample(TablatipoExample example);

    Tablatipo selectByPrimaryKey(TablatipoKey key);

    int updateByExampleSelective(@Param("record") Tablatipo record, @Param("example") TablatipoExample example);

    int updateByExample(@Param("record") Tablatipo record, @Param("example") TablatipoExample example);

    int updateByPrimaryKeySelective(Tablatipo record);

    int updateByPrimaryKey(Tablatipo record);
}