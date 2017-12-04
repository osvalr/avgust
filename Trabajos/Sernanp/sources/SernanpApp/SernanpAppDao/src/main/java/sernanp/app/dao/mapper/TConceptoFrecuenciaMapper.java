package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TConceptoFrecuencia;
import sernanp.app.dao.domain.TConceptoFrecuenciaExample;
import sernanp.app.dao.domain.TConceptoFrecuenciaKey;

public interface TConceptoFrecuenciaMapper {
    int countByExample(TConceptoFrecuenciaExample example);

    int deleteByExample(TConceptoFrecuenciaExample example);

    int deleteByPrimaryKey(TConceptoFrecuenciaKey key);

    int insert(TConceptoFrecuencia record);

    int insertSelective(TConceptoFrecuencia record);

    List<TConceptoFrecuencia> selectByExampleWithRowbounds(TConceptoFrecuenciaExample example, RowBounds rowBounds);

    List<TConceptoFrecuencia> selectByExample(TConceptoFrecuenciaExample example);

    TConceptoFrecuencia selectByPrimaryKey(TConceptoFrecuenciaKey key);

    int updateByExampleSelective(@Param("record") TConceptoFrecuencia record, @Param("example") TConceptoFrecuenciaExample example);

    int updateByExample(@Param("record") TConceptoFrecuencia record, @Param("example") TConceptoFrecuenciaExample example);

    int updateByPrimaryKeySelective(TConceptoFrecuencia record);

    int updateByPrimaryKey(TConceptoFrecuencia record);
}