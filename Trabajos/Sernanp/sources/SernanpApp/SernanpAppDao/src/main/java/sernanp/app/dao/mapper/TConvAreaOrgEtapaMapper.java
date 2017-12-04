package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConvAreaOrgEtapa;
import sernanp.app.dao.domain.TConvAreaOrgEtapaExample;
import sernanp.app.dao.domain.TConvAreaOrgEtapaKey;

public interface TConvAreaOrgEtapaMapper {
    int countByExample(TConvAreaOrgEtapaExample example);

    int deleteByExample(TConvAreaOrgEtapaExample example);

    int deleteByPrimaryKey(TConvAreaOrgEtapaKey key);

    int insert(TConvAreaOrgEtapa record);

    int insertSelective(TConvAreaOrgEtapa record);

    List<TConvAreaOrgEtapa> selectByExample(TConvAreaOrgEtapaExample example);

    TConvAreaOrgEtapa selectByPrimaryKey(TConvAreaOrgEtapaKey key);

    int updateByExampleSelective(@Param("record") TConvAreaOrgEtapa record, @Param("example") TConvAreaOrgEtapaExample example);

    int updateByExample(@Param("record") TConvAreaOrgEtapa record, @Param("example") TConvAreaOrgEtapaExample example);

    int updateByPrimaryKeySelective(TConvAreaOrgEtapa record);

    int updateByPrimaryKey(TConvAreaOrgEtapa record);
}