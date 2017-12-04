package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.CuentaAmortizacion;
import pe.com.acme.domain.mybatis.model.CuentaAmortizacionExample;
import pe.com.acme.domain.mybatis.model.CuentaAmortizacionKey;

public interface CuentaAmortizacionMapper {
    int countByExample(CuentaAmortizacionExample example);

    int deleteByExample(CuentaAmortizacionExample example);

    int deleteByPrimaryKey(CuentaAmortizacionKey key);

    int insert(CuentaAmortizacion record);

    int insertSelective(CuentaAmortizacion record);

    List<CuentaAmortizacion> selectByExampleWithRowbounds(CuentaAmortizacionExample example, RowBounds rowBounds);

    List<CuentaAmortizacion> selectByExample(CuentaAmortizacionExample example);

    CuentaAmortizacion selectByPrimaryKey(CuentaAmortizacionKey key);

    int updateByExampleSelective(@Param("record") CuentaAmortizacion record, @Param("example") CuentaAmortizacionExample example);

    int updateByExample(@Param("record") CuentaAmortizacion record, @Param("example") CuentaAmortizacionExample example);

    int updateByPrimaryKeySelective(CuentaAmortizacion record);

    int updateByPrimaryKey(CuentaAmortizacion record);
}