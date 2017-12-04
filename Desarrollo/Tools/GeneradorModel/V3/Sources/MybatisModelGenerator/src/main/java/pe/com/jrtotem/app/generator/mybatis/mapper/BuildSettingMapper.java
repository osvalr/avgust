package pe.com.jrtotem.app.generator.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingExample;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingKey;

public interface BuildSettingMapper {
    int countByExample(BuildSettingExample example);

    int deleteByExample(BuildSettingExample example);

    int deleteByPrimaryKey(BuildSettingKey key);

    int insert(BuildSetting record);

    int insertSelective(BuildSetting record);

    List<BuildSetting> selectByExample(BuildSettingExample example);

    BuildSetting selectByPrimaryKey(BuildSettingKey key);

    int updateByExampleSelective(@Param("record") BuildSetting record, @Param("example") BuildSettingExample example);

    int updateByExample(@Param("record") BuildSetting record, @Param("example") BuildSettingExample example);

    int updateByPrimaryKeySelective(BuildSetting record);

    int updateByPrimaryKey(BuildSetting record);
}