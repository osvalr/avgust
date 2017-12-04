package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPersonalDescuentoTmp;
import sernanp.app.dao.domain.TPersonalDescuentoTmpExample;
import sernanp.app.dao.domain.TPersonalDescuentoTmpKey;

public interface TPersonalDescuentoTmpMapper {
    int countByExample(TPersonalDescuentoTmpExample example);

    int deleteByExample(TPersonalDescuentoTmpExample example);

    int deleteByPrimaryKey(TPersonalDescuentoTmpKey key);

    int insert(TPersonalDescuentoTmp record);

    int insertSelective(TPersonalDescuentoTmp record);

    List<TPersonalDescuentoTmp> selectByExampleWithRowbounds(TPersonalDescuentoTmpExample example, RowBounds rowBounds);

    List<TPersonalDescuentoTmp> selectByExample(TPersonalDescuentoTmpExample example);

    TPersonalDescuentoTmp selectByPrimaryKey(TPersonalDescuentoTmpKey key);

    int updateByExampleSelective(@Param("record") TPersonalDescuentoTmp record, @Param("example") TPersonalDescuentoTmpExample example);

    int updateByExample(@Param("record") TPersonalDescuentoTmp record, @Param("example") TPersonalDescuentoTmpExample example);

    int updateByPrimaryKeySelective(TPersonalDescuentoTmp record);

    int updateByPrimaryKey(TPersonalDescuentoTmp record);
}