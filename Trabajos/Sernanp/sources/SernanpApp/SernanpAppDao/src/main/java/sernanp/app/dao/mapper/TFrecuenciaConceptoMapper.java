package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TFrecuenciaConcepto;
import sernanp.app.dao.domain.TFrecuenciaConceptoExample;
import sernanp.app.dao.domain.TFrecuenciaConceptoKey;

public interface TFrecuenciaConceptoMapper {
    int countByExample(TFrecuenciaConceptoExample example);

    int deleteByExample(TFrecuenciaConceptoExample example);

    int deleteByPrimaryKey(TFrecuenciaConceptoKey key);

    int insert(TFrecuenciaConcepto record);

    int insertSelective(TFrecuenciaConcepto record);

    List<TFrecuenciaConcepto> selectByExample(TFrecuenciaConceptoExample example);

    TFrecuenciaConcepto selectByPrimaryKey(TFrecuenciaConceptoKey key);

    int updateByExampleSelective(@Param("record") TFrecuenciaConcepto record, @Param("example") TFrecuenciaConceptoExample example);

    int updateByExample(@Param("record") TFrecuenciaConcepto record, @Param("example") TFrecuenciaConceptoExample example);

    int updateByPrimaryKeySelective(TFrecuenciaConcepto record);

    int updateByPrimaryKey(TFrecuenciaConcepto record);
}