package pe.com.acme.invoiceelec.model.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.invoiceelec.model.mybatis.domain.NcreDebElect;
import pe.com.acme.invoiceelec.model.mybatis.domain.NcreDebElectExample;
import pe.com.acme.invoiceelec.model.mybatis.domain.NcreDebElectKey;

public interface NcreDebElectMapper {
    int countByExample(NcreDebElectExample example);

    int deleteByExample(NcreDebElectExample example);

    int deleteByPrimaryKey(NcreDebElectKey key);

    int insert(NcreDebElect record);

    int insertSelective(NcreDebElect record);

    List<NcreDebElect> selectByExampleWithRowbounds(NcreDebElectExample example, RowBounds rowBounds);

    List<NcreDebElect> selectByExample(NcreDebElectExample example);

    NcreDebElect selectByPrimaryKey(NcreDebElectKey key);

    int updateByExampleSelective(@Param("record") NcreDebElect record, @Param("example") NcreDebElectExample example);

    int updateByExample(@Param("record") NcreDebElect record, @Param("example") NcreDebElectExample example);

    int updateByPrimaryKeySelective(NcreDebElect record);

    int updateByPrimaryKey(NcreDebElect record);
}