package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPersonalVacaciones;
import sernanp.app.dao.domain.TPersonalVacacionesExample;
import sernanp.app.dao.domain.TPersonalVacacionesKey;

public interface TPersonalVacacionesMapper {
    int countByExample(TPersonalVacacionesExample example);

    int deleteByExample(TPersonalVacacionesExample example);

    int deleteByPrimaryKey(TPersonalVacacionesKey key);

    int insert(TPersonalVacaciones record);

    int insertSelective(TPersonalVacaciones record);

    List<TPersonalVacaciones> selectByExampleWithRowbounds(TPersonalVacacionesExample example, RowBounds rowBounds);

    List<TPersonalVacaciones> selectByExample(TPersonalVacacionesExample example);

    TPersonalVacaciones selectByPrimaryKey(TPersonalVacacionesKey key);

    int updateByExampleSelective(@Param("record") TPersonalVacaciones record, @Param("example") TPersonalVacacionesExample example);

    int updateByExample(@Param("record") TPersonalVacaciones record, @Param("example") TPersonalVacacionesExample example);

    int updateByPrimaryKeySelective(TPersonalVacaciones record);

    int updateByPrimaryKey(TPersonalVacaciones record);
}