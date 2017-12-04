package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TGenericaGasto;
import sernanp.app.dao.domain.TGenericaGastoExample;
import sernanp.app.dao.domain.TGenericaGastoKey;

public interface TGenericaGastoMapper {
    int countByExample(TGenericaGastoExample example);

    int deleteByExample(TGenericaGastoExample example);

    int deleteByPrimaryKey(TGenericaGastoKey key);

    int insert(TGenericaGasto record);

    int insertSelective(TGenericaGasto record);

    List<TGenericaGasto> selectByExampleWithRowbounds(TGenericaGastoExample example, RowBounds rowBounds);

    List<TGenericaGasto> selectByExample(TGenericaGastoExample example);

    TGenericaGasto selectByPrimaryKey(TGenericaGastoKey key);

    int updateByExampleSelective(@Param("record") TGenericaGasto record, @Param("example") TGenericaGastoExample example);

    int updateByExample(@Param("record") TGenericaGasto record, @Param("example") TGenericaGastoExample example);

    int updateByPrimaryKeySelective(TGenericaGasto record);

    int updateByPrimaryKey(TGenericaGasto record);
}