package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TFrecuencia;
import sernanp.app.dao.domain.TFrecuenciaExample;
import sernanp.app.dao.domain.TFrecuenciaKey;

public interface TFrecuenciaMapper {
    int countByExample(TFrecuenciaExample example);

    int deleteByExample(TFrecuenciaExample example);

    int deleteByPrimaryKey(TFrecuenciaKey key);

    int insert(TFrecuencia record);

    int insertSelective(TFrecuencia record);

    List<TFrecuencia> selectByExample(TFrecuenciaExample example);

    TFrecuencia selectByPrimaryKey(TFrecuenciaKey key);

    int updateByExampleSelective(@Param("record") TFrecuencia record, @Param("example") TFrecuenciaExample example);

    int updateByExample(@Param("record") TFrecuencia record, @Param("example") TFrecuenciaExample example);

    int updateByPrimaryKeySelective(TFrecuencia record);

    int updateByPrimaryKey(TFrecuencia record);
}