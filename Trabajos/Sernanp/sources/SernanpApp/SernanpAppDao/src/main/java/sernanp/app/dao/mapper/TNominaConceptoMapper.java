package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TNominaConcepto;
import sernanp.app.dao.domain.TNominaConceptoExample;
import sernanp.app.dao.domain.TNominaConceptoKey;

public interface TNominaConceptoMapper {
    int countByExample(TNominaConceptoExample example);

    int deleteByExample(TNominaConceptoExample example);

    int deleteByPrimaryKey(TNominaConceptoKey key);

    int insert(TNominaConcepto record);

    int insertSelective(TNominaConcepto record);

    List<TNominaConcepto> selectByExampleWithRowbounds(TNominaConceptoExample example, RowBounds rowBounds);

    List<TNominaConcepto> selectByExample(TNominaConceptoExample example);

    TNominaConcepto selectByPrimaryKey(TNominaConceptoKey key);

    int updateByExampleSelective(@Param("record") TNominaConcepto record, @Param("example") TNominaConceptoExample example);

    int updateByExample(@Param("record") TNominaConcepto record, @Param("example") TNominaConceptoExample example);

    int updateByPrimaryKeySelective(TNominaConcepto record);

    int updateByPrimaryKey(TNominaConcepto record);
}
