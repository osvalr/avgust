package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonaNaturalLegajo;
import sernanp.app.dao.domain.TPersonaNaturalLegajoExample;
import sernanp.app.dao.domain.TPersonaNaturalLegajoKey;

public interface TPersonaNaturalLegajoMapper {
    int countByExample(TPersonaNaturalLegajoExample example);

    int deleteByExample(TPersonaNaturalLegajoExample example);

    int deleteByPrimaryKey(TPersonaNaturalLegajoKey key);

    int insert(TPersonaNaturalLegajo record);

    int insertSelective(TPersonaNaturalLegajo record);

    List<TPersonaNaturalLegajo> selectByExample(TPersonaNaturalLegajoExample example);

    TPersonaNaturalLegajo selectByPrimaryKey(TPersonaNaturalLegajoKey key);

    int updateByExampleSelective(@Param("record") TPersonaNaturalLegajo record, @Param("example") TPersonaNaturalLegajoExample example);

    int updateByExample(@Param("record") TPersonaNaturalLegajo record, @Param("example") TPersonaNaturalLegajoExample example);

    int updateByPrimaryKeySelective(TPersonaNaturalLegajo record);

    int updateByPrimaryKey(TPersonaNaturalLegajo record);
}