package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TConvocatoria;
import sernanp.app.dao.domain.TConvocatoriaExample;
import sernanp.app.dao.domain.TConvocatoriaKey;

public interface TConvocatoriaMapper {
    int countByExample(TConvocatoriaExample example);

    int deleteByExample(TConvocatoriaExample example);

    int deleteByPrimaryKey(TConvocatoriaKey key);

    int insert(TConvocatoria record);

    int insertSelective(TConvocatoria record);

    List<TConvocatoria> selectByExampleWithRowbounds(TConvocatoriaExample example, RowBounds rowBounds);

    List<TConvocatoria> selectByExample(TConvocatoriaExample example);

    TConvocatoria selectByPrimaryKey(TConvocatoriaKey key);

    int updateByExampleSelective(@Param("record") TConvocatoria record, @Param("example") TConvocatoriaExample example);

    int updateByExample(@Param("record") TConvocatoria record, @Param("example") TConvocatoriaExample example);

    int updateByPrimaryKeySelective(TConvocatoria record);

    int updateByPrimaryKey(TConvocatoria record);
}