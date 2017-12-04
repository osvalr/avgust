package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonalConcepto;
import sernanp.app.dao.domain.TPersonalConceptoExample;
import sernanp.app.dao.domain.TPersonalConceptoKey;

public interface TPersonalConceptoMapper {
    int countByExample(TPersonalConceptoExample example);

    int deleteByExample(TPersonalConceptoExample example);

    int deleteByPrimaryKey(TPersonalConceptoKey key);

    int insert(TPersonalConcepto record);

    int insertSelective(TPersonalConcepto record);

    List<TPersonalConcepto> selectByExample(TPersonalConceptoExample example);

    TPersonalConcepto selectByPrimaryKey(TPersonalConceptoKey key);

    int updateByExampleSelective(@Param("record") TPersonalConcepto record, @Param("example") TPersonalConceptoExample example);

    int updateByExample(@Param("record") TPersonalConcepto record, @Param("example") TPersonalConceptoExample example);

    int updateByPrimaryKeySelective(TPersonalConcepto record);

    int updateByPrimaryKey(TPersonalConcepto record);
}