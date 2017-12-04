package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TEntidadBancaria;
import sernanp.app.dao.domain.TEntidadBancariaExample;
import sernanp.app.dao.domain.TEntidadBancariaKey;

public interface TEntidadBancariaMapper {
    int countByExample(TEntidadBancariaExample example);

    int deleteByExample(TEntidadBancariaExample example);

    int deleteByPrimaryKey(TEntidadBancariaKey key);

    int insert(TEntidadBancaria record);

    int insertSelective(TEntidadBancaria record);

    List<TEntidadBancaria> selectByExample(TEntidadBancariaExample example);

    TEntidadBancaria selectByPrimaryKey(TEntidadBancariaKey key);

    int updateByExampleSelective(@Param("record") TEntidadBancaria record, @Param("example") TEntidadBancariaExample example);

    int updateByExample(@Param("record") TEntidadBancaria record, @Param("example") TEntidadBancariaExample example);

    int updateByPrimaryKeySelective(TEntidadBancaria record);

    int updateByPrimaryKey(TEntidadBancaria record);
}