package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.ResetHistorico;
import pe.com.acme.domain.mybatis.model.ResetHistoricoExample;
import pe.com.acme.domain.mybatis.model.ResetHistoricoKey;

public interface ResetHistoricoMapper {
    int countByExample(ResetHistoricoExample example);

    int deleteByExample(ResetHistoricoExample example);

    int deleteByPrimaryKey(ResetHistoricoKey key);

    int insert(ResetHistorico record);

    int insertSelective(ResetHistorico record);

    List<ResetHistorico> selectByExampleWithRowbounds(ResetHistoricoExample example, RowBounds rowBounds);

    List<ResetHistorico> selectByExample(ResetHistoricoExample example);

    ResetHistorico selectByPrimaryKey(ResetHistoricoKey key);

    int updateByExampleSelective(@Param("record") ResetHistorico record, @Param("example") ResetHistoricoExample example);

    int updateByExample(@Param("record") ResetHistorico record, @Param("example") ResetHistoricoExample example);

    int updateByPrimaryKeySelective(ResetHistorico record);

    int updateByPrimaryKey(ResetHistorico record);
}