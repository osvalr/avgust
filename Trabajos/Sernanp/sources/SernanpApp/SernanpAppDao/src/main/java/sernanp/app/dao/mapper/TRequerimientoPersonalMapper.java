package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TRequerimientoPersonal;
import sernanp.app.dao.domain.TRequerimientoPersonalExample;
import sernanp.app.dao.domain.TRequerimientoPersonalKey;

public interface TRequerimientoPersonalMapper {
    int countByExample(TRequerimientoPersonalExample example);

    int deleteByExample(TRequerimientoPersonalExample example);

    int deleteByPrimaryKey(TRequerimientoPersonalKey key);

    int insert(TRequerimientoPersonal record);

    int insertSelective(TRequerimientoPersonal record);

    List<TRequerimientoPersonal> selectByExample(TRequerimientoPersonalExample example);

    TRequerimientoPersonal selectByPrimaryKey(TRequerimientoPersonalKey key);

    int updateByExampleSelective(@Param("record") TRequerimientoPersonal record, @Param("example") TRequerimientoPersonalExample example);

    int updateByExample(@Param("record") TRequerimientoPersonal record, @Param("example") TRequerimientoPersonalExample example);

    int updateByPrimaryKeySelective(TRequerimientoPersonal record);

    int updateByPrimaryKey(TRequerimientoPersonal record);
}