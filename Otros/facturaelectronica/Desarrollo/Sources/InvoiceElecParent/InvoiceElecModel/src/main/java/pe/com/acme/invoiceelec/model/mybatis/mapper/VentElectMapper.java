package pe.com.acme.invoiceelec.model.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElect;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElectExample;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElectKey;

public interface VentElectMapper {
    int countByExample(VentElectExample example);

    int deleteByExample(VentElectExample example);

    int deleteByPrimaryKey(VentElectKey key);

    int insert(VentElect record);

    int insertSelective(VentElect record);

    List<VentElect> selectByExampleWithRowbounds(VentElectExample example, RowBounds rowBounds);

    List<VentElect> selectByExample(VentElectExample example);

    VentElect selectByPrimaryKey(VentElectKey key);

    int updateByExampleSelective(@Param("record") VentElect record, @Param("example") VentElectExample example);

    int updateByExample(@Param("record") VentElect record, @Param("example") VentElectExample example);

    int updateByPrimaryKeySelective(VentElect record);

    int updateByPrimaryKey(VentElect record);
}