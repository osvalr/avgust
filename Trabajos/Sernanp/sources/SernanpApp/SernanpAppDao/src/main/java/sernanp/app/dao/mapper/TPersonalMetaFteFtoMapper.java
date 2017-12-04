package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPersonalMetaFteFto;
import sernanp.app.dao.domain.TPersonalMetaFteFtoExample;

public interface TPersonalMetaFteFtoMapper {
    int countByExample(TPersonalMetaFteFtoExample example);

    int deleteByExample(TPersonalMetaFteFtoExample example);

    int insert(TPersonalMetaFteFto record);

    int insertSelective(TPersonalMetaFteFto record);

    List<TPersonalMetaFteFto> selectByExampleWithRowbounds(TPersonalMetaFteFtoExample example, RowBounds rowBounds);

    List<TPersonalMetaFteFto> selectByExample(TPersonalMetaFteFtoExample example);

    int updateByExampleSelective(@Param("record") TPersonalMetaFteFto record, @Param("example") TPersonalMetaFteFtoExample example);

    int updateByExample(@Param("record") TPersonalMetaFteFto record, @Param("example") TPersonalMetaFteFtoExample example);
}