package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonalEntidadBancaria;
import sernanp.app.dao.domain.TPersonalEntidadBancariaExample;
import sernanp.app.dao.domain.TPersonalEntidadBancariaKey;

public interface TPersonalEntidadBancariaMapper {
    int countByExample(TPersonalEntidadBancariaExample example);

    int deleteByExample(TPersonalEntidadBancariaExample example);

    int deleteByPrimaryKey(TPersonalEntidadBancariaKey key);

    int insert(TPersonalEntidadBancaria record);

    int insertSelective(TPersonalEntidadBancaria record);

    List<TPersonalEntidadBancaria> selectByExample(TPersonalEntidadBancariaExample example);

    TPersonalEntidadBancaria selectByPrimaryKey(TPersonalEntidadBancariaKey key);

    int updateByExampleSelective(@Param("record") TPersonalEntidadBancaria record, @Param("example") TPersonalEntidadBancariaExample example);

    int updateByExample(@Param("record") TPersonalEntidadBancaria record, @Param("example") TPersonalEntidadBancariaExample example);

    int updateByPrimaryKeySelective(TPersonalEntidadBancaria record);

    int updateByPrimaryKey(TPersonalEntidadBancaria record);
}