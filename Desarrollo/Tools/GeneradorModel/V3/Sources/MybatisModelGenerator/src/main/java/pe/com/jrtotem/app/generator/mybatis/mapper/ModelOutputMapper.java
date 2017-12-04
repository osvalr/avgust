package pe.com.jrtotem.app.generator.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelOutput;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelOutputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelOutputKey;

public interface ModelOutputMapper {
    int countByExample(ModelOutputExample example);

    int deleteByExample(ModelOutputExample example);

    int deleteByPrimaryKey(ModelOutputKey key);

    int insert(ModelOutput record);

    int insertSelective(ModelOutput record);

    List<ModelOutput> selectByExample(ModelOutputExample example);

    ModelOutput selectByPrimaryKey(ModelOutputKey key);

    int updateByExampleSelective(@Param("record") ModelOutput record, @Param("example") ModelOutputExample example);

    int updateByExample(@Param("record") ModelOutput record, @Param("example") ModelOutputExample example);

    int updateByPrimaryKeySelective(ModelOutput record);

    int updateByPrimaryKey(ModelOutput record);
}