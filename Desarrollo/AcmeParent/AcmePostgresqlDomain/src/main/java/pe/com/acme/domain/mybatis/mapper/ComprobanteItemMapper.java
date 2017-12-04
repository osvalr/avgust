package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.ComprobanteItem;
import pe.com.acme.domain.mybatis.model.ComprobanteItemExample;
import pe.com.acme.domain.mybatis.model.ComprobanteItemKey;

public interface ComprobanteItemMapper {
    long countByExample(ComprobanteItemExample example);

    int deleteByExample(ComprobanteItemExample example);

    int deleteByPrimaryKey(ComprobanteItemKey key);

    int insert(ComprobanteItem record);

    int insertSelective(ComprobanteItem record);

    List<ComprobanteItem> selectByExampleWithRowbounds(ComprobanteItemExample example, RowBounds rowBounds);

    List<ComprobanteItem> selectByExample(ComprobanteItemExample example);

    ComprobanteItem selectByPrimaryKey(ComprobanteItemKey key);

    int updateByExampleSelective(@Param("record") ComprobanteItem record, @Param("example") ComprobanteItemExample example);

    int updateByExample(@Param("record") ComprobanteItem record, @Param("example") ComprobanteItemExample example);

    int updateByPrimaryKeySelective(ComprobanteItem record);

    int updateByPrimaryKey(ComprobanteItem record);
}