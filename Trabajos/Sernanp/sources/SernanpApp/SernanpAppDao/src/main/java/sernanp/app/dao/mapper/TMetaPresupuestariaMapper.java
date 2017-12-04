package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TMetaPresupuestaria;
import sernanp.app.dao.domain.TMetaPresupuestariaExample;
import sernanp.app.dao.domain.TMetaPresupuestariaKey;

public interface TMetaPresupuestariaMapper {
    int countByExample(TMetaPresupuestariaExample example);

    int deleteByExample(TMetaPresupuestariaExample example);

    int deleteByPrimaryKey(TMetaPresupuestariaKey key);

    int insert(TMetaPresupuestaria record);

    int insertSelective(TMetaPresupuestaria record);

    List<TMetaPresupuestaria> selectByExampleWithRowbounds(TMetaPresupuestariaExample example, RowBounds rowBounds);

    List<TMetaPresupuestaria> selectByExample(TMetaPresupuestariaExample example);

    TMetaPresupuestaria selectByPrimaryKey(TMetaPresupuestariaKey key);

    int updateByExampleSelective(@Param("record") TMetaPresupuestaria record, @Param("example") TMetaPresupuestariaExample example);

    int updateByExample(@Param("record") TMetaPresupuestaria record, @Param("example") TMetaPresupuestariaExample example);

    int updateByPrimaryKeySelective(TMetaPresupuestaria record);

    int updateByPrimaryKey(TMetaPresupuestaria record);
}