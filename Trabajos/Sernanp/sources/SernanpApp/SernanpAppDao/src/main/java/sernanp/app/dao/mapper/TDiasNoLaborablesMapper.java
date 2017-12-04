package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TDiasNoLaborables;
import sernanp.app.dao.domain.TDiasNoLaborablesExample;
import sernanp.app.dao.domain.TDiasNoLaborablesKey;

public interface TDiasNoLaborablesMapper {
    int countByExample(TDiasNoLaborablesExample example);

    int deleteByExample(TDiasNoLaborablesExample example);

    int deleteByPrimaryKey(TDiasNoLaborablesKey key);

    int insert(TDiasNoLaborables record);

    int insertSelective(TDiasNoLaborables record);

    List<TDiasNoLaborables> selectByExample(TDiasNoLaborablesExample example);

    TDiasNoLaborables selectByPrimaryKey(TDiasNoLaborablesKey key);

    int updateByExampleSelective(@Param("record") TDiasNoLaborables record, @Param("example") TDiasNoLaborablesExample example);

    int updateByExample(@Param("record") TDiasNoLaborables record, @Param("example") TDiasNoLaborablesExample example);

    int updateByPrimaryKeySelective(TDiasNoLaborables record);

    int updateByPrimaryKey(TDiasNoLaborables record);
}