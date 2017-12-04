package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalContratoExample;
import sernanp.app.dao.domain.TPersonalContratoKey;

public interface TPersonalContratoMapper {
    int countByExample(TPersonalContratoExample example);

    int deleteByExample(TPersonalContratoExample example);

    int deleteByPrimaryKey(TPersonalContratoKey key);

    int insert(TPersonalContrato record);

    int insertSelective(TPersonalContrato record);

    List<TPersonalContrato> selectByExample(TPersonalContratoExample example);

    TPersonalContrato selectByPrimaryKey(TPersonalContratoKey key);

    int updateByExampleSelective(@Param("record") TPersonalContrato record, @Param("example") TPersonalContratoExample example);

    int updateByExample(@Param("record") TPersonalContrato record, @Param("example") TPersonalContratoExample example);

    int updateByPrimaryKeySelective(TPersonalContrato record);

    int updateByPrimaryKey(TPersonalContrato record);
}