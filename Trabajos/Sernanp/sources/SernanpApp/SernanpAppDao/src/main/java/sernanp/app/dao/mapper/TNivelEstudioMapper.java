package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TNivelEstudio;
import sernanp.app.dao.domain.TNivelEstudioExample;
import sernanp.app.dao.domain.TNivelEstudioKey;

public interface TNivelEstudioMapper {
    int countByExample(TNivelEstudioExample example);

    int deleteByExample(TNivelEstudioExample example);

    int deleteByPrimaryKey(TNivelEstudioKey key);

    int insert(TNivelEstudio record);

    int insertSelective(TNivelEstudio record);

    List<TNivelEstudio> selectByExample(TNivelEstudioExample example);

    TNivelEstudio selectByPrimaryKey(TNivelEstudioKey key);

    int updateByExampleSelective(@Param("record") TNivelEstudio record, @Param("example") TNivelEstudioExample example);

    int updateByExample(@Param("record") TNivelEstudio record, @Param("example") TNivelEstudioExample example);

    int updateByPrimaryKeySelective(TNivelEstudio record);

    int updateByPrimaryKey(TNivelEstudio record);
}