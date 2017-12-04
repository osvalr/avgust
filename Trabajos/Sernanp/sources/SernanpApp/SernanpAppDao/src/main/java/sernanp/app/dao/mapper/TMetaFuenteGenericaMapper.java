package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TMetaFuenteGenerica;
import sernanp.app.dao.domain.TMetaFuenteGenericaExample;
import sernanp.app.dao.domain.TMetaFuenteGenericaKey;

public interface TMetaFuenteGenericaMapper {
    int countByExample(TMetaFuenteGenericaExample example);

    int deleteByExample(TMetaFuenteGenericaExample example);

    int deleteByPrimaryKey(TMetaFuenteGenericaKey key);

    int insert(TMetaFuenteGenerica record);

    int insertSelective(TMetaFuenteGenerica record);

    List<TMetaFuenteGenerica> selectByExampleWithRowbounds(TMetaFuenteGenericaExample example, RowBounds rowBounds);

    List<TMetaFuenteGenerica> selectByExample(TMetaFuenteGenericaExample example);

    TMetaFuenteGenerica selectByPrimaryKey(TMetaFuenteGenericaKey key);

    int updateByExampleSelective(@Param("record") TMetaFuenteGenerica record, @Param("example") TMetaFuenteGenericaExample example);

    int updateByExample(@Param("record") TMetaFuenteGenerica record, @Param("example") TMetaFuenteGenericaExample example);

    int updateByPrimaryKeySelective(TMetaFuenteGenerica record);

    int updateByPrimaryKey(TMetaFuenteGenerica record);
}