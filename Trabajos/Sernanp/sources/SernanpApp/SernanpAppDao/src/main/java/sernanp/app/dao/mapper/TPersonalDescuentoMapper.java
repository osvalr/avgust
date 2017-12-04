package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonalDescuento;
import sernanp.app.dao.domain.TPersonalDescuentoExample;
import sernanp.app.dao.domain.TPersonalDescuentoKey;

public interface TPersonalDescuentoMapper {
    int countByExample(TPersonalDescuentoExample example);

    int deleteByExample(TPersonalDescuentoExample example);

    int deleteByPrimaryKey(TPersonalDescuentoKey key);

    int insert(TPersonalDescuento record);

    int insertSelective(TPersonalDescuento record);

    List<TPersonalDescuento> selectByExample(TPersonalDescuentoExample example);

    TPersonalDescuento selectByPrimaryKey(TPersonalDescuentoKey key);

    int updateByExampleSelective(@Param("record") TPersonalDescuento record, @Param("example") TPersonalDescuentoExample example);

    int updateByExample(@Param("record") TPersonalDescuento record, @Param("example") TPersonalDescuentoExample example);

    int updateByPrimaryKeySelective(TPersonalDescuento record);

    int updateByPrimaryKey(TPersonalDescuento record);
}