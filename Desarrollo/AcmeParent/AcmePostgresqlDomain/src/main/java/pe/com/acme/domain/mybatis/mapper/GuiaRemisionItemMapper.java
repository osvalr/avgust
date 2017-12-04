package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.GuiaRemisionItem;
import pe.com.acme.domain.mybatis.model.GuiaRemisionItemExample;
import pe.com.acme.domain.mybatis.model.GuiaRemisionItemKey;

public interface GuiaRemisionItemMapper {
    long countByExample(GuiaRemisionItemExample example);

    int deleteByExample(GuiaRemisionItemExample example);

    int deleteByPrimaryKey(GuiaRemisionItemKey key);

    int insert(GuiaRemisionItem record);

    int insertSelective(GuiaRemisionItem record);

    List<GuiaRemisionItem> selectByExampleWithRowbounds(GuiaRemisionItemExample example, RowBounds rowBounds);

    List<GuiaRemisionItem> selectByExample(GuiaRemisionItemExample example);

    GuiaRemisionItem selectByPrimaryKey(GuiaRemisionItemKey key);

    int updateByExampleSelective(@Param("record") GuiaRemisionItem record, @Param("example") GuiaRemisionItemExample example);

    int updateByExample(@Param("record") GuiaRemisionItem record, @Param("example") GuiaRemisionItemExample example);

    int updateByPrimaryKeySelective(GuiaRemisionItem record);

    int updateByPrimaryKey(GuiaRemisionItem record);
}