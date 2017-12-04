package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TExpedientePersonal;
import sernanp.app.dao.domain.TExpedientePersonalExample;
import sernanp.app.dao.domain.TExpedientePersonalKey;

public interface TExpedientePersonalMapper {
    int countByExample(TExpedientePersonalExample example);

    int deleteByExample(TExpedientePersonalExample example);

    int deleteByPrimaryKey(TExpedientePersonalKey key);

    int insert(TExpedientePersonal record);

    int insertSelective(TExpedientePersonal record);

    List<TExpedientePersonal> selectByExample(TExpedientePersonalExample example);

    TExpedientePersonal selectByPrimaryKey(TExpedientePersonalKey key);

    int updateByExampleSelective(@Param("record") TExpedientePersonal record, @Param("example") TExpedientePersonalExample example);

    int updateByExample(@Param("record") TExpedientePersonal record, @Param("example") TExpedientePersonalExample example);

    int updateByPrimaryKeySelective(TExpedientePersonal record);

    int updateByPrimaryKey(TExpedientePersonal record);
}