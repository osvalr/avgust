package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.ComprobantePago;
import pe.com.acme.domain.mybatis.model.ComprobantePagoExample;
import pe.com.acme.domain.mybatis.model.ComprobantePagoKey;

public interface ComprobantePagoMapper {
    long countByExample(ComprobantePagoExample example);

    int deleteByExample(ComprobantePagoExample example);

    int deleteByPrimaryKey(ComprobantePagoKey key);

    int insert(ComprobantePago record);

    int insertSelective(ComprobantePago record);

    List<ComprobantePago> selectByExampleWithRowbounds(ComprobantePagoExample example, RowBounds rowBounds);

    List<ComprobantePago> selectByExample(ComprobantePagoExample example);

    ComprobantePago selectByPrimaryKey(ComprobantePagoKey key);

    int updateByExampleSelective(@Param("record") ComprobantePago record, @Param("example") ComprobantePagoExample example);

    int updateByExample(@Param("record") ComprobantePago record, @Param("example") ComprobantePagoExample example);

    int updateByPrimaryKeySelective(ComprobantePago record);

    int updateByPrimaryKey(ComprobantePago record);
}