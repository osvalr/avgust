package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TNumeroTelefono;
import sernanp.app.dao.domain.TNumeroTelefonoExample;
import sernanp.app.dao.domain.TNumeroTelefonoKey;

public interface TNumeroTelefonoMapper {
    int countByExample(TNumeroTelefonoExample example);

    int deleteByExample(TNumeroTelefonoExample example);

    int deleteByPrimaryKey(TNumeroTelefonoKey key);

    int insert(TNumeroTelefono record);

    int insertSelective(TNumeroTelefono record);

    List<TNumeroTelefono> selectByExample(TNumeroTelefonoExample example);

    TNumeroTelefono selectByPrimaryKey(TNumeroTelefonoKey key);

    int updateByExampleSelective(@Param("record") TNumeroTelefono record, @Param("example") TNumeroTelefonoExample example);

    int updateByExample(@Param("record") TNumeroTelefono record, @Param("example") TNumeroTelefonoExample example);

    int updateByPrimaryKeySelective(TNumeroTelefono record);

    int updateByPrimaryKey(TNumeroTelefono record);
}