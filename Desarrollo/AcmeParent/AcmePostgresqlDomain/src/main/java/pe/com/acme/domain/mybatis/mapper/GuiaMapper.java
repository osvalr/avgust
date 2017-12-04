package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Guia;
import pe.com.acme.domain.mybatis.model.GuiaExample;
import pe.com.acme.domain.mybatis.model.GuiaKey;

public interface GuiaMapper {
    int countByExample(GuiaExample example);

    int deleteByExample(GuiaExample example);

    int deleteByPrimaryKey(GuiaKey key);

    int insert(Guia record);

    int insertSelective(Guia record);

    List<Guia> selectByExampleWithRowbounds(GuiaExample example, RowBounds rowBounds);

    List<Guia> selectByExample(GuiaExample example);

    Guia selectByPrimaryKey(GuiaKey key);

    int updateByExampleSelective(@Param("record") Guia record, @Param("example") GuiaExample example);

    int updateByExample(@Param("record") Guia record, @Param("example") GuiaExample example);

    int updateByPrimaryKeySelective(Guia record);

    int updateByPrimaryKey(Guia record);
}