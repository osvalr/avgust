package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAnioMeta;
import sernanp.app.dao.domain.TAnioMetaExample;
import sernanp.app.dao.domain.TAnioMetaKey;

public interface TAnioMetaMapper {
    int countByExample(TAnioMetaExample example);

    int deleteByExample(TAnioMetaExample example);

    int deleteByPrimaryKey(TAnioMetaKey key);

    int insert(TAnioMeta record);

    int insertSelective(TAnioMeta record);

    List<TAnioMeta> selectByExample(TAnioMetaExample example);

    TAnioMeta selectByPrimaryKey(TAnioMetaKey key);

    int updateByExampleSelective(@Param("record") TAnioMeta record, @Param("example") TAnioMetaExample example);

    int updateByExample(@Param("record") TAnioMeta record, @Param("example") TAnioMetaExample example);

    int updateByPrimaryKeySelective(TAnioMeta record);

    int updateByPrimaryKey(TAnioMeta record);
}