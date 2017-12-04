package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonalConceptoAfecto;
import sernanp.app.dao.domain.TPersonalConceptoAfectoExample;
import sernanp.app.dao.domain.TPersonalConceptoAfectoKey;

public interface TPersonalConceptoAfectoMapper {
    int countByExample(TPersonalConceptoAfectoExample example);

    int deleteByExample(TPersonalConceptoAfectoExample example);

    int deleteByPrimaryKey(TPersonalConceptoAfectoKey key);

    int insert(TPersonalConceptoAfecto record);

    int insertSelective(TPersonalConceptoAfecto record);

    List<TPersonalConceptoAfecto> selectByExample(TPersonalConceptoAfectoExample example);

    TPersonalConceptoAfecto selectByPrimaryKey(TPersonalConceptoAfectoKey key);

    int updateByExampleSelective(@Param("record") TPersonalConceptoAfecto record, @Param("example") TPersonalConceptoAfectoExample example);

    int updateByExample(@Param("record") TPersonalConceptoAfecto record, @Param("example") TPersonalConceptoAfectoExample example);

    int updateByPrimaryKeySelective(TPersonalConceptoAfecto record);

    int updateByPrimaryKey(TPersonalConceptoAfecto record);
}