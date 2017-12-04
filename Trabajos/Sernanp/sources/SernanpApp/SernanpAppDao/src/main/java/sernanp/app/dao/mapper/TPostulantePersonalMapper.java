package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPostulantePersonal;
import sernanp.app.dao.domain.TPostulantePersonalExample;
import sernanp.app.dao.domain.TPostulantePersonalKey;

public interface TPostulantePersonalMapper {
    int countByExample(TPostulantePersonalExample example);

    int deleteByExample(TPostulantePersonalExample example);

    int deleteByPrimaryKey(TPostulantePersonalKey key);

    int insert(TPostulantePersonal record);

    int insertSelective(TPostulantePersonal record);

    List<TPostulantePersonal> selectByExampleWithRowbounds(TPostulantePersonalExample example, RowBounds rowBounds);

    List<TPostulantePersonal> selectByExample(TPostulantePersonalExample example);

    TPostulantePersonal selectByPrimaryKey(TPostulantePersonalKey key);

    int updateByExampleSelective(@Param("record") TPostulantePersonal record, @Param("example") TPostulantePersonalExample example);

    int updateByExample(@Param("record") TPostulantePersonal record, @Param("example") TPostulantePersonalExample example);

    int updateByPrimaryKeySelective(TPostulantePersonal record);

    int updateByPrimaryKey(TPostulantePersonal record);
}