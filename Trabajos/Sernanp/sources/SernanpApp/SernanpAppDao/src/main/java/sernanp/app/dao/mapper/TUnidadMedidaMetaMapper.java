package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TUnidadMedidaMeta;
import sernanp.app.dao.domain.TUnidadMedidaMetaExample;
import sernanp.app.dao.domain.TUnidadMedidaMetaKey;

public interface TUnidadMedidaMetaMapper {
    int countByExample(TUnidadMedidaMetaExample example);

    int deleteByExample(TUnidadMedidaMetaExample example);

    int deleteByPrimaryKey(TUnidadMedidaMetaKey key);

    int insert(TUnidadMedidaMeta record);

    int insertSelective(TUnidadMedidaMeta record);

    List<TUnidadMedidaMeta> selectByExample(TUnidadMedidaMetaExample example);

    TUnidadMedidaMeta selectByPrimaryKey(TUnidadMedidaMetaKey key);

    int updateByExampleSelective(@Param("record") TUnidadMedidaMeta record, @Param("example") TUnidadMedidaMetaExample example);

    int updateByExample(@Param("record") TUnidadMedidaMeta record, @Param("example") TUnidadMedidaMetaExample example);

    int updateByPrimaryKeySelective(TUnidadMedidaMeta record);

    int updateByPrimaryKey(TUnidadMedidaMeta record);
}