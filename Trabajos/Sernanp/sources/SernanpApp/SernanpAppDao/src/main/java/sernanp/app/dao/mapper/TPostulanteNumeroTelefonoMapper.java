package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPostulanteNumeroTelefono;
import sernanp.app.dao.domain.TPostulanteNumeroTelefonoExample;
import sernanp.app.dao.domain.TPostulanteNumeroTelefonoKey;

public interface TPostulanteNumeroTelefonoMapper {
    int countByExample(TPostulanteNumeroTelefonoExample example);

    int deleteByExample(TPostulanteNumeroTelefonoExample example);

    int deleteByPrimaryKey(TPostulanteNumeroTelefonoKey key);

    int insert(TPostulanteNumeroTelefono record);

    int insertSelective(TPostulanteNumeroTelefono record);

    List<TPostulanteNumeroTelefono> selectByExample(TPostulanteNumeroTelefonoExample example);

    TPostulanteNumeroTelefono selectByPrimaryKey(TPostulanteNumeroTelefonoKey key);

    int updateByExampleSelective(@Param("record") TPostulanteNumeroTelefono record, @Param("example") TPostulanteNumeroTelefonoExample example);

    int updateByExample(@Param("record") TPostulanteNumeroTelefono record, @Param("example") TPostulanteNumeroTelefonoExample example);

    int updateByPrimaryKeySelective(TPostulanteNumeroTelefono record);

    int updateByPrimaryKey(TPostulanteNumeroTelefono record);
}