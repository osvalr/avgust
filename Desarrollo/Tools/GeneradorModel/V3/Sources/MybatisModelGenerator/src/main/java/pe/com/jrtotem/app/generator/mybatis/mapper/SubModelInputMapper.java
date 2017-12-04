package pe.com.jrtotem.app.generator.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInput;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInputKey;

public interface SubModelInputMapper {
    int countByExample(SubModelInputExample example);

    int deleteByExample(SubModelInputExample example);

    int deleteByPrimaryKey(SubModelInputKey key);

    int insert(SubModelInput record);

    int insertSelective(SubModelInput record);

    List<SubModelInput> selectByExample(SubModelInputExample example);

    SubModelInput selectByPrimaryKey(SubModelInputKey key);

    int updateByExampleSelective(@Param("record") SubModelInput record, @Param("example") SubModelInputExample example);

    int updateByExample(@Param("record") SubModelInput record, @Param("example") SubModelInputExample example);

    int updateByPrimaryKeySelective(SubModelInput record);

    int updateByPrimaryKey(SubModelInput record);
}