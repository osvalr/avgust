package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgPersonal;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgPersonalExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgPersonalKey;

public interface TConvocatoriaAreaOrgPersonalMapper {
    int countByExample(TConvocatoriaAreaOrgPersonalExample example);

    int deleteByExample(TConvocatoriaAreaOrgPersonalExample example);

    int deleteByPrimaryKey(TConvocatoriaAreaOrgPersonalKey key);

    int insert(TConvocatoriaAreaOrgPersonal record);

    int insertSelective(TConvocatoriaAreaOrgPersonal record);

    List<TConvocatoriaAreaOrgPersonal> selectByExample(TConvocatoriaAreaOrgPersonalExample example);

    TConvocatoriaAreaOrgPersonal selectByPrimaryKey(TConvocatoriaAreaOrgPersonalKey key);

    int updateByExampleSelective(@Param("record") TConvocatoriaAreaOrgPersonal record, @Param("example") TConvocatoriaAreaOrgPersonalExample example);

    int updateByExample(@Param("record") TConvocatoriaAreaOrgPersonal record, @Param("example") TConvocatoriaAreaOrgPersonalExample example);

    int updateByPrimaryKeySelective(TConvocatoriaAreaOrgPersonal record);

    int updateByPrimaryKey(TConvocatoriaAreaOrgPersonal record);
}