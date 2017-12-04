package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonal;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonalExample;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonalKey;

public interface TNominaAnioPeriodoPersonalMapper {
    int countByExample(TNominaAnioPeriodoPersonalExample example);

    int deleteByExample(TNominaAnioPeriodoPersonalExample example);

    int deleteByPrimaryKey(TNominaAnioPeriodoPersonalKey key);

    int insert(TNominaAnioPeriodoPersonal record);

    int insertSelective(TNominaAnioPeriodoPersonal record);

    List<TNominaAnioPeriodoPersonal> selectByExample(TNominaAnioPeriodoPersonalExample example);

    TNominaAnioPeriodoPersonal selectByPrimaryKey(TNominaAnioPeriodoPersonalKey key);

    int updateByExampleSelective(@Param("record") TNominaAnioPeriodoPersonal record, @Param("example") TNominaAnioPeriodoPersonalExample example);

    int updateByExample(@Param("record") TNominaAnioPeriodoPersonal record, @Param("example") TNominaAnioPeriodoPersonalExample example);

    int updateByPrimaryKeySelective(TNominaAnioPeriodoPersonal record);

    int updateByPrimaryKey(TNominaAnioPeriodoPersonal record);
}