package pe.com.jrtotem.app.generator.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionExample;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionKey;

public interface InfoDbConnectionMapper {
    int countByExample(InfoDbConnectionExample example);

    int deleteByExample(InfoDbConnectionExample example);

    int deleteByPrimaryKey(InfoDbConnectionKey key);

    int insert(InfoDbConnection record);

    int insertSelective(InfoDbConnection record);

    List<InfoDbConnection> selectByExample(InfoDbConnectionExample example);

    InfoDbConnection selectByPrimaryKey(InfoDbConnectionKey key);

    int updateByExampleSelective(@Param("record") InfoDbConnection record, @Param("example") InfoDbConnectionExample example);

    int updateByExample(@Param("record") InfoDbConnection record, @Param("example") InfoDbConnectionExample example);

    int updateByPrimaryKeySelective(InfoDbConnection record);

    int updateByPrimaryKey(InfoDbConnection record);
}