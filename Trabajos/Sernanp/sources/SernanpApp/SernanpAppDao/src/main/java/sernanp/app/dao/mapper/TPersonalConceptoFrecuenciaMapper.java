package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPersonalConceptoFrecuencia;
import sernanp.app.dao.domain.TPersonalConceptoFrecuenciaExample;
import sernanp.app.dao.domain.TPersonalConceptoFrecuenciaKey;

public interface TPersonalConceptoFrecuenciaMapper {
    int countByExample(TPersonalConceptoFrecuenciaExample example);

    int deleteByExample(TPersonalConceptoFrecuenciaExample example);

    int deleteByPrimaryKey(TPersonalConceptoFrecuenciaKey key);

    int insert(TPersonalConceptoFrecuencia record);

    int insertSelective(TPersonalConceptoFrecuencia record);

    List<TPersonalConceptoFrecuencia> selectByExampleWithRowbounds(TPersonalConceptoFrecuenciaExample example, RowBounds rowBounds);

    List<TPersonalConceptoFrecuencia> selectByExample(TPersonalConceptoFrecuenciaExample example);

    TPersonalConceptoFrecuencia selectByPrimaryKey(TPersonalConceptoFrecuenciaKey key);

    int updateByExampleSelective(@Param("record") TPersonalConceptoFrecuencia record, @Param("example") TPersonalConceptoFrecuenciaExample example);

    int updateByExample(@Param("record") TPersonalConceptoFrecuencia record, @Param("example") TPersonalConceptoFrecuenciaExample example);

    int updateByPrimaryKeySelective(TPersonalConceptoFrecuencia record);

    int updateByPrimaryKey(TPersonalConceptoFrecuencia record);
}