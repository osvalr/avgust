package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TAfectoConcepto;
import sernanp.app.dao.domain.TAfectoConceptoExample;
import sernanp.app.dao.domain.TAfectoConceptoKey;

public interface TAfectoConceptoMapper {
    int countByExample(TAfectoConceptoExample example);

    int deleteByExample(TAfectoConceptoExample example);

    int deleteByPrimaryKey(TAfectoConceptoKey key);

    int insert(TAfectoConcepto record);

    int insertSelective(TAfectoConcepto record);

    List<TAfectoConcepto> selectByExample(TAfectoConceptoExample example);

    TAfectoConcepto selectByPrimaryKey(TAfectoConceptoKey key);

    int updateByExampleSelective(@Param("record") TAfectoConcepto record, @Param("example") TAfectoConceptoExample example);

    int updateByExample(@Param("record") TAfectoConcepto record, @Param("example") TAfectoConceptoExample example);

    int updateByPrimaryKeySelective(TAfectoConcepto record);

    int updateByPrimaryKey(TAfectoConcepto record);
}