package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TSecuenciaNumero;
import sernanp.app.dao.domain.TSecuenciaNumeroExample;
import sernanp.app.dao.domain.TSecuenciaNumeroKey;

public interface TSecuenciaNumeroMapper {
    int countByExample(TSecuenciaNumeroExample example);

    int deleteByExample(TSecuenciaNumeroExample example);

    int deleteByPrimaryKey(TSecuenciaNumeroKey key);

    int insert(TSecuenciaNumero record);

    int insertSelective(TSecuenciaNumero record);

    List<TSecuenciaNumero> selectByExample(TSecuenciaNumeroExample example);

    TSecuenciaNumero selectByPrimaryKey(TSecuenciaNumeroKey key);

    int updateByExampleSelective(@Param("record") TSecuenciaNumero record, @Param("example") TSecuenciaNumeroExample example);

    int updateByExample(@Param("record") TSecuenciaNumero record, @Param("example") TSecuenciaNumeroExample example);

    int updateByPrimaryKeySelective(TSecuenciaNumero record);

    int updateByPrimaryKey(TSecuenciaNumero record);
}