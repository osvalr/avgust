package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.CuentaXCobrar;
import pe.com.acme.domain.mybatis.model.CuentaXCobrarExample;
import pe.com.acme.domain.mybatis.model.CuentaXCobrarKey;

public interface CuentaXCobrarMapper {
    long countByExample(CuentaXCobrarExample example);

    int deleteByExample(CuentaXCobrarExample example);

    int deleteByPrimaryKey(CuentaXCobrarKey key);

    int insert(CuentaXCobrar record);

    int insertSelective(CuentaXCobrar record);

    List<CuentaXCobrar> selectByExampleWithRowbounds(CuentaXCobrarExample example, RowBounds rowBounds);

    List<CuentaXCobrar> selectByExample(CuentaXCobrarExample example);

    CuentaXCobrar selectByPrimaryKey(CuentaXCobrarKey key);

    int updateByExampleSelective(@Param("record") CuentaXCobrar record, @Param("example") CuentaXCobrarExample example);

    int updateByExample(@Param("record") CuentaXCobrar record, @Param("example") CuentaXCobrarExample example);

    int updateByPrimaryKeySelective(CuentaXCobrar record);

    int updateByPrimaryKey(CuentaXCobrar record);
}