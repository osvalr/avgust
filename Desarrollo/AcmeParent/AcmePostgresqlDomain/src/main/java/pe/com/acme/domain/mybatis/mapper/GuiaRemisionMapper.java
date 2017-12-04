package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.GuiaRemision;
import pe.com.acme.domain.mybatis.model.GuiaRemisionExample;
import pe.com.acme.domain.mybatis.model.GuiaRemisionKey;

public interface GuiaRemisionMapper {
    long countByExample(GuiaRemisionExample example);

    int deleteByExample(GuiaRemisionExample example);

    int deleteByPrimaryKey(GuiaRemisionKey key);

    int insert(GuiaRemision record);

    int insertSelective(GuiaRemision record);

    List<GuiaRemision> selectByExampleWithRowbounds(GuiaRemisionExample example, RowBounds rowBounds);

    List<GuiaRemision> selectByExample(GuiaRemisionExample example);

    GuiaRemision selectByPrimaryKey(GuiaRemisionKey key);

    int updateByExampleSelective(@Param("record") GuiaRemision record, @Param("example") GuiaRemisionExample example);

    int updateByExample(@Param("record") GuiaRemision record, @Param("example") GuiaRemisionExample example);

    int updateByPrimaryKeySelective(GuiaRemision record);

    int updateByPrimaryKey(GuiaRemision record);
}