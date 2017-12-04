package pe.com.jrtotem.app.generator.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInput;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputKey;

public interface ModelInputMapper {
    int countByExample(ModelInputExample example);

    int deleteByExample(ModelInputExample example);

    int deleteByPrimaryKey(ModelInputKey key);

    int insert(ModelInput record);

    int insertSelective(ModelInput record);

    List<ModelInput> selectByExample(ModelInputExample example);

    ModelInput selectByPrimaryKey(ModelInputKey key);

    int updateByExampleSelective(@Param("record") ModelInput record, @Param("example") ModelInputExample example);

    int updateByExample(@Param("record") ModelInput record, @Param("example") ModelInputExample example);

    int updateByPrimaryKeySelective(ModelInput record);

    int updateByPrimaryKey(ModelInput record);
}