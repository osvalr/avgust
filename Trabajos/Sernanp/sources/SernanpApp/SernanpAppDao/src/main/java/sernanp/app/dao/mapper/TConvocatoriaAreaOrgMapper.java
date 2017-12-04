package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgKey;

public interface TConvocatoriaAreaOrgMapper {
    int countByExample(TConvocatoriaAreaOrgExample example);

    int deleteByExample(TConvocatoriaAreaOrgExample example);

    int deleteByPrimaryKey(TConvocatoriaAreaOrgKey key);

    int insert(TConvocatoriaAreaOrg record);

    int insertSelective(TConvocatoriaAreaOrg record);

    List<TConvocatoriaAreaOrg> selectByExample(TConvocatoriaAreaOrgExample example);

    TConvocatoriaAreaOrg selectByPrimaryKey(TConvocatoriaAreaOrgKey key);

    int updateByExampleSelective(@Param("record") TConvocatoriaAreaOrg record, @Param("example") TConvocatoriaAreaOrgExample example);

    int updateByExample(@Param("record") TConvocatoriaAreaOrg record, @Param("example") TConvocatoriaAreaOrgExample example);

    int updateByPrimaryKeySelective(TConvocatoriaAreaOrg record);

    int updateByPrimaryKey(TConvocatoriaAreaOrg record);
}