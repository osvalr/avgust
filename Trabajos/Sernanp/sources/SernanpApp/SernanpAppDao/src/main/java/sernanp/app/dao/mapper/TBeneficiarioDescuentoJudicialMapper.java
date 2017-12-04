package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TBeneficiarioDescuentoJudicial;
import sernanp.app.dao.domain.TBeneficiarioDescuentoJudicialExample;
import sernanp.app.dao.domain.TBeneficiarioDescuentoJudicialKey;

public interface TBeneficiarioDescuentoJudicialMapper {
    int countByExample(TBeneficiarioDescuentoJudicialExample example);

    int deleteByExample(TBeneficiarioDescuentoJudicialExample example);

    int deleteByPrimaryKey(TBeneficiarioDescuentoJudicialKey key);

    int insert(TBeneficiarioDescuentoJudicial record);

    int insertSelective(TBeneficiarioDescuentoJudicial record);

    List<TBeneficiarioDescuentoJudicial> selectByExample(TBeneficiarioDescuentoJudicialExample example);

    TBeneficiarioDescuentoJudicial selectByPrimaryKey(TBeneficiarioDescuentoJudicialKey key);

    int updateByExampleSelective(@Param("record") TBeneficiarioDescuentoJudicial record, @Param("example") TBeneficiarioDescuentoJudicialExample example);

    int updateByExample(@Param("record") TBeneficiarioDescuentoJudicial record, @Param("example") TBeneficiarioDescuentoJudicialExample example);

    int updateByPrimaryKeySelective(TBeneficiarioDescuentoJudicial record);

    int updateByPrimaryKey(TBeneficiarioDescuentoJudicial record);
}