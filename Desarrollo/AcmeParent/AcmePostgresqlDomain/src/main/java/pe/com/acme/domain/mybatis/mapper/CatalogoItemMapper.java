package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.CatalogoItem;
import pe.com.acme.domain.mybatis.model.CatalogoItemExample;
import pe.com.acme.domain.mybatis.model.CatalogoItemKey;

public interface CatalogoItemMapper {
    int countByExample(CatalogoItemExample example);

    int deleteByExample(CatalogoItemExample example);

    int deleteByPrimaryKey(CatalogoItemKey key);

    int insert(CatalogoItem record);

    int insertSelective(CatalogoItem record);

    List<CatalogoItem> selectByExampleWithRowbounds(CatalogoItemExample example, RowBounds rowBounds);

    List<CatalogoItem> selectByExample(CatalogoItemExample example);

    CatalogoItem selectByPrimaryKey(CatalogoItemKey key);

    int updateByExampleSelective(@Param("record") CatalogoItem record, @Param("example") CatalogoItemExample example);

    int updateByExample(@Param("record") CatalogoItem record, @Param("example") CatalogoItemExample example);

    int updateByPrimaryKeySelective(CatalogoItem record);

    int updateByPrimaryKey(CatalogoItem record);
}