package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.LogInHistorico;
import pe.com.acme.domain.mybatis.model.LogInHistoricoExample;
import pe.com.acme.domain.mybatis.model.LogInHistoricoKey;

public interface LogInHistoricoMapper {
    int countByExample(LogInHistoricoExample example);

    int deleteByExample(LogInHistoricoExample example);

    int deleteByPrimaryKey(LogInHistoricoKey key);

    int insert(LogInHistorico record);

    int insertSelective(LogInHistorico record);

    List<LogInHistorico> selectByExampleWithRowbounds(LogInHistoricoExample example, RowBounds rowBounds);

    List<LogInHistorico> selectByExample(LogInHistoricoExample example);

    LogInHistorico selectByPrimaryKey(LogInHistoricoKey key);

    int updateByExampleSelective(@Param("record") LogInHistorico record, @Param("example") LogInHistoricoExample example);

    int updateByExample(@Param("record") LogInHistorico record, @Param("example") LogInHistoricoExample example);

    int updateByPrimaryKeySelective(LogInHistorico record);

    int updateByPrimaryKey(LogInHistorico record);
}